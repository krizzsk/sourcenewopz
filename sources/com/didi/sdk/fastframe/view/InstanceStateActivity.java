package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstanceStateActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final String f35910a = "savedData";

    /* renamed from: b */
    private static final String f35911b = "int";

    /* renamed from: c */
    private static final String f35912c = "long";

    /* renamed from: d */
    private static final String f35913d = "double";

    /* renamed from: e */
    private static final String f35914e = "float";

    /* renamed from: f */
    private static final String f35915f = "boolean";

    /* renamed from: g */
    private static final String f35916g = "serializable";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m25425b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m25425b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m25420a(bundle);
    }

    /* renamed from: a */
    private void m25420a(Bundle bundle) {
        HashMap<String, Object> a = m25419a((Class) getClass(), (HashMap<String, Object>) new HashMap());
        if (!CollectionUtil.isEmpty((Map) a)) {
            for (Map.Entry next : a.entrySet()) {
                m25421a(bundle, (String) next.getKey(), next.getValue());
            }
        }
        if (a != null) {
            bundle.putCharSequenceArrayList(f35910a, new ArrayList(a.keySet()));
        }
    }

    /* renamed from: b */
    private void m25425b(Bundle bundle) {
        if (bundle != null) {
            ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(f35910a);
            if (!CollectionUtil.isEmpty((Collection) charSequenceArrayList)) {
                Iterator<CharSequence> it = charSequenceArrayList.iterator();
                while (it.hasNext()) {
                    CharSequence next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        m25422a(next, bundle.get((String) next));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m25419a(Class cls, HashMap<String, Object> hashMap) {
        if (cls == null) {
            return null;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (cls == InstanceStateActivity.class) {
            return hashMap;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (!CollectionUtil.isEmpty((Object[]) declaredFields)) {
            for (Field field : declaredFields) {
                if (m25423a(field)) {
                    String a = m25417a(cls, field);
                    Object b = m25424b(field);
                    if (!TextUtils.isEmpty(a) && b != null) {
                        hashMap.put(a, b);
                    }
                }
            }
        }
        return m25419a(cls.getSuperclass(), hashMap);
    }

    /* renamed from: a */
    private void m25421a(Bundle bundle, String str, Object obj) {
        String a = m25418a(str);
        if (bundle == null) {
            return;
        }
        if (f35911b.equals(a)) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (f35912c.equals(a)) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if ("float".equals(a)) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (f35913d.equals(a)) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if ("boolean".equals(a)) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (f35916g.equals(a)) {
            bundle.putSerializable(str, (Serializable) obj);
        } else {
            SystemUtils.log(6, "InstanceStateActivity", "不支持存储类型：" + str, (Throwable) null, "com.didi.sdk.fastframe.view.InstanceStateActivity", 184);
        }
    }

    /* renamed from: a */
    private boolean m25423a(Field field) {
        if (field == null) {
            return false;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class)) {
            return false;
        }
        Class cls = (Class) genericType;
        if (!field.isAnnotationPresent(SavedInstance.class)) {
            return false;
        }
        if (Serializable.class.isAssignableFrom(cls) || cls.getSimpleName().equals(f35911b) || cls.getSimpleName().equals("java.lang.Integer") || cls.getSimpleName().equals(f35912c) || cls.getSimpleName().equals("java.lang.Long") || cls.getSimpleName().equals(f35913d) || cls.getSimpleName().equals("java.lang.Double") || cls.getSimpleName().equals("float") || cls.getSimpleName().equals("java.lang.Float") || cls.getSimpleName().equals("boolean") || cls.getSimpleName().equals("java.lang.Boolean")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private String m25417a(Class cls, Field field) {
        if (cls == null || field == null) {
            return null;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class) || !Serializable.class.isAssignableFrom((Class) genericType)) {
            return cls.getName() + "|" + field.getName() + "|" + genericType;
        }
        return cls.getName() + "|" + field.getName() + "|" + "java.io.Serializable";
    }

    /* renamed from: a */
    private String m25418a(String str) {
        String str2 = String.valueOf(str).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG)[2];
        String str3 = f35911b;
        if (!str3.equals(str2) && !"java.lang.Integer".equals(str2)) {
            str3 = f35912c;
            if (!str3.equals(str2) && !"java.lang.Long".equals(str2)) {
                str3 = f35913d;
                if (!str3.equals(str2) && !"java.lang.Double".equals(str2)) {
                    str3 = "float";
                    if (!str3.equals(str2) && !"java.lang.Float".equals(str2)) {
                        str3 = "boolean";
                        if (!str3.equals(str2) && !"java.lang.Boolean".equals(str2)) {
                            if ("java.io.Serializable".equals(str2)) {
                                return f35916g;
                            }
                            return null;
                        }
                    }
                }
            }
        }
        return str3;
    }

    /* renamed from: b */
    private Object m25424b(Field field) {
        Object obj = null;
        if (field != null) {
            field.setAccessible(true);
            try {
                obj = field.get(this);
            } catch (IllegalAccessException unused) {
            }
            field.setAccessible(false);
        }
        return obj;
    }

    /* renamed from: a */
    private void m25422a(CharSequence charSequence, Object obj) {
        String[] split = String.valueOf(charSequence).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        String str = split[0];
        try {
            Field declaredField = Class.forName(str).getDeclaredField(split[1]);
            declaredField.setAccessible(true);
            declaredField.set(this, obj);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
