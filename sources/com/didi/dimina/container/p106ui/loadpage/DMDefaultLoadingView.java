package com.didi.dimina.container.p106ui.loadpage;

import android.content.Context;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.page.DMPage;

/* renamed from: com.didi.dimina.container.ui.loadpage.DMDefaultLoadingView */
public class DMDefaultLoadingView extends DMBaseLoadingView {
    private final DMMina mDmMina;
    private final DMPage mDmPage;

    public DMDefaultLoadingView(Context context, DMMina dMMina, DMPage dMPage) {
        super(context, dMMina, dMPage);
        this.mDmPage = dMPage;
        this.mDmMina = dMMina;
        init();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() {
        /*
            r13 = this;
            java.lang.String r0 = "black"
            android.content.Context r1 = r13.getContext()
            boolean r2 = r1 instanceof android.app.Activity
            r3 = 0
            if (r2 == 0) goto L_0x0012
            android.app.Activity r1 = (android.app.Activity) r1
            int r1 = com.didi.dimina.container.p106ui.statusbar.ImmersionBar.getStatusBarHeight((android.app.Activity) r1)
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 >= 0) goto L_0x0016
            r1 = 0
        L_0x0016:
            android.content.Context r2 = r13.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r4 = 2131624879(0x7f0e03af, float:1.887695E38)
            r5 = 1
            r2.inflate(r4, r13, r5)
            r2 = 2131432316(0x7f0b137c, float:1.8486386E38)
            android.view.View r2 = r13.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r4 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.view.View r4 = r13.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r6 = 2131431740(0x7f0b113c, float:1.8485218E38)
            android.view.View r6 = r13.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            android.content.res.Resources r7 = r13.getResources()
            r8 = 2131954641(0x7f130bd1, float:1.9545787E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = ""
            com.didi.dimina.container.DMMina r9 = r13.mDmMina     // Catch:{ Exception -> 0x00d3 }
            java.util.List r9 = com.didi.dimina.container.util.NavigateUtil.getCurPageHosts(r9)     // Catch:{ Exception -> 0x00d3 }
            if (r9 == 0) goto L_0x005c
            int r9 = r9.size()     // Catch:{ Exception -> 0x00d3 }
            if (r9 >= r5) goto L_0x005c
            r3 = 1
        L_0x005c:
            com.didi.dimina.container.page.DMPage r5 = r13.mDmPage     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r5 = r5.getUrl()     // Catch:{ Exception -> 0x00d3 }
            com.didi.dimina.container.DMMina r9 = r13.mDmMina     // Catch:{ Exception -> 0x00d3 }
            com.didi.dimina.container.bean.JSAppConfig r9 = r9.getJSAppConfig()     // Catch:{ Exception -> 0x00d3 }
            boolean r10 = r9.containPath(r5)     // Catch:{ Exception -> 0x00d3 }
            if (r10 == 0) goto L_0x00d1
            com.didi.dimina.container.bean.JSAppConfig$PageConfig r5 = r9.getPageConfig(r5)     // Catch:{ Exception -> 0x00d3 }
            com.didi.dimina.container.bean.JSAppConfig$GlobalConfig r9 = r9.globalConfig     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r10 = r5.navigationBarTitleText     // Catch:{ Exception -> 0x00d3 }
            boolean r10 = com.didi.dimina.container.util.TextUtil.isEmpty(r10)     // Catch:{ Exception -> 0x00d3 }
            if (r10 != 0) goto L_0x007f
            java.lang.String r7 = r5.navigationBarTitleText     // Catch:{ Exception -> 0x00d3 }
            goto L_0x0091
        L_0x007f:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            if (r10 == 0) goto L_0x0091
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r10 = r10.navigationBarTitleText     // Catch:{ Exception -> 0x00d3 }
            boolean r10 = com.didi.dimina.container.util.TextUtil.isEmpty(r10)     // Catch:{ Exception -> 0x00d3 }
            if (r10 != 0) goto L_0x0091
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r7 = r10.navigationBarTitleText     // Catch:{ Exception -> 0x00d3 }
        L_0x0091:
            java.lang.String r10 = r5.navigationBarTextStyle     // Catch:{ Exception -> 0x00d3 }
            boolean r10 = com.didi.dimina.container.util.TextUtil.isEmpty(r10)     // Catch:{ Exception -> 0x00d3 }
            if (r10 != 0) goto L_0x009c
            java.lang.String r10 = r5.navigationBarTextStyle     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00b0
        L_0x009c:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            if (r10 == 0) goto L_0x00af
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r10 = r10.navigationBarTextStyle     // Catch:{ Exception -> 0x00d3 }
            boolean r10 = com.didi.dimina.container.util.TextUtil.isEmpty(r10)     // Catch:{ Exception -> 0x00d3 }
            if (r10 != 0) goto L_0x00af
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r10 = r9.window     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r10 = r10.navigationBarTextStyle     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00b0
        L_0x00af:
            r10 = r0
        L_0x00b0:
            java.lang.String r11 = r5.backgroundColor     // Catch:{ Exception -> 0x00cf }
            boolean r11 = com.didi.dimina.container.util.TextUtil.isEmpty(r11)     // Catch:{ Exception -> 0x00cf }
            if (r11 != 0) goto L_0x00bc
            java.lang.String r5 = r5.backgroundColor     // Catch:{ Exception -> 0x00cf }
        L_0x00ba:
            r8 = r5
            goto L_0x00d8
        L_0x00bc:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r5 = r9.window     // Catch:{ Exception -> 0x00cf }
            if (r5 == 0) goto L_0x00d8
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r5 = r9.window     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = r5.backgroundColor     // Catch:{ Exception -> 0x00cf }
            boolean r5 = com.didi.dimina.container.util.TextUtil.isEmpty(r5)     // Catch:{ Exception -> 0x00cf }
            if (r5 != 0) goto L_0x00d8
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r5 = r9.window     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = r5.backgroundColor     // Catch:{ Exception -> 0x00cf }
            goto L_0x00ba
        L_0x00cf:
            r5 = move-exception
            goto L_0x00d5
        L_0x00d1:
            r10 = r0
            goto L_0x00d8
        L_0x00d3:
            r5 = move-exception
            r10 = r0
        L_0x00d5:
            r5.printStackTrace()
        L_0x00d8:
            android.view.ViewGroup$LayoutParams r5 = r2.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5
            int r9 = r5.leftMargin
            int r11 = r5.topMargin
            int r11 = r11 + r1
            int r1 = r5.rightMargin
            int r12 = r5.bottomMargin
            r5.setMargins(r9, r11, r1, r12)
            r2.setLayoutParams(r5)
            r4.setText(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r2 = "#ffffff"
            java.lang.String r5 = "#000000"
            if (r1 == 0) goto L_0x0109
            int r0 = android.graphics.Color.parseColor(r5)
            r4.setTextColor(r0)
            int r0 = android.graphics.Color.parseColor(r2)
            r13.setBackgroundColor(r0)
            goto L_0x0131
        L_0x0109:
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0117
            int r0 = android.graphics.Color.parseColor(r5)
            r4.setTextColor(r0)
            goto L_0x0126
        L_0x0117:
            java.lang.String r0 = "white"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0126
            int r0 = android.graphics.Color.parseColor(r2)
            r4.setTextColor(r0)
        L_0x0126:
            java.lang.String r0 = com.didi.dimina.container.util.ColorUtil.convert3To6(r8)
            int r0 = android.graphics.Color.parseColor(r0)
            r13.setBackgroundColor(r0)
        L_0x0131:
            if (r3 == 0) goto L_0x0138
            r0 = 8
            r6.setVisibility(r0)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.loadpage.DMDefaultLoadingView.init():void");
    }
}
