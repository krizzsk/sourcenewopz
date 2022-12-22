package com.didichuxing.apollo.sdk.log;

public class ApolloErrorLog {

    /* renamed from: a */
    private String f45615a = "";

    public String getLogKey() {
        return "error_msg";
    }

    public ApolloErrorLog(String str) {
        if (str != null) {
            this.f45615a = str;
        }
    }

    public String getErrorMsg() {
        String str = this.f45615a;
        return str == null ? "" : str;
    }
}
