package com.didi.beatles.p099im.access.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomResBuilder;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewBuilder;
import com.didi.beatles.p099im.access.utils.ConfigLoadListener;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.views.custom.IMCustomCardViewBaseProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.utils.IMBusinessConfig */
public class IMBusinessConfig {
    public static final int COMMON_WORD_TYPE_DEFAULT = 1;
    public static final int COMMON_WORD_TYPE_DRIVER = 2;

    /* renamed from: d */
    private static final String f8852d = "IMBusinessConfig";

    /* renamed from: A */
    private String f8853A;

    /* renamed from: B */
    private String f8854B;

    /* renamed from: C */
    private IMCustomViewBuilder f8855C;

    /* renamed from: D */
    private IMCustomResBuilder f8856D;

    /* renamed from: E */
    private IMStyleManager.Style f8857E = IMStyleManager.Style.UNDEFINED;

    /* renamed from: F */
    private List<Integer> f8858F = new ArrayList<Integer>(5) {
        {
            add(3);
            add(7);
        }
    };

    /* renamed from: a */
    ConfigLoadListener f8859a;

    /* renamed from: b */
    List<String> f8860b = new ArrayList();

    /* renamed from: c */
    String f8861c;
    @ConfigField(tag = 0)

    /* renamed from: e */
    private boolean f8862e = true;
    @ConfigField(tag = 1)

    /* renamed from: f */
    private boolean f8863f = false;
    @ConfigField(tag = 2)
    @Deprecated

    /* renamed from: g */
    private boolean f8864g = false;
    @ConfigField(tag = 3)

    /* renamed from: h */
    private boolean f8865h = false;
    @ConfigField(tag = 4)

    /* renamed from: i */
    private boolean f8866i = false;
    @ConfigField(tag = 5)

    /* renamed from: j */
    private boolean f8867j = true;
    @ConfigField(tag = 6)

    /* renamed from: k */
    private boolean f8868k = true;
    @ConfigField(tag = 7)

    /* renamed from: l */
    private boolean f8869l = true;
    @ConfigField(tag = 8)

    /* renamed from: m */
    private boolean f8870m = true;
    @ConfigField(tag = 9)

    /* renamed from: n */
    private boolean f8871n = true;
    @ConfigField(tag = 10)

    /* renamed from: o */
    private boolean f8872o = true;
    @ConfigField(tag = 11)

    /* renamed from: p */
    private boolean f8873p = true;

    /* renamed from: q */
    private boolean f8874q = true;

    /* renamed from: r */
    private int f8875r = 16;

    /* renamed from: s */
    private boolean f8876s = false;

    /* renamed from: t */
    private boolean f8877t = false;

    /* renamed from: u */
    private Map<String, Integer> f8878u = new HashMap();

    /* renamed from: v */
    private int f8879v = 1;

    /* renamed from: w */
    private boolean f8880w = false;

    /* renamed from: x */
    private String f8881x;

    /* renamed from: y */
    private String f8882y;

    /* renamed from: z */
    private boolean f8883z = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.access.utils.IMBusinessConfig$TypeCommonWord */
    public @interface TypeCommonWord {
    }

    public IMBusinessConfig() {
    }

    public void injectCommonUseMsgs(List<String> list) {
        this.f8860b = list;
    }

