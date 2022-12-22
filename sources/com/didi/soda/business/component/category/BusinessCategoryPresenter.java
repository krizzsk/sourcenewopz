package com.didi.soda.business.component.category;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.business.component.category.Contract;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.BusinessCateEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/business/component/category/BusinessCategoryPresenter;", "Lcom/didi/soda/business/component/category/Contract$AbsCategoryPresenter;", "listener", "Lcom/didi/soda/business/listener/BusinessCategoryListener;", "callback", "Lcom/didi/soda/business/listener/BusinessSelectedCallback;", "(Lcom/didi/soda/business/listener/BusinessCategoryListener;Lcom/didi/soda/business/listener/BusinessSelectedCallback;)V", "businessId", "", "businessStatus", "", "getCallback", "()Lcom/didi/soda/business/listener/BusinessSelectedCallback;", "getListener", "()Lcom/didi/soda/business/listener/BusinessCategoryListener;", "omegaHelper", "Lcom/didi/soda/business/manager/BusinessOmegaHelper;", "getOmegaHelper", "()Lcom/didi/soda/business/manager/BusinessOmegaHelper;", "omegaHelper$delegate", "Lkotlin/Lazy;", "traceId", "dismissCategory", "", "handleBusinessData", "onCreate", "onDismiss", "type", "onItemClick", "index", "item", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "onItemExposure", "selectedCategory", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryPresenter.kt */
public final class BusinessCategoryPresenter extends Contract.AbsCategoryPresenter {

    /* renamed from: a */
    private final BusinessCategoryListener f39375a;

    /* renamed from: b */
    private final BusinessSelectedCallback f39376b;

    /* renamed from: c */
    private final Lazy f39377c = LazyKt.lazy(new BusinessCategoryPresenter$omegaHelper$2(this));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f39378d = "";

    /* renamed from: e */
    private String f39379e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f39380f = 1;

    public final BusinessCategoryListener getListener() {
        return this.f39375a;
    }

    public final BusinessSelectedCallback getCallback() {
        return this.f39376b;
    }

    public BusinessCategoryPresenter(BusinessCategoryListener businessCategoryListener, BusinessSelectedCallback businessSelectedCallback) {
        Intrinsics.checkNotNullParameter(businessCategoryListener, "listener");
        Intrinsics.checkNotNullParameter(businessSelectedCallback, "callback");
        this.f39375a = businessCategoryListener;
        this.f39376b = businessSelectedCallback;
    }

    /* renamed from: a */
    private final BusinessOmegaHelper m27863a() {
        return (BusinessOmegaHelper) this.f39377c.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        String string = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        if (string == null) {
            string = "";
        }
        this.f39378d = string;
        m27866b();
        String str = this.f39378d;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(str, scopeContext, new Action1() {
            public final void call(Object obj) {
                BusinessCategoryPresenter.m27864a(BusinessCategoryPresenter.this, (BusinessState) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27864a(BusinessCategoryPresenter businessCategoryPresenter, BusinessState businessState) {
        Intrinsics.checkNotNullParameter(businessCategoryPresenter, "this$0");
        businessCategoryPresenter.f39380f = businessState == null ? 1 : businessState.shopStatus;
        businessCategoryPresenter.m27863a().updateBusinessStatus(businessCategoryPresenter.f39380f);
    }

    public void dismissCategory() {
        this.f39375a.dismissCategory();
    }

    public void selectedCategory(int i) {
        this.f39376b.onSelectedCategory(i);
    }

    public void onDismiss(int i) {
        m27863a().onDismissMoreClassifyCk(i);
    }

    public void onItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "item");
        m27863a().onClassifyTabSw(businessCategoryRvModel.mCategoryId, i, businessCategoryRvModel.mCategoryName, 2, businessCategoryRvModel.mItemCount, this.f39379e);
    }

    public void onItemClick(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "item");
        m27863a().onClassifyTabClick(businessCategoryRvModel.mCategoryId, i, businessCategoryRvModel.mCategoryName, 2);
    }

    /* renamed from: b */
    private final void m27866b() {
        BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessCategoryPresenter.m27865a(BusinessCategoryPresenter.this, (CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27865a(BusinessCategoryPresenter businessCategoryPresenter, CustomerResource customerResource) {
        String str;
        Intrinsics.checkNotNullParameter(businessCategoryPresenter, "this$0");
        if (customerResource != null) {
            boolean z = false;
            String str2 = null;
            if (!(customerResource.status == Resource.Status.SUCCESS && customerResource.data != null)) {
                customerResource = null;
            }
            if (customerResource != null) {
                if (customerResource.mExtension != null) {
                    businessCategoryPresenter.f39379e = customerResource.mExtension.getString(ParamConst.TRACE_ID, "");
                }
                Object obj = customerResource.data;
                if (obj != null) {
                    BusinessEntity businessEntity = (BusinessEntity) obj;
                    ((Contract.AbsCategoryView) businessCategoryPresenter.getLogicView()).updateContainerTopPadding(BusinessDataHelper.hasDynamicNotice(businessEntity));
                    ArrayList arrayList = new ArrayList();
                    List<BusinessCateEntity> list = businessEntity.cateInfo;
                    if (list != null) {
                        if (!(!list.isEmpty())) {
                            list = null;
                        }
                        if (list != null) {
                            Collection arrayList2 = new ArrayList();
                            for (Object next : list) {
                                if (((BusinessCateEntity) next) != null) {
                                    arrayList2.add(next);
                                }
                            }
                            for (BusinessCateEntity newInstance : (List) arrayList2) {
                                arrayList.add(BusinessCategoryRvModel.newInstance(newInstance));
                            }
                        }
                    }
                    if ((arrayList.isEmpty() ^ true ? arrayList : null) != null) {
                        ((Contract.AbsCategoryView) businessCategoryPresenter.getLogicView()).bindCategoryList(arrayList);
                    }
                    BusinessInfoEntity businessInfoEntity = businessEntity.shopInfo;
                    if (businessInfoEntity != null && (str = businessInfoEntity.shopName) != null) {
                        if (str.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            str2 = str;
                        }
                        if (str2 != null) {
                            ((Contract.AbsCategoryView) businessCategoryPresenter.getLogicView()).setShopName(str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.BusinessEntity");
            }
        }
    }
}
