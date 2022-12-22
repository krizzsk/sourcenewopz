package com.didiglobal.font;

public enum DiDiTypeface {
    FONT_REGULAR(0),
    FONT_BOLD(1),
    FONT_ITALIC(2),
    FONT_BOLD_ITALIC(3),
    FONT_THIN(4),
    FONT_THIN_ITALIC(6),
    FONT_MEDIUM(5),
    FONT_MEDIUM_ITALIC(7);
    
    private int type;

    private DiDiTypeface(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
