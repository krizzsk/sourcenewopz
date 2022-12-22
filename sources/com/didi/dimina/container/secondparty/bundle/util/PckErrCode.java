package com.didi.dimina.container.secondparty.bundle.util;

public class PckErrCode {
    public static final int API_CONFIG_SUCC_DEAL_ECEPTION = -406;
    public static final int ASSERT_COPY_ERROR = -400;
    public static final int ASSET_DM_CONFIG_NO_EXIST = -202;
    public static final int ASSET_FAIL = -201;
    public static final int ASSET_JSAPP_UNZIP_FAIL = -205;
    public static final int ASSET_JSSDK_UNZIP_FAIL = -204;
    public static final int ASSET_UNZIP_FAIL = -203;
    public static final int COMPOSE_MIN_SDK_NO_MATCHING = -409;
    public static final int CONFIG_API_APP_MODULE_NULL = -413;
    public static final int CONFIG_API_APP_SDK_MODULE_BOTH_NULL = -414;
    public static final int CONFIG_API_FAIL = -401;
    public static final int CONFIG_API_NO_SUCC = -402;
    public static final int CONFIG_API_SDK_MODULE_NULL = -412;
    public static final int CONFIG_REQUEST_RESULT_NULL = -410;
    public static final int DEBUGKIT_LIMITED = -411;
    public static final int DEFAULT_NO_SET = -9999;
    public static final int DOWNLOAD_ERROR = -403;
    public static final int HTTP_DM_CONFIG_NULL = -408;
    public static final int JSAPP_ID_NOT_EQUAL_ASSET_ID = -416;
    public static final int JSSDK_ID_NOT_EQUAL_ASSET_ID = -415;
    public static final int LOCAL_DM_CONFIG_NULL = -407;
    public static final int OTHER_EROR = -405;
    public static final int SUB_CONTENT_IS_EMPTY = -145;
    public static final int SUB_DOWNLOAD_CANCELED = -149;
    public static final int SUB_DOWNLOAD_FAILED = -142;
    public static final int SUB_INSTALL_LIST_EMPTY = -150;
    public static final int SUB_KEY_2_URL_FAILED = -141;
    public static final int SUB_KEY_2_URL_NO_200 = -147;
    public static final int SUB_KEY_2_URL_RESPONSE_DATA_ERROR = -148;
    public static final int SUB_MODULE_NO_CONFIG = -144;
    public static final int SUB_OCCUR_EXCEPTION = -146;
    public static final int SUB_PARAMS_INVALID = -140;
    public static final int SUB_PRE_DOWNLOAD_ERROR = -300;
    public static final int SUB_PRE_HTTP_DM_CONFIG_NULL = -302;
    public static final int SUB_PRE_UNZIP_ERROR = -301;
    public static final int SUB_UNZIP_FAILED = -143;
    public static final int SUCC = 0;
    public static final int THREAD_EXEC_EXCEPTION = -501;
    public static final int UNZIP_ERROR = -404;

