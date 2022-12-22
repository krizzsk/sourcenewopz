package com.didi.sdk.push;

import java.util.ArrayList;
import java.util.List;

class PushSelector {
    private static final String TAG = "PushSelector";
    private static PushSelector sInstance;
    private int nextPushItemIndex;
    private List<PushItem> pushItemList = new ArrayList();
    private PushItem selectedPushItem;

    private PushSelector() {
        loadPushItem();
        this.nextPushItemIndex = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadPushItem() {
        /*
            r8 = this;
            com.didi.sdk.push.SpiComponentManager r0 = com.didi.sdk.push.SpiComponentManager.getInstance()
            java.lang.Class<com.didi.sdk.push.ISetting> r1 = com.didi.sdk.push.ISetting.class
            java.lang.Object r0 = r0.getComponent(r1)
            com.didi.sdk.push.ISetting r0 = (com.didi.sdk.push.ISetting) r0
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getSettings()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
        L_0x0018:
            com.didi.sdk.push.DefaultSetting r0 = new com.didi.sdk.push.DefaultSetting
            r0.<init>()
            java.lang.String r0 = r0.getSettings()
        L_0x0021:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0028
            return
        L_0x0028:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f8 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r0 = "l"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x00f8 }
            r1 = 0
            r2 = 0
        L_0x0035:
            int r3 = r0.length()     // Catch:{ Exception -> 0x00f8 }
            if (r2 >= r3) goto L_0x00ef
            org.json.JSONObject r3 = r0.optJSONObject(r2)     // Catch:{ Exception -> 0x00f8 }
            if (r3 == 0) goto L_0x00eb
            com.didi.sdk.push.PushItem r4 = new com.didi.sdk.push.PushItem     // Catch:{ Exception -> 0x00f8 }
            r4.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "name"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setLibNameOrAddress(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "type"
            int r5 = r3.optInt(r5)     // Catch:{ Exception -> 0x00f8 }
            com.didi.sdk.push.PushItem$LoadType r5 = com.didi.sdk.push.PushItem.LoadType.valueOf((int) r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setLoadType(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "ver"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setVersion(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "supportJni2"
            boolean r5 = r3.optBoolean(r5, r1)     // Catch:{ Exception -> 0x00f8 }
            r4.setSupportJNIv2(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "tls"
            boolean r5 = r3.optBoolean(r5, r1)     // Catch:{ Exception -> 0x00f8 }
            r4.setTLSOpen(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "quic"
            boolean r5 = r3.optBoolean(r5, r1)     // Catch:{ Exception -> 0x00f8 }
            r4.setDQuicOpen(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "writeBufCheckRepeat"
            r6 = 5000(0x1388, double:2.4703E-320)
            long r5 = r3.optLong(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            r4.setWriteBufCheckRepeat(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "writeTimeout"
            r6 = 10000(0x2710, double:4.9407E-320)
            long r5 = r3.optLong(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            r4.setWriteTimeout(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "priority"
            int r5 = r3.optInt(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setPriority(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "routeType"
            int r5 = r3.optInt(r5)     // Catch:{ Exception -> 0x00f8 }
            com.didi.sdk.push.RouteType r5 = com.didi.sdk.push.RouteType.valueOf((int) r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setRouteType(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "heartBeatInterval"
            r6 = 5
            int r5 = r3.optInt(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            r4.setHeartBeatInterval(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "heartBeatRetryInterval"
            int r5 = r3.optInt(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            r4.setHeartBeatRetryInterval(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "port"
            int r5 = r3.optInt(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setPort(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "confVersion"
            int r5 = r3.optInt(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.setConfVersion(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "fluxMsgType"
            java.lang.String r6 = ""
            java.lang.String r3 = r3.optString(r5, r6)     // Catch:{ Exception -> 0x00f8 }
            r4.setFluxMsgType(r3)     // Catch:{ Exception -> 0x00f8 }
            java.util.List<com.didi.sdk.push.PushItem> r3 = r8.pushItemList     // Catch:{ Exception -> 0x00f8 }
            r3.add(r4)     // Catch:{ Exception -> 0x00f8 }
        L_0x00eb:
            int r2 = r2 + 1
            goto L_0x0035
        L_0x00ef:
            java.util.List<com.didi.sdk.push.PushItem> r0 = r8.pushItemList     // Catch:{ Exception -> 0x00f8 }
            java.util.Comparator r1 = java.util.Collections.reverseOrder()     // Catch:{ Exception -> 0x00f8 }
            java.util.Collections.sort(r0, r1)     // Catch:{ Exception -> 0x00f8 }
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.PushSelector.loadPushItem():void");
    }

    public static PushSelector getDefault() {
        if (sInstance == null) {
            synchronized (PushSelector.class) {
                if (sInstance == null) {
                    sInstance = new PushSelector();
                }
            }
        }
        return sInstance;
    }

    public PushItem next() {
        PushLog.m26280d(TAG, String.format("find pushItem, index = [%d]", new Object[]{Integer.valueOf(this.nextPushItemIndex)}));
        if (hasNext()) {
            List<PushItem> list = this.pushItemList;
            int i = this.nextPushItemIndex;
            this.nextPushItemIndex = i + 1;
            PushItem pushItem = list.get(i);
            this.selectedPushItem = pushItem;
            return pushItem;
        }
        this.selectedPushItem = null;
        return null;
    }

    public boolean hasNext() {
        return this.nextPushItemIndex < this.pushItemList.size();
    }

    public boolean supportJNIv2() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return false;
        }
        return pushItem.supportJNIv2();
    }

    public boolean isTLSOpen() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return false;
        }
        return pushItem.isTLSOpen();
    }

    public boolean isDQuicOpen() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return false;
        }
        return pushItem.isDQuicOpen();
    }

    public long getWriteBufCheckRepeat() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getWriteBufCheckRepeat();
    }

    public long getWriteTimeout() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getWriteTimeout();
    }

    public String getPushVer() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return "";
        }
        return pushItem.getVersion();
    }

    public RouteType getRouteType() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return null;
        }
        return pushItem.getRouteType();
    }

    public int getHeartBeatInterval() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getHeartBeatInterval();
    }

    public String getFluxMsgType() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return "";
        }
        return pushItem.getFluxMsgType();
    }

    public int getHeartBeatRetryInterval() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getHeartBeatRetryInterval();
    }

    public int getPort() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getPort();
    }

    public int getConfVersion() {
        PushItem pushItem = this.selectedPushItem;
        if (pushItem == null) {
            return 0;
        }
        return pushItem.getConfVersion();
    }
}
