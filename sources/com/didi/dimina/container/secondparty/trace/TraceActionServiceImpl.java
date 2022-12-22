package com.didi.dimina.container.secondparty.trace;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.blankscreen.BlankType;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.dimina.container.secondparty.trace.inner.LogTracker;
import com.didi.dimina.container.service.TraceActionService;
import com.didi.dimina.container.service.TraceService;
import com.didi.dimina.container.util.LogUtil;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.sdk.push.ServerParam;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u0003\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ·\u00012\u00020\u0001:\u0002·\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016JJ\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001a\u001a\u00020\bJ\\\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0001\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010%\u001a\u00020\bH\u0016J*\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u00042\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010)H\u0016J\u001a\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J*\u0010/\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101H\u0016JX\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u0002042\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u0002042\b\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010?\u001a\u0004\u0018\u00010\u0004J \u0010@\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u0004H\u0016J\"\u0010C\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u000204H\u0016J.\u0010D\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010H\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010I\u001a\u0002042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u000e\u0010J\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJV\u0010K\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010L\u001a\u0002042\u0006\u0010M\u001a\u0002042\u0006\u0010N\u001a\u0002042\b\u0010O\u001a\u0004\u0018\u00010\u00042\b\u0010P\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u000e\u0010Q\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\u0004J\"\u0010R\u001a\u00020\b2\u0006\u0010V\u001a\u00020W2\u0006\u0010T\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010\u0004J>\u0010[\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u0010I\u001a\u0002042\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u000e\u0010]\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ>\u0010^\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u0010I\u001a\u0002042\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u000e\u0010_\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ.\u0010`\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010a\u001a\u0004\u0018\u00010\u00042\b\u0010B\u001a\u0004\u0018\u00010\u00042\b\u0010S\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010c\u001a\u000204H\u0016J$\u0010d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010e\u001a\u0004\u0018\u00010\u00042\b\u0010f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010g\u001a\u00020\b2\b\u0010h\u001a\u0004\u0018\u00010\u0004H\u0016Jj\u0010i\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u0002042\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010j\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u0002042\u0006\u0010=\u001a\u0002042\b\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010?\u001a\u0004\u0018\u00010\u0004J\u0010\u0010k\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016JV\u0010l\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010m\u001a\u0002042\u0006\u0010n\u001a\u0002042\u0006\u0010o\u001a\u0002042\u0006\u0010p\u001a\u0002042\b\u0010q\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010s\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010v\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010u\u001a\u0004\u0018\u00010\u00042\b\u0010w\u001a\u0004\u0018\u00010\u0004J*\u0010x\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010y\u001a\u0004\u0018\u00010\u00042\u0006\u0010z\u001a\u00020\n2\b\u0010u\u001a\u0004\u0018\u00010\u0004J0\u0010{\u001a\u00020\b2\u0006\u0010|\u001a\u00020\n2\b\u0010}\u001a\u0004\u0018\u00010\u00042\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010)J$\u0010~\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010}\u001a\u0004\u0018\u00010\u00042\b\u0010U\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\n2\b\u0010h\u001a\u0004\u0018\u00010\u0004H\u0016J>\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u00020\nH\u0016J+\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010\u0001\u001a\u0002042\u0007\u0010\u0001\u001a\u0002042\u0006\u0010p\u001a\u000204H\u0016JC\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004J:\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004JC\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ:\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ6\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010p\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J8\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010N\u001a\u0002042\u0007\u0010\u0001\u001a\u0002042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010p\u001a\u000204H\u0016J%\u0010 \u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010¡\u0001\u001a\u00020\n2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u001b\u0010£\u0001\u001a\u00020\b2\u0006\u0010|\u001a\u00020\n2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J5\u0010¦\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010§\u0001\u001a\u00030\u00012\b\u0010e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\n2\b\u0010¨\u0001\u001a\u00030\u0001J\u0019\u0010©\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010e\u001a\u0004\u0018\u00010\u0004J1\u0010ª\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¨\u0001\u001a\u00030\u0001H\u0016J:\u0010­\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010®\u0001\u001a\u0002042\b\u0010¨\u0001\u001a\u00030\u0001H\u0016J#\u0010¯\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0007\u0010°\u0001\u001a\u0002042\u0007\u0010±\u0001\u001a\u000204H\u0016J/\u0010²\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010´\u0001\u001a\f\u0018\u00010µ\u0001j\u0005\u0018\u0001`¶\u0001H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006¸\u0001"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/TraceActionServiceImpl;", "Lcom/didi/dimina/container/service/TraceActionService;", "()V", "AC_SUCCESS", "", "getAC_SUCCESS", "()Ljava/lang/String;", "firstLaunch", "", "minaIndex", "", "duration", "newTraceForceUpdateEnd", "mina", "Lcom/didi/dimina/container/DMMina;", "localJsAppConfig", "Lcom/didi/dimina/container/bundle/bean/BundleConfig;", "localJsSdkConfig", "remoteJsAppConfig", "remoteJsSdkConfig", "errCode", "errMsg", "newTraceForceUpdateErrorEnd", "jsAppId", "setEmpIfEmptyForPmTrace", "str", "setMainPackageDownloadStartTime", "techSagaScreenBlankMonitor", "checkPolicy", "checkCount", "isBlank", "samplePolicy", "colorRate", "", "openUrl", "webUrl", "costIntervalTime", "techSagaScreenBlankMonitorException", "traceD6WebkitSameLayerRenderEvent", "eventId", "params", "", "", "traceEngineType", "engine", "traceEventDeviceStat", "map", "traceForceUpdateEnd", "forceUpdateConfig", "Lcom/didi/dimina/container/DMConfig$ForceUpdateConfig;", "result", "costTime", "", "traceForceUpdateStart", "traceImageWebRequestFromCache", "mime", "width", "height", "sourceSize", "mainFrame", "resource", "resolution", "versionName", "apolloTest", "traceInteractionTime", "timeInterval", "url", "traceInvokeWebViewReady", "traceLoadError", "pageName", "appId", "errorMessage", "tracePmConfigRequestEnd", "use_time", "tracePmConfigRequestStart", "tracePmDownloadInstallEnd", "appTime", "sdkTime", "useTime", "downloadAppVersion", "downloadSdkVersion", "tracePmDownloadInstallStart", "tracePmException", "errorMsg", "errorCode", "extra", "throwable", "", "tracePmInstallStart", "instal", "sdkId", "tracePmSubPackageDownloadEnd", "module_name", "tracePmSubPackageDownloadStart", "tracePmSubPackageRequestEnd", "tracePmSubPackageRequestStart", "traceReadFileError", "pos", "traceSagaWaitingTiming", "timeGap", "traceUnrealizedBridge", "moduleName", "bridgeName", "traceV8Fatal", "msg", "traceWebRequestBigImgWaring", "cdnHeaders", "traceWebViewCrash", "trackAppOpenRateEnd", "pckDownloadTime", "jsCoreTime", "webViewTime", "intvlTime", "launchPath", "trackAppOpenRateStart", "trackBackgroundFetchDataApply", "apply", "token", "trackBackgroundFetchDataDuration", "traceId", "trackBackgroundFetchDataError", "aggregationUrl", "error", "trackEvent", "index", "event", "trackEventCoreDotting", "trackEventError", "type", "code", "trackEventLaunchPerformance2", "jsDefine", "jsRequire", "jsPackage", "page", "ebg", "trackJscoreExecute", "dmTime", "appIime", "trackMainPackageDownloadLocalFail", "en", "jsAppVersion", "jsSdkVersion", "jsSdkId", "trackMainPackageDownloadLocalSuccess", "trackMainPackageDownloadRemoteFail", "trackMainPackageDownloadRemoteStart", "trackMainPackageDownloadRemoteSuccess", "trackMainPackageDownloadStart", "trackOpenPageEnd", "path", "isPreload", "", "(ILjava/lang/String;ZLjava/lang/Long;)V", "trackOpenPageStart", "trackPageOnDestroyRendering", "webViewId", "from", "trackPreloadWebview", "pageFrame", "trackRelaunch", "memory", "source", "trackReportMiniProgramEvent", "object", "Lorg/json/JSONObject;", "trackSubPackageDownloadResult", "success", "isLaunching", "trackSubPackageDownloadStart", "trackTechSagaSubPkgExecStart", "devMode", "packageName", "trackTechSagaSubPkgExecSuccess", "diff", "trackWebViewRelease", "launchTime", "pageCount", "trackWvInterceptorRequestError", "requestUrl", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TraceActionServiceImpl.kt */
public final class TraceActionServiceImpl implements TraceActionService {

