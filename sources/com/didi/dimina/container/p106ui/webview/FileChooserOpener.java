package com.didi.dimina.container.p106ui.webview;

import android.net.Uri;
import com.didi.dimina.container.webengine.WebViewEngine;

/* renamed from: com.didi.dimina.container.ui.webview.FileChooserOpener */
public interface FileChooserOpener {
    void openFileChooser(WebViewEngine.WebViewEngineValueCallback<Uri[]> webViewEngineValueCallback, FileChooserParams fileChooserParams);
}
