package com.didi.soda.blocks.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.yoga.android.YogaLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fJ\u001e\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/BlockLayoutKT;", "Lcom/facebook/yoga/android/YogaLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addView", "", "subBinder", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/view/View;", "index", "keyboardNavigationClusterSearch", "currentCluster", "direction", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BlockLayoutKT.kt */
public final class BlockLayoutKT extends YogaLayout {
    private HashMap _$_findViewCache;

    public BlockLayoutKT(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public BlockLayoutKT(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlockLayoutKT(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public BlockLayoutKT(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void addView(BaseBinder<? extends View> baseBinder) {
        Intrinsics.checkParameterIsNotNull(baseBinder, "subBinder");
        addView(baseBinder, -1);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.didi.soda.blocks.style.BaseBinder, java.lang.Object, com.didi.soda.blocks.style.BaseBinder<? extends android.view.View>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addView(com.didi.soda.blocks.style.BaseBinder<? extends android.view.View> r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "subBinder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            android.view.View r0 = r3.getView()
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x001b
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r1 = r3.getView()
            r0.removeView(r1)
        L_0x001b:
            com.facebook.yoga.YogaNode r0 = r3.getYogaNode()
            android.view.View r3 = r3.getView()
            r2.addView(r3, r0)
            com.facebook.yoga.YogaNode r3 = r2.getYogaNode()
            java.lang.String r1 = "yogaNode"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r1)
            int r3 = r3.getChildCount()
            if (r4 >= 0) goto L_0x0037
            r4 = r3
        L_0x0037:
            com.facebook.yoga.YogaNode r3 = r2.getYogaNode()
            r3.addChildAt(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.style.BlockLayoutKT.addView(com.didi.soda.blocks.style.BaseBinder, int):void");
    }

    public View keyboardNavigationClusterSearch(View view, int i) {
        return this;
    }
}
