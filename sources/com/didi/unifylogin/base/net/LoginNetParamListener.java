package com.didi.unifylogin.base.net;

import android.content.Context;
import java.util.Map;

public interface LoginNetParamListener {
    String getA3(Context context);

    int getAppId();

    String getCanonicalCountryCode();

    int getCityId();

    String getCountryCallingCode();

    int getCountryId();

    Map<String, Object> getExtraInfo();

    String getIdfa(Context context);

    String getLanguage();

    double getLat();

    double getLng();

    String getMapType();

    int getRole();

    String getTerminalId();

    int getUtcOffset(Context context);
}
