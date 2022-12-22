package org.xidea.p087el.impl;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xidea.p087el.ExpressionSyntaxException;
import org.xidea.p087el.json.JSONTokenizer;

/* renamed from: org.xidea.el.impl.ExpressionParser */
public class ExpressionParser extends JSONTokenizer {
    private static final TokenImpl TOKEN_FALSE = new TokenImpl(-1, Boolean.FALSE);
    private static final TokenImpl TOKEN_NULL = new TokenImpl(-1, (Object) null);
    private static final TokenImpl TOKEN_TRUE = new TokenImpl(-1, Boolean.TRUE);
    private Map<String, Integer> aliasMap = Collections.emptyMap();
    private int depth;
    protected TokenImpl expression;
    private int previousType = Integer.MIN_VALUE;
    private ParseStatus status = ParseStatus.BEGIN;
    protected ArrayList<TokenImpl> tokens = new ArrayList<>();

    /* access modifiers changed from: protected */
    public int getPriority(int i) {
        switch (i) {
            case 65534:
            case 65535:
                return Integer.MIN_VALUE;
            default:
                return ((i & 3840) >> 8) | ((i & 60) << 4);
        }
    }

    public ExpressionParser(String str) {
        super(str, false);
    }

    public void setAliasMap(Map<String, Integer> map) {
        this.aliasMap = map;
    }

    public TokenImpl parseEL() {
        skipSpace(0);
        while (this.start < this.end) {
            char lower = toLower(this.value.charAt(this.start));
            if (lower == '\"' || lower == '\'') {
                addKeyOrObject(findString(), false);
            } else if (lower >= '0' && lower <= '9') {
                addKeyOrObject(findNumber(), false);
            } else if (Character.isJavaIdentifierStart(lower)) {
                addId(findId());
            } else {
                addOperator(findOperator());
            }
            skipSpace(0);
        }
        if (this.depth != 0) {
            fail("表达式括弧不匹配");
        }
        prepareSelect();
        LinkedList linkedList = new LinkedList();
        try {
            toTree(right(this.tokens), linkedList);
            if (linkedList.size() != 1) {
                fail("表达式语法错误");
            }
            TokenImpl tokenImpl = (TokenImpl) linkedList.getFirst();
            this.expression = tokenImpl;
            tokenImpl.value = this.value;
            return this.expression;
        } catch (Exception e) {
            throw new ExpressionSyntaxException("逆波兰式树型化异常", e);
        }
    }

    private void prepareSelect() {
        int size = this.tokens.size();
        while (true) {
            int i = size - 1;
            if (size > 0) {
                int type = this.tokens.get(i).getType();
                if (type == 68) {
                    this.tokens.add(getSelectRange(i, -1, -1) + 1, new TokenImpl(65534, (Object) null));
                    size = i + 1;
                } else {
                    if (type == 69) {
                        this.tokens.add(getSelectRange(i, 1, this.tokens.size()), new TokenImpl(65535, (Object) null));
                    }
                    size = i;
                }
            } else {
                return;
            }
        }
    }

