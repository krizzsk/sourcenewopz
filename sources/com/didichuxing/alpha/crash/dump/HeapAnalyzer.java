package com.didichuxing.alpha.crash.dump;

import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.entrega.customer.app.constant.Const;
import com.didichuxing.alpha.crash.dump.LeakTraceElement;
import com.didichuxing.alpha.crash.dump.Reachability;
import com.didichuxing.alpha.crash.dump.ShortestPathFinder;
import com.squareup.haha.perflib.ArrayInstance;
import com.squareup.haha.perflib.ClassInstance;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Field;
import com.squareup.haha.perflib.HprofParser;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.RootType;
import com.squareup.haha.perflib.Snapshot;
import com.squareup.haha.perflib.Type;
import com.squareup.haha.perflib.p225io.MemoryMappedFileBuffer;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;

public class HeapAnalyzer {
    private static final String ANONYMOUS_CLASS_NAME_PATTERN = "^.+\\$\\d+$";
    public static final String HUAWEI = "HUAWEI";
    public static final String LENOVO = "LENOVO";

    /* renamed from: LG */
    public static final String f45570LG = "LGE";
    public static final String MEIZU = "Meizu";
    public static final String MOTOROLA = "motorola";
    public static final String NVIDIA = "NVIDIA";
    public static final String SAMSUNG = "samsung";
    public static final String VIVO = "vivo";
    private static final String keyedWeakReferenceName = "com.didichuxing.omega.sdk.leak.KeyedWeakReference";
    private final ExcludedRefs excludedRefs;
    private final List<Reachability.Inspector> reachabilityInspectors = new ArrayList();

