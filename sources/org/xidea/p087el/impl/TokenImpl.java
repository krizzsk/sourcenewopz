package org.xidea.p087el.impl;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xidea.p087el.ExpressionSyntaxException;
import org.xidea.p087el.ExpressionToken;
import org.xidea.p087el.OperationStrategy;
import org.xidea.p087el.ValueStack;
import org.xidea.p087el.json.JSONEncoder;

/* renamed from: org.xidea.el.impl.TokenImpl */
public class TokenImpl extends AbstractList<Object> implements ExpressionToken {
    static final int BRACKET_BEGIN = 65534;
    static final int BRACKET_END = 65535;
    private static final Object[] EMPTY_ARGS = new Object[0];
    private static final Map<Integer, String> LABEL_MAP = new HashMap();
    static final int OP_GET_STATIC = 32;
    static final int OP_INVOKE_WITH_STATIC_PARAM = 33;
    private static final Map<String, Integer> TOKEN_MAP = new HashMap();
    private TokenImpl left;
    private Object param;
    private TokenImpl right;
    private int type;
    String value;

    static int getArgCount(int i) {
        if (i < 0) {
            return 0;
        }
        return ((i & 192) >> 6) + 1;
    }

    static {
        for (Field field : ExpressionToken.class.getFields()) {
            try {
                LABEL_MAP.put((Integer) field.get((Object) null), field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TOKEN_MAP.put(".", 96);
        TOKEN_MAP.put("!", 28);
        TOKEN_MAP.put("^", 29);
        TOKEN_MAP.put("*", 88);
        TOKEN_MAP.put("/", 89);
        TOKEN_MAP.put("%", 90);
        TOKEN_MAP.put(IMTextUtils.STREET_IMAGE_TAG_START, 336);
        TOKEN_MAP.put(IMTextUtils.STREET_IMAGE_TAG_END, 337);
        TOKEN_MAP.put("<=", 338);
        TOKEN_MAP.put(">=", 339);
        TOKEN_MAP.put("==", 80);
        TOKEN_MAP.put("!=", 81);
        TOKEN_MAP.put("===", 82);
        TOKEN_MAP.put("!==", 83);
        TOKEN_MAP.put(ParamKeys.SIGN_AND, 588);
        TOKEN_MAP.put("^", 332);
        TOKEN_MAP.put("|", 76);
        TOKEN_MAP.put("&&", 328);
        TOKEN_MAP.put("||", 72);
        TOKEN_MAP.put("?", 68);
        TOKEN_MAP.put(":", 69);
        TOKEN_MAP.put(",", 64);
        for (String next : TOKEN_MAP.keySet()) {
            LABEL_MAP.put(TOKEN_MAP.get(next), next);
        }
        LABEL_MAP.put(Integer.valueOf(BRACKET_BEGIN), "(");
        LABEL_MAP.put(65535, ")");
    }

    public TokenImpl(int i, Object obj) {
        this.type = i;
        this.param = obj;
    }

    public TokenImpl(String str) {
        if (TOKEN_MAP.containsKey(str)) {
            this.type = TOKEN_MAP.get(str).intValue();
            return;
        }
        throw new ExpressionSyntaxException("未知操作符：" + str);
    }

    public TokenImpl optimize(OperationStrategy operationStrategy, Map<String, Object> map) {
        return optimize(operationStrategy, map, new OptimizeStack(map));
    }

    private TokenImpl optimize(OperationStrategy operationStrategy, Map<String, Object> map, ValueStack valueStack) {
        TokenImpl tokenImpl;
        int type2;
        int i = this.type;
        if (i > 0) {
            boolean z = false;
            if ((i == 97 || i == 33) && ((type2 = this.left.getType()) == 96 || type2 == 32)) {
                TokenImpl tokenImpl2 = this.left;
                tokenImpl2.left = tokenImpl2.left.optimize(operationStrategy, map, valueStack);
                TokenImpl tokenImpl3 = this.left;
                tokenImpl3.right = tokenImpl3.right.optimize(operationStrategy, map, valueStack);
                TokenImpl tokenImpl4 = this.right;
                if (tokenImpl4 != null) {
                    this.right = tokenImpl4.optimize(operationStrategy, map, valueStack);
                }
                z = true;
            }
            try {
                Object evaluate = operationStrategy.evaluate(this, valueStack);
                if (evaluate == null || (evaluate instanceof Number) || (evaluate instanceof CharSequence) || (evaluate instanceof Boolean)) {
                    return new TokenImpl(-1, evaluate);
                }
            } catch (Exception unused) {
            }
            if (!z && (tokenImpl = this.left) != null) {
                this.left = tokenImpl.optimize(operationStrategy, map, valueStack);
                TokenImpl tokenImpl5 = this.right;
                if (tokenImpl5 != null) {
                    this.right = tokenImpl5.optimize(operationStrategy, map, valueStack);
                }
            }
            optimize();
        }
        return this;
    }

    private void optimize() {
        int i = this.type;
        if (i == 96) {
            if (this.right.getType() == -1) {
                this.type = 32;
                setParam(this.right.getParam());
            }
        } else if (i != 97) {
        } else {
            if (this.right.getType() == -3) {
                this.type = 33;
                setParam(EMPTY_ARGS);
                return;
            }
            TokenImpl tokenImpl = this.right;
            ArrayList arrayList = null;
            while (true) {
                int i2 = tokenImpl.type;
                if (i2 != 64) {
                    if (i2 == -3) {
                        this.type = 33;
                        setParam(arrayList.toArray());
                        return;
                    }
                    return;
                } else if (tokenImpl.right.type == -1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(0, tokenImpl.right.getParam());
                    tokenImpl = tokenImpl.left;
                } else {
                    return;
                }
            }
        }
    }

    public int getType() {
        return this.type;
    }

    public ExpressionToken getLeft() {
        return this.left;
    }

    public ExpressionToken getRight() {
        return this.right;
    }

    public Object getParam() {
        return this.param;
    }

    public void setLeft(TokenImpl tokenImpl) {
        this.left = tokenImpl;
    }

    public void setRight(TokenImpl tokenImpl) {
        this.right = tokenImpl;
    }

    public void setParam(Object obj) {
        this.param = obj;
    }

    public String toString() {
        String str = this.value;
        if (str != null) {
            return str;
        }
        return String.valueOf(LABEL_MAP.get(Integer.valueOf(this.type))) + ":" + JSONEncoder.encode(this);
    }

    public static TokenImpl toToken(List<Object> list) {
        if (list == null) {
            return null;
        }
        int intValue = ((Number) list.get(0)).intValue();
        TokenImpl tokenImpl = new TokenImpl(intValue, (Object) null);
        int argCount = getArgCount(intValue) + 1;
        int size = list.size();
        int min = Math.min(argCount, size);
        if (min != 1) {
            if (min != 2) {
                if (min == 3) {
                    tokenImpl.setRight(toToken((List) list.get(2)));
                } else {
                    throw new ExpressionSyntaxException("tokens 長度最大為4");
                }
            }
            tokenImpl.setLeft(toToken((List) list.get(1)));
        }
        if (argCount < size) {
            tokenImpl.setParam(list.get(argCount));
        }
        return tokenImpl;
    }

    public Object get(int i) {
        int i2 = this.type;
        if (i2 == 32) {
            if (i == 0) {
                return 96;
            }
            if (i == 1) {
                return this.left;
            }
            if (i == 2) {
                return this.right;
            }
            return null;
        } else if (i2 == 33) {
            if (i == 0) {
                return 97;
            }
            if (i == 1) {
                return this.left;
            }
            if (i == 2) {
                return this.right;
            }
            return null;
        } else if (i == 0) {
            return Integer.valueOf(i2);
        } else {
            if (i2 > 0) {
                if (i < getArgCount(i2) + 1) {
                    if (i == 1) {
                        return this.left;
                    }
                    if (i == 2) {
                        return this.right;
                    }
                }
                return this.param;
            } else if (i == 1) {
                return this.param;
            } else {
                return null;
            }
        }
    }

    public int size() {
        int i = this.type;
        if (32 == i || 33 == i) {
            return 3;
        }
        int argCount = getArgCount(i) + 1;
        return hasParam() ? argCount + 1 : argCount;
    }

    private boolean hasParam() {
        int i = this.type;
        return i == -2 || i == -1 || i == 32 || i == 33 || i == 65;
    }

    public static boolean isPrefix(int i) {
        return getArgCount(i) == 1;
    }
}
