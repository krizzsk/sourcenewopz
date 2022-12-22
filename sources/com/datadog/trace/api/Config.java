package com.datadog.trace.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import java.util.regex.Pattern;

public class Config {

    /* renamed from: A */
    private static final String f4170A = null;
    public static final String AGENT_HOST = "agent.host";
    public static final String AGENT_PORT_LEGACY = "agent.port";
    public static final String AGENT_UNIX_DOMAIN_SOCKET = "trace.agent.unix.domain.socket";
    public static final String API_KEY = "api-key";
    public static final String API_KEY_FILE = "api-key-file";

    /* renamed from: B */
    private static final String f4171B = "_dd.hostname";
    public static final String CONFIGURATION_FILE = "trace.config";
    public static final String DB_CLIENT_HOST_SPLIT_BY_INSTANCE = "trace.db.client.split-by-instance";
    public static final String DD_AGENT_WRITER_TYPE = "DDAgentWriter";
    public static final String DEFAULT_AGENT_HOST = "localhost";
    public static final String DEFAULT_AGENT_UNIX_DOMAIN_SOCKET = null;
    public static final float DEFAULT_ANALYTICS_SAMPLE_RATE = 1.0f;
    public static final boolean DEFAULT_INTEGRATIONS_ENABLED = true;
    public static final int DEFAULT_JMX_FETCH_STATSD_PORT = 8125;
    public static final boolean DEFAULT_LOGS_INJECTION_ENABLED = false;
    public static final boolean DEFAULT_METRICS_ENABLED = false;
    public static final boolean DEFAULT_PROFILING_ENABLED = false;
    public static final int DEFAULT_PROFILING_EXCEPTION_HISTOGRAM_MAX_COLLECTION_SIZE = 10000;
    public static final int DEFAULT_PROFILING_EXCEPTION_HISTOGRAM_TOP_ITEMS = 50;
    public static final int DEFAULT_PROFILING_EXCEPTION_SAMPLE_LIMIT = 10000;
    public static final int DEFAULT_PROFILING_PROXY_PORT = 8080;
    public static final int DEFAULT_PROFILING_START_DELAY = 10;
    public static final boolean DEFAULT_PROFILING_START_FORCE_FIRST = false;
    public static final String DEFAULT_PROFILING_UPLOAD_COMPRESSION = "on";
    public static final int DEFAULT_PROFILING_UPLOAD_PERIOD = 60;
    public static final int DEFAULT_PROFILING_UPLOAD_TIMEOUT = 30;
    public static final String DEFAULT_SERVICE_NAME = "unnamed-java-app";
    public static final String DEFAULT_SITE = "datadoghq.com";
    public static final int DEFAULT_TRACE_AGENT_PORT = 8126;
    public static final boolean DEFAULT_TRACE_ANALYTICS_ENABLED = false;
    public static final double DEFAULT_TRACE_RATE_LIMIT = 100.0d;
    @Deprecated
    public static final String GLOBAL_TAGS = "trace.global.tags";
    public static final String HEADER_TAGS = "trace.header.tags";
    public static final String HEALTH_METRICS_ENABLED = "trace.health.metrics.enabled";
    public static final String HEALTH_METRICS_STATSD_HOST = "trace.health.metrics.statsd.host";
    public static final String HEALTH_METRICS_STATSD_PORT = "trace.health.metrics.statsd.port";
    public static final String HOST_TAG = "host";
    public static final String HTTP_CLIENT_ERROR_STATUSES = "http.client.error.statuses";
    public static final String HTTP_CLIENT_HOST_SPLIT_BY_DOMAIN = "trace.http.client.split-by-domain";
    public static final String HTTP_CLIENT_TAG_QUERY_STRING = "http.client.tag.query-string";
    public static final String HTTP_SERVER_ERROR_STATUSES = "http.server.error.statuses";
    public static final String HTTP_SERVER_TAG_QUERY_STRING = "http.server.tag.query-string";
    public static final String INTEGRATIONS_ENABLED = "integrations.enabled";
    public static final String JMX_FETCH_CHECK_PERIOD = "jmxfetch.check-period";
    public static final String JMX_FETCH_CONFIG = "jmxfetch.config";
    public static final String JMX_FETCH_CONFIG_DIR = "jmxfetch.config.dir";
    public static final String JMX_FETCH_ENABLED = "jmxfetch.enabled";
    @Deprecated
    public static final String JMX_FETCH_METRICS_CONFIGS = "jmxfetch.metrics-configs";
    public static final String JMX_FETCH_REFRESH_BEANS_PERIOD = "jmxfetch.refresh-beans-period";
    public static final String JMX_FETCH_STATSD_HOST = "jmxfetch.statsd.host";
    public static final String JMX_FETCH_STATSD_PORT = "jmxfetch.statsd.port";
    public static final String JMX_TAGS = "trace.jmx.tags";
    public static final String LANGUAGE_TAG_KEY = "language";
    public static final String LANGUAGE_TAG_VALUE = "jvm";
    public static final String LOGGING_WRITER_TYPE = "LoggingWriter";
    public static final String LOGS_INJECTION_ENABLED = "logs.injection";
    public static final String PARTIAL_FLUSH_MIN_SPANS = "trace.partial.flush.min.spans";
    public static final String PRIORITY_SAMPLING = "priority.sampling";
    @Deprecated
    public static final String PROFILING_API_KEY_FILE_OLD = "profiling.api-key-file";
    @Deprecated
    public static final String PROFILING_API_KEY_FILE_VERY_OLD = "profiling.apikey.file";
    @Deprecated
    public static final String PROFILING_API_KEY_OLD = "profiling.api-key";
    @Deprecated
    public static final String PROFILING_API_KEY_VERY_OLD = "profiling.apikey";
    public static final String PROFILING_ENABLED = "profiling.enabled";
    public static final String PROFILING_EXCEPTION_HISTOGRAM_MAX_COLLECTION_SIZE = "profiling.exception.histogram.max-collection-size";
    public static final String PROFILING_EXCEPTION_HISTOGRAM_TOP_ITEMS = "profiling.exception.histogram.top-items";
    public static final String PROFILING_EXCEPTION_SAMPLE_LIMIT = "profiling.exception.sample.limit";
    public static final String PROFILING_PROXY_HOST = "profiling.proxy.host";
    public static final String PROFILING_PROXY_PASSWORD = "profiling.proxy.password";
    public static final String PROFILING_PROXY_PORT = "profiling.proxy.port";
    public static final String PROFILING_PROXY_USERNAME = "profiling.proxy.username";
    public static final String PROFILING_START_DELAY = "profiling.start-delay";
    public static final String PROFILING_START_FORCE_FIRST = "profiling.experimental.start-force-first";
    public static final String PROFILING_TAGS = "profiling.tags";
    public static final String PROFILING_TEMPLATE_OVERRIDE_FILE = "profiling.jfr-template-override-file";
    public static final String PROFILING_UPLOAD_COMPRESSION = "profiling.upload.compression";
    public static final String PROFILING_UPLOAD_PERIOD = "profiling.upload.period";
    public static final String PROFILING_UPLOAD_TIMEOUT = "profiling.upload.timeout";
    @Deprecated
    public static final String PROFILING_URL = "profiling.url";
    public static final String PROFILING_URL_TEMPLATE = "https://intake.profile.%s/v1/input";
    public static final String PROPAGATION_STYLE_EXTRACT = "propagation.style.extract";
    public static final String PROPAGATION_STYLE_INJECT = "propagation.style.inject";
    public static final String RUNTIME_CONTEXT_FIELD_INJECTION = "trace.runtime.context.field.injection";
    public static final String RUNTIME_ID_TAG = "runtime-id";
    public static final String SCOPE_DEPTH_LIMIT = "trace.scope.depth.limit";
    public static final String SERVICE = "service";
    public static final String SERVICE_MAPPING = "service.mapping";
    public static final String SERVICE_NAME = "service.name";
    public static final String SERVICE_TAG = "service";
    public static final String SITE = "site";
    public static final String SPAN_TAGS = "trace.span.tags";
    public static final String SPLIT_BY_TAGS = "trace.split-by-tags";
    public static final String TAGS = "tags";
    public static final String TRACE_AGENT_PORT = "trace.agent.port";
    public static final String TRACE_ANALYTICS_ENABLED = "trace.analytics.enabled";
    public static final String TRACE_ANNOTATIONS = "trace.annotations";
    public static final String TRACE_CLASSES_EXCLUDE = "trace.classes.exclude";
    public static final String TRACE_ENABLED = "trace.enabled";
    public static final String TRACE_EXECUTORS = "trace.executors";
    public static final String TRACE_EXECUTORS_ALL = "trace.executors.all";
    public static final String TRACE_METHODS = "trace.methods";
    public static final String TRACE_RATE_LIMIT = "trace.rate.limit";
    public static final String TRACE_REPORT_HOSTNAME = "trace.report-hostname";
    public static final String TRACE_RESOLVER_ENABLED = "trace.resolver.enabled";
    public static final String TRACE_SAMPLE_RATE = "trace.sample.rate";
    public static final String TRACE_SAMPLING_OPERATION_RULES = "trace.sampling.operation.rules";
    public static final String TRACE_SAMPLING_SERVICE_RULES = "trace.sampling.service.rules";
    public static final String WRITER_TYPE = "writer.type";

