package com.didichuxing.login;

import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;

public interface IThirdPartFactory {
    public static final String GMS = "gms";
    public static final String HMS = "hms";
    public static final String THIRD_PARTY_FACEBOOK = "facebook";
    public static final String THIRD_PARTY_GOOGLE = "google";

    AbsThirdPartyLoginBase factory();

    String getThirdParty();
}
