package com.didi.sdk.webview;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.events.FusionTitlebarRightClickEvent;
import com.didi.sdk.events.FusionTitlebarRightTextEvent;
import com.didi.sdk.fusionbridge.module.ContactModule;
import com.didi.sdk.fusionbridge.module.DidiBridgeModule;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.fusionbridge.module.ShareEntranceModule;
import com.didi.sdk.fusionbridge.module.ShareModule;
import com.didi.sdk.util.permission.PermissionCallback;
import com.didi.sdk.webview.InterceptGoBackMgr;
import com.didi.sdk.webview.tool.WebViewToolDialog;
import com.didi.sdk.webview.tool.WebViewToolModel;
import com.didi.sharesdk.ShareApi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

public class WebActivity extends AbsLoadingWebActivity {
    public static final int REQ_ALBUM_ACTIVITY = 100;
    public static final int REQ_CAMERA_ACTIVITY = 101;
    public static final String UI_TARGET_WEB_TITLE = "web_title";

    /* renamed from: a */
    private static PermissionCallback f38399a = null;

    /* renamed from: b */
    private static final int f38400b = 100;

    /* renamed from: c */
    private ArrayList<View> f38401c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<WebViewToolModel> f38402d;

    /* renamed from: e */
    private WebViewToolDialog f38403e;

    /* access modifiers changed from: protected */
    public void onCreateAfter(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onCreateBefore(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        onCreateBefore(bundle);
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.common_status_background));
        try {
            super.onCreate(bundle);
            if (this.mWebTitleBar == null) {
                finish();
                return;
            }
            if (this.mWebTitleBar != null) {
                this.mWebTitleBar.getMiddleTv().setTypeface(Typeface.DEFAULT_BOLD);
                this.mWebTitleBar.getMiddleTv().performClick();
                this.mWebTitleBar.getLeftImgView().setContentDescription(getResources().getString(R.string.description_title_back));
                this.mWebTitleBar.setTitleBarLineVisible(0);
            }
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            onCreateAfter(bundle);
        } catch (Exception e) {
            if (workaroundException(e)) {
                finish();
                return;
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1006 || i == 1005) {
            this.mFileChooserManager.onActivityResult(i, i2, intent);
        } else if (i == 100 || i == 101) {
            if (i2 == -1) {
                ((DidiBridgeModule) getWebView().getExportModuleInstance(FusionBridgeModule.class)).handleChooseImageResult(i, i2, intent);
            }
        } else if (i == 102) {
            ContactModule contactModule = (ContactModule) this.mWebView.getExportModuleInstance(ContactModule.class);
            if (contactModule != null) {
                contactModule.handleContactResult(i2, intent);
            }
        } else if (i == 10103 || i == 10104) {
            ShareApi.handleShareActivityResult(i, i, intent);
        }
    }

