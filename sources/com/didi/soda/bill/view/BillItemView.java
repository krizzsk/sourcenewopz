package com.didi.soda.bill.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.raven.config.RavenKey;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.logic.ItemViewAbsLogic;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB'\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J\r\u0010\u001a\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010'\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&R\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/bill/view/BillItemView;", "L", "Lcom/didi/soda/bill/view/item/logic/ItemViewAbsLogic;", "Landroid/widget/FrameLayout;", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "context", "Landroid/content/Context;", "isNewVersion", "", "(Landroid/content/Context;Z)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "<set-?>", "()Z", "mItemViewLogic", "attach", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "itemViewLogic", "getLogic", "()Lcom/didi/soda/bill/view/item/logic/ItemViewAbsLogic;", "initView", "needBinderBackground", "needExtraPadding", "needFocusContent", "onCreate", "live", "Lcom/didi/app/nova/skeleton/ILive;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "performAutoClick", "type", "bundle", "Landroid/os/Bundle;", "setData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemView.kt */
public abstract class BillItemView<L extends ItemViewAbsLogic> extends FrameLayout implements IScopeLifecycle {

    /* renamed from: a */
    private ItemViewAbsLogic f39162a;

    /* renamed from: b */
    private boolean f39163b;

    public void _$_clearFindViewByIdCache() {
    }

    public void initView() {
    }

    public boolean needBinderBackground() {
        return true;
    }

    public boolean needExtraPadding() {
        return true;
    }

    public boolean needFocusContent() {
        return false;
    }

    public void onCreate(ILive iLive) {
    }

    public void onPause(ILive iLive) {
    }

    public void onResume(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    public void performAutoClick(int i, Bundle bundle) {
    }

    public abstract void setData(ComponentModel componentModel);

    public final boolean isNewVersion() {
        return this.f39163b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillItemView(Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f39163b = z;
        initView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillItemView(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    public final void attach(ComponentModel componentModel, ItemViewAbsLogic itemViewAbsLogic) {
        ScopeContext scopeContext;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        this.f39162a = itemViewAbsLogic;
        if (!(itemViewAbsLogic == null || (scopeContext = itemViewAbsLogic.getScopeContext()) == null)) {
            scopeContext.addObserver(this);
        }
        setData(componentModel);
    }

    public final L getLogic() {
        L l = this.f39162a;
        if (l == null) {
            return (ItemViewAbsLogic) null;
        }
        if (l != null) {
            return l;
        }
        throw new NullPointerException("null cannot be cast to non-null type L of com.didi.soda.bill.view.BillItemView.getLogic$lambda-0");
    }

    public void onDestroy(ILive iLive) {
        ScopeContext scopeContext;
        ItemViewAbsLogic itemViewAbsLogic = this.f39162a;
        if (itemViewAbsLogic != null && (scopeContext = itemViewAbsLogic.getScopeContext()) != null) {
            scopeContext.removeObserver(this);
        }
    }
}
