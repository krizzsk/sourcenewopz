package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.IHomeViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.IData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R*\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "list", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Ljava/util/List;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getLister", "()Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "setLister", "(Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeAdapter */
/* compiled from: WalletHomeAdapter.kt */
public final class WalletHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private List<WalletHomeHolderData<? extends IData>> f32632a;

    /* renamed from: b */
    private WalletHomeContract.V2Listener f32633b;

    public final List<WalletHomeHolderData<? extends IData>> getList() {
        return this.f32632a;
    }

    public final void setList(List<WalletHomeHolderData<? extends IData>> list) {
        this.f32632a = list;
    }

    public WalletHomeAdapter(List<WalletHomeHolderData<? extends IData>> list, WalletHomeContract.V2Listener v2Listener) {
        this.f32632a = list;
        this.f32633b = v2Listener;
    }

    public final WalletHomeContract.V2Listener getLister() {
        return this.f32633b;
    }

    public final void setLister(WalletHomeContract.V2Listener v2Listener) {
        this.f32633b = v2Listener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        RecyclerView.ViewHolder findViewHolderByType = WalletViewHolderFactory.Companion.findViewHolderByType(viewGroup, i, this.f32633b);
        if (findViewHolderByType instanceof IHomeViewHolder) {
            ((IHomeViewHolder) findViewHolderByType).onCreateViewHolder(viewGroup);
        }
        return findViewHolderByType;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        List<WalletHomeHolderData<? extends IData>> list = this.f32632a;
        if (list != null) {
            WalletHomeHolderData walletHomeHolderData = list.get(i);
            if (viewHolder instanceof IHomeViewHolder) {
                ((IHomeViewHolder) viewHolder).onBindViewHolder(walletHomeHolderData);
            }
        }
    }

    public int getItemCount() {
        List<WalletHomeHolderData<? extends IData>> list = this.f32632a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemViewType(int i) {
        WalletHomeHolderData walletHomeHolderData;
        Integer viewType;
        List<WalletHomeHolderData<? extends IData>> list = this.f32632a;
        if (list == null || (walletHomeHolderData = list.get(i)) == null || (viewType = walletHomeHolderData.getViewType()) == null) {
            return -1;
        }
        return viewType.intValue();
    }
}
