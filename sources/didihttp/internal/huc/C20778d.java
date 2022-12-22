package didihttp.internal.huc;

import android.support.p003v4.media.session.PlaybackStateCompat;
import didihttp.internal.http.UnrepeatableRequestBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

/* renamed from: didihttp.internal.huc.d */
/* compiled from: StreamedRequestBody */
final class C20778d extends C20777c implements UnrepeatableRequestBody {

    /* renamed from: a */
    private final Pipe f56871a;

    C20778d(long j) {
        Pipe pipe = new Pipe(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        this.f56871a = pipe;
        mo170309a(Okio.buffer(pipe.sink()), j);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.f56871a.source().read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