    public HeapAnalyzer(ExcludedRefs excludedRefs2, List<Class<? extends Reachability.Inspector>> list) {
        this.excludedRefs = excludedRefs2;
        for (Class declaredConstructor : list) {
            try {
                this.reachabilityInspectors.add(declaredConstructor.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<AnalysisResult> checkForLeak(File file, boolean z) {
        long nanoTime = System.nanoTime();
        if (!file.exists()) {
            return null;
        }
        try {
            Snapshot parse = new HprofParser(new MemoryMappedFileBuffer(file)).parse();
            List<Instance> findLeakingReference = findLeakingReference(parse);
            if (findLeakingReference != null) {
                if (!findLeakingReference.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < findLeakingReference.size(); i++) {
                        arrayList.add(findLeakTrace(nanoTime, parse, findLeakingReference.get(i), z));
                    }
                    return arrayList;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private List<Instance> findLeakingReference(Snapshot snapshot) {
        ClassObj findClass = snapshot.findClass(keyedWeakReferenceName);
        if (findClass != null) {
            ArrayList arrayList = new ArrayList();
            for (Instance classInstanceValues : findClass.getInstancesList()) {
                List<ClassInstance.FieldValue> classInstanceValues2 = classInstanceValues(classInstanceValues);
                if (fieldValue(classInstanceValues2, "key") != null) {
                    arrayList.add((Instance) fieldValue(classInstanceValues2, "referent"));
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("Could not find the com.didichuxing.omega.sdk.leak.KeyedWeakReference class in the heap dump.");
    }

    private LeakTrace buildLeakTrace(LeakNode leakNode) {
        ArrayList arrayList = new ArrayList();
        for (LeakNode leakNode2 = new LeakNode((Exclusion) null, (Instance) null, leakNode, (LeakReference) null); leakNode2 != null; leakNode2 = leakNode2.parent) {
            LeakTraceElement buildLeakElement = buildLeakElement(leakNode2);
            if (buildLeakElement != null) {
                arrayList.add(0, buildLeakElement);
            }
        }
        return new LeakTrace(arrayList, computeExpectedReachability(arrayList));
    }

    private List<Reachability> computeExpectedReachability(List<LeakTraceElement> list) {
        Reachability reachability;
        int i = 1;
        int size = list.size() - 1;
        int i2 = 0;
        loop0:
        while (true) {
            if (i >= size) {
                break;
            }
            LeakTraceElement leakTraceElement = list.get(i);
            Iterator<Reachability.Inspector> it = this.reachabilityInspectors.iterator();
            while (true) {
                if (it.hasNext()) {
                    Reachability expectedReachability = it.next().expectedReachability(leakTraceElement);
                    if (expectedReachability != Reachability.REACHABLE) {
                        if (expectedReachability == Reachability.UNREACHABLE) {
                            size = i;
                            break loop0;
                        }
                    } else {
                        i2 = i;
                        break;
                    }
                } else {
                    break;
                }
            }
            i++;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 <= i2) {
                reachability = Reachability.REACHABLE;
            } else if (i3 >= size) {
                reachability = Reachability.UNREACHABLE;
            } else {
                reachability = Reachability.UNKNOWN;
            }
            arrayList.add(reachability);
        }
        return arrayList;
    }

    private LeakTraceElement buildLeakElement(LeakNode leakNode) {
        String str;
        LeakTraceElement.Holder holder;
        LeakTraceElement.Holder holder2;
        String str2 = null;
        if (leakNode.parent == null) {
            return null;
        }
        Instance instance = leakNode.parent.instance;
        if (instance instanceof RootObj) {
            return null;
        }
        List<LeakReference> describeFields = describeFields(instance);
        String className = getClassName(instance);
        ArrayList arrayList = new ArrayList();
        arrayList.add(className);
        String name = Object.class.getName();
        if (instance instanceof ClassInstance) {
            ClassObj classObj = instance.getClassObj();
            while (true) {
                classObj = classObj.getSuperClassObj();
                if (classObj.getClassName().equals(name)) {
                    break;
                }
                arrayList.add(classObj.getClassName());
            }
        }
        if (instance instanceof ClassObj) {
            holder2 = LeakTraceElement.Holder.CLASS;
        } else if (instance instanceof ArrayInstance) {
            holder2 = LeakTraceElement.Holder.ARRAY;
        } else {
            ClassObj classObj2 = instance.getClassObj();
            if (HahaHelper.extendsThread(classObj2)) {
                LeakTraceElement.Holder holder3 = LeakTraceElement.Holder.THREAD;
                str = "(named '" + HahaHelper.threadName(instance) + "')";
                holder = holder3;
                return new LeakTraceElement(leakNode.leakReference, holder, arrayList, str, leakNode.exclusion, describeFields);
            } else if (className.matches(ANONYMOUS_CLASS_NAME_PATTERN)) {
                String className2 = classObj2.getSuperClassObj().getClassName();
                if (name.equals(className2)) {
                    holder2 = LeakTraceElement.Holder.OBJECT;
                    try {
                        Class[] interfaces = Class.forName(classObj2.getClassName()).getInterfaces();
                        if (interfaces.length > 0) {
                            Class cls = interfaces[0];
                            str2 = "(anonymous implementation of " + cls.getName() + ")";
                        } else {
                            str2 = "(anonymous subclass of java.lang.Object)";
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                } else {
                    LeakTraceElement.Holder holder4 = LeakTraceElement.Holder.OBJECT;
                    str2 = "(anonymous subclass of " + className2 + ")";
                    holder2 = holder4;
                }
            } else {
                holder2 = LeakTraceElement.Holder.OBJECT;
            }
        }
        holder = holder2;
        str = str2;
        return new LeakTraceElement(leakNode.leakReference, holder, arrayList, str, leakNode.exclusion, describeFields);
    }

    private AnalysisResult findLeakTrace(long j, Snapshot snapshot, Instance instance, boolean z) {
        long j2;
        ShortestPathFinder.Result findPath = new ShortestPathFinder(this.excludedRefs).findPath(snapshot, instance);
        if (findPath.leakingNode == null) {
            return AnalysisResult.noLeak(since(j));
        }
        LeakTrace buildLeakTrace = buildLeakTrace(findPath.leakingNode);
        String className = instance.getClassObj().getClassName();
        if (z) {
            snapshot.computeDominators();
            Instance instance2 = findPath.leakingNode.instance;
            long totalRetainedSize = instance2.getTotalRetainedSize();
            if (Build.VERSION.SDK_INT <= 25) {
                totalRetainedSize += computeIgnoredBitmapRetainedSize(snapshot, instance2);
            }
            j2 = totalRetainedSize;
        } else {
            j2 = -1;
        }
        return AnalysisResult.leakDetected(findPath.excludingKnownLeaks, className, buildLeakTrace, j2, since(j));
    }

    static List<ClassInstance.FieldValue> classInstanceValues(Instance instance) {
        return ((ClassInstance) instance).getValues();
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

    private static boolean isCharArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.CHAR;
    }

    private static boolean isByteArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.BYTE;
    }

    private String getClassName(Instance instance) {
        if (instance instanceof ClassObj) {
            return ((ClassObj) instance).getClassName();
        }
        if (instance instanceof ArrayInstance) {
            return ((ArrayInstance) instance).getClassObj().getClassName();
        }
        return instance.getClassObj().getClassName();
    }

    private List<LeakReference> describeFields(Instance instance) {
        ArrayList arrayList = new ArrayList();
        if (instance instanceof ClassObj) {
            for (Map.Entry next : ((ClassObj) instance).getStaticFieldValues().entrySet()) {
                arrayList.add(new LeakReference(LeakTraceElement.Type.STATIC_FIELD, ((Field) next.getKey()).getName(), valueAsString(next.getValue())));
            }
        } else if (instance instanceof ArrayInstance) {
            ArrayInstance arrayInstance = (ArrayInstance) instance;
            if (arrayInstance.getArrayType() == Type.OBJECT) {
                Object[] values = arrayInstance.getValues();
                for (int i = 0; i < values.length; i++) {
                    arrayList.add(new LeakReference(LeakTraceElement.Type.ARRAY_ENTRY, Integer.toString(i), valueAsString(values[i])));
                }
            }
        } else {
            for (Map.Entry next2 : instance.getClassObj().getStaticFieldValues().entrySet()) {
                arrayList.add(new LeakReference(LeakTraceElement.Type.STATIC_FIELD, ((Field) next2.getKey()).getName(), valueAsString(next2.getValue())));
            }
            for (ClassInstance.FieldValue next3 : ((ClassInstance) instance).getValues()) {
                arrayList.add(new LeakReference(LeakTraceElement.Type.INSTANCE_FIELD, next3.getField().getName(), valueAsString(next3.getValue())));
            }
        }
        return arrayList;
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

    private long since(long j) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
    }

    private boolean isIgnoredDominator(Instance instance, Instance instance2) {
        boolean z = false;
        do {
            Instance immediateDominator = instance2.getImmediateDominator();
            if (!(immediateDominator instanceof RootObj) || ((RootObj) immediateDominator).getRootType() != RootType.UNKNOWN) {
                instance2 = immediateDominator;
            } else {
                instance2 = instance2.getNextInstanceToGcRoot();
                z = true;
            }
            if (instance2 == null) {
                return false;
            }
        } while (instance2 != instance);
        return z;
    }

    private long computeIgnoredBitmapRetainedSize(Snapshot snapshot, Instance instance) {
        ArrayInstance arrayInstance;
        long j = 0;
        for (Instance next : snapshot.findClass("android.graphics.Bitmap").getInstancesList()) {
            if (isIgnoredDominator(instance, next) && (arrayInstance = (ArrayInstance) fieldValue(classInstanceValues(next), "mBuffer")) != null) {
                long totalRetainedSize = arrayInstance.getTotalRetainedSize();
                long totalRetainedSize2 = next.getTotalRetainedSize();
                if (totalRetainedSize2 < totalRetainedSize) {
                    totalRetainedSize2 += totalRetainedSize;
                }
                j += totalRetainedSize2;
            }
        }
        return j;
    }
}
