package didihttp.internal.cache2;

import android.support.p003v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* renamed from: didihttp.internal.cache2.a */
/* compiled from: FileOperator */
final class C20756a {

    /* renamed from: a */
    private static final int f56642a = 8192;

    /* renamed from: b */
    private final byte[] f56643b;

    /* renamed from: c */
    private final ByteBuffer f56644c;

    /* renamed from: d */
    private final FileChannel f56645d;

    public C20756a(FileChannel fileChannel) {
        byte[] bArr = new byte[8192];
        this.f56643b = bArr;
        this.f56644c = ByteBuffer.wrap(bArr);
        this.f56645d = fileChannel;
    }

    /* renamed from: a */
    public void mo170002a(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            try {
                int min = (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2);
                buffer.read(this.f56643b, 0, min);
                this.f56644c.limit(min);
                do {
                    j += (long) this.f56645d.write(this.f56644c, j);
                } while (this.f56644c.hasRemaining());
                j2 -= (long) min;
            } finally {
                this.f56644c.clear();
            }
        }
    }

    /* renamed from: b */
    public void mo170003b(long j, Buffer buffer, long j2) throws IOException {
        if (j2 >= 0) {
            while (j2 > 0) {
                try {
                    this.f56644c.limit((int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2));
                    if (this.f56645d.read(this.f56644c, j) != -1) {
                        int position = this.f56644c.position();
                        buffer.write(this.f56643b, 0, position);
                        long j3 = (long) position;
                        j += j3;
                        j2 -= j3;
                    } else {
                        throw new EOFException();
                    }
                } finally {
                    this.f56644c.clear();
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
