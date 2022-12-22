package com.didi.sdk.view.picker;

public class PickerString implements IPickerData {

    /* renamed from: a */
    private String f38115a;

    public PickerString(String str) {
        this.f38115a = str;
    }

    public String getSimpleData() {
        return this.f38115a;
    }

    public String toString() {
        return this.f38115a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            return this.f38115a.equals(((PickerString) obj).getSimpleData());
        } catch (Exception unused) {
            return false;
        }
    }
}
