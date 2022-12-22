package org.xidea.p087el;

/* renamed from: org.xidea.el.ExpressionToken */
public interface ExpressionToken {
    public static final int BIT_ARGS = 192;
    public static final int BIT_PRIORITY = 60;
    public static final int BIT_PRIORITY_SUB = 3840;
    public static final int OP_ADD = 84;
    public static final int OP_AND = 328;
    public static final int OP_BIT_AND = 588;
    public static final int OP_BIT_NOT = 29;
    public static final int OP_BIT_OR = 76;
    public static final int OP_BIT_XOR = 332;
    public static final int OP_DIV = 89;
    public static final int OP_EQ = 80;
    public static final int OP_EQ_STRICT = 82;
    public static final int OP_GET = 96;
    public static final int OP_GT = 337;
    public static final int OP_GTEQ = 339;
    public static final int OP_IN = 4432;
    public static final int OP_INVOKE = 97;
    public static final int OP_JOIN = 64;
    public static final int OP_LT = 336;
    public static final int OP_LTEQ = 338;
    public static final int OP_MOD = 90;
    public static final int OP_MUL = 88;
    public static final int OP_NE = 81;
    public static final int OP_NEG = 31;
    public static final int OP_NE_STRICT = 83;
    public static final int OP_NOT = 28;
    public static final int OP_OR = 72;
    public static final int OP_POS = 30;
    public static final int OP_PUSH = 65;
    public static final int OP_QUESTION = 68;
    public static final int OP_QUESTION_SELECT = 69;
    public static final int OP_SUB = 85;
    public static final int POS_INC = 12;
    public static final int VALUE_CONSTANTS = -1;
    public static final int VALUE_LIST = -3;
    public static final int VALUE_MAP = -4;
    public static final int VALUE_VAR = -2;

    ExpressionToken getLeft();

    Object getParam();

    ExpressionToken getRight();

    int getType();

    String toString();
}
