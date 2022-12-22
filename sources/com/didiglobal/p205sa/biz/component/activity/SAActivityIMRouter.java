package com.didiglobal.p205sa.biz.component.activity;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.component.common.net.CarServerParam;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.SAActivityIMRouter */
public class SAActivityIMRouter implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        if (!TextUtils.isEmpty(uri.getPath()) && !"0".equals(uri.getQueryParameter("click_enable"))) {
            IMBusinessParam iMBusinessParam = new IMBusinessParam();
            String queryParameter = uri.getQueryParameter("business_id");
            String queryParameter2 = uri.getQueryParameter("city_id");
            String queryParameter3 = uri.getQueryParameter("avatar");
            String queryParameter4 = uri.getQueryParameter("name");
            String queryParameter5 = uri.getQueryParameter(CarServerParam.PARAM_DRIVER_ID);
            String queryParameter6 = uri.getQueryParameter("im_key");
            String queryParameter7 = uri.getQueryParameter("oid");
            iMBusinessParam.setSecret(queryParameter6);
            iMBusinessParam.setsOrderId(queryParameter7);
            iMBusinessParam.setBusinessId(Integer.parseInt(queryParameter));
            iMBusinessParam.setSessionId(IMEngine.generateSessionId(Integer.parseInt(queryParameter), Long.parseLong(queryParameter5)));
            iMBusinessParam.setSelfUid(Long.parseLong(NationTypeUtil.getNationComponentData().getLoginInfo().getUid()));
            iMBusinessParam.setPeerUserAvatar(queryParameter3);
            iMBusinessParam.setPeerUserName(queryParameter4);
            String userFirstName = getUserFirstName();
            if (!TextUtils.isEmpty(userFirstName)) {
                iMBusinessParam.setSelfUserName(userFirstName);
                iMBusinessParam.setSelfEngNickName(userFirstName);
            } else {
                String string = ResourcesHelper.getString(DIDIApplication.getAppContext(), R.string.global_im_default_name_prefix);
                String string2 = ResourcesHelper.getString(DIDIApplication.getAppContext(), R.string.global_im_default_name_prefix_default);
                iMBusinessParam.setSelfUserName(string);
                iMBusinessParam.setSelfEngNickName(string2);
            }
            iMBusinessParam.setCityID(queryParameter2);
            iMBusinessParam.setPeerUserName(queryParameter4);
            iMBusinessParam.setPeerUserAvatar(queryParameter3);
            String userAvatarUrl = getUserAvatarUrl(request.getContext());
            if (!TextUtils.isEmpty(userAvatarUrl)) {
                iMBusinessParam.setSelfUserAvatar(userAvatarUrl);
            }
            IMEngine.startChatDetailActivity(request.getContext(), iMBusinessParam);
        }
    }

    public static String getUserAvatarUrl(Context context) {
        UserInfo userInfo;
        if (context == null || (userInfo = UserCenterFacade.getIns().getUserInfo(context)) == null) {
            return "";
        }
        return userInfo.getHead_url();
    }

    public static String getUserFirstName() {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        return loginInfo != null ? loginInfo.getFirstname() : "";
    }
}
