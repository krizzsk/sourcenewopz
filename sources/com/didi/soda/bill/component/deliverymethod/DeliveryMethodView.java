package com.didi.soda.bill.component.deliverymethod;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.datamodel.DeliveryRulesModel;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0003J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020\u0019H\u0002J\"\u0010(\u001a\u00020\u00192\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0014J\u0012\u0010.\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010/\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/bill/component/deliverymethod/DeliveryMethodView;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mConfirm", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mContent", "Landroid/widget/LinearLayout;", "mContentScrollView", "Landroid/widget/ScrollView;", "mDeliveryEntities", "", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "mDeliveryEntity", "mDeliveryRuleText", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "mNote", "Landroid/widget/EditText;", "getMNote", "()Landroid/widget/EditText;", "setMNote", "(Landroid/widget/EditText;)V", "mRemarkView", "Landroid/view/View;", "addItemView", "", "entity", "clickItem", "type", "", "createImageSpanString", "Landroid/text/SpannableStringBuilder;", "desc", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "init", "initDeliveryMethod", "deliveryMethods", "deliveryRulesModel", "Lcom/didi/soda/bill/model/datamodel/DeliveryRulesModel;", "onCreate", "onPause", "refreshNoteView", "showDeliveryRule", "updateUi", "selectType", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeliveryMethodView.kt */
public final class DeliveryMethodView extends Contract.AbsDeliveryMethodView implements IRFFloatingExpand {

    /* renamed from: a */
    private ScrollView f38928a;

    /* renamed from: b */
    private LinearLayout f38929b;

    /* renamed from: c */
    private RFMainButton f38930c;

    /* renamed from: d */
    private CustomerAppCompatTextView f38931d;

    /* renamed from: e */
    private View f38932e;

    /* renamed from: f */
    private EditText f38933f;

    /* renamed from: g */
    private List<? extends DeliveryMethodEntity> f38934g;

    /* renamed from: h */
    private DeliveryMethodEntity f38935h;

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

    public final EditText getMNote() {
        return this.f38933f;
    }

    public final void setMNote(EditText editText) {
        this.f38933f = editText;
    }

