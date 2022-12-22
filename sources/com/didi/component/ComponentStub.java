package com.didi.component;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;

public class ComponentStub extends View {

    /* renamed from: a */
    private IComponent f10971a;

    /* renamed from: b */
    private IViewContainer.IComponentCreator f10972b;

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public ComponentStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f10972b = iComponentCreator;
    }

    public IViewContainer.IComponentCreator getComponentCreator() {
        return this.f10972b;
    }

    public IComponent inflate(String str) {
        return inflate(str, (Bundle) null);
    }

    public IComponent inflate(String str, Bundle bundle) {
        if (this.f10971a != null) {
            clear();
        }
        return m7417a(str, bundle);
    }

    /* renamed from: a */
    private IComponent m7417a(String str, Bundle bundle) {
        IComponent newComponent;
        IViewContainer.IComponentCreator iComponentCreator = this.f10972b;
        if (iComponentCreator == null || (newComponent = iComponentCreator.newComponent(str, (ViewGroup) null, bundle)) == null) {
            return null;
        }
        View view = newComponent.getView().getView();
        if (view != null) {
            m7418a((View) this, view);
            this.f10971a = newComponent;
            return newComponent;
        }
        throw new IllegalArgumentException("Component must have a view");
    }

    public void clear() {
        IComponent iComponent = this.f10971a;
        if (iComponent != null) {
            View view = iComponent.getView().getView();
            if (view != null) {
                m7418a(view, (View) this);
                IViewContainer.IComponentCreator iComponentCreator = this.f10972b;
                if (iComponentCreator != null) {
                    iComponentCreator.removeComponent(this.f10971a);
                }
                this.f10971a = null;
                return;
            }
            throw new IllegalArgumentException("Component must have a view");
        }
    }

    /* renamed from: a */
    private void m7418a(View view, View view2) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewInLayout(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(view2, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(view2, indexOfChild);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
