package com.didichuxing.alpha.crash.dump;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.entrega.customer.app.constant.Const;
import com.squareup.haha.perflib.ArrayInstance;
import com.squareup.haha.perflib.ClassInstance;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.Type;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.text.Typography;

public final class HahaHelper {
    private static final Set<String> WRAPPER_TYPES = new HashSet(Arrays.asList(new String[]{Boolean.class.getName(), Character.class.getName(), Float.class.getName(), Double.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName()}));

    static String threadName(Instance instance) {
        Object fieldValue = fieldValue(classInstanceValues(instance), "name");
        if (fieldValue == null) {
            return "Thread name not available";
        }
        return asString(fieldValue);
    }

    static boolean extendsThread(ClassObj classObj) {
        while (classObj.getSuperClassObj() != null) {
            if (classObj.getClassName().equals(Thread.class.getName())) {
                return true;
            }
            classObj = classObj.getSuperClassObj();
        }
        return false;
    }

    static String valueAsString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (!(obj instanceof ClassInstance)) {
            return obj.toString();
        }
        if (!((ClassInstance) obj).getClassObj().getClassName().equals(String.class.getName())) {
            return obj.toString();
        }
        return Typography.quote + asString(obj) + Typography.quote;
    }

    static String asString(Object obj) {
        Preconditions.checkNotNull(obj, "stringObject");
        Instance instance = (Instance) obj;
        List<ClassInstance.FieldValue> classInstanceValues = classInstanceValues(instance);
        Integer num = (Integer) fieldValue(classInstanceValues, Const.PageParams.COUNT);
        Preconditions.checkNotNull(num, Const.PageParams.COUNT);
        if (num.intValue() == 0) {
            return "";
        }
        Object fieldValue = fieldValue(classInstanceValues, "value");
        Preconditions.checkNotNull(fieldValue, "value");
        if (isCharArray(fieldValue)) {
            ArrayInstance arrayInstance = (ArrayInstance) fieldValue;
            Integer num2 = 0;
            if (hasField(classInstanceValues, TypedValues.CycleType.S_WAVE_OFFSET)) {
                num2 = (Integer) fieldValue(classInstanceValues, TypedValues.CycleType.S_WAVE_OFFSET);
                Preconditions.checkNotNull(num2, TypedValues.CycleType.S_WAVE_OFFSET);
            }
            return new String(arrayInstance.asCharArray(num2.intValue(), num.intValue()));
        } else if (isByteArray(fieldValue)) {
            ArrayInstance arrayInstance2 = (ArrayInstance) fieldValue;
            Class<ArrayInstance> cls = ArrayInstance.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("asRawByteArray", new Class[]{Integer.TYPE, Integer.TYPE});
                declaredMethod.setAccessible(true);
                return new String((byte[]) declaredMethod.invoke(arrayInstance2, new Object[]{0, num}), Charset.forName("UTF-8"));
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            throw new UnsupportedOperationException("Could not find char array in " + instance);
        }
    }

    public static boolean isPrimitiveWrapper(Object obj) {
        if (!(obj instanceof ClassInstance)) {
            return false;
        }
        return WRAPPER_TYPES.contains(((ClassInstance) obj).getClassObj().getClassName());
    }

    public static boolean isPrimitiveOrWrapperArray(Object obj) {
        if (!(obj instanceof ArrayInstance)) {
            return false;
        }
        ArrayInstance arrayInstance = (ArrayInstance) obj;
        if (arrayInstance.getArrayType() != Type.OBJECT) {
            return true;
        }
        return WRAPPER_TYPES.contains(arrayInstance.getClassObj().getClassName());
    }

    private static boolean isCharArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.CHAR;
    }

    private static boolean isByteArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.BYTE;
    }

    static List<ClassInstance.FieldValue> classInstanceValues(Instance instance) {
        return ((ClassInstance) instance).getValues();
    }

    static <T> T fieldValue(List<ClassInstance.FieldValue> list, String str) {
        for (ClassInstance.FieldValue next : list) {
            if (next.getField().getName().equals(str)) {
                return next.getValue();
            }
        }
        throw new IllegalArgumentException("Field " + str + " does not exists");
    }

    static boolean hasField(List<ClassInstance.FieldValue> list, String str) {
        for (ClassInstance.FieldValue field : list) {
            if (field.getField().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private HahaHelper() {
        throw new AssertionError();
    }
}
