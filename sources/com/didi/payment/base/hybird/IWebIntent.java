package com.didi.payment.base.hybird;

import android.content.Intent;
import com.didi.payment.base.view.webview.WebModel;

public interface IWebIntent {
    Intent getIntent(WebModel webModel);
}
