package com.didi.beatles.p099im.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.access.utils.Parser;
import com.didi.beatles.p099im.activity.IMMessageActivity;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p099im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.IMMessageList;
import com.didi.beatles.p099im.event.IMMessageEmptyEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p099im.module.IMMessageCallback;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.module.impl.IMModelProvider;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.plugin.IMPluginCardViewProvider;
import com.didi.beatles.p099im.plugin.IMPluginFactory;
import com.didi.beatles.p099im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p099im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p099im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMDateUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParseUtil;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.views.IMDynamicRegisterCardView;
import com.didi.beatles.p099im.views.IMPluginCardView;
import com.didi.beatles.p099im.views.IMViewHolder;
import com.didi.beatles.p099im.views.custom.IMCradViewStatusCallback;
import com.didi.beatles.p099im.views.custom.IMCustomCardViewBaseProvider;
import com.didi.beatles.p099im.views.custom.IMDynamicRegisterCard;
import com.didi.beatles.p099im.views.messageCard.IMAudioRenderView;
import com.didi.beatles.p099im.views.messageCard.IMBaseRenderView;
import com.didi.beatles.p099im.views.messageCard.IMGifImageRenderView;
import com.didi.beatles.p099im.views.messageCard.IMImageRenderView;
import com.didi.beatles.p099im.views.messageCard.IMLocationRenderView;
import com.didi.beatles.p099im.views.messageCard.IMOrderMsgRenderView;
import com.didi.beatles.p099im.views.messageCard.IMRichInfoRenderView;
import com.didi.beatles.p099im.views.messageCard.IMSingleTextRender;
import com.didi.beatles.p099im.views.messageCard.IMSysAudioMsgRenderView;
import com.didi.beatles.p099im.views.messageCard.IMSysMsgRenderView;
import com.didi.beatles.p099im.views.messageCard.IMTextRenderView;
import com.didi.beatles.p099im.views.messageCard.IMTimeRenderView;
import com.didi.beatles.p099im.views.messageCard.IMloadRenderView;
import com.didi.beatles.p099im.views.popup.IMMessageOperatePopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.adapter.MessageAdapter */
public class MessageAdapter extends RecyclerView.Adapter implements IMBaseRenderView.MessageListItemListener {

    /* renamed from: H */
    private static final String f9082H = "im_register_card";

    /* renamed from: N */
    private static final int f9083N = 16384;

    /* renamed from: O */
    private static final int f9084O = 32768;
    public static final int TYPE_TIME_TITLE = 107;

    /* renamed from: a */
    private static final int f9085a = 0;

    /* renamed from: b */
    private static final int f9086b = 101;

    /* renamed from: c */
    private static final int f9087c = 102;

    /* renamed from: d */
    private static final int f9088d = 103;

    /* renamed from: e */
    private static final int f9089e = 111;

    /* renamed from: f */
    private static final int f9090f = 116;

    /* renamed from: g */
    private static final int f9091g = 118;

    /* renamed from: h */
    private static final int f9092h = 104;

    /* renamed from: i */
    private static final int f9093i = 105;

    /* renamed from: j */
    private static final int f9094j = 112;

    /* renamed from: k */
    private static final int f9095k = 106;

    /* renamed from: l */
    private static final int f9096l = 117;

    /* renamed from: m */
    private static final int f9097m = 119;

    /* renamed from: n */
    private static final int f9098n = 108;

    /* renamed from: o */
    private static final int f9099o = 109;

    /* renamed from: p */
    private static final int f9100p = 110;

    /* renamed from: q */
    private static final int f9101q = 113;

    /* renamed from: r */
    private static final int f9102r = 114;

    /* renamed from: s */
    private static final int f9103s = 115;

    /* renamed from: A */
    private IMCustomCardViewBaseProvider f9104A = null;

    /* renamed from: B */
    private List<Integer> f9105B = new ArrayList();

    /* renamed from: C */
    private IMCradViewStatusCallback f9106C;

    /* renamed from: D */
    private IMPluginCardViewProvider f9107D = null;

    /* renamed from: E */
    private Set<Integer> f9108E = new HashSet();

    /* renamed from: F */
    private IMMessageViewStatusCallback f9109F;

    /* renamed from: G */
    private int f9110G;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public MessageAdapterListener f9111I;

    /* renamed from: J */
    private boolean f9112J;

    /* renamed from: K */
    private boolean f9113K;

    /* renamed from: L */
    private IMMessageOperatePopup f9114L;

    /* renamed from: M */
    private IMRenderCardEnv f9115M;

    /* renamed from: P */
    private boolean f9116P = false;
    public Map<Long, Integer> audioRenderStatusStore = new HashMap();
    public Set<IMAudioRenderView> audioRenderViewStore = new HashSet(0);
    public IMCustomContext imCustomContext;
    public boolean isUberMode;
    public int mBusinessid;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public IMMessageList<IMMessage> f9117t = new IMMessageList<>();

    /* renamed from: u */
    private HashMap<Long, IMUser> f9118u = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public IMMessageActivity f9119v;

    /* renamed from: w */
    private boolean f9120w;

    /* renamed from: x */
    private int f9121x;

    /* renamed from: y */
    private ViewGroup f9122y;

    /* renamed from: z */
    private boolean f9123z;

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$MessageAdapterListener */
    public interface MessageAdapterListener {
        void displayEggs(IMConfig.EggsInfo eggsInfo);

