package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMStageFeedBack;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.adapter.IMFeedChatAdapter;
import com.didi.beatles.p099im.common.IMPollingService;
import com.didi.beatles.p099im.event.IMEventDispatcher;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p099im.event.IMSessionInfoUpdateEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IMClearSessionUnreadCountCallback;
import com.didi.beatles.p099im.module.IMFeedSessionCallback;
import com.didi.beatles.p099im.module.IMModifyHelperForbidCallback;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMFeedMessage;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMDateUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMPollingUtils;
import com.didi.beatles.p099im.utils.IMRTLUtils;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.views.feed.IMListTraceVHolder;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity */
public class IMFeedMsgListActivity extends IMBaseActivity implements IMSessionCallback {

    /* renamed from: a */
    private static final String f8885a = "IMFeedList";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f8886b = this;

    /* renamed from: c */
    private CommonTitleBar f8887c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f8888d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f8889e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f8890f;

    /* renamed from: g */
    private ProgressBar f8891g;

    /* renamed from: h */
    private View f8892h;

    /* renamed from: i */
    private View f8893i;

    /* renamed from: j */
    private View f8894j;

    /* renamed from: k */
    private View f8895k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f8896l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f8897m;

    /* renamed from: n */
    private View f8898n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ViewPager f8899o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public PageListAdapter f8900p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public IIMSessionModule f8901q;

    /* renamed from: r */
    private ConnectionChangeReceiver f8902r;

    /* renamed from: s */
    private NewMessageReceiver f8903s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LineAnimation f8904t;

    public void onSessionLoad(List<IMSession> list) {
    }

