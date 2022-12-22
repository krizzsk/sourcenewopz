package com.google.firebase.installations;

import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

class CrossProcessLock {
    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[SYNTHETIC, Splitter:B:15:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[SYNTHETIC, Splitter:B:19:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.installations.CrossProcessLock acquire(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            java.io.File r7 = r7.getFilesDir()     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            r1.<init>(r7, r8)     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            java.lang.String r8 = "rw"
            r7.<init>(r1, r8)     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            java.nio.channels.FileChannel r7 = r7.getChannel()     // Catch:{ IOException -> 0x0030, Error -> 0x002e, OverlappingFileLockException -> 0x002c }
            java.nio.channels.FileLock r8 = r7.lock()     // Catch:{ IOException -> 0x0029, Error -> 0x0027, OverlappingFileLockException -> 0x0025 }
            com.google.firebase.installations.CrossProcessLock r1 = new com.google.firebase.installations.CrossProcessLock     // Catch:{ IOException -> 0x0023, Error -> 0x0021, OverlappingFileLockException -> 0x001f }
            r1.<init>(r7, r8)     // Catch:{ IOException -> 0x0023, Error -> 0x0021, OverlappingFileLockException -> 0x001f }
            return r1
        L_0x001f:
            r1 = move-exception
            goto L_0x0033
        L_0x0021:
            r1 = move-exception
            goto L_0x0033
        L_0x0023:
            r1 = move-exception
            goto L_0x0033
        L_0x0025:
            r1 = move-exception
            goto L_0x002a
        L_0x0027:
            r1 = move-exception
            goto L_0x002a
        L_0x0029:
            r1 = move-exception
        L_0x002a:
            r8 = r0
            goto L_0x0033
        L_0x002c:
            r1 = move-exception
            goto L_0x0031
        L_0x002e:
            r1 = move-exception
            goto L_0x0031
        L_0x0030:
            r1 = move-exception
        L_0x0031:
            r7 = r0
            r8 = r7
        L_0x0033:
            r4 = r1
            r1 = 6
            r6 = 62
            java.lang.String r2 = "CrossProcessLock"
            java.lang.String r3 = "encountered error while creating and acquiring the lock, ignoring"
            java.lang.String r5 = "com.google.firebase.installations.CrossProcessLock"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0047
            r8.release()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0047
        L_0x0046:
        L_0x0047:
            if (r7 == 0) goto L_0x004c
            r7.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.CrossProcessLock.acquire(android.content.Context, java.lang.String):com.google.firebase.installations.CrossProcessLock");
    }

    /* access modifiers changed from: package-private */
    public void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException e) {
            SystemUtils.log(6, TAG, "encountered error while releasing, ignoring", e, "com.google.firebase.installations.CrossProcessLock", 91);
        }
    }
}
