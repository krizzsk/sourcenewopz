package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.taxis99.R;

public class HomeFilterNoResultView extends ConstraintLayout {

    /* renamed from: a */
    private LinearLayout f43129a;

    /* renamed from: b */
    private ImageView f43130b;

    /* renamed from: c */
    private TextView f43131c;

    /* renamed from: d */
    private TextView f43132d;

    /* renamed from: e */
    private CustomerAppCompatTextView f43133e;

    /* renamed from: f */
    private ResetSizeListener f43134f;

    public interface ResetSizeListener {
        void setYourOwnSize(HomeNoResultRvModel homeNoResultRvModel, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, CustomerAppCompatTextView customerAppCompatTextView);
    }

    public HomeFilterNoResultView(Context context) {
        super(context);
        m30518a();
    }

    public HomeFilterNoResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30518a();
    }

    public HomeFilterNoResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30518a();
    }

    public void show(HomeNoResultRvModel homeNoResultRvModel) {
        if (TextUtils.isEmpty(homeNoResultRvModel.mBgImg)) {
            this.f43130b.setImageResource(R.drawable.customer_img_topgun_no_shop_result);
        } else {
            FlyImageLoader.loadImage1x1(getContext(), homeNoResultRvModel.mBgImg).placeholder((int) R.drawable.customer_img_topgun_no_shop_result).fitCenter().into(this.f43130b);
        }
        this.f43130b.setVisibility(0);
        this.f43131c.setText(homeNoResultRvModel.mTitleName);
        if (TextUtils.isEmpty(homeNoResultRvModel.mSubTitle)) {
            this.f43132d.setVisibility(8);
        } else {
            this.f43132d.setText(homeNoResultRvModel.mSubTitle);
            this.f43132d.setVisibility(0);
        }
        if (TextUtils.isEmpty(homeNoResultRvModel.mBtnText)) {
            this.f43133e.setVisibility(8);
            return;
        }
        this.f43133e.setVisibility(0);
        this.f43133e.setText(homeNoResultRvModel.mBtnText);
    }

    public void setResetSizeListener(ResetSizeListener resetSizeListener) {
        this.f43134f = resetSizeListener;
    }

    public void reset(HomeNoResultRvModel homeNoResultRvModel) {
        ResetSizeListener resetSizeListener = this.f43134f;
        if (resetSizeListener != null) {
            resetSizeListener.setYourOwnSize(homeNoResultRvModel, this.f43129a, this.f43130b, this.f43131c, this.f43132d, this.f43133e);
        }
    }

    /* renamed from: a */
    private void m30518a() {
        m30519b();
    }

    /* renamed from: b */
    private void m30519b() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f43129a = linearLayout;
        linearLayout.setOrientation(1);
        this.f43129a.setGravity(1);
        this.f43130b = new CustomerAppCompatImageView(getContext());
        this.f43131c = new CustomerAppCompatTextView(getContext());
        this.f43132d = new CustomerAppCompatTextView(getContext());
        CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(getContext());
        this.f43133e = customerAppCompatTextView;
        customerAppCompatTextView.setTag("RETRY");
        this.f43131c.setGravity(17);
        this.f43131c.setTextSize(1, 16.0f);
        this.f43131c.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43131c, IToolsService.FontType.BOLD);
        this.f43132d.setGravity(17);
        this.f43132d.setTextSize(1, 12.0f);
        this.f43132d.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43132d, IToolsService.FontType.NORMAL);
        this.f43133e.setGravity(17);
        this.f43133e.setTextSize(1, 14.0f);
        this.f43133e.setTextColor(SkinUtil.getBrandPrimaryColor());
        this.f43133e.setPadding(DisplayUtils.dip2px(getContext(), 14.0f), DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 14.0f), DisplayUtils.dip2px(getContext(), 8.0f));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43133e, IToolsService.FontType.MEDIUM);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(DisplayUtils.dip2px(getContext(), 0.5f), SkinUtil.getBrandPrimaryColor());
        gradientDrawable.setCornerRadius((float) DisplayUtils.dip2px(getContext(), 9.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(DisplayUtils.dip2px(getContext(), 0.5f), SkinUtil.getBrandPrimaryColor());
        gradientDrawable2.setColor(ColorUtil.getColorWithAlpha(0.08f, SkinUtil.getBrandPrimaryColor()));
        gradientDrawable2.setCornerRadius((float) DisplayUtils.dip2px(getContext(), 9.0f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable);
        this.f43133e.setBackground(stateListDrawable);
        int dip2px = DisplayUtils.dip2px(getContext(), 144.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 17;
        this.f43130b.setScaleType(ImageView.ScaleType.CENTER);
        this.f43129a.addView(this.f43130b, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), -4.0f);
        this.f43129a.addView(this.f43131c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = DisplayUtils.dip2px(getContext(), 2.0f);
        this.f43129a.addView(this.f43132d, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = DisplayUtils.dip2px(getContext(), 21.0f);
        this.f43129a.addView(this.f43133e, layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-1, DisplayUtils.getScreenHeight(getContext()) - DisplayUtils.dip2px(getContext(), (float) (GlobalContext.isEmbed() ? 206 : 160)));
        this.f43129a.setPadding(0, DisplayUtils.dip2px(getContext(), 90.0f), 0, 0);
        addView(this.f43129a, layoutParams5);
    }
}
