package com.didi.soda.customer.widget.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.taxis99.R;

public class SearchBusinessDishView extends FrameLayout {

    /* renamed from: a */
    private CustomerAppCompatTextView f42167a;

    /* renamed from: b */
    private ImageView f42168b;

    /* renamed from: c */
    private CustomerPriceView f42169c;

    /* renamed from: d */
    private CustomerAppCompatTextView f42170d;

    /* renamed from: e */
    private View f42171e;

    /* renamed from: f */
    private ConstraintLayout f42172f;

    public SearchBusinessDishView(Context context) {
        super(context);
        m29726a();
    }

    public SearchBusinessDishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29726a();
    }

    public SearchBusinessDishView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29726a();
    }

    public SearchBusinessDishView setData(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        String str;
        int i;
        this.f42167a.setText(searchFoodItemModel.name);
        if (TextUtils.isEmpty(searchFoodItemModel.imgUrl)) {
            this.f42168b.setVisibility(8);
        } else {
            this.f42168b.setVisibility(0);
            FlyImageLoader.loadImage4x3(getContext(), searchFoodItemModel.imgUrl).placeholder((int) R.drawable.customer_skin_img_business_goods_item_default).transform(new RoundedCornersTransformation(getContext(), DisplayUtils.dip2px(getContext(), 4.0f), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f42168b);
        }
        if (searchFoodItemModel.specialPrice >= 0) {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.specialPriceDisplay, (long) searchFoodItemModel.specialPrice, searchFoodItemModel.currency, "search");
        } else {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search");
        }
        String currencyDisplay = searchFoodItemModel.specialPrice >= 0 ? LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search") : "";
        this.f42169c.setFontType(IToolsService.FontType.LIGHT, IToolsService.FontType.LIGHT);
        this.f42169c.setPriceStr(str, currencyDisplay);
        if (GoodsDataHelper.isNormal(searchFoodItemModel.status)) {
            this.f42170d.setVisibility(8);
            i = DisplayUtils.dip2px(getContext(), 59.0f);
        } else {
            this.f42170d.setVisibility(0);
            i = DisplayUtils.dip2px(getContext(), 68.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.f42172f.getLayoutParams();
        layoutParams.height = i;
        this.f42172f.setLayoutParams(layoutParams);
        return this;
    }

    public SearchBusinessDishView setClickListener(View.OnClickListener onClickListener) {
        this.f42171e.setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: a */
    private void m29726a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_search_dish_item_view, this);
        this.f42167a = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_name);
        this.f42168b = (ImageView) findViewById(R.id.customer_iv_image);
        this.f42169c = (CustomerPriceView) findViewById(R.id.customer_custom_price);
        this.f42170d = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_sold_out);
        this.f42171e = findViewById(R.id.customer_view_item_mark);
        this.f42172f = (ConstraintLayout) findViewById(R.id.customer_cl_item_container);
    }
}
