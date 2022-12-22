package com.didi.payment.kycservice.key.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.kycservice.common.PageRefreshEvent;
import com.didi.payment.kycservice.key.list.adaper.PixKeyListAdapter;
import com.didi.payment.kycservice.key.list.response.PixKeyListResp;
import com.didi.payment.kycservice.key.migrateout.PixKeyMigrateOutActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/list/PixKeyListActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/kycservice/key/list/PixKeyListVM;", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rvAdapter", "Lcom/didi/payment/kycservice/key/list/adaper/PixKeyListAdapter;", "toolbarBack", "Landroid/widget/ImageView;", "toolbarContainer", "Landroid/widget/RelativeLayout;", "toolbarTipContainer", "Landroid/view/ViewGroup;", "toolbarTipMsg", "Landroid/widget/TextView;", "toolbarTipNum", "tvMainTitle", "tvSubTitle", "getRvDivider", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getTitleBarView", "Landroid/view/View;", "initListener", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "subscribeUi", "vm", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyListActivity.kt */
public final class PixKeyListActivity extends WBaseActivity<PixKeyListVM> {

    /* renamed from: a */
    private RelativeLayout f30694a;

    /* renamed from: b */
    private ImageView f30695b;

    /* renamed from: c */
    private ViewGroup f30696c;

    /* renamed from: d */
    private TextView f30697d;

    /* renamed from: e */
    private TextView f30698e;

    /* renamed from: f */
    private TextView f30699f;

    /* renamed from: g */
    private TextView f30700g;

    /* renamed from: h */
    private RecyclerView f30701h;

    /* renamed from: i */
    private final PixKeyListAdapter f30702i = new PixKeyListAdapter(this, new PixKeyListActivity$rvAdapter$1(this));

    public static final /* synthetic */ PixKeyListVM access$getVm(PixKeyListActivity pixKeyListActivity) {
        return (PixKeyListVM) pixKeyListActivity.getVm();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pix_key_list_new);
        m21577b();
        m21573a();
        ViewModel viewModel = new ViewModelProvider(this).get(PixKeyListVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…PixKeyListVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((PixKeyListVM) getVm());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((PixKeyListVM) getVm()).loadData();
    }

