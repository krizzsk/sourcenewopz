package com.didichuxing.foundation.net.http;

public class SimpleHttpHeader implements HttpHeader {

    /* renamed from: a */
    private final String f47585a;

    /* renamed from: b */
    private final String f47586b;

    public SimpleHttpHeader(String str, String str2) {
        this.f47585a = str;
        this.f47586b = str2;
    }

    public String getName() {
        return this.f47585a;
    }

    public String getValue() {
        return this.f47586b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleHttpHeader)) {
            return false;
        }
        SimpleHttpHeader simpleHttpHeader = (SimpleHttpHeader) obj;
        String str = this.f47585a;
        if (str == null ? simpleHttpHeader.f47585a != null : !str.equals(simpleHttpHeader.f47585a)) {
            return false;
        }
        String str2 = this.f47586b;
        String str3 = simpleHttpHeader.f47586b;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.f47585a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f47586b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f47585a;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        sb.append(str);
        sb.append(": ");
        String str3 = this.f47586b;
        if (str3 != null) {
            str2 = str3;
        }
        sb.append(str2);
        return sb.toString();
    }
}
