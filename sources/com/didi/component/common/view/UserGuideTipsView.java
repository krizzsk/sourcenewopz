package com.didi.component.common.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.tips.TipsView;
import com.taxis99.R;

public class UserGuideTipsView extends TipsView {
    public UserGuideTipsView(Context context) {
        super(context);
        m8037a();
    }

    /* renamed from: a */
    private void m8037a() {
        this.mLineContainer.setBackgroundResource(R.drawable.global_tips_bg_shape);
        ((ImageView) this.mIvTriangleBC).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleBR).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleBL).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTC).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTL).setImageResource(R.drawable.global_tips_triangle_below_bg);
        ((ImageView) this.mIvTriangleTR).setImageResource(R.drawable.global_tips_triangle_below_bg);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.iv_close);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -1;
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) frameLayout.getChildAt(0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.topMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_8dp);
        layoutParams2.rightMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_10dp);
        imageView.setLayoutParams(layoutParams2);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rl_container);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams3.leftMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_10dp);
        layoutParams3.topMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_5dp);
        layoutParams3.bottomMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_6dp);
        layoutParams3.rightMargin = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_20dp);
        viewGroup.setLayoutParams(layoutParams3);
    }
}
