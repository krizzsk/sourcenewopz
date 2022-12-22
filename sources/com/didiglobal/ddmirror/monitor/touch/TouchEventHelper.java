package com.didiglobal.ddmirror.monitor.touch;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didiglobal.ddmirror.monitor.PrismConstants;
import com.didiglobal.ddmirror.monitor.model.EventData;
import com.didiglobal.ddmirror.monitor.model.ViewContainer;
import com.didiglobal.ddmirror.monitor.model.ViewContent;
import com.didiglobal.ddmirror.monitor.model.ViewPath;
import java.util.List;

public class TouchEventHelper {
    private static int mWindowHeight = -1;
    private static int mWindowWidth = -1;

    public static EventData createEventData(Window window, View view, TouchRecord touchRecord) {
        if (view == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        getWindowInfo(window, sb);
        ViewPath viewPathInfo = getViewPathInfo(view, touchRecord, sb);
        if (viewPathInfo.viewContainer != null) {
            ViewContainer viewContainer = viewPathInfo.viewContainer;
            sb.append("_^_");
            sb.append(viewContainer.symbol);
            sb.append("_&_");
            sb.append(viewContainer.url);
        } else if (!TextUtils.isEmpty(viewPathInfo.webUrl)) {
            sb.append("_^_");
            sb.append("wu");
            sb.append("_&_");
            sb.append(viewPathInfo.webUrl);
        } else {
            getViewId(view, sb);
        }
        sb.append("_^_");
        sb.append("vp");
        sb.append("_&_");
        sb.append(viewPathInfo.path);
        if (!TextUtils.isEmpty(viewPathInfo.listInfo)) {
            sb.append("_^_");
            sb.append("vl");
            sb.append("_&_");
            sb.append(viewPathInfo.listInfo);
        }
        if (touchRecord.isClick && TextUtils.isEmpty(viewPathInfo.webUrl)) {
            getViewContent(view, sb);
        }
        if (!viewPathInfo.inScrollableContainer) {
            getQuadrant(view.getContext(), touchRecord, sb);
        }
        sb.append("_^_");
        sb.append(PrismConstants.Symbol.VIEW_CLASS);
        sb.append("_&_");
        sb.append(view.getClass().getName());
        EventData eventData = new EventData(0);
        eventData.eventId = sb.toString();
        return eventData;
    }

    private static void getWindowInfo(Window window, StringBuilder sb) {
        sb.append("w");
        sb.append("_&_");
        String trim = window.getAttributes().getTitle().toString().trim();
        sb.append(trim.substring(trim.indexOf("/") + 1));
        sb.append("_&_");
        sb.append(window.getAttributes().type);
    }

    private static void getViewId(View view, StringBuilder sb) {
        String resourceName = getResourceName(view.getContext(), view.getId());
        if (resourceName != null) {
            sb.append("_^_");
            sb.append("vi");
            sb.append("_&_");
            sb.append(resourceName);
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

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didiglobal.ddmirror.monitor.model.ViewPath getViewPathInfo(android.view.View r13, com.didiglobal.ddmirror.monitor.touch.TouchRecord r14, java.lang.StringBuilder r15) {
        /*
            com.didiglobal.ddmirror.monitor.model.ViewPath r15 = new com.didiglobal.ddmirror.monitor.model.ViewPath
            r15.<init>()
            boolean r0 = r13 instanceof android.webkit.WebView
            r1 = 1
            if (r0 == 0) goto L_0x0042
            r0 = r13
            android.webkit.WebView r0 = (android.webkit.WebView) r0
            java.lang.String r0 = r0.getUrl()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0040
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.getScheme()
            r2.append(r3)
            java.lang.String r3 = "://"
            r2.append(r3)
            java.lang.String r3 = r0.getHost()
            r2.append(r3)
            java.lang.String r0 = r0.getPath()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r15.webUrl = r0
        L_0x0040:
            r15.inScrollableContainer = r1
        L_0x0042:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x004a:
            android.view.ViewParent r5 = r13.getParent()
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0168
            r6 = r5
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int r7 = r6.indexOfChild(r13)
            boolean r8 = r14.isClick
            java.lang.String r9 = ","
            if (r8 == 0) goto L_0x00ad
            boolean r8 = r5 instanceof android.widget.AbsListView
            if (r8 == 0) goto L_0x00ad
            r15.inScrollableContainer = r1
            android.widget.AbsListView r5 = (android.widget.AbsListView) r5
            r8 = 2
            int[] r8 = new int[r8]
            r5.getLocationOnScreen(r8)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "l:"
            r10.append(r11)
            r10.append(r7)
            r10.append(r9)
            float r11 = r14.mDownX
            int r11 = (int) r11
            r12 = r8[r3]
            int r11 = r11 - r12
            float r12 = r14.mDownY
            int r12 = (int) r12
            r8 = r8[r1]
            int r12 = r12 - r8
            int r5 = r5.pointToPosition(r11, r12)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            if (r0 != 0) goto L_0x0097
            goto L_0x00a9
        L_0x0097:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
        L_0x00a9:
            r0 = r5
            r5 = 1
            goto L_0x0132
        L_0x00ad:
            boolean r8 = r14.isClick
            if (r8 == 0) goto L_0x00ea
            boolean r8 = r5 instanceof androidx.recyclerview.widget.RecyclerView
            if (r8 == 0) goto L_0x00ea
            r15.inScrollableContainer = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "r:"
            r8.append(r10)
            int r5 = r5.getChildAdapterPosition(r13)
            r8.append(r5)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            if (r0 != 0) goto L_0x00d7
            goto L_0x00a9
        L_0x00d7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            goto L_0x00a9
        L_0x00ea:
            boolean r8 = r14.isClick
            if (r8 == 0) goto L_0x0127
            boolean r8 = r5 instanceof androidx.viewpager.widget.ViewPager
            if (r8 == 0) goto L_0x0127
            r15.inScrollableContainer = r1
            androidx.viewpager.widget.ViewPager r5 = (androidx.viewpager.widget.ViewPager) r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "v:"
            r8.append(r10)
            int r5 = r5.getCurrentItem()
            r8.append(r5)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            if (r0 != 0) goto L_0x0114
            goto L_0x00a9
        L_0x0114:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            goto L_0x00a9
        L_0x0127:
            boolean r8 = r5 instanceof android.widget.ScrollView
            if (r8 != 0) goto L_0x012f
            boolean r5 = r5 instanceof android.widget.HorizontalScrollView
            if (r5 == 0) goto L_0x0131
        L_0x012f:
            r15.inScrollableContainer = r1
        L_0x0131:
            r5 = 0
        L_0x0132:
            android.content.Context r8 = r13.getContext()
            int r13 = r13.getId()
            java.lang.String r13 = getResourceName(r8, r13)
            java.lang.String r8 = "*"
            java.lang.String r9 = "/"
            if (r13 == 0) goto L_0x0154
            r2.append(r13)
            r2.append(r9)
            if (r5 == 0) goto L_0x0152
            r2.append(r8)
            r2.append(r9)
        L_0x0152:
            r4 = 1
            goto L_0x0165
        L_0x0154:
            if (r5 == 0) goto L_0x015d
            r2.append(r8)
            r2.append(r9)
            goto L_0x0165
        L_0x015d:
            if (r4 != 0) goto L_0x0165
            r2.append(r7)
            r2.append(r9)
        L_0x0165:
            r13 = r6
            goto L_0x004a
        L_0x0168:
            if (r0 == 0) goto L_0x016c
            r15.listInfo = r0
        L_0x016c:
            java.lang.String r13 = r2.toString()
            r15.path = r13
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.monitor.touch.TouchEventHelper.getViewPathInfo(android.view.View, com.didiglobal.ddmirror.monitor.touch.TouchRecord, java.lang.StringBuilder):com.didiglobal.ddmirror.monitor.model.ViewPath");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void getViewContent(android.view.View r13, java.lang.StringBuilder r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            r0.<init>(r1)
            getViewContent(r13, r0, r1)
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
            com.didiglobal.ddmirror.monitor.model.ViewContent r3 = (com.didiglobal.ddmirror.monitor.model.ViewContent) r3
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
            if (r13 == 0) goto L_0x00b8
            r13 = 0
            r2 = r13
            r4 = 0
        L_0x0042:
            int r5 = r0.size()
            if (r4 >= r5) goto L_0x0090
            java.lang.Object r5 = r0.get(r4)
            com.didiglobal.ddmirror.monitor.model.ViewContent r5 = (com.didiglobal.ddmirror.monitor.model.ViewContent) r5
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
            if (r13 != r2) goto L_0x00a1
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r13 = r13.content
            r14.append(r13)
            goto L_0x00e0
        L_0x00a1:
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r0 = r2.content
            r14.append(r0)
            r14.append(r8)
            java.lang.String r13 = r13.content
            r14.append(r13)
            goto L_0x00e0
        L_0x00b8:
            if (r2 == 0) goto L_0x00e0
            java.util.Iterator r13 = r0.iterator()
        L_0x00be:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x00e0
            java.lang.Object r0 = r13.next()
            com.didiglobal.ddmirror.monitor.model.ViewContent r0 = (com.didiglobal.ddmirror.monitor.model.ViewContent) r0
            int r1 = r0.type
            if (r1 == r5) goto L_0x00d2
            int r1 = r0.type
            if (r1 != r4) goto L_0x00be
        L_0x00d2:
            r14.append(r7)
            r14.append(r3)
            r14.append(r8)
            java.lang.String r13 = r0.content
            r14.append(r13)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.monitor.touch.TouchEventHelper.getViewContent(android.view.View, java.lang.StringBuilder):void");
    }

    private static int getViewContent(View view, List<ViewContent> list, int i) {
        if (view.getVisibility() != 0) {
            return i;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                i = getViewContent(viewGroup.getChildAt(i2), list, i);
                if (i == 0) {
                    return i;
                }
            }
            return i;
        } else if (!(view instanceof TextView)) {
            return i;
        } else {
            TextView textView = (TextView) view;
            if (textView.getText() == null) {
                return i;
            }
            String trim = textView.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                return i;
            }
            ViewContent viewContent = new ViewContent();
            viewContent.type = 1;
            viewContent.content = trim;
            viewContent.fontSize = textView.getTextSize();
            int[] iArr = new int[2];
            textView.getLocationOnScreen(iArr);
            viewContent.location = iArr;
            list.add(viewContent);
            return i - 1;
        }
    }

    private static void getQuadrant(Context context, TouchRecord touchRecord, StringBuilder sb) {
        int windowHeight = getWindowHeight(context) / 2;
        float f = touchRecord.mDownX;
        float f2 = touchRecord.mDownY;
        sb.append("_^_");
        float windowWidth = (float) (getWindowWidth(context) / 2);
        int i = (f > windowWidth ? 1 : (f == windowWidth ? 0 : -1));
        if (i > 0 && f2 <= ((float) windowHeight)) {
            sb.append("vq");
            sb.append("_&_");
            sb.append("1");
        } else if (i < 0 || f2 <= ((float) windowHeight)) {
            int i2 = (f > windowWidth ? 1 : (f == windowWidth ? 0 : -1));
            if (i2 < 0 && f2 >= ((float) windowHeight)) {
                sb.append("vq");
                sb.append("_&_");
                sb.append("3");
            } else if (i2 <= 0 && f2 < ((float) windowHeight)) {
                sb.append("vq");
                sb.append("_&_");
                sb.append("4");
            }
        } else {
            sb.append("vq");
            sb.append("_&_");
            sb.append("2");
        }
    }

    public static int getWindowWidth(Context context) {
        if (mWindowWidth == -1) {
            initWindowDisplay(context);
        }
        return mWindowWidth;
    }

    public static int getWindowHeight(Context context) {
        if (mWindowHeight == -1) {
            initWindowDisplay(context);
        }
        return mWindowHeight;
    }

    private static void initWindowDisplay(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        mWindowWidth = point.x;
        mWindowHeight = point.y;
    }
}
