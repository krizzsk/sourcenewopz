package com.didi.sdk.idfa;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.p154ms.p155ad.IAdOperation;

public class IDFAManager {

    /* renamed from: a */
    private static final String f36427a = "IDFAManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f36428b;

    public interface onIDFAChangeListener {
        void onIDFAChanged(String str);
    }

    public static synchronized String getIdfa(final Context context, final onIDFAChangeListener onidfachangelistener) {
        synchronized (IDFAManager.class) {
            if (context == null) {
                return "";
            }
            if (TextUtils.isEmpty(f36428b)) {
                new AsyncTask<Context, Void, String>() {
                    /* access modifiers changed from: protected */
                    public String doInBackground(Context... contextArr) {
                        IAdOperation iAdOperation = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.GMS);
                        if (iAdOperation != null) {
                            String advertisingId = iAdOperation.getAdvertisingId(context);
                            LogUtil.m26099i(IDFAManager.f36427a, "doInBackground : gmsOperation is load, idfa = " + advertisingId);
                            return advertisingId;
                        }
                        IAdOperation iAdOperation2 = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.HMS);
                        if (iAdOperation2 != null) {
                            String advertisingId2 = iAdOperation2.getAdvertisingId(context);
                            LogUtil.m26099i(IDFAManager.f36427a, "doInBackground : hmsOperation is load, idfa = " + advertisingId2);
                            return advertisingId2;
                        }
                        LogUtil.m26099i(IDFAManager.f36427a, "doInBackground : no IADOperation is load, idfa = " + null);
                        return "";
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(String str) {
                        super.onPostExecute(str);
                        String unused = IDFAManager.f36428b = str;
                        if (IDFAManager.f36428b == null) {
                            String unused2 = IDFAManager.f36428b = "";
                        }
                        onIDFAChangeListener onidfachangelistener = onidfachangelistener;
                        if (onidfachangelistener != null) {
                            onidfachangelistener.onIDFAChanged(IDFAManager.f36428b);
                        }
                    }
                }.execute(new Context[]{context});
            }
            String str = f36428b;
            return str;
        }
    }

    public static synchronized String getIdfa(Context context) {
        String idfa;
        synchronized (IDFAManager.class) {
            idfa = getIdfa(context, (onIDFAChangeListener) null);
        }
        return idfa;
    }
}
