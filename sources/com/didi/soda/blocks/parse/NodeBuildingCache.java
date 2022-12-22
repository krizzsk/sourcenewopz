package com.didi.soda.blocks.parse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuildingCache;", "", "()V", "resultCache", "", "", "cacheValue", "", "keyPath", "value", "clear", "contains", "", "key", "getCachedValue", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NodeBuildingCache.kt */
public final class NodeBuildingCache {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MUTABLE_TYPE_INDEX = "$index";
    private static final String MUTABLE_TYPE_INVOKE = "$invoke";
    private static final String MUTABLE_TYPE_ITEM = "$item";
    private static final String MUTABLE_TYPE_SCOPE = "$scope";
    /* access modifiers changed from: private */
    public static final List<String> cache_black_list = CollectionsKt.listOf(MUTABLE_TYPE_ITEM, MUTABLE_TYPE_INDEX, MUTABLE_TYPE_INVOKE, MUTABLE_TYPE_SCOPE);
    private Map<String, Object> resultCache = new LinkedHashMap();

    public final boolean contains(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.resultCache.containsKey(str) && this.resultCache.get(str) != null;
    }

    public final Object getCachedValue(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.resultCache.get(str);
    }

    public final void cacheValue(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "keyPath");
        for (String contains$default : cache_black_list) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) contains$default, false, 2, (Object) null)) {
                return;
            }
        }
        if (obj != null) {
            this.resultCache.put(str, obj);
        }
    }

    public final void clear() {
        this.resultCache.clear();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/NodeBuildingCache$Companion;", "", "()V", "MUTABLE_TYPE_INDEX", "", "MUTABLE_TYPE_INVOKE", "MUTABLE_TYPE_ITEM", "MUTABLE_TYPE_SCOPE", "cache_black_list", "", "getCache_black_list", "()Ljava/util/List;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NodeBuildingCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getCache_black_list() {
            return NodeBuildingCache.cache_black_list;
        }
    }
}
