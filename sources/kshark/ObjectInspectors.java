package kshark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kshark.FilteringLeakingObjectFinder;
import kshark.HeapObject;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R1\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, mo175978d2 = {"Lkshark/ObjectInspectors;", "", "Lkshark/ObjectInspector;", "(Ljava/lang/String;I)V", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "Lkotlin/ParameterName;", "name", "heapObject", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "KEYED_WEAK_REFERENCE", "CLASSLOADER", "CLASS", "ANONYMOUS_CLASS", "THREAD", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ObjectInspectors.kt */
public enum ObjectInspectors implements ObjectInspector {
    ;
    
    private static final String ANONYMOUS_CLASS_NAME_PATTERN = "^.+\\$\\d+$";
    /* access modifiers changed from: private */
    public static final Regex ANONYMOUS_CLASS_NAME_PATTERN_REGEX = null;
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final List<FilteringLeakingObjectFinder.LeakingObjectFilter> jdkLeakingObjectFilters = null;
    private final Function1<HeapObject, Boolean> leakingObjectFilter;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/ObjectInspectors$KEYED_WEAK_REFERENCE;", "Lkshark/ObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    static final class KEYED_WEAK_REFERENCE extends ObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        KEYED_WEAK_REFERENCE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            String str;
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            List<KeyedWeakReferenceMirror> findKeyedWeakReferences$shark = KeyedWeakReferenceFinder.INSTANCE.findKeyedWeakReferences$shark(objectReporter.getHeapObject().getGraph());
            long objectId = objectReporter.getHeapObject().getObjectId();
            for (KeyedWeakReferenceMirror keyedWeakReferenceMirror : findKeyedWeakReferences$shark) {
                if (keyedWeakReferenceMirror.getReferent().getValue() == objectId) {
                    Collection leakingReasons = objectReporter.getLeakingReasons();
                    if (keyedWeakReferenceMirror.getDescription().length() > 0) {
                        str = "ObjectWatcher was watching this because " + keyedWeakReferenceMirror.getDescription();
                    } else {
                        str = "ObjectWatcher was watching this";
                    }
                    leakingReasons.add(str);
                    objectReporter.getLabels().add("key = " + keyedWeakReferenceMirror.getKey());
                    if (keyedWeakReferenceMirror.getWatchDurationMillis() != null) {
                        objectReporter.getLabels().add("watchDurationMillis = " + keyedWeakReferenceMirror.getWatchDurationMillis());
                    }
                    if (keyedWeakReferenceMirror.getRetainedDurationMillis() != null) {
                        objectReporter.getLabels().add("retainedDurationMillis = " + keyedWeakReferenceMirror.getRetainedDurationMillis());
                    }
                }
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/ObjectInspectors$CLASSLOADER;", "Lkshark/ObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    static final class CLASSLOADER extends ObjectInspectors {
        CLASSLOADER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf((KClass<? extends Object>) C21490Reflection.getOrCreateKotlinClass(ClassLoader.class), (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) ObjectInspectors$CLASSLOADER$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/ObjectInspectors$CLASS;", "Lkshark/ObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    static final class CLASS extends ObjectInspectors {
        CLASS(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            if (objectReporter.getHeapObject() instanceof HeapObject.HeapClass) {
                objectReporter.getNotLeakingReasons().add("a class is never leaking");
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/ObjectInspectors$ANONYMOUS_CLASS;", "Lkshark/ObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    static final class ANONYMOUS_CLASS extends ObjectInspectors {
        ANONYMOUS_CLASS(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            String str;
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            HeapObject heapObject = objectReporter.getHeapObject();
            if (heapObject instanceof HeapObject.HeapInstance) {
                HeapObject.HeapClass instanceClass = ((HeapObject.HeapInstance) heapObject).getInstanceClass();
                if (ObjectInspectors.ANONYMOUS_CLASS_NAME_PATTERN_REGEX.matches(instanceClass.getName())) {
                    HeapObject.HeapClass superclass = instanceClass.getSuperclass();
                    if (superclass == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Intrinsics.areEqual((Object) superclass.getName(), (Object) "java.lang.Object")) {
                        try {
                            Class<?> cls = Class.forName(instanceClass.getName());
                            Intrinsics.checkExpressionValueIsNotNull(cls, "actualClass");
                            Class[] interfaces = cls.getInterfaces();
                            Collection labels = objectReporter.getLabels();
                            Intrinsics.checkExpressionValueIsNotNull(interfaces, "interfaces");
                            if (!(interfaces.length == 0)) {
                                Class cls2 = interfaces[0];
                                StringBuilder sb = new StringBuilder();
                                sb.append("Anonymous class implementing ");
                                Intrinsics.checkExpressionValueIsNotNull(cls2, "implementedInterface");
                                sb.append(cls2.getName());
                                str = sb.toString();
                            } else {
                                str = "Anonymous subclass of java.lang.Object";
                            }
                            labels.add(str);
                        } catch (ClassNotFoundException unused) {
                        }
                    } else {
                        objectReporter.getLabels().add("Anonymous subclass of " + superclass.getName());
                    }
                }
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/ObjectInspectors$THREAD;", "Lkshark/ObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    static final class THREAD extends ObjectInspectors {
        THREAD(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf((KClass<? extends Object>) C21490Reflection.getOrCreateKotlinClass(Thread.class), (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) ObjectInspectors$THREAD$inspect$1.INSTANCE);
        }
    }

    public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
        return this.leakingObjectFilter;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0013"}, mo175978d2 = {"Lkshark/ObjectInspectors$Companion;", "", "()V", "ANONYMOUS_CLASS_NAME_PATTERN", "", "ANONYMOUS_CLASS_NAME_PATTERN_REGEX", "Lkotlin/text/Regex;", "jdkDefaults", "", "Lkshark/ObjectInspector;", "getJdkDefaults", "()Ljava/util/List;", "jdkLeakingObjectFilters", "Lkshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "getJdkLeakingObjectFilters", "createLeakingObjectFilters", "inspectors", "", "Lkshark/ObjectInspectors;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: ObjectInspectors.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ObjectInspector> getJdkDefaults() {
            return ArraysKt.toList((T[]) ObjectInspectors.values());
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> getJdkLeakingObjectFilters() {
            return ObjectInspectors.jdkLeakingObjectFilters;
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> createLeakingObjectFilters(Set<? extends ObjectInspectors> set) {
            Intrinsics.checkParameterIsNotNull(set, "inspectors");
            Collection arrayList = new ArrayList();
            for (ObjectInspectors leakingObjectFilter$shark : set) {
                Function1<HeapObject, Boolean> leakingObjectFilter$shark2 = leakingObjectFilter$shark.getLeakingObjectFilter$shark();
                if (leakingObjectFilter$shark2 != null) {
                    arrayList.add(leakingObjectFilter$shark2);
                }
            }
            Iterable<Function1> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Function1 objectInspectors$Companion$createLeakingObjectFilters$2$1 : iterable) {
                arrayList2.add(new ObjectInspectors$Companion$createLeakingObjectFilters$2$1(objectInspectors$Companion$createLeakingObjectFilters$2$1));
            }
            return (List) arrayList2;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        ANONYMOUS_CLASS_NAME_PATTERN_REGEX = new Regex(ANONYMOUS_CLASS_NAME_PATTERN);
        Companion companion = Companion;
        EnumSet<E> allOf = EnumSet.allOf(ObjectInspectors.class);
        Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(ObjectInspectors::class.java)");
        jdkLeakingObjectFilters = companion.createLeakingObjectFilters(allOf);
    }
}
