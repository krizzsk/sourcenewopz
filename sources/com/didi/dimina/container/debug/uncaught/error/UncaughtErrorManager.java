package com.didi.dimina.container.debug.uncaught.error;

import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR6\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\rj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006`\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorManager;", "", "()V", "TAG", "", "showingQueue", "Ljava/util/LinkedList;", "Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorBean;", "getShowingQueue", "()Ljava/util/LinkedList;", "setShowingQueue", "(Ljava/util/LinkedList;)V", "storageMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getErrorList", "jsAppId", "show", "", "bean", "storage", "content", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UncaughtErrorManager.kt */
public final class UncaughtErrorManager {
    public static final UncaughtErrorManager INSTANCE = new UncaughtErrorManager();
    public static final String TAG = "UncaughtErrorManager";

    /* renamed from: a */
    private static HashMap<String, LinkedList<String>> f16797a = new HashMap<>();

    /* renamed from: b */
    private static LinkedList<UncaughtErrorBean> f16798b = new LinkedList<>();

    private UncaughtErrorManager() {
    }

    public final LinkedList<UncaughtErrorBean> getShowingQueue() {
        return f16798b;
    }

    public final void setShowingQueue(LinkedList<UncaughtErrorBean> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "<set-?>");
        f16798b = linkedList;
    }

    public final void storage(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "jsAppId");
        Intrinsics.checkParameterIsNotNull(str2, "content");
        LinkedList linkedList = f16797a.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        Intrinsics.checkExpressionValueIsNotNull(linkedList, "storageMap.get(jsAppId) ?: LinkedList()");
        linkedList.add(str2);
        f16797a.put(str, linkedList);
    }

    public final LinkedList<String> getErrorList(String str) {
        Intrinsics.checkParameterIsNotNull(str, "jsAppId");
        return f16797a.get(str);
    }

    public final void show(String str, UncaughtErrorBean uncaughtErrorBean) {
        Intrinsics.checkParameterIsNotNull(str, "jsAppId");
        Intrinsics.checkParameterIsNotNull(uncaughtErrorBean, "bean");
        f16798b.add(uncaughtErrorBean);
        UncaughtErrorPageManager.INSTANCE.show();
    }
}
