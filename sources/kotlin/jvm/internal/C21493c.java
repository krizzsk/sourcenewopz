package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lkotlin/jvm/internal/ArrayCharIterator;", "Lkotlin/collections/CharIterator;", "array", "", "([C)V", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.c */
/* compiled from: ArrayIterators.kt */
final class C21493c extends CharIterator {

    /* renamed from: a */
    private int f59931a;

    /* renamed from: b */
    private final char[] f59932b;

    public C21493c(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.f59932b = cArr;
    }

    public boolean hasNext() {
        return this.f59931a < this.f59932b.length;
    }

    public char nextChar() {
        try {
            char[] cArr = this.f59932b;
            int i = this.f59931a;
            this.f59931a = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f59931a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
