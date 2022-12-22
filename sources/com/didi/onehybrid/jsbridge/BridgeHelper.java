package com.didi.onehybrid.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.didi.onehybrid.util.C10393Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BridgeHelper {
    public static final String APOLLO_WEBVIEW_QM_TOGGLE_NAME = "webview_quality_monitor_enable";
    public static final String ASSET_BRIDGE4_JS = "fusion/didibridge4.js";
    public static final String CALLBACK_ID_FORMAT = "__${%s}__";
    public static final String CALLBACK_TO_JS = "javascript:Fusion.callbackJS('%s', %s);";
    public static final String CALL_REGISTER_MODULES = "javascript:Fusion.registerModules(%s);";
    public static final String CALL_TO_JS = "javascript:Fusion.invokeJSMethod('%s', '%s', %s);";
    public static final String ERROR_CODE_CALLBACK = "402";
    public static final int ERROR_CODE_CONFIG_NOT_FIND = 415;
    public static final int ERROR_CODE_DOWNLOAD_FAIL = 413;
    public static final int ERROR_CODE_EMPTY_ROLLBACK = 414;
    public static final String ERROR_CODE_INVALID_ARGUMENTS = "401";
    public static final int ERROR_CODE_INVALID_FILE_PATH = 410;
    public static final String ERROR_CODE_NO_INTERFACE = "400";
    public static final String ERROR_CODE_NO_MODULE = "403";
    public static final int ERROR_CODE_READ_FILE_ERROR = 412;
    public static final int ERROR_CODE_RESOURCE_NOT_FIND = 411;
    public static final int ERROR_CODE_SUCCESS = 200;
    public static final String ERROR_INFO_CONFIG_NOT_FIND = "config not find";
    public static final String ERROR_INFO_DOWNLOAD_FAIL = "resource download fail";
    public static final String ERROR_INFO_EMPTY_ROLLBACK = "empty rollback package";
    public static final String ERROR_INFO_INVALID_FILE_PATH = "invalid file path";
    public static final String ERROR_INFO_READ_FILE_ERROR = "read file error";
    public static final String ERROR_INFO_RESOURCE_NOT_FIND = "resource not find";
    public static final String ERROR_INFO_SUCCESS = "success";
    public static final String FUSION_CALL_NATIVE = "fusion://invokeNative";
    public static final String FUSION_JS_CALLBACK = "fusion://callbackNative";
    public static final String FUSION_SCHEMA = "fusion://";
    public static final String OMEGA_EVENT_BRIDGE = "tone_p_x_fusion_jsbridge";
    public static final String OMEGA_EVENT_CACHE = "tone_p_x_fusion_cache";
    public static final String OMEGA_WEBVIEW_QM_KEY_ERROR = "error";
    public static final String OMEGA_WEBVIEW_QM_KEY_RES_URL = "res_url";
    public static final String OMEGA_WEBVIEW_QM_KEY_SRC_THR = "src_throwable";
    public static final String OMEGA_WEBVIEW_QM_KEY_SRC_URL = "source_url";
    public static final int TRACE_ID_LENGTH = 11;

    /* renamed from: a */
    static final String f29602a = "";

    /* renamed from: b */
    static final String f29603b = "/";

    /* renamed from: c */
    private static final String f29604c = "BridgeHelper";

    public static Pair<String, String> extractNamespaceAndMethod(String str) {
        String[] split = str.replace("fusion://invokeNative", "").split("/");
        if (split.length >= 2) {
            return new Pair<>(split[0], split[1]);
        }
        return null;
    }

    public static InvokeMessage parseInvokeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        InvokeMessage invokeMessage = new InvokeMessage();
        invokeMessage.setTraceId(C10393Util.generateRandomString(11));
        invokeMessage.setModuleName(parse.getQueryParameter("module"));
        invokeMessage.setFunctionName(parse.getQueryParameter("method"));
        invokeMessage.setArgs(parse.getQueryParameter("arguments"));
        invokeMessage.setOrgProtocol(str);
        return invokeMessage;
    }

    public static void webViewLoadLocalJs(WebView webView, String str) {
        String assetFileToString = assetFileToString(webView.getContext(), str);
        webView.loadUrl("javascript:" + assetFileToString);
    }

    public static String assetFileToString(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        return m20808a(inputStream);
    }

    /* renamed from: a */
    private static String m20808a(InputStream inputStream) {
        String readLine;
        if (inputStream == null) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            do {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append("\n");
                    continue;
                }
            } while (readLine != null);
            bufferedReader.close();
            inputStream.close();
            String sb2 = sb.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return sb2;
        } catch (Exception e) {
            e.printStackTrace();
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (IOException unused2) {
                return null;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }
}
