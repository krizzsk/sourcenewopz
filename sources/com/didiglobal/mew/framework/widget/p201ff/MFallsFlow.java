package com.didiglobal.mew.framework.widget.p201ff;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MFallsFlow */
public class MFallsFlow extends RelativeLayout {

    /* renamed from: a */
    private MFallsFlowScrollView f50265a;

    /* renamed from: b */
    private MFallsFlowHeader f50266b;

    /* renamed from: c */
    private MFallsFlowListView f50267c;

    /* renamed from: d */
    private RelativeLayout f50268d;

    /* renamed from: e */
    private MFFAdapter f50269e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewGroup.OnHierarchyChangeListener f50270f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public NestedScrollView.OnScrollChangeListener f50271g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecyclerView.OnScrollListener f50272h;

    /* renamed from: i */
    private RecyclerView.OnScrollListener f50273i = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (MFallsFlow.this.f50272h != null) {
                MFallsFlow.this.f50272h.onScrollStateChanged(recyclerView, i);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (MFallsFlow.this.f50272h != null) {
                MFallsFlow.this.f50272h.onScrolled(recyclerView, i, i2);
            }
        }
    };

    /* renamed from: j */
    private ViewGroup.OnHierarchyChangeListener f50274j = new ViewGroup.OnHierarchyChangeListener() {
        public void onChildViewAdded(View view, View view2) {
            if (MFallsFlow.this.f50270f != null) {
                MFallsFlow.this.f50270f.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (MFallsFlow.this.f50270f != null) {
                MFallsFlow.this.f50270f.onChildViewAdded(view, view2);
            }
        }
    };

    /* renamed from: k */
    private NestedScrollView.OnScrollChangeListener f50275k = new NestedScrollView.OnScrollChangeListener() {
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            if (MFallsFlow.this.f50271g != null) {
                MFallsFlow.this.f50271g.onScrollChange(nestedScrollView, i, i2, i3, i4);
            }
        }
    };

    public MFallsFlow(Context context) {
        super(context);
        m36215a(context, (AttributeSet) null, 0);
    }

    public MFallsFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36215a(context, attributeSet, 0);
    }

    public MFallsFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36215a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m36215a(Context context, AttributeSet attributeSet, int i) {
        View.inflate(context, R.layout.mew_widget_falls_flow, this);
        this.f50265a = (MFallsFlowScrollView) findViewById(R.id.mew_falls_flow_scroll_view);
        this.f50266b = (MFallsFlowHeader) findViewById(R.id.mew_falls_flow_header);
        this.f50267c = (MFallsFlowListView) findViewById(R.id.mew_falls_flow_list_view);
        this.f50268d = (RelativeLayout) findViewById(R.id.mew_falls_flow_list_view_bg);
        this.f50265a.setOnScrollChangeListener(this.f50275k);
        this.f50267c.addOnScrollListener(this.f50273i);
        this.f50266b.setOnHierarchyChangeListener(this.f50274j);
        MFFAdapter mFFAdapter = new MFFAdapter();
        this.f50269e = mFFAdapter;
        this.f50267c.setAdapter(mFFAdapter);
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener, NestedScrollView.OnScrollChangeListener onScrollChangeListener) {
        this.f50272h = onScrollListener;
        this.f50271g = onScrollChangeListener;
    }

    public void setHeaderViewChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f50270f = onHierarchyChangeListener;
    }

    public void initHeaderView(View view) {
        this.f50266b.removeAllViews();
        this.f50266b.addView(view);
    }

    public void setAlignBottom(boolean z) {
        this.f50267c.setAlignBottom(z);
    }

    public void setListViewElevation(int i, int i2) {
        this.f50269e.setElevation(i, i2);
    }

    public void setHeaderViewBgColor(int i) {
        this.f50266b.setBackgroundColor(i);
    }

    public void setVisibility(boolean z) {
        this.f50266b.setVisibility(z ? 0 : 8);
    }

    public void setOverlapSpace(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50268d.getLayoutParams();
        layoutParams.topMargin = i;
        this.f50268d.setLayoutParams(layoutParams);
    }

    public void clear() {
        this.f50269e.clear();
    }

    public void setData(List<MFFCardProperty> list) {
        this.f50269e.setCardPropertyList(list);
    }

    public void addData(List<MFFCardProperty> list) {
        this.f50269e.addCardPropertyList(list);
    }

    public void addData(int i, MFFCardProperty mFFCardProperty) {
        this.f50269e.addCardProperty(i, mFFCardProperty);
    }
}
