package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.view.helper.RedDotViewHelper;
import com.taxis99.R;

public class PayMethodSettingFragmentView extends PayMethodBaseFragmentView implements View.OnClickListener {

    /* renamed from: a */
    private LinearLayout f36339a;

    /* renamed from: b */
    private LinearLayout f36340b;

    /* renamed from: c */
    private LinearLayout f36341c;

    /* renamed from: d */
    private LinearLayout f36342d;

    /* renamed from: e */
    private LinearLayout f36343e;

    /* renamed from: f */
    private LinearLayout f36344f;

    /* renamed from: g */
    private TextView f36345g;

    /* renamed from: h */
    private TextView f36346h;

    /* renamed from: i */
    private ImageView f36347i;

    /* renamed from: j */
    private PaySelPageData f36348j;

    public int getEnterpriseFlag() {
        return 0;
    }

    public PayMethodSettingFragmentView(Context context) {
        super(context);
        m25715a(context);
    }

    public PayMethodSettingFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25715a(context);
    }

    /* renamed from: a */
    private void m25715a(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_paymethod_setting, this, true);
        this.f36342d = (LinearLayout) findViewById(R.id.ll_paymethod_container);
        this.f36341c = (LinearLayout) findViewById(R.id.ll_promotion_container);
        this.f36343e = (LinearLayout) findViewById(R.id.ll_paymethod);
        this.f36344f = (LinearLayout) findViewById(R.id.ll_promotion);
        this.f36339a = (LinearLayout) findViewById(R.id.ll_empty);
        this.f36340b = (LinearLayout) findViewById(R.id.ll_content);
        this.f36345g = (TextView) findViewById(R.id.tv_promotion_title);
        this.f36346h = (TextView) findViewById(R.id.tv_paymethod_title);
        ImageView imageView = (ImageView) findViewById(R.id.iv_paymethod_rules);
        this.f36347i = imageView;
        imageView.setOnClickListener(this);
        this.f36339a.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mPayMethodPageEventListener != null) {
            this.mPayMethodPageEventListener.onPageClickEvent(view, this.f36348j);
        }
    }

    public void showEmptyView() {
        this.f36340b.setVisibility(8);
        this.f36339a.setVisibility(0);
    }

    public void showContentView() {
        this.f36340b.setVisibility(0);
        this.f36339a.setVisibility(8);
    }

    public void updateContentView(PaySelPageData paySelPageData, DidiGlobalPayMethodListData.Entrance entrance, EnterprisePayway enterprisePayway) {
        this.f36348j = paySelPageData;
        if (paySelPageData == null || paySelPageData.payMethodList == null || this.f36348j.payMethodList.size() == 0) {
            showEmptyView();
            return;
        }
        showContentView();
        if (TextUtils.isEmpty(this.f36348j.ruleUrl)) {
            this.f36347i.setVisibility(8);
        }
        if (paySelPageData.payMethodList == null || paySelPageData.payMethodList.size() <= 0) {
            this.f36343e.setVisibility(8);
        } else {
            this.f36343e.setVisibility(0);
            this.f36346h.setText(paySelPageData.payMethodTitle);
            this.mCardViewManager.insertPayMethodView(this.f36342d, paySelPageData.payMethodList, (EnterprisePayway) null);
            RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
        }
        if (paySelPageData.promotionList == null || paySelPageData.promotionList.size() <= 0) {
            this.f36344f.setVisibility(8);
            return;
        }
        this.f36344f.setVisibility(0);
        this.f36345g.setText(paySelPageData.promotionTitle);
        this.mCardViewManager.insertPromotionView(this.f36341c, paySelPageData.promotionList);
        RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
    }
}
