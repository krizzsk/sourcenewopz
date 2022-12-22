package kshark;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0005H\u0002J$\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lkshark/GraphContext;", "", "()V", "store", "", "", "contains", "", "key", "get", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "minusAssign", "", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: GraphContext.kt */
public final class GraphContext {

    /* renamed from: a */
    private final Map<String, Object> f4534a = new LinkedHashMap();

    public final <T> T get(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.f4534a.get(str);
    }

    public final <T> T getOrPut(String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        Map<String, Object> map = this.f4534a;
        T t = map.get(str);
        if (t != null) {
            return t;
        }
        T invoke = function0.invoke();
        map.put(str, invoke);
        return invoke;
    }

    public final <T> void set(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.f4534a.put(str, t);
    }

    public final boolean contains(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.f4534a.containsKey(str);
    }

    public final void minusAssign(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.f4534a.remove(str);
    }
}
