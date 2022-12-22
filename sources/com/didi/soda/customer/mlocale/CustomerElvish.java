package com.didi.soda.customer.mlocale;

import android.content.Context;
import com.didi.soda.customer.mlocale.base.BaseDataLoader;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/mlocale/CustomerElvish;", "", "()V", "getLanguageAndLocale", "Lcom/didi/soda/customer/mlocale/LanguageModel;", "context", "Landroid/content/Context;", "locale", "Ljava/util/Locale;", "isGlobal", "", "init", "", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerElvish.kt */
public final class CustomerElvish {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Map<String, Object> f41377a = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static CustomerElvish f41378b = new CustomerElvish();

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/mlocale/CustomerElvish$Companion;", "", "()V", "INSTANCE", "Lcom/didi/soda/customer/mlocale/CustomerElvish;", "localCustomRuleConf", "", "", "getLocalCustomRuleConf", "()Ljava/util/Map;", "setLocalCustomRuleConf", "(Ljava/util/Map;)V", "getInstance", "init", "", "context", "Landroid/content/Context;", "locale", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerElvish.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getLocalCustomRuleConf() {
            return CustomerElvish.f41377a;
        }

        public final void setLocalCustomRuleConf(Map<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            CustomerElvish.f41377a = map;
        }

        public final void init(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "locale");
            CustomerElvish.f41378b.init(context, str);
        }

        public final CustomerElvish getInstance() {
            return CustomerElvish.f41378b;
        }
    }

    private CustomerElvish() {
    }

    public final void init(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "locale");
        if (str.length() == 0) {
            throw new Exception("Locale is empty!");
        } else if (f41377a.isEmpty()) {
            f41377a = new BaseDataLoader().localCustomRuleConfData(context);
        }
    }

    public final LanguageModel getLanguageAndLocale(Context context, Locale locale, boolean z) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (context == null) {
            return new LanguageModel("en-US", "en_US");
        }
        return new BaseDataLoader().loadLanguageConfig(context, locale, z);
    }
}
