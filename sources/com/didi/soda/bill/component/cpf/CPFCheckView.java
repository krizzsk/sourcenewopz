package com.didi.soda.bill.component.cpf;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.component.cpf.CPFCheckEditItemView;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0014J\b\u0010\u0019\u001a\u00020\u000eH\u0014J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckView;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckView;", "Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView$EditChangeListener;", "()V", "mBirthItemView", "Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView;", "mCPFItemView", "mConfirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "mRoot", "Landroid/view/View;", "mSkipBtn", "Lcom/didi/rfusion/widget/RFTextView;", "afterTextChanged", "", "s", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "init", "onCreate", "onDestroy", "onResume", "refreshInfo", "cpfInfo", "birthInfo", "showToast", "timeDesc", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckView.kt */
public final class CPFCheckView extends Contract.AbsCPFCheckView implements CPFCheckEditItemView.EditChangeListener {

    /* renamed from: a */
    private RFMainButton f38923a;

    /* renamed from: b */
    private RFTextView f38924b;

    /* renamed from: c */
    private View f38925c;

    /* renamed from: d */
    private CPFCheckEditItemView f38926d;

    /* renamed from: e */
    private CPFCheckEditItemView f38927e;

    public void onCreate() {
        super.onCreate();
        m27633a();
    }

