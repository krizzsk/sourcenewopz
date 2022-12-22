package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.b */
/* compiled from: StickyHeaderPositioner */
final class C3795b {

    /* renamed from: a */
    static final int f8648a = -1;

    /* renamed from: b */
    static final int f8649b = 5;

    /* renamed from: c */
    private static final int f8650c = -1;

    /* renamed from: d */
    private final NovaRecyclerView f8651d;

    /* renamed from: e */
    private final boolean f8652e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameLayout f8653f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f8654g;

    /* renamed from: h */
    private int f8655h = -1;

    /* renamed from: i */
    private List<Integer> f8656i;

    /* renamed from: j */
    private int f8657j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f8658k;

    /* renamed from: l */
    private float f8659l = -1.0f;

    /* renamed from: m */
    private int f8660m = -1;

    /* renamed from: n */
    private RecyclerView.ViewHolder f8661n;

    C3795b(RecyclerView recyclerView) {
        this.f8651d = (NovaRecyclerView) recyclerView;
        this.f8652e = m5793j();
        this.f8653f = (FrameLayout) m5794k().findViewById(R.id.header_container);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41427a(List<Integer> list) {
        this.f8656i = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41425a(int i, Map<Integer, View> map, ViewRetriever viewRetriever) {
        int a = m5767a(i, map.get(Integer.valueOf(i)));
        View view = map.get(Integer.valueOf(a));
        if (a != this.f8655h) {
            if (a == -1 || (this.f8652e && m5784e(view))) {
                this.f8658k = true;
                m5795l();
                this.f8655h = -1;
            } else {
                this.f8655h = a;
                mo41426a(viewRetriever.getViewHolderForPosition(a), a);
            }
        } else if (this.f8652e && m5784e(view)) {
            m5792i();
            this.f8655h = -1;
        }
        mo41428a(map);
        this.f8651d.post(new StickyHeaderPositioner$1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41428a(Map<Integer, View> map) {
        boolean z;
        View view = this.f8654g;
        if (view != null) {
            if (view.getHeight() == 0) {
                m5774b(map);
                return;
            }
            Iterator<Map.Entry<Integer, View>> it = map.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Integer) next.getKey()).intValue() > this.f8655h) {
                    if (m5766a((View) next.getValue()) != -1.0f) {
                        z = false;
                    }
                }
            }
            if (z) {
                m5773b();
            }
            this.f8654g.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41424a(int i) {
        if (i != -1) {
            this.f8660m = i;
            return;
        }
        this.f8659l = -1.0f;
        this.f8660m = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo41429b(int i) {
        this.f8657j = i;
        this.f8655h = -1;
        this.f8658k = true;
        m5795l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41423a() {
        m5792i();
    }

    /* renamed from: a */
    private float m5766a(View view) {
        if (!m5775b(view)) {
            return -1.0f;
        }
        if (this.f8657j == 1) {
            float f = -(((float) this.f8654g.getHeight()) - view.getY());
            this.f8654g.setTranslationY(f);
            return f;
        }
        float f2 = -(((float) this.f8654g.getWidth()) - view.getX());
        this.f8654g.setTranslationX(f2);
        return f2;
    }

    /* renamed from: b */
    private boolean m5775b(View view) {
        if (this.f8657j == 1) {
            if (view.getY() < ((float) this.f8654g.getHeight())) {
                return true;
            }
            return false;
        } else if (view.getX() < ((float) this.f8654g.getWidth())) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private void m5773b() {
        if (this.f8657j == 1) {
            this.f8654g.setTranslationY(0.0f);
        } else {
            this.f8654g.setTranslationX(0.0f);
        }
    }

    /* renamed from: a */
    private int m5767a(int i, View view) {
        int indexOf;
        if (m5779c(view) && (indexOf = this.f8656i.indexOf(Integer.valueOf(i))) > 0) {
            return this.f8656i.get(indexOf - 1).intValue();
        }
        int i2 = -1;
        for (Integer next : this.f8656i) {
            if (next.intValue() > i) {
                break;
            }
            i2 = next.intValue();
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5779c(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001b
            int r1 = r4.f8657j
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0012
            float r5 = r5.getY()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
            goto L_0x001a
        L_0x0012:
            float r5 = r5.getX()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.C3795b.m5779c(android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41426a(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.f8661n == viewHolder) {
            this.f8651d.getAdapter().onBindViewHolder(this.f8661n, i);
            this.f8661n.itemView.requestLayout();
            m5783e();
            this.f8658k = false;
            return;
        }
        m5792i();
        this.f8661n = viewHolder;
        this.f8651d.getAdapter().onBindViewHolder(this.f8661n, i);
        View view = this.f8661n.itemView;
        this.f8654g = view;
        m5768a(view.getContext());
        this.f8654g.setVisibility(4);
        this.f8654g.setId(R.id.header_view);
        if (this.f8653f == null) {
            FrameLayout frameLayout = new FrameLayout(this.f8651d.getContext());
            this.f8653f = frameLayout;
            frameLayout.setId(R.id.header_container);
            m5794k().addView(this.f8653f, new ViewGroup.LayoutParams(-1, -2));
        }
        this.f8653f.addView(this.f8654g);
        if (this.f8652e) {
            m5781d(this.f8654g);
        }
        this.f8658k = false;
        this.f8653f.post(new StickyHeaderPositioner$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m5776c() {
        View view = this.f8654g;
        if (view == null) {
            return 0;
        }
        if (this.f8657j == 1) {
            return view.getHeight();
        }
        return view.getWidth();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m5782d() {
        View view = this.f8654g;
        if (view == null) {
            return false;
        }
        if (this.f8657j == 1) {
            if (view.getTranslationY() < 0.0f) {
                return true;
            }
            return false;
        } else if (view.getTranslationX() < 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5778c(int i) {
        View view = this.f8654g;
        if (view != null) {
            if (this.f8657j == 1) {
                view.setTranslationY(view.getTranslationY() + ((float) i));
            } else {
                view.setTranslationX(view.getTranslationX() + ((float) i));
            }
        }
    }

    /* renamed from: e */
    private void m5783e() {
        View view = this.f8654g;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new StickyHeaderPositioner$3(this, view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5787f() {
        View view;
        if (this.f8659l != -1.0f && (view = this.f8654g) != null) {
            if ((this.f8657j == 1 && view.getTranslationY() == 0.0f) || (this.f8657j == 0 && this.f8654g.getTranslationX() == 0.0f)) {
                m5788g();
            } else {
                m5790h();
            }
        }
    }

    /* renamed from: g */
    private void m5788g() {
        if (Build.VERSION.SDK_INT >= 21 && this.f8654g.getTag() == null) {
            this.f8654g.setTag(true);
            this.f8654g.animate().z(this.f8659l);
        }
    }

    /* renamed from: h */
    private void m5790h() {
        if (Build.VERSION.SDK_INT >= 21 && this.f8654g.getTag() != null) {
            this.f8654g.setTag((Object) null);
            this.f8654g.animate().z(0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m5792i() {
        FrameLayout frameLayout;
        View view = this.f8654g;
        if (view != null && (frameLayout = this.f8653f) != null) {
            frameLayout.removeView(view);
            this.f8654g = null;
            this.f8661n = null;
        }
    }

    /* renamed from: d */
    private void m5781d(View view) {
        m5769a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    /* renamed from: a */
    private void m5769a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int i;
        int paddingLeft = this.f8657j == 1 ? this.f8651d.getPaddingLeft() : 0;
        if (this.f8657j == 1) {
            i = 0;
        } else {
            i = this.f8651d.getPaddingTop();
        }
        marginLayoutParams.setMargins(paddingLeft, i, this.f8657j == 1 ? this.f8651d.getPaddingRight() : 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5784e(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001b
            int r1 = r4.f8657j
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0012
            float r5 = r5.getY()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
            goto L_0x001a
        L_0x0012:
            float r5 = r5.getX()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.C3795b.m5784e(android.view.View):boolean");
    }

    /* renamed from: j */
    private boolean m5793j() {
        return this.f8651d.getPaddingLeft() > 0 || this.f8651d.getPaddingRight() > 0 || this.f8651d.getPaddingTop() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public ViewGroup m5794k() {
        return (ViewGroup) this.f8651d.getParent();
    }

    /* renamed from: b */
    private void m5774b(Map<Integer, View> map) {
        View view = this.f8654g;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new StickyHeaderPositioner$4(this, view, map));
        }
    }

    /* renamed from: l */
    private void m5795l() {
        if (m5794k() != null) {
            m5794k().post(new StickyHeaderPositioner$5(this));
        }
    }

    /* renamed from: a */
    private void m5768a(Context context) {
        int i = this.f8660m;
        if (i != -1 && this.f8659l == -1.0f) {
            this.f8659l = m5765a(context, i);
        }
    }

    /* renamed from: a */
    private float m5765a(Context context, int i) {
        return ((float) i) * context.getResources().getDisplayMetrics().density;
    }
}
