package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lkshark/ObjectInspector;", "", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ObjectInspector.kt */
public interface ObjectInspector {
    public static final Companion Companion = Companion.$$INSTANCE;

    void inspect(ObjectReporter objectReporter);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\n¨\u0006\t"}, mo175978d2 = {"Lkshark/ObjectInspector$Companion;", "", "()V", "invoke", "Lkshark/ObjectInspector;", "block", "Lkotlin/Function1;", "Lkshark/ObjectReporter;", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspector.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ObjectInspector invoke(Function1<? super ObjectReporter, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "block");
            return new ObjectInspector$Companion$invoke$1(function1);
        }
    }
}
