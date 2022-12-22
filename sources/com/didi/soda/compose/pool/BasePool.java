package com.didi.soda.compose.pool;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fR$\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/compose/pool/BasePool;", "V", "", "()V", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getArrayList", "()Ljava/util/ArrayList;", "register", "", "clz", "(Ljava/lang/Object;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BasePool.kt */
public abstract class BasePool<V> {

    /* renamed from: a */
    private final ArrayList<V> f40139a = new ArrayList<>();

    public abstract void register(V v);

    public ArrayList<V> getArrayList() {
        return this.f40139a;
    }
}
