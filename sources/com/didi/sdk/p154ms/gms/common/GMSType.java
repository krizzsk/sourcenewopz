package com.didi.sdk.p154ms.gms.common;

import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.type.MSType;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "GMS", value = {IMSType.class})
/* renamed from: com.didi.sdk.ms.gms.common.GMSType */
public class GMSType implements IMSType {
    public final MSType getMSType() {
        return MSType.GMS;
    }
}
