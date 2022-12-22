package com.didi.dimina.container.secondparty.trace;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.trace.inner.LogTracker;
import com.didi.dimina.container.service.TraceService;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.ads.AdRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J2\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J0\u0010\u0019\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J&\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J0\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J4\u0010\u001d\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService;", "Lcom/didi/dimina/container/service/TraceService;", "()V", "jsSdkInfoVersionCache", "", "", "", "mpVersionCache", "postFix", "getPostFix", "()Ljava/lang/String;", "sMasMonitor", "Ljava/util/HashSet;", "sNeedDmLogEvent", "sNeedOmegaCoreDottingEvent", "toBamai", "", "event", "resultMap", "", "", "toDiminaMonitor", "dmMina", "Lcom/didi/dimina/container/DMMina;", "map", "toMasMonitor", "toOmega", "toRaven", "ravenId", "trackEvent", "Companion", "DMLOG_EVENT", "MAS_MONITOR_EVENT", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DiminaTraceService.kt */
public final class DiminaTraceService implements TraceService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final String f17442f = "DiminaTraceService";

    /* renamed from: a */
    private final Map<Integer, String> f17443a = new HashMap();

    /* renamed from: b */
    private final Map<Integer, String> f17444b = new HashMap();

    /* renamed from: c */
    private final HashSet<String> f17445c = new HashSet<>();

    /* renamed from: d */
    private final HashSet<String> f17446d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f17447e = new HashSet<>();

    public DiminaTraceService() {
        this.f17445c.add(Constant.CORE_DOTTING.LAUNCH_NATIVE_JS_READY);
        this.f17445c.add(Constant.CORE_DOTTING.LAUNCH_INVOKE_SERVICE_READY);
        this.f17445c.add(Constant.CORE_DOTTING.LAUNCH_INVOKE_BUSINESS_READY);
        this.f17445c.add(Constant.CORE_DOTTING.LAUNCH_LAUNCH_PAGE);
        this.f17445c.add(Constant.CORE_DOTTING.PAGE_INVOKE_PARAMS_TO_WIN_DONE);
        this.f17445c.add(Constant.CORE_DOTTING.DIMINA_PAGE_DOM_READY);
        this.f17445c.add(Constant.CORE_DOTTING.PAGE_FIRST_INVOKE_PARAMS_TO_WIN_DONE);
        this.f17445c.add(Constant.CORE_DOTTING.DIMINA_PAGE_FIRST_DOM_READY);
        this.f17445c.add(Constant.CORE_DOTTING.LAUNCH_DMMINA);
        this.f17445c.add(Constant.CORE_DOTTING.DMMINA_PRELOAD);
        this.f17446d.add(MAS_MONITOR_EVENT.LAUNCH_APP);
        this.f17446d.add("tech_saga_jscore_execute");
        this.f17446d.add(MAS_MONITOR_EVENT.OPEN_PAGE);
        this.f17446d.add("tech_saga_preload_webview");
        this.f17446d.add("tech_saga_package_request");
        this.f17446d.add("tech_saga_package_download");
        this.f17446d.add("tech_saga_sub_package_request");
        this.f17446d.add("tech_saga_sub_package_download");
        this.f17446d.add("tech_saga_screen_blank_monitor");
        this.f17447e.add(MAS_MONITOR_EVENT.LOAD_MAIN_PACKAGE_DOWNLOAD_TIME);
        this.f17447e.add(MAS_MONITOR_EVENT.OPEN_PAGE);
        this.f17447e.add(MAS_MONITOR_EVENT.LAUNCH_APP);
        this.f17447e.add(MAS_MONITOR_EVENT.ERROR);
    }

    public void trackEvent(DMMina dMMina, String str, Map<String, ? extends Object> map) {
        if (str != null) {
            m12972a(dMMina, str, map);
            Map hashMap = new HashMap();
            Dimina.Config config = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
            boolean z = true;
            boolean z2 = !config.isDebug();
            if (Intrinsics.areEqual((Object) TraceActionServiceImpl.TECH_SAGA_CORE_DOTTING, (Object) str) && map != null) {
                String str2 = (String) map.get("event");
                hashMap.put("zhKey", Constant.CORE_DOTTING.translate(str2));
                z = CollectionsKt.contains(this.f17445c, str2);
            }
            hashMap.put("pub_env", Integer.valueOf(z2 ? 1 : 0));
            hashMap.put("pub_sdk_version", Dimina.getVersion());
            hashMap.put("pub_os_type", "android");
            String str3 = "";
            if (dMMina != null) {
                int minaIndex = dMMina.getMinaIndex();
                String str4 = this.f17443a.get(Integer.valueOf(minaIndex));
                if (str4 == null) {
                    str4 = DiminaHelper.getJsSdkVersionName(dMMina);
                }
                if (str4 != null) {
                    this.f17443a.put(Integer.valueOf(minaIndex), str4);
                }
                if (str4 == null) {
                    str4 = AdRequest.VERSION;
                }
                hashMap.put("pub_jssdk_version", str4);
                hashMap.put("pub_jssdk_code", DiminaHelper.getJsSdkVersionCode(dMMina));
                DMConfig config2 = dMMina.getConfig();
                if (config2 != null && (config2.getLaunchConfig() instanceof DMConfig4Di.LaunchConfig)) {
                    DMConfig.LaunchConfig launchConfig = config2.getLaunchConfig();
                    if (launchConfig != null) {
                        str3 = ((DMConfig4Di.LaunchConfig) launchConfig).getRavenId();
                        Intrinsics.checkExpressionValueIsNotNull(str3, "(config.launchConfig as …4Di.LaunchConfig).ravenId");
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.didi.dimina.container.secondparty.DMConfig4Di.LaunchConfig");
                    }
                }
                hashMap.put("pub_jsapp_id", DiminaHelper.getJsAppId(dMMina));
                hashMap.put("pub_curpath", DMMinaHelper.getCurPath(dMMina));
                String str5 = this.f17444b.get(Integer.valueOf(minaIndex));
                if (str5 == null) {
                    str5 = DiminaHelper.getJsAppVersionName(dMMina);
                }
                if (str5 != null) {
                    this.f17444b.put(Integer.valueOf(minaIndex), str5);
                }
                hashMap.put("pub_jsapp_version", str5);
                hashMap.put("pub_jsapp_code", DiminaHelper.getJsAppVersionCode(dMMina));
                hashMap.put("pub_entrypath", DMMinaHelper.getEntryPath(dMMina));
                hashMap.put("pub_launch_type", Integer.valueOf(DMMinaHelper.getLaunchType(dMMina)));
                LogUtil.m13412i(f17442f, str + " , omage公共参数：" + hashMap);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            LogUtil.m13412i(f17442f, str + " , omage 本来的map信息：" + map);
            m12973a(str3, str, (Map<String, ? extends Object>) hashMap);
            m12974a(str, hashMap);
            if (z) {
                m12976b(str, hashMap);
            }
            m12975b(dMMina, str, hashMap);
        }
    }

    /* renamed from: a */
    private final void m12972a(DMMina dMMina, String str, Map<String, ? extends Object> map) {
        if (this.f17446d.contains(str)) {
            LogTracker.trackEvent(dMMina, str, new HashMap(map));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r1.getRegionConfigService();
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12975b(com.didi.dimina.container.DMMina r10, java.lang.String r11, java.util.Map<java.lang.String, ? extends java.lang.Object> r12) {
        /*
            r9 = this;
            java.lang.String r0 = "ebg"
            com.didi.dimina.container.Dimina$Config r1 = com.didi.dimina.container.Dimina.getConfig()
            java.lang.String r2 = "Dimina.getConfig()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.didi.dimina.container.Dimina$AdapterConfig r1 = r1.getAdapterConfig()
            if (r1 == 0) goto L_0x001c
            com.didi.dimina.container.service.RegionConfigService r1 = r1.getRegionConfigService()
            if (r1 == 0) goto L_0x001c
            java.lang.Boolean r1 = r1.isInternational()
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x002b
            return
        L_0x002b:
            java.util.HashSet<java.lang.String> r1 = r9.f17447e
            boolean r1 = r1.contains(r11)
            if (r1 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x005b
            com.didi.dimina.container.DMConfig r1 = r10.getConfig()
            boolean r1 = r1 instanceof com.didi.dimina.container.secondparty.DMConfig4Di
            if (r1 == 0) goto L_0x005b
            com.didi.dimina.container.DMConfig r1 = r10.getConfig()
            java.lang.String r2 = "dmMina.config"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.didi.dimina.container.DMConfig$LaunchConfig r1 = r1.getLaunchConfig()
            if (r1 == 0) goto L_0x0053
            com.didi.dimina.container.secondparty.DMConfig4Di$LaunchConfig r1 = (com.didi.dimina.container.secondparty.DMConfig4Di.LaunchConfig) r1
            boolean r2 = r1.isOpenMasCrossPlatformMonitor()
            goto L_0x005b
        L_0x0053:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            java.lang.String r11 = "null cannot be cast to non-null type com.didi.dimina.container.secondparty.DMConfig4Di.LaunchConfig"
            r10.<init>(r11)
            throw r10
        L_0x005b:
            if (r2 != 0) goto L_0x0065
            java.lang.String r10 = "DiminaTraceService"
            java.lang.String r11 = "mas monitor closed"
            com.didi.dimina.container.util.LogUtil.iRelease(r10, r11)
            return
        L_0x0065:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pub_mp_version"
            java.lang.Object r2 = r12.get(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.append(r2)
            java.lang.String r2 = ""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.secondparty.trace.TraceMasMonitor r4 = new com.didi.dimina.container.secondparty.trace.TraceMasMonitor
            if (r10 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0087:
            r4.<init>(r10, r1)
            java.lang.String r10 = "tech_saga_pkg_xh_download_and_install"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            r5 = 0
            java.lang.String r1 = "tmintvl"
            if (r10 == 0) goto L_0x00ca
            java.lang.String r10 = "step"
            java.lang.Object r10 = r12.get(r10)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.Object r11 = r12.get(r1)     // Catch:{ NumberFormatException -> 0x01d9 }
            if (r11 == 0) goto L_0x01d9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.append(r11)     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.append(r2)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r11 = r12.toString()     // Catch:{ NumberFormatException -> 0x01d9 }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r0 = "dwn"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)     // Catch:{ NumberFormatException -> 0x01d9 }
            if (r10 == 0) goto L_0x01d9
            int r10 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x01d9
            r4.traceDownloadMainBundle(r11)     // Catch:{ NumberFormatException -> 0x01d9 }
            goto L_0x01d9
        L_0x00ca:
            java.lang.String r10 = "tech_saga_launch_app"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            java.lang.String r7 = "ac"
            if (r10 == 0) goto L_0x011a
            java.lang.Object r10 = r12.get(r7)
            boolean r8 = r10 instanceof java.lang.Integer
            if (r8 != 0) goto L_0x00dd
            goto L_0x011a
        L_0x00dd:
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r3 != r10) goto L_0x011a
            java.lang.Object r10 = r12.get(r1)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.Object r11 = r12.get(r0)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.append(r10)     // Catch:{ NumberFormatException -> 0x01d9 }
            r12.append(r2)     // Catch:{ NumberFormatException -> 0x01d9 }
            java.lang.String r10 = r12.toString()     // Catch:{ NumberFormatException -> 0x01d9 }
            long r1 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x01d9 }
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x01d9
            boolean r10 = r11.equals(r0)     // Catch:{ NumberFormatException -> 0x01d9 }
            if (r10 != 0) goto L_0x01d9
            r4.traceFirstRenderTime(r1)     // Catch:{ NumberFormatException -> 0x01d9 }
            r4.traceEngineInit(r1)     // Catch:{ NumberFormatException -> 0x01d9 }
            goto L_0x01d9
        L_0x011a:
            java.lang.String r10 = "tech_saga_open_page"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x01b7
            java.lang.String r10 = "path"
            java.lang.Object r10 = r12.get(r10)     // Catch:{  }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{  }
            java.lang.Object r11 = r12.get(r7)     // Catch:{  }
            boolean r0 = com.didi.dimina.container.util.TextUtil.isEmpty(r10)     // Catch:{  }
            if (r0 == 0) goto L_0x0135
            return
        L_0x0135:
            boolean r0 = r11 instanceof java.lang.Integer     // Catch:{  }
            if (r0 != 0) goto L_0x013a
            goto L_0x014d
        L_0x013a:
            r0 = r11
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{  }
            int r0 = r0.intValue()     // Catch:{  }
            if (r0 != 0) goto L_0x014d
            if (r10 != 0) goto L_0x0148
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{  }
        L_0x0148:
            r4.tracePageView(r10)     // Catch:{  }
            goto L_0x01d9
        L_0x014d:
            boolean r0 = r11 instanceof java.lang.Integer     // Catch:{  }
            if (r0 != 0) goto L_0x0152
            goto L_0x0183
        L_0x0152:
            r0 = r11
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{  }
            int r0 = r0.intValue()     // Catch:{  }
            if (r3 != r0) goto L_0x0183
            r4.tracePageSuccess(r10)     // Catch:{  }
            java.lang.String r11 = "intvl_time"
            java.lang.Object r11 = r12.get(r11)     // Catch:{  }
            if (r11 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x01d9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{  }
            r12.<init>()     // Catch:{  }
            java.lang.String r11 = r11.toString()     // Catch:{  }
            r12.append(r11)     // Catch:{  }
            r12.append(r2)     // Catch:{  }
            java.lang.String r11 = r12.toString()     // Catch:{  }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{  }
            r4.traceFirstRenderTimeWithPath(r10, r11)     // Catch:{  }
            goto L_0x01d9
        L_0x0183:
            java.lang.String r0 = "webviewReady"
            boolean r0 = r0.equals(r11)     // Catch:{  }
            if (r0 == 0) goto L_0x019d
            java.lang.Object r11 = r12.get(r1)     // Catch:{  }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{  }
            if (r11 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x01d9
            long r11 = r11.longValue()     // Catch:{  }
            r4.tracejsFirstExecTime(r10, r11)     // Catch:{  }
            goto L_0x01d9
        L_0x019d:
            java.lang.String r0 = "interactionTime"
            boolean r11 = r0.equals(r11)     // Catch:{  }
            if (r11 == 0) goto L_0x01d9
            java.lang.Object r11 = r12.get(r1)     // Catch:{  }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{  }
            if (r11 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x01d9
            long r11 = r11.longValue()     // Catch:{  }
            r4.traceInteractionTime(r10, r11)     // Catch:{  }
            goto L_0x01d9
        L_0x01b7:
            java.lang.String r10 = "tech_saga_error_bt"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x01d9
            java.lang.String r10 = "en"
            java.lang.Object r10 = r12.get(r10)     // Catch:{  }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{  }
            java.lang.String r11 = "em"
            java.lang.Object r11 = r12.get(r11)     // Catch:{  }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{  }
            if (r10 == 0) goto L_0x01d2
            goto L_0x01d3
        L_0x01d2:
            r10 = r2
        L_0x01d3:
            if (r11 == 0) goto L_0x01d6
            r2 = r11
        L_0x01d6:
            r4.traceError(r10, r2)     // Catch:{  }
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.trace.DiminaTraceService.m12975b(com.didi.dimina.container.DMMina, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.getRegionConfigService();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m12973a(java.lang.String r3, java.lang.String r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5) {
        /*
            r2 = this;
            com.didi.dimina.container.Dimina$Config r0 = com.didi.dimina.container.Dimina.getConfig()
            java.lang.String r1 = "Dimina.getConfig()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didi.dimina.container.Dimina$AdapterConfig r0 = r0.getAdapterConfig()
            if (r0 == 0) goto L_0x001a
            com.didi.dimina.container.service.RegionConfigService r0 = r0.getRegionConfigService()
            if (r0 == 0) goto L_0x001a
            java.lang.Boolean r0 = r0.isInternational()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0029
            return
        L_0x0029:
            boolean r0 = com.didi.raven.RavenSdk.isInit()
            if (r0 == 0) goto L_0x0038
            if (r3 == 0) goto L_0x0038
            com.didi.raven.RavenSdk r0 = com.didi.raven.RavenSdk.getInstance()
            r0.trackEvent(r3, r4, r5)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.trace.DiminaTraceService.m12973a(java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* renamed from: a */
    private final void m12974a(String str, Map<String, ? extends Object> map) {
        if (Intrinsics.areEqual((Object) TraceActionServiceImpl.TECH_SAGA_CORE_DOTTING, (Object) str)) {
            String str2 = (String) map.get("event");
            String str3 = (String) map.get("info");
            StringBuilder sb = new StringBuilder("| ");
            if (!TextUtil.isEmpty(Constant.CORE_DOTTING.translate(str2))) {
                sb.append(Constant.CORE_DOTTING.translate(str2));
                sb.append(" | ");
            }
            sb.append(str2);
            sb.append(" | ");
            if (!TextUtil.isEmpty(str3)) {
                sb.append(str3);
                sb.append(" | ");
            }
            sb.append("【event】");
            sb.append(m12971a());
            LogUtil.iRelease("Dimina-Core-Dotting", sb.toString());
            return;
        }
        LogUtil.iRelease(f17442f, "event: " + str + ", param: " + map + m12971a());
    }

    /* renamed from: b */
    private final void m12976b(String str, Map<String, ? extends Object> map) {
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r0.isDebug() != false) goto L_0x0015;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m12971a() {
        /*
            r6 = this;
            com.didi.dimina.container.Dimina$Config r0 = com.didi.dimina.container.Dimina.getConfig()
            if (r0 == 0) goto L_0x0015
            com.didi.dimina.container.Dimina$Config r0 = com.didi.dimina.container.Dimina.getConfig()
            java.lang.String r1 = "Dimina.getConfig()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            boolean r0 = r0.isDebug()
            if (r0 == 0) goto L_0x006f
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            r1 = 0
            java.lang.StackTraceElement r1 = (java.lang.StackTraceElement) r1
            int r2 = r0.length
            r3 = 5
        L_0x0027:
            if (r3 >= r2) goto L_0x0046
            r1 = r0[r3]
            java.lang.String r4 = "stackTraceElement"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            java.lang.String r4 = r1.getClassName()
            java.lang.Class<com.didi.dimina.container.util.TraceUtil> r5 = com.didi.dimina.container.util.TraceUtil.class
            java.lang.String r5 = r5.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0046:
            if (r1 == 0) goto L_0x006f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "("
            r0.append(r2)
            java.lang.String r2 = r1.getFileName()
            r0.append(r2)
            java.lang.String r2 = ":"
            r0.append(r2)
            int r1 = r1.getLineNumber()
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0071
        L_0x006f:
            java.lang.String r0 = ""
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.trace.DiminaTraceService.m12971a():java.lang.String");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$DMLOG_EVENT;", "", "()V", "PARAMS", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DiminaTraceService.kt */
    public static final class DMLOG_EVENT {
        public static final DMLOG_EVENT INSTANCE = new DMLOG_EVENT();

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$DMLOG_EVENT$PARAMS;", "", "()V", "ACTION", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: DiminaTraceService.kt */
        public static final class PARAMS {
            public static final String ACTION = "ac";
            public static final PARAMS INSTANCE = new PARAMS();

            private PARAMS() {
            }
        }

        private DMLOG_EVENT() {
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$MAS_MONITOR_EVENT;", "", "()V", "ERROR", "", "LAUNCH_APP", "LOAD_MAIN_PACKAGE_DOWNLOAD_TIME", "OPEN_PAGE", "KEY", "VALUE", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DiminaTraceService.kt */
    private static final class MAS_MONITOR_EVENT {
        public static final String ERROR = "tech_saga_error_bt";
        public static final MAS_MONITOR_EVENT INSTANCE = new MAS_MONITOR_EVENT();
        public static final String LAUNCH_APP = "tech_saga_launch_app";
        public static final String LOAD_MAIN_PACKAGE_DOWNLOAD_TIME = "tech_saga_pkg_xh_download_and_install";
        public static final String OPEN_PAGE = "tech_saga_open_page";

        private MAS_MONITOR_EVENT() {
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$MAS_MONITOR_EVENT$KEY;", "", "()V", "ACTION", "", "EBG", "ERROR_CODE", "ERROR_MESSAGE", "INSTALL_TYPE", "PATH", "PUB_MP_VERSION", "RESULT", "STEP", "TIME_INTERVAL", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: DiminaTraceService.kt */
        public static final class KEY {
            public static final String ACTION = "ac";
            public static final String EBG = "ebg";
            public static final String ERROR_CODE = "en";
            public static final String ERROR_MESSAGE = "em";
            public static final String INSTALL_TYPE = "instype";
            public static final KEY INSTANCE = new KEY();
            public static final String PATH = "path";
            public static final String PUB_MP_VERSION = "pub_mp_version";
            public static final String RESULT = "result";
            public static final String STEP = "step";
            public static final String TIME_INTERVAL = "tmintvl";

            private KEY() {
            }
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$MAS_MONITOR_EVENT$VALUE;", "", "()V", "ACTION_END", "", "ACTION_START", "INTERACTION_TIME", "", "IS_ENTER_BACKGROUND", "STEP_DOWNLOAD", "WEBVIEW_READY", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: DiminaTraceService.kt */
        public static final class VALUE {
            public static final int ACTION_END = 1;
            public static final int ACTION_START = 0;
            public static final VALUE INSTANCE = new VALUE();
            public static final String INTERACTION_TIME = "interactionTime";
            public static final String IS_ENTER_BACKGROUND = "ebg";
            public static final String STEP_DOWNLOAD = "dwn";
            public static final String WEBVIEW_READY = "webviewReady";

            private VALUE() {
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/DiminaTraceService$Companion;", "", "()V", "TAG", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DiminaTraceService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
