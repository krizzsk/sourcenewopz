package com.didi.sdk.view.titlebar;

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

public class CommonTitleBar extends RelativeLayout {
    protected ImageView mImageLine;
    protected ImageView mLeftImg;
    protected ImageView mLeftImg1;
    protected TextView mLeftTv;
    protected TextView mMiddleTv;
    protected ImageView mMoreIv;
    protected TextView mRightTv;

    /* renamed from: a */
    private boolean m27095a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public CommonTitleBar(Context context) {
        super(context);
        m27091a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27091a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27091a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m27091a();
    }

    /* renamed from: a */
    private void m27091a() {
        LayoutInflater.from(getContext()).inflate(R.layout.v_common_title_bar, this, true);
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
        int titleColor = ProductControllerStyleManager.getInstance().getProductThemeStyle().getTitleBarStyle().getTitleColor();
        if (titleColor != 0) {
            this.mMiddleTv.setTextColor(titleColor);
        }
    }

    public TextView getMiddleTv() {
        return this.mMiddleTv;
    }

    public ImageView getLeftImgView() {
        return this.mLeftImg;
    }

    public TextView getRightTextView() {
        return this.mRightTv;
    }

    public void setTitle(int i) {
        m27093a(this.mMiddleTv, i);
        m27092a((View) this.mMiddleTv);
    }

    public void setTitle(String str) {
        m27094a(this.mMiddleTv, str);
        m27092a((View) this.mMiddleTv);
    }

    public void setRightText(int i) {
        m27093a(this.mRightTv, i);
        m27092a((View) this.mRightTv);
    }

    public void setRightText(String str) {
        m27094a(this.mRightTv, str);
        m27092a((View) this.mRightTv);
    }

    public void setRightText(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mRightTv.setOnClickListener(onClickListener);
        }
        m27093a(this.mRightTv, i);
        m27092a((View) this.mRightTv);
    }

    public void setRightText(String str, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mRightTv.setOnClickListener(onClickListener);
        }
        m27094a(this.mRightTv, str);
        m27092a((View) this.mRightTv);
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, onClickListener);
    }

    public void setLeftImage(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeftImg.setOnClickListener(onClickListener);
        }
        this.mLeftImg.setImageResource(i);
        m27092a((View) this.mLeftImg);
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
        m27092a((View) this.mLeftImg);
    }

    public void setLeftVisible(int i) {
        if (m27095a(i)) {
            this.mLeftImg.setVisibility(i);
        }
    }

    public void setTitleLineVisible(int i) {
        if (m27095a(i)) {
            this.mMiddleTv.setVisibility(i);
        }
    }

    public void setRightVisible(int i) {
        if (m27095a(i)) {
            this.mRightTv.setVisibility(i);
        }
    }

    public void setTitleBarLineVisible(int i) {
        if (m27095a(i)) {
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
    private void m27093a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m27094a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m27092a(View view) {
        view.setVisibility(0);
    }
}
