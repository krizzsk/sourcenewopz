package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;
import com.didi.soda.blocks.constant.Const;

public final class LabelCustomization extends Customization {

    /* renamed from: d */
    private String f973d;

    /* renamed from: e */
    private String f974e;

    /* renamed from: f */
    private int f975f = -1;

    /* renamed from: g */
    private String f976g;

    /* renamed from: h */
    private String f977h;

    /* renamed from: i */
    private int f978i = -1;

    public String getHeadingTextColor() {
        return this.f973d;
    }

    public String getHeadingTextFontName() {
        return this.f974e;
    }

    public int getHeadingTextFontSize() {
        return this.f975f;
    }

    public String getInputLabelTextColor() {
        return this.f976g;
    }

    public String getInputLabelTextFontName() {
        return this.f977h;
    }

    public int getInputLabelTextFontSize() {
        return this.f978i;
    }

    public void setHeadingTextColor(String str) throws InvalidInputException {
        this.f973d = mo14764a(str);
    }

    public void setHeadingTextFontName(String str) throws InvalidInputException {
        this.f974e = mo14765a("fontName", str);
    }

    public void setHeadingTextFontSize(int i) throws InvalidInputException {
        this.f975f = mo14763a(Const.BlockParamConst.FONT_SIZE, i).intValue();
    }

    public void setInputLabelTextColor(String str) throws InvalidInputException {
        this.f976g = mo14764a(str);
    }

    public void setInputLabelTextFontName(String str) throws InvalidInputException {
        this.f977h = mo14765a("fontName", str);
    }

    public void setInputLabelTextFontSize(int i) throws InvalidInputException {
        this.f978i = mo14763a(Const.BlockParamConst.FONT_SIZE, i).intValue();
    }
}
