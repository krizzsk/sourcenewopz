package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* renamed from: okhttp3.internal.cache2.a */
/* compiled from: FileOperator */
final class C2443a {

    /* renamed from: a */
    private final FileChannel f5314a;

    C2443a(FileChannel fileChannel) {
        this.f5314a = fileChannel;
    }

    /* renamed from: a */
    public void mo25152a(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.f5314a.transferFrom(buffer, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }

    /* renamed from: b */
    public void mo25153b(long j, Buffer buffer, long j2) throws IOException {
        if (j2 >= 0) {
            while (j2 > 0) {
                long transferTo = this.f5314a.transferTo(j, j2, buffer);
                j += transferTo;
                j2 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
