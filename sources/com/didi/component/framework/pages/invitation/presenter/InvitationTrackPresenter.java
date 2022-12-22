package com.didi.component.framework.pages.invitation.presenter;

import android.content.Context;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.component.framework.pages.invitation.item.TrackItem;
import com.didi.component.framework.pages.invitation.model.ListData;
import com.didi.component.framework.pages.invitation.model.RefererRelationTotalVo;
import com.didi.component.framework.pages.invitation.model.RefererRelationVo;
import com.didi.component.framework.pages.invitation.model.RewardModel;
import com.didi.component.framework.pages.invitation.view.IInvitationTrackView;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J2\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tJ\u0018\u0010\u001d\u001a\u00020\u00172\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eH\u0002J!\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0007J\u0018\u0010'\u001a\u00020\u00172\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eH\u0007J\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020!JE\u0010+\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010&2\b\u0010-\u001a\u0004\u0018\u00010\u001f2\b\u0010.\u001a\u0004\u0018\u00010&2\b\u0010/\u001a\u0004\u0018\u00010&2\b\u00100\u001a\u0004\u0018\u00010!¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/presenter/InvitationTrackPresenter;", "Lcom/didi/component/core/IPresenter;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationTrackView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isTop", "", "()Z", "setTop", "(Z)V", "list", "", "Lcom/didi/component/framework/pages/invitation/item/TrackItem;", "getList", "()Ljava/util/List;", "newPage", "convertToTrackItem", "refererRelationVo", "Lcom/didi/component/framework/pages/invitation/model/RefererRelationVo;", "generateItemList", "", "listInfo", "Lcom/didi/component/framework/pages/invitation/model/ListData;", "reward", "Lcom/didi/component/framework/pages/invitation/model/RewardModel;", "hasRewards", "generateMoreItemList", "getLeftedDays", "", "curTime", "", "expiredTime", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/Integer;", "onLoadFailure", "event", "", "onUpdatedReceived", "registerSubscriber", "timeBits", "time", "traceEvent", "ticket", "channel", "country", "city", "activityId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "unRegisterSubscriber", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationTrackPresenter.kt */
public final class InvitationTrackPresenter extends IPresenter<IInvitationTrackView> {
    public static final long CONST_DAY_IN_SECONDS_THIRTEEN = 86400000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TIME_STEMP_TEN_BIT = 10;
    public static final int TIME_STEMP_THIRTEEN_BIT = 13;

    /* renamed from: a */
    private final Context f13923a;

    /* renamed from: b */
    private final List<TrackItem> f13924b = new ArrayList();

    /* renamed from: c */
    private boolean f13925c;

