package com.didi.component.homepop.request;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.xengine.commit.XEngineCommitUtil;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.dialog.LEGODialogFragmentManager;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import java.util.Map;

public class HomeGGKConfigRequest implements HomePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(final Context context, String str) {
        if (context instanceof FragmentActivity) {
            GGKConfigManager.requestConfig((FragmentActivity) context, (Map<String, Object>) null, ComponentConfigManager.BUSINESS_SCENE_HOME, str, "passenger_newPopup", new GGKConfigCallbackAdapter() {
                public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
                    XEngineCommitUtil.configRouterSkip(context, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                        public void onRouterFinished() {
                            LEGODialogFragmentManager.getInstance().dismissAllGGKDialog();
                        }
                    });
                    return true;
                }

                public boolean sheetClickLis(final LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                    XEngineCommitUtil.configRouterSkip(context, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                        public void onRouterFinished() {
                            lEGODrawer.dismiss();
                        }
                    });
                    return true;
                }
            });
        }
    }
}
