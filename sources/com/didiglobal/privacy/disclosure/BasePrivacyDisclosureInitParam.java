package com.didiglobal.privacy.disclosure;

import android.content.Context;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class BasePrivacyDisclosureInitParam implements IPrivacyDisclosureInitParam {
    public int getMostDisclosureTimesApolloDefaultValue() {
        return -1;
    }

    public Map<String, String> getPrivacyTypeIdTitleMap() {
        return null;
    }

    public PrivacyDisclosureBaseDialog getDialog() {
        return new PrivacyDisclosureDialog();
    }

    public PrivacyDisclosureBaseDialog getLocalDialog() {
        return new PrivacyDisclosureLocalDialog();
    }

    public String getPositiveBtnText(Context context) {
        return context == null ? "" : context.getResources().getString(R.string.GRider_transformation_Agree_JFdp);
    }

    public String getNegativeBtnText(Context context) {
        return context == null ? "" : context.getResources().getString(R.string.GRider_transformation_Not_yet_rroA);
    }

    public Map<String, Boolean> getPrivacyTypeIdApolloEnableDefautValue() {
        HashMap hashMap = new HashMap();
        hashMap.put(PrivacyTypeEnum.LOCATION.getTypeId(), true);
        hashMap.put(PrivacyTypeEnum.READ_CONTACTS.getTypeId(), true);
        hashMap.put(PrivacyTypeEnum.ALBUM.getTypeId(), false);
        hashMap.put(PrivacyTypeEnum.CAMERA.getTypeId(), false);
        hashMap.put(PrivacyTypeEnum.RECORD_AUDIO.getTypeId(), true);
        hashMap.put(PrivacyTypeEnum.BLUETOOTH.getTypeId(), false);
        return hashMap;
    }

    public Map<String, String> getPrivacyTypeIdPermNameMap() {
        return new HashMap();
    }

    public Map<String, Integer> getPrivacyTypeIdPermIconMap() {
        return new HashMap();
    }
}
