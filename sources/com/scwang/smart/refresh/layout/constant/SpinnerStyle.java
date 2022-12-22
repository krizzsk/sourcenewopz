package com.scwang.smart.refresh.layout.constant;

public class SpinnerStyle {
    public static final SpinnerStyle FixedBehind = new SpinnerStyle(2, false, false);
    public static final SpinnerStyle FixedFront = new SpinnerStyle(3, true, false);
    public static final SpinnerStyle MatchLayout;
    @Deprecated
    public static final SpinnerStyle Scale = new SpinnerStyle(1, true, true);
    public static final SpinnerStyle Translate = new SpinnerStyle(0, true, false);
    public static final SpinnerStyle[] values;
    public final boolean front;
    public final int ordinal;
    public final boolean scale;

    static {
        SpinnerStyle spinnerStyle = new SpinnerStyle(4, true, false);
        MatchLayout = spinnerStyle;
        values = new SpinnerStyle[]{Translate, Scale, FixedBehind, FixedFront, spinnerStyle};
    }

    protected SpinnerStyle(int i, boolean z, boolean z2) {
        this.ordinal = i;
        this.front = z;
        this.scale = z2;
    }
}
