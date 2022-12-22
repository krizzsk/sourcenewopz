package didihttp;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import didihttp.internal.C20747Util;

public final class Challenge {

    /* renamed from: a */
    private final String f56344a;

    /* renamed from: b */
    private final String f56345b;

    public Challenge(String str, String str2) {
        this.f56344a = str;
        this.f56345b = str2;
    }

    public String scheme() {
        return this.f56344a;
    }

    public String realm() {
        return this.f56345b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return C20747Util.equal(this.f56344a, challenge.f56344a) && C20747Util.equal(this.f56345b, challenge.f56345b);
        }
    }

    public int hashCode() {
        String str = this.f56345b;
        int i = 0;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f56344a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f56344a + " realm=\"" + this.f56345b + Const.jsQuote;
    }
}
