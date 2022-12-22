package com.didiglobal.pay.paysecure.omega;

import android.text.TextUtils;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.PaySecureNetParamListener;
import com.didiglobal.pay.paysecure.base.FragmentMessenger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u001e\u0010\n\u001a\u00020\u00002\u0016\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fJ4\u0010\r\u001a\u00020\u000e2*\u0010\u000b\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/omega/OmegaUtil;", "", "eventId", "", "(Ljava/lang/String;)V", "params", "", "add", "key", "obg", "addAll", "map", "", "appendCommonAttrs", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "send", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: OmegaUtil.kt */
public final class OmegaUtil {
    public static final String APP_ID = "appid";
    public static final String COUNTRY = "country";
    public static final String COUNTRY_CODE = "country_code";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EMAIL_STATUS = "status";
    public static final String ERROR_TYPE = "error_type";
    public static final String PAGE = "page";
    public static final String SCENE = "Scene";
    public static final String SOCIAL = "social";
    public static final String TEL = "tel";
    public static final String UID = "uid";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Map<String, Object> f50324c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static FragmentMessenger f50325d;

    /* renamed from: a */
    private final Map<String, Object> f50326a;

    /* renamed from: b */
    private final String f50327b;

    public OmegaUtil(String str) {
        this.f50327b = str;
        Map<String, Object> hashMap = new HashMap<>();
        this.f50326a = hashMap;
        m36244a((HashMap) hashMap);
    }

    public final void send() {
        OmegaSDKAdapter.trackEvent(this.f50327b, this.f50326a);
    }

    public final OmegaUtil add(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f50326a.put(str, obj);
        }
        return this;
    }

    public final OmegaUtil addAll(Map<String, ? extends Object> map) {
        if (map != null) {
            this.f50326a.putAll(map);
        }
        return this;
    }

    /* renamed from: a */
    private final void m36244a(HashMap<String, Object> hashMap) {
        Map<String, Object> map = f50324c;
        if (map != null) {
            if (map == null) {
                Intrinsics.throwNpe();
            }
            hashMap.putAll(map);
        }
        Map map2 = hashMap;
        FragmentMessenger messenger = Companion.getMessenger();
        map2.put(OmegaUtilKt.ENTRANCE_PAGE_ID, messenger != null ? messenger.getScene() : null);
        map2.put("terminal_id", PaySecure.INSTANCE.getConfig().getTerminalId());
        map2.put("app_id", PaySecure.INSTANCE.getConfig().getAppId());
        map2.put("pub_target", "");
        map2.put("pub_page", CashierAction.ACTION_PASSWORD);
        map2.put("pub_biz", "fintech");
        PaySecureNetParamListener netParamListener = PaySecure.INSTANCE.getConfig().getNetParamListener();
        if (netParamListener.getOmegaParams() != null) {
            Map<String, Object> omegaParams = netParamListener.getOmegaParams();
            if (omegaParams == null) {
                omegaParams = MapsKt.emptyMap();
            }
            hashMap.putAll(omegaParams);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001b\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/omega/OmegaUtil$Companion;", "", "()V", "APP_ID", "", "COUNTRY", "COUNTRY_CODE", "EMAIL_STATUS", "ERROR_TYPE", "PAGE", "SCENE", "SOCIAL", "TEL", "UID", "messenger", "Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;", "omegaMap", "", "getOmegaMap", "()Ljava/util/Map;", "setOmegaMap", "(Ljava/util/Map;)V", "addOmegaMap", "", "map", "", "getMessenger", "setMessenger", "trackEvent", "eventId", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: OmegaUtil.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Object> getOmegaMap() {
            return OmegaUtil.f50324c;
        }

        public final void setOmegaMap(Map<String, Object> map) {
            OmegaUtil.f50324c = map;
        }

        public final void addOmegaMap(Map<String, ? extends Object> map) {
            Companion companion = this;
            if (companion.getOmegaMap() == null) {
                companion.setOmegaMap(new HashMap());
            }
            Map<String, Object> omegaMap = companion.getOmegaMap();
            if (omegaMap == null) {
                Intrinsics.throwNpe();
            }
            if (map == null) {
                Intrinsics.throwNpe();
            }
            omegaMap.putAll(map);
        }

        public final FragmentMessenger getMessenger() {
            return OmegaUtil.f50325d;
        }

        public final void setMessenger(FragmentMessenger fragmentMessenger) {
            OmegaUtil.f50325d = fragmentMessenger;
        }

        public final void trackEvent(String str) {
            new OmegaUtil(str).send();
        }
    }
}
