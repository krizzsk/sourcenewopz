package com.didi.component.framework.pages.promo.helper;

import com.didi.onekeyshare.entity.SharePlatform;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/helper/MapToSharePlatform;", "", "()V", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapToSharePlatform.kt */
public final class MapToSharePlatform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PROMO_APPLY_CLICK = "Mark_Promocodeenter_Confirmbt_ck";
    public static final String PROMO_CHANNEL_CLICK = "Mark_Promoresult_share_ck";
    public static final String PROMO_CODE_INPUT_CK = "Mark_Promocodeenter_input_ck";
    public static final String PROMO_COUPON_CLICK = "Mark_Promocodeenter_mycouponbt_ck";
    public static final String PROMO_MORE_CLICK = "Mark_Promoresult_sharebt_ck";
    public static final String PROMO_SHARE_PAGE = "Mark_Promoresult_sw";
    public static final String PROMO_SHOW_PAGE = "Mark_Promocodeenter_sw";
    public static final String PROMO_TERM_OF_USE = "Mark_Promocodeenter_TMSofusebt_ck";
    public static final String PROMO_VALUE_BACK = "Mark_Promocodeenter_back";

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/helper/MapToSharePlatform$Companion;", "", "()V", "PROMO_APPLY_CLICK", "", "PROMO_CHANNEL_CLICK", "PROMO_CODE_INPUT_CK", "PROMO_COUPON_CLICK", "PROMO_MORE_CLICK", "PROMO_SHARE_PAGE", "PROMO_SHOW_PAGE", "PROMO_TERM_OF_USE", "PROMO_VALUE_BACK", "getMapPlatform", "Lcom/didi/onekeyshare/entity/SharePlatform;", "channel", "", "(Ljava/lang/Integer;)Lcom/didi/onekeyshare/entity/SharePlatform;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MapToSharePlatform.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharePlatform getMapPlatform(Integer num) {
            if (num == null) {
                SharePlatform sharePlatform = SharePlatform.UNKNOWN;
            }
            if (num != null && num.intValue() == 1) {
                return SharePlatform.FACEBOOK_PLATFORM;
            }
            if (num != null && num.intValue() == 2) {
                return SharePlatform.MESSENGER_PLATFORM;
            }
            if (num != null && num.intValue() == 3) {
                return SharePlatform.TWITTER_PLATFORM;
            }
            if (num != null && num.intValue() == 4) {
                return SharePlatform.WHATSAPP_PLATFORM;
            }
            if (num != null && num.intValue() == 5) {
                return SharePlatform.LINE_PLATFORM;
            }
            if (num != null && num.intValue() == 6) {
                return SharePlatform.SYSTEM_MESSAGE;
            }
            if (num != null && num.intValue() == 7) {
                return SharePlatform.EMAIL_PLATFORM;
            }
            if (num != null && num.intValue() == 8) {
                return SharePlatform.WXCHAT_PLATFORM;
            }
            if (num != null && num.intValue() == 10) {
                return SharePlatform.COPY_LINK_PLATFORM;
            }
            if (num != null && num.intValue() == 12) {
                return SharePlatform.VK_PLATFORM;
            }
            return SharePlatform.UNKNOWN;
        }
    }
}
