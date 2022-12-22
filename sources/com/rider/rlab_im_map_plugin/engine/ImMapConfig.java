package com.rider.rlab_im_map_plugin.engine;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.rlab.uni_im_map.map.IMMapLogServiceRegister;
import com.didi.rlab.uni_im_map.map.IMMapOmegaServiceRegister;
import com.didi.rlab.uni_im_map.map.IMXpannelServiceRegister;
import com.didi.rlab.uni_im_map.map.MapIMNavigationServicePlugin;
import com.didi.rlab.uni_im_map.map.MapIMServicePlugin;
import com.didi.rlab.uni_im_map.map.MapIMServiceRegister;
import com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.channel.IMMapLogServiceImpl;
import com.rider.rlab_im_map_plugin.channel.IMMapOmegaServiceImpl;
import com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.channel.XpannelServiceImpl;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import java.util.Locale;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.plugin.common.BinaryMessenger;

public final class ImMapConfig {

    /* renamed from: a */
    private static final Logger f55852a = LoggerFactory.getLogger("ImMapEngine");

    /* renamed from: b */
    private static volatile ImMapConfig f55853b = null;

    /* renamed from: c */
    private Context f55854c;

    /* renamed from: d */
    private boolean f55855d = false;

    /* renamed from: e */
    private boolean f55856e = false;

    /* renamed from: f */
    private String f55857f;

    /* renamed from: g */
    private ImCallFrom f55858g;

    /* renamed from: h */
    private ImFavorFrom f55859h;

    /* renamed from: i */
    private boolean f55860i = true;

    /* renamed from: j */
    private String f55861j;

    /* renamed from: k */
    private String f55862k;

    /* renamed from: l */
    private int f55863l;

    /* renamed from: m */
    private int f55864m;

    /* renamed from: n */
    private int f55865n;

    /* renamed from: o */
    private boolean f55866o;

    /* renamed from: p */
    private boolean f55867p;

    /* renamed from: q */
    private OnSelectNavListener f55868q;

    /* renamed from: r */
    private CustomerConfigListener f55869r;

    /* renamed from: s */
    private OmegaParamsCallback f55870s;

    /* renamed from: t */
    private Locale f55871t;

    /* renamed from: u */
    private boolean f55872u = false;

    /* renamed from: v */
    private LatLng f55873v;

    /* renamed from: w */
    private boolean f55874w = false;

    /* renamed from: x */
    private NachoAction f55875x;

    /* renamed from: y */
    private boolean f55876y = false;

    /* renamed from: z */
    private int f55877z = 0;

    private ImMapConfig() {
    }

    public static ImMapConfig getInstance() {
        ImMapConfig imMapConfig;
        if (f55853b != null) {
            return f55853b;
        }
        synchronized (ImMapConfig.class) {
            if (f55853b == null) {
                f55853b = new ImMapConfig();
            }
            imMapConfig = f55853b;
        }
        return imMapConfig;
    }

    public ImMapConfig setImCallFrom(ImCallFrom imCallFrom) {
        this.f55858g = imCallFrom;
        return this;
    }

    public ImMapConfig setImFavorFrom(ImFavorFrom imFavorFrom) {
        this.f55859h = imFavorFrom;
        return this;
    }

    public ImMapConfig setUserNewMap(boolean z) {
        this.f55860i = z;
        return this;
    }

    public ImMapConfig setProductId(String str) {
        this.f55861j = str;
        return this;
    }

    public ImMapConfig setToken(String str) {
        this.f55862k = str;
        return this;
    }

    public ImMapConfig setNavType(int i) {
        this.f55863l = i;
        return this;
    }

    public ImMapConfig setZoomLevel(int i) {
        this.f55864m = i;
        return this;
    }

    public ImMapConfig setTravelMode(int i) {
        this.f55865n = i;
        return this;
    }

    public ImMapConfig setDowngradeMap(boolean z) {
        this.f55855d = z;
        return this;
    }

    public ImMapConfig setMapStyle(String str) {
        this.f55857f = str;
        return this;
    }

    public ImMapConfig setGoogleNav(boolean z) {
        this.f55866o = z;
        return this;
    }

    public ImMapConfig setIsDebug(boolean z) {
        this.f55867p = z;
        return this;
    }

    public ImMapConfig setDowngradeMapNavigation(boolean z) {
        this.f55856e = z;
        return this;
    }

    public ImMapConfig setOnSelectNavListener(OnSelectNavListener onSelectNavListener) {
        this.f55868q = onSelectNavListener;
        return this;
    }

    public ImMapConfig setCustomerConfigListener(CustomerConfigListener customerConfigListener) {
        this.f55869r = customerConfigListener;
        return this;
    }

    public ImMapConfig setOmegaParamsCallback(OmegaParamsCallback omegaParamsCallback) {
        this.f55870s = omegaParamsCallback;
        return this;
    }

