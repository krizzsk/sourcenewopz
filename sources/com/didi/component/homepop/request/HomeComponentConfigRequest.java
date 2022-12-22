package com.didi.component.homepop.request;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import java.util.Map;

public class HomeComponentConfigRequest implements HomePopupRequest {
    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(Context context, String str) {
        ComponentConfigManager.showCompoentConfigDialog((FragmentActivity) context, (Map<String, Object>) null, ComponentConfigManager.BUSINESS_SCENE_HOME, str, (ComponentConfigManager.CusEventListener) null);
    }
}
