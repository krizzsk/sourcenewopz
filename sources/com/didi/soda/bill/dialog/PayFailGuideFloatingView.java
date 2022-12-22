package com.didi.soda.bill.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.button.RFStyleButton;
import com.didi.rfusion.widget.floating.RFFloating;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertBtnEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertExtraEntity;
import com.didi.soda.customer.foundation.util.CenterImageSpan;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.MaxHeightScrollView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ$\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010%\u001a\u00020\u00002\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fJ\u001c\u0010&\u001a\u00020\u00002\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u0011J@\u0010'\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/PayFailGuideFloatingView;", "Lcom/didi/rfusion/widget/floating/RFFloating;", "()V", "btnGroupView", "Landroid/view/View;", "contentView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "firstBtnView", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mContentView", "otherPayCallback", "Lkotlin/Function0;", "", "Lcom/didi/soda/bill/dialog/OtherPayCallback;", "recommendPayCallback", "Lcom/didi/soda/bill/dialog/RecommendPayCallback;", "scrollView", "Lcom/didi/soda/customer/widget/MaxHeightScrollView;", "secondBtnView", "Lcom/didi/rfusion/widget/button/RFGhostButton;", "initBtns", "btns", "", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertBtnEntity;", "extraEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertExtraEntity;", "initData", "initView", "onCreate", "view", "setAlertEntity", "setBtnText", "btnView", "Lcom/didi/rfusion/widget/button/RFStyleButton;", "btnEntity", "setOtherPayCallback", "setRecommendCallback", "textFormat", "content", "", "channel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "isGrey", "", "isNetWork", "drawable", "Landroid/graphics/drawable/Drawable;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayFailGuideFloatingView.kt */
public final class PayFailGuideFloatingView extends RFFloating {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final String f38993j = "{{pay_name}}";

    /* renamed from: k */
    private static final String f38994k = "{{pay_logo}}";

    /* renamed from: n */
    private static final float f38995n = 30.0f;

    /* renamed from: o */
    private static final float f38996o = 18.0f;

    /* renamed from: a */
    private View f38997a;

    /* renamed from: b */
    private RFMainButton f38998b;

    /* renamed from: c */
    private RFGhostButton f38999c;

    /* renamed from: d */
    private View f39000d;

    /* renamed from: e */
    private CustomerAppCompatTextView f39001e;

    /* renamed from: f */
    private MaxHeightScrollView f39002f;

    /* renamed from: g */
    private Function0<Unit> f39003g;

    /* renamed from: h */
    private Function0<Unit> f39004h;