    /* renamed from: a */
    private static final String f4172a = "dd.";

    /* renamed from: aR */
    private static Properties f4173aR = null;

    /* renamed from: aS */
    private static final Config f4174aS = new Config();

    /* renamed from: b */
    private static final Pattern f4175b = Pattern.compile("[^a-zA-Z0-9_]");

    /* renamed from: c */
    private static final String f4176c = "env";

    /* renamed from: d */
    private static final String f4177d = "version";

    /* renamed from: e */
    private static final boolean f4178e = true;

    /* renamed from: f */
    private static final String f4179f = "DDAgentWriter";

    /* renamed from: g */
    private static final boolean f4180g = true;

    /* renamed from: h */
    private static final boolean f4181h = true;

    /* renamed from: i */
    private static final boolean f4182i = true;

    /* renamed from: j */
    private static final Set<Integer> f4183j = m2602e("500-599", "default");

    /* renamed from: k */
    private static final Set<Integer> f4184k = m2602e("400-499", "default");

    /* renamed from: l */
    private static final boolean f4185l = false;

    /* renamed from: m */
    private static final boolean f4186m = false;

    /* renamed from: n */
    private static final boolean f4187n = false;

    /* renamed from: o */
    private static final boolean f4188o = false;

    /* renamed from: p */
    private static final String f4189p = "";

    /* renamed from: q */
    private static final int f4190q = 100;

    /* renamed from: r */
    private static final int f4191r = 1000;

    /* renamed from: s */
    private static final String f4192s = PropagationStyle.DATADOG.name();

    /* renamed from: t */
    private static final String f4193t = PropagationStyle.DATADOG.name();

    /* renamed from: u */
    private static final boolean f4194u = true;

    /* renamed from: v */
    private static final String f4195v = "[,\\s]+";

    /* renamed from: w */
    private static final boolean f4196w = false;

    /* renamed from: x */
    private static final String f4197x = null;

    /* renamed from: y */
    private static final boolean f4198y = false;

    /* renamed from: z */
    private static final String f4199z = "";

    /* renamed from: C */
    private final String f4200C;

    /* renamed from: D */
    private final String f4201D;

    /* renamed from: E */
    private final String f4202E;

    /* renamed from: F */
    private final boolean f4203F;

    /* renamed from: G */
    private final boolean f4204G;

    /* renamed from: H */
    private final String f4205H;

    /* renamed from: I */
    private final String f4206I;

    /* renamed from: J */
    private final int f4207J;

    /* renamed from: K */
    private final String f4208K;

    /* renamed from: L */
    private final boolean f4209L;

    /* renamed from: M */
    private final boolean f4210M;

    /* renamed from: N */
    private final Map<String, String> f4211N;

    /* renamed from: O */
    private final Map<String, String> f4212O;

    /* renamed from: P */
    private final Map<String, String> f4213P;

    /* renamed from: Q */
    private final Map<String, String> f4214Q;

    /* renamed from: R */
    private final List<String> f4215R;

    /* renamed from: S */
    private final Map<String, String> f4216S;

    /* renamed from: T */
    private final Set<Integer> f4217T;

    /* renamed from: U */
    private final Set<Integer> f4218U;

    /* renamed from: V */
    private final boolean f4219V;

    /* renamed from: W */
    private final boolean f4220W;

    /* renamed from: X */
    private final boolean f4221X;

    /* renamed from: Y */
    private final boolean f4222Y;

    /* renamed from: Z */
    private final Set<String> f4223Z;

    /* renamed from: aA */
    private final Double f4224aA;

    /* renamed from: aB */
    private final boolean f4225aB;
    @Deprecated

    /* renamed from: aC */
    private final String f4226aC;

    /* renamed from: aD */
    private final Map<String, String> f4227aD;

    /* renamed from: aE */
    private final int f4228aE;

    /* renamed from: aF */
    private final boolean f4229aF;

    /* renamed from: aG */
    private final int f4230aG;

    /* renamed from: aH */
    private final String f4231aH;

    /* renamed from: aI */
    private final int f4232aI;

