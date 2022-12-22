package org.xidea.p087el.impl;

/* renamed from: org.xidea.el.impl.NumberArithmetic */
class NumberArithmetic {
    private static final Class<?>[] NUMBER_CLASS = {Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class};

    NumberArithmetic() {
    }

    private static final int getNumberType(Number number, Number number2) {
        int i;
        Class<?> cls = number.getClass();
        Class<?> cls2 = number2.getClass();
        int length = NUMBER_CLASS.length;
        while (true) {
            i = length - 1;
            if (length <= 0) {
                return NUMBER_CLASS.length - 1;
            }
            Class<?> cls3 = NUMBER_CLASS[i];
            if (cls3 == cls || cls3 == cls2) {
                return i;
            }
            length = i;
        }
        return i;
    }

    public boolean compare(Number number, Number number2, int i) {
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2)) {
            return i == 81 || i == 83;
        }
        long compare = (long) Double.compare(doubleValue, doubleValue2);
        switch (i) {
            case 80:
            case 82:
                return compare == 0;
            case 81:
            case 83:
                return compare != 0;
            default:
                switch (i) {
                    case 336:
                        return compare < 0;
                    case 337:
                        return compare > 0;
                    case 338:
                        return compare <= 0;
                    case 339:
                        return compare >= 0;
                    default:
                        throw new IllegalStateException("无效比较类型:" + i);
                }
        }
    }

    public Number add(Number number, Number number2) {
        int numberType = getNumberType(number, number2);
        if (numberType == 0 || numberType == 1 || numberType == 2) {
            return Integer.valueOf(number.intValue() + number2.intValue());
        }
        if (numberType == 3) {
            return Long.valueOf(number.longValue() + number2.longValue());
        }
        if (numberType != 4) {
            return Double.valueOf(number.doubleValue() + number2.doubleValue());
        }
        return Float.valueOf(number.floatValue() + number2.floatValue());
    }

    public Number subtract(Number number, Number number2) {
        int numberType = getNumberType(number, number2);
        if (numberType == 0 || numberType == 1 || numberType == 2) {
            return Integer.valueOf(number.intValue() - number2.intValue());
        }
        if (numberType == 3) {
            return Long.valueOf(number.longValue() - number2.longValue());
        }
        if (numberType != 4) {
            return Double.valueOf(number.doubleValue() - number2.doubleValue());
        }
        return Float.valueOf(number.floatValue() - number2.floatValue());
    }

    public Number multiply(Number number, Number number2) {
        int numberType = getNumberType(number, number2);
        if (numberType == 0 || numberType == 1 || numberType == 2) {
            return Integer.valueOf(number.intValue() * number2.intValue());
        }
        if (numberType == 3) {
            return Long.valueOf(number.longValue() * number2.longValue());
        }
        if (numberType != 4) {
            return Double.valueOf(number.doubleValue() * number2.doubleValue());
        }
        return Float.valueOf(number.floatValue() * number2.floatValue());
    }

    public Number divide(Number number, Number number2, boolean z) {
        int numberType = getNumberType(number, number2);
        if (numberType == 0 || numberType == 1 || numberType == 2) {
            return Double.valueOf(number.doubleValue() / number2.doubleValue());
        }
        if (numberType == 3) {
            return Double.valueOf(number.doubleValue() / number2.doubleValue());
        }
        if (numberType != 4) {
            return Double.valueOf(number.doubleValue() / number2.doubleValue());
        }
        return Float.valueOf(number.floatValue() / number2.floatValue());
    }

    public Number modulus(Number number, Number number2) {
        int numberType = getNumberType(number, number2);
        if (numberType == 0 || numberType == 1 || numberType == 2) {
            return Integer.valueOf(number.intValue() % number2.intValue());
        }
        if (numberType == 3) {
            return Long.valueOf(number.longValue() % number2.longValue());
        }
        if (numberType != 4) {
            return Double.valueOf(number.doubleValue() % number2.doubleValue());
        }
        return Float.valueOf(number.floatValue() % number2.floatValue());
    }
}
