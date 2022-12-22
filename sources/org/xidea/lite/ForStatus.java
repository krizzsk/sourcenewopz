package org.xidea.lite;

/* compiled from: Template */
class ForStatus {
    int index = -1;
    int lastIndex;

    ForStatus(int i) {
        this.lastIndex = i - 1;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }
}
