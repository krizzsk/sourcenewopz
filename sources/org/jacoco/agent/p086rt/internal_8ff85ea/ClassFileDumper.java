package org.jacoco.agent.p086rt.internal_8ff85ea;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.data.CRC64;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.ClassFileDumper */
class ClassFileDumper {
    private final File location;

    ClassFileDumper(String str) {
        if (str == null) {
            this.location = null;
        } else {
            this.location = new File(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void dump(String str, byte[] bArr) throws IOException {
        File file;
        if (this.location != null) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf != -1) {
                file = new File(this.location, str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } else {
                file = this.location;
            }
            file.mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, String.format("%s.%016x.class", new Object[]{str, Long.valueOf(CRC64.checksum(bArr))})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        }
    }
}