    public static boolean useFeed() {
        return IMContextInfoHelper.isUseFeed();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, IMFeedMsgListActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityWithNewTask(Context context) {
        Intent intent = new Intent(context, IMFeedMsgListActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.im_feed_list_layout);
        m5925a();
        m5944b();
        m5950c();
        m5952d();
        EventBus.getDefault().register(this);
        NotificationUtils.cancelNotification();
        m5973o();
        this.f8901q = IMManager.getInstance().getSessionModel();
        m5956f();
        ViewPager viewPager = this.f8899o;
        this.f8900p.getClass();
        viewPager.setCurrentItem(0);
        this.f8900p.getClass();
        m5926a(0);
        m5958g();
        IMStageFeedBackListerManager.INSTANCE.notifyListeners(this, IMStageFeedBack.IMStage.IM_FEED_LIST_ON_CREATE, (IMStageFeedBack.OutFeedBackData) null);
    }

    /* renamed from: a */
    private void m5925a() {
        this.f8891g = (ProgressBar) findViewById(R.id.progress_bar);
        this.f8888d = findViewById(R.id.im_feed_tip_layout);
        this.f8889e = (TextView) findViewById(R.id.im_feed_tip);
        this.f8890f = findViewById(R.id.im_feed_tip_close);
    }

    /* renamed from: b */
    private void m5944b() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.im_title_bar);
        this.f8887c = commonTitleBar;
        commonTitleBar.initResource();
        this.f8887c.setTitleBackground(0);
        this.f8887c.setBackgroundColor(-1);
        this.f8887c.setTitle((int) R.string.im_feed_list_title);
        this.f8887c.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMFeedMsgListActivity.this.f8886b.finish();
            }
        });
        if (NotificationUtils.isShowNotificationSettingsEntrance()) {
            this.f8887c.setRightExtendIvVisible(0);
            this.f8887c.setRightExtendIv(R.drawable.im_icon_setting, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMFeedMsgListActivity.this.m5954e();
                }
            });
        }
    }

    /* renamed from: c */
    private void m5950c() {
        this.f8894j = findViewById(R.id.im_feed_switch_chat);
        this.f8895k = findViewById(R.id.im_feed_switch_chat_area);
        this.f8892h = findViewById(R.id.im_feed_switch_helper);
        this.f8893i = findViewById(R.id.im_feed_switch_helper_area);
        this.f8897m = (TextView) findViewById(R.id.im_feed_chat_red);
        this.f8896l = findViewById(R.id.im_feed_helper_red);
        View findViewById = findViewById(R.id.im_feed_switch_line);
        this.f8898n = findViewById;
        this.f8904t = new LineAnimation(findViewById, new View[]{this.f8892h, this.f8894j});
        this.f8893i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMTraceUtil.addBusinessEvent("ddim_service_tab_ck").add("redpoint", IMFeedMsgListActivity.this.f8896l.getVisibility() == 0 ? "1" : "0").report();
                ViewPager e = IMFeedMsgListActivity.this.f8899o;
                IMFeedMsgListActivity.this.f8900p.getClass();
                e.setCurrentItem(0);
            }
        });
        this.f8895k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMTraceUtil.addBusinessEvent("ddim_message_tab_ck").add("number", IMFeedMsgListActivity.this.f8897m.getVisibility() == 0 ? "1" : "0").report();
                ViewPager e = IMFeedMsgListActivity.this.f8899o;
                IMFeedMsgListActivity.this.f8900p.getClass();
                e.setCurrentItem(1);
            }
        });
    }

    /* renamed from: d */
    private void m5952d() {
        this.f8899o = (ViewPager) findViewById(R.id.im_feed_viewpager);
        PageListAdapter pageListAdapter = new PageListAdapter();
        this.f8900p = pageListAdapter;
        this.f8899o.setAdapter(pageListAdapter);
        this.f8899o.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                IMFeedMsgListActivity.this.f8904t.scrollChange(i, f);
            }

            public void onPageSelected(int i) {
                IMFeedMsgListActivity.this.f8900p.getClass();
                if (i == 0) {
                    IMTraceUtil.addBusinessEvent(IMFeedMsgListActivity.this.m5972n() ? "ddim_service_feed_sw" : "ddim_service_list_sw").report();
                } else {
                    IMTraceUtil.addBusinessEvent("ddim_message_list_sw").report();
                }
                IMFeedMsgListActivity.this.m5926a(i);
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
        m5975p();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f8901q == null) {
            this.f8901q = IMManager.getInstance().getSessionModel();
        }
        m5969m();
        m5967l();
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.registerSessionCallback(this);
        }
        IMManager.getInstance().pullMessage(0, 0, 2);
        IMPollingUtils.startPollingService(this, 60, IMPollingService.class, IMPollingService.ACTION);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.unregisterSessionCallback(this);
        }
        IMManager.getInstance().clearIMRedDot();
        IMPollingUtils.stopPollingService(this, IMPollingService.class, IMPollingService.ACTION);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateEvent(IMSessionInfoUpdateEvent iMSessionInfoUpdateEvent) {
        if (iMSessionInfoUpdateEvent.imSessionList != null && iMSessionInfoUpdateEvent.imSessionList.size() > 0) {
            m5969m();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateErrorEvent(IMSessionInfoUpdateErrorEvent iMSessionInfoUpdateErrorEvent) {
        if (iMSessionInfoUpdateErrorEvent.errorStatusCode == 111) {
            m5969m();
        }
    }

    public void onSessionOptionResult(List<IMSession> list, int i) {
        if (i == 3) {
            m5969m();
        } else {
            IMToastHelper.showLongError((Context) this.f8886b, getString(R.string.bts_im_delete_fail));
        }
    }

    public void onSessionStatusUpdate(List<IMSession> list) {
        m5948b(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5927a(int i, int i2, IMFeedSessionCallback iMFeedSessionCallback) {
        m5928a(i, i2, (Comparator<? super IMSession>) null, iMFeedSessionCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5928a(int i, int i2, Comparator<? super IMSession> comparator, IMFeedSessionCallback iMFeedSessionCallback) {
        IMLog.m6631d(f8885a, "loadSessionAsync " + i + " " + i);
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.loadSessionAsync(i, i2, comparator, iMFeedSessionCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5939a(IMSession iMSession) {
        IMLog.m6631d(f8885a, "delSession " + iMSession.getSessionId());
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.deleteSession(iMSession);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5943a(boolean z, IMSessionUnreadCallback iMSessionUnreadCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadUnRead ");
        sb.append(z ? "helper" : "chat");
        IMLog.m6631d(f8885a, sb.toString());
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule == null) {
            return;
        }
        if (z) {
            iIMSessionModule.getAllRedDotCount(iMSessionUnreadCallback);
        } else {
            iIMSessionModule.getAllUnreadCount(iMSessionUnreadCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5942a(List<IMSession> list) {
        IMLog.m6631d(f8885a, "clearUnRead list " + list.size());
        if (this.f8901q != null) {
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                jArr[i] = list.get(i).getSessionId();
            }
            this.f8901q.clearSessionsUnreadCount(jArr);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5929a(int i, IMClearSessionUnreadCountCallback iMClearSessionUnreadCountCallback) {
        IMLog.m6631d(f8885a, "clearUnRead type " + i);
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.clearSessionsUnreadCount(i, iMClearSessionUnreadCountCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5940a(IMSession iMSession, boolean z, IMModifyHelperForbidCallback iMModifyHelperForbidCallback) {
        IMLog.m6631d(f8885a, "updateSessionNotify " + iMSession.getSessionId() + " " + z);
        IIMSessionModule iIMSessionModule = this.f8901q;
        if (iIMSessionModule != null) {
            iIMSessionModule.modifyHelperForbidState(iMSession.getSessionId(), !z, iMModifyHelperForbidCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5947b(IMSession iMSession) {
        IMLog.m6631d(f8885a, "goSessionDetail " + iMSession.getSessionId());
        OmegaUtil.trackMsgCenterOmega(iMSession.getType(), iMSession.getSessionId());
        IMBusinessParam iMBusinessParam = new IMBusinessParam();
        iMBusinessParam.setSessionId(iMSession.getSessionId());
        iMBusinessParam.setSelfUid(IMSession.getSelfId(iMSession.getUserIds()).longValue());
        iMBusinessParam.setPeerUid(IMSession.getPeerId(iMSession.getUserIds()).longValue());
        iMBusinessParam.setBusinessId(iMSession.getBusinessId());
        iMBusinessParam.setUserDraft(iMSession.getDraft());
        iMBusinessParam.setSessionType(iMSession.getType());
        int i = 10;
        iMBusinessParam.setSourceId(10);
        int currentItem = this.f8899o.getCurrentItem();
        this.f8900p.getClass();
        if (currentItem != 0) {
            i = 1;
        } else if (m5972n()) {
            i = 9;
        }
        IMEngine.startChatDetailActivity(this.f8886b, iMBusinessParam, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5941a(String str) {
        IMLog.m6631d(f8885a, "goMessageUri " + str);
        IMCommonUtil.startUriActivity(this.f8886b, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5954e() {
        IMLog.m6631d(f8885a, "goIMSetting");
        if (IMContextInfoHelper.setSettingPageScheme() != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(Uri.parse(IMContextInfoHelper.setSettingPageScheme()));
                if (IMContextInfoHelper.getContext() != null) {
                    intent.setPackage(IMContextInfoHelper.getContext().getPackageName());
                    IMContextInfoHelper.getContext().startActivity(intent);
                }
                IMLog.m6635i("im_sdk", "goSettingLink use setSettingPageScheme: " + IMContextInfoHelper.setSettingPageScheme());
            } catch (Exception e) {
                IMLog.m6635i("im_sdk", "goSettingLink failed exception = " + e.toString());
                e.printStackTrace();
            }
        } else {
            IMLog.m6635i("im_sdk", "goIMSetting use normal");
            int i = 2;
            int currentItem = this.f8899o.getCurrentItem();
            this.f8900p.getClass();
            if (currentItem == 0) {
                i = !m5972n();
            }
            IMSettingsActivity.startActivity(this.f8886b, i);
        }
    }

    /* renamed from: f */
    private void m5956f() {
        this.f8891g.setVisibility(0);
    }

    public void hideProgressBar() {
        this.f8891g.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5926a(int i) {
        View view = this.f8894j;
        this.f8900p.getClass();
        boolean z = false;
        view.setSelected(i == 1);
        View view2 = this.f8892h;
        this.f8900p.getClass();
        if (i == 0) {
            z = true;
        }
        view2.setSelected(z);
    }

    /* renamed from: g */
    private void m5958g() {
        m5959h();
        m5962i();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m5959h() {
        IMLog.m6631d(f8885a, "updateSwitchHelperUnRead");
        m5943a(true, (IMSessionUnreadCallback) new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (i > 0) {
                    IMFeedMsgListActivity.this.f8896l.setVisibility(0);
                } else {
                    IMFeedMsgListActivity.this.f8896l.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m5962i() {
        IMLog.m6631d(f8885a, "updateSwitchChatUnRead");
        m5943a(false, (IMSessionUnreadCallback) new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (i > 0) {
                    IMFeedMsgListActivity.this.f8897m.setVisibility(0);
                    IMFeedMsgListActivity.this.f8897m.setText(String.valueOf(Math.min(99, i)));
                    return;
                }
                IMFeedMsgListActivity.this.f8897m.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m5964j() {
        this.f8888d.setVisibility(0);
        this.f8888d.setTag(new Object());
        this.f8889e.setText(getString(R.string.bts_im_no_network));
        this.f8889e.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.im_icon_wifi_unstable), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f8889e.setOnClickListener((View.OnClickListener) null);
        this.f8890f.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m5966k() {
        this.f8888d.setTag((Object) null);
        m5967l();
    }

    /* renamed from: l */
    private void m5967l() {
        if (this.f8888d.getTag() == null) {
            NotificationUtils.isNotificationEnabled(this.f8886b, new NotificationUtils.OnIMNotificationEnableCallback() {
                public void onNotificationEnabled(boolean z) {
                    IMLog.m6631d(IMFeedMsgListActivity.f8885a, C4234I.m6591t("[onNotificationEnabled] #checkNotifyPermission# enable=", Boolean.valueOf(z)));
                    if (z || !IMDateUtil.isCurrentAfterDay(IMPreference.getInstance(IMFeedMsgListActivity.this.f8886b).getNotifyCloseTime()) || IMContextInfoHelper.setSettingPageScheme() != null) {
                        IMFeedMsgListActivity.this.f8888d.setVisibility(8);
                        return;
                    }
                    IMTraceUtil.addBusinessEvent("ddim_service_nonotify_sw").report();
                    IMFeedMsgListActivity.this.f8888d.setVisibility(0);
                    IMFeedMsgListActivity.this.f8889e.setText(IMFeedMsgListActivity.this.getString(R.string.im_notify_tip));
                    IMFeedMsgListActivity.this.f8889e.setCompoundDrawablesWithIntrinsicBounds(IMFeedMsgListActivity.this.getResources().getDrawable(R.drawable.im_icon_reminder), (Drawable) null, (Drawable) null, (Drawable) null);
                    IMFeedMsgListActivity.this.f8889e.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            IMTraceUtil.addBusinessEvent("ddim_service_nonotify_ck").report();
                            NotificationUtils.openNotificationSettings(IMFeedMsgListActivity.this.f8886b);
                        }
                    });
                    IMFeedMsgListActivity.this.f8890f.setVisibility(0);
                    IMFeedMsgListActivity.this.f8890f.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            IMPreference.getInstance(IMFeedMsgListActivity.this.f8886b).setNotifyCloseTime(System.currentTimeMillis());
                            IMFeedMsgListActivity.this.f8888d.setVisibility(8);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: m */
    private void m5969m() {
        IMLog.m6631d(f8885a, "updateSessionList all");
        for (BaseModule updateSessions : this.f8900p.modules) {
            updateSessions.updateSessions();
        }
        m5958g();
    }

    /* renamed from: b */
    private void m5948b(List<IMSession> list) {
        IMLog.m6631d(f8885a, "updateSessionList size " + list.size());
        for (BaseModule updateSessions : this.f8900p.modules) {
            updateSessions.updateSessions(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m5972n() {
        HelperListModule helperListModule;
        Iterator<BaseModule> it = this.f8900p.modules.iterator();
        while (true) {
            if (!it.hasNext()) {
                helperListModule = null;
                break;
            }
            BaseModule next = it.next();
            if (next instanceof HelperListModule) {
                helperListModule = (HelperListModule) next;
                break;
            }
        }
        return helperListModule != null && helperListModule.isShowFeed;
    }

    /* renamed from: o */
    private void m5973o() {
        this.f8902r = new ConnectionChangeReceiver();
        try {
            registerReceiver(this.f8902r, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        this.f8903s = new NewMessageReceiver();
        LocalBroadcastManager.getInstance(this.f8886b).registerReceiver(this.f8903s, new IntentFilter(IMEventDispatcher.RECEIVE_NEW_MESSAGE_ACTION));
    }

    /* renamed from: p */
    private void m5975p() {
        ConnectionChangeReceiver connectionChangeReceiver = this.f8902r;
        if (connectionChangeReceiver != null) {
            try {
                unregisterReceiver(connectionChangeReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f8902r = null;
        }
        if (this.f8903s != null) {
            LocalBroadcastManager.getInstance(this.f8886b).unregisterReceiver(this.f8903s);
            this.f8903s = null;
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$ConnectionChangeReceiver */
    private class ConnectionChangeReceiver extends BroadcastReceiver {
        private ConnectionChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null || !networkInfo.isConnected()) {
                    try {
                        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            IMFeedMsgListActivity.this.m5966k();
                            return;
                        }
                    } catch (SecurityException e) {
                        IMLog.m6633e(e);
                    }
                    IMFeedMsgListActivity.this.m5964j();
                    return;
                }
                IMFeedMsgListActivity.this.m5966k();
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$NewMessageReceiver */
    private class NewMessageReceiver extends BroadcastReceiver {
        private NewMessageReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ArrayList<IMMessage> parcelableArrayListExtra;
            if (IMEventDispatcher.RECEIVE_NEW_MESSAGE_ACTION.equals(intent.getAction()) && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IMEventDispatcher.IM_MESSAGE_EXTRA)) != null && !parcelableArrayListExtra.isEmpty() && IMFeedMsgListActivity.this.f8901q != null) {
                LongSparseArray longSparseArray = new LongSparseArray();
                for (IMMessage iMMessage : parcelableArrayListExtra) {
                    Integer num = (Integer) longSparseArray.get(iMMessage.getSid());
                    if (num == null) {
                        longSparseArray.put(iMMessage.getSid(), 1);
                    } else {
                        longSparseArray.put(iMMessage.getSid(), Integer.valueOf(num.intValue() + 1));
                    }
                }
                int i = 0;
                for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                    long keyAt = longSparseArray.keyAt(i2);
                    IMSession sessionFromLocal = IMFeedMsgListActivity.this.f8901q.getSessionFromLocal(keyAt);
                    if (sessionFromLocal != null && sessionFromLocal.getType() == 4) {
                        i += ((Integer) longSparseArray.get(keyAt)).intValue();
                    }
                }
                IMLog.m6631d(IMFeedMsgListActivity.f8885a, "NewMessageReceiver receive " + parcelableArrayListExtra.size() + " helper " + i);
                if (i > 0) {
                    for (BaseModule receiveNewMessage : IMFeedMsgListActivity.this.f8900p.modules) {
                        receiveNewMessage.receiveNewMessage(i);
                    }
                }
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$PageListAdapter */
    private class PageListAdapter extends PagerAdapter {
        final int CHAT_INDEX;
        final int HELPER_INDEX;
        final int INDEX_NUM;
        List<BaseModule> modules;

        public int getCount() {
            return 2;
        }

        private PageListAdapter() {
            this.INDEX_NUM = 2;
            this.HELPER_INDEX = 0;
            this.CHAT_INDEX = 1;
            this.modules = new ArrayList(2);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return (obj instanceof BaseModule) && view == ((BaseModule) obj).itemView;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            BaseModule baseModule;
            if (i == 0) {
                baseModule = new HelperListModule(viewGroup);
                this.modules.add(baseModule);
            } else if (i == 1) {
                baseModule = new ChatListModule(viewGroup);
                this.modules.add(baseModule);
            } else {
                baseModule = new ChatListModule(viewGroup);
            }
            viewGroup.addView(baseModule.itemView);
            return baseModule;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof BaseModule) {
                viewGroup.removeView(((BaseModule) obj).itemView);
                this.modules.remove(obj);
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$LineAnimation */
    private class LineAnimation {
        private View lineView;
        private View[] tabViews;
        private int[] width;
        private int[] windowX;

        LineAnimation(View view, View[] viewArr) {
            this.lineView = view;
            this.tabViews = viewArr;
        }

        private void init() {
            View[] viewArr = this.tabViews;
            this.width = new int[viewArr.length];
            this.windowX = new int[viewArr.length];
            int[] iArr = new int[2];
            int i = 0;
            while (true) {
                View[] viewArr2 = this.tabViews;
                if (i < viewArr2.length) {
                    this.width[i] = viewArr2[i].getWidth();
                    this.tabViews[i].getLocationInWindow(iArr);
                    this.windowX[i] = iArr[0];
                    i++;
                } else {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lineView.getLayoutParams();
                    layoutParams.addRule(5, this.tabViews[0].getId());
                    layoutParams.addRule(7, this.tabViews[0].getId());
                    this.lineView.setLayoutParams(layoutParams);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void scrollChange(int i, float f) {
            if (this.width == null) {
                init();
            }
            if (f != 0.0f && i != this.tabViews.length - 1) {
                int[] iArr = this.windowX;
                int i2 = i + 1;
                int i3 = iArr[i2] - iArr[i];
                if (IMRTLUtils.isRTLLayout()) {
                    int[] iArr2 = this.width;
                    i3 += iArr2[i2] - iArr2[i];
                }
                float f2 = ((float) i3) * f;
                int[] iArr3 = this.width;
                updateLine(((int) (((float) (iArr3[i2] - iArr3[i])) * f)) + iArr3[i], f2);
            } else if (IMRTLUtils.isRTLLayout()) {
                int[] iArr4 = this.width;
                int i4 = iArr4[i] - iArr4[0];
                IMLog.m6631d(IMFeedMsgListActivity.f8885a, "【scrollChange】is rtl");
                int i5 = this.width[i];
                int[] iArr5 = this.windowX;
                updateLine(i5, (float) ((iArr5[i] - iArr5[0]) + i4));
            } else {
                IMLog.m6631d(IMFeedMsgListActivity.f8885a, "【scrollChange】is not rtl");
                int i6 = this.width[i];
                int[] iArr6 = this.windowX;
                updateLine(i6, (float) (iArr6[i] - iArr6[0]));
            }
        }

        private void updateLine(int i, float f) {
            ViewGroup.LayoutParams layoutParams = this.lineView.getLayoutParams();
            layoutParams.width = i;
            this.lineView.setLayoutParams(layoutParams);
            this.lineView.setTranslationX(f);
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$BaseModule */
    private abstract class BaseModule {
        IMFeedChatAdapter adapter;
        ImageView emptyImg;
        TextView emptyTip;
        View emptyView;
        View itemView;
        List<IMSession> list = new ArrayList();
        RecyclerView listView;
        TraceMonitor monitor;
        TextView tipView;

        /* access modifiers changed from: package-private */
        public void receiveNewMessage(int i) {
        }

        /* access modifiers changed from: package-private */
        public abstract void updateSessions();

        /* access modifiers changed from: package-private */
        public abstract void updateSessions(List<IMSession> list2);

        BaseModule(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_feed_list_pager_item, viewGroup, false);
            this.itemView = inflate;
            this.listView = (RecyclerView) inflate.findViewById(R.id.im_feed_pager_list);
            this.tipView = (TextView) this.itemView.findViewById(R.id.im_feed_pager_tip);
            this.emptyView = this.itemView.findViewById(R.id.im_feed_empty);
            this.emptyImg = (ImageView) this.itemView.findViewById(R.id.im_feed_empty_img);
            this.emptyTip = (TextView) this.itemView.findViewById(R.id.im_feed_empty_tip);
            this.emptyImg.setImageResource(IMResource.getDrawableID(R.drawable.im_feed_empty_tip));
            this.adapter = new IMFeedChatAdapter(IMFeedMsgListActivity.this.f8886b);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(IMFeedMsgListActivity.this.f8886b);
            this.listView.setLayoutManager(linearLayoutManager);
            this.listView.setAdapter(this.adapter);
            TraceMonitor traceMonitor = new TraceMonitor(this.listView, linearLayoutManager);
            this.monitor = traceMonitor;
            this.listView.addOnScrollListener(traceMonitor);
        }

        /* access modifiers changed from: package-private */
        public void showEmptyView(int i) {
            this.emptyView.setVisibility(0);
            this.emptyTip.setText(i);
        }

        /* access modifiers changed from: package-private */
        public void hideEmptyView() {
            this.emptyView.setVisibility(8);
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$HelperListModule */
    private class HelperListModule extends BaseModule implements IMFeedSessionCallback, IMSessionUnreadCallback {
        private static final int status = 3;
        /* access modifiers changed from: private */
        public Comparator<? super IMSession> feedComparable = new Comparator<IMSession>() {
            public int compare(IMSession iMSession, IMSession iMSession2) {
                return iMSession.compareLastModifyTime(iMSession2);
            }
        };
        /* access modifiers changed from: private */
        public boolean isShowFeed;
        /* access modifiers changed from: private */
        public int newFeedMsg = 0;
        private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i != 1) {
                    HelperListModule.this.feedClearUnRead();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        };
        private final int type = 4;

        HelperListModule(ViewGroup viewGroup) {
            super(viewGroup);
            this.adapter.setCallback(new IMFeedChatAdapter.OnViewCallback(IMFeedMsgListActivity.this) {
                public void callChangeList(boolean z) {
                    if (!z) {
                        IMTraceUtil.addBusinessEvent("ddim_service_switch_ck").report();
                    }
                    HelperListModule.this.changeList(z);
                }

                public void callClearUnRead() {
                    IMFeedMsgListActivity.this.m5929a(4, (IMClearSessionUnreadCountCallback) new IMClearSessionUnreadCountCallback() {
                        public void onSessionUnreadCountCleared(boolean z) {
                            if (z) {
                                IMFeedMsgListActivity.this.m5959h();
                                HelperListModule.this.adapter.doClearAnimation(HelperListModule.this.listView);
                            }
                        }
                    });
                }

                public void callClickSession(IMSession iMSession) {
                    IMFeedMsgListActivity.this.m5947b(iMSession);
                }

                public void callClickMessage(IMFeedMessage iMFeedMessage, String str) {
                    if (!TextUtils.isEmpty(str)) {
                        IMFeedMsgListActivity.this.m5941a(str);
                    }
                }

                public void callDelSession(IMSession iMSession) {
                    IMFeedMsgListActivity.this.m5939a(iMSession);
                }

                public void callChangeNotify(final IMSession iMSession, final boolean z) {
                    IMFeedMsgListActivity.this.m5940a(iMSession, z, (IMModifyHelperForbidCallback) new IMModifyHelperForbidCallback() {
                        public void onSucceed() {
                            iMSession.setIsfForbid(z);
                            HelperListModule.this.adapter.updateData(iMSession);
                        }

                        public void onFailed(String str) {
                            IMToastHelper.showShortInfo((Context) IMFeedMsgListActivity.this.f8886b, str);
                        }
                    });
                }

                public void callAnimationFinish() {
                    HelperListModule.this.updateSessions();
                }
            });
            this.tipView.setOnClickListener(new View.OnClickListener(IMFeedMsgListActivity.this) {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HelperListModule.this.listView.scrollToPosition(0);
                    HelperListModule.this.list.clear();
                    int unused = HelperListModule.this.newFeedMsg = 0;
                    HelperListModule.this.showFeedUnRead();
                    IMFeedMsgListActivity.this.m5929a(4, (IMClearSessionUnreadCountCallback) new IMClearSessionUnreadCountCallback() {
                        public void onSessionUnreadCountCleared(boolean z) {
                            if (z) {
                                IMFeedMsgListActivity.this.m5959h();
                                IMFeedMsgListActivity.this.m5928a(3, 4, (Comparator<? super IMSession>) HelperListModule.this.feedComparable, (IMFeedSessionCallback) HelperListModule.this);
                            }
                        }
                    });
                }
            });
            boolean isListShowFeed = IMPreference.getInstance(IMFeedMsgListActivity.this.f8886b).isListShowFeed(true);
            this.isShowFeed = isListShowFeed;
            changeList(isListShowFeed);
        }

        /* access modifiers changed from: private */
        public void changeList(boolean z) {
            this.isShowFeed = z;
            IMFeedMsgListActivity.this.m5959h();
            if (z) {
                IMTraceUtil.addBusinessEvent("ddim_service_feed_sw").report();
                IMPreference.getInstance(IMFeedMsgListActivity.this.f8886b).setListShowFeed(true);
                this.adapter.configShow(true, false, true);
                this.newFeedMsg = 0;
                showFeedUnRead();
                this.listView.addOnScrollListener(this.scrollListener);
                IMFeedMsgListActivity.this.m5928a(3, 4, this.feedComparable, (IMFeedSessionCallback) new IMFeedSessionCallback() {
                    public void onFeedSessionsLoad(List<IMSession> list, int i, int i2) {
                        HelperListModule.this.onFeedSessionsLoad(list, i, i2);
                        HelperListModule.this.listView.post(new Runnable() {
                            public void run() {
                                HelperListModule.this.feedClearUnRead();
                            }
                        });
                    }
                });
                return;
            }
            IMTraceUtil.addBusinessEvent("ddim_service_list_sw").report();
            IMPreference.getInstance(IMFeedMsgListActivity.this.f8886b).setListShowFeed(false);
            this.adapter.configShow(false, true, true);
            this.tipView.setVisibility(8);
            IMFeedMsgListActivity.this.m5943a(true, (IMSessionUnreadCallback) this);
            this.listView.removeOnScrollListener(this.scrollListener);
            IMFeedMsgListActivity.this.m5927a(3, 4, (IMFeedSessionCallback) this);
        }

        /* access modifiers changed from: package-private */
        public void updateSessions() {
            if (!this.isShowFeed) {
                IMFeedMsgListActivity.this.m5927a(3, 4, (IMFeedSessionCallback) this);
                IMFeedMsgListActivity.this.m5943a(true, (IMSessionUnreadCallback) this);
            }
        }

        /* access modifiers changed from: package-private */
        public void updateSessions(List<IMSession> list) {
            boolean z;
            Iterator<IMSession> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getType() == 4) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                updateSessions();
                IMFeedMsgListActivity.this.m5959h();
            }
        }

        public void onFeedSessionsLoad(List<IMSession> list, int i, int i2) {
            IMFeedMsgListActivity.this.hideProgressBar();
            this.monitor.resetMonitor();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (this.isShowFeed) {
                this.list = cloneSessionList(list);
            } else {
                this.list = list;
            }
            if (this.list.isEmpty()) {
                this.listView.setVisibility(8);
                showEmptyView(R.string.im_helper_list_empty);
                return;
            }
            this.listView.setVisibility(0);
            this.adapter.setData(this.list);
            hideEmptyView();
        }

        public void unReadCount(int i) {
            if (!this.isShowFeed) {
                this.adapter.setUnReadCount(Math.max(0, i));
            }
        }

        /* access modifiers changed from: package-private */
        public void receiveNewMessage(int i) {
            if (this.isShowFeed) {
                this.newFeedMsg += i;
                showFeedUnRead();
            }
        }

        /* access modifiers changed from: private */
        public void showFeedUnRead() {
            if (this.newFeedMsg <= 0) {
                this.tipView.setVisibility(8);
                return;
            }
            this.tipView.setVisibility(0);
            if (this.newFeedMsg == 1) {
                this.tipView.setText(IMFeedMsgListActivity.this.getString(R.string.im_feed_new_one));
                return;
            }
            this.tipView.setText(IMFeedMsgListActivity.this.getString(R.string.im_feed_new, new Object[]{String.valueOf(this.newFeedMsg)}));
        }

        private List<IMSession> cloneSessionList(List<IMSession> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (IMSession clone : list) {
                try {
                    arrayList.add((IMSession) clone.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public void feedClearUnRead() {
            if (this.isShowFeed) {
                List<IMSession> recentShow = this.adapter.getRecentShow();
                if (!recentShow.isEmpty()) {
                    IMFeedMsgListActivity.this.m5942a(recentShow);
                }
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$ChatListModule */
    private class ChatListModule extends BaseModule implements IMFeedSessionCallback, IMSessionUnreadCallback {
        private final int status = 3;
        private final int type = 19;

        ChatListModule(ViewGroup viewGroup) {
            super(viewGroup);
            this.adapter.configShow(false, true, false);
            this.adapter.setCallback(new IMFeedChatAdapter.OnViewCallback(IMFeedMsgListActivity.this) {
                public void callClearUnRead() {
                    IMFeedMsgListActivity.this.m5929a(19, (IMClearSessionUnreadCountCallback) new IMClearSessionUnreadCountCallback() {
                        public void onSessionUnreadCountCleared(boolean z) {
                            if (z) {
                                IMFeedMsgListActivity.this.m5962i();
                                ChatListModule.this.adapter.doClearAnimation(ChatListModule.this.listView);
                            }
                        }
                    });
                }

                public void callClickSession(IMSession iMSession) {
                    IMFeedMsgListActivity.this.m5947b(iMSession);
                }

                public void callDelSession(IMSession iMSession) {
                    IMFeedMsgListActivity.this.m5939a(iMSession);
                }

                public void callAnimationFinish() {
                    ChatListModule.this.updateSessions();
                }
            });
            updateSessions();
        }

        /* access modifiers changed from: package-private */
        public void updateSessions() {
            IMFeedMsgListActivity.this.m5927a(3, 19, (IMFeedSessionCallback) this);
            IMFeedMsgListActivity.this.m5943a(false, (IMSessionUnreadCallback) this);
        }

        /* access modifiers changed from: package-private */
        public void updateSessions(List<IMSession> list) {
            boolean z;
            Iterator<IMSession> it = list.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                IMSession next = it.next();
                if (next.getType() != 16) {
                    if (next.getType() != 2) {
                        if (next.getType() == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                updateSessions();
                IMFeedMsgListActivity.this.m5962i();
            }
        }

        public void onFeedSessionsLoad(List<IMSession> list, int i, int i2) {
            IMFeedMsgListActivity.this.hideProgressBar();
            this.monitor.resetMonitor();
            this.list = list == null ? new ArrayList() : new ArrayList(list);
            if (this.list.isEmpty()) {
                this.listView.setVisibility(8);
                showEmptyView(R.string.im_chat_list_empty);
                return;
            }
            this.listView.setVisibility(0);
            this.adapter.setData(this.list);
            hideEmptyView();
        }

        public void unReadCount(int i) {
            this.adapter.setUnReadCount(Math.max(0, i));
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMFeedMsgListActivity$TraceMonitor */
    private class TraceMonitor extends RecyclerView.OnScrollListener {
        private int lastFirst;
        private int lastLast;
        private LinearLayoutManager layoutManager;
        private RecyclerView recyclerView;

        TraceMonitor(RecyclerView recyclerView2, LinearLayoutManager linearLayoutManager) {
            this.recyclerView = recyclerView2;
            this.layoutManager = linearLayoutManager;
            resetMonitor();
        }

        /* access modifiers changed from: package-private */
        public void resetMonitor() {
            this.lastFirst = -1;
            this.lastLast = -1;
        }

        public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
            super.onScrolled(recyclerView2, i, i2);
            int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
            for (int i3 = findFirstVisibleItemPosition; i3 < this.lastFirst; i3++) {
                traceHolder(i3);
            }
            int i4 = this.lastLast;
            while (true) {
                i4++;
                if (i4 <= findLastVisibleItemPosition) {
                    traceHolder(i4);
                } else {
                    this.lastFirst = findFirstVisibleItemPosition;
                    this.lastLast = findLastVisibleItemPosition;
                    return;
                }
            }
        }

        private void traceHolder(int i) {
            IMLog.m6631d(IMFeedMsgListActivity.f8885a, "traceHolder:" + i);
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.recyclerView.findViewHolderForLayoutPosition(i);
            if (findViewHolderForLayoutPosition instanceof IMListTraceVHolder) {
                ((IMListTraceVHolder) findViewHolderForLayoutPosition).traceHolder();
            }
        }
    }
}
