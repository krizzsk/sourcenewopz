package com.didi.map.base.bubble;

import java.util.List;

public abstract class BaseBubbleBitmapOpt {
    public static final int INDEX_BUBBLE_ID = 2;
    public static final int INDEX_BUBBLE_RECT_INDEX = 4;
    public static final int INDEX_TYPE = 1;
    public static final String SEPARATOR = "|";
    private long bubbleId;
    private List<String> fileNams;
    private boolean isNight;
    public final String loadTag;

    public abstract String getResourcePaths();

    public BaseBubbleBitmapOpt(String str, long j) {
        this.loadTag = str;
        this.bubbleId = j;
    }

    public BaseBubbleBitmapOpt(String str) {
        this.loadTag = str;
    }

    public boolean isNight() {
        return this.isNight;
    }

    public void setNight(boolean z) {
        this.isNight = z;
    }

    public void setFileNams(List<String> list) {
        this.fileNams = list;
    }

    public String getFileName(int i) {
        return this.fileNams.get(i);
    }

    public void attachBubble(long j) {
        this.bubbleId = j;
    }

    public String toString() {
        return "|" + this.loadTag + "|" + this.bubbleId + "|";
    }
}