    /* renamed from: aJ */
    private final String f4233aJ;

    /* renamed from: aK */
    private final String f4234aK;

    /* renamed from: aL */
    private final int f4235aL;

    /* renamed from: aM */
    private final String f4236aM;

    /* renamed from: aN */
    private final String f4237aN;

    /* renamed from: aO */
    private final int f4238aO;

    /* renamed from: aP */
    private final int f4239aP;

    /* renamed from: aQ */
    private final int f4240aQ;

    /* renamed from: aa */
    private final Integer f4241aa;

    /* renamed from: ab */
    private final Integer f4242ab;

    /* renamed from: ac */
    private final boolean f4243ac;

    /* renamed from: ad */
    private final Set<PropagationStyle> f4244ad;

    /* renamed from: ae */
    private final Set<PropagationStyle> f4245ae;

    /* renamed from: af */
    private final boolean f4246af;

    /* renamed from: ag */
    private final String f4247ag;

    /* renamed from: ah */
    private final List<String> f4248ah;
    @Deprecated

    /* renamed from: ai */
    private final List<String> f4249ai;

    /* renamed from: aj */
    private final Integer f4250aj;

    /* renamed from: ak */
    private final Integer f4251ak;

    /* renamed from: al */
    private final String f4252al;

    /* renamed from: am */
    private final Integer f4253am;

    /* renamed from: an */
    private final boolean f4254an;

    /* renamed from: ao */
    private final String f4255ao;

    /* renamed from: ap */
    private final Integer f4256ap;

    /* renamed from: aq */
    private final boolean f4257aq;

    /* renamed from: ar */
    private final boolean f4258ar;

    /* renamed from: as */
    private final String f4259as;

    /* renamed from: at */
    private final String f4260at;

    /* renamed from: au */
    private final boolean f4261au;

    /* renamed from: av */
    private final List<String> f4262av;

    /* renamed from: aw */
    private final boolean f4263aw;

    /* renamed from: ax */
    private final Map<String, String> f4264ax;

    /* renamed from: ay */
    private final Map<String, String> f4265ay;

    /* renamed from: az */
    private final Double f4266az;

    public enum PropagationStyle {
        DATADOG,
        B3,
        HAYSTACK
    }

    Config() {
        f4173aR = m2597c();
        this.f4200C = UUID.randomUUID().toString();
        this.f4201D = getSettingFromEnvironment(SITE, DEFAULT_SITE);
        this.f4202E = getSettingFromEnvironment("service", getSettingFromEnvironment("service.name", DEFAULT_SERVICE_NAME));
        this.f4203F = getBooleanSettingFromEnvironment(TRACE_ENABLED, true).booleanValue();
        this.f4204G = getBooleanSettingFromEnvironment(INTEGRATIONS_ENABLED, true).booleanValue();
        this.f4205H = getSettingFromEnvironment(WRITER_TYPE, "DDAgentWriter");
        this.f4206I = getSettingFromEnvironment(AGENT_HOST, DEFAULT_AGENT_HOST);
        this.f4207J = m2576a(TRACE_AGENT_PORT, m2576a(AGENT_PORT_LEGACY, (Integer) 8126)).intValue();
        this.f4208K = getSettingFromEnvironment(AGENT_UNIX_DOMAIN_SOCKET, DEFAULT_AGENT_UNIX_DOMAIN_SOCKET);
        this.f4209L = getBooleanSettingFromEnvironment(PRIORITY_SAMPLING, true).booleanValue();
        this.f4210M = getBooleanSettingFromEnvironment(TRACE_RESOLVER_ENABLED, true).booleanValue();
        this.f4211N = m2583a(SERVICE_MAPPING, (String) null);
        HashMap hashMap = new HashMap(m2583a(GLOBAL_TAGS, (String) null));
        hashMap.putAll(m2583a("tags", (String) null));
        this.f4212O = m2585a((Map<String, String>) hashMap, "env", "version");
        this.f4213P = m2583a(SPAN_TAGS, (String) null);
        this.f4214Q = m2583a(JMX_TAGS, (String) null);
        this.f4215R = m2594b(TRACE_CLASSES_EXCLUDE, (String) null);
        this.f4216S = m2583a(HEADER_TAGS, (String) null);
        this.f4217T = m2587a(HTTP_SERVER_ERROR_STATUSES, f4183j);
        this.f4218U = m2587a(HTTP_CLIENT_ERROR_STATUSES, f4184k);
        this.f4219V = getBooleanSettingFromEnvironment(HTTP_SERVER_TAG_QUERY_STRING, false).booleanValue();
        this.f4220W = getBooleanSettingFromEnvironment(HTTP_CLIENT_TAG_QUERY_STRING, false).booleanValue();
        this.f4221X = getBooleanSettingFromEnvironment(HTTP_CLIENT_HOST_SPLIT_BY_DOMAIN, false).booleanValue();
        this.f4222Y = getBooleanSettingFromEnvironment(DB_CLIENT_HOST_SPLIT_BY_INSTANCE, false).booleanValue();
        this.f4223Z = Collections.unmodifiableSet(new LinkedHashSet(m2594b(SPLIT_BY_TAGS, "")));
        this.f4241aa = m2576a(SCOPE_DEPTH_LIMIT, (Integer) 100);
        this.f4242ab = m2576a(PARTIAL_FLUSH_MIN_SPANS, (Integer) 1000);
        this.f4243ac = getBooleanSettingFromEnvironment(RUNTIME_CONTEXT_FIELD_INJECTION, true).booleanValue();
        this.f4244ad = m2598c(PROPAGATION_STYLE_EXTRACT, f4192s);
        this.f4245ae = m2598c(PROPAGATION_STYLE_INJECT, f4193t);
        this.f4246af = getBooleanSettingFromEnvironment(JMX_FETCH_ENABLED, true).booleanValue();
        this.f4247ag = getSettingFromEnvironment(JMX_FETCH_CONFIG_DIR, (String) null);
        this.f4248ah = m2594b(JMX_FETCH_CONFIG, (String) null);
        this.f4249ai = m2594b(JMX_FETCH_METRICS_CONFIGS, (String) null);
        this.f4250aj = m2576a(JMX_FETCH_CHECK_PERIOD, (Integer) null);
        this.f4251ak = m2576a(JMX_FETCH_REFRESH_BEANS_PERIOD, (Integer) null);
        this.f4252al = getSettingFromEnvironment(JMX_FETCH_STATSD_HOST, (String) null);
        this.f4253am = m2576a(JMX_FETCH_STATSD_PORT, (Integer) 8125);
        this.f4254an = getBooleanSettingFromEnvironment(HEALTH_METRICS_ENABLED, false).booleanValue();
        this.f4255ao = getSettingFromEnvironment(HEALTH_METRICS_STATSD_HOST, (String) null);
        this.f4256ap = m2576a(HEALTH_METRICS_STATSD_PORT, (Integer) null);
        this.f4257aq = getBooleanSettingFromEnvironment(LOGS_INJECTION_ENABLED, false).booleanValue();
        this.f4258ar = getBooleanSettingFromEnvironment(TRACE_REPORT_HOSTNAME, false).booleanValue();
        this.f4259as = getSettingFromEnvironment(TRACE_ANNOTATIONS, f4197x);
        this.f4260at = getSettingFromEnvironment(TRACE_METHODS, f4170A);
        this.f4261au = getBooleanSettingFromEnvironment(TRACE_EXECUTORS_ALL, false).booleanValue();
        this.f4262av = m2594b(TRACE_EXECUTORS, "");
        this.f4263aw = getBooleanSettingFromEnvironment(TRACE_ANALYTICS_ENABLED, false).booleanValue();
        this.f4264ax = m2583a(TRACE_SAMPLING_SERVICE_RULES, (String) null);
        this.f4265ay = m2583a(TRACE_SAMPLING_OPERATION_RULES, (String) null);
        this.f4266az = m2574a(TRACE_SAMPLE_RATE, (Double) null);
        this.f4224aA = m2574a(TRACE_RATE_LIMIT, Double.valueOf(100.0d));
        this.f4225aB = getBooleanSettingFromEnvironment(PROFILING_ENABLED, false).booleanValue();
        this.f4226aC = getSettingFromEnvironment(PROFILING_URL, (String) null);
        this.f4227aD = m2583a(PROFILING_TAGS, (String) null);
        this.f4228aE = m2576a(PROFILING_START_DELAY, (Integer) 10).intValue();
        this.f4229aF = getBooleanSettingFromEnvironment(PROFILING_START_FORCE_FIRST, false).booleanValue();
        this.f4230aG = m2576a(PROFILING_UPLOAD_PERIOD, (Integer) 60).intValue();
        this.f4231aH = getSettingFromEnvironment(PROFILING_TEMPLATE_OVERRIDE_FILE, (String) null);
        this.f4232aI = m2576a(PROFILING_UPLOAD_TIMEOUT, (Integer) 30).intValue();
        this.f4233aJ = getSettingFromEnvironment(PROFILING_UPLOAD_COMPRESSION, "on");
        this.f4234aK = getSettingFromEnvironment(PROFILING_PROXY_HOST, (String) null);
        this.f4235aL = m2576a(PROFILING_PROXY_PORT, (Integer) 8080).intValue();
        this.f4236aM = getSettingFromEnvironment(PROFILING_PROXY_USERNAME, (String) null);
        this.f4237aN = getSettingFromEnvironment(PROFILING_PROXY_PASSWORD, (String) null);
        this.f4238aO = m2576a(PROFILING_EXCEPTION_SAMPLE_LIMIT, (Integer) 10000).intValue();
        this.f4239aP = m2576a(PROFILING_EXCEPTION_HISTOGRAM_TOP_ITEMS, (Integer) 50).intValue();
        this.f4240aQ = m2576a(PROFILING_EXCEPTION_HISTOGRAM_MAX_COLLECTION_SIZE, (Integer) 10000).intValue();
    }

