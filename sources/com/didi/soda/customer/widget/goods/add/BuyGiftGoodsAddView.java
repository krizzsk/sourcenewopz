package com.didi.soda.customer.widget.goods.add;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.didi.soda.customer.widget.goods.add.IGoodsAddView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.taxis99.R;

public class BuyGiftGoodsAddView extends LinearLayout implements IGoodsAddView<BuyGiftGoodsAddViewModel> {

    /* renamed from: a */
    private BuyGiftDescTextView f41876a;

    /* renamed from: b */
    private CustomerPriceView f41877b;

    /* renamed from: c */
    private View f41878c;

    public BuyGiftGoodsAddView(Context context) {
        super(context);
        m29532a();
    }

    public BuyGiftGoodsAddView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29532a();
    }

    public void updateViewModel(BuyGiftGoodsAddViewModel buyGiftGoodsAddViewModel) {
        GoodsItemState goodsItemState = buyGiftGoodsAddViewModel.goodsItemState;
        this.f41876a.setText(buyGiftGoodsAddViewModel.mBuyGiftDesc);
        this.f41877b.setPriceStr(buyGiftGoodsAddViewModel.mBuyGiftPriceDisplay, buyGiftGoodsAddViewModel.mBuyGiftOriPriceDisplay);
        if (goodsItemState == GoodsItemState.FOR_SALE) {
            this.f41876a.setTextColor(SkinUtil.getBrandPrimaryColor());
            setEnabled(true);
            this.f41876a.setEnabled(true);
            this.f41877b.setEnabled(true);
            this.f41878c.setEnabled(true);
            return;
        }
        this.f41876a.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        setEnabled(false);
        this.f41876a.setEnabled(false);
        this.f41877b.setEnabled(false);
        this.f41878c.setEnabled(false);
    }

    public IGoodsAddView.AddType getAddType() {
        return IGoodsAddView.AddType.BUY_GIFT;
    }

    /* renamed from: a */
    private void m29532a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_buy_gift_goods_add_view, this, true);
        this.f41876a = (BuyGiftDescTextView) findViewById(R.id.customer_tv_buy_gift_desc);
        this.f41877b = (CustomerPriceView) findViewById(R.id.customer_custom_buy_gift_price);
        View findViewById = findViewById(R.id.customer_rl_buy_gift_price_container);
        this.f41878c = findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.leftMargin = 0 - DisplayUtils.dip2px(getContext(), 0.5f);
        this.f41878c.setLayoutParams(marginLayoutParams);
        int uponBrandPrimaryTextColor = SkinUtil.getUponBrandPrimaryTextColor();
        this.f41877b.setCurPriceColor(uponBrandPrimaryTextColor);
        this.f41877b.setDisableCurPriceColor(uponBrandPrimaryTextColor);
        this.f41877b.setOriginPriceColor(ColorUtil.getColorWithAlpha(0.5f, uponBrandPrimaryTextColor));
        this.f41877b.setDisableOriginPriceColor(ColorUtil.getColorWithAlpha(0.5f, uponBrandPrimaryTextColor));
        this.f41877b.setFontType(IToolsService.FontType.BOLD, IToolsService.FontType.NORMAL);
    }

    public static class BuyGiftGoodsAddViewModel implements C13842a {
        public GoodsItemState goodsItemState;
        public String mBuyGiftDesc;
        public String mBuyGiftOriPriceDisplay;
        public CharSequence mBuyGiftPriceDisplay;

        public static BuyGiftGoodsAddViewModel newInstance(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
            BuyGiftGoodsAddViewModel buyGiftGoodsAddViewModel = new BuyGiftGoodsAddViewModel();
            buyGiftGoodsAddViewModel.goodsItemState = businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState;
            buyGiftGoodsAddViewModel.mBuyGiftDesc = businessGoodsItemRvModel.mBuyGiftDesc;
            buyGiftGoodsAddViewModel.mBuyGiftPriceDisplay = businessGoodsItemRvModel.mBuyGiftPriceDisplay;
            buyGiftGoodsAddViewModel.mBuyGiftOriPriceDisplay = businessGoodsItemRvModel.mBuyGiftOriPriceDisplay;
            return buyGiftGoodsAddViewModel;
        }
    }
}