    /* renamed from: i */
    private AlertEntity f39005i;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/PayFailGuideFloatingView$Companion;", "", "()V", "LOGO_HEIGHT", "", "LOGO_WIDTH", "PAY_LOGO", "", "PAY_NAME", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayFailGuideFloatingView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        m27688b();
        View view2 = this.f38997a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(1);
        m27690c();
    }

    /* renamed from: b */
    private final void m27688b() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_widget_pay_fail_guide, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f38997a = inflate;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_tv_common_first);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…customer_tv_common_first)");
        this.f38998b = (RFMainButton) findViewById;
        View view = this.f38997a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.customer_tv_common_second);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI…ustomer_tv_common_second)");
        this.f38999c = (RFGhostButton) findViewById2;
        View view2 = this.f38997a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.customer_ll_bottom_btns);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI….customer_ll_bottom_btns)");
        this.f39000d = findViewById3;
        View view3 = this.f38997a;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.customer_ll_common_dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewByI…ll_common_dialog_content)");
        this.f39001e = (CustomerAppCompatTextView) findViewById4;
        View view4 = this.f38997a;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.customer_sv_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewByI…id.customer_sv_container)");
        this.f39002f = (MaxHeightScrollView) findViewById5;
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f39001e;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            customerAppCompatTextView = customerAppCompatTextView2;
        }
        customerAppCompatTextView.setMinHeight(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_560));
    }

    /* renamed from: c */
    private final void m27690c() {
        AlertEntity alertEntity = this.f39005i;
        if (alertEntity != null) {
            AlertExtraEntity alertExtraEntity = null;
            if (alertEntity.getContent() != null) {
                CustomerAppCompatTextView customerAppCompatTextView = this.f39001e;
                if (customerAppCompatTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    customerAppCompatTextView = null;
                }
                View view = customerAppCompatTextView;
                String content = alertEntity.getContent();
                AlertExtraEntity extra = alertEntity.getExtra();
                m27684a(view, content, extra == null ? null : extra.payFailedChannel, true, false, (Drawable) null);
            }
            List<AlertBtnEntity> btnList = alertEntity.getBtnList();
            AlertEntity alertEntity2 = this.f39005i;
            if (alertEntity2 != null) {
                alertExtraEntity = alertEntity2.getExtra();
            }
            m27687a(btnList, alertExtraEntity);
            if (getNavBar() != null) {
                getNavBar().setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PayFailGuideFloatingView.m27686a(PayFailGuideFloatingView.this, view);
                    }
                }).build());
                getNavBar().setTitle(new RFFloatingTextAttr.Builder(alertEntity.getTitle()).build());
                getNavBar().setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27686a(PayFailGuideFloatingView payFailGuideFloatingView, View view) {
        Intrinsics.checkNotNullParameter(payFailGuideFloatingView, "this$0");
        payFailGuideFloatingView.dismiss();
    }

    /* renamed from: a */
    private final void m27687a(List<AlertBtnEntity> list, AlertExtraEntity alertExtraEntity) {
        if (list != null) {
            View view = this.f39000d;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnGroupView");
                view = null;
            }
            view.setVisibility(0);
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AlertBtnEntity alertBtnEntity = (AlertBtnEntity) next;
                if (i == 0) {
                    RFMainButton rFMainButton = this.f38998b;
                    if (rFMainButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("firstBtnView");
                        rFMainButton = null;
                    }
                    rFMainButton.setVisibility(0);
                    RFMainButton rFMainButton2 = this.f38998b;
                    if (rFMainButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("firstBtnView");
                        rFMainButton2 = null;
                    }
                    m27685a(rFMainButton2, alertBtnEntity, alertExtraEntity);
                } else if (i == 1) {
                    RFGhostButton rFGhostButton = this.f38999c;
                    if (rFGhostButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secondBtnView");
                        rFGhostButton = null;
                    }
                    rFGhostButton.setVisibility(0);
                    RFGhostButton rFGhostButton2 = this.f38999c;
                    if (rFGhostButton2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secondBtnView");
                        rFGhostButton2 = null;
                    }
                    m27685a(rFGhostButton2, alertBtnEntity, alertExtraEntity);
                }
                i = i2;
            }
        }
    }

    /* renamed from: a */
    private final void m27685a(RFStyleButton rFStyleButton, AlertBtnEntity alertBtnEntity, AlertExtraEntity alertExtraEntity) {
        if (alertBtnEntity != null) {
            if (Intrinsics.areEqual((Object) alertBtnEntity.getAction(), (Object) AlertBtnEntity.ACTION_RECOMMEND_PAY)) {
                m27684a(rFStyleButton, alertBtnEntity.getDesc(), alertExtraEntity == null ? null : alertExtraEntity.payChannel, false, false, (Drawable) null);
                Unit.INSTANCE.toString();
                rFStyleButton.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PayFailGuideFloatingView.m27689b(PayFailGuideFloatingView.this, view);
                    }
                });
            } else if (Intrinsics.areEqual((Object) alertBtnEntity.getAction(), (Object) AlertBtnEntity.ACTION_OTHER_PAY)) {
                String desc = alertBtnEntity.getDesc();
                if (desc == null) {
                    desc = "";
                }
                rFStyleButton.setText(desc);
                rFStyleButton.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PayFailGuideFloatingView.m27691c(PayFailGuideFloatingView.this, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27689b(PayFailGuideFloatingView payFailGuideFloatingView, View view) {
        Intrinsics.checkNotNullParameter(payFailGuideFloatingView, "this$0");
        Function0<Unit> function0 = payFailGuideFloatingView.f39004h;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m27691c(PayFailGuideFloatingView payFailGuideFloatingView, View view) {
        Intrinsics.checkNotNullParameter(payFailGuideFloatingView, "this$0");
        Function0<Unit> function0 = payFailGuideFloatingView.f39003g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27684a(View view, String str, PayChannelEntity payChannelEntity, boolean z, boolean z2, Drawable drawable) {
        String str2;
        String str3;
        String str4;
        String str5;
        View view2 = view;
        PayChannelEntity payChannelEntity2 = payChannelEntity;
        String str6 = str == null ? "" : str;
        boolean z3 = false;
        String str7 = null;
        if (StringsKt.contains$default((CharSequence) str6, (CharSequence) f38993j, false, 2, (Object) null)) {
            if (payChannelEntity2 == null) {
                str3 = null;
            } else {
                str3 = payChannelEntity2.cardSuffix;
            }
            CharSequence charSequence = str3;
            if (!(charSequence == null || charSequence.length() == 0) && (Intrinsics.areEqual((Object) charSequence, (Object) "null") ^ true)) {
                str4 = payChannelEntity2 == null ? null : payChannelEntity2.cardSuffix;
            } else if (payChannelEntity2 == null || (str4 = payChannelEntity2.channelName) == null) {
                str4 = "";
            }
            if (str4 == null) {
                str5 = "";
            } else {
                str5 = str4;
            }
            str6 = StringsKt.replace$default(str6, f38993j, str5, false, 4, (Object) null);
        }
        CharSequence charSequence2 = str6;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        if (StringsKt.contains$default(charSequence2, (CharSequence) f38994k, false, 2, (Object) null)) {
            int i = z ? R.drawable.customer_bill_pay_card_placeholder_grey : R.drawable.customer_bill_pay_card_placeholder_white;
            int indexOf$default = StringsKt.indexOf$default(charSequence2, f38994k, 0, false, 6, (Object) null);
            Drawable drawable2 = drawable == null ? ContextCompat.getDrawable(this, i) : drawable;
            if (drawable2 != null) {
                Context context = this;
                drawable2.setBounds(0, 0, DisplayUtils.dip2px(context, 30.0f), DisplayUtils.dip2px(context, 18.0f));
            }
            spannableStringBuilder.setSpan(new CenterImageSpan(drawable2), indexOf$default, indexOf$default + 12, 17);
            if (payChannelEntity2 == null) {
                str2 = null;
            } else {
                str2 = payChannelEntity2.cardOrg;
            }
            CharSequence charSequence3 = str2;
            if (!(charSequence3 == null || charSequence3.length() == 0) && (!Intrinsics.areEqual((Object) charSequence3, (Object) "null"))) {
                z3 = true;
            }
            if (z3 && !z2) {
                Context context2 = this;
                FitType fitType = FitType.FIT_None;
                if (payChannelEntity2 != null) {
                    str7 = payChannelEntity2.cardOrg;
                }
                FlyImageLoader.loadImageDownLoadOnly(context2, fitType, str7).downloadOnly(new PayFailGuideFloatingView$textFormat$1(this, view, str, payChannelEntity, z));
            }
        }
        if (view2 instanceof CustomerAppCompatTextView) {
            ((CustomerAppCompatTextView) view2).setText(spannableStringBuilder);
        } else if (view2 instanceof RFStyleButton) {
            ((RFStyleButton) view2).setText(spannableStringBuilder);
        }
    }

    public final PayFailGuideFloatingView setAlertEntity(AlertEntity alertEntity) {
        this.f39005i = alertEntity;
        return this;
    }

    public final PayFailGuideFloatingView setRecommendCallback(Function0<Unit> function0) {
        this.f39004h = function0;
        return this;
    }

    public final PayFailGuideFloatingView setOtherPayCallback(Function0<Unit> function0) {
        this.f39003g = function0;
        return this;
    }
}
