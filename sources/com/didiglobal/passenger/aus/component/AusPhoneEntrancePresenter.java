package com.didiglobal.passenger.aus.component;

import com.didi.component.business.constant.BizConstants;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.core.ComponentParams;
import com.didi.component.phoneentrance.AbsPhoneEntrancePresenter;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.taxis99.R;

public class AusPhoneEntrancePresenter extends AbsPhoneEntrancePresenter {
    public AusPhoneEntrancePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void expiredDialog() {
        if (this.isGotoHelpCenter) {
            super.expiredDialog();
        } else if (getHost() != null) {
            GlobalOmegaUtils.trackEvent("call_after_trip_sw");
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(100);
            normalDialogInfo.setMessage(this.mContext.getString(R.string.global_phone_expired_email_content, new Object[]{BizConstants.AUS.CUSTOM_SERVICE_EMAIL}));
            normalDialogInfo.setIcon(AlertController.IconType.INFO);
            normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_email_connect_custom_service));
            normalDialogInfo.setNegativeText(this.mContext.getString(R.string.cancel));
            normalDialogInfo.setCancelable(true);
            showDialog(normalDialogInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (this.isGotoHelpCenter && this.isDriverAllowContact) {
            super.onDialogAction(i, i2);
        } else if (i == 100) {
            dismissDialog(100);
            if (2 == i2) {
                GlobalOmegaUtils.trackEvent("call_after_trip_send_ck");
                try {
                    actionEmail(BizConstants.AUS.CUSTOM_SERVICE_EMAIL, "", "");
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastHelper.showLongCompleted(this.mContext, (int) R.string.global_open_emailbox_fail);
                }
            } else if (1 == i2) {
                GlobalOmegaUtils.trackEvent("call_after_trip_cancel_ck");
            }
        }
    }
}
