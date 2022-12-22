package com.didi.sdk.componentspi;

import android.app.Application;
import android.content.Context;
import com.didi.product.global.BuildConfig;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.developermode.DevModePreference;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.INationTypeComponent;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider({INationTypeComponent.class})
public class NationTypeComponent implements INationTypeComponent {

    /* renamed from: a */
    private static Logger f35694a = LoggerFactory.getLogger("NationTypeComponent");

    /* renamed from: b */
    private NationComponentData f35695b;

    /* renamed from: c */
    private final NationComponentData.LoginAction f35696c = new NationComponentData.LoginAction() {
        public void login() {
            OneLoginFacade.getAction().go2Login(DIDIApplicationDelegate.getAppContext());
        }

        public void loginout(String str) {
            OneLoginFacade.getAction().activeLogout(DIDIApplicationDelegate.getAppContext(), str);
        }

        public void go2Login() {
            OneLoginFacade.getAction().go2Login(DIDIApplicationDelegate.getAppContext());
        }
    };

    public NationComponentData getNationComponentData() {
        m25281a();
        return this.f35695b;
    }

    public void refreshPushHost() {
        NationComponentData nationComponentData = this.f35695b;
        if (nationComponentData == null) {
            m25281a();
        } else {
            nationComponentData.setPushConfig(m25280a(DIDIApplication.getAppContext()));
        }
    }

    /* renamed from: a */
    private void m25281a() {
        if (this.f35695b == null) {
            this.f35695b = new NationComponentDataDelegate();
            Application appContext = DIDIApplicationDelegate.getAppContext();
            this.f35695b.setPushConfig(m25280a(appContext));
            this.f35695b.setLoginAction(this.f35696c);
            this.f35695b.setOriginID(AppUtils.getMetaDataByKey("origin_id"));
            if (DomainUtil.isSupportDomainSwitch(appContext)) {
                String rebuildHost = DomainUtil.rebuildHost("omgup.didiglobal.com", DomainServiceManager.getInstance().getDomainSuffix(appContext));
                ELog.log("rebuild omega upload host for sdk init with: " + rebuildHost);
                this.f35695b.setOmegaUploadHost(rebuildHost);
            } else {
                this.f35695b.setOmegaUploadHost("omgup.didiglobal.com");
            }
            this.f35695b.setMapTypeString((AnalysisAPK.isGlobalHmsApk(appContext) ? MapType.MATYPE_HMS : MapType.MATYPE_GMAP).getMapTypeString());
            this.f35695b.setMapTypeInt(MapType.MAPTYPE_WGS84.getMapTypeInt());
            this.f35695b.setCoordinateType(MapType.MAPTYPE_WGS84.getMapTypeString());
            this.f35695b.setPlatform_type("2");
            this.f35695b.setTerminal_id(AppUtils.getMetaDataByKey("terminal_id"));
            this.f35695b.setBiz_type("1");
            this.f35695b.setProductPreFix(AppUtils.getMetaDataByKey(EventKeys.APP_SCHEME_PREFIX));
            this.f35695b.setUserAgentPrefix(AppUtils.getMetaDataByKey(EventKeys.USER_AGENT_PREFIX));
            this.f35695b.setBrand(AppUtils.getMetaDataByKey("brand"));
        }
    }

    /* renamed from: a */
    private NationComponentData.PushConfig m25280a(Context context) {
        int i;
        String str;
        NationComponentData.PushConfig pushConfig = new NationComponentData.PushConfig();
        ELog.log("DevModeUtil.getDevEnvironment(context) = " + DevModeUtil.getDevEnvironment(context));
        if (DevModeUtil.getDevEnvironment(context) == DevModeUtil.DevEnvironment.DEBUG) {
            str = DevModePreference.getPushIp(context);
            i = Integer.valueOf(DevModePreference.getPushPort(context)).intValue();
        } else {
            if (DomainUtil.isSupportDomainSwitch(context)) {
                String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(context);
                str = DomainUtil.rebuildHost(BuildConfig.PUSH_IP, domainSuffix);
                ELog.log("in getPushCfg() suffix = " + domainSuffix);
            } else {
                str = BuildConfig.PUSH_IP;
            }
            i = 25269;
        }
        ELog.log("push_ip: " + str + " &push_port = " + i);
        pushConfig.setIp(str);
        pushConfig.setPort(i);
        return pushConfig;
    }
}
