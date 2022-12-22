package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import net.lingala.zip4j.util.InternalZipConstants;

@JvmInline
@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, mo175978d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ULong.kt */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    /* renamed from: a */
    private final long f59797a;

    /* renamed from: a */
    private int m42434a(long j) {
        return m42437a(this.f59797a, j);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m47748boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47749constructorimpl(long j) {
        return j;
    }

    /* renamed from: e */
    private static final byte m42454e(long j) {
        return (byte) ((int) j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47750equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m47754unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47751equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: f */
    private static final short m42463f(long j) {
        return (short) ((int) j);
    }

    /* renamed from: g */
    private static final int m42464g(long j) {
        return (int) j;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: h */
    private static final long m42471h(long j) {
        return j;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47752hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: l */
    private static final long m42482l(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m47750equalsimpl(this.f59797a, obj);
    }

    public int hashCode() {
        return m47752hashCodeimpl(this.f59797a);
    }

    public String toString() {
        return m47753toStringimpl(this.f59797a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47754unboximpl() {
        return this.f59797a;
    }

    private /* synthetic */ ULong(long j) {
        this.f59797a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m42434a(((ULong) obj).m47754unboximpl());
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, mo175978d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ULong.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private static final int m42435a(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: a */
    private static final int m42438a(long j, short s) {
        return UnsignedKt.ulongCompare(j, m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: a */
    private static final int m42436a(long j, int i) {
        return UnsignedKt.ulongCompare(j, m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: a */
    private static int m42437a(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: b */
    private static final long m42440b(long j, byte b) {
        return m47749constructorimpl(j + m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: b */
    private static final long m42443b(long j, short s) {
        return m47749constructorimpl(j + m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: b */
    private static final long m42441b(long j, int i) {
        return m47749constructorimpl(j + m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: b */
    private static final long m42442b(long j, long j2) {
        return m47749constructorimpl(j + j2);
    }

    /* renamed from: c */
    private static final long m42445c(long j, byte b) {
        return m47749constructorimpl(j - m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: c */
    private static final long m42448c(long j, short s) {
        return m47749constructorimpl(j - m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: c */
    private static final long m42446c(long j, int i) {
        return m47749constructorimpl(j - m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: c */
    private static final long m42447c(long j, long j2) {
        return m47749constructorimpl(j - j2);
    }

    /* renamed from: d */
    private static final long m42450d(long j, byte b) {
        return m47749constructorimpl(j * m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: d */
    private static final long m42453d(long j, short s) {
        return m47749constructorimpl(j * m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: d */
    private static final long m42451d(long j, int i) {
        return m47749constructorimpl(j * m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: d */
    private static final long m42452d(long j, long j2) {
        return m47749constructorimpl(j * j2);
    }

    /* renamed from: e */
    private static final long m42455e(long j, byte b) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: e */
    private static final long m42458e(long j, short s) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: e */
    private static final long m42456e(long j, int i) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: e */
    private static final long m42457e(long j, long j2) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: f */
    private static final long m42459f(long j, byte b) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: f */
    private static final long m42462f(long j, short s) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: f */
    private static final long m42460f(long j, int i) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: f */
    private static final long m42461f(long j, long j2) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: g */
    private static final long m42465g(long j, byte b) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) b) & 255));
    }

    /* renamed from: g */
    private static final long m42468g(long j, short s) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) s) & 65535));
    }

    /* renamed from: g */
    private static final long m42466g(long j, int i) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: g */
    private static final long m42467g(long j, long j2) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: h */
    private static final byte m42469h(long j, byte b) {
        return UByte.m47699constructorimpl((byte) ((int) UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) b) & 255))));
    }

    /* renamed from: h */
    private static final short m42473h(long j, short s) {
        return UShort.m47774constructorimpl((short) ((int) UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) s) & 65535))));
    }

    /* renamed from: h */
    private static final int m42470h(long j, int i) {
        return UInt.m47724constructorimpl((int) UnsignedKt.m47801ulongRemaindereb3DHEI(j, m47749constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT)));
    }

    /* renamed from: h */
    private static final long m42472h(long j, long j2) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: b */
    private static final long m42439b(long j) {
        return m47749constructorimpl(j + 1);
    }

    /* renamed from: c */
    private static final long m42444c(long j) {
        return m47749constructorimpl(j - 1);
    }

    /* renamed from: i */
    private static final ULongRange m42476i(long j, long j2) {
        return new ULongRange(j, j2, (DefaultConstructorMarker) null);
    }

    /* renamed from: i */
    private static final long m42475i(long j, int i) {
        return m47749constructorimpl(j << i);
    }

    /* renamed from: j */
    private static final long m42477j(long j, int i) {
        return m47749constructorimpl(j >>> i);
    }

    /* renamed from: j */
    private static final long m42478j(long j, long j2) {
        return m47749constructorimpl(j & j2);
    }

    /* renamed from: k */
    private static final long m42481k(long j, long j2) {
        return m47749constructorimpl(j | j2);
    }

    /* renamed from: l */
    private static final long m42483l(long j, long j2) {
        return m47749constructorimpl(j ^ j2);
    }

    /* renamed from: d */
    private static final long m42449d(long j) {
        return m47749constructorimpl(~j);
    }

    /* renamed from: i */
    private static final byte m42474i(long j) {
        return UByte.m47699constructorimpl((byte) ((int) j));
    }

    /* renamed from: j */
    private static final short m42479j(long j) {
        return UShort.m47774constructorimpl((short) ((int) j));
    }

    /* renamed from: k */
    private static final int m42480k(long j) {
        return UInt.m47724constructorimpl((int) j);
    }

    /* renamed from: m */
    private static final float m42484m(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: n */
    private static final double m42485n(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47753toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }
}
