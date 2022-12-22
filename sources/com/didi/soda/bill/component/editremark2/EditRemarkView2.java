package com.didi.soda.bill.component.editremark2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.rfusion.widget.textfield.RFTextField;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/bill/component/editremark2/EditRemarkView2;", "Lcom/didi/soda/bill/component/Contract$AbsEditRemarkView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "confirmBtn", "Landroid/widget/TextView;", "contentEt", "Lcom/didi/rfusion/widget/textfield/RFTextField;", "editContainer", "Landroid/view/ViewGroup;", "mAutoShowKeyBoard", "", "originRemark", "", "getOriginRemark", "()Ljava/lang/String;", "setOriginRemark", "(Ljava/lang/String;)V", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "init", "", "initDefaultNote", "defaultNote", "onCreate", "onPause", "onResume", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditRemarkView2.kt */
public final class EditRemarkView2 extends Contract.AbsEditRemarkView implements IRFFloatingExpand {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RFTextField f38941a;

    /* renamed from: b */
    private TextView f38942b;

    /* renamed from: c */
    private ViewGroup f38943c;

    /* renamed from: d */
    private String f38944d = "";

    /* renamed from: e */
    private boolean f38945e = true;

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

    public final String getOriginRemark() {
        return this.f38944d;
    }

    public final void setOriginRemark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f38944d = str;
    }

    public void onCreate() {
        super.onCreate();
        m27658a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Context context = getContext();
        RFTextField rFTextField = this.f38941a;
        if (rFTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField = null;
        }
        KeyboardUtils.hideSoftInput(context, rFTextField.getEditText());
    }

    public void initDefaultNote(String str) {
        Intrinsics.checkNotNullParameter(str, "defaultNote");
        this.f38944d = str;
        CharSequence charSequence = str;
        RFTextField rFTextField = null;
        if (charSequence.length() == 0) {
            IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
            RFTextField rFTextField2 = this.f38941a;
            if (rFTextField2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            } else {
                rFTextField = rFTextField2;
            }
            iToolsService.setTypeface(rFTextField.getEditText(), IToolsService.FontType.LIGHT);
            return;
        }
        RFTextField rFTextField3 = this.f38941a;
        if (rFTextField3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField3 = null;
        }
        rFTextField3.setText(charSequence);
        RFTextField rFTextField4 = this.f38941a;
        if (rFTextField4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField4 = null;
        }
        rFTextField4.setSelection(str.length());
        IToolsService iToolsService2 = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        RFTextField rFTextField5 = this.f38941a;
        if (rFTextField5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
        } else {
            rFTextField = rFTextField5;
        }
        iToolsService2.setTypeface(rFTextField.getEditText(), IToolsService.FontType.MEDIUM);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_edit_remark2, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_remark_edit_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.cus…er_remark_edit_container)");
        this.f38943c = (ViewGroup) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_cart_note);
        RFTextField rFTextField = (RFTextField) findViewById2;
        EditText editText = rFTextField.getEditText();
        if (editText != null) {
            editText.setMaxHeight(CustomerExtentionKt.getPx(R.dimen.rf_dimen_280));
        }
        rFTextField.setHintEnabled(false);
        EditText editText2 = rFTextField.getEditText();
        if (editText2 != null) {
            editText2.setHintTextColor(CustomerExtentionKt.getColor(R.color.rf_color_gery_3_60_999999));
        }
        EditText editText3 = rFTextField.getEditText();
        if (editText3 != null) {
            editText3.setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_v2_grey2_1_a100));
        }
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById<RFTextFi….color)\n                }");
        this.f38941a = rFTextField;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_common_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.cus…er_custom_common_confirm)");
        this.f38942b = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…on_confirm)\n            }");
        return inflate;
    }

    /* renamed from: a */
    private final void m27658a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditRemarkView2.m27659a(EditRemarkView2.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.customer_name_note)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
        }
        TextView textView = this.f38942b;
        ViewGroup viewGroup = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView = null;
        }
        textView.setText(getContext().getString(R.string.customer_dialog_confirm));
        TextView textView2 = this.f38942b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditRemarkView2.m27661b(EditRemarkView2.this, view);
            }
        });
        RFTextField rFTextField = this.f38941a;
        if (rFTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField = null;
        }
        EditText editText = rFTextField.getEditText();
        if (editText != null) {
            editText.setOnTouchListener($$Lambda$EditRemarkView2$LYX1cVgKveZfWwLEa2mCSN9NGw.INSTANCE);
        }
        RFTextField rFTextField2 = this.f38941a;
        if (rFTextField2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField2 = null;
        }
        EditText editText2 = rFTextField2.getEditText();
        if (editText2 != null) {
            editText2.addTextChangedListener(new EditRemarkView2$init$4(this));
        }
        RFTextField rFTextField3 = this.f38941a;
        if (rFTextField3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField3 = null;
        }
        EditText editText3 = rFTextField3.getEditText();
        if (editText3 != null) {
            editText3.setFocusable(true);
        }
        RFTextField rFTextField4 = this.f38941a;
        if (rFTextField4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField4 = null;
        }
        EditText editText4 = rFTextField4.getEditText();
        if (editText4 != null) {
            editText4.setFocusableInTouchMode(true);
        }
        Context context = getContext();
        if (context != null) {
            AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) context);
            ScopeContext scopeContext = getScopeContext();
            ViewGroup viewGroup2 = this.f38943c;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContainer");
            } else {
                viewGroup = viewGroup2;
            }
            instance.assistComponent(scopeContext, viewGroup);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27659a(EditRemarkView2 editRemarkView2, View view) {
        Intrinsics.checkNotNullParameter(editRemarkView2, "this$0");
        ((Contract.AbsEditRemarkPresenter) editRemarkView2.getPresenter()).finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27661b(EditRemarkView2 editRemarkView2, View view) {
        Intrinsics.checkNotNullParameter(editRemarkView2, "this$0");
        RFTextField rFTextField = editRemarkView2.f38941a;
        if (rFTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            rFTextField = null;
        }
        CharSequence text = rFTextField.getText();
        if ((text == null || text.length() == 0) || text.length() < 200) {
            if (!Intrinsics.areEqual((Object) String.valueOf(text), (Object) editRemarkView2.getOriginRemark())) {
                ((Contract.AbsEditRemarkPresenter) editRemarkView2.getPresenter()).updateRemark(String.valueOf(text));
            }
            ((Contract.AbsEditRemarkPresenter) editRemarkView2.getPresenter()).finish();
            BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
            String string = editRemarkView2.getScopeContext().getBundle().getString("current_shop_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…eKey.CURRENT_SHOP_ID, \"\")");
            String string2 = editRemarkView2.getScopeContext().getBundle().getString("cart_id", "");
            Intrinsics.checkNotNullExpressionValue(string2, "scopeContext.bundle.getS…st.BundleKey.CART_ID, \"\")");
            companion.trackCartRemarkConfirmCk(string, string2, String.valueOf(text));
            return;
        }
        ToastUtil.showCustomerToast(editRemarkView2.getScopeContext(), editRemarkView2.getContext().getString(R.string.customer_bill_remark_max_length));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27660a(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(view.getScrollY() != 0);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f38945e) {
            Context context = getContext();
            RFTextField rFTextField = this.f38941a;
            if (rFTextField == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                rFTextField = null;
            }
            KeyboardUtils.showSoftInput(context, rFTextField.getEditText());
            this.f38945e = false;
        }
    }
}
