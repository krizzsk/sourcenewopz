package com.didi.soda.customer.widget.goodsV2;

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
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsStateBar extends ConstraintLayout {

    /* renamed from: a */
    private CustomerPriceView f41941a;

    /* renamed from: b */
    private TextView f41942b;

    /* renamed from: c */
    private NovaFlowLayout f41943c;

    /* renamed from: d */
    private FrameLayout f41944d;

    /* renamed from: e */
    private List<GoodActTagLayout> f41945e = new ArrayList();

    /* renamed from: f */
    private CustomerAppCompatTextView f41946f;

    public GoodsStateBar(Context context) {
        super(context);
        m29571c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29571c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29571c();
    }

    public GoodsStateBar setGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        if (goodsAmountModel.mGoodsItemState == GoodsItemState.FOR_SALE) {
            this.f41942b.setTextColor(SkinUtil.getBrandPrimaryColor());
        } else {
            this.f41942b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        }
        return this;
    }

    public GoodsStateBar setMarketingTip(SpannableStringBuilder spannableStringBuilder) {
        if (this.f41942b == null) {
            return this;
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.f41942b.setVisibility(0);
            this.f41942b.setText(spannableStringBuilder);
        } else {
            this.f41942b.setVisibility(8);
        }
        return this;
    }

    public GoodsStateBar setPrice(String str, String str2) {
        CustomerPriceView customerPriceView = this.f41941a;
        if (customerPriceView != null) {
            customerPriceView.setPriceStr(str, str2);
        }
        return this;
    }

    public GoodsStateBar setPriceLight(boolean z) {
        CustomerPriceView customerPriceView = this.f41941a;
        if (customerPriceView != null) {
            customerPriceView.setPriceLight(z);
        }
        return this;
    }

    public GoodsStateBar setLimitLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f41946f.setVisibility(8);
        } else {
            this.f41946f.setVisibility(0);
            this.f41946f.setText(str);
        }
        return this;
    }

    public GoodsStateBar setActTag(List<ActTagEntity> list) {
        if (list == null || list.size() <= 0) {
            this.f41943c.setVisibility(8);
        } else {
            m29570b();
            for (ActTagEntity next : list) {
                if (!TextUtils.isEmpty(next.richText)) {
                    GoodActTagLayout a = m29569a();
                    if (a == null) {
                        a = new GoodActTagLayout(getContext());
                    }
                    this.f41943c.addView(a);
                    a.setActTag(next);
                    this.f41943c.setVisibility(0);
                }
            }
        }
        return this;
    }

    public GoodsStateBar setActTag(GoodsPurchaseHeaderRvModel.ActTagModel actTagModel, GoodsItemState goodsItemState, View.OnClickListener onClickListener) {
        if (actTagModel == null || TextUtils.isEmpty(actTagModel.content)) {
            this.f41943c.setVisibility(8);
        } else {
            this.f41943c.setVisibility(0);
            m29570b();
            GoodActTagLayout a = m29569a();
            if (a == null) {
                a = new GoodActTagLayout(getContext());
                a.setOnClickListener(onClickListener);
            }
            this.f41943c.addView(a);
            a.setActTag(actTagModel, goodsItemState);
        }
        return this;
    }

    /* renamed from: a */
    private GoodActTagLayout m29569a() {
        if (this.f41945e.size() > 0) {
            return this.f41945e.remove(0);
        }
        return null;
    }

    /* renamed from: b */
    private void m29570b() {
        int childCount = this.f41943c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f41943c.getChildAt(i);
            if (childAt instanceof GoodActTagLayout) {
                this.f41945e.add((GoodActTagLayout) childAt);
            }
        }
        this.f41943c.removeAllViews();
    }

    /* renamed from: c */
    private void m29571c() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_goods_state_bar_v2, this);
        this.f41941a = (CustomerPriceView) findViewById(R.id.customer_custom_goods_price);
        this.f41942b = (TextView) findViewById(R.id.customer_tv_goods_marketing_tips);
        this.f41943c = (NovaFlowLayout) findViewById(R.id.customer_tv_goods_act_tag);
        this.f41944d = (FrameLayout) findViewById(R.id.customer_fl_price_container);
        this.f41946f = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_goods_limit_des);
        this.f41941a.setFontType(IToolsService.FontType.BOLD, IToolsService.FontType.LIGHT);
    }
}