    public static String code2Msg(int i) {
        if (i == -9999) {
            return i + " 未设置, 拦截器默认值";
        } else if (i == -501) {
            return i + " 线程执行过程中 发生错误";
        } else if (i != 0) {
            switch (i) {
                case JSAPP_ID_NOT_EQUAL_ASSET_ID /*-416*/:
                    return i + " 传入的JsAppId 与 Asset中的JsAppId不同";
                case JSSDK_ID_NOT_EQUAL_ASSET_ID /*-415*/:
                    return i + " 传入的JssdkId 与 Asset中的JsSdkId不同";
                case CONFIG_API_APP_SDK_MODULE_BOTH_NULL /*-414*/:
                    return i + " api/config 配置接口 返回内容中，app_module/sdk_module都为null";
                case CONFIG_API_APP_MODULE_NULL /*-413*/:
                    return i + " api/config 配置接口 返回内容中，app_module为null";
                case CONFIG_API_SDK_MODULE_NULL /*-412*/:
                    return i + " api/config 配置接口返回内容中，sdk_module为null";
                case DEBUGKIT_LIMITED /*-411*/:
                    return i + " debug 工具禁止远程更新(starbox小助手->包管理 有开关按钮)";
                case CONFIG_REQUEST_RESULT_NULL /*-410*/:
                    return i + " api/config 返回result为null";
                case COMPOSE_MIN_SDK_NO_MATCHING /*-409*/:
                    return i + " 在两两匹配过程中, jsSdk的minVersion 不匹配";
                case HTTP_DM_CONFIG_NULL /*-408*/:
                    return i + "api/config 转化配置为null";
                case LOCAL_DM_CONFIG_NULL /*-407*/:
                    return i + " 本地配置文件为null";
                case API_CONFIG_SUCC_DEAL_ECEPTION /*-406*/:
                    return i + " succ接口过程处理发生exception";
                case OTHER_EROR /*-405*/:
                    return i + " 发生其他错误";
                case UNZIP_ERROR /*-404*/:
                    return i + " 解压过程发生错误";
                case DOWNLOAD_ERROR /*-403*/:
                    return i + " 下载过程发生错误";
                case CONFIG_API_NO_SUCC /*-402*/:
                    return i + " api/config 接口返回值错误，不是200";
                case CONFIG_API_FAIL /*-401*/:
                    return i + " api/config接口进入了onFail";
                case ASSERT_COPY_ERROR /*-400*/:
                    return i + " asset执行过程中fail";
                default:
                    switch (i) {
                        case SUB_PRE_HTTP_DM_CONFIG_NULL /*-302*/:
                            return i + " 分包前置服过程务器返回的配置内容json转化内容为null";
                        case SUB_PRE_UNZIP_ERROR /*-301*/:
                            return i + "分包前置解压过程发生错误";
                        case SUB_PRE_DOWNLOAD_ERROR /*-300*/:
                            return i + "分包前置下载过程发生错误";
                        default:
                            switch (i) {
                                case -205:
                                    return i + " asset执行过程中 js app 发生错误\n";
                                case -204:
                                    return i + " asset执行过程中 js sdk 发生错误";
                                case -203:
                                    return i + " asset执行unzip fail";
                                case -202:
                                    return i + " asset中不存在配置文件";
                                case -201:
                                    return i + " asset处理过程发生fail";
                                default:
                                    switch (i) {
                                        case SUB_INSTALL_LIST_EMPTY /*-150*/:
                                            return i + "安装列表为空";
                                        case SUB_DOWNLOAD_CANCELED /*-149*/:
                                            return i + " 下载任务被取消";
                                        case SUB_KEY_2_URL_RESPONSE_DATA_ERROR /*-148*/:
                                            return i + " key2url 接口data 不正确";
                                        case SUB_KEY_2_URL_NO_200 /*-147*/:
                                            return i + " key2url 接口没有返回 200";
                                        case SUB_OCCUR_EXCEPTION /*-146*/:
                                            return i + " 发生异常";
                                        case SUB_CONTENT_IS_EMPTY /*-145*/:
                                            return i + " 文件读取成功，但是内容为 null";
                                        case SUB_MODULE_NO_CONFIG /*-144*/:
                                            return i + " 这个module 没有配置";
                                        case SUB_UNZIP_FAILED /*-143*/:
                                            return i + " bundle包下载成功，解压失败";
                                        case SUB_DOWNLOAD_FAILED /*-142*/:
                                            return i + " bundle包下载失败";
                                        case SUB_KEY_2_URL_FAILED /*-141*/:
                                            return i + " key换url获取失败";
                                        case SUB_PARAMS_INVALID /*-140*/:
                                            return i + " 入参错误";
                                        default:
                                            return i + " 未定义 这个错误码";
                                    }
                            }
                    }
            }
        } else {
            return i + " 成功";
        }
    }
}
