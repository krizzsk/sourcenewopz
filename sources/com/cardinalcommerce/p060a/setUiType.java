package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setUiType */
public abstract class setUiType extends setLocationDataConsentGiven {
    setUiType() {
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        return setlocationdataconsentgiven instanceof setUiType;
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
