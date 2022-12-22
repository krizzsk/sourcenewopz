package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class TypeEnhancementInfo {

    /* renamed from: a */
    private final Map<Integer, JavaTypeQualifiers> f60615a;

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f60615a = map;
    }

    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.f60615a;
    }
}
