package com.didi.soda.business.component.dynamic.category;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.business.component.dynamic.category.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.business.model.BusinessPageLifeState;
import com.didi.soda.business.model.BusinessPageLifeStateRepo;
import com.didi.soda.business.page.BusinessCategoryMenuPage;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.repo.RepoFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/BusinessDyCategoryPresenter;", "Lcom/didi/soda/business/component/dynamic/category/Contract$AbsCategoryPresenter;", "()V", "TAG", "", "businessId", "businessStatus", "", "mDefaultSelectedIndex", "omegaHelper", "Lcom/didi/soda/business/manager/BusinessOmegaHelper;", "getOmegaHelper", "()Lcom/didi/soda/business/manager/BusinessOmegaHelper;", "omegaHelper$delegate", "Lkotlin/Lazy;", "traceId", "getDefaultSelectedIndex", "handleBusinessData", "", "onCreate", "onDismiss", "type", "onItemClick", "index", "item", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "onItemExposure", "selectedCategory", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDyCategoryPresenter.kt */
public final class BusinessDyCategoryPresenter extends Contract.AbsCategoryPresenter {

    /* renamed from: a */
    private final String f39456a = "BusinessDyCategoryPresenter";

    /* renamed from: b */
    private final Lazy f39457b = LazyKt.lazy(new BusinessDyCategoryPresenter$omegaHelper$2(this));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f39458c = "";

    /* renamed from: d */
    private String f39459d = "";

    /* renamed from: e */
    private int f39460e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f39461f = 1;

    /* renamed from: a */
    private final BusinessOmegaHelper m27987a() {
        return (BusinessOmegaHelper) this.f39457b.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        String string = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        if (string == null) {
            string = "";
        }
        this.f39458c = string;
        m27990b();
        String str = this.f39458c;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(str, scopeContext, new Action1() {
            public final void call(Object obj) {
                BusinessDyCategoryPresenter.m27989a(BusinessDyCategoryPresenter.this, (BusinessState) obj);
            }
        });
        ((BusinessPageLifeStateRepo) RepoFactory.getRepo(BusinessPageLifeStateRepo.class)).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessDyCategoryPresenter.m27988a(BusinessDyCategoryPresenter.this, (BusinessPageLifeState) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27989a(BusinessDyCategoryPresenter businessDyCategoryPresenter, BusinessState businessState) {
        Intrinsics.checkNotNullParameter(businessDyCategoryPresenter, "this$0");
        businessDyCategoryPresenter.f39461f = businessState == null ? 1 : businessState.shopStatus;
        businessDyCategoryPresenter.m27987a().updateBusinessStatus(businessDyCategoryPresenter.f39461f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27988a(BusinessDyCategoryPresenter businessDyCategoryPresenter, BusinessPageLifeState businessPageLifeState) {
        INavigator navigator;
        Intrinsics.checkNotNullParameter(businessDyCategoryPresenter, "this$0");
        if (businessPageLifeState != null && businessPageLifeState.state == 1) {
            LogUtil.m29100d(businessDyCategoryPresenter.f39456a, "business page has been already  destroyed");
            ScopeContext scopeContext = businessDyCategoryPresenter.getScopeContext();
            if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
                navigator.finish();
            }
        }
    }

    public void selectedCategory(int i) {
        INavigator navigator;
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(BusinessCategoryMenuPage.KEY_REFRESH_SELECTED_CATEGORY, BusinessCategoryMenuPage.VALUE_REFRESH_SELECTED_CATEGORY_FLAG);
            bundle.putInt(BusinessCategoryMenuPage.PARAM_REFRESH_SELECTED_CATEGORY_INDEX, i);
            Unit unit = Unit.INSTANCE;
            navigator.finish(bundle);
        }
    }

    public void onDismiss(int i) {
        m27987a().onDismissMoreClassifyCk(i);
    }

    public void onItemExposure(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "item");
        m27987a().onClassifyTabSw(businessCategoryMenuRvModel.mCategoryId, i, businessCategoryMenuRvModel.mCategoryName, 2, businessCategoryMenuRvModel.mItemCount, this.f39459d);
    }

    public void onItemClick(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "item");
        m27987a().onClassifyTabClick(businessCategoryMenuRvModel.mCategoryId, i, businessCategoryMenuRvModel.mCategoryName, 2);
    }

