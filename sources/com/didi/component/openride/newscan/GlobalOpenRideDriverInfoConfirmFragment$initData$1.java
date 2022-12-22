package com.didi.component.openride.newscan;

import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.taxis99.R;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalOpenRideDriverInfoConfirmFragment.kt */
final class GlobalOpenRideDriverInfoConfirmFragment$initData$1 implements View.OnClickListener {
    final /* synthetic */ PinCodeInfoResult $result;
    final /* synthetic */ GlobalOpenRideDriverInfoConfirmFragment this$0;

    GlobalOpenRideDriverInfoConfirmFragment$initData$1(GlobalOpenRideDriverInfoConfirmFragment globalOpenRideDriverInfoConfirmFragment, PinCodeInfoResult pinCodeInfoResult) {
        this.this$0 = globalOpenRideDriverInfoConfirmFragment;
        this.$result = pinCodeInfoResult;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.g_driver_info_pop_close) {
            GlobalOpenRideQRScanPresenter access$getMOpenRidePresenter$p = this.this$0.f14730b;
            if (access$getMOpenRidePresenter$p != null) {
                PinCodeInfoResult pinCodeInfoResult = this.$result;
                access$getMOpenRidePresenter$p.notifyDriverStateOfPsg(2, pinCodeInfoResult == null ? null : pinCodeInfoResult.driverId);
            }
            GlobalOmegaUtils.trackEvent("Pas_99GO_drivermatch_wrong_ck");
            this.this$0.scanResume();
            return;
        }
        this.this$0.scanResume();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE);
        if (SaApolloUtil.INSTANCE.getSaState()) {
            Bundle bundle = new Bundle();
            if (FormStore.getInstance().getDriverInfo() != null) {
                bundle.putString("driverInfoLat", FormStore.getInstance().getDriverInfo().driverLat);
                bundle.putString("driverInfoLng", FormStore.getInstance().getDriverInfo().driverLng);
            }
            EventBus.getDefault().post(bundle);
        }
        if (FormStore.getInstance().isOpenRideFromDeepLink()) {
            FormStore.getInstance().setIsOpenRideFromDeepLink(false);
        }
        GlobalOmegaUtils.trackEvent("Pas_99GO_drivermatch_yes_ck");
    }
}
