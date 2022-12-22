package com.cardinalcommerce.shared.models;

import com.cardinalcommerce.p060a.setAutoSizeTextTypeWithDefaults;

public class Warning {

    /* renamed from: a */
    private String f3276a;

    /* renamed from: b */
    private String f3277b;

    /* renamed from: c */
    private setAutoSizeTextTypeWithDefaults f3278c;

    public Warning() {
    }

    public Warning(String str, String str2, setAutoSizeTextTypeWithDefaults setautosizetexttypewithdefaults) {
        this.f3276a = str;
        this.f3277b = str2;
        this.f3278c = setautosizetexttypewithdefaults;
    }

    public String getID() {
        return this.f3276a;
    }

    public String getMessage() {
        return this.f3277b;
    }

    public setAutoSizeTextTypeWithDefaults getSeverity() {
        return this.f3278c;
    }
}
