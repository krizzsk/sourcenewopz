package com.didi.component.framework.template.trip.scene;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.sdk.app.DIDIApplication;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsCompScene implements ICompScene {

    /* renamed from: a */
    private List<IComponent> f13993a = new ArrayList();
    protected Context mContext;
    protected IViewContainer.IComponentCreator mViewCreator;

    /* access modifiers changed from: protected */
    public abstract void initComponents(RelativeLayout relativeLayout);

    public AbsCompScene(Context context, IViewContainer.IComponentCreator iComponentCreator) {
        this.mContext = context == null ? DIDIApplication.getAppContext() : context;
        this.mViewCreator = iComponentCreator;
    }

    public void loadComponents(RelativeLayout relativeLayout) {
        initComponents(relativeLayout);
    }

    public void unLoadComponents() {
        unLoadAllComponents();
    }

    /* access modifiers changed from: protected */
    public void inflateViewlessComponent(String str, Bundle bundle) {
        this.f13993a.add(this.mViewCreator.inflateComponent(str, (ViewGroup) null, (ViewGroup.LayoutParams) null, bundle));
    }

    /* access modifiers changed from: protected */
    public void inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f13993a.add(this.mViewCreator.inflateComponent(str, viewGroup, layoutParams, (Bundle) null));
    }

    /* access modifiers changed from: protected */
    public void inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle) {
        this.f13993a.add(this.mViewCreator.inflateComponent(str, viewGroup, layoutParams, bundle));
    }

    /* access modifiers changed from: protected */
    public void unLoadAllComponents() {
        List<IComponent> list = this.f13993a;
        if (list != null && list.size() > 0) {
            for (IComponent removeComponent : this.f13993a) {
                this.mViewCreator.removeComponent(removeComponent);
            }
        }
    }
}
