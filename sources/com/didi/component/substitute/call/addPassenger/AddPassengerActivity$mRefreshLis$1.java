package com.didi.component.substitute.call.addPassenger;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.model.ErrorObject;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "error", "Lcom/didi/component/substitute/call/model/ErrorObject;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPassengerActivity.kt */
final class AddPassengerActivity$mRefreshLis$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ AddPassengerActivity this$0;

    AddPassengerActivity$mRefreshLis$1(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public final void onEvent(String str, ErrorObject errorObject) {
        this.this$0.hideLoading();
        if (errorObject != null) {
            AddPassengerActivity addPassengerActivity = this.this$0;
            if (errorObject.getErrno() == 0) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null && confirmListener.getIsAnyCar()) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
                }
                addPassengerActivity.setResult(-1);
                FormStore.getInstance().setSkipEstimateGet(true);
                addPassengerActivity.finish();
            } else if (!TextUtils.isEmpty(errorObject.getErrmsg())) {
                LEGOToastHelper.showLongNagToast(addPassengerActivity, errorObject.getErrmsg());
            }
        }
    }
}
