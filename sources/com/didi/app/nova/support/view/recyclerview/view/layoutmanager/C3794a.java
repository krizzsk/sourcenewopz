package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.mark.StickyHeader;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.ViewRetriever;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.a */
/* compiled from: NovaLayoutManagerDelegate */
class C3794a {

    /* renamed from: a */
    private List<Integer> f8642a = new ArrayList();

    /* renamed from: b */
    private ViewRetriever.RecyclerViewRetriever f8643b;

    /* renamed from: c */
    private C3795b f8644c;

    /* renamed from: d */
    private INovaLayoutManager f8645d;

    /* renamed from: e */
    private NovaRecyclerAdapter f8646e;

    /* renamed from: f */
    private int f8647f = -1;

    C3794a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41419a(INovaLayoutManager iNovaLayoutManager, NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f8645d = iNovaLayoutManager;
        this.f8646e = novaRecyclerAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41415a() {
        C3795b bVar = this.f8644c;
        if (bVar != null) {
            bVar.mo41429b(1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41420a(boolean z) {
        int i = z ? 5 : -1;
        this.f8647f = i;
        mo41416a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41416a(int i) {
        this.f8647f = i;
        C3795b bVar = this.f8644c;
        if (bVar != null) {
            bVar.mo41424a(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41417a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        m5756f();
        if (this.f8644c != null) {
            m5754d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo41421b() {
        C3795b bVar = this.f8644c;
        if (bVar != null) {
            bVar.mo41425a(this.f8645d.findFirstVisibleItemPosition(), m5755e(), this.f8643b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo41422c() {
        C3795b bVar = this.f8644c;
        if (bVar != null) {
            bVar.mo41423a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo41418a(RecyclerView recyclerView) {
        if (this.f8643b == null) {
            this.f8643b = new ViewRetriever.RecyclerViewRetriever(recyclerView);
        }
        if (this.f8644c == null) {
            this.f8644c = new C3795b(recyclerView);
        }
        this.f8644c.mo41424a(this.f8647f);
        if (this.f8642a.size() > 0) {
            this.f8644c.mo41427a(this.f8642a);
            m5754d();
        }
    }

    /* renamed from: d */
    private void m5754d() {
        this.f8644c.mo41429b(this.f8645d.getOrientation());
        this.f8644c.mo41425a(this.f8645d.findFirstVisibleItemPosition(), m5755e(), this.f8643b);
    }

    /* renamed from: e */
    private Map<Integer, View> m5755e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < this.f8645d.getChildCount(); i++) {
            View childAt = this.f8645d.getChildAt(i);
            int position = this.f8645d.getPosition(childAt);
            if (this.f8642a.contains(Integer.valueOf(position))) {
                linkedHashMap.put(Integer.valueOf(position), childAt);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    private void m5756f() {
        this.f8642a.clear();
        for (int i = 0; i < this.f8646e.getItemCount(); i++) {
            if (i < this.f8646e.getItemCount() + 0 && (this.f8646e.getItem(i + 0) instanceof StickyHeader)) {
                this.f8642a.add(Integer.valueOf(i));
            }
        }
        C3795b bVar = this.f8644c;
        if (bVar != null) {
            bVar.mo41427a(this.f8642a);
        }
    }
}
