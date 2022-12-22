package com.didi.global.fintech.cashier.p117ui.kts;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierAlertDialog;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDrawer;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierPaySuccessDrawer;
import com.didi.global.globalgenerickit.eventtracker.Const;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a \u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u001ar\u0010\r\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016\u001aX\u0010\u0019\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016\u001aZ\u0010 \u001a\u00020\u000e*\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010$\u001a\u00020\u000b*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001¨\u0006&"}, mo175978d2 = {"dimen", "", "Landroid/content/Context;", "id", "dimenF", "", "dp2px", "dp", "dp2pxF", "getColor", "inputColor", "", "defaultColor", "showBottomDialog", "", "title", "subTitle", "showCloseIcon", "", "isHorizontal", "negativeText", "negativeClick", "Lkotlin/Function0;", "positiveText", "positiveClick", "showPaySuccessDialog", "status", "symbol", "price", "tipContent", "okText", "okClick", "showSimpleCenterDialog", "sp2px", "sp", "sp2pxF", "string", "resId", "cashier_ui_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.ContextKtxKt */
/* compiled from: ContextKtx.kt */
public final class ContextKtxKt {
    public static /* synthetic */ void showBottomDialog$default(Context context, String str, String str2, boolean z, boolean z2, String str3, Function0 function0, String str4, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            function0 = null;
        }
        if ((i & 64) != 0) {
            str4 = null;
        }
        if ((i & 128) != 0) {
            function02 = null;
        }
        showBottomDialog(context, str, str2, z, z2, str3, function0, str4, function02);
    }

    public static final void showBottomDialog(Context context, String str, String str2, boolean z, boolean z2, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        GlobalCashierDrawer globalCashierDrawer = new GlobalCashierDrawer();
        globalCashierDrawer.setTitle(str);
        globalCashierDrawer.setSubTitle(str2);
        globalCashierDrawer.setShowCloseBtn(z);
        globalCashierDrawer.setHorizontal(z2);
        CharSequence charSequence = str4;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            globalCashierDrawer.setPositiveBtn(MapsKt.mutableMapOf(TuplesKt.m42317to(str4, new View.OnClickListener() {
                public final void onClick(View view) {
                    ContextKtxKt.m15816a(Function0.this, view);
                }
            })));
        }
        CharSequence charSequence2 = str3;
        if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
            globalCashierDrawer.setNegativeBtn(MapsKt.mutableMapOf(TuplesKt.m42317to(str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    ContextKtxKt.m15817b(Function0.this, view);
                }
            })));
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this as FragmentActivity).supportFragmentManager");
        globalCashierDrawer.show(supportFragmentManager, Const.DRAWER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15816a(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15817b(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void showSimpleCenterDialog$default(Context context, String str, String str2, String str3, Function0 function0, String str4, Function0 function02, int i, Object obj) {
        showSimpleCenterDialog(context, str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : function0, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : function02);
    }

    public static final void showSimpleCenterDialog(Context context, String str, String str2, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        GlobalCashierAlertDialog globalCashierAlertDialog = new GlobalCashierAlertDialog();
        boolean z = false;
        globalCashierAlertDialog.setCancelable(false);
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        }
        globalCashierAlertDialog.setTitle(str);
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            str2 = "";
        }
        globalCashierAlertDialog.setSubTitle(str2);
        CharSequence charSequence3 = str3;
        if (!(charSequence3 == null || StringsKt.isBlank(charSequence3))) {
            globalCashierAlertDialog.setPosBtn(MapsKt.mutableMapOf(TuplesKt.m42317to(str3, new ContextKtxKt$showSimpleCenterDialog$1(function0))));
        }
        CharSequence charSequence4 = str4;
        if (!(charSequence4 == null || StringsKt.isBlank(charSequence4))) {
            globalCashierAlertDialog.setNegBtn(MapsKt.mutableMapOf(TuplesKt.m42317to(str4, new ContextKtxKt$showSimpleCenterDialog$2(function02))));
        }
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this as FragmentActivity).supportFragmentManager");
        globalCashierAlertDialog.show(supportFragmentManager, "simpleCenterDialog");
    }

    public static /* synthetic */ void showPaySuccessDialog$default(Context context, String str, String str2, String str3, String str4, String str5, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            function0 = null;
        }
        showPaySuccessDialog(context, str, str2, str3, str4, str5, function0);
    }

    public static final void showPaySuccessDialog(Context context, String str, String str2, String str3, String str4, String str5, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        GlobalCashierPaySuccessDrawer globalCashierPaySuccessDrawer = new GlobalCashierPaySuccessDrawer();
        globalCashierPaySuccessDrawer.setStatusStr(str);
        globalCashierPaySuccessDrawer.setSymbolStr(str2);
        globalCashierPaySuccessDrawer.setPriceStr(str3);
        globalCashierPaySuccessDrawer.setTipStr(str4);
        CharSequence charSequence = str5;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            globalCashierPaySuccessDrawer.setBtn(MapsKt.mutableMapOf(TuplesKt.m42317to(str5, new View.OnClickListener() {
                public final void onClick(View view) {
                    ContextKtxKt.m15818c(Function0.this, view);
                }
            })));
        }
        CharSequence charSequence2 = str3;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            CharSequence charSequence3 = str4;
            if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this as FragmentActivity).supportFragmentManager");
        globalCashierPaySuccessDrawer.show(supportFragmentManager, "paySuccessDialog");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m15818c(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final float dimenF(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimension(i);
    }

    public static final int dimen(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final float dp2pxF(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static final float dp2pxF(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return dp2pxF(context, (float) i);
    }

    public static final int dp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return MathKt.roundToInt(dp2pxF(context, f));
    }

    public static final int dp2px(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return MathKt.roundToInt(dp2pxF(context, i));
    }

    public static final float sp2pxF(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ((float) i) * context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final int sp2px(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return MathKt.roundToInt(sp2pxF(context, i));
    }

    public static final String string(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "this.getString(resId)");
        return string;
    }

    public static /* synthetic */ int getColor$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getColor(context, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return android.graphics.Color.parseColor("#ffffff");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return android.graphics.Color.parseColor(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getColor(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "#"
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r3 = "inputColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            r3 = 0
            r1 = 2
            r2 = 0
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r4, r0, r3, r1, r2)     // Catch:{ Exception -> 0x001f }
            if (r3 == 0) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r4)     // Catch:{ Exception -> 0x001f }
        L_0x001a:
            int r3 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x001f }
            goto L_0x002a
        L_0x001f:
            int r3 = android.graphics.Color.parseColor(r5)     // Catch:{ Exception -> 0x0024 }
            goto L_0x002a
        L_0x0024:
            java.lang.String r3 = "#ffffff"
            int r3 = android.graphics.Color.parseColor(r3)
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt.getColor(android.content.Context, java.lang.String, java.lang.String):int");
    }
}