    public ImMapConfig setLocale(Locale locale) {
        this.f55871t = locale;
        return this;
    }

    public ImMapConfig setShowMapTool(boolean z) {
        this.f55872u = z;
        return this;
    }

    public ImMapConfig setMockLatLng(LatLng latLng) {
        this.f55873v = latLng;
        return this;
    }

    public ImMapConfig setNachoAction(NachoAction nachoAction) {
        this.f55875x = nachoAction;
        return this;
    }

    public ImMapConfig setHmsService(boolean z) {
        this.f55876y = z;
        return this;
    }

    public ImMapConfig setBusinessType(int i) {
        this.f55877z = i;
        return this;
    }

    public void build(Context context) {
        this.f55854c = context;
        ImCallFrom imCallFrom = this.f55858g;
        if (imCallFrom == null) {
            f55852a.info("callFrom must be not null , please set", new Object[0]);
            throw new NullPointerException("callFrom must be not null , please set");
        } else if (this.f55871t == null) {
            f55852a.info("locale must be not null , please set", new Object[0]);
            throw new NullPointerException("locale must be not null , please set");
        } else if (this.f55870s != null) {
            if (this.f55863l == 0) {
                if (imCallFrom == ImCallFrom.IMMAP_RLAB_D) {
                    this.f55863l = 1;
                } else if (this.f55858g == ImCallFrom.IMMAP_RLAB_C) {
                    this.f55863l = 2;
                } else {
                    this.f55863l = 1;
                }
            }
            if (this.f55864m == 0) {
                this.f55864m = 14;
            }
            if (this.f55865n == 0) {
                this.f55865n = 1;
            }
            if (this.f55859h == null) {
                this.f55859h = ImFavorFrom.IMMAP_GLOBAL;
            }
            FlutterEngine flutterEngine = null;
            NachoAction nachoAction = this.f55875x;
            if (nachoAction != null) {
                flutterEngine = nachoAction.getEngine();
            }
            if (flutterEngine != null) {
                BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
                new MapIMServicePlugin().setup(binaryMessenger);
                new MapIMNavigationServicePlugin().setup(binaryMessenger);
                IMXpannelServiceRegister.setup(binaryMessenger, new XpannelServiceImpl());
                MapIMServiceRegister.setup(binaryMessenger, new MapIMServiceImpl());
                NavigationIMServiceRegister.setup(binaryMessenger, new NavIMServiceImpl());
                IMMapLogServiceRegister.setup(binaryMessenger, new IMMapLogServiceImpl());
                IMMapOmegaServiceRegister.setup(binaryMessenger, new IMMapOmegaServiceImpl());
                f55852a.info("initialize im sdk", new Object[0]);
                return;
            }
            f55852a.info("engine is null , preinitialization", new Object[0]);
            throw new NullPointerException("初始化该IM地图库，必须放到初始化flutter之后，才能保证flutter和na交互正常");
        } else {
            f55852a.info("omega must be not null , please set", new Object[0]);
            throw new NullPointerException("omega must be not null , please set");
        }
    }

    public boolean isDowngradeMap() {
        return this.f55855d;
    }

    public Context getContext() {
        return this.f55854c;
    }

    public String getRouterPath() {
        return "http://rider.didichuxing.com" + ImCommons.ROUTE_PAGE_MAIN + ImCommons.IM_PATH;
    }

    public String getMapStyle() {
        return this.f55857f;
    }

    public ImCallFrom getCallFrom() {
        return this.f55858g;
    }

    public ImFavorFrom getFavorFrom() {
        return this.f55859h;
    }

    public boolean isUserNewMap() {
        return this.f55860i;
    }

    public String getProductId() {
        return this.f55861j;
    }

    public String getToken() {
        return this.f55862k;
    }

    public int getNavType() {
        return this.f55863l;
    }

    public int getZoomLevel() {
        return this.f55864m;
    }

    public int getTravelMode() {
        return this.f55865n;
    }

    public boolean isGoogleNav() {
        return this.f55866o;
    }

    public boolean isDebug() {
        return this.f55867p;
    }

    public boolean isDowngradeMapNavigation() {
        return this.f55856e;
    }

    public OnSelectNavListener getOnSelectNavListener() {
        return this.f55868q;
    }

    public CustomerConfigListener getCustomerConfigListener() {
        return this.f55869r;
    }

    public OmegaParamsCallback getOmegaParamsCallback() {
        return this.f55870s;
    }

    public Locale getLocale() {
        return this.f55871t;
    }

    public boolean isShowMapTool() {
        return this.f55872u;
    }

    public LatLng getMockLatLng() {
        return this.f55873v;
    }

    public NachoAction getNachoAction() {
        return this.f55875x;
    }

    public boolean isHmsService() {
        return this.f55876y;
    }

    public int getBusinessType() {
        return this.f55877z;
    }
}
