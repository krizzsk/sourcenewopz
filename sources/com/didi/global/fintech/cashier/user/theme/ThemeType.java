package com.didi.global.fintech.cashier.user.theme;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/theme/ThemeType;", "", "type", "", "(Ljava/lang/String;II)V", "brazil", "", "global", "latour", "THEME_99", "THEME_GLOBAL", "THEME_LATOUR", "THEME_99_SODA", "THEME_GLOBAL_SODA", "THEME_99_DRIVER", "THEME_GLOBAL_DRIVER", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThemeType.kt */
public enum ThemeType {
    THEME_99(0),
    THEME_GLOBAL(1),
    THEME_LATOUR(2),
    THEME_99_SODA(3),
    THEME_GLOBAL_SODA(4),
    THEME_99_DRIVER(5),
    THEME_GLOBAL_DRIVER(6);

    private ThemeType(int i) {
    }

    public final boolean brazil() {
        return this == THEME_99 || this == THEME_99_SODA || this == THEME_99_DRIVER;
    }

    public final boolean global() {
        return this == THEME_GLOBAL || this == THEME_GLOBAL_SODA || this == THEME_GLOBAL_DRIVER;
    }

    public final boolean latour() {
        return this == THEME_LATOUR;
    }
}
