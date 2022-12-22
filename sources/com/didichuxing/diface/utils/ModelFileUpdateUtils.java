package com.didichuxing.diface.utils;

import android.content.Context;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelTaskManager;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelFileUpdateUtils {

    public interface IDownloadUnzipListener {
        void onDownloadUnzipDone(boolean z);
    }

    public static boolean updateModelFiles(File file, File file2) {
        return true;
    }

    public static boolean updateModelFiles2(File file, File file2) {
        return true;
    }

    private ModelFileUpdateUtils() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m34026b(String str) {
        return !str.startsWith(".") && str.endsWith(".bin");
    }

    /* renamed from: c */
    private static boolean m34027c(String str) {
        return str.endsWith(".old");
    }

    /* renamed from: a */
    private static boolean m34024a(File[] fileArr, boolean z) {
        boolean z2;
        if (fileArr == null) {
            return false;
        }
        boolean z3 = true;
        for (File file : fileArr) {
            String name = file.getName();
            if (z) {
                if (m34026b(name)) {
                    z2 = file.renameTo(new File(file.getParentFile(), name + ".old"));
                }
            } else if (m34027c(name)) {
                z2 = file.renameTo(new File(file.getParentFile(), name.substring(0, name.length() - 4)));
            }
            z3 &= z2;
        }
        return z3;
    }

    public static String getModelFilesVersion() {
        File[] listFiles = new File(AlgoModelTaskManager.getModelDir(DiFaceFacade.getInstance().getAppContext(), 0)).listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return ModelFileUpdateUtils.m34026b(str);
            }
        });
        if (listFiles == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (File file : listFiles) {
            try {
                jSONObject.put(file.getName(), FileUtils.fileToMD5(file));
            } catch (JSONException e) {
                LogUtils.logStackTrace(e);
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static void m34022a(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return ModelFileUpdateUtils.m34026b(str);
            }
        });
        if (listFiles != null) {
            DFileUtils.delFiles(Arrays.asList(listFiles));
        }
    }

    /* renamed from: b */
    private static void m34025b(File file) {
        LogUtils.m33563d("dir contents======" + Arrays.toString(file.listFiles()));
    }

    public static void downloadModelFiles(Context context, String str, final File file, final IDownloadUnzipListener iDownloadUnzipListener) {
        ((HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http")).newRpc(new HttpRpcRequest.Builder().get(str).build()).enqueue(new HttpRpc.Callback() {
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r7) {
                /*
                    r6 = this;
                    r0 = 0
                    r1 = 0
                    com.didichuxing.foundation.net.http.HttpEntity r7 = r7.getEntity()     // Catch:{ IOException -> 0x0031, all -> 0x002e }
                    java.io.InputStream r7 = r7.getContent()     // Catch:{ IOException -> 0x0031, all -> 0x002e }
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0029, all -> 0x0027 }
                    java.io.File r3 = r3     // Catch:{ IOException -> 0x0029, all -> 0x0027 }
                    r2.<init>(r3)     // Catch:{ IOException -> 0x0029, all -> 0x0027 }
                    r1 = 4096(0x1000, float:5.74E-42)
                    byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x0025 }
                L_0x0015:
                    int r3 = r7.read(r1)     // Catch:{ IOException -> 0x0025 }
                    r4 = -1
                    if (r3 == r4) goto L_0x0023
                    r2.write(r1, r0, r3)     // Catch:{ IOException -> 0x0025 }
                    r2.flush()     // Catch:{ IOException -> 0x0025 }
                    goto L_0x0015
                L_0x0023:
                    r0 = 1
                    goto L_0x0038
                L_0x0025:
                    r1 = move-exception
                    goto L_0x0035
                L_0x0027:
                    r0 = move-exception
                    goto L_0x0070
                L_0x0029:
                    r2 = move-exception
                    r5 = r2
                    r2 = r1
                    r1 = r5
                    goto L_0x0035
                L_0x002e:
                    r0 = move-exception
                    r7 = r1
                    goto L_0x0070
                L_0x0031:
                    r7 = move-exception
                    r2 = r1
                    r1 = r7
                    r7 = r2
                L_0x0035:
                    com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(r1)     // Catch:{ all -> 0x006e }
                L_0x0038:
                    com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r2)
                    com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r7)
                    if (r0 == 0) goto L_0x005c
                    com.didichuxing.diface.core.DiFaceFacade r7 = com.didichuxing.diface.core.DiFaceFacade.getInstance()
                    java.lang.String r0 = "55"
                    r7.report(r0)
                    java.io.File r7 = r3
                    java.io.File r0 = r7.getParentFile()
                    boolean r7 = com.didichuxing.diface.utils.ModelFileUpdateUtils.updateModelFiles(r7, r0)
                    com.didichuxing.diface.utils.ModelFileUpdateUtils$3$1 r0 = new com.didichuxing.diface.utils.ModelFileUpdateUtils$3$1
                    r0.<init>(r7)
                    com.didichuxing.dfbasesdk.utils.UIHandler.post(r0)
                    goto L_0x006d
                L_0x005c:
                    com.didichuxing.diface.core.DiFaceFacade r7 = com.didichuxing.diface.core.DiFaceFacade.getInstance()
                    java.lang.String r0 = "56"
                    r7.report(r0)
                    com.didichuxing.diface.utils.ModelFileUpdateUtils$3$2 r7 = new com.didichuxing.diface.utils.ModelFileUpdateUtils$3$2
                    r7.<init>()
                    com.didichuxing.dfbasesdk.utils.UIHandler.post(r7)
                L_0x006d:
                    return
                L_0x006e:
                    r0 = move-exception
                    r1 = r2
                L_0x0070:
                    com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r1)
                    com.didichuxing.dfbasesdk.utils.IOUtils.closeQuietly(r7)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.utils.ModelFileUpdateUtils.C155043.onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):void");
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                UIHandler.post(new Runnable() {
                    public void run() {
                        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_MODEL_DOWNLOAD_FAIL);
                        iDownloadUnzipListener.onDownloadUnzipDone(false);
                    }
                });
            }
        });
    }
}
