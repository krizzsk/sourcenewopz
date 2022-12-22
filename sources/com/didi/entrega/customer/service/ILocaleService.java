package com.didi.entrega.customer.service;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/customer/service/ILocaleService;", "Lcom/didi/entrega/customer/service/IService;", "getCurrentLocale", "Ljava/util/Locale;", "getCurrentLocaleTag", "", "getLang", "getLangTag", "getSupportList", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ILocaleService.kt */
public interface ILocaleService extends IService {
    Locale getCurrentLocale();

    String getCurrentLocaleTag();

    Locale getLang();

    String getLangTag();

    List<Locale> getSupportList();
}
