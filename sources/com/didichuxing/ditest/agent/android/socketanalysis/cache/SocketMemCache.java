package com.didichuxing.ditest.agent.android.socketanalysis.cache;

import com.didichuxing.ditest.agent.android.socketanalysis.config.StatusConfig;
import com.didichuxing.ditest.agent.android.socketanalysis.model.TransactionInfo;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SocketMemCache {
    public static TransactionInfo mSocketMemoryCache;
    private static SocketMemCache memCacheInstance;
    private final String keyDown = "down";
    private final String keyDownCount = "dc";
    private final String keySeqId = "seqid";
    private final String keyTime = "time";
    private final String keyTls = "tls";
    private final String keyType = "type";
    private final String keyUp = "up";
    private final String keyUpCount = "uc";
    private final String keyVer = "ver";

    private SocketMemCache() {
        mSocketMemoryCache = new TransactionInfo();
    }

    public static synchronized SocketMemCache getMemCacheInstance() {
        SocketMemCache socketMemCache;
        synchronized (SocketMemCache.class) {
            if (memCacheInstance == null) {
                memCacheInstance = new SocketMemCache();
            }
            socketMemCache = memCacheInstance;
        }
        return socketMemCache;
    }

    public void addEvent(Map<String, Object> map) {
        Map map2;
        if (!StatusConfig.isUpperLimitByDay()) {
            synchronized (mSocketMemoryCache) {
                try {
                    mSocketMemoryCache.seqIdList.add(map.get("seqid").toString());
                    mSocketMemoryCache.verList.add(map.get("ver").toString());
                    mSocketMemoryCache.tlsList.add(map.get("tls").toString());
                    ConcurrentHashMap<String, Object> concurrentHashMap = mSocketMemoryCache.data;
                    Object obj = concurrentHashMap.get("tf_" + map.get("type").toString());
                    if (obj == null) {
                        map2 = null;
                    } else {
                        map2 = JsonUtil.json2Map(obj.toString());
                    }
                    if (map2 == null) {
                        map2 = new HashMap();
                        map2.put("type", map.get("type"));
                        map2.put("up", map.get("up"));
                        map2.put("down", map.get("down"));
                        map2.put("time", map.get("time"));
                        if (map.get("up").toString().equals("0")) {
                            map2.put("dc", 1);
                            map2.put("uc", 0);
                        } else if (map.get("down").toString().equals("0")) {
                            map2.put("dc", 0);
                            map2.put("uc", 1);
                        }
                    } else {
                        map2.put("type", map.get("type"));
                        map2.put("up", Long.valueOf(Long.parseLong(map2.get("up").toString()) + Long.parseLong(map.get("up").toString())));
                        map2.put("down", Long.valueOf(Long.parseLong(map2.get("down").toString()) + Long.parseLong(map.get("down").toString())));
                        map2.put("time", Long.valueOf(Long.parseLong(map2.get("time").toString()) + Long.parseLong(map.get("time").toString())));
                        if (map.get("up").toString().equals("0")) {
                            map2.put("dc", Integer.valueOf(Integer.valueOf(map2.get("dc").toString()).intValue() + 1));
                        } else if (map.get("down").toString().equals("0")) {
                            map2.put("uc", Integer.valueOf(Integer.valueOf(map2.get("uc").toString()).intValue() + 1));
                        }
                    }
                    ConcurrentHashMap<String, Object> concurrentHashMap2 = mSocketMemoryCache.data;
                    concurrentHashMap2.put("tf_" + map.get("type").toString(), JsonUtil.map2Json(map2));
                } catch (ClassCastException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadEventImmediatelyByMemoryCache() {
        /*
            r2 = this;
            com.didichuxing.ditest.agent.android.socketanalysis.model.TransactionInfo r0 = mSocketMemoryCache
            monitor-enter(r0)
            boolean r1 = com.didichuxing.ditest.agent.android.socketanalysis.config.SocketConfig.SWITCH_SOCKET_TRANSACTION_STAT     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0020
            com.didichuxing.ditest.agent.android.socketanalysis.model.TransactionInfo r1 = mSocketMemoryCache     // Catch:{ all -> 0x0022 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0020
        L_0x0010:
            com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketMemCache$1 r1 = new com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketMemCache$1     // Catch:{ Exception -> 0x0019 }
            r1.<init>()     // Catch:{ Exception -> 0x0019 }
            r1.start()     // Catch:{ Exception -> 0x0019 }
            goto L_0x001e
        L_0x0019:
            java.lang.String r1 = "uploadEventImmediatelyByMemoryCache error"
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r1)     // Catch:{ all -> 0x0022 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketMemCache.uploadEventImmediatelyByMemoryCache():void");
    }
}
