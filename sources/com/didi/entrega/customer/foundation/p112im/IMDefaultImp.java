package com.didi.entrega.customer.foundation.p112im;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.access.utils.ConfigLoadListener;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.manager.IMBusinessManager;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.NumberParseUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.StringUtils;
import com.didi.entrega.customer.immap.IMMapHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.customer.service.IOneSdkService;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.didi.entrega.customer.foundation.im.IMDefaultImp */
public class IMDefaultImp implements IIMInterface {

    /* renamed from: a */
    private static final String f19903a = "|";

    /* renamed from: b */
    private static String f19904b;

    /* renamed from: c */
    private static String f19905c;

    public void setMerchantCommonWords(Context context) {
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
    }

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        IMBusinessParam iMBusinessParam = new IMBusinessParam();
        iMBusinessParam.setSessionId(getSessionId(str, str6));
        iMBusinessParam.setsOrderId(str5);
        iMBusinessParam.setSelfUid(NumberParseUtil.parseLong(LoginUtil.getUid()));
        iMBusinessParam.setPeerUid(NumberParseUtil.parseLong(str));
        iMBusinessParam.setBusinessId(601);
        iMBusinessParam.setSecret(str2);
        UserInfoEntity userInfo = ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).getUserInfo();
        iMBusinessParam.setSelfUserName(m14733a(context, userInfo, str6));
        iMBusinessParam.setSelfUserAvatar(userInfo != null ? userInfo.headUrl : "");
        iMBusinessParam.setPeerUserName(m14734a(context, str3));
        iMBusinessParam.setPeerUserAvatar(str4);
        iMBusinessParam.setSceneKey(str6 + "|" + ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag() + "|" + i);
        IMEngine.startChatDetailActivity(context, iMBusinessParam);
    }

    public void startChatActivity(Context context) {
        IMEngine.startChatListActivity(context, 5);
    }

    public void closeSession(String str, String str2) {
        IMManager.getInstance().closeSession(getSessionId(str, str2));
    }

    public long getSessionId(String str, String str2) {
        return IMBusinessManager.generateSid(601, NumberParseUtil.parseLong(str));
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
        IMEngine.getInstance(GlobalContext.getContext()).addMessageListener(new IMMessageListener(str, str2, iMSessionUnreadCallback) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ IMSessionUnreadCallback f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onMessageArrive() {
                IMDefaultImp.this.m14739a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m14739a(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
    }

    public void setRiderCommonWords(Context context) {
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig();
        iMBusinessConfig.setNeedSceneCommonWord(true);
        iMBusinessConfig.setLocationTopScheme("taxis99OneTravel://sodaEntrega");
        iMBusinessConfig.setConfigListener(new ConfigLoadListener() {
            public ArrayList<String> onQuickMessageLoaded(String str) {
                return IMDefaultImp.this.m14736a(str);
            }

            public List<IMActionItem> getMoreAction(String str) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IMActionItem(ResourceHelper.getString(R.string.FoodC_IM_Location_REco), R.drawable.rider_im_map_tab_icon) {
                    public void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
                        IMMapHelper.startSendIMMap();
                    }
                });
                return arrayList;
            }
        });
        IMEngine.registerBusinessConfig(context, 601, iMBusinessConfig);
    }

    public boolean shouldUseImMessage(String str) {
        return CustomerApolloUtil.isImEnterAvild() && !TextUtils.isEmpty(str);
    }

    /* renamed from: a */
    private String m14733a(Context context, UserInfoEntity userInfoEntity, String str) {
        if (userInfoEntity == null || (TextUtils.isEmpty(userInfoEntity.firstName) && TextUtils.isEmpty(userInfoEntity.lastName))) {
            return context.getResources().getString(R.string.FoodC_IM2_Customer_XcCD);
        }
        if ("rider".equals(str)) {
            return userInfoEntity.firstName + " " + userInfoEntity.lastName;
        } else if (!"merchant".equals(str) || TextUtils.isEmpty(userInfoEntity.lastName)) {
            return context.getResources().getString(R.string.FoodC_IM2_Customer_XcCD);
        } else {
            return userInfoEntity.lastName;
        }
    }

    /* renamed from: a */
    private String m14734a(Context context, String str) {
        return TextUtils.isEmpty(str) ? context.getResources().getString(R.string.FoodC_IM2_Courier_fMUf) : str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<String> m14736a(String str) {
        String str2;
        String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
        if (!StringUtils.isEmpty(str)) {
            String[] split = str.split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
            str2 = split[0];
            if (split.length > 1) {
                langTag = split[1];
            }
        } else {
            str2 = "rider";
        }
        Map a = m14738a(str2, langTag);
        if (a != null) {
            return m14737a(a);
        }
        return null;
    }

    /* renamed from: a */
    private Map m14738a(String str, String str2) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(f19904b)) {
            f19904b = CustomerApolloUtil.getIMQuickMessages();
        }
        if (TextUtils.isEmpty(f19904b)) {
            return null;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(f19904b).optJSONObject(str);
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(str2)) == null) {
                return null;
            }
            return (Map) GsonUtil.fromJson(optJSONObject.toString(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private ArrayList<String> m14737a(Map map) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        if (map != null) {
            for (Map.Entry value : map.entrySet()) {
                hashSet.addAll((List) value.getValue());
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }
}
