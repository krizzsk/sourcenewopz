package com.didi.soda.customer.widget.loading.render;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.taxis99.R;

public class ProgressBarLoadingRender extends BaseLoadingRender {
    public static String sIndeterminateDrawableId = "Loading::ProgressBar::Indeterminate::Drawable::Id";

    /* renamed from: b */
    private ProgressBar f42118b;

    public boolean isRunning() {
        return this.f42118b.isIndeterminate() && this.f42118b.getWindowVisibility() == 0 && this.f42118b.isShown();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        this.f42118b = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.loading_progressbar, (ViewGroup) null);
        int i = bundle.getInt(sIndeterminateDrawableId);
        if (i != 0) {
            this.f42118b.setIndeterminateDrawable(context.getResources().getDrawable(i));
        }
        if (bundle.getInt("Loading::Interpolator::Id") != 0) {
            this.f42118b.setInterpolator(context, bundle.getInt("Loading::Interpolator::Id"));
        }
        this.f42118b.setBackgroundColor(bundle.getInt("Loading::Background::Color", 0));
        return this.f42118b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        this.f42118b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f42118b.setVisibility(8);
    }
}
