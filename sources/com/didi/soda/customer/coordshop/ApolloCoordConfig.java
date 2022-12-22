package com.didi.soda.customer.coordshop;

import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/ApolloCoordConfig;", "", "()V", "maxVisible", "", "getMaxVisible", "()I", "setMaxVisible", "(I)V", "minVisibleDishJson", "Lorg/json/JSONObject;", "getMinVisibleDishJson", "()Lorg/json/JSONObject;", "setMinVisibleDishJson", "(Lorg/json/JSONObject;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ApolloCoordConfig.kt */
public final class ApolloCoordConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static ApolloCoordConfig f40821c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f40822d;

    /* renamed from: a */
    private JSONObject f40823a;

    /* renamed from: b */
    private int f40824b;

    public final JSONObject getMinVisibleDishJson() {
        return this.f40823a;
    }

    public final void setMinVisibleDishJson(JSONObject jSONObject) {
        this.f40823a = jSONObject;
    }

    public final int getMaxVisible() {
        return this.f40824b;
    }

    public final void setMaxVisible(int i) {
        this.f40824b = i;
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/ApolloCoordConfig$Companion;", "", "()V", "config", "Lcom/didi/soda/customer/coordshop/ApolloCoordConfig;", "isInit", "", "create", "minVisibleDish", "", "maxVisible", "", "getMaxVisible", "getMinVisibleDish", "initConfig", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ApolloCoordConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApolloCoordConfig create(String str, int i) {
            CharSequence charSequence = str;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0) && (!Intrinsics.areEqual((Object) charSequence, (Object) "null"))) {
                z = true;
            }
            if (!z || i == 0) {
                return null;
            }
            try {
                ApolloCoordConfig apolloCoordConfig = new ApolloCoordConfig();
                apolloCoordConfig.setMinVisibleDishJson(new JSONObject(str));
                apolloCoordConfig.setMaxVisible(i);
                return apolloCoordConfig;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final void initConfig() {
            if (!ApolloCoordConfig.f40822d) {
                ApolloCoordConfig.f40822d = true;
                ApolloCoordConfig.f40821c = CustomerApolloUtil.getCoordShopConfig();
            }
        }

        public final int getMinVisibleDish() {
            ApolloCoordConfig access$getConfig$cp;
            JSONObject minVisibleDishJson;
            initConfig();
            String poiCountryCode = LocationUtil.getPoiCountryCode();
            if (poiCountryCode == null || (access$getConfig$cp = ApolloCoordConfig.f40821c) == null || (minVisibleDishJson = access$getConfig$cp.getMinVisibleDishJson()) == null) {
                return Integer.MAX_VALUE;
            }
            return minVisibleDishJson.optInt(poiCountryCode);
        }

        public final int getMaxVisible() {
            initConfig();
            ApolloCoordConfig access$getConfig$cp = ApolloCoordConfig.f40821c;
            if (access$getConfig$cp == null) {
                return 0;
            }
            return access$getConfig$cp.getMaxVisible();
        }
    }
}
