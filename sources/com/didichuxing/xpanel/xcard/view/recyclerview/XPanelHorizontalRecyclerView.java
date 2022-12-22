package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.ILifecycle;
import com.didichuxing.xpanel.xcard.IParser;
import com.didichuxing.xpanel.xcard.IView;
import com.didichuxing.xpanel.xcard.ParseHelper;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import com.didichuxing.xpanel.xcard.view.Border;
import com.didichuxing.xpanel.xcard.view.Corner;

public class XPanelHorizontalRecyclerView extends RecyclerView implements ILifecycle, IParser, IView {

    /* renamed from: a */
    private String f49729a;

    /* renamed from: b */
    private StartSnapHelper f49730b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f49731c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ScrollManager f49732d;
    public int decorationPadding;

    /* renamed from: e */
    private ParseHelper f49733e;
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
        this.f49729a = "XpanelHorizontalRecyclerView";
        this.decorationPadding = 0;
        m35887a(context);
    }

    public void setDecorationPadding(int i) {
        this.decorationPadding = i;
        addItemDecoration(new XpanelItemDecoration(i));
    }

    /* renamed from: a */
    private void m35887a(Context context) {
        this.f49731c = context;
        StartSnapHelper startSnapHelper = new StartSnapHelper();
        this.f49730b = startSnapHelper;
        startSnapHelper.attachToRecyclerView(this);
        MyRecylerAdapter myRecylerAdapter2 = new MyRecylerAdapter(context, this.f49730b, this);
        this.myRecylerAdapter = myRecylerAdapter2;
        setAdapter(myRecylerAdapter2);
        C165961 r0 = new LinearLayoutManager(context, 0, false) {
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted(state);
                XPanelHorizontalRecyclerView.this.f49732d.checkScrollX();
            }
        };
        r0.setStackFromEnd(true);
        setLayoutManager(r0);
        setDecorationPadding(this.decorationPadding);
        ScrollManager scrollManager = new ScrollManager(this, context, r0);
        this.f49732d = scrollManager;
        scrollManager.initScrollListener();
        setOverScrollMode(2);
    }

    public void addChildView(View view) {
        this.myRecylerAdapter.mo121808a(view);
    }

    public void setParseHelper(ParseHelper parseHelper) {
        this.f49733e = parseHelper;
        setDecorationPadding(parseHelper != null ? parseHelper.mXpanelMargin : 0);
    }

    public void addView(View view) {
        this.myRecylerAdapter.mo121808a(view);
    }

    public void setCardDataHelper(XPanelCardDataHelper xPanelCardDataHelper) {
        MyRecylerAdapter myRecylerAdapter2 = this.myRecylerAdapter;
        if (myRecylerAdapter2 != null) {
            myRecylerAdapter2.mo121810a(xPanelCardDataHelper);
            ScrollManager scrollManager = this.f49732d;
            if (scrollManager != null) {
                scrollManager.setCardDataHelper(xPanelCardDataHelper);
            }
        }
    }

    public void setCardData(String str) {
        this.myRecylerAdapter.mo121812a(str);
    }

    public void onResume() {
        this.f49732d.checkScrollX();
    }

    public void onPause() {
        this.f49732d.pauseStatus();
    }

    public void cardMoveOut() {
        this.f49732d.pauseStatus();
    }

    public void cardMoveIn() {
        this.f49732d.checkScrollX();
    }

    public void bindXCardListener(ICardListener iCardListener) {
        MyRecylerAdapter myRecylerAdapter2 = this.myRecylerAdapter;
        if (myRecylerAdapter2 != null) {
            myRecylerAdapter2.mo121809a(iCardListener);
            ScrollManager scrollManager = this.f49732d;
            if (scrollManager != null) {
                scrollManager.setXCardListener(iCardListener);
            }
        }
    }

    public class XpanelItemDecoration extends RecyclerView.ItemDecoration {
        private int mDividerWidth;
        private int mPadding;

        public XpanelItemDecoration(int i) {
            this.mPadding = i;
            this.mDividerWidth = Utils.dip2px(XPanelHorizontalRecyclerView.this.f49731c, 6.0f) - 16;
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

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r2, java.lang.String r3, com.facebook.yoga.YogaNode r4) {
        /*
            r1 = this;
            int r3 = r2.hashCode()
            r4 = 622269923(0x251715e3, float:1.3104578E-16)
            r0 = 1
            if (r3 == r4) goto L_0x001a
            r4 = 695731883(0x297806ab, float:5.5072846E-14)
            if (r3 == r4) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r3 = "flex-direction"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r3 = "pagingMeasurements"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = -1
        L_0x0025:
            if (r3 == 0) goto L_0x003f
            if (r3 == r0) goto L_0x003f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unknown view param: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "ParseHelper"
            com.didichuxing.xpanel.util.LogcatUtil.m35795e(r3, r2)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.view.recyclerview.XPanelHorizontalRecyclerView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }
}
