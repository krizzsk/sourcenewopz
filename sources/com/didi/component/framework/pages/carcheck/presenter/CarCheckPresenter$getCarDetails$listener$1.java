package com.didi.component.framework.pages.carcheck.presenter;

import com.didi.component.framework.pages.carcheck.view.CarCheckView;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/component/framework/pages/carcheck/presenter/CarCheckPresenter$getCarDetails$listener$1", "Lcom/didi/travel/psnger/common/net/base/ITravelOrderListener;", "onError", "", "p0", "", "p1", "", "onFail", "onSuccess", "order", "Lcom/didi/travel/psnger/core/model/response/ICarOrder;", "onTimeout", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckPresenter.kt */
public final class CarCheckPresenter$getCarDetails$listener$1 implements ITravelOrderListener {
    final /* synthetic */ CarCheckPresenter this$0;

    public void onError(int i, String str) {
    }

    public void onFail(int i, String str) {
    }

    public void onTimeout(String str) {
    }

    CarCheckPresenter$getCarDetails$listener$1(CarCheckPresenter carCheckPresenter) {
        this.this$0 = carCheckPresenter;
    }

    public void onSuccess(ICarOrder iCarOrder) {
        DTSDKDriverModel dTSDKDriverModel;
        String str;
        CarCheckView carCheckView;
        String str2 = null;
        CarOrder carOrder = iCarOrder instanceof CarOrder ? (CarOrder) iCarOrder : null;
        if (carOrder == null) {
            dTSDKDriverModel = null;
        } else {
            dTSDKDriverModel = carOrder.carDriver;
        }
        if (dTSDKDriverModel == null) {
            str = null;
        } else {
            str = dTSDKDriverModel.card;
        }
        if (dTSDKDriverModel != null) {
            str2 = dTSDKDriverModel.carType;
        }
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && (carCheckView = (CarCheckView) this.this$0.mView) != null) {
                carCheckView.initCarDetails(str, str2);
            }
        }
    }
}
