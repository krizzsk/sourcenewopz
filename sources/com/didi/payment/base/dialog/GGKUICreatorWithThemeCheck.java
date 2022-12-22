package com.didi.payment.base.dialog;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.dialog.GGKBaseDialogModel;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel;

public class GGKUICreatorWithThemeCheck {
    public static GGKDrawer showDrawerModel(Activity activity, GGKBaseDrawerModel gGKBaseDrawerModel) {
        if (activity == null) {
            return null;
        }
        if (DidiThemeManager.getIns().getCurrentTheme(activity) == -1) {
            DidiThemeManager.getIns().init(activity.getApplication());
        }
        return GGKUICreator.showDrawerModel(activity, gGKBaseDrawerModel);
    }

    public static GGKDialogFragment showDialogModel(FragmentActivity fragmentActivity, GGKBaseDialogModel gGKBaseDialogModel, String str) {
        if (fragmentActivity == null) {
            return null;
        }
        if (DidiThemeManager.getIns().getCurrentTheme(fragmentActivity) == -1) {
            DidiThemeManager.getIns().init(fragmentActivity.getApplication());
        }
        if (fragmentActivity.getSupportFragmentManager() == null) {
            return null;
        }
        return GGKUICreator.showDialogModel(fragmentActivity.getSupportFragmentManager(), gGKBaseDialogModel, str);
    }
}
