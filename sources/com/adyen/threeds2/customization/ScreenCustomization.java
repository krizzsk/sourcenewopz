package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ScreenCustomization extends Customization {

    /* renamed from: d */
    private String f979d;

    /* renamed from: e */
    private String f980e;

    public String getBackgroundColor() {
        return this.f980e;
    }

    public String getStatusBarColor() {
        return this.f979d;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.f980e = mo14764a(str);
    }

    public void setStatusBarColor(String str) {
        this.f979d = mo14764a(str);
    }
}
