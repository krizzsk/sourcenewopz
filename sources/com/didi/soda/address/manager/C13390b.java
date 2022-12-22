package com.didi.soda.address.manager;

import com.didi.app.nova.skeleton.repo.Repo;

/* renamed from: com.didi.soda.address.manager.b */
/* compiled from: AddressTipRepo */
class C13390b extends Repo<AddressTipInfo> {
    C13390b() {
    }

    /* renamed from: a */
    public AddressTipInfo getValue() {
        if (getValue() == null) {
            return new AddressTipInfo();
        }
        return (AddressTipInfo) super.getValue();
    }
}
