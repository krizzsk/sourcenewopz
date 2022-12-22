package com.xiaojuchefu.prism.monitor.model;

public class ViewTag {
    public boolean append;
    public int tagId;
    public String tagSymbol;

    public ViewTag(int i, String str) {
        this(i, str, true);
    }

    public ViewTag(int i, String str, boolean z) {
        this.tagId = i;
        this.tagSymbol = str;
        this.append = z;
    }
}
