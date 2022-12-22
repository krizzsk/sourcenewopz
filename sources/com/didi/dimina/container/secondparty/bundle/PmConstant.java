package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.util.DomainComplianceUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmConstant;", "", "()V", "API_CONFIG_REQUEST_RETRY_COUNT", "", "JSAPP_ASSETS_CONFIG_FILE_NAME", "", "JSAPP_ASSETS_DIR_PREFIX", "JSSDK_ASSETS_DIR", "KEY_NATIVE_APP_VERSION_CODE", "MODULE_LAZY_DOWNLOAD_NO_0", "MODULE_LAZY_DOWNLOAD_SUB_PRE_2", "MODULE_LAZY_DOWNLOAD_YES_1", "UNZIP_MAX_RETRY_COUNT", "prefixMMKVDmConfigKey", "prefixMMKVDmConfigKey$annotations", "getPrefixMMKVDmConfigKey", "()Ljava/lang/String;", "HTTP", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PmConstant.kt */
public final class PmConstant {
    public static final int API_CONFIG_REQUEST_RETRY_COUNT = 2;
    public static final PmConstant INSTANCE = new PmConstant();
    public static final String JSAPP_ASSETS_CONFIG_FILE_NAME = "config.json";
    public static final String JSAPP_ASSETS_DIR_PREFIX = "dimina/bundle/";
    public static final String JSSDK_ASSETS_DIR = "dimina/jssdk";
    public static final String KEY_NATIVE_APP_VERSION_CODE = "dimina_key_native_app_version_code";
    public static final int MODULE_LAZY_DOWNLOAD_NO_0 = 0;
    public static final int MODULE_LAZY_DOWNLOAD_SUB_PRE_2 = 2;
    public static final int MODULE_LAZY_DOWNLOAD_YES_1 = 1;
    public static final int UNZIP_MAX_RETRY_COUNT = 3;

    public static final String getPrefixMMKVDmConfigKey() {
        return "key_pck_dm_v2_config_";
    }

    @JvmStatic
    public static /* synthetic */ void prefixMMKVDmConfigKey$annotations() {
    }

    private PmConstant() {
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/bundle/PmConstant$HTTP;", "", "()V", "API_CONFIG_V2", "", "KEY_2_URL", "SUCC_CODE_200", "", "getDefaultHostDomain", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PmConstant.kt */
    public static final class HTTP {
        public static final String API_CONFIG_V2 = "/api/v2/config";
        public static final HTTP INSTANCE = new HTTP();
        public static final String KEY_2_URL = "/api/public_urls";
        public static final int SUCC_CODE_200 = 200;

        private HTTP() {
        }

        @JvmStatic
        public static final String getDefaultHostDomain() {
            return DomainComplianceUtil.Companion.getHttpsColonDoubleSlash() + "pkg-manage.chengxinyouxuan.com";
        }
    }
}
