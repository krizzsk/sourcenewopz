package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;
import com.didi.sdk.app.ActivityStack;

public class EndJarvisPresenter extends AbsJarvisPresenter {

    /* renamed from: a */
    private ActivityStack.OnStackChangedAdapter f15400a = new ActivityStack.OnStackChangedAdapter() {
        public void onAppResume() {
            super.onAppResume();
            EndJarvisPresenter.this.requestJarvisStatus();
        }
    };

    /* access modifiers changed from: protected */
    public String getPage() {
        return "end";
    }

    public EndJarvisPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        requestJarvisStatus();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
        ActivityStack.addStackChangedListener(this.f15400a);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
        ActivityStack.removeStackChangedListener(this.f15400a);
    }
}
