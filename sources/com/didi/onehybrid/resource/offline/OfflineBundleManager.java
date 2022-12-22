package com.didi.onehybrid.resource.offline;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.onehybrid.Constants;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.resource.FusionAsynDispatcher;
import com.didi.onehybrid.resource.FusionHttpClient;
import com.didi.onehybrid.resource.FusionZipTaskRecorder;
import com.didi.onehybrid.resource.offline.OfflineBundle;
import com.didi.onehybrid.util.C10393Util;
import com.didi.onehybrid.util.FileUtil;
import com.didi.onehybrid.util.HttpUtil;
import com.didi.onehybrid.util.IDUtil;
import com.didi.onehybrid.util.NetworkUtil;
import com.didi.onehybrid.util.OmegaUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineBundleManager {
    private static AtomicBoolean INITIALIZED = new AtomicBoolean(false);
    private static final String KEY_APP_KEY = "app_key";
    private static final String KEY_APP_VERSION = "app_version";
    private static final String KEY_CITY_ID = "city";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_DEVICE_TYPE = "device_type";
    private static final String KEY_MODULES = "bundles";
    private static final String KEY_OS_TYPE = "os_type";
    private static final String KEY_PHONE_NUMBER = "phone";
    private static final String OFFLINE_BUNDLE_ABILITY_ID = "common-plat-public-common-common_go/getPkgInfo";
    private static final String OFFLINE_BUNDLE_DEFAULT_VERSION = "999999999999";
    private static final String OFFLINE_BUNDLE_DIR = "fusion_hybrid";
    private static final String OFFLINE_BUNDLE_RESOURCE_FILE_PATH = "/resource/";
    private static final String OFFLINE_BUNDLE_TEMP_DIR = "download_temp";
    private static final String TAG = "OfflineBundleManager";
    private static OfflineBundleManager sInstance;
    private boolean loadofflineitems = false;
    private String mAppKey = "";
    private OfflineBundleDao mBundleDAO;
    /* access modifiers changed from: private */
    public BundleInfoDao mBundleInfoDAO;
    private int mCityId = -1;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public File mDownloadTempDir;
    private String mHybridUrl = "";
    private boolean mNeedRegisterWifiListener = false;
    private NetworkChangedReceiver mNetworkChangedReceiver;
    /* access modifiers changed from: private */
    public File mOfflineBundleHome;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OfflineBundleInfo> mOfflineBundleInfos;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OfflineBundle> mOfflineBundles;
    private FusionOfflineEventBroadcastReceiver mOfflineEventReceiver;
    private ConcurrentHashMap<String, String> mOfflineUrlFileMap;
    private String mPhoneNo = "";
    private ConcurrentHashMap<String, HashMap<String, ArrayList<OfflineBundleInfo>>> offlineCache;
    public FusionZipTaskRecorder recorder = new FusionZipTaskRecorder();

    public static synchronized void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (OfflineBundleManager.class) {
            if (sInstance == null) {
                sInstance = new OfflineBundleManager(application, fusionInitConfig);
                INITIALIZED.getAndSet(true);
            }
            sInstance.prepareOfflineHome();
        }
    }

    public static OfflineBundleManager getInstance() {
        return sInstance;
    }

    public static boolean isInitialized() {
        return INITIALIZED.get();
    }

    private OfflineBundleManager(Context context, FusionInitConfig fusionInitConfig) {
        this.mContext = context;
        this.mBundleDAO = new OfflineBundleDao(context);
        this.mHybridUrl = fusionInitConfig.getHybridUrl();
        this.mAppKey = fusionInitConfig.getAppKey();
        this.mPhoneNo = fusionInitConfig.getPhone();
        this.mCityId = fusionInitConfig.getCityId();
        this.mOfflineBundles = new CopyOnWriteArrayList<>();
        this.mOfflineUrlFileMap = new ConcurrentHashMap<>();
    }

    private void prepareOfflineHome() {
        this.mOfflineBundleHome = this.mContext.getDir(OFFLINE_BUNDLE_DIR, 0);
        File file = new File(this.mOfflineBundleHome, OFFLINE_BUNDLE_TEMP_DIR);
        this.mDownloadTempDir = file;
        if (!file.exists()) {
            this.mDownloadTempDir.mkdirs();
        }
    }

    public void getBundleInfo() {
        if (C10393Util.hasStoragePermissions(this.mContext)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    OfflineBundleManager.this.updateBundles();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public synchronized void updateBundles() {
        try {
            this.mOfflineBundles = loadBundlesFromDB();
            ArrayList arrayList = new ArrayList();
            final HashMap hashMap = new HashMap();
            if (this.mOfflineBundles != null) {
                Iterator<OfflineBundle> it = this.mOfflineBundles.iterator();
                while (it.hasNext()) {
                    OfflineBundle next = it.next();
                    SystemUtils.log(3, TAG, "bundleInfo:" + next.getName(), (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 183);
                    hashMap.put(next.getName(), next);
                    OfflineBundle offlineBundle = new OfflineBundle();
                    offlineBundle.setName(next.getName());
                    offlineBundle.setVersion(next.getVersion());
                    arrayList.add(offlineBundle);
                }
            }
            Map<String, Object> bundleParams = FusionEngine.getBusinessAgent().getBundleParams();
            bundleParams.put("modules", arrayList);
            Bff.call(new IBffProxy.Ability.Builder(this.mContext, OFFLINE_BUNDLE_ABILITY_ID).setParams(bundleParams).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    if (jsonObject.get("errno").getAsInt() == 0) {
                        OmegaUtils.offline_update(true, "");
                        OfflineBundles offlineBundles = (OfflineBundles) new Gson().fromJson((JsonElement) jsonObject.get("data").getAsJsonObject(), OfflineBundles.class);
                        if (offlineBundles != null) {
                            List<OfflineBundle> list = offlineBundles.packages;
                            HashMap hashMap = new HashMap();
                            if (list != null && list.size() > 0) {
                                if (!TextUtils.isEmpty(FusionEngine.getBusinessAgent().getHighPriorityBundleName())) {
                                    Iterator<OfflineBundle> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        OfflineBundle next = it.next();
                                        if (next.getName().equals(FusionEngine.getBusinessAgent().getHighPriorityBundleName())) {
                                            OfflineBundleManager.this.downloadBundlePreJudge(next, hashMap);
                                            break;
                                        }
                                    }
                                }
                                for (OfflineBundle next2 : list) {
                                    hashMap.put(next2.getName(), next2);
                                    if (!next2.getName().equals(FusionEngine.getBusinessAgent().getHighPriorityBundleName())) {
                                        OfflineBundleManager.this.downloadBundlePreJudge(next2, hashMap);
                                    }
                                }
                                if (OfflineBundleManager.this.mOfflineBundles != null) {
                                    Iterator it2 = OfflineBundleManager.this.mOfflineBundles.iterator();
                                    while (it2.hasNext()) {
                                        OfflineBundle offlineBundle = (OfflineBundle) it2.next();
                                        if (hashMap.get(offlineBundle.getName()) == null) {
                                            OfflineBundleManager.this.dealInvalidBundle(offlineBundle);
                                        }
                                    }
                                }
                            }
                        }
                        OfflineBundleManager.this.buildOfflineCache();
                        return;
                    }
                    SystemUtils.log(3, OfflineBundleManager.TAG, jsonObject.get("errmsg").getAsString(), (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager$2", 247);
                    OmegaUtils.offline_update(false, jsonObject.get("errmsg").getAsString());
                }

                public void onFailure(IOException iOException) {
                    SystemUtils.log(3, OfflineBundleManager.TAG, iOException.getMessage(), (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager$2", 254);
                    OmegaUtils.offline_update(false, "exception:" + iOException.getMessage());
                }
            }).build());
        } catch (Exception e) {
            SystemUtils.log(3, TAG, e.getMessage(), (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 261);
            this.mBundleDAO.destroy();
            OmegaUtils.offline_error("asynRunTask:" + e.getMessage());
        }
        return;
    }

    /* access modifiers changed from: private */
    public void downloadBundlePreJudge(OfflineBundle offlineBundle, HashMap<String, OfflineBundle> hashMap) {
        if (offlineBundle != null) {
            String name = offlineBundle.getName();
            if (!hashMap.containsKey(name)) {
                if (!isInBlackList(name)) {
                    SystemUtils.log(3, TAG, "新增离线包" + name, (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 285);
                    downloadBundlePackage((OfflineBundle) null, offlineBundle, false);
                }
            } else if (hashMap.get(name) != null) {
                if (isInBlackList(name)) {
                    dealInvalidBundle(hashMap.get(name));
                } else if (hashMap.get(name).getVersion().compareTo(offlineBundle.getVersion()) < 0) {
                    hashMap.get(name).setState(0);
                    SystemUtils.log(3, TAG, "本地离线包需要更新" + name, (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 299);
                    downloadBundlePackage(hashMap.get(name), offlineBundle, true);
                }
            }
        }
    }

    private boolean isInBlackList(String str) {
        String bundleBlackList = FusionEngine.getBusinessAgent().getBundleBlackList();
        return !TextUtils.isEmpty(bundleBlackList) && bundleBlackList.contains(str);
    }

    /* access modifiers changed from: private */
    public void dealInvalidBundle(OfflineBundle offlineBundle) {
        offlineBundle.setState(0);
        offlineBundle.setDbOperation(3);
        deleteBundleFile(offlineBundle);
        updateBundleInfoAndResource(offlineBundle);
    }

    private void deleteBundleFile(OfflineBundle offlineBundle) {
        File file = new File(this.mOfflineBundleHome, offlineBundle.getName());
        if (file.exists()) {
            FileUtil.deleteDir(file);
            SystemUtils.log(3, "OfflineBundleManger", "delete file:" + offlineBundle.getName() + FileUtil.deleteDir(file), (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 338);
        }
    }

    private void deleteBundleInfo(Map<String, OfflineBundle> map, String str) {
        OfflineBundle offlineBundle = map.get(str);
        deleteBundleFile(offlineBundle);
        this.mOfflineBundles.remove(offlineBundle);
        this.mBundleDAO.deleteBundleInfo(offlineBundle);
        SystemUtils.log(3, "OfflineBundleManger", "delete Bundle", (Throwable) null, "com.didi.onehybrid.resource.offline.OfflineBundleManager", 350);
    }

    /* access modifiers changed from: private */
    public void buildOfflineCache() {
        CopyOnWriteArrayList<OfflineBundle> copyOnWriteArrayList = this.mOfflineBundles;
        if (copyOnWriteArrayList != null) {
            Iterator<OfflineBundle> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                updateResource(it.next());
            }
        }
    }

    private void addToOfflineCache(OfflineBundleInfo offlineBundleInfo) {
        Uri parse = Uri.parse(offlineBundleInfo.getOriginUrl());
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (!this.offlineCache.containsKey(scheme)) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(offlineBundleInfo);
            hashMap.put(host, arrayList);
            this.offlineCache.put(scheme, hashMap);
        } else if (this.offlineCache.get(scheme).containsKey(host)) {
            ((ArrayList) this.offlineCache.get(scheme).get(host)).add(offlineBundleInfo);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(offlineBundleInfo);
            this.offlineCache.get(scheme).put(host, arrayList2);
        }
    }

    private CopyOnWriteArrayList<OfflineBundle> loadBundlesFromDB() {
        return new CopyOnWriteArrayList<>(this.mBundleDAO.loadAllBundleInfos());
    }

    private CopyOnWriteArrayList<OfflineBundleInfo> fetchBundleInfosFromServer() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", this.mAppKey);
        hashMap.put("app_version", C10393Util.getVersionNameAndCode(this.mContext));
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("device_id", IDUtil.getUUID(this.mContext));
        hashMap.put("os_type", Build.VERSION.SDK_INT + "");
        hashMap.put("phone", this.mPhoneNo);
        hashMap.put("city", this.mCityId + "");
        hashMap.put(KEY_MODULES, pickLocalBundleVersions());
        try {
            String executeGetRequest = new FusionHttpClient(HttpUtil.appendQueryParams(this.mHybridUrl, hashMap), (Map<String, String>) null).executeGetRequest();
            if (!TextUtils.isEmpty(executeGetRequest)) {
                JSONArray jSONArray = new JSONObject(executeGetRequest).getJSONArray(KEY_MODULES);
                for (int i = 0; i < jSONArray.length(); i++) {
                    OfflineBundleInfo fromJson = OfflineBundleInfo.fromJson(jSONArray.getJSONObject(i));
                    if (fromJson != null) {
                        copyOnWriteArrayList.add(fromJson);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    private String pickLocalBundleVersions() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.mOfflineBundleInfos;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<OfflineBundleInfo> it = this.mOfflineBundleInfos.iterator();
        while (it.hasNext()) {
            OfflineBundleInfo next = it.next();
            sb.append(String.format("%s:%s;", new Object[]{next.getBundleName(), next.getBundleVersion()}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void downloadBundlePackage(final OfflineBundle offlineBundle, final OfflineBundle offlineBundle2, final boolean z) {
        if (offlineBundle2 != null) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    File file = new File(OfflineBundleManager.this.mDownloadTempDir, offlineBundle2.getName());
                    String absolutePath = file.getAbsolutePath();
                    try {
                        if (OfflineBundleManager.this.recorder.recordTask(absolutePath)) {
                            startDownLoadTask(file);
                            OfflineBundleManager.this.recorder.finishTask(absolutePath);
                        }
                    } finally {
                        OfflineBundleManager.this.recorder.finishTask(absolutePath);
                    }
                }

                /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
                /* JADX WARNING: Removed duplicated region for block: B:16:0x008b  */
                /* JADX WARNING: Removed duplicated region for block: B:18:0x008e A[SYNTHETIC, Splitter:B:18:0x008e] */
                /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private void startDownLoadTask(java.io.File r11) {
                    /*
                        r10 = this;
                        com.didi.onehybrid.resource.offline.OfflineBundle r0 = r3
                        boolean r1 = r11.exists()
                        r2 = 0
                        r3 = 1
                        if (r1 == 0) goto L_0x0042
                        java.lang.String r1 = com.didi.onehybrid.util.MD5Util.fileMD5(r11)     // Catch:{ IOException -> 0x0026 }
                        boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException -> 0x0026 }
                        if (r4 != 0) goto L_0x0022
                        com.didi.onehybrid.resource.offline.OfflineBundle r4 = r4     // Catch:{ IOException -> 0x0026 }
                        java.lang.String r4 = r4.getMD5()     // Catch:{ IOException -> 0x0026 }
                        boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ IOException -> 0x0026 }
                        if (r1 == 0) goto L_0x0022
                        r1 = 1
                        goto L_0x0043
                    L_0x0022:
                        r11.delete()     // Catch:{ IOException -> 0x0026 }
                        goto L_0x0042
                    L_0x0026:
                        r1 = move-exception
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                        r4.<init>()
                        java.lang.String r5 = "downloadBundlePackage:"
                        r4.append(r5)
                        java.lang.String r5 = r1.getMessage()
                        r4.append(r5)
                        java.lang.String r4 = r4.toString()
                        com.didi.onehybrid.util.OmegaUtils.offline_error(r4)
                        r1.printStackTrace()
                    L_0x0042:
                        r1 = 0
                    L_0x0043:
                        if (r1 != 0) goto L_0x008b
                        java.util.Calendar r1 = java.util.Calendar.getInstance()
                        long r4 = java.lang.System.currentTimeMillis()
                        r1.setTimeInMillis(r4)
                        com.didi.onehybrid.resource.offline.OfflineBundleManager r4 = com.didi.onehybrid.resource.offline.OfflineBundleManager.this
                        long r4 = r4.getCurrentDayFlow(r1)
                        com.didi.onehybrid.BusinessAgent r6 = com.didi.onehybrid.FusionEngine.getBusinessAgent()
                        long r6 = r6.getFlowLimit()
                        int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r8 < 0) goto L_0x0063
                        goto L_0x008c
                    L_0x0063:
                        com.didi.onehybrid.resource.FusionHttpClient r2 = new com.didi.onehybrid.resource.FusionHttpClient
                        com.didi.onehybrid.resource.offline.OfflineBundle r6 = r4
                        java.lang.String r6 = r6.getUrl()
                        r2.<init>(r6)
                        boolean r6 = r2.executeDownload(r11)
                        com.didi.onehybrid.resource.offline.OfflineBundleManager r7 = com.didi.onehybrid.resource.offline.OfflineBundleManager.this
                        android.content.Context r7 = r7.mContext
                        com.didi.onehybrid.resource.offline.OfflinePreference r7 = com.didi.onehybrid.resource.offline.OfflinePreference.getInstance(r7)
                        r8 = 6
                        int r1 = r1.get(r8)
                        long r8 = r2.getFlow()
                        long r4 = r4 + r8
                        r7.updateCurrentDayFlow(r1, r4)
                        r2 = r6
                        goto L_0x008c
                    L_0x008b:
                        r2 = r1
                    L_0x008c:
                        if (r2 == 0) goto L_0x0105
                        com.didi.onehybrid.resource.offline.OfflineBundle r1 = r4     // Catch:{ Exception -> 0x00e3 }
                        java.lang.String r1 = r1.getMD5()     // Catch:{ Exception -> 0x00e3 }
                        java.lang.String r2 = com.didi.onehybrid.util.MD5Util.fileMD5(r11)     // Catch:{ Exception -> 0x00e3 }
                        boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x00e3 }
                        if (r1 == 0) goto L_0x00fc
                        java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00e3 }
                        com.didi.onehybrid.resource.offline.OfflineBundleManager r2 = com.didi.onehybrid.resource.offline.OfflineBundleManager.this     // Catch:{ Exception -> 0x00e3 }
                        java.io.File r2 = r2.mOfflineBundleHome     // Catch:{ Exception -> 0x00e3 }
                        com.didi.onehybrid.resource.offline.OfflineBundle r4 = r4     // Catch:{ Exception -> 0x00e3 }
                        java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x00e3 }
                        r1.<init>(r2, r4)     // Catch:{ Exception -> 0x00e3 }
                        boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00e3 }
                        if (r2 != 0) goto L_0x00b8
                        r1.mkdirs()     // Catch:{ Exception -> 0x00e3 }
                    L_0x00b8:
                        com.didi.onehybrid.resource.offline.OfflineBundle r2 = com.didi.onehybrid.util.ZipUtil.getBundleInfoFromZipFile(r11, r1)     // Catch:{ Exception -> 0x00e3 }
                        if (r2 == 0) goto L_0x00fc
                        com.didi.onehybrid.resource.offline.OfflineBundle r4 = r4     // Catch:{ Exception -> 0x00e3 }
                        java.lang.String r4 = r4.getMD5()     // Catch:{ Exception -> 0x00e3 }
                        r2.setMd5(r4)     // Catch:{ Exception -> 0x00e3 }
                        com.didi.onehybrid.util.ZipUtil.updateResourceFromZipFile(r11, r1, r2)     // Catch:{ Exception -> 0x00e3 }
                        boolean r1 = r5     // Catch:{ Exception -> 0x00e3 }
                        if (r1 == 0) goto L_0x00d6
                        r0.updateInfo(r2)     // Catch:{ Exception -> 0x00e3 }
                        r1 = 2
                        r0.setDbOperation(r1)     // Catch:{ Exception -> 0x00e3 }
                        goto L_0x00da
                    L_0x00d6:
                        r2.setDbOperation(r3)     // Catch:{ Exception -> 0x00e3 }
                        r0 = r2
                    L_0x00da:
                        r0.setState(r3)     // Catch:{ Exception -> 0x00e3 }
                        com.didi.onehybrid.resource.offline.OfflineBundleManager r1 = com.didi.onehybrid.resource.offline.OfflineBundleManager.this     // Catch:{ Exception -> 0x00e3 }
                        r1.updateBundleInfoAndResource(r0)     // Catch:{ Exception -> 0x00e3 }
                        goto L_0x00fc
                    L_0x00e3:
                        r0 = move-exception
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "downloadBundlePackage"
                        r1.append(r2)
                        java.lang.String r0 = r0.getMessage()
                        r1.append(r0)
                        java.lang.String r0 = r1.toString()
                        com.didi.onehybrid.util.OmegaUtils.offline_error(r0)
                    L_0x00fc:
                        boolean r0 = r11.exists()
                        if (r0 == 0) goto L_0x0105
                        r11.delete()
                    L_0x0105:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.resource.offline.OfflineBundleManager.C103893.startDownLoadTask(java.io.File):void");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateBundleInfoAndResource(OfflineBundle offlineBundle) {
        int dbOperation = offlineBundle.getDbOperation();
        if (dbOperation == 1) {
            this.mBundleDAO.addBundleInfo(offlineBundle);
        } else if (dbOperation == 2) {
            this.mBundleDAO.updateBundleInfo(offlineBundle);
        } else if (dbOperation == 3) {
            this.mBundleDAO.deleteBundleInfo(offlineBundle);
        }
        updateResource(offlineBundle);
    }

    private void updateResource(OfflineBundle offlineBundle) {
        if (offlineBundle.getState() != 0 && offlineBundle.getResouceInfoList() != null) {
            for (OfflineBundle.ResourceInfo next : offlineBundle.getResouceInfoList()) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.mOfflineUrlFileMap;
                String url = next.getUrl();
                concurrentHashMap.put(url, offlineBundle.getName() + "/" + next.getMd5() + next.getFileType());
            }
        }
    }

    /* access modifiers changed from: private */
    public long getCurrentDayFlow(Calendar calendar) {
        int i;
        if (OfflinePreference.getInstance(this.mContext).contains(Constants.FUSION_OFFLINE_FLOW_DATE) && calendar.get(6) != (i = OfflinePreference.getInstance(this.mContext).getInt(Constants.FUSION_OFFLINE_FLOW_DATE, -1))) {
            OfflinePreference.getInstance(this.mContext).remove(String.valueOf(i));
        }
        return OfflinePreference.getInstance(this.mContext).getLong(String.valueOf(calendar.get(6)), 0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ad, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void downloadBundlePackage(com.didi.onehybrid.resource.offline.OfflineBundleInfo r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x00ac
            boolean r0 = r8.isRollback()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x000b
            goto L_0x00ac
        L_0x000b:
            android.content.Context r0 = r7.mContext     // Catch:{ all -> 0x00a9 }
            boolean r0 = com.didi.onehybrid.util.NetworkUtil.isNetworkWifi(r0)     // Catch:{ all -> 0x00a9 }
            r1 = 2
            r2 = 1
            if (r0 != 0) goto L_0x0023
            int r0 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0023
            r9 = 4
            r8.setState(r9)     // Catch:{ all -> 0x00a9 }
            r7.mNeedRegisterWifiListener = r2     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x0023:
            r0 = 3
            if (r9 == r0) goto L_0x002e
            int r9 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r9 != r0) goto L_0x002e
            monitor-exit(r7)
            return
        L_0x002e:
            r8.setState(r2)     // Catch:{ all -> 0x00a9 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r3 = r7.mDownloadTempDir     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = r8.getBundleFileName()     // Catch:{ all -> 0x00a9 }
            r9.<init>(r3, r4)     // Catch:{ all -> 0x00a9 }
            boolean r3 = r9.exists()     // Catch:{ all -> 0x00a9 }
            r4 = 0
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = com.didi.onehybrid.util.MD5Util.fileMD5(r9)     // Catch:{ IOException -> 0x0063 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0063 }
            if (r5 != 0) goto L_0x0058
            java.lang.String r5 = r8.getMd5()     // Catch:{ IOException -> 0x0063 }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0058
            goto L_0x0068
        L_0x0058:
            boolean r2 = r9.delete()     // Catch:{ IOException -> 0x0063 }
            if (r2 != 0) goto L_0x0067
            r8.setState(r0)     // Catch:{ IOException -> 0x0063 }
            monitor-exit(r7)
            return
        L_0x0063:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00a9 }
        L_0x0067:
            r2 = 0
        L_0x0068:
            if (r2 != 0) goto L_0x0077
            com.didi.onehybrid.resource.FusionHttpClient r2 = new com.didi.onehybrid.resource.FusionHttpClient     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r8.getDownloadUrl()     // Catch:{ all -> 0x00a9 }
            r2.<init>(r3)     // Catch:{ all -> 0x00a9 }
            boolean r2 = r2.executeDownload(r9)     // Catch:{ all -> 0x00a9 }
        L_0x0077:
            if (r2 == 0) goto L_0x009f
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r5 = r7.mOfflineBundleHome     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r8.getBundleDirName()     // Catch:{ all -> 0x00a9 }
            r3.<init>(r5, r6)     // Catch:{ all -> 0x00a9 }
            boolean r5 = r3.exists()     // Catch:{ all -> 0x00a9 }
            if (r5 == 0) goto L_0x008d
            r3.delete()     // Catch:{ all -> 0x00a9 }
        L_0x008d:
            r3.mkdirs()     // Catch:{ all -> 0x00a9 }
            com.didi.onehybrid.util.ZipUtil.unzip(r9, r3)     // Catch:{ IOException -> 0x009d }
            boolean r3 = r9.exists()     // Catch:{ IOException -> 0x009d }
            if (r3 == 0) goto L_0x009f
            r9.delete()     // Catch:{ IOException -> 0x009d }
            goto L_0x009f
        L_0x009d:
            goto L_0x00a0
        L_0x009f:
            r4 = r2
        L_0x00a0:
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r1 = 3
        L_0x00a4:
            r8.setState(r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x00a9:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00ac:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.resource.offline.OfflineBundleManager.downloadBundlePackage(com.didi.onehybrid.resource.offline.OfflineBundleInfo, int):void");
    }

    public void registerEventListener() {
        this.mOfflineEventReceiver = new FusionOfflineEventBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fusion_offline_event");
        LocalBroadcastManager.getInstance(this.mContext.getApplicationContext()).registerReceiver(this.mOfflineEventReceiver, intentFilter);
    }

    public void unregisterEventListener() {
        LocalBroadcastManager.getInstance(this.mContext.getApplicationContext()).unregisterReceiver(this.mOfflineEventReceiver);
    }

    private void registerWifiListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        this.mNetworkChangedReceiver = new NetworkChangedReceiver();
        try {
            this.mContext.getApplicationContext().registerReceiver(this.mNetworkChangedReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    public void unRegisterWifiListener() {
        try {
            this.mContext.getApplicationContext().unregisterReceiver(this.mNetworkChangedReceiver);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public boolean isAllOfflineItemLoaded() {
        return this.loadofflineitems;
    }

    public synchronized void downloadOfflineWhenEvent(final String str) {
        if (NetworkUtil.isAvailable(this.mContext)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    if (OfflineBundleManager.this.mOfflineBundleInfos != null && OfflineBundleManager.this.mOfflineBundleInfos.size() > 0) {
                        Iterator it = OfflineBundleManager.this.mOfflineBundleInfos.iterator();
                        while (it.hasNext()) {
                            OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                            if (offlineBundleInfo.getBundleName().equalsIgnoreCase(str)) {
                                OfflineBundleManager.this.downloadBundlePackage(offlineBundleInfo, 3);
                                OfflineBundleManager.this.mBundleInfoDAO.updateBundleInfo(offlineBundleInfo);
                                return;
                            }
                        }
                    }
                }
            });
            this.mBundleInfoDAO.destroy();
        }
    }

    public File findBundleFile(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = this.mOfflineUrlFileMap;
        if (concurrentHashMap != null && !TextUtils.isEmpty(concurrentHashMap.get(UrlTrieTree.getPureUrl(str)))) {
            File file = new File(this.mOfflineBundleHome, this.mOfflineUrlFileMap.get(UrlTrieTree.getPureUrl(str)));
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private class NetworkChangedReceiver extends BroadcastReceiver {
        private NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context) && NetworkUtil.isAvailable(context)) {
                FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                    public void run() {
                        if (OfflineBundleManager.this.mOfflineBundleInfos != null && OfflineBundleManager.this.mOfflineBundleInfos.size() > 0) {
                            Iterator it = OfflineBundleManager.this.mOfflineBundleInfos.iterator();
                            while (it.hasNext()) {
                                OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                                if (offlineBundleInfo.getState() == 4) {
                                    OfflineBundleManager.this.downloadBundlePackage(offlineBundleInfo, 2);
                                    OfflineBundleManager.this.mBundleInfoDAO.updateBundleInfo(offlineBundleInfo);
                                }
                            }
                        }
                    }
                });
                OfflineBundleManager.this.mBundleInfoDAO.destroy();
                OfflineBundleManager.this.unRegisterWifiListener();
            }
        }
    }

    public void getOfflineInfo(FusionRuntimeInfo fusionRuntimeInfo) {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.mOfflineBundleInfos;
        if (copyOnWriteArrayList != null) {
            Iterator<OfflineBundleInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                OfflineBundleInfo next = it.next();
                if (next.isValid()) {
                    fusionRuntimeInfo.recordBundlesInfo(next.getBundleName(), Long.valueOf(fusionRuntimeInfo.getRenderInfo().getCacheFileSize(new File(this.mOfflineBundleHome, next.getBundleDirName()))));
                }
            }
        }
    }
}
