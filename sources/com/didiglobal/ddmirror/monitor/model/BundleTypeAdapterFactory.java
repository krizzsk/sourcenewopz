package com.didiglobal.ddmirror.monitor.model;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BundleTypeAdapterFactory implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(final Gson gson, TypeToken<T> typeToken) {
        if (!Bundle.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        return new TypeAdapter<Bundle>() {
            public void write(JsonWriter jsonWriter, Bundle bundle) throws IOException {
                if (bundle == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                for (String str : bundle.keySet()) {
                    jsonWriter.name(str);
                    Object obj = bundle.get(str);
                    if (obj == null) {
                        jsonWriter.nullValue();
                    } else {
                        gson.toJson(obj, (Type) obj.getClass(), jsonWriter);
                    }
                }
                jsonWriter.endObject();
            }

            public Bundle read(JsonReader jsonReader) throws IOException {
                int i = C166942.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
                if (i == 1) {
                    jsonReader.nextNull();
                    return null;
                } else if (i == 2) {
                    return toBundle(readObject(jsonReader));
                } else {
                    throw new IOException("expecting object: " + jsonReader.getPath());
                }
            }

            private Bundle toBundle(List<Pair<String, Object>> list) throws IOException {
                Bundle bundle = new Bundle();
                for (Pair next : list) {
                    String str = (String) next.first;
                    Object obj = next.second;
                    if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str, (Parcelable) obj);
                    } else if (obj instanceof List) {
                        bundle.putParcelable(str, toBundle((List) obj));
                    } else {
                        throw new IOException("Unparcelable key, value: " + str + ", " + obj);
                    }
                }
                return bundle;
            }

            private List<Pair<String, Object>> readObject(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginObject();
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    int i = C166942.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
                    if (i == 3) {
                        arrayList.add(new Pair(jsonReader.nextName(), readValue(jsonReader)));
                    } else if (i != 4) {
                        throw new IOException("expecting object: " + jsonReader.getPath());
                    }
                }
                jsonReader.endObject();
                return arrayList;
            }

            private Object readValue(JsonReader jsonReader) throws IOException {
                int i = C166942.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
                if (i == 1) {
                    jsonReader.nextNull();
                    return null;
                } else if (i == 2) {
                    return readObject(jsonReader);
                } else {
                    if (i == 5) {
                        return readArray(jsonReader);
                    }
                    if (i == 6) {
                        return Boolean.valueOf(jsonReader.nextBoolean());
                    }
                    if (i == 7) {
                        return readNumber(jsonReader);
                    }
                    if (i == 8) {
                        return jsonReader.nextString();
                    }
                    throw new IOException("expecting value: " + jsonReader.getPath());
                }
            }

            private Object readNumber(JsonReader jsonReader) throws IOException {
                double nextDouble = jsonReader.nextDouble();
                if (nextDouble - Math.ceil(nextDouble) != 0.0d) {
                    return Double.valueOf(nextDouble);
                }
                long j = (long) nextDouble;
                if (j < -2147483648L || j > 2147483647L) {
                    return Long.valueOf(j);
                }
                return Integer.valueOf((int) j);
            }

            private List readArray(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.peek() != JsonToken.END_ARRAY) {
                    arrayList.add(readValue(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            }
        };
    }

    /* renamed from: com.didiglobal.ddmirror.monitor.model.BundleTypeAdapterFactory$2 */
    static /* synthetic */ class C166942 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$gson$stream$JsonToken = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$gson$stream$JsonToken     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.monitor.model.BundleTypeAdapterFactory.C166942.<clinit>():void");
        }
    }
}
