package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006+"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/ChooseTypeBaseFragment;", "T", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rvAdapter", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter;", "getRvAdapter", "()Lcom/didi/payment/kycservice/kyc/fragment/SignUpRvAdapter;", "titlePrefix", "", "getTitlePrefix", "()Ljava/lang/String;", "setTitlePrefix", "(Ljava/lang/String;)V", "tvMainTitle", "Landroid/widget/TextView;", "getTvMainTitle", "()Landroid/widget/TextView;", "setTvMainTitle", "(Landroid/widget/TextView;)V", "tvSubTitle", "getTvSubTitle", "setTvSubTitle", "getRvDivider", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getTitleBarView", "Landroid/view/View;", "initView", "", "rootView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseTypeBaseFragment.kt */
public class ChooseTypeBaseFragment<T extends WBaseViewModel> extends WBaseFragment<T> {

    /* renamed from: a */
    private RecyclerView f30760a;

    /* renamed from: b */
    private String f30761b = "";

    /* renamed from: c */
    private final SignUpRvAdapter f30762c = new SignUpRvAdapter();
    protected TextView tvMainTitle;
    protected TextView tvSubTitle;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final TextView getTvMainTitle() {
        TextView textView = this.tvMainTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setTvMainTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvMainTitle = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getTvSubTitle() {
        TextView textView = this.tvSubTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setTvSubTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubTitle = textView;
    }

    /* access modifiers changed from: protected */
    public final String getTitlePrefix() {
        return this.f30761b;
    }

    /* access modifiers changed from: protected */
    public final void setTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30761b = str;
    }

    /* access modifiers changed from: protected */
    public final SignUpRvAdapter getRvAdapter() {
        return this.f30762c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ChooseTypeBaseFragmentKt.PARAM_TITLE_PREFIX, "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(PARAM_TITLE_PREFIX, \"\")");
            setTitlePrefix(string);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_pix_common_sign_up_choose_type, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m21644a(view);
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ChooseTypeBaseFragment.m21645a(ChooseTypeBaseFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21645a(ChooseTypeBaseFragment chooseTypeBaseFragment, View view) {
        Intrinsics.checkNotNullParameter(chooseTypeBaseFragment, "this$0");
        chooseTypeBaseFragment.getVm().loadData();
    }

    /* renamed from: a */
    private final void m21644a(View view) {
        View findViewById = view.findViewById(R.id.pix_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.pix_main_title)");
        setTvMainTitle((TextView) findViewById);
        View findViewById2 = view.findViewById(R.id.pix_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.pix_sub_title)");
        setTvSubTitle((TextView) findViewById2);
        View findViewById3 = view.findViewById(R.id.pix_sign_up_recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…pix_sign_up_recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.f30760a = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.f30760a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(m21643a());
        RecyclerView recyclerView4 = this.f30760a;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(this.f30762c);
        setErrViewContainer((ViewGroup) view.findViewById(R.id.pix_net_error_container));
    }

    /* renamed from: a */
    private final RecyclerView.ItemDecoration m21643a() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Context context = getContext();
        Drawable drawable = context == null ? null : ContextCompat.getDrawable(context, R.drawable.pix_rv_divider);
        Intrinsics.checkNotNull(drawable);
        dividerItemDecoration.setDrawable(drawable);
        return dividerItemDecoration;
    }
}
