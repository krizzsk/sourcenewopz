package com.didi.soda.address.component.selectlist;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/SelectedAddressComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/address/component/selectlist/SelectedAddressView;", "Lcom/didi/soda/address/component/selectlist/SelectedAddressPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "onCreateView", "onPageResult", "", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressComponent.kt */
public final class SelectedAddressComponent extends MvpComponent<SelectedAddressView, SelectedAddressPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectedAddressComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public SelectedAddressPresenter onCreatePresenter() {
        return new SelectedAddressPresenter();
    }

    /* access modifiers changed from: protected */
    public SelectedAddressView onCreateView() {
        return new SelectedAddressView();
    }

    public final void onPageResult(Bundle bundle) {
        ((SelectedAddressPresenter) getPresenter()).onPageResult(bundle);
    }
}
