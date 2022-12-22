package com.didi.entrega.customer.widget.abnormal;

import android.view.View;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.soda.customer.app.constant.StringConst;
import com.taxis99.R;

public final class AbnormalViewModelFactory {
    private AbnormalViewModelFactory() {
    }

    public static AbnormalViewModel buildNoNetwork(View.OnClickListener onClickListener) {
        return new AbnormalViewModel.Builder().setResId(R.drawable.entrega_img_abnormal_net_error).setTitle(ResourceHelper.getString(R.string.FoodC_orderlist3_No_network_XMSJ)).setSubTitle(ResourceHelper.getString(R.string.FoodC_orderlist3_Check_the_uDiY)).setRetryText(ResourceHelper.getString(R.string.FoodC_orderlist3_Try_again_HqaK)).setClickListener(onClickListener).build();
    }

    public static AbnormalViewModel buildNoService(String str, View.OnClickListener onClickListener) {
        if (str.contains(StringConst.JAVA)) {
            LogUtil.m14763e("+", str);
            str = ResourceHelper.getString(R.string.FoodC_orderlist3_No_service_laow);
        }
        return new AbnormalViewModel.Builder().setResId(R.drawable.entrega_img_abnormal).setTitle(str).setSubTitle(ResourceHelper.getString(R.string.FoodC_unpaid_Please_try_BFRt)).setRetryText(ResourceHelper.getString(R.string.FoodC_orderlist3_Try_again_HqaK)).setClickListener(onClickListener).build();
    }

    public static AbnormalViewModel buildOrderListNoData(View.OnClickListener onClickListener) {
        return new AbnormalViewModel.Builder().setResId(R.drawable.entrega_img_abnormal).setTitle(ResourceHelper.getString(R.string.FoodC_order2_No_order_wxgV)).setClickListener(onClickListener).build();
    }
}
