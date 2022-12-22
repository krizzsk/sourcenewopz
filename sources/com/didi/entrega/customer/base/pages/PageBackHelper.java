package com.didi.entrega.customer.base.pages;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/customer/base/pages/PageBackHelper;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageBackHelper.kt */
public final class PageBackHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f19818a = "popBackStack";

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/customer/base/pages/PageBackHelper$Companion;", "", "()V", "POP_BACK_STACK_LOWERCASE", "", "popBackStack", "", "page", "Lcom/didi/app/nova/skeleton/Page;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PageBackHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean popBackStack(Page page) {
            ScopeContext scopeContext;
            Bundle bundle = null;
            if (!(page == null || (scopeContext = page.getScopeContext()) == null)) {
                bundle = scopeContext.getBundle();
            }
            boolean z = false;
            if (bundle != null) {
                String string = bundle.getString("popBackStack", "0");
                int i = bundle.getInt("popBackStack", 0);
                if (Intrinsics.areEqual((Object) "1", (Object) string) || i == 1) {
                    z = true;
                }
            }
            if (z) {
                GlobalContext.popBackStack();
            }
            return z;
        }
    }
}
