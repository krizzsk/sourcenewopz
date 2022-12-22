package com.didi.soda.customer.service;

import com.didi.soda.customer.mlocale.LocaleServiceEmb;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/service/CustomerLocaleService;", "Lcom/didi/soda/customer/service/ILocaleService;", "()V", "getCurrentLocale", "Ljava/util/Locale;", "getCurrentLocaleTag", "", "getLang", "getLangTag", "getSupportList", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerLocaleService.kt */
public final class CustomerLocaleService implements ILocaleService {
    public String getLangTag() {
        String currentLangTag = LocaleServiceEmb.getInstance().getCurrentLangTag();
        return currentLangTag == null ? "en-US" : currentLangTag;
    }

    public Locale getLang() {
        return LocaleServiceEmb.getInstance().getCurrentLang();
    }

    public String getCurrentLocaleTag() {
        return LocaleServiceEmb.getInstance().getCurrentLocaleTag();
    }

    public Locale getCurrentLocale() {
        return LocaleServiceEmb.getInstance().getCurrentLocale();
    }

    public List<Locale> getSupportList() {
        List<Locale> supportLocaleList = LocaleServiceEmb.getInstance().getSupportLocaleList();
        Intrinsics.checkNotNullExpressionValue(supportLocaleList, "getInstance().supportLocaleList");
        return supportLocaleList;
    }
}
