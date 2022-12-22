package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;

public final class MediaType {

    /* renamed from: a */
    private static final String f5180a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: b */
    private static final String f5181b = "\"([^\"]*)\"";

    /* renamed from: c */
    private static final Pattern f5182c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f5183d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: e */
    private final String f5184e;

    /* renamed from: f */
    private final String f5185f;

    /* renamed from: g */
    private final String f5186g;
    @Nullable

    /* renamed from: h */
    private final String f5187h;

    private MediaType(String str, String str2, String str3, @Nullable String str4) {
        this.f5184e = str;
        this.f5185f = str2;
        this.f5186g = str3;
        this.f5187h = str4;
    }

    public static MediaType get(String str) {
        Matcher matcher = f5182c.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f5183d.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
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
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + Typography.quote);
                        }
                    }
                    end = matcher2.end();
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + Typography.quote);
                }
            }
            return new MediaType(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + Typography.quote);
    }

    @Nullable
    public static MediaType parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String type() {
        return this.f5185f;
    }

    public String subtype() {
        return this.f5186g;
    }

    @Nullable
    public Charset charset() {
        return charset((Charset) null);
    }

    @Nullable
    public Charset charset(@Nullable Charset charset) {
        try {
            return this.f5187h != null ? Charset.forName(this.f5187h) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f5184e;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f5184e.equals(this.f5184e);
    }

    public int hashCode() {
        return this.f5184e.hashCode();
    }
}
