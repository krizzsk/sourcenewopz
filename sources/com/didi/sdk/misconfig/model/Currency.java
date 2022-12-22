package com.didi.sdk.misconfig.model;

import java.io.Serializable;

public class Currency implements Serializable {
    private String abbr;
    private String symbol;
    private String unit;

    public String getUnit() {
        return this.unit;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
