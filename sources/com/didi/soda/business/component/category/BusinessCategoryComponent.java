package com.didi.soda.business.component.category;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/BusinessCategoryComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/business/component/category/BusinessCategoryView;", "Lcom/didi/soda/business/component/category/BusinessCategoryPresenter;", "container", "Landroid/view/ViewGroup;", "listener", "Lcom/didi/soda/business/listener/BusinessCategoryListener;", "callback", "Lcom/didi/soda/business/listener/BusinessSelectedCallback;", "(Landroid/view/ViewGroup;Lcom/didi/soda/business/listener/BusinessCategoryListener;Lcom/didi/soda/business/listener/BusinessSelectedCallback;)V", "getCallback", "()Lcom/didi/soda/business/listener/BusinessSelectedCallback;", "getListener", "()Lcom/didi/soda/business/listener/BusinessCategoryListener;", "onBack", "", "onCreatePresenter", "onCreateView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryComponent.kt */
public final class BusinessCategoryComponent extends MvpComponent<BusinessCategoryView, BusinessCategoryPresenter> {

    /* renamed from: a */
    private final BusinessCategoryListener f39373a;

    /* renamed from: b */
    private final BusinessSelectedCallback f39374b;

    public final BusinessCategoryListener getListener() {
        return this.f39373a;
    }

    public final BusinessSelectedCallback getCallback() {
        return this.f39374b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessCategoryComponent(ViewGroup viewGroup, BusinessCategoryListener businessCategoryListener, BusinessSelectedCallback businessSelectedCallback) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(businessCategoryListener, "listener");
        Intrinsics.checkNotNullParameter(businessSelectedCallback, "callback");
        this.f39373a = businessCategoryListener;
        this.f39374b = businessSelectedCallback;
    }

    /* access modifiers changed from: protected */
    public BusinessCategoryPresenter onCreatePresenter() {
        return new BusinessCategoryPresenter(this.f39373a, this.f39374b);
    }

    /* access modifiers changed from: protected */
    public BusinessCategoryView onCreateView() {
        return new BusinessCategoryView();
    }

    public final boolean onBack() {
        ((BusinessCategoryView) getLogicView()).dismissCategory();
        return true;
    }
}
