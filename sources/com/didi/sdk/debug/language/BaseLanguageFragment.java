package com.didi.sdk.debug.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/BaseLanguageFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/didi/sdk/debug/language/LanguageDebugAdapter;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "rootView", "Landroid/view/View;", "title", "Landroid/widget/TextView;", "getData", "Ljava/util/ArrayList;", "Lcom/didi/sdk/debug/language/LanguageModel;", "Lkotlin/collections/ArrayList;", "getTitle", "", "initView", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateData", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseLanguageFragment.kt */
public abstract class BaseLanguageFragment extends Fragment {

    /* renamed from: a */
    private RecyclerView f35791a;

    /* renamed from: b */
    private View f35792b;

    /* renamed from: c */
    private TextView f35793c;

    /* renamed from: d */
    private LanguageDebugAdapter f35794d = new LanguageDebugAdapter();

    public void _$_clearFindViewByIdCache() {
    }

    public abstract ArrayList<LanguageModel> getData();

    public abstract String getTitle();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_language_base, (ViewGroup) null);
        this.f35792b = inflate;
        Intrinsics.checkNotNull(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m25346b();
        m25345a();
    }

    /* renamed from: a */
    private final void m25345a() {
        this.f35794d.updateList(getData());
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25346b() {
        /*
            r4 = this;
            android.view.View r0 = r4.f35792b
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = r1
            goto L_0x0010
        L_0x0007:
            r2 = 2131433523(0x7f0b1833, float:1.8488834E38)
            android.view.View r0 = r0.findViewById(r2)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
        L_0x0010:
            r4.f35791a = r0
            if (r0 != 0) goto L_0x0015
            goto L_0x0023
        L_0x0015:
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r4.getContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r0.setLayoutManager(r2)
        L_0x0023:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f35791a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.didi.sdk.debug.language.LanguageDebugAdapter r2 = r4.f35794d
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r0.setAdapter(r2)
        L_0x002f:
            android.view.View r0 = r4.f35792b
            if (r0 != 0) goto L_0x0034
            goto L_0x003e
        L_0x0034:
            r1 = 2131434585(0x7f0b1c59, float:1.8490988E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x003e:
            r4.f35793c = r1
            if (r1 != 0) goto L_0x0043
            goto L_0x004c
        L_0x0043:
            java.lang.String r0 = r4.getTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.debug.language.BaseLanguageFragment.m25346b():void");
    }
}