        boolean interceptMessageUrl(String str);

        void onResendMessage(IMMessage iMMessage);

        void showAddCustomWordDialog(String str, int i);
    }

    /* renamed from: a */
    private int m6174a(int i, int i2) {
        return i | i2;
    }

    /* renamed from: b */
    private int m6183b(int i, int i2) {
        return i ^ i2;
    }

    /* renamed from: c */
    private boolean m6192c(int i) {
        return (i & 16384) != 0;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public MessageAdapter(IMMessageActivity iMMessageActivity, MessageAdapterListener messageAdapterListener, int i, int i2, IMSession iMSession, IMCustomContext iMCustomContext) {
        this.f9111I = messageAdapterListener;
        this.f9119v = iMMessageActivity;
        this.f9121x = i;
        m6188b();
        this.mBusinessid = i2;
        this.f9110G = iMSession.getType();
        this.imCustomContext = iMCustomContext;
        this.f9107D = new IMPluginCardViewProvider();
        m6191c();
        initPluginCardViewProvider();
    }

    public void updateRenderCardEnv(long j, String str, Map<String, String> map) {
        IMRenderCardEnv iMRenderCardEnv = this.f9115M;
        if (iMRenderCardEnv == null) {
            this.f9115M = new IMRenderCardEnv(j, str, map);
            return;
        }
        iMRenderCardEnv.setOrderId(str);
        this.f9115M.setExtraTraceMap(map);
    }

    public void initPluginCardViewProvider() {
        List<Integer> pluginList = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.f9110G, this.mBusinessid).getPluginList();
        if (pluginList == null) {
            this.f9107D.clear();
            IMLog.m6631d(f9082H, C4234I.m6591t("[initPluginCardViewProvider] NULL plugin list"));
            return;
        }
        for (Integer next : pluginList) {
            if (next == null || next.intValue() <= 0) {
                IMLog.m6631d(f9082H, C4234I.m6591t("[initPluginCardViewProvider] invalid plugin id:", next));
            } else {
                IMPluginService plugin = IMPluginFactory.getPlugin(next.intValue());
                if (plugin != null) {
                    Class<? extends View> messageViewClazz = plugin.getMessageViewClazz();
                    if (messageViewClazz != null) {
                        int parsePluginViewType = Parser.parsePluginViewType(next.intValue());
                        IMLog.m6631d(f9082H, C4234I.m6591t("[initPluginCardViewProvider] #REGISTER# viewType=", Integer.valueOf(parsePluginViewType), " |clazz=", messageViewClazz));
                        this.f9107D.registerPluginMessageView(parsePluginViewType, messageViewClazz);
                    }
                } else {
                    IMLog.m6632e(f9082H, C4234I.m6591t("[initPluginCardViewProvider] no plugin service implement for plugin id:", next));
                }
            }
        }
    }

    public boolean canLoadHistory() {
        return this.f9120w;
    }

    public void loadAudio(int i, int i2) {
        while (i < i2) {
            IMMessage item = getItem(i);
            if (item instanceof IMMessage) {
                IMMessage iMMessage = item;
                if (iMMessage.getType() == 131072 && IMTextUtil.isEmpty(iMMessage.getFile_name()) && IMModelProvider.getInstance().getMessageModule() != null) {
                    IMModelProvider.getInstance().getMessageModule().loadAudioMessage(iMMessage, iMMessage.getSid(), (IMMessageCallback) null);
                }
            }
            i++;
        }
    }