    /* renamed from: a */
    private final void m21573a() {
        ImageView imageView = this.f30695b;
        ViewGroup viewGroup = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixKeyListActivity.m21574a(PixKeyListActivity.this, view);
            }
        });
        ViewGroup viewGroup2 = this.f30696c;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTipContainer");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixKeyListActivity.m21578b(PixKeyListActivity.this, view);
            }
        });
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixKeyListActivity.m21580c(PixKeyListActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21574a(PixKeyListActivity pixKeyListActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyListActivity, "this$0");
        pixKeyListActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21578b(PixKeyListActivity pixKeyListActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyListActivity, "this$0");
        pixKeyListActivity.startActivity(new Intent(pixKeyListActivity, PixKeyMigrateOutActivity.class));
        PixKeyListResp.Data value = ((PixKeyListVM) pixKeyListActivity.getVm()).getPixKeyListData().getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21580c(PixKeyListActivity pixKeyListActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyListActivity, "this$0");
        ((PixKeyListVM) pixKeyListActivity.getVm()).loadData();
    }

    public void subscribeUi(PixKeyListVM pixKeyListVM) {
        Intrinsics.checkNotNullParameter(pixKeyListVM, "vm");
        super.subscribeUi(pixKeyListVM);
        LifecycleOwner lifecycleOwner = this;
        pixKeyListVM.getPixKeyListData().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyListActivity.m21575a(PixKeyListActivity.this, (PixKeyListResp.Data) obj);
            }
        });
        pixKeyListVM.isNetError().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyListActivity.m21576a(PixKeyListActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21575a(PixKeyListActivity pixKeyListActivity, PixKeyListResp.Data data) {
        Intrinsics.checkNotNullParameter(pixKeyListActivity, "this$0");
        TextView textView = null;
        if (data.getPortabilityCount() > 0) {
            ViewGroup viewGroup = pixKeyListActivity.f30696c;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarTipContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            TextView textView2 = pixKeyListActivity.f30697d;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarTipNum");
                textView2 = null;
            }
            textView2.setText(String.valueOf(data.getPortabilityCount()));
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            TextView textView3 = pixKeyListActivity.f30698e;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarTipMsg");
                textView3 = null;
            }
            nViewUtils.setText(textView3, data.getPortabilityMessage());
        } else {
            ViewGroup viewGroup2 = pixKeyListActivity.f30696c;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarTipContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
        }
        TextView textView4 = pixKeyListActivity.f30699f;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
            textView4 = null;
        }
        textView4.setText(data.getTitle());
        TextView textView5 = pixKeyListActivity.f30700g;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
        } else {
            textView = textView5;
        }
        textView.setText(data.getSubTitle());
        ArrayList<PixKeyListResp.KeyItem> keyList = data.getKeyList();
        if (keyList != null) {
            if (data.getCanRegister()) {
                keyList.add(new PixKeyListResp.KeyItem(0, (String) null, (String) null, (String) null, false, 99, (PixKeyListResp.Detail) null, 95, (DefaultConstructorMarker) null));
            }
            pixKeyListActivity.f30702i.setData(keyList);
            if (keyList.size() <= 1) {
                EventBus.getDefault().post(new PageRefreshEvent("key_list"));
            }
            ArrayList<PixKeyListResp.KeyItem> keyList2 = data.getKeyList();
            Intrinsics.checkNotNull(keyList2);
            Iterator<PixKeyListResp.KeyItem> it = keyList2.iterator();
            while (it.hasNext()) {
                PixKeyListResp.KeyItem next = it.next();
                if (next.isDefault()) {
                    data.setDefaultKey(next.getValue());
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21576a(PixKeyListActivity pixKeyListActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixKeyListActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
        RecyclerView recyclerView = null;
        if (bool.booleanValue()) {
            TextView textView = pixKeyListActivity.f30699f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
                textView = null;
            }
            textView.setVisibility(8);
            TextView textView2 = pixKeyListActivity.f30700g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
                textView2 = null;
            }
            textView2.setVisibility(8);
            RecyclerView recyclerView2 = pixKeyListActivity.f30701h;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        TextView textView3 = pixKeyListActivity.f30699f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = pixKeyListActivity.f30700g;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
            textView4 = null;
        }
        textView4.setVisibility(0);
        RecyclerView recyclerView3 = pixKeyListActivity.f30701h;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        RelativeLayout relativeLayout = this.f30694a;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            relativeLayout = null;
        }
        return relativeLayout;
    }

    /* renamed from: b */
    private final void m21577b() {
        View findViewById = findViewById(R.id.pix_key_list_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_key_list_toolbar)");
        this.f30694a = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.pix_key_list_toolbar_back_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_key_list_toolbar_back_iv)");
        this.f30695b = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_key_list_toolbar_tip_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_ke…st_toolbar_tip_container)");
        this.f30696c = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.pix_key_list_tv_portability_num);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_key_list_tv_portability_num)");
        this.f30697d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.pix_key_list_tv_portability_msg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.pix_key_list_tv_portability_msg)");
        this.f30698e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.pix_key_list_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.pix_key_list_main_title)");
        this.f30699f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.pix_key_list_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.pix_key_list_sub_title)");
        this.f30700g = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.pix_key_list_recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.pix_key_list_recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById8;
        this.f30701h = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView3 = this.f30701h;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(m21579c());
        RecyclerView recyclerView4 = this.f30701h;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(this.f30702i);
        setErrViewContainer((ViewGroup) findViewById(R.id.pix_key_list_net_error_container));
    }

    /* renamed from: c */
    private final RecyclerView.ItemDecoration m21579c() {
        Context context = this;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.pix_rv_divider);
        Intrinsics.checkNotNull(drawable);
        dividerItemDecoration.setDrawable(drawable);
        return dividerItemDecoration;
    }
}
