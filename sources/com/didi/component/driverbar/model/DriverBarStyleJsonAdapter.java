package com.didi.component.driverbar.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/driverbar/model/DriverBarStyleJsonAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/didi/component/driverbar/model/DriverBarStyle;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarStyleJsonAdapter.kt */
public final class DriverBarStyleJsonAdapter extends TypeAdapter<DriverBarStyle> {
    public void write(JsonWriter jsonWriter, DriverBarStyle driverBarStyle) {
        JsonWriter jsonWriter2;
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (driverBarStyle == null) {
            jsonWriter2 = null;
        } else {
            jsonWriter2 = jsonWriter.value(driverBarStyle == DriverBarStyle.JAPAN_STYLE ? "japan" : "");
        }
        if (jsonWriter2 == null) {
            jsonWriter.nullValue();
        }
    }

    public DriverBarStyle read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        DriverBarStyle driverBarStyle = null;
        if (!(jsonReader.peek() != JsonToken.NULL)) {
            jsonReader = null;
        }
        if (jsonReader != null) {
            driverBarStyle = StringsKt.equals(jsonReader.nextString(), "japan", true) ? DriverBarStyle.JAPAN_STYLE : DriverBarStyle.DEFAULT_STYLE;
        }
        return driverBarStyle == null ? DriverBarStyle.DEFAULT_STYLE : driverBarStyle;
    }
}
