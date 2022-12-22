package com.didi.component.common.router.common;

import android.os.Bundle;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.entrega.customer.app.constant.Const;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryUnreadMsgCountHandler implements IRouterHandler {
    public void handle(final Request request, final Result result) {
        try {
            JSONObject jSONObject = new JSONObject(request.getExtra().getString("params", ""));
            IMManager.getInstance().getUnreadMessageCount(IMEngine.generateSessionId(jSONObject.optInt("product_id"), jSONObject.optLong("peer_uid")), (IMSessionUnreadCallback) new IMSessionUnreadCallback() {
                public void unReadCount(int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Const.PageParams.COUNT, i);
                        Bundle bundle = new Bundle();
                        bundle.putString("params", jSONObject.toString());
                        result.putExtras(bundle);
                        RouterHelper.release(request);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
