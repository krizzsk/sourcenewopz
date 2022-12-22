package com.didi.sdk.webview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class WebTitleBar extends CommonTitleBar {

    /* renamed from: a */
    private RelativeLayout f38413a;

    /* renamed from: a */
    private void m27183a(Context context) {
    }

    public WebTitleBar(Context context) {
        super(context);
    }

    public WebTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38413a = (RelativeLayout) findViewById(R.id.title_bar_layout_above);
        this.mImageLine.setImageDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.afanty_title_bar_line_bg)));
    }

    public WebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38413a = (RelativeLayout) findViewById(R.id.title_bar_layout_above);
        this.mImageLine.setImageDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.afanty_title_bar_line_bg)));
    }

    public void setTitleName(String str) {
        this.mMiddleTv.setText(str);
    }

    public String getTitleName() {
        return this.mMiddleTv.getText().toString();
    }

    public void setTitleVisible(boolean z) {
        this.mMiddleTv.setVisibility(z ? 0 : 8);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.mLeftImg.setOnClickListener(onClickListener);
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.mLeftImg1.setOnClickListener(onClickListener);
    }

    public void setOnMoreClickListener(View.OnClickListener onClickListener) {
        this.mMoreIv.setOnClickListener(onClickListener);
    }

    public void setBackBtnVisibility(int i) {
        this.mLeftImg.setVisibility(i);
    }

    public void setCloseBtnVisibility(int i) {
        this.mLeftImg1.setVisibility(i);
    }

    public void setMoreBtnVisibility(int i) {
        this.mMoreIv.setVisibility(i);
    }

    public ImageView getRightImage() {
        return this.mMoreIv;
    }

    public Button getRightButton() {
        return (Button) this.mRightTv;
    }

    public TextView getMiddleTv() {
        return this.mMiddleTv;
    }

    public void updateTitleBar(String str, String str2, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.f38413a.setBackground(new ColorDrawable(Color.parseColor(str)));
            setTitleBarLineVisible(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mMiddleTv.setTextColor(Color.parseColor(str2));
            this.mRightTv.setTextColor(Color.parseColor(str2));
            this.mLeftTv.setTextColor(Color.parseColor(str2));
        }
        m27184a(this.mLeftImg1, i);
        m27184a(this.mLeftImg, i);
        m27184a(this.mMoreIv, i);
    }

    /* renamed from: a */
    private void m27184a(ImageView imageView, int i) {
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
            DrawableCompat.setTint(mutate, ContextCompat.getColor(getContext(), i == 0 ? 17170444 : 17170443));
            imageView.setImageDrawable(mutate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