    private Config(Properties properties, Config config) {
        this.f4200C = config.f4200C;
        this.f4201D = properties.getProperty(SITE, config.f4201D);
        this.f4202E = properties.getProperty("service", properties.getProperty("service.name", config.f4202E));
        this.f4203F = m2573a(properties, TRACE_ENABLED, Boolean.valueOf(config.f4203F)).booleanValue();
        this.f4204G = m2573a(properties, INTEGRATIONS_ENABLED, Boolean.valueOf(config.f4204G)).booleanValue();
        this.f4205H = properties.getProperty(WRITER_TYPE, config.f4205H);
        this.f4206I = properties.getProperty(AGENT_HOST, config.f4206I);
        this.f4207J = m2577a(properties, TRACE_AGENT_PORT, m2577a(properties, AGENT_PORT_LEGACY, Integer.valueOf(config.f4207J))).intValue();
        this.f4208K = properties.getProperty(AGENT_UNIX_DOMAIN_SOCKET, config.f4208K);
        this.f4209L = m2573a(properties, PRIORITY_SAMPLING, Boolean.valueOf(config.f4209L)).booleanValue();
        this.f4210M = m2573a(properties, TRACE_RESOLVER_ENABLED, Boolean.valueOf(config.f4210M)).booleanValue();
        this.f4211N = m2586a(properties, SERVICE_MAPPING, config.f4211N);
        HashMap hashMap = new HashMap(m2586a(properties, GLOBAL_TAGS, (Map<String, String>) Collections.emptyMap()));
        hashMap.putAll(m2586a(properties, "tags", config.f4212O));
        this.f4212O = m2584a((Map<String, String>) hashMap, properties, "env", "version");
        this.f4213P = m2586a(properties, SPAN_TAGS, config.f4213P);
        this.f4214Q = m2586a(properties, JMX_TAGS, config.f4214Q);
        this.f4215R = m2580a(properties, TRACE_CLASSES_EXCLUDE, config.f4215R);
        this.f4216S = m2586a(properties, HEADER_TAGS, config.f4216S);
        this.f4217T = m2589a(properties, HTTP_SERVER_ERROR_STATUSES, config.f4217T);
        this.f4218U = m2589a(properties, HTTP_CLIENT_ERROR_STATUSES, config.f4218U);
        this.f4219V = m2573a(properties, HTTP_SERVER_TAG_QUERY_STRING, Boolean.valueOf(config.f4219V)).booleanValue();
        this.f4220W = m2573a(properties, HTTP_CLIENT_TAG_QUERY_STRING, Boolean.valueOf(config.f4220W)).booleanValue();
        this.f4221X = m2573a(properties, HTTP_CLIENT_HOST_SPLIT_BY_DOMAIN, Boolean.valueOf(config.f4221X)).booleanValue();
        this.f4222Y = m2573a(properties, DB_CLIENT_HOST_SPLIT_BY_INSTANCE, Boolean.valueOf(config.f4222Y)).booleanValue();
        this.f4223Z = Collections.unmodifiableSet(new LinkedHashSet(m2580a(properties, SPLIT_BY_TAGS, (List<String>) new ArrayList(config.f4223Z))));
        this.f4241aa = m2577a(properties, SCOPE_DEPTH_LIMIT, config.f4241aa);
        this.f4242ab = m2577a(properties, PARTIAL_FLUSH_MIN_SPANS, config.f4242ab);
        this.f4243ac = m2573a(properties, RUNTIME_CONTEXT_FIELD_INJECTION, Boolean.valueOf(config.f4243ac)).booleanValue();
        Set<PropagationStyle> a = m2588a(properties, PROPAGATION_STYLE_EXTRACT);
        this.f4244ad = a == null ? config.f4244ad : a;
        Set<PropagationStyle> a2 = m2588a(properties, PROPAGATION_STYLE_INJECT);
        this.f4245ae = a2 == null ? config.f4245ae : a2;
        this.f4246af = m2573a(properties, JMX_FETCH_ENABLED, Boolean.valueOf(config.f4246af)).booleanValue();
        this.f4247ag = properties.getProperty(JMX_FETCH_CONFIG_DIR, config.f4247ag);
        this.f4248ah = m2580a(properties, JMX_FETCH_CONFIG, config.f4248ah);
        this.f4249ai = m2580a(properties, JMX_FETCH_METRICS_CONFIGS, config.f4249ai);
        this.f4250aj = m2577a(properties, JMX_FETCH_CHECK_PERIOD, config.f4250aj);
        this.f4251ak = m2577a(properties, JMX_FETCH_REFRESH_BEANS_PERIOD, config.f4251ak);
        this.f4252al = properties.getProperty(JMX_FETCH_STATSD_HOST, config.f4252al);
        this.f4253am = m2577a(properties, JMX_FETCH_STATSD_PORT, config.f4253am);
        this.f4254an = m2573a(properties, HEALTH_METRICS_ENABLED, (Boolean) false).booleanValue();
        this.f4255ao = properties.getProperty(HEALTH_METRICS_STATSD_HOST, config.f4255ao);
        this.f4256ap = m2577a(properties, HEALTH_METRICS_STATSD_PORT, config.f4256ap);
        this.f4257aq = getBooleanSettingFromEnvironment(LOGS_INJECTION_ENABLED, false).booleanValue();
        this.f4258ar = m2573a(properties, TRACE_REPORT_HOSTNAME, Boolean.valueOf(config.f4258ar)).booleanValue();
        this.f4259as = properties.getProperty(TRACE_ANNOTATIONS, config.f4259as);
        this.f4260at = properties.getProperty(TRACE_METHODS, config.f4260at);
        this.f4261au = m2573a(properties, TRACE_EXECUTORS_ALL, Boolean.valueOf(config.f4261au)).booleanValue();
        this.f4262av = m2580a(properties, TRACE_EXECUTORS, config.f4262av);
        this.f4263aw = m2573a(properties, TRACE_ANALYTICS_ENABLED, Boolean.valueOf(config.f4263aw)).booleanValue();
        this.f4264ax = m2586a(properties, TRACE_SAMPLING_SERVICE_RULES, config.f4264ax);
        this.f4265ay = m2586a(properties, TRACE_SAMPLING_OPERATION_RULES, config.f4265ay);
        this.f4266az = m2575a(properties, TRACE_SAMPLE_RATE, config.f4266az);
        this.f4224aA = m2575a(properties, TRACE_RATE_LIMIT, config.f4224aA);
        this.f4225aB = m2573a(properties, PROFILING_ENABLED, Boolean.valueOf(config.f4225aB)).booleanValue();
        this.f4226aC = properties.getProperty(PROFILING_URL, config.f4226aC);
        this.f4227aD = m2586a(properties, PROFILING_TAGS, config.f4227aD);
        this.f4228aE = m2577a(properties, PROFILING_START_DELAY, Integer.valueOf(config.f4228aE)).intValue();
        this.f4229aF = m2573a(properties, PROFILING_START_FORCE_FIRST, Boolean.valueOf(config.f4229aF)).booleanValue();
        this.f4230aG = m2577a(properties, PROFILING_UPLOAD_PERIOD, Integer.valueOf(config.f4230aG)).intValue();
        this.f4231aH = properties.getProperty(PROFILING_TEMPLATE_OVERRIDE_FILE, config.f4231aH);
        this.f4232aI = m2577a(properties, PROFILING_UPLOAD_TIMEOUT, Integer.valueOf(config.f4232aI)).intValue();
        this.f4233aJ = properties.getProperty(PROFILING_UPLOAD_COMPRESSION, config.f4233aJ);
        this.f4234aK = properties.getProperty(PROFILING_PROXY_HOST, config.f4234aK);
        this.f4235aL = m2577a(properties, PROFILING_PROXY_PORT, Integer.valueOf(config.f4235aL)).intValue();
        this.f4236aM = properties.getProperty(PROFILING_PROXY_USERNAME, config.f4236aM);
        this.f4237aN = properties.getProperty(PROFILING_PROXY_PASSWORD, config.f4237aN);
        this.f4238aO = m2577a(properties, PROFILING_EXCEPTION_SAMPLE_LIMIT, Integer.valueOf(config.f4238aO)).intValue();
        this.f4239aP = m2577a(properties, PROFILING_EXCEPTION_HISTOGRAM_TOP_ITEMS, Integer.valueOf(config.f4239aP)).intValue();
        this.f4240aQ = m2577a(properties, PROFILING_EXCEPTION_HISTOGRAM_MAX_COLLECTION_SIZE, Integer.valueOf(config.f4240aQ)).intValue();
    }

