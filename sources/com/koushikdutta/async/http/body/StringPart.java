package com.koushikdutta.async.http.body;

import com.koushikdutta.async.http.NameValuePair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StringPart extends StreamPart {

    /* renamed from: a */
    String f55336a;

    public StringPart(String str, String str2) {
        super(str, (long) str2.getBytes().length, (List<NameValuePair>) null);
        this.f55336a = str2;
    }

    /* access modifiers changed from: protected */
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.f55336a.getBytes());
    }

    public String getValue() {
        return this.f55336a;
    }

    public String toString() {
        return this.f55336a;
    }
}
