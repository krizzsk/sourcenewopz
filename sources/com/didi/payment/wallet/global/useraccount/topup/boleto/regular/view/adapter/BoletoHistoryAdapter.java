package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.taxis99.R;
import java.util.List;

public class BoletoHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    /* renamed from: a */
    private static final String f31985a = "BoletoHistoryAdapter";

    /* renamed from: b */
    private RecyclerView f31986b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f31987c;

    /* renamed from: d */
    private Callback f31988d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AdapterView.OnItemClickListener f31989e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<WalletBoletoResp> f31990f;

    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public List<WalletBoletoResp> getBoletoHistoryItems() {
        return this.f31990f;
    }

    public WalletBoletoResp getItem(int i) {
        return this.f31990f.get(i);
    }

    public BoletoHistoryAdapter(RecyclerView recyclerView, Activity activity, List<WalletBoletoResp> list, AdapterView.OnItemClickListener onItemClickListener) {
        this.f31986b = recyclerView;
        this.f31987c = activity;
        this.f31990f = list;
        this.f31989e = onItemClickListener;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public void setCallback(Callback callback) {
        this.f31988d = callback;
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_boleto_history_list_item_empty, viewGroup, false));
        }
        return new ViewHolder(this.f31987c, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_boleto_history_list_item, viewGroup, false));
    }

    public int getItemViewType(int i) {
        List<WalletBoletoResp> list = this.f31990f;
        return (list == null || list.size() <= 0) ? 0 : 1;
    }

    public int getItemCount() {
        List<WalletBoletoResp> list = this.f31990f;
        if (list == null || list.size() <= 0) {
            return 1;
        }
        return this.f31990f.size();
    }

    public void addItemList(List<WalletBoletoResp> list) {
        this.f31990f.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(WalletBoletoResp walletBoletoResp) {
        this.f31990f.add(walletBoletoResp);
        notifyItemInserted(this.f31990f.size() - 1);
    }

    public void removeAtIndex(int i) {
        this.f31990f.remove(i);
        notifyItemRemoved(i);
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private Context mContext;
        private TextView mTvAmount;
        private TextView mTvDate;
        private TextView mTvStatus;
        public final View mView;

        public ViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.mView = view;
            initView(view);
            setUp(view);
        }

        private void setUp(View view) {
            view.setOnClickListener(this);
        }

        private void initView(View view) {
            this.mTvAmount = (TextView) view.findViewById(R.id.tv_wallet_boleto_history_list_item_amount);
            this.mTvStatus = (TextView) view.findViewById(R.id.tv_wallet_boleto_history_list_item_status);
            this.mTvDate = (TextView) view.findViewById(R.id.tv_wallet_boleto_history_list_item_date_content);
        }

        /* access modifiers changed from: protected */
        public void clear() {
            this.mTvAmount.setText("");
            this.mTvStatus.setText("");
            this.mTvDate.setText("");
        }

        public void onBind(int i) {
            super.onBind(i);
            WalletBoletoResp walletBoletoResp = (WalletBoletoResp) BoletoHistoryAdapter.this.f31990f.get(i);
            if (walletBoletoResp.amount != null || !walletBoletoResp.amount.getContent().equalsIgnoreCase("")) {
                walletBoletoResp.amount.bindTextView(this.mTvAmount);
            }
            if (walletBoletoResp.status != null) {
                setStatus(walletBoletoResp.status);
            }
            if (walletBoletoResp.expiryTime != null) {
                this.mTvDate.setText(walletBoletoResp.expiryTime);
            }
        }

        private void setAmount(String str) {
            String str2 = "R$" + str;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(this.mContext, 30.0f)), 0, str2.length(), 0);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(this.mContext, 16.0f)), 0, 2, 0);
            spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, str2.length(), 0);
            this.mTvAmount.setText(spannableString);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setStatus(java.lang.String r5) {
            /*
                r4 = this;
                java.lang.String r5 = r5.toUpperCase()
                int r0 = r5.hashCode()
                r1 = -1787006747(0xffffffff957c70e5, float:-5.0980053E-26)
                r2 = 2
                r3 = 1
                if (r0 == r1) goto L_0x002e
                r1 = -591252731(0xffffffffdcc23305, float:-4.37297936E17)
                if (r0 == r1) goto L_0x0024
                r1 = 2448076(0x255acc, float:3.430485E-39)
                if (r0 == r1) goto L_0x001a
                goto L_0x0038
            L_0x001a:
                java.lang.String r0 = "PAID"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0038
                r5 = 1
                goto L_0x0039
            L_0x0024:
                java.lang.String r0 = "EXPIRED"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0038
                r5 = 0
                goto L_0x0039
            L_0x002e:
                java.lang.String r0 = "UNPAID"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0038
                r5 = 2
                goto L_0x0039
            L_0x0038:
                r5 = -1
            L_0x0039:
                if (r5 == 0) goto L_0x0064
                if (r5 == r3) goto L_0x005b
                if (r5 == r2) goto L_0x0040
                goto L_0x006c
            L_0x0040:
                android.widget.TextView r5 = r4.mTvStatus
                r0 = 2131958212(0x7f1319c4, float:1.955303E38)
                r5.setText(r0)
                android.widget.TextView r5 = r4.mTvStatus
                com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.BoletoHistoryAdapter r0 = com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.BoletoHistoryAdapter.this
                android.app.Activity r0 = r0.f31987c
                r1 = 2131101862(0x7f0608a6, float:1.7816146E38)
                int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
                r5.setTextColor(r0)
                goto L_0x006c
            L_0x005b:
                android.widget.TextView r5 = r4.mTvStatus
                r0 = 2131958211(0x7f1319c3, float:1.9553028E38)
                r5.setText(r0)
                goto L_0x006c
            L_0x0064:
                android.widget.TextView r5 = r4.mTvStatus
                r0 = 2131958210(0x7f1319c2, float:1.9553026E38)
                r5.setText(r0)
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.BoletoHistoryAdapter.ViewHolder.setStatus(java.lang.String):void");
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            GlobalOmegaUtils.trackBoletoCashinHistoryBillCK();
            BoletoHistoryAdapter.this.f31989e.onItemClick((AdapterView) null, this.mView, getAdapterPosition(), (long) this.mView.getId());
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
            this.mTvEmpty = (TextView) view.findViewById(R.id.tv_boleto_history_empty_text);
        }
    }
}
