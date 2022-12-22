package com.didi.soda.business.component.detail;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.business.component.detail.BusinessDetailItemView;
import com.didi.soda.business.component.detail.Contract;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.customer.foundation.rpc.entity.ActTipEntity;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0002J*\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\rH\u0014J\b\u00108\u001a\u00020\rH\u0002J\u0018\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0010\u0010<\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0015H\u0002J\u001a\u0010=\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\"\u0010@\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\u0006\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0015H\u0002J\u001e\u0010C\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001e\u0010D\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0010H\u0002J\u001e\u0010G\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0010H\u0002J\u001e\u0010J\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0002J\u0018\u0010L\u001a\u00020\r2\u0006\u0010:\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010M\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006Q"}, mo175978d2 = {"Lcom/didi/soda/business/component/detail/BusinessDetailView;", "Lcom/didi/soda/business/component/detail/Contract$AbsBusinessDetailView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mContext", "Landroid/content/Context;", "rootContainer", "Landroid/widget/LinearLayout;", "getRootContainer", "()Landroid/widget/LinearLayout;", "setRootContainer", "(Landroid/widget/LinearLayout;)V", "addDiscountView", "", "linearLayout", "activityTipList", "", "Lcom/didi/soda/business/model/BusinessDetailModel$BusinessDiscountDescModel;", "addDivederLine", "addOpenTimeLineView", "timeDescList", "", "addPayLineView", "payTitle", "payCardDescList", "addShopFeatureView", "shopFeatureTipModel", "Lcom/didi/soda/business/model/BusinessDetailModel$ShopFeatureTipModel;", "addView", "childView", "Landroid/view/View;", "buildTitleItemView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "title", "createArrowImageSpanString", "Landroid/text/SpannableStringBuilder;", "desc", "createDividerLine", "createItemViewBuilder", "Lcom/didi/soda/business/component/detail/BusinessDetailItemView$Builder;", "createTextView", "Landroid/widget/TextView;", "fontSize", "", "fontType", "Lcom/didi/soda/customer/service/IToolsService$FontType;", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isHideBusinessStatusTitle", "", "status", "", "onCreate", "removeLastLine", "renderAddressView", "builder", "address", "renderBusinessTitleItemView", "renderButByRiderItemView", "modeInfoModel", "Lcom/didi/soda/business/model/BusinessDetailModel$BusinessModeInfoModel;", "renderDisclaimerDesc", "disclaimerDesc", "disclaimerUrl", "renderDiscountItemView", "renderOpenTimeItemView", "mBizOpenDayList", "Lcom/didi/soda/business/model/BusinessDetailModel$BusinessOpenDayModel;", "renderPayItemView", "payDescModelList", "Lcom/didi/soda/business/model/BusinessDetailModel$BusinessPayDescModel;", "renderPhoneItemView", "phoneList", "renderShopFeatureItemView", "updateBusinessDetail", "detailModel", "Lcom/didi/soda/business/model/BusinessDetailModel;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailView.kt */
public final class BusinessDetailView extends Contract.AbsBusinessDetailView implements IRFFloatingExpand {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final float f39407c = 16.0f;

    /* renamed from: d */
    private static final float f39408d = 14.0f;

    /* renamed from: e */
    private static final int f39409e = 10;

    /* renamed from: f */
    private static final int f39410f = 5;

    /* renamed from: g */
    private static final String f39411g = "line";

    /* renamed from: a */
    private LinearLayout f39412a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f39413b;

    /* renamed from: a */
    private final boolean m27898a(int i) {
        return i == 1 || i == 3;
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public final LinearLayout getRootContainer() {
        return this.f39412a;
    }

    public final void setRootContainer(LinearLayout linearLayout) {
        this.f39412a = linearLayout;
    }

    /* renamed from: a */
    private final BusinessDetailItemView.Builder m27885a() {
        return new BusinessDetailItemView.Builder(this.f39412a);
    }

    public void updateBusinessDetail(BusinessDetailModel businessDetailModel) {
        int i;
        if (businessDetailModel != null && this.f39413b != null) {
            RFFloatingNavBar navBar = getNavBar(getScopeContext());
            boolean z = true;
            if (navBar != null) {
                navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BusinessDetailView.m27895a(BusinessDetailView.this, view);
                    }
                }).build());
            }
            String str = businessDetailModel.mBusinessName;
            if (str != null) {
                m27897a(str);
            }
            if (businessDetailModel.shopFeatureTipModel != null) {
                BusinessDetailItemView.Builder a = m27885a();
                BusinessDetailModel.ShopFeatureTipModel shopFeatureTipModel = businessDetailModel.shopFeatureTipModel;
                Intrinsics.checkNotNullExpressionValue(shopFeatureTipModel, "detailModel.shopFeatureTipModel");
                m27891a(a, shopFeatureTipModel);
                m27906d();
            }
            if (BusinessDataHelper.isShowBuyAgentInDetail(businessDetailModel.modeInfoModel)) {
                m27890a(m27885a(), businessDetailModel.modeInfoModel);
                m27906d();
            }
            Collection collection = businessDetailModel.mDiscountTipList;
            if (!(collection == null || collection.isEmpty())) {
                BusinessDetailItemView.Builder a2 = m27885a();
                List<BusinessDetailModel.BusinessDiscountDescModel> list = businessDetailModel.mDiscountTipList;
                Intrinsics.checkNotNullExpressionValue(list, "detailModel.mDiscountTipList");
                m27894a(a2, (List<? extends BusinessDetailModel.BusinessDiscountDescModel>) list);
                m27906d();
            }
            CharSequence charSequence = businessDetailModel.mBusinessAddress;
            if (!(charSequence == null || charSequence.length() == 0)) {
                BusinessDetailItemView.Builder a3 = m27885a();
                String str2 = businessDetailModel.mBusinessAddress;
                Intrinsics.checkNotNullExpressionValue(str2, "detailModel.mBusinessAddress");
                m27892a(a3, str2);
                i = 1;
            } else {
                i = 0;
            }
            if (!m27898a(businessDetailModel.mBusinessStatus)) {
                BusinessDetailItemView.Builder icon = m27885a().setIcon(R.string.customer_common_icon_historical_address);
                if (businessDetailModel.mBusinessStatus == 4) {
                    icon.setTitle(ResourceHelper.getString(R.string.customer_business_detail_temporarily_unavailable)).buildAddView();
                } else {
                    icon.setTitle(ResourceHelper.getString(R.string.customer_business_detail_status_closed)).setContent(businessDetailModel.mNextBizTimeDesc).buildAddView();
                }
                i++;
            }
            Collection collection2 = businessDetailModel.mBizOpenDayList;
            if (!(collection2 == null || collection2.isEmpty())) {
                BusinessDetailItemView.Builder a4 = m27885a();
                List<BusinessDetailModel.BusinessOpenDayModel> list2 = businessDetailModel.mBizOpenDayList;
                Intrinsics.checkNotNullExpressionValue(list2, "detailModel.mBizOpenDayList");
                m27902b(a4, (List<? extends BusinessDetailModel.BusinessOpenDayModel>) list2);
                i++;
            }
            CharSequence charSequence2 = businessDetailModel.mDeliveryTypeDesc;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                m27885a().setIcon(R.string.customer_common_icon_delivery).setTitle(ResourceHelper.getString(R.string.customer_business_delivery_method)).setIsShowLineHeight(true).setAddExpendAction(new BusinessDetailView$updateBusinessDetail$3(this, businessDetailModel)).buildAddView();
                i++;
            }
            Collection collection3 = businessDetailModel.mBusinessPhone;
            if (!(collection3 == null || collection3.isEmpty())) {
                BusinessDetailItemView.Builder a5 = m27885a();
                List<String> list3 = businessDetailModel.mBusinessPhone;
                Intrinsics.checkNotNullExpressionValue(list3, "detailModel.mBusinessPhone");
                m27905c(a5, list3);
                i++;
            }
            if (i > 0) {
                m27906d();
            }
            Collection collection4 = businessDetailModel.mPayDescList;
            if (!(collection4 == null || collection4.isEmpty())) {
                BusinessDetailItemView.Builder a6 = m27885a();
                List<BusinessDetailModel.BusinessPayDescModel> list4 = businessDetailModel.mPayDescList;
                Intrinsics.checkNotNullExpressionValue(list4, "detailModel.mPayDescList");
                m27907d(a6, list4);
                m27906d();
            }
            CharSequence charSequence3 = businessDetailModel.mDisclaimerDesc;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                z = false;
            }
            if (!z) {
                BusinessDetailItemView.Builder a7 = m27885a();
                String str3 = businessDetailModel.mDisclaimerDesc;
                Intrinsics.checkNotNullExpressionValue(str3, "detailModel.mDisclaimerDesc");
                m27893a(a7, str3, businessDetailModel.mDisclaimerUrl);
            }
            m27900b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27895a(BusinessDetailView businessDetailView, View view) {
        Intrinsics.checkNotNullParameter(businessDetailView, "this$0");
        Contract.AbsBusinessDetailPresenter absBusinessDetailPresenter = (Contract.AbsBusinessDetailPresenter) businessDetailView.getPresenter();
        if (absBusinessDetailPresenter != null) {
            absBusinessDetailPresenter.onPageClose();
        }
    }

    /* renamed from: a */
    private final void m27897a(String str) {
        if (this.f39412a != null) {
            if (str.length() > 0) {
                m27886a((View) m27899b(str));
            }
        }
    }

    /* renamed from: b */
    private final CustomerAppCompatTextView m27899b(String str) {
        CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(this.f39413b);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerAppCompatTextView, IToolsService.FontType.MEDIUM);
        customerAppCompatTextView.setPadding(DisplayUtils.dip2px(customerAppCompatTextView.getContext(), 24.0f), DisplayUtils.dip2px(customerAppCompatTextView.getContext(), 20.0f), DisplayUtils.dip2px(customerAppCompatTextView.getContext(), 24.0f), 0);
        customerAppCompatTextView.setTextColor(customerAppCompatTextView.getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        customerAppCompatTextView.setTextSize(1, 24.0f);
        customerAppCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        customerAppCompatTextView.setMaxLines(5);
        customerAppCompatTextView.setText(str);
        return customerAppCompatTextView;
    }

    /* renamed from: a */
    private final void m27886a(View view) {
        LinearLayout rootContainer;
        if (view != null && (rootContainer = getRootContainer()) != null) {
            rootContainer.addView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.f39413b = getContext();
        View view = getView();
        this.f39412a = view == null ? null : (LinearLayout) view.findViewById(R.id.customer_cl_business_detail_container);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_detail, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_detail, container, true)");
        return inflate;
    }

    /* renamed from: a */
    private final void m27890a(BusinessDetailItemView.Builder builder, BusinessDetailModel.BusinessModeInfoModel businessModeInfoModel) {
        if (businessModeInfoModel != null) {
            builder.setIcon(R.string.customer_common_icon_buy_by_rider);
            CharSequence charSequence = businessModeInfoModel.modeTagDesc;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                builder.setTitle(businessModeInfoModel.modeTagDesc);
            }
            CharSequence charSequence2 = businessModeInfoModel.shortDesc;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                if (BusinessDataHelper.isShowBuyAgentBtnLink(businessModeInfoModel)) {
                    builder.setContent(m27903c(businessModeInfoModel.shortDesc)).setContentClickAction(new BusinessDetailView$renderButByRiderItemView$1(this, businessModeInfoModel));
                } else {
                    builder.setContent(businessModeInfoModel.shortDesc);
                }
            }
            builder.buildAddView();
        }
    }

    /* renamed from: a */
    private final void m27891a(BusinessDetailItemView.Builder builder, BusinessDetailModel.ShopFeatureTipModel shopFeatureTipModel) {
        CharSequence charSequence = shopFeatureTipModel.title;
        builder.setIconUrl(shopFeatureTipModel.iconUrl).setTitle(!(charSequence == null || charSequence.length() == 0) ? shopFeatureTipModel.title : getString(R.string.FoodC_2_Preferred_YAdf)).setAddExpendAction(new BusinessDetailView$renderShopFeatureItemView$1(this, shopFeatureTipModel)).buildAddView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27887a(LinearLayout linearLayout, BusinessDetailModel.ShopFeatureTipModel shopFeatureTipModel) {
        int size;
        Collection collection = shopFeatureTipModel.tips;
        if (!(collection == null || collection.isEmpty()) && shopFeatureTipModel.tips.size() - 1 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ActTipEntity actTipEntity = shopFeatureTipModel.tips.get(i);
                CharSequence charSequence = actTipEntity.cTypeDesc;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    LinearLayout linearLayout2 = new LinearLayout(this.f39413b);
                    linearLayout2.setOrientation(1);
                    TextView a = m27884a(14.0f, IToolsService.FontType.MEDIUM);
                    a.setText(actTipEntity.cTypeDesc);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    Resources resources = getResources();
                    layoutParams.topMargin = resources == null ? 0 : resources.getDimensionPixelOffset(R.dimen.customer_24px);
                    Resources resources2 = getResources();
                    layoutParams.bottomMargin = resources2 == null ? 0 : resources2.getDimensionPixelOffset(R.dimen.customer_12px);
                    linearLayout2.addView(a, layoutParams);
                    CharSequence charSequence2 = actTipEntity.content;
                    if (!(charSequence2 == null || charSequence2.length() == 0)) {
                        TextView a2 = m27884a(14.0f, IToolsService.FontType.LIGHT);
                        a2.setText(actTipEntity.content);
                        Resources resources3 = getResources();
                        a2.setLineSpacing(resources3 == null ? 0.0f : (float) resources3.getDimensionPixelOffset(R.dimen.customer_12px), 1.0f);
                        linearLayout2.addView(a2, new LinearLayout.LayoutParams(-1, -2));
                    }
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m27894a(BusinessDetailItemView.Builder builder, List<? extends BusinessDetailModel.BusinessDiscountDescModel> list) {
        builder.setIcon(R.string.customer_common_icon_coupon).setTitle(ResourceHelper.getString(R.string.customer_business_detail_promotions)).setAddExpendAction(new BusinessDetailView$renderDiscountItemView$1(this, list)).buildAddView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27889a(LinearLayout linearLayout, List<? extends BusinessDetailModel.BusinessDiscountDescModel> list) {
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                BusinessDetailModel.BusinessDiscountDescModel businessDiscountDescModel = (BusinessDetailModel.BusinessDiscountDescModel) list.get(i);
                if (businessDiscountDescModel != null) {
                    CharSequence charSequence = businessDiscountDescModel.mTypeDetail;
                    boolean z = true;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        LinearLayout linearLayout2 = new LinearLayout(this.f39413b);
                        linearLayout2.setOrientation(1);
                        TextView a = m27884a(14.0f, IToolsService.FontType.MEDIUM);
                        a.setText(businessDiscountDescModel.mTypeDetail);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        Resources resources = getResources();
                        layoutParams.topMargin = resources == null ? 0 : resources.getDimensionPixelOffset(R.dimen.customer_24px);
                        Resources resources2 = getResources();
                        layoutParams.bottomMargin = resources2 == null ? 0 : resources2.getDimensionPixelOffset(R.dimen.customer_12px);
                        linearLayout2.addView(a, layoutParams);
                        CharSequence charSequence2 = businessDiscountDescModel.mContent;
                        if (!(charSequence2 == null || charSequence2.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            TextView a2 = m27884a(14.0f, IToolsService.FontType.LIGHT);
                            a2.setText(businessDiscountDescModel.mContent);
                            Resources resources3 = getResources();
                            a2.setLineSpacing(resources3 == null ? 0.0f : (float) resources3.getDimensionPixelOffset(R.dimen.customer_12px), 1.0f);
                            linearLayout2.addView(a2, new LinearLayout.LayoutParams(-1, -2));
                        }
                        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
                    } else if (businessDiscountDescModel.ruleDesc != null) {
                        CharSequence charSequence3 = businessDiscountDescModel.mContent;
                        if (!(charSequence3 == null || charSequence3.length() == 0)) {
                            TextView richTextView = new RichTextView(this.f39413b);
                            richTextView.setTextSize(1, 14.0f);
                            richTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666));
                            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(richTextView, IToolsService.FontType.LIGHT);
                            richTextView.setText(m27903c(businessDiscountDescModel.mContent));
                            richTextView.setOnClickListener(new View.OnClickListener(businessDiscountDescModel) {
                                public final /* synthetic */ BusinessDetailModel.BusinessDiscountDescModel f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onClick(View view) {
                                    BusinessDetailView.m27896a(BusinessDetailView.this, this.f$1, view);
                                }
                            });
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            Resources resources4 = getResources();
                            layoutParams2.topMargin = resources4 == null ? 0 : resources4.getDimensionPixelOffset(R.dimen.customer_24px);
                            linearLayout.addView(richTextView, layoutParams2);
                            Contract.AbsBusinessDetailPresenter absBusinessDetailPresenter = (Contract.AbsBusinessDetailPresenter) getPresenter();
                            if (absBusinessDetailPresenter != null) {
                                absBusinessDetailPresenter.onCouponReduceShow();
                            }
                        }
                    }
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27896a(BusinessDetailView businessDetailView, BusinessDetailModel.BusinessDiscountDescModel businessDiscountDescModel, View view) {
        Intrinsics.checkNotNullParameter(businessDetailView, "this$0");
        Intrinsics.checkNotNullParameter(businessDiscountDescModel, "$discountDescModel");
        Contract.AbsBusinessDetailPresenter absBusinessDetailPresenter = (Contract.AbsBusinessDetailPresenter) businessDetailView.getPresenter();
        if (absBusinessDetailPresenter != null) {
            absBusinessDetailPresenter.openCouponExclusivePage(businessDiscountDescModel.ruleDesc);
        }
    }

    /* renamed from: b */
    private final void m27902b(BusinessDetailItemView.Builder builder, List<? extends BusinessDetailModel.BusinessOpenDayModel> list) {
        builder.setIcon(R.string.customer_common_icon_historical_address).setTitle(ResourceHelper.getString(R.string.customer_business_detail_business_hours)).setAddExpendAction(new BusinessDetailView$renderOpenTimeItemView$1(list, this)).buildAddView();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m27901b(LinearLayout linearLayout, List<String> list) {
        int size;
        Collection collection = list;
        if (!(collection == null || collection.isEmpty()) && list.size() - 1 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String str = list.get(i);
                if (str != null) {
                    TextView a = m27884a(14.0f, IToolsService.FontType.LIGHT);
                    a.setText(str);
                    Resources resources = getResources();
                    a.setLineSpacing(resources == null ? 0.0f : (float) resources.getDimensionPixelOffset(R.dimen.customer_12px), 1.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    Resources resources2 = getResources();
                    layoutParams.topMargin = resources2 == null ? 0 : resources2.getDimensionPixelOffset(R.dimen.customer_24px);
                    linearLayout.addView(a, layoutParams);
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private final void m27905c(BusinessDetailItemView.Builder builder, List<String> list) {
        builder.setIcon(R.string.customer_common_icon_telephone).setTitle(ResourceHelper.getString(R.string.customer_business_detail_contact_info)).setAddExpendAction(new BusinessDetailView$renderPhoneItemView$1(list, this)).buildAddView();
    }

    /* renamed from: a */
    private final void m27892a(BusinessDetailItemView.Builder builder, String str) {
        builder.setIcon(R.string.customer_common_icon_restaurant_address).setTitle(ResourceHelper.getString(R.string.customer_business_detail_address)).setIsShowLineHeight(true).setContent(m27903c(str)).setContentClickAction(new BusinessDetailView$renderAddressView$1(this)).buildAddView();
    }

    /* renamed from: a */
    private final void m27893a(BusinessDetailItemView.Builder builder, String str, String str2) {
        builder.setIcon(R.string.customer_common_icon_order).setTitle(ResourceHelper.getString(R.string.customer_business_detail_notification)).setContent(m27903c(str)).setIsContentLineSpacingMultiplier(true).setContentClickAction(new BusinessDetailView$renderDisclaimerDesc$1(this, str2)).buildAddView();
    }

    /* renamed from: d */
    private final void m27907d(BusinessDetailItemView.Builder builder, List<? extends BusinessDetailModel.BusinessPayDescModel> list) {
        builder.setIcon(R.string.customer_common_icon_payment2).setAddExpendAction(new BusinessDetailView$renderPayItemView$1(list, this)).buildAddView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27888a(LinearLayout linearLayout, String str, List<String> list) {
        int size;
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            LinearLayout linearLayout2 = new LinearLayout(this.f39413b);
            boolean z = true;
            linearLayout2.setOrientation(1);
            TextView a = m27884a((float) f39407c, IToolsService.FontType.MEDIUM);
            a.setText(charSequence);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            Resources resources = getResources();
            layoutParams.topMargin = resources == null ? 0 : resources.getDimensionPixelOffset(R.dimen.customer_60px);
            linearLayout2.addView(a, layoutParams);
            Collection collection = list;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (!z && list.size() - 1 >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    TextView a2 = m27884a(14.0f, IToolsService.FontType.LIGHT);
                    String str2 = list.get(i);
                    if (str2 != null) {
                        a2.setText(str2);
                        Resources resources2 = getResources();
                        a2.setLineSpacing(resources2 == null ? 0.0f : (float) resources2.getDimensionPixelOffset(R.dimen.customer_12px), 1.0f);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        Resources resources3 = getResources();
                        layoutParams2.topMargin = resources3 == null ? 0 : resources3.getDimensionPixelOffset(R.dimen.customer_24px);
                        linearLayout2.addView(a2, layoutParams2);
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    /* renamed from: b */
    private final void m27900b() {
        Object obj;
        LinearLayout linearLayout = this.f39412a;
        if (linearLayout != null && linearLayout.getChildCount() != 0) {
            View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
            if (childAt == null) {
                obj = null;
            } else {
                obj = childAt.getTag();
            }
            if (Intrinsics.areEqual((Object) "line", obj)) {
                childAt.setVisibility(8);
            }
        }
    }

    /* renamed from: c */
    private final View m27904c() {
        View view = new View(this.f39413b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.f39413b, 0.5f));
        layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_48px);
        layoutParams.topMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px);
        layoutParams.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.customer_48px);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
        view.setTag("line");
        return view;
    }

    /* renamed from: d */
    private final void m27906d() {
        LinearLayout linearLayout = this.f39412a;
        if (linearLayout != null) {
            linearLayout.addView(m27904c());
        }
    }

    /* renamed from: c */
    private final SpannableStringBuilder m27903c(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new SpannableStringBuilder("");
        }
        SpannableString spannableString = new SpannableString(charSequence);
        SpannableString spannableString2 = new SpannableString(ResourceHelper.getString(R.string.customer_global_blank) + ResourceHelper.getString(R.string.customer_global_blank_double) + ResourceHelper.getString(R.string.customer_business_detail_view));
        spannableString2.setSpan(new ForegroundColorSpan(ResourceHelper.getColor(R.color.rf_color_jianbian_2)), 0, spannableString2.length(), 17);
        spannableString2.setSpan(new CustomerVerticalCenterSpan(14, ResourceHelper.getColor(R.color.rf_color_jianbian_2)), 0, spannableString2.length(), 33);
        SpannableString spannableString3 = new SpannableString(ResourceHelper.getString(R.string.customer_global_blank));
        spannableString3.setSpan(new AbsoluteSizeSpan(5, true), 0, spannableString3.length(), 17);
        SpannableString spannableString4 = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_arrow));
        spannableString4.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString4.length(), 33);
        spannableString4.setSpan(new CustomerVerticalCenterSpan(10, ResourceHelper.getColor(R.color.rf_color_jianbian_2)), 0, spannableString4.length(), 33);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString);
        spannableStringBuilder.append(spannableString2);
        spannableStringBuilder.append(spannableString3);
        spannableStringBuilder.append(spannableString4);
        return spannableStringBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final TextView m27884a(float f, IToolsService.FontType fontType) {
        TextView richTextView = new RichTextView(this.f39413b);
        richTextView.setTextSize(1, f);
        richTextView.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(richTextView, fontType);
        return richTextView;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/business/component/detail/BusinessDetailView$Companion;", "", "()V", "ARROW_ICON_FONT_SIZE", "", "BLANK_SIZE", "CONTENT_FONT_SIZE", "", "LINE_TAG", "", "TITLE_FONT_SIZE", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDetailView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
