package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.model.GoodsPurchaseHeaderRvModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsStateBar extends ConstraintLayout {

    /* renamed from: a */
    private CustomerPriceView f41865a;

    /* renamed from: b */
    private TextView f41866b;

    /* renamed from: c */
    private NovaFlowLayout f41867c;

    /* renamed from: d */
    private FrameLayout f41868d;

    /* renamed from: e */
    private List<GoodActTagLayout> f41869e = new ArrayList();

    public GoodsStateBar(Context context) {
        super(context);
        m29529c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29529c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29529c();
    }

    public GoodsStateBar setGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        if (goodsAmountModel.mGoodsItemState == GoodsItemState.FOR_SALE) {
            this.f41866b.setTextColor(SkinUtil.getBrandPrimaryColor());
        } else {
            this.f41866b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        }
        return this;
    }

    public GoodsStateBar setMarketingTip(SpannableStringBuilder spannableStringBuilder) {
        if (this.f41866b == null) {
            return this;
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.f41866b.setVisibility(0);
            this.f41866b.setText(spannableStringBuilder);
        } else {
            this.f41866b.setVisibility(8);
        }
        return this;
    }

    public GoodsStateBar setMaxPriceWidth(int i) {
        CustomerPriceView customerPriceView = this.f41865a;
        if (customerPriceView != null) {
            customerPriceView.setMaxWidth(i);
        }
        return this;
    }

    public GoodsStateBar setPrice(String str, String str2) {
        CustomerPriceView customerPriceView = this.f41865a;
        if (customerPriceView != null) {
            customerPriceView.setPriceStr(str, str2);
        }
        return this;
    }

    public GoodsStateBar setActTag(List<ActTagEntity> list) {
        if (list == null || list.size() <= 0) {
            this.f41867c.setVisibility(8);
        } else {
            this.f41867c.setVisibility(0);
            m29528b();
            for (ActTagEntity next : list) {
                GoodActTagLayout a = m29527a();
                if (a == null) {
                    a = new GoodActTagLayout(getContext());
                }
                this.f41867c.addView(a);
                a.setActTag(next);
            }
        }
        return this;
    }

    public GoodsStateBar setActTag(GoodsPurchaseHeaderRvModel.ActTagModel actTagModel, GoodsItemState goodsItemState) {
        if (actTagModel != null) {
            this.f41867c.setVisibility(0);
            m29528b();
            GoodActTagLayout a = m29527a();
            if (a == null) {
                a = new GoodActTagLayout(getContext());
            }
            this.f41867c.addView(a);
            a.setActTag(actTagModel, goodsItemState);
        } else {
            this.f41867c.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private GoodActTagLayout m29527a() {
        if (this.f41869e.size() > 0) {
            return this.f41869e.remove(0);
        }
        return null;
    }

    /* renamed from: b */
    private void m29528b() {
        int childCount = this.f41867c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f41867c.getChildAt(i);
            if (childAt instanceof GoodActTagLayout) {
                this.f41869e.add((GoodActTagLayout) childAt);
            }
        }
        this.f41867c.removeAllViews();
    }

    /* renamed from: c */
    private void m29529c() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_goods_state_bar, this);
        this.f41865a = (CustomerPriceView) findViewById(R.id.customer_custom_goods_price);
        this.f41866b = (TextView) findViewById(R.id.customer_tv_goods_marketing_tips);
        this.f41867c = (NovaFlowLayout) findViewById(R.id.customer_tv_goods_act_tag);
        this.f41868d = (FrameLayout) findViewById(R.id.customer_fl_price_container);
        this.f41865a.setFontType(IToolsService.FontType.LIGHT, IToolsService.FontType.LIGHT);
    }
}
