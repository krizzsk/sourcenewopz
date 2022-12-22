package kotlin.p245io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\b\u001a\t\u0010\r\u001a\u00020\u0001H\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, mo175978d2 = {"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "kotlin-stdlib"}, mo175979k = 2, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.io.ConsoleKt */
/* compiled from: Console.kt */
public final class ConsoleKt {
    /* renamed from: a */
    private static final void m44126a(Object obj) {
        System.out.print(obj);
    }

    /* renamed from: a */
    private static final void m44124a(int i) {
        System.out.print(i);
    }

    /* renamed from: a */
    private static final void m44125a(long j) {
        System.out.print(j);
    }

    /* renamed from: a */
    private static final void m44120a(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    /* renamed from: a */
    private static final void m44127a(short s) {
        System.out.print(Short.valueOf(s));
    }

    /* renamed from: a */
    private static final void m44121a(char c) {
        System.out.print(c);
    }

    /* renamed from: a */
    private static final void m44128a(boolean z) {
        System.out.print(z);
    }

    /* renamed from: a */
    private static final void m44123a(float f) {
        System.out.print(f);
    }

    /* renamed from: a */
    private static final void m44122a(double d) {
        System.out.print(d);
    }

    /* renamed from: a */
    private static final void m44129a(char[] cArr) {
        System.out.print(cArr);
    }

    /* renamed from: b */
    private static final void m44136b(Object obj) {
        System.out.println(obj);
    }

    /* renamed from: b */
    private static final void m44134b(int i) {
        System.out.println(i);
    }

    /* renamed from: b */
    private static final void m44135b(long j) {
        System.out.println(j);
    }

    /* renamed from: b */
    private static final void m44130b(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    /* renamed from: b */
    private static final void m44137b(short s) {
        System.out.println(Short.valueOf(s));
    }

    /* renamed from: b */
    private static final void m44131b(char c) {
        System.out.println(c);
    }

    /* renamed from: b */
    private static final void m44138b(boolean z) {
        System.out.println(z);
    }

    /* renamed from: b */
    private static final void m44133b(float f) {
        System.out.println(f);
    }

    /* renamed from: b */
    private static final void m44132b(double d) {
        System.out.println(d);
    }

    /* renamed from: b */
    private static final void m44139b(char[] cArr) {
        System.out.println(cArr);
    }

    /* renamed from: a */
    private static final void m44119a() {
        System.out.println();
    }

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "System.`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "Charset.defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }
}
