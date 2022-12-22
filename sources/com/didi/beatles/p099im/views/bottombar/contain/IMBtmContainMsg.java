package com.didi.beatles.p099im.views.bottombar.contain;

import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.adapter.IMCommonWordAdapter;
import com.didi.beatles.p099im.adapter.IMEmojiAdapter;
import com.didi.beatles.p099im.event.IMAddCustomWordEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMEmotionInputDetector;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.beatles.p099im.views.buttonView.IMSwitchView;
import com.didi.beatles.p099im.views.dialog.IMAddCommonWordDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainMsg */
class IMBtmContainMsg extends C4306a {

    /* renamed from: c */
    private static final double f10048c = 4.5d;

    /* renamed from: d */
    private final boolean f10049d;

    /* renamed from: e */
    private final int f10050e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Callback f10051f;

    /* renamed from: g */
    private IIMUserModule f10052g;

    /* renamed from: h */
    private Toast f10053h;

    /* renamed from: i */
    private RecyclerView f10054i;

    /* renamed from: j */
    private IMCommonWordAdapter f10055j;

    /* renamed from: k */
    private RecyclerView f10056k;

    /* renamed from: l */
    private IMEmojiAdapter f10057l;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainMsg$Callback */
    interface Callback {
        void addCommonWord(int i);

        void sendCommonWord(String str, int i);

        void sendEmoji(String str, String str2, String str3);
    }

    IMBtmContainMsg(View view, boolean z, int i) {
        super(view);
        this.f10049d = z;
        this.f10050e = i;
        m6823a(view);
        EventBus.getDefault().register(this);
    }

    /* renamed from: a */
    public void mo44097a(Callback callback) {
        this.f10051f = callback;
    }

