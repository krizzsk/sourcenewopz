package org.xidea.p087el.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xidea.p087el.Expression;
import org.xidea.p087el.ExpressionFactory;
import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.p088fn.ECMA262Impl;

/* renamed from: org.xidea.el.impl.ExpressionFactoryImpl */
public class ExpressionFactoryImpl extends ExpressionFactory {
    private static ExpressionFactoryImpl expressionFactory;
    private Map<String, Integer> aliseMap;
    private int inc;
    private final OperationStrategy strategy;

    public static ExpressionFactoryImpl getInstance() {
        if (expressionFactory == null) {
            ExpressionFactoryImpl expressionFactoryImpl = new ExpressionFactoryImpl();
            expressionFactory = expressionFactoryImpl;
            expressionFactoryImpl.aliseMap = Collections.emptyMap();
            expressionFactory.getImpl().customizable = false;
        }
        return expressionFactory;
    }

    public ExpressionFactoryImpl(OperationStrategy operationStrategy) {
        this.aliseMap = new HashMap();
        this.inc = 1;
        this.strategy = operationStrategy;
    }

    public OperationStrategy getStrategy() {
        return getImpl();
    }

    public ExpressionFactoryImpl() {
        this.aliseMap = new HashMap();
        this.inc = 1;
        this.strategy = new OperationStrategyImpl(true);
        ECMA262Impl.setup(this);
    }

    private OperationStrategyImpl getImpl() {
        OperationStrategy operationStrategy = this.strategy;
        if (operationStrategy instanceof OperationStrategyImpl) {
            return (OperationStrategyImpl) operationStrategy;
        }
        throw new UnsupportedOperationException();
    }

    public void addVar(String str, Object obj) {
        getImpl().addVar(str, obj);
    }

    public void addMethod(Class<? extends Object> cls, String str, Invocable invocable) {
        getImpl().addMethod(cls, str, invocable);
    }

    public void addOperator(int i, String str, Object obj) {
        if (obj == null) {
            this.aliseMap.put(str, Integer.valueOf(i));
            return;
        }
        if (obj instanceof Method) {
            Method method = (Method) obj;
            if (Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                obj = ReferenceImpl.createProxy(method);
            }
        }
        if (obj instanceof Invocable) {
            int i2 = this.inc;
            this.inc = i2 + 1;
            int i3 = i + (i2 << 12);
            this.aliseMap.put(str, Integer.valueOf(i3));
            getImpl().addVar(Integer.valueOf(i3), obj);
            return;
        }
        throw new IllegalArgumentException("操作符实现只支持public static 模式函数或者org.xidea.el.Invocable 对象");
    }

    public Object parse(String str) {
        ExpressionParser expressionParser = new ExpressionParser(str);
        expressionParser.setAliasMap(this.aliseMap);
        return expressionParser.parseEL().optimize(this.strategy, Collections.EMPTY_MAP);
    }

    public Expression create(Object obj) {
        ExpressionToken expressionToken;
        if (obj instanceof String) {
            return create(parse((String) obj));
        }
        if (obj instanceof ExpressionToken) {
            expressionToken = (ExpressionToken) obj;
        } else {
            expressionToken = TokenImpl.toToken((List) obj);
        }
        return getOptimizedExpression(expressionToken);
    }

    private Expression getOptimizedExpression(ExpressionToken expressionToken) {
        Expression create = OptimizeExpressionImpl.create(expressionToken, this.strategy);
        return create != null ? create : new ExpressionImpl(expressionToken, this.strategy);
    }
}
