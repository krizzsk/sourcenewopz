package com.cardinalcommerce.p060a;

import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;

/* renamed from: com.cardinalcommerce.a.CardinalUiType */
public final class CardinalUiType extends CardinalActionCode {

    /* renamed from: a */
    private static int f2347a = 0;

    /* renamed from: b */
    private static int f2348b = 1;

    /* renamed from: com.cardinalcommerce.a.CardinalUiType$1 */
    static /* synthetic */ class C18891 {
        private static int Cardinal = 0;
        private static int configure = 1;
        static final /* synthetic */ int[] init;

        static {
            int[] iArr = new int[CardinalEnvironment.values().length];
            init = iArr;
            try {
                iArr[CardinalEnvironment.STAGING.ordinal()] = 1;
                int i = configure;
                int i2 = (i ^ 85) + ((i & 85) << 1);
                Cardinal = i2 % 128;
                int i3 = i2 % 2;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String getInstance(CardinalConfigurationParameters cardinalConfigurationParameters) {
        int i = f2348b;
        int i2 = i & 121;
        int i3 = (i2 - (~((i ^ 121) | i2))) - 1;
        f2347a = i3 % 128;
        int i4 = i3 % 2;
        if (C18891.init[cardinalConfigurationParameters.getEnvironment().ordinal()] != 1) {
            int i5 = f2348b;
            int i6 = ((i5 | 46) << 1) - (i5 ^ 46);
            int i7 = ((i6 | -1) << 1) - (i6 ^ -1);
            f2347a = i7 % 128;
            int i8 = i7 % 2;
            return "https://centinelapi.cardinalcommerce.com/V1/";
        }
        int i9 = (f2347a + 24) - 1;
        f2348b = i9 % 128;
        int i10 = i9 % 2;
        return "https://centinelapistag.cardinalcommerce.com/V1/";
    }
}
