package com.didi.soda.web.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.taxis99.R;

public class WebPageTitleBar extends RelativeLayout {
    protected ImageView mImageLine;
    protected ImageView mLeftImg;
    protected ImageView mLeftImg1;
    protected TextView mLeftTv;
    protected TextView mMiddleTv;
    protected ImageView mMoreIv;
    protected TextView mRightTv;

    public WebPageTitleBar(Context context) {
        super(context);
        m31269a();
    }

    public WebPageTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31269a();
    }

    public WebPageTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31269a();
    }

    public WebPageTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m31269a();
    }

    /* renamed from: a */
    private void m31269a() {
        LayoutInflater.from(getContext()).inflate(R.layout.nova_web_page_title_bar, this, true);
        this.mLeftImg = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.mLeftImg1 = (ImageView) findViewById(R.id.common_title_bar_left_img1);
        this.mMiddleTv = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.mRightTv = (TextView) findViewById(R.id.common_title_bar_right_tv);
        this.mMoreIv = (ImageView) findViewById(R.id.img_web_title_more);
        this.mImageLine = (ImageView) findViewById(R.id.common_title_bar_line);
        this.mLeftTv = (TextView) findViewById(R.id.common_title_bar_left_tv);
    }

    public void setTitleName(String str) {
        this.mMiddleTv.setText(str);
    }

    public void setTitle(int i) {
        m31272a(this.mMiddleTv, i);
        m31270a(this.mMiddleTv);
    }

    public void setTitle(String str) {
        m31273a(this.mMiddleTv, str);
        m31270a(this.mMiddleTv);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.mLeftImg.setOnClickListener(onClickListener);
    }

    public void setBackBtnVisibility(int i) {
        this.mLeftImg.setVisibility(i);
    }

    public void setOnMoreClickListener(View.OnClickListener onClickListener) {
        this.mMoreIv.setOnClickListener(onClickListener);
    }

    public void setMoreBtnVisibility(int i) {
        this.mMoreIv.setVisibility(i);
    }

    public void setCloseBtnListener(View.OnClickListener onClickListener) {
        this.mLeftImg1.setOnClickListener(onClickListener);
    }

    public void setCloseBtnVisibility(int i) {
        this.mLeftImg1.setVisibility(i);
    }

    /* renamed from: a */
    private void m31272a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m31273a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m31270a(View view) {
        view.setVisibility(0);
    }

    public void setTitleBarTextColor(int i) {
        this.mMiddleTv.setTextColor(i);
    }

    public void setTitleBarBgColor(int i) {
        findViewById(R.id.title_bar_layout_above).setBackgroundColor(i);
    }

    public void setBackImageColor(int i) {
        m31271a(this.mLeftImg, i);
        m31271a(this.mLeftImg1, i);
    }

    public void setMoreImageColor(int i) {
        m31271a(this.mMoreIv, i);
    }

    /* renamed from: a */
    private void m31271a(ImageView imageView, int i) {
        Drawable drawable;
        try {
            Drawable drawable2 = imageView.getDrawable();
            Drawable.ConstantState constantState = drawable2.getConstantState();
            if (constantState == null) {
                drawable = drawable2;
            } else {
                drawable = constantState.newDrawable();
            }
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            mutate.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            DrawableCompat.setTint(mutate, i);
            imageView.setImageDrawable(mutate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
