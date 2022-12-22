package com.didi.soda.customer.base.pages;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/base/pages/PageBackHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageBackHelper.kt */
public final class PageBackHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f40371a = "popbackstack";

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/base/pages/PageBackHelper$Companion;", "", "()V", "POP_BACK_STACK_LOWERCASE", "", "popBackStack", "", "page", "Lcom/didi/app/nova/skeleton/Page;", "isWebPage", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PageBackHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ boolean popBackStack$default(Companion companion, Page page, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.popBackStack(page, z);
        }

        public final boolean popBackStack(Page page, boolean z) {
            ScopeContext scopeContext;
            Bundle bundle = null;
            if (!(page == null || (scopeContext = page.getScopeContext()) == null)) {
                bundle = scopeContext.getBundle();
            }
            if (z && bundle != null) {
                bundle = bundle.getBundle("webpagebundle");
            }
            boolean z2 = false;
            if (bundle != null) {
                z2 = bundle.getInt(PageBackHelper.f40371a, 0) == 1 ? true : Intrinsics.areEqual((Object) "1", (Object) bundle.getString(PageBackHelper.f40371a, "0"));
            }
            if (z2) {
                GlobalContext.popBackStack();
            }
            return z2;
        }
    }
}
