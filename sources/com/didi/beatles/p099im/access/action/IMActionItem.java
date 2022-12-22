package com.didi.beatles.p099im.access.action;

import android.content.Context;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.model.IMMoreActionNetControlItem;

/* renamed from: com.didi.beatles.im.access.action.IMActionItem */
public abstract class IMActionItem {
    public static final int PHOTO_ALBUM = 2;
    public static final int TAKE_PHOTO = 1;
    public boolean enable;
    public final int iconId;
    public final IMExtendActionItem item;
    public IMMoreActionNetControlItem moreActionNetControlItem;
    public final String text;

    public abstract void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam);

    public IMActionItem(String str, int i) {
        this.enable = false;
        this.text = str;
        this.iconId = i;
        this.item = null;
        this.moreActionNetControlItem = null;
    }

    private IMActionItem(String str, int i, IMExtendActionItem iMExtendActionItem) {
        this.enable = false;
        this.text = str;
        this.iconId = i;
        this.item = iMExtendActionItem;
        this.moreActionNetControlItem = null;
    }

    public static IMActionItem createActionItemInner(IMExtendActionItem iMExtendActionItem) {
        return new IMActionItem(iMExtendActionItem.text, iMExtendActionItem.iconId, iMExtendActionItem) {
            public void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
            }
        };
    }
}
