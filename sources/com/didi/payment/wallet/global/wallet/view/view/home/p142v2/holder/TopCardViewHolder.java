package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.BankCard;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.BulletinBoardSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Button;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Coupon;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.PrepaidStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.QuickFunctionSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeFreeze;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\b\u0010]\u001a\u00020\u000bH\u0016J!\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010cJ\u0016\u0010d\u001a\u00020_2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00030fH\u0016J\u0010\u0010g\u001a\u00020_2\u0006\u0010h\u001a\u00020iH\u0016J\u0018\u0010j\u001a\u00020_2\u0006\u0010k\u001a\u00020l2\u0006\u0010T\u001a\u00020<H\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010)\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010+\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u000e\u0010/\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u000e\u00109\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bI\u0010?R\u0011\u0010J\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bK\u0010?R\u0011\u0010L\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bM\u0010?R\u0011\u0010N\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bO\u0010?R\u0011\u0010P\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010?R\u000e\u0010R\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010T\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bU\u0010?R\u0011\u0010V\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bW\u0010?R\u000e\u0010X\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\¨\u0006m"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "itemView", "Landroid/view/View;", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Landroid/view/View;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "(Landroid/view/View;)V", "balanceEycHideDrawableId", "", "getBalanceEycHideDrawableId", "()I", "setBalanceEycHideDrawableId", "(I)V", "balanceEyeShowDrawableId", "getBalanceEyeShowDrawableId", "setBalanceEyeShowDrawableId", "clCard", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClCard", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "clFreeze", "getClFreeze", "clTopUp", "getClTopUp$wallet_globalRelease", "flAddCard", "Landroid/widget/FrameLayout;", "flPublic", "flRoot", "getFlRoot", "()Landroid/widget/FrameLayout;", "ivAddBank", "Landroid/widget/ImageView;", "ivAddGifBank", "ivCardRight", "getIvCardRight", "()Landroid/widget/ImageView;", "ivFreeze", "getIvFreeze", "ivFreezeIcon", "getIvFreezeIcon", "ivPayLogo", "getIvPayLogo", "ivPrepaid", "getIvPrepaid", "ivPublicClose", "ivTopUp", "llBank", "Landroid/widget/LinearLayout;", "llBottom", "getLlBottom", "()Landroid/widget/LinearLayout;", "llCoupon", "llPrepaidMsg", "getLlPrepaidMsg", "llQuickFunction", "llTag", "tvAddCard", "Landroid/widget/TextView;", "tvBalance", "getTvBalance", "()Landroid/widget/TextView;", "tvBank", "tvBankCount", "tvCashback", "tvCoupon", "tvCouponCount", "tvDesc", "tvDiscount", "tvEarnings", "tvFreezeDesc", "getTvFreezeDesc", "tvFreezeTitle", "getTvFreezeTitle", "tvPrepaidDate", "getTvPrepaidDate", "tvPrepaidMsg", "getTvPrepaidMsg", "tvPrepaidNo", "getTvPrepaidNo", "tvPublic", "tvStatus", "tvTitle", "getTvTitle", "tvTopUp", "getTvTopUp", "viewCardDot", "viewDot", "viewLine", "getViewLine", "()Landroid/view/View;", "getViewType", "layoutQuickFunction", "", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/QuickFunctionSection;", "status", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/QuickFunctionSection;Ljava/lang/Integer;)V", "onBindViewHolder", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "switchAmountStatus", "amountStatus", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder */
/* compiled from: TopCardViewHolder.kt */
public final class TopCardViewHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<Data> {

    /* renamed from: A */
    private final TextView f32697A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final ImageView f32698B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final ImageView f32699C;

    /* renamed from: D */
    private final View f32700D;

    /* renamed from: E */
    private final ConstraintLayout f32701E;

    /* renamed from: F */
    private final ConstraintLayout f32702F;

    /* renamed from: G */
    private final ConstraintLayout f32703G;

    /* renamed from: H */
    private final TextView f32704H;

    /* renamed from: I */
    private final ImageView f32705I;

    /* renamed from: J */
    private final FrameLayout f32706J;

    /* renamed from: K */
    private final TextView f32707K;

    /* renamed from: L */
    private final TextView f32708L;

    /* renamed from: M */
    private final ImageView f32709M;

    /* renamed from: N */
    private final ImageView f32710N;

    /* renamed from: O */
    private final ImageView f32711O;

    /* renamed from: P */
    private final LinearLayout f32712P;

    /* renamed from: Q */
    private final ImageView f32713Q;

    /* renamed from: R */
    private final View f32714R;

    /* renamed from: S */
    private int f32715S;

    /* renamed from: T */
    private int f32716T;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletHomeContract.V2Listener f32717a;

    /* renamed from: b */
    private final TextView f32718b;

    /* renamed from: c */
    private final TextView f32719c;

    /* renamed from: d */
    private final TextView f32720d;

    /* renamed from: e */
    private final TextView f32721e;

    /* renamed from: f */
    private final TextView f32722f;

    /* renamed from: g */
    private final TextView f32723g;

    /* renamed from: h */
    private final TextView f32724h;

    /* renamed from: i */
    private final TextView f32725i;

    /* renamed from: j */
    private final LinearLayout f32726j;

    /* renamed from: k */
    private final LinearLayout f32727k;

    /* renamed from: l */
    private final FrameLayout f32728l;

    /* renamed from: m */
    private final TextView f32729m;

    /* renamed from: n */
    private final LinearLayout f32730n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final View f32731o;

    /* renamed from: p */
    private final FrameLayout f32732p;

    /* renamed from: q */
    private final TextView f32733q;

    /* renamed from: r */
    private final TextView f32734r;

    /* renamed from: s */
    private final TextView f32735s;

    /* renamed from: t */
    private final TextView f32736t;

    /* renamed from: u */
    private final LinearLayout f32737u;

    /* renamed from: v */
    private final ImageView f32738v;

    /* renamed from: w */
    private final TextView f32739w;

