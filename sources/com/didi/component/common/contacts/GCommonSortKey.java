package com.didi.component.common.contacts;

import java.io.Serializable;

public class GCommonSortKey implements Serializable, Comparable<GCommonSortKey> {
    public Character key;

    private int compare(char c, char c2) {
        if (c == '#' || c2 == '#') {
            if (c == '#' && c2 == '#') {
                return 0;
            }
            return c == '#' ? 1 : -1;
        } else if (c > c2) {
            return 1;
        } else {
            return c == c2 ? 0 : -1;
        }
    }

    public GCommonSortKey(char c) {
        this.key = Character.valueOf(c);
    }

    public int compareTo(GCommonSortKey gCommonSortKey) {
        return compare(this.key.charValue(), gCommonSortKey.key.charValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GCommonSortKey) || ((GCommonSortKey) obj).key.charValue() != this.key.charValue()) {
            return false;
        }
        return true;
    }
}
