package org.mozilla.javascript.regexp;

/* compiled from: NativeRegExp */
class RENode {
    int bmsize;
    char chr;
    int flatIndex;
    boolean greedy;
    int index;
    RENode kid;
    RENode kid2;
    int kidlen;
    int length;
    int max;
    int min;
    RENode next;

    /* renamed from: op */
    byte f6659op;
    int parenCount;
    int parenIndex;
    boolean sense;
    int startIndex;

    RENode(byte b) {
        this.f6659op = b;
    }
}
