package com.android.didi.bfflib.business;

import android.os.Looper;
import com.android.didi.bfflib.utils.BffThreadPool;
import com.didi.sdk.util.TextUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

class GsonUtil {
    private static final Gson gson;

    public interface OnFromJsonListener<T> {
        void onFail();

        void onSuccess(T t);
    }

    GsonUtil() {
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(Integer.TYPE, Integer.class, new TypeAdapter<Integer>() {
            public Integer read(JsonReader jsonReader) throws IOException {
                int i = 0;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return 0;
                }
                String nextString = jsonReader.nextString();
                if (TextUtil.isEmpty(nextString)) {
                    return 0;
                }
                try {
                    i = Integer.parseInt(nextString);
                } catch (NumberFormatException unused) {
                }
                return Integer.valueOf(i);
            }

            public void write(JsonWriter jsonWriter, Integer num) throws IOException {
                if (num == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value((Number) num);
                }
            }
        }));
        gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, new TypeAdapter<Boolean>() {
            public Boolean read(JsonReader jsonReader) throws IOException {
                boolean z = false;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return false;
                } else if (jsonReader.peek() != JsonToken.STRING) {
                    return Boolean.valueOf(jsonReader.nextBoolean());
                } else {
                    String nextString = jsonReader.nextString();
                    if ("true".equals(nextString) || "1".equals(nextString)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            }

            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                if (bool == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(bool);
                }
            }
        }));
        gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(Double.TYPE, Double.class, new TypeAdapter<Double>() {
            public Double read(JsonReader jsonReader) throws IOException {
                JsonToken peek = jsonReader.peek();
                JsonToken jsonToken = JsonToken.NULL;
                double d = 0.0d;
                Double valueOf = Double.valueOf(0.0d);
                if (peek == jsonToken) {
                    jsonReader.nextNull();
                    return valueOf;
                }
                String nextString = jsonReader.nextString();
                if (TextUtil.isEmpty(nextString)) {
                    return valueOf;
                }
                try {
                    d = Double.parseDouble(nextString);
                } catch (NumberFormatException unused) {
                }
                return Double.valueOf(d);
            }

            public void write(JsonWriter jsonWriter, Double d) throws IOException {
                if (d == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value((Number) d);
                }
            }
        }));
        gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(Float.TYPE, Float.class, new TypeAdapter<Float>() {
            public void write(JsonWriter jsonWriter, Float f) throws IOException {
                if (f == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value((Number) f);
                }
            }

            public Float read(JsonReader jsonReader) throws IOException {
                JsonToken peek = jsonReader.peek();
                JsonToken jsonToken = JsonToken.NULL;
                float f = 0.0f;
                Float valueOf = Float.valueOf(0.0f);
                if (peek == jsonToken) {
                    jsonReader.nextNull();
                    return valueOf;
                }
                String nextString = jsonReader.nextString();
                if (TextUtil.isEmpty(nextString)) {
                    return valueOf;
                }
                try {
                    f = Float.parseFloat(nextString);
                } catch (NumberFormatException unused) {
                }
                return Float.valueOf(f);
            }
        }));
        gsonBuilder.registerTypeAdapterFactory(TypeAdapters.newFactory(Long.TYPE, Long.class, new TypeAdapter<Long>() {
            public void write(JsonWriter jsonWriter, Long l) throws IOException {
                if (l == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value((Number) l);
                }
            }

            public Long read(JsonReader jsonReader) throws IOException {
                long j = 0;
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return 0L;
                }
                String nextString = jsonReader.nextString();
                if (TextUtil.isEmpty(nextString)) {
                    return 0L;
                }
                try {
                    j = Long.parseLong(nextString);
                } catch (NumberFormatException unused) {
                }
                return Long.valueOf(j);
            }
        }));
        gson = gsonBuilder.setPrettyPrinting().create();
    }

    public static <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        checkMainThread();
        if (TextUtil.isEmpty(str) || type == null) {
            return null;
        }
        return gson.fromJson(str, type);
    }

    public static <T> void fromJsonAsync(final String str, final Class<T> cls, final OnFromJsonListener<T> onFromJsonListener) {
        BffThreadPool.execute((BffThreadPool.IORunnable) new BffThreadPool.IORunnable<T>() {
            public T run() {
                try {
                    return GsonUtil.fromJson(str, cls);
                } catch (Exception e) {
                    throw e;
                }
            }

            public void postRun(T t) {
                OnFromJsonListener onFromJsonListener = onFromJsonListener;
                if (onFromJsonListener != null) {
                    if (t != null) {
                        onFromJsonListener.onSuccess(t);
                    } else {
                        onFromJsonListener.onFail();
                    }
                }
            }
        });
    }

    public static <T> void fromJsonAsync(final String str, final Type type, final OnFromJsonListener<T> onFromJsonListener) {
        BffThreadPool.execute((BffThreadPool.IORunnable) new BffThreadPool.IORunnable<T>() {
            public T run() {
                try {
                    return GsonUtil.fromJson(str, type);
                } catch (Exception e) {
                    throw e;
                }
            }

            public void postRun(T t) {
                OnFromJsonListener onFromJsonListener = onFromJsonListener;
                if (onFromJsonListener != null) {
                    if (t != null) {
                        onFromJsonListener.onSuccess(t);
                    } else {
                        onFromJsonListener.onFail();
                    }
                }
            }
        });
    }

    private static void checkMainThread() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new JsonSyntaxException("cant handle json data in main thread.");
        }
    }
}
