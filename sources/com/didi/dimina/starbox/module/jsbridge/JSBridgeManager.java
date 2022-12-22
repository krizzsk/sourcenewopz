package com.didi.dimina.starbox.module.jsbridge;

import com.didi.dimina.container.DMMina;

public class JSBridgeManager {

    /* renamed from: a */
    private final DMMina f18009a;

    /* renamed from: b */
    private DMMinaInfoSubJSBridge f18010b;

    /* renamed from: c */
    private GCSubJSBridge f18011c;

    /* renamed from: d */
    private BundleUrlSubJSBridge f18012d;

    /* renamed from: e */
    private ScanSubJSBridge f18013e;

    /* renamed from: f */
    private DevModeSubJSBridge f18014f;

    /* renamed from: g */
    private VConsoleJSBridge f18015g;

    /* renamed from: h */
    private ExtendSubJSBridge f18016h;

    /* renamed from: i */
    private InputModalSubJSBridge f18017i;

    /* renamed from: j */
    private DiminaDemoSubJSBridge f18018j;

    public JSBridgeManager(DMMina dMMina) {
        this.f18009a = dMMina;
    }

    public InputModalSubJSBridge getInputModalSubJSBridge() {
        if (this.f18017i == null) {
            synchronized (this) {
                if (this.f18017i == null) {
                    this.f18017i = new InputModalSubJSBridge(this.f18009a.getActivity());
                }
            }
        }
        return this.f18017i;
    }

    public ExtendSubJSBridge getExtendSubJSBridge() {
        if (this.f18016h == null) {
            synchronized (this) {
                if (this.f18016h == null) {
                    this.f18016h = new ExtendSubJSBridge();
                }
            }
        }
        return this.f18016h;
    }

    public VConsoleJSBridge getVConsoleJSBridge() {
        if (this.f18015g == null) {
            synchronized (this) {
                if (this.f18015g == null) {
                    this.f18015g = new VConsoleJSBridge();
                }
            }
        }
        return this.f18015g;
    }

    public DMMinaInfoSubJSBridge getDMMinaInfoSubJSBridge() {
        if (this.f18010b == null) {
            synchronized (this) {
                if (this.f18010b == null) {
                    this.f18010b = new DMMinaInfoSubJSBridge();
                }
            }
        }
        return this.f18010b;
    }

    public GCSubJSBridge getGCSubJSBridge() {
        if (this.f18011c == null) {
            synchronized (this) {
                if (this.f18011c == null) {
                    this.f18011c = new GCSubJSBridge(this.f18009a.getActivity());
                }
            }
        }
        return this.f18011c;
    }

    public BundleUrlSubJSBridge getBundleUrlSubJSBridge() {
        if (this.f18012d == null) {
            synchronized (this) {
                if (this.f18012d == null) {
                    this.f18012d = new BundleUrlSubJSBridge(this.f18009a.getActivity());
                }
            }
        }
        return this.f18012d;
    }

    public ScanSubJSBridge getScanSubJSBridge() {
        if (this.f18013e == null) {
            synchronized (this) {
                if (this.f18013e == null) {
                    this.f18013e = new ScanSubJSBridge(this.f18009a.getActivity());
                }
            }
        }
        return this.f18013e;
    }

    public DevModeSubJSBridge getDevModeSubJSBridge() {
        if (this.f18014f == null) {
            synchronized (this) {
                if (this.f18014f == null) {
                    this.f18014f = new DevModeSubJSBridge(this.f18009a);
                }
            }
        }
        return this.f18014f;
    }

    public DiminaDemoSubJSBridge getDiminaDemoSubJSBridge() {
        if (this.f18018j == null) {
            synchronized (this) {
                if (this.f18018j == null) {
                    this.f18018j = new DiminaDemoSubJSBridge(this.f18009a);
                }
            }
        }
        return this.f18018j;
    }
}
