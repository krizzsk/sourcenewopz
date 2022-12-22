package com.didi.beatles.p099im.views.bottombar.contain;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainCustom;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainEmoji;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainFunc;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainMsg;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainManager */
public class IMBtmContainManager {
    public static final int CONTAIN_CUM = 3;
    public static final int CONTAIN_EMOJI = 4;
    public static final int CONTAIN_FUNC = 2;
    public static final int CONTAIN_MSG = 1;

    /* renamed from: a */
    private final Context f10028a;

    /* renamed from: b */
    private final int f10029b;

    /* renamed from: c */
    private ViewStub f10030c;

    /* renamed from: d */
    private ViewStub f10031d;

    /* renamed from: e */
    private ViewStub f10032e;

    /* renamed from: f */
    private ViewStub f10033f;

    /* renamed from: g */
    private IMBtmContainMsg f10034g;

    /* renamed from: h */
    private boolean f10035h = false;

    /* renamed from: i */
    private List<IMEmojiModule> f10036i = null;

    /* renamed from: j */
    private List<String> f10037j = null;

    /* renamed from: k */
    private List<String> f10038k = null;

    /* renamed from: l */
    private IMBtmContainFunc f10039l;

    /* renamed from: m */
    private List<IMActionItem> f10040m = null;

    /* renamed from: n */
    private List<IMActionItem> f10041n = null;

    /* renamed from: o */
    private IMBtmContainCustom f10042o;

    /* renamed from: p */
    private View f10043p = null;

    /* renamed from: q */
    private boolean f10044q = false;

    /* renamed from: r */
    private IMBtmContainEmoji f10045r;

    /* renamed from: s */
    private List<IMEmojiModule> f10046s = null;

    /* renamed from: t */
    private IMBtmContainCallback f10047t;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainManager$Type */
    public @interface Type {
    }

    public IMBtmContainManager(View view, int i) {
        this.f10028a = view.getContext();
        this.f10029b = i;
        this.f10030c = (ViewStub) view.findViewById(R.id.user_view_contain_msg);
        this.f10031d = (ViewStub) view.findViewById(R.id.user_view_contain_func);
        this.f10032e = (ViewStub) view.findViewById(R.id.user_view_contain_custom);
        this.f10033f = (ViewStub) view.findViewById(R.id.user_view_contain_emoji);
    }

