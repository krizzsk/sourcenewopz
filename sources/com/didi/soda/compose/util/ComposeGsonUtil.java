package com.didi.soda.compose.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public final class ComposeGsonUtil {

    /* renamed from: a */
    static volatile Gson f40142a;

    public interface DataNullHandler {

        public enum DataErrorType {
            NULL,
            LACKDATA,
            EMPTYARRAY
        }

        boolean filter(JsonObject jsonObject);

        void handle(DataErrorType dataErrorType, JsonObject jsonObject);
    }

    static {
        BooleanTypeAdapter booleanTypeAdapter = new BooleanTypeAdapter();
        f40142a = new GsonBuilder().registerTypeAdapter(Boolean.class, booleanTypeAdapter).registerTypeAdapter(Boolean.TYPE, booleanTypeAdapter).create();
    }

    private ComposeGsonUtil() {
    }

    public static <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return f40142a.fromJson(str, cls);
    }

    public static <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return f40142a.fromJson(str, type);
    }

    public static <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        return f40142a.fromJson(reader, type);
    }

    public static <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return f40142a.fromJson(jsonElement, type);
    }

    public static String toJson(Object obj) {
        try {
            return f40142a.toJson(obj, (Type) obj.getClass());
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /* renamed from: a */
    private static void m28556a(DataNullHandler dataNullHandler, JsonObject jsonObject, DataNullHandler.DataErrorType dataErrorType) {
        if (dataNullHandler != null) {
            dataNullHandler.handle(dataErrorType, jsonObject);
        }
    }

    static class BooleanTypeAdapter extends TypeAdapter<Boolean> {
        BooleanTypeAdapter() {
        }

        public Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            int i = C135501.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
            boolean z = true;
            if (i == 1) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (i == 2) {
                jsonReader.nextNull();
                return null;
            } else if (i == 3) {
                if (jsonReader.nextInt() == 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 4) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + peek);
            }
        }

        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            if (bool == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(bool);
            }
        }
    }

    /* renamed from: com.didi.soda.compose.util.ComposeGsonUtil$1 */
    static /* synthetic */ class C135501 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$gson$stream$JsonToken = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.compose.util.ComposeGsonUtil.C135501.<clinit>():void");
        }
    }
}
