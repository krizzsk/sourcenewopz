package kotlin.experimental;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f¨\u0006\u0007"}, mo175978d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, mo175979k = 2, mo175980mv = {1, 5, 1})
/* compiled from: bitwiseOperations.kt */
public final class BitwiseOperationsKt {
    /* renamed from: a */
    private static final byte m43989a(byte b) {
        return (byte) (~b);
    }

    /* renamed from: a */
    private static final byte m43990a(byte b, byte b2) {
        return (byte) (b & b2);
    }

    /* renamed from: a */
    private static final short m43991a(short s) {
        return (short) (~s);
    }

    /* renamed from: a */
    private static final short m43992a(short s, short s2) {
        return (short) (s & s2);
    }

    /* renamed from: b */
    private static final byte m43993b(byte b, byte b2) {
        return (byte) (b | b2);
    }

    /* renamed from: b */
    private static final short m43994b(short s, short s2) {
        return (short) (s | s2);
    }

    /* renamed from: c */
    private static final byte m43995c(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    /* renamed from: c */
    private static final short m43996c(short s, short s2) {
        return (short) (s ^ s2);
    }
}
