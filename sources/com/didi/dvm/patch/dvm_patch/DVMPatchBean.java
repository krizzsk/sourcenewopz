package com.didi.dvm.patch.dvm_patch;

import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DVMPatchBean {
    public static int ACTION_ADD_AND_UPDATE = 1;
    public static int ACTION_ROLLBACK = 2;

    /* renamed from: l */
    private static Logger f19278l = LoggerFactory.getLogger("DVMPatchBean");

    /* renamed from: a */
    String f19279a;

    /* renamed from: b */
    int f19280b;

    /* renamed from: c */
    String[] f19281c = new String[0];

    /* renamed from: d */
    int f19282d;

    /* renamed from: e */
    String f19283e;

    /* renamed from: f */
    String f19284f;

    /* renamed from: g */
    String f19285g;

    /* renamed from: h */
    String f19286h;

    /* renamed from: i */
    JSONObject f19287i;

    /* renamed from: j */
    String[] f19288j;

    /* renamed from: k */
    private File f19289k;

    public static DVMPatchBean from(JSONObject jSONObject) {
        DVMPatchBean dVMPatchBean = new DVMPatchBean();
        dVMPatchBean.f19279a = jSONObject.optString("id");
        dVMPatchBean.f19280b = jSONObject.optInt("version");
        JSONArray optJSONArray = jSONObject.optJSONArray("appVersion");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            dVMPatchBean.f19281c = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVMPatchBean.f19281c[i] = optJSONArray.optString(i);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rollback");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            dVMPatchBean.f19288j = new String[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                dVMPatchBean.f19288j[i2] = optJSONArray2.optString(i2);
            }
        }
        dVMPatchBean.f19282d = jSONObject.optInt("action");
        dVMPatchBean.f19283e = jSONObject.optString("signature");
        dVMPatchBean.f19284f = jSONObject.optString("bin");
        return dVMPatchBean;
    }

    public static DVMPatchBean from(String str, JSONObject jSONObject) {
        DVMPatchBean dVMPatchBean = new DVMPatchBean();
        dVMPatchBean.f19279a = str;
        if (jSONObject != null) {
            dVMPatchBean.f19280b = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray("appVersion");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                dVMPatchBean.f19281c = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    dVMPatchBean.f19281c[i] = optJSONArray.optString(i);
                }
            }
        }
        return dVMPatchBean;
    }

    public boolean isDownloaded(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optJSONObject(this.f19279a) == null) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(this.f19279a);
        if (optJSONObject != null && optJSONObject.optInt("version") != this.f19280b) {
            return false;
        }
        File dvmPatchDir = DVMPatchManager.getDvmPatchDir(this.f19279a);
        if (dvmPatchDir.exists() && new File(dvmPatchDir, "data.bin").exists() && new File(dvmPatchDir, "patch.json").exists()) {
            return true;
        }
        return false;
    }

    public boolean isVersionMatch() {
        return DVMPatchManager.isVersionMatch(this.f19281c);
    }

    public File createDownloadTempFile() throws IOException {
        File file = new File(DVMPatchManager.f19301g, this.f19279a);
        this.f19289k = file;
        if (file.exists()) {
            this.f19289k.delete();
        } else {
            this.f19289k.getParentFile().mkdirs();
        }
        this.f19289k.createNewFile();
        return this.f19289k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verify() {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.File r1 = r6.f19289k
            r2 = 0
            if (r1 == 0) goto L_0x005c
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x005c
            java.io.File r1 = r6.f19289k
            java.lang.String r1 = com.didi.sdk.util.FileUtil.getFileMD5(r1)
            java.lang.String r3 = r6.f19283e     // Catch:{ Exception -> 0x0042 }
            boolean r1 = com.didi.dvm.patch.dvm_patch.Validator.verify(r1, r3)     // Catch:{ Exception -> 0x0042 }
            com.didi.sdk.logging.Logger r3 = f19278l     // Catch:{ Exception -> 0x0040 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r4.<init>()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = "verify patch ["
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = r6.f19279a     // Catch:{ Exception -> 0x0040 }
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = "]"
            r4.append(r5)     // Catch:{ Exception -> 0x0040 }
            r4.append(r1)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0040 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0040 }
            r3.info((java.lang.String) r4, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0040 }
            goto L_0x005b
        L_0x0040:
            r2 = move-exception
            goto L_0x0045
        L_0x0042:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L_0x0045:
            r2.printStackTrace()
            java.lang.String r3 = r2.toString()
            java.lang.String r4 = "e"
            r0.put(r4, r3)
            java.lang.String r2 = com.didi.dvm.patch.dvm_patch.C7968b.m14426a(r2)
            java.lang.String r3 = "s"
            r0.put(r3, r2)
        L_0x005b:
            r2 = r1
        L_0x005c:
            java.lang.String r1 = r6.f19279a
            java.lang.String r3 = "id"
            r0.put(r3, r1)
            java.lang.String r1 = r6.f19284f
            java.lang.String r3 = "bin"
            r0.put(r3, r1)
            int r1 = r6.f19280b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "v"
            r0.put(r3, r1)
            if (r2 != 0) goto L_0x0080
            com.didi.dvm.patch.dvm_patch.b r1 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f19298d
            java.lang.String r3 = "tech_dvm_patch_verify_error"
            r1.mo59023a(r3, r0)
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchBean.verify():boolean");
    }

    public void takeEffect() throws IOException {
        try {
            File file = new File(DVMPatchManager.f19297c, this.f19279a);
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();
            if (unzip(this.f19289k, file)) {
                Logger logger = f19278l;
                logger.debug("unzip file success [" + this.f19279a + Const.jaRight, new Object[0]);
                DVMPatchManager.takeEffect(this);
            }
            this.f19289k.delete();
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.f19279a);
            hashMap.put("bin", this.f19284f);
            hashMap.put("e", e.toString());
            hashMap.put(RavenKey.STACK, C7968b.m14426a(e));
            hashMap.put(RavenKey.VERSION, Integer.valueOf(this.f19280b));
            DVMPatchManager.f19298d.mo59023a("tech_dvm_patch_take_effect_error", hashMap);
            throw e;
        }
    }

    public void rollback() {
        if (this.f19288j != null) {
            try {
                DVMPatchManager.takeEffect(this);
                for (String str : this.f19288j) {
                    f19278l.info("try rollback dvm patch:" + str, new Object[0]);
                    File dvmPatchDir = DVMPatchManager.getDvmPatchDir(str);
                    if (dvmPatchDir.exists()) {
                        dvmPatchDir.delete();
                    }
                }
                f19278l.info("rollback dvm patch  done", new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                HashMap hashMap = new HashMap();
                hashMap.put("id", "");
                hashMap.put("e", e.toString());
                hashMap.put(RavenKey.STACK, C7968b.m14426a(e));
                DVMPatchManager.f19298d.mo59023a("tech_dvm_patch_rollback_error", hashMap);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076 A[SYNTHETIC, Splitter:B:38:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0080 A[SYNTHETIC, Splitter:B:43:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzip(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0072 }
            r1.<init>(r5)     // Catch:{ all -> 0x0072 }
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x006e }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x006e }
            r2.<init>(r1)     // Catch:{ all -> 0x006e }
            r5.<init>(r2)     // Catch:{ all -> 0x006e }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x006c }
            boolean r2 = r6.exists()     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x001d
            r6.mkdirs()     // Catch:{ all -> 0x006c }
        L_0x001d:
            java.util.zip.ZipEntry r2 = r5.getNextEntry()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x005a
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "../"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0030
            goto L_0x001d
        L_0x0030:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x006c }
            r4.<init>(r6, r3)     // Catch:{ all -> 0x006c }
            boolean r2 = r2.isDirectory()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x003f
            r4.mkdirs()     // Catch:{ all -> 0x006c }
            goto L_0x001d
        L_0x003f:
            r4.createNewFile()     // Catch:{ all -> 0x006c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x006c }
            r2.<init>(r4)     // Catch:{ all -> 0x006c }
        L_0x0047:
            int r3 = r5.read(r0)     // Catch:{ all -> 0x006c }
            r4 = -1
            if (r3 == r4) goto L_0x0053
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ all -> 0x006c }
            goto L_0x0047
        L_0x0053:
            r2.close()     // Catch:{ all -> 0x006c }
            r5.closeEntry()     // Catch:{ all -> 0x006c }
            goto L_0x001d
        L_0x005a:
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0062:
            r5.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006a:
            r5 = 1
            return r5
        L_0x006c:
            r6 = move-exception
            goto L_0x0070
        L_0x006e:
            r6 = move-exception
            r5 = r0
        L_0x0070:
            r0 = r1
            goto L_0x0074
        L_0x0072:
            r6 = move-exception
            r5 = r0
        L_0x0074:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007e:
            if (r5 == 0) goto L_0x0088
            r5.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0088:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchBean.unzip(java.io.File, java.io.File):boolean");
    }

    public SelfCheckResult selfChecking() {
        SelfCheckResult selfCheckResult = new SelfCheckResult();
        if (!isVersionMatch()) {
            selfCheckResult.f19290ok = false;
            selfCheckResult.msg.add("version not match");
            f19278l.debug("version not match", new Object[0]);
            return selfCheckResult;
        }
        File file = new File(DVMPatchManager.f19297c, this.f19279a);
        if (!file.exists()) {
            selfCheckResult.f19290ok = false;
            selfCheckResult.msg.add("path dir not exists");
            f19278l.debug("selfChecking path dir not exists", new Object[0]);
            return selfCheckResult;
        }
        File file2 = new File(file, "patch.json");
        JSONObject readFile2JSON = DVMPatchManager.readFile2JSON(file2);
        if (readFile2JSON == null) {
            selfCheckResult.f19290ok = false;
            f19278l.debug("remove patch because of patch.json not exists", new Object[0]);
            List<String> list = selfCheckResult.msg;
            list.add(file2 + " not exists");
        }
        String next = readFile2JSON.keys().next();
        this.f19286h = next;
        this.f19287i = readFile2JSON.optJSONObject(next);
        File file3 = new File(file, "data.bin");
        this.f19285g = file3.getAbsolutePath();
        if (!file3.exists()) {
            selfCheckResult.f19290ok = false;
            List<String> list2 = selfCheckResult.msg;
            list2.add(this.f19285g + " not exists");
            f19278l.debug("selfChecking dataFile not exists", new Object[0]);
        }
        return selfCheckResult;
    }

    public JSONObject getPatchInfo() throws JSONException {
        this.f19287i.put("file", this.f19285g);
        return this.f19287i;
    }

    class SelfCheckResult {
        List<String> msg = new ArrayList();

        /* renamed from: ok */
        public boolean f19290ok = true;

        SelfCheckResult() {
        }
    }
}
