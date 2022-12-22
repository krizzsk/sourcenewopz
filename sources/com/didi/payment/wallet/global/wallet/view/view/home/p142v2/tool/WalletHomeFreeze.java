package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSource;
import com.didi.payment.wallet.global.prepaidcard.StringUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.PrepaidInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.PrepaidStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeFreeze;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeFreeze;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze */
/* compiled from: WalletHomeFreeze.kt */
public final class WalletHomeFreeze {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final int f32780a = 1;

    /* renamed from: b */
    private static final int f32781b = 2;

    /* renamed from: c */
    private static final int f32782c = 3;

    /* renamed from: d */
    private static final int f32783d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Map<Integer, Function1<Context, Unit>> f32784e = new LinkedHashMap();

    @JvmStatic
    public static final void initFreezeStatus(TopCardViewHolder topCardViewHolder) {
        Companion.initFreezeStatus(topCardViewHolder);
    }

    @JvmStatic
    public static final void switchFreezeUIByStatus(Integer num, Context context) {
        Companion.switchFreezeUIByStatus(num, context);
    }

    @Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J,\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u001fJ%\u0010 \u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\"¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R5\u0010\b\u001a)\u0012\u0004\u0012\u00020\u0004\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeFreeze$Companion;", "", "()V", "WALLET_5K_FREEZE_STATUS", "", "WALLET_FOREVER_FREEZE_STATUS", "WALLET_NORMAL_FREEZE_STATUS", "WALLET_NORMAL_STATUS", "freezeMap", "", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "c", "", "initFreezeStatus", "holder", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewHolder;", "scalePic", "Landroid/graphics/drawable/Drawable;", "context", "resourceId", "sampleSize", "config", "Landroid/graphics/Bitmap$Config;", "setPrepaidUI", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountSection;", "switchFreezeUIByStatus", "status", "(Ljava/lang/Integer;Landroid/content/Context;)V", "switchWalletHomeNavBackground", "view", "Landroid/view/View;", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/View;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion */
    /* compiled from: WalletHomeFreeze.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void switchFreezeUIByStatus(Integer num, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Function1 function1 = (Function1) WalletHomeFreeze.f32784e.get(Integer.valueOf(num == null ? 0 : num.intValue()));
            if (function1 != null) {
                function1.invoke(context);
            }
        }

        public final void setPrepaidUI(TopCardViewHolder topCardViewHolder, AccountSection accountSection) {
            Integer num;
            PrepaidStatus marketingArea;
            PrepaidStatus marketingArea2;
            PrepaidStatus marketingArea3;
            TopCardViewHolder topCardViewHolder2 = topCardViewHolder;
            AccountSection accountSection2 = accountSection;
            Intrinsics.checkNotNullParameter(topCardViewHolder2, "holder");
            Context context = topCardViewHolder.getLlPrepaidMsg().getContext();
            if (context != null) {
                Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                String str = null;
                if (accountSection2 == null || (marketingArea3 = accountSection.getMarketingArea()) == null) {
                    num = null;
                } else {
                    num = marketingArea3.getType();
                }
                int i = 0;
                if ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 3)) {
                    topCardViewHolder.getClCard().setBackgroundResource(R.drawable.shape_home_top_card_prepaid);
                    topCardViewHolder.getTvTopUp().setBackgroundResource(R.drawable.shape_home_top_card_topup_prepaid);
                    topCardViewHolder.getTvTopUp().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_202438));
                    topCardViewHolder.getLlPrepaidMsg().setVisibility(8);
                    topCardViewHolder.getViewLine().setVisibility(0);
                    PrepaidInfo prepaidCardInfo = accountSection.getPrepaidCardInfo();
                    if (prepaidCardInfo != null) {
                        PayRichInfo payRichInfo = new PayRichInfo();
                        payRichInfo.text = baseContext.getString(R.string.Fintech_Payment_management_Home_Card_EXP, new Object[]{prepaidCardInfo.getLocalExp()});
                        payRichInfo.infoList = new ArrayList();
                        List<PayRichInfo.RichInfo> list = payRichInfo.infoList;
                        PayRichInfo.RichInfo richInfo = new PayRichInfo.RichInfo();
                        richInfo.start = 4;
                        String localExp = prepaidCardInfo.getLocalExp();
                        richInfo.length = localExp == null ? 0 : localExp.length();
                        richInfo.bold = 1;
                        Unit unit = Unit.INSTANCE;
                        list.add(richInfo);
                        payRichInfo.bindTextView(topCardViewHolder.getTvPrepaidDate(), (PayRichInfo.ISpannableString) null);
                        PayRichInfo payRichInfo2 = new PayRichInfo();
                        payRichInfo2.text = baseContext.getString(R.string.Fintech_Payment_management_Home_Card_NUM, new Object[]{prepaidCardInfo.getLocalNum()});
                        payRichInfo2.infoList = new ArrayList();
                        List<PayRichInfo.RichInfo> list2 = payRichInfo2.infoList;
                        PayRichInfo.RichInfo richInfo2 = new PayRichInfo.RichInfo();
                        richInfo2.start = 4;
                        String localNum = prepaidCardInfo.getLocalNum();
                        richInfo2.length = localNum == null ? 0 : localNum.length();
                        richInfo2.bold = 1;
                        Unit unit2 = Unit.INSTANCE;
                        list2.add(richInfo2);
                        payRichInfo2.bindTextView(topCardViewHolder.getTvPrepaidNo(), (PayRichInfo.ISpannableString) null);
                        topCardViewHolder.getTvPrepaidDate().setVisibility(0);
                        topCardViewHolder.getTvPrepaidNo().setVisibility(0);
                    }
                    topCardViewHolder.getIvCardRight().setVisibility(8);
                    topCardViewHolder.getLlBottom().setBackgroundResource(R.drawable.shape_home_top_card_bottom_prepaid);
                    topCardViewHolder.getIvPayLogo().setVisibility(0);
                    topCardViewHolder.getTvBalance().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_FFFFFF));
                    topCardViewHolder.getTvTitle().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_FFFFFF));
                    topCardViewHolder2.setBalanceEyeShowDrawableId(R.drawable.ic_home_top_card_hide_prepaid);
                    topCardViewHolder2.setBalanceEycHideDrawableId(R.drawable.ic_home_top_card_open_prepaid);
                    topCardViewHolder.getTvBalance().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    topCardViewHolder.getClCard().setOnClickListener(new View.OnClickListener(baseContext) {
                        public final /* synthetic */ Context f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onClick(View view) {
                            WalletHomeFreeze.Companion.m46634setPrepaidUI$lambda5(this.f$0, view);
                        }
                    });
                    WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
                    PrepaidStatus marketingArea4 = accountSection.getMarketingArea();
                    WalletHomeTrackerManager.Companion.trackCardPrepaidApply$default(companion, marketingArea4 == null ? null : marketingArea4.getType(), "fin_prepaidcard_activated_sw", (Integer) null, 4, (Object) null);
                } else {
                    topCardViewHolder.getLlBottom().setBackgroundResource(R.drawable.shape_home_top_card_bottom);
                    topCardViewHolder.getIvPayLogo().setVisibility(8);
                    topCardViewHolder.getTvPrepaidDate().setVisibility(8);
                    topCardViewHolder.getTvPrepaidNo().setVisibility(8);
                    topCardViewHolder.getViewLine().setVisibility(8);
                    topCardViewHolder.getTvBalance().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_000000));
                    topCardViewHolder.getTvTitle().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_000000));
                    topCardViewHolder.getClCard().setOnClickListener((View.OnClickListener) null);
                }
                LinearLayout llPrepaidMsg = topCardViewHolder.getLlPrepaidMsg();
                if (!(accountSection2 == null || (marketingArea2 = accountSection.getMarketingArea()) == null)) {
                    str = marketingArea2.getText();
                }
                if (TextUtils.isEmpty(str)) {
                    i = 8;
                }
                llPrepaidMsg.setVisibility(i);
                if (accountSection2 != null && (marketingArea = accountSection.getMarketingArea()) != null) {
                    TextView tvPrepaidMsg = topCardViewHolder.getTvPrepaidMsg();
                    StringUtils.Companion companion2 = StringUtils.Companion;
                    String text = marketingArea.getText();
                    if (text == null) {
                        text = "";
                    }
                    tvPrepaidMsg.setText(companion2.handleSpecialText(text, new StringUtils.BoldFont()));
                    GlideUtils.with2load2into(baseContext, marketingArea.getIconUrl(), topCardViewHolder.getIvPrepaid());
                    topCardViewHolder.getLlPrepaidMsg().setOnClickListener(new View.OnClickListener(baseContext, marketingArea) {
                        public final /* synthetic */ Context f$1;
                        public final /* synthetic */ PrepaidStatus f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            WalletHomeFreeze.Companion.m46635setPrepaidUI$lambda7$lambda6(AccountSection.this, this.f$1, this.f$2, view);
                        }
                    });
                    Integer type = marketingArea.getType();
                    if (type != null && type.intValue() == 1) {
                        topCardViewHolder.getLlPrepaidMsg().setBackgroundResource(R.drawable.shape_home_top_prepaid_msg);
                        topCardViewHolder.getTvPrepaidMsg().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_FF6F25));
                    } else if (type != null && type.intValue() == 2) {
                        topCardViewHolder.getLlPrepaidMsg().setBackgroundResource(R.drawable.shape_home_top_prepaid_msg_grey);
                        topCardViewHolder.getTvPrepaidMsg().setTextColor(ContextCompat.getColor(baseContext, R.color.wallet_color_202438));
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: setPrepaidUI$lambda-5  reason: not valid java name */
        public static final void m46634setPrepaidUI$lambda5(Context context, View view) {
            DRouter.build(PrepaidCardManager.Companion.buildWalletUrl(PrepaidCardManager.Companion.buildPrepaidUrl(PrepaidCardManager.PREPAID_CARD_URL, PrepaidSource.HOME_SKU.getValue(), PrepaidConstant.SCENE_HOME_PAGE, WalletHomeTrackerManager.Companion.getStatus(), "1", ""))).start(context);
        }

        /* access modifiers changed from: private */
        /* renamed from: setPrepaidUI$lambda-7$lambda-6  reason: not valid java name */
        public static final void m46635setPrepaidUI$lambda7$lambda6(AccountSection accountSection, Context context, PrepaidStatus prepaidStatus, View view) {
            Integer indexType;
            Intrinsics.checkNotNullParameter(prepaidStatus, "$this_apply");
            PrepaidStatus marketingArea = accountSection.getMarketingArea();
            boolean z = false;
            if (!(marketingArea == null || (indexType = marketingArea.getIndexType()) == null || indexType.intValue() != 4)) {
                z = true;
            }
            Integer num = null;
            if (z) {
                WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1 walletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1 = new WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1(context, accountSection);
                PrepaidCardManager.Companion companion = PrepaidCardManager.Companion;
                String value = PrepaidSource.HOME_TOP.getValue();
                AccountStatusMessage accountStatusMessage = accountSection.getAccountStatusMessage();
                PrepaidCardManager.Companion.start$default(companion, context, value, PrepaidConstant.SCENE_APPLY, accountStatusMessage == null ? null : accountStatusMessage.getStatus(), "1", (String) null, walletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1, 32, (Object) null);
            } else {
                DRouter.build(PrepaidCardManager.Companion.buildWalletUrl(prepaidStatus.getLinkUrl())).start(context);
                EventBus.getDefault().post(new WalletRefreshDataEvent());
            }
            WalletHomeTrackerManager.Companion companion2 = WalletHomeTrackerManager.Companion;
            PrepaidStatus marketingArea2 = accountSection.getMarketingArea();
            if (marketingArea2 != null) {
                num = marketingArea2.getType();
            }
            WalletHomeTrackerManager.Companion.trackCardPrepaidApply$default(companion2, num, "fin_prepaidcard_apply_banner_ck", (Integer) null, 4, (Object) null);
        }

        @JvmStatic
        public final void initFreezeStatus(TopCardViewHolder topCardViewHolder) {
            Intrinsics.checkNotNullParameter(topCardViewHolder, "holder");
            if (!WalletHomeFreeze.f32784e.isEmpty()) {
                WalletHomeFreeze.f32784e.clear();
            }
            Function1 walletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1 = new WalletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1(topCardViewHolder);
            WalletHomeFreeze.f32784e.put(1, walletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1);
            WalletHomeFreeze.f32784e.put(2, walletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1);
            WalletHomeFreeze.f32784e.put(3, new WalletHomeFreeze$Companion$initFreezeStatus$1(topCardViewHolder));
            WalletHomeFreeze.f32784e.put(0, new WalletHomeFreeze$Companion$initFreezeStatus$2(topCardViewHolder));
        }

        public final void switchWalletHomeNavBackground(Context context, Integer num, View view) {
            boolean z;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                view.setBackgroundResource(R.drawable.shape_home_title_freeze_bar);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(WalletHomeController.Companion.findHomePageTheme(context), typedValue, true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{R.attr.wallet_home_title_bar_background});
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ue.resourceId, attribute)");
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            view.setBackground(drawable);
        }

        static /* synthetic */ Drawable scalePic$default(Companion companion, Context context, int i, int i2, Bitmap.Config config, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = 2;
            }
            if ((i3 & 8) != 0) {
                config = Bitmap.Config.RGB_565;
            }
            return companion.scalePic(context, i, i2, config);
        }

        private final Drawable scalePic(Context context, int i, int i2, Bitmap.Config config) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i2;
            options.inPreferredConfig = config;
            return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), i, options));
        }
    }
}
