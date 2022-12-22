package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J0\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0018R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/widget/TabsView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "Lcom/didi/soda/blocks/model/ComponentModel;", "container", "Landroid/widget/LinearLayout;", "anchorToMiddle", "", "index", "bindData", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "tabList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "clickCallBack", "Lkotlin/Function1;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabsView.kt */
public final class TabsView extends HorizontalScrollView {

    /* renamed from: a */
    private BinderRootConfig<ComponentModel> f43333a;

    /* renamed from: b */
    private LinearLayout f43334b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabsView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TabsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = LayoutInflater.from(getContext()).inflate(R.layout.customer_landing_tabs_view, this, true).findViewById(R.id.customer_landing_tabs_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_landing_tabs_container)");
        this.f43334b = (LinearLayout) findViewById;
        setFillViewport(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r18v2, types: [com.didi.soda.home.widget.TabMultiItemView] */
    /* JADX WARNING: type inference failed for: r18v3, types: [com.didi.soda.home.widget.TabSingleItemView] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindData(com.didi.app.nova.skeleton.ScopeContext r25, java.util.List<com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity> r26, kotlin.jvm.functions.Function1<? super com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity, kotlin.Unit> r27) {
        /*
            r24 = this;
            r6 = r24
            r7 = r25
            r8 = r26
            java.lang.String r0 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "tabList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "clickCallBack"
            r9 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.widget.LinearLayout r0 = r6.f43334b
            java.lang.String r11 = "container"
            if (r0 != 0) goto L_0x0023
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r0 = 0
        L_0x0023:
            r0.removeAllViews()
            r0 = 2131167446(0x7f0708d6, float:1.7949166E38)
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r0)
            android.widget.LinearLayout r1 = r6.f43334b
            if (r1 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r1 = 0
        L_0x0035:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r2.<init>(r3, r3)
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r1.setLayoutParams(r2)
            int r1 = r26.size()
            if (r1 == 0) goto L_0x010d
            r2 = 0
            r4 = 0
            r12 = 1
            if (r1 == r12) goto L_0x0072
            r5 = 2
            if (r1 == r5) goto L_0x0058
            r1 = 2131167782(0x7f070a26, float:1.7949847E38)
            int r3 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r1)
            r13 = r0
            r14 = r3
            goto L_0x007b
        L_0x0058:
            r4 = 1065353216(0x3f800000, float:1.0)
            android.widget.LinearLayout r1 = r6.f43334b
            if (r1 != 0) goto L_0x0062
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r1 = 0
        L_0x0062:
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r13 = -1
            r5.<init>(r13, r3)
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r1.setLayoutParams(r5)
            r13 = r0
            r14 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x007c
        L_0x0072:
            r0 = 2131168281(0x7f070c19, float:1.795086E38)
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r0)
            r13 = r0
            r14 = -2
        L_0x007b:
            r15 = 0
        L_0x007c:
            r0 = r8
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r16 = r0.iterator()
            r4 = 0
        L_0x0084:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x010c
            java.lang.Object r0 = r16.next()
            int r17 = r4 + 1
            if (r4 >= 0) goto L_0x0095
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0095:
            r1 = r0
            com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity r1 = (com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity) r1
            int r0 = r26.size()
            java.lang.String r2 = "context"
            if (r0 != r12) goto L_0x00b9
            com.didi.soda.home.widget.TabSingleItemView r0 = new com.didi.soda.home.widget.TabSingleItemView
            android.content.Context r3 = r24.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r20 = 0
            r21 = 0
            r22 = 6
            r23 = 0
            r18 = r0
            r19 = r3
            r18.<init>(r19, r20, r21, r22, r23)
            goto L_0x00d1
        L_0x00b9:
            com.didi.soda.home.widget.TabMultiItemView r0 = new com.didi.soda.home.widget.TabMultiItemView
            android.content.Context r3 = r24.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r20 = 0
            r21 = 0
            r22 = 6
            r23 = 0
            r18 = r0
            r19 = r3
            r18.<init>(r19, r20, r21, r22, r23)
        L_0x00d1:
            com.didi.soda.home.widget.ITabItemView r0 = (com.didi.soda.home.widget.ITabItemView) r0
            r5 = r0
            r1.setIndex(r4)
            r5.bindData(r7, r1)
            android.view.View r3 = r5.getView()
            com.didi.soda.home.widget.-$$Lambda$TabsView$W9Q7kry8kuPU_sr2YO8VnfJGOHQ r2 = new com.didi.soda.home.widget.-$$Lambda$TabsView$W9Q7kry8kuPU_sr2YO8VnfJGOHQ
            r0 = r2
            r10 = r2
            r2 = r26
            r12 = r3
            r3 = r24
            r20 = r5
            r5 = r27
            r0.<init>(r2, r3, r4, r5)
            r12.setOnClickListener(r10)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r0.<init>(r14, r13, r15)
            android.widget.LinearLayout r1 = r6.f43334b
            if (r1 != 0) goto L_0x00fe
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r1 = 0
        L_0x00fe:
            android.view.View r2 = r20.getView()
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r1.addView(r2, r0)
            r4 = r17
            r12 = 1
            goto L_0x0084
        L_0x010c:
            return
        L_0x010d:
            r0 = 8
            r6.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.widget.TabsView.bindData(com.didi.app.nova.skeleton.ScopeContext, java.util.List, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30647a(TabInfoEntity tabInfoEntity, List list, TabsView tabsView, int i, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(tabInfoEntity, "$tabInfoEntity");
        Intrinsics.checkNotNullParameter(list, "$tabList");
        Intrinsics.checkNotNullParameter(tabsView, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$clickCallBack");
        if (tabInfoEntity.isSelect() != 1) {
            if (list.size() > 2) {
                tabsView.m30646a(i);
            }
            function1.invoke(tabInfoEntity);
        }
    }

    /* renamed from: a */
    private final void m30646a(int i) {
        LinearLayout linearLayout = this.f43334b;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > i) {
            int width = getWidth();
            LinearLayout linearLayout3 = this.f43334b;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("container");
            } else {
                linearLayout2 = linearLayout3;
            }
            View childAt = linearLayout2.getChildAt(i);
            scrollTo((childAt.getLeft() + (childAt.getWidth() / 2)) - (width / 2), 0);
        }
    }
}
