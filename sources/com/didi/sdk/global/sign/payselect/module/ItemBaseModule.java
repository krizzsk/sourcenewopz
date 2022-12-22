package com.didi.sdk.global.sign.payselect.module;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.base.FlowLayout;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.payselect.PayMethodSelVM;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtils;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtilsKt;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\tH\u0016J\u001e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020<H\u0002J\u0016\u0010=\u001a\u0002092\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020<H\u0002J\b\u0010>\u001a\u000205H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0002H\u0002J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\u0010\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020\u0002H\u0002J\u0010\u0010K\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010L\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010M\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010O\u001a\u0002052\u0006\u0010A\u001a\u00020\u0002H\u0016J\b\u0010P\u001a\u000205H\u0016J\u0010\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u00020@H\u0014J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020@H\u0014J(\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u000209H\u0002J\u0010\u0010[\u001a\u0002052\u0006\u00106\u001a\u00020\u0002H\u0016J\u0018\u0010\\\u001a\u0002052\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\tH\u0002J\u0010\u0010]\u001a\u0002052\u0006\u00106\u001a\u00020\u0002H\u0002J\u0010\u0010^\u001a\u0002052\u0006\u00106\u001a\u00020\u0002H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0010\u0010#\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u0014\u00100\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006_"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/ItemBaseModule;", "Lcom/didi/sdk/global/base/module/BizModule;", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "Lcom/didi/sdk/global/sign/payselect/module/IPayModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "dlgSwitch", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "flowLayLout", "Lcom/didi/sdk/global/base/FlowLayout;", "getFlowLayLout", "()Lcom/didi/sdk/global/base/FlowLayout;", "setFlowLayLout", "(Lcom/didi/sdk/global/base/FlowLayout;)V", "ivIcon", "Landroid/widget/ImageView;", "ivRightIcon", "getIvRightIcon", "()Landroid/widget/ImageView;", "setIvRightIcon", "(Landroid/widget/ImageView;)V", "llAllTitleContainer", "Landroid/widget/LinearLayout;", "getLlAllTitleContainer", "()Landroid/widget/LinearLayout;", "setLlAllTitleContainer", "(Landroid/widget/LinearLayout;)V", "llMainTitleContainer", "getLlMainTitleContainer", "setLlMainTitleContainer", "payItemData", "tvMostFavorable", "Landroid/widget/TextView;", "getTvMostFavorable", "()Landroid/widget/TextView;", "setTvMostFavorable", "(Landroid/widget/TextView;)V", "tvSubTitle", "getTvSubTitle", "setTvSubTitle", "tvTitle", "getTvTitle", "setTvTitle", "vm", "Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "getVm", "()Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "bindData", "", "data", "type", "getChannels4UT", "", "targetItemData", "curSelectedChannels", "", "getCurSelChannels4UT", "initView", "isOnlyOpenSwitchBtn", "", "targetItem", "isSelectable", "onClickFirstBtn", "onClickSecondBtn", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onItemClick", "paySelItemData", "onPause", "onResume", "onStart", "onStop", "performClick", "refreshUI", "setEnabled", "enabled", "setSelected", "selected", "showSwitchDlg", "popupItem", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodConfigInfo$PopupItem;", "dlgType", "channelIds4UT", "curSelChannelId4UT", "updateFlowLayout", "updateMostFavorable", "updateSubTitle", "updateTitle", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemBaseModule.kt */
public abstract class ItemBaseModule extends BizModule<PaySelItemData> implements IPayModule {

    /* renamed from: a */
    private ImageView f36250a;

    /* renamed from: b */
    private TextView f36251b;

    /* renamed from: c */
    private TextView f36252c;

    /* renamed from: d */
    private ImageView f36253d;

    /* renamed from: e */
    private FlowLayout f36254e;

    /* renamed from: f */
    private TextView f36255f;

    /* renamed from: g */
    private LinearLayout f36256g;

    /* renamed from: h */
    private LinearLayout f36257h;

    /* renamed from: i */
    private LEGODrawer f36258i;

    /* renamed from: j */
    private PaySelItemData f36259j;

    /* renamed from: k */
    private final PayMethodSelVM f36260k;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ItemBaseModule(androidx.fragment.app.FragmentActivity r8, android.view.ViewGroup r9, int r10) {
        /*
            r7 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "parentView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r2 = r8
            android.content.Context r2 = (android.content.Context) r2
            r5 = r8
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            androidx.lifecycle.ViewModelStoreOwner r8 = (androidx.lifecycle.ViewModelStoreOwner) r8
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.lifecycle.ViewModelProvider r9 = new androidx.lifecycle.ViewModelProvider
            r9.<init>(r8)
            java.lang.Class<com.didi.sdk.global.sign.payselect.PayMethodSelVM> r8 = com.didi.sdk.global.sign.payselect.PayMethodSelVM.class
            androidx.lifecycle.ViewModel r8 = r9.get(r8)
            java.lang.String r9 = "ViewModelProvider(activi…yMethodSelVM::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            com.didi.sdk.global.sign.payselect.PayMethodSelVM r8 = (com.didi.sdk.global.sign.payselect.PayMethodSelVM) r8
            r7.f36260k = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.payselect.module.ItemBaseModule.<init>(androidx.fragment.app.FragmentActivity, android.view.ViewGroup, int):void");
    }

    /* access modifiers changed from: protected */
    public final TextView getTvTitle() {
        return this.f36251b;
    }

    /* access modifiers changed from: protected */
    public final void setTvTitle(TextView textView) {
        this.f36251b = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getTvSubTitle() {
        return this.f36252c;
    }

    /* access modifiers changed from: protected */
    public final void setTvSubTitle(TextView textView) {
        this.f36252c = textView;
    }

    /* access modifiers changed from: protected */
    public final ImageView getIvRightIcon() {
        return this.f36253d;
    }

    /* access modifiers changed from: protected */
    public final void setIvRightIcon(ImageView imageView) {
        this.f36253d = imageView;
    }

    /* access modifiers changed from: protected */
    public final FlowLayout getFlowLayLout() {
        return this.f36254e;
    }

    /* access modifiers changed from: protected */
    public final void setFlowLayLout(FlowLayout flowLayout) {
        this.f36254e = flowLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView getTvMostFavorable() {
        return this.f36255f;
    }

    /* access modifiers changed from: protected */
    public final void setTvMostFavorable(TextView textView) {
        this.f36255f = textView;
    }

    /* access modifiers changed from: protected */
    public final LinearLayout getLlAllTitleContainer() {
        return this.f36256g;
    }

    /* access modifiers changed from: protected */
    public final void setLlAllTitleContainer(LinearLayout linearLayout) {
        this.f36256g = linearLayout;
    }

    /* access modifiers changed from: protected */
    public final LinearLayout getLlMainTitleContainer() {
        return this.f36257h;
    }

    /* access modifiers changed from: protected */
    public final void setLlMainTitleContainer(LinearLayout linearLayout) {
        this.f36257h = linearLayout;
    }

    /* access modifiers changed from: protected */
    public final PayMethodSelVM getVm() {
        return this.f36260k;
    }

    public void initView() {
        this.f36250a = (ImageView) getRootView().findViewById(R.id.paysel_item_icon);
        this.f36251b = (TextView) getRootView().findViewById(R.id.paysel_item_title);
        this.f36252c = (TextView) getRootView().findViewById(R.id.paysel_item_subtitle);
        this.f36253d = (ImageView) getRootView().findViewById(R.id.paysel_right_arrow_icon);
        this.f36254e = (FlowLayout) getRootView().findViewById(R.id.paysel_labels_container);
        this.f36255f = (TextView) getRootView().findViewById(R.id.paysel_item_most_favorable);
        this.f36256g = (LinearLayout) getRootView().findViewById(R.id.paysel_all_title_container);
        this.f36257h = (LinearLayout) getRootView().findViewById(R.id.paysel_main_title_container);
    }

    public void bindData(PaySelItemData paySelItemData, int i) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        this.f36259j = paySelItemData;
        NViewUtils.INSTANCE.setImage(this.f36250a, paySelItemData.iconUrl);
        m25644a(paySelItemData);
        m25648b(paySelItemData);
        updateFlowLayout(paySelItemData);
        setSelected(paySelItemData.isSelected);
        if (paySelItemData.isFrozen) {
            setEnabled(false);
        } else {
            setEnabled(paySelItemData.isEnabled);
        }
        m25645a(paySelItemData, i);
    }

    /* renamed from: a */
    private final void m25645a(PaySelItemData paySelItemData, int i) {
        TextView textView;
        ViewTreeObserver viewTreeObserver;
        if (paySelItemData.isFrozen) {
            TextView textView2 = this.f36255f;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        NViewUtils.INSTANCE.setText(this.f36255f, paySelItemData.mostFavorableTxt);
        if (i == 0 && (textView = this.f36255f) != null && !TextUtils.isEmpty(paySelItemData.mostFavorableTxt) && (viewTreeObserver = textView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ItemBaseModule$updateMostFavorable$1(textView, this, paySelItemData));
        }
    }

    /* access modifiers changed from: protected */
    public void setEnabled(boolean z) {
        TextView textView = this.f36251b;
        if (textView != null) {
            textView.setEnabled(z);
        }
        TextView textView2 = this.f36252c;
        if (textView2 != null) {
            textView2.setEnabled(z);
        }
        ImageView imageView = this.f36253d;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        TextView textView3 = this.f36255f;
        if (textView3 != null) {
            textView3.setEnabled(z);
        }
        if (!z) {
            getRootView().setOnClickListener((View.OnClickListener) null);
        } else {
            getRootView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ItemBaseModule.m25646a(ItemBaseModule.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25646a(ItemBaseModule itemBaseModule, View view) {
        Intrinsics.checkNotNullParameter(itemBaseModule, "this$0");
        PaySelItemData paySelItemData = itemBaseModule.f36259j;
        if (paySelItemData != null) {
            itemBaseModule.m25649c(paySelItemData);
        }
    }

    /* access modifiers changed from: protected */
    public void setSelected(boolean z) {
        ImageView imageView = this.f36253d;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    public void updateFlowLayout(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        ItemBaseModuleKt.updateFlowLayoutImpl(this.f36254e, paySelItemData);
    }

    /* renamed from: a */
    private final void m25644a(PaySelItemData paySelItemData) {
        NViewUtils.INSTANCE.setText(this.f36251b, paySelItemData.title);
        PaySelGroupData paySelGroupData = paySelItemData.groupData;
        if (paySelGroupData != null) {
            if (paySelGroupData.isOtherGroup()) {
                TextView textView = this.f36251b;
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                    return;
                }
                return;
            }
            TextView textView2 = this.f36251b;
            if (textView2 != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    /* renamed from: b */
    private final void m25648b(PaySelItemData paySelItemData) {
        if (paySelItemData.channelId == 150 && paySelItemData.expired == 1 && !TextUtils.isEmpty(paySelItemData.expiredDesc)) {
            NViewUtils.INSTANCE.setText(this.f36252c, paySelItemData.expiredDesc);
        } else if (paySelItemData.channelId == 120) {
            NViewUtils.INSTANCE.setText(this.f36252c, paySelItemData.info);
        } else {
            NViewUtils.INSTANCE.setText(this.f36252c, paySelItemData.subTitle);
        }
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        SystemUtils.log(6, "ItemBaseModule", NachoLifecycleManager.LIFECYCLE_ON_CREATE, (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 211);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onStart(lifecycleOwner);
        SystemUtils.log(6, "ItemBaseModule", "onStart", (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 216);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onResume(lifecycleOwner);
        SystemUtils.log(6, "ItemBaseModule", "onResume", (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 221);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onPause(lifecycleOwner);
        SystemUtils.log(6, "ItemBaseModule", "onPause", (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 226);
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onStop(lifecycleOwner);
        SystemUtils.log(6, "ItemBaseModule", "onStop", (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 231);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        SystemUtils.log(6, "ItemBaseModule", NachoLifecycleManager.LIFECYCLE_ON_DESTROY, (Throwable) null, "com.didi.sdk.global.sign.payselect.module.ItemBaseModule", 236);
    }

    public boolean isSelectable() {
        PaySelItemData paySelItemData = this.f36259j;
        if (paySelItemData == null) {
            return false;
        }
        if ((paySelItemData.style == 1 || paySelItemData.style == 3) && paySelItemData.isEnabled && paySelItemData.isSufficient) {
            return true;
        }
        return false;
    }

    public void performClick(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "targetItem");
        PaySelItemData paySelItemData2 = this.f36259j;
        if (paySelItemData2 != null && PaySelUtilsKt.isSamePayChannel(paySelItemData, paySelItemData2)) {
            getRootView().performClick();
        }
    }

    /* renamed from: c */
    private final void m25649c(PaySelItemData paySelItemData) {
        DidiGlobalPayMethodListData.PayMethodConfigInfo payMethodConfigInfo;
        DidiGlobalPayMethodListData.PayMethodConfigInfo.PopupItem popupItem;
        PaySelPageData value = this.f36260k.getBizDataLD().getValue();
        DidiGlobalPayMethodListData.PayMethodConfigInfo.PopupItem popupItem2 = null;
        if (value == null) {
            payMethodConfigInfo = null;
        } else {
            payMethodConfigInfo = value.configInfo;
        }
        List<PaySelItemData> selectedPayMethodExactly = this.f36260k.getSelectedPayMethodExactly();
        String a = m25640a(paySelItemData, (List<? extends PaySelItemData>) selectedPayMethodExactly);
        if (m25650d(paySelItemData)) {
            ToastHelper.showLongInfo(getContext(), (int) R.string.Fintech_Payment_Redesign__yFwp);
            return;
        }
        if (payMethodConfigInfo == null) {
            popupItem = null;
        } else {
            popupItem = payMethodConfigInfo.switchOutCombinationPayPopup;
        }
        if (!PaySelUtils.INSTANCE.isSwitchOutCombinedChannel(selectedPayMethodExactly, paySelItemData) || !PaySelUtils.INSTANCE.hasBalanceAndNotZero(selectedPayMethodExactly) || popupItem == null || !popupItem.isValid()) {
            if (payMethodConfigInfo != null) {
                popupItem2 = payMethodConfigInfo.switchOut99PayPopup;
            }
            if (!PaySelUtils.INSTANCE.isSwitchOutMainGroup(selectedPayMethodExactly, paySelItemData) || popupItem2 == null || !popupItem2.isValid()) {
                PaySelUT.INSTANCE.trackPaySelItemClk(a, "pm_swtich");
                this.f36260k.doItemClick(paySelItemData);
                return;
            }
            m25643a(popupItem2, 1, a, m25641a((List<? extends PaySelItemData>) selectedPayMethodExactly));
            PaySelUT.INSTANCE.trackPaySelItemClk(a, "");
            return;
        }
        m25643a(popupItem, 2, a, m25641a((List<? extends PaySelItemData>) selectedPayMethodExactly));
        PaySelUT.INSTANCE.trackPaySelItemClk(a, "");
    }

    /* renamed from: a */
    private final String m25640a(PaySelItemData paySelItemData, List<? extends PaySelItemData> list) {
        return paySelItemData.channelId + '_' + m25641a(list);
    }

    /* renamed from: a */
    private final String m25641a(List<? extends PaySelItemData> list) {
        int size = list.size() - 1;
        String str = "";
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                str = Intrinsics.stringPlus(str, Integer.valueOf(((PaySelItemData) list.get(i)).channelId));
                if (i != CollectionsKt.getLastIndex(list)) {
                    str = Intrinsics.stringPlus(str, ",");
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return str;
    }

    /* renamed from: a */
    private final void m25643a(DidiGlobalPayMethodListData.PayMethodConfigInfo.PopupItem popupItem, int i, String str, String str2) {
        LEGODrawer lEGODrawer = this.f36258i;
        if (lEGODrawer != null) {
            Intrinsics.checkNotNull(lEGODrawer);
            if (lEGODrawer.isShowing()) {
                return;
            }
        }
        String str3 = popupItem.title;
        Intrinsics.checkNotNull(str3);
        this.f36258i = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel1(str3, new LEGOBtnTextAndCallback(popupItem.confirmBtn, new ItemBaseModule$showSwitchDlg$model$1(this, i, str))).addMinorBtn(new LEGOBtnTextAndCallback(popupItem.cancelBtn, new ItemBaseModule$showSwitchDlg$model$2(this, i))).setClickOutsideCanCancel(true).setSubTitle(popupItem.subTitle));
        if (i == 2) {
            PaySelUT.INSTANCE.trackDlgShow("fin_pmmethod_combinepopup_sw", str2);
        } else {
            PaySelUT.INSTANCE.trackDlgShow("fin_pmmethod_retrievepopup_sw", str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25642a() {
        LEGODrawer lEGODrawer = this.f36258i;
        if (lEGODrawer != null) {
            Intrinsics.checkNotNull(lEGODrawer);
            if (lEGODrawer.isShowing()) {
                LEGODrawer lEGODrawer2 = this.f36258i;
                Intrinsics.checkNotNull(lEGODrawer2);
                lEGODrawer2.dismiss();
                PaySelItemData paySelItemData = this.f36259j;
                if (paySelItemData != null) {
                    this.f36260k.doItemClick(paySelItemData);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25647b() {
        LEGODrawer lEGODrawer = this.f36258i;
        if (lEGODrawer != null) {
            Intrinsics.checkNotNull(lEGODrawer);
            if (lEGODrawer.isShowing()) {
                LEGODrawer lEGODrawer2 = this.f36258i;
                Intrinsics.checkNotNull(lEGODrawer2);
                lEGODrawer2.dismiss();
            }
        }
    }

    public void refreshUI() {
        PaySelItemData paySelItemData = this.f36259j;
        if (paySelItemData != null) {
            bindData(paySelItemData, 1);
        }
    }

    /* renamed from: d */
    private final boolean m25650d(PaySelItemData paySelItemData) {
        List<PaySelItemData> list;
        PaySelPageData value = this.f36260k.getBizDataLD().getValue();
        if (value == null) {
            list = null;
        } else {
            list = value.payMethodList;
        }
        boolean z = false;
        if (list == null || !PaySelUtils.INSTANCE.isBalanceCombinedMode(paySelItemData) || paySelItemData.isSelected) {
            return false;
        }
        for (PaySelItemData canCombine : list) {
            if (PayMethodSelectHelper.canCombine(paySelItemData, canCombine)) {
                z = true;
            }
        }
        return !z;
    }
}
