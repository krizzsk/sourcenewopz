package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@JvmInline
@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\b¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u"}, mo175978d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: UShort.kt */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;

    /* renamed from: a */
    private final short f59799a;

    /* renamed from: a */
    private int m42522a(short s) {
        return m42526a(this.f59799a, s);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m47773boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m47774constructorimpl(short s) {
        return s;
    }

    /* renamed from: e */
    private static final byte m42542e(short s) {
        return (byte) s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47775equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m47779unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47776equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: f */
    private static final short m42551f(short s) {
        return s;
    }

    /* renamed from: g */
    private static final int m42552g(short s) {
        return s & MAX_VALUE;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: h */
    private static final long m42559h(short s) {
        return ((long) s) & 65535;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47777hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: j */
    private static final short m42564j(short s) {
        return s;
    }

    /* renamed from: m */
    private static final float m42570m(short s) {
        return (float) (s & MAX_VALUE);
    }

    /* renamed from: n */
    private static final double m42571n(short s) {
        return (double) (s & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return m47775equalsimpl(this.f59799a, obj);
    }

    public int hashCode() {
        return m47777hashCodeimpl(this.f59799a);
    }

    public String toString() {
        return m47778toStringimpl(this.f59799a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m47779unboximpl() {
        return this.f59799a;
    }

    private /* synthetic */ UShort(short s) {
        this.f59799a = s;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m42522a(((UShort) obj).m47779unboximpl());
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, mo175978d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: UShort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private static final int m42523a(short s, byte b) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) b & 255);
    }

    /* renamed from: a */
    private static int m42526a(short s, short s2) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) s2 & MAX_VALUE);
    }

    /* renamed from: a */
    private static final int m42524a(short s, int i) {
        return UnsignedKt.uintCompare(UInt.m47724constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: a */
    private static final int m42525a(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m47749constructorimpl(((long) s) & 65535), j);
    }

    /* renamed from: b */
    private static final int m42527b(short s, byte b) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) + UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: b */
    private static final int m42529b(short s, short s2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) + UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: b */
    private static final int m42528b(short s, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: b */
    private static final long m42530b(short s, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) s) & 65535) + j);
    }

    /* renamed from: c */
    private static final int m42532c(short s, byte b) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) - UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: c */
    private static final int m42534c(short s, short s2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) - UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: c */
    private static final int m42533c(short s, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: c */
    private static final long m42535c(short s, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) s) & 65535) - j);
    }

    /* renamed from: d */
    private static final int m42537d(short s, byte b) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) * UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: d */
    private static final int m42539d(short s, short s2) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) * UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: d */
    private static final int m42538d(short s, int i) {
        return UInt.m47724constructorimpl(UInt.m47724constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: d */
    private static final long m42540d(short s, long j) {
        return ULong.m47749constructorimpl(ULong.m47749constructorimpl(((long) s) & 65535) * j);
    }

    /* renamed from: e */
    private static final int m42543e(short s, byte b) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: e */
    private static final int m42545e(short s, short s2) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: e */
    private static final int m42544e(short s, int i) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: e */
    private static final long m42546e(short s, long j) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(ULong.m47749constructorimpl(((long) s) & 65535), j);
    }

    /* renamed from: f */
    private static final int m42547f(short s, byte b) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: f */
    private static final int m42549f(short s, short s2) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: f */
    private static final int m42548f(short s, int i) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: f */
    private static final long m42550f(short s, long j) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(ULong.m47749constructorimpl(((long) s) & 65535), j);
    }

    /* renamed from: g */
    private static final int m42553g(short s, byte b) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(b & 255));
    }

    /* renamed from: g */
    private static final int m42555g(short s, short s2) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: g */
    private static final int m42554g(short s, int i) {
        return UnsignedKt.m47798uintDivideJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: g */
    private static final long m42556g(short s, long j) {
        return UnsignedKt.m47800ulongDivideeb3DHEI(ULong.m47749constructorimpl(((long) s) & 65535), j);
    }

    /* renamed from: h */
    private static final byte m42557h(short s, byte b) {
        return UByte.m47699constructorimpl((byte) UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(b & 255)));
    }

    /* renamed from: h */
    private static final short m42561h(short s, short s2) {
        return m47774constructorimpl((short) UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(s2 & MAX_VALUE)));
    }

    /* renamed from: h */
    private static final int m42558h(short s, int i) {
        return UnsignedKt.m47799uintRemainderJ1ME1BU(UInt.m47724constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: h */
    private static final long m42560h(short s, long j) {
        return UnsignedKt.m47801ulongRemaindereb3DHEI(ULong.m47749constructorimpl(((long) s) & 65535), j);
    }

    /* renamed from: b */
    private static final short m42531b(short s) {
        return m47774constructorimpl((short) (s + 1));
    }

    /* renamed from: c */
    private static final short m42536c(short s) {
        return m47774constructorimpl((short) (s - 1));
    }

    /* renamed from: i */
    private static final UIntRange m42563i(short s, short s2) {
        return new UIntRange(UInt.m47724constructorimpl(s & MAX_VALUE), UInt.m47724constructorimpl(s2 & MAX_VALUE), (DefaultConstructorMarker) null);
    }

    /* renamed from: j */
    private static final short m42565j(short s, short s2) {
        return m47774constructorimpl((short) (s & s2));
    }

    /* renamed from: k */
    private static final short m42567k(short s, short s2) {
        return m47774constructorimpl((short) (s | s2));
    }

    /* renamed from: l */
    private static final short m42569l(short s, short s2) {
        return m47774constructorimpl((short) (s ^ s2));
    }

    /* renamed from: d */
    private static final short m42541d(short s) {
        return m47774constructorimpl((short) (~s));
    }

    /* renamed from: i */
    private static final byte m42562i(short s) {
        return UByte.m47699constructorimpl((byte) s);
    }

    /* renamed from: k */
    private static final int m42566k(short s) {
        return UInt.m47724constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: l */
    private static final long m42568l(short s) {
        return ULong.m47749constructorimpl(((long) s) & 65535);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47778toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }
}
