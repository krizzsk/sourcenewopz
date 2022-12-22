package com.didi.payment.wallet_ui;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0012H\u0017J\b\u0010\u0014\u001a\u00020\u0012H\u0017R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/IWalletUI;", "", "bigBtnCornerFraction", "", "getBigBtnCornerFraction", "()F", "isWhiteInThemeBg", "", "()Z", "midBtnCornerFraction", "getMidBtnCornerFraction", "smallBtnCornerFraction", "getSmallBtnCornerFraction", "walletFirstLevelButtonBgColorOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWalletFirstLevelButtonBgColorOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "getThemeBgColor", "", "getWalletFirstLevelButtonBgEndColor", "getWalletFirstLevelButtonBgStartColor", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalletUI.kt */
public interface IWalletUI {
    float getBigBtnCornerFraction();

    float getMidBtnCornerFraction();

    float getSmallBtnCornerFraction();

    int getThemeBgColor();

    GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation();

    int getWalletFirstLevelButtonBgEndColor();

    int getWalletFirstLevelButtonBgStartColor();

    boolean isWhiteInThemeBg();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IWalletUI.kt */
    public static final class DefaultImpls {
        public static float getBigBtnCornerFraction(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return 0.5f;
        }

        public static float getMidBtnCornerFraction(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return 0.5f;
        }

        public static float getSmallBtnCornerFraction(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return 0.5f;
        }

        public static boolean isWhiteInThemeBg(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return false;
        }

        public static int getThemeBgColor(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return Color.parseColor("#FFCA00");
        }

        public static int getWalletFirstLevelButtonBgStartColor(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return Color.parseColor("#FFF366");
        }

        public static int getWalletFirstLevelButtonBgEndColor(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return Color.parseColor("#FFC040");
        }

        public static GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation(IWalletUI iWalletUI) {
            Intrinsics.checkNotNullParameter(iWalletUI, "this");
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