    public IMBusinessConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f8862e = z;
        this.f8863f = z2;
        this.f8864g = z3;
        this.f8865h = z4;
        this.f8866i = z5;
        this.f8867j = z6;
        this.f8868k = z7;
        this.f8869l = z8;
        this.f8870m = z9;
        this.f8871n = z10;
        this.f8872o = z11;
        this.f8873p = z12;
    }

    public IMBusinessConfig(int i) {
        try {
            this.f8862e = (i & 1) > 0;
            this.f8863f = (i & 2) > 0;
            this.f8864g = (i & 4) > 0;
            this.f8865h = (i & 8) > 0;
            this.f8866i = (i & 16) > 0;
            this.f8867j = (i & 32) > 0;
            this.f8868k = (i & 64) > 0;
            this.f8869l = (i & 128) > 0;
            this.f8870m = (i & 256) > 0;
            this.f8871n = (i & 512) > 0;
            this.f8872o = (i & 1024) > 0;
            this.f8873p = (i & 2048) > 0;
        } catch (Exception e) {
            IMLog.m6632e("", "MBusinessConfig initError", e);
        }
    }

    public String getBottomBarClass() {
        return this.f8882y;
    }

    public void setBottomBarClass(String str) {
        IMLog.m6631d("IMEngine", "设置的类 " + str);
        this.f8882y = str;
    }

    public boolean isNeedSceneCommonWord() {
        return this.f8880w;
    }

    public void setNeedSceneCommonWord(boolean z) {
        this.f8880w = z;
    }

    public int getCommonWordType() {
        return this.f8879v;
    }

    public void setCommonWordType(int i) {
        this.f8879v = i;
    }

    public String getIllegalTextOnPicture() {
        return this.f8881x;
    }

    public void setIllegalTextOnPicture(String str) {
        this.f8881x = str;
    }

    public boolean isNeedMsgString() {
        return this.f8883z;
    }

    public void setNeedMsgString(boolean z) {
        this.f8883z = z;
    }

    public void setOpenGlobalAlert(boolean z) {
        this.f8872o = z;
    }

    public void setTitleShowNickName(boolean z) {
        this.f8862e = z;
    }

    public void setShowProfile(boolean z) {
        this.f8863f = z;
    }

    public void setAvatarCanClick(boolean z) {
        this.f8864g = z;
    }

    public void setShowEmoji(boolean z) {
        this.f8865h = z;
    }

    public void setShowExtendIcon(boolean z) {
        this.f8866i = z;
    }

    public void setShowUsefulExpression(boolean z) {
        this.f8867j = z;
    }

    public void setDefaultOpenUsefulExpression(boolean z) {
        this.f8868k = z;
    }

    public void setClientCreateSession(boolean z) {
        this.f8869l = z;
    }

    public void setOpenInnerNotification(boolean z) {
        this.f8870m = z;
    }

    public void setOpenOuterNotification(boolean z) {
        this.f8871n = z;
    }

    public boolean isTitleShowNickName() {
        return this.f8862e;
    }

    public boolean isShowProfile() {
        return this.f8863f;
    }

    public boolean isAvatarCanClick() {
        return this.f8864g;
    }

    public boolean isShowEmoji() {
        return this.f8865h;
    }

    public boolean isShowExtendIcon() {
        return this.f8866i;
    }

    public boolean isShowUsefulExpression() {
        return this.f8867j;
    }

    public boolean isDefaultOpenUsefulExpression() {
        return this.f8868k;
    }

    public boolean isClientCreateSession() {
        return this.f8869l;
    }

    public boolean isOpenInnerNotification() {
        return this.f8870m;
    }

    public boolean isOpenOuterNotification() {
        return this.f8871n;
    }

    public boolean isOpenGlobalAlert() {
        return this.f8872o;
    }

    public boolean isShowPeerAvatar() {
        return this.f8873p;
    }

    public void setShowPeerAvatar(boolean z) {
        this.f8873p = z;
    }

    public boolean isUseAudioMessage() {
        return this.f8874q;
    }

    public void setUseAudioMessage(boolean z) {
        this.f8874q = z;
    }

    public int getTextSize() {
        return this.f8875r;
    }

    public IMBusinessConfig setTextSize(int i) {
        this.f8875r = i;
        return this;
    }

    public IMBusinessConfig setIsUber(boolean z) {
        this.f8876s = z;
        return this;
    }

    public boolean isUber() {
        return this.f8876s;
    }

    public IMBusinessConfig setIsFloatShowQuickButton(boolean z) {
        this.f8877t = z;
        return this;
    }

    public boolean isFloatShowQuickButton() {
        return this.f8877t;
    }

    @Deprecated
    public IMBusinessConfig registerDrawable(String str, int i) {
        Map<String, Integer> map = this.f8878u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendDrawableResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f8878u;
        if (map == null || map.isEmpty() || (num = this.f8878u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public IMBusinessConfig registerImResource(Map<String, Integer> map) {
        if (map != null && map.size() > 0) {
            this.f8878u.putAll(map);
        }
        return this;
    }

    @Deprecated
    public IMBusinessConfig registerColor(String str, int i) {
        Map<String, Integer> map = this.f8878u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendColorResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f8878u;
        if (map == null || map.isEmpty() || (num = this.f8878u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public IMBusinessConfig registerImResource(String str, int i) {
        Map<String, Integer> map = this.f8878u;
        if (map != null) {
            map.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public int getExtendResource(String str) {
        Integer num;
        Map<String, Integer> map = this.f8878u;
        if (map == null || map.isEmpty() || (num = this.f8878u.get(str)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public Map<String, Integer> getResourceMap() {
        return this.f8878u;
    }

    public void setConfigListener(ConfigLoadListener configLoadListener) {
        this.f8859a = configLoadListener;
    }

    public ArrayList<String> getQuickMessages(String str, int i) {
        ArrayList<String> onQuickMessageLoaded;
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener == null || (onQuickMessageLoaded = configLoadListener.onQuickMessageLoaded(str)) == null || onQuickMessageLoaded.isEmpty()) {
            return IMContextInfoHelper.getQuickReplyList(i);
        }
        return onQuickMessageLoaded;
    }

    @Deprecated
    public boolean showBottomExtendView(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            return configLoadListener.dispatchShowBottomExtendView(context, iMSession, iMBusinessParam);
        }
        return false;
    }

    public ConfigLoadListener.IMGuideAction showBottomGuideView(Context context, IMSession iMSession, String str, Map<String, View> map) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            return configLoadListener.showBottomBarGuide(context, iMSession, str, map);
        }
        return null;
    }

    public boolean interceptMessageUrl(Context context, IMSession iMSession, String str) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            return configLoadListener.onGoLinkUrl(context, iMSession, str);
        }
        return false;
    }

    public void getIMEmojiList(String str, int i, ConfigLoadListener.IMGetEmojiListCallback iMGetEmojiListCallback) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            configLoadListener.getEmojiList(str, iMGetEmojiListCallback);
        }
    }

    public List<IMActionItem> getIMMoreAction(String str) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            return configLoadListener.getMoreAction(str);
        }
        return null;
    }

    @Deprecated
    public void onClickPhone(Context context, String str) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            configLoadListener.onClickPhone(context, str);
        }
    }

    public void onChatTitleRightIconClick(Activity activity, View view) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            configLoadListener.onChatTitleRightIconClick(activity, view);
        }
    }

    public void onMoreButtonShow(IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            configLoadListener.onMoreButtonShow(iMSession, iMBusinessParam);
        }
    }

    public void onBottomBarExpandViewShow(int i, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        ConfigLoadListener configLoadListener = this.f8859a;
        if (configLoadListener != null) {
            configLoadListener.onBottomBarExpandViewShow(i, iMSession, iMBusinessParam);
        }
    }

    public void registCradViewProvider(String str) {
        this.f8861c = str;
    }

    public void registerPlugin(Integer num) {
        if (this.f8858F == null) {
            this.f8858F = new ArrayList();
        }
        this.f8858F.add(num);
    }

    public void registerPlugin(List<Integer> list) {
        if (this.f8858F == null) {
            this.f8858F = new ArrayList();
        }
        this.f8858F.addAll(list);
    }

    public List<Integer> getPluginList() {
        return this.f8858F;
    }

    public String getSchemeHost() {
        return this.f8853A;
    }

    public void setSchemeHost(String str) {
        this.f8853A = str;
    }

    public IMCustomCardViewBaseProvider getCardViewProvider() {
        if (!TextUtils.isEmpty(this.f8861c)) {
            try {
                return (IMCustomCardViewBaseProvider) Class.forName(this.f8861c).newInstance();
            } catch (Exception e) {
                IMLog.m6632e("im_register_card", "reflect fail with the name is" + this.f8861c);
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setIMStyle(IMStyleManager.Style style) {
        this.f8857E = style;
    }

    public IMStyleManager.Style getIMStyle() {
        return this.f8857E;
    }

    public void setCustomViewBuilder(IMCustomViewBuilder iMCustomViewBuilder) {
        this.f8855C = iMCustomViewBuilder;
    }

    public IMCustomViewBuilder getCustomBuilder() {
        return this.f8855C;
    }

    public void setCustomResBuilder(IMCustomResBuilder iMCustomResBuilder) {
        this.f8856D = iMCustomResBuilder;
    }

    public IMCustomResBuilder getCustomResBuilder() {
        return this.f8856D;
    }

    public void setLocationTopScheme(String str) {
        this.f8854B = str;
    }

    public String getLocationTopScheme() {
        return this.f8854B;
    }

    public String toString() {
        return "IMBusinessConfig{titleShowNickName=" + this.f8862e + ", showProfile=" + this.f8863f + ", avatarCanClick=" + this.f8864g + ", showEmoji=" + this.f8865h + ", showExtendIcon=" + this.f8866i + ", showUsefulExpression=" + this.f8867j + ", defaultOpenUsefulExpression=" + this.f8868k + ", clientCreateSession=" + this.f8869l + ", openInnerNotification=" + this.f8870m + ", openOuterNotification=" + this.f8871n + ", openGlobalAlert=" + this.f8872o + ", showPeerAvatar=" + this.f8873p + ", textSize=" + this.f8875r + ", isUber=" + this.f8876s + ", isFolatShowQuickButton=" + this.f8877t + ", mCradViewProviderName='" + this.f8861c + '\'' + ", bottombarclass= " + this.f8882y + ", schemeHost = " + this.f8853A + ", style = " + this.f8857E + '}';
    }
}
