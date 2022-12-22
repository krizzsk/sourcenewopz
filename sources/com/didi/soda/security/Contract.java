package com.didi.soda.security;

import android.content.Intent;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;

public interface Contract {

    public static abstract class AbsSecurityPresenter extends CustomerRecyclerPresenter<AbsSecurityView> {
        /* access modifiers changed from: package-private */
        public abstract void bindCard();

        /* access modifiers changed from: package-private */
        public abstract void disable(int i);

        /* access modifiers changed from: package-private */
        public abstract boolean hasEnable();

        /* access modifiers changed from: package-private */
        public abstract void verifyCpf();

        /* access modifiers changed from: package-private */
        public abstract void verifyCurp();
    }

    public static abstract class AbsSecurityView extends CustomerRecyclerView<AbsSecurityPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void onActivityResult(int i, int i2, Intent intent);
    }
}
