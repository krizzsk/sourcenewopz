package com.didi.safetoolkit.business.share.model;

import java.io.Serializable;

public class SfSortKey implements Serializable, Comparable<SfSortKey> {
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

    public SfSortKey(char c) {
        this.key = Character.valueOf(c);
    }

    public int compareTo(SfSortKey sfSortKey) {
        return compare(this.key.charValue(), sfSortKey.key.charValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SfSortKey) || ((SfSortKey) obj).key.charValue() != this.key.charValue()) {
            return false;
        }
        return true;
    }
}
