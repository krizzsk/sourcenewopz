package com.didi.component.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.font.iface.DecoratorFactory;

@ServiceProvider({DecoratorFactory.class})
public class CLayoutInflaterFactory implements DecoratorFactory {

    /* renamed from: a */
    private DecoratorFactory f10982a;

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        DecoratorFactory decoratorFactory = this.f10982a;
        if (decoratorFactory != null) {
            return decoratorFactory.onCreateView(view, str, context, attributeSet);
        }
        return null;
    }

    public void attach(DecoratorFactory decoratorFactory) {
        this.f10982a = decoratorFactory;
    }

    public void detach(DecoratorFactory decoratorFactory) {
        if (this.f10982a == decoratorFactory) {
            this.f10982a = null;
        }
    }

    public void onDecorateView(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        onCreateView(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }
}
