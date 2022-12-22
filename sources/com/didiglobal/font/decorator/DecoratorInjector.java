package com.didiglobal.font.decorator;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterCompat;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.DecoratorFactory;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/font/decorator/DecoratorInjector;", "", "()V", "inject", "", "context", "Landroid/content/Context;", "CombineFactory", "lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DecoratorInjector.kt */
public final class DecoratorInjector {
    public static final DecoratorInjector INSTANCE = new DecoratorInjector();

    private DecoratorInjector() {
    }

    @JvmStatic
    public static final void inject(Context context) {
        LayoutInflater layoutInflater;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (context instanceof Activity) {
            layoutInflater = ((Activity) context).getLayoutInflater();
        } else {
            layoutInflater = LayoutInflater.from(context);
        }
        if (layoutInflater != null) {
            ServiceLoader<S> load = ServiceLoader.load(DecoratorFactory.class);
            LayoutInflater.Factory factory = null;
            if (layoutInflater.getFactory2() == null) {
                LayoutInflater.Factory factory2 = null;
                if (context instanceof AppCompatActivity) {
                    AppCompatDelegate delegate = ((AppCompatActivity) context).getDelegate();
                    Intrinsics.checkExpressionValueIsNotNull(delegate, "context.delegate");
                    factory2 = new DecoratorInjector$inject$1(delegate);
                }
                Intrinsics.checkExpressionValueIsNotNull(load, "decoratorFactories");
                layoutInflater.setFactory2(new CombineFactory(factory2, load));
                return;
            }
            Class<LayoutInflater> cls = LayoutInflater.class;
            try {
                Field declaredField = LayoutInflaterCompat.class.getDeclaredField("sCheckedField");
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "compatClass.getDeclaredField(\"sCheckedField\")");
                declaredField.setAccessible(true);
                declaredField.setBoolean(layoutInflater, false);
                Field declaredField2 = cls.getDeclaredField("mFactory");
                Intrinsics.checkExpressionValueIsNotNull(declaredField2, "inflaterClass.getDeclaredField(\"mFactory\")");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mFactory2");
                Intrinsics.checkExpressionValueIsNotNull(declaredField3, "inflaterClass.getDeclaredField(\"mFactory2\")");
                declaredField3.setAccessible(true);
                if (layoutInflater.getFactory2() != null) {
                    factory = layoutInflater.getFactory2();
                } else if (layoutInflater.getFactory() != null) {
                    factory = layoutInflater.getFactory();
                } else {
                    SystemUtils.log(6, "dongxt", " reflection --------null ", (Throwable) null, "com.didiglobal.font.decorator.DecoratorInjector", 79);
                }
                Intrinsics.checkExpressionValueIsNotNull(load, "decoratorFactories");
                CombineFactory combineFactory = new CombineFactory(factory, load);
                declaredField3.set(layoutInflater, combineFactory);
                declaredField2.set(layoutInflater, combineFactory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J,\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/font/decorator/DecoratorInjector$CombineFactory;", "Landroid/view/LayoutInflater$Factory2;", "factory", "Landroid/view/LayoutInflater$Factory;", "decoratorFactories", "", "Lcom/didiglobal/font/iface/DecoratorFactory;", "(Landroid/view/LayoutInflater$Factory;Ljava/lang/Iterable;)V", "getDecoratorFactories", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DecoratorInjector.kt */
    public static final class CombineFactory implements LayoutInflater.Factory2 {
        private final Iterable<DecoratorFactory> decoratorFactories;
        private final LayoutInflater.Factory factory;

        public CombineFactory(LayoutInflater.Factory factory2, Iterable<? extends DecoratorFactory> iterable) {
            Intrinsics.checkParameterIsNotNull(iterable, "decoratorFactories");
            this.factory = factory2;
            this.decoratorFactories = iterable;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            View view2;
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attributeSet, RavenKey.ATTRS);
            LayoutInflater.Factory factory2 = this.factory;
            if (factory2 instanceof LayoutInflater.Factory2) {
                view2 = ((LayoutInflater.Factory2) factory2).onCreateView(view, str, context, attributeSet);
            } else {
                view2 = factory2 != null ? factory2.onCreateView(str, context, attributeSet) : null;
            }
            for (DecoratorFactory next : this.decoratorFactories) {
                if (view2 != null) {
                    next.onDecorateView(view, view2, str, context, attributeSet);
                } else {
                    view2 = next.onCreateView(view, str, context, attributeSet);
                    if (view2 == null) {
                        view2 = next.onCreateView(str, context, attributeSet);
                    }
                }
            }
            return view2;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(attributeSet, RavenKey.ATTRS);
            return onCreateView((View) null, str, context, attributeSet);
        }

        public final Iterable<DecoratorFactory> getDecoratorFactories() {
            return this.decoratorFactories;
        }
    }
}
