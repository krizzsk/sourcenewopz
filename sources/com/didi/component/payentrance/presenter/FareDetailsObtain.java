package com.didi.component.payentrance.presenter;

import android.content.Context;
import com.didi.component.common.net.CarRequest;
import com.didi.component.payentrance.model.FareDetailsModel;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/payentrance/presenter/FareDetailsObtain;", "", "()V", "obtainFareDetails", "", "context", "Landroid/content/Context;", "listener", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "Lcom/didi/component/payentrance/model/FareDetailsModel;", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsObtain.kt */
public final class FareDetailsObtain {
    public final void obtainFareDetails(Context context, ResponseListener<FareDetailsModel> responseListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseListener, "listener");
        CarRequest.getFeeDetails(context, new FareDetailsObtain$obtainFareDetails$1(context, responseListener));
    }
}
