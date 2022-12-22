package com.didi.dimina.container.secondparty.jsmodule;

import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.apollo.ApolloSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.dmlog.ReportMiniProgramSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.location.LocationSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.omega.OmegaSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.p105wx.DMMinaNavigator;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.ImageSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.raven.RavenSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.scan.ScanSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.setting.SettingSecondPartySubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.WebSocketSubJSBridge;

public class DMServiceTwoPartJSModuleLazyParameter {
    private final FragmentActivity mActivity;
    private volatile ApolloSubJSBridge mApollo;
    private final DMMina mDMMina;
    private volatile ImageSubJSBridge mImage;
    private volatile LocationSubJSBridge mLocation;
    private volatile DMMinaNavigator mMiniProgramNavigator;
    private volatile OmegaSubJSBridge mOmega;
    private volatile RavenSubJSBridge mRavenSubJsBridge;
    private volatile ReportMiniProgramSubJSBridge mReportMiniProgramSubJSBridge;
    private volatile ScanSubJSBridge mScan;
    private volatile SettingSecondPartySubJSBridge mSettingSubJSBridge;
    private volatile WebSocketSubJSBridge mWebSocketSubJSBridge;

    public DMServiceTwoPartJSModuleLazyParameter(DMMina dMMina) {
        this.mDMMina = dMMina;
        this.mActivity = dMMina.getActivity();
    }

    /* access modifiers changed from: package-private */
    public ScanSubJSBridge getScan() {
        if (this.mScan == null) {
            synchronized (this) {
                if (this.mScan == null) {
                    this.mScan = new ScanSubJSBridge();
                }
            }
        }
        return this.mScan;
    }

    /* access modifiers changed from: package-private */
    public DMMinaNavigator getMiniProgramNavigator() {
        if (this.mMiniProgramNavigator == null) {
            synchronized (this) {
                if (this.mMiniProgramNavigator == null) {
                    this.mMiniProgramNavigator = new DMMinaNavigator(this.mDMMina, this.mActivity);
                }
            }
        }
        return this.mMiniProgramNavigator;
    }

    /* access modifiers changed from: package-private */
    public RavenSubJSBridge getRavenSubJSBridge() {
        if (this.mRavenSubJsBridge == null) {
            synchronized (this) {
                if (this.mRavenSubJsBridge == null) {
                    this.mRavenSubJsBridge = new RavenSubJSBridge(this.mDMMina.getConfig());
                }
            }
        }
        return this.mRavenSubJsBridge;
    }

    /* access modifiers changed from: package-private */
    public ApolloSubJSBridge getApollo() {
        if (this.mApollo == null) {
            synchronized (this) {
                if (this.mApollo == null) {
                    this.mApollo = new ApolloSubJSBridge();
                }
            }
        }
        return this.mApollo;
    }

    /* access modifiers changed from: package-private */
    public OmegaSubJSBridge getOmega() {
        if (this.mOmega == null) {
            synchronized (this) {
                if (this.mOmega == null) {
                    this.mOmega = new OmegaSubJSBridge();
                }
            }
        }
        return this.mOmega;
    }

    /* access modifiers changed from: package-private */
    public ImageSubJSBridge getImage() {
        if (this.mImage == null) {
            synchronized (this) {
                if (this.mImage == null) {
                    this.mImage = new ImageSubJSBridge(this.mActivity, this.mDMMina);
                }
            }
        }
        return this.mImage;
    }

    /* access modifiers changed from: package-private */
    public LocationSubJSBridge getLocation() {
        if (this.mLocation == null) {
            synchronized (this) {
                if (this.mLocation == null) {
                    this.mLocation = new LocationSubJSBridge(this.mDMMina, this.mActivity);
                }
            }
        }
        return this.mLocation;
    }

    /* access modifiers changed from: package-private */
    public WebSocketSubJSBridge getWebSocketSubJSBridge() {
        if (this.mWebSocketSubJSBridge == null) {
            synchronized (this) {
                if (this.mWebSocketSubJSBridge == null) {
                    this.mWebSocketSubJSBridge = new WebSocketSubJSBridge(this.mDMMina);
                }
            }
        }
        return this.mWebSocketSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public SettingSecondPartySubJSBridge getSettingSubJSBridge() {
        if (this.mSettingSubJSBridge == null) {
            synchronized (this) {
                if (this.mSettingSubJSBridge == null) {
                    this.mSettingSubJSBridge = new SettingSecondPartySubJSBridge(this.mDMMina, this.mActivity);
                }
            }
        }
        return this.mSettingSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public ReportMiniProgramSubJSBridge getReportMiniProgramSubJSBridge() {
        if (this.mReportMiniProgramSubJSBridge == null) {
            synchronized (this) {
                if (this.mReportMiniProgramSubJSBridge == null) {
                    this.mReportMiniProgramSubJSBridge = new ReportMiniProgramSubJSBridge(this.mDMMina);
                }
            }
        }
        return this.mReportMiniProgramSubJSBridge;
    }
}
