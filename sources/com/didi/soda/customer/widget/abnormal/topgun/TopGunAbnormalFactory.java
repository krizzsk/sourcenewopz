package com.didi.soda.customer.widget.abnormal.topgun;

import android.view.View;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.taxis99.R;

public final class TopGunAbnormalFactory {
    private TopGunAbnormalFactory() {
    }

    public static TopGunAbnormalViewModel buildNoNetwork(View.OnClickListener onClickListener) {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_abnormal_net_error).setTitle(ResourceHelper.getString(R.string.customer_net_error_tip)).setSubTitle(ResourceHelper.getString(R.string.customer_net_error_tip_subtitle)).setRetryText(ResourceHelper.getString(R.string.customer_try_again)).setClickListener(onClickListener).build();
    }

    public static TopGunAbnormalViewModel buildHomeNoService(String str, View.OnClickListener onClickListener) {
        if (str.contains(StringConst.JAVA)) {
            LogUtil.m29102e("+", str);
            str = ResourceHelper.getString(R.string.customer_service_not_connected);
        }
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_abnormal_no_service).setTitle(str).setSubTitle(ResourceHelper.getString(R.string.customer_try_again_later)).setRetryText(ResourceHelper.getString(R.string.customer_try_again)).setClickListener(onClickListener).build();
    }

    public static TopGunAbnormalViewModel buildShopNoResultService() {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_abnormal_no_result).setTitle(ResourceHelper.getString(R.string.customer_name_business_search_no_result)).setSubTitle(ResourceHelper.getString(R.string.customer_name_business_search_no_result_try)).build();
    }

    public static TopGunAbnormalViewModel buildCollectionNoData(View.OnClickListener onClickListener) {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.common_icon_collection_empty).setTitle(ResourceHelper.getString(R.string.customer_favorites_no_data)).setSubTitle(ResourceHelper.getString(R.string.customer_favorites_no_data_tips)).setRetryText(ResourceHelper.getString(R.string.customer_collection_find_stores)).setClickListener(onClickListener).build();
    }

    public static TopGunAbnormalViewModel buildGlobalCartNoData() {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_abnormal_no_result).setTitle(ResourceHelper.getString(R.string.customer_global_cart_no_data)).setSubTitle(ResourceHelper.getString(R.string.customer_global_cart_no_data_tips)).build();
    }

    public static TopGunAbnormalViewModel buildSearchResultNoData() {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_no_shop_result).setTitle(ResourceHelper.getString(R.string.customer_search_no_result_tip)).build();
    }

    public static TopGunAbnormalViewModel buildHistoryOrderNoData(View.OnClickListener onClickListener) {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.common_icon_history_order_empty).setTitle(ResourceHelper.getString(R.string.FoodC_rebuild_No_Order_Bwfw)).setClickListener(onClickListener).build();
    }

    public static TopGunAbnormalViewModel buildHistoryNoLogin(View.OnClickListener onClickListener) {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.common_icon_history_order_empty).setTitle(ResourceHelper.getString(R.string.FoodC_rebuild_Not_yet_CNFK)).setSubTitle(ResourceHelper.getString(R.string.FoodC_rebuild_Login_to_EtCI)).setRetryText(ResourceHelper.getString(R.string.FoodC_rebuild_Sign_in_jHLY)).setClickListener(onClickListener).build();
    }

    public static TopGunAbnormalViewModel buildAllCategoryNoData() {
        return new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_abnormal_no_result).setTitle(ResourceHelper.getString(R.string.customer_global_no_data_available)).build();
    }
}
