package com.didi.beatles.p099im.access.action;

import android.app.Activity;
import android.content.Context;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.picture.IMPictureSelector;
import com.didi.beatles.p099im.plugin.IMPluginFactory;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.action.IMActionFactory */
public class IMActionFactory {

    /* renamed from: a */
    private static final String f8715a = IMActionFactory.class.getSimpleName();

    public static List<IMActionItem> generateItems(Context context, List<Integer> list, List<Integer> list2, List<Integer> list3) {
        IMActionItem a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer next : list) {
            if (!(next == null || (a = m5822a(context, next.intValue(), list3)) == null)) {
                a.enable = list2 != null && list2.contains(next);
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static IMActionItem m5822a(Context context, int i, List<Integer> list) {
        boolean z;
        if (context == null) {
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                if (list == null) {
                    IMLog.m6632e(f8715a, C4234I.m6591t("[getAction] NULL plugin list."));
                    return null;
                }
                Iterator<Integer> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Integer next = it.next();
                    if (next != null && next.intValue() == i) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    IMLog.m6632e(f8715a, C4234I.m6591t("[getAction] Action id :", Integer.valueOf(i), " not registered by business."));
                    return null;
                }
                IMPluginService plugin = IMPluginFactory.getPlugin(i);
                if (plugin == null) {
                    IMLog.m6632e(f8715a, C4234I.m6591t("[getAction] Action id :", Integer.valueOf(i), " not implement yet."));
                    return null;
                }
                IMExtendActionItem extendActionItem = plugin.getExtendActionItem(context);
                if (extendActionItem == null) {
                    IMLog.m6632e(f8715a, C4234I.m6591t("[getAction] Action id :", Integer.valueOf(i), " without extend action item."));
                    return null;
                }
                IMLog.m6632e(f8715a, C4234I.m6591t("[getAction] Add item with action id :", Integer.valueOf(i)));
                return IMActionItem.createActionItemInner(extendActionItem);
            } else if (!IMContextInfoHelper.enableSendImage()) {
                return null;
            } else {
                return new IMActionItem(context.getString(R.string.im_picture_album), R.drawable.im_action_album) {
                    public void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
                        IMPictureSelector.create((Activity) context).openGallery().maxSelectNum(9).maxImageSize(200).enableSelectOverlay(false).minSelectNum(1).imageSpanCount(4).selectionMode(2).previewImage(true).showCameraInGallery(false).isZoomAnim(true).glideOverride(160, 160).isGif(false).compress(true).minimumCompressSize(100).forResult(188);
                    }
                };
            }
        } else if (!IMContextInfoHelper.enableSendImage()) {
            return null;
        } else {
            return new IMActionItem(context.getString(R.string.im_picture_photo), R.drawable.im_action_photo) {
                public void invokeAction(Context context, IMSession iMSession, IMBusinessParam iMBusinessParam) {
                    IMPictureSelector.create((Activity) context).openCamera().maxImageSize(200).glideOverride(160, 160).compress(true).minimumCompressSize(100).forResult(188);
                }
            };
        }
    }
}
