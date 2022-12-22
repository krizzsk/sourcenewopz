package com.didi.entrega.pay.pospay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.entrega.customer.base.ICustomerView;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.didi.entrega.pay.pospay.PosListView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PosListView extends ICustomerView<PosListPresenter> {

    /* renamed from: a */
    private Adapter f21011a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<PayMethodInfoModel.CardInfoModel> f21012b = new ArrayList();
    @BindView(16334)
    public View mBackView;
    @BindView(16362)
    public RecyclerView mRecycleView;
    @BindView(16407)
    public CustomerAppCompatTextView mTitleView;

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public void updateData(List<PayMethodInfoModel.CardInfoModel> list) {
        if (list != null) {
            this.f21012b.clear();
            this.f21012b.addAll(list);
            this.f21011a.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PosListView.this.m15377a(view);
            }
        });
        this.mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = this.mRecycleView;
        Adapter adapter = new Adapter();
        this.f21011a = adapter;
        recyclerView.setAdapter(adapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15377a(View view) {
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_component_pos_list_container, viewGroup);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15378a(PayMethodInfoModel.CardInfoModel cardInfoModel) {
        for (PayMethodInfoModel.CardInfoModel cardInfoModel2 : this.f21012b) {
            cardInfoModel2.mIsSelected = false;
        }
        cardInfoModel.mIsSelected = true;
        this.f21011a.notifyDataSetChanged();
        ((PosListPresenter) getPresenter()).onSelectPos(cardInfoModel);
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private Adapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_item_pos_pay_method, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            PayMethodInfoModel.CardInfoModel cardInfoModel = (PayMethodInfoModel.CardInfoModel) PosListView.this.f21012b.get(i);
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
            if (PosListView.this.f21012b.size() == 1) {
                viewHolder.itemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
            } else if (i == 0) {
                viewHolder.itemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_top);
            } else if (i == PosListView.this.f21012b.size() - 1) {
                viewHolder.itemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_below);
            } else {
                viewHolder.itemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_center);
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$PosListView$Adapter(PayMethodInfoModel.CardInfoModel cardInfoModel, View view) {
            PosListView.this.m15378a(cardInfoModel);
        }

        public int getItemCount() {
            return PosListView.this.f21012b.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private View mDivider;
        private ImageView mIconImageView;
        private ImageView mSelectedView;
        private CustomerAppCompatTextView mTitleView;

        public ViewHolder(View view) {
            super(view);
            this.mIconImageView = (ImageView) view.findViewById(R.id.customer_tv_cart_paymethod_icon);
            this.mTitleView = (CustomerAppCompatTextView) view.findViewById(R.id.customer_tv_cart_paymethod_item_title);
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
