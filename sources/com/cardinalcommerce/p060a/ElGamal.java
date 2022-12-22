package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.ElGamal */
public final class ElGamal extends setEnableDFSync {

    /* renamed from: com.cardinalcommerce.a.ElGamal$Mappings */
    public final class Mappings implements setEnableLogging {
        private DSASigner.dsaSha3_384 configure;

        public Mappings(DSASigner.dsaSha3_384 dsasha3_384) {
            this.configure = dsasha3_384;
        }

        public final setLocationDataConsentGiven getInstance() throws IOException {
            return new GOST(this.configure.configure());
        }

        public final setLocationDataConsentGiven values() {
            try {
                return getInstance();
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }

    public ElGamal(OutputStream outputStream) {
        super(outputStream);
    }

    /* access modifiers changed from: package-private */
    public final setEnableDFSync Cardinal() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public final setEnableDFSync init() {
        return this;
    }

    public final void init(getProxyAddress getproxyaddress) throws IOException {
        if (getproxyaddress != null) {
            getproxyaddress.values().getSDKVersion().cca_continue(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
