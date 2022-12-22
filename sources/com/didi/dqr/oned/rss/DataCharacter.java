package com.didi.dqr.oned.rss;

import org.osgi.framework.VersionRange;

public class DataCharacter {

    /* renamed from: a */
    private final int f18786a;

    /* renamed from: b */
    private final int f18787b;

    public DataCharacter(int i, int i2) {
        this.f18786a = i;
        this.f18787b = i2;
    }

    public final int getValue() {
        return this.f18786a;
    }

    public final int getChecksumPortion() {
        return this.f18787b;
    }

    public final String toString() {
        return this.f18786a + "(" + this.f18787b + VersionRange.RIGHT_OPEN;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        if (this.f18786a == dataCharacter.f18786a && this.f18787b == dataCharacter.f18787b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18786a ^ this.f18787b;
    }
}
