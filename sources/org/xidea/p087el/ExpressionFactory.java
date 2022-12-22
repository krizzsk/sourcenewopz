package org.xidea.p087el;

import org.xidea.p087el.impl.ExpressionFactoryImpl;

/* renamed from: org.xidea.el.ExpressionFactory */
public abstract class ExpressionFactory {
    public abstract Expression create(Object obj);

    public abstract Object parse(String str);

    public static ExpressionFactory getInstance() {
        return ExpressionFactoryImpl.getInstance();
    }
}
