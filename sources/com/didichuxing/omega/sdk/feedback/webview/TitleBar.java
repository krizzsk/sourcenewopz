package com.didichuxing.omega.sdk.feedback.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class TitleBar extends RelativeLayout {
    private ImageView mLeftImg;
    private TextView mMiddleTv;

    public TitleBar(Context context) {
        super(context);
        init();
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.afanty_common_title_bar, this, true);
        this.mLeftImg = (ImageView) findViewById(R.id.afanty_common_title_bar_left_img);
        this.mMiddleTv = (TextView) findViewById(R.id.afanty_common_title_bar_middle_tv);
    }

    public void setTitle(String str) {
        setText(this.mMiddleTv, str);
        show(this.mMiddleTv);
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage(R.drawable.afanty_common_title_bar_btn_back_selector, onClickListener);
    }

    private void setLeftImage(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeftImg.setOnClickListener(onClickListener);
        }
        this.mLeftImg.setImageResource(i);
        show(this.mLeftImg);
    }

    private void setText(TextView textView, String str) {
        textView.setText(str);
    }

    private void show(View view) {
        view.setVisibility(0);
    }
}