    /* renamed from: AC */
    public static final String f17448AC = "ac";
    public static final String AC_START = "start";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEV_MODE = "dev_mode";
    public static final String LAUNCH = "launch";
    public static final String PKG = "pkg";
    public static final String TECH_SAGA_CORE_DOTTING = "tech_saga_core_dotting";
    public static final String TECH_SAGA_CORE_DOTTING_EVENT = "event";
    public static final String TECH_SAGA_CORE_DOTTING_INFO = "info";
    public static final String TECH_SAGA_SUB_PKG_EXEC = "tech_saga_sub_pkg_exec";
    public static final String USE_TIME = "use_time";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static long f17449b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static long f17450c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ConcurrentHashMap<String, Long> f17451d = new ConcurrentHashMap<>();

    /* renamed from: a */
    private final String f17452a = "succ";

    public /* synthetic */ void traceInvokeWebViewReady(int i, String str, Long l) {
        traceInvokeWebViewReady(i, str, l.longValue());
    }

    public /* synthetic */ void trackJscoreExecute(int i, Long l, Long l2, Long l3) {
        trackJscoreExecute(i, l.longValue(), l2.longValue(), l3.longValue());
    }

    public final String getAC_SUCCESS() {
        return this.f17452a;
    }

    public void traceEventDeviceStat(int i, Map<String, ? extends Object> map) {
        trackEvent(i, "tech_saga_performance_info", map);
    }

