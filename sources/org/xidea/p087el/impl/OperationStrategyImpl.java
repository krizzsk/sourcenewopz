package org.xidea.p087el.impl;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.Reference;
import org.xidea.p087el.ValueStack;
import org.xidea.p087el.p088fn.ECMA262Impl;

/* renamed from: org.xidea.el.impl.OperationStrategyImpl */
public class OperationStrategyImpl implements OperationStrategy {
    private static final Log log = LogFactory.getLog(OperationStrategyImpl.class);

    /* renamed from: na */
    private static final NumberArithmetic f6716na = new NumberArithmetic();
    boolean customizable;
    private final Map<Object, Object> globalMap = new HashMap();
    private final Map<String, Map<String, Invocable>> methodMap = new HashMap();

    public OperationStrategyImpl(boolean z) {
        this.customizable = z;
    }

    public Map<Object, Object> getGlobalMap() {
        return Collections.unmodifiableMap(this.globalMap);
    }

    /* access modifiers changed from: protected */
    public void addVar(Object obj, Object obj2) {
        this.globalMap.put(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public void addMethod(Class<? extends Object> cls, String str, Invocable invocable) {
        Map map = this.methodMap.get(str);
        if (map == null) {
            map = new HashMap();
            this.methodMap.put(str, map);
        }
        map.put(cls.getName(), invocable);
    }

    /* access modifiers changed from: protected */
    public boolean compare(Object obj, Object obj2, int i) {
        if (obj == null) {
            if (obj2 == null) {
                return i == 339 || i == 338;
            }
        } else if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return f6716na.compare((Number) obj, (Number) obj2, i);
        } else {
            if (obj.equals(obj2)) {
                return i == 339 || i == 338;
            }
        }
        Object ToPrimitive = ECMA262Impl.ToPrimitive(obj, Number.class);
        Object ToPrimitive2 = ECMA262Impl.ToPrimitive(obj2, Number.class);
        if ((ToPrimitive instanceof String) && (ToPrimitive2 instanceof String)) {
            return f6716na.compare(Integer.valueOf(((String) ToPrimitive).compareTo((String) ToPrimitive2)), 0, i);
        }
        return f6716na.compare(ECMA262Impl.ToNumber(ToPrimitive), ECMA262Impl.ToNumber(ToPrimitive2), i);
    }

    /* access modifiers changed from: protected */
    public boolean isEquals(Object obj, Object obj2, boolean z) {
        if (obj == null || obj2 == null) {
            return obj == obj2;
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return f6716na.compare((Number) obj, (Number) obj2, 80);
        }
        if (obj.equals(obj2)) {
            return true;
        }
        if (z) {
            return false;
        }
        if ((obj instanceof String) && (obj2 instanceof String)) {
            return false;
        }
        Object ToPrimitive = ECMA262Impl.ToPrimitive(obj, Number.class);
        Object ToPrimitive2 = ECMA262Impl.ToPrimitive(obj2, Number.class);
        if ((ToPrimitive instanceof String) && (ToPrimitive2 instanceof String)) {
            return ToPrimitive.equals(ToPrimitive2);
        }
        return f6716na.compare(ECMA262Impl.ToNumber(ToPrimitive), ECMA262Impl.ToNumber(ToPrimitive2), 80);
    }

    public Object evaluate(ExpressionToken expressionToken, ValueStack valueStack) {
        Object[] objArr;
        Object obj;
        Object obj2;
        int type = expressionToken.getType();
        if (type == -4) {
            return new LinkedHashMap();
        }
        if (type == -3) {
            return new ArrayList();
        }
        if (type == -2) {
            Object param = expressionToken.getParam();
            Object obj3 = valueStack.get(param);
            return obj3 == null ? this.globalMap.get(param) : obj3;
        } else if (type == -1) {
            return expressionToken.getParam();
        } else {
            if (type == 33 || type == 97) {
                if (type == 97) {
                    objArr = ((List) evaluate(expressionToken.getRight(), valueStack)).toArray();
                } else {
                    objArr = (Object[]) expressionToken.getParam();
                }
                ExpressionToken left = expressionToken.getLeft();
                int type2 = left.getType();
                if (type2 == 96) {
                    obj2 = evaluate(left.getLeft(), valueStack);
                    obj = evaluate(left.getRight(), valueStack);
                } else if (type2 != 32) {
                    return invoke(valueStack, evaluate(left, valueStack), objArr);
                } else {
                    obj2 = evaluate(left.getLeft(), valueStack);
                    obj = left.getRight().getParam();
                }
                return invoke(valueStack, new ReferenceImpl(obj2, obj), objArr);
            }
            Object evaluate = evaluate(expressionToken.getLeft(), valueStack);
            if (type == 32) {
                return ReflectUtil.getValue(evaluate, expressionToken.getParam());
            }
            if (type != 72) {
                if (type == 96) {
                    return ReflectUtil.getValue(evaluate, evaluate(expressionToken.getRight(), valueStack));
                }
                if (type == 328) {
                    return ECMA262Impl.ToBoolean(evaluate) ? evaluate(expressionToken.getRight(), valueStack) : evaluate;
                }
                if (type == 68) {
                    return expressionToken;
                }
                if (type != 69) {
                    Object evaluate2 = (type & 192) > 0 ? evaluate(expressionToken.getRight(), valueStack) : null;
                    if (type == 28) {
                        return Boolean.valueOf(!ECMA262Impl.ToBoolean(evaluate));
                    }
                    if (type == 4432) {
                        return Boolean.valueOf(mo38350in(evaluate, evaluate2));
                    }
                    if (type == 30) {
                        return ECMA262Impl.ToNumber(evaluate);
                    }
                    if (type == 31) {
                        return f6716na.subtract(0, ECMA262Impl.ToNumber(evaluate));
                    }
                    if (type == 64) {
                        ((List) evaluate).add(evaluate2);
                        return evaluate;
                    } else if (type != 65) {
                        switch (type) {
                            case 80:
                                return Boolean.valueOf(isEquals(evaluate, evaluate2, false));
                            case 81:
                                return Boolean.valueOf(!isEquals(evaluate, evaluate2, false));
                            case 82:
                                return Boolean.valueOf(isEquals(evaluate, evaluate2, true));
                            case 83:
                                return Boolean.valueOf(!isEquals(evaluate, evaluate2, true));
                            case 84:
                                Object ToPrimitive = ECMA262Impl.ToPrimitive(evaluate, String.class);
                                Object ToPrimitive2 = ECMA262Impl.ToPrimitive(evaluate2, String.class);
                                if (!(ToPrimitive instanceof String) && !(ToPrimitive2 instanceof String)) {
                                    return f6716na.add(ECMA262Impl.ToNumber(ToPrimitive), ECMA262Impl.ToNumber(ToPrimitive2));
                                }
                                return String.valueOf(String.valueOf(ToPrimitive)) + ToPrimitive2;
                            case 85:
                                return f6716na.subtract(ECMA262Impl.ToNumber(evaluate), ECMA262Impl.ToNumber(evaluate2));
                            default:
                                switch (type) {
                                    case 88:
                                        return f6716na.multiply(ECMA262Impl.ToNumber(evaluate), ECMA262Impl.ToNumber(evaluate2));
                                    case 89:
                                        return f6716na.divide(ECMA262Impl.ToNumber(evaluate), ECMA262Impl.ToNumber(evaluate2), true);
                                    case 90:
                                        return f6716na.modulus(ECMA262Impl.ToNumber(evaluate), ECMA262Impl.ToNumber(evaluate2));
                                    default:
                                        switch (type) {
                                            case 336:
                                            case 337:
                                            case 338:
                                            case 339:
                                                return Boolean.valueOf(compare(evaluate, evaluate2, type));
                                            default:
                                                Object obj4 = this.globalMap.get(Integer.valueOf(type));
                                                if (obj4 != null) {
                                                    try {
                                                        return ((Invocable) obj4).invoke((Object) null, evaluate, evaluate2);
                                                    } catch (Exception e) {
                                                        if (log.isDebugEnabled()) {
                                                            Log log2 = log;
                                                            log2.debug("方法调用失败:" + evaluate, e);
                                                        }
                                                    }
                                                }
                                                throw new RuntimeException("不支持的操作符" + expressionToken.getType());
                                        }
                                }
                        }
                    } else {
                        ((Map) evaluate).put(expressionToken.getParam(), evaluate2);
                        return evaluate;
                    }
                } else {
                    ExpressionToken expressionToken2 = (ExpressionToken) evaluate;
                    if (ECMA262Impl.ToBoolean(evaluate(expressionToken2.getLeft(), valueStack))) {
                        return evaluate(expressionToken2.getRight(), valueStack);
                    }
                    return evaluate(expressionToken.getRight(), valueStack);
                }
            } else if (ECMA262Impl.ToBoolean(evaluate)) {
                return evaluate;
            } else {
                return evaluate(expressionToken.getRight(), valueStack);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: in */
    public boolean mo38350in(Object obj, Object obj2) {
        int i;
        Class<?> cls = obj2.getClass();
        if (obj2 instanceof List) {
            i = ((List) obj2).size();
        } else {
            i = cls.isArray() ? Array.getLength(obj2) : -1;
        }
        if (i < 0) {
            String ToString = ECMA262Impl.ToString(obj);
            if (obj2 instanceof Map) {
                return ((Map) obj2).containsKey(ToString);
            }
            return ReflectUtil.getPropertyType(cls, ToString) != null;
        } else if ("length".equals(obj)) {
            return true;
        } else {
            Number ToNumber = ECMA262Impl.ToNumber(obj);
            int intValue = ToNumber.intValue();
            return intValue >= 0 && intValue <= i && ((float) intValue) == ToNumber.floatValue();
        }
    }

    private Object invoke(ValueStack valueStack, Object obj, Object[] objArr) {
        Object obj2;
        Invocable invocable;
        try {
            if (obj instanceof Reference) {
                Reference reference = (Reference) obj;
                invocable = ReferenceImpl.createInvocable(reference, this.methodMap, objArr);
                obj2 = reference.getBase();
            } else if (obj instanceof Invocable) {
                invocable = (Invocable) obj;
                obj2 = valueStack;
            } else if (obj instanceof Method) {
                invocable = ReferenceImpl.createProxy((Method) obj);
                obj2 = valueStack;
            } else {
                invocable = null;
                obj2 = valueStack;
            }
            return invocable.invoke(obj2, objArr);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("方法调用失败:" + obj, e);
            }
            return null;
        }
    }

    public Object getVar(ValueStack valueStack, Object obj) {
        Object obj2 = valueStack.get(obj);
        return obj2 == null ? this.globalMap.get(obj) : obj2;
    }
}
