package com.didiglobal.p205sa.biz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.app.business.ISaTabObserver;
import com.didi.sdk.app.business.SaTabIds;
import com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager;
import com.didiglobal.p205sa.biz.tab.manager.SaTabDataManager;
import com.didiglobal.p205sa.biz.tab.manager.SaTabTrackManager;
import com.didiglobal.p205sa.biz.tab.model.SaTabArrowModel;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00041234B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001bH\u0016J\u001a\u0010)\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010*\u001a\u00020\t2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\u0006\u0010.\u001a\u00020\u001bJ\u0010\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/sdk/app/business/ISaTabObserver;", "()V", "onTabItemClickListener", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "refreshTabNotification", "Lkotlin/Function1;", "Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;", "", "getRefreshTabNotification", "()Lkotlin/jvm/functions/Function1;", "setRefreshTabNotification", "(Lkotlin/jvm/functions/Function1;)V", "tabAdapter", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabAdapter;", "tabList", "Landroidx/recyclerview/widget/RecyclerView;", "initData", "initView", "view", "Landroid/view/View;", "notifyTabDown", "groupId", "", "notifyTabRedPoint", "show", "", "notifyTabTip", "tip", "notifyTabUp", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onHiddenChanged", "hidden", "onViewCreated", "refreshTab", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "Lkotlin/collections/ArrayList;", "isClick", "setOnTabItemClickListener", "listener", "OnTabItemClickListener", "TabAdapter", "TabModel", "TabViewHolder", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment */
/* compiled from: SaTabFragment.kt */
public final class SaTabFragment extends Fragment implements ISaTabObserver {

    /* renamed from: a */
    private RecyclerView f51208a;

    /* renamed from: b */
    private final TabAdapter f51209b = new TabAdapter();

    /* renamed from: c */
    private OnTabItemClickListener f51210c;

    /* renamed from: d */
    private Function1<? super SaTabDataModel, Unit> f51211d;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "", "onClick", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "position", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$OnTabItemClickListener */
    /* compiled from: SaTabFragment.kt */
    public interface OnTabItemClickListener {
        void onClick(TabModel tabModel, int i);
    }

    public final Function1<SaTabDataModel, Unit> getRefreshTabNotification() {
        return this.f51211d;
    }

