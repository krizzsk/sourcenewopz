package com.didichuxing.omega.sdk.feedback.webview;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.didichuxing.afanty.common.record.FeedbackRecord;
import com.didichuxing.afanty.common.record.RecordFactory;
import com.didichuxing.afanty.common.utils.CommonUtil;
import com.didichuxing.afanty.common.utils.JsonUtil;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.FeedbackBitmap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WebAppInterface {
    private static TitleBar mTitleBar;
    /* access modifiers changed from: private */
    public static WebView myWebView;

    public WebAppInterface(WebView webView) {
        myWebView = webView;
    }

    public static void setMyWebView(WebView webView) {
        myWebView = webView;
    }

    public void setTitleBar(TitleBar titleBar) {
        mTitleBar = titleBar;
    }

    @JavascriptInterface
    public void call(String str, String str2, String str3) {
        if (str2 != null && str != null && str.length() != 0 && str3 != null && str3.length() != 0) {
            if (str.equalsIgnoreCase("screenShotImage")) {
                getScreenShot(str3);
            } else if (str.equalsIgnoreCase("userLogAndInfo")) {
                getInfo(str3);
            } else if (str.equalsIgnoreCase("userInfo")) {
                getUserInfo(str3);
            }
        }
    }

    private void getInfo(final String str) {
        final String str2 = "";
        FeedbackBitmap.getInstance().setFr(RecordFactory.createFeedbackRecord());
        String log = getLog();
        try {
            str2 = getJson().trim().replace("\n", str2);
        } catch (Exception unused) {
        }
        final String replace = log.trim().replace("\n", "|||");
        WebView webView = myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    try {
                        String str = "javascript:" + str + "('" + replace + "','" + str2 + "')";
                        if (WebAppInterface.myWebView != null && CommonUtil.validateUrl(WebAppInterface.myWebView)) {
                            WebAppInterface.myWebView.loadUrl(str);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void getUserInfo(final String str) {
        final String str2 = "";
        try {
            str2 = RecordFactory.createUserInfo().toString().trim().replace("\n", str2);
        } catch (Exception e) {
            OLog.m32668e("user record to string fail:" + e.toString());
        }
        WebView webView = myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    try {
                        String str = "javascript:" + str + "('" + str2 + "')";
                        if (WebAppInterface.myWebView != null && CommonUtil.validateUrl(WebAppInterface.myWebView)) {
                            WebAppInterface.myWebView.loadUrl(str);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private String getJson() {
        String str;
        FeedbackRecord fr = FeedbackBitmap.getInstance().getFr();
        if (fr == null) {
            return "";
        }
        Map<String, Object> map = fr.toMap();
        map.remove("screenshots");
        map.remove("logcat");
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next().getValue();
            if (value instanceof String) {
                str = value.toString();
            } else if (value instanceof Integer) {
                str = value.toString();
            } else if (value instanceof Long) {
                str = value.toString();
            } else if (value instanceof Float) {
                str = value.toString();
            } else if (value instanceof Double) {
                str = value.toString();
            } else {
                if (value instanceof Map) {
                    it.remove();
                } else if (value instanceof List) {
                    it.remove();
                } else {
                    it.remove();
                }
                str = "";
            }
            if (str.length() == 0 || str.contains("\n")) {
                it.remove();
            }
        }
        return JsonUtil.map2Json(map);
    }

    private String getLog() {
        FeedbackRecord fr = FeedbackBitmap.getInstance().getFr();
        if (fr != null) {
            try {
                return new String(fr.getLogcat(), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private void getScreenShot(final String str) {
        new Thread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0069 A[SYNTHETIC, Splitter:B:36:0x0069] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[SYNTHETIC, Splitter:B:41:0x0073] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0080 A[SYNTHETIC, Splitter:B:48:0x0080] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x008a A[SYNTHETIC, Splitter:B:53:0x008a] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
            /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    com.didichuxing.omega.sdk.feedback.FeedbackBitmap r0 = com.didichuxing.omega.sdk.feedback.FeedbackBitmap.getInstance()
                    android.net.Uri r0 = r0.getScreenshot_uri()
                    java.lang.String r1 = ""
                    if (r0 == 0) goto L_0x0093
                    android.webkit.WebView r2 = com.didichuxing.omega.sdk.feedback.webview.WebAppInterface.myWebView
                    if (r2 == 0) goto L_0x0093
                    r2 = 0
                    android.webkit.WebView r3 = com.didichuxing.omega.sdk.feedback.webview.WebAppInterface.myWebView     // Catch:{ Exception -> 0x0060, all -> 0x005d }
                    android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0060, all -> 0x005d }
                    android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x0060, all -> 0x005d }
                    java.io.InputStream r0 = r3.openInputStream(r0)     // Catch:{ Exception -> 0x0060, all -> 0x005d }
                    r3 = 8192(0x2000, float:1.14794E-41)
                    byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
                    java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
                    r4.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
                L_0x002c:
                    int r2 = r0.read(r3)     // Catch:{ Exception -> 0x0054 }
                    r5 = -1
                    if (r2 == r5) goto L_0x0038
                    r5 = 0
                    r4.write(r3, r5, r2)     // Catch:{ Exception -> 0x0054 }
                    goto L_0x002c
                L_0x0038:
                    byte[] r2 = r4.toByteArray()     // Catch:{ Exception -> 0x0054 }
                    r3 = 2
                    java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ Exception -> 0x0054 }
                    if (r0 == 0) goto L_0x004b
                    r0.close()     // Catch:{ Exception -> 0x0047 }
                    goto L_0x004b
                L_0x0047:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x004b:
                    r4.close()     // Catch:{ Exception -> 0x004f }
                    goto L_0x0094
                L_0x004f:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto L_0x0094
                L_0x0054:
                    r2 = move-exception
                    goto L_0x0064
                L_0x0056:
                    r1 = move-exception
                    r4 = r2
                    goto L_0x007d
                L_0x0059:
                    r3 = move-exception
                    r4 = r2
                    r2 = r3
                    goto L_0x0064
                L_0x005d:
                    r1 = move-exception
                    r4 = r2
                    goto L_0x007e
                L_0x0060:
                    r0 = move-exception
                    r4 = r2
                    r2 = r0
                    r0 = r4
                L_0x0064:
                    r2.printStackTrace()     // Catch:{ all -> 0x007c }
                    if (r0 == 0) goto L_0x0071
                    r0.close()     // Catch:{ Exception -> 0x006d }
                    goto L_0x0071
                L_0x006d:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0071:
                    if (r4 == 0) goto L_0x0093
                    r4.close()     // Catch:{ Exception -> 0x0077 }
                    goto L_0x0093
                L_0x0077:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto L_0x0093
                L_0x007c:
                    r1 = move-exception
                L_0x007d:
                    r2 = r0
                L_0x007e:
                    if (r2 == 0) goto L_0x0088
                    r2.close()     // Catch:{ Exception -> 0x0084 }
                    goto L_0x0088
                L_0x0084:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0088:
                    if (r4 == 0) goto L_0x0092
                    r4.close()     // Catch:{ Exception -> 0x008e }
                    goto L_0x0092
                L_0x008e:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0092:
                    throw r1
                L_0x0093:
                    r2 = r1
                L_0x0094:
                    if (r2 == 0) goto L_0x00ae
                    int r0 = r2.length()
                    if (r0 != 0) goto L_0x009d
                    goto L_0x00ae
                L_0x009d:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "data:image/jpg;base64,"
                    r0.append(r1)
                    r0.append(r2)
                    java.lang.String r1 = r0.toString()
                L_0x00ae:
                    android.webkit.WebView r0 = com.didichuxing.omega.sdk.feedback.webview.WebAppInterface.myWebView
                    if (r0 == 0) goto L_0x00c0
                    android.webkit.WebView r0 = com.didichuxing.omega.sdk.feedback.webview.WebAppInterface.myWebView
                    com.didichuxing.omega.sdk.feedback.webview.WebAppInterface$3$1 r2 = new com.didichuxing.omega.sdk.feedback.webview.WebAppInterface$3$1
                    r2.<init>(r1)
                    r0.post(r2)
                L_0x00c0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.webview.WebAppInterface.C160893.run():void");
            }
        }).start();
    }

    @JavascriptInterface
    public void setTitle(String str) {
        TitleBar titleBar = mTitleBar;
        if (titleBar != null) {
            titleBar.setTitle(str);
        }
    }
}
