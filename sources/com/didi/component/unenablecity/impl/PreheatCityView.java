package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.IPreheatCityView;
import com.didi.sdk.util.SaApolloUtil;
import com.taxis99.R;

public class PreheatCityView implements View.OnClickListener, IPreheatCityView {
    protected static final float IMAGE_RATIO = 2.6785715f;
    protected TextView mContentView = ((TextView) this.mRootView.findViewById(R.id.tv_global_preheat_city_content));
    protected Activity mContext;
    protected ImageView mImageView;
    protected AbsUnableCityPresenter mPresenter;
    protected View mRootView;
    protected TextView mTitleView;

    public int getLayoutResId() {
        return R.layout.global_preheat_city_layout;
    }

    public PreheatCityView(Activity activity, ViewGroup viewGroup) {
        this.mContext = activity;
        View inflate = ViewGroup.inflate(activity, getLayoutResId(), viewGroup);
        this.mRootView = inflate;
        this.mTitleView = (TextView) inflate.findViewById(R.id.tv_global_preheat_city_title);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.iv_global_preheat_city_image);
        this.mImageView = imageView;
        imageView.setOnClickListener(this);
        float screenWidth = ((float) UIUtils.getScreenWidth(activity)) / IMAGE_RATIO;
        ViewGroup.LayoutParams layoutParams = this.mImageView.getLayoutParams();
        layoutParams.height = (int) screenWidth;
        this.mImageView.setLayoutParams(layoutParams);
        this.mRootView.setBackgroundResource(R.color.white);
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.mPresenter = absUnableCityPresenter;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
    }

    public void setContent(CharSequence charSequence) {
        this.mContentView.setText(charSequence);
    }

    public void showImage(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mImageView.setVisibility(8);
        } else if (Build.VERSION.SDK_INT < 17 || !this.mContext.isDestroyed()) {
            Glide.with(this.mContext).load((Object) new GlideUrl(str)).into(this.mImageView);
        }
    }

    public void showImage(int i) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            if (SaApolloUtil.INSTANCE.getSaState()) {
                i = R.drawable.sa_unable_city_no_guide;
            }
            imageView.setImageResource(i);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.iv_global_preheat_city_image) {
            onPreheatImageClicked();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreheatImageClicked() {
        AbsUnableCityPresenter absUnableCityPresenter = this.mPresenter;
        if (absUnableCityPresenter != null) {
            absUnableCityPresenter.onPreheatImageClicked();
        }
    }
}
