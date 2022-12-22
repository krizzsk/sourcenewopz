package com.didi.payment.wallet.global.wallet.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletBalanceTypeAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001aH\u0016J \u0010#\u001a\u00020\u001c2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010%2\b\u0010\u0014\u001a\u0004\u0018\u00010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$BalanceViewHolder;", "()V", "choseView", "Landroid/view/View;", "getChoseView", "()Landroid/view/View;", "setChoseView", "(Landroid/view/View;)V", "list", "Ljava/util/ArrayList;", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$ItemClickListener;", "getOnItemClickListener", "()Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$ItemClickListener;", "setOnItemClickListener", "(Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$ItemClickListener;)V", "walletBalanceOption", "getWalletBalanceOption", "()Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "setWalletBalanceOption", "(Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataSet", "", "BalanceViewHolder", "ItemClickListener", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletBalanceTypeAdapter.kt */
public final class WalletBalanceTypeAdapter extends RecyclerView.Adapter<BalanceViewHolder> {

    /* renamed from: a */
    private ArrayList<WalletBalanceOption> f32295a = new ArrayList<>();

    /* renamed from: b */
    private ItemClickListener f32296b;

    /* renamed from: c */
    private WalletBalanceOption f32297c;

    /* renamed from: d */
    private View f32298d;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$ItemClickListener;", "", "onItemClick", "", "item", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletBalanceTypeAdapter.kt */
    public interface ItemClickListener {
        void onItemClick(WalletBalanceOption walletBalanceOption);
    }

    public final ItemClickListener getOnItemClickListener() {
        return this.f32296b;
    }

    public final void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.f32296b = itemClickListener;
    }

    public BalanceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dialog_wallet_balance_type, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…rent, false\n            )");
        return new BalanceViewHolder(inflate);
    }

    public final WalletBalanceOption getWalletBalanceOption() {
        return this.f32297c;
    }

    public final void setWalletBalanceOption(WalletBalanceOption walletBalanceOption) {
        this.f32297c = walletBalanceOption;
    }

    public final void setData(List<WalletBalanceOption> list, WalletBalanceOption walletBalanceOption) {
        this.f32297c = walletBalanceOption;
        if (list != null) {
            this.f32295a.clear();
            this.f32295a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final View getChoseView() {
        return this.f32298d;
    }

    public final void setChoseView(View view) {
        this.f32298d = view;
    }

    public void onBindViewHolder(BalanceViewHolder balanceViewHolder, int i) {
        Intrinsics.checkNotNullParameter(balanceViewHolder, "holder");
        WalletBalanceOption walletBalanceOption = this.f32295a.get(i);
        Intrinsics.checkNotNullExpressionValue(walletBalanceOption, "list[position]");
        WalletBalanceOption walletBalanceOption2 = walletBalanceOption;
        balanceViewHolder.bindData(walletBalanceOption2);
        WalletBalanceOption walletBalanceOption3 = this.f32297c;
        if (!(walletBalanceOption3 == null || walletBalanceOption2.getType() == null || !Intrinsics.areEqual((Object) walletBalanceOption2.getType(), (Object) walletBalanceOption3.getType()))) {
            balanceViewHolder.getTvBalance().setSelected(true);
            setChoseView(balanceViewHolder.getTvBalance());
        }
        if (this.f32297c == null && i == 0) {
            View view = this.f32298d;
            if (view != null) {
                view.setSelected(false);
            }
            balanceViewHolder.getTvBalance().setSelected(true);
            this.f32298d = balanceViewHolder.getTvBalance();
        }
        balanceViewHolder.itemView.setOnClickListener(new View.OnClickListener(balanceViewHolder, walletBalanceOption2) {
            public final /* synthetic */ WalletBalanceTypeAdapter.BalanceViewHolder f$1;
            public final /* synthetic */ WalletBalanceOption f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                WalletBalanceTypeAdapter.m22927a(WalletBalanceTypeAdapter.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22927a(WalletBalanceTypeAdapter walletBalanceTypeAdapter, BalanceViewHolder balanceViewHolder, WalletBalanceOption walletBalanceOption, View view) {
        Intrinsics.checkNotNullParameter(walletBalanceTypeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(balanceViewHolder, "$holder");
        Intrinsics.checkNotNullParameter(walletBalanceOption, "$item");
        View choseView = walletBalanceTypeAdapter.getChoseView();
        if (choseView != null) {
            choseView.setSelected(false);
        }
        balanceViewHolder.getTvBalance().setSelected(true);
        balanceViewHolder.itemView.postDelayed(new Runnable(walletBalanceOption) {
            public final /* synthetic */ WalletBalanceOption f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WalletBalanceTypeAdapter.m22926a(WalletBalanceTypeAdapter.this, this.f$1);
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22926a(WalletBalanceTypeAdapter walletBalanceTypeAdapter, WalletBalanceOption walletBalanceOption) {
        Intrinsics.checkNotNullParameter(walletBalanceTypeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(walletBalanceOption, "$item");
        ItemClickListener onItemClickListener = walletBalanceTypeAdapter.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(walletBalanceOption);
        }
    }

    public int getItemCount() {
        return this.f32295a.size();
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$BalanceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvBalance", "Landroid/widget/TextView;", "getTvBalance", "()Landroid/widget/TextView;", "bindData", "", "item", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletBalanceTypeAdapter.kt */
    public static final class BalanceViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvBalance;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BalanceViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_balanceType);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_balanceType)");
            this.tvBalance = (TextView) findViewById;
        }

        public final TextView getTvBalance() {
            return this.tvBalance;
        }

        public final void bindData(WalletBalanceOption walletBalanceOption) {
            Intrinsics.checkNotNullParameter(walletBalanceOption, "item");
            if (this.tvBalance.isSelected()) {
                this.tvBalance.setSelected(false);
            }
            TextView textView = this.tvBalance;
            String label = walletBalanceOption.getLabel();
            if (label == null) {
                label = "";
            }
            textView.setText(label);
        }
    }
}
