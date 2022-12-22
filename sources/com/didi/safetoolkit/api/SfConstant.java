package com.didi.safetoolkit.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SfConstant {
    public static final int PAGE_SAFE_CENTER = 3;
    public static final int PAGE_SHARE = 1;
    public static final int PAGE_SOS = 2;
    public static final String SHARE_NAME_LIST = "sf_name_list";
    public static final String WILL_DELETE_CONTACT = "deleteContact";

    public static class SfAction {
        public static final String ACTION_ADD_CONTACTS_FAIL = "sf_add_contacts_fail";
        public static final String ACTION_ADD_CONTACTS_SUCCESS = "sf_add_contacts_success";
        public static final String ACTION_DELETE_CONTACTS_FAIL = "sf_delete_contacts_fail";
        public static final String ACTION_DELETE_CONTACT_SUCCESS = "sf_delete_contacts_success";
        public static final String ACTION_EMERGENCY_ASSIST_OFF = "sf_emergency_assist_off";
        public static final String ACTION_EMERGENCY_ASSIST_ON = "sf_emergency_assist_on";
        public static final String ACTION_SHARE_FAILED = "sf_share_failed";
        public static final String ACTION_SHARE_SUCCESS = "sf_share_success";
        public static final String ACTION_START_SHARE = "sf_start_share";
    }

    public static class SfDangerLevel {
        public static final String LEVEL_HIGH_RISK = "High_Risk";
        public static final String LEVEL_IMPORTANT = "Important";
        public static final String LEVEL_LOW_MEDIUM_RISK = "Low_Medium_Risk";
        public static final String LEVEL_NORMAL = "Normal";
        public static final String LEVEL_RECORDING_OFF = "Other_Recording_Off";
        public static final String LEVEL_RECORDING_ON = "Other_Recording_On";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SfPageTarget {
    }
}
