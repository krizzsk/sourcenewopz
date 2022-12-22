package com.didi.sdk.login;

import android.app.Application;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.ILoginParams;
import com.taxis99.R;

@ServiceProvider(alias = "google_login", value = {ILoginParams.class})
public class GoogleLoginParams implements ILoginParams {
    public String getClientId() {
        Application appContext = DIDIApplication.getAppContext();
        return appContext.getString(AppUtils.isBrazilApp(appContext) ? R.string.login_google_app_id_brazil : R.string.login_google_app_id);
    }
}
