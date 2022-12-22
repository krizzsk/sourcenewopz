package com.global.didi.elvish.util;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"LOCALE_SEPARATOR_MIDDLE_LINE", "", "LOCALE_SEPARATOR_UNDERLINE", "locale2String", "locale", "Ljava/util/Locale;", "string2Locale", "elvish_release"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: LocaleUtils.kt */
public final class LocaleUtilsKt {
    public static final String LOCALE_SEPARATOR_MIDDLE_LINE = "-";
    public static final String LOCALE_SEPARATOR_UNDERLINE = "_";

    public static final Locale string2Locale(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        List list = null;
        if (StringsKt.contains$default(charSequence, (CharSequence) "_", false, 2, (Object) null)) {
            list = StringsKt.split$default(charSequence, new String[]{"_"}, false, 0, 6, (Object) null);
        } else if (StringsKt.contains$default(charSequence, (CharSequence) "-", false, 2, (Object) null)) {
            list = StringsKt.split$default(charSequence, new String[]{"-"}, false, 0, 6, (Object) null);
        }
        if (list == null || list.size() != 2) {
            return null;
        }
        return new Locale((String) list.get(0), (String) list.get(1));
    }

    public static final String locale2String(Locale locale) {
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }
}
