package com.didi.global.loading.render;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.taxis99.R;

public class ProgressBarLoadingRender extends BaseLoadingRender {
    public static String kIndeterminateDrawableId = "Loading::ProgressBar::Indeterminate::Drawable::Id";

    /* renamed from: b */
    private ProgressBar f22681b;

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        this.f22681b = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.loading_progressbar, (ViewGroup) null);
        int i = bundle.getInt(kIndeterminateDrawableId);
        if (i != 0) {
            this.f22681b.setIndeterminateDrawable(context.getResources().getDrawable(i));
        }
        if (bundle.getInt("Loading::Interpolator::Id") != 0) {
            this.f22681b.setInterpolator(context, bundle.getInt("Loading::Interpolator::Id"));
        }
        this.f22681b.setBackgroundColor(bundle.getInt("Loading::Background::Color", 0));
        return this.f22681b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        this.f22681b.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f22681b.setVisibility(8);
    }

    public boolean isRunning() {
        return this.f22681b.isIndeterminate() && this.f22681b.getWindowVisibility() == 0 && this.f22681b.isShown();
    }
}
