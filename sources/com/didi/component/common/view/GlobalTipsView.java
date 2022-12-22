package com.didi.component.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.tips.TipsView;
import com.taxis99.R;

public class GlobalTipsView extends TipsView {
    public GlobalTipsView(Context context) {
        super(context);
        m8015a();
    }

    public GlobalTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlobalTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GlobalTipsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m8015a() {
        this.mLineContainer.setBackgroundResource(R.drawable.global_tips_bg_shape);
        ((ImageView) this.mIvTriangleBC).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleBR).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleBL).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTC).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTR).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTL).setImageResource(R.drawable.global_tips_triangle_below_bg);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvGuide.getLayoutParams();
        layoutParams.rightMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_7dp);
        layoutParams.width = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.im_30_dp);
        layoutParams.height = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.im_16_dp);
        this.mIvGuide.setLayoutParams(layoutParams);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rl_text);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams2.topMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_7dp);
        layoutParams2.bottomMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_7dp);
        layoutParams2.addRule(15);
        viewGroup.setLayoutParams(layoutParams2);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.rl_container);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup2.getLayoutParams();
        layoutParams3.leftMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_9dp);
        layoutParams3.rightMargin = 0;
        layoutParams3.topMargin = 0;
        layoutParams3.bottomMargin = 0;
        viewGroup2.setLayoutParams(layoutParams3);
        findViewById(R.id.iv_guide_frame_close).setVisibility(0);
        findViewById(R.id.iv_close).setVisibility(8);
        int defineMaxContentWidth = defineMaxContentWidth();
        TextView textView = (TextView) findViewById(R.id.tv_tips_content_more_line);
        textView.setIncludeFontPadding(false);
        textView.setMaxWidth(defineMaxContentWidth);
        TextView textView2 = (TextView) findViewById(R.id.tv_tips_content_2_line);
        textView2.setIncludeFontPadding(false);
        textView2.setMaxWidth(defineMaxContentWidth);
        TextView textView3 = (TextView) findViewById(R.id.tv_tips_content_1_line);
        textView3.setIncludeFontPadding(false);
        textView3.setMaxWidth(defineMaxContentWidth);
    }

    /* access modifiers changed from: protected */
    public int defineMaxContentWidth() {
        return ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.im_140_dp);
    }
}
