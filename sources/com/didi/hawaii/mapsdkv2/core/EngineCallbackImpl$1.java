package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.utils.C9266IO;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class EngineCallbackImpl$1 implements Runnable {
    final /* synthetic */ C9183c this$0;
    final /* synthetic */ byte[] val$content;
    final /* synthetic */ String val$fileName;

    EngineCallbackImpl$1(C9183c cVar, String str, byte[] bArr) {
        this.this$0 = cVar;
        this.val$fileName = str;
        this.val$content = bArr;
    }

    public void run() {
        File file = new File(this.val$fileName + DefaultDiskStorage.FileType.TEMP);
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.createNewFile()) {
                    throw new IOException("Can't create " + file.getAbsolutePath());
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(this.val$content);
                C9266IO.safeClose(fileOutputStream2);
            } catch (FileNotFoundException e) {
                FileOutputStream fileOutputStream3 = fileOutputStream2;
                e = e;
                fileOutputStream = fileOutputStream3;
                e.printStackTrace();
                C9266IO.safeClose(fileOutputStream);
                file.renameTo(new File(this.val$fileName));
            } catch (IOException e2) {
                FileOutputStream fileOutputStream4 = fileOutputStream2;
                e = e2;
                fileOutputStream = fileOutputStream4;
                e.printStackTrace();
                C9266IO.safeClose(fileOutputStream);
                file.renameTo(new File(this.val$fileName));
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                C9266IO.safeClose(fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            C9266IO.safeClose(fileOutputStream);
            file.renameTo(new File(this.val$fileName));
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            C9266IO.safeClose(fileOutputStream);
            file.renameTo(new File(this.val$fileName));
        } catch (Throwable th2) {
            th = th2;
            C9266IO.safeClose(fileOutputStream);
            throw th;
        }
        file.renameTo(new File(this.val$fileName));
    }
}
