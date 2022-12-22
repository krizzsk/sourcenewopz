package org.xidea.p087el.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xidea.p087el.Expression;
import org.xidea.p087el.ExpressionInfo;
import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.Reference;
import org.xidea.p087el.ReferenceExpression;
import org.xidea.p087el.ValueStack;
import org.xidea.p087el.json.JSONEncoder;

/* renamed from: org.xidea.el.impl.ExpressionImpl */
public class ExpressionImpl implements Expression, ExpressionInfo, ReferenceExpression {
    private static ValueStack EMPTY_VS = new ValueStackImpl(Collections.emptyMap());
    protected final ExpressionToken expression;
    protected final OperationStrategy strategy;

    public ExpressionImpl(String str) {
        ExpressionFactoryImpl instance = ExpressionFactoryImpl.getInstance();
        this.expression = (ExpressionToken) instance.parse(str);
        this.strategy = instance.getStrategy();
    }

    public ExpressionImpl(ExpressionToken expressionToken, OperationStrategy operationStrategy) {
        this.strategy = operationStrategy;
        this.expression = expressionToken;
    }

    public Object evaluate(Object obj) {
        ValueStack valueStack;
        if (obj instanceof ValueStack) {
            valueStack = (ValueStack) obj;
        } else if (obj == null) {
            valueStack = EMPTY_VS;
        } else {
            valueStack = new ValueStackImpl(obj);
        }
        return this.strategy.evaluate(this.expression, valueStack);
    }

    public Object evaluate(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return evaluate((Object) null);
        }
        int i = 0;
        if (objArr.length == 1) {
            return evaluate(objArr[0]);
        }
        if ((objArr.length & 1) != 1) {
            HashMap hashMap = new HashMap();
            while (i < objArr.length) {
                Object obj = objArr[i];
                int i2 = i + 1;
                hashMap.put(obj, objArr[i2]);
                i = i2 + 1;
            }
            System.out.println(JSONEncoder.encode(hashMap));
            return evaluate((Object) hashMap);
        }
        throw new IllegalArgumentException("参数必须是偶数个数");
    }

    public Reference prepare(Object obj) {
        ValueStack valueStack;
        if (obj == null) {
            valueStack = EMPTY_VS;
        } else if (obj instanceof ValueStack) {
            valueStack = (ValueStack) obj;
        } else {
            valueStack = new RefrenceStackImpl(obj);
        }
        Object prepare = prepare(this.expression, valueStack);
        if (prepare instanceof Reference) {
            return (Reference) prepare;
        }
        return new ReferenceImpl(new Object[]{prepare}, 0);
    }

    /* access modifiers changed from: protected */
    public Object prepare(ExpressionToken expressionToken, ValueStack valueStack) {
        Object obj;
        int type = expressionToken.getType();
        if (type == 32) {
            obj = expressionToken.getParam();
        } else if (type != 96) {
            return this.strategy.evaluate(expressionToken, valueStack);
        } else {
            obj = this.strategy.evaluate(expressionToken.getRight(), valueStack);
        }
        Object prepare = prepare(expressionToken.getLeft(), valueStack);
        if (prepare instanceof Reference) {
            return ((Reference) prepare).next(obj);
        }
        return new ReferenceImpl(prepare, obj);
    }

    public String toString() {
        return this.expression.toString();
    }

    public List<String> getVars() {
        ArrayList arrayList = new ArrayList();
        appendVar(this.expression, arrayList);
        return arrayList;
    }

    static void appendVar(ExpressionToken expressionToken, List<String> list) {
        if (expressionToken != null) {
            int type = expressionToken.getType();
            if (type > 0) {
                appendVar(expressionToken.getRight(), list);
                appendVar(expressionToken.getLeft(), list);
            } else if (type == -2) {
                list.add((String) expressionToken.getParam());
            }
        }
    }
}
