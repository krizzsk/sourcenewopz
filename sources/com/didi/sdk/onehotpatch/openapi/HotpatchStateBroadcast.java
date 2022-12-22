package com.didi.sdk.onehotpatch.openapi;

import android.content.Context;
import android.content.Intent;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class HotpatchStateBroadcast {
    public static void sendPatchDownloadState(Context context, String str, int i, String str2) {
        try {
            Logger.info("--send--event: " + str + " state: " + i, new Object[0]);
            Intent intent = new Intent();
            intent.setPackage(WsgSecInfo.packageName(context));
            intent.setAction(HotpatchStateConst.HOTPATCH_STATE_BROADCAST_ACTION);
            intent.putExtra("event", str);
            intent.putExtra("state", i);
            intent.putExtra(HotpatchStateConst.EXT, str2);
            context.sendStickyBroadcast(intent);
        } catch (Exception unused) {
            Logger.info("发送patch相关状态的广播 失败", new Object[0]);
        }
    }
}
