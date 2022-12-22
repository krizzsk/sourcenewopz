package com.didichuxing.afanty.beans;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.didichuxing.afanty.common.collector.PackageCollector;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.FloatingView;
import com.didichuxing.omega.sdk.feedback.activity.CommonWebActivity;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONArray;

public class SmileMenuItem {

    /* renamed from: a */
    private boolean f45532a = false;

    /* renamed from: b */
    private TYPE f45533b = null;

    /* renamed from: c */
    private String f45534c = null;

    /* renamed from: d */
    private String f45535d = null;

    /* renamed from: e */
    private String f45536e = "";

    /* renamed from: f */
    private int f45537f;

    /* renamed from: g */
    private String f45538g = null;

    /* renamed from: h */
    private Object[] f45539h = null;

    /* renamed from: i */
    private Class<?>[] f45540i = null;

    /* renamed from: j */
    private String f45541j = null;

    /* renamed from: k */
    private Drawable f45542k;

    /* renamed from: l */
    private String f45543l;

    /* renamed from: m */
    private String f45544m;

    /* renamed from: n */
    private JSONArray f45545n;

    /* renamed from: o */
    private String f45546o;

    /* renamed from: p */
    private Map<String, String> f45547p;

    /* renamed from: q */
    private Context f45548q;

    /* renamed from: r */
    private boolean f45549r = false;

