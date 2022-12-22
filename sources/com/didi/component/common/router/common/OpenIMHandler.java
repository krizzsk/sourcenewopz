package com.didi.component.common.router.common;

import android.text.TextUtils;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import org.json.JSONObject;

public class OpenIMHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        try {
            JSONObject jSONObject = new JSONObject(request.getExtra().getString("params", ""));
            int optInt = jSONObject.optInt("product_id");
            long optLong = jSONObject.optLong("peer_uid");
            String optString = jSONObject.optString("city_id");
            String optString2 = jSONObject.optString("oid");
            String optString3 = jSONObject.optString("new_srt");
            String optString4 = jSONObject.optString("peer_nick");
            String optString5 = jSONObject.optString("peer_img");
            IMBusinessParam iMBusinessParam = new IMBusinessParam();
            iMBusinessParam.setSessionId(IMEngine.generateSessionId(optInt, optLong));
            iMBusinessParam.setSelfUid(NationComponentDataUtil.getUid());
            iMBusinessParam.setPeerUid(optLong);
            iMBusinessParam.setBusinessId(optInt);
            iMBusinessParam.setsOrderId(optString2);
            iMBusinessParam.setCityID(optString);
            iMBusinessParam.setSecret(optString3);
            iMBusinessParam.setPeerUserName(optString4);
            iMBusinessParam.setPeerEngNickName(optString4);
            iMBusinessParam.setPeerUserAvatar(optString5);
            String userFirstName = NationComponentDataUtil.getUserFirstName();
            if (!TextUtils.isEmpty(userFirstName)) {
                iMBusinessParam.setSelfUserName(userFirstName);
                iMBusinessParam.setSelfEngNickName(userFirstName);
            } else {
                String string = ResourcesHelper.getString(DIDIBaseApplication.getAppContext(), R.string.global_im_default_name_prefix);
                String string2 = ResourcesHelper.getString(DIDIBaseApplication.getAppContext(), R.string.global_im_default_name_prefix_default);
                iMBusinessParam.setSelfUserName(string);
                iMBusinessParam.setSelfEngNickName(string2);
            }
            String userAvatarUrl = NationComponentDataUtil.getUserAvatarUrl(DIDIBaseApplication.getAppContext());
            if (!TextUtils.isEmpty(userAvatarUrl)) {
                iMBusinessParam.setSelfUserAvatar(userAvatarUrl);
            }
            IMEngine.startChatDetailActivity(request.getContext(), iMBusinessParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
