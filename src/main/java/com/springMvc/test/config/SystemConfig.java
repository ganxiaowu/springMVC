package com.springMvc.test.config;

/**
 * 说明:系统配置类
 * 时间:2016/12/19 13:40
 * 作者:曾立明
 * 版本:v1.0
 */
public class SystemConfig {
    /**
     *系统运行环境，默认为本机运行
     */
    public static String DEV  = "localhost";
    public static String URL  = "";
    /**
     * 系统代号
     */
    public static String S_SYSTEM = "";
    /**
     *是否为本机环境或者开发环境运行
     */
    public static boolean RUM_TIME;
    /**
     * 成功标志
     */
    public static final String SUCCESS_CODE="S00";
    /**
     * 用户信息参数
     */
    public static final String USER_INFO = "crmUser";
    public static final String USER_NO = "USER_NO";

    public static  String DESKEY = "#crm.32m0h1k6j`crm";//加密秘钥   JAVA本身的加密
    //用户相关的redis key
    public static  String CLIENT_KEY = "e64rbd57"; //客户端加密key

    public static final String REDIS_USER = "COM:MINGHANG:CRM:USERSINFO:%s:USER";
    public static final String REDIS_MENU = "COM:MINGHANG:CRM:USERSINFO:%s:MENU";
    public static final String REDIS_OPKEY = "COM:MINGHANG:CRM:USERSINFO:%s:OPKEY";
    public static final String REDIS_LOGINNUM = "COM:MINGHANG:CRM:USERSINFO:%s:LOGINNUM";
    public static final String TOKEN = "COM:MINGHANG:CRM:USERSINFO:%s:TOKEN";
    public static final String AESKEY = "COM:MINGHANG:CRM:USERSINFO:%s:AESKEY";

    public static final String PAYURLKEY="COM:MINGHANG:CRM:ALIPAY:%s";
    
    //用户具有的菜单访问地址权限
    public static final String MENU_SET = "COM:MINGHANG:CRM:MENU_SET:";
    public static final String WS = "COM:MINGHANG:CRM:WS:";
    //个人中心验证码
    public static final String REDIS_PERSONALCENTER_SECURITYPHONE = "COM:MINGHANG:CRM:%s:SECURITYPHONE";
    public static final String REDIS_PERSONALCENTER_SECURITYEMAIL = "COM:MINGHANG:CRM:%s:SECURITYEMAIL";
    public static final String REDIS_PERSONALCENTER_TIME = "COM:MINGHANG:CRM:%s:TIME";
    public static final String REDIS_PERSONALCENTER_PHONETIME = "COM:MINGHANG:CRM:%s:PHONETIME";
    
    //用户下载excel时缓存,用作解决客户端无法下载问题
    public static final String REDIS_EXCELDOWN_CATCH = "COM:MINGHANG:CRM:EXCELACTCH:%s";

    
    //公司账号单价
    public static final String PAY_ACCOUNT_PRICE="COM:MINGHANG:CRM:PAYCOMP:ACCOUNT:%s:PRICE";
    //公司剩余通话分钟数
    public static final String PAY_CALL_MINUTES_NOW="COM:MINGHANG:CRM:PAYCOMP:CALLMINUTES:%s:NOW";
    //公司剩余通话分钟单价
    public static final String PAY_CALL_MINUTES_PRICE="COM:MINGHANG:CRM:PAYCOMP:CALLMINUTES:%s:PRICE";
    
    //按日期统计当日各公司通话分钟数-用作同步
    public static final String PAY_CALL_SYNC_TOTAL_MINUTES="COM:MINGHANG:CRM:PAYCOMP:TOTALCALLMINUTES:%s";
    
    //当日各公司通话分钟数以及其他信息-用作同步
    public static final String PAY_CALL_COUNT_TOTAL_MINUTES="COM:MINGHANG:CRM:PAYCOMP:CATCHESMSCALLCOUNT:CATCHVAL";
    
    //支付中心通话分钟数统计剩余部分数据-用作同步
    public static final String PAY_CALL_COUNT_TOTAL_CATCH="COM:MINGHANG:CRM:PAYCOMP:CALLSMSCOUNT:%s:CALL";
    
    //按日期统计当日各公司通话分钟数-用作同步-邮件接收对象
    public static final String PAY_CALL_COUNT_MAIL_CC="COM:MINGHANG:CRM:PAYCOMP:PAY_CALL_COUNT_MAIL_CC:VAL";
    
    //系统配置
    public static final String PROJECT = "COM:MINGHANG:CRM:PROJECT:";
    public static final long YXTIME = 24*60*60;
    public static final String CACHE = "COM:MINGHANG:CACHE:";

    //前端关站
    public static final String CORE_SHUT_SERVER_KEY="COM:MINGHANG:CRM:CORE:SHUT_SERVER";
    //超级管理员
    public static  final  String ADMINUSER = PROJECT+"AdminUser";
    //运维
    public static  final  String OPERATIONUSER = PROJECT+"OperationUser";
    //关站白名单
    public static  final  String WHITELIST = PROJECT+"WhiteList";
    //数据字典Key
    public static final String VALS = "RM";
    public static  String MQ = "192.168.1.65,192.168.1.210,192.168.1.203,192.168.1.213";
    
    //未被使用的飞鸟坐席编号,(公司编号,坐席编号)
    public static final String FNCALL_SEAT_UNUSED="COM:MINGHANG:FNCALL:SEAT:UNUSED:%s:%s";
    //已使用的飞鸟坐席编号,(公司编号,坐席编号)
    public static final String FNCALL_SEAT_USED="COM:MINGHANG:FNCALL:SEAT:USED:%s:%s";
    //正在被申请的坐席编号,(公司编号,坐席编号)
    public static final String FNCALL_SEAT_APPLYING="COM:MINGHANG:FNCALL:SEAT:APPLYING:%s:%s";
    
    //法院失信被执行人缓存-列表,3小时清空
    public static final String ALIYUNCOURTDISHONESTYQUERY_CATCHE_LIST="COM:MINGHANG:QUERY:ALIYUNCOURTDISHONESTYQUERY:LIST:%s";
    //法院失信被执行人缓存-详情,3小时清空
    public static final String ALIYUNCOURTDISHONESTYQUERY_CATCHE_DETAIL="COM:MINGHANG:QUERY:ALIYUNCOURTDISHONESTYQUERY:DETAIL:%s";
    
}
