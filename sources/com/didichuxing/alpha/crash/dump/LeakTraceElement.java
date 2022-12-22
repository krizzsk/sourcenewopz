package com.didichuxing.alpha.crash.dump;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class LeakTraceElement implements Serializable {
    public final List<String> classHierarchy;
    public final String className;
    public final Exclusion exclusion;
    public final String extra;
    public final List<LeakReference> fieldReferences;
    @Deprecated
    public final List<String> fields;
    public final Holder holder;
    public final LeakReference reference;
    @Deprecated
    public final String referenceName;
    @Deprecated
    public final Type type;

    public enum Holder {
        OBJECT,
        CLASS,
        THREAD,
        ARRAY
    }

    public enum Type {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    LeakTraceElement(LeakReference leakReference, Holder holder2, List<String> list, String str, Exclusion exclusion2, List<LeakReference> list2) {
        String str2;
        this.reference = leakReference;
        Type type2 = null;
        if (leakReference == null) {
            str2 = null;
        } else {
            str2 = leakReference.getDisplayName();
        }
        this.referenceName = str2;
        this.type = leakReference != null ? leakReference.type : type2;
        this.holder = holder2;
        this.classHierarchy = Collections.unmodifiableList(new ArrayList(list));
        this.className = list.get(0);
        this.extra = str;
        this.exclusion = exclusion2;
        this.fieldReferences = Collections.unmodifiableList(new ArrayList(list2));
        ArrayList arrayList = new ArrayList();
        for (LeakReference leakReference2 : list2) {
            arrayList.add(leakReference2.toString());
        }
        this.fields = Collections.unmodifiableList(arrayList);
    }

    public String getFieldReferenceValue(String str) {
        for (LeakReference next : this.fieldReferences) {
            if (next.name.equals(str)) {
                return next.value;
            }
        }
        return null;
    }

    public boolean isInstanceOf(Class<?> cls) {
        return isInstanceOf(cls.getName());
    }

    public boolean isInstanceOf(String str) {
        for (String equals : this.classHierarchy) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String getSimpleClassName() {
        int lastIndexOf = this.className.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return this.className;
        }
        return this.className.substring(lastIndexOf + 1);
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean z) {
        LeakReference leakReference = this.reference;
        String str = (leakReference == null || leakReference.type != Type.STATIC_FIELD) ? "" : "static ";
        if (this.holder == Holder.ARRAY || this.holder == Holder.THREAD) {
            str = str + this.holder.name().toLowerCase(Locale.US) + " ";
        }
        String str2 = str + getSimpleClassName();
        LeakReference leakReference2 = this.reference;
        if (leakReference2 != null) {
            String displayName = leakReference2.getDisplayName();
            if (z) {
                displayName = "!(" + displayName + ")!";
            }
            str2 = str2 + "." + displayName;
        }
        if (this.extra != null) {
            str2 = str2 + " " + this.extra;
        }
        if (this.exclusion == null) {
            return str2;
        }
        return str2 + " , matching exclusion " + this.exclusion.matching;
    }

    public String toDetailedString() {
        String str;
        if (this.holder == Holder.ARRAY) {
            str = "* Array of";
        } else {
            str = this.holder == Holder.CLASS ? "* Class" : "* Instance of";
        }
        String str2 = str + " " + this.className + "\n";
        for (LeakReference leakReference : this.fieldReferences) {
            str2 = str2 + "|   " + leakReference + "\n";
        }
        return str2;
    }
}
