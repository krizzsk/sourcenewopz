package com.didiglobal.component.scan;

import android.graphics.Color;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.taxis99.R;
import kotlin.Metadata;

@ServiceProvider({IViewStyleDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/component/scan/ViewStyleDelegate;", "Lcom/didiglobal/scan/delegate/IViewStyleDelegate;", "()V", "getScanImg", "", "getTurnOnImg", "getUploadButtonBgColor", "comp-scan_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewStyleDelegate.kt */
public final class ViewStyleDelegate implements IViewStyleDelegate {
    public int getScanImg() {
        return AppUtils.isGlobalApp(ActivityLifecycleManager.getInstance().getCurrentActivity()) ? R.drawable.icon_scan_global : R.drawable.icon_scan_brazil;
    }

    public int getTurnOnImg() {
        return AppUtils.isGlobalApp(ActivityLifecycleManager.getInstance().getCurrentActivity()) ? R.drawable.icon_turn_on_global : R.drawable.icon_turn_on_brazil;
    }

    public int getUploadButtonBgColor() {
        if (AppUtils.isGlobalApp(ActivityLifecycleManager.getInstance().getCurrentActivity())) {
            return Color.parseColor("#FF8040");
        }
        return Color.parseColor("#FFC040");
    }
}
