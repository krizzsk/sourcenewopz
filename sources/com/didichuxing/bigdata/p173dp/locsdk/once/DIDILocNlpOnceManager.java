package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.Context;
import com.didi.mapbizinterface.MapBizInterface;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.biz.BizManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocNlpOnceManager */
public class DIDILocNlpOnceManager {

    /* renamed from: a */
    private static volatile DIDILocNlpOnceManager f46063a;

    /* renamed from: b */
    private static Context f46064b;

    private DIDILocNlpOnceManager(Context context) {
        f46064b = context.getApplicationContext();
        BizManager.getIntance().init(context);
        MapBizInterface.getInstance().init(context);
        SystemUtil.init(context.getApplicationContext());
        DLog.m32737d("DIDILocationManager single instance constructed!!");
    }

    public static DIDILocNlpOnceManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        f46064b = context.getApplicationContext();
        if (f46063a == null) {
            synchronized (DIDILocNlpOnceManager.class) {
                if (f46063a == null) {
                    f46063a = new DIDILocNlpOnceManager(f46064b);
                }
            }
        }
        return f46063a;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam, int i) {
        if (i == 3) {
            return new SpliteDIDINLPOnceRequester(f46064b).request(dIDILocationListener, dIDILocationUpdateOnceParam);
        }
        return -1;
    }
}
