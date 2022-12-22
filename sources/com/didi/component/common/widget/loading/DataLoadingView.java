package com.didi.component.common.widget.loading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class DataLoadingView extends FrameLayout implements IDataLoadingView {

    /* renamed from: a */
    private ImageView f12056a;

    /* renamed from: b */
    private TextView f12057b;

    /* renamed from: c */
    private TextView f12058c;

    /* renamed from: d */
    private AnimationDrawable f12059d;

    /* renamed from: e */
    private State f12060e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnRetryListener f12061f;

    enum State {
        Loading,
        Retry,
        Fail
    }

    public View getView() {
        return this;
    }

    public DataLoadingView(Context context) {
        super(context);
        m8126a();
    }

    public DataLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8126a();
    }

    public DataLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8126a();
    }

    public void setId(int i) {
        super.setId(i);
    }

    /* renamed from: a */
    private void m8126a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_comp_view_data_loading, this);
        this.f12056a = (ImageView) findViewById(R.id.iv_loading);
        this.f12057b = (TextView) findViewById(R.id.tv_retry);
        this.f12058c = (TextView) findViewById(R.id.tv_fail);
        this.f12059d = (AnimationDrawable) this.f12056a.getDrawable();
        showLoading();
        this.f12057b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DataLoadingView.this.f12061f != null) {
                    DataLoadingView.this.f12061f.onRetry();
                }
            }
        });
    }

    public void showLoading() {
        if (this.f12060e != State.Loading) {
            this.f12056a.setVisibility(0);
            this.f12057b.setVisibility(8);
            this.f12058c.setVisibility(8);
            this.f12059d.start();
            this.f12060e = State.Loading;
        }
    }

    public void showRetry() {
        if (this.f12060e != State.Retry) {
            this.f12059d.stop();
            this.f12056a.setVisibility(8);
            this.f12057b.setVisibility(0);
            this.f12058c.setVisibility(8);
            this.f12060e = State.Retry;
        }
    }

    public void showFail(String str) {
        if (this.f12060e != State.Fail) {
            this.f12059d.stop();
            this.f12056a.setVisibility(8);
            this.f12057b.setVisibility(8);
            this.f12058c.setVisibility(0);
            this.f12060e = State.Fail;
            this.f12058c.setText(str);
        }
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.f12061f = onRetryListener;
    }
}
