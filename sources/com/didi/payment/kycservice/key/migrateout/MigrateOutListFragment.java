package com.didi.payment.kycservice.key.migrateout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.key.migrateout.adapter.MigrateOutListAdapter;
import com.didi.payment.kycservice.key.migrateout.p132vm.PixKeyMigrateOutVM;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/MigrateOutListFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM;", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rvAdapter", "Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter;", "tvMainTitle", "Landroid/widget/TextView;", "getRvDivider", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getTitleBarView", "Landroid/view/View;", "initView", "", "rootView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MigrateOutListFragment.kt */
public final class MigrateOutListFragment extends WBaseFragment<PixKeyMigrateOutVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f30713a;

    /* renamed from: b */
    private RecyclerView f30714b;

    /* renamed from: c */
    private MigrateOutListAdapter f30715c;

    @JvmStatic
    public static final MigrateOutListFragment newInstance() {
        return Companion.newInstance();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public static final /* synthetic */ PixKeyMigrateOutVM access$getVm(MigrateOutListFragment migrateOutListFragment) {
        return (PixKeyMigrateOutVM) migrateOutListFragment.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/MigrateOutListFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/key/migrateout/MigrateOutListFragment;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MigrateOutListFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MigrateOutListFragment newInstance() {
            return new MigrateOutListFragment();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(PixKeyMigrateOutVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…MigrateOutVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        this.f30715c = new MigrateOutListAdapter(new MigrateOutListFragment$onCreate$1(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_migrate_out_list_new, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m21587a(view);
        PixKeyMigrateOutListResp.Data migrateOutListData = ((PixKeyMigrateOutVM) getVm()).getMigrateOutListData();
        TextView textView = this.f30713a;
        MigrateOutListAdapter migrateOutListAdapter = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
            textView = null;
        }
        textView.setText(migrateOutListData.getTitle());
        if (migrateOutListData.getItems() != null) {
            MigrateOutListAdapter migrateOutListAdapter2 = this.f30715c;
            if (migrateOutListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            } else {
                migrateOutListAdapter = migrateOutListAdapter2;
            }
            ArrayList<PixKeyMigrateOutListResp.KeyItem> items = migrateOutListData.getItems();
            Intrinsics.checkNotNull(items);
            migrateOutListAdapter.setData(items);
        }
    }

    /* renamed from: a */
    private final void m21587a(View view) {
        View findViewById = view.findViewById(R.id.pix_key_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.pix_key_main_title)");
        this.f30713a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_key_migrate_recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…key_migrate_recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.f30714b = recyclerView;
        MigrateOutListAdapter migrateOutListAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView2 = this.f30714b;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.addItemDecoration(m21586a());
        RecyclerView recyclerView3 = this.f30714b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        MigrateOutListAdapter migrateOutListAdapter2 = this.f30715c;
        if (migrateOutListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        } else {
            migrateOutListAdapter = migrateOutListAdapter2;
        }
        recyclerView3.setAdapter(migrateOutListAdapter);
    }

    /* renamed from: a */
    private final RecyclerView.ItemDecoration m21586a() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), 1);
        Context context = getContext();
        Drawable drawable = context == null ? null : ContextCompat.getDrawable(context, R.drawable.pix_rv_divider);
        Intrinsics.checkNotNull(drawable);
        dividerItemDecoration.setDrawable(drawable);
        return dividerItemDecoration;
    }
}
