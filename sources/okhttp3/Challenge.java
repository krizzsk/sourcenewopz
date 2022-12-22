package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.C2434Util;

public final class Challenge {

    /* renamed from: a */
    private final String f5111a;

    /* renamed from: b */
    private final Map<String, String> f5112b;

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (map != null) {
            this.f5111a = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey() == null ? null : ((String) next.getKey()).toLowerCase(Locale.US), next.getValue());
            }
            this.f5112b = Collections.unmodifiableMap(linkedHashMap);
        } else {
            throw new NullPointerException("authParams == null");
        }
    }

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 != null) {
            this.f5111a = str;
            this.f5112b = Collections.singletonMap("realm", str2);
        } else {
            throw new NullPointerException("realm == null");
        }
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.f5112b);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.f5111a, (Map<String, String>) linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public String scheme() {
        return this.f5111a;
    }

    public Map<String, String> authParams() {
        return this.f5112b;
    }

    public String realm() {
        return this.f5112b.get("realm");
    }

    public Charset charset() {
        String str = this.f5112b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return C2434Util.ISO_8859_1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return challenge.f5111a.equals(this.f5111a) && challenge.f5112b.equals(this.f5112b);
        }
    }

    public int hashCode() {
        return ((899 + this.f5111a.hashCode()) * 31) + this.f5112b.hashCode();
    }

    public String toString() {
        return this.f5111a + " authParams=" + this.f5112b;
    }
}
