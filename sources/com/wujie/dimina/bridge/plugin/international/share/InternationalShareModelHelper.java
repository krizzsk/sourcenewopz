package com.wujie.dimina.bridge.plugin.international.share;

import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sharesdk.OneKeyShareModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006%"}, mo175978d2 = {"Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareModelHelper;", "", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "name", "getName", "setName", "onkKeyShareModel", "Lcom/didi/sharesdk/OneKeyShareModel;", "getOnkKeyShareModel", "()Lcom/didi/sharesdk/OneKeyShareModel;", "setOnkKeyShareModel", "(Lcom/didi/sharesdk/OneKeyShareModel;)V", "phone", "getPhone", "setPhone", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "resId", "", "getResId", "()I", "setResId", "(I)V", "type", "getType", "setType", "Companion", "bridge-international-share_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: InternationalShareModelHelper.kt */
public final class InternationalShareModelHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Map<String, InternationalShareModelHelper> f56067i = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Map<String, SharePlatform> f56068j = new HashMap();

    /* renamed from: a */
    private String f56069a;

    /* renamed from: b */
    private String f56070b;

    /* renamed from: c */
    private String f56071c = "";

    /* renamed from: d */
    private int f56072d = -1;

    /* renamed from: e */
    private String f56073e = "";

    /* renamed from: f */
    private String f56074f = "";

    /* renamed from: g */
    private String f56075g;

    /* renamed from: h */
    private OneKeyShareModel f56076h;

    public final String getType() {
        return this.f56069a;
    }

    public final void setType(String str) {
        this.f56069a = str;
    }

    public final String getName() {
        return this.f56070b;
    }

    public final void setName(String str) {
        this.f56070b = str;
    }

    public final String getIcon() {
        return this.f56071c;
    }

    public final void setIcon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f56071c = str;
    }

    public final int getResId() {
        return this.f56072d;
    }

    public final void setResId(int i) {
        this.f56072d = i;
    }

    public final String getPhone() {
        return this.f56073e;
    }

    public final void setPhone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f56073e = str;
    }

    public final String getMessage() {
        return this.f56074f;
    }

    public final void setMessage(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f56074f = str;
    }

    public final String getRedirectUrl() {
        return this.f56075g;
    }

    public final void setRedirectUrl(String str) {
        this.f56075g = str;
    }

    public final OneKeyShareModel getOnkKeyShareModel() {
        return this.f56076h;
    }

    public final void setOnkKeyShareModel(OneKeyShareModel oneKeyShareModel) {
        this.f56076h = oneKeyShareModel;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareModelHelper$Companion;", "", "()V", "h5ShareMap", "", "", "Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareModelHelper;", "platformMap", "Lcom/didi/onekeyshare/entity/SharePlatform;", "addModel", "", "name", "platform", "resId", "", "contains", "", "type", "getH5ShareModel", "getPlatform", "bridge-international-share_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: InternationalShareModelHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SharePlatform getPlatform(String str) {
            return (SharePlatform) InternationalShareModelHelper.f56068j.get(str);
        }

        /* access modifiers changed from: private */
        public final void addModel(String str, String str2, int i) {
            InternationalShareModelHelper internationalShareModelHelper = new InternationalShareModelHelper();
            internationalShareModelHelper.setResId(i);
            if (str2 != null) {
                internationalShareModelHelper.setOnkKeyShareModel(new OneKeyShareModel(str2));
            }
            InternationalShareModelHelper.f56067i.put(str, internationalShareModelHelper);
        }

        public final boolean contains(String str) {
            Map access$getH5ShareMap$cp = InternationalShareModelHelper.f56067i;
            if (access$getH5ShareMap$cp != null) {
                return access$getH5ShareMap$cp.containsKey(str);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }

        public final InternationalShareModelHelper getH5ShareModel(String str) {
            OneKeyShareModel onkKeyShareModel;
            InternationalShareModelHelper internationalShareModelHelper = (InternationalShareModelHelper) InternationalShareModelHelper.f56067i.get(str);
            if (!(internationalShareModelHelper == null || (onkKeyShareModel = internationalShareModelHelper.getOnkKeyShareModel()) == null)) {
                internationalShareModelHelper.setOnkKeyShareModel(new OneKeyShareModel(onkKeyShareModel.getPlatform()));
            }
            return internationalShareModelHelper;
        }
    }

    static {
        Companion.addModel("share_sys_msg", SharePlatform.SYSTEM_MESSAGE.platformName(), SharePlatform.SYSTEM_MESSAGE.resId());
        Companion.addModel("shareSysMsg", SharePlatform.SYSTEM_MESSAGE.platformName(), SharePlatform.SYSTEM_MESSAGE.resId());
        Companion.addModel(InternalJSMethod.SHARE_FACEBOOK, SharePlatform.FACEBOOK_PLATFORM.platformName(), SharePlatform.FACEBOOK_PLATFORM.resId());
        Companion.addModel("shareFBMessenger", SharePlatform.MESSENGER_PLATFORM.platformName(), SharePlatform.MESSENGER_PLATFORM.resId());
        Companion.addModel(InternalJSMethod.SHARE_WHATSAPP, SharePlatform.WHATSAPP_PLATFORM.platformName(), SharePlatform.WHATSAPP_PLATFORM.resId());
        Companion.addModel("shareLine", SharePlatform.LINE_PLATFORM.platformName(), SharePlatform.LINE_PLATFORM.resId());
        Companion.addModel(InternalJSMethod.SHARE_TWITTER, SharePlatform.TWITTER_PLATFORM.platformName(), SharePlatform.TWITTER_PLATFORM.resId());
        Companion.addModel(InternalJSMethod.SHARE_EMAIL, SharePlatform.EMAIL_PLATFORM.platformName(), SharePlatform.EMAIL_PLATFORM.resId());
        String str = null;
        Companion.addModel("page_refresh", str, SharePlatform.REFRESH_ICON.resId());
        Companion.addModel("refreshPage", str, SharePlatform.REFRESH_ICON.resId());
        Companion.addModel(InternalJSMethod.SHARE_SAVE_PICTURE, SharePlatform.SAVEIMAGE_PLATFORM.platformName(), SharePlatform.SAVEIMAGE_PLATFORM.resId());
        f56068j.put("share_weixin_timeline", SharePlatform.WXMOMENTS_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_WEIXIN_TIMELINE, SharePlatform.WXMOMENTS_PLATFORM);
        f56068j.put("share_weixin_appmsg", SharePlatform.WXCHAT_PLATFORM);
        f56068j.put("shareWeixinKouling", SharePlatform.WXCHAT_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_WEIXIN_APPMSG, SharePlatform.WXCHAT_PLATFORM);
        f56068j.put("share_qq_appmsg", SharePlatform.QQ_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_QQ_APPMSG, SharePlatform.QQ_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_QZONE, SharePlatform.QZONE_PLATFORM);
        f56068j.put("share_qzone", SharePlatform.QZONE_PLATFORM);
        f56068j.put("share_alipay_friend", SharePlatform.ALIPAY_FRIEND_PLAFORM);
        f56068j.put(InternalJSMethod.SHARE_ALIPAY_FRIEND, SharePlatform.ALIPAY_FRIEND_PLAFORM);
        f56068j.put("share_alipay_life", SharePlatform.ALIPAY_CIRCLE_PLAFORM);
        f56068j.put(InternalJSMethod.SHARE_ALIPAY_LIFE, SharePlatform.ALIPAY_CIRCLE_PLAFORM);
        f56068j.put("share_sys_msg", SharePlatform.SYSTEM_MESSAGE);
        f56068j.put("shareSysMsg", SharePlatform.SYSTEM_MESSAGE);
        f56068j.put(InternalJSMethod.SHARE_FACEBOOK, SharePlatform.FACEBOOK_PLATFORM);
        f56068j.put("shareFBMessenger", SharePlatform.MESSENGER_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_WHATSAPP, SharePlatform.WHATSAPP_PLATFORM);
        f56068j.put("shareLine", SharePlatform.LINE_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_TWITTER, SharePlatform.TWITTER_PLATFORM);
        f56068j.put(InternalJSMethod.SHARE_EMAIL, SharePlatform.EMAIL_PLATFORM);
        f56068j.put("refreshPage", SharePlatform.REFRESH_ICON);
        f56068j.put("page_refresh", SharePlatform.REFRESH_ICON);
        f56068j.put(InternalJSMethod.SHARE_SAVE_PICTURE, SharePlatform.SAVEIMAGE_PLATFORM);
    }
}
