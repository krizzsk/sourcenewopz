package com.didi.component.operationpanel.model;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import kotlin.Metadata;
import p242io.reactivex.SingleOnSubscribe;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012,\u0010\u0002\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u00040\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lkotlin/Pair;", "Lcom/didi/component/business/sharetrip/CommonTripShareManager;", "Lcom/didi/onekeyshare/entity/ShareInfo;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$prepareShare$1<T> implements SingleOnSubscribe {
    final /* synthetic */ Context $context;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ CommonTripShareManager $shareManager;
    final /* synthetic */ OperationPanelModel this$0;

    OperationPanelModel$prepareShare$1(OperationPanelModel operationPanelModel, Context context, Fragment fragment, CommonTripShareManager commonTripShareManager) {
        this.this$0 = operationPanelModel;
        this.$context = context;
        this.$fragment = fragment;
        this.$shareManager = commonTripShareManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if ((r0.length() > 0) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribe(final p242io.reactivex.SingleEmitter<kotlin.Pair<com.didi.component.business.sharetrip.CommonTripShareManager, com.didi.onekeyshare.entity.ShareInfo>> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "emitter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.didi.component.operationpanel.model.OperationPanelModel r0 = r6.this$0
            java.lang.String r0 = r0.f14837c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            if (r0 == 0) goto L_0x001c
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0018
            r2 = 1
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x002e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No available share action commit url"
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r7.tryOnError(r0)
            goto L_0x0040
        L_0x002e:
            com.didi.component.operationpanel.model.OperationPanelModel r1 = r6.this$0
            android.content.Context r2 = r6.$context
            com.didi.component.operationpanel.model.OperationPanelModel$prepareShare$1$1 r3 = new com.didi.component.operationpanel.model.OperationPanelModel$prepareShare$1$1
            androidx.fragment.app.Fragment r4 = r6.$fragment
            com.didi.component.business.sharetrip.CommonTripShareManager r5 = r6.$shareManager
            r3.<init>(r1, r7, r4, r5)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r1.m10622a(r0, r2, r3)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.operationpanel.model.OperationPanelModel$prepareShare$1.subscribe(io.reactivex.SingleEmitter):void");
    }
}
