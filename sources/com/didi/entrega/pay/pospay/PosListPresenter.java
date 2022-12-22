package com.didi.entrega.pay.pospay;

import android.os.Bundle;
import com.didi.entrega.customer.base.ICustomerPresenter;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/pay/pospay/PosListPresenter;", "Lcom/didi/entrega/customer/base/ICustomerPresenter;", "Lcom/didi/entrega/pay/pospay/PosListView;", "()V", "mPosPayInfo", "Lcom/didi/entrega/pay/model/PayMethodInfoModel;", "initData", "", "onCreate", "onSelectPos", "selected", "Lcom/didi/entrega/pay/model/PayMethodInfoModel$CardInfoModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PosListPresenter.kt */
public final class PosListPresenter extends ICustomerPresenter<PosListView> {

    /* renamed from: a */
    private PayMethodInfoModel f21010a;

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r1 = r1.mChannelId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSelectPos(com.didi.entrega.pay.model.PayMethodInfoModel.CardInfoModel r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "selected"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.didi.entrega.pay.model.PayMethodInfoModel r2 = r0.f21010a
            if (r2 == 0) goto L_0x0067
            com.didi.entrega.customer.foundation.rpc.entity.PayChannel r2 = new com.didi.entrega.customer.foundation.rpc.entity.PayChannel
            java.lang.String r4 = r1.cardIndex
            java.lang.String r5 = r1.cardOrg
            java.lang.String r6 = r1.cardSuffix
            com.didi.entrega.pay.model.PayMethodInfoModel r1 = r0.f21010a
            r3 = 0
            if (r1 != 0) goto L_0x001d
        L_0x001b:
            r7 = 0
            goto L_0x0027
        L_0x001d:
            java.lang.String r1 = r1.mChannelId
            if (r1 != 0) goto L_0x0022
            goto L_0x001b
        L_0x0022:
            int r1 = java.lang.Integer.parseInt(r1)
            r7 = r1
        L_0x0027:
            com.didi.entrega.pay.model.PayMethodInfoModel r1 = r0.f21010a
            r3 = 0
            if (r1 != 0) goto L_0x002e
            r8 = r3
            goto L_0x0031
        L_0x002e:
            java.lang.String r1 = r1.mChannelName
            r8 = r1
        L_0x0031:
            com.didi.entrega.pay.model.PayMethodInfoModel r1 = r0.f21010a
            if (r1 != 0) goto L_0x0037
            r9 = r3
            goto L_0x003a
        L_0x0037:
            java.lang.String r1 = r1.mPayTypeDesc
            r9 = r1
        L_0x003a:
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 32704(0x7fc0, float:4.5828E-41)
            r20 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r3 = "payMethodPage"
            r1.putSerializable(r3, r2)
            com.didi.app.nova.skeleton.ScopeContext r2 = r21.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r2 = r2.getNavigator()
            r2.finish(r1)
            goto L_0x0072
        L_0x0067:
            com.didi.app.nova.skeleton.ScopeContext r1 = r21.getScopeContext()
            com.didi.app.nova.skeleton.INavigator r1 = r1.getNavigator()
            r1.finish()
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.pay.pospay.PosListPresenter.onSelectPos(com.didi.entrega.pay.model.PayMethodInfoModel$CardInfoModel):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m15375a();
    }

    /* renamed from: a */
    private final void m15375a() {
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        Serializable serializable = bundle.getSerializable("pos_page_param");
        if (serializable instanceof PayMethodInfoModel) {
            PayMethodInfoModel payMethodInfoModel = (PayMethodInfoModel) serializable;
            this.f21010a = payMethodInfoModel;
            PosListView posListView = (PosListView) getLogicView();
            if (posListView != null) {
                posListView.setTitle(payMethodInfoModel.mPayTypeDesc);
            }
            PosListView posListView2 = (PosListView) getLogicView();
            if (posListView2 != null) {
                posListView2.updateData(payMethodInfoModel.mCardInfoList);
            }
        }
    }
}
