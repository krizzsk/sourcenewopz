package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ButtonCustomization extends Customization {

    /* renamed from: d */
    private String f961d;

    /* renamed from: e */
    private int f962e = -1;

    public String getBackgroundColor() {
        return this.f961d;
    }

    public int getCornerRadius() {
        return this.f962e;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.f961d = mo14764a(str);
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.f962e = mo14763a("cornerRadius", i).intValue();
    }
}
