package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.BridgeModule;
import com.didi.dimina.container.bridge.plugin.exception.BridgePluginNotFoundException;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSBridgePluginLoader {

    /* renamed from: a */
    private static final String f16598a = JSBridgePluginLoader.class.getSimpleName();

    /* renamed from: b */
    private static final String f16599b = (DMSandboxHelper.DIMINA + File.separator + SDKConsts.MSG_TAG_PLUGIN);

    /* renamed from: c */
    private static List<PluginEntity> f16600c = new ArrayList();

    /* renamed from: d */
    private static Map<String, String> f16601d = new HashMap();

    public static class PluginEntity implements Serializable {
        @SerializedName("components")
        public Map<String, String> components;
        @SerializedName("entry")
        public String entry;
        @SerializedName("permissions")
        public Map<String, String> permissions;
    }

    public static void loadPlugin(Context context) {
        f16600c.clear();
        try {
            for (String c : context.getAssets().list(f16599b)) {
                PluginEntity c2 = m12207c(context, c);
                if (c2 != null) {
                    f16600c.add(c2);
                }
            }
            for (PluginEntity next : f16600c) {
                if (next != null) {
                    if (!TextUtils.isEmpty(next.entry)) {
                        m12204a(next.entry.trim());
                    }
                    if (next.components != null && next.components.size() > 0) {
                        for (String next2 : next.components.keySet()) {
                            m12205a(next2, next.components.get(next2));
                        }
                    }
                    if (next.permissions != null && next.permissions.size() > 0) {
                        for (String next3 : next.permissions.keySet()) {
                            f16601d.put(next3, next.permissions.get(next3));
                        }
                    }
                }
            }
        } catch (Exception unused) {
            LogUtil.iRelease(f16598a, "文件读取失败: ");
        }
    }

    /* renamed from: a */
    private static void m12205a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class<?> cls = Class.forName(str2.trim());
                String str3 = f16598a;
                LogUtil.iRelease(str3, "注册视图组件：" + cls.getName());
                Dimina.registerCustomComponent(str.trim(), cls);
            } catch (Exception unused) {
                String str4 = f16598a;
                LogUtil.iRelease(str4, "加载视图组件失败，类路径不存在: " + str2);
            }
        }
    }

    /* renamed from: a */
    private static void m12204a(String str) {
        try {
            Class<?> cls = Class.forName(str.trim());
            if (((BridgeModule) cls.getAnnotation(BridgeModule.class)) != null) {
                String str2 = f16598a;
                LogUtil.iRelease(str2, "注册同级插件：" + cls.getName());
                Dimina.registerJSModule(cls);
                return;
            }
            String str3 = f16598a;
            LogUtil.iRelease(str3, "注册DMService子插件：" + cls.getName());
            Dimina.registerDMServiceSubJSModule(cls);
        } catch (Exception unused) {
            String str4 = f16598a;
            LogUtil.iRelease(str4, "加载插件失败，插件路径不存在: " + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064 A[SYNTHETIC, Splitter:B:35:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e A[SYNTHETIC, Splitter:B:40:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007a A[SYNTHETIC, Splitter:B:47:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0084 A[SYNTHETIC, Splitter:B:52:0x0084] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didi.dimina.container.bridge.JSBridgePluginLoader.PluginEntity m12203a(android.content.Context r5, java.lang.String r6) throws com.didi.dimina.container.bridge.plugin.exception.BridgePluginNotFoundException {
        /*
            boolean r0 = m12206b(r5, r6)
            if (r0 == 0) goto L_0x008d
            r0 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x005c, all -> 0x0057 }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ Exception -> 0x005c, all -> 0x0057 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            java.lang.String r1 = "UTF-8"
            r6.<init>(r5, r1)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004d }
            r1.<init>(r6)     // Catch:{ Exception -> 0x004d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x004d }
        L_0x0020:
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x004d }
            if (r3 == 0) goto L_0x002a
            r2.append(r3)     // Catch:{ Exception -> 0x004d }
            goto L_0x0020
        L_0x002a:
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x004d }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x004d }
            java.lang.Class<com.didi.dimina.container.bridge.JSBridgePluginLoader$PluginEntity> r2 = com.didi.dimina.container.bridge.JSBridgePluginLoader.PluginEntity.class
            java.lang.Object r1 = com.didi.dimina.container.util.JSONUtil.jsonToObject(r1, r2)     // Catch:{ Exception -> 0x004d }
            com.didi.dimina.container.bridge.JSBridgePluginLoader$PluginEntity r1 = (com.didi.dimina.container.bridge.JSBridgePluginLoader.PluginEntity) r1     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x0044
            r5.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0044:
            r6.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004c:
            return r1
        L_0x004d:
            r1 = move-exception
            goto L_0x005f
        L_0x004f:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0078
        L_0x0054:
            r1 = move-exception
            r6 = r0
            goto L_0x005f
        L_0x0057:
            r5 = move-exception
            r6 = r0
            r0 = r5
            r5 = r6
            goto L_0x0078
        L_0x005c:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x005f:
            r1.printStackTrace()     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x006c
            r5.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006c:
            if (r6 == 0) goto L_0x0076
            r6.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0076:
            return r0
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            if (r5 == 0) goto L_0x0082
            r5.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0082:
            if (r6 == 0) goto L_0x008c
            r6.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008c:
            throw r0
        L_0x008d:
            com.didi.dimina.container.bridge.plugin.exception.BridgePluginNotFoundException r5 = new com.didi.dimina.container.bridge.plugin.exception.BridgePluginNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "assets目录下，不存在该插件路径："
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.JSBridgePluginLoader.m12203a(android.content.Context, java.lang.String):com.didi.dimina.container.bridge.JSBridgePluginLoader$PluginEntity");
    }

    /* renamed from: b */
    private static boolean m12206b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "";
        try {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                str2 = str.substring(0, lastIndexOf);
                str = str.substring(lastIndexOf + 1);
            }
            for (String equals : context.getAssets().list(str2)) {
                if (TextUtils.equals(equals, str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: c */
    private static PluginEntity m12207c(Context context, String str) throws BridgePluginNotFoundException {
        if (!TextUtils.isEmpty(str)) {
            return m12203a(context, f16599b + File.separator + str);
        }
        throw new BridgePluginNotFoundException("插件名称不能为空");
    }

    public static String getPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f16601d.get(str);
    }
}
