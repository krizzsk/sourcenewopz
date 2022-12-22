package p242io.socket.engineio.parser;

import java.nio.ByteBuffer;

/* renamed from: io.socket.engineio.parser.a */
/* compiled from: Parser */
class C21332a {
    private C21332a() {
    }

    /* renamed from: a */
    public static byte[] m42061a(byte[][] bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        return m42062a(bArr, i);
    }

    /* renamed from: a */
    public static byte[] m42062a(byte[][] bArr, int i) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (byte[] put : bArr) {
            allocate.put(put);
        }
        return allocate.array();
    }
}
