package com.didi.beatles.p099im.views.bottombar;

import android.view.ViewGroup;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.protocol.view.IMSkinConfig;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.IMBottomSkinManager */
public class IMBottomSkinManager {
    public static final String KEY_BOARD = "key_board";

    /* renamed from: a */
    private static final String f9971a = "IMBottomSkinManager";

    /* renamed from: b */
    private boolean f9972b;

    /* renamed from: c */
    private ArrayList<IMSkinTextView> f9973c;

    public IMBottomSkinManager() {
        this.f9972b = false;
        this.f9973c = new ArrayList<>();
        this.f9972b = IMContextInfoHelper.isPad();
    }

    public void bindCommonWordView(IMSkinTextView iMSkinTextView) {
        if (!this.f9972b) {
            iMSkinTextView.setSkinMap(new SkinElementBuilder().setCancelEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_common_word_red))).setCommonEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_common_word_n))).setDisableEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_common_word_send))).setCustomEle(KEY_BOARD, new IMSkinElement(IMResource.getDrawableID(R.drawable.im_keyboard_n))).build());
        } else {
            iMSkinTextView.setSkinMap(new SkinElementBuilder().setCommonEle(new IMSkinElement(IMResource.getString(R.string.im_btn_text_common_word))).setCustomEle(KEY_BOARD, new IMSkinElement(IMResource.getString(R.string.im_btn_text_text))).build());
            iMSkinTextView.setText(IMResource.getString(R.string.im_btn_text_common_word));
        }
        m6725a(iMSkinTextView);
    }

    public void bindKeyBoardView(IMSkinTextView iMSkinTextView) {
        if (!this.f9972b) {
            iMSkinTextView.setSkinMap(new SkinElementBuilder().setCancelEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_keyboard_red))).setCommonEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_keyboard_n))).setDisableEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_keyboard_send))).build());
        } else {
            iMSkinTextView.setText(IMResource.getString(R.string.im_btn_text_text));
        }
        m6725a(iMSkinTextView);
        iMSkinTextView.setImageContentDescription(IMResource.getString(R.string.im_accessibility_keyboard_btn));
    }

    public void bindMoreBtnView(IMSkinTextView iMSkinTextView) {
        if (!this.f9972b) {
            iMSkinTextView.setSkinMap(new SkinElementBuilder().setDisableEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_more_send))).setCommonEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_more_n))).setCancelEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_more_red))).build());
        } else {
            iMSkinTextView.setText("更多");
        }
        m6725a(iMSkinTextView);
    }

    public void bindVoiceBtnView(IMSkinTextView iMSkinTextView) {
        if (!this.f9972b) {
            iMSkinTextView.setSkinMap(new SkinElementBuilder().setDisableEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_chat_voice_d))).setCommonEle(new IMSkinElement(IMResource.getDrawableID(R.drawable.im_chat_voice_n))).build());
        } else {
            iMSkinTextView.setText(IMResource.getString(R.string.im_btn_text_sound));
        }
        m6725a(iMSkinTextView);
        iMSkinTextView.setImageContentDescription(IMResource.getString(R.string.im_accessibility_voice_btn));
    }

    public void updateBtnView(IMSkinTextView iMSkinTextView, IMSkinConfig iMSkinConfig) {
        if (iMSkinConfig.skinElement.isEmpty()) {
            IMLog.m6635i(f9971a, "updateBtnView but config is empty");
            return;
        }
        if (!this.f9972b) {
            SkinElementBuilder skinElementBuilder = new SkinElementBuilder();
            for (IMSkinConfig.Element next : iMSkinConfig.skinElement) {
                int i = next.tag;
                if (i == 1) {
                    skinElementBuilder.setDisableEle(new IMSkinElement(next.drawable));
                } else if (i == 2) {
                    skinElementBuilder.setCommonEle(new IMSkinElement(next.drawable));
                } else if (i == 3) {
                    skinElementBuilder.setCancelEle(new IMSkinElement(next.drawable));
                }
            }
            iMSkinTextView.setSkinMap(skinElementBuilder.build());
        }
        if (iMSkinConfig.paddingConfig >= 0) {
            m6726a(iMSkinTextView, iMSkinConfig.paddingConfig);
        } else {
            m6725a(iMSkinTextView);
        }
    }

    /* renamed from: a */
    private void m6725a(IMSkinTextView iMSkinTextView) {
        m6726a(iMSkinTextView, 0);
    }

    /* renamed from: a */
    private void m6726a(IMSkinTextView iMSkinTextView, int i) {
        if (!this.f9973c.contains(iMSkinTextView)) {
            this.f9973c.add(iMSkinTextView);
        }
        if (!this.f9972b) {
            ViewGroup.LayoutParams layoutParams = iMSkinTextView.getLayoutParams();
            layoutParams.width = IMViewUtil.dp2px(iMSkinTextView.getContext(), 26.0f);
            layoutParams.height = IMViewUtil.dp2px(iMSkinTextView.getContext(), 26.0f);
            iMSkinTextView.setPadding(i, i, i, i);
            iMSkinTextView.setShowImage(true);
        }
    }

    public void showDisableSkin() {
        Iterator<IMSkinTextView> it = this.f9973c.iterator();
        while (it.hasNext()) {
            it.next().showDisableSkin();
        }
    }

    public void showCommonSkin() {
        Iterator<IMSkinTextView> it = this.f9973c.iterator();
        while (it.hasNext()) {
            it.next().showCommonSkin();
        }
    }

    public void showCancelSkin() {
        Iterator<IMSkinTextView> it = this.f9973c.iterator();
        while (it.hasNext()) {
            it.next().showCancelSkin();
        }
    }

    /* renamed from: com.didi.beatles.im.views.bottombar.IMBottomSkinManager$SkinElementBuilder */
    public class SkinElementBuilder {
        private Map<String, IMSkinElement> map;

        public SkinElementBuilder() {
        }

        public SkinElementBuilder setDisableEle(IMSkinElement iMSkinElement) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put("disable", iMSkinElement);
            return this;
        }

        public SkinElementBuilder setCancelEle(IMSkinElement iMSkinElement) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put("cancel", iMSkinElement);
            return this;
        }

        public SkinElementBuilder setCommonEle(IMSkinElement iMSkinElement) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put(IMSkinTextView.IM_SKIN_COMMON, iMSkinElement);
            return this;
        }

        public SkinElementBuilder setCustomEle(String str, IMSkinElement iMSkinElement) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put(str, iMSkinElement);
            return this;
        }

        public Map<String, IMSkinElement> build() {
            return this.map;
        }
    }
}
