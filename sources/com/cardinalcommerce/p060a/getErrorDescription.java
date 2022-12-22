package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.getErrorDescription */
public final class getErrorDescription {

    /* renamed from: a */
    private static ValidateResponse f2554a = new ValidateResponse();

    static {
        new CardinalValidateReceiver();
    }

    getErrorDescription() {
    }

    public static ValidateResponse getInstance(setForegroundTintBlendMode setforegroundtintblendmode) {
        return setforegroundtintblendmode.cca_continue.size() <= 0 ? f2554a : new ValidateResponse(setforegroundtintblendmode);
    }
}
