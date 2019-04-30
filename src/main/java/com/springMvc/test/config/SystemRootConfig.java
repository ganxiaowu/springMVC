package com.springMvc.test.config;

/**
 * 说明:系统配置类-后台使用,为了方便以后项目分离
 * 时间:2016/12/19 13:40
 * 作者:曾立明
 * 版本:v1.0
 */
public class SystemRootConfig {
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
    public static final String USER_INFO = "crmBackUser";
    public static final String USER_NO = "USER_NO";

    public static  String DESKEY = "#crm.32m0h1k6j`crm";//加密秘钥   JAVA本身的加密
    //用户相关的redis key
    public static  String CLIENT_KEY = "e64rbd57"; //客户端加密key

    public static final String REDIS_USER = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:USER";
    public static final String REDIS_MENU = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:MENU";
    public static final String REDIS_OPKEY = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:OPKEY";
    public static final String REDIS_LOGINNUM = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:LOGINNUM";
    public static final String TOKEN = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:TOKEN";
    public static final String AESKEY = "COM:MINGHANG:CRM:BACK:USERSINFO:%s:AESKEY";

    //用户具有的菜单访问地址权限
    public static final String MENU_SET = "COM:MINGHANG:CRM:BACK:MENU_SET:";
    public static final String WS = "COM:MINGHANG:CRM:BACK:WS:";
    //个人中心验证码
    public static final String REDIS_PERSONALCENTER_SECURITYPHONE = "COM:MINGHANG:CRM:BACK:%s:SECURITYPHONE";
    public static final String REDIS_PERSONALCENTER_SECURITYEMAIL = "COM:MINGHANG:CRM:BACK:%s:SECURITYEMAIL";
    public static final String REDIS_PERSONALCENTER_TIME = "COM:MINGHANG:CRM:BACK:%s:TIME";
    public static final String REDIS_PERSONALCENTER_PHONETIME = "COM:MINGHANG:CRM:BACK:%s:PHONETIME";
    
    //用户下载excel时缓存,用作解决客户端无法下载问题
    public static final String REDIS_EXCELDOWN_CATCH = "COM:MINGHANG:CRM:BACK:EXCELACTCH:%s";

    
    
    
    //系统配置
    public static final String PROJECT = "COM:MINGHANG:CRM:BACK:PROJECT:";
    public static final long YXTIME = 24*60*60;
    public static final String CACHE = "COM:MINGHANG:BACK:CACHE:";
    
    
    //后台关站
    public static final String ROOT_SHUT_SERVER_KEY="COM:MINGHANG:CRM:BACK:SHUT_SERVER";

    //超级管理员
    public static  final  String ADMINUSER = PROJECT+"AdminUser";
    //运维
    public static  final  String OPERATIONUSER = PROJECT+"OperationUser";
    //关站白名单
    public static  final  String WHITELIST = PROJECT+"WhiteList";
    //数据字典Key
    public static final String VALS = "RM";
    public static  String MQ = "192.168.1.65,192.168.1.210,192.168.1.203,192.168.1.213";
}
