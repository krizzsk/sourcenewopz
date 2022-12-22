package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: typeSignatureMapping.kt */
public class JvmDescriptorTypeWriter<T> {

    /* renamed from: a */
    private final JvmTypeFactory<T> f60639a;

    /* renamed from: b */
    private int f60640b;

    /* renamed from: c */
    private T f60641c;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.f60641c == null) {
            this.f60640b++;
        }
    }

    public void writeClass(T t) {
        Intrinsics.checkNotNullParameter(t, "objectType");
        writeJvmTypeAsIs(t);
    }

    /* access modifiers changed from: protected */
    public final void writeJvmTypeAsIs(T t) {
        Intrinsics.checkNotNullParameter(t, "type");
        if (this.f60641c == null) {
            int i = this.f60640b;
            if (i > 0) {
                t = this.f60639a.createFromString(Intrinsics.stringPlus(StringsKt.repeat(Const.jaLeft, i), this.f60639a.toString(t)));
            }
            this.f60641c = t;
        }
    }

    public void writeTypeVariable(Name name, T t) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(t, "type");
        writeJvmTypeAsIs(t);
    }
}
