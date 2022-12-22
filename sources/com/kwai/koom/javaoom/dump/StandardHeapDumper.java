package com.kwai.koom.javaoom.dump;

import android.os.Debug;
import java.io.IOException;

public class StandardHeapDumper implements HeapDumper {
    public boolean dump(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