    /* renamed from: a */
    public void mo44069a() {
        this.f10051f = null;
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: a */
    private void m6823a(View view) {
        this.f10054i = (RecyclerView) view.findViewById(R.id.bottom_list);
        if (this.f10049d) {
            this.f10056k = (RecyclerView) view.findViewById(R.id.emoji_recyclerview);
            IMSwitchView iMSwitchView = (IMSwitchView) view.findViewById(R.id.im_bottombar_switch);
            iMSwitchView.setVisibility(0);
            iMSwitchView.setOnCheckListener(new IMSwitchView.IMSwitchCheckListener() {
                public void leftBtnChecked() {
                    IMBtmContainMsg.this.m6829b();
                }

                public void rightBtnChecked() {
                    IMBtmContainMsg.this.m6833c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6829b() {
        RecyclerView recyclerView = this.f10056k;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
        this.f10054i.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6833c() {
        RecyclerView recyclerView = this.f10056k;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        this.f10054i.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6835d() {
        RecyclerView recyclerView = this.f10054i;
        if (recyclerView != null && recyclerView.isShown() && this.f10055j != null) {
            this.f10054i.smoothScrollToPosition(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44098a(List<IMEmojiModule> list) {
        if (this.f10049d) {
            IMEmojiAdapter iMEmojiAdapter = this.f10057l;
            if (iMEmojiAdapter != null) {
                iMEmojiAdapter.changeEmojiList(list);
            } else {
                m6834c(list);
            }
        }
    }

    /* renamed from: c */
    private void m6834c(List<IMEmojiModule> list) {
        if (this.f10056k != null) {
            this.f10056k.setLayoutManager(new GridLayoutManager(this.f10058a, 4, 1, false));
            IMEmojiAdapter iMEmojiAdapter = new IMEmojiAdapter(this.f10058a, (IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f10058a, 50.0f)) / 2, list, new IMEmojiAdapter.IMEmojiViewOnClickListener() {
                public void onClick(String str, String str2, String str3) {
                    if (IMBtmContainMsg.this.f10051f != null) {
                        IMBtmContainMsg.this.f10051f.sendEmoji(str, str2, str3);
                    }
                }
            });
            this.f10057l = iMEmojiAdapter;
            this.f10056k.setAdapter(iMEmojiAdapter);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44099a(List<String> list, boolean z) {
        IMCommonWordAdapter iMCommonWordAdapter = this.f10055j;
        if (iMCommonWordAdapter != null) {
            iMCommonWordAdapter.replaceSystemList(list, z);
        } else {
            m6831b(list, z);
        }
    }

    /* renamed from: b */
    private void m6831b(List<String> list, boolean z) {
        int i;
        if (list != null && list.size() > 0) {
            if (this.f10049d) {
                i = IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f10058a, 50.0f);
            } else {
                i = IMEmotionInputDetector.keyboardHeight;
            }
            List<String> list2 = list;
            IMCommonWordAdapter iMCommonWordAdapter = new IMCommonWordAdapter(this.f10058a, list2, IMManager.getInstance().getCustomUsefulExpression(), (int) (((double) i) / f10048c), this.f10050e, z);
            this.f10055j = iMCommonWordAdapter;
            iMCommonWordAdapter.setCommonWordClickListener(new IMCommonWordAdapter.IMCommonWordClickListener() {
                public void sendCommonWord(String str, int i) {
                    if (IMBtmContainMsg.this.f10051f != null) {
                        IMBtmContainMsg.this.f10051f.sendCommonWord(str, i);
                    }
                }

                public void addCommonWord(int i) {
                    if (IMBtmContainMsg.this.f10051f != null) {
                        IMBtmContainMsg.this.f10051f.addCommonWord(i);
                    }
                }

                public void deleteCommonWord(String str) {
                    IMBtmContainMsg.this.m6828a(str);
                }
            });
            if (IMContextInfoHelper.isPad()) {
                this.f10054i.setLayoutManager(new LinearLayoutManager(this.f10058a, 0, false));
            } else {
                this.f10054i.setLayoutManager(new LinearLayoutManager(this.f10058a, 1, false));
            }
            this.f10054i.setAdapter(this.f10055j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo44100b(List<String> list) {
        IMCommonWordAdapter iMCommonWordAdapter = this.f10055j;
        if (iMCommonWordAdapter != null) {
            iMCommonWordAdapter.replaceCustomList(list);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    /* renamed from: a */
    public void mo44096a(IMAddCustomWordEvent iMAddCustomWordEvent) {
        final IMAddCommonWordDialog.CustomWord customWord = iMAddCustomWordEvent.customWord;
        if (this.f10052g == null) {
            this.f10052g = IMManager.getInstance().getUserModel();
        }
        IIMUserModule iIMUserModule = this.f10052g;
        if (iIMUserModule != null && customWord != null) {
            iIMUserModule.executeUsfulExpression(1, customWord.resource, customWord.text, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", Integer.valueOf(customWord.resource));
                    if (i == 0) {
                        hashMap.put("state", 1);
                    } else {
                        hashMap.put("state", 2);
                    }
                    IMMsgOmega.getInstance().track("ddim_dy_all_sure_ck", hashMap);
                    if (i == 0) {
                        IMBtmContainMsg.this.mo44100b(IMManager.getInstance().getCustomUsefulExpression());
                        IMBtmContainMsg.this.m6821a((int) R.drawable.im_toast_succeed, (int) R.string.im_add_word_succeed);
                        IMBtmContainMsg.this.m6835d();
                        return;
                    }
                    IMBtmContainMsg.this.m6822a((int) R.drawable.im_toast_warm, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6828a(String str) {
        if (this.f10052g == null) {
            this.f10052g = IMManager.getInstance().getUserModel();
        }
        IIMUserModule iIMUserModule = this.f10052g;
        if (iIMUserModule != null) {
            iIMUserModule.executeUsfulExpression(2, 0, str, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    if (i == 0) {
                        IMBtmContainMsg.this.mo44100b(IMManager.getInstance().getCustomUsefulExpression());
                    } else {
                        IMBtmContainMsg.this.m6822a((int) R.drawable.im_toast_warm, str);
                    }
                    HashMap hashMap = new HashMap();
                    if (i == 0) {
                        hashMap.put("state", 1);
                    } else {
                        hashMap.put("state", 2);
                    }
                    IMMsgOmega.getInstance().track("ddim_dy_all_del_ck", hashMap);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6821a(int i, int i2) {
        m6822a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6822a(int i, String str) {
        if (this.f10053h == null) {
            this.f10053h = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        }
        SystemUtils.showToast(this.f10053h);
        IMTipsToast.setIconKeepSize(this.f10053h, i);
        IMTipsToast.setText(this.f10053h, str);
    }
}
