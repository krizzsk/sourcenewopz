package com.didi.dimina.container.bridge;

import android.app.Activity;
import com.didi.dimina.container.webengine.WebViewEngine;

public class DMWebViewJSModuleLazyParameter {
    public static final String EXPORT_NAME = "DMWebViewBridgeModule";
    private final Activity mActivity;
    private volatile BridgeCheckBridge mCheckBridgeSubJSBridge;
    private volatile ComponentSubJSBridge mComponent;
    private final WebViewEngine mDiminaWebView;
    private volatile KeyboardSubJSBridge mKeyboard;
    private volatile LocalFilePathSubJSBridge mLocalFilePathSubJSBridge;
    private volatile PageStyleSubJSBridge mPageStyle;
    private volatile PickViewSubJSBridge mPickViewSubJSBridge;
    private volatile ReportMiniProgramSubJSBridge mReportMiniProgramSubJSBridge;
    private volatile C7439i mTouchView;
    private volatile VConsoleJSBridge mVConsoleJSBridge;
    private volatile WebViewPageInnerSubJSBridge mWebViewPageInner;

    /* access modifiers changed from: package-private */
    public VConsoleJSBridge getVConsole() {
        if (this.mVConsoleJSBridge == null) {
            synchronized (this) {
                if (this.mVConsoleJSBridge == null) {
                    this.mVConsoleJSBridge = new VConsoleJSBridge(this.mDiminaWebView);
                }
            }
        }
        return this.mVConsoleJSBridge;
    }

    /* access modifiers changed from: package-private */
    public C7439i getTouchView() {
        if (this.mTouchView == null) {
            synchronized (this) {
                if (this.mTouchView == null) {
                    this.mTouchView = new C7439i(this.mActivity, this.mDiminaWebView);
                }
            }
        }
        return this.mTouchView;
    }

    /* access modifiers changed from: package-private */
    public ComponentSubJSBridge getComponent(boolean z) {
        if (!z) {
            return this.mComponent;
        }
        if (this.mComponent == null) {
            synchronized (this) {
                if (this.mComponent == null) {
                    this.mComponent = new ComponentSubJSBridge(this.mActivity, this.mDiminaWebView.getDmPage());
                }
            }
        }
        return this.mComponent;
    }

    /* access modifiers changed from: package-private */
    public KeyboardSubJSBridge getKeyboard() {
        if (this.mKeyboard == null) {
            synchronized (this) {
                if (this.mKeyboard == null) {
                    this.mKeyboard = new KeyboardSubJSBridge(this.mActivity, this.mDiminaWebView);
                }
            }
        }
        return this.mKeyboard;
    }

    /* access modifiers changed from: package-private */
    public WebViewPageInnerSubJSBridge getWebViewPageInner() {
        if (this.mWebViewPageInner == null) {
            synchronized (this) {
                if (this.mWebViewPageInner == null) {
                    this.mWebViewPageInner = new WebViewPageInnerSubJSBridge(this.mDiminaWebView.getDmPage(), this.mDiminaWebView.getDmMina(), this.mDiminaWebView);
                }
            }
        }
        return this.mWebViewPageInner;
    }

    /* access modifiers changed from: package-private */
    public PageStyleSubJSBridge getPageStyle() {
        if (this.mPageStyle == null) {
            synchronized (this) {
                if (this.mPageStyle == null) {
                    this.mPageStyle = new PageStyleSubJSBridge(this.mDiminaWebView.getDmPage());
                }
            }
        }
        return this.mPageStyle;
    }

    /* access modifiers changed from: package-private */
    public LocalFilePathSubJSBridge getLocalFilePathSubJSBridge() {
        if (this.mLocalFilePathSubJSBridge == null) {
            synchronized (this) {
                if (this.mLocalFilePathSubJSBridge == null) {
                    this.mLocalFilePathSubJSBridge = new LocalFilePathSubJSBridge(this.mDiminaWebView.getDmMina());
                }
            }
        }
        return this.mLocalFilePathSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public PickViewSubJSBridge getPickViewSubJSBridge() {
        if (this.mPickViewSubJSBridge == null) {
            synchronized (this) {
                if (this.mPickViewSubJSBridge == null) {
                    this.mPickViewSubJSBridge = new PickViewSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mPickViewSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public BridgeCheckBridge getBridgeCheckBridge() {
        if (this.mCheckBridgeSubJSBridge == null) {
            synchronized (this) {
                if (this.mCheckBridgeSubJSBridge == null) {
                    this.mCheckBridgeSubJSBridge = new BridgeCheckBridge(this.mDiminaWebView.getDmMina());
                }
            }
        }
        return this.mCheckBridgeSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public ReportMiniProgramSubJSBridge getReportMiniProgramSubJSBridge() {
        if (this.mReportMiniProgramSubJSBridge == null) {
            synchronized (this) {
                if (this.mReportMiniProgramSubJSBridge == null) {
                    this.mReportMiniProgramSubJSBridge = new ReportMiniProgramSubJSBridge(this.mDiminaWebView.getDmMina());
                }
            }
        }
        return this.mReportMiniProgramSubJSBridge;
    }

    public DMWebViewJSModuleLazyParameter(WebViewEngine webViewEngine) {
        this.mDiminaWebView = webViewEngine;
        this.mActivity = webViewEngine.getActivity();
    }
}