    public void release() {
        IMBtmContainMsg iMBtmContainMsg = this.f10034g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo44069a();
        }
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo44069a();
        }
        IMBtmContainCustom iMBtmContainCustom = this.f10042o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo44069a();
        }
        IMBtmContainEmoji iMBtmContainEmoji = this.f10045r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo44069a();
        }
    }

    public void setCallback(IMBtmContainCallback iMBtmContainCallback) {
        this.f10047t = iMBtmContainCallback;
        IMBtmContainMsg iMBtmContainMsg = this.f10034g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo44097a((IMBtmContainMsg.Callback) iMBtmContainCallback);
        }
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo44078a((IMBtmContainFunc.Callback) iMBtmContainCallback);
        }
        IMBtmContainCustom iMBtmContainCustom = this.f10042o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo44071a((IMBtmContainCustom.Callback) iMBtmContainCallback);
        }
        IMBtmContainEmoji iMBtmContainEmoji = this.f10045r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo44075a((IMBtmContainEmoji.Callback) iMBtmContainCallback);
        }
    }

    public void showContainView(int i, boolean z) {
        IMBtmContainEmoji iMBtmContainEmoji;
        IMBtmContainCustom iMBtmContainCustom;
        IMBtmContainFunc iMBtmContainFunc;
        IMBtmContainMsg iMBtmContainMsg;
        if (i == 1) {
            m6817a(z);
            this.f10034g.f10059b.setVisibility(0);
        } else if (i == 2) {
            m6816a();
            this.f10039l.f10059b.setVisibility(0);
        } else if (i == 3) {
            m6818b();
            this.f10042o.f10059b.setVisibility(0);
        } else if (i == 4) {
            m6819c();
            this.f10045r.f10059b.setVisibility(0);
        }
        if (!(i == 1 || (iMBtmContainMsg = this.f10034g) == null)) {
            iMBtmContainMsg.f10059b.setVisibility(8);
        }
        if (!(i == 2 || (iMBtmContainFunc = this.f10039l) == null)) {
            iMBtmContainFunc.f10059b.setVisibility(8);
        }
        if (!(i == 3 || (iMBtmContainCustom = this.f10042o) == null)) {
            iMBtmContainCustom.f10059b.setVisibility(8);
        }
        if (i != 4 && (iMBtmContainEmoji = this.f10045r) != null) {
            iMBtmContainEmoji.f10059b.setVisibility(8);
        }
    }

    public void configMsg(boolean z) {
        this.f10035h = z;
    }

    public void refreshEmojis(List<IMEmojiModule> list) {
        IMBtmContainMsg iMBtmContainMsg = this.f10034g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo44098a(list);
        } else {
            this.f10036i = list;
        }
    }

    public void refreshSystemComWords(List<String> list, boolean z) {
        IMBtmContainMsg iMBtmContainMsg = this.f10034g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo44099a(list, z);
        } else {
            this.f10037j = list;
        }
    }

    public void refreshCustomWords(List<String> list) {
        IMBtmContainMsg iMBtmContainMsg = this.f10034g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo44100b(list);
        } else {
            this.f10038k = list;
        }
    }

    public void refreshCustomView(View view, boolean z) {
        IMBtmContainCustom iMBtmContainCustom = this.f10042o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo44070a(view, z);
            return;
        }
        this.f10043p = view;
        this.f10044q = z;
    }

    public void refreshTabEmojis(List<IMEmojiModule> list) {
        IMBtmContainEmoji iMBtmContainEmoji = this.f10045r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo44076a(list);
        } else {
            this.f10046s = list;
        }
    }

    public void refreshSystemFunc(List<IMActionItem> list) {
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo44079a(list);
        } else {
            this.f10040m = list;
        }
    }

    public void refreshMoreFunc(List<IMActionItem> list) {
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo44081b(list);
        } else {
            this.f10041n = list;
        }
    }

    public void refreshFuncStatus(IMActionItem iMActionItem) {
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo44077a(iMActionItem);
        }
    }

    /* renamed from: a */
    private void m6817a(boolean z) {
        if (this.f10034g == null) {
            this.f10034g = new IMBtmContainMsg(this.f10030c.inflate(), this.f10035h, m6820d());
            List<String> list = this.f10037j;
            if (list != null) {
                refreshSystemComWords(list, z);
                this.f10037j = null;
            }
            List<String> list2 = this.f10038k;
            if (list2 != null) {
                refreshCustomWords(list2);
                this.f10038k = null;
            }
            List<IMEmojiModule> list3 = this.f10036i;
            if (list3 != null) {
                refreshEmojis(list3);
                this.f10036i = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f10047t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: a */
    private void m6816a() {
        if (this.f10039l == null) {
            this.f10039l = new IMBtmContainFunc(this.f10031d.inflate());
            List<IMActionItem> list = this.f10040m;
            if (list != null) {
                refreshSystemFunc(list);
                this.f10040m = null;
            }
            List<IMActionItem> list2 = this.f10041n;
            if (list2 != null) {
                refreshMoreFunc(list2);
                this.f10041n = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f10047t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: b */
    private void m6818b() {
        if (this.f10042o == null) {
            IMBtmContainCustom iMBtmContainCustom = new IMBtmContainCustom(this.f10032e.inflate());
            this.f10042o = iMBtmContainCustom;
            View view = this.f10043p;
            if (view != null) {
                iMBtmContainCustom.mo44070a(view, this.f10044q);
                this.f10043p = null;
                this.f10044q = false;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f10047t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: c */
    private void m6819c() {
        if (this.f10045r == null) {
            IMBtmContainEmoji iMBtmContainEmoji = new IMBtmContainEmoji(this.f10033f.inflate());
            this.f10045r = iMBtmContainEmoji;
            List<IMEmojiModule> list = this.f10046s;
            if (list != null) {
                iMBtmContainEmoji.mo44076a(list);
                this.f10046s = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f10047t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: d */
    private int m6820d() {
        if (IMContextInfoHelper.isPad()) {
            return 4;
        }
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(this.f10028a).getCurrentBusinessConfig(this.f10029b);
        if (currentBusinessConfig == null) {
            return 1;
        }
        return currentBusinessConfig.getCommonWordType();
    }

    public void invokeActionItem(IMActionItem iMActionItem, boolean z) {
        IMBtmContainCallback iMBtmContainCallback;
        if (iMActionItem != null && (iMBtmContainCallback = this.f10047t) != null) {
            iMBtmContainCallback.invokeAction(iMActionItem, z);
        }
    }

    public List<IMActionItem> getFuncList() {
        IMBtmContainFunc iMBtmContainFunc = this.f10039l;
        if (iMBtmContainFunc != null) {
            return iMBtmContainFunc.mo44080b();
        }
        ArrayList arrayList = new ArrayList();
        List<IMActionItem> list = this.f10041n;
        if (list != null) {
            arrayList.addAll(list);
        }
        List<IMActionItem> list2 = this.f10040m;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }
}
