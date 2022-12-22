package com.didi.onehybrid.devmode;

import com.didi.onehybrid.devmode.adapter.CacheDetailListAdapter;
import com.didi.onehybrid.jsbridge.InvokeMessage;
import com.didi.onehybrid.util.C10393Util;
import com.didi.onehybrid.util.MD5Util;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FusionRuntimeInfo implements Serializable {
    private Map<String, BridgeInfo> bridgeInfoMap = new HashMap();
    private long mPageStartTime;
    private RenderInfo mRenderInfo = new RenderInfo();
    private boolean needRecord = false;

    public static class BridgeInfo implements Serializable {
        public String args;
        public String bridgeUrl;
        public String bridgeVersion;
        public String callbackResult;
        public String errMsg;
        public String functionName;
        public boolean isRejected = false;
        public String moduleName;
    }

    public void switchOn() {
        this.needRecord = true;
    }

    public RenderInfo getRenderInfo() {
        return this.mRenderInfo;
    }

    public void recordReqUrl(String str) {
        if (this.needRecord) {
            this.mRenderInfo.reqUrl = str;
        }
    }

    public void recordPageStartTime(long j) {
        if (this.needRecord) {
            this.mPageStartTime = j;
        }
    }

    public void recordPageEndTime(long j) {
        if (this.needRecord) {
            this.mRenderInfo.totalTime = j - this.mPageStartTime;
        }
    }

    public void addFileCacheUrl(String str) {
        if (this.needRecord) {
            this.mRenderInfo.fileCacheRes.add(str);
        }
    }

    public void addCdnUrl(String str) {
        if (this.needRecord) {
            this.mRenderInfo.cdnRes.add(str);
        }
    }

    public void recordRejectBridgeUrl(String str) {
        if (this.needRecord) {
            String generateRandomString = C10393Util.generateRandomString(11);
            BridgeInfo bridgeInfo = new BridgeInfo();
            bridgeInfo.bridgeUrl = str;
            bridgeInfo.isRejected = true;
            bridgeInfo.errMsg = "OriginHost is not in didi white list";
            this.bridgeInfoMap.put(generateRandomString, bridgeInfo);
        }
    }

    public void recordBridgeInvoke(InvokeMessage invokeMessage) {
        if (this.needRecord) {
            BridgeInfo bridgeInfo = new BridgeInfo();
            bridgeInfo.bridgeVersion = invokeMessage.getInvokeFrom();
            bridgeInfo.bridgeUrl = invokeMessage.getOrgProtocol();
            bridgeInfo.moduleName = invokeMessage.getModuleName();
            bridgeInfo.functionName = invokeMessage.getFunctionName();
            bridgeInfo.args = invokeMessage.getArgs();
            this.bridgeInfoMap.put(invokeMessage.getTraceId(), bridgeInfo);
        }
    }

    public void recordBridgeCallback(String str, String str2) {
        BridgeInfo bridgeInfo;
        if (this.needRecord && (bridgeInfo = this.bridgeInfoMap.get(str)) != null) {
            bridgeInfo.callbackResult = str2;
        }
    }

    public void recordBridgeException(String str, String str2) {
        BridgeInfo bridgeInfo;
        if (!this.needRecord || (bridgeInfo = this.bridgeInfoMap.get(str)) == null) {
            return;
        }
        if (str2.equals("403")) {
            bridgeInfo.errMsg = "Module is not exist";
        } else if (str2.equals("400")) {
            bridgeInfo.errMsg = "Function is not exist";
        } else if (str2.equals("401")) {
            bridgeInfo.errMsg = "Arguments is illeagle";
        } else {
            bridgeInfo.errMsg = "unknow error";
        }
    }

    public void recordCacheInfo(String str, String str2, String str3) {
        if (this.needRecord) {
            this.mRenderInfo.addOfflineCacheItemInfo(str, str3, str2);
        }
    }

    public void recordBundlesInfo(String str, Long l) {
        if (this.needRecord) {
            this.mRenderInfo.bundles.put(str, l);
        }
    }

    public Map<String, BridgeInfo> getBridgeInfoMap() {
        return this.bridgeInfoMap;
    }

    public static class RenderInfo implements Serializable {
        public HashMap<String, Long> bundles = new HashMap<>();
        public List<String> cdnRes = new ArrayList();
        public List<String> fileCacheRes = Collections.synchronizedList(new ArrayList());
        public HashMap<String, HashMap<String, String>> mBundles = new HashMap<>();
        public String reqUrl;
        public long totalTime = 0;

        public void addOfflineCacheItemInfo(String str, String str2, String str3) {
            if (this.mBundles.containsKey(str)) {
                this.mBundles.get(str).put(str3, str2);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str3, str2);
            this.mBundles.put(str, hashMap);
        }

        public long getOfflineSize() {
            long j = 0;
            for (Map.Entry<String, HashMap<String, String>> value : this.mBundles.entrySet()) {
                for (Map.Entry value2 : ((HashMap) value.getValue()).entrySet()) {
                    j += new File((String) value2.getValue()).length();
                }
            }
            return j;
        }

        public long getCacheFileSize(File file) {
            long j;
            long j2 = 0;
            if (!file.exists()) {
                return 0;
            }
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    j = file2.length();
                } else {
                    j = getCacheFileSize(file2);
                }
                j2 += j;
            }
            return j2;
        }

        public static void fillCacheDetail(File file, ArrayList<CacheDetailListAdapter.CacheItemDetailInfo> arrayList) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    CacheDetailListAdapter.CacheItemDetailInfo cacheItemDetailInfo = new CacheDetailListAdapter.CacheItemDetailInfo();
                    cacheItemDetailInfo.mCacheSize = C10393Util.smartConvert(file2.length());
                    try {
                        cacheItemDetailInfo.mCacheMd5 = MD5Util.fileMD5(file2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    arrayList.add(cacheItemDetailInfo);
                } else {
                    fillCacheDetail(file2, arrayList);
                }
            }
        }

        public String toString() {
            return this.totalTime + "ms ==>" + this.reqUrl;
        }
    }
}
