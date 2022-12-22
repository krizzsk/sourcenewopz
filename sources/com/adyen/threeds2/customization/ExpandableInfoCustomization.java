package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;
import com.didi.soda.blocks.constant.Const;

public final class ExpandableInfoCustomization extends Customization {

    /* renamed from: d */
    private String f966d;

    /* renamed from: e */
    private String f967e;

    /* renamed from: f */
    private int f968f = -1;

    /* renamed from: g */
    private String f969g;

    /* renamed from: h */
    private int f970h = -1;

    /* renamed from: i */
    private String f971i;

    /* renamed from: j */
    private String f972j;

    public String getBorderColor() {
        return this.f969g;
    }

    public int getBorderWidth() {
        return this.f970h;
    }

    public String getExpandedStateIndicatorColor() {
        return this.f971i;
    }

    public String getHeadingTextColor() {
        return this.f966d;
    }

    public String getHeadingTextFontName() {
        return this.f967e;
    }

    public int getHeadingTextFontSize() {
        return this.f968f;
    }

    public String getHighlightedBackgroundColor() {
        return this.f972j;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.f969g = mo14764a(str);
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.f970h = mo14763a("borderWidth", i).intValue();
    }

    public void setExpandStateIndicatorColor(String str) throws InvalidInputException {
        this.f971i = mo14764a(str);
    }

    public void setHeadingTextColor(String str) throws InvalidInputException {
        this.f966d = mo14764a(str);
    }

    public void setHeadingTextFontName(String str) throws InvalidInputException {
        this.f967e = mo14765a("fontName", str);
    }

    public void setHeadingTextFontSize(int i) throws InvalidInputException {
        this.f968f = mo14763a(Const.BlockParamConst.FONT_SIZE, i).intValue();
    }

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        this.f972j = mo14764a(str);
    }
}
