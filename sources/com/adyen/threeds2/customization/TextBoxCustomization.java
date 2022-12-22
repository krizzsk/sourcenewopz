package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class TextBoxCustomization extends Customization {

    /* renamed from: d */
    private String f985d;

    /* renamed from: e */
    private int f986e = -1;

    /* renamed from: f */
    private int f987f = -1;

    public String getBorderColor() {
        return this.f985d;
    }

    public int getBorderWidth() {
        return this.f986e;
    }

    public int getCornerRadius() {
        return this.f987f;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.f985d = mo14764a(str);
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.f986e = mo14763a("borderWidth", i).intValue();
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.f987f = mo14763a("cornerRadius", i).intValue();
    }
}
