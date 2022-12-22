package com.didi.payment.wallet_ui;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet_ui.IWalletUI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/UiUtils;", "", "()V", "Companion", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UiUtils.kt */
public final class UiUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f32871a = Resources.getSystem().getDisplayMetrics().widthPixels;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f32872b = Resources.getSystem().getDisplayMetrics().heightPixels;

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rJ\t\u0010\u001a\u001a\u00020\rH\u0001J\t\u0010\u001b\u001a\u00020\rH\u0001J\t\u0010\u001c\u001a\u00020\rH\u0001J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/UiUtils$Companion;", "Lcom/didi/payment/wallet_ui/IWalletUI;", "()V", "bigBtnCornerFraction", "", "getBigBtnCornerFraction", "()F", "isWhiteInThemeBg", "", "()Z", "midBtnCornerFraction", "getMidBtnCornerFraction", "screenHeight", "", "getScreenHeight", "()I", "screenWidth", "getScreenWidth", "smallBtnCornerFraction", "getSmallBtnCornerFraction", "walletFirstLevelButtonBgColorOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWalletFirstLevelButtonBgColorOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "floatSize", "size", "getThemeBgColor", "getWalletFirstLevelButtonBgEndColor", "getWalletFirstLevelButtonBgStartColor", "intSize", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: UiUtils.kt */
    public static final class Companion implements IWalletUI {
        private final /* synthetic */ IWalletUI $$delegate_0;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public float getBigBtnCornerFraction() {
            return this.$$delegate_0.getBigBtnCornerFraction();
        }

        public float getMidBtnCornerFraction() {
            return this.$$delegate_0.getMidBtnCornerFraction();
        }

        public float getSmallBtnCornerFraction() {
            return this.$$delegate_0.getSmallBtnCornerFraction();
        }

        public int getThemeBgColor() {
            return this.$$delegate_0.getThemeBgColor();
        }

        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgColorOrientation();
        }

        public int getWalletFirstLevelButtonBgEndColor() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgEndColor();
        }

        public int getWalletFirstLevelButtonBgStartColor() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgStartColor();
        }

        public boolean isWhiteInThemeBg() {
            return this.$$delegate_0.isWhiteInThemeBg();
        }

        private Companion() {
            IWalletUI iWalletUI;
            if (UiUtilsKt.getSwitchWalletUIImpl()) {
                iWalletUI = UiUtilsKt.getWalletUIImpl();
                if (iWalletUI == null) {
                    iWalletUI = new IWalletUI() {
                        public float getBigBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getBigBtnCornerFraction(this);
                        }

                        public float getMidBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getMidBtnCornerFraction(this);
                        }

                        public float getSmallBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getSmallBtnCornerFraction(this);
                        }

                        public int getThemeBgColor() {
                            return IWalletUI.DefaultImpls.getThemeBgColor(this);
                        }

                        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgColorOrientation(this);
                        }

                        public int getWalletFirstLevelButtonBgEndColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgEndColor(this);
                        }

                        public int getWalletFirstLevelButtonBgStartColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgStartColor(this);
                        }

                        public boolean isWhiteInThemeBg() {
                            return IWalletUI.DefaultImpls.isWhiteInThemeBg(this);
                        }
                    };
                }
            } else {
                iWalletUI = DRouter.build(IWalletUI.class).getService(new Object[0]);
                if (iWalletUI == null) {
                    iWalletUI = new IWalletUI() {
                        public float getBigBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getBigBtnCornerFraction(this);
                        }

                        public float getMidBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getMidBtnCornerFraction(this);
                        }

                        public float getSmallBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getSmallBtnCornerFraction(this);
                        }

                        public int getThemeBgColor() {
                            return IWalletUI.DefaultImpls.getThemeBgColor(this);
                        }

                        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgColorOrientation(this);
                        }

                        public int getWalletFirstLevelButtonBgEndColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgEndColor(this);
                        }

                        public int getWalletFirstLevelButtonBgStartColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgStartColor(this);
                        }

                        public boolean isWhiteInThemeBg() {
                            return IWalletUI.DefaultImpls.isWhiteInThemeBg(this);
                        }
                    };
                }
            }
            this.$$delegate_0 = iWalletUI;
        }

        public final int getScreenWidth() {
            return UiUtils.f32871a;
        }

        public final int getScreenHeight() {
            return UiUtils.f32872b;
        }

        public final int intSize(int i) {
            return (i * getScreenWidth()) / 750;
        }

        public final float floatSize(int i) {
            return ((float) (i * getScreenWidth())) / 750.0f;
        }
    }
}
