package com.didi.sdk.util;

import android.content.Context;
import com.didi.sdk.nation.NationTypeUtil;

public class FormatUtils {

    public enum PLACEHOLDER {
        BRAND("{brand}");
        
        private String str;

        private PLACEHOLDER(String str2) {
            this.str = str2;
        }

        public String toString() {
            return this.str;
        }
    }

    public static String format(Context context, int i, PLACEHOLDER placeholder) {
        return context.getString(i).replace(placeholder.toString(), m26689a(placeholder));
    }

    /* renamed from: com.didi.sdk.util.FormatUtils$1 */
    static /* synthetic */ class C131511 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$util$FormatUtils$PLACEHOLDER;

        static {
            int[] iArr = new int[PLACEHOLDER.values().length];
            $SwitchMap$com$didi$sdk$util$FormatUtils$PLACEHOLDER = iArr;
            try {
                iArr[PLACEHOLDER.BRAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: a */
    private static String m26689a(PLACEHOLDER placeholder) {
        if (C131511.$SwitchMap$com$didi$sdk$util$FormatUtils$PLACEHOLDER[placeholder.ordinal()] != 1) {
            return "";
        }
        return NationTypeUtil.getNationComponentData().getBrand();
    }
}
