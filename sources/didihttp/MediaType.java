package didihttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {

    /* renamed from: a */
    private static final String f56462a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: b */
    private static final String f56463b = "\"([^\"]*)\"";

    /* renamed from: c */
    private static final Pattern f56464c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f56465d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: e */
    private final String f56466e;

    /* renamed from: f */
    private final String f56467f;

    /* renamed from: g */
    private final String f56468g;

    /* renamed from: h */
    private final String f56469h;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f56466e = str;
        this.f56467f = str2;
        this.f56468g = str3;
        this.f56469h = str4;
    }

    public static MediaType parse(String str) {
        Matcher matcher = f56464c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f56465d.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public String type() {
        return this.f56467f;
    }

    public String subtype() {
        return this.f56468g;
    }

    public Charset charset() {
        String str = this.f56469h;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public Charset charset(Charset charset) {
        String str = this.f56469h;
        return str != null ? Charset.forName(str) : charset;
    }

    public String toString() {
        return this.f56466e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f56466e.equals(this.f56466e);
    }

    public int hashCode() {
        return this.f56466e.hashCode();
    }
}
