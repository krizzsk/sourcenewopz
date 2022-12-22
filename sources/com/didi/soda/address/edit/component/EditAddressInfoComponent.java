package com.didi.soda.address.edit.component;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/address/edit/component/EditAddressInfoComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/address/edit/component/EditAddressInfoView;", "Lcom/didi/soda/address/edit/component/EditAddressInfoPresent;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "editAddressInfoPresent", "onCreatePresenter", "onCreateView", "onPageResult", "", "data", "Landroid/os/Bundle;", "setBackAction", "backAction", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoComponent.kt */
public final class EditAddressInfoComponent extends MvpComponent<EditAddressInfoView, EditAddressInfoPresent> {

    /* renamed from: a */
    private EditAddressInfoPresent f38728a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditAddressInfoComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public EditAddressInfoPresent onCreatePresenter() {
        EditAddressInfoPresent editAddressInfoPresent = new EditAddressInfoPresent();
        this.f38728a = editAddressInfoPresent;
        return editAddressInfoPresent;
    }

    /* access modifiers changed from: protected */
    public EditAddressInfoView onCreateView() {
        return new EditAddressInfoView();
    }

    public final Unit setBackAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "backAction");
        EditAddressInfoPresent editAddressInfoPresent = this.f38728a;
        if (editAddressInfoPresent == null) {
            return null;
        }
        editAddressInfoPresent.setBackAction(function0);
        return Unit.INSTANCE;
    }

    public final void onPageResult(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        EditAddressInfoPresent editAddressInfoPresent = this.f38728a;
        if (editAddressInfoPresent != null) {
            editAddressInfoPresent.onPageResult(bundle);
        }
    }
}
