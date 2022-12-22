package kshark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kshark.FilteringLeakingObjectFinder;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0003R1\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, mo175978d2 = {"Lkshark/AndroidObjectInspectors;", "", "Lkshark/ObjectInspector;", "(Ljava/lang/String;I)V", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "Lkotlin/ParameterName;", "name", "heapObject", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "VIEW", "EDITOR", "ACTIVITY", "CONTEXT_WRAPPER", "DIALOG", "APPLICATION", "INPUT_METHOD_MANAGER", "FRAGMENT", "SUPPORT_FRAGMENT", "ANDROIDX_FRAGMENT", "MESSAGE_QUEUE", "MORTAR_PRESENTER", "MORTAR_SCOPE", "COORDINATOR", "MAIN_THREAD", "VIEW_ROOT_IMPL", "WINDOW", "TOAST", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
public enum AndroidObjectInspectors implements ObjectInspector {
    ;
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final List<FilteringLeakingObjectFinder.LeakingObjectFilter> appLeakingObjectFilters = null;
    private final Function1<HeapObject, Boolean> leakingObjectFilter;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$VIEW;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class VIEW extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        VIEW(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$VIEW$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.view.View", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$VIEW$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$EDITOR;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class EDITOR extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        EDITOR(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$EDITOR$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.widget.Editor", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$EDITOR$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$ACTIVITY;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class ACTIVITY extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        ACTIVITY(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$ACTIVITY$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.app.Activity", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$ACTIVITY$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$CONTEXT_WRAPPER;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class CONTEXT_WRAPPER extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        CONTEXT_WRAPPER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$CONTEXT_WRAPPER$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.content.ContextWrapper", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$CONTEXT_WRAPPER$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$DIALOG;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class DIALOG extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        DIALOG(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$DIALOG$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.app.Dialog", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$DIALOG$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$APPLICATION;", "Lkshark/AndroidObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class APPLICATION extends AndroidObjectInspectors {
        APPLICATION(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.app.Application", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$APPLICATION$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$INPUT_METHOD_MANAGER;", "Lkshark/AndroidObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class INPUT_METHOD_MANAGER extends AndroidObjectInspectors {
        INPUT_METHOD_MANAGER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.view.inputmethod.InputMethodManager", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$INPUT_METHOD_MANAGER$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$FRAGMENT;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class FRAGMENT extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        FRAGMENT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$FRAGMENT$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.app.Fragment", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$FRAGMENT$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$SUPPORT_FRAGMENT;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class SUPPORT_FRAGMENT extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        SUPPORT_FRAGMENT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$SUPPORT_FRAGMENT$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("androidx.fragment.app.Fragment", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$SUPPORT_FRAGMENT$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$ANDROIDX_FRAGMENT;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class ANDROIDX_FRAGMENT extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        ANDROIDX_FRAGMENT(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("androidx.fragment.app.Fragment", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$ANDROIDX_FRAGMENT$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$MESSAGE_QUEUE;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class MESSAGE_QUEUE extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        MESSAGE_QUEUE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$MESSAGE_QUEUE$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.os.MessageQueue", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$MESSAGE_QUEUE$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$MORTAR_PRESENTER;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class MORTAR_PRESENTER extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        MORTAR_PRESENTER(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$MORTAR_PRESENTER$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("mortar.Presenter", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$MORTAR_PRESENTER$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$MORTAR_SCOPE;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class MORTAR_SCOPE extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        MORTAR_SCOPE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$MORTAR_SCOPE$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("mortar.MortarScope", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$MORTAR_SCOPE$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$COORDINATOR;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class COORDINATOR extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        COORDINATOR(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$COORDINATOR$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("com.squareup.coordinators.Coordinator", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$COORDINATOR$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$MAIN_THREAD;", "Lkshark/AndroidObjectInspectors;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class MAIN_THREAD extends AndroidObjectInspectors {
        MAIN_THREAD(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf((KClass<? extends Object>) C21490Reflection.getOrCreateKotlinClass(Thread.class), (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$MAIN_THREAD$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$VIEW_ROOT_IMPL;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class VIEW_ROOT_IMPL extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        VIEW_ROOT_IMPL(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$VIEW_ROOT_IMPL$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.view.ViewRootImpl", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$VIEW_ROOT_IMPL$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$WINDOW;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class WINDOW extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        WINDOW(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$WINDOW$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.view.Window", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$WINDOW$inspect$1.INSTANCE);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$TOAST;", "Lkshark/AndroidObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lkshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    static final class TOAST extends AndroidObjectInspectors {
        private final Function1<HeapObject, Boolean> leakingObjectFilter;

        TOAST(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.leakingObjectFilter = AndroidObjectInspectors$TOAST$leakingObjectFilter$1.INSTANCE;
        }

        public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
            return this.leakingObjectFilter;
        }

        public void inspect(ObjectReporter objectReporter) {
            Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
            objectReporter.whenInstanceOf("android.widget.Toast", (Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit>) AndroidObjectInspectors$TOAST$inspect$1.INSTANCE);
        }
    }

    public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark() {
        return this.leakingObjectFilter;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000f"}, mo175978d2 = {"Lkshark/AndroidObjectInspectors$Companion;", "", "()V", "appDefaults", "", "Lkshark/ObjectInspector;", "getAppDefaults", "()Ljava/util/List;", "appLeakingObjectFilters", "Lkshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "getAppLeakingObjectFilters", "createLeakingObjectFilters", "inspectors", "", "Lkshark/AndroidObjectInspectors;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AndroidObjectInspectors.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ObjectInspector> getAppDefaults() {
            return CollectionsKt.plus(ObjectInspectors.Companion.getJdkDefaults(), (T[]) AndroidObjectInspectors.values());
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> getAppLeakingObjectFilters() {
            return AndroidObjectInspectors.appLeakingObjectFilters;
        }

        public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> createLeakingObjectFilters(Set<? extends AndroidObjectInspectors> set) {
            Intrinsics.checkParameterIsNotNull(set, "inspectors");
            Collection arrayList = new ArrayList();
            for (AndroidObjectInspectors leakingObjectFilter$shark : set) {
                Function1<HeapObject, Boolean> leakingObjectFilter$shark2 = leakingObjectFilter$shark.getLeakingObjectFilter$shark();
                if (leakingObjectFilter$shark2 != null) {
                    arrayList.add(leakingObjectFilter$shark2);
                }
            }
            Iterable<Function1> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Function1 androidObjectInspectors$Companion$createLeakingObjectFilters$2$1 : iterable) {
                arrayList2.add(new AndroidObjectInspectors$Companion$createLeakingObjectFilters$2$1(androidObjectInspectors$Companion$createLeakingObjectFilters$2$1));
            }
            return (List) arrayList2;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        Companion companion = Companion;
        EnumSet<E> allOf = EnumSet.allOf(AndroidObjectInspectors.class);
        Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(AndroidObjectInspectors::class.java)");
        appLeakingObjectFilters = CollectionsKt.plus(ObjectInspectors.Companion.getJdkLeakingObjectFilters(), companion.createLeakingObjectFilters(allOf));
    }
}
