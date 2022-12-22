package com.didi.safetoolkit.business.share.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.android.didi.safetoolkit.presenter.IBaseView;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.SfContractOptIView;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.BroadcastUtil;
import com.didi.sdk.util.SPUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\rH\u0002J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/share/controller/SfGetOptController;", "Lcom/android/didi/safetoolkit/presenter/AbsPresenter;", "Lcom/didi/safetoolkit/business/share/SfContractOptIView;", "view", "(Lcom/didi/safetoolkit/business/share/SfContractOptIView;)V", "guideKey", "", "mOrderId", "target", "", "threshold", "whereFrom", "addContact", "", "model", "Lcom/didi/safetoolkit/model/SfContactsModel;", "goContact", "hideGuide", "hideLoading", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "parseBundle", "bundle", "Landroid/os/Bundle;", "setResultAndFinish", "intent", "showGuide", "showLoading", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfGetOptController.kt */
public final class SfGetOptController extends AbsPresenter<SfContractOptIView> {
    private final String guideKey = "sf_contract_opt_guide";
    private String mOrderId;
    private int target = -1;
    private int threshold;
    /* access modifiers changed from: private */
    public int whereFrom = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SfGetOptController(SfContractOptIView sfContractOptIView) {
        super(sfContractOptIView);
        Intrinsics.checkParameterIsNotNull(sfContractOptIView, "view");
    }

    public static final /* synthetic */ SfContractOptIView access$getMView$p(SfGetOptController sfGetOptController) {
        return (SfContractOptIView) sfGetOptController.mView;
    }

    public final void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.target = bundle.getInt("target", 2);
            this.mOrderId = bundle.getString("order_id", (String) null);
            this.threshold = bundle.getInt("threshold", Integer.MAX_VALUE);
            if (this.target == 3) {
                this.whereFrom = 2;
            }
        }
    }

    public final void addContact(SfContactsModel sfContactsModel) {
        Intrinsics.checkParameterIsNotNull(sfContactsModel, "model");
        showLoading();
        new SfContactsManageStore().addContact(false, new Gson().toJson((Object) CollectionsKt.arrayListOf(sfContactsModel)), new SfGetOptController$addContact$1(this));
    }

    /* access modifiers changed from: private */
    public final void setResultAndFinish(Intent intent) {
        IBaseView iBaseView = this.mView;
        Intrinsics.checkExpressionValueIsNotNull(iBaseView, "mView");
        Context context = ((SfContractOptIView) iBaseView).getContext();
        if (context != null) {
            ((Activity) context).setResult(-1, intent);
            IBaseView iBaseView2 = this.mView;
            Intrinsics.checkExpressionValueIsNotNull(iBaseView2, "mView");
            Context context2 = ((SfContractOptIView) iBaseView2).getContext();
            if (context2 != null) {
                ((Activity) context2).finish();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void showGuide() {
        SfContractOptIView sfContractOptIView = (SfContractOptIView) getView();
        Intrinsics.checkExpressionValueIsNotNull(sfContractOptIView, "view");
        Object obj = SPUtils.get(sfContractOptIView.getContext(), this.guideKey, false);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        } else if (!((Boolean) obj).booleanValue()) {
            ((SfContractOptIView) getView()).showGuide();
        }
    }

    public final void goContact() {
        SafeToolKit ins = SafeToolKit.getIns();
        Context context = getContext();
        if (context != null) {
            ins.startGetContactsPage((Activity) context, 1, this.threshold);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void hideGuide() {
        SfContractOptIView sfContractOptIView = (SfContractOptIView) getView();
        Intrinsics.checkExpressionValueIsNotNull(sfContractOptIView, "view");
        SPUtils.put(sfContractOptIView.getContext(), this.guideKey, true);
        ((SfContractOptIView) getView()).hideGuide();
    }

    private final void showLoading() {
        ((SfContractOptIView) getView()).showLoadingState();
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        ((SfContractOptIView) getView()).hideLoadingState();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            if (this.whereFrom == 2) {
                SafeToolKit ins = SafeToolKit.getIns();
                Intrinsics.checkExpressionValueIsNotNull(ins, "SafeToolKit.getIns()");
                ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, ins.getBusinessType()).get();
                if (iSfContactCallbackService != null) {
                    iSfContactCallbackService.onNewTrustedContactAdded(true);
                }
            }
            if (getContext() != null) {
                BroadcastUtil.sendBroadcast(getContext(), SfConstant.SfAction.ACTION_ADD_CONTACTS_SUCCESS);
            }
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            setResultAndFinish(intent2);
        }
    }
}
