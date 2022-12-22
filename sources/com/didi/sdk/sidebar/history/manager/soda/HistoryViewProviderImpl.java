package com.didi.sdk.sidebar.history.manager.soda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.util.SaApolloUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class HistoryViewProviderImpl implements HistoryViewProvider {

    /* renamed from: a */
    private Context f37388a;

    /* renamed from: b */
    private boolean f37389b = false;

    /* renamed from: c */
    private int f37390c = 0;

    /* renamed from: d */
    private int f37391d = 0;

    /* renamed from: e */
    private String f37392e = "";

    public View getItemView(Context context) {
        this.f37388a = context;
        return m26594a(context);
    }

    public void bindItem(AbsHistoryOrder absHistoryOrder, View view) {
        Context context = view.getContext();
        FoodHistoryItemModel foodHistoryItemModel = (FoodHistoryItemModel) absHistoryOrder;
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mItemState.setText(foodHistoryItemModel.mItemOrderState);
        viewHolder.mItemName.setText(foodHistoryItemModel.mItemName);
        viewHolder.mItemShopName.setText(foodHistoryItemModel.mItemShopName);
        viewHolder.mItemNum.setText(String.format(this.f37392e, new Object[]{Integer.valueOf(foodHistoryItemModel.mItemNum)}));
        viewHolder.mItemTotalPrice.setText(foodHistoryItemModel.mItemPriceDisplay);
        if (foodHistoryItemModel.isFinished()) {
            viewHolder.mItemTime.setText(foodHistoryItemModel.mItemCreateTime);
            viewHolder.mItemState.setTextColor(context.getResources().getColor(R.color.customer_color_66));
        } else {
            viewHolder.mItemTime.setText(foodHistoryItemModel.mItemEtc);
            viewHolder.mItemState.setTextColor(context.getResources().getColor(R.color.customer_color_FF7A45));
        }
        viewHolder.mItemBuyAgain.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = viewHolder.mBottomHolder.getLayoutParams();
        layoutParams.height = 43;
        viewHolder.mBottomHolder.setLayoutParams(layoutParams);
    }

    public void clickHistoryItemView(Context context, AbsHistoryOrder absHistoryOrder) {
        HistoryRecordStore.getInstance().closeHistoryRecordFragment();
        HashMap hashMap = new HashMap();
        hashMap.put("content", "soda");
        OmegaSDKAdapter.trackEvent("ibt_gp_mytrip_order_ck", (Map<String, Object>) hashMap);
        if (absHistoryOrder != null) {
            FoodHistoryItemModel foodHistoryItemModel = (FoodHistoryItemModel) absHistoryOrder;
            Request build = DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://soda/orderPage");
            if (SaApolloUtil.INSTANCE.getSaState()) {
                build = (Request) build.putExtra(HistoryRecordConstant.PARAMS_POP_BACK_STACK, 1);
            }
            ((Request) build.putExtra("orderid", foodHistoryItemModel.mOrderId)).start(context);
        }
    }

    /* renamed from: a */
    private View m26594a(Context context) {
        m26595a();
        FrameLayout frameLayout = new FrameLayout(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_item_history_item, (ViewGroup) null, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, this.f37391d);
        frameLayout.addView(inflate, layoutParams);
        return frameLayout;
    }

    /* renamed from: a */
    private void m26595a() {
        if (!this.f37389b) {
            this.f37389b = true;
            this.f37390c = 43;
            this.f37391d = 13;
            this.f37392e = this.f37388a.getResources().getString(R.string.customer_history_num_format);
        }
    }

    static class ViewHolder {
        View mBottomHolder;
        TextView mItemBuyAgain;
        TextView mItemName;
        TextView mItemNum;
        TextView mItemShopName;
        TextView mItemState;
        TextView mItemTime;
        TextView mItemTotalPrice;
        TextView mItemType;
        View mItemView;

        ViewHolder(View view) {
            this.mItemView = view;
            this.mItemType = (TextView) view.findViewById(R.id.customer_tv_item_type);
            this.mItemState = (TextView) view.findViewById(R.id.customer_tv_item_state);
            this.mItemTime = (TextView) view.findViewById(R.id.customer_tv_time);
            this.mItemShopName = (TextView) view.findViewById(R.id.customer_tv_shop_name);
            this.mItemName = (TextView) view.findViewById(R.id.customer_tv_item_name);
            this.mItemNum = (TextView) view.findViewById(R.id.customer_tv_item_num);
            this.mItemTotalPrice = (TextView) view.findViewById(R.id.customer_tv_total_price);
            this.mItemBuyAgain = (TextView) view.findViewById(R.id.customer_tv_buy_again);
            this.mBottomHolder = view.findViewById(R.id.customer_view_bottom_holder);
        }
    }
}
