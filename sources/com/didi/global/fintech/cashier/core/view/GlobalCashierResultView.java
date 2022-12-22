package com.didi.global.fintech.cashier.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultView;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/view/GlobalCashierResultView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultView;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mCenterView", "kotlin.jvm.PlatformType", "mRootView", "Landroid/view/View;", "payViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "getPayViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "payViewHolder$delegate", "Lkotlin/Lazy;", "view", "getView", "()Landroid/view/View;", "paySuccessView", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultView.kt */
public final class GlobalCashierResultView extends GlobalCashierBaseView<IGlobalCashierResultPresenter> implements IGlobalCashierResultView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f21521a;

    /* renamed from: b */
    private final View f21522b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f21523c;

    /* renamed from: d */
    private final Lazy f21524d = LazyKt.lazy(new GlobalCashierResultView$payViewHolder$2(this));

    public void setupView(SuccessInfoResponse successInfoResponse) {
        Intrinsics.checkNotNullParameter(successInfoResponse, "response");
    }

    public GlobalCashierResultView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f21521a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_global_cashier_result, viewGroup);
        this.f21522b = inflate;
        this.f21523c = (ViewGroup) inflate.findViewById(R.id.fl_nsv_center);
    }

    /* renamed from: a */
    private final IGlobalCashierResultPayViewHolder m15766a() {
        return (IGlobalCashierResultPayViewHolder) this.f21524d.getValue();
    }

    public IGlobalCashierResultPayViewHolder paySuccessView() {
        return m15766a();
    }

    public View getView() {
        return this.f21522b;
    }
}
