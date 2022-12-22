package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001c\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u001a\u001e\u0010\u000b\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006\u001a\u0016\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002\u001a.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0014H\u0002\u001a,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H\u0002\u001a \u0010\u0016\u001a\u00020\u00012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H\u0002\u001aD\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00062\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0014H\u0002\u001aD\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00062\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000*.\u0010\u001d\"\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u00132\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0013¨\u0006\u001e"}, mo175978d2 = {"CAMPAIGN_DIVIDER", "", "KEY_IS_FIRST_LAUNCHER", "PART_DIVIDER", "TAG", "codeUrlMap", "", "appFlyersDataTrack", "", "map", "", "appFlyersLaunch", "delayDispatch", "dispatchAction", "Lkotlin/Function0;", "doDispatch", "value", "Lcom/didi/soda/customer/biz/popdialog/CampaignValue;", "track", "Lkotlin/Function2;", "Lcom/didi/soda/customer/biz/popdialog/TrackCallback;", "filterExtraParams", "getCampaign", "parserCampaign", "", "campaign", "extraParams", "parserFoodUrl", "foodUrl", "TrackCallback", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyersLauncher.kt */
public final class AppsFlyersLauncherKt {

    /* renamed from: a */
    private static final String f40463a = "is_first_launch";

    /* renamed from: b */
    private static final String f40464b = "afLauncher";

    /* renamed from: c */
    private static final String f40465c = "__";

    /* renamed from: d */
    private static final String f40466d = "--";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Map<String, String> f40467e = MapsKt.mapOf(TuplesKt.m42317to("coupon_-_m", "sidebar/coupon"));

    public static final void appFlyersDataTrack(Map<String, ? extends Object> map) {
        String json;
        String str = "";
        if (!(map == null || (json = GsonUtil.toJson(map)) == null)) {
            str = json;
        }
        if (map != null) {
            Object obj = map.get(f40463a);
        }
        OmegaTracker.Builder.create(EventConst.AppFlyers.GET_DATA).addEventParam("campaign", m28686b(map)).addEventParam("conversion", str).build().track();
    }

    public static final void appFlyersLaunch(Map<String, ? extends Object> map) {
        boolean z;
        String str;
        String obj;
        if (map != null) {
            Object obj2 = map.get(f40463a);
            boolean z2 = false;
            if (obj2 == null) {
                z = false;
            } else {
                z = Boolean.parseBoolean(obj2.toString());
            }
            if (z) {
                LogUtil.m29100d(f40464b, "it is first launch app");
                Function2 appsFlyersLauncherKt$appFlyersLaunch$trackClosure$1 = new AppsFlyersLauncherKt$appFlyersLaunch$trackClosure$1(map);
                Object obj3 = map.get(Const.CampaignKey.KEY_CAMPAIGN_URL);
                String str2 = "";
                if (obj3 == null) {
                    obj3 = str2;
                }
                if (obj3.toString().length() > 0) {
                    m28683a(obj3.toString(), m28681a(map), (Function2<? super String, ? super String, Unit>) appsFlyersLauncherKt$appFlyersLaunch$trackClosure$1);
                    return;
                }
                Map<String, String> a = m28681a(map);
                Object obj4 = map.get("campaign");
                String str3 = null;
                if (obj4 == null) {
                    str = null;
                } else {
                    str = obj4.toString();
                }
                if (!m28687b(str, a, appsFlyersLauncherKt$appFlyersLaunch$trackClosure$1)) {
                    Object obj5 = map.get(Const.CampaignKey.KEY_AD_GROUP_ID);
                    String obj6 = obj5 == null ? null : obj5.toString();
                    CharSequence charSequence = obj6;
                    if (charSequence == null || charSequence.length() == 0) {
                        Object obj7 = map.get(Const.CampaignKey.KEY_AD_SET_ID);
                        if (obj7 != null) {
                            str3 = obj7.toString();
                        }
                        obj6 = str3;
                    }
                    CharSequence charSequence2 = obj6;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        Object obj8 = map.get(Const.CampaignKey.KEY_MEDIA_SOURCE);
                        if (!(obj8 == null || (obj = obj8.toString()) == null)) {
                            str2 = obj;
                        }
                        AFGroupIdManager.Companion.tryParseAdGroup(obj6, str2, map, appsFlyersLauncherKt$appFlyersLaunch$trackClosure$1);
                        return;
                    }
                    return;
                }
                return;
            }
            LogUtil.m29100d(f40464b, "it not first launch");
        }
    }

    /* renamed from: a */
    private static final Map<String, String> m28681a(Map<String, ? extends Object> map) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (StringsKt.startsWith$default(str, "af_", false, 2, (Object) null) || value == null || Intrinsics.areEqual((Object) Const.CampaignKey.KEY_CAMPAIGN_URL, (Object) str)) {
                    LogUtil.m29100d(f40464b, "不需要AF的参数");
                } else {
                    String encode = Uri.encode(value.toString());
                    Intrinsics.checkNotNullExpressionValue(encode, "encode(value.toString())");
                    linkedHashMap.put(str, encode);
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    private static final String m28686b(Map<String, ? extends Object> map) {
        Object obj;
        Object obj2;
        Object obj3 = "";
        if (map == null || (obj = map.get(Const.CampaignKey.KEY_CAMPAIGN_URL)) == null) {
            obj = obj3;
        }
        if (obj.toString().length() == 0) {
            if (!(map == null || (obj2 = map.get("campaign")) == null)) {
                obj3 = obj2;
            }
            obj = obj3;
        }
        return obj.toString();
    }

    /* renamed from: a */
    private static final void m28683a(String str, Map<String, String> map, Function2<? super String, ? super String, Unit> function2) {
        String decode = Uri.decode(str);
        if (decode == null) {
            decode = "";
        }
        Uri.Builder buildUpon = Uri.parse(decode).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        m28684a((Function0<Unit>) new AppsFlyersLauncherKt$parserFoodUrl$2(buildUpon, function2));
    }

    /* renamed from: b */
    private static final boolean m28687b(String str, Map<String, String> map, Function2<? super String, ? super String, Unit> function2) {
        String str2 = str;
        LogUtil.m29100d(f40464b, Intrinsics.stringPlus("parserCampaign === ", str2));
        if (str2 == null) {
            return false;
        }
        CharSequence charSequence = str2;
        if (charSequence.length() == 0) {
            return false;
        }
        List split$default = StringsKt.split$default(charSequence, new String[]{f40465c}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            List split$default2 = StringsKt.split$default((CharSequence) (String) split$default.get(1), new String[]{f40466d}, false, 0, 6, (Object) null);
            CampaignValue campaignValue = new CampaignValue();
            int size = split$default2.size();
            int i = 0;
            while (i < size) {
                String str3 = (String) split$default2.get(i);
                if (i == 0) {
                    campaignValue.mo102088a(str3);
                } else if (i != 1) {
                    int i2 = i + 1;
                    if (i2 < size) {
                        campaignValue.mo102089a(str3, (String) split$default2.get(i2));
                    } else {
                        LogUtil.m29100d(f40464b, "parserCampaign 参数解析出错。");
                    }
                    i += 2;
                } else {
                    campaignValue.mo102092b(str3);
                }
                i++;
            }
            for (Map.Entry next : map.entrySet()) {
                campaignValue.mo102089a((String) next.getKey(), (String) next.getValue());
            }
            if (!campaignValue.mo102100i()) {
                return false;
            }
            campaignValue.mo102094c(str2);
            m28682a(campaignValue, function2);
            return true;
        }
        LogUtil.m29100d(f40464b, Intrinsics.stringPlus("格式不符合规范 temp.size = ", Integer.valueOf(split$default.size())));
        return false;
    }

    /* renamed from: a */
    private static final void m28682a(CampaignValue campaignValue, Function2<? super String, ? super String, Unit> function2) {
        m28684a((Function0<Unit>) new AppsFlyersLauncherKt$doDispatch$dispatch$1(campaignValue, function2));
    }

    /* renamed from: a */
    private static final void m28684a(Function0<Unit> function0) {
        if (LocationUtil.hasValidPoi()) {
            function0.invoke();
        } else {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressOnce(new Action2() {
                public final void call(Object obj, Subscription subscription) {
                    AppsFlyersLauncherKt.m28685a(Function0.this, (AddressEntity) obj, subscription);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28685a(Function0 function0, AddressEntity addressEntity, Subscription subscription) {
        Intrinsics.checkNotNullParameter(function0, "$dispatchAction");
        function0.invoke();
    }
}
