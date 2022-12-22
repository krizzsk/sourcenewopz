package com.didi.soda.globalcart.anim;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "", "srcStr", "dstStr"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TotalPriceAnim.kt */
final class TotalPriceAnim$changeMethod$1 extends Lambda implements Function2<String, String, String> {
    public static final TotalPriceAnim$changeMethod$1 INSTANCE = new TotalPriceAnim$changeMethod$1();

    TotalPriceAnim$changeMethod$1() {
        super(2);
    }

    public final String invoke(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "srcStr");
        Intrinsics.checkNotNullParameter(str2, "dstStr");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int i = parseInt < parseInt2 ? (parseInt + 10) - parseInt2 : parseInt - parseInt2;
            if (i == 0) {
                return str2;
            }
            if (i > 5) {
                str3 = String.valueOf((parseInt + 1) % 10);
            } else {
                str3 = String.valueOf((parseInt + 9) % 10);
            }
            return str3;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
