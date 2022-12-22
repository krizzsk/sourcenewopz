package org.opencv.core;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class CvException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public CvException(String str) {
        super(str);
    }

    public String toString() {
        return "CvException [" + super.toString() + Const.jaRight;
    }
}