    /* renamed from: d */
    private boolean f13926d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvitationTrackPresenter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13923a = context;
    }

    public final Context getContext() {
        return this.f13923a;
    }

    public final List<TrackItem> getList() {
        return this.f13924b;
    }

    public final boolean isTop() {
        return this.f13925c;
    }

    public final void setTop(boolean z) {
        this.f13925c = z;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/presenter/InvitationTrackPresenter$Companion;", "", "()V", "CONST_DAY_IN_SECONDS_THIRTEEN", "", "TIME_STEMP_TEN_BIT", "", "TIME_STEMP_THIRTEEN_BIT", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitationTrackPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void registerSubscriber() {
        EventBus.getDefault().register(this);
    }

    public final void generateItemList(ListData listData, boolean z, RewardModel rewardModel, boolean z2, boolean z3) {
        RefererRelationTotalVo refererRelationTotalVo;
        List<RefererRelationVo> refererRelationVos;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z4 = z;
        boolean z5 = z2;
        this.f13925c = z4;
        this.f13926d = z5;
        List arrayList = new ArrayList();
        Boolean bool = null;
        if (!z4) {
            if (rewardModel == null) {
                str = null;
            } else {
                str = rewardModel.getReceivedAmountFormat();
            }
            if (rewardModel == null) {
                str2 = null;
            } else {
                str2 = rewardModel.getRestAmountFormat();
            }
            if (rewardModel == null) {
                str3 = null;
            } else {
                str3 = rewardModel.getCurrencySymbol();
            }
            if (rewardModel != null) {
                bool = rewardModel.getCurrencyFirst();
            }
            arrayList.add(new TrackItem(1001, str, str2, str3, bool, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131040, (DefaultConstructorMarker) null));
        } else if (z5) {
            arrayList.add(new TrackItem(1000, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131070, (DefaultConstructorMarker) null));
            if (rewardModel == null) {
                str7 = null;
            } else {
                str7 = rewardModel.getReceivedAmountFormat();
            }
            if (rewardModel == null) {
                str8 = null;
            } else {
                str8 = rewardModel.getRestAmountFormat();
            }
            if (rewardModel == null) {
                str9 = null;
            } else {
                str9 = rewardModel.getCurrencySymbol();
            }
            if (rewardModel != null) {
                bool = rewardModel.getCurrencyFirst();
            }
            arrayList.add(new TrackItem(1001, str7, str8, str9, bool, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131040, (DefaultConstructorMarker) null));
        } else {
            arrayList.add(new TrackItem(0, (String) null, (String) null, (String) null, (Boolean) null, ResourcesHelper.getString(this.f13923a, R.string.global_invite_error_tips_text), (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131038, (DefaultConstructorMarker) null));
            if (rewardModel == null) {
                str4 = null;
            } else {
                str4 = rewardModel.getReceivedAmountFormat();
            }
            if (rewardModel == null) {
                str5 = null;
            } else {
                str5 = rewardModel.getRestAmountFormat();
            }
            if (rewardModel == null) {
                str6 = null;
            } else {
                str6 = rewardModel.getCurrencySymbol();
            }
            if (rewardModel != null) {
                bool = rewardModel.getCurrencyFirst();
            }
            arrayList.add(new TrackItem(1, str4, str5, str6, bool, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131040, (DefaultConstructorMarker) null));
        }
        if (z3 || !z4) {
            arrayList.add(new TrackItem(2, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, ResourcesHelper.getString(this.f13923a, R.string.global_invite_code_invitations), false, (Long) null, (Long) null, 122878, (DefaultConstructorMarker) null));
        }
        if (!(listData == null || (refererRelationTotalVo = listData.getRefererRelationTotalVo()) == null || (refererRelationVos = refererRelationTotalVo.getRefererRelationVos()) == null)) {
            for (RefererRelationVo a : refererRelationVos) {
                arrayList.add(m9649a(a));
            }
        }
        arrayList.add(new TrackItem(8, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131070, (DefaultConstructorMarker) null));
        IInvitationTrackView iInvitationTrackView = (IInvitationTrackView) this.mView;
        if (iInvitationTrackView != null) {
            iInvitationTrackView.initRecyclerView(arrayList);
        }
    }

    /* renamed from: a */
    private final void m9650a(List<RefererRelationVo> list) {
        List arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            arrayList.add(new TrackItem(1003, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Long) null, (String) null, false, (Long) null, (Long) null, 131070, (DefaultConstructorMarker) null));
        }
        if (list != null) {
            for (RefererRelationVo a : list) {
                arrayList.add(m9649a(a));
            }
        }
        IInvitationTrackView iInvitationTrackView = (IInvitationTrackView) this.mView;
        if (iInvitationTrackView != null) {
            iInvitationTrackView.updateContactsList(arrayList);
        }
    }

    /* renamed from: a */
    private final TrackItem m9649a(RefererRelationVo refererRelationVo) {
        int i;
        if (!this.f13925c) {
            return new TrackItem(1002, (String) null, (String) null, (String) null, (Boolean) null, (String) null, refererRelationVo.getRefereeLogo(), refererRelationVo.getRefereeName(), refererRelationVo.getRefereePhone(), Boolean.valueOf(refererRelationVo.getCurrencyFirst()), refererRelationVo.getCurrencySymbol(), refererRelationVo.getRebateAmountFormat(), refererRelationVo.getState(), (String) null, false, refererRelationVo.getCreateTime(), refererRelationVo.getExpireTime(), 24638, (DefaultConstructorMarker) null);
        }
        if (this.f13926d) {
            return new TrackItem(1002, (String) null, (String) null, (String) null, (Boolean) null, (String) null, refererRelationVo.getRefereeLogo(), refererRelationVo.getRefereeName(), refererRelationVo.getRefereePhone(), Boolean.valueOf(refererRelationVo.getCurrencyFirst()), refererRelationVo.getCurrencySymbol(), refererRelationVo.getRebateAmountFormat(), refererRelationVo.getState(), (String) null, false, refererRelationVo.getCreateTime(), refererRelationVo.getExpireTime(), 24638, (DefaultConstructorMarker) null);
        }
        Long state = refererRelationVo.getState();
        if (state != null && state.longValue() == 2) {
            i = 3;
        } else if (state != null && state.longValue() == 1) {
            i = 4;
        } else {
            i = (state != null && state.longValue() == 3) ? 6 : 5;
        }
        return new TrackItem(Integer.valueOf(i), (String) null, (String) null, (String) null, (Boolean) null, (String) null, refererRelationVo.getRefereeLogo(), refererRelationVo.getRefereeName(), refererRelationVo.getRefereePhone(), Boolean.valueOf(refererRelationVo.getCurrencyFirst()), refererRelationVo.getCurrencySymbol(), refererRelationVo.getRebateAmountFormat(), refererRelationVo.getState(), (String) null, false, (Long) null, (Long) null, 122942, (DefaultConstructorMarker) null);
    }

    @Subscribe
    public final void onUpdatedReceived(List<RefererRelationVo> list) {
        m9650a(list);
    }

    @Subscribe
    public final void onLoadFailure(String str) {
        IInvitationTrackView iInvitationTrackView;
        Intrinsics.checkNotNullParameter(str, "event");
        if (Intrinsics.areEqual((Object) str, (Object) InvitationTrackFragment.LOAD_FAILURE) && (iInvitationTrackView = (IInvitationTrackView) this.mView) != null) {
            iInvitationTrackView.loadFailure();
        }
    }

    public final void unRegisterSubscriber() {
        EventBus.getDefault().unregister(this);
    }

    public final Integer getLeftedDays(Long l, Long l2) {
        if (l == null || l2 == null) {
            return 0;
        }
        if (timeBits(l2.longValue()) == 10) {
            l2 = Long.valueOf(l2.longValue() * ((long) 1000));
        }
        return Integer.valueOf((int) ((l2.longValue() - l.longValue()) / 86400000));
    }

    public final int timeBits(long j) {
        return String.valueOf(j).length() == 10 ? 10 : 13;
    }

    public final void traceEvent(String str, String str2, Integer num, String str3, String str4, Long l) {
        Intrinsics.checkNotNullParameter(str, "event");
        Map hashMap = new HashMap();
        hashMap.put("ticket", str2);
        hashMap.put("channel", num);
        hashMap.put("location_country", str3);
        hashMap.put("location_city", str4);
        hashMap.put("activity_id", l);
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }
}
