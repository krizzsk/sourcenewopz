package com.didi.sdk.push.fcm;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.global.DidiGlobalPayApiImpl;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public class FcmMessageProcesser {
    private Logger logger = LoggerFactory.getLogger("fcmlink");

    @IntentFilter(linkType = "2", messageType = {"onetravel://one/bindcard"})
    public void bindPayCard(String str, Activity activity) {
        this.logger.debug("bindPayCard", new Object[0]);
        DidiGlobalPayApiImpl didiGlobalPayApiImpl = new DidiGlobalPayApiImpl();
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
        payMethodListParam.skipAction = activity.getResources().getString(R.string.app_mainactivity_action);
        payMethodListParam.nextAction = activity.getResources().getString(R.string.app_mainactivity_action);
        didiGlobalPayApiImpl.startPayMethodListActivity(activity, 1, payMethodListParam);
    }

    @IntentFilter(linkType = "1", messageType = {""})
    public void openWebActivity(String str, Activity activity) {
        JSONObject linkContent = getLinkContent(str);
        if (linkContent != null) {
            String optString = linkContent.optString("url");
            if (!TextUtil.isEmpty(optString)) {
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.url = optString;
                Intent intent = new Intent(activity, WebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                intent.addFlags(335544320);
                activity.startActivity(intent);
            }
        }
    }

    private JSONObject getLinkContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optJSONObject(Constact.KEY_LINK_CONTENT);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
