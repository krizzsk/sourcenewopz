package org.xidea.p087el.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xidea.p087el.Expression;
import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.ValueStack;

/* renamed from: org.xidea.el.impl.OptimizeExpressionImpl */
public class OptimizeExpressionImpl extends ExpressionImpl {
    protected String name;

    public OptimizeExpressionImpl(ExpressionToken expressionToken, OperationStrategy operationStrategy, String str) {
        super(expressionToken, operationStrategy);
        this.name = str;
    }

    public List<String> getVars() {
        return Arrays.asList(new String[]{this.name});
    }

    public Object evaluate(Object obj) {
        ValueStack valueStack;
        if (obj == null) {
            valueStack = new ValueStackImpl(new Object[0]);
        } else if (obj instanceof ValueStack) {
            valueStack = (ValueStack) obj;
        } else {
            valueStack = new ValueStackImpl(obj);
        }
        return compute(valueStack);
    }

    /* access modifiers changed from: protected */
    public Object compute(ValueStack valueStack) {
        return this.strategy.getVar(valueStack, this.name);
    }

    public static Expression create(ExpressionToken expressionToken, OperationStrategy operationStrategy) {
        if (expressionToken.getType() == -2) {
            return new OptimizeExpressionImpl(expressionToken, operationStrategy, (String) expressionToken.getParam());
        }
        if (expressionToken.getType() != 32) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ExpressionToken expressionToken2 = expressionToken;
        while (expressionToken2.getType() == 32) {
            arrayList.add(expressionToken2.getParam());
            expressionToken2 = expressionToken2.getLeft();
        }
        if (expressionToken2.getType() != -2) {
            return null;
        }
        String str = (String) expressionToken2.getParam();
        Object[] array = arrayList.toArray();
        if (array.length != 1) {
            return new PropertiesImpl(expressionToken, operationStrategy, str, array);
        }
        return new PropertyImpl(expressionToken, operationStrategy, str, array[0]);
    }
}
