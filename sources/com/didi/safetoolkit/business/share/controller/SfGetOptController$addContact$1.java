package com.didi.safetoolkit.business.share.controller;

import android.text.TextUtils;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.sdk.util.ToastHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/safetoolkit/business/share/controller/SfGetOptController$addContact$1", "Lcom/didi/safetoolkit/business/contacts/store/SfContactsManageStore$Callback;", "onError", "", "data", "Lcom/didi/safetoolkit/business/contacts/model/SfContactsManageModel;", "onSuccess", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfGetOptController.kt */
public final class SfGetOptController$addContact$1 implements SfContactsManageStore.Callback {
    final /* synthetic */ SfGetOptController this$0;

    SfGetOptController$addContact$1(SfGetOptController sfGetOptController) {
        this.this$0 = sfGetOptController;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.safetoolkit.business.contacts.model.SfContactsManageModel r7) {
        /*
            r6 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            com.didi.safetoolkit.business.share.controller.SfGetOptController r1 = r6.this$0
            com.didi.safetoolkit.business.share.SfContractOptIView r1 = com.didi.safetoolkit.business.share.controller.SfGetOptController.access$getMView$p(r1)
            boolean r1 = r1 instanceof com.didi.safetoolkit.base.BaseSafeToolkitActivity
            if (r1 == 0) goto L_0x0028
            com.didi.safetoolkit.business.share.controller.SfGetOptController r1 = r6.this$0
            com.didi.safetoolkit.business.share.SfContractOptIView r1 = com.didi.safetoolkit.business.share.controller.SfGetOptController.access$getMView$p(r1)
            if (r1 == 0) goto L_0x0020
            com.didi.safetoolkit.base.BaseSafeToolkitActivity r1 = (com.didi.safetoolkit.base.BaseSafeToolkitActivity) r1
            boolean r1 = r1.isDestory()
            if (r1 == 0) goto L_0x0028
            return
        L_0x0020:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type com.didi.safetoolkit.base.BaseSafeToolkitActivity"
            r7.<init>(r0)
            throw r7
        L_0x0028:
            com.didi.safetoolkit.business.share.controller.SfGetOptController r1 = r6.this$0
            r1.hideLoading()
            r1 = 0
            android.content.Intent r1 = (android.content.Intent) r1
            com.didi.safetoolkit.business.share.controller.SfGetOptController r2 = r6.this$0
            android.content.Context r2 = r2.getContext()
            boolean r2 = com.didi.safetoolkit.util.SfAppUtils.isBrazilPackage(r2)
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x008f
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r2 = r7.datas
            if (r2 == 0) goto L_0x008f
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r2 = r7.datas
            if (r2 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0049:
            java.util.List<com.didi.safetoolkit.model.SfContactsModel> r2 = r2.needAreaCodeContacts
            if (r2 == 0) goto L_0x008f
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r2 = r7.datas
            if (r2 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0054:
            java.util.List<com.didi.safetoolkit.model.SfContactsModel> r2 = r2.needAreaCodeContacts
            if (r2 != 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x005b:
            java.lang.String r5 = "data.datas!!.needAreaCodeContacts!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x008f
            com.didi.safetoolkit.business.share.controller.SfGetOptController r0 = r6.this$0
            int r0 = r0.whereFrom
            if (r0 != r4) goto L_0x0074
            r0 = 150(0x96, float:2.1E-43)
            goto L_0x0075
        L_0x0074:
            r0 = 0
        L_0x0075:
            com.didi.safetoolkit.business.sdk.SafeToolKit r2 = com.didi.safetoolkit.business.sdk.SafeToolKit.getIns()
            com.didi.safetoolkit.business.share.controller.SfGetOptController r5 = r6.this$0
            android.content.Context r5 = r5.getContext()
            if (r5 == 0) goto L_0x0087
            android.app.Activity r5 = (android.app.Activity) r5
            r2.startAreaCodeAddPage(r5, r0, r7)
            goto L_0x00c3
        L_0x0087:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
            r7.<init>(r0)
            throw r7
        L_0x008f:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r5 = r7.datas
            if (r5 == 0) goto L_0x00ba
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r5 = r7.datas
            if (r5 != 0) goto L_0x00a4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a4:
            java.util.List<com.didi.safetoolkit.model.SfContactsModel> r5 = r5.contacts
            if (r5 == 0) goto L_0x00ba
            com.didi.safetoolkit.business.contacts.model.SfContactsManageModel$SfContactsDatas r7 = r7.datas
            if (r7 != 0) goto L_0x00af
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00af:
            java.util.List<com.didi.safetoolkit.model.SfContactsModel> r7 = r7.contacts
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.io.Serializable r7 = (java.io.Serializable) r7
            java.lang.String r5 = "list"
            r2.putSerializable(r5, r7)
        L_0x00ba:
            android.content.Intent r7 = r1.putExtra(r0, r2)
            java.lang.String r0 = "intent.putExtra(\"data\", bundle)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
        L_0x00c3:
            com.didi.safetoolkit.business.share.controller.SfGetOptController r7 = r6.this$0
            int r7 = r7.whereFrom
            if (r7 != r4) goto L_0x00e9
            java.lang.Class<com.didi.safetoolkit.api.ISfContactCallbackService> r7 = com.didi.safetoolkit.api.ISfContactCallbackService.class
            com.didi.safetoolkit.business.sdk.SafeToolKit r0 = com.didi.safetoolkit.business.sdk.SafeToolKit.getIns()
            java.lang.String r2 = "SafeToolKit.getIns()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            java.lang.String r0 = r0.getBusinessType()
            com.didichuxing.foundation.spi.ServiceLoader r7 = com.didichuxing.foundation.spi.ServiceLoader.load(r7, r0)
            java.lang.Object r7 = r7.get()
            com.didi.safetoolkit.api.ISfContactCallbackService r7 = (com.didi.safetoolkit.api.ISfContactCallbackService) r7
            if (r7 == 0) goto L_0x00e9
            r7.onNewTrustedContactAdded(r3)
        L_0x00e9:
            com.didi.safetoolkit.business.share.controller.SfGetOptController r7 = r6.this$0
            android.content.Context r7 = r7.getContext()
            if (r7 == 0) goto L_0x00fc
            com.didi.safetoolkit.business.share.controller.SfGetOptController r7 = r6.this$0
            android.content.Context r7 = r7.getContext()
            java.lang.String r0 = "sf_add_contacts_success"
            com.didi.safetoolkit.util.BroadcastUtil.sendBroadcast(r7, r0)
        L_0x00fc:
            if (r1 != 0) goto L_0x0103
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
        L_0x0103:
            com.didi.safetoolkit.business.share.controller.SfGetOptController r7 = r6.this$0
            r7.setResultAndFinish(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.business.share.controller.SfGetOptController$addContact$1.onSuccess(com.didi.safetoolkit.business.contacts.model.SfContactsManageModel):void");
    }

    public void onError(SfContactsManageModel sfContactsManageModel) {
        Intrinsics.checkParameterIsNotNull(sfContactsManageModel, "data");
        this.this$0.hideLoading();
        if (this.this$0.getContext() != null && !TextUtils.isEmpty(sfContactsManageModel.errmsg)) {
            ToastHelper.showShortCompleted(this.this$0.getContext(), sfContactsManageModel.errmsg);
        }
    }
}
