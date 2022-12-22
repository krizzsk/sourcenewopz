package com.didi.soda.home.feedback;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.flutter.plugin.CustomerBasePlugin;
import com.didi.soda.home.feedback.GetPhotoPlugin;
import com.didi.soda.router.DiRouter;
import com.didi.soda.web.WebFusionCallback;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.PhotoJsBridgeData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/home/feedback/GetPhotoPlugin;", "Lcom/didi/soda/customer/flutter/plugin/CustomerBasePlugin;", "()V", "mChannel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "CallBack", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetPhotoPlugin.kt */
public final class GetPhotoPlugin extends CustomerBasePlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private MethodChannel f42639a;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/home/feedback/GetPhotoPlugin$CallBack;", "", "onFailed", "", "errorMsg", "", "onSuccess", "base64Str", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GetPhotoPlugin.kt */
    public interface CallBack {
        void onFailed(String str);

        void onSuccess(String str);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) WebConstant.BridgeMethod.GET_PHOTO)) {
            PhotoJsBridgeData.GetPhotoData defaultPhotoData = Companion.getDefaultPhotoData();
            String str = (String) methodCall.argument("type");
            if (str != null) {
                defaultPhotoData.setType(str);
            }
            Boolean bool = (Boolean) methodCall.argument("cut");
            if (bool != null) {
                defaultPhotoData.setCut(bool.booleanValue());
            }
            String str2 = (String) methodCall.argument("ext");
            if (str2 != null) {
                defaultPhotoData.setExt(str2);
            }
            Double d = (Double) methodCall.argument("imageQuality");
            if (d != null) {
                defaultPhotoData.setQuality((float) d.doubleValue());
            }
            JSONObject jSONObject = (JSONObject) methodCall.argument(Const.BlockParamConst.RESIZE);
            if (jSONObject != null) {
                defaultPhotoData.getResize().setWidth(jSONObject.optInt("width"));
                defaultPhotoData.getResize().setHeight(jSONObject.optInt("height"));
            }
            Companion.getPhotoString(defaultPhotoData, new GetPhotoPlugin$onMethodCall$6(result));
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/feedback/GetPhotoPlugin$Companion;", "", "()V", "getDefaultPhotoData", "Lcom/didi/soda/web/model/PhotoJsBridgeData$GetPhotoData;", "getImageStringByPhoto", "", "srcStr", "getPhotoString", "", "data", "callBack", "Lcom/didi/soda/home/feedback/GetPhotoPlugin$CallBack;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GetPhotoPlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PhotoJsBridgeData.GetPhotoData getDefaultPhotoData() {
            PhotoJsBridgeData.GetPhotoData getPhotoData = new PhotoJsBridgeData.GetPhotoData();
            getPhotoData.setType("choice");
            getPhotoData.setCut(true);
            getPhotoData.setExt(FileUtil.JPG);
            getPhotoData.setQuality(1.0f);
            getPhotoData.setResize(new PhotoJsBridgeData.GetPhotoData.PicSize());
            getPhotoData.getResize().setWidth(200);
            getPhotoData.getResize().setHeight(200);
            return getPhotoData;
        }

        public final String getImageStringByPhoto(String str) {
            Intrinsics.checkNotNullParameter(str, "srcStr");
            CharSequence charSequence = str;
            if (TextUtils.isEmpty(charSequence) || !StringsKt.contains$default(charSequence, (CharSequence) Const.ImageUpload.STR_PREFIX, false, 2, (Object) null)) {
                return null;
            }
            Object[] array = StringsKt.split$default(charSequence, new String[]{Const.ImageUpload.STR_PREFIX}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                return ((String[]) array)[1];
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final void getPhotoString(PhotoJsBridgeData.GetPhotoData getPhotoData, CallBack callBack) {
            Intrinsics.checkNotNullParameter(getPhotoData, "data");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            WebFusionCallback.getInstance().bindCallbackWithName(WebConstant.BridgeMethod.GET_PHOTO, new CallbackFunction() {
                public final void onCallBack(Object[] objArr) {
                    GetPhotoPlugin.Companion.m46956getPhotoString$lambda0(GetPhotoPlugin.CallBack.this, objArr);
                }
            });
            DiRouter.request().path("WebPage/Transfer_Page").putSerializable(WebConstant.Transfer.TRANSFER_PAGE_DATA, getPhotoData).open();
        }

        /* access modifiers changed from: private */
        /* renamed from: getPhotoString$lambda-0  reason: not valid java name */
        public static final void m46956getPhotoString$lambda0(CallBack callBack, Object[] objArr) {
            String str;
            Intrinsics.checkNotNullParameter(callBack, "$callBack");
            boolean z = true;
            if (objArr != null) {
                if (!(objArr.length == 0)) {
                    z = false;
                }
            }
            if (z || !(objArr[0] instanceof JSONObject)) {
                str = "";
            } else {
                JSONObject jSONObject = objArr[0];
                if (jSONObject != null) {
                    JSONObject jSONObject2 = jSONObject;
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject == null) {
                        str = jSONObject2.optString("errmsg");
                        Intrinsics.checkNotNullExpressionValue(str, "jObject.optString(\"errmsg\")");
                    } else {
                        String optString = optJSONObject.optString("image");
                        Intrinsics.checkNotNullExpressionValue(optString, "photoBase64");
                        callBack.onSuccess(optString);
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
            callBack.onFailed(str);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/get_photo_plugin", JSONMethodCodec.INSTANCE);
        this.f42639a = methodChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f42639a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f42639a = null;
    }
}
