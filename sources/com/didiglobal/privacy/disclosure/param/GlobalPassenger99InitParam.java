package com.didiglobal.privacy.disclosure.param;

import com.didiglobal.privacy.disclosure.BasePrivacyDisclosureInitParam;
import com.taxis99.R;

public abstract class GlobalPassenger99InitParam extends BasePrivacyDisclosureInitParam {
    public int getDialogLayoutResInt() {
        return R.layout.global_privacy_disclosure_dialog_passenger;
    }

    public int getNegativeBtnResInt() {
        return R.drawable.global_privacy_btn_disclosure_negative_passenger_selector;
    }

    public int getNegativeBtnTextColor() {
        return -16777216;
    }

    public int getPositionBtnTextColor() {
        return -16777216;
    }

    public int getPositiveBtnResInt() {
        return R.drawable.global_privacy_btn_disclosure_positive_passenger_99_selector;
    }
}
