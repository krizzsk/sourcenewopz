package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lkotlin/jvm/internal/ArrayIntIterator;", "Lkotlin/collections/IntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextInt", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.f */
/* compiled from: ArrayIterators.kt */
final class C21496f extends IntIterator {

    /* renamed from: a */
    private int f59937a;

    /* renamed from: b */
    private final int[] f59938b;

    public C21496f(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        this.f59938b = iArr;
    }

    public boolean hasNext() {
        return this.f59937a < this.f59938b.length;
    }

    public int nextInt() {
        try {
            int[] iArr = this.f59938b;
            int i = this.f59937a;
            this.f59937a = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f59937a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
