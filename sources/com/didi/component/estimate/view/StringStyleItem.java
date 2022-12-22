package com.didi.component.estimate.view;

public class StringStyleItem {
    public static final int TYPE_BIG_BRACE = 1;
    public static final int TYPE_MIDDLE_BRACKET = 2;
    public int endIndex;
    public int startIndex;
    public final int style;

    private StringStyleItem(int i, int i2, int i3) {
        this.style = i;
        this.startIndex = i2;
        this.endIndex = i3;
    }

    public static StringStyleItem newBigBraceInstance(int i, int i2) {
        return new StringStyleItem(1, i, i2);
    }

    public static StringStyleItem newMiddleBracketInstance(int i, int i2) {
        return new StringStyleItem(2, i, i2);
    }
}
