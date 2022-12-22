package com.didi.component.splitfare.contactmanage;

import java.io.Serializable;

public class GlobalSortKey implements Serializable, Comparable<GlobalSortKey> {
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

    public GlobalSortKey(char c) {
        this.key = Character.valueOf(c);
    }

    public int compareTo(GlobalSortKey globalSortKey) {
        return compare(this.key.charValue(), globalSortKey.key.charValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlobalSortKey) || ((GlobalSortKey) obj).key.charValue() != this.key.charValue()) {
            return false;
        }
        return true;
    }
}
