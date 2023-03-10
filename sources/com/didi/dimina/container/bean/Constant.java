package com.didi.dimina.container.bean;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Constant {
    public static final String DEFAULT_JS_SDK_ID = "923777";
    public static final String KEY_PRE_INSTALL_RECENTLY_USED_JSAPP_PREFIX = "dimina_pre_install_recently_used_";

    public static class BundleConstant {
        public static final String APP_MODULE_NAME = "app";
        public static final String SDK_MODULE_NAME = "DIMINA_JSSDK";
    }

    public static class LAUNCHER_JS {
        public static final String APP_CONFIG = "/app-config.json";
        public static final String APP_SERVICE = "/app-service.js";
        public static final String APP_SERVICE_NAME = "/app-service.js";
        public static final String APP_WEB_VIEW_NAME = "/app-webview.js";
        public static final String APP_WEB_VIEW_STYLE_NAME = "/app-webview.css";
        public static final String DM_SERVICE = "/dev/dm-service.js";
        public static final String DM_WEB_VIEW_NAME = "/dev/dm-webview.js";
        public static final String PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX = ".js";
        public static final String PAGE_WEB_VIEW_STYLE_PREFIX = "/page-webview.";
        public static final String PAGE_WEB_VIEW_STYLE_SUFFIX = ".css";
    }

    public static class LAUNCHER_WEB_VIEW {
        public static final String PAGE_FRAME = "/dev/page-frame.html";
    }

    public static boolean isFromSDK(String str) {
        return str.contains("quick-page-frame.html") || str.contains("page-frame.html") || str.contains("dm-service.js") || str.contains("dm-webview.js");
    }

    public static class CORE_DOTTING {
        public static final String DIMINA_INIT = "dimina_init";
        public static final String DIMINA_LAUNCH = "dimina_launch";
        public static final String DIMINA_PAGE_ACTIVITY_ON_DESTROY = "activity_onDestroy";
        public static final String DIMINA_PAGE_ACTIVITY_ON_START = "activity_onStart";
        public static final String DIMINA_PAGE_ACTIVITY_ON_STOP = "activity_onStop";
        public static final String DIMINA_PAGE_DOM_READY = "page_domReady";
        public static final String DIMINA_PAGE_FIRST_DOM_READY = "page_first_domReady";
        public static final String DIMINA_REGISTER_CUSTOM_COMPONENT = "dimina_register_custom_component";
        public static final String DIMINA_REGISTER_JS_MODULE = "dimina_register_js_module";
        public static final String DIMINA_REGISTER_LAUNCH_LIFECYCLE_CALLBACK = "dimina_register_launch_lifecycle_callback";
        public static final String DIMINA_RELEASE = "dimina_release";
        public static final String DIMINA_REQUIRE_INSTALL_END_LOCAL = "dimina_require_install_end_local";
        public static final String DIMINA_REQUIRE_INSTALL_END_REMOTE = "dimina_require_install_end_remote";
        public static final String DIMINA_REQUIRE_INSTALL_START = "dimina_require_install_start";
        public static final String DIMINA_UN_REGISTER_LAUNCH_LIFECYCLE_CALLBACK = "dimina_unregister_launch_lifecycle_callback";
        public static final String DMMINA_HIDE_STACK = "dmmina_hide_stack";
        public static final String DMMINA_LAUNCH_STACK_PAGE = "dmmina_launch_stack_page";
        public static final String DMMINA_PRELOAD = "dmmina_preload";
        public static final String DMMINA_PRE_INSTALL = "dmmina_pre_install";
        public static final String DMMINA_PUSH_PAGE = "dmmina_push_page";
        public static final String DMMINA_RELEASE = "dmmina_release";
        public static final String DMMINA_REMOVE_STACK = "dmmina_remove_stack";
        public static final String DMMINA_SHOW_STACK = "dmmina_show_stack";
        public static final String LAUNCH_DMMINA = "launch_dmmina";
        public static final String LAUNCH_DMMINA_CONSTRUCTION = "launch_dmmina_construction";
        public static final String LAUNCH_ENGINE_CREATE = "launch_engine_create";
        public static final String LAUNCH_EXIT_EMPTY_BUNDLE_DOWNLOAD_FAILED = "launch_exit_empty_bundle_download_failed";
        public static final String LAUNCH_EXIT_IN_MINI_LAUNCH = "launch_exit_in_mini_launch";
        public static final String LAUNCH_INVOKE_BUSINESS_READY = "launch_invokeBusinessReady";
        public static final String LAUNCH_INVOKE_SERVICE_READY = "launch_invokeServiceReady";
        public static final String LAUNCH_LAUNCH_PAGE = "launch_launchPage";
        public static final String LAUNCH_LOADED_APP_CONFIG_JSON = "launch_loaded_app_config_json";
        public static final String LAUNCH_LOADED_APP_SERVICE_JS_END = "launch_loaded_app_service_js_end";
        public static final String LAUNCH_LOADED_APP_SERVICE_JS_START = "launch_loaded_app_service_js_start";
        public static final String LAUNCH_LOADED_DM_SERVICE_JS_END = "launch_loaded_dm_service_js_end";
        public static final String LAUNCH_LOADED_DM_SERVICE_JS_START = "launch_loaded_dm_service_js_start";
        public static final String LAUNCH_NATIVE_JS_READY = "launch_nativeJsReady";
        public static final String LAUNCH_SWITCH_TAB_LOAD_JS_FILE_TO_DATA_THREAD_FINISH = "launch_switch_tab_load_js_file_to_data_thread_finish";
        public static final String LAUNCH_SWITCH_TAB_LOAD_JS_FILE_TO_DATA_THREAD_REQUIRE = "launch_switch_tab_load_js_file_to_data_thread_require";
        public static final String NAVIGATE_CLOSE_DIMINA = "navigate_closeDimina";
        public static final String NAVIGATE_GET_CURRENT_PAGES = "navigate_getCurrentPages";
        public static final String NAVIGATE_HIDE_STACK = "navigate_hideStack";
        public static final String NAVIGATE_LAUNCH = "navigate_launch";
        public static final String NAVIGATE_NAVIGATE_BACK = "navigate_navigateBack";
        public static final String NAVIGATE_NAVIGATE_BACK_NATIVE = "navigate_navigateBackNative";
        public static final String NAVIGATE_NAVIGATE_TO = "navigate_navigateTo";
        public static final String NAVIGATE_ON_CLOSE_MINI_PROGRAM = "navigate_onCloseMiniProgram";
        public static final String NAVIGATE_PUSH_PAGE = "navigate_pushPage";
        public static final String NAVIGATE_REDIRECT_TO = "navigate_redirectTo";
        public static final String NAVIGATE_RELAUNCH = "navigate_relaunch";
        public static final String NAVIGATE_REMOVE_STACK = "navigate_removeStack";
        public static final String NAVIGATE_SHOW_STACK = "navigate_showStack";
        public static final String NAVIGATE_SWITCH_TAB = "navigate_switchTab";
        public static final String PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_FAILED = "package_loadJSFileToDataThread_failed";
        public static final String PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_START = "package_loadJSFileToDataThread_start";
        public static final String PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS = "package_loadJSFileToDataThread_success";
        public static final String PACKAGE_LOAD_SUB_PACKAGE_FAILED = "package_loadSubPackage_failed";
        public static final String PACKAGE_LOAD_SUB_PACKAGE_START = "package_loadSubPackage_start";
        public static final String PACKAGE_LOAD_SUB_PACKAGE_SUCCESS = "package_loadSubPackage_success";
        public static final String PACKAGE_PRELOAD_SUB_PACKAGE_FAILED = "package_preloadSubPackage_failed";
        public static final String PACKAGE_PRELOAD_SUB_PACKAGE_START = "package_preloadSubPackage_start";
        public static final String PACKAGE_PRELOAD_SUB_PACKAGE_SUCCESS = "package_preloadSubPackage_success";
        public static final String PAGE_FIRST_INVOKE_PARAMS_TO_WIN_DONE = "page_first_invokeParamsToWinDone";
        public static final String PAGE_INVOKE_PARAMS_TO_WIN_DONE = "page_invokeParamsToWinDone";
        public static final String PAGE_INVOKE_PRELOAD_WEB_VIEW_FINISH = "page_preloadWebViewFinish";
        public static final String PAGE_ON_CREATE = "page_onCreate";
        public static final String PAGE_ON_DESTROY = "page_onDestroy";
        public static final String PAGE_ON_HIDE = "page_on_hide";
        public static final String PAGE_ON_SHOW = "page_on_show";
        public static final String PAGE_PRELOAD_WEB_VIEW = "page_preloadWebView";
        public static final String PAGE_RELEASE_WEB_VIEW = "page_releaseWebView";
        public static final String PAGE_RELOAD_WEB_VIEW = "page_reLoadWebView";
        public static volatile Map<String, String> zhMap;

        static {
            initMap();
        }

        private static void initMap() {
            zhMap = new ConcurrentHashMap();
            zhMap.put(LAUNCH_DMMINA, "???????????????");
            zhMap.put(LAUNCH_LOADED_APP_CONFIG_JSON, "?????? ?????? app-config.json");
            zhMap.put(LAUNCH_LOADED_DM_SERVICE_JS_START, "?????? ?????? dm-service.js ??????");
            zhMap.put(LAUNCH_LOADED_DM_SERVICE_JS_END, "?????? ?????? dm-service.js ??????");
            zhMap.put(LAUNCH_LOADED_APP_SERVICE_JS_START, "?????? ?????? app-service.js ??????");
            zhMap.put(LAUNCH_LOADED_APP_SERVICE_JS_END, "?????? ?????? app-service.js ??????");
            zhMap.put(LAUNCH_INVOKE_SERVICE_READY, "?????? ?????? invokeServiceReady");
            zhMap.put(LAUNCH_NATIVE_JS_READY, "?????? ?????? nativeJsReady");
            zhMap.put(LAUNCH_INVOKE_BUSINESS_READY, "?????? ?????? businessReady");
            zhMap.put(LAUNCH_LAUNCH_PAGE, "?????? ?????? launchPage");
            zhMap.put(LAUNCH_EXIT_IN_MINI_LAUNCH, "?????? ???????????????????????????");
            zhMap.put(LAUNCH_EXIT_EMPTY_BUNDLE_DOWNLOAD_FAILED, "?????? ?????????????????????????????????");
            zhMap.put(LAUNCH_ENGINE_CREATE, "?????? JSEngine ??????");
            zhMap.put(PAGE_ON_CREATE, "?????? onCreate");
            zhMap.put(PAGE_ON_SHOW, "?????? onShow");
            zhMap.put(PAGE_ON_HIDE, "?????? onHide");
            zhMap.put(PAGE_ON_DESTROY, "?????? onDestroy");
            zhMap.put(PAGE_RELOAD_WEB_VIEW, "?????? WebView ??????");
            zhMap.put(PAGE_RELEASE_WEB_VIEW, "?????? WebView ??????");
            zhMap.put(PAGE_PRELOAD_WEB_VIEW, "?????? ?????????");
            zhMap.put(PAGE_INVOKE_PRELOAD_WEB_VIEW_FINISH, "?????? ???????????????");
            zhMap.put(PAGE_INVOKE_PARAMS_TO_WIN_DONE, "?????? invokeParamsToWinDone");
            zhMap.put(PAGE_FIRST_INVOKE_PARAMS_TO_WIN_DONE, "?????? ????????? invokeParamsToWinDone");
            zhMap.put(DIMINA_PAGE_DOM_READY, "?????? domReady");
            zhMap.put(DIMINA_PAGE_FIRST_DOM_READY, "?????? ????????? domReady");
            zhMap.put(NAVIGATE_SHOW_STACK, "?????? showStack");
            zhMap.put(NAVIGATE_HIDE_STACK, "?????? hideStack");
            zhMap.put(NAVIGATE_REMOVE_STACK, "?????? removeStack");
            zhMap.put(NAVIGATE_PUSH_PAGE, "?????? pushStack");
            zhMap.put(NAVIGATE_LAUNCH, "?????? launch");
            zhMap.put(NAVIGATE_RELAUNCH, "?????? relaunch");
            zhMap.put(NAVIGATE_REDIRECT_TO, "?????? redirectTo");
            zhMap.put(NAVIGATE_NAVIGATE_TO, "?????? navigateTo");
            zhMap.put(NAVIGATE_NAVIGATE_BACK, "?????? navigateBack");
            zhMap.put(PACKAGE_PRELOAD_SUB_PACKAGE_START, "????????? ?????????????????????");
            zhMap.put(PACKAGE_PRELOAD_SUB_PACKAGE_FAILED, "????????? ?????????????????????");
            zhMap.put(PACKAGE_PRELOAD_SUB_PACKAGE_SUCCESS, "????????? ?????????????????????");
            zhMap.put(PACKAGE_LOAD_SUB_PACKAGE_START, "????????? ??????????????????");
            zhMap.put(PACKAGE_LOAD_SUB_PACKAGE_FAILED, "????????? ??????????????????");
            zhMap.put(PACKAGE_LOAD_SUB_PACKAGE_SUCCESS, "????????? ??????????????????");
            zhMap.put(PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS, "????????? loadJSFileToDataThread??????");
            zhMap.put(PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_FAILED, "????????? loadJSFileToDataThread??????");
            zhMap.put(PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_START, "????????? loadJSFileToDataThread??????");
        }

        public static String translate(String str) {
            String str2 = zhMap.get(str);
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
    }
}
