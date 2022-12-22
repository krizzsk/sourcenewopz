package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setHttpAuthUsernamePassword */
public final class setHttpAuthUsernamePassword extends C2017j {

    /* renamed from: a */
    private String f2803a;

    public setHttpAuthUsernamePassword(int i) {
        super(i);
    }

    public final <T> T configure(String str, setWebViewRenderProcessClient<T> setwebviewrenderprocessclient) throws setCertificate {
        this.f2803a = str;
        this.getWarnings = str.length();
        return getInstance(setwebviewrenderprocessclient);
    }

    /* access modifiers changed from: protected */
    public final void getInstance(int i, int i2) {
        this.init = this.f2803a.substring(i, i2);
    }

    /* access modifiers changed from: protected */
    public final void configure(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.f2803a.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.f2803a.charAt(i3))) {
                this.init = this.f2803a.substring(i, i2);
            } else {
                i2--;
            }
        }
        this.init = this.f2803a.substring(i, i2);
    }

    /* access modifiers changed from: protected */
    public final int configure(char c, int i) {
        return this.f2803a.indexOf(c, i);
    }

    /* access modifiers changed from: protected */
    public final void configure() {
        int i = this.Cardinal + 1;
        this.Cardinal = i;
        if (i >= this.getWarnings) {
            this.cca_continue = 26;
        } else {
            this.cca_continue = this.f2803a.charAt(this.Cardinal);
        }
    }

    /* access modifiers changed from: protected */
    public final void cleanup() {
        int i = this.Cardinal + 1;
        this.Cardinal = i;
        if (i >= this.getWarnings) {
            this.cca_continue = 26;
        } else {
            this.cca_continue = this.f2803a.charAt(this.Cardinal);
        }
    }

    /* access modifiers changed from: protected */
    public final void Cardinal() throws setCertificate {
        int i = this.Cardinal + 1;
        this.Cardinal = i;
        if (i < this.getWarnings) {
            this.cca_continue = this.f2803a.charAt(this.Cardinal);
        } else {
            this.cca_continue = 26;
            throw new setCertificate(this.Cardinal - 1, 3, "EOF");
        }
    }
}
