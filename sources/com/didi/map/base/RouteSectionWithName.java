package com.didi.map.base;

import java.util.Arrays;

public class RouteSectionWithName {
    public int color;
    public int endNum;
    public byte[] roadName;
    public int startNum;
    public int type;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("startNum = ");
        sb.append(this.startNum);
        sb.append(",endNum = ");
        sb.append(this.endNum);
        sb.append(",roadName size = ");
        byte[] bArr = this.roadName;
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : "0");
        sb.append(" ,color: ");
        sb.append(this.color);
        sb.append(",type: ");
        sb.append(this.type);
        return sb.toString();
    }

    public int hashCode() {
        return this.startNum + this.endNum + this.color + this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RouteSectionWithName)) {
            return false;
        }
        RouteSectionWithName routeSectionWithName = (RouteSectionWithName) obj;
        if (routeSectionWithName.startNum == this.startNum && routeSectionWithName.endNum == this.endNum && routeSectionWithName.color == this.color && routeSectionWithName.type == this.type && Arrays.equals(routeSectionWithName.roadName, this.roadName)) {
            return true;
        }
        return false;
    }
}
