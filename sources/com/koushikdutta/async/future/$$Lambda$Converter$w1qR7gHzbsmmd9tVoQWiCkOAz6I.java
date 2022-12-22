package com.koushikdutta.async.future;

import org.json.JSONObject;

/* renamed from: com.koushikdutta.async.future.-$$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I implements TypeConverter {
    public static final /* synthetic */ $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I INSTANCE = new $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I();

    private /* synthetic */ $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I() {
    }

    public final Future convert(Object obj, String str) {
        return new SimpleFuture((JSONObject) obj).thenConvert($$Lambda$aZvS3YDHoKr6bnGLhb3C3itLAc.INSTANCE);
    }
}
