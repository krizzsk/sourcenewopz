package com.didi.soda.bill.component.tipfee;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.bill.component.tipfee.Contract;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.support.CustomerEditTextCompat;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0014J\b\u0010\u001e\u001a\u00020\u000eH\u0014J\u0006\u0010\u001f\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditView;", "Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditView;", "()V", "mTextWatcher", "Landroid/text/TextWatcher;", "mTipFeeConfirmTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "mTipFeeCurrencyTv", "mTipFeeInputEt", "Lcom/didi/soda/customer/widget/support/CustomerEditTextCompat;", "mTipFeePercentTv", "mTipFeeRootContainer", "Landroid/view/ViewGroup;", "bindTipsFeeData", "", "billTipModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "selectedFee", "", "currency", "", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "initViews", "root", "onCreate", "onPause", "onResume", "showExceedMaxMessage", "TipTextWatcher", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipsFeeEditView.kt */
public final class BillTipsFeeEditView extends Contract.AbsTipsFeeEditView {

    /* renamed from: a */
    private CustomerAppCompatTextView f38981a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CustomerAppCompatTextView f38982b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CustomerAppCompatTextView f38983c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CustomerEditTextCompat f38984d;

    /* renamed from: e */
    private ViewGroup f38985e;

    /* renamed from: f */
    private TextWatcher f38986f;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
    }

    public void bindTipsFeeData(BillTipModel billTipModel, long j, String str) {
        Intrinsics.checkNotNullParameter(str, "currency");
        if (billTipModel != null) {
            Long l = BillTipsFeeListItemAdapter.FLAG_OF_OTHER_ITEM_VALUE;
            Intrinsics.checkNotNullExpressionValue(l, "FLAG_OF_OTHER_ITEM_VALUE");
            CustomerAppCompatTextView customerAppCompatTextView = null;
            if (j > l.longValue()) {
                CustomerAppCompatTextView customerAppCompatTextView2 = this.f38982b;
                if (customerAppCompatTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    customerAppCompatTextView2 = null;
                }
                customerAppCompatTextView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
                CustomerAppCompatTextView customerAppCompatTextView3 = this.f38983c;
                if (customerAppCompatTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    customerAppCompatTextView3 = null;
                }
                customerAppCompatTextView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
                long tipFeeValue = billTipModel.isPercent() ? billTipModel.getTipFeeValue() : billTipModel.getTipFeeValue() / ((long) 100);
                CustomerEditTextCompat customerEditTextCompat = this.f38984d;
                if (customerEditTextCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                    customerEditTextCompat = null;
                }
                customerEditTextCompat.setText(String.valueOf(tipFeeValue));
                CustomerEditTextCompat customerEditTextCompat2 = this.f38984d;
                if (customerEditTextCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                    customerEditTextCompat2 = null;
                }
                customerEditTextCompat2.setSelection(String.valueOf(tipFeeValue).length());
            } else {
                CustomerEditTextCompat customerEditTextCompat3 = this.f38984d;
                if (customerEditTextCompat3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                    customerEditTextCompat3 = null;
                }
                customerEditTextCompat3.setHint("0");
                CustomerAppCompatTextView customerAppCompatTextView4 = this.f38982b;
                if (customerAppCompatTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    customerAppCompatTextView4 = null;
                }
                customerAppCompatTextView4.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_neutral_5_20));
                CustomerAppCompatTextView customerAppCompatTextView5 = this.f38983c;
                if (customerAppCompatTextView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    customerAppCompatTextView5 = null;
                }
                customerAppCompatTextView5.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_neutral_5_20));
            }
            if (billTipModel.isPercent()) {
                CustomerAppCompatTextView customerAppCompatTextView6 = this.f38982b;
                if (customerAppCompatTextView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    customerAppCompatTextView6 = null;
                }
                customerAppCompatTextView6.setText(ResourceHelper.getString(R.string.customer_global_blank));
                CustomerAppCompatTextView customerAppCompatTextView7 = this.f38983c;
                if (customerAppCompatTextView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    customerAppCompatTextView7 = null;
                }
                customerAppCompatTextView7.setText("%");
            } else if (LocalizationUtils.CurrencyUtils.isJPYLocalLang(str)) {
                CustomerAppCompatTextView customerAppCompatTextView8 = this.f38982b;
                if (customerAppCompatTextView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    customerAppCompatTextView8 = null;
                }
                customerAppCompatTextView8.setText(ResourceHelper.getString(R.string.customer_global_blank));
                CustomerAppCompatTextView customerAppCompatTextView9 = this.f38983c;
                if (customerAppCompatTextView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    customerAppCompatTextView9 = null;
                }
                customerAppCompatTextView9.setText(LocalizationUtils.CurrencyUtils.getCurrencySymbol(str));
            } else {
                CustomerAppCompatTextView customerAppCompatTextView10 = this.f38982b;
                if (customerAppCompatTextView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    customerAppCompatTextView10 = null;
                }
                customerAppCompatTextView10.setText(LocalizationUtils.CurrencyUtils.getCurrencySymbol(str));
                CustomerAppCompatTextView customerAppCompatTextView11 = this.f38983c;
                if (customerAppCompatTextView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    customerAppCompatTextView11 = null;
                }
                customerAppCompatTextView11.setText(ResourceHelper.getString(R.string.customer_global_blank));
            }
            CustomerAppCompatTextView customerAppCompatTextView12 = this.f38983c;
            if (customerAppCompatTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                customerAppCompatTextView12 = null;
            }
            customerAppCompatTextView12.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView13 = this.f38982b;
            if (customerAppCompatTextView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
            } else {
                customerAppCompatTextView = customerAppCompatTextView13;
            }
            customerAppCompatTextView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_bill_tips_fee_edit, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        m27681a(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…itViews(it)\n            }");
        return inflate;
    }

    /* renamed from: a */
    private final void m27681a(View view) {
        View findViewById = view.findViewById(R.id.customer_tips_fee_edit_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…er_tips_fee_edit_confirm)");
        this.f38981a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_tips_fee_input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_tips_fee_input)");
        this.f38984d = (CustomerEditTextCompat) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_tip_currency);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.customer_tip_currency)");
        this.f38982b = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_tip_percent);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.customer_tip_percent)");
        this.f38983c = (CustomerAppCompatTextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.customer_bill_tips_fee_root_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…_tips_fee_root_container)");
        this.f38985e = (ViewGroup) findViewById5;
        this.f38986f = new TipTextWatcher(this);
        CustomerEditTextCompat customerEditTextCompat = this.f38984d;
        CustomerEditTextCompat customerEditTextCompat2 = null;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat = null;
        }
        TextWatcher textWatcher = this.f38986f;
        if (textWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTextWatcher");
            textWatcher = null;
        }
        customerEditTextCompat.addTextChangedListener(textWatcher);
        CustomerAppCompatTextView customerAppCompatTextView = this.f38981a;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeConfirmTv");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BillTipsFeeEditView.m27682a(BillTipsFeeEditView.this, view);
            }
        });
        CustomerEditTextCompat customerEditTextCompat3 = this.f38984d;
        if (customerEditTextCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat3 = null;
        }
        customerEditTextCompat3.setOnTouchListener($$Lambda$BillTipsFeeEditView$IYYTFbbUVReEeqyjtlrfH6bpbvY.INSTANCE);
        CustomerEditTextCompat customerEditTextCompat4 = this.f38984d;
        if (customerEditTextCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat4 = null;
        }
        customerEditTextCompat4.setFocusable(true);
        CustomerEditTextCompat customerEditTextCompat5 = this.f38984d;
        if (customerEditTextCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat5 = null;
        }
        customerEditTextCompat5.setFocusableInTouchMode(true);
        Context context = getContext();
        if (context != null) {
            AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) context);
            ScopeContext scopeContext = getScopeContext();
            ViewGroup viewGroup = this.f38985e;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipFeeRootContainer");
                viewGroup = null;
            }
            instance.assistComponent(scopeContext, viewGroup);
            CustomerEditTextCompat customerEditTextCompat6 = this.f38984d;
            if (customerEditTextCompat6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            } else {
                customerEditTextCompat2 = customerEditTextCompat6;
            }
            customerEditTextCompat2.requestFocus();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27682a(BillTipsFeeEditView billTipsFeeEditView, View view) {
        Intrinsics.checkNotNullParameter(billTipsFeeEditView, "this$0");
        Contract.AbsTipsFeeEditPresenter absTipsFeeEditPresenter = (Contract.AbsTipsFeeEditPresenter) billTipsFeeEditView.getPresenter();
        CustomerEditTextCompat customerEditTextCompat = billTipsFeeEditView.f38984d;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat = null;
        }
        absTipsFeeEditPresenter.confirmTipsFeeInput(String.valueOf(customerEditTextCompat.getText()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27683a(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(view.getScrollY() != 0);
        return false;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J*\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditView$TipTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditView;)V", "isChanged", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillTipsFeeEditView.kt */
    public final class TipTextWatcher implements TextWatcher {
        private boolean isChanged;
        final /* synthetic */ BillTipsFeeEditView this$0;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public TipTextWatcher(BillTipsFeeEditView billTipsFeeEditView) {
            Intrinsics.checkNotNullParameter(billTipsFeeEditView, "this$0");
            this.this$0 = billTipsFeeEditView;
        }

        public void afterTextChanged(Editable editable) {
            if (this.isChanged) {
                this.isChanged = false;
                return;
            }
            String valueOf = String.valueOf(editable);
            if (valueOf != null) {
                String obj = StringsKt.trim(valueOf).toString();
                CharSequence charSequence = obj;
                CustomerEditTextCompat customerEditTextCompat = null;
                if (charSequence == null || charSequence.length() == 0) {
                    CustomerAppCompatTextView access$getMTipFeeCurrencyTv$p = this.this$0.f38982b;
                    if (access$getMTipFeeCurrencyTv$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                        access$getMTipFeeCurrencyTv$p = null;
                    }
                    access$getMTipFeeCurrencyTv$p.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_neutral_5_20));
                    CustomerAppCompatTextView access$getMTipFeePercentTv$p = this.this$0.f38983c;
                    if (access$getMTipFeePercentTv$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                        access$getMTipFeePercentTv$p = null;
                    }
                    access$getMTipFeePercentTv$p.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_neutral_5_20));
                    CustomerEditTextCompat access$getMTipFeeInputEt$p = this.this$0.f38984d;
                    if (access$getMTipFeeInputEt$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                        access$getMTipFeeInputEt$p = null;
                    }
                    access$getMTipFeeInputEt$p.setHint("0");
                    CustomerEditTextCompat access$getMTipFeeInputEt$p2 = this.this$0.f38984d;
                    if (access$getMTipFeeInputEt$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                    } else {
                        customerEditTextCompat = access$getMTipFeeInputEt$p2;
                    }
                    customerEditTextCompat.requestFocus();
                    return;
                }
                CustomerAppCompatTextView access$getMTipFeeCurrencyTv$p2 = this.this$0.f38982b;
                if (access$getMTipFeeCurrencyTv$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeCurrencyTv");
                    access$getMTipFeeCurrencyTv$p2 = null;
                }
                access$getMTipFeeCurrencyTv$p2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
                CustomerAppCompatTextView access$getMTipFeePercentTv$p2 = this.this$0.f38983c;
                if (access$getMTipFeePercentTv$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeePercentTv");
                    access$getMTipFeePercentTv$p2 = null;
                }
                access$getMTipFeePercentTv$p2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
                BillTipModel billTipFeeModel = ((Contract.AbsTipsFeeEditPresenter) this.this$0.getPresenter()).getBillTipFeeModel();
                if (billTipFeeModel != null) {
                    BillTipsFeeEditView billTipsFeeEditView = this.this$0;
                    if (billTipFeeModel.isPercent()) {
                        if (Integer.parseInt(obj) > billTipFeeModel.getMaxTipFeeRate()) {
                            this.isChanged = true;
                            int length = obj.length() - 1;
                            if (obj != null) {
                                String substring = obj.substring(0, length);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (substring != null) {
                                    String obj2 = StringsKt.trim(substring).toString();
                                    CustomerEditTextCompat access$getMTipFeeInputEt$p3 = billTipsFeeEditView.f38984d;
                                    if (access$getMTipFeeInputEt$p3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                                        access$getMTipFeeInputEt$p3 = null;
                                    }
                                    access$getMTipFeeInputEt$p3.setText(obj2);
                                    CustomerEditTextCompat access$getMTipFeeInputEt$p4 = billTipsFeeEditView.f38984d;
                                    if (access$getMTipFeeInputEt$p4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                                    } else {
                                        customerEditTextCompat = access$getMTipFeeInputEt$p4;
                                    }
                                    customerEditTextCompat.setSelection(obj.length() - 1);
                                    billTipsFeeEditView.showExceedMaxMessage();
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else if (Integer.parseInt(obj) * 100 > billTipFeeModel.getMaxTipFeePrice()) {
                        this.isChanged = true;
                        int length2 = obj.length() - 1;
                        if (obj != null) {
                            String substring2 = obj.substring(0, length2);
                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (substring2 != null) {
                                String obj3 = StringsKt.trim(substring2).toString();
                                CustomerEditTextCompat access$getMTipFeeInputEt$p5 = billTipsFeeEditView.f38984d;
                                if (access$getMTipFeeInputEt$p5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                                    access$getMTipFeeInputEt$p5 = null;
                                }
                                access$getMTipFeeInputEt$p5.setText(obj3);
                                CustomerEditTextCompat access$getMTipFeeInputEt$p6 = billTipsFeeEditView.f38984d;
                                if (access$getMTipFeeInputEt$p6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
                                } else {
                                    customerEditTextCompat = access$getMTipFeeInputEt$p6;
                                }
                                customerEditTextCompat.setSelection(obj.length() - 1);
                                billTipsFeeEditView.showExceedMaxMessage();
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }

    public final void showExceedMaxMessage() {
        ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.customer_bill_tip_exceed_max_message));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Context context = getContext();
        CustomerEditTextCompat customerEditTextCompat = this.f38984d;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat = null;
        }
        KeyboardUtils.showSoftInput(context, customerEditTextCompat);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Context context = getContext();
        CustomerEditTextCompat customerEditTextCompat = this.f38984d;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipFeeInputEt");
            customerEditTextCompat = null;
        }
        KeyboardUtils.hideSoftInput(context, customerEditTextCompat);
    }
}
