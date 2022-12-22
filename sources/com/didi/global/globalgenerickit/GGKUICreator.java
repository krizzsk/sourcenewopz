package com.didi.global.globalgenerickit;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.didi.global.globalgenerickit.dialog.GGKBaseDialogModel;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.utils.OmegaUtils;

public class GGKUICreator {
    public static GGKDrawer showDrawerModel(Context context, GGKBaseDrawerModel gGKBaseDrawerModel) {
        GGKDrawer gGKDrawer = new GGKDrawer(context, gGKBaseDrawerModel.convert());
        gGKDrawer.show();
        if (!TextUtils.isEmpty(gGKBaseDrawerModel.getTrackId())) {
            OmegaUtils.configShowTrack(gGKBaseDrawerModel.getTrackId(), Const.DRAWER);
        }
        return gGKDrawer;
    }

    public static GGKDialogFragment showDialogModel(FragmentManager fragmentManager, GGKBaseDialogModel gGKBaseDialogModel, String str) {
        GGKDialogFragment newInstance = GGKDialogFragment.newInstance(gGKBaseDialogModel);
        newInstance.show(fragmentManager, str);
        newInstance.setCancelable(false);
        return newInstance;
    }
}
