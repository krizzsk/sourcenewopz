package org.xidea.p087el.p088fn;

import androidx.exifinterface.media.ExifInterface;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.impl.ExpressionFactoryImpl;
import org.xidea.p087el.json.JSONDecoder;
import org.xidea.p087el.json.JSONEncoder;

/* renamed from: org.xidea.el.fn.JSGlobal */
class JSGlobal implements Invocable {
    private static final Pattern FLOAT_PARTTERN = Pattern.compile("^[\\+\\-]?[0-9]*(?:\\.[0-9]+)?");
    private static final Pattern INT_PARTTERN = Pattern.compile("^[\\+\\-]?(0x[0-9a-fA-F]+|0+[0-7]*|[1-9][0-9]*)");
    private static final Pattern URL_SPLIT = Pattern.compile("[\\/\\:&\\?=]");
    final int type;

    static void setupVar(ExpressionFactoryImpl expressionFactoryImpl) {
        ExpressionFactoryImpl expressionFactoryImpl2 = expressionFactoryImpl;
        String[] strArr = {"abs", "acos", "asin", "atan", "ceil", "asin", "cos", AuthenticationTokenClaims.JSON_KEY_EXP, "floor", "log", "round", "sin", "sqrt", "tan", "random", "min", "max", "pow", "atan2"};
        HashMap hashMap = new HashMap();
        double log = Math.log(10.0d);
        double log2 = Math.log(2.0d);
        hashMap.put(ExifInterface.LONGITUDE_EAST, Double.valueOf(2.718281828459045d));
        hashMap.put("PI", Double.valueOf(3.141592653589793d));
        hashMap.put("LN10", Double.valueOf(log));
        hashMap.put("LN2", Double.valueOf(log2));
        hashMap.put("LOG2E", Double.valueOf(1.0d / log2));
        hashMap.put("LOG10E", Double.valueOf(1.0d / log));
        hashMap.put("SQRT1_2", Double.valueOf(Math.sqrt(0.5d)));
        hashMap.put("SQRT2", Double.valueOf(Math.sqrt(2.0d)));
        for (int i = 0; i < 19; i++) {
            hashMap.put(strArr[i], new JSGlobal(i));
        }
        expressionFactoryImpl2.addVar("Math", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(IMParseUtil.TAG_PARSE_UTIL, new JSGlobal(100));
        hashMap2.put("stringify", new JSGlobal(101));
        expressionFactoryImpl2.addVar("JSON", Collections.unmodifiableMap(hashMap2));
        expressionFactoryImpl2.addVar("isFinite", new JSGlobal(200));
        expressionFactoryImpl2.addVar("isNaN", new JSGlobal(201));
        expressionFactoryImpl2.addVar("parseInt", new JSGlobal(300));
        expressionFactoryImpl2.addVar("parseFloat", new JSGlobal(301));
        expressionFactoryImpl2.addVar("encodeURI", new JSGlobal(400));
        expressionFactoryImpl2.addVar("decodeURI", new JSGlobal(401));
        expressionFactoryImpl2.addVar("encodeURIComponent", new JSGlobal(402));
        expressionFactoryImpl2.addVar("decodeURIComponent", new JSGlobal(403));
        expressionFactoryImpl2.addVar("Infinity", Double.valueOf(Double.POSITIVE_INFINITY));
        expressionFactoryImpl2.addVar("NaN", Double.valueOf(Double.NaN));
    }

    JSGlobal(int i) {
        this.type = i;
    }

    public Object invoke(Object obj, Object... objArr) throws Exception {
        int i = this.type;
        boolean z = false;
        if (i == 100) {
            return parse(JSObject.getStringArg(objArr, 0, (String) null));
        }
        if (i == 101) {
            return stringify(JSObject.getArg(objArr, 0, (Object) null));
        }
        if (i == 300 || i == 301) {
            String trim = JSObject.getStringArg(objArr, 0, "").trim();
            if (this.type == 301) {
                return parseFloat(trim);
            }
            return parseInt(trim.trim(), JSObject.getNumberArg(objArr, 1, -1).intValue());
        }
        switch (i) {
            case 400:
            case 401:
            case 402:
            case 403:
                String valueOf = String.valueOf(JSObject.getArg(objArr, 0, "null"));
                String valueOf2 = String.valueOf(JSObject.getArg(objArr, 1, "utf-8"));
                boolean z2 = (this.type & 1) == 0;
                if (this.type < 402) {
                    z = true;
                }
                return edscode(z2, z, valueOf, valueOf2);
            default:
                Number numberArg = JSObject.getNumberArg(objArr, 0, Double.valueOf(Double.NaN));
                int i2 = this.type;
                if (i2 == 200) {
                    return !Double.isNaN(numberArg.doubleValue()) && !Double.isInfinite(numberArg.doubleValue());
                }
                if (i2 == 201) {
                    return Boolean.valueOf(Double.isNaN(numberArg.doubleValue()));
                }
                switch (i2) {
                    case 0:
                        return abs(numberArg);
                    case 1:
                        return acos(numberArg);
                    case 2:
                        return asin(numberArg);
                    case 3:
                        return atan(numberArg);
                    case 4:
                        return ceil(numberArg);
                    case 5:
                        return asin(numberArg);
                    case 6:
                        return cos(numberArg);
                    case 7:
                        return exp(numberArg);
                    case 8:
                        return floor(numberArg);
                    case 9:
                        return log(numberArg);
                    case 10:
                        return round(numberArg);
                    case 11:
                        return sin(numberArg);
                    case 12:
                        return sqrt(numberArg);
                    case 13:
                        return tan(numberArg);
                    case 14:
                        return Double.valueOf(Math.random());
                    case 15:
                        return mimax(false, objArr);
                    case 16:
                        return mimax(true, objArr);
                    case 17:
                        return Double.valueOf(Math.pow(numberArg.doubleValue(), JSObject.getNumberArg(objArr, 1, Double.valueOf(Double.NaN)).doubleValue()));
                    case 18:
                        return atan2(Double.valueOf(numberArg.doubleValue()), Double.valueOf(JSObject.getNumberArg(objArr, 1, Double.valueOf(Double.NaN)).doubleValue()));
                    default:
                        return 0;
                }
        }
    }

    private final Object mimax(boolean z, Object... objArr) throws Exception {
        Number number = null;
        for (int i = 0; i < objArr.length; i++) {
            Number ToNumber = ECMA262Impl.ToNumber(JSObject.getArg(objArr, i, Double.valueOf(Double.NaN)));
            double floatValue = (double) ToNumber.floatValue();
            if (floatValue == Double.NaN) {
                return ToNumber;
            }
            if (z) {
                if (Double.POSITIVE_INFINITY == floatValue) {
                    return ToNumber;
                }
            } else if (Double.NEGATIVE_INFINITY == floatValue) {
                return ToNumber;
            }
            if (i != 0) {
                if (floatValue > number.doubleValue()) {
                    if (!z) {
                    }
                } else if (z) {
                }
            }
            number = ToNumber;
        }
        return number;
    }

    private final Object abs(Number number) {
        double doubleValue = number.doubleValue();
        return doubleValue < 0.0d ? Double.valueOf(-doubleValue) : number;
    }

    private final Object acos(Number number) {
        return Double.valueOf(Math.acos(number.doubleValue()));
    }

    private final Object asin(Number number) {
        return Double.valueOf(Math.asin(number.doubleValue()));
    }

    private final Object atan(Number number) {
        return Double.valueOf(Math.atan(number.doubleValue()));
    }

    private final Object atan2(Number number, Number number2) {
        return Double.valueOf(Math.atan2(number.doubleValue(), number2.doubleValue()));
    }

    private final Object ceil(Number number) {
        return Double.valueOf(Math.ceil(number.doubleValue()));
    }

    private final Object cos(Number number) {
        return Double.valueOf(Math.cos(number.doubleValue()));
    }

    private final Object exp(Number number) {
        return Double.valueOf(Math.exp(number.doubleValue()));
    }

    private final Object floor(Number number) {
        return Double.valueOf(Math.floor(number.doubleValue()));
    }

    private final Object log(Number number) {
        return Double.valueOf(Math.log(number.doubleValue()));
    }

    private final Object round(Number number) {
        return Long.valueOf(Math.round(number.doubleValue()));
    }

    private final Object sin(Number number) {
        return Double.valueOf(Math.sin(number.doubleValue()));
    }

    private final Object sqrt(Number number) {
        return Double.valueOf(Math.sqrt(number.doubleValue()));
    }

    private final Object tan(Number number) {
        return Double.valueOf(Math.tan(number.doubleValue()));
    }

    private final Object parse(Object obj) {
        return JSONDecoder.decode(ECMA262Impl.ToPrimitive(obj, String.class).toString());
    }

    private final String stringify(Object obj) {
        return JSONEncoder.encode(obj);
    }

    /* access modifiers changed from: protected */
    public Number parseFloat(String str) {
        if (str.length() > 0) {
            Matcher matcher = FLOAT_PARTTERN.matcher(str);
            if (matcher.find()) {
                return Double.valueOf(Double.parseDouble(matcher.group(0)));
            }
        }
        return Double.valueOf(Double.NaN);
    }

    /* access modifiers changed from: protected */
    public Number parseInt(String str, int i) {
        Matcher matcher = INT_PARTTERN.matcher(str);
        if (!matcher.find()) {
            return Integer.valueOf(parseFloat(str).intValue());
        }
        String group = matcher.group(0);
        if (i > 0) {
            return Long.valueOf(Long.parseLong(group, i));
        }
        String group2 = matcher.group(1);
        if (group2.charAt(0) != '0') {
            return Long.valueOf(Long.parseLong(group, 10));
        }
        if (group2.startsWith("0x") || group2.startsWith("0X")) {
            return Long.valueOf(Long.parseLong(group.substring(2), 16));
        }
        return Long.valueOf(Long.parseLong(group, 8));
    }

    /* access modifiers changed from: protected */
    public Object edscode(boolean z, boolean z2, String str, String str2) throws UnsupportedEncodingException {
        if (!z2) {
            return processPart(z, str, str2);
        }
        Matcher matcher = URL_SPLIT.matcher(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            if (start >= i) {
                sb.append(processPart(z, str.substring(i, start), str2));
            }
            i = matcher.end();
            sb.append(str.substring(start, i));
        }
        sb.append(processPart(z, str.substring(i), str2));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Object processPart(boolean z, String str, String str2) throws UnsupportedEncodingException {
        return z ? URLEncoder.encode(str, str2) : URLDecoder.decode(str, str2);
    }
}
