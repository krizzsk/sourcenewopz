package com.didiglobal.privacy.disclosure;

import com.yanzhenjie.permission.runtime.Permission;
import java.util.Map;

public enum PrivacyTypeEnum implements IPrivacyType {
    LOCATION(PrivacyTypeConstants.PRIVACY_TYPE_LOCATION, new String[]{Permission.ACCESS_FINE_LOCATION}),
    READ_CONTACTS(PrivacyTypeConstants.PRIVACY_TYPE_READ_CONTACTS, new String[]{Permission.READ_CONTACTS}),
    ALBUM(PrivacyTypeConstants.PRIVACY_TYPE_ALBUM, new String[]{Permission.WRITE_EXTERNAL_STORAGE}),
    CAMERA(PrivacyTypeConstants.PRIVACY_TYPE_CAMERA, new String[]{Permission.CAMERA}),
    RECORD_AUDIO(PrivacyTypeConstants.PRIVACY_TYPE_RECORD_AUDIO, new String[]{Permission.RECORD_AUDIO}),
    BLUETOOTH(PrivacyTypeConstants.PRIVACY_TYPE_BLUETOOTH, new String[0]);
    
    private String[] permissions;
    private String typeId;

    private PrivacyTypeEnum(String str, String[] strArr) {
        this.typeId = str;
        this.permissions = strArr;
    }

    public String getCustomDialogTitle() {
        Map<String, String> privacyTypeIdTitleMap;
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureManager.getInitParam();
        if (initParam == null || (privacyTypeIdTitleMap = initParam.getPrivacyTypeIdTitleMap()) == null) {
            return "";
        }
        return privacyTypeIdTitleMap.get(this.typeId);
    }

    public String getDialogDesc() {
        Map<String, String> privacyTypeIdDescMap;
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureManager.getInitParam();
        if (initParam == null || (privacyTypeIdDescMap = initParam.getPrivacyTypeIdDescMap()) == null) {
            return "";
        }
        return privacyTypeIdDescMap.get(this.typeId);
    }

    public String getDialogPermName() {
        Map<String, String> privacyTypeIdPermNameMap;
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureManager.getInitParam();
        if (initParam == null || (privacyTypeIdPermNameMap = initParam.getPrivacyTypeIdPermNameMap()) == null) {
            return "";
        }
        return privacyTypeIdPermNameMap.get(this.typeId);
    }

    public Integer getDialogPermIcon() {
        Map<String, Integer> privacyTypeIdPermIconMap;
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureManager.getInitParam();
        if (initParam == null || (privacyTypeIdPermIconMap = initParam.getPrivacyTypeIdPermIconMap()) == null) {
            return -1;
        }
        return privacyTypeIdPermIconMap.get(this.typeId);
    }

    public String getTypeId() {
        return this.typeId;
    }

    public String[] getPermissions() {
        return this.permissions;
    }
}
