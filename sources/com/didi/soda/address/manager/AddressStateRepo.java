package com.didi.soda.address.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Action3;
import com.didi.app.nova.skeleton.repo.Action4;
import com.didi.app.nova.skeleton.repo.Event;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressStateRepo extends Repo<AddressEntity> {

    /* renamed from: a */
    private static final String f38781a = "AddressStateRepo";

    /* renamed from: b */
    private List<AddressStateSubscription> f38782b = new ArrayList();

    /* renamed from: c */
    private String f38783c;

    /* renamed from: d */
    private int f38784d = 0;

    AddressStateRepo() {
    }

    /* renamed from: a */
    public int mo98668a() {
        return this.f38784d;
    }

    /* renamed from: a */
    public void mo98670a(int i) {
        this.f38784d = i;
    }

    /* renamed from: b */
    public String mo98674b() {
        return this.f38783c;
    }

    /* renamed from: a */
    public void mo98673a(String str) {
        this.f38783c = str;
    }

    /* renamed from: c */
    public void mo98676c() {
        setValue((AddressEntity) null);
        this.f38783c = null;
        this.f38784d = 0;
        ((AddressStorage) SingletonFactory.get(AddressStorage.class)).clear();
    }

    /* renamed from: a */
    public void setValue(AddressEntity addressEntity) {
        super.setValue(addressEntity);
        m27476a(addressEntity, (AddressEntity) getValue());
        if (AddressUtil.checkAddressValid(addressEntity)) {
            ((AddressStorage) SingletonFactory.get(AddressStorage.class)).setData(addressEntity);
        }
    }

    /* renamed from: b */
    public void mo98675b(AddressEntity addressEntity) {
        AddressEntity addressEntity2 = (AddressEntity) getValue();
        boolean checkAddressValid = AddressUtil.checkAddressValid(addressEntity2);
        if (AddressUtil.checkAddressValid(addressEntity)) {
            if (!addressEntity.poi.poiId.equals(checkAddressValid ? addressEntity2.poi.poiId : "")) {
                setValue(addressEntity);
            }
        } else if (!checkAddressValid) {
            setValue(addressEntity);
        }
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<AddressEntity> action) {
        return super.subscribe(scopeContext, action);
    }

    /* renamed from: a */
    public Subscription mo98669a(ScopeContext scopeContext, Action<AddressEntity> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }

    /* renamed from: a */
    public void mo98671a(Action<AddressEntity> action) {
        this.f38782b.add(new AddressStateSubscription(action));
        LogUtil.m29100d(f38781a, "Subscriber without life" + this.f38782b.size());
    }

    /* renamed from: a */
    private void m27476a(AddressEntity addressEntity, AddressEntity addressEntity2) {
        Iterator<AddressStateSubscription> it = this.f38782b.iterator();
        LogUtil.m29100d(f38781a, "Subscriber without life" + this.f38782b.size() + " call:" + addressEntity);
        while (it.hasNext()) {
            AddressStateSubscription next = it.next();
            if (next.isUnsubscribed()) {
                it.remove();
            } else {
                if (next.mAction instanceof Action1) {
                    ((Action1) next.mAction).call(addressEntity);
                } else if (next.mAction instanceof Action2) {
                    ((Action2) next.mAction).call(addressEntity, next);
                } else if (next.mAction instanceof Action3) {
                    ((Action3) next.mAction).invoke(addressEntity, next);
                } else if (next.mAction instanceof Action4) {
                    ((Action4) next.mAction).call(new Event(addressEntity2, addressEntity, next));
                } else {
                    ((Action1) next.mAction).call(addressEntity);
                }
                if (next.isUnsubscribed()) {
                    it.remove();
                }
            }
        }
    }

    class AddressStateSubscription implements Subscription {
        /* access modifiers changed from: private */
        public Action<AddressEntity> mAction;
        private boolean mActive = true;

        AddressStateSubscription(Action<AddressEntity> action) {
            this.mAction = action;
        }

        public boolean isUnsubscribed() {
            return !this.mActive;
        }

        public void unsubscribe() {
            this.mActive = false;
        }

        public void activeChange(boolean z) throws Exception {
            this.mActive = z;
        }
    }
}
