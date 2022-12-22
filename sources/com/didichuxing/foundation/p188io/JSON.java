package com.didichuxing.foundation.p188io;

import com.didichuxing.foundation.util.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.didichuxing.foundation.io.JSON */
public final class JSON {
    public static final String stringify(Object obj) throws JSONException {
        if (obj == null || obj == JSONObject.NULL || (obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return String.valueOf(obj);
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString();
        }
        if (obj instanceof Number) {
            String obj2 = ((Number) obj).toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        } else if (obj instanceof CharSequence) {
            return quote(obj.toString());
        } else {
            return new JSONObject(Introspector.properties(obj, true)).toString();
        }
    }

    public static final Object parse(String str) throws JSONException {
        return new JSONTokener(str).nextValue();
    }

    public static final Object parse(InputStream inputStream) throws JSONException, IOException {
        return parse((Reader) new InputStreamReader(inputStream));
    }

    public static final Object parse(Reader reader) throws JSONException, IOException {
        return parse(Streams.readFullyNoClose(reader));
    }

    public static String quote(String str) {
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Typography.quote);
        int length = str.length();
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                stringBuffer.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"') {
                    if (charAt != '/') {
                        if (charAt != '\\') {
                            switch (charAt) {
                                case 8:
                                    stringBuffer.append("\\b");
                                    break;
                                case 9:
                                    stringBuffer.append("\\t");
                                    break;
                                case 10:
                                    stringBuffer.append("\\n");
                                    break;
                                default:
                                    if (charAt >= ' ' && ((charAt < 128 || charAt >= 160) && (charAt < 8192 || charAt >= 8448))) {
                                        stringBuffer.append(charAt);
                                        break;
                                    } else {
                                        String str2 = "000" + Integer.toHexString(charAt);
                                        stringBuffer.append("\\u" + str2.substring(str2.length() - 4));
                                        break;
                                    }
                            }
                        }
                    } else {
                        if (c == '<') {
                            stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        }
                        stringBuffer.append(charAt);
                    }
                }
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append("\\r");
            }
            i++;
            c = charAt;
        }
        stringBuffer.append(Typography.quote);
        return stringBuffer.toString();
    }
}
