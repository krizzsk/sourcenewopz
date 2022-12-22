package com.didi.sdk.global.sign.payselect.module;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.module.PaySelModuleMgr;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtils;
import com.didi.sdk.global.util.PayUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/MainGroupModule;", "Lcom/didi/sdk/global/sign/payselect/module/GroupBaseModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "groupData", "Lcom/didi/sdk/global/sign/model/local/PaySelGroupData;", "llContainer", "Landroidx/appcompat/widget/LinearLayoutCompat;", "mFrozenContainer", "mGroupTitle", "Landroid/widget/TextView;", "mIvGroupIcon", "Landroid/widget/ImageView;", "mIvGroupRightTopIcon", "mTvFrozenTitle", "bindData", "", "data", "type", "initView", "onClickFrozen", "frozenData", "Lcom/didi/payment/commonsdk/basemodel/account/AccountFreezeData;", "updateFrozenArea", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MainGroupModule.kt */
public final class MainGroupModule extends GroupBaseModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f36263a;

    /* renamed from: b */
    private ImageView f36264b;

    /* renamed from: c */
    private TextView f36265c;

    /* renamed from: d */
    private TextView f36266d;

    /* renamed from: e */
    private ViewGroup f36267e;

    /* renamed from: f */
    private LinearLayoutCompat f36268f;

    /* renamed from: g */
    private PaySelGroupData f36269g;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/MainGroupModule$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/sign/payselect/module/MainGroupModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MainGroupModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MainGroupModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new MainGroupModule(fragmentActivity, viewGroup, R.layout.payment_paysel_main_group_view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainGroupModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    public void initView() {
        getRootView().setBackgroundResource(PayUtils.INSTANCE.isBrazilClient(getContext()) ? R.drawable.payment_paysel_main_group_bg_99 : R.drawable.payment_paysel_main_group_bg_global);
        View findViewById = getRootView().findViewById(R.id.paysel_main_group_right_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…el_main_group_right_icon)");
        this.f36264b = (ImageView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.gpay_method_list_group_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…y_method_list_group_icon)");
        this.f36263a = (ImageView) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.gpay_method_list_group_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…_method_list_group_title)");
        this.f36265c = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.paysel_main_items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…sel_main_items_container)");
        this.f36268f = (LinearLayoutCompat) findViewById4;
        View findViewById5 = getRootView().findViewById(R.id.paysel_main_group_frozen_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…_main_group_frozen_title)");
        this.f36266d = (TextView) findViewById5;
        View findViewById6 = getRootView().findViewById(R.id.paysel_main_group_frozen_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.…n_group_frozen_container)");
        this.f36267e = (ViewGroup) findViewById6;
    }

    public void bindData(PaySelGroupData paySelGroupData, int i) {
        Intrinsics.checkNotNullParameter(paySelGroupData, "data");
        if (!CollectionUtil.isEmpty((Collection) paySelGroupData.itemList)) {
            this.f36269g = paySelGroupData;
            LinearLayoutCompat linearLayoutCompat = this.f36268f;
            if (linearLayoutCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llContainer");
                linearLayoutCompat = null;
            }
            linearLayoutCompat.removeAllViews();
            getItemModules().clear();
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            ImageView imageView = this.f36263a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvGroupIcon");
                imageView = null;
            }
            nViewUtils.setImage(imageView, paySelGroupData.iconUrl);
            if (PaySelUtils.INSTANCE.isFrozenMode(paySelGroupData.accountFreezeData)) {
                getRootView().setBackgroundResource(R.drawable.payment_paysel_main_group_bg_frozen);
                ImageView imageView2 = this.f36264b;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvGroupRightTopIcon");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.payment_paysel_main_group_icon_frozen);
                TextView textView = this.f36265c;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGroupTitle");
                    textView = null;
                }
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                AccountFreezeData accountFreezeData = paySelGroupData.accountFreezeData;
                Intrinsics.checkNotNull(accountFreezeData);
                m25651a(accountFreezeData);
            } else {
                ViewGroup viewGroup = this.f36267e;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFrozenContainer");
                    viewGroup = null;
                }
                viewGroup.setVisibility(8);
                ImageView imageView3 = this.f36264b;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvGroupRightTopIcon");
                    imageView3 = null;
                }
                imageView3.setImageResource(R.drawable.payment_paysel_main_group_icon_dollar);
                if (PayUtils.INSTANCE.isBrazilClient(getContext())) {
                    TextView textView2 = this.f36265c;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGroupTitle");
                        textView2 = null;
                    }
                    textView2.setTextColor(Color.parseColor("#000000"));
                    getRootView().setBackgroundResource(R.drawable.payment_paysel_main_group_bg_99);
                } else {
                    TextView textView3 = this.f36265c;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGroupTitle");
                        textView3 = null;
                    }
                    textView3.setTextColor(Color.parseColor("#FFFFFF"));
                    getRootView().setBackgroundResource(R.drawable.payment_paysel_main_group_bg_global);
                }
            }
            NViewUtils nViewUtils2 = NViewUtils.INSTANCE;
            TextView textView4 = this.f36265c;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGroupTitle");
                textView4 = null;
            }
            nViewUtils2.setText(textView4, paySelGroupData.name);
            List<PaySelItemData> list = paySelGroupData.itemList;
            Intrinsics.checkNotNullExpressionValue(list, FirebaseAnalytics.Param.ITEMS);
            for (PaySelItemData paySelItemData : list) {
                paySelItemData.iconUrl = "";
                PaySelModuleMgr.Companion companion = PaySelModuleMgr.Companion;
                FragmentActivity activity = getActivity();
                LinearLayoutCompat linearLayoutCompat2 = this.f36268f;
                if (linearLayoutCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llContainer");
                    linearLayoutCompat2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(paySelItemData, "it");
                BizModule<PaySelItemData> create = companion.create(activity, linearLayoutCompat2, paySelItemData);
                BizModule.bindData$default(create, paySelItemData, 0, 2, (Object) null);
                if (create instanceof IPayModule) {
                    getItemModules().add(create);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m25651a(AccountFreezeData accountFreezeData) {
        ViewGroup viewGroup = this.f36267e;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFrozenContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        TextView textView = this.f36266d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFrozenTitle");
            textView = null;
        }
        textView.setText(accountFreezeData.getTitle(0));
        if (!accountFreezeData.isJumpable(0)) {
            TextView textView2 = this.f36266d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFrozenTitle");
                textView2 = null;
            }
            textView2.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ViewGroup viewGroup3 = this.f36267e;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFrozenContainer");
                viewGroup3 = null;
            }
            viewGroup3.setOnClickListener((View.OnClickListener) null);
            return;
        }
        TextView textView3 = this.f36266d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFrozenTitle");
            textView3 = null;
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R.drawable.payment_paysel_right_arrow_white), (Drawable) null);
        ViewGroup viewGroup4 = this.f36267e;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFrozenContainer");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener(accountFreezeData) {
            public final /* synthetic */ AccountFreezeData f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                MainGroupModule.m25652a(MainGroupModule.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25652a(MainGroupModule mainGroupModule, AccountFreezeData accountFreezeData, View view) {
        Intrinsics.checkNotNullParameter(mainGroupModule, "this$0");
        Intrinsics.checkNotNullParameter(accountFreezeData, "$frozenData");
        mainGroupModule.m25653b(accountFreezeData);
    }

    /* renamed from: b */
    private final void m25653b(AccountFreezeData accountFreezeData) {
        String str;
        if (accountFreezeData.isJumpable(0)) {
            str = accountFreezeData.getLink(0);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            WebBrowserUtil.startInternalWebActivity(getContext(), str, "");
        }
    }
}