    public Map<String, String> getLocalRootSpanTags() {
        String d;
        HashMap hashMap = new HashMap(m2595b());
        hashMap.put("language", LANGUAGE_TAG_VALUE);
        if (this.f4258ar && (d = m2599d()) != null && !d.isEmpty()) {
            hashMap.put(f4171B, d);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public Map<String, String> getMergedSpanTags() {
        Map<String, String> a = m2582a(m2581a().size() + this.f4213P.size());
        a.putAll(m2581a());
        a.putAll(this.f4213P);
        return Collections.unmodifiableMap(a);
    }

    public Map<String, String> getMergedJmxTags() {
        Map<String, String> b = m2595b();
        Map<String, String> a = m2582a(m2581a().size() + this.f4214Q.size() + b.size() + 1);
        a.putAll(m2581a());
        a.putAll(this.f4214Q);
        a.putAll(b);
        a.put("service", this.f4202E);
        return Collections.unmodifiableMap(a);
    }

    public Map<String, String> getMergedProfilingTags() {
        Map<String, String> b = m2595b();
        String d = m2599d();
        Map<String, String> a = m2582a(m2581a().size() + this.f4227aD.size() + b.size() + 3);
        a.put("host", d);
        a.putAll(m2581a());
        a.putAll(this.f4227aD);
        a.putAll(b);
        a.put("service", this.f4202E);
        a.put("language", LANGUAGE_TAG_VALUE);
        return Collections.unmodifiableMap(a);
    }

    public float getInstrumentationAnalyticsSampleRate(String... strArr) {
        for (String str : strArr) {
            Float floatSettingFromEnvironment = getFloatSettingFromEnvironment(str + ".analytics.sample-rate", (Float) null);
            if (floatSettingFromEnvironment != null) {
                return floatSettingFromEnvironment.floatValue();
            }
        }
        return 1.0f;
    }

    /* renamed from: a */
    private Map<String, String> m2581a() {
        return this.f4212O;
    }

    /* renamed from: b */
    private Map<String, String> m2595b() {
        Map<String, String> a = m2582a(2);
        a.put(RUNTIME_ID_TAG, this.f4200C);
        return Collections.unmodifiableMap(a);
    }

    public String getFinalProfilingUrl() {
        String str = this.f4226aC;
        if (str != null) {
            return str;
        }
        return String.format(Locale.US, PROFILING_URL_TEMPLATE, new Object[]{this.f4201D});
    }

    public boolean isIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return m2591a(sortedSet, z);
    }

    @Deprecated
    /* renamed from: a */
    private static boolean m2591a(SortedSet<String> sortedSet, boolean z) {
        boolean z2 = z;
        for (String str : sortedSet) {
            boolean booleanValue = getBooleanSettingFromEnvironment("integration." + str + ".enabled", Boolean.valueOf(z)).booleanValue();
            z2 = z ? z2 & booleanValue : z2 | booleanValue;
        }
        return z2;
    }

    public boolean isJmxFetchIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return jmxFetchIntegrationEnabled(sortedSet, z);
    }

