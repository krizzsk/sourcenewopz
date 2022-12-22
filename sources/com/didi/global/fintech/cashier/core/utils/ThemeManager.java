package com.didi.global.fintech.cashier.core.utils;

import android.app.Activity;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.theme.ThemeType;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/ThemeManager;", "", "()V", "initTheme", "", "activity", "Landroid/app/Activity;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThemeManager.kt */
public final class ThemeManager {
    public static final ThemeManager INSTANCE = new ThemeManager();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ThemeManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeType.values().length];
            iArr[ThemeType.THEME_GLOBAL.ordinal()] = 1;
            iArr[ThemeType.THEME_LATOUR.ordinal()] = 2;
            iArr[ThemeType.THEME_99_SODA.ordinal()] = 3;
            iArr[ThemeType.THEME_GLOBAL_SODA.ordinal()] = 4;
            iArr[ThemeType.THEME_99_DRIVER.ordinal()] = 5;
            iArr[ThemeType.THEME_GLOBAL_DRIVER.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ThemeManager() {
    }

    public final void initTheme(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        switch (WhenMappings.$EnumSwitchMapping$0[CashierFacade.Companion.getInstance().getTheme().ordinal()]) {
            case 1:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_global);
                return;
            case 2:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_latour);
                return;
            case 3:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_99_soda);
                return;
            case 4:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_global_soda);
                return;
            case 5:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_99_driver);
                return;
            case 6:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_global_driver);
                return;
            default:
                activity.setTheme(R.style.GlobalCashierActivityTheme_for_99);
                return;
        }
    }
}
