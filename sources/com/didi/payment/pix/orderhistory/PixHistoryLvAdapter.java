package com.didi.payment.pix.orderhistory;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.pix.net.response.PixOrderHistoryListResp;
import com.didi.payment.pix.orderhistory.PixHistoryLvAdapter;
import com.didi.payment.pix.orderhistory.p137vm.PixOrderHistoryVM;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/pix/orderhistory/PixHistoryLvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/pix/orderhistory/PixHistoryLvAdapter$HistoryViewHolder;", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroid/content/Context;Landroidx/lifecycle/ViewModelStoreOwner;)V", "historyOrderVm", "Lcom/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM;", "getHistoryOrderVm", "()Lcom/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM;", "setHistoryOrderVm", "(Lcom/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM;)V", "orders", "", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp$OrderItem;", "appendOrderData", "", "newData", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HistoryViewHolder", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixHistoryLvAdapter.kt */
public final class PixHistoryLvAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    /* renamed from: a */
    private Context f31121a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<PixOrderHistoryListResp.OrderItem> f31122b = new ArrayList();
    public PixOrderHistoryVM historyOrderVm;

    public PixHistoryLvAdapter(Context context, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        this.f31121a = context;
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner).get(PixOrderHistoryVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)…derHistoryVM::class.java)");
        setHistoryOrderVm((PixOrderHistoryVM) viewModel);
    }

    public PixOrderHistoryVM getHistoryOrderVm() {
        PixOrderHistoryVM pixOrderHistoryVM = this.historyOrderVm;
        if (pixOrderHistoryVM != null) {
            return pixOrderHistoryVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("historyOrderVm");
        return null;
    }

    public void setHistoryOrderVm(PixOrderHistoryVM pixOrderHistoryVM) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryVM, "<set-?>");
        this.historyOrderVm = pixOrderHistoryVM;
    }

    public final void appendOrderData(List<PixOrderHistoryListResp.OrderItem> list) {
        List<PixOrderHistoryListResp.OrderItem> list2 = this.f31122b;
        if (list2 == null) {
            this.f31122b = list;
            notifyDataSetChanged();
            return;
        }
        Intrinsics.checkNotNull(list2);
        int size = list2.size();
        if (list != null) {
            List<PixOrderHistoryListResp.OrderItem> list3 = this.f31122b;
            Intrinsics.checkNotNull(list3);
            list3.addAll(list);
        }
        notifyItemInserted(size);
    }

    public HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f31121a).inflate(R.layout.pix_order_history_item_lay, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_item_lay, parent, false)");
        return new HistoryViewHolder(this, inflate);
    }

    public void onBindViewHolder(HistoryViewHolder historyViewHolder, int i) {
        Intrinsics.checkNotNullParameter(historyViewHolder, "holder");
        List<PixOrderHistoryListResp.OrderItem> list = this.f31122b;
        Intrinsics.checkNotNull(list);
        historyViewHolder.bindData(list.get(i), i);
    }

    public int getItemCount() {
        List<PixOrderHistoryListResp.OrderItem> list = this.f31122b;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/pix/orderhistory/PixHistoryLvAdapter$HistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/didi/payment/pix/orderhistory/PixHistoryLvAdapter;Landroid/view/View;)V", "mAmountTv", "Landroid/widget/TextView;", "mItem", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp$OrderItem;", "mNameTv", "mOrderTimeTv", "mStatusDescTv", "bindData", "", "item", "position", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixHistoryLvAdapter.kt */
    public final class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView mAmountTv;
        private PixOrderHistoryListResp.OrderItem mItem;
        private final TextView mNameTv;
        private final TextView mOrderTimeTv;
        private final TextView mStatusDescTv;
        final /* synthetic */ PixHistoryLvAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HistoryViewHolder(PixHistoryLvAdapter pixHistoryLvAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(pixHistoryLvAdapter, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = pixHistoryLvAdapter;
            View findViewById = view.findViewById(R.id.pix_trans_history_item_name_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…ans_history_item_name_tv)");
            this.mNameTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.pix_trans_history_item_time_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…ans_history_item_time_tv)");
            this.mOrderTimeTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.pix_trans_history_item_amount_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…s_history_item_amount_tv)");
            this.mAmountTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.trans_history_item_pay_status_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…story_item_pay_status_tv)");
            this.mStatusDescTv = (TextView) findViewById4;
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ PixHistoryLvAdapter.HistoryViewHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PixHistoryLvAdapter.HistoryViewHolder.m46590_init_$lambda0(PixHistoryLvAdapter.this, this.f$1, view);
                }
            });
        }

        public final void bindData(PixOrderHistoryListResp.OrderItem orderItem, int i) {
            if (orderItem != null) {
                this.mItem = orderItem;
                this.mNameTv.setText(orderItem.name);
                this.mOrderTimeTv.setText(orderItem.ctime);
                this.mAmountTv.setText(orderItem.amount);
                this.mStatusDescTv.setText(orderItem.status);
                try {
                    int parseColor = Color.parseColor(orderItem.color4Amount);
                    this.mAmountTv.setTextColor(parseColor);
                    this.mStatusDescTv.setTextColor(parseColor);
                } catch (Exception unused) {
                }
                List access$getOrders$p = this.this$0.f31122b;
                Intrinsics.checkNotNull(access$getOrders$p);
                if (i == access$getOrders$p.size() - 1) {
                    this.this$0.getHistoryOrderVm().getEndOfListWatcher().setValue(true);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m46590_init_$lambda0(PixHistoryLvAdapter pixHistoryLvAdapter, HistoryViewHolder historyViewHolder, View view) {
            Intrinsics.checkNotNullParameter(pixHistoryLvAdapter, "this$0");
            Intrinsics.checkNotNullParameter(historyViewHolder, "this$1");
            pixHistoryLvAdapter.getHistoryOrderVm().getOnItemClickListener().setValue(historyViewHolder.mItem);
        }
    }
}
