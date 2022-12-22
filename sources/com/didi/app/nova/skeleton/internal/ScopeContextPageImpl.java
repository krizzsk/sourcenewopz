package com.didi.app.nova.skeleton.internal;

import android.os.Bundle;
import com.didi.app.nova.skeleton.AbstractPage;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.dialog.Dialog;

public class ScopeContextPageImpl extends ScopeContextBase {

    /* renamed from: a */
    AbstractPage f8485a;

    public ScopeContextPageImpl(AbstractPage abstractPage) {
        this.f8485a = abstractPage;
    }

    /* access modifiers changed from: protected */
    public INavigator newNavigator() {
        return new INavigator() {
            public void push(Page page) {
                ScopeContextPageImpl.this.f8485a.push(page);
            }

            public void pushForResult(Page page) {
                ScopeContextPageImpl.this.f8485a.pushForResult(page);
            }

            public void popToRoot() {
                ScopeContextPageImpl.this.f8485a.popToRoot();
            }

            public void finish() {
                ScopeContextPageImpl.this.f8485a.finish();
            }

            public void finish(Bundle bundle) {
                ScopeContextPageImpl.this.f8485a.finish(bundle);
            }

            public void showDialog(Dialog dialog, String str) {
                dialog.show(ScopeContextPageImpl.this.f8485a.getInstrument(), str);
            }
        };
    }

    public String alias() {
        return this.f8485a.alias() + "@" + this;
    }

    public Bundle getBundle() {
        return this.f8485a.getArgs();
    }
}
