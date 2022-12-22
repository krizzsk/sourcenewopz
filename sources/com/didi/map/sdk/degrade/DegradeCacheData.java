package com.didi.map.sdk.degrade;

import com.didi.map.sdk.navtracker.log.DLog;
import java.util.List;

public class DegradeCacheData {
    public int count;
    public long createTime;
    public long launch_near_time;
    public List<CrashDetail> list;
    public boolean tag;
    public long validTime;

    public void doLog() {
        DLog.m20199d("ccc", " degrade data: tag:" + this.tag + ",count" + this.count + ",validTime=" + this.validTime + ",createTime = " + this.createTime + ",launch_near_time =" + this.launch_near_time, new Object[0]);
        List<CrashDetail> list2 = this.list;
        if (list2 != null && list2.size() > 1) {
            for (CrashDetail next : this.list) {
                DLog.m20199d("ccc", "stack:----" + next.stack + ",time= " + next.time, new Object[0]);
            }
        }
    }
}