    public void updateUI(final String str, final Object... objArr) {
        super.updateUI(str, objArr);
        if (!TextUtils.isEmpty(str)) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Object[] objArr;
                    Object[] objArr2;
                    if (!"web_title".equals(str) || (objArr2 = objArr) == null || !(objArr2[0] instanceof String)) {
                        if (ShareEntranceModule.UI_TARGET_INIT_ENTRANCE.equals(str) && (objArr = objArr) != null && (objArr[0] instanceof List)) {
                            List unused = WebActivity.this.f38402d = (List) objArr[0];
                        } else if (ShareEntranceModule.UI_TARGET_SHOW_ENTRANCE.equals(str)) {
                            Object[] objArr3 = objArr;
                            WebActivity.this.showEntrance((CallbackFunction) objArr3[0], (String) objArr3[1]);
                        } else if (ShareEntranceModule.UI_TARGET_INVOKE_ENTRANCE.equals(str)) {
                            WebActivity.this.invokeEntrance((CallbackFunction) objArr[0]);
                        } else if (ShareEntranceModule.UI_TARGET_HIDE_ENTRANCE.equals(str)) {
                            WebActivity.this.hideEntrance();
                        } else if (ShareEntranceModule.UI_TARGET_ISBACKGROUND.equals(str)) {
                            WebActivity.this.viewBackgroundCallbackFunction = (CallbackFunction) objArr[0];
                        }
                    } else if (WebActivity.this.mFusionWebModel.canChangeWebViewTitle || TextUtils.isEmpty(WebActivity.this.mFusionWebModel.title)) {
                        WebActivity.this.mWebTitleBar.setTitleName((String) objArr[0]);
                        WebActivity.this.mTitleByJs = true;
                    }
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        WebViewToolDialog webViewToolDialog = this.f38403e;
        if (webViewToolDialog != null) {
            webViewToolDialog.dismissH5Dialog();
        }
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void invokeEntrance() {
        invokeEntrance((CallbackFunction) null);
    }

    /* access modifiers changed from: protected */
    public void invokeEntrance(CallbackFunction callbackFunction) {
        invokeEntrance(callbackFunction, "");
    }

    /* access modifiers changed from: protected */
    public void invokeEntrance(final CallbackFunction callbackFunction, final String str) {
        this.f38403e = new WebViewToolDialog();
        List<WebViewToolModel> list = this.f38402d;
        if (list == null || list.isEmpty()) {
            finishWithResultCodeOK();
            return;
        }
        OmegaWebUtil.trackSharePagedShow(this.f38402d, getWebView().getUrl());
        final JSONObject jSONObject = new JSONObject();
        this.f38403e.showShareFragment(this, this.f38402d, new ICallback.IH5ShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                WebActivity.this.m27169a(sharePlatform.platformName(), str, jSONObject, 0, callbackFunction);
            }

            public void onError(SharePlatform sharePlatform) {
                WebActivity.this.m27169a(sharePlatform.platformName(), str, jSONObject, 1, callbackFunction);
            }

            public void onCancel(SharePlatform sharePlatform) {
                WebActivity.this.m27169a(sharePlatform.platformName(), str, jSONObject, 2, callbackFunction);
            }

            public void onRefresh() {
                WebActivity.this.mWebView.reload();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27169a(String str, String str2, JSONObject jSONObject, int i, CallbackFunction callbackFunction) {
        try {
            jSONObject.put("share_result", i);
            jSONObject.put("channel", ShareModule.getChannelName(str));
        } catch (JSONException unused) {
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
        }
        if (!TextUtils.isEmpty(str2)) {
            getFusionBridge().callH5Method(str2, jSONObject.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void showEntrance(final CallbackFunction callbackFunction, final String str) {
        List<WebViewToolModel> list = this.f38402d;
        if (list != null && !list.isEmpty()) {
            this.mWebTitleBar.setMoreBtnVisibility(0);
            this.mWebTitleBar.setOnMoreClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebActivity.this.invokeEntrance(callbackFunction, str);
                }
            });
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(FusionTitlebarRightTextEvent fusionTitlebarRightTextEvent) {
        if (!(fusionTitlebarRightTextEvent == null || fusionTitlebarRightTextEvent.data == null)) {
            String optString = fusionTitlebarRightTextEvent.data.optString("txt", (String) null);
            if (!TextUtils.isEmpty(optString)) {
                this.mWebTitleBar.setRightText(optString);
                return;
            }
        }
        this.mWebTitleBar.setRightVisible(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(final FusionTitlebarRightClickEvent fusionTitlebarRightClickEvent) {
        if (fusionTitlebarRightClickEvent != null && fusionTitlebarRightClickEvent.func != null) {
            this.mWebTitleBar.setRightClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    fusionTitlebarRightClickEvent.func.onCallBack(new Object[0]);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public FusionBridgeModule getFusionBridge() {
        if (this.mWebView == null) {
            return null;
        }
        return (ExtendFusionBridgeModule) this.mWebView.getExportModuleInstance(ExtendFusionBridgeModule.class);
    }

    public boolean goBack(final boolean z) {
        if (InterceptGoBackMgr.checkToIntercept(this, new InterceptGoBackMgr.GoBackCallback() {
            public void goBack() {
                boolean unused = WebActivity.super.goBack(z);
            }
        })) {
            return false;
        }
        InterceptGoBackMgr.cleanData();
        return super.goBack(z);
    }

    public void addViewToTitleBar(View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.mWebTitleBar != null && view != null) {
            this.mWebTitleBar.addView(view, layoutParams);
            this.f38401c.add(view);
        }
    }

    public void removeViewFromTitleBar(Object obj) {
        ArrayList<View> arrayList;
        if (this.mWebTitleBar != null && (arrayList = this.f38401c) != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getTag() == obj) {
                    this.f38401c.remove(next);
                    this.mWebTitleBar.removeView(next);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 100) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    f38399a.onPermissionReject(strArr[i2]);
                } else {
                    f38399a.onPermissionGranted();
                }
            }
        }
    }

    public void request(String[] strArr, PermissionCallback permissionCallback) {
        f38399a = permissionCallback;
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(strArr, 100);
        }
    }

    public void updateTitleBar(String str, String str2, int i, int i2) {
        if (this.mWebTitleBar != null) {
            this.mWebTitleBar.updateTitleBar(str, str2, i, i2);
            if (Build.VERSION.SDK_INT >= 21 && !TextUtils.isEmpty(str)) {
                getWindow().setStatusBarColor(Color.parseColor(str));
            }
        }
    }
}
