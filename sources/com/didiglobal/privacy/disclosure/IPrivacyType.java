package com.didiglobal.privacy.disclosure;

public interface IPrivacyType {
    String getCustomDialogTitle();

    String getDialogDesc();

    Integer getDialogPermIcon();

    String getDialogPermName();

    String[] getPermissions();

    String getTypeId();
}
