package com.didi.component.framework.pages.carcheck.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.carcheck.view.CarCheckView;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.psnger.p170v2.TravelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/presenter/CarCheckPresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/carcheck/view/CarCheckView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "commitCheckResult", "", "bundle", "Landroid/os/Bundle;", "getCarDetails", "oid", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckPresenter.kt */
public final class CarCheckPresenter extends IPresenter<CarCheckView> {

    /* renamed from: a */
    private final Context f13780a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarCheckPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13780a = context;
    }

    public final Context getContext() {
        return this.f13780a;
    }

    public final void commitCheckResult(Bundle bundle) {
        CarCheckView carCheckView;
        if (bundle != null && (carCheckView = (CarCheckView) this.mView) != null) {
            carCheckView.jumpToResultPage(bundle);
        }
    }

    public final void getCarDetails(String str) {
        Intrinsics.checkNotNullParameter(str, "oid");
        TravelUtil.getOrderDetail((Session) null, str, new CarCheckPresenter$getCarDetails$listener$1(this));
    }
}
