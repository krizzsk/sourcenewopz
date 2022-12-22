package com.didi.dimina.container.p106ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.dimina.container.util.PixUtil;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.dialog.LoadingView */
public class LoadingView extends FrameLayout {

    /* renamed from: a */
    private TextView f17570a;

    /* renamed from: b */
    private ProgressBar f17571b;

    public LoadingView(Context context) {
        super(context);
        m13085a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13085a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13085a();
    }

    /* renamed from: a */
    private void m13085a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_loading_view, this);
        this.f17570a = (TextView) findViewById(R.id.tv_msg);
        this.f17571b = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public void setMessage(String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17571b.getLayoutParams();
        if (TextUtils.isEmpty(str)) {
            this.f17570a.setVisibility(8);
            layoutParams.topMargin = PixUtil.dip2px(getContext(), 0.0f);
            return;
        }
        layoutParams.topMargin = PixUtil.dip2px(getContext(), 22.0f);
        this.f17570a.setVisibility(0);
        this.f17570a.setText(str);
    }
}
