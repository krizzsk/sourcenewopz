package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/util/KtApolloUtil;", "", "()V", "TAG", "", "isKotlinOn", "", "alias", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KtApolloUtil.kt */
public final class KtApolloUtil {
    public static final KtApolloUtil INSTANCE = new KtApolloUtil();

    /* renamed from: a */
    private static final String f41243a = "KtApolloUtil";

    private KtApolloUtil() {
    }

    @JvmStatic
    public static final boolean isKotlinOn(String str) {
        Intrinsics.checkNotNullParameter(str, "alias");
        HashSet hashSet = new HashSet();
        List<String> kotlinOnPageList = CustomerApolloUtil.getKotlinOnPageList();
        if (kotlinOnPageList == null) {
            kotlinOnPageList = CollectionsKt.emptyList();
        }
        hashSet.addAll(kotlinOnPageList);
        boolean contains = hashSet.contains(str);
        LogUtil.m29104i(f41243a, str + " is " + contains);
        OmegaTracker.Builder.create(EventConst.Technology.PAGE_KOTLIN_EVENT).addEventParam(ParamConst.PARAM_OMEGA_PAGE_NAME, str).addEventParam("state", Integer.valueOf(contains ? 1 : 0)).build().track();
        return contains;
    }
}
