package global.didi.pay.newview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class NewGlobalPayTitleView extends LinearLayout {
    private LinearLayout mCloseLayout;
    /* access modifiers changed from: private */
    public View.OnClickListener mCloseListener;
    private TextView mMsgTV;
    private LinearLayout mPixCloseLayout;
    /* access modifiers changed from: private */
    public View.OnClickListener mPixCloseListener;
    private TextView mTitleTV;

    public NewGlobalPayTitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPayTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_title, this);
        this.mTitleTV = (TextView) findViewById(R.id.g_payment_title_top);
        this.mMsgTV = (TextView) findViewById(R.id.g_payment_title_msg);
        this.mCloseLayout = (LinearLayout) findViewById(R.id.g_payment_title_close_layout);
        this.mPixCloseLayout = (LinearLayout) findViewById(R.id.g_payment_title_pix_close_layout);
        this.mCloseLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPayTitleView.this.mCloseListener != null) {
                    NewGlobalPayTitleView.this.mCloseListener.onClick(view);
                }
            }
        });
        this.mPixCloseLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPayTitleView.this.mPixCloseListener != null) {
                    NewGlobalPayTitleView.this.mPixCloseListener.onClick(view);
                }
            }
        });
    }

    public void showClosePixButton() {
        this.mPixCloseLayout.setVisibility(0);
    }

    public void hideClosePixButton() {
        this.mPixCloseLayout.setVisibility(8);
    }

    public void showCloseButton() {
        this.mCloseLayout.setVisibility(0);
    }

    public void hideCloseButton() {
        this.mCloseLayout.setVisibility(8);
    }

    public void setTitle(String str) {
        setTitle(str, 0);
    }

    public void setTitle(String str, boolean z) {
        setTitle(str, 0, z);
    }

    public void setTitle(String str, int i) {
        setTitle(str, i, 0.0f);
    }

    public void setTitle(String str, int i, boolean z) {
        setTitle(str, i, 0.0f, z);
    }

    public void setTitle(String str, int i, float f) {
        setTitle(str, i, f, false);
    }

    public void setTitle(String str, int i, float f, boolean z) {
        if (z && this.mTitleTV.getMaxLines() == 1) {
            this.mTitleTV.setMaxLines(2);
        } else if (!z && this.mTitleTV.getMaxLines() == 2) {
            this.mTitleTV.setMaxLines(1);
        }
        TextView textView = this.mTitleTV;
        textView.setText("" + str);
        this.mTitleTV.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        this.mTitleTV.setTextColor(getColor(i));
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
            this.mMsgTV.setTextColor(getColor(i));
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

    public void setPixCloseListener(View.OnClickListener onClickListener) {
        this.mPixCloseListener = onClickListener;
    }

    private int getColor(int i) {
        if (i > 0) {
            return getContext().getResources().getColor(i);
        }
        return getContext().getResources().getColor(R.color.black);
    }
}
