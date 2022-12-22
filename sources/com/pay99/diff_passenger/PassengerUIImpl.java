package com.pay99.diff_passenger;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet_ui.IWalletUI;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerUIImpl;", "Lcom/didi/payment/wallet_ui/IWalletUI;", "()V", "bigBtnCornerFraction", "", "getBigBtnCornerFraction", "()F", "isWhiteInThemeBg", "", "()Z", "midBtnCornerFraction", "getMidBtnCornerFraction", "smallBtnCornerFraction", "getSmallBtnCornerFraction", "walletFirstLevelButtonBgColorOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWalletFirstLevelButtonBgColorOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "getThemeBgColor", "", "getWalletFirstLevelButtonBgEndColor", "getWalletFirstLevelButtonBgStartColor", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerUIImpl.kt */
public final class PassengerUIImpl implements IWalletUI {
    public float getBigBtnCornerFraction() {
        return 0.5f;
    }

    public float getMidBtnCornerFraction() {
        return 0.5f;
    }

    public float getSmallBtnCornerFraction() {
        return 0.5f;
    }

    public int getThemeBgColor() {
        return Color.parseColor(WalletCommonParamsUtil.isPassengerBrazilClient() ? "#FFCA00" : "#FF8040");
    }

    public boolean isWhiteInThemeBg() {
        return !WalletCommonParamsUtil.isPassengerBrazilClient();
    }

    public int getWalletFirstLevelButtonBgStartColor() {
        return Color.parseColor(WalletCommonParamsUtil.isPassengerBrazilClient() ? "#FFF366" : "#FF8F40");
    }

    public int getWalletFirstLevelButtonBgEndColor() {
        return Color.parseColor(WalletCommonParamsUtil.isPassengerBrazilClient() ? "#FFC040" : "#FF7040");
    }

    public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }
}
