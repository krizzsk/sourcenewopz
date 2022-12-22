package com.didi.payment.kycservice.key.create.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.kycservice.key.create.PixKeyCreateActivity;
import com.didi.payment.kycservice.key.create.PixKeyCreateVM;
import com.didi.payment.kycservice.module.TitleBarData;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByRandomFragment;", "Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyBaseFragment;", "()V", "tvRandom", "Landroid/widget/TextView;", "initListener", "", "initView", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyByRandomFragment.kt */
public final class CreateKeyByRandomFragment extends CreateKeyBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f30659a;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyByRandomFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "title", "", "subTitle", "keyVal", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateKeyByRandomFragment.kt */
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
            CreateKeyByRandomFragment createKeyByRandomFragment = new CreateKeyByRandomFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_TITLE, str);
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE, str2);
            bundle.putString("param_key_val", str3);
            createKeyByRandomFragment.setArguments(bundle);
            return createKeyByRandomFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.new_fragment_create_key_by_random, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m21559a(view);
        m21558a();
        subscribeUi(getVm());
    }

    /* renamed from: a */
    private final void m21559a(View view) {
        getTitleBarModule().bindData(new TitleBarData((String) null, getTitle(), getSubTitle(), false, 9, (DefaultConstructorMarker) null));
    }

    /* renamed from: a */
    private final void m21558a() {
        getTitleBarModule().setBackImgOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByRandomFragment.m21560a(CreateKeyByRandomFragment.this, view);
            }
        });
        getBtnContinue().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CreateKeyByRandomFragment.m21561b(CreateKeyByRandomFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21560a(CreateKeyByRandomFragment createKeyByRandomFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByRandomFragment, "this$0");
        FragmentActivity activity = createKeyByRandomFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21561b(CreateKeyByRandomFragment createKeyByRandomFragment, View view) {
        Intrinsics.checkNotNullParameter(createKeyByRandomFragment, "this$0");
        ((PixKeyCreateVM) createKeyByRandomFragment.getVm()).createPixKey(4, createKeyByRandomFragment.getKeyVal());
    }
}
