package com.didi.global.globalgenerickit.template.misoperation;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import java.util.HashMap;

/* compiled from: MisOperationBinder */
class ViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ C8592a this$0;
    final /* synthetic */ String val$url;

    ViewHolder$1(C8592a aVar, String str) {
        this.this$0 = aVar;
        this.val$url = str;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.this$0.f22197a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("who", "card");
            this.this$0.f22197a.handleEvent("xpanel_button_ck", this.val$url, hashMap);
        }
    }
}
