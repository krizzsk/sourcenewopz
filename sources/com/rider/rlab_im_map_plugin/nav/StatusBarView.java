package com.rider.rlab_im_map_plugin.nav;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;

public class StatusBarView extends RelativeLayout {

    /* renamed from: a */
    private static final String f55954a = "status_bar_height";

    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StatusBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public static int getImmersiveStatusBarHeight(Context context) {
        int identifier;
        if (Build.VERSION.SDK_INT < 21 || ((StatusBarLightingCompat.getImpl() != null && (StatusBarLightingCompat.getImpl() instanceof NoneLightningCompatImpl)) || (identifier = context.getResources().getIdentifier(f55954a, "dimen", "android")) <= 0)) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getImmersiveStatusBarHeight(getContext()), 1073741824));
    }
}