    private int getSelectRange(int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            i += i2;
            if (i != i3) {
                int type = this.tokens.get(i).getType();
                if (type > 0) {
                    if (type == 65534) {
                        i4 += i2;
                    } else if (type == 65535) {
                        i4 -= i2;
                    } else if (i4 == 0 && getPriority(type) <= getPriority(68)) {
                        return i;
                    }
                    if (i4 < 0) {
                        return i;
                    }
                }
            } else if (i2 > 0) {
                return i3;
            } else {
                return -1;
            }
        }
    }

    private void toTree(List<TokenImpl> list, LinkedList<TokenImpl> linkedList) {
        for (TokenImpl next : list) {
            int type = next.getType();
            if (type == -4 || type == -3 || type == -2 || type == -1) {
                linkedList.addFirst(next);
            } else if ((type & 192) > 0) {
                next.setLeft(linkedList.removeFirst());
                next.setRight(linkedList.removeFirst());
                linkedList.addFirst(next);
            } else {
                next.setLeft(linkedList.removeFirst());
                linkedList.addFirst(next);
            }
        }
    }

    private List<TokenImpl> right(List<TokenImpl> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(new ArrayList());
        LinkedList linkedList2 = new LinkedList();
        Iterator<TokenImpl> it = list.iterator();
        while (it.hasNext()) {
            TokenImpl next = it.next();
            if (next.getType() <= 0) {
                addRightToken(linkedList, next);
            } else if (linkedList2.isEmpty()) {
                linkedList2.addFirst(next);
            } else if (next.getType() == 65534) {
                linkedList2.addFirst(next);
            } else if (next.getType() == 65535) {
                while (true) {
                    TokenImpl tokenImpl = (TokenImpl) linkedList2.removeFirst();
                    if (tokenImpl.getType() == 65534) {
                        break;
                    }
                    addRightToken(linkedList, tokenImpl);
                }
            } else {
                while (!linkedList2.isEmpty() && rightEnd(next, (TokenImpl) linkedList2.getFirst())) {
                    addRightToken(linkedList, (TokenImpl) linkedList2.removeFirst());
                }
                linkedList2.addFirst(next);
            }
        }
        while (!linkedList2.isEmpty()) {
            addRightToken(linkedList, (TokenImpl) linkedList2.removeFirst());
        }
        return (List) linkedList.getFirst();
    }

    private void addRightToken(LinkedList<List<TokenImpl>> linkedList, TokenImpl tokenImpl) {
        linkedList.getFirst().add(tokenImpl);
    }

    private boolean rightEnd(TokenImpl tokenImpl, TokenImpl tokenImpl2) {
        int type = tokenImpl2.getType();
        int type2 = tokenImpl.getType();
        int priority = getPriority(type);
        int priority2 = getPriority(type2);
        if ((priority != priority2 || !TokenImpl.isPrefix(type2)) && priority2 <= priority) {
            return true;
        }
        return false;
    }

    private void addToken(TokenImpl tokenImpl) {
        Integer num;
        int argCount;
        int type = tokenImpl.getType();
        if (type == 65534 || type < 0) {
            replacePrevious();
        }
        if (type == -2) {
            Object param = tokenImpl.getParam();
            if ("in".equals(param)) {
                num = 4432;
            } else {
                num = this.aliasMap.get(param);
            }
            if (num != null && (((argCount = TokenImpl.getArgCount(num.intValue())) == 2 && this.status == ParseStatus.EXPRESSION) || (argCount == 1 && this.status != ParseStatus.EXPRESSION))) {
                tokenImpl = new TokenImpl(num.intValue(), (Object) null);
            }
        }
        int type2 = tokenImpl.getType();
        if (!(type2 == -4 || type2 == -3 || type2 == -2 || type2 == -1)) {
            switch (type2) {
                case 65534:
                    this.depth++;
                    this.status = ParseStatus.BEGIN;
                    break;
                case 65535:
                    int i = this.depth - 1;
                    this.depth = i;
                    if (i < 0) {
                        fail("括弧异常");
                        break;
                    }
                    break;
                default:
                    this.status = ParseStatus.OPERATOR;
                    break;
            }
        }
        this.status = ParseStatus.EXPRESSION;
        this.previousType = type;
        this.tokens.add(tokenImpl);
    }

    private void replacePrevious() {
        Integer num;
        int size = this.tokens.size() - 1;
        if (this.previousType == -2 && size >= 0 && (num = this.aliasMap.get(this.tokens.get(size).getParam())) != null) {
            this.tokens.set(size, new TokenImpl(num.intValue(), (Object) null));
            this.status = ParseStatus.OPERATOR;
            this.previousType = num.intValue();
        }
    }

    private void addId(String str) {
        if ("true".equals(str)) {
            addToken(TOKEN_TRUE);
        } else if (SDKConsts.BOOLEAN_FALSE.equals(str)) {
            addToken(TOKEN_FALSE);
        } else if ("null".equals(str)) {
            addToken(TOKEN_NULL);
        } else {
            skipSpace(0);
            if (this.previousType == 96) {
                addToken(new TokenImpl(-1, str));
            } else {
                addKeyOrObject(str, true);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r2 == '=') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r1 == r2) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (toLower(r5.value.charAt(r0)) == '=') goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String findOperator() {
        /*
            r5 = this;
            int r0 = r5.start
            int r0 = r0 + 1
            java.lang.String r1 = r5.value
            int r2 = r5.start
            char r1 = r1.charAt(r2)
            char r1 = r5.toLower(r1)
            java.lang.String r2 = r5.value
            int r2 = r2.length()
            if (r2 <= r0) goto L_0x0023
            java.lang.String r2 = r5.value
            char r2 = r2.charAt(r0)
            char r2 = r5.toLower(r2)
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            r3 = 33
            r4 = 61
            if (r1 == r3) goto L_0x005d
            r3 = 58
            if (r1 == r3) goto L_0x0076
            r3 = 91
            if (r1 == r3) goto L_0x0076
            r3 = 37
            if (r1 == r3) goto L_0x0076
            r3 = 38
            if (r1 == r3) goto L_0x0058
            r3 = 93
            if (r1 == r3) goto L_0x0076
            r3 = 94
            if (r1 == r3) goto L_0x0076
            switch(r1) {
                case 40: goto L_0x0076;
                case 41: goto L_0x0076;
                case 42: goto L_0x0076;
                case 43: goto L_0x0076;
                case 44: goto L_0x0076;
                case 45: goto L_0x0076;
                case 46: goto L_0x0076;
                case 47: goto L_0x0076;
                default: goto L_0x0045;
            }
        L_0x0045:
            switch(r1) {
                case 60: goto L_0x0055;
                case 61: goto L_0x004d;
                case 62: goto L_0x0055;
                case 63: goto L_0x0076;
                default: goto L_0x0048;
            }
        L_0x0048:
            switch(r1) {
                case 123: goto L_0x0076;
                case 124: goto L_0x0058;
                case 125: goto L_0x0076;
                case 126: goto L_0x0076;
                default: goto L_0x004b;
            }
        L_0x004b:
            r0 = 0
            return r0
        L_0x004d:
            if (r2 == r4) goto L_0x005d
            java.lang.String r1 = "不支持赋值操作:"
            r5.fail(r1)
            goto L_0x005d
        L_0x0055:
            if (r2 != r4) goto L_0x0076
            goto L_0x005a
        L_0x0058:
            if (r1 != r2) goto L_0x0076
        L_0x005a:
            int r0 = r0 + 1
            goto L_0x0076
        L_0x005d:
            if (r2 != r4) goto L_0x0076
            int r0 = r0 + 1
            java.lang.String r1 = r5.value
            int r1 = r1.length()
            if (r1 <= r0) goto L_0x0076
            java.lang.String r1 = r5.value
            char r1 = r1.charAt(r0)
            char r1 = r5.toLower(r1)
            if (r1 != r4) goto L_0x0076
            goto L_0x005a
        L_0x0076:
            java.lang.String r1 = r5.value
            int r2 = r5.start
            r5.start = r0
            java.lang.String r0 = r1.substring(r2, r0)
            java.lang.String r0 = r5.toLower(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.impl.ExpressionParser.findOperator():java.lang.String");
    }

    private String toLower(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = toLower(charArray[i]);
        }
        return new String(charArray);
    }

    private void fail(String str) {
        throw new ExpressionSyntaxException(String.valueOf(str) + "\n@" + this.start + "\n" + this.value.substring(this.start) + "\n----\n" + this.value);
    }

    private void addOperator(String str) {
        int findRegExp;
        if (str == null) {
            fail("未知操作符:");
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (charAt != '(') {
                if (charAt != ')') {
                    if (charAt == '/') {
                        char charAt2 = this.value.charAt(this.start);
                        if (charAt2 == '/' || charAt2 == '*') {
                            this.start--;
                            skipComment();
                            return;
                        } else if (this.status == ParseStatus.EXPRESSION || (findRegExp = findRegExp(this.value, this.start)) <= 0) {
                            addToken(new TokenImpl(str));
                            return;
                        } else {
                            String substring = this.value.substring(this.start - 1, findRegExp);
                            HashMap hashMap = new HashMap();
                            hashMap.put("class", "RegExp");
                            hashMap.put("source", substring);
                            addToken(new TokenImpl(-1, hashMap));
                            this.start = findRegExp;
                            return;
                        }
                    } else if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt == '{') {
                                addMap();
                                return;
                            } else if (charAt != '}') {
                                switch (charAt) {
                                    case '+':
                                        addToken(new TokenImpl(this.status == ParseStatus.EXPRESSION ? 84 : 30, (Object) null));
                                        return;
                                    case ',':
                                        if (!isMapMethod()) {
                                            addToken(new TokenImpl(64, (Object) null));
                                            return;
                                        } else {
                                            this.status = ParseStatus.OPERATOR;
                                            return;
                                        }
                                    case '-':
                                        addToken(new TokenImpl(this.status == ParseStatus.EXPRESSION ? 85 : 31, (Object) null));
                                        return;
                                    default:
                                        addToken(new TokenImpl(str));
                                        return;
                                }
                            }
                        }
                    } else if (this.status == ParseStatus.EXPRESSION) {
                        addToken(new TokenImpl(96, (Object) null));
                        addToken(new TokenImpl(65534, (Object) null));
                        return;
                    } else {
                        addList();
                        return;
                    }
                }
                addToken(new TokenImpl(65535, (Object) null));
                return;
            }
            replacePrevious();
            if (this.status == ParseStatus.EXPRESSION) {
                addToken(new TokenImpl(97, (Object) null));
                if (skipSpace(41)) {
                    addToken(new TokenImpl(-1, Collections.EMPTY_LIST));
                    this.start++;
                    return;
                }
                addList();
                return;
            }
            addToken(new TokenImpl(65534, (Object) null));
            return;
        }
        addToken(new TokenImpl(str));
    }

    private boolean isMapMethod() {
        int i = 0;
        for (int size = this.tokens.size() - 1; size >= 0; size--) {
            int type = this.tokens.get(size).getType();
            if (i == 0) {
                if (type == 65 || type == -4) {
                    return true;
                }
                if (type == 64) {
                    return false;
                }
            }
            if (type == 65534) {
                i--;
            } else if (type == 65535) {
                i++;
            }
        }
        return false;
    }

    private void addKeyOrObject(Object obj, boolean z) {
        if (skipSpace(58) && isMapMethod()) {
            addToken(new TokenImpl(65, obj));
            this.start++;
        } else if (z) {
            addToken(new TokenImpl(-2, obj));
        } else {
            addToken(new TokenImpl(-1, obj));
        }
    }

    private void addList() {
        addToken(new TokenImpl(65534, (Object) null));
        addToken(new TokenImpl(-3, (Object) null));
        if (!skipSpace(93)) {
            addToken(new TokenImpl(64, (Object) null));
        }
    }

    private void addMap() {
        addToken(new TokenImpl(65534, (Object) null));
        addToken(new TokenImpl(-4, (Object) null));
    }

    /* access modifiers changed from: package-private */
    public int findRegExp(String str, int i) {
        int length = str.length();
        while (true) {
            boolean z = false;
            while (r8 < length) {
                int i2 = r8 + 1;
                char charAt = str.charAt(r8);
                if (charAt == '[') {
                    r8 = i2;
                    z = true;
                } else if (charAt == ']') {
                    i = i2;
                } else if (charAt == '\\') {
                    r8 = i2 + 1;
                } else if (z || charAt != '/') {
                    r8 = i2;
                } else {
                    while (true) {
                        r8 = i2;
                        if (r8 >= length) {
                            continue;
                            break;
                        }
                        i2 = r8 + 1;
                        char charAt2 = str.charAt(r8);
                        if (charAt2 != 'g' && charAt2 != 'i' && charAt2 != 'm') {
                            return i2 - 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
