package com.didi.component.bubbleLayout.anycar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.taxis99.R;
import java.util.Map;

public class AanycarAbnormalView extends FrameLayout {

    /* renamed from: a */
    private View f10999a;

    /* renamed from: b */
    private Context f11000b;

    /* renamed from: c */
    private ImageView f11001c;

    /* renamed from: d */
    private TextView f11002d;

    /* renamed from: e */
    private TextView f11003e;

    /* renamed from: f */
    private TextView f11004f;

    /* renamed from: g */
    private View f11005g;

    /* renamed from: h */
    private EstimateAbnormalModel f11006h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BtnClickListener f11007i;

    public interface BtnClickListener {
        void click();
    }

    public AanycarAbnormalView(Context context) {
        super(context);
        this.f11000b = context;
        initView();
    }

    public AanycarAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11000b = context;
        initView();
    }

    public AanycarAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11000b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f11000b).inflate(R.layout.anycar_request_error, this, true);
        this.f10999a = inflate;
        inflate.setBackground(this.f11000b.getResources().getDrawable(R.drawable.tab_gradient_bg));
        this.f10999a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f11004f = (TextView) this.f10999a.findViewById(R.id.anycar_abnormal_btn);
        this.f11003e = (TextView) this.f10999a.findViewById(R.id.anycar_abnormal_content);
        this.f11002d = (TextView) this.f10999a.findViewById(R.id.anycar_abnormal_title);
        this.f11001c = (ImageView) this.f10999a.findViewById(R.id.anycar_abnormal_icon);
        this.f11005g = this.f10999a.findViewById(R.id.anycar_abnormal_container);
    }

    public void setData(EstimateAbnormalModel estimateAbnormalModel) {
        this.f11006h = estimateAbnormalModel;
        if (estimateAbnormalModel == null) {
            this.f11004f.setVisibility(0);
            this.f11004f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (AanycarAbnormalView.this.f11007i != null) {
                        AanycarAbnormalView.this.f11007i.click();
                    }
                }
            });
            this.f11001c.setImageDrawable(ResourcesHelper.getDrawable(this.f11000b, R.drawable.new_estimate_error_happen));
            this.f11003e.setText(ResourcesHelper.getString(this.f11000b, R.string.GRider_page_I_suggest_bznI));
            this.f11002d.setText(ResourcesHelper.getString(this.f11000b, R.string.GRider_page_Connection_FZOe));
            this.f11004f.setText(ResourcesHelper.getString(this.f11000b, R.string.GRider_page_Try_again_kabc));
            return;
        }
        this.f11004f.setVisibility(8);
        EstimateAbnormalModel estimateAbnormalModel2 = this.f11006h;
        if (estimateAbnormalModel2 != null && !CollectionUtils.isEmpty((Map) estimateAbnormalModel2.getExtraLog())) {
            GlobalOmegaUtils.trackEvent("ibt_gp_eyeball_exception_sw", this.f11006h.getExtraLog());
        }
        if (!StringUtil.isNullOrEmpty(this.f11006h.abnormalTitle)) {
            this.f11002d.setVisibility(0);
            this.f11002d.setText(this.f11006h.abnormalTitle);
        } else {
            this.f11002d.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(this.f11006h.abnormalContent)) {
            this.f11003e.setVisibility(0);
            this.f11003e.setText(this.f11006h.abnormalContent);
        } else {
            this.f11003e.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(this.f11006h.abnormalIcon)) {
            this.f11001c.setVisibility(0);
            Glide.with(this.f11000b).load(this.f11006h.abnormalIcon).into(this.f11001c);
            return;
        }
        this.f11001c.setVisibility(8);
    }

    public void setClickListener(BtnClickListener btnClickListener) {
        this.f11007i = btnClickListener;
    }
}
