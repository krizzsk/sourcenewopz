package com.didi.soda.bill;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.manager.CreateOrderOmegaBuilder;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.PayMethodCardTraceModel;
import com.didi.soda.bill.model.datamodel.OutOfStockModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillSection;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/bill/BillOmegaHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillOmegaHelper.kt */
public final class BillOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004Jf\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000626\u0010\u0015\u001a2\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00180\u0017\u0012\u0004\u0012\u00020\u00040\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0011J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001f\u0010\"\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J1\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0011J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u000202J\u0015\u00104\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u0015\u00109\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u00106J\"\u0010:\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u0011J,\u0010<\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?J\u001a\u0010@\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J3\u0010A\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010B\u001a\u0004\u0018\u00010\u00112\b\u0010C\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010DJ=\u0010E\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010H\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0006J\u001a\u0010J\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010K\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J2\u0010L\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0011J)\u0010Q\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010RJ*\u0010S\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u0011J,\u0010U\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010W\u001a\u00020\u0011J,\u0010X\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010W\u001a\u00020\u0011J,\u0010Y\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010W\u001a\u00020\u0011J\u001a\u0010Z\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u0006J\"\u0010\\\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010]\u001a\u00020\u0011J\u001a\u0010^\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J)\u0010_\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010\u00062\b\u0010b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010RJ,\u0010c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010d\u001a\u00020\u0011J$\u0010e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J,\u0010f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00112\b\u0010g\u001a\u0004\u0018\u00010\u0006J3\u0010h\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010i\u001a\u0004\u0018\u00010?2\b\u0010d\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010jJ3\u0010k\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010l\u001a\u0004\u0018\u00010\u00112\b\u0010m\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010DJ3\u0010n\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u00112\b\u0010o\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010pJ.\u0010q\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010o\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010r\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010\u0006J\u0010\u0010s\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0010\u0010t\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J8\u0010u\u001a\u00020\u00042\b\u0010v\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010w\u001a\u0004\u0018\u00010\u00062\b\u0010x\u001a\u0004\u0018\u00010\u0006J\u0016\u0010y\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0011J\u000e\u0010z\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006J\u0016\u0010{\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0016\u0010}\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0010\u0010~\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0017\u0010\u0001\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0017\u0010\u0001\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0011J\u0007\u0010\u0001\u001a\u00020\u0004J\u0007\u0010\u0001\u001a\u00020\u0004J\u0007\u0010\u0001\u001a\u00020\u0004J\u0011\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001J \u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006JX\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010[\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0003\u0010\u0001JO\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0003\u0010\u0001J9\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0011¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010pJ4\u0010\u0001\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u0001\u001a\u00020-2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006J\u0011\u0010 \u0001\u001a\u00020\u00042\b\u0010¡\u0001\u001a\u00030\u0001J*\u0010¢\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010d\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010RJ\u001b\u0010£\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J*\u0010¤\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010d\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010RJ$\u0010¥\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0007\u0010m\u001a\u00030¦\u0001J$\u0010§\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0007\u0010¨\u0001\u001a\u00020-J\u000f\u0010©\u0001\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0011J-\u0010ª\u0001\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0007\u0010«\u0001\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020\u0011J,\u0010­\u0001\u001a\u00020\u00042\u0007\u0010®\u0001\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006¨\u0006¯\u0001"}, mo175978d2 = {"Lcom/didi/soda/bill/BillOmegaHelper$Companion;", "", "()V", "addCard", "", "cartId", "", "shopId", "bubble", "resourceId", "addressVerifySw", "billGlideContextError", "billPageSW", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "from", "infoType", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "traceId", "copyFunction", "Lkotlin/Function4;", "Ljava/util/ArrayList;", "", "clickAddPayPay", "clickArea", "context", "clickDuplicateOrder", "orderId", "type", "clickPayPay", "clickSecurityCheck", "action", "clickSecurityPage", "selectedWay", "(Ljava/lang/String;Ljava/lang/Integer;)V", "clickTopup", "confirmPayFail", "errorCode", "errorMsg", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "dialogShowTracker", "dialogType", "hasRemarkComponent", "", "onCouponReduceClose", "btnType", "onPayCallback", "paramBuilder", "Lcom/didi/soda/bill/manager/CreateOrderOmegaBuilder;", "onPayClick", "orderRecoveryTech", "eventType", "(Ljava/lang/Integer;)V", "orderTimeoutHasDataTech", "orderTimeoutNoDataBackTech", "orderTimeoutTech", "payTipDialogTrack", "key", "paymentClick", "payDiscountType", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "remarkDisableToastSw", "selectCard", "payMethod", "lastDigit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "showPayFail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "showSecurityCheck", "showSecurityPage", "checkWays", "toastShow", "traceBillOrderDetailTipsSW", "traceBillTipsFeeCK", "isManual", "tipFee", "", "tipFeeType", "traceCartAddressPromptSW", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "traceCartContentPopupSW", "contentType", "traceCartRecommendBubbleCK", "fromPage", "style", "traceCartRecommendBubbleCancel", "traceCartRecommendBubbleSW", "traceCartToastSW", "activityId", "traceDeliveryConfirmCK", "clickType", "traceDeliveryConfirmSW", "traceExperimentSW", "experimentName", "pageName", "userGroup", "traceGuideCashDialogCK", "buttonType", "traceGuideCashDialogSW", "traceMutualExclusionRuleCK", "itemId", "tracePayErrorGuideDialogCK", "selectedPayMethod", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;Ljava/lang/Integer;)V", "tracePayErrorGuideDialogSW", "payMethodType", "payMethodList", "tracePreMatchBlockCK", "userId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "tracePreMatchBlockSW", "traceRefundRuleBackCk", "traceRefundRuleBtnCk", "traceRefundRuleSW", "trackAddressCK", "aid", "buildingName", "houseNumber", "trackArrearsOrderInterceptCk", "trackArrearsOrderInterceptSw", "trackBillInfoError", "errorType", "trackBillInfoErrorV2", "trackBillPageClose", "trackBillTypeNotFound", "trackBillUpdateError", "trackBillUpdateErrorV2", "trackCPFCheckCK", "trackCPFCheckFailSW", "trackCPFCheckSW", "trackCPFToastSW", "trackCartRemarkCk", "model", "Lcom/didi/soda/bill/model/ComponentModel;", "trackCartRemarkConfirmCk", "remark", "trackCouponCK", "couponId", "batchId", "discount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "trackCouponPackageCK", "couponPrice", "couponNum", "isSelect", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "trackCouponPackageSW", "activity_id", "benefit_id", "cart_id", "payment_type", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "trackDeliveryCK", "trackDeliveryConfirmCK", "hasRemark", "(Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;)V", "trackGlobalCartItemCk", "trackOutOfStockCk", "componentModel", "trackOutOfStockConfirmCk", "trackOutOfStockPageSw", "trackOutOfStockSelectCk", "trackPayMethodSW", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/PayMethodListInfoEntity;", "trackPayPaySW", "isSign", "trackReminderShow", "trackTipsClick", "tipsNow", "tipsType", "uploadPayCallback", "isSuccess", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackBillPageClose(String str) {
            OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_RETURN_CK).build().track();
            OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
            if (str == null) {
                str = "";
            }
            create.addEventParam("from", str).build().track();
        }

        public final void traceExperimentSW(String str, String str2, Integer num) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_EXPERIMENT_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam(ParamConst.PARAM_EXPERIMENT_NAME, str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam(ParamConst.PARAM_PAGE_NAME, str2).addEventParam(ParamConst.PARAM_USER_GROUP, Integer.valueOf(ExtentionsKt.orZero(num))).build().track();
        }

        public final void trackReminderShow(int i) {
            OmegaTracker.Builder.create(EventConst.Bill.BILL_REMINDER_SHOW).addEventParam("event_type", Integer.valueOf(i)).build().track();
        }

        public final void trackAddressCK(String str, String str2, String str3, String str4, String str5) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_CHANGE_ADDRESS_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("aid", str);
            if (str3 == null) {
                str3 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str3);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("cart_id", str2);
            if (str4 == null) {
                str4 = "";
            }
            OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("building_number", str4);
            if (str5 == null) {
                str5 = "";
            }
            addEventParam4.addEventParam("user_fill_content", str5).build().track();
        }

        public final void addressVerifySw() {
            OmegaTracker.Builder.create(EventConst.Bill.EVENT_ADDRESS_VERIFY_SW).build().track();
        }

        public final void trackDeliveryCK(Integer num, String str, String str2, String str3) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_DELIVERY_METHOD_CK);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str2);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("cart_id", str);
            int i2 = 0;
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_DELIVERY_METHOD, Integer.valueOf(i));
            if (str3 != null) {
                if (str3.length() == 0) {
                    i2 = 1;
                }
            }
            addEventParam3.addEventParam(ParamConst.PARAM_HAS_REMARK, Integer.valueOf(1 ^ i2)).build().track();
        }

        public final void trackDeliveryConfirmCK(Integer num, boolean z, String str, String str2) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_DELIVERY_METHOD_CONFIRM_CK);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str2);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("cart_id", str);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            addEventParam2.addEventParam(ParamConst.PARAM_DELIVERY_METHOD, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_HAS_REMARK, Integer.valueOf(z ? 1 : 0)).build().track();
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void trackCouponCK(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.String r10, java.lang.String r11, java.lang.Integer r12) {
            /*
                r5 = this;
                r0 = 1
                java.lang.String r1 = "sailing_c_x_cart_voucher_ck"
                r2 = 0
                if (r12 != 0) goto L_0x0008
                goto L_0x0012
            L_0x0008:
                int r3 = r12.intValue()
                r4 = 9
                if (r3 != r4) goto L_0x0012
            L_0x0010:
                r12 = 0
                goto L_0x0023
            L_0x0012:
                r3 = 15
                if (r12 != 0) goto L_0x0017
                goto L_0x001f
            L_0x0017:
                int r12 = r12.intValue()
                if (r12 != r3) goto L_0x001f
                r12 = 1
                goto L_0x0023
            L_0x001f:
                java.lang.String r1 = "sailing_c_x_cart_discount_ck"
                goto L_0x0010
            L_0x0023:
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r1)
                java.lang.String r3 = ""
                if (r11 != 0) goto L_0x002c
                r11 = r3
            L_0x002c:
                java.lang.String r4 = "shop_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r1.addEventParam(r4, r11)
                if (r10 != 0) goto L_0x0036
                r10 = r3
            L_0x0036:
                java.lang.String r1 = "cart_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r10 = r11.addEventParam(r1, r10)
                if (r9 != 0) goto L_0x003f
                goto L_0x0043
            L_0x003f:
                int r2 = r9.intValue()
            L_0x0043:
                java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
                java.lang.String r11 = "discount_now"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r9 = r10.addEventParam(r11, r9)
                if (r8 != 0) goto L_0x0050
                r8 = r3
            L_0x0050:
                java.lang.String r10 = "activity_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r9.addEventParam(r10, r8)
                if (r7 != 0) goto L_0x0059
                r7 = r3
            L_0x0059:
                java.lang.String r9 = "max_batch_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r8.addEventParam(r9, r7)
                if (r6 != 0) goto L_0x0062
                r6 = r3
            L_0x0062:
                java.lang.String r8 = "coupon_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r7.addEventParam(r8, r6)
                if (r12 == 0) goto L_0x006c
                r0 = 101(0x65, float:1.42E-43)
            L_0x006c:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
                java.lang.String r8 = "coupon_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r6.addEventParam(r8, r7)
                com.didi.soda.customer.foundation.tracker.OmegaTracker r6 = r6.build()
                r6.track()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.BillOmegaHelper.Companion.trackCouponCK(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer):void");
        }

        public final void trackCouponPackageCK(String str, Integer num, Integer num2, Integer num3, String str2, String str3) {
            int i;
            int i2;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_COUPON_PACKAGE_CK);
            if (str3 == null) {
                str3 = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str3);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("cart_id", str2);
            int i3 = 0;
            if (num3 == null) {
                i = 0;
            } else {
                i = num3.intValue();
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_IS_SELECTED, Integer.valueOf(i));
            if (num == null) {
                i2 = 0;
            } else {
                i2 = num.intValue();
            }
            OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("amount", Integer.valueOf(i2));
            if (num2 != null) {
                i3 = num2.intValue();
            }
            OmegaTracker.Builder addEventParam5 = addEventParam4.addEventParam(ParamConst.PARAM_COUPON_NUM, Integer.valueOf(i3));
            if (str == null) {
                str = "";
            }
            addEventParam5.addEventParam("coupon_id", str).build().track();
        }

        public final void trackCouponPackageSW(Integer num, Integer num2, String str, Integer num3) {
            int i;
            int i2;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_COUPON_PACKAGE_SW);
            int i3 = 0;
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("activity_id", Integer.valueOf(i));
            if (num2 == null) {
                i2 = 0;
            } else {
                i2 = num2.intValue();
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_BENEFIT_ID, Integer.valueOf(i2));
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("cart_id", str);
            if (num3 != null) {
                i3 = num3.intValue();
            }
            addEventParam3.addEventParam("payment_type", Integer.valueOf(i3)).build().track();
        }

        public final void trackTipsClick(String str, String str2, int i, int i2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CLICK_TIPS);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam(ParamConst.PARAM_TIPS_NOW, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_TIPS_TYPE, Integer.valueOf(i2)).build().track();
        }

        public final void trackGlobalCartItemCk(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "shopId");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, BlocksConst.ACTION_PARAMS_ITEM_ID);
            OmegaTracker.Builder.create(EventConst.Bill.SAILING_C_X_CART_ITEM_CK).addEventParam("shop_id", str).addEventParam("cart_id", str2).addEventParam("item_id", str3).build().track();
        }

        public final void trackCartRemarkCk(ComponentModel componentModel) {
            Intrinsics.checkNotNullParameter(componentModel, "model");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.SAILING_C_X_CART_REMARK_CK);
            String shopId = componentModel.getShopId();
            String str = "";
            if (shopId == null) {
                shopId = str;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", shopId);
            String cartId = componentModel.getCartId();
            if (cartId == null) {
                cartId = str;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("cart_id", cartId);
            String content = componentModel.getContent();
            if (content != null) {
                str = content;
            }
            addEventParam2.addEventParam(ParamConst.PARAM_CART_REMARK, str).build().track();
        }

        public final void dialogShowTracker(int i) {
            OmegaTracker.Builder.create(EventConst.Bill.BILL_DIALOG_SHOW).addEventParam("event_type", Integer.valueOf(i)).build().track();
        }

        public final void trackCartRemarkConfirmCk(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "shopId");
            Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
            Intrinsics.checkNotNullParameter(str3, ParamConst.PARAM_CART_REMARK);
            OmegaTracker.Builder.create(EventConst.Bill.SAILING_C_X_CART_REMARK_COMFIRM_CK).addEventParam("shop_id", str).addEventParam("cart_id", str2).addEventParam(ParamConst.PARAM_CART_REMARK, str3).build().track();
        }

        public final void trackBillUpdateError(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_UPDATE_ERROR).addErrorType(ApiErrorUtil.Companion.getErrorType(str)).addErrorMsg(str2).addModuleName("bill").build().trackError();
        }

        public final void trackBillUpdateErrorV2(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_UPDATE_ERROR_V2).addErrorType(ApiErrorUtil.Companion.getErrorType(str)).addErrorMsg(str2).addModuleName("bill").build().trackError();
        }

        public final void trackBillInfoError(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_INFO_ERROR).addErrorType(ApiErrorUtil.Companion.getErrorType(str)).addErrorMsg(str2).addModuleName("bill").build().trackError();
        }

        public final void trackBillInfoErrorV2(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_INFO_ERROR_V2).addErrorType(ApiErrorUtil.Companion.getErrorType(str)).addErrorMsg(str2).addModuleName("bill").build().trackError();
        }

        public final void trackBillTypeNotFound(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            Intrinsics.checkNotNullParameter(str2, "errorMsg");
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_BILL_TYPE_NOT_FOUND).addErrorType(ApiErrorUtil.Companion.getErrorType(str)).addErrorMsg(str2).addModuleName("bill").build().trackError();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Removed duplicated region for block: B:171:0x03f6  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x03f8  */
        /* JADX WARNING: Removed duplicated region for block: B:174:0x03fd  */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x0407  */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x0409  */
        /* JADX WARNING: Removed duplicated region for block: B:180:0x040c  */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x040f  */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x043c  */
        /* JADX WARNING: Removed duplicated region for block: B:216:0x051b  */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x051d  */
        /* JADX WARNING: Removed duplicated region for block: B:220:0x054d  */
        /* JADX WARNING: Removed duplicated region for block: B:221:0x054f  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x056f  */
        /* JADX WARNING: Removed duplicated region for block: B:225:0x0571  */
        /* JADX WARNING: Removed duplicated region for block: B:228:0x057e  */
        /* JADX WARNING: Removed duplicated region for block: B:229:0x0580  */
        /* JADX WARNING: Removed duplicated region for block: B:232:0x05a9  */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x05ab  */
        /* JADX WARNING: Removed duplicated region for block: B:236:0x05b8  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x05ba  */
        /* JADX WARNING: Removed duplicated region for block: B:242:0x05c7  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x05c9  */
        /* JADX WARNING: Removed duplicated region for block: B:245:0x05cc  */
        /* JADX WARNING: Removed duplicated region for block: B:246:0x05ce  */
        /* JADX WARNING: Removed duplicated region for block: B:249:0x05db  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x05e2  */
        /* JADX WARNING: Removed duplicated region for block: B:254:0x05e7  */
        /* JADX WARNING: Removed duplicated region for block: B:257:0x05f5  */
        /* JADX WARNING: Removed duplicated region for block: B:258:0x05f7  */
        /* JADX WARNING: Removed duplicated region for block: B:260:0x0606  */
        /* JADX WARNING: Removed duplicated region for block: B:263:0x061a  */
        /* JADX WARNING: Removed duplicated region for block: B:266:0x0621  */
        /* JADX WARNING: Removed duplicated region for block: B:268:0x0626  */
        /* JADX WARNING: Removed duplicated region for block: B:271:0x0654  */
        /* JADX WARNING: Removed duplicated region for block: B:272:0x0656  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void billPageSW(com.didi.app.nova.skeleton.ScopeContext r46, java.lang.String r47, int r48, com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity r49, java.lang.String r50, kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>>, kotlin.Unit> r51) {
            /*
                r45 = this;
                r0 = r46
                r1 = r47
                r2 = r49
                r3 = r50
                r4 = r51
                java.lang.String r5 = "scopeContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
                java.lang.String r5 = "from"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
                java.lang.String r5 = "entity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
                java.lang.String r5 = "traceId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
                java.lang.String r5 = "copyFunction"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.List r7 = r49.getSections()
                java.lang.String r13 = ""
                if (r7 != 0) goto L_0x0062
                r0 = r13
                r7 = r0
                r10 = r7
                r11 = r10
                r12 = r11
                r14 = r12
                r8 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r26 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                r32 = 0
                r33 = 0
                r35 = 0
                r38 = 0
                r39 = 0
                goto L_0x0385
            L_0x0062:
                java.util.Iterator r7 = r7.iterator()
                r25 = r13
                r27 = r25
                r31 = r27
                r34 = r31
                r36 = r34
                r37 = r36
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r26 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                r32 = 0
                r33 = 0
                r35 = 0
                r38 = 0
                r39 = 0
            L_0x0095:
                boolean r40 = r7.hasNext()
                if (r40 == 0) goto L_0x0372
                java.lang.Object r40 = r7.next()
                com.didi.soda.customer.foundation.rpc.entity.bill.BillSection r40 = (com.didi.soda.customer.foundation.rpc.entity.bill.BillSection) r40
                java.util.ArrayList r40 = r40.getComponents()
                if (r40 != 0) goto L_0x00ac
                r44 = r7
                r10 = 1
                goto L_0x036e
            L_0x00ac:
                java.util.Iterator r40 = r40.iterator()
            L_0x00b0:
                boolean r41 = r40.hasNext()
                if (r41 == 0) goto L_0x0367
                java.lang.Object r41 = r40.next()
                com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity r41 = (com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity) r41
                com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity r42 = r41.getData()
                if (r42 != 0) goto L_0x00c7
            L_0x00c2:
                r44 = r7
            L_0x00c4:
                r10 = 1
                goto L_0x0363
            L_0x00c7:
                int r43 = r41.getType()
                java.lang.String r8 = "price"
                switch(r43) {
                    case 2: goto L_0x0347;
                    case 3: goto L_0x031e;
                    case 4: goto L_0x02ed;
                    case 5: goto L_0x01e7;
                    case 6: goto L_0x01b5;
                    case 7: goto L_0x01a4;
                    case 8: goto L_0x00d1;
                    case 9: goto L_0x017b;
                    case 10: goto L_0x0155;
                    case 11: goto L_0x013e;
                    case 12: goto L_0x00d1;
                    case 13: goto L_0x00d1;
                    case 14: goto L_0x00d1;
                    case 15: goto L_0x0115;
                    case 16: goto L_0x00d1;
                    case 17: goto L_0x00d1;
                    case 18: goto L_0x00d8;
                    default: goto L_0x00d1;
                }
            L_0x00d1:
                r44 = r7
                r10 = 1
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                goto L_0x0363
            L_0x00d8:
                com.didi.soda.customer.foundation.rpc.entity.address.CetaEntity r8 = r42.getCetaInfo()
                if (r8 != 0) goto L_0x00e0
                r8 = 0
                goto L_0x00e4
            L_0x00e0:
                java.lang.String r8 = r8.getContent()
            L_0x00e4:
                if (r8 == 0) goto L_0x00e9
                r36 = r8
                goto L_0x00eb
            L_0x00e9:
                r36 = r13
            L_0x00eb:
                com.didi.soda.customer.foundation.rpc.entity.address.CetaEntity r8 = r42.getCetaInfo()
                if (r8 != 0) goto L_0x00f3
                r8 = 0
                goto L_0x00f7
            L_0x00f3:
                java.lang.String r8 = r8.getReasonCode()
            L_0x00f7:
                if (r8 == 0) goto L_0x00fc
                r37 = r8
                goto L_0x00fe
            L_0x00fc:
                r37 = r13
            L_0x00fe:
                com.didi.soda.customer.foundation.rpc.entity.address.CetaEntity r8 = r42.getCetaInfo()
                if (r8 != 0) goto L_0x0106
                r8 = 0
                goto L_0x010e
            L_0x0106:
                int r8 = r8.getRangeType()
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            L_0x010e:
                int r39 = com.didi.soda.customer.foundation.util.ExtentionsKt.orZero((java.lang.Integer) r8)
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                goto L_0x00c2
            L_0x0115:
                com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo r8 = r42.getPriceInfo()
                if (r8 != 0) goto L_0x011d
                r8 = 0
                goto L_0x0121
            L_0x011d:
                int r8 = r8.getPayPrice()
            L_0x0121:
                com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity r9 = r42.getCouponInfo()
                if (r9 != 0) goto L_0x012a
            L_0x0127:
                r34 = r13
                goto L_0x0133
            L_0x012a:
                java.lang.String r9 = r9.getCouponId()
                if (r9 != 0) goto L_0x0131
                goto L_0x0127
            L_0x0131:
                r34 = r9
            L_0x0133:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                r44 = r7
                r17 = r8
                r10 = 1
                r33 = 1
                goto L_0x0363
            L_0x013e:
                com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity r8 = r42.getFollowingInfo()
                if (r8 != 0) goto L_0x0146
                goto L_0x00c2
            L_0x0146:
                int r8 = r8.isSelected
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                r44 = r7
                r29 = r8
                r10 = 1
                r28 = 1
                goto L_0x0363
            L_0x0155:
                com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity r8 = r42.getCouponInfo()
                if (r8 != 0) goto L_0x015e
            L_0x015b:
                r25 = r13
                goto L_0x0167
            L_0x015e:
                java.lang.String r8 = r8.getBatchId()
                if (r8 != 0) goto L_0x0165
                goto L_0x015b
            L_0x0165:
                r25 = r8
            L_0x0167:
                com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo r8 = r42.getPriceInfo()
                if (r8 != 0) goto L_0x016f
                r8 = 0
                goto L_0x0173
            L_0x016f:
                int r8 = r8.getPayPrice()
            L_0x0173:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                r44 = r7
                r16 = r8
                goto L_0x00c4
            L_0x017b:
                com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity r8 = r42.getCouponInfo()
                if (r8 != 0) goto L_0x0183
                r8 = 0
                goto L_0x0187
            L_0x0183:
                java.lang.String r8 = r8.getBatchId()
            L_0x0187:
                if (r8 == 0) goto L_0x018c
                r31 = r8
                goto L_0x018e
            L_0x018c:
                r31 = r13
            L_0x018e:
                com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo r8 = r42.getPriceInfo()
                if (r8 != 0) goto L_0x0196
                r8 = 0
                goto L_0x019a
            L_0x0196:
                int r8 = r8.getPayPrice()
            L_0x019a:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                r44 = r7
                r15 = r8
                r10 = 1
                r32 = 1
                goto L_0x0363
            L_0x01a4:
                com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r8 = r42.getTipFeeInfo()
                if (r8 != 0) goto L_0x01ad
                r23 = 0
                goto L_0x01b1
            L_0x01ad:
                long r8 = r8.tipPayValue
                r23 = r8
            L_0x01b1:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                goto L_0x00c2
            L_0x01b5:
                java.util.HashMap r9 = new java.util.HashMap
                r9.<init>()
                r11 = r9
                java.util.Map r11 = (java.util.Map) r11
                int r41 = r41.getComponentId()
                java.lang.Integer r14 = java.lang.Integer.valueOf(r41)
                java.lang.String r10 = "price_id"
                r11.put(r10, r14)
                com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo r10 = r42.getPriceInfo()
                if (r10 != 0) goto L_0x01d3
                r10 = 0
                goto L_0x01d7
            L_0x01d3:
                int r10 = r10.getPayPrice()
            L_0x01d7:
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                r11.put(r8, r10)
                boolean r8 = r6.add(r9)
                java.lang.Boolean.valueOf(r8)
                goto L_0x00c2
            L_0x01e7:
                com.didi.soda.customer.foundation.rpc.entity.bill.BillCartItemsInfo r9 = r42.getItemsInfo()
                if (r9 != 0) goto L_0x01ef
                goto L_0x00c2
            L_0x01ef:
                java.lang.String r10 = r9.getShopName()
                if (r10 != 0) goto L_0x01f8
                r27 = r13
                goto L_0x01fa
            L_0x01f8:
                r27 = r10
            L_0x01fa:
                java.util.ArrayList r10 = r9.getItems()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
                java.util.Iterator r10 = r10.iterator()
            L_0x0205:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x02e5
                java.lang.Object r11 = r10.next()
                com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity r11 = (com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity) r11
                com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity r14 = r11.getActRules()
                if (r14 != 0) goto L_0x0218
                goto L_0x021f
            L_0x0218:
                int r14 = r22 + 1
                java.lang.Integer.valueOf(r22)
                r22 = r14
            L_0x021f:
                java.util.HashMap r14 = new java.util.HashMap
                r14.<init>()
                int r41 = r11.getAmount()
                int r20 = r20 + r41
                int r41 = r11.getPrice()
                int r21 = r21 + r41
                r12 = r14
                java.util.Map r12 = (java.util.Map) r12
                r44 = r7
                java.lang.String r7 = r11.getItemId()
                r41 = r10
                java.lang.String r10 = "item_id"
                r12.put(r10, r7)
                int r7 = r11.getAmount()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r10 = "item_count"
                r12.put(r10, r7)
                java.lang.String r7 = r11.getHeadImg()
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                if (r7 == 0) goto L_0x025e
                int r7 = r7.length()
                if (r7 != 0) goto L_0x025c
                goto L_0x025e
            L_0x025c:
                r7 = 0
                goto L_0x025f
            L_0x025e:
                r7 = 1
            L_0x025f:
                r10 = 1
                r7 = r7 ^ r10
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r10 = "has_image"
                r12.put(r10, r7)
                int r7 = r11.getPrice()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r12.put(r8, r7)
                int r7 = r11.getMduType()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r10 = "item_type"
                r12.put(r10, r7)
                int r7 = r11.getSpecialPrice()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r10 = "discount_price"
                r12.put(r10, r7)
                int r7 = r11.getActivityType()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r10 = "activity_type"
                r12.put(r10, r7)
                int r7 = r11.getTyingItemsFlag()
                r10 = 1
                if (r7 == r10) goto L_0x02ae
                int r7 = r11.getTyingItemsFlag()
                r10 = 2
                if (r7 != r10) goto L_0x02ab
                goto L_0x02af
            L_0x02ab:
                java.lang.String r7 = "0"
                goto L_0x02b1
            L_0x02ae:
                r10 = 2
            L_0x02af:
                java.lang.String r7 = "1"
            L_0x02b1:
                java.lang.String r10 = "is_item_merge"
                r12.put(r10, r7)
                java.lang.String r7 = r9.getShopId()
                if (r7 != 0) goto L_0x02bd
                goto L_0x02dc
            L_0x02bd:
                com.didi.soda.cart.omega.CartGuideDataManager$Companion r10 = com.didi.soda.cart.omega.CartGuideDataManager.Companion
                com.didi.soda.cart.omega.CartGuideDataManager r10 = r10.getInstance()
                java.lang.String r11 = r11.getItemId()
                com.didi.soda.cart.model.CartGuideModel r7 = r10.getCartGuideParams(r7, r11)
                if (r7 != 0) goto L_0x02ce
                goto L_0x02dc
            L_0x02ce:
                java.util.Map r7 = r7.getGuideParams()
                if (r7 != 0) goto L_0x02d5
                goto L_0x02dc
            L_0x02d5:
                r14.putAll(r7)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
            L_0x02dc:
                r5.add(r14)
                r10 = r41
                r7 = r44
                goto L_0x0205
            L_0x02e5:
                r44 = r7
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                goto L_0x00c4
            L_0x02ed:
                r44 = r7
                int r38 = r41.getHintType()
                com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r7 = r42.getPayChannel()
                if (r7 != 0) goto L_0x02fc
                r26 = 0
                goto L_0x0300
            L_0x02fc:
                int r7 = r7.channelId
                r26 = r7
            L_0x0300:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r26)
                java.lang.String r8 = "bill_payment_method_payment_type"
                r0.attach(r8, r7)
                com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r7 = r42.getPayChannel()
                if (r7 != 0) goto L_0x0312
            L_0x030f:
                r35 = 0
                goto L_0x031a
            L_0x0312:
                int r7 = r7.channelId
                r8 = 120(0x78, float:1.68E-43)
                if (r7 != r8) goto L_0x030f
                r35 = 1
            L_0x031a:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                goto L_0x00c4
            L_0x031e:
                r44 = r7
                java.util.ArrayList r7 = r42.getDeliveryMethods()
                if (r7 != 0) goto L_0x0328
                goto L_0x00c4
            L_0x0328:
                java.util.Iterator r7 = r7.iterator()
            L_0x032c:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x0341
                java.lang.Object r8 = r7.next()
                com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity r8 = (com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity) r8
                int r9 = r8.isSelected
                r10 = 1
                if (r9 != r10) goto L_0x032c
                int r7 = r8.type
                r30 = r7
            L_0x0341:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                goto L_0x00c4
            L_0x0347:
                r44 = r7
                com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r7 = r42.getRecAddress()
                if (r7 == 0) goto L_0x0352
                r18 = 1
                goto L_0x0354
            L_0x0352:
                r18 = 0
            L_0x0354:
                java.lang.Boolean r7 = r42.getHasAdsorb()
                r10 = 1
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r10)
                boolean r19 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
            L_0x0363:
                r7 = r44
                goto L_0x00b0
            L_0x0367:
                r44 = r7
                r10 = 1
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
            L_0x036e:
                r7 = r44
                goto L_0x0095
            L_0x0372:
                r10 = 1
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r8 = r23
                r0 = r25
                r7 = r27
                r11 = r31
                r12 = r34
                r14 = r36
                r10 = r37
            L_0x0385:
                android.content.Context r23 = com.didi.soda.customer.app.GlobalContext.getContext()
                if (r23 == 0) goto L_0x0699
                android.app.Activity r23 = (android.app.Activity) r23
                boolean r23 = com.didi.soda.customer.foundation.util.LocationUtil.hasLocationPermission(r23)
                if (r23 != 0) goto L_0x0398
                r24 = r13
                r23 = 1
                goto L_0x03a7
            L_0x0398:
                boolean r23 = com.didi.soda.customer.foundation.util.LocationUtil.hasValidLocation()
                if (r23 == 0) goto L_0x03a3
                r23 = 3
                r24 = r13
                goto L_0x03a7
            L_0x03a3:
                r24 = r13
                r23 = 2
            L_0x03a7:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r16)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
                r16 = r10
                java.lang.Integer r10 = java.lang.Integer.valueOf(r17)
                r4.invoke(r13, r2, r10, r6)
                java.lang.Class<com.didi.soda.manager.base.ICustomerAddressManager> r2 = com.didi.soda.manager.base.ICustomerAddressManager.class
                com.didi.soda.manager.base.ICustomerManager r2 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r2)
                com.didi.soda.manager.base.ICustomerAddressManager r2 = (com.didi.soda.manager.base.ICustomerAddressManager) r2
                com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r2 = r2.getDelieveryAddress()
                java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r4 = com.didi.soda.manager.base.ICustomerBillManager.class
                com.didi.soda.manager.base.ICustomerManager r4 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r4)
                com.didi.soda.manager.base.ICustomerBillManager r4 = (com.didi.soda.manager.base.ICustomerBillManager) r4
                com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r4 = r4.getCurrentContact()
                if (r4 != 0) goto L_0x03d4
                r10 = 0
                goto L_0x03d8
            L_0x03d4:
                java.lang.String r10 = r4.getFirstName()
            L_0x03d8:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                boolean r10 = android.text.TextUtils.isEmpty(r10)
                if (r10 == 0) goto L_0x03f3
                if (r4 != 0) goto L_0x03e4
                r10 = 0
                goto L_0x03e8
            L_0x03e4:
                java.lang.String r10 = r4.getLastName()
            L_0x03e8:
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                boolean r10 = android.text.TextUtils.isEmpty(r10)
                if (r10 != 0) goto L_0x03f1
                goto L_0x03f3
            L_0x03f1:
                r10 = 0
                goto L_0x03f4
            L_0x03f3:
                r10 = 1
            L_0x03f4:
                if (r2 != 0) goto L_0x03f8
                r13 = 0
                goto L_0x03fa
            L_0x03f8:
                java.lang.String r13 = r2.aid
            L_0x03fa:
                if (r13 == 0) goto L_0x03fd
                goto L_0x03ff
            L_0x03fd:
                r13 = r24
            L_0x03ff:
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                int r13 = r13.length()
                if (r13 != 0) goto L_0x0409
                r13 = 1
                goto L_0x040a
            L_0x0409:
                r13 = 0
            L_0x040a:
                if (r13 == 0) goto L_0x040f
                r13 = 8
                goto L_0x0427
            L_0x040f:
                if (r18 == 0) goto L_0x0413
                r13 = 7
                goto L_0x0427
            L_0x0413:
                if (r19 == 0) goto L_0x0417
                r13 = 6
                goto L_0x0427
            L_0x0417:
                java.lang.Class<com.didi.soda.manager.base.ICustomerAddressManager> r13 = com.didi.soda.manager.base.ICustomerAddressManager.class
                com.didi.soda.manager.base.ICustomerManager r13 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r13)
                com.didi.soda.manager.base.ICustomerAddressManager r13 = (com.didi.soda.manager.base.ICustomerAddressManager) r13
                if (r13 != 0) goto L_0x0423
                r13 = 0
                goto L_0x0427
            L_0x0423:
                int r13 = r13.getSenceOfSelectedAddress()
            L_0x0427:
                java.lang.String r18 = "sailing_c_x_cart_common_sw"
                r19 = r14
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r14 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r18)
                java.lang.String r3 = "from_page"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r14.addEventParam(r3, r1)
                java.lang.String r3 = r49.getCartId()
                if (r3 != 0) goto L_0x043e
                r3 = r24
            L_0x043e:
                java.lang.String r14 = "cart_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r14, r3)
                java.lang.Integer r3 = java.lang.Integer.valueOf(r48)
                java.lang.String r14 = "cart_info_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r14, r3)
                java.lang.String r3 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r5)
                java.lang.String r5 = "list"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r3)
                if (r2 != 0) goto L_0x045d
            L_0x045a:
                r3 = r24
                goto L_0x0467
            L_0x045d:
                com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r3 = r2.poi
                if (r3 != 0) goto L_0x0462
                goto L_0x045a
            L_0x0462:
                java.lang.String r3 = r3.poiId
                if (r3 != 0) goto L_0x0467
                goto L_0x045a
            L_0x0467:
                java.lang.String r5 = "poi_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r3)
                if (r2 != 0) goto L_0x0473
            L_0x0470:
                r3 = r24
                goto L_0x0478
            L_0x0473:
                java.lang.String r3 = r2.aid
                if (r3 != 0) goto L_0x0478
                goto L_0x0470
            L_0x0478:
                java.lang.String r5 = "aid"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r5, r3)
                if (r4 != 0) goto L_0x0483
            L_0x0480:
                r3 = r24
                goto L_0x0488
            L_0x0483:
                java.lang.String r3 = r4.phone
                if (r3 != 0) goto L_0x0488
                goto L_0x0480
            L_0x0488:
                java.lang.String r4 = "contact_phone"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r3 = r49.getShopInfo()
                if (r3 != 0) goto L_0x0497
            L_0x0494:
                r3 = r24
                goto L_0x049e
            L_0x0497:
                java.lang.String r3 = r3.getShopId()
                if (r3 != 0) goto L_0x049e
                goto L_0x0494
            L_0x049e:
                java.lang.String r4 = "shop_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
                java.lang.String r4 = "item_num"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
                java.lang.String r4 = "subtotal"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                java.lang.Long r3 = java.lang.Long.valueOf(r8)
                java.lang.String r4 = "tips"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                java.lang.String r3 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r6)
                java.lang.String r4 = "price_list"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                int r3 = r6.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = "price_item_count"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                int r3 = r49.getPriceSumOri()
                int r4 = r49.getRealPayPrice()
                int r3 = r3 - r4
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r4 = "discount"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r3)
                java.lang.String r3 = "max_batch_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r1.addEventParam(r3, r0)
                int r1 = r49.getRealPayPrice()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "total"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
                java.lang.String r3 = "payment_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.String r1 = "shop_name"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r7)
                if (r2 != 0) goto L_0x051d
                r1 = 0
                goto L_0x051f
            L_0x051d:
                int r1 = r2.type
            L_0x051f:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "address_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r28)
                java.lang.String r3 = "has_coupon_package"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r29)
                java.lang.String r3 = "is_selected"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r3 = "has_username"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo r1 = r49.getShopInfo()
                if (r1 != 0) goto L_0x054f
                r1 = 0
                goto L_0x0553
            L_0x054f:
                int r1 = r1.getDeliveryType()
            L_0x0553:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r3 = "delivery_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r30)
                java.lang.String r3 = "delivery_method"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.String r1 = "merchant_max_batch_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r11)
                if (r32 == 0) goto L_0x0571
                r10 = 1
                goto L_0x0572
            L_0x0571:
                r10 = 2
            L_0x0572:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r3 = "is_merchant_coupon"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                if (r33 == 0) goto L_0x0580
                r10 = 1
                goto L_0x0581
            L_0x0580:
                r10 = 2
            L_0x0581:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r3 = "is_r_coupon"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
                java.lang.String r3 = "r_coupon_amount"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.String r1 = "r_coupon_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r12)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
                java.lang.String r3 = "merchant_coupon_amount"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                if (r35 == 0) goto L_0x05ab
                r10 = 2
                goto L_0x05ac
            L_0x05ab:
                r10 = 1
            L_0x05ac:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r3 = "is_wallet_recommed"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                if (r2 != 0) goto L_0x05ba
                r1 = 0
                goto L_0x05bc
            L_0x05ba:
                java.lang.String r1 = r2.aid
            L_0x05bc:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x05c9
                int r1 = r1.length()
                if (r1 != 0) goto L_0x05c7
                goto L_0x05c9
            L_0x05c7:
                r14 = 0
                goto L_0x05ca
            L_0x05c9:
                r14 = 1
            L_0x05ca:
                if (r14 == 0) goto L_0x05ce
                r10 = 1
                goto L_0x05cf
            L_0x05ce:
                r10 = 2
            L_0x05cf:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r3 = "address_poi_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                if (r2 != 0) goto L_0x05dd
            L_0x05db:
                r1 = 0
                goto L_0x05e4
            L_0x05dd:
                com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r2.poi
                if (r1 != 0) goto L_0x05e2
                goto L_0x05db
            L_0x05e2:
                java.lang.String r1 = r1.displayName
            L_0x05e4:
                if (r1 == 0) goto L_0x05e7
                goto L_0x05e9
            L_0x05e7:
                r1 = r24
            L_0x05e9:
                java.lang.String r3 = "address_detail"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                com.didichuxing.bigdata.dp.locsdk.ErrInfo r1 = com.didi.soda.customer.foundation.util.LocationUtil.getErrorInfo()
                if (r1 != 0) goto L_0x05f7
                r1 = 0
                goto L_0x0603
            L_0x05f7:
                int r1 = r1.getErrNo()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r1 = r1.toString()
            L_0x0603:
                if (r1 == 0) goto L_0x0606
                goto L_0x0608
            L_0x0606:
                r1 = r24
            L_0x0608:
                java.lang.String r3 = "location_error_code"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r23)
                java.lang.String r3 = "is_location"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r1)
                if (r2 != 0) goto L_0x061c
            L_0x061a:
                r11 = 0
                goto L_0x0623
            L_0x061c:
                com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r2.poi
                if (r1 != 0) goto L_0x0621
                goto L_0x061a
            L_0x0621:
                java.lang.String r11 = r1.poiType
            L_0x0623:
                if (r11 == 0) goto L_0x0626
                goto L_0x0628
            L_0x0626:
                r11 = r24
            L_0x0628:
                java.lang.String r1 = "poi_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r11)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
                java.lang.String r2 = "address_scene"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r2, r1)
                java.lang.String r1 = "trace_id"
                r2 = r50
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r2)
                java.lang.String r1 = "ceta_info"
                r13 = r19
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r13)
                java.lang.String r1 = "ceta_msg_code"
                r13 = r16
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r13)
                if (r22 <= 0) goto L_0x0656
                r10 = 1
                goto L_0x0657
            L_0x0656:
                r10 = 2
            L_0x0657:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
                java.lang.String r2 = "is_mutex_ruler"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r2, r1)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r38)
                java.lang.String r2 = "pay_discount_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r2, r1)
                java.lang.String r1 = "pub_biz_line"
                java.lang.String r2 = "fin"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r2)
                r1 = r45
                r2 = r49
                boolean r2 = r1.hasRemarkComponent(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.String r3 = "is_shop_remark"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r39)
                java.lang.String r3 = "ceta_range_type"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r3, r2)
                com.didi.soda.customer.foundation.tracker.OmegaTracker r0 = r0.build()
                r0.track()
                return
            L_0x0699:
                r1 = r45
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r2 = "null cannot be cast to non-null type android.app.Activity"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.BillOmegaHelper.Companion.billPageSW(com.didi.app.nova.skeleton.ScopeContext, java.lang.String, int, com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity, java.lang.String, kotlin.jvm.functions.Function4):void");
        }

        private final boolean hasRemarkComponent(BillInfoEntity billInfoEntity) {
            List<BillSection> sections = billInfoEntity.getSections();
            if (sections == null) {
                return false;
            }
            Collection arrayList = new ArrayList();
            for (BillSection components : sections) {
                ArrayList<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    arrayList.add(components2);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (ArrayList addAll : (List) arrayList) {
                CollectionsKt.addAll(arrayList2, addAll);
            }
            for (BillComponentEntity type : (List) arrayList2) {
                if (8 == type.getType()) {
                    return true;
                }
            }
            return false;
        }

        public final void paymentClick(String str, String str2, int i, PayChannelEntity payChannelEntity) {
            int i2;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_PAYMENT);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (payChannelEntity == null) {
                i2 = -1;
            } else {
                i2 = payChannelEntity.channelId;
            }
            addEventParam2.addEventParam("pay_method", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_DISCOUNT_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN).build().track();
        }

        public final void remarkDisableToastSw(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_REMARK_DISABLE_TOAST);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void selectCard(String str, String str2, Integer num, String str3) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_SELECT_PAYMETHOD);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("pay_method", Integer.valueOf(i));
            Object obj = str3;
            if (str3 == null) {
                obj = 0;
            }
            addEventParam3.addEventParam(ParamConst.PARAM_CARD_LAST_DIGIT, obj).build().track();
        }

        public final void clickTopup(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_CLICK_99_PAY_TOP_UP);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam(ParamConst.PARAM_99_PAY_RECHARGE_TYPE, 1).build().track();
        }

        public final void trackPayPaySW(String str, String str2, boolean z) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(z ? EventConst.Pay.EVENT_CLICK_PAY_PAY_SW : EventConst.Pay.EVENT_CLICK_ADD_PAY_PAY_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void trackPayMethodSW(String str, String str2, PayMethodListInfoEntity payMethodListInfoEntity) {
            int i;
            Object obj;
            Intrinsics.checkNotNullParameter(payMethodListInfoEntity, "payMethodList");
            int i2 = 0;
            try {
                Intrinsics.checkNotNull(str2);
                i = Integer.parseInt(str2);
            } catch (Exception unused) {
                i = 0;
            }
            List arrayList = new ArrayList();
            List<PayMethodListInfoEntity.PayMethodInfo> list = payMethodListInfoEntity.payments;
            if (list != null) {
                Collection arrayList2 = new ArrayList();
                for (PayMethodListInfoEntity.PayMethodInfo payMethodInfo : list) {
                    if (Intrinsics.areEqual((Object) "150", (Object) payMethodInfo.channelId)) {
                        if (!StringUtils.isEmpty(payMethodInfo.tip)) {
                            i2 = 1;
                        }
                        List<PayMethodListInfoEntity.PayMethodInfo.CardInfo> list2 = payMethodInfo.extraInfoList;
                        if (list2 == null) {
                            obj = null;
                        } else {
                            for (PayMethodListInfoEntity.PayMethodInfo.CardInfo cardInfo : list2) {
                                Intrinsics.checkNotNullExpressionValue(cardInfo, "cardModel");
                                arrayList.add(new PayMethodCardTraceModel(cardInfo));
                            }
                            obj = Unit.INSTANCE;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(payMethodInfo, "it");
                        obj = Boolean.valueOf(arrayList.add(new PayMethodCardTraceModel(payMethodInfo)));
                    }
                    if (obj != null) {
                        arrayList2.add(obj);
                    }
                }
                List list3 = (List) arrayList2;
            }
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_SELECT_CARD_SW);
            String str3 = "";
            if (str == null) {
                str = str3;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_HAS_PAY_BUBBLE, Integer.valueOf(i2));
            String json = GsonUtil.toJson(arrayList);
            if (json != null) {
                str3 = json;
            }
            addEventParam.addEventParam(ParamConst.PARAM_PAY_METHOD_LIST_V2, str3).addEventParam(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN).build().track();
        }

        public final void clickAddPayPay(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_CLICK_ADD_PAY_PAY);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void clickPayPay(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_CLICK_PAY_PAY);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void addCard(String str, String str2, String str3, String str4) {
            int i;
            try {
                Intrinsics.checkNotNull(str4);
                i = Integer.parseInt(str4);
            } catch (Exception unused) {
                i = 0;
            }
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Pay.EVENT_CLICK_ADD_PAYCARD);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam(ParamConst.PARAM_HAS_PAY_BUBBLE, Integer.valueOf(StringUtils.isEmpty(str3) ^ true ? 1 : 0)).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN).build().track();
        }

        public final void showSecurityCheck(String str) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Security.SAILING_C_X_CHECK_WINDOW_SW);
            if (str == null) {
                str = "";
            }
            create.addEventParam("cart_id", str).build().track();
        }

        public final void clickSecurityCheck(int i, String str) {
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Security.SAILING_C_X_CHECK_WINDOW_CK).addEventParam("action", Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            addEventParam.addEventParam("cart_id", str).build().track();
        }

        public final void showSecurityPage(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Security.SAILING_C_X_SECURITYCHECK_COMMON_SW);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam(ParamConst.PARAM_CHECK_WAYS, str2);
            if (str == null) {
                str = "";
            }
            addEventParam.addEventParam("cart_id", str).build().track();
        }

        public final void clickSecurityPage(String str, Integer num) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Security.SAILING_C_X_SECURITYCHECK_SELECT_CK);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            OmegaTracker.Builder addEventParam = create.addEventParam(ParamConst.PARAM_SELECTED_WAY, Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            addEventParam.addEventParam("cart_id", str).build().track();
        }

        public final void clickDuplicateOrder(String str, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_PAY_DUPLICATE_CONFIRM_CK);
            if (str == null) {
                str = "";
            }
            create.addEventParam(ParamConst.PARAM_PROCESSING_ORDER_ID, str).addEventParam("event_type", Integer.valueOf(i)).build().track();
        }

        public final void uploadPayCallback(int i, int i2, String str, String str2) {
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_PAY_RESULT).addEventParam("is_suc", Integer.valueOf(i)).addEventParam("error_code", Integer.valueOf(i2));
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("error_msg", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam2.addEventParam("order_id", str2).build().track();
        }

        public final void confirmPayFail(int i, String str, String str2, Integer num) {
            int i2;
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_PAY_FAIL_CHANGE).addEventParam("error_code", Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("error_msg", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("order_id", str2);
            if (num == null) {
                i2 = 0;
            } else {
                i2 = num.intValue();
            }
            addEventParam3.addEventParam("from", Integer.valueOf(i2)).build().track();
        }

        public final void onPayClick(CreateOrderOmegaBuilder createOrderOmegaBuilder) {
            Intrinsics.checkNotNullParameter(createOrderOmegaBuilder, "paramBuilder");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_PAY).addAllEventParam(createOrderOmegaBuilder.build()).build().track();
        }

        public final void onPayCallback(CreateOrderOmegaBuilder createOrderOmegaBuilder) {
            Intrinsics.checkNotNullParameter(createOrderOmegaBuilder, "paramBuilder");
            OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_PAY_CREAT_ORDER_RESULT).addAllEventParam(createOrderOmegaBuilder.build()).build().track();
        }

        public final void showPayFail(String str, String str2, Integer num, String str3, Integer num2) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_SHOW_PAY_FAIL);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("order_id", str2);
            int i2 = 0;
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("error_code", Integer.valueOf(i));
            if (str3 == null) {
                str3 = "";
            }
            OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("error_msg", str3);
            if (num2 != null) {
                i2 = num2.intValue();
            }
            addEventParam4.addEventParam("from", Integer.valueOf(i2)).build().track();
        }

        public final void clickArea(String str, ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(scopeContext, "context");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_CLICK_CONTACT_AREACODE, scopeContext);
            if (str == null) {
                str = "";
            }
            create.addEventParam("cart_id", str).build().track();
        }

        public final void payTipDialogTrack(String str, ScopeContext scopeContext, int i) {
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNull(scopeContext);
            OmegaTracker.Builder create = OmegaTracker.Builder.create(str, scopeContext);
            if (i > 0) {
                create.addEventParam(ParamConst.PARAM_CLICK_AREA_TYPE, Integer.valueOf(i));
            }
            create.build().track();
        }

        public final void orderTimeoutTech(Integer num) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_ORDER_TIMEOUT_TECH);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            create.addEventParam("event_type", Integer.valueOf(i)).build().track();
        }

        public final void orderTimeoutNoDataBackTech() {
            OmegaTracker.Builder.create(EventConst.Bill.BILL_ORDER_TIMEOUT_BACK_NO_DATA_TECH).build().track();
        }

        public final void orderRecoveryTech(Integer num) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_ORDER_RECOVERY_TECH);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            create.addEventParam("event_type", Integer.valueOf(i)).build().track();
        }

        public final void toastShow(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_ORDER_RECOVERY_FAIL_TOAST_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("shop_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("cart_id", str2).build().track();
        }

        public final void orderTimeoutHasDataTech() {
            OmegaTracker.Builder.create(EventConst.Bill.BILL_ORDER_TIMEOUT_HAS_DATA_TECH).build().track();
        }

        public final void onCouponReduceClose(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "shopId");
            OmegaTracker.Builder.create(EventConst.Business.SHOP_HEADER_COUPON_REDUCE_CLOSE_CK).addEventParam("shop_id", str).addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void trackArrearsOrderInterceptSw(String str) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            OmegaTracker.Builder.create(EventConst.Bill.EVENT_ARREARS_ORDER_INTERCEPT_SW).addEventParam("order_id", str).build().track();
        }

        public final void trackArrearsOrderInterceptCk(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            OmegaTracker.Builder.create(EventConst.Bill.EVENT_ARREARS_ORDER_INTERCEPT_CK).addEventParam("order_id", str).addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void trackOutOfStockCk(ComponentModel componentModel) {
            OutOfStockModel outOfStockModel;
            AbnormalItemDetailEntity currItem;
            Intrinsics.checkNotNullParameter(componentModel, "componentModel");
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_OUT_OF_STOCK_CK);
            String cartId = componentModel.getCartId();
            String str = "";
            if (cartId == null) {
                cartId = str;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", cartId);
            String shopId = componentModel.getShopId();
            if (shopId != null) {
                str = shopId;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str);
            ComponentDataModel data = componentModel.getData();
            int i = 0;
            if (!(data == null || (outOfStockModel = data.getOutOfStockModel()) == null || (currItem = outOfStockModel.getCurrItem()) == null)) {
                i = currItem.getType();
            }
            addEventParam2.addEventParam("click_type", Integer.valueOf(i)).build().track();
        }

        public final void trackOutOfStockPageSw(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_OUT_OF_STOCK_PAGE_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void trackOutOfStockSelectCk(String str, String str2, Integer num) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_OUT_OF_STOCK_SELECT_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            addEventParam2.addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void trackOutOfStockConfirmCk(String str, String str2, Integer num) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_OUT_OF_STOCK_CONFIRM_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            addEventParam2.addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void billGlideContextError() {
            OmegaTracker.Builder.create(ErrorConst.ErrorName.SALING_C_BILL_GLIDE_CONTEXT_ERROR).build().track();
        }

        public final void trackCPFCheckSW() {
            OmegaTracker.Builder.create(EventConst.Business.SHOP_CPF_CHECK_SW).build().track();
        }

        public final void trackCPFCheckCK(int i) {
            OmegaTracker.Builder.create(EventConst.Business.SHOP_CPF_CHECK_CK).addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void trackCPFCheckFailSW() {
            OmegaTracker.Builder.create(EventConst.Business.SHOP_CPF_CHECK_FAIL_SW).addEventParam("msg_type", 2).build().track();
        }

        public final void trackCPFToastSW() {
            OmegaTracker.Builder.create(EventConst.Business.SHOP_CPF_CHECK_TOAST_SW).build().track();
        }

        public final void tracePreMatchBlockSW(String str, String str2, String str3, String str4) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_PAY_PREMATCHBLOCK_SW);
            Pair[] pairArr = new Pair[4];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("error_msg", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("user_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[2] = TuplesKt.m42317to("shop_id", str3);
            if (str4 == null) {
                str4 = "";
            }
            pairArr[3] = TuplesKt.m42317to("cart_id", str4);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void tracePreMatchBlockCK(Integer num, String str, String str2, String str3) {
            int i;
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Cart.EVENT_PAY_PREMATCHBLOCK_CK);
            Pair[] pairArr = new Pair[4];
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            pairArr[0] = TuplesKt.m42317to("event_type", Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.m42317to("user_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[2] = TuplesKt.m42317to("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[3] = TuplesKt.m42317to("cart_id", str3);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceGuideCashDialogSW(String str, String str2, String str3) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_PAYMENT_FAIL_SW);
            Pair[] pairArr = new Pair[3];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("order_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[2] = TuplesKt.m42317to("cart_id", str3);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceGuideCashDialogCK(String str, String str2, String str3, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_PAYMENT_FAIL_CK);
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.m42317to("button_type", Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.m42317to("order_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[2] = TuplesKt.m42317to("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[3] = TuplesKt.m42317to("cart_id", str3);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceCartToastSW(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_ACTIVITY_TOAST_SW);
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("activity_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("error_msg", str2);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceDeliveryConfirmSW(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_DELIVERY_CONFIRM_SW);
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("shop_id", str2);
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceDeliveryConfirmCK(String str, String str2, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_DELIVERY_CONFIRM_CK);
            Pair[] pairArr = new Pair[3];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("shop_id", str2);
            pairArr[2] = TuplesKt.m42317to("click_type", Integer.valueOf(i));
            create.addAllEventParam(MapsKt.mapOf(pairArr)).build().track();
        }

        public final void traceRefundRuleSW(String str) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_ORDERDETAIL_REFUND_RULE_POPUP_SW);
            if (str == null) {
                str = "";
            }
            create.addEventParam("order_id", str).build().track();
        }

        public final void traceRefundRuleBtnCk(String str) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_ORDERDETAIL_REFUND_RULE_CONFIRM_CK);
            if (str == null) {
                str = "";
            }
            create.addEventParam("order_id", str).build().track();
        }

        public final void traceRefundRuleBackCk(String str) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
            if (str == null) {
                str = "";
            }
            create.addEventParam("from", str).build().track();
        }

        public final void traceCartRecommendBubbleSW(String str, String str2, String str3, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_RECOMMEND_BUBBLE_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            addEventParam2.addEventParam("from_page", str3).addEventParam(ParamConst.PARAM_BUBBLE_STYLE, Integer.valueOf(i)).build().track();
        }

        public final void traceCartRecommendBubbleCK(String str, String str2, String str3, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_RECOMMEND_BUBBLE_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            addEventParam2.addEventParam("from_page", str3).addEventParam(ParamConst.PARAM_BUBBLE_STYLE, Integer.valueOf(i)).build().track();
        }

        public final void traceCartRecommendBubbleCancel(String str, String str2, String str3, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_RECOMMEND_BUUBLE_CL);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            addEventParam2.addEventParam("from_page", str3).addEventParam(ParamConst.PARAM_BUBBLE_STYLE, Integer.valueOf(i)).build().track();
        }

        public final void traceCartAddressPromptSW(String str, String str2, Integer num) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_ADDRESS_PROMPT_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam("scene", Integer.valueOf(CustomerExtentionKt.getOrZero(num))).build().track();
        }

        public final void traceCartContentPopupSW(String str, String str2, int i, int i2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_CONTENT_POPUP_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam("type", Integer.valueOf(i)).addEventParam("content_type", Integer.valueOf(i2)).build().track();
        }

        public final void traceMutualExclusionRuleCK(String str, String str2, int i, String str3) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_CART_MUTEX_RULER_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            addEventParam2.addEventParam("item_id", str3).addEventParam("from", Integer.valueOf(i)).build().track();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            if ((!(r2.length() == 0) && (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) "null") ^ true)) == true) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void tracePayErrorGuideDialogSW(java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.String r10) {
            /*
                r6 = this;
                r0 = 1
                r1 = 0
                if (r10 != 0) goto L_0x0006
            L_0x0004:
                r0 = 0
                goto L_0x0022
            L_0x0006:
                r2 = r10
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x006d }
                int r3 = r2.length()     // Catch:{ Exception -> 0x006d }
                if (r3 != 0) goto L_0x0011
                r3 = 1
                goto L_0x0012
            L_0x0011:
                r3 = 0
            L_0x0012:
                if (r3 != 0) goto L_0x001f
                java.lang.String r3 = "null"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x006d }
                r2 = r2 ^ r0
                if (r2 == 0) goto L_0x001f
                r2 = 1
                goto L_0x0020
            L_0x001f:
                r2 = 0
            L_0x0020:
                if (r2 != r0) goto L_0x0004
            L_0x0022:
                if (r0 == 0) goto L_0x006e
                com.didi.soda.bill.BillOmegaHelper$Companion$tracePayErrorGuideDialogSW$type$1 r0 = new com.didi.soda.bill.BillOmegaHelper$Companion$tracePayErrorGuideDialogSW$type$1     // Catch:{ Exception -> 0x006d }
                r0.<init>()     // Catch:{ Exception -> 0x006d }
                java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x006d }
                java.lang.Object r0 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r10, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x006d }
                java.lang.String r2 = "fromJson<ArrayList<Recom…>(payMethodListStr, type)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x006d }
                java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x006d }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x006d }
                r2.<init>()     // Catch:{ Exception -> 0x006d }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x006d }
            L_0x0041:
                boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x006d }
                if (r3 == 0) goto L_0x0064
                java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x006d }
                com.didi.soda.customer.foundation.rpc.entity.RecommendPayment r3 = (com.didi.soda.customer.foundation.rpc.entity.RecommendPayment) r3     // Catch:{ Exception -> 0x006d }
                com.didi.soda.customer.foundation.rpc.entity.RecommendPaymentOmega r4 = new com.didi.soda.customer.foundation.rpc.entity.RecommendPaymentOmega     // Catch:{ Exception -> 0x006d }
                r4.<init>()     // Catch:{ Exception -> 0x006d }
                java.lang.String r5 = r3.getCard_suffix()     // Catch:{ Exception -> 0x006d }
                r4.setCard_no(r5)     // Catch:{ Exception -> 0x006d }
                java.lang.Integer r3 = r3.getChannelID()     // Catch:{ Exception -> 0x006d }
                r4.setPay_method(r3)     // Catch:{ Exception -> 0x006d }
                r2.add(r4)     // Catch:{ Exception -> 0x006d }
                goto L_0x0041
            L_0x0064:
                java.lang.String r0 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r2)     // Catch:{ Exception -> 0x006d }
                java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x006d }
                goto L_0x006e
            L_0x006d:
            L_0x006e:
                java.lang.String r0 = "sailing_c_x_cart_paymethod_fail_sw"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r0 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r0)
                java.lang.String r2 = ""
                if (r7 == 0) goto L_0x007a
                goto L_0x007b
            L_0x007a:
                r7 = r2
            L_0x007b:
                java.lang.String r3 = "cart_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r0.addEventParam(r3, r7)
                if (r8 == 0) goto L_0x0084
                goto L_0x0085
            L_0x0084:
                r8 = r2
            L_0x0085:
                java.lang.String r0 = "shop_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r0, r8)
                if (r9 != 0) goto L_0x008f
                goto L_0x0093
            L_0x008f:
                int r1 = r9.intValue()
            L_0x0093:
                java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
                java.lang.String r9 = "pay_method"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r9, r8)
                if (r10 == 0) goto L_0x00a1
                goto L_0x00a2
            L_0x00a1:
                r10 = r2
            L_0x00a2:
                java.lang.String r8 = "paymethod_list"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r8, r10)
                com.didi.soda.customer.foundation.tracker.OmegaTracker r7 = r7.build()
                r7.track()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.BillOmegaHelper.Companion.tracePayErrorGuideDialogSW(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String):void");
        }

        public final void tracePayErrorGuideDialogCK(String str, String str2, PayChannelEntity payChannelEntity, Integer num) {
            int i;
            String str3 = "";
            String json = payChannelEntity == null ? str3 : GsonUtil.toJson(payChannelEntity);
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_CART_PAY_METHOD_FAIL_CK);
            if (str == null) {
                str = str3;
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = str3;
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("shop_id", str2);
            if (json != null) {
                str3 = json;
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_PAY_METHOD_INFO, str3);
            if (num == null) {
                i = 0;
            } else {
                i = num.intValue();
            }
            addEventParam3.addEventParam("button_type", Integer.valueOf(i)).build().track();
        }

        public final void traceBillOrderDetailTipsSW(String str, String str2) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.EVENT_CART_CART_ORDER_DETAIL_TIP_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).build().track();
        }

        public final void traceBillTipsFeeCK(String str, String str2, boolean z, long j, int i) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_TIPS_CONFIRM_CK);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("shop_id", str2).addEventParam(ParamConst.PARAM_IS_MANUAL, Integer.valueOf(z ? 2 : 1)).addEventParam(ParamConst.PARAM_TIPS_NOW, Long.valueOf(j)).addEventParam(ParamConst.PARAM_TIPS_TYPE, Integer.valueOf(i)).build().track();
        }
    }
}
