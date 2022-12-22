package com.didichuxing.omega.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.payment.util.PaymentConstant;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import com.didichuxing.omega.sdk.analysis.AnalysisPageListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UIAutoTracker {
    private static final String UIAutoTracker_Tag = "Tracker_screenshot";
    private static int duplicateCount = 0;
    private static MyOnGlobalLayoutListener globalLayoutListener = null;
    private static String lastPn = "";
    private static String lastRpn = "";
    private static long startTime;

    public static void activityResumed(Activity activity) {
        if (OmegaConfig.SWITCH_FULL_AUTO_UI || OmegaConfig.DEBUG_MODEL) {
            View decorView = activity.getWindow().getDecorView();
            if (UIAutoMarker.getViewNameMap(activity).size() == 0) {
                globalLayoutListener = new MyOnGlobalLayoutListener(decorView, activity);
                decorView.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
            }
        }
    }

    public static void activityPaused(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (globalLayoutListener != null) {
            decorView.getViewTreeObserver().removeGlobalOnLayoutListener(globalLayoutListener);
            globalLayoutListener.onDestroy();
            globalLayoutListener = null;
        }
    }

    public static class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private Activity activity;
        private View view;

        public MyOnGlobalLayoutListener(View view2, Activity activity2) {
            this.view = view2;
            this.activity = activity2;
        }

        public void onGlobalLayout() {
            UIAutoTracker.traverseView(this.view, this.activity);
        }

        public void onDestroy() {
            UIAutoTracker.releaseDelegate(this.view);
        }
    }

    /* access modifiers changed from: private */
    public static void releaseDelegate(View view) {
        if (view != null) {
            view.setAccessibilityDelegate((View.AccessibilityDelegate) null);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    releaseDelegate(viewGroup.getChildAt(i));
                }
            }
        }
    }

    private static boolean isHitSampleScreenShot(Activity activity) {
        if (!OmegaConfig.SWITCH_SCREENSHOT) {
            return false;
        }
        String omegaId = PersistentInfoCollector.getOmegaId();
        String simplifyClassName = activity != null ? CommonUtil.simplifyClassName(activity.getClass().getName()) : "UNKNOWN";
        String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
        if (currentFramentName == null) {
            currentFramentName = simplifyClassName;
        }
        if (((int) (OmegaConfig.SCREENSHOT_SAMPLE_RATE * 10000.0d)) >= Math.abs((omegaId + simplifyClassName + currentFramentName).hashCode()) % 10000 && !PersistentInfoCollector.hasCurVersionUploadScreenShot(PackageCollector.getVN())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void traverseView(View view, Activity activity) {
        JSONArray jSONArray = ((OmegaConfig.DEBUG_MODEL || isHitSampleScreenShot(activity)) && CommonUtil.getAPILevel() >= 14) ? new JSONArray() : null;
        try {
            WeakHashMap<View, String> viewNameMap = UIAutoMarker.getViewNameMap(activity);
            if (viewNameMap != null) {
                doTraverseView(activity, view, viewNameMap, new HashMap(), 0, "ROOT", 0, jSONArray);
            }
        } catch (Throwable unused) {
            OLog.m34769w("doTraverseView fail");
        }
        if (jSONArray == null) {
            return;
        }
        if (view.isShown()) {
            try {
                genOMGVI(activity, view, jSONArray);
            } catch (Throwable unused2) {
                OLog.m34769w("genOMGVI fail");
            }
        } else {
            OLog.m34761d("NO OMGVI, not shown.");
        }
    }

    static String bitMapCompress(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float sampleSize = getSampleSize(width, height);
        if (1.0d - ((double) sampleSize) > 1.0E-4d) {
            Matrix matrix = new Matrix();
            matrix.postScale(sampleSize, sampleSize);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, OmegaConfig.PIC_COMPRESS_QUALITY, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float getSampleSize(int r5, int r6) {
        /*
            float r0 = com.didichuxing.omega.sdk.common.OmegaConfig.PIC_IMAGE_SIZE
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r5 <= r6) goto L_0x000d
            float r2 = (float) r5
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x000d
            float r0 = r0 / r2
            goto L_0x0018
        L_0x000d:
            if (r5 >= r6) goto L_0x0016
            float r5 = (float) r6
            int r6 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x0016
            float r0 = r0 / r5
            goto L_0x0018
        L_0x0016:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x0018:
            double r5 = (double) r0
            r2 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x002d
            r2 = 4607182463836013682(0x3ff0000a7c5ac472, double:1.00001)
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = r0
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.UIAutoTracker.getSampleSize(int, int):float");
    }

    private static boolean isNeedUpload() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        duplicateCount++;
        if (((double) (System.currentTimeMillis() - startTime)) < OmegaConfig.OMGVI_DELAY_TIME) {
            return false;
        }
        duplicateCount = 1;
        startTime = System.currentTimeMillis();
        return true;
    }

    private static Class getMapViewClass() {
        try {
            return Class.forName("com.didi.common.map.MapView");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Field getChildrenField(Class cls) {
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField("mChildren");
                if (declaredField != null) {
                    return declaredField;
                }
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void getMapView(View view, ArrayList<View> arrayList) {
        if (view != null) {
            SystemUtils.log(6, UIAutoTracker_Tag, view.getClass().getCanonicalName(), (Throwable) null, "com.didichuxing.omega.sdk.UIAutoTracker", 332);
            Class<?> cls = view.getClass();
            if (cls == getMapViewClass()) {
                arrayList.add(view);
            }
            try {
                Field childrenField = getChildrenField(cls);
                if (childrenField != null) {
                    childrenField.setAccessible(true);
                    Object obj = childrenField.get(view);
                    if (obj instanceof View[]) {
                        for (View mapView : (View[]) obj) {
                            getMapView(mapView, arrayList);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void genOMGVI(Activity activity, View view, JSONArray jSONArray) {
        if (isNeedUpload()) {
            JSONObject jSONObject = new JSONObject();
            String str = "UNKNOWN";
            if (activity != null) {
                try {
                    str = CommonUtil.simplifyClassName(activity.getClass().getName());
                } catch (JSONException unused) {
                }
            }
            String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
            String encryptBlackItem = OmegaConfig.encryptBlackItem(AnalysisPageListener.getCurrentPageName());
            if (!TextUtils.isEmpty(encryptBlackItem)) {
                jSONObject.put("spn", encryptBlackItem);
            }
            String encryptBlackItem2 = OmegaConfig.encryptBlackItem(str);
            if (!TextUtils.isEmpty(encryptBlackItem2)) {
                jSONObject.put("rpn", encryptBlackItem2);
            }
            if (currentFramentName == null) {
                currentFramentName = encryptBlackItem2;
            }
            String encryptBlackItem3 = OmegaConfig.encryptBlackItem(currentFramentName);
            if (!TextUtils.isEmpty(encryptBlackItem3)) {
                jSONObject.put("pn", encryptBlackItem3);
            }
            jSONObject.put("rl", jSONArray);
            omgvi((Bitmap) null, jSONObject, view, (int[]) null);
        }
    }

    private static void omgvi(Bitmap bitmap, JSONObject jSONObject, View view, int[] iArr) {
        Bitmap bitmap2;
        View view2 = view;
        view2.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (!(bitmap == null || iArr == null)) {
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache.getWidth(), drawingCache.getHeight(), Bitmap.Config.RGB_565);
            int[] iArr2 = new int[(bitmap.getWidth() * bitmap.getHeight())];
            bitmap.getPixels(iArr2, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            Bitmap bitmap3 = createBitmap;
            createBitmap.setPixels(iArr2, 0, bitmap.getWidth(), iArr[0], iArr[1], bitmap.getWidth(), bitmap.getHeight());
            if (iArr[1] > 0) {
                int[] iArr3 = new int[(drawingCache.getWidth() * iArr[1])];
                Bitmap bitmap4 = bitmap3;
                drawingCache.getPixels(iArr3, 0, drawingCache.getWidth(), 0, 0, drawingCache.getWidth(), iArr[1]);
                bitmap3 = bitmap4;
                bitmap4.setPixels(iArr3, 0, drawingCache.getWidth(), 0, 0, drawingCache.getWidth(), iArr[1]);
            }
            if ((drawingCache.getHeight() - iArr[1]) - bitmap.getHeight() > 0) {
                int[] iArr4 = new int[(drawingCache.getWidth() * ((drawingCache.getHeight() - iArr[1]) - bitmap.getHeight()))];
                Bitmap bitmap5 = bitmap3;
                drawingCache.getPixels(iArr4, 0, drawingCache.getWidth(), 0, iArr[1] + bitmap.getHeight(), drawingCache.getWidth(), (drawingCache.getHeight() - iArr[1]) - bitmap.getHeight());
                bitmap3 = bitmap5;
                bitmap5.setPixels(iArr4, 0, drawingCache.getWidth(), 0, iArr[1] + bitmap.getHeight(), drawingCache.getWidth(), (drawingCache.getHeight() - iArr[1]) - bitmap.getHeight());
            }
            if (iArr[0] > 0) {
                int[] iArr5 = new int[(iArr[0] * bitmap.getHeight())];
                Bitmap bitmap6 = bitmap3;
                drawingCache.getPixels(iArr5, 0, iArr[0], 0, iArr[1], iArr[0], bitmap.getHeight());
                bitmap3 = bitmap6;
                bitmap6.setPixels(iArr5, 0, iArr[0], 0, iArr[1], iArr[0], bitmap.getHeight());
            }
            if ((drawingCache.getWidth() - iArr[0]) - bitmap.getWidth() > 0) {
                int[] iArr6 = new int[(((drawingCache.getWidth() - iArr[0]) - bitmap.getWidth()) * bitmap.getHeight())];
                Bitmap bitmap7 = bitmap3;
                drawingCache.getPixels(iArr6, 0, (drawingCache.getWidth() - iArr[0]) - bitmap.getWidth(), iArr[0] + bitmap.getWidth(), iArr[1], (drawingCache.getWidth() - iArr[0]) - bitmap.getWidth(), bitmap.getHeight());
                bitmap2 = bitmap7;
                bitmap7.setPixels(iArr6, 0, (drawingCache.getWidth() - iArr[0]) - bitmap.getWidth(), iArr[0] + bitmap.getWidth(), iArr[1], (drawingCache.getWidth() - iArr[0]) - bitmap.getWidth(), bitmap.getHeight());
            } else {
                bitmap2 = bitmap3;
            }
            for (int i = iArr[0]; i < iArr[0] + bitmap.getWidth(); i++) {
                for (int i2 = iArr[1]; i2 < iArr[1] + bitmap.getHeight(); i2++) {
                    int pixel = drawingCache.getPixel(i, i2);
                    if (pixel != 0) {
                        bitmap2.setPixel(i, i2, pixel);
                    }
                }
            }
            drawingCache = bitmap2;
        }
        if (drawingCache != null) {
            Event event = new Event("OMGVI");
            event.setFrom("vi");
            event.putAttr("vs", jSONObject.toString());
            event.putAttr("ss", bitMapCompress(drawingCache));
            event.putAttr("ssw", Integer.valueOf(view.getWidth()));
            event.putAttr("ssh", Integer.valueOf(view.getHeight()));
            Tracker.trackEvent(event);
        }
        view2.setDrawingCacheEnabled(false);
    }

    public static String getResourceName(View view) {
        try {
            if (view.getId() >= 0) {
                return view.getResources().getResourceEntryName(view.getId());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doTraverseView(android.app.Activity r18, android.view.View r19, java.util.Map<android.view.View, java.lang.String> r20, java.util.Map<java.lang.String, java.lang.Integer> r21, int r22, java.lang.String r23, int r24, org.json.JSONArray r25) throws org.json.JSONException {
        /*
            r0 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r25
            boolean r1 = r8.containsKey(r0)
            r2 = 0
            r12 = 1
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r8.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r13 = r18
        L_0x001a:
            r14 = r1
            goto L_0x008f
        L_0x001d:
            android.view.View$AccessibilityDelegate r1 = r19.getAccessibilityDelegate()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x003a
            boolean r3 = r1 instanceof com.didichuxing.omega.sdk.UIAutoTracker.MyAccessibilityDelegate     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x0029
        L_0x0027:
            r3 = 1
            goto L_0x003b
        L_0x0029:
            java.lang.Class r3 = r1.getClass()     // Catch:{ all -> 0x005c }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "AccessibilityDelegateAdapter"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x003a
            goto L_0x0027
        L_0x003a:
            r3 = 0
        L_0x003b:
            if (r3 != 0) goto L_0x005c
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005c }
            r4 = 24
            if (r3 < r4) goto L_0x004f
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x005c }
            r13 = r18
            r3.<init>(r13)     // Catch:{ all -> 0x005a }
            com.didichuxing.omega.sdk.UIAutoTracker$MyAccessibilityDelegate r1 = com.didichuxing.omega.sdk.UIAutoTracker.MyAccessibilityDelegate.getInstance(r3, r1)     // Catch:{ all -> 0x005a }
            goto L_0x0056
        L_0x004f:
            r13 = r18
            r3 = 0
            com.didichuxing.omega.sdk.UIAutoTracker$MyAccessibilityDelegate r1 = com.didichuxing.omega.sdk.UIAutoTracker.MyAccessibilityDelegate.getInstance(r3, r1)     // Catch:{ all -> 0x005a }
        L_0x0056:
            r0.setAccessibilityDelegate(r1)     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            goto L_0x005e
        L_0x005c:
            r13 = r18
        L_0x005e:
            java.lang.String r1 = getResourceName(r19)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r23
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            r4 = r24
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            if (r1 == 0) goto L_0x008a
            java.lang.Object r4 = r9.get(r1)
            if (r4 != 0) goto L_0x008a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r9.put(r1, r3)
            goto L_0x008b
        L_0x008a:
            r1 = r3
        L_0x008b:
            r8.put(r0, r1)
            goto L_0x001a
        L_0x008f:
            if (r11 == 0) goto L_0x00c9
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r3 = "rn"
            r1.put(r3, r14)
            r3 = 2
            int[] r3 = new int[r3]
            r0.getLocationInWindow(r3)
            r4 = r3[r2]
            java.lang.String r5 = "x"
            r1.put(r5, r4)
            r3 = r3[r12]
            java.lang.String r4 = "y"
            r1.put(r4, r3)
            int r3 = r19.getWidth()
            java.lang.String r4 = "w"
            r1.put(r4, r3)
            int r3 = r19.getHeight()
            java.lang.String r4 = "h"
            r1.put(r4, r3)
            java.lang.String r3 = "z"
            r1.put(r3, r10)
            r11.put(r1)
        L_0x00c9:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x00f2
            r15 = r0
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15
            int r7 = r15.getChildCount()
            r6 = 0
        L_0x00d5:
            if (r6 >= r7) goto L_0x00f2
            android.view.View r1 = r15.getChildAt(r6)
            int r4 = r10 + 1
            r0 = r18
            r2 = r20
            r3 = r21
            r5 = r14
            r16 = r6
            r17 = r7
            r7 = r25
            doTraverseView(r0, r1, r2, r3, r4, r5, r6, r7)
            int r6 = r16 + 1
            r7 = r17
            goto L_0x00d5
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.UIAutoTracker.doTraverseView(android.app.Activity, android.view.View, java.util.Map, java.util.Map, int, java.lang.String, int, org.json.JSONArray):void");
    }

    private static class MyAccessibilityDelegate extends View.AccessibilityDelegate {
        private static MyAccessibilityDelegate instanceWithoutOld;
        private WeakReference<Activity> activity;
        private View.AccessibilityDelegate oldDelegate;

        public MyAccessibilityDelegate(WeakReference<Activity> weakReference, View.AccessibilityDelegate accessibilityDelegate) {
            this.activity = weakReference;
            this.oldDelegate = accessibilityDelegate;
        }

        public static MyAccessibilityDelegate getInstance(WeakReference<Activity> weakReference, View.AccessibilityDelegate accessibilityDelegate) {
            if (accessibilityDelegate != null || weakReference != null) {
                return new MyAccessibilityDelegate(weakReference, accessibilityDelegate);
            }
            if (instanceWithoutOld == null) {
                instanceWithoutOld = new MyAccessibilityDelegate((WeakReference<Activity>) null, (View.AccessibilityDelegate) null);
            }
            return instanceWithoutOld;
        }

        public void sendAccessibilityEvent(View view, int i) {
            Activity activity2;
            try {
                if (this.oldDelegate != null) {
                    this.oldDelegate.sendAccessibilityEvent(view, i);
                } else {
                    super.sendAccessibilityEvent(view, i);
                }
            } catch (Throwable unused) {
            }
            Event event = new Event("OMGUI");
            event.setFrom(OptionsBridge.UI_KEY);
            WeakReference<Activity> weakReference = this.activity;
            String str = null;
            if (weakReference == null) {
                activity2 = null;
            } else {
                activity2 = (Activity) weakReference.get();
            }
            if (activity2 == null) {
                activity2 = UIAutoTracker.scanForActivity(view.getContext());
            }
            if (activity2 != null) {
                WeakHashMap<View, String> viewNameMap = UIAutoMarker.getViewNameMap(activity2);
                event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity2));
                event.putAllAttrs(UIAutoMarker.getViewAttrMap(view));
                String str2 = "UNKNOWN";
                String simplifyClassName = activity2 != null ? CommonUtil.simplifyClassName(activity2.getClass().getName()) : str2;
                String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
                String encryptBlackItem = OmegaConfig.encryptBlackItem(AnalysisPageListener.getCurrentPageName());
                if (!TextUtils.isEmpty(encryptBlackItem)) {
                    event.putAttr("spn", encryptBlackItem);
                }
                if (currentFramentName == null) {
                    currentFramentName = simplifyClassName;
                }
                String encryptBlackItem2 = OmegaConfig.encryptBlackItem(simplifyClassName);
                if (!TextUtils.isEmpty(encryptBlackItem2)) {
                    event.putAttr("rpn", encryptBlackItem2);
                }
                String encryptBlackItem3 = OmegaConfig.encryptBlackItem(currentFramentName);
                if (!TextUtils.isEmpty(encryptBlackItem3)) {
                    event.putAttr("pn", encryptBlackItem3);
                }
                if (1 != i || !OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
                    if (i == 1) {
                        event.putAttr("at", 1);
                    } else if (i == 2) {
                        event.putAttr("at", 8);
                    } else if (i == 4 || i == 8 || i == 16 || i == 32 || i == 128 || i == 256 || i == 2048 || i == 4096) {
                        OLog.m34767v("filter eventType: " + i);
                        return;
                    } else if (i == 8192) {
                        event.putAttr("at", 4);
                    } else if (i != 65536) {
                        event.putAttr("at", Integer.valueOf(i + 100000000));
                    } else {
                        event.putAttr("at", 2);
                    }
                    event.putAttr("rt", CommonUtil.simplifyClassName(view.getClass().getName()));
                    if (viewNameMap != null) {
                        str = viewNameMap.get(view);
                    }
                    if (str == null) {
                        String resourceName = UIAutoTracker.getResourceName(view);
                        if (resourceName != null) {
                            str2 = resourceName;
                        }
                    } else {
                        str2 = str;
                    }
                    event.putAttr("rn", str2);
                    String access$200 = UIAutoTracker.getText(view);
                    if (access$200.length() > 0) {
                        Object tag = view.getTag();
                        String name = view.getClass().getName();
                        if ((tag != null && tag.toString().equals(PaymentConstant.TAG_SENSITIVE)) || ((name != null && name.contains("EditText") && !OmegaConfig.SWITCH_ATUO_EVENT_INPUT) || (view instanceof EditText))) {
                            access$200 = CommonUtil.copyJoinStr("*", access$200.length());
                        }
                        event.putAttr("text", access$200);
                    }
                    event.setSessionId();
                    String screenShot = ScreenShotUtil.getScreenShot(view, -1.0f, -1.0f);
                    if (!TextUtils.isEmpty(screenShot)) {
                        event.putAttr("prism-ck-img", screenShot);
                    }
                    Tracker.trackEvent(event);
                }
            }
        }
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String getText(View view) {
        return doGetText(view, 1).toString();
    }

    private static StringBuilder doGetText(View view, int i) {
        StringBuilder sb = new StringBuilder();
        if (i < 3) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    sb.append(doGetText(viewGroup.getChildAt(i2), i + 1));
                }
            } else if (view instanceof TextView) {
                sb.append(((TextView) view).getText());
            }
        }
        return sb;
    }
}
