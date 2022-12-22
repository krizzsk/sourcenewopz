package com.didi.payment.pix.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.commonsdk.view.CommonAbsSectionView;
import com.didi.payment.commonsdk.view.adapter.OperationBannerAdapter;
import com.didi.payment.commonsdk.view.helper.GravitySnapHelper;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001 B\u0011\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB!\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/pix/home/view/PixOperationBannerEntranceView;", "Lcom/didi/payment/commonsdk/view/CommonAbsSectionView;", "Lcom/didi/payment/pix/home/PixChannelResp$PanelSection;", "Lcom/didi/payment/pix/home/view/PixOperationBannerEntranceView$OperationItemListener;", "Lcom/didi/payment/commonsdk/view/adapter/OperationBannerAdapter$AdapterItemCallback;", "Lcom/didi/payment/pix/home/PixChannelResp$PanelEntry;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdapter", "Lcom/didi/payment/pix/home/view/PixOperationBannerAdapter;", "getMAdapter", "()Lcom/didi/payment/pix/home/view/PixOperationBannerAdapter;", "setMAdapter", "(Lcom/didi/payment/pix/home/view/PixOperationBannerAdapter;)V", "mRvOperationList", "Landroidx/recyclerview/widget/RecyclerView;", "mTvTitle", "Landroid/widget/TextView;", "init", "", "initSnapHelper", "onItemClicked", "item", "updateContent", "operationSection", "OperationItemListener", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOperationBannerEntranceView.kt */
public final class PixOperationBannerEntranceView extends CommonAbsSectionView<PixChannelResp.PanelSection, OperationItemListener> implements OperationBannerAdapter.AdapterItemCallback<PixChannelResp.PanelEntry> {

    /* renamed from: a */
    private TextView f31074a;

    /* renamed from: b */
    private RecyclerView f31075b;
    public PixOperationBannerAdapter mAdapter;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/pix/home/view/PixOperationBannerEntranceView$OperationItemListener;", "", "onOperationItemClicked", "", "item", "Lcom/didi/payment/pix/home/PixChannelResp$PanelEntry;", "onOperationItemShown", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixOperationBannerEntranceView.kt */
    public interface OperationItemListener {
        void onOperationItemClicked(PixChannelResp.PanelEntry panelEntry);

        void onOperationItemShown(PixChannelResp.PanelEntry panelEntry);
    }

    public final PixOperationBannerAdapter getMAdapter() {
        PixOperationBannerAdapter pixOperationBannerAdapter = this.mAdapter;
        if (pixOperationBannerAdapter != null) {
            return pixOperationBannerAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    public final void setMAdapter(PixOperationBannerAdapter pixOperationBannerAdapter) {
        Intrinsics.checkNotNullParameter(pixOperationBannerAdapter, "<set-?>");
        this.mAdapter = pixOperationBannerAdapter;
    }

    public PixOperationBannerEntranceView(Context context) {
        super(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixOperationBannerEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixOperationBannerEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pix_home_operation_banner_layout, this, true);
        View findViewById = findViewById(R.id.tv_operation_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_operation_title)");
        this.f31074a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.rv_operation_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rv_operation_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.f31075b = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = this.f31075b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
            recyclerView3 = null;
        }
        recyclerView3.setNestedScrollingEnabled(false);
        RecyclerView recyclerView4 = this.f31075b;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(new PixOperationBannerEntranceView$init$1(this));
        RecyclerView recyclerView5 = this.f31075b;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
            recyclerView5 = null;
        }
        recyclerView5.addOnScrollListener(new PixOperationBannerEntranceView$init$2(this));
        setMAdapter(new PixOperationBannerAdapter(getContext(), this));
        RecyclerView recyclerView6 = this.f31075b;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
        } else {
            recyclerView2 = recyclerView6;
        }
        recyclerView2.setAdapter(getMAdapter());
        m21863a();
    }

    /* renamed from: a */
    private final void m21863a() {
        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(GravityCompat.START);
        gravitySnapHelper.setSnapToPadding(false);
        gravitySnapHelper.setSnapLastItem(false);
        gravitySnapHelper.setMaxFlingSizeFraction(1.0f);
        gravitySnapHelper.setScrollMsPerInch(50.0f);
        RecyclerView recyclerView = this.f31075b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvOperationList");
            recyclerView = null;
        }
        gravitySnapHelper.attachToRecyclerView(recyclerView);
    }

    public void updateContent(PixChannelResp.PanelSection panelSection) {
        if (panelSection == null || CollectionUtil.isEmpty((Collection) panelSection.getPanelList())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        TextView textView = this.f31074a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
            textView = null;
        }
        textView.setVisibility(4);
        getMAdapter().setData(panelSection.getPanelList());
        if (this.mListener != null) {
            ((OperationItemListener) this.mListener).onOperationItemShown(panelSection.getPanelList().get(0));
        }
    }

    public void onItemClicked(PixChannelResp.PanelEntry panelEntry) {
        if (this.mListener != null) {
            ((OperationItemListener) this.mListener).onOperationItemClicked(panelEntry);
        }
    }
}
