package org.mozilla.javascript;

import com.airbnb.lottie.utils.Utils;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.google.common.net.HttpHeaders;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

final class NativeDate extends IdScriptableObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ConstructorId_UTC = -1;
    private static final int ConstructorId_now = -3;
    private static final int ConstructorId_parse = -2;
    private static final Object DATE_TAG = HttpHeaders.DATE;
    private static final double HalfTimeDomain = 8.64E15d;
    private static final double HoursPerDay = 24.0d;
    private static final int Id_constructor = 1;
    private static final int Id_getDate = 17;
    private static final int Id_getDay = 19;
    private static final int Id_getFullYear = 13;
    private static final int Id_getHours = 21;
    private static final int Id_getMilliseconds = 27;
    private static final int Id_getMinutes = 23;
    private static final int Id_getMonth = 15;
    private static final int Id_getSeconds = 25;
    private static final int Id_getTime = 11;
    private static final int Id_getTimezoneOffset = 29;
    private static final int Id_getUTCDate = 18;
    private static final int Id_getUTCDay = 20;
    private static final int Id_getUTCFullYear = 14;
    private static final int Id_getUTCHours = 22;
    private static final int Id_getUTCMilliseconds = 28;
    private static final int Id_getUTCMinutes = 24;
    private static final int Id_getUTCMonth = 16;
    private static final int Id_getUTCSeconds = 26;
    private static final int Id_getYear = 12;
    private static final int Id_setDate = 39;
    private static final int Id_setFullYear = 43;
    private static final int Id_setHours = 37;
    private static final int Id_setMilliseconds = 31;
    private static final int Id_setMinutes = 35;
    private static final int Id_setMonth = 41;
    private static final int Id_setSeconds = 33;
    private static final int Id_setTime = 30;
    private static final int Id_setUTCDate = 40;
    private static final int Id_setUTCFullYear = 44;
    private static final int Id_setUTCHours = 38;
    private static final int Id_setUTCMilliseconds = 32;
    private static final int Id_setUTCMinutes = 36;
    private static final int Id_setUTCMonth = 42;
    private static final int Id_setUTCSeconds = 34;
    private static final int Id_setYear = 45;
    private static final int Id_toDateString = 4;
    private static final int Id_toGMTString = 8;
    private static final int Id_toISOString = 46;
    private static final int Id_toJSON = 47;
    private static final int Id_toLocaleDateString = 7;
    private static final int Id_toLocaleString = 5;
    private static final int Id_toLocaleTimeString = 6;
    private static final int Id_toSource = 9;
    private static final int Id_toString = 2;
    private static final int Id_toTimeString = 3;
    private static final int Id_toUTCString = 8;
    private static final int Id_valueOf = 10;
    private static double LocalTZA = 0.0d;
    private static final int MAXARGS = 7;
    private static final int MAX_PROTOTYPE_ID = 47;
    private static final double MinutesPerDay = 1440.0d;
    private static final double MinutesPerHour = 60.0d;
    private static final double SecondsPerDay = 86400.0d;
    private static final double SecondsPerHour = 3600.0d;
    private static final double SecondsPerMinute = 60.0d;
    private static final String js_NaN_date_str = "Invalid Date";
    private static DateFormat localeDateFormatter = null;
    private static DateFormat localeDateTimeFormatter = null;
    private static DateFormat localeTimeFormatter = null;
    private static final double msPerDay = 8.64E7d;
    private static final double msPerHour = 3600000.0d;
    private static final double msPerMinute = 60000.0d;
    private static final double msPerSecond = 1000.0d;
    static final long serialVersionUID = -8307438915861678966L;
    private static TimeZone thisTimeZone;
    private static DateFormat timeZoneFormatter;
    private double date;

    private static double MakeDate(double d, double d2) {
        return (d * msPerDay) + d2;
    }

    private static double MakeTime(double d, double d2, double d3, double d4) {
        return (((((d * 60.0d) + d2) * 60.0d) + d3) * msPerSecond) + d4;
    }

    private static double TimeWithinDay(double d) {
        double d2 = d % msPerDay;
        return d2 < 0.0d ? d2 + msPerDay : d2;
    }

    private static int msFromTime(double d) {
        double d2 = d % msPerSecond;
        if (d2 < 0.0d) {
            d2 += msPerSecond;
        }
        return (int) d2;
    }

    public String getClassName() {
        return HttpHeaders.DATE;
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeDate nativeDate = new NativeDate();
        nativeDate.date = ScriptRuntime.NaN;
        nativeDate.exportAsJSClass(47, scriptable, z);
    }

    private NativeDate() {
        if (thisTimeZone == null) {
            TimeZone timeZone = TimeZone.getDefault();
            thisTimeZone = timeZone;
            LocalTZA = (double) timeZone.getRawOffset();
        }
    }

    public Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.StringClass;
        }
        return super.getDefaultValue(cls);
    }

    /* access modifiers changed from: package-private */
    public double getJSTimeValue() {
        return this.date;
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        IdFunctionObject idFunctionObject2 = idFunctionObject;
        addIdFunctionProperty(idFunctionObject2, DATE_TAG, -3, "now", 0);
        addIdFunctionProperty(idFunctionObject, DATE_TAG, -2, IMParseUtil.TAG_PARSE_UTIL, 1);
        addIdFunctionProperty(idFunctionObject2, DATE_TAG, -1, "UTC", 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r0 = r1;
        r4 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00af, code lost:
        initPrototypeMethod(DATE_TAG, r6, r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initPrototypeId(int r6) {
        /*
            r5 = this;
            r0 = 4
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            switch(r6) {
                case 1: goto L_0x00aa;
                case 2: goto L_0x00a7;
                case 3: goto L_0x00a4;
                case 4: goto L_0x00a1;
                case 5: goto L_0x009e;
                case 6: goto L_0x009b;
                case 7: goto L_0x0098;
                case 8: goto L_0x0095;
                case 9: goto L_0x0092;
                case 10: goto L_0x008f;
                case 11: goto L_0x008c;
                case 12: goto L_0x0089;
                case 13: goto L_0x0086;
                case 14: goto L_0x0083;
                case 15: goto L_0x0080;
                case 16: goto L_0x007d;
                case 17: goto L_0x007a;
                case 18: goto L_0x0077;
                case 19: goto L_0x0074;
                case 20: goto L_0x0071;
                case 21: goto L_0x006e;
                case 22: goto L_0x006b;
                case 23: goto L_0x0068;
                case 24: goto L_0x0065;
                case 25: goto L_0x0062;
                case 26: goto L_0x005e;
                case 27: goto L_0x005a;
                case 28: goto L_0x0056;
                case 29: goto L_0x0052;
                case 30: goto L_0x004d;
                case 31: goto L_0x004a;
                case 32: goto L_0x0047;
                case 33: goto L_0x0042;
                case 34: goto L_0x003f;
                case 35: goto L_0x003a;
                case 36: goto L_0x0037;
                case 37: goto L_0x0031;
                case 38: goto L_0x002e;
                case 39: goto L_0x002b;
                case 40: goto L_0x0028;
                case 41: goto L_0x0025;
                case 42: goto L_0x0022;
                case 43: goto L_0x001f;
                case 44: goto L_0x001c;
                case 45: goto L_0x0019;
                case 46: goto L_0x0015;
                case 47: goto L_0x0012;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.<init>(r6)
            throw r0
        L_0x0012:
            java.lang.String r0 = "toJSON"
            goto L_0x004f
        L_0x0015:
            java.lang.String r0 = "toISOString"
            goto L_0x00af
        L_0x0019:
            java.lang.String r0 = "setYear"
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "setUTCFullYear"
            goto L_0x003c
        L_0x001f:
            java.lang.String r0 = "setFullYear"
            goto L_0x003c
        L_0x0022:
            java.lang.String r0 = "setUTCMonth"
            goto L_0x0044
        L_0x0025:
            java.lang.String r0 = "setMonth"
            goto L_0x0044
        L_0x0028:
            java.lang.String r0 = "setUTCDate"
            goto L_0x004f
        L_0x002b:
            java.lang.String r0 = "setDate"
            goto L_0x004f
        L_0x002e:
            java.lang.String r1 = "setUTCHours"
            goto L_0x0033
        L_0x0031:
            java.lang.String r1 = "setHours"
        L_0x0033:
            r0 = r1
            r4 = 4
            goto L_0x00af
        L_0x0037:
            java.lang.String r0 = "setUTCMinutes"
            goto L_0x003c
        L_0x003a:
            java.lang.String r0 = "setMinutes"
        L_0x003c:
            r4 = 3
            goto L_0x00af
        L_0x003f:
            java.lang.String r0 = "setUTCSeconds"
            goto L_0x0044
        L_0x0042:
            java.lang.String r0 = "setSeconds"
        L_0x0044:
            r4 = 2
            goto L_0x00af
        L_0x0047:
            java.lang.String r0 = "setUTCMilliseconds"
            goto L_0x004f
        L_0x004a:
            java.lang.String r0 = "setMilliseconds"
            goto L_0x004f
        L_0x004d:
            java.lang.String r0 = "setTime"
        L_0x004f:
            r4 = 1
            goto L_0x00af
        L_0x0052:
            java.lang.String r0 = "getTimezoneOffset"
            goto L_0x00af
        L_0x0056:
            java.lang.String r0 = "getUTCMilliseconds"
            goto L_0x00af
        L_0x005a:
            java.lang.String r0 = "getMilliseconds"
            goto L_0x00af
        L_0x005e:
            java.lang.String r0 = "getUTCSeconds"
            goto L_0x00af
        L_0x0062:
            java.lang.String r0 = "getSeconds"
            goto L_0x00af
        L_0x0065:
            java.lang.String r0 = "getUTCMinutes"
            goto L_0x00af
        L_0x0068:
            java.lang.String r0 = "getMinutes"
            goto L_0x00af
        L_0x006b:
            java.lang.String r0 = "getUTCHours"
            goto L_0x00af
        L_0x006e:
            java.lang.String r0 = "getHours"
            goto L_0x00af
        L_0x0071:
            java.lang.String r0 = "getUTCDay"
            goto L_0x00af
        L_0x0074:
            java.lang.String r0 = "getDay"
            goto L_0x00af
        L_0x0077:
            java.lang.String r0 = "getUTCDate"
            goto L_0x00af
        L_0x007a:
            java.lang.String r0 = "getDate"
            goto L_0x00af
        L_0x007d:
            java.lang.String r0 = "getUTCMonth"
            goto L_0x00af
        L_0x0080:
            java.lang.String r0 = "getMonth"
            goto L_0x00af
        L_0x0083:
            java.lang.String r0 = "getUTCFullYear"
            goto L_0x00af
        L_0x0086:
            java.lang.String r0 = "getFullYear"
            goto L_0x00af
        L_0x0089:
            java.lang.String r0 = "getYear"
            goto L_0x00af
        L_0x008c:
            java.lang.String r0 = "getTime"
            goto L_0x00af
        L_0x008f:
            java.lang.String r0 = "valueOf"
            goto L_0x00af
        L_0x0092:
            java.lang.String r0 = "toSource"
            goto L_0x00af
        L_0x0095:
            java.lang.String r0 = "toUTCString"
            goto L_0x00af
        L_0x0098:
            java.lang.String r0 = "toLocaleDateString"
            goto L_0x00af
        L_0x009b:
            java.lang.String r0 = "toLocaleTimeString"
            goto L_0x00af
        L_0x009e:
            java.lang.String r0 = "toLocaleString"
            goto L_0x00af
        L_0x00a1:
            java.lang.String r0 = "toDateString"
            goto L_0x00af
        L_0x00a4:
            java.lang.String r0 = "toTimeString"
            goto L_0x00af
        L_0x00a7:
            java.lang.String r0 = "toString"
            goto L_0x00af
        L_0x00aa:
            r0 = 7
            java.lang.String r1 = "constructor"
            r0 = r1
            r4 = 7
        L_0x00af:
            java.lang.Object r1 = DATE_TAG
            r5.initPrototypeMethod(r1, r6, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.initPrototypeId(int):void");
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        double d2;
        if (!idFunctionObject.hasTag(DATE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == -3) {
            return ScriptRuntime.wrapNumber(now());
        }
        if (methodId == -2) {
            return ScriptRuntime.wrapNumber(date_parseString(ScriptRuntime.toString(objArr, 0)));
        }
        if (methodId == -1) {
            return ScriptRuntime.wrapNumber(jsStaticFunction_UTC(objArr));
        }
        if (methodId != 1) {
            if (methodId == 47) {
                Scriptable object = ScriptRuntime.toObject(context, scriptable, (Object) scriptable2);
                Object primitive = ScriptRuntime.toPrimitive(object, ScriptRuntime.NumberClass);
                if (primitive instanceof Number) {
                    double doubleValue = ((Number) primitive).doubleValue();
                    if (doubleValue != doubleValue || Double.isInfinite(doubleValue)) {
                        return null;
                    }
                }
                Object property = ScriptableObject.getProperty(object, "toISOString");
                if (property == NOT_FOUND) {
                    throw ScriptRuntime.typeError2("msg.function.not.found.in", "toISOString", ScriptRuntime.toString((Object) object));
                } else if (property instanceof Callable) {
                    Object call = ((Callable) property).call(context, scriptable, object, ScriptRuntime.emptyArgs);
                    if (ScriptRuntime.isPrimitive(call)) {
                        return call;
                    }
                    throw ScriptRuntime.typeError1("msg.toisostring.must.return.primitive", ScriptRuntime.toString(call));
                } else {
                    throw ScriptRuntime.typeError3("msg.isnt.function.in", "toISOString", ScriptRuntime.toString((Object) object), ScriptRuntime.toString(property));
                }
            } else if (scriptable2 instanceof NativeDate) {
                NativeDate nativeDate = (NativeDate) scriptable2;
                double d3 = nativeDate.date;
                switch (methodId) {
                    case 2:
                    case 3:
                    case 4:
                        if (d3 == d3) {
                            return date_format(d3, methodId);
                        }
                        return js_NaN_date_str;
                    case 5:
                    case 6:
                    case 7:
                        if (d3 == d3) {
                            return toLocale_helper(d3, methodId);
                        }
                        return js_NaN_date_str;
                    case 8:
                        if (d3 == d3) {
                            return js_toUTCString(d3);
                        }
                        return js_NaN_date_str;
                    case 9:
                        return "(new Date(" + ScriptRuntime.toString(d3) + "))";
                    case 10:
                    case 11:
                        return ScriptRuntime.wrapNumber(d3);
                    case 12:
                    case 13:
                    case 14:
                        if (d3 == d3) {
                            if (methodId != 14) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) YearFromTime(d3);
                            if (methodId == 12 && (!context.hasFeature(1) || (1900.0d <= d3 && d3 < 2000.0d))) {
                                d3 -= 1900.0d;
                            }
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 15:
                    case 16:
                        if (d3 == d3) {
                            if (methodId == 15) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) MonthFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 17:
                    case 18:
                        if (d3 == d3) {
                            if (methodId == 17) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) DateFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 19:
                    case 20:
                        if (d3 == d3) {
                            if (methodId == 19) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) WeekDay(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 21:
                    case 22:
                        if (d3 == d3) {
                            if (methodId == 21) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) HourFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 23:
                    case 24:
                        if (d3 == d3) {
                            if (methodId == 23) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) MinFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 25:
                    case 26:
                        if (d3 == d3) {
                            if (methodId == 25) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) SecFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 27:
                    case 28:
                        if (d3 == d3) {
                            if (methodId == 27) {
                                d3 = LocalTime(d3);
                            }
                            d3 = (double) msFromTime(d3);
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 29:
                        if (d3 == d3) {
                            d3 = (d3 - LocalTime(d3)) / msPerMinute;
                        }
                        return ScriptRuntime.wrapNumber(d3);
                    case 30:
                        double TimeClip = TimeClip(ScriptRuntime.toNumber(objArr, 0));
                        nativeDate.date = TimeClip;
                        return ScriptRuntime.wrapNumber(TimeClip);
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                        double makeTime = makeTime(d3, objArr, methodId);
                        nativeDate.date = makeTime;
                        return ScriptRuntime.wrapNumber(makeTime);
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                        double makeDate = makeDate(d3, objArr, methodId);
                        nativeDate.date = makeDate;
                        return ScriptRuntime.wrapNumber(makeDate);
                    case 45:
                        double number = ScriptRuntime.toNumber(objArr, 0);
                        if (number != number || Double.isInfinite(number)) {
                            d = ScriptRuntime.NaN;
                        } else {
                            if (d3 != d3) {
                                d2 = 0.0d;
                            } else {
                                d2 = LocalTime(d3);
                            }
                            if (number >= 0.0d && number <= 99.0d) {
                                number += 1900.0d;
                            }
                            d = TimeClip(internalUTC(MakeDate(MakeDay(number, (double) MonthFromTime(d2), (double) DateFromTime(d2)), TimeWithinDay(d2))));
                        }
                        nativeDate.date = d;
                        return ScriptRuntime.wrapNumber(d);
                    case 46:
                        if (d3 == d3) {
                            return js_toISOString(d3);
                        }
                        throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.invalid.date"));
                    default:
                        throw new IllegalArgumentException(String.valueOf(methodId));
                }
            } else {
                throw incompatibleCallError(idFunctionObject);
            }
        } else if (scriptable2 != null) {
            return date_format(now(), 2);
        } else {
            return jsConstructor(objArr);
        }
    }

    private static double Day(double d) {
        return Math.floor(d / msPerDay);
    }

    private static boolean IsLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static double DayFromYear(double d) {
        return ((((d - 1970.0d) * 365.0d) + Math.floor((d - 1969.0d) / 4.0d)) - Math.floor((d - 1901.0d) / 100.0d)) + Math.floor((d - 1601.0d) / 400.0d);
    }

    private static double TimeFromYear(double d) {
        return DayFromYear(d) * msPerDay;
    }

    private static int YearFromTime(double d) {
        double d2 = d / msPerDay;
        int floor = ((int) Math.floor(d2 / 366.0d)) + 1970;
        int floor2 = ((int) Math.floor(d2 / 365.0d)) + 1970;
        if (floor2 >= floor) {
            int i = floor;
            floor = floor2;
            floor2 = i;
        }
        while (floor > floor2) {
            int i2 = (floor + floor2) / 2;
            if (TimeFromYear((double) i2) > d) {
                floor = i2 - 1;
            } else {
                floor2 = i2 + 1;
                if (TimeFromYear((double) floor2) > d) {
                    return i2;
                }
            }
        }
        return floor2;
    }

    private static double DayFromMonth(int i, int i2) {
        int i3;
        int i4;
        int i5 = i * 30;
        if (i >= 7) {
            i4 = i / 2;
        } else if (i >= 2) {
            i4 = (i - 1) / 2;
        } else {
            i3 = i5 + i;
            if (i >= 2 && IsLeapYear(i2)) {
                i3++;
            }
            return (double) i3;
        }
        i3 = i5 + (i4 - 1);
        i3++;
        return (double) i3;
    }

    private static int DaysInMonth(int i, int i2) {
        return i2 == 2 ? IsLeapYear(i) ? 29 : 28 : i2 >= 8 ? 31 - (i2 & 1) : (i2 & 1) + 30;
    }

    private static int MonthFromTime(double d) {
        int i;
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear((double) YearFromTime))) - 59;
        if (Day < 0) {
            return Day < -28 ? 0 : 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 1;
            }
            Day--;
        }
        int i2 = Day / 30;
        switch (i2) {
            case 0:
                return 2;
            case 1:
                i = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                break;
            case 6:
                i = 184;
                break;
            case 7:
                i = 214;
                break;
            case 8:
                i = 245;
                break;
            case 9:
                i = 275;
                break;
            case 10:
                return 11;
            default:
                throw Kit.codeBug();
        }
        return Day >= i ? i2 + 2 : i2 + 1;
    }

    private static int DateFromTime(double d) {
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear((double) YearFromTime))) - 59;
        int i = 31;
        if (Day < 0) {
            if (Day < -28) {
                Day += 31;
            }
            return Day + 28 + 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 29;
            }
            Day--;
        }
        int i2 = 30;
        switch (Day / 30) {
            case 0:
                return Day + 1;
            case 1:
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                break;
            case 6:
                i = 184;
                break;
            case 7:
                i = 214;
                break;
            case 8:
                i = 245;
                break;
            case 9:
                i = 275;
                break;
            case 10:
                return (Day - 275) + 1;
            default:
                throw Kit.codeBug();
        }
        i2 = 31;
        int i3 = Day - i;
        if (i3 < 0) {
            i3 += i2;
        }
        return i3 + 1;
    }

    private static int WeekDay(double d) {
        double Day = (Day(d) + 4.0d) % 7.0d;
        if (Day < 0.0d) {
            Day += 7.0d;
        }
        return (int) Day;
    }

    private static double now() {
        return (double) System.currentTimeMillis();
    }

    private static double DaylightSavingTA(double d) {
        if (d < 0.0d) {
            d = MakeDate(MakeDay((double) EquivalentYear(YearFromTime(d)), (double) MonthFromTime(d), (double) DateFromTime(d)), TimeWithinDay(d));
        }
        if (thisTimeZone.inDaylightTime(new Date((long) d))) {
            return msPerHour;
        }
        return 0.0d;
    }

    private static int EquivalentYear(int i) {
        int DayFromYear = (((int) DayFromYear((double) i)) + 4) % 7;
        if (DayFromYear < 0) {
            DayFromYear += 7;
        }
        if (IsLeapYear(i)) {
            switch (DayFromYear) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        } else {
            switch (DayFromYear) {
                case 0:
                    return 1978;
                case 1:
                    return 1973;
                case 2:
                    return 1985;
                case 3:
                    return 1986;
                case 4:
                    return 1981;
                case 5:
                    return 1971;
                case 6:
                    return 1977;
            }
        }
        throw Kit.codeBug();
    }

    private static double LocalTime(double d) {
        return LocalTZA + d + DaylightSavingTA(d);
    }

    private static double internalUTC(double d) {
        double d2 = LocalTZA;
        return (d - d2) - DaylightSavingTA(d - d2);
    }

    private static int HourFromTime(double d) {
        double floor = Math.floor(d / msPerHour) % HoursPerDay;
        if (floor < 0.0d) {
            floor += HoursPerDay;
        }
        return (int) floor;
    }

    private static int MinFromTime(double d) {
        double floor = Math.floor(d / msPerMinute) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static int SecFromTime(double d) {
        double floor = Math.floor(d / msPerSecond) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static double MakeDay(double d, double d2, double d3) {
        double floor = d + Math.floor(d2 / 12.0d);
        double d4 = d2 % 12.0d;
        if (d4 < 0.0d) {
            d4 += 12.0d;
        }
        return ((Math.floor(TimeFromYear(floor) / msPerDay) + DayFromMonth((int) d4, (int) floor)) + d3) - 1.0d;
    }

    private static double TimeClip(double d) {
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Math.abs(d) > HalfTimeDomain) {
            return ScriptRuntime.NaN;
        }
        if (d > 0.0d) {
            return Math.floor(d + 0.0d);
        }
        return Math.ceil(d + 0.0d);
    }

    private static double date_msecFromDate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return MakeDate(MakeDay(d, d2, d3), MakeTime(d4, d5, d6, d7));
    }

    private static double date_msecFromArgs(Object[] objArr) {
        Object[] objArr2 = objArr;
        double[] dArr = new double[7];
        for (int i = 0; i < 7; i++) {
            if (i < objArr2.length) {
                double number = ScriptRuntime.toNumber(objArr2[i]);
                if (number != number || Double.isInfinite(number)) {
                    return ScriptRuntime.NaN;
                }
                dArr[i] = ScriptRuntime.toInteger(objArr2[i]);
            } else if (i == 2) {
                dArr[i] = 1.0d;
            } else {
                dArr[i] = 0.0d;
            }
        }
        if (dArr[0] >= 0.0d && dArr[0] <= 99.0d) {
            dArr[0] = dArr[0] + 1900.0d;
        }
        return date_msecFromDate(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    private static double jsStaticFunction_UTC(Object[] objArr) {
        return TimeClip(date_msecFromArgs(objArr));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        r0 = -1;
        r13 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bc, code lost:
        if (r8 != '-') goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00cb, code lost:
        if (r8 != '-') goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ce, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d0, code lost:
        r10 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d1, code lost:
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e0, code lost:
        r13 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e9, code lost:
        r10 = '-';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x010a, code lost:
        if (r13 != 7) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x010c, code lost:
        if (r8 != r10) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x010e, code lost:
        r16 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0111, code lost:
        r16 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double parseISOString(java.lang.String r34) {
        /*
            r0 = r34
            r1 = 9
            int[] r1 = new int[r1]
            r1 = {1970, 1, 1, 0, 0, 0, 0, -1, -1} // fill-array
            int r2 = r34.length()
            r3 = 84
            r4 = 43
            r5 = 4
            r6 = 6
            r7 = 3
            r8 = 45
            r9 = 0
            r11 = -1
            if (r2 == 0) goto L_0x0032
            char r12 = r0.charAt(r9)
            if (r12 == r4) goto L_0x0029
            if (r12 != r8) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            if (r12 != r3) goto L_0x0032
            r12 = 1
            r13 = 3
            r14 = 1
            goto L_0x0035
        L_0x0029:
            if (r12 != r8) goto L_0x002d
            r12 = -1
            goto L_0x002e
        L_0x002d:
            r12 = 1
        L_0x002e:
            r13 = 0
            r14 = 1
            r15 = 6
            goto L_0x0036
        L_0x0032:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0035:
            r15 = 4
        L_0x0036:
            r16 = 1
        L_0x0038:
            r17 = 2
            r18 = 8
            r10 = 5
            r3 = 7
            if (r13 == r11) goto L_0x011d
            if (r13 != 0) goto L_0x0045
            r19 = r15
            goto L_0x004c
        L_0x0045:
            if (r13 != r6) goto L_0x004a
            r19 = 3
            goto L_0x004c
        L_0x004a:
            r19 = 2
        L_0x004c:
            int r11 = r14 + r19
            if (r11 <= r2) goto L_0x0054
        L_0x0050:
            r0 = -1
            r13 = -1
            goto L_0x011e
        L_0x0054:
            r19 = 0
        L_0x0056:
            if (r14 >= r11) goto L_0x0072
            char r8 = r0.charAt(r14)
            r4 = 48
            if (r8 < r4) goto L_0x0050
            r4 = 57
            if (r8 <= r4) goto L_0x0065
            goto L_0x0050
        L_0x0065:
            int r19 = r19 * 10
            int r8 = r8 + -48
            int r19 = r19 + r8
            int r14 = r14 + 1
            r4 = 43
            r8 = 45
            goto L_0x0056
        L_0x0072:
            r1[r13] = r19
            if (r14 != r2) goto L_0x007f
            if (r13 == r7) goto L_0x007c
            if (r13 == r3) goto L_0x007c
            goto L_0x011d
        L_0x007c:
            r13 = -1
            goto L_0x011d
        L_0x007f:
            int r4 = r14 + 1
            char r8 = r0.charAt(r14)
            r11 = 90
            if (r8 != r11) goto L_0x0098
            r1[r3] = r9
            r1[r18] = r9
            if (r13 == r5) goto L_0x0095
            if (r13 == r10) goto L_0x0095
            if (r13 == r6) goto L_0x0095
            r14 = r4
            goto L_0x0050
        L_0x0095:
            r14 = r4
            goto L_0x011d
        L_0x0098:
            r11 = 58
            switch(r13) {
                case 0: goto L_0x00fa;
                case 1: goto L_0x00fa;
                case 2: goto L_0x00ee;
                case 3: goto L_0x00e4;
                case 4: goto L_0x00d3;
                case 5: goto L_0x00bf;
                case 6: goto L_0x00b6;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00a5;
                default: goto L_0x009d;
            }
        L_0x009d:
            r10 = 45
            r11 = 84
        L_0x00a1:
            r14 = 43
            goto L_0x010a
        L_0x00a5:
            r10 = 45
            r11 = 84
            r13 = -1
            goto L_0x00a1
        L_0x00ab:
            if (r8 == r11) goto L_0x00af
            int r4 = r4 + -1
        L_0x00af:
            r10 = 45
            r11 = 84
            r13 = 8
            goto L_0x00a1
        L_0x00b6:
            r14 = 43
            r13 = 45
            if (r8 == r14) goto L_0x00d0
            if (r8 != r13) goto L_0x00ce
            goto L_0x00d0
        L_0x00bf:
            r13 = 45
            r14 = 43
            r10 = 46
            if (r8 != r10) goto L_0x00c9
            r10 = 6
            goto L_0x00d1
        L_0x00c9:
            if (r8 == r14) goto L_0x00d0
            if (r8 != r13) goto L_0x00ce
            goto L_0x00d0
        L_0x00ce:
            r10 = -1
            goto L_0x00d1
        L_0x00d0:
            r10 = 7
        L_0x00d1:
            r13 = r10
            goto L_0x00e9
        L_0x00d3:
            r13 = 45
            r14 = 43
            if (r8 != r11) goto L_0x00db
            r13 = 5
            goto L_0x00e9
        L_0x00db:
            if (r8 == r14) goto L_0x00e2
            if (r8 != r13) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r13 = -1
            goto L_0x00e9
        L_0x00e2:
            r13 = 7
            goto L_0x00e9
        L_0x00e4:
            r14 = 43
            if (r8 != r11) goto L_0x00e0
            r13 = 4
        L_0x00e9:
            r10 = 45
            r11 = 84
            goto L_0x010a
        L_0x00ee:
            r11 = 84
            r14 = 43
            if (r8 != r11) goto L_0x00f6
            r13 = 3
            goto L_0x00f7
        L_0x00f6:
            r13 = -1
        L_0x00f7:
            r10 = 45
            goto L_0x010a
        L_0x00fa:
            r10 = 45
            r11 = 84
            r14 = 43
            if (r8 != r10) goto L_0x0105
            int r13 = r13 + 1
            goto L_0x010a
        L_0x0105:
            if (r8 != r11) goto L_0x0109
            r13 = 3
            goto L_0x010a
        L_0x0109:
            r13 = -1
        L_0x010a:
            if (r13 != r3) goto L_0x0113
            if (r8 != r10) goto L_0x0111
            r16 = -1
            goto L_0x0113
        L_0x0111:
            r16 = 1
        L_0x0113:
            r14 = r4
            r3 = 84
            r4 = 43
            r8 = 45
            r11 = -1
            goto L_0x0038
        L_0x011d:
            r0 = -1
        L_0x011e:
            if (r13 == r0) goto L_0x01ad
            if (r14 == r2) goto L_0x0124
            goto L_0x01ad
        L_0x0124:
            r0 = r1[r9]
            r2 = 1
            r4 = r1[r2]
            r8 = r1[r17]
            r7 = r1[r7]
            r5 = r1[r5]
            r9 = r1[r10]
            r6 = r1[r6]
            r3 = r1[r3]
            r1 = r1[r18]
            r10 = 275943(0x435e7, float:3.86679E-40)
            if (r0 > r10) goto L_0x01ad
            if (r4 < r2) goto L_0x01ad
            r10 = 12
            if (r4 > r10) goto L_0x01ad
            if (r8 < r2) goto L_0x01ad
            int r2 = DaysInMonth(r0, r4)
            if (r8 > r2) goto L_0x01ad
            r2 = 24
            if (r7 > r2) goto L_0x01ad
            if (r7 != r2) goto L_0x0156
            if (r5 > 0) goto L_0x01ad
            if (r9 > 0) goto L_0x01ad
            if (r6 > 0) goto L_0x01ad
        L_0x0156:
            r2 = 59
            if (r5 > r2) goto L_0x01ad
            if (r9 > r2) goto L_0x01ad
            r10 = 23
            if (r3 > r10) goto L_0x01ad
            if (r1 <= r2) goto L_0x0163
            goto L_0x01ad
        L_0x0163:
            int r0 = r0 * r12
            double r10 = (double) r0
            r0 = 1
            int r4 = r4 - r0
            double r12 = (double) r4
            double r14 = (double) r8
            double r7 = (double) r7
            double r4 = (double) r5
            r34 = r1
            double r0 = (double) r9
            r9 = r3
            double r2 = (double) r6
            r20 = r10
            r22 = r12
            r24 = r14
            r26 = r7
            r28 = r4
            r30 = r0
            r32 = r2
            double r0 = date_msecFromDate(r20, r22, r24, r26, r28, r30, r32)
            r2 = -1
            if (r9 != r2) goto L_0x0187
            goto L_0x0199
        L_0x0187:
            int r3 = r9 * 60
            int r3 = r3 + r34
            double r2 = (double) r3
            r4 = 4678479150791524352(0x40ed4c0000000000, double:60000.0)
            double r2 = r2 * r4
            r10 = r16
            double r4 = (double) r10
            double r2 = r2 * r4
            double r0 = r0 - r2
        L_0x0199:
            r2 = -4377866037058863104(0xc33eb208c2dc0000, double:-8.64E15)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x01ad
            r2 = 4845505999795912704(0x433eb208c2dc0000, double:8.64E15)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            return r0
        L_0x01ad:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.parseISOString(java.lang.String):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:160:0x01c4, code lost:
        r16 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x01f6, code lost:
        if (r4 <= '9') goto L_0x01f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x014f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double date_parseString(java.lang.String r33) {
        /*
            r6 = r33
            double r0 = parseISOString(r33)
            int r2 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000b
            return r0
        L_0x000b:
            int r7 = r33.length()
            r0 = -1
            r0 = 0
            r4 = 0
            r5 = -1
            r11 = -1
            r12 = -1
            r13 = -1
            r14 = -1
            r15 = -1
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r18 = 0
        L_0x001c:
            if (r0 >= r7) goto L_0x0201
            char r1 = r6.charAt(r0)
            int r0 = r0 + 1
            r2 = 57
            r3 = 32
            r10 = 48
            r8 = 45
            if (r1 <= r3) goto L_0x01e7
            r9 = 44
            if (r1 == r9) goto L_0x01e7
            if (r1 != r8) goto L_0x0036
            goto L_0x01e7
        L_0x0036:
            r3 = 40
            r20 = 1
            if (r1 != r3) goto L_0x0052
        L_0x003c:
            if (r0 >= r7) goto L_0x001c
            char r1 = r6.charAt(r0)
            int r0 = r0 + 1
            if (r1 != r3) goto L_0x0049
            int r20 = r20 + 1
            goto L_0x003c
        L_0x0049:
            r2 = 41
            if (r1 != r2) goto L_0x003c
            int r20 = r20 + -1
            if (r20 > 0) goto L_0x003c
            goto L_0x001c
        L_0x0052:
            r9 = 43
            r23 = 0
            if (r10 > r1) goto L_0x011f
            if (r1 > r2) goto L_0x011f
            int r25 = r1 + -48
            r3 = r25
        L_0x005e:
            if (r0 >= r7) goto L_0x006f
            char r1 = r6.charAt(r0)
            if (r10 > r1) goto L_0x006f
            if (r1 > r2) goto L_0x006f
            int r3 = r3 * 10
            int r3 = r3 + r1
            int r3 = r3 - r10
            int r0 = r0 + 1
            goto L_0x005e
        L_0x006f:
            r2 = 60
            if (r4 == r9) goto L_0x00f9
            if (r4 != r8) goto L_0x0077
            goto L_0x00f9
        L_0x0077:
            r9 = 70
            if (r3 >= r9) goto L_0x00da
            r9 = 47
            if (r4 != r9) goto L_0x0087
            if (r12 < 0) goto L_0x0087
            if (r13 < 0) goto L_0x0087
            if (r11 >= 0) goto L_0x0087
            goto L_0x00da
        L_0x0087:
            r4 = 58
            if (r1 != r4) goto L_0x0096
            if (r5 >= 0) goto L_0x0090
            r5 = r3
            goto L_0x011c
        L_0x0090:
            if (r15 >= 0) goto L_0x0093
            goto L_0x00cb
        L_0x0093:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0096:
            r4 = 47
            if (r1 != r4) goto L_0x00a7
            if (r12 >= 0) goto L_0x00a1
            int r3 = r3 + -1
            r12 = r3
            goto L_0x011c
        L_0x00a1:
            if (r13 >= 0) goto L_0x00a4
            goto L_0x00d5
        L_0x00a4:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x00a7:
            if (r0 >= r7) goto L_0x00b6
            r4 = 44
            if (r1 == r4) goto L_0x00b6
            r4 = 32
            if (r1 <= r4) goto L_0x00b6
            if (r1 == r8) goto L_0x00b6
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x00b6:
            if (r18 == 0) goto L_0x00c7
            if (r3 >= r2) goto L_0x00c7
            int r1 = (r16 > r23 ? 1 : (r16 == r23 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c3
            double r1 = (double) r3
            double r16 = r16 - r1
            goto L_0x011c
        L_0x00c3:
            double r1 = (double) r3
            double r16 = r16 + r1
            goto L_0x011c
        L_0x00c7:
            if (r5 < 0) goto L_0x00cd
            if (r15 >= 0) goto L_0x00cd
        L_0x00cb:
            r15 = r3
            goto L_0x011c
        L_0x00cd:
            if (r15 < 0) goto L_0x00d3
            if (r14 >= 0) goto L_0x00d3
            r14 = r3
            goto L_0x011c
        L_0x00d3:
            if (r13 >= 0) goto L_0x00d7
        L_0x00d5:
            r13 = r3
            goto L_0x011c
        L_0x00d7:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x00da:
            if (r11 < 0) goto L_0x00df
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x00df:
            r2 = 32
            if (r1 <= r2) goto L_0x00f1
            r2 = 44
            if (r1 == r2) goto L_0x00f1
            r2 = 47
            if (r1 == r2) goto L_0x00f1
            if (r0 < r7) goto L_0x00ee
            goto L_0x00f1
        L_0x00ee:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x00f1:
            r1 = 100
            if (r3 >= r1) goto L_0x00f7
            int r3 = r3 + 1900
        L_0x00f7:
            r11 = r3
            goto L_0x011c
        L_0x00f9:
            r1 = 24
            if (r3 >= r1) goto L_0x0100
            int r3 = r3 * 60
            goto L_0x0107
        L_0x0100:
            int r1 = r3 % 100
            int r3 = r3 / 100
            int r3 = r3 * 60
            int r3 = r3 + r1
        L_0x0107:
            if (r4 != r9) goto L_0x010a
            int r3 = -r3
        L_0x010a:
            int r1 = (r16 > r23 ? 1 : (r16 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x0117
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r4 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0117
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0117:
            double r1 = (double) r3
            r16 = r1
            r18 = 1
        L_0x011c:
            r4 = 0
            goto L_0x001c
        L_0x011f:
            r2 = 47
            if (r1 == r2) goto L_0x01e5
            r2 = 58
            if (r1 == r2) goto L_0x01e5
            if (r1 == r9) goto L_0x01e5
            if (r1 != r8) goto L_0x012d
            goto L_0x01e5
        L_0x012d:
            int r8 = r0 + -1
            r9 = r0
        L_0x0130:
            if (r9 >= r7) goto L_0x014a
            char r0 = r6.charAt(r9)
            r1 = 65
            if (r1 > r0) goto L_0x013e
            r1 = 90
            if (r0 <= r1) goto L_0x0147
        L_0x013e:
            r1 = 97
            if (r1 > r0) goto L_0x014a
            r1 = 122(0x7a, float:1.71E-43)
            if (r0 <= r1) goto L_0x0147
            goto L_0x014a
        L_0x0147:
            int r9 = r9 + 1
            goto L_0x0130
        L_0x014a:
            int r10 = r9 - r8
            r3 = 2
            if (r10 >= r3) goto L_0x0152
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0152:
            java.lang.String r2 = "am;pm;monday;tuesday;wednesday;thursday;friday;saturday;sunday;january;february;march;april;may;june;july;august;september;october;november;december;gmt;ut;utc;est;edt;cst;cdt;mst;mdt;pst;pdt;"
            r0 = 0
            r1 = 0
        L_0x0156:
            r3 = 59
            int r20 = r2.indexOf(r3, r1)
            if (r20 >= 0) goto L_0x0161
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0161:
            r3 = 1
            r21 = r9
            r9 = r0
            r0 = r2
            r22 = r1
            r1 = r3
            r25 = r2
            r2 = r22
            r3 = r33
            r19 = r4
            r4 = r8
            r22 = r8
            r8 = r5
            r5 = r10
            boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x01d5
            r0 = 4646096334330265600(0x407a400000000000, double:420.0)
            r4 = 4643985272004935680(0x4072c00000000000, double:300.0)
            r10 = 12
            r2 = 2
            if (r9 >= r2) goto L_0x019e
            if (r8 > r10) goto L_0x019b
            if (r8 >= 0) goto L_0x0190
            goto L_0x019b
        L_0x0190:
            if (r9 != 0) goto L_0x0196
            if (r8 != r10) goto L_0x01ce
            r5 = 0
            goto L_0x01cf
        L_0x0196:
            if (r8 == r10) goto L_0x01ce
            int r5 = r8 + 12
            goto L_0x01cf
        L_0x019b:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x019e:
            int r2 = r9 + -2
            r3 = 7
            if (r2 >= r3) goto L_0x01a4
            goto L_0x01ce
        L_0x01a4:
            int r2 = r2 + -7
            if (r2 >= r10) goto L_0x01af
            if (r12 >= 0) goto L_0x01ac
            r12 = r2
            goto L_0x01ce
        L_0x01ac:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x01af:
            int r2 = r2 + -12
            switch(r2) {
                case 0: goto L_0x01ca;
                case 1: goto L_0x01ca;
                case 2: goto L_0x01ca;
                case 3: goto L_0x01c7;
                case 4: goto L_0x01c2;
                case 5: goto L_0x01bb;
                case 6: goto L_0x01c7;
                case 7: goto L_0x01c4;
                case 8: goto L_0x01bb;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01c4;
                default: goto L_0x01b4;
            }
        L_0x01b4:
            org.mozilla.javascript.Kit.codeBug()
            goto L_0x01ce
        L_0x01b8:
            r0 = 4647151865492930560(0x407e000000000000, double:480.0)
            goto L_0x01c4
        L_0x01bb:
            r5 = r8
            r16 = 4645040803167600640(0x4076800000000000, double:360.0)
            goto L_0x01cf
        L_0x01c2:
            r0 = 4642648265865560064(0x406e000000000000, double:240.0)
        L_0x01c4:
            r16 = r0
            goto L_0x01ce
        L_0x01c7:
            r16 = r4
            goto L_0x01ce
        L_0x01ca:
            r5 = r8
            r16 = r23
            goto L_0x01cf
        L_0x01ce:
            r5 = r8
        L_0x01cf:
            r4 = r19
            r0 = r21
            goto L_0x001c
        L_0x01d5:
            r2 = 2
            int r1 = r20 + 1
            int r0 = r9 + 1
            r5 = r8
            r4 = r19
            r9 = r21
            r8 = r22
            r2 = r25
            goto L_0x0156
        L_0x01e5:
            r8 = r5
            goto L_0x01f8
        L_0x01e7:
            r19 = r4
            r8 = r5
            r3 = 45
            if (r0 >= r7) goto L_0x01fc
            char r4 = r6.charAt(r0)
            if (r1 != r3) goto L_0x01fc
            if (r10 > r4) goto L_0x01fc
            if (r4 > r2) goto L_0x01fc
        L_0x01f8:
            r4 = r1
            r5 = r8
            goto L_0x001c
        L_0x01fc:
            r5 = r8
            r4 = r19
            goto L_0x001c
        L_0x0201:
            r8 = r5
            if (r11 < 0) goto L_0x0241
            if (r12 < 0) goto L_0x0241
            if (r13 >= 0) goto L_0x0209
            goto L_0x0241
        L_0x0209:
            if (r14 >= 0) goto L_0x020c
            r14 = 0
        L_0x020c:
            if (r15 >= 0) goto L_0x020f
            r15 = 0
        L_0x020f:
            if (r8 >= 0) goto L_0x0213
            r10 = 0
            goto L_0x0214
        L_0x0213:
            r10 = r8
        L_0x0214:
            double r0 = (double) r11
            double r2 = (double) r12
            double r4 = (double) r13
            double r6 = (double) r10
            double r8 = (double) r15
            double r10 = (double) r14
            r31 = 0
            r19 = r0
            r21 = r2
            r23 = r4
            r25 = r6
            r27 = r8
            r29 = r10
            double r0 = date_msecFromDate(r19, r21, r23, r25, r27, r29, r31)
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0237
            double r0 = internalUTC(r0)
            return r0
        L_0x0237:
            r2 = 4678479150791524352(0x40ed4c0000000000, double:60000.0)
            double r16 = r16 * r2
            double r0 = r0 + r16
            return r0
        L_0x0241:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.date_parseString(java.lang.String):double");
    }

    private static String date_format(double d, int i) {
        StringBuilder sb = new StringBuilder(60);
        double LocalTime = LocalTime(d);
        if (i != 3) {
            appendWeekDayName(sb, WeekDay(LocalTime));
            sb.append(' ');
            appendMonthName(sb, MonthFromTime(LocalTime));
            sb.append(' ');
            append0PaddedUint(sb, DateFromTime(LocalTime), 2);
            sb.append(' ');
            int YearFromTime = YearFromTime(LocalTime);
            if (YearFromTime < 0) {
                sb.append('-');
                YearFromTime = -YearFromTime;
            }
            append0PaddedUint(sb, YearFromTime, 4);
            if (i != 4) {
                sb.append(' ');
            }
        }
        if (i != 4) {
            append0PaddedUint(sb, HourFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, MinFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, SecFromTime(LocalTime), 2);
            int floor = (int) Math.floor((LocalTZA + DaylightSavingTA(d)) / msPerMinute);
            int i2 = ((floor / 60) * 100) + (floor % 60);
            if (i2 > 0) {
                sb.append(" GMT+");
            } else {
                sb.append(" GMT-");
                i2 = -i2;
            }
            append0PaddedUint(sb, i2, 4);
            if (timeZoneFormatter == null) {
                timeZoneFormatter = new SimpleDateFormat("zzz");
            }
            if (d < 0.0d) {
                d = MakeDate(MakeDay((double) EquivalentYear(YearFromTime(LocalTime)), (double) MonthFromTime(d), (double) DateFromTime(d)), TimeWithinDay(d));
            }
            sb.append(" (");
            Date date2 = new Date((long) d);
            synchronized (timeZoneFormatter) {
                sb.append(timeZoneFormatter.format(date2));
            }
            sb.append(VersionRange.RIGHT_OPEN);
        }
        return sb.toString();
    }

    private static Object jsConstructor(Object[] objArr) {
        double d;
        NativeDate nativeDate = new NativeDate();
        if (objArr.length == 0) {
            nativeDate.date = now();
            return nativeDate;
        } else if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue((Class<?>) null);
            }
            if (obj instanceof CharSequence) {
                d = date_parseString(obj.toString());
            } else {
                d = ScriptRuntime.toNumber(obj);
            }
            nativeDate.date = TimeClip(d);
            return nativeDate;
        } else {
            double date_msecFromArgs = date_msecFromArgs(objArr);
            if (!Double.isNaN(date_msecFromArgs) && !Double.isInfinite(date_msecFromArgs)) {
                date_msecFromArgs = TimeClip(internalUTC(date_msecFromArgs));
            }
            nativeDate.date = date_msecFromArgs;
            return nativeDate;
        }
    }

    private static String toLocale_helper(double d, int i) {
        DateFormat dateFormat;
        String format;
        if (i == 5) {
            if (localeDateTimeFormatter == null) {
                localeDateTimeFormatter = DateFormat.getDateTimeInstance(1, 1);
            }
            dateFormat = localeDateTimeFormatter;
        } else if (i == 6) {
            if (localeTimeFormatter == null) {
                localeTimeFormatter = DateFormat.getTimeInstance(1);
            }
            dateFormat = localeTimeFormatter;
        } else if (i == 7) {
            if (localeDateFormatter == null) {
                localeDateFormatter = DateFormat.getDateInstance(1);
            }
            dateFormat = localeDateFormatter;
        } else {
            throw new AssertionError();
        }
        synchronized (dateFormat) {
            format = dateFormat.format(new Date((long) d));
        }
        return format;
    }

    private static String js_toUTCString(double d) {
        StringBuilder sb = new StringBuilder(60);
        appendWeekDayName(sb, WeekDay(d));
        sb.append(", ");
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append(' ');
        appendMonthName(sb, MonthFromTime(d));
        sb.append(' ');
        int YearFromTime = YearFromTime(d);
        if (YearFromTime < 0) {
            sb.append('-');
            YearFromTime = -YearFromTime;
        }
        append0PaddedUint(sb, YearFromTime, 4);
        sb.append(' ');
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append(" GMT");
        return sb.toString();
    }

    private static String js_toISOString(double d) {
        StringBuilder sb = new StringBuilder(27);
        int YearFromTime = YearFromTime(d);
        if (YearFromTime < 0) {
            sb.append('-');
            append0PaddedUint(sb, -YearFromTime, 6);
        } else if (YearFromTime > 9999) {
            append0PaddedUint(sb, YearFromTime, 6);
        } else {
            append0PaddedUint(sb, YearFromTime, 4);
        }
        sb.append('-');
        append0PaddedUint(sb, MonthFromTime(d) + 1, 2);
        sb.append('-');
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append('T');
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append('.');
        append0PaddedUint(sb, msFromTime(d), 3);
        sb.append(Matrix.MATRIX_TYPE_ZERO);
        return sb.toString();
    }

    private static void append0PaddedUint(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i3 = i2 - 1;
        int i4 = Utils.SECOND_IN_NANOS;
        if (i < 10) {
            i4 = 1;
        } else if (i < 1000000000) {
            i4 = 1;
            while (true) {
                int i5 = i4 * 10;
                if (i < i5) {
                    break;
                }
                i3--;
                i4 = i5;
            }
        } else {
            i3 -= 9;
        }
        while (i3 > 0) {
            sb.append('0');
            i3--;
        }
        while (i4 != 1) {
            sb.append((char) ((i / i4) + 48));
            i %= i4;
            i4 /= 10;
        }
        sb.append((char) (i + 48));
    }

    private static void appendMonthName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("JanFebMarAprMayJunJulAugSepOctNovDec".charAt(i2 + i3));
        }
    }

    private static void appendWeekDayName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("SunMonTueWedThuFriSat".charAt(i2 + i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r7 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r7 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (r0.length >= r7) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        r8 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
        r9 = new double[4];
        r10 = 0;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r10 >= r8) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r12 = org.mozilla.javascript.ScriptRuntime.toNumber(r0[r10]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        if (r12 != r12) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        if (java.lang.Double.isInfinite(r12) == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        r9[r10] = org.mozilla.javascript.ScriptRuntime.toInteger(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        if (r11 != false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r22 == r22) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        if (r6 == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
        r10 = LocalTime(r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005f, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0061, code lost:
        if (r7 < 4) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0063, code lost:
        if (r8 <= 0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
        r14 = r9[0];
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006a, code lost:
        r14 = (double) HourFromTime(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0070, code lost:
        if (r7 < 3) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0072, code lost:
        if (r4 >= r8) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0074, code lost:
        r16 = r9[r4];
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007c, code lost:
        r16 = (double) MinFromTime(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0083, code lost:
        if (r7 < 2) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (r4 >= r8) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0087, code lost:
        r1 = r9[r4];
        r4 = r4 + 1;
        r18 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008f, code lost:
        r18 = (double) SecFromTime(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0096, code lost:
        if (r7 < 1) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0098, code lost:
        if (r4 >= r8) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
        r0 = r9[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009d, code lost:
        r0 = (double) msFromTime(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a2, code lost:
        r0 = MakeDate(Day(r10), MakeTime(r14, r16, r18, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b0, code lost:
        if (r6 == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b2, code lost:
        r0 = internalUTC(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ba, code lost:
        return TimeClip(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00bd, code lost:
        return org.mozilla.javascript.ScriptRuntime.NaN;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double makeTime(double r22, java.lang.Object[] r24, int r25) {
        /*
            r0 = r24
            int r1 = r0.length
            if (r1 != 0) goto L_0x0008
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0008:
            r1 = 3
            r2 = 2
            r3 = 4
            r4 = 0
            r5 = 1
            switch(r25) {
                case 31: goto L_0x0026;
                case 32: goto L_0x0024;
                case 33: goto L_0x0021;
                case 34: goto L_0x001f;
                case 35: goto L_0x001c;
                case 36: goto L_0x001a;
                case 37: goto L_0x0017;
                case 38: goto L_0x0015;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L_0x0015:
            r6 = 0
            goto L_0x0018
        L_0x0017:
            r6 = 1
        L_0x0018:
            r7 = 4
            goto L_0x0028
        L_0x001a:
            r6 = 0
            goto L_0x001d
        L_0x001c:
            r6 = 1
        L_0x001d:
            r7 = 3
            goto L_0x0028
        L_0x001f:
            r6 = 0
            goto L_0x0022
        L_0x0021:
            r6 = 1
        L_0x0022:
            r7 = 2
            goto L_0x0028
        L_0x0024:
            r6 = 0
            goto L_0x0027
        L_0x0026:
            r6 = 1
        L_0x0027:
            r7 = 1
        L_0x0028:
            int r8 = r0.length
            if (r8 >= r7) goto L_0x002d
            int r8 = r0.length
            goto L_0x002e
        L_0x002d:
            r8 = r7
        L_0x002e:
            double[] r9 = new double[r3]
            r10 = 0
            r11 = 0
        L_0x0032:
            if (r10 >= r8) goto L_0x0050
            r12 = r0[r10]
            double r12 = org.mozilla.javascript.ScriptRuntime.toNumber((java.lang.Object) r12)
            int r14 = (r12 > r12 ? 1 : (r12 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x004c
            boolean r14 = java.lang.Double.isInfinite(r12)
            if (r14 == 0) goto L_0x0045
            goto L_0x004c
        L_0x0045:
            double r12 = org.mozilla.javascript.ScriptRuntime.toInteger((double) r12)
            r9[r10] = r12
            goto L_0x004d
        L_0x004c:
            r11 = 1
        L_0x004d:
            int r10 = r10 + 1
            goto L_0x0032
        L_0x0050:
            if (r11 != 0) goto L_0x00bb
            int r0 = (r22 > r22 ? 1 : (r22 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0058
            goto L_0x00bb
        L_0x0058:
            if (r6 == 0) goto L_0x005f
            double r10 = LocalTime(r22)
            goto L_0x0061
        L_0x005f:
            r10 = r22
        L_0x0061:
            if (r7 < r3) goto L_0x006a
            if (r8 <= 0) goto L_0x006a
            r3 = r9[r4]
            r14 = r3
            r4 = 1
            goto L_0x0070
        L_0x006a:
            int r0 = HourFromTime(r10)
            double r12 = (double) r0
            r14 = r12
        L_0x0070:
            if (r7 < r1) goto L_0x007c
            if (r4 >= r8) goto L_0x007c
            int r0 = r4 + 1
            r3 = r9[r4]
            r16 = r3
            r4 = r0
            goto L_0x0083
        L_0x007c:
            int r0 = MinFromTime(r10)
            double r0 = (double) r0
            r16 = r0
        L_0x0083:
            if (r7 < r2) goto L_0x008f
            if (r4 >= r8) goto L_0x008f
            int r0 = r4 + 1
            r1 = r9[r4]
            r4 = r0
            r18 = r1
            goto L_0x0096
        L_0x008f:
            int r0 = SecFromTime(r10)
            double r0 = (double) r0
            r18 = r0
        L_0x0096:
            if (r7 < r5) goto L_0x009d
            if (r4 >= r8) goto L_0x009d
            r0 = r9[r4]
            goto L_0x00a2
        L_0x009d:
            int r0 = msFromTime(r10)
            double r0 = (double) r0
        L_0x00a2:
            r20 = r0
            double r0 = MakeTime(r14, r16, r18, r20)
            double r2 = Day(r10)
            double r0 = MakeDate(r2, r0)
            if (r6 == 0) goto L_0x00b6
            double r0 = internalUTC(r0)
        L_0x00b6:
            double r0 = TimeClip(r0)
            return r0
        L_0x00bb:
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.makeTime(double, java.lang.Object[], int):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        if (r0.length >= r6) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        r7 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        r8 = new double[3];
        r9 = 0;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r9 >= r7) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r11 = org.mozilla.javascript.ScriptRuntime.toNumber(r0[r9]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r11 != r11) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        if (java.lang.Double.isInfinite(r11) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r8[r9] = org.mozilla.javascript.ScriptRuntime.toInteger(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r10 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        return org.mozilla.javascript.ScriptRuntime.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        if (r19 == r19) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0053, code lost:
        if (r6 >= 3) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0057, code lost:
        return org.mozilla.javascript.ScriptRuntime.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0058, code lost:
        r9 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        if (r5 == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005d, code lost:
        r9 = LocalTime(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0062, code lost:
        r9 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0064, code lost:
        if (r6 < 3) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
        if (r7 <= 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
        r13 = r8[0];
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006d, code lost:
        r13 = (double) YearFromTime(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0073, code lost:
        if (r6 < 2) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0075, code lost:
        if (r3 >= r7) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0077, code lost:
        r1 = r8[r3];
        r3 = r3 + 1;
        r15 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007e, code lost:
        r15 = (double) MonthFromTime(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0084, code lost:
        if (r6 < 1) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0086, code lost:
        if (r3 >= r7) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0088, code lost:
        r0 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008b, code lost:
        r0 = (double) DateFromTime(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0090, code lost:
        r0 = MakeDate(MakeDay(r13, r15, r0), TimeWithinDay(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009e, code lost:
        if (r5 == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a0, code lost:
        r0 = internalUTC(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a8, code lost:
        return TimeClip(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double makeDate(double r19, java.lang.Object[] r21, int r22) {
        /*
            r0 = r21
            int r1 = r0.length
            if (r1 != 0) goto L_0x0008
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0008:
            r1 = 2
            r2 = 3
            r3 = 0
            r4 = 1
            switch(r22) {
                case 39: goto L_0x0020;
                case 40: goto L_0x001e;
                case 41: goto L_0x001b;
                case 42: goto L_0x0019;
                case 43: goto L_0x0016;
                case 44: goto L_0x0014;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.codeBug()
            throw r0
        L_0x0014:
            r5 = 0
            goto L_0x0017
        L_0x0016:
            r5 = 1
        L_0x0017:
            r6 = 3
            goto L_0x0022
        L_0x0019:
            r5 = 0
            goto L_0x001c
        L_0x001b:
            r5 = 1
        L_0x001c:
            r6 = 2
            goto L_0x0022
        L_0x001e:
            r5 = 0
            goto L_0x0021
        L_0x0020:
            r5 = 1
        L_0x0021:
            r6 = 1
        L_0x0022:
            int r7 = r0.length
            if (r7 >= r6) goto L_0x0027
            int r7 = r0.length
            goto L_0x0028
        L_0x0027:
            r7 = r6
        L_0x0028:
            double[] r8 = new double[r2]
            r9 = 0
            r10 = 0
        L_0x002c:
            if (r9 >= r7) goto L_0x004a
            r11 = r0[r9]
            double r11 = org.mozilla.javascript.ScriptRuntime.toNumber((java.lang.Object) r11)
            int r13 = (r11 > r11 ? 1 : (r11 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0046
            boolean r13 = java.lang.Double.isInfinite(r11)
            if (r13 == 0) goto L_0x003f
            goto L_0x0046
        L_0x003f:
            double r11 = org.mozilla.javascript.ScriptRuntime.toInteger((double) r11)
            r8[r9] = r11
            goto L_0x0047
        L_0x0046:
            r10 = 1
        L_0x0047:
            int r9 = r9 + 1
            goto L_0x002c
        L_0x004a:
            if (r10 == 0) goto L_0x004f
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x004f:
            int r0 = (r19 > r19 ? 1 : (r19 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x005b
            if (r6 >= r2) goto L_0x0058
            double r0 = org.mozilla.javascript.ScriptRuntime.NaN
            return r0
        L_0x0058:
            r9 = 0
            goto L_0x0064
        L_0x005b:
            if (r5 == 0) goto L_0x0062
            double r9 = LocalTime(r19)
            goto L_0x0064
        L_0x0062:
            r9 = r19
        L_0x0064:
            if (r6 < r2) goto L_0x006d
            if (r7 <= 0) goto L_0x006d
            r2 = r8[r3]
            r13 = r2
            r3 = 1
            goto L_0x0073
        L_0x006d:
            int r0 = YearFromTime(r9)
            double r11 = (double) r0
            r13 = r11
        L_0x0073:
            if (r6 < r1) goto L_0x007e
            if (r3 >= r7) goto L_0x007e
            int r0 = r3 + 1
            r1 = r8[r3]
            r3 = r0
            r15 = r1
            goto L_0x0084
        L_0x007e:
            int r0 = MonthFromTime(r9)
            double r0 = (double) r0
            r15 = r0
        L_0x0084:
            if (r6 < r4) goto L_0x008b
            if (r3 >= r7) goto L_0x008b
            r0 = r8[r3]
            goto L_0x0090
        L_0x008b:
            int r0 = DateFromTime(r9)
            double r0 = (double) r0
        L_0x0090:
            r17 = r0
            double r0 = MakeDay(r13, r15, r17)
            double r2 = TimeWithinDay(r9)
            double r0 = MakeDate(r0, r2)
            if (r5 == 0) goto L_0x00a4
            double r0 = internalUTC(r0)
        L_0x00a4:
            double r0 = TimeClip(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.makeDate(double, java.lang.Object[], int):double");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r15) {
        /*
            r14 = this;
            int r0 = r15.length()
            r1 = 2
            r2 = 6
            r3 = 8
            r4 = 83
            r5 = 9
            r6 = 84
            r7 = 68
            r8 = 77
            r9 = 3
            r10 = 116(0x74, float:1.63E-43)
            r11 = 115(0x73, float:1.61E-43)
            r12 = 103(0x67, float:1.44E-43)
            r13 = 0
            switch(r0) {
                case 6: goto L_0x0207;
                case 7: goto L_0x01bb;
                case 8: goto L_0x0177;
                case 9: goto L_0x0171;
                case 10: goto L_0x0129;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x007c;
                case 14: goto L_0x0061;
                case 15: goto L_0x004d;
                case 16: goto L_0x001d;
                case 17: goto L_0x0047;
                case 18: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0219
        L_0x001f:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x002b
            r1 = 28
            java.lang.String r0 = "getUTCMilliseconds"
            goto L_0x021b
        L_0x002b:
            if (r0 != r11) goto L_0x0033
            r1 = 32
            java.lang.String r0 = "setUTCMilliseconds"
            goto L_0x021b
        L_0x0033:
            if (r0 != r10) goto L_0x0219
            char r0 = r15.charAt(r3)
            if (r0 != r7) goto L_0x0040
            r1 = 7
            java.lang.String r0 = "toLocaleDateString"
            goto L_0x021b
        L_0x0040:
            if (r0 != r6) goto L_0x0219
            java.lang.String r0 = "toLocaleTimeString"
            r1 = 6
            goto L_0x021b
        L_0x0047:
            r1 = 29
            java.lang.String r0 = "getTimezoneOffset"
            goto L_0x021b
        L_0x004d:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0059
            r1 = 27
            java.lang.String r0 = "getMilliseconds"
            goto L_0x021b
        L_0x0059:
            if (r0 != r11) goto L_0x0219
            r1 = 31
            java.lang.String r0 = "setMilliseconds"
            goto L_0x021b
        L_0x0061:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x006d
            r1 = 14
            java.lang.String r0 = "getUTCFullYear"
            goto L_0x021b
        L_0x006d:
            if (r0 != r11) goto L_0x0075
            r1 = 44
            java.lang.String r0 = "setUTCFullYear"
            goto L_0x021b
        L_0x0075:
            if (r0 != r10) goto L_0x0219
            r1 = 5
            java.lang.String r0 = "toLocaleString"
            goto L_0x021b
        L_0x007c:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0096
            char r0 = r15.charAt(r2)
            if (r0 != r8) goto L_0x008e
            r1 = 24
            java.lang.String r0 = "getUTCMinutes"
            goto L_0x021b
        L_0x008e:
            if (r0 != r4) goto L_0x0219
            r1 = 26
            java.lang.String r0 = "getUTCSeconds"
            goto L_0x021b
        L_0x0096:
            if (r0 != r11) goto L_0x0219
            char r0 = r15.charAt(r2)
            if (r0 != r8) goto L_0x00a4
            r1 = 36
            java.lang.String r0 = "setUTCMinutes"
            goto L_0x021b
        L_0x00a4:
            if (r0 != r4) goto L_0x0219
            r1 = 34
            java.lang.String r0 = "setUTCSeconds"
            goto L_0x021b
        L_0x00ac:
            char r0 = r15.charAt(r1)
            if (r0 != r7) goto L_0x00b7
            r1 = 4
            java.lang.String r0 = "toDateString"
            goto L_0x021b
        L_0x00b7:
            if (r0 != r6) goto L_0x0219
            java.lang.String r0 = "toTimeString"
            r1 = 3
            goto L_0x021b
        L_0x00be:
            char r0 = r15.charAt(r9)
            r1 = 70
            if (r0 == r1) goto L_0x0115
            if (r0 == r8) goto L_0x010f
            if (r0 == r11) goto L_0x010a
            switch(r0) {
                case 83: goto L_0x0104;
                case 84: goto L_0x0101;
                case 85: goto L_0x00cf;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            goto L_0x0219
        L_0x00cf:
            char r0 = r15.charAt(r13)
            r1 = 114(0x72, float:1.6E-43)
            if (r0 != r12) goto L_0x00eb
            char r0 = r15.charAt(r5)
            if (r0 != r1) goto L_0x00e3
            r1 = 22
            java.lang.String r0 = "getUTCHours"
            goto L_0x021b
        L_0x00e3:
            if (r0 != r10) goto L_0x0219
            r1 = 16
            java.lang.String r0 = "getUTCMonth"
            goto L_0x021b
        L_0x00eb:
            if (r0 != r11) goto L_0x0219
            char r0 = r15.charAt(r5)
            if (r0 != r1) goto L_0x00f9
            r1 = 38
            java.lang.String r0 = "setUTCHours"
            goto L_0x021b
        L_0x00f9:
            if (r0 != r10) goto L_0x0219
            r1 = 42
            java.lang.String r0 = "setUTCMonth"
            goto L_0x021b
        L_0x0101:
            java.lang.String r0 = "toUTCString"
            goto L_0x0111
        L_0x0104:
            r1 = 46
            java.lang.String r0 = "toISOString"
            goto L_0x021b
        L_0x010a:
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L_0x021b
        L_0x010f:
            java.lang.String r0 = "toGMTString"
        L_0x0111:
            r1 = 8
            goto L_0x021b
        L_0x0115:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0121
            r1 = 13
            java.lang.String r0 = "getFullYear"
            goto L_0x021b
        L_0x0121:
            if (r0 != r11) goto L_0x0219
            r1 = 43
            java.lang.String r0 = "setFullYear"
            goto L_0x021b
        L_0x0129:
            char r0 = r15.charAt(r9)
            if (r0 != r8) goto L_0x0143
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x013b
            r1 = 23
            java.lang.String r0 = "getMinutes"
            goto L_0x021b
        L_0x013b:
            if (r0 != r11) goto L_0x0219
            r1 = 35
            java.lang.String r0 = "setMinutes"
            goto L_0x021b
        L_0x0143:
            if (r0 != r4) goto L_0x0159
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0151
            r1 = 25
            java.lang.String r0 = "getSeconds"
            goto L_0x021b
        L_0x0151:
            if (r0 != r11) goto L_0x0219
            r1 = 33
            java.lang.String r0 = "setSeconds"
            goto L_0x021b
        L_0x0159:
            r1 = 85
            if (r0 != r1) goto L_0x0219
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0169
            r1 = 18
            java.lang.String r0 = "getUTCDate"
            goto L_0x021b
        L_0x0169:
            if (r0 != r11) goto L_0x0219
            r1 = 40
            java.lang.String r0 = "setUTCDate"
            goto L_0x021b
        L_0x0171:
            r1 = 20
            java.lang.String r0 = "getUTCDay"
            goto L_0x021b
        L_0x0177:
            char r0 = r15.charAt(r9)
            r2 = 72
            if (r0 == r2) goto L_0x01a7
            if (r0 == r8) goto L_0x0193
            r2 = 111(0x6f, float:1.56E-43)
            if (r0 == r2) goto L_0x018d
            if (r0 == r10) goto L_0x0189
            goto L_0x0219
        L_0x0189:
            java.lang.String r0 = "toString"
            goto L_0x021b
        L_0x018d:
            java.lang.String r0 = "toSource"
            r1 = 9
            goto L_0x021b
        L_0x0193:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x019f
            r1 = 15
            java.lang.String r0 = "getMonth"
            goto L_0x021b
        L_0x019f:
            if (r0 != r11) goto L_0x0219
            r1 = 41
            java.lang.String r0 = "setMonth"
            goto L_0x021b
        L_0x01a7:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x01b3
            r1 = 21
            java.lang.String r0 = "getHours"
            goto L_0x021b
        L_0x01b3:
            if (r0 != r11) goto L_0x0219
            r1 = 37
            java.lang.String r0 = "setHours"
            goto L_0x021b
        L_0x01bb:
            char r0 = r15.charAt(r9)
            if (r0 == r7) goto L_0x01f5
            if (r0 == r6) goto L_0x01e3
            r1 = 89
            if (r0 == r1) goto L_0x01d1
            r1 = 117(0x75, float:1.64E-43)
            if (r0 == r1) goto L_0x01cc
            goto L_0x0219
        L_0x01cc:
            r1 = 10
            java.lang.String r0 = "valueOf"
            goto L_0x021b
        L_0x01d1:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x01dc
            r1 = 12
            java.lang.String r0 = "getYear"
            goto L_0x021b
        L_0x01dc:
            if (r0 != r11) goto L_0x0219
            r1 = 45
            java.lang.String r0 = "setYear"
            goto L_0x021b
        L_0x01e3:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x01ee
            r1 = 11
            java.lang.String r0 = "getTime"
            goto L_0x021b
        L_0x01ee:
            if (r0 != r11) goto L_0x0219
            r1 = 30
            java.lang.String r0 = "setTime"
            goto L_0x021b
        L_0x01f5:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0200
            r1 = 17
            java.lang.String r0 = "getDate"
            goto L_0x021b
        L_0x0200:
            if (r0 != r11) goto L_0x0219
            r1 = 39
            java.lang.String r0 = "setDate"
            goto L_0x021b
        L_0x0207:
            char r0 = r15.charAt(r13)
            if (r0 != r12) goto L_0x0212
            r1 = 19
            java.lang.String r0 = "getDay"
            goto L_0x021b
        L_0x0212:
            if (r0 != r10) goto L_0x0219
            r1 = 47
            java.lang.String r0 = "toJSON"
            goto L_0x021b
        L_0x0219:
            r0 = 0
            r1 = 0
        L_0x021b:
            if (r0 == 0) goto L_0x0226
            if (r0 == r15) goto L_0x0226
            boolean r15 = r0.equals(r15)
            if (r15 != 0) goto L_0x0226
            goto L_0x0227
        L_0x0226:
            r13 = r1
        L_0x0227:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.findPrototypeId(java.lang.String):int");
    }
}
