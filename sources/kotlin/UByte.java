package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@JvmInline
@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\b¢\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, mo175978d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: UByte.kt */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;

    /* renamed from: a */
    private final byte f59793a;

    /* renamed from: a */
    private int m42318a(byte b) {
        return m42319a(this.f59793a, b);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m47698boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m47699constructorimpl(byte b) {
        return b;
    }

    /* renamed from: e */
    private static final byte m42338e(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47700equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m47704unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47701equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    /* renamed from: f */
    private static final short m42347f(byte b) {
        return (short) (((short) b) & 255);
    }

    /* renamed from: g */
    private static final int m42348g(byte b) {
        return b & 255;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: h */
    private static final long m42355h(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47702hashCodeimpl(byte b) {
        return b;
    }

    /* renamed from: i */
    private static final byte m42358i(byte b) {
        return b;
    }

    /* renamed from: m */
    private static final float m42366m(byte b) {
        return (float) (b & 255);
    }

    /* renamed from: n */
    private static final double m42367n(byte b) {
        return (double) (b & 255);
    }

    public boolean equals(Object obj) {
        return m47700equalsimpl(this.f59793a, obj);
    }

    public int hashCode() {
        return m47702hashCodeimpl(this.f59793a);
    }

    public String toString() {
        return m47703toStringimpl(this.f59793a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m47704unboximpl() {
        return this.f59793a;
    }

    private /* synthetic */ UByte(byte b) {
        this.f59793a = b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m42318a(((UByte) obj).m47704unboximpl());
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, mo175978d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: UByte.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private static int m42319a(byte b, byte b2) {
        return Intrinsics.compare((int) b & 255, (int) b2 & 255);
    }

    /* renamed from: a */
    private static final int m42322a(byte b, short s) {
        return Intrinsics.compare((int) b & 255, (int) s & UShort.MAX_VALUE);
    }

    /* renamed from: a */
    private static final int m42320a(byte b, int i) {
        return UnsignedKt.uintCompare(UInt.m47724constructorimpl(b & 255), i);
    }

    /* renamed from: a */
    private static final int m42321a(byte b, long j) {
        return UnsignedKt.ulongCompare(ULong.m47749constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: b */
    private static final int m42324b(byte b, byte b2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) + UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: b */
    private static final int m42326b(byte b, short s) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) + UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: b */
    private static final int m42325b(byte b, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) + i);
    }

    /* renamed from: b */
    private static final long m42327b(byte b, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) b) & 255) + j);
    }

    /* renamed from: c */
    private static final int m42329c(byte b, byte b2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) - UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: c */
    private static final int m42331c(byte b, short s) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) - UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: c */
    private static final int m42330c(byte b, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) - i);
    }

    /* renamed from: c */
    private static final long m42332c(byte b, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) b) & 255) - j);
    }

    /* renamed from: d */
    private static final int m42334d(byte b, byte b2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) * UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: d */
    private static final int m42336d(byte b, short s) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) * UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: d */
    private static final int m42335d(byte b, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(b & 255) * i);
    }

    /* renamed from: d */
    private static final long m42337d(byte b, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) b) & 255) * j);
    }

    /* renamed from: e */
    private static final int m42339e(byte b, byte b2) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: e */
    private static final int m42341e(byte b, short s) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: e */
    private static final int m42340e(byte b, int i) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), i);
    }

    /* renamed from: e */
    private static final long m42342e(byte b, long j) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(ULong.m47749constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: f */
    private static final int m42343f(byte b, byte b2) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: f */
    private static final int m42345f(byte b, short s) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: f */
    private static final int m42344f(byte b, int i) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), i);
    }

    /* renamed from: f */
    private static final long m42346f(byte b, long j) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(ULong.m47749constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: g */
    private static final int m42349g(byte b, byte b2) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(b2 & 255));
    }

    /* renamed from: g */
    private static final int m42351g(byte b, short s) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: g */
    private static final int m42350g(byte b, int i) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(b & 255), i);
    }

    /* renamed from: g */
    private static final long m42352g(byte b, long j) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(ULong.m47749constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: h */
    private static final byte m42353h(byte b, byte b2) {
        return m47699constructorimpl((byte) UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(b2 & 255)));
    }

    /* renamed from: h */
    private static final short m42357h(byte b, short s) {
        return UShort.m47774constructorimpl((short) UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: h */
    private static final int m42354h(byte b, int i) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(b & 255), i);
    }

    /* renamed from: h */
    private static final long m42356h(byte b, long j) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(ULong.m47749constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: b */
    private static final byte m42323b(byte b) {
        return m47699constructorimpl((byte) (b + 1));
    }

    /* renamed from: c */
    private static final byte m42328c(byte b) {
        return m47699constructorimpl((byte) (b - 1));
    }

    /* renamed from: i */
    private static final UIntRange m42359i(byte b, byte b2) {
        return new UIntRange(UInt.m47724constructorimpl(b & 255), UInt.m47724constructorimpl(b2 & 255), (DefaultConstructorMarker) null);
    }

    /* renamed from: j */
    private static final byte m42360j(byte b, byte b2) {
        return m47699constructorimpl((byte) (b & b2));
    }

    /* renamed from: k */
    private static final byte m42362k(byte b, byte b2) {
        return m47699constructorimpl((byte) (b | b2));
    }

    /* renamed from: l */
    private static final byte m42364l(byte b, byte b2) {
        return m47699constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: d */
    private static final byte m42333d(byte b) {
        return m47699constructorimpl((byte) (~b));
    }

    /* renamed from: j */
    private static final short m42361j(byte b) {
        return UShort.m47774constructorimpl((short) (((short) b) & 255));
    }

    /* renamed from: k */
    private static final int m42363k(byte b) {
        return UInt.m47724constructorimpl(b & 255);
    }

    /* renamed from: l */
    private static final long m42365l(byte b) {
        return ULong.m47749constructorimpl(((long) b) & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47703toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }
}
