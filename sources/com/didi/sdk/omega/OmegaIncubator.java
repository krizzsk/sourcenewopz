package com.didi.sdk.omega;

import android.content.Context;
import com.didi.sdk.data.DataLoadUtil;
import com.didi.sdk.data.Incubator;
import com.didi.sdk.data.NLogger;
import com.didi.sdk.data.UserDataGenerator;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.init.OmegaSDK;

@ServiceProvider(alias = "omega", value = {Incubator.class})
public class OmegaIncubator implements Incubator {

    /* renamed from: a */
    private NLogger f36859a = NLogger.getNLogger("OmegaModule");

    public void init(Context context) {
        this.f36859a.debug("omega init");
        final UserDataGenerator userDataGenerator = (UserDataGenerator) DataLoadUtil.loadGenerator(UserDataGenerator.class);
        if (userDataGenerator == null) {
            this.f36859a.error("please implementation UserDataGenerator");
            return;
        }
        Omega.init(context);
        OmegaSDK.setGetUid(new OmegaConfig.IGetUid() {
            public String getDidiPassengerUid() {
                return userDataGenerator.getUid();
            }
        });
        OmegaSDK.setGetPhone(new OmegaConfig.IGetPhone() {
            public String getPhone() {
                return userDataGenerator.getPhone();
            }
        });
    }
}
