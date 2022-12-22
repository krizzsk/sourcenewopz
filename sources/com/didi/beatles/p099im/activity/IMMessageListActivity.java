package com.didi.beatles.p099im.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMStageFeedBack;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.adapter.ChatAdapter;
import com.didi.beatles.p099im.common.IMLifecycleHandler;
import com.didi.beatles.p099im.common.IMPollingService;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMPollingUtils;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.views.IMChoiceTitleBar;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMMessageListActivity */
public abstract class IMMessageListActivity extends IMBaseActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, IMSessionCallback {
    protected static final String EXTRA_SESSION = "sessin_type";
    protected static final int IM_HISTORY_TYPE = -1;
    public int CHOICE_MODE = 1;
    public int SELECT_MODE = 0;

    /* renamed from: a */
    ConnectionChangeReceiver f8972a;

    /* renamed from: b */
    private ChatAdapter f8973b;

    /* renamed from: c */
    private ListView f8974c;

    /* renamed from: d */
    private List<IMSession> f8975d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f8976e;

    /* renamed from: f */
    private ImageView f8977f;

    /* renamed from: g */
    private LinearLayout f8978g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f8979h;
    protected RelativeLayout headerInfoLayout;
    protected TextView headerInfoView;

    /* renamed from: i */
    private ProgressBar f8980i;
    protected boolean isValidList = false;

    /* renamed from: j */
    private IMChoiceTitleBar f8981j;

    /* renamed from: k */
    private HashMap<Integer, View> f8982k = new HashMap<>();

    /* renamed from: l */
    private int f8983l;
    public IMLifecycleHandler.Controller mController;
    protected int mNeedSessionType;
    protected IIMSessionModule mSessionModule;
    protected TextView noMessageWording;
    protected CommonTitleBar titleBar;

    public List<IMSession> addFootView(List<IMSession> list) {
        return list;
    }

    /* access modifiers changed from: protected */
    public String getNoMsgWording() {
        return "";
    }

    public void handleEmptyCheckOverDueView(View view) {
    }

    public void handleHeaderInfoView() {
    }

    /* access modifiers changed from: protected */
    public void initTitle() {
    }

    /* access modifiers changed from: protected */
    public void loadSessionAsync() {
    }

    /* access modifiers changed from: protected */
    public abstract void parseIntent();

