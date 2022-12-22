package com.didi.soda.customer.foundation.p164im;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.access.core.IMSessionMessageListener;
import com.didi.beatles.p099im.access.utils.ConfigLoadListener;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.manager.IMBusinessManager;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NumberParseUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.immap.IMMapHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.service.IOneSdkService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.foundation.im.IMDefaultImp */
public class IMDefaultImp implements IIMInterface {

    /* renamed from: a */
    private static final String f40909a = "|";

    /* renamed from: b */
    private static String f40910b;

    /* renamed from: c */
    private static String f40911c;

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        IMBusinessParam iMBusinessParam = new IMBusinessParam();
        iMBusinessParam.setSessionId(getSessionId(str, str6));
        iMBusinessParam.setsOrderId(str5);
        iMBusinessParam.setSelfUid(NumberParseUtil.parseLong(LoginUtil.getUid()));
        iMBusinessParam.setPeerUid(NumberParseUtil.parseLong(str));
        if ("merchant".equals(str6)) {
            iMBusinessParam.setBusinessId(600);
        } else {
            iMBusinessParam.setBusinessId(601);
        }
        iMBusinessParam.setSecret(str2);
        UserInfoEntity userInfo = ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).getUserInfo();
        iMBusinessParam.setSelfUserName(m29068a(context, userInfo, str6));
        iMBusinessParam.setSelfUserAvatar(userInfo != null ? userInfo.headUrl : "");
        iMBusinessParam.setPeerUserName(m29069a(context, str3));
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
        if ("rider".equals(str2)) {
            return IMBusinessManager.generateSid(601, NumberParseUtil.parseLong(str));
        }
        return IMEngine.generateSessionId(600, NumberParseUtil.parseLong(str), true);
    }

    public void setRiderMessageUnreadCountListener(final String str, final String str2, final IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
        IMEngine.getInstance(GlobalContext.getContext()).addMessageListener(new IMMessageListener() {
            public void onMessageArrive() {
                IMEngine.getUnreadMessageCount(IMDefaultImp.this.getSessionId(str, str2), iMSessionUnreadCallback);
            }
        });
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
    }

    public void setMerchantMessageUnreadCountListener(final String str, final String str2, final IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMEngine.getUnreadMessageCount(getSessionId(str, str2), iMSessionUnreadCallback);
        IMEngine.getInstance(GlobalContext.getContext()).addMessageListener(new IMMessageListener() {
            public void onMessageArrive() {
                IMEngine.getUnreadMessageCount(IMDefaultImp.this.getSessionId(str, str2), iMSessionUnreadCallback);
            }
        });
    }

    public void setRiderCommonWords(Context context) {
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig();
        iMBusinessConfig.setNeedSceneCommonWord(true);
        iMBusinessConfig.setLocationTopScheme("taxis99OneTravel://soda");
        iMBusinessConfig.setConfigListener(new ConfigLoadListener() {
            public ArrayList<String> onQuickMessageLoaded(String str) {
                return IMDefaultImp.this.m29071a(str);
            }

            public List<IMActionItem> getMoreAction(String str) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IMActionItem(ResourceHelper.getString(R.string.FoodC_IM_Location_REco), R.drawable.rider_im_map_tab_icon) {
                    public void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
                        IMMapHelper.startSendIMMap(iMBusinessParam, iMSession);
                    }
                });
                return arrayList;
            }
        });
        IMEngine.registerBusinessConfig(context, 601, iMBusinessConfig);
    }

    public void setMerchantCommonWords(Context context) {
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig();
        iMBusinessConfig.setUseAudioMessage(m29076a());
        if (CustomerApolloUtil.isConfigMerchantComment()) {
            iMBusinessConfig.setNeedSceneCommonWord(true);
            iMBusinessConfig.setShowUsefulExpression(true);
            iMBusinessConfig.setConfigListener(new ConfigLoadListener() {
                public ArrayList<String> onQuickMessageLoaded(String str) {
                    return IMDefaultImp.this.m29071a(str);
                }
            });
        } else {
            iMBusinessConfig.setShowUsefulExpression(false);
        }
        IMEngine.registerBusinessConfig(context, 600, iMBusinessConfig);
    }

    public boolean shouldUseImMessage(String str) {
        return CustomerApolloUtil.isImEnterAvild() && !TextUtils.isEmpty(str);
    }

    public void addUserCenterMessageListener() {
        IMEngine.addSessionMessageListener(new IMSessionMessageListener() {
            public final void onSessionMessageArrive(Set set) {
                IMDefaultImp.this.m29075a(set);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29075a(Set set) {
        fetchUnReadNum();
    }

    public void fetchUnReadNum() {
        IMEngine.getAllUnreadRedCount($$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0.INSTANCE);
        IMEngine.getAllUnreadMessageCount($$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk.INSTANCE);
    }

    /* renamed from: a */
    private String m29068a(Context context, UserInfoEntity userInfoEntity, String str) {
        if (userInfoEntity == null || (TextUtils.isEmpty(userInfoEntity.firstName) && TextUtils.isEmpty(userInfoEntity.lastName))) {
            return context.getResources().getString(R.string.customer_im_message_defalut_name);
        }
        if ("rider".equals(str)) {
            return userInfoEntity.firstName + " " + userInfoEntity.lastName;
        } else if (!"merchant".equals(str) || TextUtils.isEmpty(userInfoEntity.lastName)) {
            return context.getResources().getString(R.string.customer_im_message_defalut_name);
        } else {
            return userInfoEntity.lastName;
        }
    }

    /* renamed from: a */
    private String m29069a(Context context, String str) {
        return TextUtils.isEmpty(str) ? context.getResources().getString(R.string.customer_im_message_defalut_peer_name) : str;
    }

    /* renamed from: a */
    private boolean m29076a() {
        if (TextUtils.isEmpty(f40911c)) {
            f40911c = CustomerApolloUtil.getAudioInputEnableIMMessage();
        }
        if (TextUtils.isEmpty(f40911c)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(f40911c);
            String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
            if (!TextUtils.isEmpty(langTag) && jSONObject.optInt(langTag) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<String> m29071a(String str) {
        if (TextUtils.isEmpty(str)) {
            String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
            Map a = m29073a("rider", langTag, (String) null);
            Map a2 = m29073a("merchant", langTag, (String) null);
            HashMap hashMap = new HashMap();
            if (a != null) {
                hashMap.putAll(a);
            }
            if (a2 != null) {
                hashMap.putAll(a2);
            }
            return m29072a((Map) hashMap);
        }
        String[] split = str.split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        String str2 = split[0];
        String str3 = split.length > 1 ? split[1] : null;
        String str4 = split.length > 2 ? split[2] : null;
        Map a3 = m29073a(str2, str3, str4);
        if (a3 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str4)) {
            return m29072a(a3);
        }
        return (ArrayList) a3.get(str4);
    }

    /* renamed from: a */
    private Map m29073a(String str, String str2, String str3) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(f40910b)) {
            f40910b = CustomerApolloUtil.getIMQuickMessages();
        }
        if (TextUtils.isEmpty(f40910b)) {
            return null;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(f40910b).optJSONObject(str);
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
    private ArrayList<String> m29072a(Map map) {
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
