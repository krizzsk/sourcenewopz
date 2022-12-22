package com.didi.soda.customer.foundation.rpc.net;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/net/ExceptionFormator;", "", "()V", "transformers", "", "Lcom/didi/soda/customer/foundation/rpc/net/ExceptionFormator$Transform;", "formatException", "", "origin", "Transform", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExceptionFormator.kt */
public final class ExceptionFormator {
    public static final ExceptionFormator INSTANCE = new ExceptionFormator();

    /* renamed from: a */
    private static List<Transform> f41057a;

    private ExceptionFormator() {
    }

    static {
        List<Transform> arrayList = new ArrayList<>();
        arrayList.add(new ExceptionFormator$transformers$1$1());
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new ExceptionFormator$transformers$lambda1$$inlined$sortBy$1());
        }
        f41057a = arrayList;
    }

    @JvmStatic
    public static final String formatException(String str) {
        if (str == null) {
            return "";
        }
        for (Transform transform : f41057a) {
            if (transform.shouldTransform(str)) {
                return transform.doTransform(str);
            }
        }
        return str;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/net/ExceptionFormator$Transform;", "", "()V", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "doTransform", "", "origin", "shouldTransform", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ExceptionFormator.kt */
    public static abstract class Transform {
        private int priority;

        public abstract String doTransform(String str);

        public abstract boolean shouldTransform(String str);

        public int getPriority() {
            return this.priority;
        }

        public void setPriority(int i) {
            this.priority = i;
        }
    }
}
