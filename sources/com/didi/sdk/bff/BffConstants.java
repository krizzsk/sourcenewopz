package com.didi.sdk.bff;

public interface BffConstants {

    public interface AbilityID {
        public static final String ABILITY_API_COMPONENT = "conf/pApiComponent";
        public static final String ABILITY_GET_FEATURE_LIST = "pmc/getFeatureBatch";
        public static final String ABILITY_GET_REDIRECT_URL_BY_USER_EVENT = "ibt-guarana-mis-ads_data_gateway/getRedirectUrlByUserEvent";
        public static final String ABILITY_GET_SAFETY_CONFIG = "passenger/pGetSafetyConfig";
        public static final String ABILITY_GET_STATUS = "passenger/pGetSwitchStatus";
        public static final String ABILITY_NEW_USER_CENTER = "expo/passenger";
        public static final String ABILITY_ONE_CONF = "conf/pGlobalOneConf";
        public static final String ABILITY_ORDER_RECOVER = "passenger/orderrecover";
        public static final String ABILITY_PRIMARY_CONF = "ibt-falcon-navigation/primary_menu";
        public static final String ABILITY_SET_FEATURE = "pmc/setFeature";
        public static final String ABILITY_SET_STATUS = "passenger/pSetSwitchStatus";
        public static final String ABILIY_GET_LEGAl_NOTICE = "pmc/getLegalNotice";
        public static final String ABLITY_AGREE_LEGAL_NOTICE = "pmc/setLegalNotice";
        public static final String ABLITY_CLIENT_GCONF = "commonapi/pClientGConf";
        public static final String ABLITY_PASSENGER_CURP = "passenger/curp";
        public static final String ABLITY_PROFILE_SETSINGLEOPTION = "commonapi/pSetSingleOption";
    }

    public interface Apollo {
        public static final String BFF_STAGE_NEW_FIFTH = "global_bff_passenger_newFifth_period_toggle";
        public static final String BFF_STAGE_THIRD = "global_bff_passenger_third_period_toggle";
    }

    public interface Tags {
        public static final String BFF_HOME_CONFIG_TAG = "home_config";
        public static final String BFF_ONE_CONF_TAG = "global_oneconf";
    }
}
