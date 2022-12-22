package com.koushikdutta.async.http.body;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class Part {
    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    /* renamed from: d */
    static final /* synthetic */ boolean f55327d = (!Part.class.desiredAssertionStatus());

    /* renamed from: a */
    private long f55328a = -1;

    /* renamed from: b */
    Headers f55329b;

    /* renamed from: c */
    Multimap f55330c;

    public Part(Headers headers) {
        this.f55329b = headers;
        this.f55330c = Multimap.parseSemicolonDelimited(headers.get("Content-Disposition"));
    }

    public String getName() {
        return this.f55330c.getString("name");
    }

    public Part(String str, long j, List<NameValuePair> list) {
        this.f55328a = j;
        this.f55329b = new Headers();
        StringBuilder sb = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", new Object[]{str}));
        if (list != null) {
            for (NameValuePair next : list) {
                sb.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", new Object[]{next.getName(), next.getValue()}));
            }
        }
        this.f55329b.set("Content-Disposition", sb.toString());
        this.f55330c = Multimap.parseSemicolonDelimited(this.f55329b.get("Content-Disposition"));
    }

    public Headers getRawHeaders() {
        return this.f55329b;
    }

    public String getContentType() {
        return this.f55329b.get("Content-Type");
    }

    public void setContentType(String str) {
        this.f55329b.set("Content-Type", str);
    }

    public String getFilename() {
        String string = this.f55330c.getString(SDKConsts.TAG_KEY_FILENAME);
        if (string == null) {
            return null;
        }
        return new File(string).getName();
    }

    public boolean isFile() {
        return this.f55330c.containsKey(SDKConsts.TAG_KEY_FILENAME);
    }

    public long length() {
        return this.f55328a;
    }

    public void write(DataSink dataSink, CompletedCallback completedCallback) {
        if (!f55327d) {
            throw new AssertionError();
        }
    }
}
