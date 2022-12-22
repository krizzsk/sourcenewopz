package com.didi.payment.wallet.global.useraccount.balance.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.useraccount.balance.model.recyclerview.BankBalanceItem;
import com.taxis99.R;
import java.util.List;

public class BalanceItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 6;
    public static final int VIEW_TYPE_END_OF_LIST = 5;
    public static final int VIEW_TYPE_INITIAL_LOAD = 1;
    public static final int VIEW_TYPE_LOADING_PROGRESS = 4;
    public static final int VIEW_TYPE_LOADING_TAB = 3;
    public static final int VIEW_TYPE_NETWORK_ERROR_RETRY = 7;
    public static final int VIEW_TYPE_NORMAL = 2;
    public static final int VIEW_TYPE_TITLE = 0;

    /* renamed from: a */
    private static final String f31831a = "BalanceItemAdapter";

    /* renamed from: b */
    private RecyclerView f31832b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f31833c;

    /* renamed from: d */
    private Callback f31834d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<MyWalletItem> f31835e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ILoadMore f31836f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public INetworkErrorRetry f31837g;

    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public interface ILoadMore {
        void onLoadMore();
    }

    public interface INetworkErrorRetry {
        void onRetry();
    }

    public List<MyWalletItem> getBankBalanceItems() {
        return this.f31835e;
    }

    public BalanceItemAdapter(RecyclerView recyclerView, Activity activity, List<MyWalletItem> list) {
        this.f31832b = recyclerView;
        this.f31833c = activity;
        this.f31835e = list;
    }

    public void setCallback(Callback callback) {
        this.f31834d = callback;
    }

    public void setLoadMore(ILoadMore iLoadMore) {
        this.f31836f = iLoadMore;
    }

    public void setRetryCallback(INetworkErrorRetry iNetworkErrorRetry) {
        this.f31837g = iNetworkErrorRetry;
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new TitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_title, viewGroup, false));
        }
        if (i == 1) {
            return new InitalLoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_initial_loading, viewGroup, false));
        }
        if (i == 2) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_list_item, viewGroup, false));
        }
        if (i == 3) {
            return new TabToLoadMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_tab_to_load_more, viewGroup, false));
        }
        if (i == 4) {
            return new LoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_loading_progress, viewGroup, false));
        }
        if (i == 5) {
            return new EndOfListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_end_of_list, viewGroup, false));
        }
        if (i != 7) {
            return new EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_empty_view, viewGroup, false));
        }
        return new NetworkErrorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_network_error, viewGroup, false));
    }

    public int getItemViewType(int i) {
        List<MyWalletItem> list = this.f31835e;
        if (list == null || list.size() == 0) {
            return 6;
        }
        if (this.f31835e.get(i) == null) {
            return 4;
        }
        if (this.f31835e.get(i).mItemViewType == 0) {
            return 0;
        }
        if (this.f31835e.get(i).mItemViewType == 1) {
            return 1;
        }
        if (this.f31835e.get(i).mItemViewType == 3) {
            return 3;
        }
        if (this.f31835e.get(i).mItemViewType == 5) {
            return 5;
        }
        if (this.f31835e.get(i).mItemViewType == 6) {
            return 6;
        }
        return this.f31835e.get(i).mItemViewType == 7 ? 7 : 2;
    }

    public int getItemCount() {
        List<MyWalletItem> list = this.f31835e;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f31835e.size();
    }

    public void clearAllItems() {
        this.f31835e.clear();
        notifyDataSetChanged();
    }

    public void addItemList(List<MyWalletItem> list) {
        this.f31835e.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(MyWalletItem myWalletItem) {
        this.f31835e.add(myWalletItem);
        notifyItemInserted(this.f31835e.size() - 1);
    }

    public void removeAtIndex(int i) {
        this.f31835e.remove(i);
        notifyItemRemoved(i);
    }

    public class ViewHolder extends BaseViewHolder {
        private TextView mTvAmount;
        private TextView mTvDate;
        private TextView mTvItemTitle;
        private TextView mTvTransId;

        public ViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mTvItemTitle = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_title);
            this.mTvDate = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_date);
            this.mTvAmount = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_amount);
            this.mTvTransId = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_trans_id);
        }

        /* access modifiers changed from: protected */
        public void clear() {
            this.mTvItemTitle.setText("");
            this.mTvDate.setText("");
            this.mTvAmount.setText("");
            this.mTvTransId.setText("");
        }

        public void onBind(int i) {
            super.onBind(i);
            BankBalanceItem bankBalanceItem = ((MyWalletItem) BalanceItemAdapter.this.f31835e.get(i)).mBankBalanceItem;
            if (bankBalanceItem.getTitle() != null) {
                this.mTvItemTitle.setText(bankBalanceItem.getTitle());
            }
            if (bankBalanceItem.getDate() != null) {
                this.mTvDate.setText(bankBalanceItem.getDate());
            }
            if (bankBalanceItem.getAmount() != null) {
                bankBalanceItem.getAmount().bindTextView(this.mTvAmount);
            }
            if (bankBalanceItem.getId() != null) {
                TextView textView = this.mTvTransId;
                textView.setText(BalanceItemAdapter.this.f31833c.getResources().getString(R.string.wallet_balance_item_id_prefix) + " " + bankBalanceItem.getId());
            }
        }
    }

    public static class TitleViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        TitleViewHolder(View view) {
            super(view);
        }
    }

    public static class InitalLoadingViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        InitalLoadingViewHolder(View view) {
            super(view);
        }
    }

    public class TabToLoadMoreViewHolder extends BaseViewHolder implements View.OnClickListener {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        TabToLoadMoreViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            BalanceItemAdapter.this.f31836f.onLoadMore();
        }
    }

    public static class EndOfListViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        EndOfListViewHolder(View view) {
            super(view);
        }
    }

    public class NetworkErrorViewHolder extends BaseViewHolder implements View.OnClickListener {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        NetworkErrorViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            BalanceItemAdapter.this.f31837g.onRetry();
        }
    }

    public static class EmptyViewHolder extends BaseViewHolder {
        TextView mTvEmpty;

        /* access modifiers changed from: protected */
        public void clear() {
        }

        EmptyViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mTvEmpty = (TextView) view.findViewById(R.id.tv_balance_empty);
        }
    }

    public static class LoadingViewHolder extends BaseViewHolder {
        ProgressBar mProgressBar;

        /* access modifiers changed from: protected */
        public void clear() {
        }

        public LoadingViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        }

        public void onBind(int i) {
            super.onBind(i);
            this.mProgressBar.setIndeterminate(true);
        }
    }

    public static class MyWalletItem {
        public BankBalanceItem mBankBalanceItem;
        public int mItemViewType;

        public MyWalletItem(int i, BankBalanceItem bankBalanceItem) {
            this.mItemViewType = i;
            this.mBankBalanceItem = bankBalanceItem;
        }
    }
}
