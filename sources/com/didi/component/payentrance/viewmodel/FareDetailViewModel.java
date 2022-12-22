package com.didi.component.payentrance.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.didi.component.payentrance.model.FareDetailsModel;
import com.didi.component.payentrance.presenter.FareDetailsObtain;
import com.didiglobal.travel.biz.callback.LoadCallbackWrapper;
import com.didiglobal.travel.biz.callback.LoadCallbackWrapperKt;
import com.didiglobal.travel.infra.lifecycle.AndroidViewModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\r\u001a\u00020\u000e2\u001d\u0010\u000f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0013J$\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/component/payentrance/viewmodel/FareDetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "fareDetailsObtain", "Lcom/didi/component/payentrance/presenter/FareDetailsObtain;", "rulesUrl", "", "getRulesUrl", "()Ljava/lang/String;", "setRulesUrl", "(Ljava/lang/String;)V", "load", "", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/biz/callback/LoadCallbackWrapper;", "Lcom/didi/component/payentrance/model/FareDetailsModel;", "Lkotlin/ExtensionFunctionType;", "withRulesUrl", "order", "Lcom/didi/travel/psnger/model/response/CarOrder;", "block", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailViewModel.kt */
public final class FareDetailViewModel extends AndroidViewModel {

    /* renamed from: a */
    private String f15092a = "";

    /* renamed from: b */
    private final FareDetailsObtain f15093b = new FareDetailsObtain();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FareDetailViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final String getRulesUrl() {
        return this.f15092a;
    }

    public final void setRulesUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f15092a = str;
    }

    public final void load(Function1<? super LoadCallbackWrapper<FareDetailsModel>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "supplier");
        LoadCallbackWrapper loadCallbackWrapper = new LoadCallbackWrapper();
        function1.invoke(loadCallbackWrapper);
        this.f15093b.obtainFareDetails(AndroidViewModelKt.getAppContext(this), new FareDetailViewModel$load$1$1(LoadCallbackWrapperKt.simpleRespListener(loadCallbackWrapper), this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if ((r0.length() > 0) != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void withRulesUrl(com.didi.travel.psnger.model.response.CarOrder r6, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r5.f15092a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            if (r0 == 0) goto L_0x0018
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x001f
            goto L_0x00aa
        L_0x001f:
            r2 = 8
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>((int) r2)
            java.util.Map r3 = (java.util.Map) r3
            java.util.Map r2 = com.didiglobal.travel.infra.collection.MapCreator.m47062constructorimpl(r3)
            if (r6 != 0) goto L_0x0030
            r3 = r1
            goto L_0x0032
        L_0x0030:
            java.lang.String r3 = r6.oid
        L_0x0032:
            java.lang.String r4 = "oid"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x003b
            r3 = r1
            goto L_0x0041
        L_0x003b:
            int r3 = r6.productid
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0041:
            java.lang.String r4 = "business_id"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x004a
            r3 = r1
            goto L_0x004c
        L_0x004a:
            java.lang.String r3 = r6.disTrict
        L_0x004c:
            java.lang.String r4 = "district"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x0055
        L_0x0053:
            r3 = r1
            goto L_0x0060
        L_0x0055:
            com.didi.sdk.address.address.entity.Address r3 = r6.startAddress
            if (r3 != 0) goto L_0x005a
            goto L_0x0053
        L_0x005a:
            double r3 = r3.latitude
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
        L_0x0060:
            java.lang.String r4 = "flat"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x0069
        L_0x0067:
            r3 = r1
            goto L_0x0074
        L_0x0069:
            com.didi.sdk.address.address.entity.Address r3 = r6.startAddress
            if (r3 != 0) goto L_0x006e
            goto L_0x0067
        L_0x006e:
            double r3 = r3.longitude
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
        L_0x0074:
            java.lang.String r4 = "flng"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x007d
        L_0x007b:
            r3 = r1
            goto L_0x0088
        L_0x007d:
            com.didi.sdk.address.address.entity.Address r3 = r6.endAddress
            if (r3 != 0) goto L_0x0082
            goto L_0x007b
        L_0x0082:
            double r3 = r3.latitude
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
        L_0x0088:
            java.lang.String r4 = "tlat"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r4, r3)
            if (r6 != 0) goto L_0x0090
            goto L_0x009b
        L_0x0090:
            com.didi.sdk.address.address.entity.Address r6 = r6.endAddress
            if (r6 != 0) goto L_0x0095
            goto L_0x009b
        L_0x0095:
            double r3 = r6.longitude
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x009b:
            java.lang.String r6 = "tlng"
            com.didiglobal.travel.infra.collection.MapCreator.m47067kvNotNullimpl(r2, r6, r1)
            java.lang.String r6 = com.didi.component.business.web.GlobalWebUrl.buildUrl(r0, r2)
            if (r6 != 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            r7.invoke(r6)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.viewmodel.FareDetailViewModel.withRulesUrl(com.didi.travel.psnger.model.response.CarOrder, kotlin.jvm.functions.Function1):void");
    }
}
