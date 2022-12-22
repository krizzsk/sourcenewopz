package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import org.osgi.framework.VersionRange;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Handle */
public final class Handle {
    final String desc;
    final boolean itf;
    final String name;
    final String owner;
    final int tag;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Handle(int i, String str, String str2, String str3) {
        this(i, str, str2, str3, i == 9);
    }

    public Handle(int i, String str, String str2, String str3, boolean z) {
        this.tag = i;
        this.owner = str;
        this.name = str2;
        this.desc = str3;
        this.itf = z;
    }

    public int getTag() {
        return this.tag;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isInterface() {
        return this.itf;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        if (this.tag != handle.tag || this.itf != handle.itf || !this.owner.equals(handle.owner) || !this.name.equals(handle.name) || !this.desc.equals(handle.desc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.tag + (this.itf ? 64 : 0) + (this.owner.hashCode() * this.name.hashCode() * this.desc.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.owner);
        sb.append('.');
        sb.append(this.name);
        sb.append(this.desc);
        sb.append(" (");
        sb.append(this.tag);
        sb.append(this.itf ? " itf" : "");
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }
}
