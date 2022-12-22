package com.didi.payment.kycservice.key.create.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.didi.payment.commonsdk.utils.NKeyboardChangeListener;
import com.didi.payment.kycservice.key.create.PixKeyCreateActivity;
import com.didi.payment.kycservice.key.create.PixKeyCreateVM;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.module.TitleBarData;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u001a\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByPhoneFragment;", "Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyBaseFragment;", "()V", "NKeyboardChangeListener", "Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener;", "etPhoneNumber", "Landroid/widget/EditText;", "ivDelete", "Landroid/widget/ImageView;", "llRootView", "Landroid/widget/LinearLayout;", "tvCountryCode", "Landroid/widget/TextView;", "checkDataValid", "", "initListener", "", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onHiddenChanged", "hidden", "onViewCreated", "subscribeUi", "vm", "Lcom/didi/payment/kycservice/key/create/PixKeyCreateVM;", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyByPhoneFragment.kt */
public final class CreateKeyByPhoneFragment extends CreateKeyBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private LinearLayout f30654a;

    /* renamed from: b */
    private TextView f30655b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f30656c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageView f30657d;

    /* renamed from: e */
    private NKeyboardChangeListener f30658e;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByPhoneFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "title", "", "subTitle", "keyVal", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateKeyByPhoneFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subTitle");
            Intrinsics.checkNotNullParameter(str3, "keyVal");
            CreateKeyByPhoneFragment createKeyByPhoneFragment = new CreateKeyByPhoneFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_TITLE, str);
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE, str2);
            bundle.putString("param_key_val", str3);
            createKeyByPhoneFragment.setArguments(bundle);
            return createKeyByPhoneFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.new_fragment_create_key_by_phone, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m21550a(view);
        m21549a();
        subscribeUi((PixKeyCreateVM) getVm());
    }

    /* renamed from: a */
    private final void m21550a(View view) {
        View findViewById = view.findViewById(R.id.pix_create_key_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.pix_create_key_root_view)");
        this.f30654a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_create_key_country_code_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.p…te_key_country_code_view)");
        this.f30655b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_create_key_phone_number_et);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.p…eate_key_phone_number_et)");
        EditText editText = (EditText) findViewById3;
        this.f30656c = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        editText.setText(getKeyVal());
        View findViewById4 = view.findViewById(R.id.pix_create_key_phone_del_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.p…_create_key_phone_del_iv)");
        this.f30657d = (ImageView) findViewById4;
        getTitleBarModule().bindData(new TitleBarData((String) null, getTitle(), getSubTitle(), false, 9, (DefaultConstructorMarker) null));
        getBtnContinue().setEnabled(m21556b());
    }

    /* renamed from: a */
    private final void m21549a() {
        getTitleBarModule().setBackImgOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByPhoneFragment.m21551a(CreateKeyByPhoneFragment.this, view);
            }
        });
        getBtnContinue().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByPhoneFragment.m21555b(CreateKeyByPhoneFragment.this, view);
            }
        });
        EditText editText = this.f30656c;
        LinearLayout linearLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CreateKeyByPhoneFragment.m21552a(CreateKeyByPhoneFragment.this, view, z);
            }
        });
        EditText editText2 = this.f30656c;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText2 = null;
        }
        editText2.addTextChangedListener(new C10751x1dddbca1(this));
        ImageView imageView = this.f30657d;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByPhoneFragment.m21557c(CreateKeyByPhoneFragment.this, view);
            }
        });
        LinearLayout linearLayout2 = this.f30654a;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRootView");
            linearLayout2 = null;
        }
        NKeyboardChangeListener nKeyboardChangeListener = new NKeyboardChangeListener(linearLayout2);
        this.f30658e = nKeyboardChangeListener;
        if (nKeyboardChangeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("NKeyboardChangeListener");
            nKeyboardChangeListener = null;
        }
        nKeyboardChangeListener.setKeyBoardListener(new CreateKeyByPhoneFragment$initListener$6(this));
        LinearLayout linearLayout3 = this.f30654a;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRootView");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CreateKeyByPhoneFragment.m21554a(CreateKeyByPhoneFragment.this, view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21551a(CreateKeyByPhoneFragment createKeyByPhoneFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        FragmentActivity activity = createKeyByPhoneFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21555b(CreateKeyByPhoneFragment createKeyByPhoneFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        PixKeyCreateVM pixKeyCreateVM = (PixKeyCreateVM) createKeyByPhoneFragment.getVm();
        EditText editText = createKeyByPhoneFragment.f30656c;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        pixKeyCreateVM.createPixKey(3, Intrinsics.stringPlus("+55", editText.getText()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21552a(CreateKeyByPhoneFragment createKeyByPhoneFragment, View view, boolean z) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        EditText editText = createKeyByPhoneFragment.f30656c;
        ImageView imageView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        CharSequence text = editText.getText();
        if (text == null || text.length() == 0) {
            ImageView imageView2 = createKeyByPhoneFragment.f30657d;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = createKeyByPhoneFragment.f30657d;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21557c(CreateKeyByPhoneFragment createKeyByPhoneFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        EditText editText = createKeyByPhoneFragment.f30656c;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        editText.setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m21554a(CreateKeyByPhoneFragment createKeyByPhoneFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        if (motionEvent.getAction() == 1) {
            FragmentActivity activity = createKeyByPhoneFragment.getActivity();
            View currentFocus = activity == null ? null : activity.getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                ((EditText) currentFocus).getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    Object systemService = createKeyByPhoneFragment.requireActivity().getSystemService("input_method");
                    if (systemService != null) {
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    }
                }
            }
        }
        return true;
    }

    public void subscribeUi(PixKeyCreateVM pixKeyCreateVM) {
        Intrinsics.checkNotNullParameter(pixKeyCreateVM, "vm");
        super.subscribeUi(pixKeyCreateVM);
        pixKeyCreateVM.getShowMigrateTipLD().observe(getViewLifecycleOwner(), new Observer(pixKeyCreateVM) {
            public final /* synthetic */ PixKeyCreateVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                CreateKeyByPhoneFragment.m21553a(CreateKeyByPhoneFragment.this, this.f$1, (MigrateTipData) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21553a(CreateKeyByPhoneFragment createKeyByPhoneFragment, PixKeyCreateVM pixKeyCreateVM, MigrateTipData migrateTipData) {
        Intrinsics.checkNotNullParameter(createKeyByPhoneFragment, "this$0");
        Intrinsics.checkNotNullParameter(pixKeyCreateVM, "$vm");
        Intrinsics.checkNotNullExpressionValue(migrateTipData, "migrateData");
        createKeyByPhoneFragment.showMigrateDlg(migrateTipData, 3, pixKeyCreateVM.getKeyVal());
    }

    public void onHiddenChanged(boolean z) {
        EditText editText = this.f30656c;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        editText.setEnabled(!z);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m21556b() {
        EditText editText = this.f30656c;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            editText = null;
        }
        String obj = editText.getEditableText().toString();
        return !TextUtils.isEmpty(obj) && obj.length() >= 11;
    }
}
