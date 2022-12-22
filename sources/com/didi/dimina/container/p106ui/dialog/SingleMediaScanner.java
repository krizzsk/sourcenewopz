package com.didi.dimina.container.p106ui.dialog;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

/* renamed from: com.didi.dimina.container.ui.dialog.SingleMediaScanner */
public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    private final MediaScannerConnection f17572a;

    /* renamed from: b */
    private final String f17573b;

    /* renamed from: c */
    private final ScanListener f17574c;

    /* renamed from: com.didi.dimina.container.ui.dialog.SingleMediaScanner$ScanListener */
    public interface ScanListener {
        void onScanFinish();
    }

    public SingleMediaScanner(Context context, String str, ScanListener scanListener) {
        this.f17573b = str;
        this.f17574c = scanListener;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, this);
        this.f17572a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    public void onMediaScannerConnected() {
        this.f17572a.scanFile(this.f17573b, (String) null);
    }

    public void onScanCompleted(String str, Uri uri) {
        this.f17572a.disconnect();
        ScanListener scanListener = this.f17574c;
        if (scanListener != null) {
            scanListener.onScanFinish();
        }
    }
}
