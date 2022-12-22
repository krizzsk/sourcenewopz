package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.ObjectMirror */
public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    public boolean isObject() {
        return true;
    }

    /* renamed from: com.didi.dimina.v8.debug.mirror.ObjectMirror$PropertyKind */
    public enum PropertyKind {
        Named(1),
        Indexed(2);
        
        int index;

        private PropertyKind(int i) {
            this.index = i;
        }
    }

    public String toString() {
        return this.v8Object.toString();
    }

    ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            int length = v8Array2.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = v8Array2.getString(i2);
            }
            return strArr;
        } finally {
            v8Array.close();
            if (v8Array2 != null) {
                v8Array2.close();
            }
        }
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
            return new PropertiesArray(v8Array2);
        } finally {
            v8Array.close();
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.close();
            }
        }
    }
}
