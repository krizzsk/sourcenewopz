package com.adyen.threeds2.customization;

import com.adyen.threeds2.exception.InvalidInputException;

public final class ToolbarCustomization extends Customization {

    /* renamed from: d */
    private String f988d;

    /* renamed from: e */
    private String f989e;

    /* renamed from: f */
    private String f990f;

    public String getBackgroundColor() {
        return this.f988d;
    }

    public String getButtonText() {
        return this.f990f;
    }

    public String getHeaderText() {
        return this.f989e;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.f988d = mo14764a(str);
    }

    public void setButtonText(String str) throws InvalidInputException {
        this.f990f = mo14765a("buttonText", str);
    }

    public void setHeaderText(String str) throws InvalidInputException {
        this.f989e = mo14765a("headerText", str);
    }
}
