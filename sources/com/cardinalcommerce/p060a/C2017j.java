package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.j */
abstract class C2017j extends setAlwaysDrawnWithCacheEnabled {
    protected int getWarnings;

    /* access modifiers changed from: protected */
    public abstract int configure(char c, int i);

    /* access modifiers changed from: protected */
    public abstract void configure(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void getInstance(int i, int i2);

    public C2017j(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final void init(boolean[] zArr) throws IOException {
        int i = this.Cardinal;
        cca_continue(zArr);
        configure(i, this.Cardinal);
    }

    /* access modifiers changed from: protected */
    public final Object configure(boolean[] zArr) throws setCertificate, IOException {
        int i = this.Cardinal;
        configure();
        getSDKVersion();
        if (this.cca_continue == '.' || this.cca_continue == 'E' || this.cca_continue == 'e') {
            if (this.cca_continue == '.') {
                configure();
                getSDKVersion();
            }
            if (this.cca_continue == 'E' || this.cca_continue == 'e') {
                this.configure.configure('E');
                configure();
                if (this.cca_continue == '+' || this.cca_continue == '-' || (this.cca_continue >= '0' && this.cca_continue <= '9')) {
                    this.configure.configure(this.cca_continue);
                    configure();
                    getSDKVersion();
                    getWarnings();
                    if (this.cca_continue < 0 || this.cca_continue >= '~' || zArr[this.cca_continue] || this.cca_continue == 26) {
                        configure(i, this.Cardinal);
                        return cca_continue();
                    }
                    cca_continue(zArr);
                    configure(i, this.Cardinal);
                    if (this.cleanup) {
                        return this.init;
                    }
                    throw new setCertificate(this.Cardinal, 1, this.init);
                }
                cca_continue(zArr);
                configure(i, this.Cardinal);
                if (this.cleanup) {
                    if (!this.values) {
                        init();
                    }
                    return this.init;
                }
                throw new setCertificate(this.Cardinal, 1, this.init);
            }
            getWarnings();
            if (this.cca_continue < 0 || this.cca_continue >= '~' || zArr[this.cca_continue] || this.cca_continue == 26) {
                configure(i, this.Cardinal);
                return cca_continue();
            }
            cca_continue(zArr);
            configure(i, this.Cardinal);
            if (this.cleanup) {
                return this.init;
            }
            throw new setCertificate(this.Cardinal, 1, this.init);
        }
        getWarnings();
        if (this.cca_continue < 0 || this.cca_continue >= '~' || zArr[this.cca_continue] || this.cca_continue == 26) {
            configure(i, this.Cardinal);
            return getInstance(this.init);
        }
        cca_continue(zArr);
        configure(i, this.Cardinal);
        if (this.cleanup) {
            return this.init;
        }
        throw new setCertificate(this.Cardinal, 1, this.init);
    }

    /* access modifiers changed from: protected */
    public final void CardinalError() throws setCertificate, IOException {
        if (this.getSDKVersion || this.cca_continue != '\'') {
            int configure = configure(this.cca_continue, this.Cardinal + 1);
            if (configure != -1) {
                getInstance(this.Cardinal + 1, configure);
                if (this.init.indexOf(92) == -1) {
                    getInstance();
                    this.Cardinal = configure;
                    configure();
                    return;
                }
                this.configure.init = -1;
                values();
                return;
            }
            throw new setCertificate(this.getWarnings, 3, (Object) null);
        } else if (this.cleanup) {
            boolean[] zArr = getInstance;
            int i = this.Cardinal;
            cca_continue(zArr);
            configure(i, this.Cardinal);
        } else {
            throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
        }
    }
}
