package com.didi.sdk.app;

import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class BusinessContextManager {

    /* renamed from: a */
    private BaseBusinessContext f35155a;

    /* renamed from: b */
    private ArrayList<IBusinessContextChangedListener> f35156b = new ArrayList<>();

    /* renamed from: c */
    private boolean f35157c = true;

    private BusinessContextManager() {
    }

    public static BusinessContextManager getInstance() {
        return (BusinessContextManager) SingletonHolder.getInstance(BusinessContextManager.class);
    }

    public BaseBusinessContext getCurBusinessContext() {
        return this.f35155a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90610a(BaseBusinessContext baseBusinessContext) {
        if (baseBusinessContext != null) {
            m24840a(this.f35155a, baseBusinessContext);
            this.f35155a = baseBusinessContext;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90611a(IBusinessContextChangedListener iBusinessContextChangedListener) {
        if (iBusinessContextChangedListener != null) {
            synchronized (this.f35156b) {
                this.f35156b.add(iBusinessContextChangedListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo90613b(IBusinessContextChangedListener iBusinessContextChangedListener) {
        if (iBusinessContextChangedListener != null) {
            synchronized (this.f35156b) {
                this.f35156b.remove(iBusinessContextChangedListener);
            }
        }
    }

    /* renamed from: a */
    private void m24840a(BaseBusinessContext baseBusinessContext, BaseBusinessContext baseBusinessContext2) {
        ArrayList arrayList;
        synchronized (this.f35156b) {
            arrayList = new ArrayList(this.f35156b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((IBusinessContextChangedListener) it.next()).onBusinessContextChanged(baseBusinessContext, baseBusinessContext2);
        }
    }

    public boolean isInHomePage() {
        return this.f35157c && ActivityLifecycleManager.getInstance().isMainActivityOnTop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90612a(boolean z) {
        this.f35157c = z;
    }
}
