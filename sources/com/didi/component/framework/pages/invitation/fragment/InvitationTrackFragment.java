package com.didi.component.framework.pages.invitation.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.adapter.CommonRvVH;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.component.framework.pages.invitation.helper.TrackEvent;
import com.didi.component.framework.pages.invitation.item.TrackItem;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didi.component.framework.pages.invitation.model.ListData;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.component.framework.pages.invitation.presenter.InvitationTrackPresenter;
import com.didi.component.framework.pages.invitation.view.IInvitationTrackView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\"\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020\rH\u0002J\u0017\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00100J\n\u00101\u001a\u0004\u0018\u00010 H\u0016J\u001a\u00102\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u001a\u00103\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0016\u00104\u001a\u00020)2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020\rH\u0002J\b\u00109\u001a\u00020)H\u0016J&\u0010:\u001a\u0004\u0018\u00010 2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020)H\u0016J\u0012\u0010B\u001a\u00020)2\b\u0010C\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010D\u001a\u00020)2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\rH\u0002J \u0010H\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020KH\u0002J\u001a\u0010L\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0016\u0010M\u001a\u00020)2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006O"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationTrackView;", "()V", "activityId", "", "Ljava/lang/Long;", "channel", "", "cityName", "", "country", "flag", "", "mAdapter", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/framework/pages/invitation/item/TrackItem;", "mCurrentPage", "mIsTop", "mList", "", "mListener", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "mLoadTextView", "Landroid/widget/Button;", "mPresenter", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationTrackPresenter;", "mProgressBar", "Landroid/widget/ProgressBar;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mRootView", "Landroid/view/View;", "mScrollerListener", "com/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment$mScrollerListener$1", "Lcom/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment$mScrollerListener$1;", "mTipContainer", "Lcom/didi/component/common/view/GlobalTipsContainer;", "newPage", "resourceId", "bindDataToView", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "item", "canLoadMore", "generateItemLayout", "type", "(Ljava/lang/Integer;)I", "getView", "handleInvitationList", "handleNewRewards", "initRecyclerView", "list", "isHideTipsView", "recyclerView", "isNeedShow", "loadFailure", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setPresenter", "presenter", "setTextColor", "tv", "Landroid/widget/TextView;", "isGlobal", "showTipView", "text", "errorImgBtn", "Landroid/widget/ImageButton;", "updateContactsItem", "updateContactsList", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationTrackFragment.kt */
public final class InvitationTrackFragment extends Fragment implements IInvitationTrackView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String INVITE_DATE = "%s";
    public static final String LEFT_DAYS = "%2$s";
    public static final String LOAD_FAILURE = "LOAD_FAILURE";
    public static final String REFERRER_REWARD = "%1$s";
    public static final String isTop = "isTop";

    /* renamed from: a */
    private View f13854a;

    /* renamed from: b */
    private InvitationTrackPresenter f13855b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IInvitationListener f13856c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f13857d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13858e;

    /* renamed from: f */
    private GlobalTipsContainer f13859f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ProgressBar f13860g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Button f13861h;

    /* renamed from: i */
    private CommonRvAdapter<TrackItem> f13862i;

    /* renamed from: j */
    private List<TrackItem> f13863j;

    /* renamed from: k */
    private RecyclerView f13864k;

    /* renamed from: l */
    private boolean f13865l;

    /* renamed from: m */
    private String f13866m = "";

    /* renamed from: n */
    private Long f13867n = 0L;

    /* renamed from: o */
    private Long f13868o = 0L;

    /* renamed from: p */
    private int f13869p;

    /* renamed from: q */
    private String f13870q = "";

    /* renamed from: r */
    private boolean f13871r;

    /* renamed from: s */
    private final InvitationTrackFragment$mScrollerListener$1 f13872s = new InvitationTrackFragment$mScrollerListener$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    public void setPresenter(InvitationTrackPresenter invitationTrackPresenter) {
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment$Companion;", "", "()V", "INVITE_DATE", "", "LEFT_DAYS", "LOAD_FAILURE", "REFERRER_REWARD", "isTop", "newInstance", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InvitationTrackFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(Bundle bundle) {
            InvitationTrackFragment invitationTrackFragment = new InvitationTrackFragment();
            invitationTrackFragment.setArguments(bundle);
            return invitationTrackFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        PageData pageInfo;
        InviteListModel listInfo;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.f13854a = layoutInflater.inflate(R.layout.global_fragment_invite_track, viewGroup, false);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        InvitationTrackPresenter invitationTrackPresenter = new InvitationTrackPresenter(requireActivity);
        this.f13855b = invitationTrackPresenter;
        if (invitationTrackPresenter != null) {
            invitationTrackPresenter.registerSubscriber();
        }
        InvitationTrackPresenter invitationTrackPresenter2 = this.f13855b;
        if (invitationTrackPresenter2 != null) {
            invitationTrackPresenter2.setIView(this);
        }
        FragmentActivity activity = getActivity();
        Long l = null;
        this.f13856c = activity instanceof IInvitationListener ? (IInvitationListener) activity : null;
        Bundle arguments = getArguments();
        this.f13858e = arguments == null ? false : arguments.getBoolean(isTop);
        this.f13859f = new GlobalTipsContainer(requireActivity());
        Bundle arguments2 = getArguments();
        this.f13871r = arguments2 == null ? false : arguments2.getBoolean(InvitationPageActivity.SHOW_NEWPAGE, false);
        IInvitationListener iInvitationListener = this.f13856c;
        boolean hasRewards = iInvitationListener == null ? false : iInvitationListener.hasRewards();
        InvitationTrackPresenter invitationTrackPresenter3 = this.f13855b;
        if (invitationTrackPresenter3 != null) {
            IInvitationListener iInvitationListener2 = this.f13856c;
            ListData data = (iInvitationListener2 == null || (listInfo = iInvitationListener2.getListInfo()) == null) ? null : listInfo.getData();
            boolean z = this.f13858e;
            IInvitationListener iInvitationListener3 = this.f13856c;
            invitationTrackPresenter3.generateItemList(data, z, (iInvitationListener3 == null || (pageInfo = iInvitationListener3.getPageInfo()) == null) ? null : pageInfo.getRewardModel(), this.f13871r, hasRewards);
        }
        Bundle arguments3 = getArguments();
        this.f13866m = arguments3 == null ? null : arguments3.getString("country");
        Bundle arguments4 = getArguments();
        this.f13867n = arguments4 == null ? null : Long.valueOf(arguments4.getLong("activityId"));
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            l = Long.valueOf(arguments5.getLong(InvitationPageActivity.RESOURCE_ID));
        }
        this.f13868o = l;
        Bundle arguments6 = getArguments();
        this.f13869p = arguments6 == null ? 2 : arguments6.getInt("channel");
        Bundle arguments7 = getArguments();
        String str = "";
        if (!(arguments7 == null || (string = arguments7.getString(InvitationPageActivity.CITY_NAME)) == null)) {
            str = string;
        }
        this.f13870q = str;
        InvitationTrackPresenter invitationTrackPresenter4 = this.f13855b;
        if (invitationTrackPresenter4 != null) {
            invitationTrackPresenter4.traceEvent(TrackEvent.REFERTRACK_SW, NationComponentDataUtil.getToken(), Integer.valueOf(this.f13869p), this.f13866m, this.f13870q, this.f13867n);
        }
        return this.f13854a;
    }

    public void initRecyclerView(List<TrackItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f13863j = list;
        View view = this.f13854a;
        RecyclerView recyclerView = view == null ? null : (RecyclerView) view.findViewById(R.id.invite_track_rv);
        this.f13864k = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        }
        CommonRvAdapter<TrackItem> invitationTrackFragment$initRecyclerView$1 = new InvitationTrackFragment$initRecyclerView$1(this, requireActivity());
        this.f13862i = invitationTrackFragment$initRecyclerView$1;
        if (invitationTrackFragment$initRecyclerView$1 != null) {
            invitationTrackFragment$initRecyclerView$1.setMData(this.f13863j);
        }
        RecyclerView recyclerView2 = this.f13864k;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f13862i);
        }
        if (!this.f13858e) {
            IInvitationListener iInvitationListener = this.f13856c;
            if (iInvitationListener != null) {
                iInvitationListener.showLoadingView();
            }
            IInvitationListener iInvitationListener2 = this.f13856c;
            if (iInvitationListener2 != null) {
                iInvitationListener2.updateContactsList(false, this.f13857d, false);
                return;
            }
            return;
        }
        Handler handler = UiThreadHandler.getsUiHandler();
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    InvitationTrackFragment.m9626a(InvitationTrackFragment.this);
                }
            }, 500);
        }
        this.f13865l = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9626a(InvitationTrackFragment invitationTrackFragment) {
        Intrinsics.checkNotNullParameter(invitationTrackFragment, "this$0");
        RecyclerView recyclerView = invitationTrackFragment.f13864k;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(invitationTrackFragment.f13872s);
        }
    }

    public void updateContactsList(List<TrackItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<TrackItem> list2 = this.f13863j;
        int size = list2 == null ? 0 : list2.size();
        if (size >= 1) {
            int i = size - 1;
            List<TrackItem> list3 = this.f13863j;
            if (list3 != null) {
                list3.addAll(i, list);
            }
            CommonRvAdapter<TrackItem> commonRvAdapter = this.f13862i;
            if (commonRvAdapter != null) {
                commonRvAdapter.notifyItemRangeInserted(i, list.size());
            }
            ProgressBar progressBar = this.f13860g;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (!this.f13865l) {
                Handler handler = UiThreadHandler.getsUiHandler();
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        public final void run() {
                            InvitationTrackFragment.m9632b(InvitationTrackFragment.this);
                        }
                    }, 500);
                }
                this.f13865l = true;
            }
            Button button = this.f13861h;
            if (button != null) {
                button.postDelayed(new Runnable() {
                    public final void run() {
                        InvitationTrackFragment.m9636c(InvitationTrackFragment.this);
                    }
                }, 500);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9632b(InvitationTrackFragment invitationTrackFragment) {
        Intrinsics.checkNotNullParameter(invitationTrackFragment, "this$0");
        RecyclerView recyclerView = invitationTrackFragment.f13864k;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(invitationTrackFragment.f13872s);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m9636c(InvitationTrackFragment invitationTrackFragment) {
        Intrinsics.checkNotNullParameter(invitationTrackFragment, "this$0");
        Button button = invitationTrackFragment.f13861h;
        if (button != null) {
            button.setVisibility((invitationTrackFragment.m9634b() || !invitationTrackFragment.m9630a()) ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m9622a(Integer num) {
        if (num != null && num.intValue() == 0) {
            return R.layout.global_invite_top_item;
        }
        if (num != null && num.intValue() == 1) {
            return R.layout.global_invite_msg_item;
        }
        if (num != null && num.intValue() == 2) {
            return R.layout.global_invite_title_tv_item;
        }
        if (num != null && num.intValue() == 8) {
            return R.layout.global_invite_code_load_more;
        }
        if (num != null && num.intValue() == 1000) {
            return R.layout.global_invitation_head_layout;
        }
        if (num != null && num.intValue() == 1001) {
            return R.layout.global_invitation_reward_layout;
        }
        if (num != null && num.intValue() == 1002) {
            return R.layout.global_invitation_contacts_item;
        }
        return (num != null && num.intValue() == 1003) ? R.layout.global_invitation_no_person_layout : R.layout.global_invite_contacts_item;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.widget.ProgressBar] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r2v17, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9625a(com.didi.component.common.adapter.CommonRvVH r9, com.didi.component.framework.pages.invitation.item.TrackItem r10) {
        /*
            r8 = this;
            java.lang.Integer r0 = r10.getType()
            r1 = 2131431667(0x7f0b10f3, float:1.848507E38)
            r2 = 0
            if (r0 != 0) goto L_0x000b
            goto L_0x0027
        L_0x000b:
            int r3 = r0.intValue()
            if (r3 != 0) goto L_0x0027
            if (r9 != 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            android.widget.TextView r2 = r9.getTextView(r1)
        L_0x0018:
            if (r2 != 0) goto L_0x001c
            goto L_0x02ce
        L_0x001c:
            java.lang.String r9 = r10.getTopMsg()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r2.setText(r9)
            goto L_0x02ce
        L_0x0027:
            r3 = 1000(0x3e8, float:1.401E-42)
            r4 = 8
            if (r0 != 0) goto L_0x002f
            goto L_0x00c4
        L_0x002f:
            int r5 = r0.intValue()
            if (r5 != r3) goto L_0x00c4
            if (r9 != 0) goto L_0x0039
            r10 = r2
            goto L_0x0040
        L_0x0039:
            r10 = 2131431599(0x7f0b10af, float:1.8484932E38)
            android.widget.ImageView r10 = r9.getImageView(r10)
        L_0x0040:
            if (r9 != 0) goto L_0x0044
            r0 = r2
            goto L_0x004b
        L_0x0044:
            r0 = 2131431602(0x7f0b10b2, float:1.8484938E38)
            android.widget.TextView r0 = r9.getTextView(r0)
        L_0x004b:
            if (r9 != 0) goto L_0x004f
            r1 = r2
            goto L_0x0056
        L_0x004f:
            r1 = 2131431601(0x7f0b10b1, float:1.8484936E38)
            android.widget.TextView r1 = r9.getTextView(r1)
        L_0x0056:
            if (r9 != 0) goto L_0x005a
            r9 = r2
            goto L_0x0061
        L_0x005a:
            r3 = 2131431560(0x7f0b1088, float:1.8484853E38)
            android.view.View r9 = r9.getTargetView(r3)
        L_0x0061:
            r3 = r8
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r3)
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r5 = r8.f13856c
            if (r5 != 0) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            com.didi.component.framework.pages.invitation.model.PageData r5 = r5.getPageInfo()
            if (r5 != 0) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            java.lang.String r2 = r5.getBannerPic()
        L_0x0078:
            com.bumptech.glide.RequestBuilder r2 = r3.load((java.lang.String) r2)
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable
            java.lang.String r5 = "#F3F4F5"
            int r5 = android.graphics.Color.parseColor(r5)
            r3.<init>(r5)
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder((android.graphics.drawable.Drawable) r3)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2.into((android.widget.ImageView) r10)
            if (r0 != 0) goto L_0x0098
            goto L_0x00a8
        L_0x0098:
            android.content.Context r10 = r8.getContext()
            r2 = 2131953144(0x7f1305f8, float:1.954275E38)
            java.lang.String r10 = com.didi.sdk.util.ResourcesHelper.getString(r10, r2)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r0.setText(r10)
        L_0x00a8:
            if (r1 != 0) goto L_0x00ab
            goto L_0x00bb
        L_0x00ab:
            android.content.Context r10 = r8.getContext()
            r0 = 2131953145(0x7f1305f9, float:1.9542753E38)
            java.lang.String r10 = com.didi.sdk.util.ResourcesHelper.getString(r10, r0)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r1.setText(r10)
        L_0x00bb:
            if (r9 != 0) goto L_0x00bf
            goto L_0x02ce
        L_0x00bf:
            r9.setVisibility(r4)
            goto L_0x02ce
        L_0x00c4:
            r3 = 1
            r5 = 0
            if (r0 != 0) goto L_0x00ca
            goto L_0x01b2
        L_0x00ca:
            int r6 = r0.intValue()
            if (r6 != r3) goto L_0x01b2
            if (r9 != 0) goto L_0x00d4
            r0 = r2
            goto L_0x00db
        L_0x00d4:
            r0 = 2131431660(0x7f0b10ec, float:1.8485055E38)
            android.widget.TextView r0 = r9.getTextView(r0)
        L_0x00db:
            if (r9 != 0) goto L_0x00df
            r1 = r2
            goto L_0x00e6
        L_0x00df:
            r1 = 2131431656(0x7f0b10e8, float:1.8485047E38)
            android.widget.TextView r1 = r9.getTextView(r1)
        L_0x00e6:
            if (r9 != 0) goto L_0x00ea
            r3 = r2
            goto L_0x00f1
        L_0x00ea:
            r3 = 2131431661(0x7f0b10ed, float:1.8485058E38)
            android.widget.TextView r3 = r9.getTextView(r3)
        L_0x00f1:
            if (r9 != 0) goto L_0x00f5
            r6 = r2
            goto L_0x00fc
        L_0x00f5:
            r6 = 2131431662(0x7f0b10ee, float:1.848506E38)
            android.widget.TextView r6 = r9.getTextView(r6)
        L_0x00fc:
            if (r9 != 0) goto L_0x0100
            r7 = r2
            goto L_0x0107
        L_0x0100:
            r7 = 2131431657(0x7f0b10e9, float:1.848505E38)
            android.widget.TextView r7 = r9.getTextView(r7)
        L_0x0107:
            if (r9 != 0) goto L_0x010a
            goto L_0x0111
        L_0x010a:
            r2 = 2131431663(0x7f0b10ef, float:1.8485062E38)
            android.widget.TextView r2 = r9.getTextView(r2)
        L_0x0111:
            if (r0 != 0) goto L_0x0114
            goto L_0x011d
        L_0x0114:
            java.lang.String r9 = r10.getMsgSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
        L_0x011d:
            if (r1 != 0) goto L_0x0120
            goto L_0x0129
        L_0x0120:
            java.lang.String r9 = r10.getReceivedMoney()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
        L_0x0129:
            if (r3 != 0) goto L_0x012c
            goto L_0x0135
        L_0x012c:
            java.lang.String r9 = r10.getMsgSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r3.setText(r9)
        L_0x0135:
            if (r6 != 0) goto L_0x0138
            goto L_0x0141
        L_0x0138:
            java.lang.String r9 = r10.getMsgSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r6.setText(r9)
        L_0x0141:
            if (r7 != 0) goto L_0x0144
            goto L_0x014d
        L_0x0144:
            java.lang.String r9 = r10.getRestMoney()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
        L_0x014d:
            if (r2 != 0) goto L_0x0150
            goto L_0x0159
        L_0x0150:
            java.lang.String r9 = r10.getMsgSymbol()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r2.setText(r9)
        L_0x0159:
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r9 = r8.f13856c
            if (r9 != 0) goto L_0x015f
            r9 = 0
            goto L_0x0163
        L_0x015f:
            boolean r9 = r9.isGlobal()
        L_0x0163:
            r8.m9623a((android.widget.TextView) r0, (boolean) r9)
            r8.m9623a((android.widget.TextView) r1, (boolean) r9)
            r8.m9623a((android.widget.TextView) r3, (boolean) r9)
            java.lang.Boolean r10 = r10.getMsgFirst()
            if (r10 != 0) goto L_0x0174
            r10 = 0
            goto L_0x0178
        L_0x0174:
            boolean r10 = r10.booleanValue()
        L_0x0178:
            if (r10 != 0) goto L_0x0197
            if (r0 != 0) goto L_0x017d
            goto L_0x0180
        L_0x017d:
            r0.setVisibility(r5)
        L_0x0180:
            if (r3 != 0) goto L_0x0183
            goto L_0x0186
        L_0x0183:
            r3.setVisibility(r4)
        L_0x0186:
            if (r6 != 0) goto L_0x0189
            goto L_0x018c
        L_0x0189:
            r6.setVisibility(r5)
        L_0x018c:
            if (r2 != 0) goto L_0x018f
            goto L_0x0192
        L_0x018f:
            r2.setVisibility(r4)
        L_0x0192:
            r8.m9623a((android.widget.TextView) r0, (boolean) r9)
            goto L_0x02ce
        L_0x0197:
            if (r0 != 0) goto L_0x019a
            goto L_0x019d
        L_0x019a:
            r0.setVisibility(r4)
        L_0x019d:
            if (r3 != 0) goto L_0x01a0
            goto L_0x01a3
        L_0x01a0:
            r3.setVisibility(r5)
        L_0x01a3:
            if (r6 != 0) goto L_0x01a6
            goto L_0x01a9
        L_0x01a6:
            r6.setVisibility(r4)
        L_0x01a9:
            if (r2 != 0) goto L_0x01ad
            goto L_0x02ce
        L_0x01ad:
            r2.setVisibility(r5)
            goto L_0x02ce
        L_0x01b2:
            r6 = 1001(0x3e9, float:1.403E-42)
            if (r0 != 0) goto L_0x01b7
            goto L_0x01c2
        L_0x01b7:
            int r7 = r0.intValue()
            if (r7 != r6) goto L_0x01c2
            r8.m9635c(r9, r10)
            goto L_0x02ce
        L_0x01c2:
            r6 = 2
            if (r0 != 0) goto L_0x01c6
            goto L_0x020a
        L_0x01c6:
            int r7 = r0.intValue()
            if (r7 != r6) goto L_0x020a
            if (r9 != 0) goto L_0x01d0
            r10 = r2
            goto L_0x01d4
        L_0x01d0:
            android.widget.TextView r10 = r9.getTextView(r1)
        L_0x01d4:
            if (r10 != 0) goto L_0x01d7
            goto L_0x01de
        L_0x01d7:
            android.graphics.Typeface r0 = android.graphics.Typeface.defaultFromStyle(r3)
            r10.setTypeface(r0)
        L_0x01de:
            if (r10 != 0) goto L_0x01e1
            goto L_0x01f3
        L_0x01e1:
            androidx.fragment.app.FragmentActivity r0 = r8.requireActivity()
            android.content.Context r0 = (android.content.Context) r0
            r1 = 2131955130(0x7f130dba, float:1.9546779E38)
            java.lang.String r0 = com.didi.sdk.util.ResourcesHelper.getString(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.setText(r0)
        L_0x01f3:
            boolean r10 = r8.f13871r
            if (r10 == 0) goto L_0x02ce
            if (r9 != 0) goto L_0x01fa
            goto L_0x0201
        L_0x01fa:
            r10 = 2131431654(0x7f0b10e6, float:1.8485043E38)
            android.view.View r2 = r9.getTargetView(r10)
        L_0x0201:
            if (r2 != 0) goto L_0x0205
            goto L_0x02ce
        L_0x0205:
            r2.setVisibility(r4)
            goto L_0x02ce
        L_0x020a:
            if (r0 != 0) goto L_0x020d
            goto L_0x0252
        L_0x020d:
            int r1 = r0.intValue()
            if (r1 != r4) goto L_0x0252
            if (r9 != 0) goto L_0x0217
            r10 = r2
            goto L_0x021e
        L_0x0217:
            r10 = 2131431101(0x7f0b0ebd, float:1.8483922E38)
            android.widget.Button r10 = r9.getButton(r10)
        L_0x021e:
            r8.f13861h = r10
            if (r9 != 0) goto L_0x0223
            goto L_0x022d
        L_0x0223:
            r10 = 2131431100(0x7f0b0ebc, float:1.848392E38)
            android.view.View r9 = r9.getTargetView(r10)
            r2 = r9
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
        L_0x022d:
            r8.f13860g = r2
            boolean r9 = r8.m9634b()
            if (r9 == 0) goto L_0x0240
            android.widget.Button r9 = r8.f13861h
            if (r9 != 0) goto L_0x023b
            goto L_0x02ce
        L_0x023b:
            r9.setVisibility(r4)
            goto L_0x02ce
        L_0x0240:
            android.widget.Button r9 = r8.f13861h
            if (r9 != 0) goto L_0x0246
            goto L_0x02ce
        L_0x0246:
            boolean r10 = r8.m9630a()
            if (r10 == 0) goto L_0x024d
            r4 = 0
        L_0x024d:
            r9.setVisibility(r4)
            goto L_0x02ce
        L_0x0252:
            r1 = 1003(0x3eb, float:1.406E-42)
            if (r0 != 0) goto L_0x0258
            goto L_0x02bc
        L_0x0258:
            int r3 = r0.intValue()
            if (r3 != r1) goto L_0x02bc
            if (r9 != 0) goto L_0x0262
            r10 = r2
            goto L_0x026b
        L_0x0262:
            r10 = 2131431609(0x7f0b10b9, float:1.8484952E38)
            android.view.View r10 = r9.getTargetView(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
        L_0x026b:
            if (r9 != 0) goto L_0x026f
            r0 = r2
            goto L_0x0278
        L_0x026f:
            r0 = 2131431611(0x7f0b10bb, float:1.8484956E38)
            android.view.View r0 = r9.getTargetView(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0278:
            if (r9 != 0) goto L_0x027c
            r9 = r2
            goto L_0x0283
        L_0x027c:
            r1 = 2131431610(0x7f0b10ba, float:1.8484954E38)
            android.view.View r9 = r9.getTargetView(r1)
        L_0x0283:
            if (r9 != 0) goto L_0x0286
            goto L_0x028a
        L_0x0286:
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
        L_0x028a:
            if (r2 != 0) goto L_0x028d
            goto L_0x0299
        L_0x028d:
            android.content.Context r1 = r8.getContext()
            r3 = 1137639424(0x43cf0000, float:414.0)
            int r1 = com.didi.component.business.util.UiUtils.dip2px(r1, r3)
            r2.height = r1
        L_0x0299:
            if (r9 != 0) goto L_0x029c
            goto L_0x029f
        L_0x029c:
            r9.setLayoutParams(r2)
        L_0x029f:
            if (r10 != 0) goto L_0x02a2
            goto L_0x02a8
        L_0x02a2:
            r9 = 2131233277(0x7f0809fd, float:1.8082687E38)
            r10.setImageResource(r9)
        L_0x02a8:
            if (r0 != 0) goto L_0x02ab
            goto L_0x02ce
        L_0x02ab:
            android.content.Context r9 = r8.getContext()
            r10 = 2131953130(0x7f1305ea, float:1.9542722E38)
            java.lang.String r9 = com.didi.sdk.util.ResourcesHelper.getString(r9, r10)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            goto L_0x02ce
        L_0x02bc:
            r1 = 1002(0x3ea, float:1.404E-42)
            if (r0 != 0) goto L_0x02c1
            goto L_0x02cb
        L_0x02c1:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x02cb
            r8.m9631b(r9, r10)
            goto L_0x02ce
        L_0x02cb:
            r8.m9637d(r9, r10)
        L_0x02ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment.m9625a(com.didi.component.common.adapter.CommonRvVH, com.didi.component.framework.pages.invitation.item.TrackItem):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0158  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m9631b(com.didi.component.common.adapter.CommonRvVH r18, com.didi.component.framework.pages.invitation.item.TrackItem r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 != 0) goto L_0x0009
            r3 = r2
            goto L_0x0010
        L_0x0009:
            r3 = 2131431587(0x7f0b10a3, float:1.8484907E38)
            android.widget.ImageView r3 = r1.getImageView(r3)
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            r4 = r2
            goto L_0x001b
        L_0x0014:
            r4 = 2131431594(0x7f0b10aa, float:1.8484922E38)
            android.widget.TextView r4 = r1.getTextView(r4)
        L_0x001b:
            if (r1 != 0) goto L_0x001f
            r5 = r2
            goto L_0x0026
        L_0x001f:
            r5 = 2131431592(0x7f0b10a8, float:1.8484918E38)
            android.widget.TextView r5 = r1.getTextView(r5)
        L_0x0026:
            if (r1 != 0) goto L_0x002a
            r6 = r2
            goto L_0x0031
        L_0x002a:
            r6 = 2131431593(0x7f0b10a9, float:1.848492E38)
            android.widget.TextView r6 = r1.getTextView(r6)
        L_0x0031:
            if (r1 != 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            r7 = 2131431589(0x7f0b10a5, float:1.8484911E38)
            r1.getTargetView(r7)
        L_0x003a:
            if (r1 != 0) goto L_0x003e
            r7 = r2
            goto L_0x0045
        L_0x003e:
            r7 = 2131431591(0x7f0b10a7, float:1.8484916E38)
            android.widget.TextView r7 = r1.getTextView(r7)
        L_0x0045:
            if (r1 != 0) goto L_0x0049
            r8 = r2
            goto L_0x0050
        L_0x0049:
            r8 = 2131431590(0x7f0b10a6, float:1.8484914E38)
            android.widget.TextView r8 = r1.getTextView(r8)
        L_0x0050:
            if (r1 != 0) goto L_0x0054
            r1 = r2
            goto L_0x005d
        L_0x0054:
            r9 = 2131431588(0x7f0b10a4, float:1.848491E38)
            android.view.View r1 = r1.getTargetView(r9)
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
        L_0x005d:
            r9 = 8
            if (r1 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r1.setVisibility(r9)
        L_0x0065:
            if (r5 != 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            r5.setVisibility(r9)
        L_0x006b:
            androidx.fragment.app.FragmentActivity r5 = r17.requireActivity()
            android.content.Context r5 = (android.content.Context) r5
            r9 = 2131233266(0x7f0809f2, float:1.8082665E38)
            android.graphics.drawable.Drawable r5 = com.didi.sdk.util.ResourcesHelper.getDrawable(r5, r9)
            r9 = r0
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            com.bumptech.glide.RequestManager r9 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r9)
            java.lang.String r10 = r19.getImgIconUrl()
            if (r10 != 0) goto L_0x0087
            java.lang.String r10 = ""
        L_0x0087:
            com.bumptech.glide.RequestBuilder r9 = r9.load((java.lang.String) r10)
            com.bumptech.glide.request.BaseRequestOptions r5 = r9.placeholder((android.graphics.drawable.Drawable) r5)
            com.bumptech.glide.RequestBuilder r5 = (com.bumptech.glide.RequestBuilder) r5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r5.into((android.widget.ImageView) r3)
            r3 = 1
            r5 = 0
            if (r4 != 0) goto L_0x009c
            goto L_0x00be
        L_0x009c:
            java.lang.String r9 = r19.getName()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x00ad
            int r9 = r9.length()
            if (r9 != 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r9 = 0
            goto L_0x00ae
        L_0x00ad:
            r9 = 1
        L_0x00ae:
            if (r9 == 0) goto L_0x00b5
            java.lang.String r9 = r19.getPhone()
            goto L_0x00b9
        L_0x00b5:
            java.lang.String r9 = r19.getName()
        L_0x00b9:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r4.setText(r9)
        L_0x00be:
            com.didi.component.framework.pages.invitation.presenter.InvitationTrackPresenter r4 = r0.f13855b
            r9 = 0
            if (r4 != 0) goto L_0x00c6
        L_0x00c4:
            r4 = 0
            goto L_0x00db
        L_0x00c6:
            java.lang.Long r11 = r19.getCreateTime()
            if (r11 != 0) goto L_0x00ce
            r11 = r9
            goto L_0x00d2
        L_0x00ce:
            long r11 = r11.longValue()
        L_0x00d2:
            int r4 = r4.timeBits(r11)
            r11 = 10
            if (r4 != r11) goto L_0x00c4
            r4 = 1
        L_0x00db:
            if (r4 == 0) goto L_0x00e9
            java.lang.Long r4 = r19.getCreateTime()
            if (r4 != 0) goto L_0x00e4
            goto L_0x00f4
        L_0x00e4:
            long r9 = r4.longValue()
            goto L_0x00f4
        L_0x00e9:
            java.lang.Long r4 = r19.getCreateTime()
            if (r4 != 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            long r9 = r4.longValue()
        L_0x00f4:
            java.lang.String r13 = com.didi.component.business.util.I18NUtils.getYearMonthDay(r9)
            android.content.Context r4 = r17.getContext()
            r9 = 2131953136(0x7f1305f0, float:1.9542734E38)
            java.lang.String r11 = com.didi.sdk.util.ResourcesHelper.getString(r4, r9)
            if (r11 != 0) goto L_0x0107
            r4 = r2
            goto L_0x0116
        L_0x0107:
            java.lang.String r4 = "invitedDate"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r4)
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "%s"
            java.lang.String r4 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)
        L_0x0116:
            if (r6 != 0) goto L_0x0119
            goto L_0x011e
        L_0x0119:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r6.setText(r4)
        L_0x011e:
            java.lang.Long r4 = r19.getState()
            r9 = 2
            r6 = 4
            if (r4 != 0) goto L_0x0128
            goto L_0x0158
        L_0x0128:
            long r11 = r4.longValue()
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 != 0) goto L_0x0158
            if (r8 != 0) goto L_0x0133
            goto L_0x0136
        L_0x0133:
            r8.setVisibility(r6)
        L_0x0136:
            if (r7 != 0) goto L_0x0139
            goto L_0x0142
        L_0x0139:
            java.lang.String r1 = "#2CBE6A"
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTextColor(r1)
        L_0x0142:
            if (r7 != 0) goto L_0x0146
            goto L_0x02a6
        L_0x0146:
            android.content.Context r1 = r17.getContext()
            r2 = 2131953151(0x7f1305ff, float:1.9542765E38)
            java.lang.String r1 = com.didi.sdk.util.ResourcesHelper.getString(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
            goto L_0x02a6
        L_0x0158:
            r9 = 4
            java.lang.String r11 = "#FF999999"
            if (r4 != 0) goto L_0x015f
            goto L_0x018f
        L_0x015f:
            long r12 = r4.longValue()
            int r14 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r14 != 0) goto L_0x018f
            androidx.fragment.app.FragmentActivity r1 = r17.requireActivity()
            android.content.Context r1 = (android.content.Context) r1
            r2 = 2131953124(0x7f1305e4, float:1.954271E38)
            java.lang.String r1 = com.didi.sdk.util.ResourcesHelper.getString(r1, r2)
            if (r8 != 0) goto L_0x0177
            goto L_0x017a
        L_0x0177:
            r8.setVisibility(r6)
        L_0x017a:
            if (r7 != 0) goto L_0x017d
            goto L_0x0184
        L_0x017d:
            int r2 = android.graphics.Color.parseColor(r11)
            r7.setTextColor(r2)
        L_0x0184:
            if (r7 != 0) goto L_0x0188
            goto L_0x02a6
        L_0x0188:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
            goto L_0x02a6
        L_0x018f:
            r9 = 3
            if (r4 != 0) goto L_0x0194
            goto L_0x01e4
        L_0x0194:
            long r12 = r4.longValue()
            int r14 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r14 != 0) goto L_0x01e4
            androidx.fragment.app.FragmentActivity r2 = r17.requireActivity()
            android.content.Context r2 = (android.content.Context) r2
            r3 = 2131953127(0x7f1305e7, float:1.9542716E38)
            java.lang.String r2 = com.didi.sdk.util.ResourcesHelper.getString(r2, r3)
            if (r8 != 0) goto L_0x01ac
            goto L_0x01af
        L_0x01ac:
            r8.setVisibility(r6)
        L_0x01af:
            if (r7 != 0) goto L_0x01b2
            goto L_0x01b9
        L_0x01b2:
            int r3 = android.graphics.Color.parseColor(r11)
            r7.setTextColor(r3)
        L_0x01b9:
            if (r7 != 0) goto L_0x01bc
            goto L_0x01c1
        L_0x01bc:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
        L_0x01c1:
            if (r1 != 0) goto L_0x01c4
            goto L_0x01c7
        L_0x01c4:
            r1.setVisibility(r5)
        L_0x01c7:
            androidx.fragment.app.FragmentActivity r2 = r17.requireActivity()
            android.content.Context r2 = (android.content.Context) r2
            r3 = 2131953132(0x7f1305ec, float:1.9542726E38)
            java.lang.String r2 = com.didi.sdk.util.ResourcesHelper.getString(r2, r3)
            if (r1 != 0) goto L_0x01d8
            goto L_0x02a6
        L_0x01d8:
            com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationTrackFragment$crFmmEXiSM4-8nqpR7GXSNrr48k r3 = new com.didi.component.framework.pages.invitation.fragment.-$$Lambda$InvitationTrackFragment$crFmmEXiSM4-8nqpR7GXSNrr48k
            r9 = r19
            r3.<init>(r9, r2, r1)
            r1.setOnClickListener(r3)
            goto L_0x02a6
        L_0x01e4:
            r9 = r19
            r12 = 1
            if (r4 != 0) goto L_0x01ec
            goto L_0x02a6
        L_0x01ec:
            long r14 = r4.longValue()
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x02a6
            java.lang.Boolean r1 = r19.getItemFirst()
            if (r1 != 0) goto L_0x01fc
            r1 = 0
            goto L_0x0200
        L_0x01fc:
            boolean r1 = r1.booleanValue()
        L_0x0200:
            if (r1 != 0) goto L_0x020b
            java.lang.String r1 = r19.getItemSymbol()
            java.lang.String r4 = r19.getAcquiredMoney()
            goto L_0x0213
        L_0x020b:
            java.lang.String r1 = r19.getAcquiredMoney()
            java.lang.String r4 = r19.getItemSymbol()
        L_0x0213:
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r4)
            androidx.fragment.app.FragmentActivity r4 = r17.requireActivity()
            android.content.Context r4 = (android.content.Context) r4
            r10 = 2131953112(0x7f1305d8, float:1.9542686E38)
            java.lang.String r4 = com.didi.sdk.util.ResourcesHelper.getString(r4, r10)
            if (r4 != 0) goto L_0x0228
            r1 = r2
            goto L_0x0239
        L_0x0228:
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r5] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r1 = java.lang.String.format(r4, r1)
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
        L_0x0239:
            if (r7 != 0) goto L_0x023c
            goto L_0x0243
        L_0x023c:
            int r3 = android.graphics.Color.parseColor(r11)
            r7.setTextColor(r3)
        L_0x0243:
            if (r7 != 0) goto L_0x0246
            goto L_0x024b
        L_0x0246:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r7.setText(r1)
        L_0x024b:
            com.didi.component.framework.pages.invitation.presenter.InvitationTrackPresenter r1 = r0.f13855b
            if (r1 != 0) goto L_0x0251
        L_0x024f:
            r1 = 0
            goto L_0x0268
        L_0x0251:
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Long r4 = r19.getExpireTime()
            java.lang.Integer r1 = r1.getLeftedDays(r3, r4)
            if (r1 != 0) goto L_0x0264
            goto L_0x024f
        L_0x0264:
            int r1 = r1.intValue()
        L_0x0268:
            if (r1 >= 0) goto L_0x0271
            if (r8 != 0) goto L_0x026d
            goto L_0x02a6
        L_0x026d:
            r8.setVisibility(r6)
            goto L_0x02a6
        L_0x0271:
            if (r8 != 0) goto L_0x0274
            goto L_0x0277
        L_0x0274:
            r8.setVisibility(r5)
        L_0x0277:
            if (r8 != 0) goto L_0x027a
            goto L_0x0283
        L_0x027a:
            java.lang.String r3 = "#FF000000"
            int r3 = android.graphics.Color.parseColor(r3)
            r8.setTextColor(r3)
        L_0x0283:
            android.content.Context r3 = r17.getContext()
            r4 = 2131953113(0x7f1305d9, float:1.9542688E38)
            java.lang.String r9 = com.didi.sdk.util.ResourcesHelper.getString(r3, r4)
            if (r9 != 0) goto L_0x0291
            goto L_0x029e
        L_0x0291:
            java.lang.String r11 = java.lang.String.valueOf(r1)
            r12 = 0
            r13 = 4
            r14 = 0
            java.lang.String r10 = "%2$s"
            java.lang.String r2 = kotlin.text.StringsKt.replace$default((java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (boolean) r12, (int) r13, (java.lang.Object) r14)
        L_0x029e:
            if (r8 != 0) goto L_0x02a1
            goto L_0x02a6
        L_0x02a1:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8.setText(r2)
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment.m9631b(com.didi.component.common.adapter.CommonRvVH, com.didi.component.framework.pages.invitation.item.TrackItem):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9627a(InvitationTrackFragment invitationTrackFragment, TrackItem trackItem, String str, ImageButton imageButton, View view) {
        Intrinsics.checkNotNullParameter(invitationTrackFragment, "this$0");
        Intrinsics.checkNotNullParameter(trackItem, "$item");
        Intrinsics.checkNotNullExpressionValue(str, "errorText");
        invitationTrackFragment.m9629a(trackItem, str, imageButton);
    }

    /* renamed from: c */
    private final void m9635c(CommonRvVH commonRvVH, TrackItem trackItem) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7 = null;
        TextView textView8 = commonRvVH == null ? null : commonRvVH.getTextView(R.id.invite_reward_module_see_details);
        if (commonRvVH == null) {
            textView = null;
        } else {
            textView = commonRvVH.getTextView(R.id.invite_reward_module_title);
        }
        if (textView != null) {
            textView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_reward_history_nSqa));
        }
        if (this.f13858e) {
            if (textView != null) {
                textView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_reward_history_nSqa));
            }
        } else if (textView != null) {
            textView.setText(ResourcesHelper.getString(getContext(), R.string.Global_Rider_MgM_new_campaign_page_Reward_XtSH));
        }
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        if (commonRvVH == null) {
            textView2 = null;
        } else {
            textView2 = commonRvVH.getTextView(R.id.invite_reward_module_cur_money);
        }
        if (commonRvVH == null) {
            textView3 = null;
        } else {
            textView3 = commonRvVH.getTextView(R.id.invite_reward_module_cur_money_symbol_f);
        }
        if (commonRvVH == null) {
            textView4 = null;
        } else {
            textView4 = commonRvVH.getTextView(R.id.invite_reward_module_cur_money_symbol_b);
        }
        if (commonRvVH == null) {
            textView5 = null;
        } else {
            textView5 = commonRvVH.getTextView(R.id.invite_reward_module_pending_money);
        }
        if (commonRvVH == null) {
            textView6 = null;
        } else {
            textView6 = commonRvVH.getTextView(R.id.invite_reward_module_pending_money_symbol_f);
        }
        if (commonRvVH != null) {
            textView7 = commonRvVH.getTextView(R.id.invite_reward_module_pending_money_symbol_b);
        }
        Boolean msgFirst = trackItem.getMsgFirst();
        if (msgFirst == null ? false : msgFirst.booleanValue()) {
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            if (textView4 != null) {
                textView4.setText(trackItem.getMsgSymbol());
            }
            if (textView7 != null) {
                textView7.setText(trackItem.getMsgSymbol());
            }
        } else {
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            if (textView3 != null) {
                textView3.setText(trackItem.getMsgSymbol());
            }
            if (textView6 != null) {
                textView6.setText(trackItem.getMsgSymbol());
            }
        }
        if (textView2 != null) {
            textView2.setText(trackItem.getReceivedMoney());
        }
        if (textView5 != null) {
            textView5.setText(trackItem.getRestMoney());
        }
    }

    /* renamed from: d */
    private final void m9637d(CommonRvVH commonRvVH, TrackItem trackItem) {
        TextView textView;
        TextView textView2;
        ImageButton imageButton;
        String str;
        TextView textView3 = null;
        ImageView imageView = commonRvVH == null ? null : commonRvVH.getImageView(R.id.invite_track_contacts_img);
        if (commonRvVH == null) {
            textView = null;
        } else {
            textView = commonRvVH.getTextView(R.id.invite_track_contacts_name);
        }
        if (commonRvVH == null) {
            textView2 = null;
        } else {
            textView2 = commonRvVH.getTextView(R.id.invite_track_contacts_money);
        }
        if (commonRvVH == null) {
            imageButton = null;
        } else {
            imageButton = (ImageButton) commonRvVH.getTargetView(R.id.invite_track_contacts_error);
        }
        if (commonRvVH != null) {
            textView3 = commonRvVH.getTextView(R.id.invite_track_contacts_details);
        }
        int color = ResourcesHelper.getColor(requireActivity(), R.color.g_color_606060);
        int color2 = ResourcesHelper.getColor(requireActivity(), R.color.g_color_2CBE6A);
        Drawable drawable = ResourcesHelper.getDrawable(requireActivity(), R.drawable.global_invite_code_user_logo);
        Intrinsics.checkNotNull(imageView);
        ((RequestBuilder) Glide.with((Fragment) this).load(trackItem.getImgIconUrl()).placeholder(drawable)).into(imageView);
        boolean z = false;
        if (textView != null) {
            CharSequence name = trackItem.getName();
            textView.setText(!(name == null || name.length() == 0) ? trackItem.getName() : trackItem.getPhone());
        }
        String string = ResourcesHelper.getString(requireActivity(), R.string.global_invite_code_invalid);
        Long state = trackItem.getState();
        if (state != null && state.longValue() == 1) {
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            Boolean itemFirst = trackItem.getItemFirst();
            if (itemFirst != null) {
                z = itemFirst.booleanValue();
            }
            if (!z) {
                str = Intrinsics.stringPlus(trackItem.getItemSymbol(), trackItem.getAcquiredMoney());
            } else {
                str = Intrinsics.stringPlus(trackItem.getAcquiredMoney(), trackItem.getItemSymbol());
            }
            if (textView2 != null) {
                textView2.setText(str);
            }
            if (textView3 != null) {
                textView3.setText(ResourcesHelper.getString(requireActivity(), R.string.global_invite_code_pending));
            }
            if (textView3 != null) {
                textView3.setTextColor(color);
            }
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
        } else if (state != null && state.longValue() == 2) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            if (textView3 != null) {
                textView3.setText(ResourcesHelper.getString(requireActivity(), R.string.global_invite_ride_done));
            }
            if (textView3 != null) {
                textView3.setTextColor(color2);
            }
            if (textView2 != null) {
                textView2.setTextColor(color2);
            }
        } else if (state != null && state.longValue() == 3) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener(trackItem, string, imageButton) {
                    public final /* synthetic */ TrackItem f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ ImageButton f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        InvitationTrackFragment.m9633b(InvitationTrackFragment.this, this.f$1, this.f$2, this.f$3, view);
                    }
                });
            }
            if (textView3 != null) {
                textView3.setTextColor(color);
            }
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
            if (textView3 != null) {
                textView3.setText(ResourcesHelper.getString(requireActivity(), R.string.global_invite_code_ineligible));
            }
        } else if (state != null && state.longValue() == 4) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            if (textView3 != null) {
                textView3.setTextColor(color);
            }
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
            if (textView3 != null) {
                textView3.setText(ResourcesHelper.getString(requireActivity(), R.string.global_invite_code_expired));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9633b(InvitationTrackFragment invitationTrackFragment, TrackItem trackItem, String str, ImageButton imageButton, View view) {
        Intrinsics.checkNotNullParameter(invitationTrackFragment, "this$0");
        Intrinsics.checkNotNullParameter(trackItem, "$item");
        Intrinsics.checkNotNullExpressionValue(str, "text");
        invitationTrackFragment.m9629a(trackItem, str, imageButton);
    }

    /* renamed from: a */
    private final void m9629a(TrackItem trackItem, String str, ImageButton imageButton) {
        GlobalTipsContainer globalTipsContainer = this.f13859f;
        if (globalTipsContainer != null) {
            globalTipsContainer.clearAllTips();
        }
        trackItem.setShowTips(true);
        GlobalTipsContainer globalTipsContainer2 = this.f13859f;
        if (globalTipsContainer2 != null) {
            globalTipsContainer2.showWithLocationBinded(str, imageButton, 1, 4, UiUtils.dip2px(requireActivity(), 16.0f), 0, new View.OnClickListener() {
                public final void onClick(View view) {
                    InvitationTrackFragment.m9628a(TrackItem.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9628a(TrackItem trackItem, View view) {
        Intrinsics.checkNotNullParameter(trackItem, "$item");
        trackItem.setShowTips(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m9624a(RecyclerView recyclerView) {
        boolean z;
        Integer type;
        Integer type2;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            List<TrackItem> list = this.f13863j;
            TrackItem trackItem = null;
            TrackItem trackItem2 = list == null ? null : list.get(linearLayoutManager.findFirstVisibleItemPosition());
            List<TrackItem> list2 = this.f13863j;
            if (list2 != null) {
                trackItem = list2.get(linearLayoutManager.findLastVisibleItemPosition());
            }
            boolean z2 = true;
            if (trackItem2 == null || (type2 = trackItem2.getType()) == null || type2.intValue() != 6) {
                z = false;
            } else {
                z = true;
            }
            if (z && trackItem2.isShowTips()) {
                GlobalTipsContainer globalTipsContainer = this.f13859f;
                if (globalTipsContainer != null) {
                    globalTipsContainer.clearAllTips();
                }
                trackItem2.setShowTips(false);
            }
            if (trackItem == null || (type = trackItem.getType()) == null || type.intValue() != 6) {
                z2 = false;
            }
            if (z2 && trackItem.isShowTips()) {
                GlobalTipsContainer globalTipsContainer2 = this.f13859f;
                if (globalTipsContainer2 != null) {
                    globalTipsContainer2.clearAllTips();
                }
                trackItem.setShowTips(false);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* renamed from: a */
    private final boolean m9630a() {
        if (this.f13858e) {
            List<TrackItem> list = this.f13863j;
            return (list == null ? 0 : list.size()) > 4;
        }
        List<TrackItem> list2 = this.f13863j;
        if ((list2 == null ? 0 : list2.size()) > 3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m9634b() {
        List<TrackItem> mData;
        IInvitationListener iInvitationListener = this.f13856c;
        if (iInvitationListener == null) {
            return false;
        }
        CommonRvAdapter<TrackItem> commonRvAdapter = this.f13862i;
        long j = 0;
        if (!(commonRvAdapter == null || (mData = commonRvAdapter.getMData()) == null)) {
            j = (long) mData.size();
        }
        return iInvitationListener.canLoadMore(j);
    }

    public void loadFailure() {
        ProgressBar progressBar = this.f13860g;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* renamed from: a */
    private final void m9623a(TextView textView, boolean z) {
        int color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fe7f3f);
        if (!z) {
            color = ResourcesHelper.getColor(getContext(), R.color.pe_color_fea330);
        }
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        InvitationTrackPresenter invitationTrackPresenter = this.f13855b;
        if (invitationTrackPresenter != null) {
            invitationTrackPresenter.unRegisterSubscriber();
        }
        View view = this.f13854a;
        if (view != null && (recyclerView = (RecyclerView) view.findViewById(R.id.invite_track_rv)) != null) {
            recyclerView.removeOnScrollListener(this.f13872s);
        }
    }

    public View getView() {
        return this.f13854a;
    }
}
