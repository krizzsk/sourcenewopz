package org.xidea.p087el.impl;

import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.ValueStack;

/* renamed from: org.xidea.el.impl.PropertiesImpl */
/* compiled from: OptimizeExpressionImpl */
class PropertiesImpl extends PropertyImpl {
    private Object[] keys;

    public PropertiesImpl(ExpressionToken expressionToken, OperationStrategy operationStrategy, String str, Object[] objArr) {
        super(expressionToken, operationStrategy, str, (Object) null);
        this.keys = objArr;
    }

    /* access modifiers changed from: protected */
    public Object compute(ValueStack valueStack) {
        Object var = this.strategy.getVar(valueStack, this.name);
        int length = this.keys.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return var;
            }
            var = ReflectUtil.getValue(var, this.keys[i]);
            length = i;
        }
    }
}
