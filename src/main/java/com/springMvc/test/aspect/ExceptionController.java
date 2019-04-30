package com.springMvc.test.aspect;

import com.springMvc.test.api.ResObj;
import com.springMvc.test.config.SystemConfig;
import com.springMvc.test.util.DESUtil;
import com.springMvc.test.util.DateUtil;
import com.springMvc.test.util.JsonParse;
import com.springMvc.test.util.ValidatedException;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2019/3/27.
 */

@RestController
@ControllerAdvice
@Slf4j
public class ExceptionController {
    /*@Autowired
    private MailServer mailServer;*/

    @ExceptionHandler(MultipartException.class)
    public String fileError(MultipartException e,HttpServletRequest req) throws Exception{
        //捕获服务器文件大小超出的异常
        if(e.getMessage().indexOf("FileSizeLimitExceededException")>-1){
            if(req.getRequestURI().indexOf("impReport/uploadImage.htm")>-1){
                //处理文本编辑器上传的文件
                Map<String,Object> map= new HashMap<String,Object>();
                map.put("error", 1);
                map.put("message", "上传文件大小不能超过20M");
                return JsonParse.obj2json(map);
            }else{
                //处理普通文件上传
                return JsonParse.obj2json(new ResObj("ERROR", "上传文件大小不能超过20M"));
            }
        }
        return JsonParse.obj2json(new ResObj("ERROR", "文件上传异常"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object controllerExceptionHandler(HttpServletRequest req, Exception e) {

        if(e instanceof ValidatedException){
            return new ResObj("ValidatedException",e.getMessage());
        }
        String ip  = getClientIP(req);
        //log.error("拦截到异常---ip:{},url:{},",ip,req.getRequestURL());
        Map<String,Object> map = getParams(req);
        //log.error("参数:{}",map);
        Cookie[] cookies = req.getCookies();
        String str = "";
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(SystemConfig.USER_INFO.equals(cookie.getName())){
                    str = cookie.getValue();
                    try {
                        str = DESUtil.decodeValue(SystemConfig.DESKEY,str);
                    } catch (Exception e1) {
                    }
                    break;
                }
            }
        }
        //log.error("异常信息",e);
        //非开发环境才有发短信的功能
        if(!SystemConfig.RUM_TIME){
            try {
                @Cleanup ByteArrayOutputStream buf= new ByteArrayOutputStream();
                e.printStackTrace(new java.io.PrintWriter(buf, true));
                StringBuffer buffer = new StringBuffer(6000);
                buffer.append("用户信息:"+str+"\r\n");
                buffer.append("ip:"+ip+"\r\n");
                buffer.append("url:"+req.getRequestURL()+"\r\n");
                buffer.append("参数:"+JsonParse.ObjToJson(map)+"\r\n");
                buffer.append("服务器时间:"+ DateUtil.formatDateTime(new Date())+"\r\n");
                buffer.append("异常信息:"+buf.toString()+"\r\n");
                String expMessage = buffer.toString();
                //mailServer.sendJavaDeveloper(expMessage,"CRM程序异常");
            }catch (Exception e1){
                //log.error("",e1);
            }
        }
        return new ResObj("ERROR", StringUtils.isEmpty(e.getMessage())?"空指针异常":e.getMessage());
    }


    /***
     * 获取客户端IP地址;这里通过了Nginx获取;X-Real-IP,
     * @param request
     * @return
     */
    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private Map<String,Object> getParams(HttpServletRequest request) {
        Map<String,Object> map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return  map;
    }

}
