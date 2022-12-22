package com.didi.component.common.socialshare;

import androidx.core.app.NotificationCompat;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/component/common/socialshare/SharePlatforms;", "", "()V", "Companion", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SharePlatforms.kt */
public final class SharePlatforms {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final SharePlatform fromPlatform(String str) {
        return Companion.fromPlatform(str);
    }

    @JvmStatic
    public static final List<SharePlatform> fromPlatforms(String... strArr) {
        return Companion.fromPlatforms(strArr);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\t\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/common/socialshare/SharePlatforms$Companion;", "", "()V", "fromPlatform", "Lcom/didi/onekeyshare/entity/SharePlatform;", "platform", "", "fromPlatforms", "", "", "([Ljava/lang/String;)Ljava/util/List;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SharePlatforms.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SharePlatform fromPlatform(String str) {
            Intrinsics.checkNotNullParameter(str, "platform");
            if (StringsKt.equals(str, NotificationCompat.CATEGORY_SYSTEM, true)) {
                return SharePlatform.SYSTEM_PLATFORM;
            }
            if (StringsKt.equals(str, "sys_msgr", true)) {
                return SharePlatform.SYSTEM_MESSAGE;
            }
            if (StringsKt.equals(str, "cp_link", true)) {
                return SharePlatform.COPY_LINK_PLATFORM;
            }
            if (StringsKt.equals(str, "wx", true)) {
                return SharePlatform.WXCHAT_PLATFORM;
            }
            if (StringsKt.equals(str, "wx_moments", true)) {
                return SharePlatform.WXMOMENTS_PLATFORM;
            }
            if (StringsKt.equals(str, "wx_minapp", true)) {
                return SharePlatform.WXMINIPRO_PLATFORM;
            }
            if (StringsKt.equals(str, "qq", true)) {
                return SharePlatform.QQ_PLATFORM;
            }
            if (StringsKt.equals(str, "qzone", true)) {
                return SharePlatform.QZONE_PLATFORM;
            }
            if (StringsKt.equals(str, "alipay", true)) {
                return SharePlatform.ALIPAY_FRIEND_PLAFORM;
            }
            if (StringsKt.equals(str, "alipay_timeline", true)) {
                return SharePlatform.ALIPAY_CIRCLE_PLAFORM;
            }
            if (StringsKt.equals(str, "fb", true)) {
                return SharePlatform.FACEBOOK_PLATFORM;
            }
            if (StringsKt.equals(str, "fb_msgr", true)) {
                return SharePlatform.MESSENGER_PLATFORM;
            }
            if (StringsKt.equals(str, "wa_msgr", true)) {
                return SharePlatform.WHATSAPP_PLATFORM;
            }
            if (StringsKt.equals(str, ScarShareChannel.LINE, true)) {
                return SharePlatform.LINE_PLATFORM;
            }
            if (StringsKt.equals(str, ScarShareChannel.TWITTER, true)) {
                return SharePlatform.TWITTER_PLATFORM;
            }
            if (StringsKt.equals(str, "email", true)) {
                return SharePlatform.EMAIL_PLATFORM;
            }
            if (StringsKt.equals(str, "ding_talk", true)) {
                return SharePlatform.DINGD_DING_PLATFORM;
            }
            if (StringsKt.equals(str, InvitationPageActivity.CONTACTS, true)) {
                return SharePlatform.CONTACTS_PLATFORM;
            }
            if (StringsKt.equals(str, "weibo", true)) {
                return SharePlatform.WEIBO_PLATFORM;
            }
            if (StringsKt.equals(str, "local_img", true)) {
                return SharePlatform.SAVEIMAGE_PLATFORM;
            }
            if (StringsKt.equals(str, "vk", true)) {
                return SharePlatform.VK_PLATFORM;
            }
            if (StringsKt.equals(str, "telgr", true)) {
                return SharePlatform.TELEGRAM_PLATFORM;
            }
            if (StringsKt.equals(str, "pg_refresh", true)) {
                return SharePlatform.REFRESH_ICON;
            }
            if (StringsKt.isBlank(str)) {
                return SharePlatform.UNKNOWN;
            }
            return SharePlatform.SYSTEM_PLATFORM;
        }

        @JvmStatic
        public final List<SharePlatform> fromPlatforms(String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "platform");
            int i = 0;
            if (strArr.length == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                i++;
                arrayList.add(SharePlatforms.Companion.fromPlatform(str));
            }
            Collection collection = arrayList;
            return CollectionsKt.distinct(arrayList);
        }
    }
}
