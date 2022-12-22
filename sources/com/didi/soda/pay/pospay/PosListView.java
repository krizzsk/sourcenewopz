package com.didi.soda.pay.pospay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.pay.model.PayMethodInfoModel;
import com.didi.soda.pay.pospay.PosListView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PosListView extends ICustomerView<PosListPresenter> {

    /* renamed from: a */
    private Adapter f43640a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<PayMethodInfoModel.CardInfoModel> f43641b = new ArrayList();
    @BindView(18382)
    public View mBackView;
    @BindView(18673)
    public RecyclerView mRecycleView;
    @BindView(19089)
    public TextView mTitleView;

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void updateData(List<PayMethodInfoModel.CardInfoModel> list) {
        if (list != null) {
            this.f43641b.clear();
            this.f43641b.addAll(list);
            this.f43640a.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PosListView.this.m30940a(view);
            }
        });
        this.mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = this.mRecycleView;
        Adapter adapter = new Adapter();
        this.f43640a = adapter;
        recyclerView.setAdapter(adapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30940a(View view) {
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_pos_list_container, viewGroup);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30941a(PayMethodInfoModel.CardInfoModel cardInfoModel) {
        for (PayMethodInfoModel.CardInfoModel cardInfoModel2 : this.f43641b) {
            cardInfoModel2.mIsSelected = false;
        }
        cardInfoModel.mIsSelected = true;
        this.f43640a.notifyDataSetChanged();
        ((PosListPresenter) getPresenter()).onSelectPos(cardInfoModel);
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private Adapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_pos_pay_method, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            PayMethodInfoModel.CardInfoModel cardInfoModel = (PayMethodInfoModel.CardInfoModel) PosListView.this.f43641b.get(i);
            viewHolder.setData(cardInfoModel, i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(cardInfoModel) {
                public final /* synthetic */ PayMethodInfoModel.CardInfoModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PosListView.Adapter.this.lambda$onBindViewHolder$0$PosListView$Adapter(this.f$1, view);
                }
            });
            if (PosListView.this.f43641b.size() == 1) {
                viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
            } else if (i == 0) {
                viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item_top);
            } else if (i == PosListView.this.f43641b.size() - 1) {
                viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item_below);
            } else {
                viewHolder.itemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item_center);
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$PosListView$Adapter(PayMethodInfoModel.CardInfoModel cardInfoModel, View view) {
            PosListView.this.m30941a(cardInfoModel);
        }

        public int getItemCount() {
            return PosListView.this.f43641b.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private View mDivider;
        private ImageView mIconImageView;
        private ImageView mSelectedView;
        private TextView mTitleView;

        public ViewHolder(View view) {
            super(view);
            this.mIconImageView = (ImageView) view.findViewById(R.id.customer_tv_cart_paymethod_icon);
            this.mTitleView = (TextView) view.findViewById(R.id.customer_tv_cart_paymethod_item_title);
            this.mSelectedView = (ImageView) view.findViewById(R.id.customer_iv_cart_paymethod_right_icon);
            this.mDivider = view.findViewById(R.id.customer_v_pos_list_divider);
        }

        /* access modifiers changed from: package-private */
        public void setData(PayMethodInfoModel.CardInfoModel cardInfoModel, int i) {
            FlyImageLoader.loadImageUnspecified(PosListView.this.getContext(), cardInfoModel.cardOrg).centerCrop().into(this.mIconImageView);
            this.mTitleView.setText(cardInfoModel.cardName);
            this.mSelectedView.setSelected(cardInfoModel.mIsSelected);
            if (i == 0) {
                this.mDivider.setVisibility(8);
            } else {
                this.mDivider.setVisibility(0);
            }
        }
    }
}
