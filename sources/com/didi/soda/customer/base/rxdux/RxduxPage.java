package com.didi.soda.customer.base.rxdux;

import android.view.View;
import com.didi.app.nova.skeleton.Component;
import com.didi.soda.customer.base.pages.CustomerPage;
import java.util.ArrayList;
import java.util.List;

public abstract class RxduxPage extends CustomerPage {

    /* renamed from: a */
    List<Component> f40378a = new ArrayList();

    public void onCreate(View view) {
        super.onCreate(view);
    }

    /* access modifiers changed from: protected */
    public boolean addComponent(Component component) {
        this.f40378a.add(component);
        return super.addComponent(component);
    }

    /* access modifiers changed from: protected */
    public boolean removeComponent(Component component) {
        this.f40378a.remove(component);
        return super.removeComponent(component);
    }
}
