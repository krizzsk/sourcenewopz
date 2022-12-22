package com.didi.safetoolkit.business.toolkit;

import android.app.Activity;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.api.ISfShareService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.ISfToolkitContract;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordOmageUtils;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.sdk.util.SPUtils;
import com.didichuxing.foundation.spi.ServiceLoader;

public class SfToolkitPresenter extends AbsPresenter<SfToolkitDialog> implements ISfToolkitContract.ToolkitPresenter {
    private ISMonitorDetailsService mService;

    public SfToolkitPresenter(SfToolkitDialog sfToolkitDialog) {
        super(sfToolkitDialog);
        SfOmegaUtil.addEventId("gp_safetyToolkit_view_sw").report();
        if (this.mService == null) {
            this.mService = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        }
    }

    public void onShareClick(boolean z) {
        SfOmegaUtil.addEventId("gp_safetyToolkit_shareTrip_ck").report();
        if (z) {
            socialShare();
        } else {
            SafeToolKit.getIns().startSharePage((Activity) getContext(), 100);
        }
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 3);
        }
    }

    private void socialShare() {
        ISfShareService iSfShareService = (ISfShareService) ServiceLoader.load(ISfShareService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfShareService != null) {
            iSfShareService.startSocialShare(((SfToolkitDialog) this.mView).getContext());
        }
    }

    public void onAlertClick() {
        SfOmegaUtil.addEventId("gp_safetyToolkit_eHelp_ck").report();
        SafeToolKit.getIns().startEmergencyAssistanceActivity(getContext());
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 9);
        }
    }

    public void onSafeCenterClick() {
        SfOmegaUtil.addEventId("gp_safetyToolkit_safeCenter_ck").report();
        SafeToolKit.getIns().startSafeCenterPage(getContext());
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 10);
        }
    }

    public void onAudioRecordClick(String str, boolean z) {
        TripRecordOmageUtils.sendTripRecordEnterClickOmega(str);
        SafeToolKit.getIns().startTripRecordingPage(getContext(), str, z);
    }

    public void onAudioRecordClick(String str, SfViewRecordMenuModel sfViewRecordMenuModel) {
        TripRecordOmageUtils.sendTripRecordEnterClickOmega(str);
        SafeToolKit.getIns().startTripRecordingPage(getContext(), str, sfViewRecordMenuModel);
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 5);
        }
    }

    public void onMonitorClick(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        SafeToolKit.getIns().startMonitorDetails(getContext(), sfViewMonitorMenuModel);
        ISMonitorDetailsService iSMonitorDetailsService = this.mService;
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(getContext(), 10);
        }
        SPUtils.put(getContext(), SfViewMenuModel.newIconKey, false);
        SfOmegaUtil.addEventId("user_safetyToolkit_TripMonitoringr_ck").report();
    }
}
