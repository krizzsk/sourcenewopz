package org.xidea.lite;

/* compiled from: Template */
class Break extends RuntimeException {
    private static final long serialVersionUID = 1;
    int depth;

    protected Break(int i) {
        this.depth = i;
    }
}
