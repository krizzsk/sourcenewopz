package com.adyen.checkout.components.util;

import com.adyen.checkout.core.api.Environment;
import com.didi.entrega.customer.app.constant.Const;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/adyen/checkout/components/util/ValidationUtils;", "", "()V", "CLIENT_KEY_LIVE_PREFIX", "", "CLIENT_KEY_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CLIENT_KEY_REGEX", "CLIENT_KEY_TEST_PREFIX", "EMAIL_PATTERN", "EMAIL_REGEX", "PHONE_PATTERN", "PHONE_REGEX", "doesClientKeyMatchEnvironment", "", "clientKey", "environment", "Lcom/adyen/checkout/core/api/Environment;", "isClientKeyValid", "isEmailValid", "emailAddress", "isPhoneNumberValid", "phoneNumber", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ValidationUtils.kt */
public final class ValidationUtils {
    public static final ValidationUtils INSTANCE = new ValidationUtils();

    /* renamed from: a */
    private static final String f911a = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

    /* renamed from: b */
    private static final Pattern f912b = Pattern.compile(f911a, 2);

    /* renamed from: c */
    private static final String f913c = "^\\D*(\\d\\D*){9,14}$";

    /* renamed from: d */
    private static final Pattern f914d = Pattern.compile(f913c);

    /* renamed from: e */
    private static final String f915e = "([a-z]){4}\\_([A-z]|\\d){32}";

    /* renamed from: f */
    private static final Pattern f916f = Pattern.compile(f915e);

    /* renamed from: g */
    private static final String f917g = "test_";

    /* renamed from: h */
    private static final String f918h = "live_";

    private ValidationUtils() {
    }

    public final boolean isPhoneNumberValid(String str) {
        Intrinsics.checkNotNullParameter(str, Const.PageParams.PHONE_NUMBER);
        return f914d.matcher(str).matches();
    }

    public final boolean isEmailValid(String str) {
        Intrinsics.checkNotNullParameter(str, "emailAddress");
        return f912b.matcher(str).matches();
    }

    public final boolean isClientKeyValid(String str) {
        Intrinsics.checkNotNullParameter(str, "clientKey");
        return f916f.matcher(str).matches();
    }

    public final boolean doesClientKeyMatchEnvironment(String str, Environment environment) {
        Intrinsics.checkNotNullParameter(str, "clientKey");
        Intrinsics.checkNotNullParameter(environment, "environment");
        boolean areEqual = Intrinsics.areEqual((Object) environment, (Object) Environment.TEST);
        boolean z = Intrinsics.areEqual((Object) environment, (Object) Environment.EUROPE) || Intrinsics.areEqual((Object) environment, (Object) Environment.AUSTRALIA) || Intrinsics.areEqual((Object) environment, (Object) Environment.UNITED_STATES);
        if (z && StringsKt.startsWith$default(str, f918h, false, 2, (Object) null)) {
            return true;
        }
        if (areEqual && StringsKt.startsWith$default(str, f917g, false, 2, (Object) null)) {
            return true;
        }
        if (z || areEqual) {
            return false;
        }
        return true;
    }
}
