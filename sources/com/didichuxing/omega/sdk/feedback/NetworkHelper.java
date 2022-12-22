package com.didichuxing.omega.sdk.feedback;

import com.didi.soda.customer.app.constant.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NetworkHelper {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00fc, code lost:
        if (r1 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0108, code lost:
        if (r1 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010a, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPersonInfo() {
        /*
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r0 = r0.getTime()
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r2 = new com.didichuxing.omega.sdk.feedback.util.ApiSigner
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "api=1&ts="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.String r6 = "api"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r5 = r2.add((java.lang.String) r6, (java.lang.Object) r5)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "ts"
            r5.add((java.lang.String) r1, (java.lang.Object) r0)
            java.lang.String r0 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getUserUid()
            java.lang.String r1 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getUserPhone()
            r5 = 0
            if (r1 == 0) goto L_0x0062
            java.lang.String r6 = r1.trim()
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = "&phone="
            r0.append(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "phone"
            r2.add((java.lang.String) r3, (java.lang.String) r1)
            goto L_0x0088
        L_0x0062:
            if (r0 == 0) goto L_0x0116
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0116
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = "&uid="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "uid"
            r2.add((java.lang.String) r3, (java.lang.String) r0)
            r0 = r1
        L_0x0088:
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0103, all -> 0x0101 }
            java.lang.String r3 = "http://omgup.didiglobal.com/feedback/query/my/stat"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0103, all -> 0x0101 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0103, all -> 0x0101 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0103, all -> 0x0101 }
            r1.setDoOutput(r4)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = "POST"
            r1.setRequestMethod(r3)     // Catch:{ Exception -> 0x00ff }
            r3 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00ff }
            r1.setReadTimeout(r3)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = "token"
            java.lang.String r2 = r2.getToken()     // Catch:{ Exception -> 0x00ff }
            r1.addRequestProperty(r3, r2)     // Catch:{ Exception -> 0x00ff }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ Exception -> 0x00ff }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x00ff }
            r2.write(r0)     // Catch:{ Exception -> 0x00ff }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ Exception -> 0x00ff }
            r0.flush()     // Catch:{ Exception -> 0x00ff }
            int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x00ff }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x00fc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r0.<init>()     // Catch:{ Exception -> 0x00ff }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00ff }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ff }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ff }
            java.lang.String r6 = "utf-8"
            r4.<init>(r2, r6)     // Catch:{ Exception -> 0x00ff }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00ff }
        L_0x00dd:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00ff }
            if (r4 == 0) goto L_0x00ec
            r0.append(r4)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch:{ Exception -> 0x00ff }
            goto L_0x00dd
        L_0x00ec:
            r2.close()     // Catch:{ Exception -> 0x00ff }
            r3.close()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00ff }
            if (r1 == 0) goto L_0x00fb
            r1.disconnect()
        L_0x00fb:
            return r0
        L_0x00fc:
            if (r1 == 0) goto L_0x010d
            goto L_0x010a
        L_0x00ff:
            r0 = move-exception
            goto L_0x0105
        L_0x0101:
            r0 = move-exception
            goto L_0x0110
        L_0x0103:
            r0 = move-exception
            r1 = r5
        L_0x0105:
            r0.printStackTrace()     // Catch:{ all -> 0x010e }
            if (r1 == 0) goto L_0x010d
        L_0x010a:
            r1.disconnect()
        L_0x010d:
            return r5
        L_0x010e:
            r0 = move-exception
            r5 = r1
        L_0x0110:
            if (r5 == 0) goto L_0x0115
            r5.disconnect()
        L_0x0115:
            throw r0
        L_0x0116:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.NetworkHelper.getPersonInfo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00e1, code lost:
        if (r1 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f1, code lost:
        if (r1 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f3, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f6, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFeatureList(java.lang.String r6) {
        /*
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r0 = r0.getTime()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "api=3&ts="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "&appname="
            r2.append(r3)
            java.lang.String r3 = com.didichuxing.afanty.common.collector.PackageCollector.getPkgName()
            r2.append(r3)
            java.lang.String r3 = "&appversion="
            r2.append(r3)
            java.lang.String r3 = com.didichuxing.afanty.common.collector.PackageCollector.getVN()
            r2.append(r3)
            java.lang.String r3 = "&from="
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r3 = new com.didichuxing.omega.sdk.feedback.util.ApiSigner
            r3.<init>()
            java.lang.String r4 = "api"
            java.lang.String r5 = "3"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r3 = r3.add((java.lang.String) r4, (java.lang.String) r5)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "ts"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r0 = r3.add((java.lang.String) r1, (java.lang.Object) r0)
            java.lang.String r1 = com.didichuxing.afanty.common.collector.PackageCollector.getPkgName()
            java.lang.String r3 = "appname"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r0 = r0.add((java.lang.String) r3, (java.lang.String) r1)
            java.lang.String r1 = com.didichuxing.afanty.common.collector.PackageCollector.getVN()
            java.lang.String r3 = "appversion"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r0 = r0.add((java.lang.String) r3, (java.lang.String) r1)
            java.lang.String r1 = "from"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r6 = r0.add((java.lang.String) r1, (java.lang.String) r6)
            java.lang.String r6 = r6.getToken()
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00f0, all -> 0x00e9 }
            java.lang.String r3 = "http://omgup.didiglobal.com/feedback/V2/conf"
            r1.<init>(r3)     // Catch:{ Exception -> 0x00f0, all -> 0x00e9 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00f0, all -> 0x00e9 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00f0, all -> 0x00e9 }
            r3 = 1
            r1.setDoOutput(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "POST"
            r1.setRequestMethod(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r3 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r1.setReadTimeout(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "token"
            r1.addRequestProperty(r3, r6)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.io.OutputStream r6 = r1.getOutputStream()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r6.write(r2)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.io.OutputStream r6 = r1.getOutputStream()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r6.flush()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            int r6 = r1.getResponseCode()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L_0x00e1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r6.<init>()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r5 = "utf-8"
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
        L_0x00c2:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r4 == 0) goto L_0x00d1
            r6.append(r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r4 = "\n"
            r6.append(r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            goto L_0x00c2
        L_0x00d1:
            r2.close()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r3.close()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r1 == 0) goto L_0x00e0
            r1.disconnect()
        L_0x00e0:
            return r6
        L_0x00e1:
            if (r1 == 0) goto L_0x00f6
            goto L_0x00f3
        L_0x00e4:
            r6 = move-exception
            r0 = r1
            goto L_0x00ea
        L_0x00e7:
            goto L_0x00f1
        L_0x00e9:
            r6 = move-exception
        L_0x00ea:
            if (r0 == 0) goto L_0x00ef
            r0.disconnect()
        L_0x00ef:
            throw r6
        L_0x00f0:
            r1 = r0
        L_0x00f1:
            if (r1 == 0) goto L_0x00f6
        L_0x00f3:
            r1.disconnect()
        L_0x00f6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.NetworkHelper.getFeatureList(java.lang.String):java.lang.String");
    }

    public static List<FeatureTeam> getFeatureFromJson(String str, List<FeatureTeam> list) {
        String str2;
        List<FeatureTeam> list2 = list;
        String str3 = Const.PageParams.SUB_ITEMS;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("features");
            int i = 0;
            while (i < jSONArray.length()) {
                FeatureTeam featureTeam = new FeatureTeam();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("value");
                String string = jSONObject.getString("name");
                boolean has = jSONObject.has(str3);
                boolean has2 = jSONObject.has("cw");
                ArrayList arrayList = new ArrayList();
                if (has) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(str3);
                    str2 = str3;
                    int i3 = 0;
                    while (i3 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                        JSONArray jSONArray3 = jSONArray;
                        FeatureTeam featureTeam2 = new FeatureTeam();
                        JSONArray jSONArray4 = jSONArray2;
                        featureTeam2.setId(jSONObject2.getInt("value"));
                        featureTeam2.setName(jSONObject2.getString("name"));
                        featureTeam2.setHasSub(false);
                        if (jSONObject2.has("cw")) {
                            featureTeam2.setHasCW(true);
                            featureTeam2.setCw(jSONObject2.getString("cw"));
                        } else {
                            featureTeam2.setHasCW(false);
                        }
                        arrayList.add(featureTeam2);
                        i3++;
                        jSONArray = jSONArray3;
                        jSONArray2 = jSONArray4;
                    }
                } else {
                    str2 = str3;
                }
                JSONArray jSONArray5 = jSONArray;
                if (has2) {
                    featureTeam.setCw(jSONObject.getString("cw"));
                }
                featureTeam.setId(i2);
                featureTeam.setName(string);
                featureTeam.setHasSub(has);
                featureTeam.setHasCW(has2);
                featureTeam.setFeatureTeams(arrayList);
                list2.add(featureTeam);
                i++;
                str3 = str2;
                jSONArray = jSONArray5;
            }
            FeatureTeam featureTeam3 = new FeatureTeam();
            featureTeam3.setId(-1);
            featureTeam3.setName(FeedbackConfig.AFANTY_CHOOSE_BUT_TYPE);
            featureTeam3.setHasSub(false);
            featureTeam3.setHasCW(false);
            featureTeam3.setFeatureTeams(new ArrayList());
            list2.add(0, featureTeam3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0136, code lost:
        if (r9 != null) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0146, code lost:
        if (r9 != null) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0148, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFeedbackRecords(int r8, int r9) {
        /*
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r0 = r0.getTime()
            int r2 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getAppType()
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r3 = new com.didichuxing.omega.sdk.feedback.util.ApiSigner
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "api=1&ts="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = "&app="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = "&index="
            r4.append(r5)
            r4.append(r8)
            java.lang.String r5 = "&count="
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "api"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r6 = r3.add((java.lang.String) r7, (java.lang.Object) r6)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "ts"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r0 = r6.add((java.lang.String) r1, (java.lang.Object) r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "app"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r0 = r0.add((java.lang.String) r2, (java.lang.Object) r1)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r1 = "index"
            com.didichuxing.omega.sdk.feedback.util.ApiSigner r8 = r0.add((java.lang.String) r1, (java.lang.Object) r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "count"
            r8.add((java.lang.String) r0, (java.lang.Object) r9)
            java.lang.String r8 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getUserUid()
            java.lang.String r9 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getUserPhone()
            r0 = 0
            if (r9 == 0) goto L_0x009c
            java.lang.String r1 = r9.trim()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x009c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r1 = "&phone="
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r1 = "phone"
            r3.add((java.lang.String) r1, (java.lang.String) r9)
            goto L_0x00c2
        L_0x009c:
            if (r8 == 0) goto L_0x014b
            java.lang.String r9 = r8.trim()
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x014b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r1 = "&uid="
            r9.append(r1)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            java.lang.String r1 = "uid"
            r3.add((java.lang.String) r1, (java.lang.String) r8)
            r8 = r9
        L_0x00c2:
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0145, all -> 0x013e }
            java.lang.String r1 = "http://omgup.didiglobal.com/feedback/query/my"
            r9.<init>(r1)     // Catch:{ Exception -> 0x0145, all -> 0x013e }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x0145, all -> 0x013e }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x0145, all -> 0x013e }
            r9.setDoOutput(r5)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r1 = "POST"
            r9.setRequestMethod(r1)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r1 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r1)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r9.setReadTimeout(r1)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r1 = "token"
            java.lang.String r2 = r3.getToken()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r9.addRequestProperty(r1, r2)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.io.OutputStream r1 = r9.getOutputStream()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r1.write(r8)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.io.OutputStream r8 = r9.getOutputStream()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r8.flush()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            int r8 = r9.getResponseCode()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r8 != r1) goto L_0x0136
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r8.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.io.InputStream r1 = r9.getInputStream()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r4 = "utf-8"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
        L_0x0117:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            if (r3 == 0) goto L_0x0126
            r8.append(r3)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r3 = "\n"
            r8.append(r3)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            goto L_0x0117
        L_0x0126:
            r1.close()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r2.close()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            if (r9 == 0) goto L_0x0135
            r9.disconnect()
        L_0x0135:
            return r8
        L_0x0136:
            if (r9 == 0) goto L_0x014b
            goto L_0x0148
        L_0x0139:
            r8 = move-exception
            r0 = r9
            goto L_0x013f
        L_0x013c:
            goto L_0x0146
        L_0x013e:
            r8 = move-exception
        L_0x013f:
            if (r0 == 0) goto L_0x0144
            r0.disconnect()
        L_0x0144:
            throw r8
        L_0x0145:
            r9 = r0
        L_0x0146:
            if (r9 == 0) goto L_0x014b
        L_0x0148:
            r9.disconnect()
        L_0x014b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.NetworkHelper.getFeedbackRecords(int, int):java.lang.String");
    }
}
