package com.didi.beatles.p099im.views.bottombar.contain;

import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.adapter.IMFuncAdapter;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainFunc */
class IMBtmContainFunc extends C4306a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Callback f10025c;

    /* renamed from: d */
    private RecyclerView f10026d;

    /* renamed from: e */
    private IMFuncAdapter f10027e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainFunc$Callback */
    interface Callback {
        void invokeAction(IMActionItem iMActionItem, boolean z);
    }

    IMBtmContainFunc(View view) {
        super(view);
        m6809a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44078a(Callback callback) {
        this.f10025c = callback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<IMActionItem> mo44080b() {
        IMFuncAdapter iMFuncAdapter = this.f10027e;
        if (iMFuncAdapter == null) {
            return Collections.emptyList();
        }
        return iMFuncAdapter.getTotalList();
    }

    /* renamed from: a */
    private void m6809a(View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        this.f10026d = recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44079a(List<IMActionItem> list) {
        IMFuncAdapter iMFuncAdapter = this.f10027e;
        if (iMFuncAdapter != null) {
            iMFuncAdapter.changeSystemList(list);
        } else {
            m6810c(list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo44081b(List<IMActionItem> list) {
        if (this.f10027e == null) {
            m6810c(Collections.emptyList());
        }
        this.f10027e.changeMoreList(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44077a(IMActionItem iMActionItem) {
        IMFuncAdapter iMFuncAdapter = this.f10027e;
        if (iMFuncAdapter != null) {
            iMFuncAdapter.refreshItem(iMActionItem);
        }
    }

    /* renamed from: c */
    private void m6810c(List<IMActionItem> list) {
        this.f10026d.setLayoutManager(new GridLayoutManager(this.f10058a, 4, 1, false));
        IMFuncAdapter iMFuncAdapter = new IMFuncAdapter(this.f10058a, list, new IMFuncAdapter.IMFuncOnClickListener() {
            public void onClick(IMActionItem iMActionItem) {
                if (IMBtmContainFunc.this.f10025c != null) {
                    IMBtmContainFunc.this.f10025c.invokeAction(iMActionItem, true);
                }
            }
        });
        this.f10027e = iMFuncAdapter;
        this.f10026d.setAdapter(iMFuncAdapter);
    }
}
