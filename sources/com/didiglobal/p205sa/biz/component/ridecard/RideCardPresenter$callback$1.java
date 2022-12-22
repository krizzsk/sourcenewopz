package com.didiglobal.p205sa.biz.component.ridecard;

import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineLoggerUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didiglobal/sa/biz/component/ridecard/RideCardPresenter$callback$1", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "onFailed", "", "scene", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardPresenter$callback$1 */
/* compiled from: RideCardPresenter.kt */
public final class RideCardPresenter$callback$1 implements XEResponseCallback {
    final /* synthetic */ RideCardPresenter this$0;

    RideCardPresenter$callback$1(RideCardPresenter rideCardPresenter) {
        this.this$0 = rideCardPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a7 A[Catch:{ Exception -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.String r4, com.didiglobal.enginecore.data.model.XEngineData r5, java.util.List<? extends com.didiglobal.enginecore.component.XEComponent> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "normal"
            java.lang.String r1 = "scene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r4 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r1 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            com.didiglobal.sa.biz.component.xengine.SAXEngineLoggerUtils r6 = com.didiglobal.p205sa.biz.component.xengine.SAXEngineLoggerUtils.INSTANCE
            java.lang.String r1 = "ridercard onSuccess"
            r6.info(r1)
            com.didiglobal.sa.biz.component.xengine.SAXEngineLoggerUtils r6 = com.didiglobal.p205sa.biz.component.xengine.SAXEngineLoggerUtils.INSTANCE
            java.lang.String r1 = "ridercard data "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r5)
            r6.info(r1)
            com.didiglobal.sa.biz.component.ridecard.RideCardPresenter r6 = r3.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba }
            r1.<init>()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r2 = r5.traceId     // Catch:{ Exception -> 0x00ba }
            r1.append(r2)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r2 = " json = "
            r1.append(r2)     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonObject r2 = r5.jsonObject     // Catch:{ Exception -> 0x00ba }
            r1.append(r2)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ba }
            r6.m36576a(r1)     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonObject r6 = r5.jsonObject     // Catch:{ Exception -> 0x00ba }
            if (r6 == 0) goto L_0x00be
            com.google.gson.JsonObject r6 = r5.jsonObject     // Catch:{ Exception -> 0x00ba }
            boolean r6 = r6.has(r0)     // Catch:{ Exception -> 0x00ba }
            if (r6 == 0) goto L_0x00be
            com.google.gson.JsonObject r6 = r5.jsonObject     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonElement r6 = r6.get(r0)     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonObject r6 = r6.getAsJsonObject()     // Catch:{ Exception -> 0x00ba }
            boolean r6 = r6.has(r4)     // Catch:{ Exception -> 0x00ba }
            if (r6 == 0) goto L_0x00be
            com.google.gson.JsonObject r5 = r5.jsonObject     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonElement r5 = r5.get(r0)     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonElement r4 = r5.get(r4)     // Catch:{ Exception -> 0x00ba }
            com.google.gson.JsonObject r4 = r4.getAsJsonObject()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "data.jsonObject.get(\"nor….get(\"data\").asJsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00ba }
            java.lang.Class<com.didiglobal.sa.biz.component.ridecard.model.RideCardModel> r5 = com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel.class
            java.lang.reflect.Type r5 = (java.lang.reflect.Type) r5     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r4 = com.didiglobal.p205sa.biz.util.GsonUtils.fromJson(r4, r5)     // Catch:{ Exception -> 0x00ba }
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel r4 = (com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel) r4     // Catch:{ Exception -> 0x00ba }
            com.didiglobal.sa.biz.component.ridecard.RideCardPresenter r5 = r3.this$0     // Catch:{ Exception -> 0x00ba }
            java.lang.String r6 = "event_home_update"
            r5.doPublish(r6, r4)     // Catch:{ Exception -> 0x00ba }
            com.didiglobal.sa.biz.component.ridecard.RideCardPresenter r5 = r3.this$0     // Catch:{ Exception -> 0x00ba }
            com.didi.component.never.core.IView r5 = r5.mView     // Catch:{ Exception -> 0x00ba }
            com.didiglobal.sa.biz.component.ridecard.RideCardView r5 = (com.didiglobal.p205sa.biz.component.ridecard.RideCardView) r5     // Catch:{ Exception -> 0x00ba }
            r5.setDate(r4)     // Catch:{ Exception -> 0x00ba }
            r5 = 0
            if (r4 != 0) goto L_0x0098
        L_0x0096:
            r6 = r5
            goto L_0x009f
        L_0x0098:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Map r6 = r4.map     // Catch:{ Exception -> 0x00ba }
            if (r6 != 0) goto L_0x009d
            goto L_0x0096
        L_0x009d:
            java.lang.String r6 = r6.businessid     // Catch:{ Exception -> 0x00ba }
        L_0x009f:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00ba }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00ba }
            if (r6 != 0) goto L_0x00be
            com.didiglobal.sa.biz.component.ridecard.RideCardPresenter r6 = r3.this$0     // Catch:{ Exception -> 0x00ba }
            if (r4 != 0) goto L_0x00ac
            goto L_0x00b3
        L_0x00ac:
            com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Map r4 = r4.map     // Catch:{ Exception -> 0x00ba }
            if (r4 != 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            java.lang.String r5 = r4.businessid     // Catch:{ Exception -> 0x00ba }
        L_0x00b3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ Exception -> 0x00ba }
            r6.f51052c = r5     // Catch:{ Exception -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.ridecard.RideCardPresenter$callback$1.onSuccess(java.lang.String, com.didiglobal.enginecore.data.model.XEngineData, java.util.List):void");
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(engineErrorException, "e");
        SAXEngineLoggerUtils.INSTANCE.info("ridercard onFailed");
        engineErrorException.printStackTrace();
    }
}
