package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setCertificate */
public final class setCertificate extends Exception {
    public setCertificate(int i, int i2, Object obj) {
        super(Cardinal(i, i2, obj));
    }

    public setCertificate(int i, Throwable th) {
        super(Cardinal(i, 2, th), th);
    }

    private static String Cardinal(int i, int i2, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            sb.append("Unexpected character (");
            sb.append(obj);
            sb.append(") at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 1) {
            sb.append("Unexpected token ");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 2) {
            sb.append("Unexpected exception ");
            sb.append(obj);
            sb.append(" occur at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 3) {
            sb.append("Unexpected End Of File position ");
            sb.append(i);
            sb.append(": ");
            sb.append(obj);
        } else if (i2 == 4) {
            sb.append("Unexpected unicode escape sequence ");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 5) {
            sb.append("Unexpected duplicate key:");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 6) {
            sb.append("Unexpected leading 0 in digit for token:");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
        } else {
            sb.append("Unkown error at position ");
            sb.append(i);
            sb.append(".");
        }
        return sb.toString();
    }
}
