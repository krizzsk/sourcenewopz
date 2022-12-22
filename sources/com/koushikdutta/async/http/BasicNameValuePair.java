package com.koushikdutta.async.http;

import android.text.TextUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {

    /* renamed from: a */
    private final String f55292a;

    /* renamed from: b */
    private final String f55293b;

    public BasicNameValuePair(String str, String str2) {
        if (str != null) {
            this.f55292a = str;
            this.f55293b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String getName() {
        return this.f55292a;
    }

    public String getValue() {
        return this.f55293b;
    }

    public String toString() {
        return this.f55292a + "=" + this.f55293b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        if (!this.f55292a.equals(basicNameValuePair.f55292a) || !TextUtils.equals(this.f55293b, basicNameValuePair.f55293b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f55292a.hashCode() ^ this.f55293b.hashCode();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
