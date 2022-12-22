package org.osgi.framework;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

final class SignerProperty {
    private final Bundle bundle;
    private final String pattern;

    public int hashCode() {
        return 31;
    }

    public SignerProperty(String str) {
        this.pattern = str;
        this.bundle = null;
    }

    SignerProperty(Bundle bundle2) {
        this.bundle = bundle2;
        this.pattern = null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignerProperty)) {
            return false;
        }
        SignerProperty signerProperty = (SignerProperty) obj;
        Bundle bundle2 = this.bundle;
        if (bundle2 == null) {
            bundle2 = signerProperty.bundle;
        }
        String str = this.bundle != null ? signerProperty.pattern : this.pattern;
        for (List<X509Certificate> next : bundle2.getSignerCertificates(2).values()) {
            ArrayList arrayList = new ArrayList(next.size());
            for (X509Certificate subjectDN : next) {
                arrayList.add(subjectDN.getSubjectDN().getName());
            }
            try {
                if (FrameworkUtil.matchDistinguishedNameChain(str, arrayList)) {
                    return true;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isBundleSigned() {
        Bundle bundle2 = this.bundle;
        if (bundle2 == null) {
            return false;
        }
        return !bundle2.getSignerCertificates(2).isEmpty();
    }
}