    public enum TYPE {
        NATIVE,
        H5
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SmileMenuItem(android.app.Application r6, java.lang.String r7, java.lang.String r8, android.graphics.drawable.Drawable r9) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.f45532a = r0
            r1 = 0
            r5.f45533b = r1
            r5.f45534c = r1
            r5.f45535d = r1
            java.lang.String r2 = ""
            r5.f45536e = r2
            r5.f45538g = r1
            r5.f45539h = r1
            r5.f45540i = r1
            r5.f45541j = r1
            r5.f45549r = r0
            r5.f45542k = r9
            android.content.Context r9 = r6.getApplicationContext()
            r5.f45548q = r9
            boolean r9 = r2.equals(r8)
            if (r9 == 0) goto L_0x002a
            return
        L_0x002a:
            r5.f45536e = r7
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d7 }
            r9.<init>(r8)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = "zhongce"
            int r8 = r9.optInt(r8)     // Catch:{ JSONException -> 0x01d7 }
            r1 = 1
            if (r8 != r1) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            r5.f45549r = r1     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = "apollo"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45538g = r8     // Catch:{ JSONException -> 0x01d7 }
            if (r8 == 0) goto L_0x010f
            com.didichuxing.apollo.sdk.IToggle r8 = com.didichuxing.apollo.sdk.Apollo.getToggle(r8)     // Catch:{ JSONException -> 0x01d7 }
            boolean r8 = r8.allow()     // Catch:{ JSONException -> 0x01d7 }
            r5.f45532a = r8     // Catch:{ JSONException -> 0x01d7 }
            if (r8 != 0) goto L_0x0055
            return
        L_0x0055:
            java.lang.String r8 = "fix_post_feedback"
            boolean r8 = r8.equals(r7)     // Catch:{ JSONException -> 0x01d7 }
            if (r8 == 0) goto L_0x0074
            r7 = 2131953447(0x7f130727, float:1.9543365E38)
            java.lang.String r7 = r6.getString(r7)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45536e = r7     // Catch:{ JSONException -> 0x01d7 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ JSONException -> 0x01d7 }
            r7 = 2131235836(0x7f0813fc, float:1.8087877E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45542k = r6     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x00be
        L_0x0074:
            java.lang.String r8 = "fix_my_feedback"
            boolean r7 = r8.equals(r7)     // Catch:{ JSONException -> 0x01d7 }
            if (r7 == 0) goto L_0x0093
            r7 = 2131953424(0x7f130710, float:1.9543319E38)
            java.lang.String r7 = r6.getString(r7)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45536e = r7     // Catch:{ JSONException -> 0x01d7 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ JSONException -> 0x01d7 }
            r7 = 2131236292(0x7f0815c4, float:1.8088802E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45542k = r6     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x00be
        L_0x0093:
            java.lang.String r6 = r5.f45538g     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IToggle r6 = com.didichuxing.apollo.sdk.Apollo.getToggle(r6)     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IExperiment r6 = r6.getExperiment()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r7 = "lang"
            java.lang.String r8 = "{}"
            java.lang.Object r6 = r6.getParam(r7, r8)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x01d7 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d7 }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getLang()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r7 = r7.optString(r8)     // Catch:{ JSONException -> 0x01d7 }
            if (r7 == 0) goto L_0x00f8
            boolean r8 = r2.equals(r7)     // Catch:{ JSONException -> 0x01d7 }
            if (r8 != 0) goto L_0x00f8
            r5.f45536e = r7     // Catch:{ JSONException -> 0x01d7 }
        L_0x00be:
            java.lang.String r6 = r5.f45538g     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IToggle r6 = com.didichuxing.apollo.sdk.Apollo.getToggle(r6)     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IExperiment r6 = r6.getExperiment()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r7 = "except_ui"
            java.lang.String r8 = "[]"
            java.lang.Object r6 = r6.getParam(r7, r8)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x01d7 }
            r5.f45544m = r6     // Catch:{ JSONException -> 0x01d7 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00de }
            java.lang.String r7 = r5.f45544m     // Catch:{ JSONException -> 0x00de }
            r6.<init>(r7)     // Catch:{ JSONException -> 0x00de }
            r5.f45545n = r6     // Catch:{ JSONException -> 0x00de }
            goto L_0x010f
        L_0x00de:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01d7 }
            r7.<init>()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = "init except ui fail:"
            r7.append(r8)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x01d7 }
            r7.append(r6)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = r7.toString()     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.afanty.common.utils.OLog.m32668e(r6)     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x010f
        L_0x00f8:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01d7 }
            r7.<init>()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = "can not find lang text! "
            r7.append(r8)     // Catch:{ JSONException -> 0x01d7 }
            r7.append(r6)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = r7.toString()     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.afanty.common.utils.OLog.m32668e(r6)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45532a = r0     // Catch:{ JSONException -> 0x01d7 }
            return
        L_0x010f:
            java.lang.String r6 = "args"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ JSONException -> 0x01d7 }
            boolean r7 = r2.equals(r6)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r8 = "url"
            if (r7 != 0) goto L_0x0191
            if (r6 == 0) goto L_0x0191
            java.lang.String r7 = ","
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ JSONException -> 0x01d7 }
            int r7 = r6.length     // Catch:{ JSONException -> 0x01d7 }
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ JSONException -> 0x01d7 }
            int r1 = r6.length     // Catch:{ JSONException -> 0x01d7 }
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ JSONException -> 0x01d7 }
        L_0x012b:
            int r3 = r6.length     // Catch:{ JSONException -> 0x01d7 }
            if (r0 >= r3) goto L_0x018d
            java.lang.String r3 = "Context.object"
            r4 = r6[r0]     // Catch:{ JSONException -> 0x01d7 }
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x01d7 }
            if (r3 == 0) goto L_0x0143
            android.app.Application r3 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getApplication()     // Catch:{ JSONException -> 0x01d7 }
            r7[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r1[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x018a
        L_0x0143:
            java.lang.String r3 = "Application.object"
            r4 = r6[r0]     // Catch:{ JSONException -> 0x01d7 }
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x01d7 }
            if (r3 == 0) goto L_0x0158
            android.app.Application r3 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getApplication()     // Catch:{ JSONException -> 0x01d7 }
            r7[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
            java.lang.Class<android.app.Application> r3 = android.app.Application.class
            r1[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x018a
        L_0x0158:
            r3 = r6[r0]     // Catch:{ JSONException -> 0x01d7 }
            r7[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
            r3 = r6[r0]     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r4 = "http"
            boolean r3 = r3.startsWith(r4)     // Catch:{ JSONException -> 0x01d7 }
            if (r3 == 0) goto L_0x0186
            java.lang.String r3 = r5.f45538g     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IToggle r3 = com.didichuxing.apollo.sdk.Apollo.getToggle(r3)     // Catch:{ JSONException -> 0x01d7 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r3.getExperiment()     // Catch:{ JSONException -> 0x01d7 }
            java.lang.Object r3 = r3.getParam(r8, r2)     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x01d7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x01d7 }
            if (r4 != 0) goto L_0x0186
            r4 = r6[r0]     // Catch:{ JSONException -> 0x01d7 }
            boolean r4 = r3.equals(r4)     // Catch:{ JSONException -> 0x01d7 }
            if (r4 != 0) goto L_0x0186
            r7[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
        L_0x0186:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r1[r0] = r3     // Catch:{ JSONException -> 0x01d7 }
        L_0x018a:
            int r0 = r0 + 1
            goto L_0x012b
        L_0x018d:
            r5.f45539h = r7     // Catch:{ JSONException -> 0x01d7 }
            r5.f45540i = r1     // Catch:{ JSONException -> 0x01d7 }
        L_0x0191:
            java.lang.String r6 = "type"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ JSONException -> 0x01d7 }
            boolean r7 = r2.equals(r6)     // Catch:{ JSONException -> 0x01d7 }
            if (r7 != 0) goto L_0x01ce
            if (r6 == 0) goto L_0x01ce
            java.lang.String r7 = "native"
            boolean r7 = r7.equals(r6)     // Catch:{ JSONException -> 0x01d7 }
            if (r7 == 0) goto L_0x01bc
            com.didichuxing.afanty.beans.SmileMenuItem$TYPE r6 = com.didichuxing.afanty.beans.SmileMenuItem.TYPE.NATIVE     // Catch:{ JSONException -> 0x01d7 }
            r5.f45533b = r6     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = "className"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45534c = r6     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = "method"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45535d = r6     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x01ce
        L_0x01bc:
            java.lang.String r7 = "h5"
            boolean r6 = r7.equals(r6)     // Catch:{ JSONException -> 0x01d7 }
            if (r6 == 0) goto L_0x01ce
            com.didichuxing.afanty.beans.SmileMenuItem$TYPE r6 = com.didichuxing.afanty.beans.SmileMenuItem.TYPE.H5     // Catch:{ JSONException -> 0x01d7 }
            r5.f45533b = r6     // Catch:{ JSONException -> 0x01d7 }
            java.lang.String r6 = r9.optString(r8)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45541j = r6     // Catch:{ JSONException -> 0x01d7 }
        L_0x01ce:
            java.lang.String r6 = "weight"
            int r6 = r9.optInt(r6)     // Catch:{ JSONException -> 0x01d7 }
            r5.f45537f = r6     // Catch:{ JSONException -> 0x01d7 }
            goto L_0x01f0
        L_0x01d7:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "SmileMenuInit err:"
            r7.append(r8)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.didichuxing.afanty.common.utils.OLog.m32668e(r6)
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.afanty.beans.SmileMenuItem.<init>(android.app.Application, java.lang.String, java.lang.String, android.graphics.drawable.Drawable):void");
    }

    public SmileMenuItem(Application application, Drawable drawable) {
        this.f45542k = drawable;
    }

    public void doAction(Application application) {
        String str;
        if (this.f45545n != null) {
            for (int i = 0; i < this.f45545n.length(); i++) {
                String optString = this.f45545n.optString(i);
                if (!"".equals(optString)) {
                    FloatingViewApi.addExceptActivity(optString);
                }
            }
        }
        if (this.f45533b == TYPE.NATIVE) {
            reflectInvoke();
        } else if (this.f45533b == TYPE.H5 && (str = this.f45541j) != null) {
            if (str.contains("?")) {
                FloatingView.startAfantyWebView(this.f45541j + "&_=" + System.currentTimeMillis());
                return;
            }
            FloatingView.startAfantyWebView(this.f45541j + "?_=" + System.currentTimeMillis());
        }
    }

    public void reflectInvoke() {
        Method method;
        if (this.f45549r) {
            m32655a();
        } else if (!TextUtils.isEmpty(this.f45534c) && !TextUtils.isEmpty(this.f45535d)) {
            if ("makeJavaCrash".equals(this.f45535d)) {
                FloatingView.makeJavaCrash();
            } else if ("makeJavaCrashNewThread".equals(this.f45535d)) {
                FloatingView.makeJavaCrashNewThread();
            } else if ("makeNativeCrash".equals(this.f45535d)) {
                FloatingView.makeNativeCrash();
            } else if ("makeNativeCrashNewThread".equals(this.f45535d)) {
                FloatingView.makeNativeCrashNewThread();
            } else if ("makeOOMReport".equals(this.f45535d)) {
                FloatingView.makeOOMReport();
            } else if ("makeJavaOOM".equals(this.f45535d)) {
                FloatingView.makeJavaOOM();
            } else if ("makeJavaOOM2".equals(this.f45535d)) {
                FloatingView.makeJavaOOM2();
            } else if ("makeAnr".equals(this.f45535d)) {
                FloatingView.makeAnr();
            } else if ("makeCarton".equals(this.f45535d)) {
                FloatingView.makeCarton();
            }
            try {
                Class<?> cls = Class.forName(this.f45534c);
                if (this.f45540i == null || this.f45540i.length <= 0) {
                    method = cls.getMethod(this.f45535d, new Class[0]);
                } else {
                    method = cls.getMethod(this.f45535d, this.f45540i);
                }
                if (method != null) {
                    Object newInstance = cls.newInstance();
                    if (this.f45539h == null || this.f45539h.length <= 0) {
                        method.invoke(newInstance, new Object[0]);
                    } else {
                        method.invoke(newInstance, this.f45539h);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OLog.m32668e("reflectInvoke failed. " + e);
            }
        }
    }

    /* renamed from: a */
    private void m32655a() {
        try {
            if ("com.sdu.didi.gsui".equals(PackageCollector.getPkgName())) {
                Class<?> cls = Class.forName("com.sdu.didi.util.WebUtils");
                cls.getDeclaredMethod("openWebView", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(cls.newInstance(), new Object[]{this.f45548q, "title", this.f45539h, true});
                return;
            }
            Intent intent = new Intent(this.f45548q, Class.forName("com.didi.sdk.webview.WebActivity"));
            intent.putExtra("title", this.f45536e);
            intent.putExtra("url", this.f45539h[0].toString());
            intent.putExtra("webview_title", "webview_title");
            intent.putExtra("webview_url", this.f45536e);
            this.f45548q.startActivity(intent);
        } catch (Exception unused) {
            this.f45549r = false;
            reflectInvoke();
        }
    }

    public void openWebView(String str) {
        Activity currentActivity = SwarmUtil.getCurrentActivity();
        Intent intent = new Intent(currentActivity, CommonWebActivity.class);
        intent.putExtra("url", str);
        currentActivity.startActivity(intent);
    }

    public boolean isVisiable() {
        return this.f45532a;
    }

    public void setVisiable(boolean z) {
        this.f45532a = z;
    }

    public String getText() {
        String str = this.f45536e;
        if (str == null || "".equals(str)) {
            return this.f45546o;
        }
        return this.f45536e;
    }

    public void setText(String str) {
        this.f45536e = str;
    }

    public int getWeight() {
        return this.f45537f;
    }

    public void setWeight(int i) {
        this.f45537f = i;
    }

    public Drawable getIcon() {
        return this.f45542k;
    }

    public String getMenuLabel() {
        return this.f45543l;
    }

    public void setMenuLabel(String str) {
        this.f45543l = str;
    }

    public TYPE getType() {
        return this.f45533b;
    }

    public void setType(TYPE type) {
        this.f45533b = type;
    }

    public String getClassName() {
        return this.f45534c;
    }

    public void setClassName(String str) {
        this.f45534c = str;
    }

    public String getMethodName() {
        return this.f45535d;
    }

    public void setMethodName(String str) {
        this.f45535d = str;
    }

    public String getApollo() {
        return this.f45538g;
    }

    public void setApollo(String str) {
        this.f45538g = str;
    }

    public String getUrl() {
        return this.f45541j;
    }

    public void setUrl(String str) {
        this.f45541j = str;
    }

    public String getDefaultText() {
        return this.f45546o;
    }

    public void setDefaultText(String str) {
        this.f45546o = str;
    }

    public Map<String, String> getLangMap() {
        return this.f45547p;
    }

    public void setLangMap(Map<String, String> map) {
        this.f45547p = map;
    }

    public Object[] getParams() {
        return this.f45539h;
    }

    public void setParams(Object[] objArr) {
        this.f45539h = objArr;
    }

    public Class<?>[] getTypes() {
        return this.f45540i;
    }

    public void setTypes(Class<?>[] clsArr) {
        this.f45540i = clsArr;
    }

    public JSONArray getJaExceptUi() {
        return this.f45545n;
    }

    public void setJaExceptUi(JSONArray jSONArray) {
        this.f45545n = jSONArray;
    }
}
