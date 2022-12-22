package org.xidea.p087el.json;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;
import org.xidea.p087el.impl.ReflectUtil;

/* renamed from: org.xidea.el.json.JSONEncoder */
public class JSONEncoder {
    public static final String W3C_DATE_FORMAT = "yyyy-MM-dd";
    public static final String W3C_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mmZ";
    public static final String W3C_DATE_TIME_MILLISECOND_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String W3C_DATE_TIME_SECOND_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static JSONEncoder encoder = new JSONEncoder();
    private static Log log = LogFactory.getLog(JSONEncoder.class);
    private final boolean addressEqual;
    private final String dateFormat;
    private final boolean ignoreClassName;
    private int index;
    private final Object[] parent;
    private final boolean throwError;

    public JSONEncoder(String str, boolean z, int i, boolean z2, boolean z3) {
        this.index = 0;
        this.dateFormat = str;
        this.ignoreClassName = z;
        this.parent = i > 0 ? new Object[i] : null;
        this.addressEqual = z2;
        this.throwError = z3;
    }

    private JSONEncoder() {
        this("yyyy-MM-dd'T'HH:mm:ss.SSSZ", true, 64, true, true);
    }

    public static String encode(Object obj) {
        StringBuilder sb = new StringBuilder();
        try {
            encoder.encode(obj, sb);
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void encode(Object obj, Appendable appendable) throws IOException {
        Object[] objArr = this.parent;
        if (objArr == null) {
            print(obj, appendable);
            return;
        }
        synchronized (objArr) {
            this.index = 0;
            print(obj, appendable);
        }
    }

    /* access modifiers changed from: protected */
    public void print(Object obj, Appendable appendable) throws IOException {
        StringBuilder sb;
        int i;
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == Boolean.class) {
            appendable.append(obj.toString());
        } else if (cls == String.class) {
            printString((String) obj, appendable);
        } else if (cls == Character.class) {
            printString(obj.toString(), appendable);
        } else if (Number.class.isAssignableFrom(cls)) {
            appendable.append(obj.toString());
        } else if (cls == Class.class) {
            printString(((Class) obj).getName(), appendable);
        } else if (!Date.class.isAssignableFrom(cls) || this.dateFormat == null) {
            Object[] objArr = this.parent;
            if (objArr != null) {
                int i2 = this.index;
                if (i2 < objArr.length) {
                    if (!this.addressEqual) {
                        while (true) {
                            i = i2 - 1;
                            if (i2 <= 0 || obj.equals(this.parent[i])) {
                                break;
                            }
                            i2 = i;
                        }
                    } else {
                        while (true) {
                            i = i2 - 1;
                            if (i2 <= 0 || this.parent[i] == obj) {
                                break;
                            }
                            i2 = i;
                        }
                    }
                    i2 = i;
                }
                if (i2 < 0) {
                    Object[] objArr2 = this.parent;
                    int i3 = this.index;
                    this.index = i3 + 1;
                    objArr2[i3] = obj;
                } else {
                    if (i2 < this.parent.length) {
                        sb = new StringBuilder("JSON 数据源中发现递归行为:");
                        sb.append(appendable);
                        sb.append("，递归数据将当null处理");
                    } else {
                        sb = new StringBuilder("深度超出许可范围：");
                        sb.append(appendable);
                    }
                    String sb2 = sb.toString();
                    log.error(sb2);
                    if (!this.throwError) {
                        appendable.append("null");
                        return;
                    }
                    throw new IllegalStateException(sb2);
                }
            }
            try {
                if (obj instanceof Map) {
                    printMap((Map<?, ?>) (Map) obj, appendable);
                } else if (cls.isArray()) {
                    printList(obj, appendable);
                } else if (obj instanceof Iterator) {
                    printList((Iterator<?>) (Iterator) obj, appendable);
                } else if (obj instanceof Collection) {
                    printList((Iterator<?>) ((Collection) obj).iterator(), appendable);
                } else {
                    printMap(obj, appendable);
                }
            } finally {
                Object[] objArr3 = this.parent;
                if (objArr3 != null) {
                    int i4 = this.index - 1;
                    this.index = i4;
                    objArr3[i4] = null;
                }
            }
        } else {
            String format = new SimpleDateFormat(this.dateFormat).format((Date) obj);
            printString(new StringBuilder(format).insert(format.length() - 2, ':').toString(), appendable);
        }
    }

    /* access modifiers changed from: protected */
    public void printString(String str, Appendable appendable) throws IOException {
        appendable.append(Typography.quote);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 13) {
                appendable.append("\\r");
            } else if (charAt != '\"') {
                switch (charAt) {
                    case 8:
                        appendable.append("\\b");
                        break;
                    case 9:
                        appendable.append("\\t");
                        break;
                    case 10:
                        appendable.append("\\n");
                        break;
                    default:
                        if (!Character.isISOControl(charAt)) {
                            appendable.append(charAt);
                            break;
                        } else {
                            appendable.append("\\u");
                            appendable.append(Integer.toHexString(charAt + 0), 1, 5);
                            break;
                        }
                }
            } else {
                appendable.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                appendable.append(charAt);
            }
        }
        appendable.append(Typography.quote);
    }

    /* access modifiers changed from: protected */
    public void printMap(Object obj, Appendable appendable) throws IOException {
        appendable.append('{');
        try {
            Map<String, Method> getterMap = ReflectUtil.getGetterMap(obj.getClass());
            boolean z = true;
            for (String next : getterMap.keySet()) {
                try {
                    Method method = getterMap.get(next);
                    if (method != null) {
                        if (!this.ignoreClassName || !"class".equals(next)) {
                            Object invoke = method.invoke(obj, new Object[0]);
                            if (z) {
                                z = false;
                            } else {
                                appendable.append(',');
                            }
                            appendable.append(Typography.quote);
                            appendable.append(next);
                            appendable.append(Typography.quote);
                            appendable.append(':');
                            print(invoke, appendable);
                        }
                    }
                } catch (Exception e) {
                    log.warn("属性获取失败", e);
                }
            }
        } catch (Exception e2) {
            log.warn("JavaBean信息获取失败", e2);
        }
        appendable.append('}');
    }

    /* access modifiers changed from: protected */
    public void printMap(Map<?, ?> map, Appendable appendable) throws IOException {
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        if (it.hasNext()) {
            appendable.append('{');
            while (true) {
                Map.Entry next = it.next();
                printString(String.valueOf(next.getKey()), appendable);
                appendable.append(':');
                print(next.getValue(), appendable);
                if (it.hasNext()) {
                    appendable.append(',');
                } else {
                    appendable.append('}');
                    return;
                }
            }
        } else {
            appendable.append("{}");
        }
    }

    /* access modifiers changed from: protected */
    public void printList(Object obj, Appendable appendable) throws IOException {
        appendable.append(VersionRange.LEFT_CLOSED);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                appendable.append(',');
            }
            print(Array.get(obj, i), appendable);
        }
        appendable.append(VersionRange.RIGHT_CLOSED);
    }

    /* access modifiers changed from: protected */
    public void printList(Iterator<?> it, Appendable appendable) throws IOException {
        if (it.hasNext()) {
            appendable.append(VersionRange.LEFT_CLOSED);
            while (true) {
                print(it.next(), appendable);
                if (it.hasNext()) {
                    appendable.append(',');
                } else {
                    appendable.append(VersionRange.RIGHT_CLOSED);
                    return;
                }
            }
        } else {
            appendable.append("[]");
        }
    }
}
