package p242io.socket.engineio.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p242io.socket.utf8.UTF8;
import p242io.socket.utf8.UTF8Exception;

/* renamed from: io.socket.engineio.parser.Parser */
public class Parser {
    public static final int PROTOCOL = 3;

    /* renamed from: a */
    private static final int f59544a = String.valueOf(Integer.MAX_VALUE).length();

    /* renamed from: b */
    private static final Map<String, Integer> f59545b = new HashMap<String, Integer>() {
        {
            put("open", 0);
            put("close", 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put(Packet.NOOP, 6);
        }
    };

    /* renamed from: c */
    private static final Map<Integer, String> f59546c = new HashMap();

    /* renamed from: d */
    private static Packet<String> f59547d = new Packet<>("error", "parser error");

    /* renamed from: e */
    private static UTF8.Options f59548e;

    /* renamed from: io.socket.engineio.parser.Parser$DecodePayloadCallback */
    public interface DecodePayloadCallback<T> {
        boolean call(Packet<T> packet, int i, int i2);
    }

    /* renamed from: io.socket.engineio.parser.Parser$EncodeCallback */
    public interface EncodeCallback<T> {
        void call(T t);
    }

    static {
        for (Map.Entry next : f59545b.entrySet()) {
            f59546c.put(next.getValue(), next.getKey());
        }
        UTF8.Options options = new UTF8.Options();
        f59548e = options;
        options.strict = false;
    }

    private Parser() {
    }

    public static void encodePacket(Packet packet, EncodeCallback encodeCallback) throws UTF8Exception {
        encodePacket(packet, false, encodeCallback);
    }

    public static void encodePacket(Packet packet, boolean z, EncodeCallback encodeCallback) throws UTF8Exception {
        if (packet.data instanceof byte[]) {
            m42055a((Packet<byte[]>) packet, (EncodeCallback<byte[]>) encodeCallback);
            return;
        }
        String valueOf = String.valueOf(f59545b.get(packet.type));
        if (packet.data != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            String valueOf2 = String.valueOf(packet.data);
            if (z) {
                valueOf2 = UTF8.encode(valueOf2, f59548e);
            }
            sb.append(valueOf2);
            valueOf = sb.toString();
        }
        encodeCallback.call(valueOf);
    }

    /* renamed from: a */
    private static void m42055a(Packet<byte[]> packet, EncodeCallback<byte[]> encodeCallback) {
        byte[] bArr = (byte[]) packet.data;
        byte[] bArr2 = new byte[(bArr.length + 1)];
        bArr2[0] = f59545b.get(packet.type).byteValue();
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        encodeCallback.call(bArr2);
    }

    public static Packet<String> decodePacket(String str) {
        return decodePacket(str, false);
    }

    public static Packet<String> decodePacket(String str, boolean z) {
        int i;
        if (str == null) {
            return f59547d;
        }
        try {
            i = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (z) {
            try {
                str = UTF8.decode(str, f59548e);
            } catch (UTF8Exception unused2) {
                return f59547d;
            }
        }
        if (i < 0 || i >= f59546c.size()) {
            return f59547d;
        }
        if (str.length() > 1) {
            return new Packet<>(f59546c.get(Integer.valueOf(i)), str.substring(1));
        }
        return new Packet<>(f59546c.get(Integer.valueOf(i)));
    }

    public static Packet<byte[]> decodePacket(byte[] bArr) {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return new Packet<>(f59546c.get(Integer.valueOf(b)), bArr2);
    }

    public static void encodePayload(Packet[] packetArr, EncodeCallback encodeCallback) throws UTF8Exception {
        for (Packet packet : packetArr) {
            if (packet.data instanceof byte[]) {
                m42056a(packetArr, (EncodeCallback<byte[]>) encodeCallback);
                return;
            }
        }
        if (packetArr.length == 0) {
            encodeCallback.call("0:");
            return;
        }
        final StringBuilder sb = new StringBuilder();
        for (Packet encodePacket : packetArr) {
            encodePacket(encodePacket, false, new EncodeCallback() {
                public void call(Object obj) {
                    sb.append(Parser.m42059c((String) obj));
                }
            });
        }
        encodeCallback.call(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m42059c(String str) {
        return str.length() + ":" + str;
    }

    /* renamed from: a */
    private static void m42056a(Packet[] packetArr, EncodeCallback<byte[]> encodeCallback) throws UTF8Exception {
        if (packetArr.length == 0) {
            encodeCallback.call(new byte[0]);
            return;
        }
        final ArrayList arrayList = new ArrayList(packetArr.length);
        for (Packet b : packetArr) {
            m42057b(b, new EncodeCallback<byte[]>() {
                public void call(byte[] bArr) {
                    arrayList.add(bArr);
                }
            });
        }
        encodeCallback.call(C21332a.m42061a((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
    }

    /* renamed from: b */
    private static void m42057b(Packet packet, final EncodeCallback<byte[]> encodeCallback) throws UTF8Exception {
        encodePacket(packet, true, new EncodeCallback() {
            public void call(Object obj) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    String valueOf = String.valueOf(str.length());
                    int length = valueOf.length() + 2;
                    byte[] bArr = new byte[length];
                    bArr[0] = 0;
                    int i = 0;
                    while (i < valueOf.length()) {
                        int i2 = i + 1;
                        bArr[i2] = (byte) Character.getNumericValue(valueOf.charAt(i));
                        i = i2;
                    }
                    bArr[length - 1] = -1;
                    encodeCallback.call(C21332a.m42061a(new byte[][]{bArr, Parser.m42060d(str)}));
                    return;
                }
                byte[] bArr2 = (byte[]) obj;
                String valueOf2 = String.valueOf(bArr2.length);
                int length2 = valueOf2.length() + 2;
                byte[] bArr3 = new byte[length2];
                bArr3[0] = 1;
                int i3 = 0;
                while (i3 < valueOf2.length()) {
                    int i4 = i3 + 1;
                    bArr3[i4] = (byte) Character.getNumericValue(valueOf2.charAt(i3));
                    i3 = i4;
                }
                bArr3[length2 - 1] = -1;
                encodeCallback.call(C21332a.m42061a(new byte[][]{bArr3, bArr2}));
            }
        });
    }

    public static void decodePayload(String str, DecodePayloadCallback<String> decodePayloadCallback) {
        if (str == null || str.length() == 0) {
            decodePayloadCallback.call(f59547d, 0, 1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (':' != charAt) {
                sb.append(charAt);
            } else {
                try {
                    int parseInt = Integer.parseInt(sb.toString());
                    int i2 = i + 1;
                    try {
                        String substring = str.substring(i2, i2 + parseInt);
                        if (substring.length() != 0) {
                            Packet<String> decodePacket = decodePacket(substring, false);
                            if (f59547d.type.equals(decodePacket.type) && ((String) f59547d.data).equals(decodePacket.data)) {
                                decodePayloadCallback.call(f59547d, 0, 1);
                                return;
                            } else if (!decodePayloadCallback.call(decodePacket, i + parseInt, length)) {
                                return;
                            }
                        }
                        i += parseInt;
                        sb = new StringBuilder();
                    } catch (IndexOutOfBoundsException unused) {
                        decodePayloadCallback.call(f59547d, 0, 1);
                        return;
                    }
                } catch (NumberFormatException unused2) {
                    decodePayloadCallback.call(f59547d, 0, 1);
                    return;
                }
            }
            i++;
        }
        if (sb.length() > 0) {
            decodePayloadCallback.call(f59547d, 0, 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r10.position(r1.length() + 1);
        r10 = r10.slice();
        r1 = java.lang.Integer.parseInt(r1.toString());
        r10.position(1);
        r1 = r1 + 1;
        r10.limit(r1);
        r2 = new byte[r10.remaining()];
        r10.get(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r4 == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r0.add(m42054a(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        r0.add(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void decodePayload(byte[] r10, p242io.socket.engineio.parser.Parser.DecodePayloadCallback r11) {
        /*
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0009:
            int r1 = r10.capacity()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L_0x007a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            byte r4 = r10.get(r2)
            r5 = 255(0xff, float:3.57E-43)
            r4 = r4 & r5
            if (r4 != 0) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r6 = 1
        L_0x0023:
            byte r7 = r10.get(r6)
            r7 = r7 & r5
            if (r7 != r5) goto L_0x0066
            int r2 = r1.length()
            int r2 = r2 + r3
            r10.position(r2)
            java.nio.ByteBuffer r10 = r10.slice()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            r10.position(r3)
            int r1 = r1 + r3
            r10.limit(r1)
            int r2 = r10.remaining()
            byte[] r2 = new byte[r2]
            r10.get(r2)
            if (r4 == 0) goto L_0x0058
            java.lang.String r2 = m42054a((byte[]) r2)
            r0.add(r2)
            goto L_0x005b
        L_0x0058:
            r0.add(r2)
        L_0x005b:
            r10.clear()
            r10.position(r1)
            java.nio.ByteBuffer r10 = r10.slice()
            goto L_0x0009
        L_0x0066:
            int r8 = r1.length()
            int r9 = f59544a
            if (r8 <= r9) goto L_0x0074
            io.socket.engineio.parser.Packet<java.lang.String> r10 = f59547d
            r11.call(r10, r2, r3)
            return
        L_0x0074:
            r1.append(r7)
            int r6 = r6 + 1
            goto L_0x0023
        L_0x007a:
            int r10 = r0.size()
        L_0x007e:
            if (r2 >= r10) goto L_0x00a4
            java.lang.Object r1 = r0.get(r2)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x0092
            java.lang.String r1 = (java.lang.String) r1
            io.socket.engineio.parser.Packet r1 = decodePacket(r1, r3)
            r11.call(r1, r2, r10)
            goto L_0x00a1
        L_0x0092:
            boolean r4 = r1 instanceof byte[]
            if (r4 == 0) goto L_0x00a1
            byte[] r1 = (byte[]) r1
            byte[] r1 = (byte[]) r1
            io.socket.engineio.parser.Packet r1 = decodePacket((byte[]) r1)
            r11.call(r1, r2, r10)
        L_0x00a1:
            int r2 = r2 + 1
            goto L_0x007e
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.socket.engineio.parser.Parser.decodePayload(byte[], io.socket.engineio.parser.Parser$DecodePayloadCallback):void");
    }

    /* renamed from: a */
    private static String m42054a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.appendCodePoint(b & 255);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static byte[] m42060d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }
}
