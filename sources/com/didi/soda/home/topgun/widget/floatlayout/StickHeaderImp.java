package com.didi.soda.home.topgun.widget.floatlayout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0013J \u0010#\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/StickHeaderImp;", "", "()V", "TAG", "", "<set-?>", "", "headerIsFloat", "getHeaderIsFloat", "()Z", "onFloatListener", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatListener;", "getOnFloatListener", "()Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatListener;", "setOnFloatListener", "(Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatListener;)V", "stickHeaderParent", "Landroid/view/ViewGroup;", "stickHeaderView", "Landroid/view/View;", "stickHolder", "Lcom/didi/soda/home/topgun/widget/floatlayout/IHeaderStickHolder;", "addIntoFloatView", "", "addPlaceView", "viewGroup", "floatViewHeight", "", "getFloatOffset", "getIntoFloatValue", "getVisibleHeight", "itemView", "internalIntoFloat", "floatView", "isIntoFloat", "onHeaderScroll", "onRecycleScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setup", "viewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StickHeaderImp.kt */
public final class StickHeaderImp {

    /* renamed from: a */
    private final String f43258a = "StickHeaderImp";

    /* renamed from: b */
    private OnHeaderFloatListener f43259b;

    /* renamed from: c */
    private ViewGroup f43260c;

    /* renamed from: d */
    private View f43261d;

    /* renamed from: e */
    private IHeaderStickHolder f43262e;

    /* renamed from: f */
    private boolean f43263f;

    public final OnHeaderFloatListener getOnFloatListener() {
        return this.f43259b;
    }

    public final void setOnFloatListener(OnHeaderFloatListener onHeaderFloatListener) {
        this.f43259b = onHeaderFloatListener;
    }

    public final boolean getHeaderIsFloat() {
        return this.f43263f;
    }

    /* renamed from: a */
    private final void m30571a(ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            Space space = new Space(viewGroup.getContext());
            space.setLayoutParams(new ViewGroup.LayoutParams(1, i));
            viewGroup.addView(space, 0);
        }
    }

    /* renamed from: a */
    private final void m30572a(IHeaderStickHolder iHeaderStickHolder) {
        View stickView = iHeaderStickHolder.getStickView();
        View view = this.f43261d;
        if (view == null || !Intrinsics.areEqual((Object) view, (Object) stickView)) {
            this.f43262e = iHeaderStickHolder;
            ViewGroup stickParentView = iHeaderStickHolder.getStickParentView();
            this.f43260c = stickParentView;
            m30571a(stickParentView, stickView.getHeight());
            this.f43261d = stickView;
        }
    }

    public final void onRecycleScrolled(RecyclerView recyclerView) {
        int i;
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(linearLayoutManager);
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
        int i2 = 0;
        if (findViewHolderForAdapterPosition == null || (view2 = findViewHolderForAdapterPosition.itemView) == null) {
            i = 0;
        } else {
            i = view2.getTop();
        }
        if (!(findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null)) {
            i2 = view.getHeight();
        }
        String str = this.f43258a;
        LogUtil.m29100d(str, "pos = " + findFirstVisibleItemPosition + " top = " + i + " height = " + i2);
        if (findViewHolderForAdapterPosition instanceof IHeaderStickHolder) {
            IHeaderStickHolder iHeaderStickHolder = (IHeaderStickHolder) findViewHolderForAdapterPosition;
            m30572a(iHeaderStickHolder);
            View view3 = this.f43261d;
            if (view3 != null) {
                View view4 = findViewHolderForAdapterPosition.itemView;
                Intrinsics.checkNotNullExpressionValue(view4, "viewHolder.itemView");
                m30573a(iHeaderStickHolder, view3, view4);
                return;
            }
            return;
        }
        m30570a(this.f43261d);
    }

    /* renamed from: a */
    private final void m30570a(View view) {
        if (view != null) {
            OnHeaderFloatListener onHeaderFloatListener = this.f43259b;
            if (onHeaderFloatListener != null) {
                onHeaderFloatListener.onHeaderFloatScroll(view, 1.0f);
            }
            IHeaderStickHolder iHeaderStickHolder = this.f43262e;
            if (iHeaderStickHolder != null) {
                iHeaderStickHolder.onFloatScroll(1.0f);
            }
            this.f43263f = true;
        }
    }

    /* renamed from: a */
    private final void m30573a(IHeaderStickHolder iHeaderStickHolder, View view, View view2) {
        if (isIntoFloat(iHeaderStickHolder, view2)) {
            m30570a(view);
            return;
        }
        m30569a();
        int b = m30575b(iHeaderStickHolder);
        float b2 = 1.0f - ((((float) (m30574b(view2) - b)) * 1.0f) / ((float) (view2.getHeight() - b)));
        OnHeaderFloatListener onHeaderFloatListener = this.f43259b;
        if (onHeaderFloatListener != null) {
            onHeaderFloatListener.onHeaderFloatScroll(view, b2);
        }
        iHeaderStickHolder.onFloatScroll(b2);
    }

    /* renamed from: a */
    private final void m30569a() {
        ViewParent viewParent;
        View view = this.f43261d;
        ViewGroup viewGroup = null;
        if (view == null) {
            viewParent = null;
        } else {
            viewParent = view.getParent();
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup == null) {
            ViewSafeHelper.safeAddView(this.f43260c, view);
        } else if (ViewSafeHelper.safeRemoveView(viewGroup, view)) {
            ViewSafeHelper.safeAddView(this.f43260c, view);
        }
    }

    /* renamed from: b */
    private final int m30575b(IHeaderStickHolder iHeaderStickHolder) {
        return iHeaderStickHolder.getIntoFloatValue();
    }

    public final boolean isIntoFloat(IHeaderStickHolder iHeaderStickHolder, View view) {
        Intrinsics.checkNotNullParameter(iHeaderStickHolder, "stickHolder");
        Intrinsics.checkNotNullParameter(view, "itemView");
        return m30574b(view) <= m30575b(iHeaderStickHolder);
    }

    public final int getFloatOffset() {
        IHeaderStickHolder iHeaderStickHolder = this.f43262e;
        if (iHeaderStickHolder == null) {
            return 0;
        }
        return iHeaderStickHolder.getFloatScrollOffset();
    }

    /* renamed from: b */
    private final int m30574b(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(view.isShown());
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(view.getHeight());
        LogUtil.m29100d("Float", sb.toString());
        if (!view.isShown()) {
            return 0;
        }
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        return rect.height();
    }
}