    /* renamed from: a */
    private final void m27633a() {
        RFMainButton rFMainButton = this.f38923a;
        RFTextView rFTextView = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            rFMainButton = null;
        }
        rFMainButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CPFCheckView.m27634a(CPFCheckView.this, view);
            }
        });
        RFTextView rFTextView2 = this.f38924b;
        if (rFTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSkipBtn");
        } else {
            rFTextView = rFTextView2;
        }
        rFTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CPFCheckView.m27636b(CPFCheckView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27634a(CPFCheckView cPFCheckView, View view) {
        Intrinsics.checkNotNullParameter(cPFCheckView, "this$0");
        Contract.AbsCPFCheckPresenter absCPFCheckPresenter = (Contract.AbsCPFCheckPresenter) cPFCheckView.getPresenter();
        CPFCheckEditItemView cPFCheckEditItemView = cPFCheckView.f38926d;
        CPFCheckEditItemView cPFCheckEditItemView2 = null;
        if (cPFCheckEditItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView = null;
        }
        String editText = cPFCheckEditItemView.getEditText();
        CPFCheckEditItemView cPFCheckEditItemView3 = cPFCheckView.f38927e;
        if (cPFCheckEditItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBirthItemView");
        } else {
            cPFCheckEditItemView2 = cPFCheckEditItemView3;
        }
        absCPFCheckPresenter.checkCPF(editText, cPFCheckEditItemView2.getEditText());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27636b(CPFCheckView cPFCheckView, View view) {
        Intrinsics.checkNotNullParameter(cPFCheckView, "this$0");
        ((Contract.AbsCPFCheckPresenter) cPFCheckView.getPresenter()).skip();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CPFCheckEditItemView cPFCheckEditItemView = this.f38926d;
        if (cPFCheckEditItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView = null;
        }
        cPFCheckEditItemView.postRequestFocus();
    }

    public void refreshInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "cpfInfo");
        Intrinsics.checkNotNullParameter(str2, "birthInfo");
        CPFCheckEditItemView cPFCheckEditItemView = this.f38926d;
        CPFCheckEditItemView cPFCheckEditItemView2 = null;
        if (cPFCheckEditItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView = null;
        }
        cPFCheckEditItemView.refresh(str);
        CPFCheckEditItemView cPFCheckEditItemView3 = this.f38927e;
        if (cPFCheckEditItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBirthItemView");
        } else {
            cPFCheckEditItemView2 = cPFCheckEditItemView3;
        }
        cPFCheckEditItemView2.refresh(str2);
    }

    public void showToast(String str) {
        Intrinsics.checkNotNullParameter(str, BlocksConst.WIDGET_PARAMS_TIMEDESC);
        if (str.length() > 0) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), str);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_cpf_check, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_component_cpf_check_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…mponent_cpf_check_layout)");
        CPFCheckEditItemView cPFCheckEditItemView = (CPFCheckEditItemView) findViewById;
        this.f38926d = cPFCheckEditItemView;
        View view = null;
        if (cPFCheckEditItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView = null;
        }
        List listOf = CollectionsKt.listOf(TuplesKt.m42317to(3, '.'), TuplesKt.m42317to(7, '.'), TuplesKt.m42317to(11, '-'));
        String string = ResourceHelper.getString(R.string.customer_bill_cpf_check_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.customer_bill_cpf_check_title)");
        cPFCheckEditItemView.initData(listOf, 14, string, "000.000.000-00");
        CPFCheckEditItemView cPFCheckEditItemView2 = this.f38926d;
        if (cPFCheckEditItemView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView2 = null;
        }
        CPFCheckEditItemView.EditChangeListener editChangeListener = this;
        cPFCheckEditItemView2.setEditChangeListener(editChangeListener);
        View findViewById2 = inflate.findViewById(R.id.customer_component_cpf_check_birth_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…t_cpf_check_birth_layout)");
        CPFCheckEditItemView cPFCheckEditItemView3 = (CPFCheckEditItemView) findViewById2;
        this.f38927e = cPFCheckEditItemView3;
        if (cPFCheckEditItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBirthItemView");
            cPFCheckEditItemView3 = null;
        }
        List listOf2 = CollectionsKt.listOf(TuplesKt.m42317to(2, Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX)), TuplesKt.m42317to(5, Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX)));
        String string2 = ResourceHelper.getString(R.string.FoodC_II_Birthday_FnHm);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.FoodC_II_Birthday_FnHm)");
        cPFCheckEditItemView3.initData(listOf2, 10, string2, "DD/MM/YYYY");
        CPFCheckEditItemView cPFCheckEditItemView4 = this.f38927e;
        if (cPFCheckEditItemView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBirthItemView");
            cPFCheckEditItemView4 = null;
        }
        cPFCheckEditItemView4.setEditChangeListener(editChangeListener);
        View findViewById3 = inflate.findViewById(R.id.customer_cpf_edit_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…tomer_cpf_edit_container)");
        this.f38925c = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_component_cpf_check_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…_component_cpf_check_btn)");
        this.f38923a = (RFMainButton) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_component_cpf_check_skip);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…component_cpf_check_skip)");
        this.f38924b = (RFTextView) findViewById5;
        View view2 = this.f38925c;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        } else {
            view = view2;
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CPFCheckView.m27635a(CPFCheckView.this, view, motionEvent);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…    false\n        }\n    }");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27635a(CPFCheckView cPFCheckView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(cPFCheckView, "this$0");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        KeyboardUtils.hideSoftInput(cPFCheckView.getContext(), (View) null);
        return false;
    }

    public void afterTextChanged(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, RavenKey.STACK);
        RFMainButton rFMainButton = this.f38923a;
        CPFCheckEditItemView cPFCheckEditItemView = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
            rFMainButton = null;
        }
        CPFCheckEditItemView cPFCheckEditItemView2 = this.f38926d;
        if (cPFCheckEditItemView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFItemView");
            cPFCheckEditItemView2 = null;
        }
        if (cPFCheckEditItemView2.getEditText().length() >= 14) {
            CPFCheckEditItemView cPFCheckEditItemView3 = this.f38927e;
            if (cPFCheckEditItemView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBirthItemView");
            } else {
                cPFCheckEditItemView = cPFCheckEditItemView3;
            }
            if (cPFCheckEditItemView.getEditText().length() >= 10) {
                z = true;
                rFMainButton.setEnabled(z);
            }
        }
        z = false;
        rFMainButton.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
    }
}