    public final void setRefreshTabNotification(Function1<? super SaTabDataModel, Unit> function1) {
        this.f51211d = function1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_sa_tab, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        m36679a(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m36678a();
        SaTabDataManager.INSTANCE.init(new SaTabFragment$onViewCreated$1(this));
        SaTabDataManager.INSTANCE.registerListener();
        SaTabTrackManager.INSTANCE.onCreate();
    }

    /* renamed from: a */
    private final void m36679a(View view) {
        this.f51208a = (RecyclerView) view.findViewById(R.id.tabList);
    }

    /* renamed from: a */
    private final void m36678a() {
        SaTabBusinessRedPointManager.INSTANCE.addObserver(this);
        TabAdapter tabAdapter = this.f51209b;
        if (tabAdapter != null) {
            tabAdapter.setOnTabItemClickListener(this.f51210c);
        }
        RecyclerView recyclerView = this.f51208a;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f51209b);
        }
        refreshTab(SaTabDataManager.getTabData$default(SaTabDataManager.INSTANCE, SaTabIds.TAB_HOME.getId(), (SaTabDataModel) null, 2, (Object) null), false);
    }

    public final void refreshTab(ArrayList<TabModel> arrayList, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "tabList");
        if (!z) {
            SaTabTrackManager.INSTANCE.trackShow(arrayList);
        }
        TabAdapter tabAdapter = this.f51209b;
        if (tabAdapter != null) {
            tabAdapter.setData(arrayList);
        }
        TabAdapter tabAdapter2 = this.f51209b;
        if (tabAdapter2 != null) {
            tabAdapter2.notifyDataSetChanged();
        }
    }

    public final void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener) {
        this.f51210c = onTabItemClickListener;
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\u000e2\u0018\b\u0001\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0010\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\tR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "Lkotlin/collections/ArrayList;", "onTabItemClickListener", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "getData", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "setOnTabItemClickListener", "listener", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter */
    /* compiled from: SaTabFragment.kt */
    public static final class TabAdapter extends RecyclerView.Adapter<TabViewHolder> {
        private final ArrayList<TabModel> dataList = new ArrayList<>();
        /* access modifiers changed from: private */
        public OnTabItemClickListener onTabItemClickListener;

        public final void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener2) {
            this.onTabItemClickListener = onTabItemClickListener2;
        }

        public final void setData(ArrayList<TabModel> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "data");
            this.dataList.clear();
            this.dataList.addAll(arrayList);
        }

        public final ArrayList<TabModel> getData() {
            return this.dataList;
        }

        public TabViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Context context = viewGroup.getContext();
            int size = this.dataList.size() > 0 ? this.dataList.size() : 1;
            View inflate = LayoutInflater.from(context).inflate(R.layout.vh_tab, (ViewGroup) null);
            UiUtils uiUtils = UiUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            inflate.setLayoutParams(new ViewGroup.LayoutParams(uiUtils.getScreenWidth(context) / size, -2));
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new TabViewHolder(inflate);
        }

        public void onBindViewHolder(TabViewHolder tabViewHolder, int i) {
            Intrinsics.checkNotNullParameter(tabViewHolder, "holder");
            TabModel tabModel = this.dataList.get(i);
            Intrinsics.checkNotNullExpressionValue(tabModel, "dataList[position]");
            tabViewHolder.bindData(tabModel, i, new SaTabFragment$TabAdapter$onBindViewHolder$1(this));
        }

        public int getItemCount() {
            return this.dataList.size();
        }
    }

    @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "redPoint", "rootView", "tipPoint", "Landroid/widget/TextView;", "title", "bindData", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "position", "", "listener", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$OnTabItemClickListener;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$TabViewHolder */
    /* compiled from: SaTabFragment.kt */
    public static final class TabViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private ImageView redPoint;
        private View rootView;
        private TextView tipPoint;
        private TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TabViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.title = (TextView) view.findViewById(R.id.title);
            this.redPoint = (ImageView) view.findViewById(R.id.redPoint);
            this.tipPoint = (TextView) view.findViewById(R.id.tipPoint);
            this.rootView = view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x010e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bindData(com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel r23, int r24, com.didiglobal.p205sa.biz.fragment.SaTabFragment.OnTabItemClickListener r25) {
            /*
                r22 = this;
                r0 = r22
                r1 = r23
                java.lang.String r2 = "data"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                com.didiglobal.sa.biz.tab.model.SaTabMenuModel r2 = r23.getTabMenu()
                com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel$TabPointInfo r3 = r23.getTabPointInfo()
                java.lang.String r4 = ""
                r5 = 1
                r6 = 0
                if (r3 == 0) goto L_0x0063
                java.lang.String r7 = r3.getTipPoint()
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L_0x0063
                android.widget.TextView r7 = r0.tipPoint
                if (r7 != 0) goto L_0x0028
                goto L_0x002b
            L_0x0028:
                r7.setVisibility(r6)
            L_0x002b:
                java.lang.String r7 = r3.getTipPoint()
                int r7 = r7.length()
                if (r7 != r5) goto L_0x003e
                android.widget.TextView r7 = r0.tipPoint
                if (r7 != 0) goto L_0x003a
                goto L_0x0054
            L_0x003a:
                r7.setPadding(r6, r6, r6, r6)
                goto L_0x0054
            L_0x003e:
                com.didiglobal.sa.biz.util.UiUtils r7 = com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE
                android.app.Application r8 = com.didi.sdk.app.DIDIApplication.getAppContext()
                android.content.Context r8 = (android.content.Context) r8
                r9 = 1086324736(0x40c00000, float:6.0)
                int r7 = r7.dip2px(r8, r9)
                android.widget.TextView r8 = r0.tipPoint
                if (r8 != 0) goto L_0x0051
                goto L_0x0054
            L_0x0051:
                r8.setPadding(r7, r6, r7, r6)
            L_0x0054:
                android.widget.TextView r7 = r0.tipPoint
                if (r7 != 0) goto L_0x0059
                goto L_0x0078
            L_0x0059:
                java.lang.String r3 = r3.getTipPoint()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r7.setText(r3)
                goto L_0x0078
            L_0x0063:
                android.widget.TextView r3 = r0.tipPoint
                if (r3 != 0) goto L_0x0068
                goto L_0x006e
            L_0x0068:
                r7 = r4
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r3.setText(r7)
            L_0x006e:
                android.widget.TextView r3 = r0.tipPoint
                if (r3 != 0) goto L_0x0073
                goto L_0x0078
            L_0x0073:
                r7 = 8
                r3.setVisibility(r7)
            L_0x0078:
                android.widget.ImageView r3 = r0.icon
                if (r3 != 0) goto L_0x007e
                goto L_0x0111
            L_0x007e:
                com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel$TabPointInfo r7 = r23.getTabPointInfo()
                if (r7 != 0) goto L_0x0086
            L_0x0084:
                r7 = 0
                goto L_0x008d
            L_0x0086:
                boolean r7 = r7.isUp()
                if (r7 != r5) goto L_0x0084
                r7 = 1
            L_0x008d:
                if (r7 == 0) goto L_0x00a2
                boolean r7 = r23.isClicked()
                if (r7 == 0) goto L_0x00a2
                com.didiglobal.sa.biz.tab.model.SaTabArrowModel r4 = r23.getArrowStyle()
                if (r4 != 0) goto L_0x009d
                r4 = 0
                goto L_0x00b7
            L_0x009d:
                java.lang.String r4 = r4.getIcon()
                goto L_0x00b7
            L_0x00a2:
                boolean r7 = r23.isClicked()
                if (r7 == 0) goto L_0x00b5
                if (r2 != 0) goto L_0x00ac
            L_0x00aa:
                r7 = 1
                goto L_0x00c2
            L_0x00ac:
                java.lang.String r7 = r2.getIconActive()
                if (r7 != 0) goto L_0x00b3
                goto L_0x00aa
            L_0x00b3:
                r4 = r7
                goto L_0x00aa
            L_0x00b5:
                if (r2 != 0) goto L_0x00b9
            L_0x00b7:
                r7 = 0
                goto L_0x00c2
            L_0x00b9:
                java.lang.String r7 = r2.getIcon()
                if (r7 != 0) goto L_0x00c0
                goto L_0x00b7
            L_0x00c0:
                r4 = r7
                goto L_0x00b7
            L_0x00c2:
                android.app.Application r8 = com.didi.sdk.app.DIDIApplication.getAppContext()
                android.content.Context r8 = (android.content.Context) r8
                com.bumptech.glide.RequestManager r8 = com.bumptech.glide.Glide.with((android.content.Context) r8)
                com.bumptech.glide.RequestBuilder r4 = r8.load((java.lang.String) r4)
                r8 = 2131235324(0x7f0811fc, float:1.8086839E38)
                com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder((int) r8)
                com.bumptech.glide.RequestBuilder r4 = (com.bumptech.glide.RequestBuilder) r4
                r4.into((android.widget.ImageView) r3)
                if (r7 == 0) goto L_0x010e
                r8 = 0
                r9 = 1065353216(0x3f800000, float:1.0)
                r10 = 0
                r11 = 1065353216(0x3f800000, float:1.0)
                int r4 = r3.getWidth()
                int r4 = r4 / 2
                float r12 = (float) r4
                int r4 = r3.getHeight()
                int r4 = r4 / 2
                float r13 = (float) r4
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r14 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT
                r15 = 0
                r16 = 0
                r17 = 400(0x190, double:1.976E-321)
                r19 = 0
                r20 = 0
                r21 = 0
                android.view.animation.ScaleAnimation r4 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.getScaleAnimation(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r21)
                java.lang.String r7 = "getScaleAnimation(\n     …ull\n                    )"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
                android.view.animation.Animation r4 = (android.view.animation.Animation) r4
                r3.startAnimation(r4)
                goto L_0x0111
            L_0x010e:
                r3.clearAnimation()
            L_0x0111:
                android.widget.TextView r3 = r0.title
                if (r3 != 0) goto L_0x0116
                goto L_0x0160
            L_0x0116:
                com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel$TabPointInfo r4 = r23.getTabPointInfo()
                if (r4 != 0) goto L_0x011e
            L_0x011c:
                r4 = 0
                goto L_0x0125
            L_0x011e:
                boolean r4 = r4.isUp()
                if (r4 != r5) goto L_0x011c
                r4 = 1
            L_0x0125:
                if (r4 == 0) goto L_0x013f
                boolean r4 = r23.isClicked()
                if (r4 == 0) goto L_0x013f
                com.didiglobal.sa.biz.tab.model.SaTabArrowModel r2 = r23.getArrowStyle()
                if (r2 != 0) goto L_0x0134
                goto L_0x0160
            L_0x0134:
                com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.getText()
                if (r2 != 0) goto L_0x013b
                goto L_0x0160
            L_0x013b:
                r2.bindTextView(r3)
                goto L_0x0160
            L_0x013f:
                boolean r4 = r23.isClicked()
                if (r4 == 0) goto L_0x0153
                if (r2 != 0) goto L_0x0148
                goto L_0x0160
            L_0x0148:
                com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.getTabNameActive()
                if (r2 != 0) goto L_0x014f
                goto L_0x0160
            L_0x014f:
                r2.bindTextView(r3)
                goto L_0x0160
            L_0x0153:
                if (r2 != 0) goto L_0x0156
                goto L_0x0160
            L_0x0156:
                com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.getTabName()
                if (r2 != 0) goto L_0x015d
                goto L_0x0160
            L_0x015d:
                r2.bindTextView(r3)
            L_0x0160:
                android.widget.TextView r2 = r0.tipPoint
                if (r2 != 0) goto L_0x0166
            L_0x0164:
                r5 = 0
                goto L_0x016c
            L_0x0166:
                int r2 = r2.getVisibility()
                if (r2 != 0) goto L_0x0164
            L_0x016c:
                com.didiglobal.sa.biz.tab.manager.SaTabHotInfoManager r2 = new com.didiglobal.sa.biz.tab.manager.SaTabHotInfoManager
                r2.<init>(r1)
                android.widget.ImageView r3 = r0.redPoint
                r2.updateHot(r3, r5)
                android.view.View r2 = r0.rootView
                if (r2 != 0) goto L_0x017b
                goto L_0x0187
            L_0x017b:
                com.didiglobal.sa.biz.fragment.-$$Lambda$SaTabFragment$TabViewHolder$szqvK7kz93X3VBtM7pyLDjmwXpM r3 = new com.didiglobal.sa.biz.fragment.-$$Lambda$SaTabFragment$TabViewHolder$szqvK7kz93X3VBtM7pyLDjmwXpM
                r4 = r24
                r5 = r25
                r3.<init>(r1, r4)
                r2.setOnClickListener(r3)
            L_0x0187:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabViewHolder.bindData(com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel, int, com.didiglobal.sa.biz.fragment.SaTabFragment$OnTabItemClickListener):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: bindData$lambda-2  reason: not valid java name */
        public static final void m47060bindData$lambda2(OnTabItemClickListener onTabItemClickListener, TabModel tabModel, int i, View view) {
            Intrinsics.checkNotNullParameter(tabModel, "$data");
            if (onTabItemClickListener != null) {
                onTabItemClickListener.onClick(tabModel, i);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "", "()V", "arrowStyle", "Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;", "getArrowStyle", "()Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;", "setArrowStyle", "(Lcom/didiglobal/sa/biz/tab/model/SaTabArrowModel;)V", "isClicked", "", "()Z", "setClicked", "(Z)V", "tabMenu", "Lcom/didiglobal/sa/biz/tab/model/SaTabMenuModel;", "getTabMenu", "()Lcom/didiglobal/sa/biz/tab/model/SaTabMenuModel;", "setTabMenu", "(Lcom/didiglobal/sa/biz/tab/model/SaTabMenuModel;)V", "tabPointInfo", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel$TabPointInfo;", "getTabPointInfo", "()Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel$TabPointInfo;", "setTabPointInfo", "(Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel$TabPointInfo;)V", "TabPointInfo", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel */
    /* compiled from: SaTabFragment.kt */
    public static final class TabModel {
        private SaTabArrowModel arrowStyle;
        private boolean isClicked;
        private SaTabMenuModel tabMenu;
        private TabPointInfo tabPointInfo;

        public final SaTabMenuModel getTabMenu() {
            return this.tabMenu;
        }

        public final void setTabMenu(SaTabMenuModel saTabMenuModel) {
            this.tabMenu = saTabMenuModel;
        }

        public final boolean isClicked() {
            return this.isClicked;
        }

        public final void setClicked(boolean z) {
            this.isClicked = z;
        }

        public final TabPointInfo getTabPointInfo() {
            return this.tabPointInfo;
        }

        public final void setTabPointInfo(TabPointInfo tabPointInfo2) {
            this.tabPointInfo = tabPointInfo2;
        }

        public final SaTabArrowModel getArrowStyle() {
            return this.arrowStyle;
        }

        public final void setArrowStyle(SaTabArrowModel saTabArrowModel) {
            this.arrowStyle = saTabArrowModel;
        }

        @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel$TabPointInfo;", "Ljava/io/Serializable;", "()V", "hasPoint", "", "getHasPoint", "()Z", "setHasPoint", "(Z)V", "isUp", "setUp", "tipPoint", "", "getTipPoint", "()Ljava/lang/String;", "setTipPoint", "(Ljava/lang/String;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* renamed from: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel$TabPointInfo */
        /* compiled from: SaTabFragment.kt */
        public static final class TabPointInfo implements Serializable {
            private boolean hasPoint;
            private boolean isUp;
            private String tipPoint = "";

            public final boolean getHasPoint() {
                return this.hasPoint;
            }

            public final void setHasPoint(boolean z) {
                this.hasPoint = z;
            }

            public final String getTipPoint() {
                return this.tipPoint;
            }

            public final void setTipPoint(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.tipPoint = str;
            }

            public final boolean isUp() {
                return this.isUp;
            }

            public final void setUp(boolean z) {
                this.isUp = z;
            }
        }
    }

    public void notifyTabRedPoint(String str, boolean z) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(str, "groupId");
        View targetView = SaTabBusinessRedPointManager.INSTANCE.getTargetView(str, this.f51208a, this.f51209b.getData());
        if (targetView != null && (imageView = (ImageView) targetView.findViewById(R.id.redPoint)) != null) {
            if (z) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.icon_sa_tab_reddot);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void notifyTabTip(String str, String str2) {
        TextView textView;
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(str2, "tip");
        View targetView = SaTabBusinessRedPointManager.INSTANCE.getTargetView(str, this.f51208a, this.f51209b.getData());
        if (targetView != null && (textView = (TextView) targetView.findViewById(R.id.tipPoint)) != null) {
            CharSequence charSequence = str2;
            if (!TextUtils.isEmpty(charSequence)) {
                if (str2.length() == 1) {
                    textView.setPadding(0, 0, 0, 0);
                } else {
                    int dip2px = UiUtils.INSTANCE.dip2px(getContext(), 6.0f);
                    textView.setPadding(dip2px, 0, dip2px, 0);
                }
                textView.setVisibility(0);
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyTabUp(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "groupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r0 = r5.f51209b
            java.util.ArrayList r0 = r0.getData()
            if (r0 != 0) goto L_0x000f
            goto L_0x00a8
        L_0x000f:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r3 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r3
            r4 = r6
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r3.getTabMenu()
            if (r3 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            java.lang.String r2 = r3.getTabId()
        L_0x0031:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.equals(r4, r2)
            if (r2 == 0) goto L_0x0015
            r2 = r1
        L_0x003a:
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r2 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r2
            if (r2 != 0) goto L_0x003f
            goto L_0x00a8
        L_0x003f:
            com.didiglobal.sa.biz.tab.model.SaTabArrowModel r0 = r2.getArrowStyle()
            if (r0 != 0) goto L_0x0046
            goto L_0x00a8
        L_0x0046:
            com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager r1 = com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager.INSTANCE
            androidx.recyclerview.widget.RecyclerView r2 = r5.f51208a
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r3 = r5.f51209b
            java.util.ArrayList r3 = r3.getData()
            android.view.View r1 = r1.getTargetView(r6, r2, r3)
            if (r1 != 0) goto L_0x0057
            goto L_0x0081
        L_0x0057:
            r2 = 2131431294(0x7f0b0f7e, float:1.8484313E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 != 0) goto L_0x0063
            goto L_0x0081
        L_0x0063:
            android.app.Application r2 = com.didi.sdk.app.DIDIApplication.getAppContext()
            android.content.Context r2 = (android.content.Context) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
            java.lang.String r3 = r0.getIcon()
            com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r3)
            r3 = 2131235324(0x7f0811fc, float:1.8086839E38)
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder((int) r3)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            r2.into((android.widget.ImageView) r1)
        L_0x0081:
            com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager r1 = com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager.INSTANCE
            androidx.recyclerview.widget.RecyclerView r2 = r5.f51208a
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r3 = r5.f51209b
            java.util.ArrayList r3 = r3.getData()
            android.view.View r6 = r1.getTargetView(r6, r2, r3)
            if (r6 != 0) goto L_0x0092
            goto L_0x00a8
        L_0x0092:
            r1 = 2131434585(0x7f0b1c59, float:1.8490988E38)
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 != 0) goto L_0x009e
            goto L_0x00a8
        L_0x009e:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r0.getText()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            r0.bindTextView(r6)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.fragment.SaTabFragment.notifyTabUp(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyTabDown(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "groupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r0 = r5.f51209b
            java.util.ArrayList r0 = r0.getData()
            if (r0 != 0) goto L_0x000f
            goto L_0x00a8
        L_0x000f:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r3 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r3
            r4 = r6
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r3.getTabMenu()
            if (r3 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            java.lang.String r2 = r3.getTabId()
        L_0x0031:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.equals(r4, r2)
            if (r2 == 0) goto L_0x0015
            r2 = r1
        L_0x003a:
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r2 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r2
            if (r2 != 0) goto L_0x003f
            goto L_0x00a8
        L_0x003f:
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r0 = r2.getTabMenu()
            if (r0 != 0) goto L_0x0046
            goto L_0x00a8
        L_0x0046:
            com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager r1 = com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager.INSTANCE
            androidx.recyclerview.widget.RecyclerView r2 = r5.f51208a
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r3 = r5.f51209b
            java.util.ArrayList r3 = r3.getData()
            android.view.View r1 = r1.getTargetView(r6, r2, r3)
            if (r1 != 0) goto L_0x0057
            goto L_0x0081
        L_0x0057:
            r2 = 2131431294(0x7f0b0f7e, float:1.8484313E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 != 0) goto L_0x0063
            goto L_0x0081
        L_0x0063:
            android.app.Application r2 = com.didi.sdk.app.DIDIApplication.getAppContext()
            android.content.Context r2 = (android.content.Context) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r2)
            java.lang.String r3 = r0.getIconActive()
            com.bumptech.glide.RequestBuilder r2 = r2.load((java.lang.String) r3)
            r3 = 2131235324(0x7f0811fc, float:1.8086839E38)
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder((int) r3)
            com.bumptech.glide.RequestBuilder r2 = (com.bumptech.glide.RequestBuilder) r2
            r2.into((android.widget.ImageView) r1)
        L_0x0081:
            com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager r1 = com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager.INSTANCE
            androidx.recyclerview.widget.RecyclerView r2 = r5.f51208a
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabAdapter r3 = r5.f51209b
            java.util.ArrayList r3 = r3.getData()
            android.view.View r6 = r1.getTargetView(r6, r2, r3)
            if (r6 != 0) goto L_0x0092
            goto L_0x00a8
        L_0x0092:
            r1 = 2131434585(0x7f0b1c59, float:1.8490988E38)
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 != 0) goto L_0x009e
            goto L_0x00a8
        L_0x009e:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r0 = r0.getTabNameActive()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            r0.bindTextView(r6)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.fragment.SaTabFragment.notifyTabDown(java.lang.String):void");
    }

    public void onDestroy() {
        super.onDestroy();
        SaTabBusinessRedPointManager.INSTANCE.removeObserver(this);
        SaTabDataManager.INSTANCE.unregisterListener();
        SaTabTrackManager.INSTANCE.onDestroy();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        SaTabDataManager.INSTANCE.onHiddenChanged(z);
        SaTabTrackManager.INSTANCE.onHiddenChanged(z);
    }
}
