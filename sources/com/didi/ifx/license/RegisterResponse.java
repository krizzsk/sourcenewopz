package com.didi.ifx.license;

class RegisterResponse {
    private long code;
    private String license_file;
    private String message;
    private String sign_data;

    RegisterResponse() {
    }

    /* access modifiers changed from: package-private */
    public long get_code() {
        return this.code;
    }

    /* access modifiers changed from: package-private */
    public String get_license_content() {
        byte[] b = C9281a.m17450b(this.license_file.getBytes());
        if (b == null) {
            return null;
        }
        return C9281a.m17444a(b);
    }

    /* access modifiers changed from: package-private */
    public String get_license_file() {
        return this.license_file;
    }

    /* access modifiers changed from: package-private */
    public String get_message() {
        return this.message;
    }

    /* access modifiers changed from: package-private */
    public String get_sign_data() {
        return this.sign_data;
    }
}
