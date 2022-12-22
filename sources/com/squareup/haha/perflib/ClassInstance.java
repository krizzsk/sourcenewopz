package com.squareup.haha.perflib;

import java.util.ArrayList;
import java.util.List;

public class ClassInstance extends Instance {
    private final long mValuesOffset;

    public ClassInstance(long j, StackTrace stackTrace, long j2) {
        super(j, stackTrace);
        this.mValuesOffset = j2;
    }

    /* access modifiers changed from: package-private */
    public List<FieldValue> getFields(String str) {
        ArrayList arrayList = new ArrayList();
        for (FieldValue next : getValues()) {
            if (next.getField().getName().equals(str)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<FieldValue> getValues() {
        ArrayList arrayList = new ArrayList();
        getBuffer().setPosition(this.mValuesOffset);
        for (ClassObj classObj = getClassObj(); classObj != null; classObj = classObj.getSuperClassObj()) {
            for (Field field : classObj.getFields()) {
                arrayList.add(new FieldValue(field, readValue(field.getType())));
            }
        }
        return arrayList;
    }

    public final void accept(Visitor visitor) {
        visitor.visitClassInstance(this);
        for (FieldValue next : getValues()) {
            if (next.getValue() instanceof Instance) {
                if (!this.mReferencesAdded) {
                    ((Instance) next.getValue()).addReference(next.getField(), this);
                }
                visitor.visitLater(this, (Instance) next.getValue());
            }
        }
        this.mReferencesAdded = true;
    }

    public boolean getIsSoftReference() {
        return getClassObj().getIsSoftReference();
    }

    public final String toString() {
        return String.format("%s@%d (0x%x)", new Object[]{getClassObj().getClassName(), Long.valueOf(getUniqueId()), Long.valueOf(getUniqueId())});
    }

    public static class FieldValue {
        private Field mField;
        private Object mValue;

        public FieldValue(Field field, Object obj) {
            this.mField = field;
            this.mValue = obj;
        }

        public Field getField() {
            return this.mField;
        }

        public Object getValue() {
            return this.mValue;
        }
    }
}
