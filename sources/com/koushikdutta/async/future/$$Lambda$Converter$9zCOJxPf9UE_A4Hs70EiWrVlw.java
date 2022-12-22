package com.koushikdutta.async.future;

/* renamed from: com.koushikdutta.async.future.-$$Lambda$Converter$9zCOJxPf9UE_A4H-s7-0EiWrVlw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw implements TypeConverter {
    public static final /* synthetic */ $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw INSTANCE = new $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw();

    private /* synthetic */ $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw() {
    }

    public final Future convert(Object obj, String str) {
        return new SimpleFuture((String) obj).thenConvert($$Lambda$nLUzEUAkwlIcHRA8apYh908V4g.INSTANCE);
    }
}
