package com.wujie.dimina.bridge.plugin.international.share;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.IDMNavigator;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.ScreenshotUtils;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: InternationalShareSubJSBridge.kt */
final class InternationalShareSubJSBridge$showShareEntrance$1 implements Runnable {
    final /* synthetic */ CallbackFunction $callback;
    final /* synthetic */ JSONObject $paras;
    final /* synthetic */ InternationalShareSubJSBridge this$0;

    InternationalShareSubJSBridge$showShareEntrance$1(InternationalShareSubJSBridge internationalShareSubJSBridge, JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.this$0 = internationalShareSubJSBridge;
        this.$paras = jSONObject;
        this.$callback = callbackFunction;
    }

    public final void run() {
        ArrayList<OneKeyShareInfo> access$convertShareInfo = this.this$0.convertShareInfo(InternationalShareSubJSBridge.Companion.assembleChannel(this.$paras));
        for (OneKeyShareInfo oneKeyShareInfo : access$convertShareInfo) {
            if (Intrinsics.areEqual((Object) oneKeyShareInfo.type, (Object) "webview")) {
                DMMina dMMina = this.this$0.mDimina;
                Intrinsics.checkExpressionValueIsNotNull(dMMina, "mDimina");
                DMMinaNavigatorDelegate curNavigator = dMMina.getCurNavigator();
                Intrinsics.checkExpressionValueIsNotNull(curNavigator, "mDimina.curNavigator");
                IDMNavigator navigator = curNavigator.getNavigator();
                Intrinsics.checkExpressionValueIsNotNull(navigator, "mDimina.curNavigator.navigator");
                IPageHost currentPage = navigator.getCurrentPage();
                Intrinsics.checkExpressionValueIsNotNull(currentPage, "mDimina.curNavigator.navigator.currentPage");
                DMPage page = currentPage.getPage();
                Intrinsics.checkExpressionValueIsNotNull(page, "mDimina.curNavigator.navigator.currentPage.page");
                DMWebViewContainer webViewContainer = page.getWebViewContainer();
                Intrinsics.checkExpressionValueIsNotNull(webViewContainer, "mDimina.curNavigator.nav…age.page.webViewContainer");
                WebViewEngine webView = webViewContainer.getWebView();
                Intrinsics.checkExpressionValueIsNotNull(webView, "webViewEngine");
                ViewGroup webView2 = webView.getWebView();
                int webViewContentHeight = webView.getWebViewContentHeight();
                Intrinsics.checkExpressionValueIsNotNull(webView2, "webView");
                oneKeyShareInfo.imagePath = ScreenshotUtils.getTempBitmapPath(this.this$0.mActivity, webView2, webViewContentHeight);
                oneKeyShareInfo.imageUrl = "";
            }
        }
        InternationalShareSubJSBridge internationalShareSubJSBridge = this.this$0;
        Activity access$getMActivity$p = internationalShareSubJSBridge.mActivity;
        if (access$getMActivity$p != null) {
            internationalShareSubJSBridge.mShareFragment = ShareBuilder.buildH5Share((FragmentActivity) access$getMActivity$p, access$convertShareInfo, (ICallback.IH5ShareCallback) new ICallback.IH5ShareCallback(this) {
                final /* synthetic */ InternationalShareSubJSBridge$showShareEntrance$1 this$0;

                public void onRefresh() {
                }

                {
                    this.this$0 = r1;
                }

                public void onComplete(SharePlatform sharePlatform) {
                    LogUtil.iRelease("InternationalShareSubJSBridge", "onComplete() " + sharePlatform);
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "success", true);
                    this.this$0.$callback.onCallBack(jSONObject);
                }

                public void onError(SharePlatform sharePlatform) {
                    LogUtil.iRelease("InternationalShareSubJSBridge", "onError() " + sharePlatform);
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "success", false);
                    this.this$0.$callback.onCallBack(jSONObject);
                }

                public void onCancel(SharePlatform sharePlatform) {
                    LogUtil.iRelease("InternationalShareSubJSBridge", "onCancel() " + sharePlatform);
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "success", false);
                    this.this$0.$callback.onCallBack(jSONObject);
                }
            });
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
