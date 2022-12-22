package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.GOST */
public final class GOST extends setThreeDSRequestorAppURL {
    private int Cardinal = -1;

    public GOST() {
    }

    public GOST(setForegroundTintBlendMode setforegroundtintblendmode) {
        super(setforegroundtintblendmode);
    }

    public GOST(getProxyAddress[] getproxyaddressArr) {
        super(getproxyaddressArr);
    }

    private int CardinalError() throws IOException {
        if (this.Cardinal < 0) {
            int i = 0;
            Enumeration cca_continue = cca_continue();
            while (cca_continue.hasMoreElements()) {
                i += ((getProxyAddress) cca_continue.nextElement()).values().getSDKVersion().configure();
            }
            this.Cardinal = i;
        }
        return this.Cardinal;
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setEnableDFSync Cardinal2 = setenabledfsync.Cardinal();
        int CardinalError = CardinalError();
        setenabledfsync.configure(48);
        setenabledfsync.Cardinal(CardinalError);
        Enumeration cca_continue = cca_continue();
        while (cca_continue.hasMoreElements()) {
            Cardinal2.init((getProxyAddress) cca_continue.nextElement());
        }
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        int CardinalError = CardinalError();
        return KeyAgreementSpi.Cardinal(CardinalError) + 1 + CardinalError;
    }

    /* renamed from: com.cardinalcommerce.a.GOST$Mappings */
    public final class Mappings extends isEnableLogging {
        private int init = -1;

        public Mappings() {
        }

        public Mappings(setForegroundTintBlendMode setforegroundtintblendmode) {
            super(setforegroundtintblendmode, true);
        }

        Mappings(setForegroundTintBlendMode setforegroundtintblendmode, byte b) {
            super(setforegroundtintblendmode, false);
        }

        /* access modifiers changed from: package-private */
        public final int configure() throws IOException {
            int init2 = init();
            return KeyAgreementSpi.Cardinal(init2) + 1 + init2;
        }

        private int init() throws IOException {
            if (this.init < 0) {
                int i = 0;
                Enumeration elements = this.cca_continue.elements();
                while (elements.hasMoreElements()) {
                    i += ((getProxyAddress) elements.nextElement()).values().getSDKVersion().configure();
                }
                this.init = i;
            }
            return this.init;
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            setEnableDFSync Cardinal = setenabledfsync.Cardinal();
            int init2 = init();
            setenabledfsync.configure(49);
            setenabledfsync.Cardinal(init2);
            Enumeration elements = this.cca_continue.elements();
            while (elements.hasMoreElements()) {
                Cardinal.init((getProxyAddress) elements.nextElement());
            }
        }
    }
}
