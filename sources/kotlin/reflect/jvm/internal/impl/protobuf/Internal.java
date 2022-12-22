package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return C21706a.m44835a(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }
}