    public boolean isRuleEnabled(String str) {
        if (getBooleanSettingFromEnvironment("trace." + str + ".enabled", true).booleanValue()) {
            if (getBooleanSettingFromEnvironment("trace." + str.toLowerCase(Locale.US) + ".enabled", true).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean jmxFetchIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        boolean z2 = z;
        for (String str : sortedSet) {
            boolean booleanValue = getBooleanSettingFromEnvironment("jmxfetch." + str + ".enabled", Boolean.valueOf(z)).booleanValue();
            z2 = z ? z2 & booleanValue : z2 | booleanValue;
        }
        return z2;
    }

    public boolean isTraceAnalyticsIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        return traceAnalyticsIntegrationEnabled(sortedSet, z);
    }

    public static boolean traceAnalyticsIntegrationEnabled(SortedSet<String> sortedSet, boolean z) {
        boolean z2 = z;
        for (String str : sortedSet) {
            boolean booleanValue = getBooleanSettingFromEnvironment(str + ".analytics.enabled", Boolean.valueOf(z)).booleanValue();
            z2 = z ? z2 & booleanValue : z2 | booleanValue;
        }
        return z2;
    }

    public static String getSettingFromEnvironment(String str, String str2) {
        String b = m2593b(str);
        String property = System.getProperties().getProperty(b);
        if (property != null) {
            return property;
        }
        String str3 = System.getenv(m2579a(str));
        if (str3 != null) {
            return str3;
        }
        String property2 = f4173aR.getProperty(b);
        return property2 != null ? property2 : str2;
    }

    /* renamed from: a */
    private static Map<String, String> m2583a(String str, String str2) {
        return m2600d(getSettingFromEnvironment(str, str2), m2593b(str));
    }

    /* renamed from: b */
    private static List<String> m2594b(String str, String str2) {
        return m2596c(getSettingFromEnvironment(str, str2));
    }

    public static Boolean getBooleanSettingFromEnvironment(String str, Boolean bool) {
        return (Boolean) m2578a(str, Boolean.class, bool);
    }

    public static Float getFloatSettingFromEnvironment(String str, Float f) {
        return (Float) m2578a(str, Float.class, f);
    }

    @Deprecated
    /* renamed from: a */
    private static Double m2574a(String str, Double d) {
        return (Double) m2578a(str, Double.class, d);
    }

    /* renamed from: a */
    private static Integer m2576a(String str, Integer num) {
        return (Integer) m2578a(str, Integer.class, num);
    }

    /* renamed from: a */
    private static <T> T m2578a(String str, Class<T> cls, T t) {
        try {
            return m2592b(getSettingFromEnvironment(str, (String) null), cls, t);
        } catch (NumberFormatException unused) {
            return t;
        }
    }

    /* renamed from: c */
    private static Set<PropagationStyle> m2598c(String str, String str2) {
        Set<PropagationStyle> a = m2590a(m2601d(getSettingFromEnvironment(str, str2)));
        return a.isEmpty() ? m2590a(m2601d(str2)) : a;
    }

    /* renamed from: a */
    private static Set<Integer> m2587a(String str, Set<Integer> set) {
        String settingFromEnvironment = getSettingFromEnvironment(str, (String) null);
        if (settingFromEnvironment == null) {
            return set;
        }
        try {
            return m2602e(settingFromEnvironment, str);
        } catch (NumberFormatException unused) {
            return set;
        }
    }

    /* renamed from: a */
    private static String m2579a(String str) {
        return f4175b.matcher(m2593b(str).toUpperCase(Locale.US)).replaceAll("_");
    }

    /* renamed from: b */
    private static String m2593b(String str) {
        return f4172a + str;
    }

    /* renamed from: b */
    private static <T> T m2592b(String str, Class<T> cls, T t) {
        if (str == null || str.trim().isEmpty()) {
            return t;
        }
        try {
            return cls.getMethod("valueOf", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (NumberFormatException e) {
            throw e;
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            throw new NumberFormatException(e2.toString());
        } catch (Throwable th) {
            throw new NumberFormatException(th.toString());
        }
    }

    /* renamed from: a */
    private static Map<String, String> m2586a(Properties properties, String str, Map<String, String> map) {
        String property = properties.getProperty(str);
        return (property == null || property.trim().isEmpty()) ? map : m2600d(property, str);
    }

    /* renamed from: a */
    private static List<String> m2580a(Properties properties, String str, List<String> list) {
        String property = properties.getProperty(str);
        return (property == null || property.trim().isEmpty()) ? list : m2596c(property);
    }

    /* renamed from: a */
    private static Boolean m2573a(Properties properties, String str, Boolean bool) {
        return (Boolean) m2592b(properties.getProperty(str), Boolean.class, bool);
    }

    /* renamed from: a */
    private static Integer m2577a(Properties properties, String str, Integer num) {
        return (Integer) m2592b(properties.getProperty(str), Integer.class, num);
    }

    /* renamed from: a */
    private static Double m2575a(Properties properties, String str, Double d) {
        return (Double) m2592b(properties.getProperty(str), Double.class, d);
    }

    /* renamed from: a */
    private static Set<PropagationStyle> m2588a(Properties properties, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        Set<PropagationStyle> a = m2590a(m2601d(property));
        if (!a.isEmpty()) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Set<Integer> m2589a(Properties properties, String str, Set<Integer> set) {
        String property = properties.getProperty(str);
        if (property == null) {
            return set;
        }
        try {
            return m2602e(property, str);
        } catch (NumberFormatException unused) {
            return set;
        }
    }

    /* renamed from: d */
    private static Map<String, String> m2600d(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.emptyMap();
        }
        if (!str.matches("(([^,:]+:[^,:]*,)*([^,:]+:[^,:]*),?)?")) {
            return Collections.emptyMap();
        }
        String[] split = str.split(",", -1);
        Map<String, String> a = m2582a(split.length);
        for (String split2 : split) {
            String[] split3 = split2.split(":", -1);
            if (split3.length == 2) {
                String trim = split3[0].trim();
                String trim2 = split3[1].trim();
                if (trim2.length() > 0) {
                    a.put(trim, trim2);
                }
            }
        }
        return Collections.unmodifiableMap(a);
    }

    /* renamed from: e */
    private static Set<Integer> m2602e(String str, String str2) throws NumberFormatException {
        String replaceAll = str.replaceAll("\\s", "");
        if (replaceAll.matches("\\d{3}(?:-\\d{3})?(?:,\\d{3}(?:-\\d{3})?)*")) {
            String[] split = replaceAll.split(",", -1);
            HashSet hashSet = new HashSet();
            for (String split2 : split) {
                String[] split3 = split2.split("-", -1);
                if (split3.length == 1) {
                    hashSet.add(Integer.valueOf(Integer.parseInt(split3[0])));
                } else if (split3.length == 2) {
                    int parseInt = Integer.parseInt(split3[0]);
                    int parseInt2 = Integer.parseInt(split3[1]);
                    int max = Math.max(parseInt, parseInt2);
                    for (int min = Math.min(parseInt, parseInt2); min <= max; min++) {
                        hashSet.add(Integer.valueOf(min));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        throw new NumberFormatException();
    }

    /* renamed from: a */
    private static Map<String, String> m2582a(int i) {
        return new HashMap(i + 1, 1.0f);
    }

    /* renamed from: a */
    private static Map<String, String> m2585a(Map<String, String> map, String... strArr) {
        HashMap hashMap = new HashMap(map);
        for (String str : strArr) {
            String settingFromEnvironment = getSettingFromEnvironment(str, (String) null);
            if (settingFromEnvironment != null) {
                hashMap.put(str, settingFromEnvironment);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    private static Map<String, String> m2584a(Map<String, String> map, Properties properties, String... strArr) {
        HashMap hashMap = new HashMap(map);
        for (String str : strArr) {
            String property = properties.getProperty(str, (String) null);
            if (property != null) {
                hashMap.put(str, property);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: c */
    private static List<String> m2596c(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.emptyList();
        }
        String[] split = str.split(",", -1);
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        return Collections.unmodifiableList(Arrays.asList(split));
    }

    /* renamed from: d */
    private static Set<String> m2601d(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : str.split(f4195v)) {
            if (!str2.isEmpty()) {
                linkedHashSet.add(str2);
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: a */
    private static Set<PropagationStyle> m2590a(Set<String> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String upperCase : set) {
            try {
                linkedHashSet.add(PropagationStyle.valueOf(upperCase.toUpperCase(Locale.US)));
            } catch (IllegalArgumentException unused) {
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: c */
    private static Properties m2597c() {
        FileReader fileReader;
        Properties properties = new Properties();
        String property = System.getProperty(m2593b(CONFIGURATION_FILE));
        if (property == null) {
            property = System.getenv(m2579a(CONFIGURATION_FILE));
        }
        if (property == null) {
            return properties;
        }
        File file = new File(property.replaceFirst("^~", System.getProperty("user.home")));
        if (!file.exists()) {
            return properties;
        }
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException | IOException unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return properties;
        throw th;
    }

    /* renamed from: d */
    private static String m2599d() {
        String str;
        BufferedReader bufferedReader;
        if (System.getProperty("os.name").startsWith("Windows")) {
            str = System.getenv("COMPUTERNAME");
        } else {
            str = System.getenv("HOSTNAME");
        }
        if (str != null && !str.isEmpty()) {
            return str.trim();
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("hostname").getInputStream()));
            str = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        if (str != null && !str.isEmpty()) {
            return str.trim();
        }
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused2) {
            return null;
        }
        throw th;
    }

    public static Config get() {
        return f4174aS;
    }

    public static Config get(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return f4174aS;
        }
        return new Config(properties, f4174aS);
    }

    public String getRuntimeId() {
        return this.f4200C;
    }

    public String getSite() {
        return this.f4201D;
    }

    public String getServiceName() {
        return this.f4202E;
    }

    public boolean isTraceEnabled() {
        return this.f4203F;
    }

    public boolean isIntegrationsEnabled() {
        return this.f4204G;
    }

    public String getWriterType() {
        return this.f4205H;
    }

    public String getAgentHost() {
        return this.f4206I;
    }

    public int getAgentPort() {
        return this.f4207J;
    }

    public String getAgentUnixDomainSocket() {
        return this.f4208K;
    }

    public boolean isPrioritySamplingEnabled() {
        return this.f4209L;
    }

    public boolean isTraceResolverEnabled() {
        return this.f4210M;
    }

    public Map<String, String> getServiceMapping() {
        return this.f4211N;
    }

    public List<String> getExcludedClasses() {
        return this.f4215R;
    }

    public Map<String, String> getHeaderTags() {
        return this.f4216S;
    }

    public Set<Integer> getHttpServerErrorStatuses() {
        return this.f4217T;
    }

    public Set<Integer> getHttpClientErrorStatuses() {
        return this.f4218U;
    }

    public boolean isHttpServerTagQueryString() {
        return this.f4219V;
    }

    public boolean isHttpClientTagQueryString() {
        return this.f4220W;
    }

    public boolean isHttpClientSplitByDomain() {
        return this.f4221X;
    }

    public boolean isDbClientSplitByInstance() {
        return this.f4222Y;
    }

    public Set<String> getSplitByTags() {
        return this.f4223Z;
    }

    public Integer getScopeDepthLimit() {
        return this.f4241aa;
    }

    public Integer getPartialFlushMinSpans() {
        return this.f4242ab;
    }

    public boolean isRuntimeContextFieldInjection() {
        return this.f4243ac;
    }

    public Set<PropagationStyle> getPropagationStylesToExtract() {
        return this.f4244ad;
    }

    public Set<PropagationStyle> getPropagationStylesToInject() {
        return this.f4245ae;
    }

    public boolean isJmxFetchEnabled() {
        return this.f4246af;
    }

    public String getJmxFetchConfigDir() {
        return this.f4247ag;
    }

    public List<String> getJmxFetchConfigs() {
        return this.f4248ah;
    }

    public List<String> getJmxFetchMetricsConfigs() {
        return this.f4249ai;
    }

    public Integer getJmxFetchCheckPeriod() {
        return this.f4250aj;
    }

    public Integer getJmxFetchRefreshBeansPeriod() {
        return this.f4251ak;
    }

    public String getJmxFetchStatsdHost() {
        return this.f4252al;
    }

    public Integer getJmxFetchStatsdPort() {
        return this.f4253am;
    }

    public boolean isHealthMetricsEnabled() {
        return this.f4254an;
    }

    public String getHealthMetricsStatsdHost() {
        return this.f4255ao;
    }

    public Integer getHealthMetricsStatsdPort() {
        return this.f4256ap;
    }

    public boolean isLogsInjectionEnabled() {
        return this.f4257aq;
    }

    public boolean isReportHostName() {
        return this.f4258ar;
    }

    public String getTraceAnnotations() {
        return this.f4259as;
    }

    public String getTraceMethods() {
        return this.f4260at;
    }

    public boolean isTraceExecutorsAll() {
        return this.f4261au;
    }

    public List<String> getTraceExecutors() {
        return this.f4262av;
    }

    public boolean isTraceAnalyticsEnabled() {
        return this.f4263aw;
    }

    public Map<String, String> getTraceSamplingServiceRules() {
        return this.f4264ax;
    }

    public Map<String, String> getTraceSamplingOperationRules() {
        return this.f4265ay;
    }

    public Double getTraceSampleRate() {
        return this.f4266az;
    }

    public Double getTraceRateLimit() {
        return this.f4224aA;
    }

    public boolean isProfilingEnabled() {
        return this.f4225aB;
    }

    public int getProfilingStartDelay() {
        return this.f4228aE;
    }

    public boolean isProfilingStartForceFirst() {
        return this.f4229aF;
    }

    public int getProfilingUploadPeriod() {
        return this.f4230aG;
    }

    public String getProfilingTemplateOverrideFile() {
        return this.f4231aH;
    }

    public int getProfilingUploadTimeout() {
        return this.f4232aI;
    }

    public String getProfilingUploadCompression() {
        return this.f4233aJ;
    }

    public String getProfilingProxyHost() {
        return this.f4234aK;
    }

    public int getProfilingProxyPort() {
        return this.f4235aL;
    }

    public String getProfilingProxyUsername() {
        return this.f4236aM;
    }

    public String getProfilingProxyPassword() {
        return this.f4237aN;
    }

    public int getProfilingExceptionSampleLimit() {
        return this.f4238aO;
    }

    public int getProfilingExceptionHistogramTopItems() {
        return this.f4239aP;
    }

    public int getProfilingExceptionHistogramMaxCollectionSize() {
        return this.f4240aQ;
    }

    public String toString() {
        return "Config{runtimeId='" + this.f4200C + '\'' + ", site='" + this.f4201D + '\'' + ", serviceName='" + this.f4202E + '\'' + ", traceEnabled=" + this.f4203F + ", integrationsEnabled=" + this.f4204G + ", writerType='" + this.f4205H + '\'' + ", agentHost='" + this.f4206I + '\'' + ", agentPort=" + this.f4207J + ", agentUnixDomainSocket='" + this.f4208K + '\'' + ", prioritySamplingEnabled=" + this.f4209L + ", traceResolverEnabled=" + this.f4210M + ", serviceMapping=" + this.f4211N + ", tags=" + this.f4212O + ", spanTags=" + this.f4213P + ", jmxTags=" + this.f4214Q + ", excludedClasses=" + this.f4215R + ", headerTags=" + this.f4216S + ", httpServerErrorStatuses=" + this.f4217T + ", httpClientErrorStatuses=" + this.f4218U + ", httpServerTagQueryString=" + this.f4219V + ", httpClientTagQueryString=" + this.f4220W + ", httpClientSplitByDomain=" + this.f4221X + ", dbClientSplitByInstance=" + this.f4222Y + ", splitByTags=" + this.f4223Z + ", scopeDepthLimit=" + this.f4241aa + ", partialFlushMinSpans=" + this.f4242ab + ", runtimeContextFieldInjection=" + this.f4243ac + ", propagationStylesToExtract=" + this.f4244ad + ", propagationStylesToInject=" + this.f4245ae + ", jmxFetchEnabled=" + this.f4246af + ", jmxFetchConfigDir='" + this.f4247ag + '\'' + ", jmxFetchConfigs=" + this.f4248ah + ", jmxFetchMetricsConfigs=" + this.f4249ai + ", jmxFetchCheckPeriod=" + this.f4250aj + ", jmxFetchRefreshBeansPeriod=" + this.f4251ak + ", jmxFetchStatsdHost='" + this.f4252al + '\'' + ", jmxFetchStatsdPort=" + this.f4253am + ", healthMetricsEnabled=" + this.f4254an + ", healthMetricsStatsdHost='" + this.f4255ao + '\'' + ", healthMetricsStatsdPort=" + this.f4256ap + ", logsInjectionEnabled=" + this.f4257aq + ", reportHostName=" + this.f4258ar + ", traceAnnotations='" + this.f4259as + '\'' + ", traceMethods='" + this.f4260at + '\'' + ", traceExecutorsAll=" + this.f4261au + ", traceExecutors=" + this.f4262av + ", traceAnalyticsEnabled=" + this.f4263aw + ", traceSamplingServiceRules=" + this.f4264ax + ", traceSamplingOperationRules=" + this.f4265ay + ", traceSampleRate=" + this.f4266az + ", traceRateLimit=" + this.f4224aA + ", profilingEnabled=" + this.f4225aB + ", profilingUrl='" + this.f4226aC + '\'' + ", profilingTags=" + this.f4227aD + ", profilingStartDelay=" + this.f4228aE + ", profilingStartForceFirst=" + this.f4229aF + ", profilingUploadPeriod=" + this.f4230aG + ", profilingTemplateOverrideFile='" + this.f4231aH + '\'' + ", profilingUploadTimeout=" + this.f4232aI + ", profilingUploadCompression='" + this.f4233aJ + '\'' + ", profilingProxyHost='" + this.f4234aK + '\'' + ", profilingProxyPort=" + this.f4235aL + ", profilingProxyUsername='" + this.f4236aM + '\'' + ", profilingProxyPassword='" + this.f4237aN + '\'' + ", profilingExceptionSampleLimit=" + this.f4238aO + ", profilingExceptionHistogramTopItems=" + this.f4239aP + ", profilingExceptionHistogramMaxCollectionSize=" + this.f4240aQ + '}';
    }
}