    public void traceLoadError(int i, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PAGE_NAME, str);
        hashMap.put("app_id", str2);
        hashMap.put("error_message", str3);
        trackEvent(i, "tech_bt_bundle_load_error", hashMap);
    }

    public void trackEventError(int i, String str, int i2, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("em", str2);
        hashMap.put("en", Integer.valueOf(i2));
        hashMap.put("et", str);
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.ERROR, hashMap);
    }

    public void trackRelaunch(int i, int i2, String str) {
        Map hashMap = new HashMap();
        hashMap.put("curmemory", Integer.valueOf(i2));
        hashMap.put("source", str);
        trackEvent(i, "tech_saga_memory_relaunch", hashMap);
    }

    public void trackAppOpenRateStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("result", 0);
        LogUtil.iRelease("trackTAG launch", "tech_saga_launch_app    start  ------11111111 ");
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.LAUNCH_APP, hashMap);
    }

    public void trackAppOpenRateEnd(int i, int i2, long j, long j2, long j3, long j4, String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("result", Integer.valueOf(i2));
        hashMap.put("pkg_download_time", Long.valueOf(j));
        hashMap.put("jscore_time", Long.valueOf(j2));
        hashMap.put("webview_time", Long.valueOf(j3));
        hashMap.put("intvl_time", Long.valueOf(j4));
        hashMap.put("launch_path", str);
        if (str4 != null) {
            hashMap.put("en", str4);
        }
        if (str5 != null) {
            hashMap.put("em", str5);
        }
        LogUtil.iRelease("trackTAG launch", "tech_saga_launch_app    end  ------222222222 ");
        int i3 = i;
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.LAUNCH_APP, hashMap);
    }

    public void trackWebViewRelease(int i, long j, long j2) {
        Map hashMap = new HashMap();
        hashMap.put("pn", Long.valueOf(j2));
        hashMap.put(USE_TIME, Long.valueOf(j));
        trackEvent(i, "tech_saga_webview_release", hashMap);
    }

    public void trackTechSagaSubPkgExecStart(int i, String str, String str2, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put(DEV_MODE, str);
        hashMap.put(PKG, str2);
        hashMap.put("ac", "start");
        hashMap.put("launch", Integer.valueOf(z ? 1 : 0));
        trackEvent(i, TECH_SAGA_SUB_PKG_EXEC, hashMap);
    }

    public void trackTechSagaSubPkgExecSuccess(int i, String str, String str2, long j, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put(DEV_MODE, str);
        hashMap.put(PKG, str2);
        hashMap.put(USE_TIME, Long.valueOf(j));
        hashMap.put("ac", this.f17452a);
        hashMap.put("launch", Integer.valueOf(z ? 1 : 0));
        trackEvent(i, TECH_SAGA_SUB_PKG_EXEC, hashMap);
    }

    public void traceInvokeWebViewReady(int i, String str, long j) {
        Map hashMap = new HashMap();
        hashMap.put("path", str);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(j));
        hashMap.put("ac", DiminaTraceService.MAS_MONITOR_EVENT.VALUE.WEBVIEW_READY);
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.OPEN_PAGE, hashMap);
    }

    public void traceInteractionTime(int i, long j, String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Map hashMap = new HashMap();
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(j));
        hashMap.put("ac", DiminaTraceService.MAS_MONITOR_EVENT.VALUE.INTERACTION_TIME);
        hashMap.put("path", str);
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.OPEN_PAGE, hashMap);
    }

    public void trackEventLaunchPerformance2(int i, long j, long j2, long j3, long j4, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("ass", Long.valueOf(j));
        hashMap.put("ibr", Long.valueOf(j2));
        hashMap.put("ljs", Long.valueOf(j3));
        hashMap.put("iptwd", Long.valueOf(j4));
        hashMap.put("ebg", Integer.valueOf(i2));
        trackEvent(i, "tech_saga_timing_launch", hashMap);
    }

    public void trackEventCoreDotting(int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        hashMap.put("info", str2);
        trackEvent(i, TECH_SAGA_CORE_DOTTING, hashMap);
    }

    public void trackWvInterceptorRequestError(int i, String str, Exception exc) {
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("req_url", str);
        }
        if (exc != null) {
            hashMap.put("em", exc.toString());
        }
        trackEvent(i, "tech_saga_interceptor_web_req_error", hashMap);
    }

    public void trackPageOnDestroyRendering(int i, String str, long j, long j2, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("path", str);
        hashMap.put(USE_TIME, Long.valueOf(j));
        hashMap.put("web_view_id", Long.valueOf(j2));
        hashMap.put("from", str2);
        trackEvent(i, "tech_saga_page_rendering_on_destroy", hashMap);
    }

    public final void setMainPackageDownloadStartTime() {
        f17449b = System.currentTimeMillis();
    }

    public final void trackMainPackageDownloadRemoteStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 2);
        f17450c = System.currentTimeMillis();
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackMainPackageDownloadStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 1);
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackMainPackageDownloadLocalSuccess(int i, String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 2);
        hashMap.put("result", 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(System.currentTimeMillis() - f17449b));
        hashMap.put("pappvs", setEmpIfEmptyForPmTrace(str));
        hashMap.put("pjssdkvs", setEmpIfEmptyForPmTrace(str2));
        hashMap.put("pntsdkvs", setEmpIfEmptyForPmTrace(Dimina.getVersion()));
        hashMap.put("pappid", setEmpIfEmptyForPmTrace(str3));
        hashMap.put("pjssdkid", setEmpIfEmptyForPmTrace(str4));
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackMainPackageDownloadLocalFail(int i, int i2, String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 2);
        hashMap.put("result", -1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(System.currentTimeMillis() - f17449b));
        hashMap.put("en", Integer.valueOf(i2));
        hashMap.put("pappvs", setEmpIfEmptyForPmTrace(str));
        hashMap.put("pjssdkvs", setEmpIfEmptyForPmTrace(str2));
        hashMap.put("pntsdkvs", setEmpIfEmptyForPmTrace(Dimina.getVersion()));
        hashMap.put("pappid", setEmpIfEmptyForPmTrace(str3));
        hashMap.put("pjssdkid", setEmpIfEmptyForPmTrace(str4));
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackMainPackageDownloadRemoteSuccess(int i, String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 2);
        hashMap.put("result", 1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 2);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, f17450c == 0 ? "" : Long.valueOf(System.currentTimeMillis() - f17450c));
        hashMap.put("pappvs", setEmpIfEmptyForPmTrace(str));
        hashMap.put("pjssdkvs", setEmpIfEmptyForPmTrace(str2));
        hashMap.put("pntsdkvs", setEmpIfEmptyForPmTrace(Dimina.getVersion()));
        hashMap.put("pappid", setEmpIfEmptyForPmTrace(str3));
        hashMap.put("pjssdkid", setEmpIfEmptyForPmTrace(str4));
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackMainPackageDownloadRemoteFail(int i, int i2, String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 2);
        hashMap.put("result", -1);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.INSTALL_TYPE, 2);
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, f17450c == 0 ? "" : Long.valueOf(System.currentTimeMillis() - f17450c));
        hashMap.put("en", Integer.valueOf(i2));
        hashMap.put("pappvs", setEmpIfEmptyForPmTrace(str));
        hashMap.put("pjssdkvs", setEmpIfEmptyForPmTrace(str2));
        hashMap.put("pntsdkvs", setEmpIfEmptyForPmTrace(Dimina.getVersion()));
        hashMap.put("pappid", setEmpIfEmptyForPmTrace(str3));
        hashMap.put("pjssdkid", setEmpIfEmptyForPmTrace(str4));
        trackEvent(i, "tech_saga_load_main_package_download", hashMap);
    }

    public final void trackSubPackageDownloadStart(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("module_name", str);
        if (str != null) {
            f17451d.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        TextUtils.isEmpty(str);
        trackEvent(i, "tech_saga_download_sp_package", hashMap);
    }

    public final void trackSubPackageDownloadResult(int i, boolean z, String str, int i2, boolean z2) {
        Long l;
        if (str != null && (l = f17451d.get(str)) != null) {
            l.longValue();
            Map hashMap = new HashMap();
            hashMap.put("module_name", str);
            hashMap.put("result", Integer.valueOf(z ? 1 : -1));
            hashMap.put("en", Integer.valueOf(i2));
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(currentTimeMillis));
            hashMap.put(USE_TIME, Long.valueOf(currentTimeMillis));
            hashMap.put("launch", Integer.valueOf(z2 ? 1 : 0));
            trackEvent(i, "tech_saga_download_sp_package_result", hashMap);
        }
    }

    public void trackPreloadWebview(int i, int i2, long j) {
        Map hashMap = new HashMap();
        hashMap.put("pageframe", Integer.valueOf(i2));
        hashMap.put("intvl_time", Long.valueOf(j));
        trackEvent(i, "tech_saga_preload_webview", hashMap);
    }

    public void traceEngineType(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("engine", str);
        trackEvent(i, "tech_saga_engine_type", hashMap);
    }

    public void traceUnrealizedBridge(int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("module_name", str);
        hashMap.put("bridge_name", str2);
        trackEvent(i, "tech_saga_unrealized_bridge", hashMap);
    }

    public void traceForceUpdateStart(int i, DMConfig.ForceUpdateConfig forceUpdateConfig) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        Long l = null;
        hashMap.put("fu_sdkver", forceUpdateConfig != null ? forceUpdateConfig.getForceUpdateJSSDKVersion() : null);
        hashMap.put("fu_appver", forceUpdateConfig != null ? forceUpdateConfig.getForceUpdateAppVersion() : null);
        if (forceUpdateConfig != null) {
            l = Long.valueOf(forceUpdateConfig.getForceUpdateTimeout());
        }
        hashMap.put("to", l);
        trackEvent(i, "tech_saga_force_update", hashMap);
    }

    public void traceForceUpdateEnd(int i, DMConfig.ForceUpdateConfig forceUpdateConfig, int i2, long j) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 2);
        Long l = null;
        hashMap.put("fu_sdkver", forceUpdateConfig != null ? forceUpdateConfig.getForceUpdateJSSDKVersion() : null);
        hashMap.put("fu_appver", forceUpdateConfig != null ? forceUpdateConfig.getForceUpdateAppVersion() : null);
        if (forceUpdateConfig != null) {
            l = Long.valueOf(forceUpdateConfig.getForceUpdateTimeout());
        }
        hashMap.put("to", l);
        hashMap.put("result", Integer.valueOf(i2));
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, Long.valueOf(j));
        trackEvent(i, "tech_saga_force_update", hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083 A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008c A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094 A[Catch:{ Exception -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void newTraceForceUpdateEnd(com.didi.dimina.container.DMMina r5, com.didi.dimina.container.bundle.bean.BundleConfig r6, com.didi.dimina.container.bundle.bean.BundleConfig r7, com.didi.dimina.container.bundle.bean.BundleConfig r8, com.didi.dimina.container.bundle.bean.BundleConfig r9, int r10, java.lang.String r11) {
        /*
            r4 = this;
            java.lang.String r0 = "mina"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00b3 }
            r0.<init>()     // Catch:{ Exception -> 0x00b3 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r1 = "ac"
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00b3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00b3 }
            r1 = 0
            com.didi.dimina.container.DMConfig r5 = r5.getConfig()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r2 = "mina.config"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)     // Catch:{ Exception -> 0x00b3 }
            com.didi.dimina.container.DMConfig$ForceUpdateConfig r5 = r5.getForceUpdateConfig()     // Catch:{ Exception -> 0x00b3 }
            r2 = -1
            r3 = 0
            if (r8 == 0) goto L_0x004e
            if (r9 == 0) goto L_0x004e
            java.lang.String r9 = r9.versionCode     // Catch:{ Exception -> 0x00b3 }
            if (r5 == 0) goto L_0x0033
            java.lang.String r1 = r5.getForceUpdateJSSDKVersion()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0034
        L_0x0033:
            r1 = r3
        L_0x0034:
            int r9 = com.didi.dimina.container.util.VersionUtil.compareVersion(r9, r1)     // Catch:{ Exception -> 0x00b3 }
            if (r9 <= 0) goto L_0x004d
            java.lang.String r8 = r8.versionCode     // Catch:{ Exception -> 0x00b3 }
            if (r5 == 0) goto L_0x0043
            java.lang.String r9 = r5.getForceUpdateAppVersion()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0044
        L_0x0043:
            r9 = r3
        L_0x0044:
            int r8 = com.didi.dimina.container.util.VersionUtil.compareVersion(r8, r9)     // Catch:{ Exception -> 0x00b3 }
            if (r8 <= 0) goto L_0x004d
            r8 = 1
            r1 = 1
            goto L_0x004e
        L_0x004d:
            r1 = -1
        L_0x004e:
            java.lang.String r8 = "rt"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00b3 }
            r0.put(r8, r9)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r8 = "lcjssdkvs"
            java.lang.String r9 = ""
            if (r7 == 0) goto L_0x0062
            java.lang.String r7 = r7.versionCode     // Catch:{ Exception -> 0x00b3 }
            if (r7 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r7 = r9
        L_0x0063:
            r0.put(r8, r7)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r7 = "lcappvs"
            if (r6 == 0) goto L_0x006f
            java.lang.String r8 = r6.versionCode     // Catch:{ Exception -> 0x00b3 }
            if (r8 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r8 = r9
        L_0x0070:
            r0.put(r7, r8)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r7 = "appid"
            if (r6 == 0) goto L_0x007c
            java.lang.String r6 = r6.appId     // Catch:{ Exception -> 0x00b3 }
            if (r6 == 0) goto L_0x007c
            r9 = r6
        L_0x007c:
            r0.put(r7, r9)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r6 = "foupjssdkvs"
            if (r5 == 0) goto L_0x008c
            long r7 = r5.getForceUpdateTimeout()     // Catch:{ Exception -> 0x00b3 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x008d
        L_0x008c:
            r7 = r3
        L_0x008d:
            r0.put(r6, r7)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r6 = "foupappvs"
            if (r5 == 0) goto L_0x009c
            long r7 = r5.getForceUpdateTimeout()     // Catch:{ Exception -> 0x00b3 }
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00b3 }
        L_0x009c:
            r0.put(r6, r3)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r5 = "en"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00b3 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r5 = "em"
            r0.put(r5, r11)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r5 = "tech_saga_force_update_sdk_package"
            r4.trackEvent(r2, r5, r0)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl.newTraceForceUpdateEnd(com.didi.dimina.container.DMMina, com.didi.dimina.container.bundle.bean.BundleConfig, com.didi.dimina.container.bundle.bean.BundleConfig, com.didi.dimina.container.bundle.bean.BundleConfig, com.didi.dimina.container.bundle.bean.BundleConfig, int, java.lang.String):void");
    }

    public final void newTraceForceUpdateErrorEnd(DMMina dMMina, String str, int i, String str2) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mina");
        try {
            Map hashMap = new HashMap();
            hashMap.put("ac", 2);
            DMConfig config = dMMina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
            DMConfig.ForceUpdateConfig forceUpdateConfig = config.getForceUpdateConfig();
            hashMap.put("rt", "-1");
            hashMap.put("appid", str);
            Long l = null;
            hashMap.put("foupjssdkvs", forceUpdateConfig != null ? Long.valueOf(forceUpdateConfig.getForceUpdateTimeout()) : null);
            if (forceUpdateConfig != null) {
                l = Long.valueOf(forceUpdateConfig.getForceUpdateTimeout());
            }
            hashMap.put("foupappvs", l);
            hashMap.put("en", Integer.valueOf(i));
            hashMap.put("em", str2);
            trackEvent(-1, "tech_saga_force_update_sdk_package", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tracePmException(Throwable th, int i, String str) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        tracePmException(Log.getStackTraceString(th), i, str);
    }

    public final void tracePmException(String str, int i, String str2) {
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            hashMap.put("em", str);
        }
        hashMap.put("en", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            hashMap.put("extra", str2);
        }
        trackEvent(-1, "tech_saga_pkg_exception", hashMap);
    }

    public void trackOpenPageStart(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("path", str);
        DMMina dMMina = DMMinaPool.get(i);
        if (dMMina != null) {
            hashMap.put("first_page", Boolean.valueOf(Intrinsics.areEqual((Object) str, (Object) DMMinaHelper.getEntryPath(dMMina))));
        }
        LogUtil.iRelease("trackTAG open", "tech_saga_open_page    start  .........3333333 " + hashMap);
        trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.OPEN_PAGE, hashMap);
    }

    public void trackOpenPageEnd(int i, String str, boolean z, Long l) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("path", str);
        DMMina dMMina = DMMinaPool.get(i);
        if (dMMina != null) {
            hashMap.put("first_page", Boolean.valueOf(Intrinsics.areEqual((Object) str, (Object) DMMinaHelper.getEntryPath(dMMina))));
        }
        hashMap.put("preload", Boolean.valueOf(z));
        hashMap.put("intvl_time", l);
        if (l != null) {
            l.longValue();
            if (l.longValue() <= 0) {
                LogUtil.eRelease("TraceActionServiceImpl", "tech_saga_open_page 埋点 " + l + " 值不正常, " + hashMap);
                return;
            }
            LogUtil.iRelease("trackTAG open", "tech_saga_open_page    end .........444444 " + hashMap);
            trackEvent(i, DiminaTraceService.MAS_MONITOR_EVENT.OPEN_PAGE, hashMap);
        }
    }

    public final void trackBackgroundFetchDataDuration(int i, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("duration", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("token", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put(ParamConst.TRACE_ID, str3);
        trackEvent(i, "tech_saga_background_fetch_data_duration", hashMap);
    }

    public final void trackBackgroundFetchDataError(int i, String str, int i2, String str2) {
        Map hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("aggregation_url", str);
        hashMap.put("error", Integer.valueOf(i2));
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("token", str2);
        trackEvent(i, "tech_saga_background_fetch_data_error", hashMap);
    }

    public void trackBackgroundFetchDataApply(int i, int i2, String str) {
        Map hashMap = new HashMap();
        hashMap.put(PrepaidConstant.SCENE_APPLY, Integer.valueOf(i2));
        if (str == null) {
            str = "";
        }
        hashMap.put("token", str);
        trackEvent(i, "tech_saga_background_fetch_data_apply", hashMap);
    }

    public void firstLaunch(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("duration", str);
        trackEvent(i, "tech_saga_first_launch", hashMap);
    }

    public final void tracePmInstallStart(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "instal");
        Map hashMap = new HashMap();
        hashMap.put("pinstl", str);
        hashMap.put("pappid", str2);
        hashMap.put("pjssdkid", str3);
        trackEvent(-1, "tech_saga_pkg_install_start", hashMap);
    }

    public final void tracePmConfigRequestStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("result", 0);
        trackEvent(i, "tech_saga_package_request", hashMap);
    }

    public final void tracePmConfigRequestEnd(int i, int i2, long j, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("result", Integer.valueOf(i2));
        hashMap.put("intvl_time", Long.valueOf(j));
        if (str == null) {
            str = "";
        }
        hashMap.put("en", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("em", str2);
        trackEvent(i, "tech_saga_package_request", hashMap);
    }

    public final void tracePmDownloadInstallStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("result", 0);
        trackEvent(i, "tech_saga_package_download", hashMap);
    }

    public final void tracePmDownloadInstallEnd(int i, int i2, long j, long j2, long j3, String str, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("result", Integer.valueOf(i2));
        hashMap.put(ServerParam.PARAM_DDRIVER_APP_TIME, Long.valueOf(j));
        hashMap.put("sdk_time", Long.valueOf(j2));
        hashMap.put("intvl_time", Long.valueOf(j3));
        if (str == null) {
            str = "";
        }
        hashMap.put("app_version", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sdk_version", str2);
        hashMap.put("en", str3);
        hashMap.put("em", str4);
        trackEvent(i, "tech_saga_package_download", hashMap);
    }

    public void techSagaScreenBlankMonitor(int i, String str, int i2, @BlankType int i3, String str2, float f, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("check_policy", str);
        hashMap.put("check_count", Integer.valueOf(i2));
        hashMap.put("is_blank", Integer.valueOf(i3));
        hashMap.put("sample_policy", str2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.CHINA;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.CHINA");
        String format = String.format(locale, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f * ((float) 100))}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        hashMap.put("color_rate", format);
        hashMap.put(CashierAction.ACTION_OPEN_URL, str3);
        hashMap.put("web_url", str4);
        hashMap.put("cost_interval", str5);
        trackEvent(i, "tech_saga_screen_blank_monitor", hashMap);
    }

    public final void tracePmSubPackageRequestStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("result", 0);
        trackEvent(i, "tech_saga_sub_package_request", hashMap);
    }

    public final void tracePmSubPackageRequestEnd(int i, String str, long j, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("result", str);
        hashMap.put("intvl_time", Long.valueOf(j));
        hashMap.put("module_name", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("en", str3);
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("em", str4);
        trackEvent(i, "tech_saga_sub_package_request", hashMap);
    }

    public final void tracePmSubPackageDownloadStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 0);
        hashMap.put("result", 0);
        trackEvent(i, "tech_saga_sub_package_download", hashMap);
    }

    public final void tracePmSubPackageDownloadEnd(int i, String str, long j, String str2, String str3, String str4) {
        Map hashMap = new HashMap();
        hashMap.put("ac", 1);
        hashMap.put("result", str);
        hashMap.put("intvl_time", Long.valueOf(j));
        hashMap.put("module_name", str2);
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("en", str3);
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("em", str4);
        trackEvent(i, "tech_saga_sub_package_download", hashMap);
    }

    public void trackJscoreExecute(int i, long j, long j2, long j3) {
        Map hashMap = new HashMap();
        hashMap.put("dm_time", Long.valueOf(j));
        hashMap.put(ServerParam.PARAM_DDRIVER_APP_TIME, Long.valueOf(j2));
        hashMap.put("intvl_time", Long.valueOf(j3));
        trackEvent(i, "tech_saga_jscore_execute", hashMap);
    }

    public final String setEmpIfEmptyForPmTrace(String str) {
        if (TextUtils.isEmpty(str)) {
            return "emp";
        }
        if (str != null) {
            return str;
        }
        Intrinsics.throwNpe();
        return str;
    }

    public void traceReadFileError(int i, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("path", str2);
        hashMap.put("msg", str3);
        hashMap.put("pos", str);
        trackEvent(i, "tech_saga_read_file_error", hashMap);
    }

    public final void traceWebRequestBigImgWaring(String str, int i, int i2, long j, String str2, String str3, String str4, long j2, long j3, String str5, String str6) {
        Map hashMap = new HashMap();
        String str7 = str;
        hashMap.put("picture_type", str);
        hashMap.put("picture_width", Integer.valueOf(i));
        hashMap.put("picture_height", Integer.valueOf(i2));
        hashMap.put("picture_size", Long.valueOf(j));
        String str8 = str2;
        hashMap.put("main_frame", str2);
        String str9 = str3;
        hashMap.put("picture_link", str3);
        String str10 = str4;
        hashMap.put("cdn_headers", str4);
        hashMap.put("picture_dpi", Long.valueOf(j3));
        hashMap.put("picture_load_usetime", Long.valueOf(j2));
        hashMap.put("version", str5);
        hashMap.put("apollo_test", str6);
        trackEvent(-1, "chengxinyouxuan_store_performance_bigpicture_bt", hashMap);
    }

    public final void traceImageWebRequestFromCache(String str, int i, int i2, long j, String str2, String str3, long j2, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("picture_type", str);
        hashMap.put("picture_width", Integer.valueOf(i));
        hashMap.put("picture_height", Integer.valueOf(i2));
        hashMap.put("picture_size", Long.valueOf(j));
        hashMap.put("main_frame", str2);
        hashMap.put("picture_link", str3);
        hashMap.put("picture_dpi", Long.valueOf(j2));
        hashMap.put("version", str4);
        hashMap.put("apollo_test", str5);
        trackEvent(-1, "tech_saga_web_request_big_image_from_cache", hashMap);
    }

    public void traceV8Fatal(String str) {
        Map hashMap = new HashMap();
        hashMap.put("msg", str);
        trackEvent(-1, "tech_saga_v8_fatal", hashMap);
    }

    public void traceWebViewCrash(int i) {
        trackEvent(i, "tech_saga_webview_crash", new HashMap());
    }

    public void techSagaScreenBlankMonitorException() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        Intrinsics.checkExpressionValueIsNotNull(app, "Dimina.getConfig().app");
        Context context = app;
        Map hashMap = new HashMap();
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config2.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        hashMap.put("brand", adapterConfig.getWsgService().getBrand(context));
        Dimina.Config config3 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config3, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig2 = config3.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig2, "Dimina.getConfig().adapterConfig");
        hashMap.put(com.didichuxing.request.ServerParam.PARAM_OS_VERSION, adapterConfig2.getWsgService().getOsVersion(context));
        trackEvent(-1, "tech_cxyx_blank_monitor_exception", hashMap);
    }

    public void traceSagaWaitingTiming(int i, long j) {
        Map hashMap = new HashMap();
        hashMap.put("timing", Long.valueOf(j));
        trackEvent(i, "tech_saga_wating_timing", hashMap);
    }

    public void trackReportMiniProgramEvent(int i, JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "object");
        DMMina dMMina = DMMinaPool.get(i);
        if (dMMina != null) {
            String optString = jSONObject.optString("eventName");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            LogBase logBase = new LogBase(dMMina, optString);
            Iterator<String> it = null;
            if (optJSONObject != null) {
                it = optJSONObject.keys();
            }
            if (it == null) {
                LogTracker.trackEvent(logBase);
                return;
            }
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    Intrinsics.throwNpe();
                }
                if (optJSONObject == null) {
                    Intrinsics.throwNpe();
                }
                logBase.append(next, optJSONObject.opt(next));
            }
            LogTracker.trackEvent(logBase);
        }
    }

    public void traceD6WebkitSameLayerRenderEvent(String str, Map<String, ? extends Object> map) {
        trackEvent(-1, str, map);
    }

    public final void trackEvent(int i, String str, Map<String, ? extends Object> map) {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        TraceService traceService = adapterConfig.getTraceService();
        if (traceService != null) {
            traceService.trackEvent(DMMinaPool.get(i), str, map);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/TraceActionServiceImpl$Companion;", "", "()V", "AC", "", "AC_START", "DEV_MODE", "LAUNCH", "PKG", "TECH_SAGA_CORE_DOTTING", "TECH_SAGA_CORE_DOTTING_EVENT", "TECH_SAGA_CORE_DOTTING_INFO", "TECH_SAGA_SUB_PKG_EXEC", "USE_TIME", "costTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getCostTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCostTimeMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "mainPackageDownloadStartRemoteTime", "getMainPackageDownloadStartRemoteTime", "()J", "setMainPackageDownloadStartRemoteTime", "(J)V", "mainPackageDownloadStartTime", "getMainPackageDownloadStartTime", "setMainPackageDownloadStartTime", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TraceActionServiceImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getMainPackageDownloadStartTime() {
            return TraceActionServiceImpl.f17449b;
        }

        public final void setMainPackageDownloadStartTime(long j) {
            TraceActionServiceImpl.f17449b = j;
        }

        public final long getMainPackageDownloadStartRemoteTime() {
            return TraceActionServiceImpl.f17450c;
        }

        public final void setMainPackageDownloadStartRemoteTime(long j) {
            TraceActionServiceImpl.f17450c = j;
        }

        public final ConcurrentHashMap<String, Long> getCostTimeMap() {
            return TraceActionServiceImpl.f17451d;
        }

        public final void setCostTimeMap(ConcurrentHashMap<String, Long> concurrentHashMap) {
            Intrinsics.checkParameterIsNotNull(concurrentHashMap, "<set-?>");
            TraceActionServiceImpl.f17451d = concurrentHashMap;
        }
    }
}
