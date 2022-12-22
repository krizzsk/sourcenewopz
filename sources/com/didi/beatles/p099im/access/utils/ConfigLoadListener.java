package com.didi.beatles.p099im.access.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.utils.ConfigLoadListener */
public abstract class ConfigLoadListener {
    public static final String GUIDE_BOTTOM = "bottom";
    public static final String GUIDE_MORE = "more";

    /* renamed from: com.didi.beatles.im.access.utils.ConfigLoadListener$IMGetEmojiListCallback */
    public interface IMGetEmojiListCallback {
        void finishLoad(ArrayList<IMEmojiModule> arrayList);
    }

    /* renamed from: com.didi.beatles.im.access.utils.ConfigLoadListener$IMGuideAction */
    public interface IMGuideAction {
        void dismiss();

        void show(Map<String, View> map);
    }

    @Deprecated
    public ArrayList<IMEmojiModule> getEmojiList(String str) {
        return null;
    }

    public void getEmojiList(String str, IMGetEmojiListCallback iMGetEmojiListCallback) {
    }

    public List<IMActionItem> getMoreAction(String str) {
        return null;
    }

    public void onBottomBarExpandViewShow(int i, IMSession iMSession, IMBusinessParam iMBusinessParam) {
    }

    public void onChatTitleRightIconClick(Activity activity, View view) {
    }

    @Deprecated
    public void onClickPhone(Context context, String str) {
    }

    public boolean onGoLinkUrl(Context context, IMSession iMSession, String str) {
        return false;
    }

    public void onMoreButtonShow(IMSession iMSession, IMBusinessParam iMBusinessParam) {
    }

    public ArrayList<String> onQuickMessageLoaded(String str) {
        return null;
    }

    public IMGuideAction showBottomBarGuide(Context context, IMSession iMSession, String str, Map<String, View> map) {
        return null;
    }

    @Deprecated
    public boolean showBottomExtendView(Context context, IMSession iMSession) {
        return false;
    }

    @Deprecated
    public boolean showBottomExtendView(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean dispatchShowBottomExtendView(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
        return showBottomExtendView(context, iMSession) || showBottomExtendView(context, iMSession, iMBusinessParam);
    }
}
