package com.didi.quicksilver.util;

import com.didi.quicksilver.ext.ErrnoException;
import com.didi.quicksilver.ext.StructStat;
import java.io.File;
import java.io.IOException;

/* renamed from: com.didi.quicksilver.util.Os */
public class C11471Os {
    public static StructStat stat(String str) throws ErrnoException {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new StructStat(file.length(), file.lastModified());
            }
            throw new ErrnoException(new IOException("File " + file + " is not exists"));
        } catch (Exception e) {
            throw new ErrnoException(e);
        }
    }
}
