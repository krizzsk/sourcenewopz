package com.didi.beatles.p099im.views.bottombar.tab;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.plugin.IMPluginFactory;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory */
public final class IMTabActionFactory {

    /* renamed from: a */
    private static final String f10130a = IMTabActionFactory.class.getSimpleName();

    /* renamed from: b */
    private IMTabActionItem f10131b;

    /* renamed from: c */
    private IMTabActionItem f10132c;

    /* renamed from: d */
    private IMTabActionItem f10133d;

    public void release() {
        IMLog.m6635i(f10130a, "[release]");
        this.f10131b = null;
        this.f10132c = null;
        this.f10133d = null;
    }

    /* renamed from: a */
    private IMTabActionItem m6912a(Context context) {
        if (this.f10131b == null) {
            this.f10131b = new IMTabActionItem(4, context.getString(R.string.im_bottombar_button_expression), R.drawable.im_bottom_bar_tab_message_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f10131b;
    }

    /* renamed from: b */
    private IMTabActionItem m6914b(Context context) {
        if (this.f10132c == null) {
            this.f10132c = new IMTabActionItem(6, context.getString(R.string.im_bottombar_button_emoji), R.drawable.im_bottom_bar_tab_emoji_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f10132c;
    }

    /* renamed from: a */
    private IMTabActionItem m6913a(Context context, String str) {
        if (this.f10133d == null) {
            if (TextUtils.isEmpty(str)) {
                str = context.getString(R.string.im_bottombar_button_more);
            }
            this.f10133d = new IMTabActionItem(5, str, R.drawable.im_bottom_bar_tab_more_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f10133d;
    }

    public IMTabActionItem loadTabActionItem(Context context, int i, IMTabInvokeEnv iMTabInvokeEnv) {
        return loadTabActionItem(context, i, iMTabInvokeEnv, (String) null);
    }

    public IMTabActionItem loadTabActionItem(Context context, int i, IMTabInvokeEnv iMTabInvokeEnv, String str) {
        if (i == 4) {
            return m6912a(context);
        }
        if (i == 6) {
            return m6914b(context);
        }
        if (i == 5) {
            return m6913a(context, str);
        }
        IMPluginService plugin = IMPluginFactory.getPlugin(i);
        if (plugin == null) {
            IMLog.m6632e(f10130a, C4234I.m6591t("[loadTabActionItem] Plugin id :", Integer.valueOf(i), " not implement yet."));
            return null;
        }
        IMTabActionItem tabActionItem = plugin.getTabActionItem(context, iMTabInvokeEnv);
        if (tabActionItem == null) {
            IMLog.m6632e(f10130a, C4234I.m6591t("[loadTabActionItem] Plugin id :", Integer.valueOf(i), " without tab action item."));
            return null;
        }
        IMLog.m6632e(f10130a, C4234I.m6591t("[loadTabActionItem] Tab item with plugin id :", Integer.valueOf(i)));
        return tabActionItem;
    }
}
