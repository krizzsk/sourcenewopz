package com.cardinalcommerce.p060a;

import android.graphics.Typeface;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import java.io.Serializable;

/* renamed from: com.cardinalcommerce.a.setWidth */
public class setWidth implements Serializable {
    private int Cardinal;
    private String cca_continue;
    private String getInstance = Typeface.DEFAULT.toString();

    public String getTextFontName() {
        return this.getInstance;
    }

    public void setTextFontName(String str) throws InvalidInputException {
        Throwable th = new Throwable("Caught in ButtonCustomization.setTextFontName");
        if (str == null || str.isEmpty()) {
            throw new InvalidInputException("InvalidInputException", th);
        }
        this.getInstance = str;
    }

    public String getTextColor() {
        return this.cca_continue;
    }

    public void setTextColor(String str) throws InvalidInputException {
        if (str == null || str.isEmpty()) {
            throw new InvalidInputException("InvalidInputException", new Throwable("Caught in ButtonCustomization.setTextColor"));
        }
        this.cca_continue = str;
    }

    public int getTextFontSize() {
        return this.Cardinal;
    }

    public void setTextFontSize(int i) throws InvalidInputException {
        if (i >= 0) {
            this.Cardinal = i;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Caught in ButtonCustomization.setTextFontSize"));
    }
}
