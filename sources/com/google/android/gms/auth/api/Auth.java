package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.p216authapi.zbl;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zbc, zba);
    public static final CredentialsApi CredentialsApi = new zbl();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zbd, zbb);
    public static final GoogleSignInApi GoogleSignInApi = new zbd();
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    public static final Api.ClientKey zba = new Api.ClientKey();
    public static final Api.ClientKey zbb = new Api.ClientKey();
    private static final Api.AbstractClientBuilder zbc = new zba();
    private static final Api.AbstractClientBuilder zbd = new zbb();

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        public static final AuthCredentialsOptions zba = new AuthCredentialsOptions(new Builder());
        /* access modifiers changed from: private */
        public final String zbb = null;
        /* access modifiers changed from: private */
        public final boolean zbc;
        /* access modifiers changed from: private */
        public final String zbd;

        @Deprecated
        /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
        public static class Builder {
            protected Boolean zba = false;
            protected String zbb;

            public Builder() {
            }

            public Builder forceEnableSaveDialog() {
                this.zba = true;
                return this;
            }

            public final Builder zba(String str) {
                this.zbb = str;
                return this;
            }

            public Builder(AuthCredentialsOptions authCredentialsOptions) {
                String unused = authCredentialsOptions.zbb;
                this.zba = Boolean.valueOf(authCredentialsOptions.zbc);
                this.zbb = authCredentialsOptions.zbd;
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.zbc = builder.zba.booleanValue();
            this.zbd = builder.zbb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            String str = authCredentialsOptions.zbb;
            return Objects.equal((Object) null, (Object) null) && this.zbc == authCredentialsOptions.zbc && Objects.equal(this.zbd, authCredentialsOptions.zbd);
        }

        public int hashCode() {
            return Objects.hashCode(null, Boolean.valueOf(this.zbc), this.zbd);
        }

        public final Bundle zba() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", (String) null);
            bundle.putBoolean("force_save_dialog", this.zbc);
            bundle.putString("log_session_id", this.zbd);
            return bundle;
        }

        public final String zbd() {
            return this.zbd;
        }
    }

    private Auth() {
    }
}
