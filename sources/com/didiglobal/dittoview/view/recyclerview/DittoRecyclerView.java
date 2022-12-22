package com.didiglobal.dittoview.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.IParser;
import com.didiglobal.dittoview.IView;
import com.didiglobal.dittoview.view.DittoBorder;
import com.didiglobal.dittoview.view.DittoCorner;
import com.didiglobal.dittoview.view.DittoShadow;

public class DittoRecyclerView extends RecyclerView implements IParser, IView {

    /* renamed from: a */
    int f49997a;

    /* renamed from: b */
    int f49998b;

    /* renamed from: c */
    private Context f49999c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ScrollManager f50000d;
    public DittoRecyclerAdapter dittoRecyclerAdapter;

    /* renamed from: e */
    private float f50001e;

    /* renamed from: f */
    private boolean f50002f;

    public View getView() {
        return this;
    }

    public void setBorder(DittoBorder dittoBorder) {
    }

    public void setCorner(DittoCorner dittoCorner) {
    }

    public void setShadow(DittoShadow dittoShadow) {
    }

    public DittoRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DittoRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DittoRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f50002f = true;
        m36012a(context);
    }

    /* renamed from: a */
    private void m36012a(Context context) {
        this.f50001e = context.getResources().getDisplayMetrics().density;
        this.f49999c = context;
        DittoRecyclerAdapter dittoRecyclerAdapter2 = new DittoRecyclerAdapter();
        this.dittoRecyclerAdapter = dittoRecyclerAdapter2;
        setAdapter(dittoRecyclerAdapter2);
        setOverScrollMode(2);
    }

    public void addChildView(View view) {
        this.dittoRecyclerAdapter.mo122387a(view);
    }

    public void addView(View view) {
        this.dittoRecyclerAdapter.mo122387a(view);
    }

    public void setCardData(String str) {
        this.dittoRecyclerAdapter.mo122390a(str);
    }

    public void bindXCardListener(DittoEventListener dittoEventListener) {
        DittoRecyclerAdapter dittoRecyclerAdapter2 = this.dittoRecyclerAdapter;
        if (dittoRecyclerAdapter2 != null) {
            dittoRecyclerAdapter2.mo122388a(dittoEventListener);
            ScrollManager scrollManager = this.f50000d;
            if (scrollManager != null) {
                scrollManager.setXCardListener(dittoEventListener);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r5, java.lang.String r6, com.facebook.yoga.YogaNode r7) {
        /*
            r4 = this;
            int r7 = r5.hashCode()
            r0 = 4
            r1 = 2
            r2 = 0
            r3 = 1
            switch(r7) {
                case -1662432227: goto L_0x0048;
                case -1221029593: goto L_0x003e;
                case -454130068: goto L_0x0034;
                case -428786256: goto L_0x002a;
                case 113126854: goto L_0x0020;
                case 622269923: goto L_0x0016;
                case 695731883: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0052
        L_0x000c:
            java.lang.String r7 = "flex-direction"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0016:
            java.lang.String r7 = "pagingMeasurements"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 6
            goto L_0x0053
        L_0x0020:
            java.lang.String r7 = "width"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 2
            goto L_0x0053
        L_0x002a:
            java.lang.String r7 = "max-height"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 5
            goto L_0x0053
        L_0x0034:
            java.lang.String r7 = "contentOffset"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 0
            goto L_0x0053
        L_0x003e:
            java.lang.String r7 = "height"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 4
            goto L_0x0053
        L_0x0048:
            java.lang.String r7 = "max-width"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0052
            r5 = 3
            goto L_0x0053
        L_0x0052:
            r5 = -1
        L_0x0053:
            if (r5 == 0) goto L_0x00a4
            if (r5 == r3) goto L_0x0079
            if (r5 == r1) goto L_0x006b
            if (r5 == r0) goto L_0x005d
            goto L_0x00d1
        L_0x005d:
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            int r6 = r4.m36010a((java.lang.String) r6)
            r5.height = r6
            r4.setLayoutParams(r5)
            goto L_0x00d1
        L_0x006b:
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            int r6 = r4.m36010a((java.lang.String) r6)
            r5.width = r6
            r4.setLayoutParams(r5)
            goto L_0x00d1
        L_0x0079:
            java.lang.String r5 = "column"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x008b
            r4.f50002f = r3
            com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView$1 r5 = new com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView$1
            android.content.Context r6 = r4.f49999c
            r5.<init>(r6, r3, r2)
            goto L_0x0094
        L_0x008b:
            r4.f50002f = r2
            com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView$2 r5 = new com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView$2
            android.content.Context r6 = r4.f49999c
            r5.<init>(r6, r2, r2)
        L_0x0094:
            r4.setLayoutManager(r5)
            com.didiglobal.dittoview.view.recyclerview.ScrollManager r6 = new com.didiglobal.dittoview.view.recyclerview.ScrollManager
            android.content.Context r7 = r4.f49999c
            r6.<init>(r4, r7, r5)
            r4.f50000d = r6
            r6.initScrollListener()
            goto L_0x00d1
        L_0x00a4:
            java.lang.String r5 = r6.trim()
            java.lang.String r6 = "{"
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r6 = "}"
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            if (r5 == 0) goto L_0x00d1
            int r6 = r5.length
            if (r6 <= r3) goto L_0x00d1
            r6 = r5[r2]
            int r6 = java.lang.Integer.parseInt(r6)
            r4.f49997a = r6
            r5 = r5[r3]
            int r5 = java.lang.Integer.parseInt(r5)
            r4.f49998b = r5
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    /* renamed from: a */
    private int m36010a(String str) {
        if (str.endsWith("%")) {
            return Integer.parseInt(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Integer.parseInt(str.substring(0, str.length() - 2));
        }
        return (int) (((float) Integer.parseInt(str)) * this.f50001e);
    }

    public void onParseEnd() {
        if (this.f50002f) {
            smoothScrollBy(0, this.f49998b);
        } else {
            smoothScrollBy(this.f49997a, 0);
        }
    }
}
