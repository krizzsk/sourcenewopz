package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.common.AssetsUtils;
import com.didi.hawaii.mapsdkv2.core.GLHttpClient;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.task.MapTask;
import com.didi.hawaii.utils.FileUtil;
import com.didi.hawaii.utils.MD5;
import com.didi.hawaii.utils.StringUtil;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.constant.StringConstant;
import com.didi.sdk.apm.SystemUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import didi_map_config_proto.DidiMapConfigProtoMapConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapConfigHelper extends Observable {

    /* renamed from: f */
    private static final String f23676f = "tmp_";

    /* renamed from: g */
    private static final String f23677g = "config.json";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f23678a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HashMap<String, JSONObject> f23679b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Prefs f23680c;

    /* renamed from: d */
    private Context f23681d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GLHttpClient f23682e;

    public MapConfigHelper(Context context, GLHttpClient gLHttpClient, Prefs prefs) {
        this.f23681d = context;
        this.f23682e = gLHttpClient;
        this.f23680c = prefs;
    }

    /* renamed from: a */
    private void m16822a(Context context, Prefs prefs, boolean z) {
        File file = new File(prefs.getConfigPath(), "config.json");
        if (z) {
            AssetsUtils.replaceCustomizedFile(context, prefs.getConfigPath(), "config.json", "config.json");
        }
        String readFromFile = file.exists() ? FileUtil.readFromFile(file) : "";
        if (TextUtils.isEmpty(readFromFile)) {
            AssetsUtils.copyFile(context, prefs.getConfigPath(), "config.json", "config.json");
            readFromFile = FileUtil.readFromFile(file);
        }
        if (TextUtils.isEmpty(readFromFile)) {
            readFromFile = this.f23678a ? StringConstant.CONFIGJSONSTR_DRIVER : StringConstant.CONFIGJSONSTR_PASSENGER;
        }
        try {
            JSONArray jSONArray = new JSONArray(readFromFile);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("sourceName");
                if (!this.f23678a || !jSONObject.has("isDriver") || jSONObject.getBoolean("isDriver")) {
                    this.f23679b.put(string, jSONObject);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void copyBaseMapConfigFile() {
        SystemUtil.setContext(this.f23681d);
        boolean a = m16823a(this.f23680c);
        if (a) {
            this.f23680c.setCachedSDKVersion(StringConstant.MAP_VERSION);
        }
        m16822a(this.f23681d, this.f23680c, a);
        for (Map.Entry next : this.f23679b.entrySet()) {
            JSONObject jSONObject = (JSONObject) next.getValue();
            try {
                String string = jSONObject.getString("localName");
                String str = (String) next.getKey();
                boolean z = jSONObject.has("shouldCopy") && jSONObject.getBoolean("shouldCopy");
                if (!a || !z) {
                    AssetsUtils.checkFile(this.f23681d, this.f23680c.getConfigPath(), string, str);
                } else {
                    AssetsUtils.replaceCustomizedFile(this.f23681d, this.f23680c.getConfigPath(), string, str);
                }
            } catch (JSONException e) {
                HWLog.m16760e(1, "DownloadConfigFailed", "copyBaseMapFile parse wrong" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void checkUpdate() {
        String str;
        DidiMapConfigProtoMapConfig.MapDataUpdateReq.Builder newBuilder = DidiMapConfigProtoMapConfig.MapDataUpdateReq.newBuilder();
        Iterator<Map.Entry<String, JSONObject>> it = this.f23679b.entrySet().iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            JSONObject jSONObject = (JSONObject) next.getValue();
            try {
                if (jSONObject.getBoolean("shouldUpdate")) {
                    if (this.f23678a) {
                        str = (String) next.getKey();
                    } else {
                        str = ((String) next.getKey()).replace("driver", "passenger");
                    }
                    int i2 = jSONObject.getInt("version");
                    if (i2 >= 0) {
                        i = i2;
                    }
                    newBuilder.addLocalDatas(DidiMapConfigProtoMapConfig.MapDataInfo.newBuilder().setName(str).setVersion(i).setMethod(1));
                }
            } catch (JSONException e) {
                HWLog.m16760e(1, "DownloadConfigFailed", "checkUpdate parse wrong" + e.getMessage());
                e.printStackTrace();
            }
        }
        String iMei = MapUtil.getIMei(this.f23681d);
        if (iMei == null || iMei.length() == 0) {
            iMei = "test";
        }
        String configUrl = HWMapConstant.getConfigUrl();
        new MapTask<Object, Integer, Object>() {
            /* access modifiers changed from: protected */
            public Object doInBackground(Object[] objArr) {
                try {
                    GLHttpClient.Res doPost = MapConfigHelper.this.f23682e.doPost(objArr[0], objArr[1]);
                    if (doPost != null) {
                        if (!(doPost.bytes == null || doPost.bytes.length == 0)) {
                            try {
                                DidiMapConfigProtoMapConfig.MapDataUpdateRes parseFrom = DidiMapConfigProtoMapConfig.MapDataUpdateRes.parseFrom(doPost.bytes);
                                if (parseFrom == null || parseFrom.getRet() != 0) {
                                    HWLog.m16760e(1, "DownloadConfigFailed", "pb result is null");
                                    return null;
                                }
                                List<DidiMapConfigProtoMapConfig.MapDataFile> updateFilesList = parseFrom.getUpdateFilesList();
                                for (DidiMapConfigProtoMapConfig.MapDataFile next : updateFilesList) {
                                    byte[] byteArray = next.getFilebody().toByteArray();
                                    if (MD5.toMD5(byteArray).toLowerCase().equals(next.getMd5().toLowerCase())) {
                                        String configPath = MapConfigHelper.this.f23680c.getConfigPath();
                                        AssetsUtils.copyFile(configPath, next.getName() + MapConfigHelper.f23676f, byteArray);
                                    }
                                }
                                return updateFilesList;
                            } catch (InvalidProtocolBufferException e) {
                                HWLog.m16760e(1, "ConfigDownloadFiled", e.getMessage());
                                return null;
                            }
                        }
                    }
                    HWLog.m16760e(1, "DownloadConfigFailed", "response is null");
                    return null;
                } catch (Exception e2) {
                    HWLog.m16760e(1, "ConfigDownloadFiled", e2.getMessage());
                    e2.printStackTrace();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Object obj) {
                if (obj == null) {
                    HWLog.m16760e(1, "ConfigDownloadFiled", "onPostExecute return");
                    return;
                }
                for (DidiMapConfigProtoMapConfig.MapDataFile mapDataFile : (List) obj) {
                    if (mapDataFile.hasFilebody()) {
                        String name = mapDataFile.getName();
                        JSONObject jSONObject = (JSONObject) MapConfigHelper.this.f23679b.get((MapConfigHelper.this.f23678a || MapConfigHelper.this.f23679b.containsKey(name)) ? name : name.replace("passenger", "driver"));
                        try {
                            String string = jSONObject.getString("localName");
                            MapEngineJNI.DGLMapStyleLock();
                            String configPath = MapConfigHelper.this.f23680c.getConfigPath();
                            if (AssetsUtils.renameFile(configPath, name + MapConfigHelper.f23676f, string)) {
                                jSONObject.put("version", mapDataFile.getVersion());
                                jSONObject.put("md5", mapDataFile.getMd5());
                            }
                            SystemUtils.log(6, "MapEngineJNI", jSONObject.toString(), (Throwable) null, "com.didi.hawaii.mapsdkv2.MapConfigHelper$1", 245);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (Throwable th) {
                            MapEngineJNI.DGLMapStyleUnlock();
                            throw th;
                        }
                        MapEngineJNI.DGLMapStyleUnlock();
                    }
                }
                updateConfigJson();
            }

            private void updateConfigJson() {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry value : MapConfigHelper.this.f23679b.entrySet()) {
                    jSONArray.put((JSONObject) value.getValue());
                }
                FileUtil.writeJsonToFile(MapConfigHelper.this.f23680c.getConfigPath(), "config.jsontmp_", jSONArray.toString());
                AssetsUtils.renameFile(MapConfigHelper.this.f23680c.getConfigPath(), "config.jsontmp_", "config.json");
            }
        }.execute((Params[]) new Object[]{configUrl, ((DidiMapConfigProtoMapConfig.MapDataUpdateReq) newBuilder.setSdkVersion(StringConstant.MAP_VERSION).setImei(iMei).setDevice("andriod").build()).toByteArray()});
    }

    /* renamed from: a */
    private static boolean m16823a(Prefs prefs) {
        if (StringUtil.isEmpty(StringConstant.MAP_VERSION)) {
            return false;
        }
        String cachedSDKVersion = prefs.getCachedSDKVersion();
        if (!StringUtil.isEmpty(cachedSDKVersion) && StringConstant.MAP_VERSION.compareToIgnoreCase(cachedSDKVersion) <= 0) {
            return false;
        }
        return true;
    }
}
