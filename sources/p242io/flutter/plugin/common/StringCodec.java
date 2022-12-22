package p242io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: io.flutter.plugin.common.StringCodec */
public final class StringCodec implements MessageCodec<String> {
    public static final StringCodec INSTANCE = new StringCodec();

    /* renamed from: a */
    private static final Charset f57780a = Charset.forName("UTF8");

    private StringCodec() {
    }

    public ByteBuffer encodeMessage(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f57780a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }

    public String decodeMessage(ByteBuffer byteBuffer) {
        int i;
        byte[] bArr;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i = 0;
        }
        return new String(bArr, i, remaining, f57780a);
    }
}
