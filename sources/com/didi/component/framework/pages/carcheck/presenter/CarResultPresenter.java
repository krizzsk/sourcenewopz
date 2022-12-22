package com.didi.component.framework.pages.carcheck.presenter;

import android.content.Context;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.carcheck.view.CarResultView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/presenter/CarResultPresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/carcheck/view/CarResultView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getCarCheckResult", "", "oid", "", "questionId", "", "answer", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarResultPresenter.kt */
public final class CarResultPresenter extends IPresenter<CarResultView> {

    /* renamed from: a */
    private final Context f13781a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarResultPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13781a = context;
    }

    public final Context getContext() {
        return this.f13781a;
    }

    public final void getCarCheckResult(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "oid");
        Intrinsics.checkNotNullParameter(str2, "answer");
        CarResultView carResultView = (CarResultView) this.mView;
        if (carResultView != null) {
            carResultView.showLoadingView();
        }
        CarRequest.commitCarCheckResult(this.f13781a, str, i, str2, new CarResultPresenter$getCarCheckResult$1(this));
    }
}
