package com.didi.dimina.container.p106ui.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.title.CommonTitleBar */
public class CommonTitleBar extends RelativeLayout {
    protected ImageTextButton[] leftTvs;
    protected ImageView mImageLine;
    protected ImageTextButton mLeft1Bt;
    protected ImageTextButton mLeft2Bt;
    protected ImageTextButton mLeft3Bt;
    protected TextView mMiddleTv;
    protected ImageTextButton mRight1Bt;
    protected ImageTextButton mRight2Bt;
    protected ImageTextButton mRight3Bt;
    protected RelativeLayout mRlTitleContainer;
    protected ImageTextButton[] rightTvs;

    public CommonTitleBar(Context context) {
        super(context);
        m13356a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13356a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13356a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13356a();
    }

    /* renamed from: a */
    private void m13356a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_common_title_bar, this, true);
        this.mRlTitleContainer = (RelativeLayout) findViewById(R.id.title_bar_layout_above);
        this.mMiddleTv = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.mRight1Bt = (ImageTextButton) findViewById(R.id.common_title_bar_right1_tv);
        this.mRight2Bt = (ImageTextButton) findViewById(R.id.common_title_bar_right2_tv);
        this.mRight3Bt = (ImageTextButton) findViewById(R.id.common_title_bar_right3_tv);
        this.mImageLine = (ImageView) findViewById(R.id.common_title_bar_line);
        this.mLeft1Bt = (ImageTextButton) findViewById(R.id.common_title_bar_left1_tv);
        this.mLeft2Bt = (ImageTextButton) findViewById(R.id.common_title_bar_left2_tv);
        ImageTextButton imageTextButton = (ImageTextButton) findViewById(R.id.common_title_bar_left3_tv);
        this.mLeft3Bt = imageTextButton;
        this.leftTvs = new ImageTextButton[]{this.mLeft1Bt, this.mLeft2Bt, imageTextButton};
        this.rightTvs = new ImageTextButton[]{this.mRight1Bt, this.mRight2Bt, this.mRight3Bt};
    }

    public void setTitle(int i) {
        m13358a(this.mMiddleTv, i);
        m13357a(this.mMiddleTv);
    }

    public void setTitle(String str) {
        m13359a(this.mMiddleTv, str);
        m13357a(this.mMiddleTv);
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        this.mLeft1Bt.setOnClickListener(onClickListener);
    }

    public void setContainerBackgroundColor(int i) {
        this.mRlTitleContainer.setBackgroundColor(i);
    }

    public void setContainerFrontColor(int i) {
        this.mMiddleTv.setTextColor(i);
        for (ImageTextButton textView : this.leftTvs) {
            textView.getTextView().setTextColor(i);
        }
        for (ImageTextButton textView2 : this.rightTvs) {
            textView2.getTextView().setTextColor(i);
        }
    }

    public void setLeftTv(int i, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mLeft1Bt.setOnClickListener(onClickListener);
        }
        this.mLeft1Bt.setVisibility(0);
    }

    /* renamed from: a */
    private void m13358a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m13359a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m13357a(View view) {
        view.setVisibility(0);
    }
}
