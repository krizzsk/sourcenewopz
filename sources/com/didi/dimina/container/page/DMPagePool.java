package com.didi.dimina.container.page;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DMPagePool {
    public static final String TAG_PAGE_FRAME = "PAGE_FRAME";

    /* renamed from: a */
    private final LinkedList<DMPage> f17020a = new LinkedList<>();

    /* renamed from: b */
    private final LinkedList<DMPage> f17021b = new LinkedList<>();

    /* renamed from: c */
    private final Map<String, LinkedList<DMPage>> f17022c = new HashMap();

    /* renamed from: d */
    private final Activity f17023d;

    /* renamed from: e */
    private final DMMina f17024e;

    /* renamed from: f */
    private volatile IDMCommonAction<Void> f17025f;

    /* renamed from: g */
    private List<JSAppConfig.DidiPageFrameItem> f17026g;

    public DMPagePool(DMMina dMMina, Activity activity) {
        this.f17023d = activity;
        this.f17024e = dMMina;
    }

    public void requireReadyDMPageCreated(IDMCommonAction<Void> iDMCommonAction, String str) {
        if (this.f17021b.isEmpty() && !m12538a(str)) {
            this.f17025f = iDMCommonAction;
        } else if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    private boolean m12538a(String str) {
        return this.f17022c.get(str) != null && this.f17022c.get(str).size() > 0;
    }

    public DMPage getReadyDMPage(String str) {
        String splitPath = HttpUtil.splitPath(str);
        LogUtil.iRelease("PAGE_FRAME", "??????????????????????????????" + splitPath);
        if (!TextUtils.isEmpty(splitPath)) {
            for (Map.Entry next : this.f17022c.entrySet()) {
                if (splitPath.equals(next.getKey()) && next.getValue() != null && ((LinkedList) next.getValue()).size() > 0) {
                    LogUtil.iRelease("PAGE_FRAME", "?????? di-page-frame: " + ((String) next.getKey()) + " url: " + str);
                    return (DMPage) ((LinkedList) next.getValue()).removeFirst();
                }
            }
        }
        if (this.f17021b.isEmpty()) {
            return null;
        }
        LogUtil.iRelease("PAGE_FRAME", "?????? page-frame url:" + str);
        return this.f17021b.removeFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12535a() {
        DMPage dMPage = (DMPage) LayoutInflater.from(this.f17023d).inflate(R.layout.dimina_webview_fragment, (ViewGroup) null);
        dMPage.preLoadView(this.f17024e);
        this.f17020a.addLast(dMPage);
    }

    /* renamed from: a */
    private boolean m12537a(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (didiPageFrameItem == null || didiPageFrameItem.isEmpty()) {
            return false;
        }
        DMPage dMPage = (DMPage) LayoutInflater.from(this.f17023d).inflate(R.layout.dimina_webview_fragment, (ViewGroup) null);
        dMPage.setPageFrameConfig(didiPageFrameItem);
        if (!dMPage.preLoadSingleView(this.f17024e, didiPageFrameItem)) {
            return false;
        }
        this.f17020a.addLast(dMPage);
        return true;
    }

    public void putDMPageToReady(int i) {
        DMPage preDMPage = getPreDMPage(i);
        if (preDMPage != null) {
            preDMPage.poolMark = 2;
            this.f17020a.remove(preDMPage);
            JSAppConfig.DidiPageFrameItem pageFrameConfig = preDMPage.getPageFrameConfig();
            if (pageFrameConfig == null || pageFrameConfig.isEmpty()) {
                LogUtil.iRelease("PAGE_FRAME", "????????????: page-frame.");
                this.f17021b.addLast(preDMPage);
            } else if (this.f17022c.containsKey(pageFrameConfig.url)) {
                this.f17022c.get(pageFrameConfig.url).addLast(preDMPage);
                LogUtil.iRelease("PAGE_FRAME", "????????????: " + pageFrameConfig.url + ".");
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.addLast(preDMPage);
                this.f17022c.put(pageFrameConfig.url, linkedList);
                LogUtil.iRelease("PAGE_FRAME", "????????????: " + pageFrameConfig.url);
            }
            if (this.f17025f != null) {
                this.f17025f.callback(null);
                this.f17025f = null;
            }
        }
    }

    /* renamed from: b */
    private void m12540b() {
        if (this.f17024e.getJSAppConfig() != null && this.f17024e.getJSAppConfig().didiPageFrame != null) {
            LogUtil.iRelease("PAGE_FRAME", "??????PageFrame?????????????????????" + this.f17024e.getJSAppConfig().didiPageFrame.size());
            this.f17026g = this.f17024e.getJSAppConfig().didiPageFrame;
        }
    }

    /* renamed from: c */
    private void m12542c() {
        if (this.f17021b.size() < 1) {
            UIHandlerUtil.safePost(this.f17024e, new Runnable() {
                public void run() {
                    DMPagePool.this.m12535a();
                }
            });
        }
    }

    public void genDMPage4FirstCreate() {
        LogUtil.iRelease("PAGE_FRAME", "genDMPage4FirstCreate()");
        m12540b();
        String d = m12544d();
        LogUtil.iRelease("PAGE_FRAME", "?????????????????????????????????entryPath = " + d);
        LogUtil.iRelease("PAGE_FRAME", "??????didiPageFrame??????" + JSONUtil.toJson(this.f17024e.getJSAppConfig().didiPageFrame));
        if (TextUtils.isEmpty(d)) {
            m12542c();
        } else if (!m12541b(m12539b(d))) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame, ??????????????????DMPage" + d);
            m12542c();
        }
    }

    /* renamed from: b */
    private JSAppConfig.DidiPageFrameItem m12539b(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("/")) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame: ??????????????????");
            return null;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        String[] split = str.split("/", 2);
        if (split.length < 2) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame: ?????????/????????????");
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame: ?????????/????????????");
            return null;
        } else if (this.f17024e.getJSAppConfig().subPackages == null || this.f17024e.getJSAppConfig().subpackagesDir == null) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame: subPackages/subpackagesDir??????");
            return null;
        } else {
            String str4 = "";
            for (JSAppConfig.SubPackage next : this.f17024e.getJSAppConfig().subPackages) {
                if (str2.equals(next.root)) {
                    for (String equals : next.pages) {
                        if (str3.equals(equals)) {
                            str4 = this.f17024e.getJSAppConfig().subpackagesDir.get(str2);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            if (this.f17024e.getJSAppConfig().didiPageFrame == null) {
                LogUtil.iRelease("PAGE_FRAME", "???????????????quick-page-frame: didiPageFrame??????");
                return null;
            }
            for (JSAppConfig.DidiPageFrameItem next2 : this.f17024e.getJSAppConfig().didiPageFrame) {
                if (next2.root.equals(str4) && next2.url.equals(str3)) {
                    LogUtil.iRelease("PAGE_FRAME", "????????????quick-page-frame: " + str);
                    return next2;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[SYNTHETIC, Splitter:B:12:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m12544d() {
        /*
            r2 = this;
            com.didi.dimina.container.DMMina r0 = r2.f17024e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f17024e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            com.didi.dimina.container.DMConfig$LaunchConfig r0 = r0.getLaunchConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f17024e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            com.didi.dimina.container.DMConfig$LaunchConfig r0 = r0.getLaunchConfig()
            java.lang.String r0 = r0.getEntryPath()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x003b
            com.didi.dimina.container.DMMina r0 = r2.f17024e
            com.didi.dimina.container.bean.JSAppConfig r0 = r0.getJSAppConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f17024e
            com.didi.dimina.container.bean.JSAppConfig r0 = r0.getJSAppConfig()
            java.lang.String r0 = r0.entryPagePath
            goto L_0x003b
        L_0x0039:
            java.lang.String r0 = ""
        L_0x003b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x004f
            java.net.URI r1 = new java.net.URI     // Catch:{ URISyntaxException -> 0x004b }
            r1.<init>(r0)     // Catch:{ URISyntaxException -> 0x004b }
            java.lang.String r0 = r1.getPath()     // Catch:{ URISyntaxException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPagePool.m12544d():java.lang.String");
    }

    /* renamed from: e */
    private String m12546e() {
        return (this.f17024e.getConfig() == null || this.f17024e.getConfig().getLaunchConfig() == null) ? "" : this.f17024e.getConfig().getLaunchConfig().getAppId();
    }

    public void genDMPage4DomReady() {
        LogUtil.iRelease("PAGE_FRAME", "???????????????????????????DOMReady");
        for (JSAppConfig.DidiPageFrameItem next : m12548f()) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????????????????DOMReady ????????????????????????" + next.url);
            m12541b(next);
        }
        if (this.f17021b.size() < 1) {
            LogUtil.iRelease("PAGE_FRAME", "??????:page-frame??????????????????????????????DOMReady ???????????????????????????");
            UIHandlerUtil.safePost(this.f17024e, new Runnable() {
                public final void run() {
                    DMPagePool.this.m12535a();
                }
            });
        }
    }

    /* renamed from: b */
    private boolean m12541b(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (didiPageFrameItem == null || didiPageFrameItem.isEmpty()) {
            LogUtil.iRelease("PAGE_FRAME", "???????????? didiPageFrameItem ?????? ");
            return false;
        } else if (!m12545d(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "???????????? ???????????????quick-page-frame.html?????????: ");
            return false;
        } else if (!m12547e(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "???????????? ?????????????????????: " + didiPageFrameItem.url);
            return false;
        } else {
            if (!this.f17022c.containsKey(didiPageFrameItem.url)) {
                this.f17022c.put(didiPageFrameItem.url, new LinkedList());
            }
            UIHandlerUtil.runOnUiThread(new Runnable(didiPageFrameItem) {
                public final /* synthetic */ JSAppConfig.DidiPageFrameItem f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DMPagePool.this.m12549f(this.f$1);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m12549f(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        List list = this.f17022c.get(didiPageFrameItem.url);
        if (list == null) {
            return;
        }
        if (list.size() >= 1) {
            LogUtil.iRelease("PAGE_FRAME", "???????????? ?????????: " + didiPageFrameItem.url);
        } else if (m12543c(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "???????????? ??????????????????????????????: " + didiPageFrameItem.url);
        } else if (this.f17024e.getCurNavigator() == null || this.f17024e.getCurNavigator().getCurrentPages() == null || this.f17024e.getCurNavigator().getCurrentPages().size() <= 6 || !DMMemoryManager.getInstance().isLowMemory()) {
            LogUtil.iRelease("PAGE_FRAME", "???????????????????????????: " + didiPageFrameItem.url);
            if (!m12537a(didiPageFrameItem)) {
                m12542c();
            }
        } else {
            LogUtil.iRelease("PAGE_FRAME", "???????????? ????????????: " + didiPageFrameItem.url);
        }
    }

    /* renamed from: f */
    private List<JSAppConfig.DidiPageFrameItem> m12548f() {
        ArrayList arrayList = new ArrayList();
        List<JSAppConfig.DidiPageFrameItem> list = this.f17026g;
        if (!(list == null || list.size() == 0)) {
            for (JSAppConfig.DidiPageFrameItem next : this.f17026g) {
                if (next != null && !next.isEmpty()) {
                    arrayList.add(next);
                }
            }
            LogUtil.m13412i("PAGE_FRAME", "??????DOMReady????????????????????????????????????" + JSONUtil.toJson(arrayList));
        }
        return arrayList;
    }

    /* renamed from: c */
    private boolean m12543c(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        Iterator it = this.f17020a.iterator();
        while (it.hasNext()) {
            DMPage dMPage = (DMPage) it.next();
            if (dMPage.getPageFrameConfig() != null && dMPage.getPageFrameConfig().url.equals(didiPageFrameItem.url)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private boolean m12545d(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (this.f17024e.getConfig().getLaunchConfig().getBundleManagerStrategy() instanceof RemoteBundleMangerStrategy) {
            return false;
        }
        return FileUtil.isFileProtocolExists(BundleManager.getInstance().transformUrl(this.f17024e, didiPageFrameItem.root, didiPageFrameItem.getModelName()));
    }

    /* renamed from: e */
    private boolean m12547e(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (this.f17024e.getConfig().getLaunchConfig().getBundleManagerStrategy() instanceof RemoteBundleMangerStrategy) {
            return false;
        }
        return FileUtil.isParentFileDirProtocolExists(BundleManager.getInstance().transformUrl(this.f17024e, didiPageFrameItem.root, didiPageFrameItem.getModelName()));
    }

    public DMPage getPreDMPage(int i) {
        Iterator it = this.f17020a.iterator();
        while (it.hasNext()) {
            DMPage dMPage = (DMPage) it.next();
            if (dMPage.getWebViewId() == i) {
                return dMPage;
            }
        }
        return null;
    }
}
