package com.didi.soda.business.component.address;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/business/component/address/BusinessAddressMapComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/business/component/address/BusinessAddressMapView;", "Lcom/didi/soda/business/component/address/BusinessAddressMapPresenter;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "onCreateView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessAddressMapComponent.kt */
public final class BusinessAddressMapComponent extends MvpComponent<BusinessAddressMapView, BusinessAddressMapPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessAddressMapComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    /* access modifiers changed from: protected */
    public BusinessAddressMapPresenter onCreatePresenter() {
        return new BusinessAddressMapPresenter();
    }

    /* access modifiers changed from: protected */
    public BusinessAddressMapView onCreateView() {
        return new BusinessAddressMapView();
    }
}
