package com.didi.soda.web;

import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.web.model.ShareToolModel;
import java.util.List;
import org.json.JSONObject;

public interface UpdateUIHandlerImp extends UpdateUIHandler {
    void finishPage();

    void hideEntrance();

    void invokeEntrance(List<ShareToolModel> list, CallbackFunction callbackFunction);

    void launchScan(CallbackFunction callbackFunction);

    void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction);

    void showEntrance(CallbackFunction callbackFunction, String str);

    void showSystemEntrance(ShareToolModel shareToolModel, CallbackFunction callbackFunction);

    void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction);
}
