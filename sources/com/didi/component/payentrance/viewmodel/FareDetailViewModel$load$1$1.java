package com.didi.component.payentrance.viewmodel;

import com.didi.component.payentrance.model.FareDetailsModel;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/payentrance/viewmodel/FareDetailViewModel$load$1$1", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "Lcom/didi/component/payentrance/model/FareDetailsModel;", "onError", "", "t", "onFail", "onFinish", "onSuccess", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailViewModel.kt */
public final class FareDetailViewModel$load$1$1 extends ResponseListener<FareDetailsModel> {
    final /* synthetic */ ResponseListener<FareDetailsModel> $proxy;
    final /* synthetic */ FareDetailViewModel this$0;

    FareDetailViewModel$load$1$1(ResponseListener<FareDetailsModel> responseListener, FareDetailViewModel fareDetailViewModel) {
        this.$proxy = responseListener;
        this.this$0 = fareDetailViewModel;
    }

    public void onSuccess(FareDetailsModel fareDetailsModel) {
        String rulesUrl;
        if (!(fareDetailsModel == null || (rulesUrl = fareDetailsModel.getRulesUrl()) == null)) {
            this.this$0.setRulesUrl(rulesUrl);
        }
        this.$proxy.onSuccess(fareDetailsModel);
    }

    public void onError(FareDetailsModel fareDetailsModel) {
        this.$proxy.onError(fareDetailsModel);
    }

    public void onFail(FareDetailsModel fareDetailsModel) {
        this.$proxy.onFail(fareDetailsModel);
    }

    public void onFinish(FareDetailsModel fareDetailsModel) {
        this.$proxy.onFinish(fareDetailsModel);
    }
}
