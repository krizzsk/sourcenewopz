package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.evaluateentrance.evaluate.model.GXPCarTipInfo;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.taxis99.R;

public class EvaluateTipView extends LinearLayout {

    /* renamed from: a */
    private ViewToolKit f13525a;

    public EvaluateTipView(Context context) {
        super(context);
        m9280a();
    }

    public EvaluateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9280a();
    }

    public EvaluateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9280a();
    }

    public EvaluateTipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9280a();
    }

    /* renamed from: a */
    private void m9280a() {
        LayoutInflater.from(getContext()).inflate(R.layout.g_xp_evaluate_tip_layout, this, true);
        this.f13525a = ViewToolKit.create(this);
    }

    public void initData(GXPCarTipInfo gXPCarTipInfo, String str) {
        setClickable(false);
        if (gXPCarTipInfo == null || !gXPCarTipInfo.isShow()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (gXPCarTipInfo.isPay()) {
            refreshStatus(gXPCarTipInfo);
        } else if (TextUtils.isEmpty(gXPCarTipInfo.entryText)) {
            setVisibility(8);
        } else {
            setClickable(true);
            this.f13525a.setViewVisible((int) R.id.ll_evaluate_tip_entrance, true);
            this.f13525a.setViewVisible((int) R.id.tv_evaluate_tip_paid_text, false);
            this.f13525a.setImageView(R.id.iv_evaluate_tip_icon, gXPCarTipInfo.entryIcon);
            this.f13525a.setTextViewText((int) R.id.tv_evaluate_tip_text, (CharSequence) gXPCarTipInfo.entryText);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_view_sw", "source", str);
    }

    public void refreshStatus(GXPCarTipInfo gXPCarTipInfo) {
        if (gXPCarTipInfo.isShow() && gXPCarTipInfo.isPay()) {
            if (TextUtils.isEmpty(gXPCarTipInfo.entryText)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f13525a.setViewVisible((int) R.id.ll_evaluate_tip_entrance, false);
            this.f13525a.setViewVisible((int) R.id.tv_evaluate_tip_paid_text, true);
            this.f13525a.setTextViewText((int) R.id.tv_evaluate_tip_paid_text, HighlightUtil.highlight(getContext(), gXPCarTipInfo.entryText));
        }
    }

    /* renamed from: a */
    private String m9279a(String str, String str2, String str3) {
        return str.substring(str.indexOf(str2) + 1, str.indexOf(str3));
    }
}
