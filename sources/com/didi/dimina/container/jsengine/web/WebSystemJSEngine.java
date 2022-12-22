package com.didi.dimina.container.jsengine.web;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.JSEngineCallback;
import com.didi.dimina.container.jsengine.JSEngineFatalCallback;
import com.didi.dimina.container.jsengine.JSExceptionCallback;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class WebSystemJSEngine implements JSEngine {

    /* renamed from: a */
    private static final String f16847a = "JSWebEngine";

    /* renamed from: b */
    private static final String f16848b = "http://websystemjsengine.dimina";

    /* renamed from: c */
    private final Handler f16849c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WebView f16850d;

    /* renamed from: e */
    private final HashMap<String, Boolean> f16851e = new HashMap<>();

    /* renamed from: f */
    private final boolean f16852f = DebugKitStoreUtil.getWebViewJSEngineEnabled();

    /* renamed from: g */
    private final ConcurrentHashMap<String, IDMCommonAction<Void>> f16853g = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ConcurrentHashMap<String, C7487a> f16854h = new ConcurrentHashMap<>();
    public boolean mIsRelease;

    public void onLowMemory() {
    }

    public void onMemoryPressNotify(JSEngine.PressLevel pressLevel) {
    }

    public /* synthetic */ void registerOnUnHandledRejection() {
        JSEngine.CC.$default$registerOnUnHandledRejection(this);
    }

    public /* synthetic */ void setDMMina(DMMina dMMina) {
        JSEngine.CC.$default$setDMMina(this, dMMina);
    }

    public void setGlobalOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public void setJSEngineCallback(JSEngineCallback jSEngineCallback) {
    }

    public void setJSExceptionCallback(JSExceptionCallback jSExceptionCallback) {
    }

    public void setOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public void setOnFatalPrinter(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public WebSystemJSEngine() {
        WebView webView = new WebView(Dimina.getConfig().getApp());
        this.f16850d = webView;
        WebSettings settings = webView.getSettings();
        if (this.f16852f) {
            settings.setAllowFileAccess(true);
            settings.setAllowFileAccessFromFileURLs(true);
            String str = FileUtil.getInternalFilesDirectory(Dimina.getConfig().getApp(), "").toString() + File.separator + DMSandboxHelper.DIMINA + File.separator + "webJSEngine.html";
            if (!new File(str).exists()) {
                FileUtil.write("\n<!DOCTYPE html>\n<html lang=\"zh_CN\">\n<head>\n<meta charset=\"UTF-8\"\n></head>\n<body>\n</body>\n</html>", str);
            }
            this.f16850d.loadUrl(str);
        }
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setDomStorageEnabled(false);
        settings.setCacheMode(-1);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        WebView.setWebContentsDebuggingEnabled(DebugKitStoreUtil.getWebViewJSEngineEnabled());
        this.f16850d.addJavascriptInterface(this, C7487a.f16855a);
        this.f16850d.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                    if (Dimina.getConfig() == null || !Dimina.getConfig().isDebug()) {
                        LogUtil.eRelease(WebSystemJSEngine.f16847a, "[error] " + consoleMessage.message());
                        LogUtil.eRelease(WebSystemJSEngine.f16847a, "[error] sourceId = " + consoleMessage.sourceId());
                        LogUtil.eRelease(WebSystemJSEngine.f16847a, "[error] lineNumber = " + consoleMessage.lineNumber());
                        return true;
                    }
                    LogUtil.m13409e("JSWebEngine | " + consoleMessage.message());
                    return true;
                } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.TIP) {
                    LogUtil.m13411i("JSWebEngine | " + consoleMessage.message());
                    return true;
                } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.LOG) {
                    LogUtil.m13411i("JSWebEngine | " + consoleMessage.message());
                    return true;
                } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
                    LogUtil.m13413w("JSWebEngine | " + consoleMessage.message());
                    return true;
                } else if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.DEBUG) {
                    return true;
                } else {
                    LogUtil.m13407d("JSWebEngine | " + consoleMessage.message());
                    return true;
                }
            }
        });
        this.f16850d.setWebViewClient(new WebViewClient() {
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                LogUtil.m13411i("JSWebEngine WebView interceptReq url===" + str);
                WebResourceResponse requireWebResourceResponse = requireWebResourceResponse(str);
                if (requireWebResourceResponse != null) {
                    return requireWebResourceResponse;
                }
                return super.shouldInterceptRequest(webView, str);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                String uri = webResourceRequest.getUrl().toString();
                LogUtil.m13411i("JSWebEngine WebView interceptReq url===" + uri);
                WebResourceResponse requireWebResourceResponse = requireWebResourceResponse(uri);
                if (requireWebResourceResponse != null) {
                    return requireWebResourceResponse;
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            private WebResourceResponse requireWebResourceResponse(String str) {
                FileInputStream fileInputStream;
                String str2;
                if (str.startsWith(WebSystemJSEngine.f16848b)) {
                    try {
                        fileInputStream = new FileInputStream(new File(str.substring(31)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        fileInputStream = null;
                    }
                    if (fileInputStream != null) {
                        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
                        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
                            str2 = fileExtensionFromUrl.equals("js") ? "application/javascript" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                        } else {
                            str2 = AsyncHttpRequest.HEADER_ACCEPT_ALL;
                        }
                        return new WebResourceResponse(str2, "UTF-8", fileInputStream);
                    }
                }
                return null;
            }
        });
        LogUtil.iRelease(f16847a, "SystemWebEngine");
    }

    public void release(boolean z) {
        if (z) {
            this.mIsRelease = true;
            this.f16849c.post(new Runnable() {
                public final void run() {
                    WebSystemJSEngine.this.m12466a();
                }
            });
            return;
        }
        this.mIsRelease = true;
        this.f16849c.postDelayed(new Runnable() {
            public final void run() {
                WebSystemJSEngine.this.m12466a();
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12466a() {
        WebView webView = this.f16850d;
        if (webView != null) {
            webView.destroy();
            this.f16850d = null;
        }
    }

    public void executeScript(final String str, String str2, final IDMCommonAction<Void> iDMCommonAction) {
        if (!this.mIsRelease) {
            this.f16849c.post(new Runnable() {
                public void run() {
                    if (!WebSystemJSEngine.this.mIsRelease) {
                        WebSystemJSEngine.this.f16850d.evaluateJavascript(str, new ValueCallback<String>() {
                            public void onReceiveValue(String str) {
                                if (iDMCommonAction != null) {
                                    iDMCommonAction.callback(null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void executeScript(String str) {
        executeScript(str, (String) null, (IDMCommonAction<Void>) null);
    }

    public void executeScriptFile(String str, String str2, int i, String str3, String str4, String str5, String str6, IDMCommonAction<Void> iDMCommonAction) {
        if (this.f16852f) {
            if (str2 != null && !str2.startsWith(f16848b)) {
                str2 = f16848b + str2;
            }
            this.f16853g.put(str2, iDMCommonAction);
            executeScript(getInjectJsFileCommand(str2), (String) null, (IDMCommonAction<Void>) null);
            return;
        }
        executeScript(str, (String) null, iDMCommonAction);
    }

    public String getInjectJsFileCommand(String str) {
        return String.format("var a = document.createElement('script');\na.src = '%s'; a.async = false;a.onload=function(){__WebJSEngine__.scriptOnLoad('%s');};document.body.appendChild(a);", new Object[]{str, str});
    }

    public void registerCallBack(String str, String str2, JSCallback jSCallback) {
        this.f16849c.post(new Runnable(str, str2, jSCallback) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ JSCallback f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                WebSystemJSEngine.this.m12467a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12467a(String str, final String str2, JSCallback jSCallback) {
        final C7487a aVar = new C7487a(str, str2, jSCallback);
        this.f16851e.put(str, true);
        aVar.mo54992a(!this.f16851e.containsKey(str), this.f16850d, new IDMCommonAction<Void>() {
            public void callback(Void voidR) {
                WebSystemJSEngine.this.f16854h.put(str2, aVar);
            }
        });
    }

    public Looper getLooper() {
        return Looper.getMainLooper();
    }

    @JavascriptInterface
    public String invoke(String str, String str2) {
        Object a;
        C7487a aVar = this.f16854h.get(str);
        if (aVar == null || (a = aVar.mo54990a(str2)) == null) {
            return "";
        }
        return String.valueOf(a);
    }

    @JavascriptInterface
    public void scriptOnLoad(String str) {
        if (this.f16853g.containsKey(str)) {
            this.f16853g.get(str).callback(null);
            this.f16853g.remove(str);
        }
    }
}
