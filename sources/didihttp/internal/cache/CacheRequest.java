package didihttp.internal.cache;

import java.io.IOException;
import okio.Sink;

public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
