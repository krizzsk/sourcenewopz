package com.didi.global.fintech.cashier.threeds.view.cvv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.view.GlobalCashierBaseView;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVViewHolder;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/view/cvv/GlobalCashierCVVView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVView;", "mContext", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mBottomView", "kotlin.jvm.PlatformType", "mBtnViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "getMBtnViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "mBtnViewHolder$delegate", "Lkotlin/Lazy;", "mContentView", "mContentViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "getMContentViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "mContentViewHolder$delegate", "mHeaderView", "mHeaderViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "getMHeaderViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "mHeaderViewHolder$delegate", "mRootView", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "btnView", "cvvView", "headerView", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVView.kt */
public final class GlobalCashierCVVView extends GlobalCashierBaseView<IGlobalCashierCVVPresenter> implements IGlobalCashierCVVView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f21689a;

    /* renamed from: b */
    private final View f21690b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f21691c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ViewGroup f21692d = ((ViewGroup) this.f21690b.findViewById(R.id.layout_content_container));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ViewGroup f21693e = ((ViewGroup) this.f21690b.findViewById(R.id.layout_bottom_container));

    /* renamed from: f */
    private final Lazy f21694f = LazyKt.lazy(new GlobalCashierCVVView$mHeaderViewHolder$2(this));

    /* renamed from: g */
    private final Lazy f21695g = LazyKt.lazy(new GlobalCashierCVVView$mContentViewHolder$2(this));

    /* renamed from: h */
    private final Lazy f21696h = LazyKt.lazy(new GlobalCashierCVVView$mBtnViewHolder$2(this));

    public void setupView(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "response");
    }

    public GlobalCashierCVVView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f21689a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_global_cashier_cvv, viewGroup);
        this.f21690b = inflate;
        this.f21691c = (ViewGroup) inflate.findViewById(R.id.layout_header_container);
    }

    public View getView() {
        return this.f21690b;
    }

    /* renamed from: a */
    private final IGlobalCashierHeaderViewHolder m15810a() {
        return (IGlobalCashierHeaderViewHolder) this.f21694f.getValue();
    }

    /* renamed from: b */
    private final IGlobalCashierCVVViewHolder m15811b() {
        return (IGlobalCashierCVVViewHolder) this.f21695g.getValue();
    }

    /* renamed from: c */
    private final IGlobalCashierCVVBtnViewHolder m15812c() {
        return (IGlobalCashierCVVBtnViewHolder) this.f21696h.getValue();
    }

    public IGlobalCashierHeaderViewHolder headerView() {
        return m15810a();
    }

    public IGlobalCashierCVVViewHolder cvvView() {
        return m15811b();
    }

    public IGlobalCashierCVVBtnViewHolder btnView() {
        return m15812c();
    }
}
