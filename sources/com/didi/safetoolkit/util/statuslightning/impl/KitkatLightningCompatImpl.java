package com.didi.safetoolkit.util.statuslightning.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.statuslightning.ILightningCompat;
import com.taxis99.R;

public class KitkatLightningCompatImpl implements ILightningCompat {
    public void setLightStatusBar(Activity activity, boolean z) {
        Resources resources;
        int i;
        if (z) {
            resources = activity.getResources();
            i = R.color.sf_white;
        } else {
            resources = activity.getResources();
            i = R.color.sf_black;
        }
        int color = resources.getColor(i);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i2 = childCount - 1;
            if (viewGroup.getChildAt(i2) instanceof StatusBarView) {
                viewGroup.getChildAt(i2).setBackgroundColor(color);
                ViewGroup viewGroup2 = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
                ViewCompat.setFitsSystemWindows(viewGroup2, true);
                viewGroup2.setClipToPadding(true);
            }
        }
        viewGroup.addView(m24421a(activity, color));
        ViewGroup viewGroup22 = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        ViewCompat.setFitsSystemWindows(viewGroup22, true);
        viewGroup22.setClipToPadding(true);
    }

    /* renamed from: a */
    private int m24420a(Activity activity) {
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : -1;
        SfLog.m24402d("sf_status_bar", "getStatusBarHeight  = " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    /* renamed from: a */
    private StatusBarView m24421a(Activity activity, int i) {
        StatusBarView statusBarView = new StatusBarView(activity);
        statusBarView.setLayoutParams(new LinearLayout.LayoutParams(-1, m24420a(activity)));
        statusBarView.setBackgroundColor(i);
        return statusBarView;
    }

    private class StatusBarView extends View {
        public StatusBarView(Context context) {
            super(context);
        }

        public StatusBarView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public StatusBarView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
