package com.adyen.threeds2.util;

import android.text.TextUtils;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class AdyenConfigParameters {
    public static final C1428a DEVICE_PARAMETER_BLOCK_LIST = new C1428a((String) null, "deviceParameterBlockList");
    public static final C1428a DIRECTORY_SERVER_ID = new C1428a("threeds2.directoryServer", "id");
    public static final C1428a DIRECTORY_SERVER_PUBLIC_KEY = new C1428a("threeds2.directoryServer", "publicKey");
    public static final C1428a SECURITY_APP_SIGNATURE = new C1428a(ErrorConst.ModuleName.SECURITY, "appSignature");
    public static final C1428a SECURITY_MALICIOUS_APPS = new C1428a(ErrorConst.ModuleName.SECURITY, "maliciousApps");
    public static final C1428a SECURITY_TRUSTED_APP_STORES = new C1428a(ErrorConst.ModuleName.SECURITY, "trustedAppStores");

    public static final class Builder {

        /* renamed from: a */
        private final String f1087a;

        /* renamed from: b */
        private final String f1088b;

        /* renamed from: c */
        private String f1089c;

        /* renamed from: d */
        private Set<String> f1090d;

        /* renamed from: e */
        private Set<String> f1091e;

        /* renamed from: f */
        private Set<String> f1092f;

        public Builder(String str, String str2) {
            this.f1087a = str;
            this.f1088b = str2;
        }

        public Builder appSignature(String str) {
            this.f1089c = str;
            return this;
        }

        public ConfigParameters build() throws InvalidInputException {
            Preconditions.requireNonEmpty("directoryServerId", this.f1087a);
            Preconditions.requireNonEmpty("directoryServerPublicKey", this.f1088b);
            ConfigParameters configParameters = new ConfigParameters();
            AdyenConfigParameters.m1216a(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID, this.f1087a);
            AdyenConfigParameters.m1216a(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_PUBLIC_KEY, this.f1088b);
            String str = this.f1089c;
            if (str != null) {
                AdyenConfigParameters.m1216a(configParameters, AdyenConfigParameters.SECURITY_APP_SIGNATURE, str);
            }
            Set<String> set = this.f1090d;
            if (set != null) {
                AdyenConfigParameters.m1217a(configParameters, AdyenConfigParameters.SECURITY_TRUSTED_APP_STORES, (Collection<String>) set);
            }
            Set<String> set2 = this.f1091e;
            if (set2 != null) {
                AdyenConfigParameters.m1217a(configParameters, AdyenConfigParameters.SECURITY_MALICIOUS_APPS, (Collection<String>) set2);
            }
            Set<String> set3 = this.f1092f;
            if (set3 != null) {
                AdyenConfigParameters.m1217a(configParameters, AdyenConfigParameters.DEVICE_PARAMETER_BLOCK_LIST, (Collection<String>) set3);
            }
            return configParameters;
        }

        public Builder deviceParameterBlockList(Set<String> set) {
            this.f1092f = set;
            return this;
        }

        public Builder maliciousApps(Set<String> set) {
            this.f1091e = set;
            return this;
        }

        public Builder trustedAppStores(Set<String> set) {
            this.f1090d = set;
            return this;
        }
    }

    /* renamed from: com.adyen.threeds2.util.AdyenConfigParameters$a */
    private static final class C1428a {

        /* renamed from: a */
        private final String f1093a;

        /* renamed from: b */
        private final String f1094b;

        C1428a(String str, String str2) {
            this.f1093a = str;
            this.f1094b = str2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo14948a() {
            return this.f1093a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo14949b() {
            return this.f1094b;
        }
    }

    private AdyenConfigParameters() {
        throw new IllegalStateException("No instances.");
    }

    /* renamed from: a */
    static void m1217a(ConfigParameters configParameters, C1428a aVar, Collection<String> collection) throws InvalidInputException {
        Preconditions.requireNonNull("paramValues", collection);
        m1216a(configParameters, aVar, TextUtils.join(";", collection));
    }

    public static String getParamValue(ConfigParameters configParameters, C1428a aVar) throws InvalidInputException {
        Preconditions.requireNonNull("configParameters", configParameters);
        Preconditions.requireNonNull("parameter", aVar);
        return configParameters.getParamValue(aVar.mo14948a(), aVar.mo14949b());
    }

    public static Collection<String> getParamValues(ConfigParameters configParameters, C1428a aVar) throws InvalidInputException {
        String paramValue = getParamValue(configParameters, aVar);
        if (paramValue == null) {
            return null;
        }
        return Arrays.asList(paramValue.split(";"));
    }

    /* renamed from: a */
    static void m1216a(ConfigParameters configParameters, C1428a aVar, String str) throws InvalidInputException {
        Preconditions.requireNonNull("configParameters", configParameters);
        Preconditions.requireNonNull("parameter", aVar);
        Preconditions.requireNonEmpty("paramValue", str);
        configParameters.addParam(aVar.mo14948a(), aVar.mo14949b(), str);
    }
}
