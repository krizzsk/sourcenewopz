package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {

    /* renamed from: g */
    private static final String[] f1618g = new String[128];

    /* renamed from: a */
    int f1619a;

    /* renamed from: b */
    int[] f1620b = new int[32];

    /* renamed from: c */
    String[] f1621c = new String[32];

    /* renamed from: d */
    int[] f1622d = new int[32];

    /* renamed from: e */
    boolean f1623e;

    /* renamed from: f */
    boolean f1624f;

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    static {
        for (int i = 0; i <= 31; i++) {
            f1618g[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = f1618g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* renamed from: of */
    public static JsonReader m1433of(BufferedSource bufferedSource) {
        return new C1514b(bufferedSource);
    }

    JsonReader() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo15468a(int i) {
        int i2 = this.f1619a;
        int[] iArr = this.f1620b;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f1620b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f1621c;
                this.f1621c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f1622d;
                this.f1622d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f1620b;
        int i3 = this.f1619a;
        this.f1619a = i3 + 1;
        iArr3[i3] = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final JsonEncodingException mo15467a(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public final String getPath() {
        return C1513a.m1437a(this.f1619a, this.f1620b, this.f1621c, this.f1622d);
    }

    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        /* renamed from: of */
        public static Options m1436of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.m1432b(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.m3612of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1432b(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f1618g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                bufferedSink.writeUtf8(str, i, i2);
            }
            bufferedSink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
    }
}
