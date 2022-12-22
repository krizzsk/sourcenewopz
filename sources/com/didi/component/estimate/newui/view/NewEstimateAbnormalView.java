package com.didi.component.estimate.newui.view;

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
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NewEstimateAbnormalView extends FrameLayout {

    /* renamed from: a */
    private View f13112a;

    /* renamed from: b */
    private Context f13113b;

    /* renamed from: c */
    private ImageView f13114c;

    /* renamed from: d */
    private TextView f13115d;

    /* renamed from: e */
    private TextView f13116e;

    /* renamed from: f */
    private TextView f13117f;

    /* renamed from: g */
    private View f13118g;

    /* renamed from: h */
    private List<EstimateAbnormalModel> f13119h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BtnClickListener f13120i;

    public interface BtnClickListener {
        void click();
    }

    public NewEstimateAbnormalView(Context context) {
        super(context);
        this.f13113b = context;
        initView();
    }

    public NewEstimateAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13113b = context;
        initView();
    }

    public NewEstimateAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13113b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f13113b).inflate(R.layout.new_etsimate_request_error, this, true);
        this.f13112a = inflate;
        inflate.setBackground(this.f13113b.getResources().getDrawable(R.drawable.tab_gradient_bg));
        this.f13117f = (TextView) this.f13112a.findViewById(R.id.new_estimate_abnormal_btn);
        this.f13116e = (TextView) this.f13112a.findViewById(R.id.new_estimate_abnormal_content);
        this.f13115d = (TextView) this.f13112a.findViewById(R.id.new_estimate_abnormal_title);
        this.f13114c = (ImageView) this.f13112a.findViewById(R.id.new_estimate_abnormal_icon);
        this.f13118g = this.f13112a.findViewById(R.id.new_estimate_abnormal_container);
    }

    public void setData(List<EstimateAbnormalModel> list) {
        this.f13119h = list;
        if (CollectionUtils.isEmpty((Collection) list)) {
            this.f13117f.setVisibility(0);
            this.f13117f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (NewEstimateAbnormalView.this.f13120i != null) {
                        NewEstimateAbnormalView.this.f13120i.click();
                    }
                }
            });
            this.f13114c.setImageDrawable(ResourcesHelper.getDrawable(this.f13113b, R.drawable.new_estimate_error_happen));
            this.f13116e.setText(ResourcesHelper.getString(this.f13113b, R.string.GRider_page_I_suggest_bznI));
            this.f13115d.setText(ResourcesHelper.getString(this.f13113b, R.string.GRider_page_Connection_FZOe));
            this.f13117f.setText(ResourcesHelper.getString(this.f13113b, R.string.GRider_page_Try_again_kabc));
            return;
        }
        this.f13117f.setVisibility(8);
        EstimateAbnormalModel estimateAbnormalModel = this.f13119h.get(0);
        if (estimateAbnormalModel != null && !CollectionUtils.isEmpty((Map) estimateAbnormalModel.getExtraLog())) {
            GlobalOmegaUtils.trackEvent("ibt_gp_eyeball_exception_sw", estimateAbnormalModel.getExtraLog());
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalTitle)) {
            this.f13115d.setVisibility(0);
            this.f13115d.setText(estimateAbnormalModel.abnormalTitle);
        } else {
            this.f13115d.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalContent)) {
            this.f13116e.setVisibility(0);
            this.f13116e.setText(estimateAbnormalModel.abnormalContent);
        } else {
            this.f13116e.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalIcon)) {
            this.f13114c.setVisibility(0);
            Glide.with(this.f13113b).load(estimateAbnormalModel.abnormalIcon).into(this.f13114c);
            return;
        }
        this.f13114c.setVisibility(8);
    }

    public void setClickListener(BtnClickListener btnClickListener) {
        this.f13120i = btnClickListener;
    }
}
