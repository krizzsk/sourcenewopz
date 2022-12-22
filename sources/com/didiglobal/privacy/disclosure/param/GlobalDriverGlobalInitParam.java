package com.didiglobal.privacy.disclosure.param;

import android.content.Context;
import com.didiglobal.privacy.disclosure.BasePrivacyDisclosureInitParam;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureDriverDialog;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class GlobalDriverGlobalInitParam extends BasePrivacyDisclosureInitParam {
    public int getDialogLayoutResInt() {
        return R.layout.global_privacy_disclosure_dialog_driver;
    }

    public int getMostDisclosureTimesApolloDefaultValue() {
        return 4;
    }

    public int getNegativeBtnResInt() {
        return R.drawable.global_privacy_btn_disclosure_negative_driver_selector;
    }

    public int getNegativeBtnTextColor() {
        return -10066330;
    }

    public int getPositionBtnTextColor() {
        return -1;
    }

    public PrivacyDisclosureBaseDialog getDialog() {
        return new PrivacyDisclosureDriverDialog();
    }

    public String getPositiveBtnText(Context context) {
        return context == null ? "" : context.getResources().getString(R.string.GDriver_popups_Permission_KinA);
    }

    public String getNegativeBtnText(Context context) {
        return context == null ? "" : context.getResources().getString(R.string.GDriver_popups_Not_allowed_MGUg);
    }

    public Map<String, Integer> getPrivacyTypeIdPermIconMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(PrivacyTypeEnum.LOCATION.getTypeId(), Integer.valueOf(R.drawable.global_privacy_location_icon));
        hashMap.put(PrivacyTypeEnum.READ_CONTACTS.getTypeId(), Integer.valueOf(R.drawable.global_privacy_contact_icon));
        hashMap.put(PrivacyTypeEnum.ALBUM.getTypeId(), Integer.valueOf(R.drawable.global_privacy_album_icon));
        hashMap.put(PrivacyTypeEnum.CAMERA.getTypeId(), Integer.valueOf(R.drawable.global_privacy_camera_icon));
        hashMap.put(PrivacyTypeEnum.RECORD_AUDIO.getTypeId(), Integer.valueOf(R.drawable.global_privacy_record_icon));
        return hashMap;
    }
}