    public void addItem(List<IMMessage> list) {
        int size = this.f9117t.size();
        Iterator<IMMessage> it = list.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                IMMessage next = it.next();
                Long valueOf = Long.valueOf(next.getCreateTime());
                long senderUid = next.getSenderUid();
                if (getItemCount() > 0) {
                    IMMessage item = getItem(getItemCount() - 1);
                    if (item instanceof IMMessage) {
                        IMMessage iMMessage = item;
                        Long valueOf2 = Long.valueOf(iMMessage.getCreateTime());
                        long senderUid2 = iMMessage.getSenderUid();
                        boolean needDisplayTime = IMDateUtil.needDisplayTime(valueOf2, valueOf);
                        if (needDisplayTime) {
                            IMMessage iMMessage2 = new IMMessage(107);
                            iMMessage2.setCreateTime(valueOf.longValue());
                            this.f9117t.add(iMMessage2);
                        }
                        if (!needDisplayTime && senderUid == senderUid2) {
                            if (next.getType() != 327680) {
                                z = false;
                            }
                            next.isShowHead = z;
                        }
                    }
                } else {
                    Long valueOf3 = Long.valueOf(next.getCreateTime());
                    IMMessage iMMessage3 = new IMMessage(107);
                    iMMessage3.setCreateTime(valueOf3.longValue());
                    this.f9117t.add(iMMessage3);
                }
                this.f9117t.add(next);
            } else {
                notifyItemRangeInserted(size + 1, list.size());
                return;
            }
        }
    }

    public void setUsers(HashMap<Long, IMUser> hashMap) {
        this.f9118u.putAll(hashMap);
    }

    public void isShowPeerAvatar(boolean z) {
        this.f9123z = z;
    }

    public void isUber(boolean z) {
        this.isUberMode = z;
    }

    public Long getListMinPosition() {
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return 0L;
        }
        if (((IMMessage) this.f9117t.get(0)).getType() != 107) {
            return Long.valueOf(((IMMessage) this.f9117t.get(0)).getId());
        }
        if (this.f9117t.size() > 1) {
            return Long.valueOf(((IMMessage) this.f9117t.get(1)).getId());
        }
        return 0L;
    }

    public Long getListMaxPosition() {
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return 0L;
        }
        IMMessageList<IMMessage> iMMessageList2 = this.f9117t;
        if (((IMMessage) iMMessageList2.get(iMMessageList2.size() - 1)).getType() != 107) {
            IMMessageList<IMMessage> iMMessageList3 = this.f9117t;
            return Long.valueOf(((IMMessage) iMMessageList3.get(iMMessageList3.size() - 1)).getId());
        } else if (this.f9117t.size() <= 2) {
            return 0L;
        } else {
            IMMessageList<IMMessage> iMMessageList4 = this.f9117t;
            return Long.valueOf(((IMMessage) iMMessageList4.get(iMMessageList4.size() - 2)).getId());
        }
    }

    public void changeMsgReadStatus(List<IMMessage> list) {
        if (list != null && list.size() != 0) {
            int[] iArr = new int[list.size()];
            int i = 0;
            for (IMMessage location : list) {
                int location2 = this.f9117t.getLocation(location);
                int i2 = i + 1;
                iArr[i] = location2;
                if (location2 != -1) {
                    ((IMMessage) this.f9117t.get(location2)).setIsRead(true);
                }
                i = i2;
            }
            if (list.size() <= 1 || iArr[1] == 0) {
                IMLog.m6630d("changeMsgReadStatus  " + m6173a(iArr[0]));
                notifyItemChanged(m6173a(iArr[0]));
                return;
            }
            notifyDataSetChanged();
            IMLog.m6630d("changeMsgReadStatus  notifyDataSetChanged");
        }
    }

    public IMMessage getLastMessage() {
        IMUser iMUser;
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return null;
        }
        IMMessageList<IMMessage> iMMessageList2 = this.f9117t;
        IMMessage iMMessage = (IMMessage) iMMessageList2.get(iMMessageList2.size() - 1);
        if (iMMessage == null) {
            return null;
        }
        if (this.f9110G == 2 && (iMUser = this.f9118u.get(Long.valueOf(iMMessage.getSenderUid()))) != null) {
            iMMessage.setNickName(iMUser.getNickName());
        }
        return iMMessage;
    }

    public List<IMMessage> getMessagesWithType(int i) {
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f9117t.iterator();
        while (it.hasNext()) {
            IMMessage iMMessage = (IMMessage) it.next();
            if (iMMessage.getType() == i) {
                arrayList.add(iMMessage);
            }
        }
        return arrayList;
    }

    public void hidePopup() {
        IMMessageOperatePopup iMMessageOperatePopup = this.f9114L;
        if (iMMessageOperatePopup != null) {
            iMMessageOperatePopup.hidePopup();
        }
    }

    public static List<IMMessage> removeDuplicate(List<IMMessage> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        list.clear();
        list.addAll(linkedHashSet);
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.beatles.p099im.common.IMMessageList<com.didi.beatles.p099im.module.entity.IMMessage> loadHistoryList(java.util.List<com.didi.beatles.p099im.module.entity.IMMessage> r19, boolean r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r1 == 0) goto L_0x00e4
            int r3 = r19.size()
            if (r3 > 0) goto L_0x000e
            goto L_0x00e4
        L_0x000e:
            com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator r3 = new com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator
            r3.<init>()
            java.util.Collections.sort(r1, r3)
            com.didi.beatles.im.common.IMMessageList r3 = new com.didi.beatles.im.common.IMMessageList
            r3.<init>()
            r4 = 0
            r6 = 1
            if (r20 == 0) goto L_0x0038
            int r7 = r18.getItemCount()
            int r7 = r7 - r6
            com.didi.beatles.im.module.entity.IMMessage r7 = r0.getItem(r7)
            boolean r8 = r7 instanceof com.didi.beatles.p099im.module.entity.IMMessage
            if (r8 == 0) goto L_0x0038
            com.didi.beatles.im.module.entity.IMMessage r7 = (com.didi.beatles.p099im.module.entity.IMMessage) r7
            long r4 = r7.getCreateTime()
            long r7 = r7.getSenderUid()
            goto L_0x0039
        L_0x0038:
            r7 = r4
        L_0x0039:
            java.util.Iterator r9 = r19.iterator()
        L_0x003d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00c5
            java.lang.Object r10 = r9.next()
            com.didi.beatles.im.module.entity.IMMessage r10 = (com.didi.beatles.p099im.module.entity.IMMessage) r10
            long r11 = r10.getCreateTime()
            long r13 = r10.getSenderUid()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            boolean r4 = com.didi.beatles.p099im.utils.IMDateUtil.needDisplayTime(r4, r5)
            if (r4 == 0) goto L_0x0077
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            com.didi.beatles.im.module.entity.IMMessage r15 = new com.didi.beatles.im.module.entity.IMMessage
            r2 = 107(0x6b, float:1.5E-43)
            r15.<init>((int) r2)
            r16 = r7
            long r6 = r5.longValue()
            r15.setCreateTime(r6)
            r3.add((com.didi.beatles.p099im.module.entity.IMMessage) r15)
            goto L_0x0079
        L_0x0077:
            r16 = r7
        L_0x0079:
            if (r4 != 0) goto L_0x008f
            int r4 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x008f
            int r4 = r10.getType()
            r5 = 327680(0x50000, float:4.59177E-40)
            if (r4 != r5) goto L_0x008b
            r2 = 1
            r10.isShowHead = r2
            goto L_0x0090
        L_0x008b:
            r2 = 1
            r10.isShowHead = r2
            goto L_0x0090
        L_0x008f:
            r2 = 1
        L_0x0090:
            r3.add((com.didi.beatles.p099im.module.entity.IMMessage) r10)
            int r4 = r10.getType()
            r5 = 196608(0x30000, float:2.75506E-40)
            if (r4 != r5) goto L_0x00c0
            int r4 = r10.getStatus()
            r5 = 100
            if (r4 != r5) goto L_0x00c0
            long r4 = r10.getSenderUid()
            long r6 = com.didi.beatles.p099im.IMContextInfoHelper.getUid()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00c0
            com.didi.beatles.im.task.IMUploadQueue r4 = com.didi.beatles.p099im.task.IMUploadQueue.getInstance()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00c0
            if (r20 != 0) goto L_0x00c0
            r4 = 300(0x12c, float:4.2E-43)
            r10.setStatus(r4)
        L_0x00c0:
            r4 = r11
            r7 = r13
            r6 = 1
            goto L_0x003d
        L_0x00c5:
            r2 = 1
            if (r20 != 0) goto L_0x00db
            com.didi.beatles.im.common.IMMessageList<com.didi.beatles.im.module.entity.IMMessage> r4 = r0.f9117t
            r5 = 0
            r4.addAll(r5, r3)
            int r1 = r19.size()
            int r4 = r0.f9121x
            if (r1 < r4) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            r0.f9120w = r2
            goto L_0x00e0
        L_0x00db:
            com.didi.beatles.im.common.IMMessageList<com.didi.beatles.im.module.entity.IMMessage> r1 = r0.f9117t
            r1.addAll(r3)
        L_0x00e0:
            r18.notifyDataSetChanged()
            return r3
        L_0x00e4:
            if (r20 != 0) goto L_0x00ec
            r1 = 0
            r0.f9120w = r1
            r18.notifyDataSetChanged()
        L_0x00ec:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.adapter.MessageAdapter.loadHistoryList(java.util.List, boolean):com.didi.beatles.im.common.IMMessageList");
    }

    /* renamed from: a */
    private void m6181a(IMMessage iMMessage) {
        MessageAdapterListener messageAdapterListener;
        if (iMMessage != null && (messageAdapterListener = this.f9111I) != null) {
            messageAdapterListener.onResendMessage(iMMessage);
        }
    }

    public void onResendClick(IMMessage iMMessage) {
        m6181a(iMMessage);
    }

    public boolean onBubbleClick(IMMessage iMMessage) {
        if (iMMessage == null || this.f9111I == null) {
            return false;
        }
        String str = null;
        if (iMMessage.getType() == 393217 && iMMessage.getMessageExtendInfo() != null) {
            str = iMMessage.getMessageExtendInfo().light_link;
        }
        if (TextUtils.isEmpty(str) || !this.f9111I.interceptMessageUrl(str)) {
            return false;
        }
        return true;
    }

    public void onBubbleLongClick(View view, int i, IMMessage iMMessage) {
        if (iMMessage.getType() != 393217 && iMMessage.getType() != 393219 && iMMessage.getType() != 107 && iMMessage.getType() != 393224) {
            boolean z = false;
            IMLog.m6635i("onBubbleLongClick " + iMMessage.getType(), new Object[0]);
            if (iMMessage.getType() == 528385 && !TextUtils.isEmpty(iMMessage.getContent())) {
                String parseSubType = Parser.parseSubType(iMMessage.getContent());
                if (!TextUtils.isEmpty(parseSubType) && "private_order".equals(parseSubType)) {
                    return;
                }
            }
            boolean z2 = iMMessage.getSenderUid() == IMContextInfoHelper.getUid();
            IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.f9110G, this.mBusinessid);
            if (iMMessage.getType() != 65537 && currentBusinessConfig.isShowUsefulExpression()) {
                z = z2;
            }
            IMBtsAudioHelper.stopPlaying();
            m6179a(this.f9122y, (IMMessageOperatePopup.OnItemClickListener) new OperateItemClickListener(iMMessage, i)).show(view, iMMessage.getType(), z);
        }
    }

    public void onEggsMsgRender(IMConfig.EggsInfo eggsInfo) {
        MessageAdapterListener messageAdapterListener = this.f9111I;
        if (messageAdapterListener != null && eggsInfo != null) {
            messageAdapterListener.displayEggs(eggsInfo);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$MessageTimeComparator */
    public static class MessageTimeComparator implements Comparator<IMMessage> {
        public int compare(IMMessage iMMessage, IMMessage iMMessage2) {
            return IMParseUtil.parseInt(iMMessage.getId() - iMMessage2.getId());
        }
    }

    public void updateItemState(IMMessage iMMessage) {
        long id = iMMessage.getId();
        Long valueOf = Long.valueOf(iMMessage.getMid());
        int size = this.f9117t.size();
        while (true) {
            size--;
            if (size <= 0) {
                size = -1;
                break;
            }
            IMMessage iMMessage2 = (IMMessage) this.f9117t.get(size);
            if (iMMessage2.getId() == id && iMMessage2.getMid() == valueOf.longValue()) {
                this.f9117t.set(size, iMMessage);
                break;
            }
        }
        if (size != -1) {
            notifyItemChanged(m6173a(size));
        }
    }

    /* renamed from: a */
    private int m6173a(int i) {
        return this.f9120w ? i + 1 : i;
    }

    public IMUser getUserModel(long j) {
        HashMap<Long, IMUser> hashMap = this.f9118u;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        return this.f9118u.get(Long.valueOf(j));
    }

    /* renamed from: a */
    private IMMessageOperatePopup m6179a(ViewGroup viewGroup, IMMessageOperatePopup.OnItemClickListener onItemClickListener) {
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(this.mBusinessid);
        IMMessageOperatePopup instance = IMMessageOperatePopup.instance(viewGroup, currentBusinessConfig != null ? currentBusinessConfig.isShowUsefulExpression() : false);
        this.f9114L = instance;
        instance.setOnItemClickListener(onItemClickListener);
        return instance;
    }

    /* renamed from: com.didi.beatles.im.adapter.MessageAdapter$OperateItemClickListener */
    private class OperateItemClickListener implements IMMessageOperatePopup.OnItemClickListener {
        /* access modifiers changed from: private */
        public IMMessage mMsgInfo;
        /* access modifiers changed from: private */
        public int mPostion;

        public OperateItemClickListener(IMMessage iMMessage, int i) {
            this.mMsgInfo = iMMessage;
            this.mPostion = i;
        }

        public void onCopyClick() {
            IMLog.m6635i("onCopyClick", new Object[0]);
            try {
                ClipboardManager clipboardManager = (ClipboardManager) MessageAdapter.this.f9119v.getSystemService("clipboard");
                if (Build.VERSION.SDK_INT >= 11) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("data", this.mMsgInfo.getContent()));
                } else {
                    clipboardManager.setText(this.mMsgInfo.getContent());
                }
            } catch (Exception e) {
                IMLog.m6631d("copy_err", e.getMessage());
            }
        }

        public void onDelClick() {
            IMLog.m6635i("onDelClick", new Object[0]);
            IMManager.getInstance().deleteMessage(this.mMsgInfo, new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    if (i == 401) {
                        try {
                            MessageAdapter.this.m6182a(OperateItemClickListener.this.mMsgInfo, OperateItemClickListener.this.mPostion);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (MessageAdapter.this.getLastMessage() == null) {
                            IMMessage iMMessage2 = new IMMessage(65536);
                            iMMessage2.setContent("");
                            iMMessage2.setCreateTime(iMMessage.getCreateTime());
                            iMMessage2.setSid(iMMessage.getSid());
                            IMManager.getInstance().updateSession(iMMessage2);
                            return;
                        }
                        return;
                    }
                    IMToastHelper.showLongError((Context) MessageAdapter.this.f9119v, MessageAdapter.this.f9119v.getString(R.string.bts_im_delete_msg_fail));
                }
            });
        }

        public void onAddWordClick() {
            IMLog.m6635i("onAddWordClick", new Object[0]);
            if (MessageAdapter.this.f9111I != null) {
                MessageAdapter.this.f9111I.showAddCustomWordDialog(this.mMsgInfo.getContent(), 3);
                IMMsgOmega.getInstance().track("ddim_dy_all_buble_ck", (Map<String, Object>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6182a(IMMessage iMMessage, int i) {
        int i2;
        int size = this.f9117t.size();
        int i3 = i - 1;
        if (i3 >= 0 && ((IMMessage) this.f9117t.get(i3)).getType() == 107) {
            int i4 = i + 1;
            if (i4 >= size) {
                this.f9117t.remove(i3);
            } else if (((IMMessage) this.f9117t.get(i4)).getType() == 107) {
                this.f9117t.remove(i3);
            } else {
                ((IMMessage) this.f9117t.get(i3)).setCreateTime(((IMMessage) this.f9117t.get(i4)).getCreateTime());
            }
        } else if (i3 >= 0 && ((IMMessage) this.f9117t.get(i3)).getType() != 107 && (i2 = i + 1) < size && ((IMMessage) this.f9117t.get(i2)).getType() != 107 && IMDateUtil.needDisplayTime(Long.valueOf(((IMMessage) this.f9117t.get(i3)).getCreateTime()), Long.valueOf(((IMMessage) this.f9117t.get(i2)).getCreateTime()))) {
            IMMessage iMMessage2 = new IMMessage(107);
            iMMessage2.setCreateTime(((IMMessage) this.f9117t.get(i2)).getCreateTime());
            this.f9117t.add(i, iMMessage2);
        }
        this.f9117t.remove(iMMessage);
        if (this.f9117t.size() == 0) {
            EventBus.getDefault().post(new IMMessageEmptyEvent());
        }
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IMViewHolder iMViewHolder;
        this.f9122y = viewGroup;
        IMMessageActivity iMMessageActivity = this.f9119v;
        if (this.f9105B.contains(Integer.valueOf(i)) && m6178a() != null) {
            boolean c = m6192c(i);
            if (c) {
                i = m6183b(i, 16384);
            } else {
                i = m6183b(i, 32768);
            }
            IMLog.m6631d(f9082H, "get view by type " + i);
            IMViewHolder a = m6176a(i, c);
            if (!(a == null || a.mRenderView == null)) {
                a.mRenderView.setShowUserAvatar(this.f9123z);
            }
            if (a != null) {
                return a;
            }
        }
        Set<Integer> set = this.f9108E;
        if (!(set == null || !set.contains(Integer.valueOf(i)) || this.f9107D == null)) {
            boolean c2 = m6192c(i);
            if (c2) {
                r8 = m6183b(i, 16384);
            } else {
                r8 = m6183b(i, 32768);
            }
            IMLog.m6631d(f9082H, "[onCreateViewHolder] #MsgTypePlugin# get view by type " + i);
            IMViewHolder b = m6187b(i, c2);
            if (!(b == null || b.mRenderView == null)) {
                b.mRenderView.setShowUserAvatar(this.f9123z);
            }
            if (b != null) {
                return b;
            }
        }
        switch (i) {
            case 101:
                iMViewHolder = m6177a((IMBaseRenderView) new IMTextRenderView(iMMessageActivity, 2, this, this.f9113K));
                break;
            case 102:
                iMViewHolder = m6177a((IMBaseRenderView) new IMGifImageRenderView(iMMessageActivity, 2, this));
                break;
            case 103:
                iMViewHolder = m6177a((IMBaseRenderView) new IMAudioRenderView(iMMessageActivity, 2, this));
                break;
            case 104:
                iMViewHolder = m6177a((IMBaseRenderView) new IMTextRenderView(iMMessageActivity, 0, this, this.f9113K));
                break;
            case 105:
                iMViewHolder = m6177a((IMBaseRenderView) new IMGifImageRenderView(iMMessageActivity, 0, this));
                break;
            case 106:
                iMViewHolder = m6177a((IMBaseRenderView) new IMAudioRenderView(iMMessageActivity, 0, this));
                break;
            case 107:
                iMViewHolder = m6177a((IMBaseRenderView) new IMTimeRenderView(iMMessageActivity, this));
                break;
            case 108:
                iMViewHolder = m6177a((IMBaseRenderView) new IMOrderMsgRenderView(iMMessageActivity, 1, this));
                break;
            case 109:
                iMViewHolder = m6177a((IMBaseRenderView) new IMloadRenderView(iMMessageActivity, this));
                break;
            case 110:
                iMViewHolder = m6177a((IMBaseRenderView) new IMSingleTextRender(iMMessageActivity, 1, this));
                break;
            case 111:
                iMViewHolder = m6177a((IMBaseRenderView) new IMLocationRenderView(iMMessageActivity, 2, this));
                break;
            case 112:
                iMViewHolder = m6177a((IMBaseRenderView) new IMLocationRenderView(iMMessageActivity, 0, this));
                break;
            case 113:
                iMViewHolder = m6177a((IMBaseRenderView) new IMSysMsgRenderView(iMMessageActivity, 1, this, false));
                break;
            case 114:
                iMViewHolder = m6177a((IMBaseRenderView) new IMSysAudioMsgRenderView(iMMessageActivity, 1, this));
                break;
            default:
                switch (i) {
                    case 116:
                        iMViewHolder = m6177a((IMBaseRenderView) new IMImageRenderView(iMMessageActivity, 2, this));
                        break;
                    case 117:
                        iMViewHolder = m6177a((IMBaseRenderView) new IMImageRenderView(iMMessageActivity, 0, this));
                        break;
                    case 118:
                        iMViewHolder = m6177a((IMBaseRenderView) new IMRichInfoRenderView(iMMessageActivity, 2, this));
                        break;
                    case 119:
                        iMViewHolder = m6177a((IMBaseRenderView) new IMRichInfoRenderView(iMMessageActivity, 0, this));
                        break;
                    default:
                        switch (i) {
                            case 501:
                            case 502:
                            case 503:
                            case 504:
                                iMViewHolder = m6186b(i);
                                break;
                            default:
                                iMViewHolder = m6177a((IMBaseRenderView) new IMSysMsgRenderView(iMMessageActivity, 1, this, true));
                                break;
                        }
                }
        }
        if (!(iMViewHolder == null || iMViewHolder.mRenderView == null)) {
            iMViewHolder.mRenderView.setShowUserAvatar(this.f9123z);
        }
        return iMViewHolder;
    }

    /* renamed from: a */
    private IMViewHolder m6176a(int i, boolean z) {
        int i2 = 0;
        if (m6178a() == null) {
            IMLog.m6632e(f9082H, "cardProvider is null ! did you register the provider?");
            return null;
        }
        IMDynamicRegisterCardView iMDynamicRegisterCardView = new IMDynamicRegisterCardView(this.f9119v, 0, this, true);
        View view = m6178a().getView(this.f9119v, iMDynamicRegisterCardView, i);
        if (view == null) {
            IMLog.m6632e(f9082H, "the card view is null while datatype is " + i + "! please register non-empty view");
            return null;
        }
        if (!(view instanceof IMDynamicRegisterCard) || !((IMDynamicRegisterCard) view).isShowAvatar()) {
            i2 = 1;
        } else if (z) {
            i2 = 2;
        }
        iMDynamicRegisterCardView.addRegisterView(view, i2);
        IMViewHolder a = m6177a((IMBaseRenderView) iMDynamicRegisterCardView);
        a.setType(1);
        return a;
    }

    /* renamed from: b */
    private IMViewHolder m6187b(int i, boolean z) {
        int i2 = 1;
        if (this.f9107D == null) {
            IMLog.m6632e(f9082H, "[getPluginCardViewHolder] NULL plugin card view provider");
            return null;
        }
        IMPluginCardView iMPluginCardView = new IMPluginCardView(this.f9119v, 0, this, true);
        View view = this.f9107D.getView(this.f9119v, iMPluginCardView, i);
        if (view == null) {
            IMLog.m6632e(f9082H, "[getPluginCardViewHolder] the card view is null while datatype is " + i + "! please register non-empty view");
            return null;
        }
        if ((view instanceof IIMPluginCardView) && !((IIMPluginCardView) view).isShowInMiddle()) {
            i2 = z ? 2 : 0;
        }
        iMPluginCardView.addRegisterView(view, i2);
        IMViewHolder a = m6177a((IMBaseRenderView) iMPluginCardView);
        a.setType(2);
        return a;
    }

    /* renamed from: b */
    private IMViewHolder m6186b(int i) {
        IMBaseRenderView customChatRow;
        if (IMContextInfoHelper.getRegisterMessageCardView() == null || (customChatRow = IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRow(i, this)) == null) {
            return null;
        }
        return new IMViewHolder(customChatRow);
    }

    /* renamed from: a */
    private IMViewHolder m6177a(IMBaseRenderView iMBaseRenderView) {
        return new IMViewHolder(iMBaseRenderView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IMMessage item;
        IMViewHolder iMViewHolder = (IMViewHolder) viewHolder;
        if (iMViewHolder != null && iMViewHolder.mRenderView != null && this.f9117t != null && (item = getItem(i)) != null) {
            IMUser userModel = getUserModel(item.getSenderUid());
            if (iMViewHolder.isExtendType()) {
                if (m6178a() != null) {
                    IMLog.m6631d(f9082H, "[onBindViewHolder] #MsgTypeExtend# bind extend card data");
                    m6178a().bindData(i, iMViewHolder.mRenderView.getCardView(), item.getContent(), item, this.f9115M);
                    iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
                    m6178a().setCardViewStatusCallback(this.f9106C);
                }
            } else if (!iMViewHolder.isPluginType()) {
                iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
            } else if (this.f9107D != null) {
                IMLog.m6631d(f9082H, "[onBindViewHolder] #MsgTypePlugin# bind extend card data");
                this.f9107D.bindData(i, iMViewHolder.mRenderView.getCardView(), item.getContent(), item, this.f9115M);
                iMViewHolder.mRenderView.setUpView(item, userModel, this, i);
                this.f9107D.setMessageViewStatusCallback(this.f9109F);
            }
        }
    }

    public IMMessage getItem(int i) {
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() == 0) {
            return null;
        }
        if (!this.f9120w && i >= this.f9117t.size()) {
            return null;
        }
        if (!this.f9120w || i <= 0) {
            return (IMMessage) this.f9117t.get(i);
        }
        return (IMMessage) this.f9117t.get(i - 1);
    }

    public IMMessage getItemNext(IMMessage iMMessage) {
        int indexOf;
        int i;
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null || iMMessageList.size() == 0 || (indexOf = this.f9117t.indexOf(iMMessage)) < 0 || (i = indexOf + 1) >= this.f9117t.size()) {
            return null;
        }
        return (IMMessage) this.f9117t.get(i);
    }

    public int getItemViewType(int i) {
        int i2;
        int i3;
        IMMessage item = getItem(i);
        if (item == null) {
            return -1;
        }
        if (i == 0 && this.f9120w) {
            return 109;
        }
        boolean z = item.getSenderUid() == IMContextInfoHelper.getUid();
        if (this.f9112J && !z && !item.isRead() && item.isMarkReadAsShown()) {
            IMMessageReadStatusManager.getInstance().addHasReadMsg(item);
            item.setIsRead(true);
        }
        if (item.getType() == 528385) {
            if (IMContextInfoHelper.getRegisterMessageCardView() == null) {
                return -1;
            }
            if (IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRowType(item) > 0) {
                return IMContextInfoHelper.getRegisterMessageCardView().getCustomChatRowType(item);
            }
            int b = m6184b(item);
            if (z) {
                i3 = m6174a(b, 16384);
            } else {
                i3 = m6174a(b, 32768);
            }
            IMLog.m6632e(f9082H, C4234I.m6591t("[getItemViewType] #MsgTypeExtend# type=", Integer.valueOf(i3), " |isMine=", Boolean.valueOf(z)));
            if (i3 != -1) {
                this.f9105B.add(Integer.valueOf(i3));
                return i3;
            }
            IMLog.m6632e(f9082H, "register card failed! the type is -1,please check your type!");
        }
        if (item.getType() == 393223) {
            if (this.f9107D == null) {
                IMLog.m6632e(f9082H, C4234I.m6591t("[getItemViewType] #MsgTypePlugin# Null plugin card view provider."));
                return -1;
            }
            int c = m6189c(item);
            if (z) {
                i2 = m6174a(c, 16384);
            } else {
                i2 = m6174a(c, 32768);
            }
            IMLog.m6632e(f9082H, C4234I.m6591t("[getItemViewType] #MsgTypePlugin# pluginViewType=", Integer.valueOf(c), " |type=", Integer.valueOf(i2), " |isMine=", Boolean.valueOf(z)));
            if (i2 != -1) {
                this.f9108E.add(Integer.valueOf(i2));
                return i2;
            }
            IMLog.m6632e(f9082H, C4234I.m6591t("[getItemViewType] #MsgTypePlugin# register card failed! the type is -1,please check your type!"));
        }
        if (item.getType() == 10486017) {
            return z ? 111 : 112;
        }
        if (item.getType() == 65536 || item.getType() == 65537) {
            return z ? 101 : 104;
        }
        if (item.getType() == 393217) {
            return 113;
        }
        if (item.getType() == 393224) {
            return 114;
        }
        if (item.getType() == 107) {
            return 107;
        }
        if (item.getType() == 131072) {
            return z ? 103 : 106;
        }
        if (item.getType() == 327680) {
            return z ? 102 : 105;
        }
        if (item.getType() == 393220 || item.getType() == 393219) {
            return 108;
        }
        if (item.getType() == 196608) {
            return z ? 116 : 117;
        }
        if (item.getType() == 458752) {
            return z ? 118 : 119;
        }
        return 0;
    }

    public int getItemCount() {
        int i;
        IMMessageList<IMMessage> iMMessageList = this.f9117t;
        if (iMMessageList == null) {
            i = 0;
        } else {
            i = iMMessageList.size();
        }
        return this.f9120w ? i + 1 : i;
    }

    /* renamed from: a */
    private IMCustomCardViewBaseProvider m6178a() {
        IMMessageActivity iMMessageActivity;
        if (this.f9104A == null && (iMMessageActivity = this.f9119v) != null) {
            this.f9104A = IMEngine.getInstance(iMMessageActivity).getCurrentBusinessConfig(this.f9110G, this.mBusinessid).getCardViewProvider();
        }
        return this.f9104A;
    }

    /* renamed from: b */
    private int m6184b(IMMessage iMMessage) {
        String content;
        if (iMMessage == null || iMMessage.getType() != 528385 || (content = iMMessage.getContent()) == null) {
            return -1;
        }
        return Parser.parseViewType(content);
    }

    /* renamed from: c */
    private int m6189c(IMMessage iMMessage) {
        if (iMMessage == null || iMMessage.getType() != 393223) {
            return -1;
        }
        IMMessageDownExtend parsedMessageExtend = iMMessage.getParsedMessageExtend();
        if (parsedMessageExtend == null) {
            IMLog.m6632e(f9082H, C4234I.m6591t("[getPluginViewType] Invalid extend info"));
            return -1;
        }
        int pluginId = parsedMessageExtend.getPluginId();
        if (pluginId > 0) {
            return Parser.parsePluginViewType(pluginId);
        }
        IMLog.m6632e(f9082H, C4234I.m6591t("[getPluginViewType] Invalid plugin id : " + pluginId));
        return -1;
    }

    /* renamed from: b */
    private void m6188b() {
        this.f9106C = new IMCradViewStatusCallback() {
            public void onUpdate(int i, String str) {
                if (MessageAdapter.this.f9117t != null) {
                    IMMessage iMMessage = (IMMessage) MessageAdapter.this.f9117t.get(i);
                    iMMessage.setContent(str);
                    MessageAdapter.this.f9117t.remove(i);
                    MessageAdapter.this.f9117t.add(i, iMMessage);
                    MessageAdapter.this.notifyItemChanged(i);
                }
            }

            public void removeView(int i) {
                if (MessageAdapter.this.f9117t != null) {
                    MessageAdapter.this.f9117t.remove(i);
                    MessageAdapter.this.notifyItemChanged(i);
                }
            }
        };
    }

    /* renamed from: c */
    private void m6191c() {
        this.f9109F = new IMMessageViewStatusCallback() {
            public void onUpdate(int i, String str) {
                IMLog.m6631d(MessageAdapter.f9082H, C4234I.m6591t("[IMMessageViewStatusCallback] #onUpdate# position=", Integer.valueOf(i), " |data=", str));
            }

            public void deleteMessage(int i) {
                IMLog.m6631d(MessageAdapter.f9082H, C4234I.m6591t("[IMMessageViewStatusCallback] #deleteMessage# position=", Integer.valueOf(i)));
            }
        };
    }

    public void clearData() {
        if (m6178a() != null) {
            m6178a().removeCardViewStatusCallback(this.f9106C);
            m6178a().clear();
        }
        IMPluginCardViewProvider iMPluginCardViewProvider = this.f9107D;
        if (iMPluginCardViewProvider != null) {
            iMPluginCardViewProvider.removeMessageViewStatusCallback(this.f9109F);
            this.f9107D.clear();
        }
        List<Integer> list = this.f9105B;
        if (list != null) {
            list.clear();
        }
        Set<Integer> set = this.f9108E;
        if (set != null) {
            set.clear();
        }
    }

    public void setSessionInfo(boolean z, boolean z2) {
        this.f9112J = z;
        this.f9113K = z2;
    }

    public boolean getSupportStatus() {
        return this.f9112J;
    }

    public int getSessionType() {
        return this.f9110G;
    }

    public IMRenderCardEnv getRenderCardEnv() {
        return this.f9115M;
    }
}
