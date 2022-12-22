package com.didi.soda.home.page;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.manager.AllCategoryFromPageRepo;
import com.didi.soda.router.IInterceptor;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/page/AllCategoryPageInterceptor;", "Lcom/didi/soda/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/soda/router/Request;", "p1", "Lcom/didi/soda/router/Response;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryPageInterceptor.kt */
public final class AllCategoryPageInterceptor implements IInterceptor {
    public boolean intercept(Request request, Response response) {
        if (request != null) {
            if (request.getFromPage() instanceof ScopeContext) {
                Object fromPage = request.getFromPage();
                if (fromPage != null) {
                    String alias = ((ScopeContext) fromPage).alias();
                    Intrinsics.checkNotNullExpressionValue(alias, "it.fromPage as ScopeContext).alias()");
                    if (StringsKt.contains$default((CharSequence) alias, (CharSequence) RoutePath.SHOP_CATEGORY_LANDING_PAGE, false, 2, (Object) null)) {
                        ((AllCategoryFromPageRepo) RepoFactory.getRepo(AllCategoryFromPageRepo.class)).setValue(RoutePath.SHOP_CATEGORY_LANDING_PAGE);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.didi.app.nova.skeleton.ScopeContext");
                }
            }
            ((AllCategoryFromPageRepo) RepoFactory.getRepo(AllCategoryFromPageRepo.class)).setValue("");
        }
        return false;
    }
}
