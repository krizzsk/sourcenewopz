package com.didi.sdk.global.sign.payselect.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.module.PaySelModuleMgr;
import com.didi.sdk.global.sign.payselect.module.ShowMoreItemModule;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/OtherGroupModule;", "Lcom/didi/sdk/global/sign/payselect/module/GroupBaseModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "groupData", "Lcom/didi/sdk/global/sign/model/local/PaySelGroupData;", "llContainer", "Landroidx/appcompat/widget/LinearLayoutCompat;", "onShowMoreClickListener", "Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$OnItemClickListener;", "bindData", "", "data", "type", "initView", "resetChildModule", "isExpendAll", "", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OtherGroupModule.kt */
public final class OtherGroupModule extends GroupBaseModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final int f36271d = 2;

    /* renamed from: a */
    private LinearLayoutCompat f36272a;

    /* renamed from: b */
    private PaySelGroupData f36273b;

    /* renamed from: c */
    private final ShowMoreItemModule.OnItemClickListener f36274c = new OtherGroupModule$onShowMoreClickListener$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtherGroupModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/OtherGroupModule$Companion;", "", "()V", "DEFAULT_SHOW_NUM", "", "create", "Lcom/didi/sdk/global/sign/payselect/module/OtherGroupModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OtherGroupModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OtherGroupModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new OtherGroupModule(fragmentActivity, viewGroup, R.layout.payment_paysel_other_group_view);
        }
    }

    public void initView() {
        View findViewById = getRootView().findViewById(R.id.paysel_other_items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…el_other_items_container)");
        this.f36272a = (LinearLayoutCompat) findViewById;
        ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = UnitUtils.dp2px(getContext(), -20.0f);
            getRootView().setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public void bindData(PaySelGroupData paySelGroupData, int i) {
        Intrinsics.checkNotNullParameter(paySelGroupData, "data");
        this.f36273b = paySelGroupData;
        m25656a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25656a(boolean z) {
        boolean z2;
        LinearLayoutCompat linearLayoutCompat = this.f36272a;
        LinearLayoutCompat linearLayoutCompat2 = null;
        if (linearLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContainer");
            linearLayoutCompat = null;
        }
        linearLayoutCompat.removeAllViews();
        getItemModules().clear();
        PaySelGroupData paySelGroupData = this.f36273b;
        List<PaySelItemData> list = paySelGroupData == null ? null : paySelGroupData.itemList;
        if (list != null) {
            int size = list.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (list.get(i).isSelected && i >= 2) {
                        z2 = false;
                        break;
                    } else if (i2 > size) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            z2 = true;
            int size2 = list.size() - 1;
            if (size2 >= 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i3 < 2 || z || !z2) {
                        PaySelModuleMgr.Companion companion = PaySelModuleMgr.Companion;
                        FragmentActivity activity = getActivity();
                        LinearLayoutCompat linearLayoutCompat3 = this.f36272a;
                        if (linearLayoutCompat3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("llContainer");
                            linearLayoutCompat3 = null;
                        }
                        PaySelItemData paySelItemData = list.get(i3);
                        Intrinsics.checkNotNullExpressionValue(paySelItemData, "items[i]");
                        BizModule<PaySelItemData> create = companion.create(activity, linearLayoutCompat3, paySelItemData);
                        PaySelItemData paySelItemData2 = list.get(i3);
                        Intrinsics.checkNotNullExpressionValue(paySelItemData2, "items[i]");
                        BizModule.bindData$default(create, paySelItemData2, 0, 2, (Object) null);
                        if (create instanceof IPayModule) {
                            getItemModules().add(create);
                        }
                        if (i4 <= size2) {
                            i3 = i4;
                        } else {
                            return;
                        }
                    } else {
                        ShowMoreItemModule.Companion companion2 = ShowMoreItemModule.Companion;
                        FragmentActivity activity2 = getActivity();
                        LinearLayoutCompat linearLayoutCompat4 = this.f36272a;
                        if (linearLayoutCompat4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("llContainer");
                        } else {
                            linearLayoutCompat2 = linearLayoutCompat4;
                        }
                        companion2.create(activity2, linearLayoutCompat2).setOnItemClickListener(this.f36274c);
                        return;
                    }
                }
            }
        }
    }
}
