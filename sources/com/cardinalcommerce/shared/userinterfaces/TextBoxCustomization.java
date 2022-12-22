package com.cardinalcommerce.shared.userinterfaces;

import com.cardinalcommerce.p060a.setMinLines;
import com.cardinalcommerce.p060a.setWidth;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;

public class TextBoxCustomization extends setWidth {
    private int Cardinal = 0;
    private String configure = "#545454";
    private int init = 0;

    public int getBorderWidth() {
        return this.Cardinal;
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        if (i > 0) {
            this.Cardinal = i;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Caught in TextBoxCustomization.setBorderWidth"));
    }

    public String getBorderColor() {
        return this.configure;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        if (setMinLines.cca_continue(str)) {
            this.configure = str;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Caught in TextBoxCustomization.setBorderColor"));
    }

    public int getCornerRadius() {
        return this.init;
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        if (i > 0) {
            this.init = i;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Caught in TextBoxCustomization.setCornerRadius"));
    }

    public TextBoxCustomization() {
        setTextFontSize(0);
    }
}
