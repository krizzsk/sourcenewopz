package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.SourceLocation;

class SourceLocationImpl implements SourceLocation {
    String fileName;
    int line;
    Class withinType;

    public int getColumn() {
        return -1;
    }

    SourceLocationImpl(Class cls, String str, int i) {
        this.withinType = cls;
        this.fileName = str;
        this.line = i;
    }

    public Class getWithinType() {
        return this.withinType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLine() {
        return this.line;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getFileName());
        stringBuffer.append(":");
        stringBuffer.append(getLine());
        return stringBuffer.toString();
    }
}
