package com.cardinalcommerce.shared.userinterfaces;

import com.cardinalcommerce.p060a.setMinLines;
import com.cardinalcommerce.p060a.setWidth;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;

public class ToolbarCustomization extends setWidth {
    private String cca_continue;
    private String configure;
    private String getInstance;

    public String getBackgroundColor() {
        return this.getInstance;
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        if (setMinLines.cca_continue(str)) {
            this.getInstance = str;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Caught in ToolbarCustomization.setBackgroundColor"));
    }

    public String getHeaderText() {
        return this.cca_continue;
    }

    public void setHeaderText(String str) throws InvalidInputException {
        if (str == null || str.isEmpty()) {
            throw new InvalidInputException("InvalidInputException", new Throwable("Caught in ToolbarCustomization.setHeaderText"));
        }
        this.cca_continue = str;
    }

    public String getButtonText() {
        return this.configure;
    }

    public void setButtonText(String str) throws InvalidInputException {
        if (str == null || str.isEmpty()) {
            throw new InvalidInputException("InvalidInputException", new Throwable("Caught in ToolbarCustomization.setButtonText"));
        }
        this.configure = str;
    }
}
