package com.didi.map.sdk.nav.prediction;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SctxPredictionDataManager {

    /* renamed from: a */
    private static final String f28486a = "SctxPredictionDataManager";

    /* renamed from: b */
    private List<String> f28487b;

    /* renamed from: c */
    private int f28488c;

    /* renamed from: d */
    private int f28489d;

    /* renamed from: e */
    private long f28490e;

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SctxPredictionDataManager mInstance = new SctxPredictionDataManager();

        private SingletonHolder() {
        }
    }

    private SctxPredictionDataManager() {
        this.f28487b = new ArrayList();
    }

    public static SctxPredictionDataManager getInstance() {
        return SingletonHolder.mInstance;
    }

    public void insertData(SctxPredictionOmegaData sctxPredictionOmegaData) {
        String str;
        if (sctxPredictionOmegaData == null) {
            return;
        }
        if (sctxPredictionOmegaData.timestamp <= 0 || sctxPredictionOmegaData.timestamp != this.f28490e) {
            this.f28490e = sctxPredictionOmegaData.timestamp;
            this.f28488c++;
            if (sctxPredictionOmegaData.isPredicted()) {
                str = sctxPredictionOmegaData.getOutput();
                this.f28487b.add(str);
                this.f28489d++;
            } else {
                str = " ";
            }
            DLog.m7384d(f28486a, "预判埋点-插入数据, data:%s, mTotalCount:%d, mMockCount:%d", str, Integer.valueOf(this.f28488c), Integer.valueOf(this.f28489d));
            return;
        }
        DLog.m7384d(f28486a, "预判埋点-插入数据，但时间戳相同，过滤这条", new Object[0]);
    }

    public void doOmega(String str) {
        if (!this.f28487b.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("total_point", Integer.valueOf(this.f28488c));
            hashMap.put("mock_point", Integer.valueOf(this.f28489d));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Const.jaLeft);
            if (!this.f28487b.isEmpty()) {
                for (int i = 0; i < this.f28487b.size(); i++) {
                    stringBuffer.append(this.f28487b.get(i));
                    if (i < this.f28487b.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
            }
            stringBuffer.append(Const.jaRight);
            hashMap.put("list", stringBuffer.toString());
            if (!TextUtils.isEmpty(PlatInfo.getInstance().getDriverPhoneNumber())) {
                hashMap.put("role", "driver");
            } else {
                hashMap.put("role", "passenger");
            }
            OmegaSDKAdapter.trackEvent("globalmap_pax_car_trend", "", hashMap);
            DLog.m7384d(f28486a, "预判埋点-上报, 列表个数:%d, mTotalCount:%d, mMockCount:%d", Integer.valueOf(this.f28487b.size()), Integer.valueOf(this.f28488c), Integer.valueOf(this.f28489d));
            clearData();
        }
    }

    public void clearData() {
        this.f28487b.clear();
        this.f28489d = 0;
        this.f28488c = 0;
    }
}
