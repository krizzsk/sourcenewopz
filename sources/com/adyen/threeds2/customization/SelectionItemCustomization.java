package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class SelectionItemCustomization extends Customization {

    /* renamed from: d */
    private String f981d;

    /* renamed from: e */
    private String f982e;

    /* renamed from: f */
    private String f983f;

    /* renamed from: g */
    private int f984g = -1;

    public String getBorderColor() {
        return this.f983f;
    }

    public int getBorderWidth() {
        return this.f984g;
    }

    public String getHighlightedBackgroundColor() {
        return this.f982e;
    }

    public String getSelectionIndicatorTintColor() {
        return this.f981d;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.f983f = mo14764a(str);
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.f984g = mo14763a("borderWidth", i).intValue();
    }

    public void setHighlightedBackgroundColor(String str) throws InvalidInputException {
        this.f982e = mo14764a(str);
    }

    public void setSelectionIndicatorTintColor(String str) throws InvalidInputException {
        this.f981d = mo14764a(str);
    }
}
