package com.didi.soda.customer.foundation.util;

import android.graphics.Color;
import android.util.Range;
import android.widget.TextView;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo175977d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a'\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010H\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n\u001a3\u0010\u0015\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00010\u00162!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00130\u0018\u001a\f\u0010\u001c\u001a\u00020\u001d*\u0004\u0018\u00010\n\u001a\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001f\u001a\u0012\u0010 \u001a\u00020\u0013*\u00020!2\u0006\u0010\"\u001a\u00020\u0001\u001a\f\u0010#\u001a\u00020\u0013*\u0004\u0018\u00010$\u001a\f\u0010%\u001a\u00020\n*\u0004\u0018\u00010&\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f*\u0016\u0010'\"\b\u0012\u0004\u0012\u00020\u00130\u00102\b\u0012\u0004\u0012\u00020\u00130\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, mo175978d2 = {"color", "", "getColor", "(I)I", "orZero", "getOrZero", "(Ljava/lang/Integer;)I", "px", "getPx", "string", "", "getString", "(I)Ljava/lang/String;", "safeRun", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeThrow", "", "msg", "foreach", "Landroid/util/Range;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "isNameNullOrEmpty", "", "parseToColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "setCustomerTextWeight", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "weight", "strike", "Landroid/widget/TextView;", "toJsonString", "", "VoidCallback", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerExtention.kt */
public final class CustomerExtentionKt {
    public static final void safeThrow(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
    }

    public static final int getPx(int i) {
        return ResourceHelper.getDimensionPixelSize(i);
    }

    public static final int getColor(int i) {
        return ResourceHelper.getColor(i);
    }

    public static final String getString(int i) {
        String string = ResourceHelper.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(this)");
        return string;
    }

    public static final int getOrZero(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final void setCustomerTextWeight(CustomerAppCompatTextView customerAppCompatTextView, int i) {
        IToolsService.FontType fontType;
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<this>");
        if (i == 2) {
            fontType = IToolsService.FontType.MEDIUM;
        } else if (i == 3) {
            fontType = IToolsService.FontType.BOLD;
        } else if (i != 4) {
            fontType = IToolsService.FontType.NORMAL;
        } else {
            fontType = IToolsService.FontType.LIGHT;
        }
        customerAppCompatTextView.setFontType(fontType);
    }

    public static final Integer parseToColor(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String toJsonString(Object obj) {
        if (obj == null) {
            return "null";
        }
        String json = GsonUtil.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(this)");
        return json;
    }

    public static final void strike(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFlags(17);
        }
    }

    public static final void foreach(Range<Integer> range, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(range, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        int intValue = range.getLower().intValue();
        Integer upper = range.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "this.upper");
        Iterator it = new IntRange(intValue, upper.intValue()).iterator();
        while (it.hasNext()) {
            function1.invoke(Integer.valueOf(((IntIterator) it).nextInt()));
        }
    }

    public static final <R> R safeRun(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return function0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final boolean isNameNullOrEmpty(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = charSequence.subSequence(i, length + 1).toString();
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || charSequence2.length() == 0) {
            return true;
        }
        return false;
    }
}
