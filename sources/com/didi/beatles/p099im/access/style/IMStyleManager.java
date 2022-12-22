package com.didi.beatles.p099im.access.style;

import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.access.style.IMStyleManager */
public class IMStyleManager {

    /* renamed from: com.didi.beatles.im.access.style.IMStyleManager$Style */
    public enum Style {
        UNDEFINED,
        DEFAULT,
        GLOBAL_PSG
    }

    /* renamed from: com.didi.beatles.im.access.style.IMStyleManager$1 */
    static /* synthetic */ class C38721 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$beatles$im$access$style$IMStyleManager$Style;

        static {
            int[] iArr = new int[Style.values().length];
            $SwitchMap$com$didi$beatles$im$access$style$IMStyleManager$Style = iArr;
            try {
                iArr[Style.GLOBAL_PSG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void loadStyle(int i, IMBusinessConfig iMBusinessConfig, Style style) {
        if (C38721.$SwitchMap$com$didi$beatles$im$access$style$IMStyleManager$Style[style.ordinal()] == 1) {
            m5916a(i, iMBusinessConfig);
        }
    }

    /* renamed from: a */
    private static void m5916a(int i, IMBusinessConfig iMBusinessConfig) {
        iMBusinessConfig.registerImResource("im_titlebar_call_phone", R.drawable.im_titlebar_call_phone_global_psg);
        iMBusinessConfig.registerImResource("im_bottom_bar_background_round", R.drawable.im_empty_drawable);
        iMBusinessConfig.registerImResource("im_bottom_bar_input_bg", R.drawable.im_empty_drawable);
        iMBusinessConfig.registerImResource("im_bottom_bar_voice_text_bg_nor", R.drawable.im_empty_drawable);
        iMBusinessConfig.registerImResource("im_keyboard_n", R.drawable.im_icon_keyboard_global_psg);
        iMBusinessConfig.registerImResource("im_chat_voice_n", R.drawable.im_icon_microphone_global_psg);
        iMBusinessConfig.registerImResource("im_common_word_n", R.drawable.im_icon_quick_global_psg);
        iMBusinessConfig.registerImResource("im_more_n", R.drawable.im_icon_expand_global_psg);
        iMBusinessConfig.registerImResource("im_custom_word_divider_line", R.drawable.im_custom_word_divider_line_global_psg);
        iMBusinessConfig.registerImResource("im_common_title_bar_btn_back_selector", R.drawable.im_common_title_bar_btn_back_global_psg);
        iMBusinessConfig.registerImResource("im_color_msg_has_read", R.color.im_color_msg_read_global_psg);
        iMBusinessConfig.registerImResource("im_color_msg_un_read", R.color.im_color_msg_read_global_psg);
        iMBusinessConfig.registerImResource("im_right_black_bubble_selector", R.drawable.im_right_black_bubble_selector_global_psg);
        iMBusinessConfig.registerImResource("im_left_bubble_selector", R.drawable.im_left_bubble_selector_global_psg);
        iMBusinessConfig.registerImResource("im_toast_succeed", R.drawable.im_picture_ic_select);
        iMBusinessConfig.registerImResource("im_toast_warm", R.drawable.im_toast_warm_global_psg);
    }

    public static Style getCurBusinessStyle() {
        IMBusinessConfig businessConfig = IMResource.getBusinessConfig();
        if (businessConfig == null) {
            return Style.DEFAULT;
        }
        return businessConfig.getIMStyle();
    }
}
