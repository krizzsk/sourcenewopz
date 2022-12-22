package com.didi.unifylogin.api;

import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.GlobalCountryCode;

public enum LoginCountryEnum {
    CHAIN(156, GlobalCountryCode.CHINA),
    HONG_KONG(344, "HK"),
    TAIWAN(158, "TW"),
    JAPAN(392, "JP"),
    BRASIL(76, "BR"),
    MEXICO(484, "MX"),
    AUSTRALIA(36, "AU"),
    ARGENTINA(32, HistoryRecordFragment.COUNTRY_CODE_AR),
    CHILE(152, HistoryRecordFragment.COUNTRY_CODE_CL),
    COLOMBIA(170, HistoryRecordFragment.COUNTRY_CODE_CO),
    COSTARICA(188, HistoryRecordFragment.COUNTRY_CODE_CR),
    PANAMA(591, HistoryRecordFragment.COUNTRY_CODE_PA),
    PERU(604, HistoryRecordFragment.COUNTRY_CODE_PE);
    
    private String areaCode;
    private int countryId;

    private LoginCountryEnum(int i, String str) {
        this.countryId = i;
        this.areaCode = str;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getAreaCode() {
        return this.areaCode;
    }
}
