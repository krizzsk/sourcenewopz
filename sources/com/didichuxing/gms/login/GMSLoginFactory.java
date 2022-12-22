package com.didichuxing.gms.login;

import com.didi.googlelogin.GoogleLoginHelper;
import com.didi.onefacelogin.FaceBookLoginHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.ILoginParams;
import com.didichuxing.login.IThirdPartFactory;

public class GMSLoginFactory {

    @ServiceProvider(alias = "gms", value = {IThirdPartFactory.class})
    public static class GoogleLoginFactory implements IThirdPartFactory {
        public String getThirdParty() {
            return "google";
        }

        public AbsThirdPartyLoginBase factory() {
            ILoginParams iLoginParams = (ILoginParams) ServiceLoader.load(ILoginParams.class, ILoginParams.GOOGLE_LOGIN).get();
            if (iLoginParams != null) {
                return new GoogleLoginHelper(iLoginParams.getClientId());
            }
            return new GoogleLoginHelper((String) null);
        }
    }

    @ServiceProvider(alias = "gms", value = {IThirdPartFactory.class})
    public static class FaceBookLoginFactory implements IThirdPartFactory {
        public String getThirdParty() {
            return "facebook";
        }

        public AbsThirdPartyLoginBase factory() {
            ILoginParams iLoginParams = (ILoginParams) ServiceLoader.load(ILoginParams.class, ILoginParams.FACEBOOK_LOGIN).get();
            if (iLoginParams != null) {
                return new FaceBookLoginHelper(iLoginParams.getClientId());
            }
            return new FaceBookLoginHelper((String) null);
        }
    }
}
