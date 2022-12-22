package com.didi.sdk.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

public class GlobalTitleBar extends RelativeLayout {
    protected View mContentView;
    protected ImageView mImageLine;
    protected ImageView mLeftImg;
    protected ImageView mLeftImg1;
    protected TextView mLeftTv;
    protected TextView mMiddleTv;
    protected ImageView mMoreIv;
    protected TextView mRightTv;

    /* renamed from: a */
    private boolean m26792a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public GlobalTitleBar(Context context) {
        super(context);
        m26788a();
    }

    public GlobalTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26788a();
    }

    public GlobalTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26788a();
    }

    public GlobalTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m26788a();
    }

    /* renamed from: a */
    private void m26788a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_titlebar, this, true);
        this.mContentView = findViewById(R.id.main_id);
        this.mLeftImg = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.mLeftImg1 = (ImageView) findViewById(R.id.common_title_bar_left_img1);
        this.mMiddleTv = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.mRightTv = (TextView) findViewById(R.id.common_title_bar_right_tv);
        this.mMoreIv = (ImageView) findViewById(R.id.img_web_title_more);
        this.mImageLine = (ImageView) findViewById(R.id.common_title_bar_line);
        this.mLeftTv = (TextView) findViewById(R.id.common_title_bar_left_tv);
        int commonTitleBarTextSelecter = ProductControllerStyleManager.getInstance().getProductThemeStyle().getTitleBarStyle().getCommonTitleBarTextSelecter();
        if (commonTitleBarTextSelecter != 0) {
            ColorStateList colorStateList = getResources().getColorStateList(commonTitleBarTextSelecter);
            this.mLeftTv.setTextColor(colorStateList);
            this.mRightTv.setTextColor(colorStateList);
        }
    }

    public ImageView getLeftImgView() {
        return this.mLeftImg;
    }

    public TextView getRightTextView() {
        return this.mRightTv;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setTitle(int i) {
        m26790a(this.mMiddleTv, i);
        m26789a((View) this.mMiddleTv);
    }

    public void setTitle(String str) {
        m26791a(this.mMiddleTv, str);
        m26789a((View) this.mMiddleTv);
    }

    public void setRightText(int i) {
        m26790a(this.mRightTv, i);
        m26789a((View) this.mRightTv);
    }

    public void setRightText(String str) {
        m26791a(this.mRightTv, str);
        m26789a((View) this.mRightTv);
    }

    public void setRightText(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mRightTv.setOnClickListener(onClickListener);
        }
        m26790a(this.mRightTv, i);
        m26789a((View) this.mRightTv);
    }

    public void setRightText(String str, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mRightTv.setOnClickListener(onClickListener);
        }
        m26791a(this.mRightTv, str);
        m26789a((View) this.mRightTv);
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, onClickListener);
    }

    public void setLeftImage(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeftImg.setOnClickListener(onClickListener);
        }
        this.mLeftImg.setImageResource(i);
        m26789a((View) this.mLeftImg);
    }

    public void setLeftTv(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeftTv.setOnClickListener(onClickListener);
        }
        this.mLeftTv.setVisibility(0);
        this.mLeftImg.setVisibility(8);
    }

    public void setLeftImage(Drawable drawable, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeftImg.setOnClickListener(onClickListener);
        }
        if (drawable != null) {
            this.mLeftImg.setImageDrawable(drawable);
        }
        m26789a((View) this.mLeftImg);
    }

    public void setLeftVisible(int i) {
        if (m26792a(i)) {
            this.mLeftImg.setVisibility(i);
        }
    }

    public void setTitleLineVisible(int i) {
        if (m26792a(i)) {
            this.mMiddleTv.setVisibility(i);
        }
    }

    public void setRightVisible(int i) {
        if (m26792a(i)) {
            this.mRightTv.setVisibility(i);
        }
    }

    public void setTitleBarLineVisible(int i) {
        if (m26792a(i)) {
            this.mImageLine.setVisibility(i);
        }
    }

    public void setRightTextColor(int i) {
        this.mRightTv.setTextColor(i);
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        this.mRightTv.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m26790a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m26791a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m26789a(View view) {
        view.setVisibility(0);
    }
}
