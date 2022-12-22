package kshark;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lkshark/ProguardMapping;", "", "()V", "obfuscatedToClearNamesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "addMapping", "", "obfuscatedName", "clearName", "deobfuscateClassName", "obfuscatedClassName", "deobfuscateFieldName", "obfuscatedClass", "obfuscatedField", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ProguardMapping.kt */
public final class ProguardMapping {

    /* renamed from: a */
    private final LinkedHashMap<String, String> f4606a = new LinkedHashMap<>();

    public final String deobfuscateClassName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "obfuscatedClassName");
        String str2 = this.f4606a.get(str);
        return str2 != null ? str2 : str;
    }

    public final String deobfuscateFieldName(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "obfuscatedClass");
        Intrinsics.checkParameterIsNotNull(str2, "obfuscatedField");
        LinkedHashMap<String, String> linkedHashMap = this.f4606a;
        String str3 = linkedHashMap.get(str + '.' + str2);
        return str3 != null ? str3 : str2;
    }

    public final void addMapping(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "obfuscatedName");
        Intrinsics.checkParameterIsNotNull(str2, "clearName");
        this.f4606a.put(str, str2);
    }
}