    public List<IMSession> removeFootView(List<IMSession> list) {
        return list;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.bts_im_fragment_chat);
        parseIntent();
        m6070a();
        this.mController = IMLifecycleHandler.attach(this);
        m6077c();
        m6083g();
        m6074b();
        m6082f();
        EventBus.getDefault().register(this);
        NotificationUtils.cancelNotification();
    }

    /* renamed from: a */
    private void m6070a() {
        this.f8980i = (ProgressBar) findViewById(R.id.progress_bar);
        View findViewById = findViewById(R.id.layout_no_chat);
        this.f8976e = findViewById;
        this.noMessageWording = (TextView) findViewById.findViewById(R.id.tv_im_no_chat_tip1);
        this.f8978g = (LinearLayout) this.f8976e.findViewById(R.id.im_no_msg_ll);
        ImageView imageView = (ImageView) this.f8976e.findViewById(R.id.tv_im_no_chat_tip);
        this.f8977f = imageView;
        imageView.setImageResource(IMResource.getDrawableID(R.drawable.im_no_msg_bg));
        this.f8979h = (TextView) findViewById(R.id.layout_no_network);
        this.headerInfoView = (TextView) findViewById(R.id.im_msg_list_header_tv);
        this.headerInfoLayout = (RelativeLayout) findViewById(R.id.im_msg_list_header_layout);
        handleHeaderInfoView();
        this.f8979h.setText(getString(R.string.bts_im_no_network));
        this.f8974c = (ListView) findViewById(R.id.ContactListView);
    }

    /* renamed from: b */
    private void m6074b() {
        IMChoiceTitleBar iMChoiceTitleBar = (IMChoiceTitleBar) findViewById(R.id.im_choice_bar);
        this.f8981j = iMChoiceTitleBar;
        iMChoiceTitleBar.getLeftImgView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.m6073a(false, true);
            }
        });
        this.f8981j.getRightTextView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.m6084h();
            }
        });
    }

    /* renamed from: c */
    private void m6077c() {
        ChatAdapter chatAdapter = new ChatAdapter(this, new ChatAdapter.OnDataListener() {
            public void onDataChange(boolean z) {
                IMMessageListActivity.this.hideProgressBar();
                if (z) {
                    IMMessageListActivity.this.m6078d();
                    IMMessageListActivity iMMessageListActivity = IMMessageListActivity.this;
                    iMMessageListActivity.handleEmptyCheckOverDueView(iMMessageListActivity.f8976e);
                    return;
                }
                IMMessageListActivity.this.m6081e();
            }
        });
        this.f8973b = chatAdapter;
        this.f8974c.setAdapter(chatAdapter);
        this.f8974c.setOnItemClickListener(this);
        this.f8974c.setOnItemLongClickListener(this);
        m6085i();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6078d() {
        LinearLayout linearLayout = this.f8978g;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.noMessageWording;
        if (textView != null) {
            textView.setText(getNoMsgWording());
        }
        View view = this.f8976e;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6081e() {
        View view = this.f8976e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateEvent(IMSessionInfoUpdateEvent iMSessionInfoUpdateEvent) {
        if (iMSessionInfoUpdateEvent.imSessionList != null && iMSessionInfoUpdateEvent.imSessionList.size() > 0) {
            loadSessionAsync();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateErrorEvent(IMSessionInfoUpdateErrorEvent iMSessionInfoUpdateErrorEvent) {
        if (iMSessionInfoUpdateErrorEvent.errorStatusCode == 111) {
            loadSessionAsync();
        }
    }

    /* renamed from: f */
    private void m6082f() {
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        this.mSessionModule = sessionModel;
        if (sessionModel != null) {
            m6086j();
        }
    }

    /* renamed from: g */
    private void m6083g() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.im_title_bar);
        this.titleBar = commonTitleBar;
        commonTitleBar.initResource();
        initTitle();
        this.titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        EventBus.getDefault().unregister(this);
        if (IMManager.getInstance().getUserModel() != null) {
            IMManager.getInstance().getUserModel().clearHolders();
        }
        m6087k();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IIMSessionModule iIMSessionModule = this.mSessionModule;
        if (iIMSessionModule != null) {
            iIMSessionModule.registerSessionCallback(this);
        }
        if (this.SELECT_MODE != 1) {
            loadSessionAsync();
        }
        IMManager.getInstance().pullMessage(0, 0, 2);
        IMPollingUtils.startPollingService(this, 60, IMPollingService.class, IMPollingService.ACTION);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        IIMSessionModule iIMSessionModule = this.mSessionModule;
        if (iIMSessionModule != null) {
            iIMSessionModule.unregisterSessionCallback(this);
        }
        IMManager.getInstance().clearIMRedDot();
        IMPollingUtils.stopPollingService(this, IMPollingService.class, IMPollingService.ACTION);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        try {
            if (this.SELECT_MODE == this.CHOICE_MODE) {
                checkItemChoice(i, view);
                return;
            }
            IMSession iMSession = this.f8975d.get(i);
            if (iMSession != null) {
                IMStageFeedBack.OutFeedBackData outFeedBackData = new IMStageFeedBack.OutFeedBackData();
                outFeedBackData.setUid(Long.valueOf(iMSession.getPeerUid()));
                outFeedBackData.setSid(Long.valueOf(iMSession.getSessionId()));
                if (IMStageFeedBackListerManager.INSTANCE.notifyListeners(this, IMStageFeedBack.IMStage.IM_OLD_MESSAGE_LIST_ITEM_CLICK, outFeedBackData)) {
                    if (this.mSessionModule != null) {
                        this.mSessionModule.clearSessionsUnreadCount(new long[]{iMSession.getSessionId()});
                    }
                    IMLog.m6635i("intercept: IMStageFeedBack.IMStage.IM_OLD_MESSAGE_LIST_ITEM_CLICK", new Object[0]);
                    return;
                }
            }
            if (iMSession.getType() == -1) {
                m6073a(false, false);
                IMEngine.startOverdueChatListActivity(this);
                return;
            }
            OmegaUtil.trackMsgCenterOmega(iMSession.getType(), iMSession.getSessionId());
            if (iMSession != null) {
                IMBusinessParam iMBusinessParam = new IMBusinessParam();
                iMBusinessParam.setSessionId(iMSession.getSessionId());
                iMBusinessParam.setSelfUid(IMSession.getSelfId(iMSession.getUserIds()).longValue());
                iMBusinessParam.setPeerUid(IMSession.getPeerId(iMSession.getUserIds()).longValue());
                iMBusinessParam.setBusinessId(iMSession.getBusinessId());
                iMBusinessParam.setUserDraft(iMSession.getDraft());
                iMBusinessParam.setSessionType(iMSession.getType());
                iMBusinessParam.setSourceId(10);
                IMEngine.startChatDetailActivity(this, iMBusinessParam, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSessionOptionResult(List<IMSession> list, int i) {
        if (i == 3) {
            List<IMSession> list2 = this.f8975d;
            if (list2 != null) {
                list2.removeAll(list);
                this.f8973b.setData(this.f8975d);
            }
            List<IMSession> list3 = this.f8975d;
            if (list3 != null && list3.size() == 1) {
                List<IMSession> list4 = this.f8975d;
                if (list4.get(list4.size() - 1).getType() == -1) {
                    removeFootView(this.f8975d);
                }
            }
            ChatAdapter chatAdapter = this.f8973b;
            if (chatAdapter != null) {
                chatAdapter.setData(this.f8975d);
                return;
            }
            return;
        }
        IMToastHelper.showLongError((Context) this, getString(R.string.bts_im_delete_fail));
    }

    public void onSessionLoad(List<IMSession> list) {
        if (this.SELECT_MODE == this.CHOICE_MODE) {
            m6073a(false, true);
        }
        hideProgressBar();
        if (list != null) {
            IMLog.m6631d("", "IMMessageListActivity onSessionLoad:" + list.size());
        } else {
            IMLog.m6631d("", "IMMessageListActivity onSessionLoad null");
        }
        List<IMSession> list2 = this.f8975d;
        if (list2 != null) {
            list2.clear();
        }
        this.f8975d = list;
        if (!IMTextUtil.isEmpty((Collection<?>) list)) {
            Collections.sort(this.f8975d);
            IIMSessionModule iIMSessionModule = this.mSessionModule;
            if (iIMSessionModule == null || !iIMSessionModule.isHaveOverDueMessage(list.size())) {
                this.f8975d = removeFootView(this.f8975d);
            } else {
                this.f8975d = addFootView(this.f8975d);
            }
            this.f8973b.setData(this.f8975d);
            return;
        }
        List<IMSession> removeFootView = removeFootView(this.f8975d);
        this.f8975d = removeFootView;
        this.f8973b.setData(removeFootView);
    }

    public boolean isValidListUI() {
        return this.isValidList;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        IMSession item = this.f8973b.getItem(i);
        if (item != null && item.getType() == -1) {
            return true;
        }
        try {
            m6073a(true, true);
            if (this.SELECT_MODE == this.CHOICE_MODE) {
                checkItemChoice(i, view);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void checkItemChoice(int i, View view) {
        ChatAdapter.ContactViewHolder contactViewHolder = (ChatAdapter.ContactViewHolder) view.getTag();
        contactViewHolder.checkBox.toggle();
        if (contactViewHolder.checkBox.isChecked()) {
            this.f8973b.getIsSelected().put(Integer.valueOf(i), true);
            this.f8982k.put(Integer.valueOf(i), view);
            this.f8983l++;
        } else {
            this.f8973b.getIsSelected().put(Integer.valueOf(i), false);
            this.f8982k.remove(Integer.valueOf(i));
            this.f8983l--;
        }
        this.f8981j.setChoiceCount(this.f8983l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6073a(boolean z, boolean z2) {
        if (z) {
            this.SELECT_MODE = this.CHOICE_MODE;
            this.f8981j.setChoiceCount(0);
            this.f8973b.setChoiceMode(this.SELECT_MODE);
            this.titleBar.setVisibility(8);
            this.f8981j.showChoiceBar();
            this.f8975d = removeFootView(this.f8975d);
        } else {
            this.SELECT_MODE = 0;
            this.f8973b.setChoiceMode(0);
            this.titleBar.setVisibility(0);
            this.f8981j.hideChoiceBar();
            this.f8973b.getIsSelected().clear();
            this.f8983l = 0;
            if (!IMTextUtil.isEmpty((Collection<?>) this.f8975d) && z2) {
                IIMSessionModule iIMSessionModule = this.mSessionModule;
                if (iIMSessionModule == null || !iIMSessionModule.isHaveOverDueMessage(0)) {
                    this.f8975d = removeFootView(this.f8975d);
                } else {
                    this.f8975d = addFootView(this.f8975d);
                }
            }
        }
        handleHeaderInfoView();
        this.f8973b.setData(this.f8975d);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6084h() {
        List<IMSession> list = this.f8975d;
        if (list != null && list.size() >= 0) {
            ArrayList arrayList = new ArrayList();
            if (this.f8973b.getIsSelected().size() > 0) {
                for (Integer next : this.f8973b.getIsSelected().keySet()) {
                    if (this.f8973b.isChecked(next.intValue())) {
                        if (next.intValue() <= this.f8975d.size()) {
                            try {
                                arrayList.add(this.f8975d.get(next.intValue()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.mSessionModule.deleteSession((List<IMSession>) arrayList);
                m6073a(false, true);
            }
        }
    }

    /* renamed from: i */
    private void m6085i() {
        this.f8980i.setVisibility(0);
    }

    public void hideProgressBar() {
        this.f8980i.setVisibility(8);
    }

    /* renamed from: j */
    private void m6086j() {
        IntentFilter intentFilter = new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver();
        this.f8972a = connectionChangeReceiver;
        try {
            registerReceiver(connectionChangeReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: k */
    private void m6087k() {
        ConnectionChangeReceiver connectionChangeReceiver = this.f8972a;
        if (connectionChangeReceiver != null) {
            try {
                unregisterReceiver(connectionChangeReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f8972a = null;
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageListActivity$ConnectionChangeReceiver */
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        public ConnectionChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null || !networkInfo.isConnected()) {
                    try {
                        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            IMMessageListActivity.this.f8979h.setVisibility(8);
                            return;
                        }
                    } catch (SecurityException e) {
                        IMLog.m6633e(e);
                    }
                    IMMessageListActivity.this.f8979h.setVisibility(0);
                    return;
                }
                IMMessageListActivity.this.f8979h.setVisibility(8);
            }
        }
    }
}
