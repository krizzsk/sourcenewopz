package org.osgi.dto;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p071io.IOUtils;
import rui.config.RConfigConstants;

public abstract class DTO {
    public String toString() {
        return appendValue(new StringBuilder(), new IdentityHashMap(), RConfigConstants.KEYWORD_COLOR_SIGN, this).toString();
    }

    private static StringBuilder appendDTO(StringBuilder sb, Map<Object, String> map, String str, DTO dto) {
        sb.append(Const.joLeft);
        String str2 = "";
        for (Field field : dto.getClass().getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                sb.append(str2);
                String name = field.getName();
                appendString(sb, name);
                sb.append(":");
                Object obj = null;
                try {
                    obj = field.get(dto);
                } catch (IllegalAccessException unused) {
                }
                appendValue(sb, map, str + "/" + name, obj);
                str2 = ", ";
            }
        }
        sb.append("}");
        return sb;
    }

    private static StringBuilder appendValue(StringBuilder sb, Map<Object, String> map, String str, Object obj) {
        if (obj == null) {
            sb.append("null");
            return sb;
        } else if ((obj instanceof String) || (obj instanceof Character)) {
            return appendString(sb, compress(obj.toString()));
        } else {
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                sb.append(obj.toString());
                return sb;
            }
            String str2 = map.get(obj);
            if (str2 != null) {
                sb.append("{\"$ref\":");
                appendString(sb, str2);
                sb.append("}");
                return sb;
            }
            map.put(obj, str);
            if (obj instanceof DTO) {
                return appendDTO(sb, map, str, (DTO) obj);
            }
            if (obj instanceof Map) {
                return appendMap(sb, map, str, (Map) obj);
            }
            if ((obj instanceof List) || (obj instanceof Set)) {
                return appendIterable(sb, map, str, (Iterable) obj);
            }
            if (obj.getClass().isArray()) {
                return appendArray(sb, map, str, obj);
            }
            return appendString(sb, compress(obj.toString()));
        }
    }

    private static StringBuilder appendArray(StringBuilder sb, Map<Object, String> map, String str, Object obj) {
        sb.append(Const.jaLeft);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            appendValue(sb, map, str + "/" + i, Array.get(obj, i));
        }
        sb.append(Const.jaRight);
        return sb;
    }

    private static StringBuilder appendIterable(StringBuilder sb, Map<Object, String> map, String str, Iterable<?> iterable) {
        sb.append(Const.jaLeft);
        int i = 0;
        for (Object next : iterable) {
            if (i > 0) {
                sb.append(",");
            }
            appendValue(sb, map, str + "/" + i, next);
            i++;
        }
        sb.append(Const.jaRight);
        return sb;
    }

    private static StringBuilder appendMap(StringBuilder sb, Map<Object, String> map, String str, Map<?, ?> map2) {
        sb.append(Const.joLeft);
        String str2 = "";
        for (Map.Entry next : map2.entrySet()) {
            sb.append(str2);
            String valueOf = String.valueOf(next.getKey());
            appendString(sb, valueOf);
            sb.append(":");
            Object value = next.getValue();
            appendValue(sb, map, str + "/" + valueOf, value);
            str2 = ", ";
        }
        sb.append("}");
        return sb;
    }

    private static StringBuilder appendString(StringBuilder sb, CharSequence charSequence) {
        sb.append(Const.jsQuote);
        int length = sb.length();
        sb.append(charSequence);
        while (length < sb.length()) {
            char charAt = sb.charAt(length);
            if (charAt == '\"' || charAt == '\\') {
                sb.insert(length, IOUtils.DIR_SEPARATOR_WINDOWS);
                length += 2;
            } else if (charAt < ' ') {
                sb.insert(length + 1, Integer.toHexString(charAt | 0));
                sb.replace(length, length + 2, "\\u");
                length += 6;
            } else {
                length++;
            }
        }
        sb.append(Const.jsQuote);
        return sb;
    }

    private static CharSequence compress(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 21) {
            return charSequence;
        }
        StringBuilder sb = new StringBuilder(21);
        sb.append(charSequence, 0, 9);
        sb.append("...");
        sb.append(charSequence, length - 9, length);
        return sb;
    }
}
