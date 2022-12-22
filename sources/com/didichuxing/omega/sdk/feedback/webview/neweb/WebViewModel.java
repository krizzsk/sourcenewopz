package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.net.Uri;
import java.io.Serializable;

public class WebViewModel implements Serializable {
    public boolean canChangeWebViewTitle = true;
    public String title = "";
    public Uri uri;
    public String url = "";
}
