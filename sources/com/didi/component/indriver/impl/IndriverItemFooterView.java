package com.didi.component.indriver.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.taxis99.R;

public class IndriverItemFooterView extends ConstraintLayout {

    /* renamed from: a */
    private View f14152a;

    /* renamed from: b */
    private Context f14153b;

    /* renamed from: c */
    private TextView f14154c;

    /* renamed from: d */
    private ImageView f14155d;

    /* renamed from: e */
    private boolean f14156e = true;
    protected AbsIndriverPresenter mPresenter;

    public IndriverItemFooterView(Context context) {
        super(context);
        this.f14153b = context;
        m9900a(context);
    }

    public IndriverItemFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14153b = context;
        m9900a(context);
    }

    public IndriverItemFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14153b = context;
        m9900a(context);
    }

    public void setPrisenter(AbsIndriverPresenter absIndriverPresenter) {
        this.mPresenter = absIndriverPresenter;
    }

    public void setArrowExpand(boolean z) {
        this.f14156e = z;
    }

    /* renamed from: a */
    private void m9900a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.indriver_item_footer, this, true);
        this.f14152a = inflate;
        this.f14154c = (TextView) inflate.findViewById(R.id.expand_tv);
        this.f14155d = (ImageView) this.f14152a.findViewById(R.id.arrow_iv);
        this.f14152a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IndriverItemFooterView.this.updateHeightWithAnim();
            }
        });
    }

    public boolean isArrowExpand() {
        return this.f14156e;
    }

    public void updateHeightWithAnim() {
        GLog.m7968e("dxt", "updateHeightWithAnim " + this.f14156e);
        AbsIndriverPresenter absIndriverPresenter = this.mPresenter;
        if (absIndriverPresenter != null) {
            absIndriverPresenter.expandView(this.f14156e);
            if (this.f14156e) {
                this.f14155d.setBackgroundResource(R.drawable.arrow_up);
                this.f14154c.setText(getResources().getString(R.string.GDriver_Fix_Collapse_ilot));
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_negotiate_detail_unfold_ck");
            } else {
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_negotiate_detail_pack_ck");
                this.f14155d.setBackgroundResource(R.drawable.arrow_donw);
                this.f14154c.setText(getResources().getString(R.string.GDriver_Fix_Launching_yxfQ));
            }
            this.f14156e = !this.f14156e;
        }
    }
}
