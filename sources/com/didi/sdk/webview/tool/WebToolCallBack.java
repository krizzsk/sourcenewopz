package com.didi.sdk.webview.tool;

import com.didi.sharesdk.OneKeyShareModel;

public interface WebToolCallBack {
    void close();

    void refresh();

    void showShareView(OneKeyShareModel oneKeyShareModel);

    void webRedirect(WebViewToolModel webViewToolModel);
}
