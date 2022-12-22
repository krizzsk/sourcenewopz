package com.didi.map.sdk.nav.util;

public final class MapMargins {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public MapMargins(int i, int i2, int i3, int i4) {
        this.left = 0;
        this.right = 0;
        this.top = 0;
        this.bottom = 0;
        this.left = i;
        this.right = i2;
        this.top = i3;
        this.bottom = i4;
    }

    public MapMargins() {
        this.left = 0;
        this.right = 0;
        this.top = 0;
        this.bottom = 0;
        this.left = 0;
        this.right = 0;
        this.top = 0;
        this.bottom = 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MapMargins)) {
            return false;
        }
        MapMargins mapMargins = (MapMargins) obj;
        if (this.left == mapMargins.left && this.right == mapMargins.right && this.top == mapMargins.top && this.bottom == mapMargins.bottom) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("left:%s right:%s top:%s bottom:%s", new Object[]{Integer.valueOf(this.left), Integer.valueOf(this.right), Integer.valueOf(this.top), Integer.valueOf(this.bottom)});
    }
}
