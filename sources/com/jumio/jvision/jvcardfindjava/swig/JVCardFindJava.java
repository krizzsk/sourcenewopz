package com.jumio.jvision.jvcardfindjava.swig;

public class JVCardFindJava {
    public static IntPoint ToOcrPoint(MinPoint2d minPoint2d) {
        return new IntPoint(JVCardFindJavaJNI.ToOcrPoint(MinPoint2d.getCPtr(minPoint2d), minPoint2d), true);
    }
}
