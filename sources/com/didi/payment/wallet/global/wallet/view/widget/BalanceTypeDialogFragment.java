package com.didi.payment.wallet.global.wallet.view.widget;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletBalanceTypeAdapter;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\u001e\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/widget/BalanceTypeDialogFragment;", "Lcom/didi/sdk/view/SimplePopupBase;", "()V", "adapter", "Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter;", "getAdapter", "()Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "timeListener", "Lkotlin/Function1;", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "", "getTimeListener", "()Lkotlin/jvm/functions/Function1;", "setTimeListener", "(Lkotlin/jvm/functions/Function1;)V", "addOnSelectListener", "time", "getLayout", "", "initView", "setDate", "list", "", "walletBalanceOption", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BalanceTypeDialogFragment.kt */
public final class BalanceTypeDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private final Lazy f32822a = LazyKt.lazy(BalanceTypeDialogFragment$adapter$2.INSTANCE);

    /* renamed from: b */
    private Function1<? super WalletBalanceOption, Unit> f32823b;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_dialog_balance_type;
    }

    public final WalletBalanceTypeAdapter getAdapter() {
        return (WalletBalanceTypeAdapter) this.f32822a.getValue();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        View findViewById = this.mRootView.findViewById(R.id.btn_closeImg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.btn_closeImg)");
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BalanceTypeDialogFragment.m23165a(BalanceTypeDialogFragment.this, view);
            }
        });
        View findViewById2 = this.mRootView.findViewById(R.id.rv_balance_type);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.rv_balance_type)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        recyclerView.setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new BalanceTypeDialogFragment$initView$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23165a(BalanceTypeDialogFragment balanceTypeDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(balanceTypeDialogFragment, "this$0");
        balanceTypeDialogFragment.dismiss();
    }

    public final void setDate(List<WalletBalanceOption> list, WalletBalanceOption walletBalanceOption) {
        Intrinsics.checkNotNullParameter(list, "list");
        getAdapter().setData(list, walletBalanceOption);
    }

    public final Function1<WalletBalanceOption, Unit> getTimeListener() {
        return this.f32823b;
    }

    public final void setTimeListener(Function1<? super WalletBalanceOption, Unit> function1) {
        this.f32823b = function1;
    }

    public final void addOnSelectListener(Function1<? super WalletBalanceOption, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "time");
        this.f32823b = function1;
    }
}
