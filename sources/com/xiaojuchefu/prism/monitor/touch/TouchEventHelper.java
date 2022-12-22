package com.xiaojuchefu.prism.monitor.touch;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.handler.IViewContentHandler;
import com.xiaojuchefu.prism.monitor.handler.IViewTagHandler;
import com.xiaojuchefu.prism.monitor.model.EventData;
import com.xiaojuchefu.prism.monitor.model.ViewContainer;
import com.xiaojuchefu.prism.monitor.model.ViewContent;
import com.xiaojuchefu.prism.monitor.model.ViewPath;
import com.xiaojuchefu.prism.monitor.model.ViewTag;
import com.xiaojuchefu.prism.monitor.touch.TouchRecord;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class TouchEventHelper {

    /* renamed from: a */
    private static final int f56117a = 0;

    /* renamed from: b */
    private static final int f56118b = 1;

    /* renamed from: c */
    private static final int f56119c = 2;

    /* renamed from: d */
    private static final int f56120d = 3;

    /* renamed from: e */
    private static final int f56121e = 4;

    /* renamed from: f */
    private static final int f56122f = 5;

    /* renamed from: g */
    private static final int f56123g = 100;

    /* renamed from: h */
    private static int f56124h = -1;

    /* renamed from: i */
    private static int f56125i = -1;

    public static EventData createEventData(Window window, View view, TouchRecord touchRecord) {
        if (view == null) {
            return null;
        }
        EventData eventData = new EventData(0);
        eventData.view = view;
        StringBuilder sb = new StringBuilder();
        m40398a(window, eventData, sb);
        ViewPath a = m40390a(view, touchRecord, eventData);
        if (a.viewContainer != null) {
            ViewContainer viewContainer = a.viewContainer;
            sb.append("_^_");
            sb.append(viewContainer.symbol);
            sb.append("_&_");
            sb.append(viewContainer.url);
        } else if (!TextUtils.isEmpty(a.webUrl)) {
            sb.append("_^_");
            sb.append("wu");
            sb.append("_&_");
            sb.append(a.webUrl);
            eventData.f56116wu = a.webUrl;
        } else {
            m40397a(view, sb, eventData);
        }
        m40396a(view, eventData, sb);
        sb.append("_^_");
        sb.append("vp");
        sb.append("_&_");
        sb.append(a.path);
        eventData.f56112vp = a.path;
        if (!TextUtils.isEmpty(a.listInfo)) {
            sb.append("_^_");
            sb.append("vl");
            sb.append("_&_");
            sb.append(a.listInfo);
            eventData.f56111vl = a.listInfo;
        }
        if (touchRecord.isClick && TextUtils.isEmpty(a.webUrl)) {
            m40399b(view, sb, eventData);
        }
        try {
            m40395a(view.getContext(), view, a.inScrollableContainer, touchRecord, sb, eventData);
        } catch (Throwable unused) {
        }
        eventData.eventId = sb.toString();
        if (PrismMonitor.getInstance().isTest()) {
            if (eventData.data == null) {
                eventData.data = new HashMap<>();
            }
            eventData.data.put("motion", m40393a(touchRecord));
            eventData.data.put("block", m40392a(window, view));
        }
        return eventData;
    }

    /* renamed from: a */
    private static void m40398a(Window window, EventData eventData, StringBuilder sb) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb.append("w");
            sb.append("_&_");
            String trim = window.getAttributes().getTitle().toString().trim();
            String substring = trim.substring(trim.indexOf("/") + 1);
            sb2.append(substring);
            sb2.append("_&_");
            sb2.append(window.getAttributes().type);
            String sb3 = sb2.toString();
            sb.append(sb3);
            eventData.f56115w = sb3;
            if (eventData.data == null) {
                eventData.data = new HashMap<>();
            }
            HashMap<String, Object> hashMap = eventData.data;
            hashMap.put("pageName", "native_&_" + substring);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m40397a(View view, StringBuilder sb, EventData eventData) {
        String resourceName = getResourceName(view.getContext(), view.getId());
        if (resourceName != null) {
            sb.append("_^_");
            sb.append("vi");
            sb.append("_&_");
            sb.append(resourceName);
            eventData.f56110vi = resourceName;
        }
    }

    /* renamed from: a */
    private static void m40396a(View view, EventData eventData, StringBuilder sb) {
        IViewTagHandler viewTagHandler = PrismMonitor.getInstance().getViewTagHandler();
        if (viewTagHandler != null) {
            ViewTag[] viewTags = viewTagHandler.getViewTags();
            if (viewTags != null && viewTags.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (ViewTag viewTag : viewTags) {
                    Object tag = view.getTag(viewTag.tagId);
                    if (tag != null) {
                        if (viewTag.append) {
                            sb2.append("_&_");
                            sb2.append(viewTag.tagSymbol);
                            sb2.append("_&_");
                            sb2.append(tag);
                        } else {
                            if (eventData.data == null) {
                                eventData.data = new HashMap<>();
                            }
                            eventData.data.put(viewTag.tagSymbol, tag);
                        }
                    }
                }
                if (sb2.length() > 0) {
                    sb.append("_^_");
                    sb.append("vf");
                    sb.append(sb2);
                    eventData.f56109vf = sb2.toString();
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder(view.getClass().getSimpleName());
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                break;
            }
            view = (ViewGroup) parent;
            sb3.insert(0, "_&_");
            sb3.insert(0, view.getClass().getSimpleName());
        }
        if (sb3.length() > 0) {
            sb.append("_^_");
            sb.append("vf");
            sb.append("_&_");
            sb.append(sb3);
            eventData.f56109vf = sb3.toString();
        }
    }

    public static String getResourceName(Context context, int i) {
        if (!(i == -1 || i == 0)) {
            try {
                String resourceName = context.getResources().getResourceName(i);
                String substring = resourceName.substring(resourceName.lastIndexOf("/") + 1);
                if (Integer.toHexString(i).startsWith("7f")) {
                    return substring;
                }
                return substring + "[01]";
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x020b A[Catch:{ all -> 0x023e }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0213 A[Catch:{ all -> 0x023e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaojuchefu.prism.monitor.model.ViewPath m40390a(android.view.View r19, com.xiaojuchefu.prism.monitor.touch.TouchRecord r20, com.xiaojuchefu.prism.monitor.model.EventData r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            com.xiaojuchefu.prism.monitor.model.ViewPath r3 = new com.xiaojuchefu.prism.monitor.model.ViewPath
            r3.<init>()
            boolean r4 = r0 instanceof android.webkit.WebView     // Catch:{ all -> 0x023e }
            java.lang.String r5 = "pageName"
            r6 = 1
            if (r4 == 0) goto L_0x006b
            r4 = r0
            android.webkit.WebView r4 = (android.webkit.WebView) r4     // Catch:{ all -> 0x023e }
            java.lang.String r4 = r4.getUrl()     // Catch:{ all -> 0x023e }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x023e }
            if (r7 != 0) goto L_0x0069
            android.net.Uri r7 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r8.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r9 = r7.getScheme()     // Catch:{ all -> 0x023e }
            r8.append(r9)     // Catch:{ all -> 0x023e }
            java.lang.String r9 = "://"
            r8.append(r9)     // Catch:{ all -> 0x023e }
            java.lang.String r9 = r7.getHost()     // Catch:{ all -> 0x023e }
            r8.append(r9)     // Catch:{ all -> 0x023e }
            java.lang.String r7 = r7.getPath()     // Catch:{ all -> 0x023e }
            r8.append(r7)     // Catch:{ all -> 0x023e }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x023e }
            r3.webUrl = r7     // Catch:{ all -> 0x023e }
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r2.data     // Catch:{ all -> 0x023e }
            if (r7 != 0) goto L_0x0053
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x023e }
            r7.<init>()     // Catch:{ all -> 0x023e }
            r2.data = r7     // Catch:{ all -> 0x023e }
        L_0x0053:
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r2.data     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r8.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r9 = "h5_&_"
            r8.append(r9)     // Catch:{ all -> 0x023e }
            r8.append(r4)     // Catch:{ all -> 0x023e }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x023e }
            r7.put(r5, r4)     // Catch:{ all -> 0x023e }
        L_0x0069:
            r3.inScrollableContainer = r6     // Catch:{ all -> 0x023e }
        L_0x006b:
            r4 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r7.<init>()     // Catch:{ all -> 0x023e }
            com.xiaojuchefu.prism.monitor.PrismMonitor r8 = com.xiaojuchefu.prism.monitor.PrismMonitor.getInstance()     // Catch:{ all -> 0x023e }
            com.xiaojuchefu.prism.monitor.handler.IViewContainerHandler r8 = r8.getViewContainerHandler()     // Catch:{ all -> 0x023e }
            r10 = 0
        L_0x007a:
            android.view.ViewParent r11 = r0.getParent()     // Catch:{ all -> 0x023e }
            boolean r12 = r11 instanceof android.view.ViewGroup     // Catch:{ all -> 0x023e }
            if (r12 == 0) goto L_0x0234
            r12 = r11
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12     // Catch:{ all -> 0x023e }
            int r13 = r12.indexOfChild(r0)     // Catch:{ all -> 0x023e }
            java.lang.String r14 = "/"
            if (r8 == 0) goto L_0x0111
            boolean r15 = r8.handleContainer(r12)     // Catch:{ all -> 0x023e }
            if (r15 == 0) goto L_0x0111
            com.xiaojuchefu.prism.monitor.model.ViewContainer r1 = new com.xiaojuchefu.prism.monitor.model.ViewContainer     // Catch:{ all -> 0x023e }
            r1.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r6 = r8.getContainerUrl(r12)     // Catch:{ all -> 0x023e }
            android.net.Uri r9 = android.net.Uri.parse(r6)     // Catch:{ all -> 0x023e }
            java.lang.String r9 = r9.getPath()     // Catch:{ all -> 0x023e }
            r1.url = r9     // Catch:{ all -> 0x023e }
            java.lang.String r8 = r8.getContainerSymbol(r12)     // Catch:{ all -> 0x023e }
            r1.symbol = r8     // Catch:{ all -> 0x023e }
            r3.viewContainer = r1     // Catch:{ all -> 0x023e }
            android.content.Context r8 = r0.getContext()     // Catch:{ all -> 0x023e }
            int r0 = r0.getId()     // Catch:{ all -> 0x023e }
            java.lang.String r0 = getResourceName(r8, r0)     // Catch:{ all -> 0x023e }
            if (r0 == 0) goto L_0x00bd
            goto L_0x00c1
        L_0x00bd:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x023e }
        L_0x00c1:
            r7.append(r0)     // Catch:{ all -> 0x023e }
            r7.append(r14)     // Catch:{ all -> 0x023e }
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r2.data     // Catch:{ all -> 0x023e }
            if (r0 != 0) goto L_0x00d2
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x023e }
            r0.<init>()     // Catch:{ all -> 0x023e }
            r2.data = r0     // Catch:{ all -> 0x023e }
        L_0x00d2:
            java.lang.String r0 = "tp"
            java.lang.String r8 = r1.symbol     // Catch:{ all -> 0x023e }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x023e }
            if (r0 == 0) goto L_0x00f4
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r2.data     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r1.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r2 = "thanos_&_"
            r1.append(r2)     // Catch:{ all -> 0x023e }
            r1.append(r6)     // Catch:{ all -> 0x023e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x023e }
            r0.put(r5, r1)     // Catch:{ all -> 0x023e }
            goto L_0x0234
        L_0x00f4:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r2.data     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r2.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r1 = r1.symbol     // Catch:{ all -> 0x023e }
            r2.append(r1)     // Catch:{ all -> 0x023e }
            java.lang.String r1 = "_&_"
            r2.append(r1)     // Catch:{ all -> 0x023e }
            r2.append(r6)     // Catch:{ all -> 0x023e }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x023e }
            r0.put(r5, r1)     // Catch:{ all -> 0x023e }
            goto L_0x0234
        L_0x0111:
            boolean r15 = r1.isClick     // Catch:{ all -> 0x023e }
            java.lang.String r9 = ","
            if (r15 == 0) goto L_0x0169
            boolean r15 = r11 instanceof android.widget.AbsListView     // Catch:{ all -> 0x023e }
            if (r15 == 0) goto L_0x0169
            r3.inScrollableContainer = r6     // Catch:{ all -> 0x023e }
            android.widget.AbsListView r11 = (android.widget.AbsListView) r11     // Catch:{ all -> 0x023e }
            r15 = 2
            int[] r15 = new int[r15]     // Catch:{ all -> 0x023e }
            r11.getLocationOnScreen(r15)     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r6.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r2 = "l:"
            r6.append(r2)     // Catch:{ all -> 0x023e }
            float r2 = r1.mDownX     // Catch:{ all -> 0x023e }
            int r2 = (int) r2     // Catch:{ all -> 0x023e }
            r16 = 0
            r18 = r15[r16]     // Catch:{ all -> 0x023e }
            int r2 = r2 - r18
            r18 = r5
            float r5 = r1.mDownY     // Catch:{ all -> 0x023e }
            int r5 = (int) r5     // Catch:{ all -> 0x023e }
            r17 = 1
            r15 = r15[r17]     // Catch:{ all -> 0x023e }
            int r5 = r5 - r15
            int r2 = r11.pointToPosition(r2, r5)     // Catch:{ all -> 0x023e }
            r6.append(r2)     // Catch:{ all -> 0x023e }
            r6.append(r9)     // Catch:{ all -> 0x023e }
            r6.append(r13)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x023e }
            if (r4 != 0) goto L_0x0156
            goto L_0x01aa
        L_0x0156:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r5.<init>()     // Catch:{ all -> 0x023e }
            r5.append(r4)     // Catch:{ all -> 0x023e }
            r5.append(r9)     // Catch:{ all -> 0x023e }
            r5.append(r2)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x023e }
            goto L_0x01aa
        L_0x0169:
            r18 = r5
            r16 = 0
            boolean r2 = r1.isClick     // Catch:{ all -> 0x023e }
            if (r2 == 0) goto L_0x01af
            boolean r2 = r11 instanceof androidx.recyclerview.widget.RecyclerView     // Catch:{ all -> 0x023e }
            if (r2 == 0) goto L_0x01af
            r2 = 1
            r3.inScrollableContainer = r2     // Catch:{ all -> 0x023e }
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r2.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r5 = "r:"
            r2.append(r5)     // Catch:{ all -> 0x023e }
            int r5 = r11.getChildAdapterPosition(r0)     // Catch:{ all -> 0x023e }
            r2.append(r5)     // Catch:{ all -> 0x023e }
            r2.append(r9)     // Catch:{ all -> 0x023e }
            r2.append(r13)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x023e }
            if (r4 != 0) goto L_0x0198
            goto L_0x01aa
        L_0x0198:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r5.<init>()     // Catch:{ all -> 0x023e }
            r5.append(r4)     // Catch:{ all -> 0x023e }
            r5.append(r9)     // Catch:{ all -> 0x023e }
            r5.append(r2)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x023e }
        L_0x01aa:
            r4 = r2
            r2 = 1
            r17 = 1
            goto L_0x01fd
        L_0x01af:
            boolean r2 = r1.isClick     // Catch:{ all -> 0x023e }
            if (r2 == 0) goto L_0x01ed
            boolean r2 = r11 instanceof androidx.viewpager.widget.ViewPager     // Catch:{ all -> 0x023e }
            if (r2 == 0) goto L_0x01ed
            r2 = 1
            r3.inScrollableContainer = r2     // Catch:{ all -> 0x023e }
            androidx.viewpager.widget.ViewPager r11 = (androidx.viewpager.widget.ViewPager) r11     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r2.<init>()     // Catch:{ all -> 0x023e }
            java.lang.String r5 = "v:"
            r2.append(r5)     // Catch:{ all -> 0x023e }
            int r5 = r11.getCurrentItem()     // Catch:{ all -> 0x023e }
            r2.append(r5)     // Catch:{ all -> 0x023e }
            r2.append(r9)     // Catch:{ all -> 0x023e }
            r2.append(r13)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x023e }
            if (r4 != 0) goto L_0x01da
            goto L_0x01aa
        L_0x01da:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r5.<init>()     // Catch:{ all -> 0x023e }
            r5.append(r4)     // Catch:{ all -> 0x023e }
            r5.append(r9)     // Catch:{ all -> 0x023e }
            r5.append(r2)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x023e }
            goto L_0x01aa
        L_0x01ed:
            boolean r2 = r11 instanceof android.widget.ScrollView     // Catch:{ all -> 0x023e }
            if (r2 != 0) goto L_0x01f8
            boolean r2 = r11 instanceof android.widget.HorizontalScrollView     // Catch:{ all -> 0x023e }
            if (r2 == 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r2 = 1
            goto L_0x01fb
        L_0x01f8:
            r2 = 1
            r3.inScrollableContainer = r2     // Catch:{ all -> 0x023e }
        L_0x01fb:
            r17 = 0
        L_0x01fd:
            android.content.Context r5 = r0.getContext()     // Catch:{ all -> 0x023e }
            int r0 = r0.getId()     // Catch:{ all -> 0x023e }
            java.lang.String r0 = getResourceName(r5, r0)     // Catch:{ all -> 0x023e }
            if (r0 == 0) goto L_0x0213
            r7.append(r0)     // Catch:{ all -> 0x023e }
            r7.append(r14)     // Catch:{ all -> 0x023e }
            r10 = 1
            goto L_0x022c
        L_0x0213:
            if (r17 == 0) goto L_0x0224
            r7.append(r13)     // Catch:{ all -> 0x023e }
            r7.append(r14)     // Catch:{ all -> 0x023e }
            java.lang.String r0 = "*"
            r7.append(r0)     // Catch:{ all -> 0x023e }
            r7.append(r14)     // Catch:{ all -> 0x023e }
            goto L_0x022c
        L_0x0224:
            if (r10 != 0) goto L_0x022c
            r7.append(r13)     // Catch:{ all -> 0x023e }
            r7.append(r14)     // Catch:{ all -> 0x023e }
        L_0x022c:
            r2 = r21
            r0 = r12
            r5 = r18
            r6 = 1
            goto L_0x007a
        L_0x0234:
            if (r4 == 0) goto L_0x0238
            r3.listInfo = r4     // Catch:{ all -> 0x023e }
        L_0x0238:
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x023e }
            r3.path = r0     // Catch:{ all -> 0x023e }
        L_0x023e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.touch.TouchEventHelper.m40390a(android.view.View, com.xiaojuchefu.prism.monitor.touch.TouchRecord, com.xiaojuchefu.prism.monitor.model.EventData):com.xiaojuchefu.prism.monitor.model.ViewPath");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m40399b(android.view.View r13, java.lang.StringBuilder r14, com.xiaojuchefu.prism.monitor.model.EventData r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            r0.<init>(r1)
            m40389a((android.view.View) r13, (java.util.List<com.xiaojuchefu.prism.monitor.model.ViewContent>) r0, (int) r1)
            int r13 = r0.size()
            if (r13 != 0) goto L_0x0011
            return
        L_0x0011:
            java.util.Iterator r13 = r0.iterator()
            r1 = 0
            r2 = 0
        L_0x0017:
            boolean r3 = r13.hasNext()
            r4 = 3
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r13.next()
            com.xiaojuchefu.prism.monitor.model.ViewContent r3 = (com.xiaojuchefu.prism.monitor.model.ViewContent) r3
            int r7 = r3.type
            if (r7 != r6) goto L_0x002c
            r13 = 1
            goto L_0x0037
        L_0x002c:
            int r7 = r3.type
            if (r7 == r5) goto L_0x0034
            int r3 = r3.type
            if (r3 != r4) goto L_0x0017
        L_0x0034:
            r2 = 1
            goto L_0x0017
        L_0x0036:
            r13 = 0
        L_0x0037:
            java.lang.String r3 = "vr"
            java.lang.String r7 = "_^_"
            java.lang.String r8 = "_&_"
            if (r13 == 0) goto L_0x00ce
            r13 = 0
            r2 = r13
            r4 = 0
        L_0x0042:
            int r5 = r0.size()
            if (r4 >= r5) goto L_0x0090
            java.lang.Object r5 = r0.get(r4)
            com.xiaojuchefu.prism.monitor.model.ViewContent r5 = (com.xiaojuchefu.prism.monitor.model.ViewContent) r5
            int r9 = r5.type
            if (r9 != r6) goto L_0x008d
            if (r13 != 0) goto L_0x0057
            r13 = r5
            r2 = r13
            goto L_0x008d
        L_0x0057:
            float r9 = r5.fontSize
            float r10 = r13.fontSize
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0060
            r13 = r5
        L_0x0060:
            int[] r9 = r5.location
            r9 = r9[r1]
            int[] r10 = r5.location
            r10 = r10[r1]
            int r9 = r9 * r10
            int[] r10 = r5.location
            r10 = r10[r6]
            int[] r11 = r5.location
            r11 = r11[r6]
            int r10 = r10 * r11
            int r9 = r9 + r10
            int[] r10 = r2.location
            r10 = r10[r1]
            int[] r11 = r2.location
            r11 = r11[r1]
            int r10 = r10 * r11
            int[] r11 = r2.location
            r11 = r11[r6]
            int[] r12 = r2.location
            r12 = r12[r6]
            int r11 = r11 * r12
            int r10 = r10 + r11
            if (r9 >= r10) goto L_0x008d
            r2 = r5
        L_0x008d:
            int r4 = r4 + 1
            goto L_0x0042
        L_0x0090:
            if (r13 != r2) goto L_0x00a5
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r0 = r13.content
            r14.append(r0)
            java.lang.String r13 = r13.content
            r15.f56114vr = r13
            goto L_0x00fa
        L_0x00a5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.content
            r0.append(r1)
            r0.append(r8)
            java.lang.String r13 = r13.content
            r0.append(r13)
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r13 = r0.toString()
            r14.append(r13)
            java.lang.String r13 = r0.toString()
            r15.f56114vr = r13
            goto L_0x00fa
        L_0x00ce:
            if (r2 == 0) goto L_0x00fa
            java.util.Iterator r13 = r0.iterator()
        L_0x00d4:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x00fa
            java.lang.Object r0 = r13.next()
            com.xiaojuchefu.prism.monitor.model.ViewContent r0 = (com.xiaojuchefu.prism.monitor.model.ViewContent) r0
            int r1 = r0.type
            if (r1 == r5) goto L_0x00e8
            int r1 = r0.type
            if (r1 != r4) goto L_0x00d4
        L_0x00e8:
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r13 = r0.content
            r14.append(r13)
            java.lang.String r13 = r0.content
            r15.f56114vr = r13
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.touch.TouchEventHelper.m40399b(android.view.View, java.lang.StringBuilder, com.xiaojuchefu.prism.monitor.model.EventData):void");
    }

    /* renamed from: a */
    private static int m40389a(View view, List<ViewContent> list, int i) {
        ViewContent content;
        if (view.getVisibility() != 0) {
            return i;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                i = m40389a(viewGroup.getChildAt(i2), list, i);
                if (i == 0) {
                    return i;
                }
            }
            return i;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            String str = "";
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                if (editText.getHint() != null) {
                    str = editText.getHint().toString().trim();
                }
            } else if (textView.getText() != null) {
                str = textView.getText().toString().trim();
            }
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ViewContent viewContent = new ViewContent();
            viewContent.type = 1;
            viewContent.content = str;
            viewContent.fontSize = textView.getTextSize();
            int[] iArr = new int[2];
            textView.getLocationOnScreen(iArr);
            viewContent.location = iArr;
            list.add(viewContent);
        } else {
            IViewContentHandler viewContentHandler = PrismMonitor.getInstance().getViewContentHandler();
            if (viewContentHandler == null || (content = viewContentHandler.getContent(view)) == null) {
                return i;
            }
            list.add(content);
        }
        return i - 1;
    }

    /* renamed from: a */
    private static void m40395a(Context context, View view, boolean z, TouchRecord touchRecord, StringBuilder sb, EventData eventData) {
        int i = 2;
        int windowWidth = getWindowWidth(context) / 2;
        int windowHeight = getWindowHeight(context) / 2;
        sb.append("_^_");
        if (!z) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = i2 + (view.getWidth() / 2);
            int height = i3 + (view.getHeight() / 2);
            int i4 = width == windowWidth ? 1 : width < windowWidth ? 4 : 5;
            if (height == windowHeight) {
                i = 1;
            } else if (height >= windowHeight) {
                i = 3;
            }
            sb.append("vq");
            sb.append("_&_");
            int i5 = i4 * i;
            sb.append(i5);
            eventData.f56113vq = String.valueOf(i5);
            return;
        }
        sb.append("vq");
        sb.append("_&_");
        sb.append(100);
        eventData.f56113vq = String.valueOf(100);
    }

    /* renamed from: a */
    private static String m40393a(TouchRecord touchRecord) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.1f", new Object[]{Float.valueOf(touchRecord.mDownX)}));
        sb.append(",");
        sb.append(String.format("%.1f", new Object[]{Float.valueOf(touchRecord.mDownY)}));
        if (!touchRecord.isClick) {
            for (int i = 0; i < touchRecord.mMoveTouch.size(); i++) {
                TouchRecord.MoveTouch moveTouch = touchRecord.mMoveTouch.get(i);
                sb.append(",");
                sb.append(String.format("%.1f", new Object[]{Float.valueOf(moveTouch.mMoveX)}));
                sb.append(",");
                sb.append(String.format("%.1f", new Object[]{Float.valueOf(moveTouch.mMoveY)}));
                sb.append(",");
                sb.append(moveTouch.mMoveTime);
            }
            sb.append(",");
            sb.append(String.format("%.1f", new Object[]{Float.valueOf(touchRecord.mUpX)}));
            sb.append(",");
            sb.append(String.format("%.1f", new Object[]{Float.valueOf(touchRecord.mUpY)}));
            sb.append(",");
            sb.append(touchRecord.mUpTime);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m40392a(Window window, View view) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(window.getDecorView().getWidth());
            sb.append(",");
            sb.append(window.getDecorView().getHeight());
            sb.append("_&_");
            int[] iArr = new int[2];
            window.getDecorView().getLocationOnScreen(iArr);
            sb.append(iArr[0]);
            sb.append(",");
            sb.append(iArr[1]);
            sb.append("_^_");
            sb.append(view.getWidth());
            sb.append(",");
            sb.append(view.getHeight());
            sb.append("_&_");
            view.getLocationOnScreen(iArr);
            sb.append(iArr[0]);
            sb.append(",");
            sb.append(iArr[1]);
            sb.append("_^_");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getWindowWidth(Context context) {
        if (f56124h == -1) {
            m40394a(context);
        }
        return f56124h;
    }

    public static int getWindowHeight(Context context) {
        if (f56125i == -1) {
            m40394a(context);
        }
        return f56125i;
    }

    /* renamed from: a */
    private static void m40394a(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        f56124h = point.x;
        f56125i = point.y;
    }

    /* renamed from: a */
    private static Object m40391a(ImageView imageView, String str) {
        Field field = null;
        for (Class cls = imageView.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            if (field != null) {
                break;
            }
        }
        if (field != null) {
            try {
                return field.get(imageView);
            } catch (IllegalAccessException unused2) {
            }
        }
        return null;
    }
}
