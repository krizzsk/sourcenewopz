package com.didi.app.nova.skeleton.internal;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.dialog.Dialog;

public final class ScopeContextComponentImpl extends ScopeContextBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ScopeContext f8483a;

    /* renamed from: b */
    private String f8484b;

    public ScopeContext getParent() {
        return null;
    }

    public ScopeContextComponentImpl(ScopeContext scopeContext, String str) {
        this.f8483a = scopeContext;
        this.f8484b = str;
    }

    /* access modifiers changed from: protected */
    public INavigator newNavigator() {
        return new INavigator() {
            public void push(Page page) {
                ScopeContextComponentImpl.this.f8483a.getNavigator().push(page);
            }

            public void pushForResult(Page page) {
                ScopeContextComponentImpl.this.f8483a.getNavigator().pushForResult(page);
            }

            public void popToRoot() {
                ScopeContextComponentImpl.this.f8483a.getNavigator().popToRoot();
            }

            public void finish() {
                ScopeContextComponentImpl.this.f8483a.getNavigator().finish();
            }

            public void finish(Bundle bundle) {
                ScopeContextComponentImpl.this.f8483a.getNavigator().finish(bundle);
            }

            public void showDialog(Dialog dialog, String str) {
                ScopeContextComponentImpl.this.f8483a.getNavigator().showDialog(dialog, str);
            }
        };
    }

    public Object getObject(String str) {
        Object object = super.getObject(str);
        return object == null ? this.f8483a.getObject(str) : object;
    }

    public String alias() {
        return this.f8484b + "@" + this;
    }

    public Bundle getBundle() {
        return this.f8483a.getBundle();
    }
}
