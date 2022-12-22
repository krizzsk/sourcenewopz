package com.didi.app.nova.skeleton.internal;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.SkeletonActivity;
import com.didi.app.nova.skeleton.dialog.Dialog;

public class ScopeContextActivityImpl extends ScopeContextBase {

    /* renamed from: a */
    SkeletonActivity f8482a;

    public ScopeContextActivityImpl(SkeletonActivity skeletonActivity) {
        this.f8482a = skeletonActivity;
    }

    /* access modifiers changed from: protected */
    public INavigator newNavigator() {
        return new INavigator() {
            public void push(Page page) {
                if (ScopeContextActivityImpl.this.f8482a.getPageInstrument() != null) {
                    ScopeContextActivityImpl.this.f8482a.getPageInstrument().pushPage(page);
                }
            }

            public void pushForResult(Page page) {
                push(page);
            }

            public void popToRoot() {
                if (ScopeContextActivityImpl.this.f8482a.getPageInstrument() != null) {
                    ScopeContextActivityImpl.this.f8482a.getPageInstrument().popToRoot();
                }
            }

            public void finish() {
                ScopeContextActivityImpl.this.f8482a.finish();
            }

            public void finish(Bundle bundle) {
                finish();
            }

            public void showDialog(Dialog dialog, String str) {
                if (ScopeContextActivityImpl.this.f8482a.getPageInstrument() != null) {
                    dialog.show(ScopeContextActivityImpl.this.f8482a.getPageInstrument(), str);
                }
            }
        };
    }

    public String alias() {
        return this.f8482a.alias();
    }

    public Bundle getBundle() {
        return this.f8482a.getIntent().getExtras();
    }
}
