package org.xidea.p087el.p088fn;

import java.text.DecimalFormat;
import org.xidea.p087el.Invocable;

/* renamed from: org.xidea.el.fn.JSNumber */
class JSNumber extends JSObject implements Invocable {
    public Object toExponential(Number number, Object[] objArr) {
        return null;
    }

    public Object toPrecision(Number number, Object[] objArr) {
        return null;
    }

    JSNumber() {
    }

    public Object toFixed(Number number, Object[] objArr) throws Exception {
        int intArg = JSObject.getIntArg(objArr, 0, 0);
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(intArg);
        decimalFormat.setMaximumFractionDigits(intArg);
        decimalFormat.setGroupingUsed(false);
        if (number.doubleValue() == 0.0d) {
            number = Double.valueOf(0.0d);
        }
        return decimalFormat.format(number);
    }

    public Object toString(Number number, Object[] objArr) {
        return ECMA262Impl.toString(number, JSObject.getIntArg(objArr, 0, 10));
    }
}