    /* renamed from: x */
    private final TextView f32740x;

    /* renamed from: y */
    private final LinearLayout f32741y;

    /* renamed from: z */
    private final ImageView f32742z;

    public int getViewType() {
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopCardViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
        this.f32718b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_balance);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_balance)");
        this.f32719c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_desc)");
        this.f32720d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_status);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_status)");
        this.f32721e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_bank)");
        this.f32722f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_bank_count);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_bank_count)");
        this.f32723g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.tv_coupon)");
        this.f32724h = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_coupon_count);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_coupon_count)");
        this.f32725i = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.ll_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.ll_bank)");
        this.f32726j = (LinearLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.ll_coupon);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.ll_coupon)");
        this.f32727k = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.fl_public);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.fl_public)");
        this.f32728l = (FrameLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.tv_public);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.tv_public)");
        this.f32729m = (TextView) findViewById12;
        View findViewById13 = view.findViewById(R.id.ll_function);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(R.id.ll_function)");
        this.f32730n = (LinearLayout) findViewById13;
        View findViewById14 = view.findViewById(R.id.view_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(R.id.view_dot)");
        this.f32731o = findViewById14;
        View findViewById15 = view.findViewById(R.id.fl_add_card);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(R.id.fl_add_card)");
        this.f32732p = (FrameLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.tv_add_card_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(R.id.tv_add_card_discount)");
        this.f32733q = (TextView) findViewById16;
        View findViewById17 = view.findViewById(R.id.tv_add_card);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "itemView.findViewById(R.id.tv_add_card)");
        this.f32734r = (TextView) findViewById17;
        View findViewById18 = view.findViewById(R.id.tv_earnings);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "itemView.findViewById(R.id.tv_earnings)");
        this.f32735s = (TextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.tv_cashback);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "itemView.findViewById(R.id.tv_cashback)");
        this.f32736t = (TextView) findViewById19;
        View findViewById20 = view.findViewById(R.id.ll_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "itemView.findViewById(R.id.ll_tag)");
        this.f32737u = (LinearLayout) findViewById20;
        View findViewById21 = view.findViewById(R.id.iv_public_close);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "itemView.findViewById(R.id.iv_public_close)");
        this.f32738v = (ImageView) findViewById21;
        View findViewById22 = view.findViewById(R.id.tv_prepaid_no);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "itemView.findViewById(R.id.tv_prepaid_no)");
        this.f32739w = (TextView) findViewById22;
        View findViewById23 = view.findViewById(R.id.tv_prepaid_date);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "itemView.findViewById(R.id.tv_prepaid_date)");
        this.f32740x = (TextView) findViewById23;
        View findViewById24 = view.findViewById(R.id.fl_prepaid_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "itemView.findViewById(R.id.fl_prepaid_msg)");
        this.f32741y = (LinearLayout) findViewById24;
        View findViewById25 = view.findViewById(R.id.iv_prepaid);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "itemView.findViewById(R.id.iv_prepaid)");
        this.f32742z = (ImageView) findViewById25;
        View findViewById26 = view.findViewById(R.id.tv_prepaid_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "itemView.findViewById(R.id.tv_prepaid_msg)");
        this.f32697A = (TextView) findViewById26;
        View findViewById27 = view.findViewById(R.id.iv_add_bank);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "itemView.findViewById(R.id.iv_add_bank)");
        this.f32698B = (ImageView) findViewById27;
        View findViewById28 = view.findViewById(R.id.iv_add_gif);
        Intrinsics.checkNotNullExpressionValue(findViewById28, "itemView.findViewById(R.id.iv_add_gif)");
        this.f32699C = (ImageView) findViewById28;
        View findViewById29 = view.findViewById(R.id.view_card_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById29, "itemView.findViewById(R.id.view_card_dot)");
        this.f32700D = findViewById29;
        View findViewById30 = view.findViewById(R.id.cl_freeze);
        Intrinsics.checkNotNullExpressionValue(findViewById30, "itemView.findViewById(R.id.cl_freeze)");
        this.f32701E = (ConstraintLayout) findViewById30;
        View findViewById31 = view.findViewById(R.id.cl_card);
        Intrinsics.checkNotNullExpressionValue(findViewById31, "itemView.findViewById(R.id.cl_card)");
        this.f32702F = (ConstraintLayout) findViewById31;
        View findViewById32 = view.findViewById(R.id.cl_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById32, "itemView.findViewById(R.id.cl_topup)");
        this.f32703G = (ConstraintLayout) findViewById32;
        View findViewById33 = view.findViewById(R.id.tv_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById33, "itemView.findViewById(R.id.tv_topup)");
        this.f32704H = (TextView) findViewById33;
        View findViewById34 = view.findViewById(R.id.iv_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById34, "itemView.findViewById(R.id.iv_topup)");
        this.f32705I = (ImageView) findViewById34;
        View findViewById35 = view.findViewById(R.id.fl_root);
        Intrinsics.checkNotNullExpressionValue(findViewById35, "itemView.findViewById(R.id.fl_root)");
        this.f32706J = (FrameLayout) findViewById35;
        View findViewById36 = view.findViewById(R.id.tv_freeze_title);
        Intrinsics.checkNotNullExpressionValue(findViewById36, "itemView.findViewById(R.id.tv_freeze_title)");
        this.f32707K = (TextView) findViewById36;
        View findViewById37 = view.findViewById(R.id.tv_freeze_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById37, "itemView.findViewById(R.id.tv_freeze_desc)");
        this.f32708L = (TextView) findViewById37;
        View findViewById38 = view.findViewById(R.id.iv_freeze);
        Intrinsics.checkNotNullExpressionValue(findViewById38, "itemView.findViewById(R.id.iv_freeze)");
        this.f32709M = (ImageView) findViewById38;
        View findViewById39 = view.findViewById(R.id.iv_freeze_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById39, "itemView.findViewById(R.id.iv_freeze_icon)");
        this.f32710N = (ImageView) findViewById39;
        View findViewById40 = view.findViewById(R.id.iv_card_right);
        Intrinsics.checkNotNullExpressionValue(findViewById40, "itemView.findViewById(R.id.iv_card_right)");
        this.f32711O = (ImageView) findViewById40;
        View findViewById41 = view.findViewById(R.id.ll_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById41, "itemView.findViewById(R.id.ll_bottom)");
        this.f32712P = (LinearLayout) findViewById41;
        View findViewById42 = view.findViewById(R.id.iv_pay_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById42, "itemView.findViewById(R.id.iv_pay_logo)");
        this.f32713Q = (ImageView) findViewById42;
        View findViewById43 = view.findViewById(R.id.v_line);
        Intrinsics.checkNotNullExpressionValue(findViewById43, "itemView.findViewById(R.id.v_line)");
        this.f32714R = findViewById43;
        this.f32715S = R.drawable.ic_home_top_card_hide;
        this.f32716T = R.drawable.ic_home_top_card_open;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopCardViewHolder(View view, WalletHomeContract.V2Listener v2Listener) {
        this(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f32717a = v2Listener;
    }

    public final TextView getTvTitle() {
        return this.f32718b;
    }

    public final TextView getTvBalance() {
        return this.f32719c;
    }

    public final TextView getTvPrepaidNo() {
        return this.f32739w;
    }

    public final TextView getTvPrepaidDate() {
        return this.f32740x;
    }

    public final LinearLayout getLlPrepaidMsg() {
        return this.f32741y;
    }

    public final ImageView getIvPrepaid() {
        return this.f32742z;
    }

    public final TextView getTvPrepaidMsg() {
        return this.f32697A;
    }

    public final ConstraintLayout getClFreeze() {
        return this.f32701E;
    }

    public final ConstraintLayout getClCard() {
        return this.f32702F;
    }

    public final ConstraintLayout getClTopUp$wallet_globalRelease() {
        return this.f32703G;
    }

    public final TextView getTvTopUp() {
        return this.f32704H;
    }

    public final FrameLayout getFlRoot() {
        return this.f32706J;
    }

    public final TextView getTvFreezeTitle() {
        return this.f32707K;
    }

    public final TextView getTvFreezeDesc() {
        return this.f32708L;
    }

    public final ImageView getIvFreeze() {
        return this.f32709M;
    }

    public final ImageView getIvFreezeIcon() {
        return this.f32710N;
    }

    public final ImageView getIvCardRight() {
        return this.f32711O;
    }

    public final LinearLayout getLlBottom() {
        return this.f32712P;
    }

    public final ImageView getIvPayLogo() {
        return this.f32713Q;
    }

    public final View getViewLine() {
        return this.f32714R;
    }

    public final int getBalanceEyeShowDrawableId() {
        return this.f32715S;
    }

    public final void setBalanceEyeShowDrawableId(int i) {
        this.f32715S = i;
    }

    public final int getBalanceEycHideDrawableId() {
        return this.f32716T;
    }

    public final void setBalanceEycHideDrawableId(int i) {
        this.f32716T = i;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        WalletHomeFreeze.Companion.initFreezeStatus(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0428, code lost:
        if (r0.intValue() != 7) goto L_0x03d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0458  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0581  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x021d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData<com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.IData r13 = r13.getContentObj()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r13 = (com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data) r13
            if (r13 != 0) goto L_0x000f
            goto L_0x05d5
        L_0x000f:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeFreeze.Companion
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r1 = r13.getNewFreezeSection()
            r2 = 0
            if (r1 != 0) goto L_0x001a
            r1 = r2
            goto L_0x0020
        L_0x001a:
            int r1 = r1.freezeStatus
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0020:
            android.view.View r3 = r12.itemView
            android.content.Context r3 = r3.getContext()
            java.lang.String r4 = "itemView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.switchFreezeUIByStatus(r1, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.FreezeInterceptor r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.FreezeInterceptor.INSTANCE
            android.view.View r1 = r12.itemView
            android.content.Context r1 = r1.getContext()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$1 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$1
            r3.<init>(r12, r13)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r5 = 1
            r6 = 0
            r0.onInterceptor(r1, r5, r6, r3)
            android.view.View r0 = r12.itemView
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "wallet_home_public_msg"
            java.lang.String r0 = com.didi.payment.wallet.global.utils.WalletSPUtils.getPublicMessageId(r0, r1)
            java.lang.String r1 = "getPublicMessageId(itemV…\"wallet_home_public_msg\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0071
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BulletinBoardSection r1 = r13.getBulletinBoardSection()
            if (r1 != 0) goto L_0x0064
            r1 = r2
            goto L_0x0068
        L_0x0064:
            java.lang.String r1 = r1.getId()
        L_0x0068:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r0 = 0
            goto L_0x0072
        L_0x0071:
            r0 = 1
        L_0x0072:
            android.widget.FrameLayout r1 = r12.f32728l
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BulletinBoardSection r3 = r13.getBulletinBoardSection()
            if (r3 != 0) goto L_0x007c
            r3 = r2
            goto L_0x0080
        L_0x007c:
            java.lang.String r3 = r3.getTitle()
        L_0x0080:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r7 = 8
            if (r3 != 0) goto L_0x008e
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = 8
        L_0x0090:
            r1.setVisibility(r0)
            android.widget.FrameLayout r0 = r12.f32728l
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00a0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            r0.trackHomePublicMsgSW()
        L_0x00a0:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BulletinBoardSection r0 = r13.getBulletinBoardSection()
            if (r0 != 0) goto L_0x00a7
            goto L_0x00c9
        L_0x00a7:
            android.widget.TextView r1 = r12.f32729m
            java.lang.String r3 = r0.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            java.lang.String r0 = r0.getLinkUrl()
            if (r0 != 0) goto L_0x00b9
            goto L_0x00c7
        L_0x00b9:
            android.widget.TextView r1 = r12.f32729m
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$pLs8r3aayRb3qeOZilf6FIu4BVE r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$pLs8r3aayRb3qeOZilf6FIu4BVE
            r3.<init>(r0, r12)
            r1.setOnClickListener(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00c7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00c9:
            android.widget.ImageView r0 = r12.f32738v
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$rAcPjKtl8Tnv6SrbjAabRYkSaUk r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$rAcPjKtl8Tnv6SrbjAabRYkSaUk
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r12.getClFreeze()
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r1 = r13.getNewFreezeSection()
            if (r1 != 0) goto L_0x00df
            r1 = r2
            goto L_0x00e1
        L_0x00df:
            java.lang.String r1 = r1.title
        L_0x00e1:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00eb
            r1 = 0
            goto L_0x00ed
        L_0x00eb:
            r1 = 8
        L_0x00ed:
            r0.setVisibility(r1)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r13.getNewFreezeSection()
            if (r0 != 0) goto L_0x00f7
            goto L_0x011b
        L_0x00f7:
            android.widget.TextView r1 = r12.getTvFreezeTitle()
            java.lang.String r3 = r0.title
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r12.getTvFreezeDesc()
            java.lang.String r3 = r0.subTitle
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r12.getClFreeze()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$vYvnc6CfygdgADkj6FHYb_pIejM r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$vYvnc6CfygdgADkj6FHYb_pIejM
            r3.<init>(r12)
            r1.setOnClickListener(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x011b:
            android.widget.TextView r0 = r12.getTvTitle()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x0127
            r1 = r2
            goto L_0x012b
        L_0x0127:
            java.lang.String r1 = r1.getAccountSectionName()
        L_0x012b:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus.Companion
            boolean r1 = r1.isShowAmount()
            r0.element = r1
            boolean r1 = r0.element
            android.widget.TextView r3 = r12.getTvTitle()
            r12.switchAmountStatus(r1, r3)
            android.widget.TextView r1 = r12.getTvTitle()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bCZ1KDCph157276PmkzJ5kYrKyk r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bCZ1KDCph157276PmkzJ5kYrKyk
            r3.<init>(r0, r13, r13)
            r1.setOnClickListener(r3)
            android.widget.TextView r0 = r12.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x015e
        L_0x015c:
            r1 = r2
            goto L_0x0169
        L_0x015e:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountBalance r1 = r1.getAccountBalance()
            if (r1 != 0) goto L_0x0165
            goto L_0x015c
        L_0x0165:
            java.lang.String r1 = r1.getLocalBalance()
        L_0x0169:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r12.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus.Companion
            boolean r1 = r1.isShowAmount()
            if (r1 == 0) goto L_0x017d
            r1 = 1107820544(0x42080000, float:34.0)
            goto L_0x017f
        L_0x017d:
            r1 = 1106247680(0x41f00000, float:30.0)
        L_0x017f:
            r0.setTextSize(r1)
            android.widget.TextView r0 = r12.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$GacnbqPCbZ9SLwaCpqdF6EBfzu8 r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$GacnbqPCbZ9SLwaCpqdF6EBfzu8
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r12.getTvTopUp()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x019a
        L_0x0198:
            r1 = r2
            goto L_0x01a5
        L_0x019a:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Button r1 = r1.getButton()
            if (r1 != 0) goto L_0x01a1
            goto L_0x0198
        L_0x01a1:
            java.lang.String r1 = r1.getTitle()
        L_0x01a5:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x01b1
            goto L_0x01d2
        L_0x01b1:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Button r0 = r0.getButton()
            if (r0 != 0) goto L_0x01b8
            goto L_0x01d2
        L_0x01b8:
            java.lang.Boolean r0 = r0.getShowCoin()
            if (r0 != 0) goto L_0x01bf
            goto L_0x01d2
        L_0x01bf:
            boolean r0 = r0.booleanValue()
            android.widget.ImageView r1 = r12.f32705I
            if (r0 == 0) goto L_0x01c9
            r0 = 0
            goto L_0x01cb
        L_0x01c9:
            r0 = 8
        L_0x01cb:
            r1.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x01d2:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r12.getClTopUp$wallet_globalRelease()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$F0zgkNQXu7EgyO4mSDOp3fUxu6c r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$F0zgkNQXu7EgyO4mSDOp3fUxu6c
            r1.<init>(r12, r13)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r12.f32735s
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x01e8
        L_0x01e6:
            r1 = r2
            goto L_0x01f1
        L_0x01e8:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getAwardMessage()
            if (r1 != 0) goto L_0x01ef
            goto L_0x01e6
        L_0x01ef:
            java.lang.String r1 = r1.text
        L_0x01f1:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01fb
            r1 = 0
            goto L_0x01fd
        L_0x01fb:
            r1 = 8
        L_0x01fd:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r12.f32736t
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x020a
        L_0x0208:
            r1 = r2
            goto L_0x0213
        L_0x020a:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getCashBackMessage()
            if (r1 != 0) goto L_0x0211
            goto L_0x0208
        L_0x0211:
            java.lang.String r1 = r1.text
        L_0x0213:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x021d
            r1 = 0
            goto L_0x021f
        L_0x021d:
            r1 = 8
        L_0x021f:
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r12.f32737u
            android.widget.TextView r1 = r12.f32735s
            int r1 = r1.getVisibility()
            if (r1 != r7) goto L_0x0237
            android.widget.TextView r1 = r12.f32736t
            int r1 = r1.getVisibility()
            if (r1 != r7) goto L_0x0237
            r1 = 8
            goto L_0x0238
        L_0x0237:
            r1 = 0
        L_0x0238:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r12.f32720d
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x0245
        L_0x0243:
            r1 = r2
            goto L_0x024e
        L_0x0245:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getLocalDetailMessage()
            if (r1 != 0) goto L_0x024c
            goto L_0x0243
        L_0x024c:
            java.lang.String r1 = r1.text
        L_0x024e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0258
            r1 = 0
            goto L_0x025a
        L_0x0258:
            r1 = 8
        L_0x025a:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r12.f32720d
            int r1 = r0.getVisibility()
            if (r1 != 0) goto L_0x0270
            android.widget.LinearLayout r1 = r12.f32737u
            int r1 = r1.getVisibility()
            if (r1 != r7) goto L_0x0270
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT_BOLD
            goto L_0x0272
        L_0x0270:
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT
        L_0x0272:
            r0.setTypeface(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x027c
            goto L_0x02bd
        L_0x027c:
            com.didi.payment.base.view.PayRichInfo r1 = r0.getLocalDetailMessage()
            if (r1 != 0) goto L_0x0283
            goto L_0x0291
        L_0x0283:
            android.widget.TextView r3 = r12.f32720d
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r8 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r8.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r8 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r8
            r1.bindTextView(r3, r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0291:
            com.didi.payment.base.view.PayRichInfo r1 = r0.getAwardMessage()
            if (r1 != 0) goto L_0x0298
            goto L_0x02a6
        L_0x0298:
            android.widget.TextView r3 = r12.f32735s
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r8 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r8.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r8 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r8
            r1.bindTextView(r3, r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x02a6:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getCashBackMessage()
            if (r0 != 0) goto L_0x02ad
            goto L_0x02bb
        L_0x02ad:
            android.widget.TextView r1 = r12.f32736t
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r3 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r3.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r3 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r3
            r0.bindTextView(r1, r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02bb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02bd:
            android.widget.TextView r0 = r12.f32720d
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bUCsW7jkYt2BXzOJllmPPsEF-HA r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bUCsW7jkYt2BXzOJllmPPsEF-HA
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r12.f32735s
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ORx_4mAjNxqnHeZrqEs3z-1eCRg r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ORx_4mAjNxqnHeZrqEs3z-1eCRg
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r12.f32736t
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$10mZHEueXi6Wan9GbDGXbSgld-I r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$10mZHEueXi6Wan9GbDGXbSgld-I
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x02e3
        L_0x02e1:
            r0 = r2
            goto L_0x02f3
        L_0x02e3:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x02ea
            goto L_0x02e1
        L_0x02ea:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getStatusMessage()
            if (r0 != 0) goto L_0x02f1
            goto L_0x02e1
        L_0x02f1:
            java.lang.String r0 = r0.text
        L_0x02f3:
            android.widget.TextView r1 = r12.f32721e
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 6
            if (r0 != 0) goto L_0x0320
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x0306
        L_0x0304:
            r0 = 0
            goto L_0x031b
        L_0x0306:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x030d
            goto L_0x0304
        L_0x030d:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x0314
            goto L_0x0304
        L_0x0314:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            if (r0 != r3) goto L_0x0304
            r0 = 1
        L_0x031b:
            if (r0 == 0) goto L_0x031e
            goto L_0x0320
        L_0x031e:
            r0 = 0
            goto L_0x0322
        L_0x0320:
            r0 = 8
        L_0x0322:
            r1.setVisibility(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x032d
        L_0x032b:
            r0 = 0
            goto L_0x0342
        L_0x032d:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x0334
            goto L_0x032b
        L_0x0334:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x033b
            goto L_0x032b
        L_0x033b:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            if (r0 != r3) goto L_0x032b
            r0 = 1
        L_0x0342:
            r1 = 2
            if (r0 != 0) goto L_0x0386
            android.widget.TextView r0 = r12.f32721e
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r8 = r13.getAccountSection()
            if (r8 != 0) goto L_0x034e
            goto L_0x037d
        L_0x034e:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r8 = r8.getAccountStatusMessage()
            if (r8 != 0) goto L_0x0355
            goto L_0x037d
        L_0x0355:
            com.didi.payment.base.view.PayRichInfo r8 = r8.getStatusMessage()
            if (r8 != 0) goto L_0x035c
            goto L_0x037d
        L_0x035c:
            java.lang.String r9 = r8.text
            java.lang.String r10 = " "
            if (r9 != 0) goto L_0x0364
        L_0x0362:
            r9 = 0
            goto L_0x036b
        L_0x0364:
            boolean r9 = kotlin.text.StringsKt.endsWith$default(r9, r10, r6, r1, r2)
            if (r9 != 0) goto L_0x0362
            r9 = 1
        L_0x036b:
            if (r9 == 0) goto L_0x0379
            java.lang.String r9 = r8.text
            if (r9 != 0) goto L_0x0373
            r9 = r2
            goto L_0x0377
        L_0x0373:
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r10)
        L_0x0377:
            r8.text = r9
        L_0x0379:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L_0x037d:
            r8 = 2131233743(0x7f080bcf, float:1.8083632E38)
            r0.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r8, r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x038b
        L_0x0386:
            android.widget.TextView r0 = r12.f32721e
            r0.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r6, r6)
        L_0x038b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x0392
            goto L_0x03a7
        L_0x0392:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x0399
            goto L_0x03a7
        L_0x0399:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getStatusMessage()
            if (r0 != 0) goto L_0x03a0
            goto L_0x03a7
        L_0x03a0:
            android.widget.TextView r8 = r12.f32721e
            r0.bindTextView(r8, r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03a7:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x03af
        L_0x03ad:
            r0 = r2
            goto L_0x03c5
        L_0x03af:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x03b6
            goto L_0x03ad
        L_0x03b6:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x03bd
            goto L_0x03ad
        L_0x03bd:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x03c5:
            r8 = 2131233693(0x7f080b9d, float:1.808353E38)
            r9 = 2131233694(0x7f080b9e, float:1.8083533E38)
            r10 = 2131233692(0x7f080b9c, float:1.8083529E38)
            if (r0 != 0) goto L_0x03d1
            goto L_0x03db
        L_0x03d1:
            int r11 = r0.intValue()
            if (r11 != 0) goto L_0x03db
        L_0x03d7:
            r8 = 2131233692(0x7f080b9c, float:1.8083529E38)
            goto L_0x042b
        L_0x03db:
            if (r0 != 0) goto L_0x03de
            goto L_0x03e5
        L_0x03de:
            int r11 = r0.intValue()
            if (r11 != r5) goto L_0x03e5
            goto L_0x042b
        L_0x03e5:
            if (r0 != 0) goto L_0x03e8
            goto L_0x03f2
        L_0x03e8:
            int r11 = r0.intValue()
            if (r11 != r1) goto L_0x03f2
        L_0x03ee:
            r8 = 2131233694(0x7f080b9e, float:1.8083533E38)
            goto L_0x042b
        L_0x03f2:
            r1 = 3
            if (r0 != 0) goto L_0x03f6
            goto L_0x03fd
        L_0x03f6:
            int r11 = r0.intValue()
            if (r11 != r1) goto L_0x03fd
            goto L_0x03d7
        L_0x03fd:
            r1 = 4
            if (r0 != 0) goto L_0x0401
            goto L_0x0408
        L_0x0401:
            int r11 = r0.intValue()
            if (r11 != r1) goto L_0x0408
            goto L_0x042b
        L_0x0408:
            r1 = 5
            if (r0 != 0) goto L_0x040c
            goto L_0x0413
        L_0x040c:
            int r8 = r0.intValue()
            if (r8 != r1) goto L_0x0413
            goto L_0x03ee
        L_0x0413:
            if (r0 != 0) goto L_0x0416
            goto L_0x0420
        L_0x0416:
            int r1 = r0.intValue()
            if (r1 != r3) goto L_0x0420
            r8 = 2131233691(0x7f080b9b, float:1.8083527E38)
            goto L_0x042b
        L_0x0420:
            r1 = 7
            if (r0 != 0) goto L_0x0424
            goto L_0x03d7
        L_0x0424:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x03d7
            goto L_0x03ee
        L_0x042b:
            android.widget.TextView r0 = r12.f32721e
            r0.setBackgroundResource(r8)
            android.widget.TextView r0 = r12.f32721e
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$K5G5iJNNd1IaxnEdIfOGiHcLziE r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$K5G5iJNNd1IaxnEdIfOGiHcLziE
            r1.<init>(r12, r13)
            r0.setOnClickListener(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x0442
            goto L_0x0509
        L_0x0442:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BankCard r0 = r0.getBankCard()
            if (r0 != 0) goto L_0x044a
            goto L_0x0509
        L_0x044a:
            java.lang.String r1 = r0.getCardNum()
            if (r1 != 0) goto L_0x0452
            r1 = 0
            goto L_0x0456
        L_0x0452:
            int r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r1, r6, r5, r2)
        L_0x0456:
            if (r1 <= 0) goto L_0x04c6
            android.widget.LinearLayout r1 = r12.f32726j
            r1.setVisibility(r6)
            android.widget.FrameLayout r1 = r12.f32732p
            r1.setVisibility(r7)
            android.widget.TextView r1 = r12.f32722f
            java.lang.String r3 = r0.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r12.f32723g
            java.lang.String r3 = r0.getLocalCardNum()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeController.Companion
            android.view.View r3 = r12.itemView
            android.content.Context r3 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$15$gifResult$1 r8 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder$onBindViewHolder$1$15$gifResult$1.INSTANCE
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$15$gifResult$2 r9 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder$onBindViewHolder$1$15$gifResult$2.INSTANCE
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            java.lang.String r10 = "0"
            java.lang.String r1 = r1.getGifApollo(r3, r8, r9, r10)
            android.view.View r3 = r12.itemView
            android.content.Context r3 = r3.getContext()
            java.lang.String r8 = "card_red_bot"
            java.lang.String r3 = com.didi.payment.wallet.global.utils.WalletSPUtils.getHomeCardRedBot(r3, r8)
            android.view.View r8 = r12.f32700D
            java.lang.String r9 = "1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x04c0
            java.lang.String r1 = r0.getRedDot()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04c0
            java.lang.String r1 = r0.getRedDot()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x04be
            goto L_0x04c0
        L_0x04be:
            r1 = 0
            goto L_0x04c2
        L_0x04c0:
            r1 = 8
        L_0x04c2:
            r8.setVisibility(r1)
            goto L_0x04f3
        L_0x04c6:
            android.widget.LinearLayout r1 = r12.f32726j
            r1.setVisibility(r7)
            android.widget.FrameLayout r1 = r12.f32732p
            r1.setVisibility(r6)
            android.widget.TextView r1 = r12.f32734r
            java.lang.String r3 = r0.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r12.f32733q
            r1.setVisibility(r7)
            com.didi.payment.base.view.PayRichInfo r1 = r0.getPromotionText()
            if (r1 != 0) goto L_0x04e7
            goto L_0x04f3
        L_0x04e7:
            android.widget.TextView r3 = r12.f32733q
            r3.setVisibility(r6)
            android.widget.TextView r3 = r12.f32733q
            r1.bindTextView(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x04f3:
            android.widget.LinearLayout r1 = r12.f32726j
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$CkSTfCM_FnxiQXDDBN1bPukuOCk r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$CkSTfCM_FnxiQXDDBN1bPukuOCk
            r3.<init>(r0, r13)
            r1.setOnClickListener(r3)
            android.widget.FrameLayout r1 = r12.f32732p
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$b2wByS3C3jm9wWx0Q_AsJ6VC5j4 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$b2wByS3C3jm9wWx0Q_AsJ6VC5j4
            r3.<init>(r0, r13)
            r1.setOnClickListener(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0509:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r13.getAccountSection()
            if (r0 != 0) goto L_0x0510
            goto L_0x0567
        L_0x0510:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Coupon r0 = r0.getCoupon()
            if (r0 != 0) goto L_0x0517
            goto L_0x0567
        L_0x0517:
            android.widget.TextView r1 = r12.f32724h
            java.lang.String r3 = r0.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r12.f32725i
            java.lang.String r3 = r0.getLocalCouponNum()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeController.Companion
            android.view.View r3 = r12.itemView
            android.content.Context r3 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r8 = r0.getLastCouponTime()
            boolean r1 = r1.isShowCouponRedDot(r3, r8)
            if (r1 == 0) goto L_0x0556
            java.lang.String r1 = r0.getCouponNum()
            if (r1 != 0) goto L_0x054a
            r1 = 0
            goto L_0x054e
        L_0x054a:
            int r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r1, r6, r5, r2)
        L_0x054e:
            if (r1 <= 0) goto L_0x0556
            android.view.View r1 = r12.f32731o
            r1.setVisibility(r6)
            goto L_0x055b
        L_0x0556:
            android.view.View r1 = r12.f32731o
            r1.setVisibility(r7)
        L_0x055b:
            android.widget.LinearLayout r1 = r12.f32727k
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ZwbqmY2X8i6EUONk915Du1NYeP0 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ZwbqmY2X8i6EUONk915Du1NYeP0
            r3.<init>(r0, r13)
            r1.setOnClickListener(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0567:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.QuickFunctionSection r0 = r13.getQuickFunctionSection()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r13.getAccountSection()
            if (r1 != 0) goto L_0x0573
        L_0x0571:
            r1 = r2
            goto L_0x0589
        L_0x0573:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r1 = r1.getAccountStatusMessage()
            if (r1 != 0) goto L_0x057a
            goto L_0x0571
        L_0x057a:
            java.lang.String r1 = r1.getStatus()
            if (r1 != 0) goto L_0x0581
            goto L_0x0571
        L_0x0581:
            int r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r1, r6, r5, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0589:
            r12.m23132a(r0, r1)
            android.widget.ImageView r0 = r12.f32699C
            r0.setVisibility(r7)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeController.Companion
            android.view.View r1 = r12.itemView
            android.content.Context r1 = r1.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r3 = r13.getAccountSection()
            if (r3 != 0) goto L_0x05a3
            goto L_0x05b5
        L_0x05a3:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BankCard r3 = r3.getBankCard()
            if (r3 != 0) goto L_0x05aa
            goto L_0x05b5
        L_0x05aa:
            java.lang.String r3 = r3.getCardNum()
            if (r3 != 0) goto L_0x05b1
            goto L_0x05b5
        L_0x05b1:
            int r6 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r3, r6, r5, r2)
        L_0x05b5:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$17 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$17
            r2.<init>(r12)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.executeAddCardGif(r1, r6, r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            android.view.View r1 = r12.itemView
            android.content.Context r1 = r1.getContext()
            r0.trackHomeCardSW(r1, r13, r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.QuickFunctionSection r13 = r13.getQuickFunctionSection()
            r0.trackQuickFunctionSW(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
        L_0x05d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder.onBindViewHolder(com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeHolderData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23133a(String str, TopCardViewHolder topCardViewHolder, View view) {
        Intrinsics.checkNotNullParameter(str, "$link");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Uri parse = Uri.parse(str);
        String findUrlStrParam = WalletUriParam.Companion.findUrlStrParam(parse, "crashPageTitle");
        String findUrlStrParam2 = WalletUriParam.Companion.findUrlStrParam(parse, "crashPageText");
        Request request = (Request) ((Request) ((Request) DRouter.build(str).putExtra(WalletExtraConstant.Key.CRASH_PAGE_TITLE, findUrlStrParam)).putExtra(WalletExtraConstant.Key.CRASH_PAGE_SUBTITLE, findUrlStrParam2)).putExtra(WalletExtraConstant.Key.CRASH_TYPE, WalletUriParam.Companion.findUrlStrParam(parse, "crashType"));
        Context context = topCardViewHolder.itemView.getContext();
        if (context != null) {
            request.start(((ContextThemeWrapper) context).getBaseContext());
            WalletHomeTrackerManager.Companion.trackHomePublicMsgCK();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23128a(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        topCardViewHolder.f32728l.setVisibility(8);
        Context context = topCardViewHolder.itemView.getContext();
        BulletinBoardSection bulletinBoardSection = data.getBulletinBoardSection();
        WalletSPUtils.savePublicMessageId(context, "wallet_home_public_msg", bulletinBoardSection == null ? null : bulletinBoardSection.getId());
        WalletHomeTrackerManager.Companion.trackHomePublicMsgClose();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23125a(AccountFreezeData accountFreezeData, TopCardViewHolder topCardViewHolder, View view) {
        Intrinsics.checkNotNullParameter(accountFreezeData, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Request build = DRouter.build(accountFreezeData.link);
        Context context = topCardViewHolder.itemView.getContext();
        if (context != null) {
            build.start(((ContextThemeWrapper) context).getBaseContext());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23130a(TopCardViewHolder topCardViewHolder, Ref.BooleanRef booleanRef, Data data, Data data2, View view) {
        PrepaidStatus marketingArea;
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(booleanRef, "$amountStatus");
        Intrinsics.checkNotNullParameter(data2, "$this_apply");
        topCardViewHolder.switchAmountStatus(!booleanRef.element, topCardViewHolder.getTvTitle());
        WalletHomeAmountStatus.Companion.saveAmountStatus(!booleanRef.element);
        booleanRef.element = !booleanRef.element;
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onRefreshUI();
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "balance_eye");
        WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
        AccountSection accountSection = data2.getAccountSection();
        Integer num = null;
        if (!(accountSection == null || (marketingArea = accountSection.getMarketingArea()) == null)) {
            num = marketingArea.getType();
        }
        companion.trackCardPrepaidApply(num, "fin_prepaidcard_cardvisible_ck", Integer.valueOf(booleanRef.element ? 1 : 0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23135b(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23131a(Data data, TopCardViewHolder topCardViewHolder, Data data2, View view) {
        Button button;
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        AccountSection accountSection = data.getAccountSection();
        if (accountSection != null && (button = accountSection.getButton()) != null) {
            FreezeInterceptor.dispatchClickEvent$default(FreezeInterceptor.INSTANCE, new TopCardViewHolder$onBindViewHolder$1$8$1$1(topCardViewHolder, button, data, data2), new TopCardViewHolder$onBindViewHolder$1$8$1$2(topCardViewHolder, button), (Function0) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m23137c(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m23138d(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m23139e(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23136b(Data data, TopCardViewHolder topCardViewHolder, Data data2, View view) {
        AccountStatusMessage accountStatusMessage;
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        AccountSection accountSection = data.getAccountSection();
        if (accountSection != null && (accountStatusMessage = accountSection.getAccountStatusMessage()) != null) {
            Request request = (Request) DRouter.build(accountStatusMessage.getLinkUrl()).putExtra("accountSection", (Serializable) data.getAccountSection());
            Context context = topCardViewHolder.itemView.getContext();
            if (context != null) {
                request.start(((ContextThemeWrapper) context).getBaseContext());
                EventBus.getDefault().post(new WalletRefreshDataEvent());
                WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data2, LoginOmegaUtil.NEED_VERIFY_EMAIL);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23126a(TopCardViewHolder topCardViewHolder, BankCard bankCard, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(bankCard, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onBankListClick(bankCard.getLinkUrl());
        }
        WalletSPUtils.setHomeCardRedBot(topCardViewHolder.itemView.getContext(), "card_red_bot", bankCard.getRedDot());
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "cardbind");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23134b(TopCardViewHolder topCardViewHolder, BankCard bankCard, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(bankCard, "$this_apply");
        WalletHomeContract.V2Listener v2Listener = topCardViewHolder.f32717a;
        if (v2Listener != null) {
            v2Listener.onBankListClick(bankCard.getLinkUrl());
        }
        if (topCardViewHolder.f32699C.getVisibility() == 0) {
            Drawable drawable = topCardViewHolder.f32699C.getDrawable();
            GifDrawable gifDrawable = drawable instanceof GifDrawable ? (GifDrawable) drawable : null;
            boolean z = true;
            if (gifDrawable == null || !gifDrawable.isRunning()) {
                z = false;
            }
            if (z) {
                gifDrawable.stop();
            }
            topCardViewHolder.f32699C.setVisibility(8);
            topCardViewHolder.f32698B.setVisibility(0);
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "cardbind");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23127a(TopCardViewHolder topCardViewHolder, Coupon coupon, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(coupon, "$this_apply");
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, topCardViewHolder.itemView.getContext(), 2, false, new TopCardViewHolder$onBindViewHolder$1$16$1$1(coupon, topCardViewHolder, data), 4, (Object) null);
    }

    public final void switchAmountStatus(boolean z, TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "tvTitle");
        int i = z ? this.f32715S : this.f32716T;
        if (Build.VERSION.SDK_INT >= 21) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.itemView.getContext().getResources().getDrawable(i, (Resources.Theme) null), (Drawable) null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.itemView.getContext().getResources().getDrawable(i), (Drawable) null);
        }
    }

    /* renamed from: a */
    private final void m23132a(QuickFunctionSection quickFunctionSection, Integer num) {
        List<Entry> entryList;
        if (quickFunctionSection != null && (entryList = quickFunctionSection.getEntryList()) != null) {
            Map linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (Object next : entryList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Entry entry = (Entry) next;
                int i3 = i / 3;
                if (linkedHashMap.get(Integer.valueOf(i3)) == null) {
                    linkedHashMap.put(Integer.valueOf(i3), new ArrayList());
                }
                List list = (List) linkedHashMap.get(Integer.valueOf(i3));
                if (list != null) {
                    list.add(entry);
                }
                i = i2;
            }
            this.f32730n.removeAllViews();
            for (Map.Entry value : linkedHashMap.entrySet()) {
                LinearLayout linearLayout = new LinearLayout(this.itemView.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, UIUtils.dip2px(this.itemView.getContext(), 69.0f));
                linearLayout.setOrientation(0);
                int dip2px = UIUtils.dip2px(this.itemView.getContext(), 12.0f);
                layoutParams.leftMargin = dip2px;
                layoutParams.rightMargin = dip2px;
                linearLayout.setLayoutParams(layoutParams);
                for (Entry entry2 : (Iterable) value.getValue()) {
                    LinearLayout linearLayout2 = new LinearLayout(this.itemView.getContext());
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((UIUtils.getScreenWidth(this.itemView.getContext()) - (dip2px * 2)) / 3, -1);
                    linearLayout2.setGravity(17);
                    linearLayout2.setLayoutParams(layoutParams2);
                    linearLayout2.setOrientation(1);
                    ImageView imageView = new ImageView(this.itemView.getContext());
                    int dip2px2 = UIUtils.dip2px(this.itemView.getContext(), 24.0f);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(dip2px2, dip2px2));
                    GlideUtils.with2load2into(this.itemView.getContext(), entry2.getIconUrl(), imageView);
                    linearLayout2.addView(imageView);
                    TextView textView = new TextView(this.itemView.getContext());
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    textView.setLayoutParams(layoutParams3);
                    layoutParams3.topMargin = UIUtils.dip2px(this.itemView.getContext(), 8.0f);
                    textView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.wallet_color_000000));
                    textView.setTextSize(14.0f);
                    textView.setText(entry2.getName());
                    linearLayout2.addView(textView);
                    linearLayout2.setOnClickListener(new View.OnClickListener(entry2, num) {
                        public final /* synthetic */ Entry f$1;
                        public final /* synthetic */ Integer f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            TopCardViewHolder.m23129a(TopCardViewHolder.this, this.f$1, this.f$2, view);
                        }
                    });
                    linearLayout.addView(linearLayout2);
                }
                this.f32730n.addView(linearLayout);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23129a(TopCardViewHolder topCardViewHolder, Entry entry, Integer num, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(entry, "$entry");
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, topCardViewHolder.itemView.getContext(), 1, false, new TopCardViewHolder$layoutQuickFunction$1$2$1$1$1(entry, num, topCardViewHolder), 4, (Object) null);
    }
}
