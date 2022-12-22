package com.didi.app.nova.skeleton;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.app.nova.skeleton.internal.ScopeContextActivityImpl;
import com.didi.sdk.apm.SystemUtils;

public abstract class SkeletonActivity extends AppCompatActivity implements ILive {

    /* renamed from: a */
    private ScopeContextBase f8269a;

    /* renamed from: b */
    private ComponentGroup f8270b = new ComponentGroup();

    /* renamed from: c */
    private boolean f8271c;

    public abstract PageInstrument getPageInstrument();

    /* access modifiers changed from: protected */
    public abstract void onAfterCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public void setupComponents() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        ScopeContextBase onCreateScopeContext = onCreateScopeContext();
        this.f8269a = onCreateScopeContext;
        onCreateScopeContext.addObserver(this.f8270b);
        this.f8271c = true;
        onAfterCreate(bundle);
        setupComponents();
        this.f8269a.onCreate(this);
    }

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext() {
        return new ScopeContextActivityImpl(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f8271c = true;
        this.f8269a.onStart(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f8271c = true;
        this.f8269a.onResume(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f8271c = false;
        this.f8269a.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f8271c = false;
        this.f8269a.onStop(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f8271c = false;
        this.f8269a.onDestroy(this);
        this.f8269a.detachAll();
        this.f8269a.removeObserver(this.f8270b);
        this.f8269a = null;
    }

    public boolean isActive() {
        return this.f8271c;
    }

    /* access modifiers changed from: protected */
    public final boolean addComponent(Component component) {
        component.attachScopeContext(getScopeContext());
        if (this.f8270b.addComponent(component)) {
            return true;
        }
        component.attachScopeContext((ScopeContext) null);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean removeComponent(Component component) {
        if (!this.f8270b.removeComponent(component)) {
            return false;
        }
        component.attachScopeContext((ScopeContext) null);
        return true;
    }

    public final Component getComponent(Class<? extends Component> cls) {
        return this.f8270b.getComponent(cls);
    }

    public ScopeContext getScopeContext() {
        return this.f8269a;
    }

    public String alias() {
        return getClass().getName();
    }
}
