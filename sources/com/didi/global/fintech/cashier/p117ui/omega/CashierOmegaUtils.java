package com.didi.global.fintech.cashier.p117ui.omega;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\n\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/omega/CashierOmegaUtils;", "", "eventId", "", "(Ljava/lang/String;)V", "params", "", "addParam", "key", "value", "addParamAll", "map", "", "send", "", "setCommonAttr", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils */
/* compiled from: CashierOmegaUtils.kt */
public final class CashierOmegaUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f21752c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f21753d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f21754e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f21755f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static String f21756g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static String f21757h;

    /* renamed from: a */
    private final String f21758a;

    /* renamed from: b */
    private final Map<String, Object> f21759b;

    public CashierOmegaUtils(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        this.f21758a = str;
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        this.f21759b = linkedHashMap;
        m15819a(linkedHashMap);
    }

    /* renamed from: a */
    private final void m15819a(Map<String, Object> map) {
        map.put("product_id", f21752c);
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put(LogBase.KEY_UID, f21753d);
        map.put("pub_page", f21756g);
        map.put("pub_from_page", f21757h);
        map.put("order_id", f21754e);
        map.put("out_trade_id", f21755f);
        map.put("pub_subbiz", "payment");
    }

    public final void send() {
        OmegaSDKAdapter.trackEvent(this.f21758a, this.f21759b);
    }

    public final CashierOmegaUtils addParam(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f21759b.put(str, obj);
        return this;
    }

    public final CashierOmegaUtils addParamAll(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f21759b.putAll(map);
        return this;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/omega/CashierOmegaUtils$Companion;", "", "()V", "oid", "", "getOid", "()Ljava/lang/String;", "setOid", "(Ljava/lang/String;)V", "outTradeId", "getOutTradeId", "setOutTradeId", "value", "productId", "getProductId", "setProductId", "pubFromPage", "getPubFromPage", "setPubFromPage", "pubPage", "getPubPage", "setPubPage", "uid", "getUid", "setUid", "trackEvent", "", "eventId", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion */
    /* compiled from: CashierOmegaUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getProductId() {
            return CashierOmegaUtils.f21752c;
        }

        public final void setProductId(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = "-1";
            }
            CashierOmegaUtils.f21752c = str;
        }

        public final String getUid() {
            return CashierOmegaUtils.f21753d;
        }

        public final void setUid(String str) {
            CashierOmegaUtils.f21753d = str;
        }

        public final String getOid() {
            return CashierOmegaUtils.f21754e;
        }

        public final void setOid(String str) {
            CashierOmegaUtils.f21754e = str;
        }

        public final String getOutTradeId() {
            return CashierOmegaUtils.f21755f;
        }

        public final void setOutTradeId(String str) {
            CashierOmegaUtils.f21755f = str;
        }

        public final String getPubPage() {
            return CashierOmegaUtils.f21756g;
        }

        public final void setPubPage(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = PubPageType.CHECKOUT.getType();
            }
            CashierOmegaUtils.f21756g = str;
        }

        public final String getPubFromPage() {
            return CashierOmegaUtils.f21757h;
        }

        public final void setPubFromPage(String str) {
            CashierOmegaUtils.f21757h = str;
        }

        public final void trackEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            new CashierOmegaUtils(str).send();
        }
    }
}
