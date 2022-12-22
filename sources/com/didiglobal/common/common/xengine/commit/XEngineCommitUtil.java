package com.didiglobal.common.common.xengine.commit;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globalgenerickit.config.ButtonModel;
import org.json.JSONException;
import org.json.JSONObject;

public class XEngineCommitUtil {

    public interface RouterFinishedListener {
        void onRouterFinished();
    }

    public static void configRouterSkip(final Context context, ButtonModel buttonModel, String str, final RouterFinishedListener routerFinishedListener) {
        Uri parse = Uri.parse(str);
        if (parse != null && parse.getHost() != null && parse.getPath() != null) {
            if (!parse.getHost().equals("xengine") || !parse.getPath().contains("commit")) {
                DRouter.build(str).start(context);
                if (routerFinishedListener != null) {
                    routerFinishedListener.onRouterFinished();
                    return;
                }
                return;
            }
            String str2 = "";
            String str3 = (buttonModel == null || buttonModel.button_type == null) ? str2 : buttonModel.button_type;
            if (buttonModel != null) {
                str2 = buttonModel.f22052id;
            }
            ((Request) ((Request) ((Request) DRouter.build(str).putExtra("KEY_COMMIT_ID", str2)).putExtra("KEY_BUTTON_TYPE", str3)).putExtra("key_block_commit_auto_route", true)).start(context, new RouterCallback() {
                public void onResult(Result result) {
                    JSONObject optJSONObject;
                    String string = result.getString("KEY_CALLBACK");
                    if (TextUtils.isEmpty(string)) {
                        RouterFinishedListener routerFinishedListener = routerFinishedListener;
                        if (routerFinishedListener != null) {
                            routerFinishedListener.onRouterFinished();
                            return;
                        }
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            DRouter.build(optJSONObject.optString("url")).start(context);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RouterFinishedListener routerFinishedListener2 = routerFinishedListener;
                    if (routerFinishedListener2 != null) {
                        routerFinishedListener2.onRouterFinished();
                    }
                }
            });
        }
    }
}
