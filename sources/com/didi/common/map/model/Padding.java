package com.didi.common.map.model;

public class Padding {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public Padding() {
    }

    public Padding(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public Padding(Padding padding) {
        if (padding != null) {
            this.top = padding.top;
            this.bottom = padding.bottom;
            this.left = padding.left;
            this.right = padding.right;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Padding)) {
            return false;
        }
        Padding padding = (Padding) obj;
        if (padding.left == this.left && padding.right == this.right && padding.bottom == this.bottom && padding.top == this.top) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "top=" + this.top + ",bottom=" + this.bottom + ",left=" + this.left + ",right=" + this.right;
    }
}
