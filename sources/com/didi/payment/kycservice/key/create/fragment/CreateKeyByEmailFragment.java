package com.didi.payment.kycservice.key.create.fragment;

import android.graphics.Rect;
import android.os.Bundle;
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
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByEmailFragment;", "Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyBaseFragment;", "()V", "NKeyboardChangeListener", "Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener;", "inputViewNew", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "ivDelete", "Landroid/widget/ImageView;", "llRootView", "Landroid/widget/LinearLayout;", "initListener", "", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onHiddenChanged", "hidden", "", "onViewCreated", "subscribeUi", "vm", "Lcom/didi/payment/kycservice/key/create/PixKeyCreateVM;", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyByEmailFragment.kt */
public final class CreateKeyByEmailFragment extends CreateKeyBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private LinearLayout f30650a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public NewPixInputView f30651b;

    /* renamed from: c */
    private ImageView f30652c;

    /* renamed from: d */
    private NKeyboardChangeListener f30653d;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByEmailFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "title", "", "subTitle", "keyVal", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateKeyByEmailFragment.kt */
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
            CreateKeyByEmailFragment createKeyByEmailFragment = new CreateKeyByEmailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_TITLE, str);
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE, str2);
            bundle.putString("param_key_val", str3);
            createKeyByEmailFragment.setArguments(bundle);
            return createKeyByEmailFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.new_fragment_create_key_by_email, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m21544a(view);
        m21543a();
        subscribeUi((PixKeyCreateVM) getVm());
    }

    /* renamed from: a */
    private final void m21544a(View view) {
        View findViewById = view.findViewById(R.id.create_key_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.create_key_root_view)");
        this.f30650a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.create_key_input_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.create_key_input_view)");
        NewPixInputView newPixInputView = (NewPixInputView) findViewById2;
        this.f30651b = newPixInputView;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            newPixInputView = null;
        }
        newPixInputView.setInputStr(getKeyVal());
        getTitleBarModule().bindData(new TitleBarData((String) null, getTitle(), getSubTitle(), false, 9, (DefaultConstructorMarker) null));
        TextView btnContinue = getBtnContinue();
        KycRegisterUtils kycRegisterUtils = KycRegisterUtils.INSTANCE;
        NewPixInputView newPixInputView3 = this.f30651b;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
        } else {
            newPixInputView2 = newPixInputView3;
        }
        btnContinue.setEnabled(kycRegisterUtils.checkEmail(newPixInputView2.getInputStr()));
    }

    /* renamed from: a */
    private final void m21543a() {
        getTitleBarModule().setBackImgOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByEmailFragment.m21545a(CreateKeyByEmailFragment.this, view);
            }
        });
        getBtnContinue().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByEmailFragment.m21548b(CreateKeyByEmailFragment.this, view);
            }
        });
        NewPixInputView newPixInputView = this.f30651b;
        LinearLayout linearLayout = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            newPixInputView = null;
        }
        newPixInputView.addTextChangeListener(new CreateKeyByEmailFragment$initListener$3(this));
        LinearLayout linearLayout2 = this.f30650a;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRootView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CreateKeyByEmailFragment.m21547a(CreateKeyByEmailFragment.this, view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21545a(CreateKeyByEmailFragment createKeyByEmailFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByEmailFragment, "this$0");
        FragmentActivity activity = createKeyByEmailFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21548b(CreateKeyByEmailFragment createKeyByEmailFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByEmailFragment, "this$0");
        PixKeyCreateVM pixKeyCreateVM = (PixKeyCreateVM) createKeyByEmailFragment.getVm();
        NewPixInputView newPixInputView = createKeyByEmailFragment.f30651b;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            newPixInputView = null;
        }
        pixKeyCreateVM.createPixKey(2, newPixInputView.getInputStr());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m21547a(CreateKeyByEmailFragment createKeyByEmailFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(createKeyByEmailFragment, "this$0");
        if (motionEvent.getAction() == 1) {
            FragmentActivity activity = createKeyByEmailFragment.getActivity();
            View currentFocus = activity == null ? null : activity.getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                ((EditText) currentFocus).getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    Object systemService = createKeyByEmailFragment.requireActivity().getSystemService("input_method");
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
        pixKeyCreateVM.getShowMigrateTipLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CreateKeyByEmailFragment.m21546a(CreateKeyByEmailFragment.this, (MigrateTipData) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21546a(CreateKeyByEmailFragment createKeyByEmailFragment, MigrateTipData migrateTipData) {
        Intrinsics.checkNotNullParameter(createKeyByEmailFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(migrateTipData, "migrateData");
        NewPixInputView newPixInputView = createKeyByEmailFragment.f30651b;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            newPixInputView = null;
        }
        createKeyByEmailFragment.showMigrateDlg(migrateTipData, 2, newPixInputView.getInputStr());
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onHiddenChanged(boolean z) {
        NewPixInputView newPixInputView = this.f30651b;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputViewNew");
            newPixInputView = null;
        }
        newPixInputView.setEditViewEnabled(!z);
    }
}
