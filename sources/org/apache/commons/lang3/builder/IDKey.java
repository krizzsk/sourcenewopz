package org.apache.commons.lang3.builder;

final class IDKey {

    /* renamed from: id */
    private final int f5624id;
    private final Object value;

    IDKey(Object obj) {
        this.f5624id = System.identityHashCode(obj);
        this.value = obj;
    }

    public int hashCode() {
        return this.f5624id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f5624id == iDKey.f5624id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }
}
