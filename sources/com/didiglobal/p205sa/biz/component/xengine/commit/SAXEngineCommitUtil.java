package com.didiglobal.p205sa.biz.component.xengine.commit;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didiglobal.p205sa.biz.component.xengine.commit.SAXEngineCommitUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/commit/SAXEngineCommitUtil;", "", "()V", "HOST_XENGINE", "", "SCHEME", "configRouterSkip", "", "context", "Landroid/content/Context;", "btnModel", "Lcom/didi/global/globalgenerickit/config/ButtonModel;", "url", "listener", "Lcom/didiglobal/sa/biz/component/xengine/commit/SAXEngineCommitUtil$RouterFinishedListener;", "RouterFinishedListener", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.commit.SAXEngineCommitUtil */
/* compiled from: SAXEngineCommitUtil.kt */
public final class SAXEngineCommitUtil {
    public static final String HOST_XENGINE = "xengine";
    public static final SAXEngineCommitUtil INSTANCE = new SAXEngineCommitUtil();
    public static final String SCHEME = "satravel";

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/commit/SAXEngineCommitUtil$RouterFinishedListener;", "", "onRouterFinished", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.component.xengine.commit.SAXEngineCommitUtil$RouterFinishedListener */
    /* compiled from: SAXEngineCommitUtil.kt */
    public interface RouterFinishedListener {
        void onRouterFinished();
    }

    private SAXEngineCommitUtil() {
    }

    public final void configRouterSkip(Context context, ButtonModel buttonModel, String str, RouterFinishedListener routerFinishedListener) {
        Uri parse = Uri.parse(str);
        if (parse != null && parse.getHost() != null && parse.getPath() != null) {
            if (Intrinsics.areEqual((Object) parse.getHost(), (Object) "xengine")) {
                String path = parse.getPath();
                Intrinsics.checkNotNull(path);
                Intrinsics.checkNotNullExpressionValue(path, "uri.path!!");
                String str2 = null;
                if (StringsKt.contains$default((CharSequence) path, (CharSequence) "commit", false, 2, (Object) null)) {
                    if (buttonModel != null) {
                        str2 = buttonModel.button_type;
                    }
                    String str3 = "";
                    String str4 = str2 != null ? buttonModel.button_type : str3;
                    if (buttonModel != null) {
                        str3 = buttonModel.f22052id;
                    }
                    ((Request) ((Request) ((Request) DRouter.build(str).putExtra("KEY_COMMIT_ID", str3)).putExtra("KEY_BUTTON_TYPE", str4)).putExtra("key_block_commit_auto_route", true)).start(context, new RouterCallback(context) {
                        public final /* synthetic */ Context f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onResult(Result result) {
                            SAXEngineCommitUtil.m36674a(SAXEngineCommitUtil.RouterFinishedListener.this, this.f$1, result);
                        }
                    });
                    return;
                }
            }
            DRouter.build(str).start(context);
            if (routerFinishedListener != null) {
                routerFinishedListener.onRouterFinished();
            }
        } else if (routerFinishedListener != null) {
            routerFinishedListener.onRouterFinished();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36674a(RouterFinishedListener routerFinishedListener, Context context, Result result) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString("KEY_CALLBACK");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    DRouter.build(optJSONObject.optString("url")).start(context);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (routerFinishedListener != null) {
                routerFinishedListener.onRouterFinished();
            }
        } else if (routerFinishedListener != null) {
            routerFinishedListener.onRouterFinished();
        }
    }
}
