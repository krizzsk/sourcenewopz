package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.global.globalgenerickit.template.yoga.ILifecycle;
import com.didi.global.globalgenerickit.template.yoga.IParser;
import com.didi.global.globalgenerickit.template.yoga.IView;
import com.didi.global.globalgenerickit.template.yoga.view.Border;
import com.didi.global.globalgenerickit.template.yoga.view.Corner;
import com.facebook.yoga.YogaNode;

public class XPanelHorizontalRecyclerView extends RecyclerView implements ILifecycle, IParser, IView {

    /* renamed from: a */
    private String f22331a;

    /* renamed from: b */
    private StartSnapHelper f22332b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f22333c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ScrollManager f22334d;
    public int decorationPadding;
    public MyRecylerAdapter myRecylerAdapter;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void setBorder(Border border) {
    }

    public void setCorner(Corner corner) {
    }

    public XPanelHorizontalRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelHorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelHorizontalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22331a = "XpanelHorizontalRecyclerView";
        this.decorationPadding = 0;
        m16105a(context);
    }

    public void setDecorationPadding(int i) {
        this.decorationPadding = i;
        addItemDecoration(new XpanelItemDecoration(i));
    }

    /* renamed from: a */
    private void m16105a(Context context) {
        this.f22333c = context;
        StartSnapHelper startSnapHelper = new StartSnapHelper();
        this.f22332b = startSnapHelper;
        startSnapHelper.attachToRecyclerView(this);
        MyRecylerAdapter myRecylerAdapter2 = new MyRecylerAdapter(context, this.f22332b, this);
        this.myRecylerAdapter = myRecylerAdapter2;
        setAdapter(myRecylerAdapter2);
        C86031 r0 = new LinearLayoutManager(context, 0, false) {
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted(state);
                XPanelHorizontalRecyclerView.this.f22334d.checkScrollX();
            }
        };
        setLayoutManager(r0);
        setDecorationPadding(this.decorationPadding);
        ScrollManager scrollManager = new ScrollManager(this, context, r0);
        this.f22334d = scrollManager;
        scrollManager.initScrollListener();
        setOverScrollMode(2);
    }

    public void addChildView(View view) {
        this.myRecylerAdapter.mo66712a(view);
    }

    public void addView(View view) {
        this.myRecylerAdapter.mo66712a(view);
    }

    public void setCardData(String str) {
        this.myRecylerAdapter.mo66715a(str);
    }

    public void onResume() {
        this.f22334d.checkScrollX();
    }

    public void onPause() {
        this.f22334d.pauseStatus();
    }

    public void cardMoveOut() {
        this.f22334d.pauseStatus();
    }

    public void cardMoveIn() {
        this.f22334d.checkScrollX();
    }

    public void bindXCardListener(EventListener eventListener) {
        MyRecylerAdapter myRecylerAdapter2 = this.myRecylerAdapter;
        if (myRecylerAdapter2 != null) {
            myRecylerAdapter2.mo66713a(eventListener);
            ScrollManager scrollManager = this.f22334d;
            if (scrollManager != null) {
                scrollManager.setXCardListener(eventListener);
            }
        }
    }

    public class XpanelItemDecoration extends RecyclerView.ItemDecoration {
        private int mDividerWidth;
        private int mPadding;

        public XpanelItemDecoration(int i) {
            this.mPadding = i;
            this.mDividerWidth = KitHelper.dip2px(XPanelHorizontalRecyclerView.this.f22333c, 6.0f) - 16;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
                rect.set(0, 0, this.mPadding, 0);
            } else if (childAdapterPosition == 0) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(0, 0, this.mDividerWidth, 0);
            }
        }
    }

    public void parse(String str, String str2, YogaNode yogaNode) {
        String str3;
        int hashCode = str.hashCode();
        if (hashCode == 622269923) {
            str3 = "pagingMeasurements";
        } else if (hashCode == 695731883) {
            str3 = "flex-direction";
        } else {
            return;
        }
        boolean equals = str.equals(str3);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }
}