    public int getDefaultSelectedIndex() {
        return this.f39460e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.didi.soda.business.model.BusinessCategoryMenuRvModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.didi.soda.business.model.BusinessCategoryMenuRvModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.didi.soda.business.model.BusinessCategoryMenuRvModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.didi.soda.business.model.BusinessCategoryMenuRvModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27990b() {
        /*
            r5 = this;
            java.lang.String r0 = "categorylist"
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()     // Catch:{ Exception -> 0x0070 }
            android.os.Bundle r1 = r1.getBundle()     // Catch:{ Exception -> 0x0070 }
            java.io.Serializable r1 = r1.getSerializable(r0)     // Catch:{ Exception -> 0x0070 }
            if (r1 == 0) goto L_0x007a
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()     // Catch:{ Exception -> 0x0070 }
            android.os.Bundle r1 = r1.getBundle()     // Catch:{ Exception -> 0x0070 }
            java.io.Serializable r1 = r1.getSerializable(r0)     // Catch:{ Exception -> 0x0070 }
            boolean r1 = r1 instanceof java.util.List     // Catch:{ Exception -> 0x0070 }
            if (r1 == 0) goto L_0x007a
            com.didi.app.nova.skeleton.ScopeContext r1 = r5.getScopeContext()     // Catch:{ Exception -> 0x0070 }
            android.os.Bundle r1 = r1.getBundle()     // Catch:{ Exception -> 0x0070 }
            java.io.Serializable r0 = r1.getSerializable(r0)     // Catch:{ Exception -> 0x0070 }
            boolean r1 = r0 instanceof java.util.List     // Catch:{ Exception -> 0x0070 }
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x0070 }
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            if (r0 != 0) goto L_0x0038
            goto L_0x007a
        L_0x0038:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0070 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0070 }
        L_0x003f:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0070 }
            if (r3 == 0) goto L_0x0051
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0070 }
            r4 = r3
            com.didi.soda.business.model.BusinessCategoryMenuRvModel r4 = (com.didi.soda.business.model.BusinessCategoryMenuRvModel) r4     // Catch:{ Exception -> 0x0070 }
            boolean r4 = r4.isSelected     // Catch:{ Exception -> 0x0070 }
            if (r4 == 0) goto L_0x003f
            r2 = r3
        L_0x0051:
            com.didi.soda.business.model.BusinessCategoryMenuRvModel r2 = (com.didi.soda.business.model.BusinessCategoryMenuRvModel) r2     // Catch:{ Exception -> 0x0070 }
            if (r2 != 0) goto L_0x0060
            r1 = 0
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0070 }
            com.didi.soda.business.model.BusinessCategoryMenuRvModel r1 = (com.didi.soda.business.model.BusinessCategoryMenuRvModel) r1     // Catch:{ Exception -> 0x0070 }
            r2 = 1
            r1.isSelected = r2     // Catch:{ Exception -> 0x0070 }
            goto L_0x0066
        L_0x0060:
            int r1 = r0.indexOf(r2)     // Catch:{ Exception -> 0x0070 }
            r5.f39460e = r1     // Catch:{ Exception -> 0x0070 }
        L_0x0066:
            com.didi.app.nova.skeleton.mvp.IView r1 = r5.getLogicView()     // Catch:{ Exception -> 0x0070 }
            com.didi.soda.business.component.dynamic.category.Contract$AbsCategoryView r1 = (com.didi.soda.business.component.dynamic.category.Contract.AbsCategoryView) r1     // Catch:{ Exception -> 0x0070 }
            r1.bindCategoryList(r0)     // Catch:{ Exception -> 0x0070 }
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            java.lang.String r1 = r5.f39456a
            java.lang.String r0 = r0.getLocalizedMessage()
            com.didi.soda.customer.foundation.log.util.LogUtil.m29104i((java.lang.String) r1, (java.lang.String) r0)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.category.BusinessDyCategoryPresenter.m27990b():void");
    }
}
