package global.didi.pay.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class GlobalPayTitleView extends LinearLayout {
    private LinearLayout mCloseLayout;
    /* access modifiers changed from: private */
    public View.OnClickListener mCloseListener;
    private TextView mMsgTV;
    private TextView mTitleTV;

    public GlobalPayTitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPayTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.g_payment_title, this);
        this.mTitleTV = (TextView) findViewById(R.id.g_payment_title_top);
        this.mMsgTV = (TextView) findViewById(R.id.g_payment_title_msg);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.g_payment_title_close_layout);
        this.mCloseLayout = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPayTitleView.this.mCloseListener != null) {
                    GlobalPayTitleView.this.mCloseListener.onClick(view);
                }
            }
        });
    }

    public void setTitle(String str) {
        setTitle(str, 0);
    }

    public void setTitle(String str, int i) {
        setTitle(str, i, 0.0f);
    }

    public void setTitle(String str, int i, float f) {
        TextView textView = this.mTitleTV;
        textView.setText("" + str);
        if (i > 0) {
            this.mTitleTV.setTextColor(getContext().getResources().getColor(i));
        } else {
            this.mTitleTV.setTextColor(getContext().getResources().getColor(R.color.oc_color_333333));
        }
        if (f > 0.0f) {
            this.mTitleTV.setTextSize(f);
        }
    }

    public void setMessage(String str) {
        setMessage(str, 0);
    }

    public void setMessageColor(int i) {
        if (i != 0) {
            this.mMsgTV.setTextColor(i);
        }
    }

    public void setMessage(String str, int i) {
        setMessage(str, i, 0.0f);
    }

    public void setMessage(String str, int i, float f) {
        if (!TextUtils.isEmpty(str)) {
            this.mMsgTV.setVisibility(0);
            TextView textView = this.mMsgTV;
            textView.setText("" + str);
            if (i > 0) {
                this.mMsgTV.setTextColor(getContext().getResources().getColor(i));
            } else {
                this.mMsgTV.setTextColor(getContext().getResources().getColor(R.color.oc_color_666666));
            }
            if (f > 0.0f) {
                this.mMsgTV.setTextSize(f);
                return;
            }
            return;
        }
        this.mMsgTV.setVisibility(8);
    }

    public void setMessageClickListener(View.OnClickListener onClickListener) {
        this.mMsgTV.setOnClickListener(onClickListener);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.mCloseListener = onClickListener;
    }
}
