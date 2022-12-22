package com.didi.soda.customer.widget.goods.add;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.add.IGoodsAddView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.taxis99.R;

public class NormalGoodsAddView extends CustomerAppCompatTextView implements IGoodsAddView<NormalGoodsAddViewModel> {
    public NormalGoodsAddView(Context context) {
        super(context);
        m29533a();
    }

    public NormalGoodsAddView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29533a();
    }

    public NormalGoodsAddView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29533a();
    }

    public void updateViewModel(NormalGoodsAddViewModel normalGoodsAddViewModel) {
        if (normalGoodsAddViewModel.goodsItemState == GoodsItemState.FOR_SALE) {
            setEnabled(true);
            setTextColor(SkinUtil.getBrandPrimaryColor());
            return;
        }
        setEnabled(false);
        setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
    }

    public IGoodsAddView.AddType getAddType() {
        return IGoodsAddView.AddType.NORMAL;
    }

    /* renamed from: a */
    private void m29533a() {
        setGravity(17);
        setHeight(DisplayUtils.dip2px(getContext(), 30.0f));
        setMinWidth(DisplayUtils.dip2px(getContext(), 84.0f));
        setTextSize(1, 14.0f);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
        setText(getContext().getResources().getString(R.string.customer_global_add));
        setBackgroundResource(R.drawable.customer_skin_shape_bg_business_goods_item_add);
    }

    public static class NormalGoodsAddViewModel implements C13842a {
        GoodsItemState goodsItemState;

        public static NormalGoodsAddViewModel newInstance(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            NormalGoodsAddViewModel normalGoodsAddViewModel = new NormalGoodsAddViewModel();
            normalGoodsAddViewModel.goodsItemState = businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState;
            return normalGoodsAddViewModel;
        }
    }
}
