package com.didi.component.savingcenter;

import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/savingcenter/HomeSavingCenterPresenter$doRequest$ability$1", "Lcom/android/didi/bfflib/BffCallBack;", "Lcom/google/gson/JsonObject;", "onFailure", "", "extra", "Lcom/android/didi/bfflib/BffExtra;", "onSuccess", "response", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSavingCenterPresenter.kt */
public final class HomeSavingCenterPresenter$doRequest$ability$1 implements BffCallBack<JsonObject> {
    final /* synthetic */ HomeSavingCenterPresenter this$0;

    HomeSavingCenterPresenter$doRequest$ability$1(HomeSavingCenterPresenter homeSavingCenterPresenter) {
        this.this$0 = homeSavingCenterPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[Catch:{ Exception -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.google.gson.JsonObject r6, com.android.didi.bfflib.BffExtra r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
            java.lang.String r1 = "data"
            if (r6 != 0) goto L_0x0008
        L_0x0006:
            r6 = r0
            goto L_0x0015
        L_0x0008:
            com.google.gson.JsonObject r6 = r6.getAsJsonObject(r1)     // Catch:{ Exception -> 0x0080 }
            if (r6 != 0) goto L_0x000f
            goto L_0x0006
        L_0x000f:
            java.lang.String r2 = "passenger_saving_center"
            com.google.gson.JsonObject r6 = r6.getAsJsonObject(r2)     // Catch:{ Exception -> 0x0080 }
        L_0x0015:
            if (r6 != 0) goto L_0x0023
            com.didi.component.savingcenter.HomeSavingCenterPresenter r6 = r5.this$0     // Catch:{ Exception -> 0x0080 }
            com.didi.component.core.IView r6 = r6.mView     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.ISavingCenterView r6 = (com.didi.component.savingcenter.ISavingCenterView) r6     // Catch:{ Exception -> 0x0080 }
            r6.setVisible(r7)     // Catch:{ Exception -> 0x0080 }
            return
        L_0x0023:
            com.google.gson.JsonObject r2 = r6.getAsJsonObject(r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = "deeplink"
            if (r2 != 0) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            boolean r0 = r2.has(r3)     // Catch:{ Exception -> 0x0080 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0080 }
        L_0x0034:
            r2 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0080 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0080 }
            if (r0 == 0) goto L_0x0067
            com.google.gson.JsonObject r6 = r6.getAsJsonObject(r1)     // Catch:{ Exception -> 0x0080 }
            com.google.gson.JsonElement r6 = r6.get(r3)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r6 = r6.getAsString()     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.HomeSavingCenterPresenter r0 = r5.this$0     // Catch:{ Exception -> 0x0080 }
            com.didi.component.core.IView r0 = r0.mView     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.ISavingCenterView r0 = (com.didi.component.savingcenter.ISavingCenterView) r0     // Catch:{ Exception -> 0x0080 }
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0080 }
            if (r1 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            java.lang.String r1 = "deepLink"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ Exception -> 0x0080 }
            r0.setScanVisible(r2, r6)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0092
        L_0x0067:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0080 }
            r0.<init>()     // Catch:{ Exception -> 0x0080 }
            com.google.gson.JsonElement r6 = (com.google.gson.JsonElement) r6     // Catch:{ Exception -> 0x0080 }
            java.lang.Class<com.didi.component.savingcenter.SavingCenterInfoData> r1 = com.didi.component.savingcenter.SavingCenterInfoData.class
            java.lang.Object r6 = r0.fromJson((com.google.gson.JsonElement) r6, r1)     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.SavingCenterInfoData r6 = (com.didi.component.savingcenter.SavingCenterInfoData) r6     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.HomeSavingCenterPresenter r0 = r5.this$0     // Catch:{ Exception -> 0x0080 }
            com.didi.component.savingcenter.SavingCenterInfo r6 = r6.getScInfo()     // Catch:{ Exception -> 0x0080 }
            r0.setInfo(r6)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0092
        L_0x0080:
            r6 = move-exception
            r6.printStackTrace()
            com.didi.component.savingcenter.HomeSavingCenterPresenter r6 = r5.this$0
            com.didi.component.core.IView r6 = r6.mView
            com.didi.component.savingcenter.ISavingCenterView r6 = (com.didi.component.savingcenter.ISavingCenterView) r6
            if (r6 != 0) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r6.setVisible(r7)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.savingcenter.HomeSavingCenterPresenter$doRequest$ability$1.onSuccess(com.google.gson.JsonObject, com.android.didi.bfflib.BffExtra):void");
    }

    public void onFailure(BffExtra bffExtra) {
        ((ISavingCenterView) this.this$0.mView).setVisible(false);
    }
}