    public void initDeliveryMethod(List<? extends DeliveryMethodEntity> list, DeliveryRulesModel deliveryRulesModel) {
        if (list != null) {
            this.f38934g = list;
            LinearLayout linearLayout = this.f38929b;
            View view = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            List<? extends DeliveryMethodEntity> list2 = this.f38934g;
            Intrinsics.checkNotNull(list2);
            for (DeliveryMethodEntity deliveryMethodEntity : CollectionsKt.reversed(list2)) {
                if (deliveryMethodEntity.isSelected == 1) {
                    this.f38935h = deliveryMethodEntity;
                }
                m27644a(deliveryMethodEntity);
            }
            LayoutInflater from = LayoutInflater.from(getContext());
            LinearLayout linearLayout2 = this.f38929b;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                linearLayout2 = null;
            }
            View inflate = from.inflate(R.layout.customer_component_edit_delivery_method_remark, linearLayout2, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_remark, mContent, false)");
            this.f38932e = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRemarkView");
                inflate = null;
            }
            this.f38933f = (EditText) inflate.findViewById(R.id.customer_custom_cart_note);
            View view2 = this.f38932e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRemarkView");
            } else {
                view = view2;
            }
            View findViewById = view.findViewById(R.id.customer_custom_delivery_rule);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRemarkView.findViewById…mer_custom_delivery_rule)");
            this.f38931d = (CustomerAppCompatTextView) findViewById;
            m27649b(this.f38935h);
            m27642a(deliveryRulesModel);
        }
    }

    public void onCreate() {
        super.onCreate();
        m27638a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        KeyboardUtils.hideSoftInput(getContext(), this.f38933f);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_edit_delivery_method, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_sv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_sv_content)");
        this.f38928a = (ScrollView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_ll_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_ll_content)");
        this.f38929b = (LinearLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_common_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…er_custom_common_confirm)");
        this.f38930c = (RFMainButton) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_custom_delivery_rule);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…mer_custom_delivery_rule)");
        this.f38931d = (CustomerAppCompatTextView) findViewById4;
        Intrinsics.checkNotNullExpressionValue(inflate, "root");
        return inflate;
    }

    /* renamed from: a */
    private final void m27638a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    DeliveryMethodView.m27640a(DeliveryMethodView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.customer_business_delivery_method)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        }
        RFMainButton rFMainButton = this.f38930c;
        ScrollView scrollView = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
            rFMainButton = null;
        }
        rFMainButton.setText(getContext().getString(R.string.customer_dialog_confirm));
        RFMainButton rFMainButton2 = this.f38930c;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
            rFMainButton2 = null;
        }
        rFMainButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DeliveryMethodView.m27648b(DeliveryMethodView.this, view);
            }
        });
        Context context = getContext();
        if (context != null) {
            AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) context);
            instance.setOnSoftInputVisibilityListener(getScopeContext(), new AndroidBug5497Workaround.OnSoftInputVisibilityListener() {
                public final void onVisibility(boolean z) {
                    DeliveryMethodView.m27641a(DeliveryMethodView.this, z);
                }
            });
            ScopeContext scopeContext = getScopeContext();
            ScrollView scrollView2 = this.f38928a;
            if (scrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentScrollView");
            } else {
                scrollView = scrollView2;
            }
            instance.assistComponent(scopeContext, scrollView);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27640a(DeliveryMethodView deliveryMethodView, View view) {
        Intrinsics.checkNotNullParameter(deliveryMethodView, "this$0");
        ((Contract.AbsDeliveryMethodPresenter) deliveryMethodView.getPresenter()).finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27648b(DeliveryMethodView deliveryMethodView, View view) {
        Intrinsics.checkNotNullParameter(deliveryMethodView, "this$0");
        KeyboardUtils.hideSoftInput(deliveryMethodView.getContext(), deliveryMethodView.getMNote());
        EditText mNote = deliveryMethodView.getMNote();
        Editable editable = null;
        if (String.valueOf(mNote == null ? null : mNote.getText()).length() > 200) {
            ToastUtil.showCustomerToast(deliveryMethodView.getScopeContext(), ResourceHelper.getString(R.string.customer_bill_remark_max_length));
            return;
        }
        DeliveryMethodEntity deliveryMethodEntity = deliveryMethodView.f38935h;
        if (deliveryMethodEntity != null) {
            EditText mNote2 = deliveryMethodView.getMNote();
            if (mNote2 != null) {
                editable = mNote2.getText();
            }
            deliveryMethodEntity.remark = String.valueOf(editable);
        }
        ((Contract.AbsDeliveryMethodPresenter) deliveryMethodView.getPresenter()).updateDeliveryMethod(deliveryMethodView.f38935h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27641a(DeliveryMethodView deliveryMethodView, boolean z) {
        Intrinsics.checkNotNullParameter(deliveryMethodView, "this$0");
        LinearLayout linearLayout = null;
        if (z) {
            ScrollView scrollView = deliveryMethodView.f38928a;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentScrollView");
                scrollView = null;
            }
            LinearLayout linearLayout2 = deliveryMethodView.f38929b;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
            } else {
                linearLayout = linearLayout2;
            }
            C13399a.m27650a(scrollView, linearLayout);
            return;
        }
        ScrollView scrollView2 = deliveryMethodView.f38928a;
        if (scrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentScrollView");
            scrollView2 = null;
        }
        LinearLayout linearLayout3 = deliveryMethodView.f38929b;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
        } else {
            linearLayout = linearLayout3;
        }
        C13399a.m27651b(scrollView2, linearLayout);
    }

    /* renamed from: a */
    private final void m27644a(DeliveryMethodEntity deliveryMethodEntity) {
        LayoutInflater from = LayoutInflater.from(getContext());
        LinearLayout linearLayout = this.f38929b;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            linearLayout = null;
        }
        View inflate = from.inflate(R.layout.customer_component_edit_delivery_method_item, linearLayout, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.customer_iv_delivery_item_select_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.customer_tv_common_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.customer_tv_common_content);
        View findViewById = inflate.findViewById(R.id.customer_itv_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.customer_itv_icon)");
        IconTextView iconTextView = (IconTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_cl_delivery_view_container_mark);
        boolean z = deliveryMethodEntity.isCanChoice == 1;
        boolean z2 = deliveryMethodEntity.isSelected == 1;
        int i = 8;
        findViewById2.setVisibility(z ? 8 : 0);
        if (z) {
            textView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
        } else {
            textView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        }
        textView.setText(deliveryMethodEntity.name);
        textView2.setText(deliveryMethodEntity.disableReason);
        if (!z || z2) {
            if (!TextUtils.isEmpty(deliveryMethodEntity.disableReason)) {
                i = 0;
            }
            textView2.setVisibility(i);
        }
        int i2 = deliveryMethodEntity.type;
        if (i2 == 1) {
            iconTextView.setText(R.string.customer_common_icon_delivermethod1);
        } else if (i2 == 2) {
            iconTextView.setText(R.string.customer_common_icon_delivermethod2);
        } else if (i2 != 3) {
            iconTextView.setText(R.string.customer_common_icon_delivermethod2);
        } else {
            iconTextView.setText(R.string.customer_common_icon_delivermethod3);
        }
        if (deliveryMethodEntity.isSelected != 1 || !z) {
            imageView.setImageResource(R.drawable.customer_ic_goods_single_selection_disabled);
        } else {
            imageView.setImageResource(R.drawable.customer_skin_ic_goods_single_selected);
        }
        inflate.setOnClickListener(new View.OnClickListener(z, this, deliveryMethodEntity) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ DeliveryMethodView f$1;
            public final /* synthetic */ DeliveryMethodEntity f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryMethodView.m27645a(this.f$0, this.f$1, this.f$2, view);
            }
        });
        LinearLayout linearLayout3 = this.f38929b;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(inflate, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27645a(boolean z, DeliveryMethodView deliveryMethodView, DeliveryMethodEntity deliveryMethodEntity, View view) {
        Intrinsics.checkNotNullParameter(deliveryMethodView, "this$0");
        Intrinsics.checkNotNullParameter(deliveryMethodEntity, "$entity");
        if (z) {
            deliveryMethodView.m27639a(deliveryMethodEntity.type);
        }
    }

    /* renamed from: a */
    private final void m27639a(int i) {
        DeliveryMethodEntity deliveryMethodEntity = this.f38935h;
        boolean z = false;
        if (deliveryMethodEntity != null && deliveryMethodEntity.type == i) {
            z = true;
        }
        if (!z) {
            m27647b(i);
        }
    }

    /* renamed from: b */
    private final void m27649b(DeliveryMethodEntity deliveryMethodEntity) {
        if (deliveryMethodEntity != null) {
            EditText editText = this.f38933f;
            if (editText != null) {
                if (!TextUtils.isEmpty(deliveryMethodEntity.remark)) {
                    editText.setText(deliveryMethodEntity.remark);
                    editText.setSelection(deliveryMethodEntity.remark.length());
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(getMNote(), IToolsService.FontType.MEDIUM);
                } else if (!TextUtils.isEmpty(deliveryMethodEntity.defaultRemark)) {
                    editText.setHint(deliveryMethodEntity.defaultRemark);
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(getMNote(), IToolsService.FontType.LIGHT);
                }
                editText.addTextChangedListener(new DeliveryMethodView$refreshNoteView$1$1(this, editText));
                editText.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return DeliveryMethodView.m27646a(DeliveryMethodView.this, view, motionEvent);
                    }
                });
            }
            LinearLayout linearLayout = this.f38929b;
            View view = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                linearLayout = null;
            }
            View view2 = this.f38932e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRemarkView");
            } else {
                view = view2;
            }
            linearLayout.addView(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27646a(DeliveryMethodView deliveryMethodView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(deliveryMethodView, "this$0");
        ScrollView scrollView = deliveryMethodView.f38928a;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentScrollView");
            scrollView = null;
        }
        scrollView.requestDisallowInterceptTouchEvent(true);
        return false;
    }

    /* renamed from: a */
    private final void m27642a(DeliveryRulesModel deliveryRulesModel) {
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (deliveryRulesModel != null) {
            CharSequence content = deliveryRulesModel.getContent();
            boolean z = true;
            if (!(content == null || content.length() == 0)) {
                CharSequence dirUrl = deliveryRulesModel.getDirUrl();
                if (!(dirUrl == null || dirUrl.length() == 0)) {
                    CustomerAppCompatTextView customerAppCompatTextView2 = this.f38931d;
                    if (customerAppCompatTextView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDeliveryRuleText");
                        customerAppCompatTextView2 = null;
                    }
                    customerAppCompatTextView2.setVisibility(0);
                    CustomerAppCompatTextView customerAppCompatTextView3 = this.f38931d;
                    if (customerAppCompatTextView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDeliveryRuleText");
                        customerAppCompatTextView3 = null;
                    }
                    customerAppCompatTextView3.setText(m27637a(deliveryRulesModel.getContent()));
                    CharSequence dirUrl2 = deliveryRulesModel.getDirUrl();
                    if (!(dirUrl2 == null || dirUrl2.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        CustomerAppCompatTextView customerAppCompatTextView4 = this.f38931d;
                        if (customerAppCompatTextView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDeliveryRuleText");
                        } else {
                            customerAppCompatTextView = customerAppCompatTextView4;
                        }
                        customerAppCompatTextView.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                DeliveryMethodView.m27643a(DeliveryRulesModel.this, view);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
        CustomerAppCompatTextView customerAppCompatTextView5 = this.f38931d;
        if (customerAppCompatTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeliveryRuleText");
        } else {
            customerAppCompatTextView = customerAppCompatTextView5;
        }
        customerAppCompatTextView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27643a(DeliveryRulesModel deliveryRulesModel, View view) {
        DiRouter.request().path("webPage").putString("url", deliveryRulesModel.getDirUrl()).open();
    }

    /* renamed from: a */
    private final SpannableStringBuilder m27637a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new SpannableStringBuilder("");
        }
        SpannableString spannableString = new SpannableString(Intrinsics.stringPlus(str, " "));
        SpannableString spannableString2 = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_notes));
        spannableString2.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString2.length(), 33);
        spannableString2.setSpan(new CustomerVerticalCenterSpan(11, ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000)), 0, spannableString2.length(), 33);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString);
        spannableStringBuilder.append(spannableString2);
        return spannableStringBuilder;
    }

    /* renamed from: b */
    private final void m27647b(int i) {
        LinearLayout linearLayout = this.f38929b;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > 1) {
            LinearLayout linearLayout3 = this.f38929b;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
                linearLayout3 = null;
            }
            LinearLayout linearLayout4 = this.f38929b;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContent");
            } else {
                linearLayout2 = linearLayout4;
            }
            linearLayout3.removeViews(0, linearLayout2.getChildCount() - 1);
        }
        List<? extends DeliveryMethodEntity> list = this.f38934g;
        Intrinsics.checkNotNull(list);
        for (DeliveryMethodEntity deliveryMethodEntity : CollectionsKt.reversed(list)) {
            if (deliveryMethodEntity.type == i) {
                deliveryMethodEntity.isSelected = 1;
                this.f38935h = deliveryMethodEntity;
            } else {
                deliveryMethodEntity.isSelected = 0;
            }
            m27644a(deliveryMethodEntity);
        }
    }
}
