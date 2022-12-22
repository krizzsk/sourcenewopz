package com.didichuxing.alpha.lag;

import android.content.Context;
import com.didichuxing.alpha.fps.OmegaFPS;
import com.didichuxing.alpha.lag.internal.BlockInfo;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.LagRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.DataTrackUtil;
import java.util.Iterator;

public class OmegaLag {
    private static OmegaLag instance;
    private static BlockCanary mBlockCanary;
    private boolean lagChecking = false;

    private OmegaLag() {
    }

    public static synchronized OmegaLag getInstance() {
        OmegaLag omegaLag;
        synchronized (OmegaLag.class) {
            if (instance == null) {
                instance = new OmegaLag();
            }
            omegaLag = instance;
        }
        return omegaLag;
    }

    public void start(Context context) {
        if (!this.lagChecking) {
            this.lagChecking = true;
            BlockCanary install = BlockCanary.install(context, new OmegaBlockCaneryContext());
            mBlockCanary = install;
            install.start();
        }
    }

    public void stop() {
        BlockCanary blockCanary = mBlockCanary;
        if (blockCanary != null) {
            blockCanary.stop();
            mBlockCanary = null;
            this.lagChecking = false;
        }
    }

    public class OmegaBlockCaneryContext extends BlockCanaryContext {
        public OmegaBlockCaneryContext() {
        }

        public void onBlock(Context context, BlockInfo blockInfo) {
            LagRecord createLagRecord = RecordFactory.createLagRecord();
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_lag", OmegaConfig.UPPER_LIMIT_LAG_EVENT_PER_DAY);
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.LAG, createLagRecord.getRecordId(), isUpperLimitByDay);
            if (isUpperLimitByDay) {
                OmegaLag.this.stop();
                return;
            }
            createLagRecord.takeLogcat();
            createLagRecord.setCpuBusy(Boolean.valueOf(blockInfo.cpuBusy));
            createLagRecord.setCpuRate(blockInfo.cpuRateInfo);
            createLagRecord.setBlockTime(blockInfo.getTimeString());
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = blockInfo.threadStackEntries.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            createLagRecord.setErrorTrace(sb.toString());
            createLagRecord.setLatestFPS(OmegaFPS.getInstance().getLatestFPS());
            createLagRecord.setSystemRefreshRate(OmegaFPS.getInstance().getSystemRefreshRate());
            RecordStorage.save(createLagRecord);
            CommonUtil.addUpperLimitByDay("upper_limit_lag");
        }
    }

    public boolean isLagChecking() {
        return this.lagChecking;
    }
}
