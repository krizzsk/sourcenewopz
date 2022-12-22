package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, mo175978d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: PrimitiveSpreadBuilders.kt */
public abstract class PrimitiveSpreadBuilder<T> {

    /* renamed from: a */
    private int f59910a;

    /* renamed from: b */
    private final T[] f59911b;

    /* renamed from: c */
    private final int f59912c;

    /* renamed from: a */
    private static /* synthetic */ void m44274a() {
    }

    /* access modifiers changed from: protected */
    public abstract int getSize(T t);

    public PrimitiveSpreadBuilder(int i) {
        this.f59912c = i;
        this.f59911b = new Object[i];
    }

    /* access modifiers changed from: protected */
    public final int getPosition() {
        return this.f59910a;
    }

    /* access modifiers changed from: protected */
    public final void setPosition(int i) {
        this.f59910a = i;
    }

    public final void addSpread(T t) {
        Intrinsics.checkNotNullParameter(t, "spreadArgument");
        T[] tArr = this.f59911b;
        int i = this.f59910a;
        this.f59910a = i + 1;
        tArr[i] = t;
    }

    /* access modifiers changed from: protected */
    public final int size() {
        int i = this.f59912c - 1;
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                T t = this.f59911b[i3];
                i2 += t != null ? getSize(t) : 1;
                if (i3 == i) {
                    break;
                }
                i3++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public final T toArray(T t, T t2) {
        int i;
        Intrinsics.checkNotNullParameter(t, "values");
        Intrinsics.checkNotNullParameter(t2, "result");
        int i2 = this.f59912c - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            int i5 = 0;
            i = 0;
            while (true) {
                T t3 = this.f59911b[i4];
                if (t3 != null) {
                    if (i5 < i4) {
                        int i6 = i4 - i5;
                        System.arraycopy(t, i5, t2, i, i6);
                        i += i6;
                    }
                    int size = getSize(t3);
                    System.arraycopy(t3, 0, t2, i, size);
                    i += size;
                    i5 = i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
            i3 = i5;
        } else {
            i = 0;
        }
        int i7 = this.f59912c;
        if (i3 < i7) {
            System.arraycopy(t, i3, t2, i, i7 - i3);
        }
        return t2;
    }
}
