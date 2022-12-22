package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.xcard.ICardListener;
import java.util.HashMap;

public class ResCardListener implements ICardListener {
    private Context mContext;

    public ResCardListener(Context context) {
        this.mContext = context;
    }

    public boolean handleEvent(String str, HashMap<String, Object> hashMap) {
        Object obj;
        if (!"click".equals(str) || (obj = hashMap.get("url")) == null) {
            return true;
        }
        LogcatUtil.m35796i("ResCardListener", "url=" + obj.toString());
        if (!(obj instanceof String)) {
            return true;
        }
        DRouter.build((String) obj).start(this.mContext);
        return true;
    }
}
