package com.didichuxing.foundation.net;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MimeType {
    public static final MimeType APPLICATION_OCTET_STREAM = parse("application/octet-stream");
    public static final MimeType TEXT_PLAIN = parse("text/plain; charset=" + Charset.defaultCharset().name());
    public static final MimeType WILDCARD = parse(AsyncHttpRequest.HEADER_ACCEPT_ALL);

    /* renamed from: a */
    private static final String f47563a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: b */
    private static final String f47564b = "\"([^\"]*)\"";

    /* renamed from: c */
    private static final Pattern f47565c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f47566d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: e */
    private final String f47567e;

    /* renamed from: f */
    private final String f47568f;

    /* renamed from: g */
    private final String f47569g;

    /* renamed from: h */
    private final Charset f47570h;

    public static MimeType guess(File file) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return APPLICATION_OCTET_STREAM;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            return APPLICATION_OCTET_STREAM;
        }
        return parse(mimeTypeFromExtension);
    }

    public static MimeType parse(String str) {
        String str2;
        Matcher matcher = f47565c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f47566d.matcher(str);
        String str3 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                if (matcher2.group(2) != null) {
                    str2 = matcher2.group(2);
                } else {
                    str2 = matcher2.group(3);
                }
                if (str3 == null || str2.equalsIgnoreCase(str3)) {
                    str3 = str2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new MimeType(str, lowerCase, lowerCase2, str3);
    }

    public MimeType(String str, String str2, String str3, String str4) {
        this.f47567e = str;
        this.f47568f = str2;
        this.f47569g = str3;
        this.f47570h = TextUtils.isEmpty(str4) ? null : Charset.forName(str4);
    }

    public String getType() {
        return this.f47568f;
    }

    public String getSubtype() {
        return this.f47569g;
    }

    public Charset getCharset() {
        return this.f47570h;
    }

    public Charset getCharset(Charset charset) {
        Charset charset2 = getCharset();
        return charset2 != null ? charset2 : charset;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MimeType) && ((MimeType) obj).f47567e.equals(this.f47567e));
    }

    public int hashCode() {
        return this.f47567e.hashCode();
    }

    public String toString() {
        return this.f47567e;
    }
}
