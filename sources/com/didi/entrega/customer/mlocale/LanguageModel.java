package com.didi.entrega.customer.mlocale;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.sdk.util.GlobalCountryCode;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/customer/mlocale/LanguageModel;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "lang", "", "locale", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "getLocale", "setLocale", "getSettingLocale", "Ljava/util/Locale;", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageModel.kt */
public final class LanguageModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1915050680870720011L;
    private String lang = "";
    private String locale = "";

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/mlocale/LanguageModel$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LanguageModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final void setLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locale = str;
    }

    public LanguageModel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "lang");
        Intrinsics.checkNotNullParameter(str2, "locale");
        this.lang = str;
        this.locale = str2;
    }

    public String toString() {
        return "[lang:" + this.lang + ",locale:" + this.locale + VersionRange.RIGHT_CLOSED;
    }

    public final Locale getSettingLocale() {
        List split$default = StringsKt.split$default((CharSequence) this.lang, new String[]{"-"}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            return new Locale((String) split$default.get(0), (String) split$default.get(1));
        }
        Locale locale2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale2, GlobalCountryCode.AMERICA);
        return locale2;
    }
}
