package com.wujie.dimina.bridge.plugin.international.share;

import android.view.ViewGroup;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.IDMNavigator;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.ScreenshotUtils;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: InternationalShareSubJSBridge.kt */
final class InternationalShareSubJSBridge$share2ThirdParty$1 implements Runnable {
    final /* synthetic */ CallbackFunction $jsCallback;
    final /* synthetic */ String $platformStr;
    final /* synthetic */ JSONObject $shareObj;
    final /* synthetic */ InternationalShareSubJSBridge this$0;

    InternationalShareSubJSBridge$share2ThirdParty$1(InternationalShareSubJSBridge internationalShareSubJSBridge, String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.this$0 = internationalShareSubJSBridge;
        this.$platformStr = str;
        this.$shareObj = jSONObject;
        this.$jsCallback = callbackFunction;
    }

    public final void run() {
        LogUtil.iRelease("InternationalShareSubJSBridge", "platformStr: " + this.$platformStr + ",  shareObj: " + this.$shareObj);
        OneKeyShareModel access$addParam2ShareModel = InternationalShareSubJSBridge.Companion.addParam2ShareModel(this.$shareObj, new OneKeyShareModel(this.$platformStr));
        if (Intrinsics.areEqual((Object) access$addParam2ShareModel.type, (Object) "webview")) {
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
            access$addParam2ShareModel.imgPath = ScreenshotUtils.getTempBitmapPath(this.this$0.mActivity, webView2, webViewContentHeight);
            access$addParam2ShareModel.imgUrl = "";
        }
        LogUtil.iRelease("InternationalShareSubJSBridge", "oneKeyShareModel : " + access$addParam2ShareModel);
        final JSONObject jSONObject = new JSONObject();
        ShareApi.show(this.this$0.mActivity, access$addParam2ShareModel, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback2(this) {
            final /* synthetic */ InternationalShareSubJSBridge$share2ThirdParty$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onComplete(SharePlatform sharePlatform) {
                LogUtil.m13412i("InternationalShareSubJSBridge", "onComplete()  " + sharePlatform);
                InternationalShareSubJSBridge.createResultJson$default(this.this$0.this$0, this.this$0.$platformStr, jSONObject, this.this$0.$jsCallback, 0, (Integer) null, 16, (Object) null);
            }

            public void onError(SharePlatform sharePlatform, int i) {
                LogUtil.m13412i("InternationalShareSubJSBridge", "onError() " + i + ",  " + sharePlatform);
                this.this$0.this$0.createResultJson(this.this$0.$platformStr, jSONObject, this.this$0.$jsCallback, 1, Integer.valueOf(i));
            }

            public void onError(SharePlatform sharePlatform) {
                LogUtil.m13412i("InternationalShareSubJSBridge", "onError()  " + sharePlatform);
            }

            public void onCancel(SharePlatform sharePlatform) {
                LogUtil.m13412i("InternationalShareSubJSBridge", "onCancel()   " + sharePlatform);
                InternationalShareSubJSBridge.createResultJson$default(this.this$0.this$0, this.this$0.$platformStr, jSONObject, this.this$0.$jsCallback, 2, (Integer) null, 16, (Object) null);
            }
        });
    }
}
