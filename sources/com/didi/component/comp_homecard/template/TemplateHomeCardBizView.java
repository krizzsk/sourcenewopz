package com.didi.component.comp_homecard.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_homecard.template.TemplateHomeCardBizModel;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TemplateHomeCardBizView implements IXEView<TemplateHomeCardBizModel> {

    /* renamed from: a */
    private View f12250a;

    /* renamed from: b */
    private Context f12251b;

    /* renamed from: c */
    private ImageView f12252c;

    /* renamed from: d */
    private TextView f12253d;

    /* renamed from: e */
    private TextView f12254e;

    /* renamed from: f */
    private TextView f12255f;

    /* renamed from: g */
    private ViewStub f12256g;

    /* renamed from: h */
    private TextView f12257h;

    /* renamed from: i */
    private ViewStub f12258i;

    /* renamed from: j */
    private TextView f12259j;

    public void initView(Context context) {
        this.f12251b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_card_biz_layout, (ViewGroup) null);
        this.f12250a = inflate;
        this.f12252c = (ImageView) inflate.findViewById(R.id.template_home_card_content_iv);
        this.f12253d = (TextView) this.f12250a.findViewById(R.id.template_home_card_main_title_tv);
        this.f12254e = (TextView) this.f12250a.findViewById(R.id.template_home_card_content_tv);
        this.f12255f = (TextView) this.f12250a.findViewById(R.id.template_home_card_left_btn);
        this.f12256g = (ViewStub) this.f12250a.findViewById(R.id.template_home_card_btn_container_new_style);
        this.f12258i = (ViewStub) this.f12250a.findViewById(R.id.template_home_card_link_btn_container);
    }

    public void bindData(TemplateHomeCardBizModel templateHomeCardBizModel) {
        String str;
        final String str2;
        if (templateHomeCardBizModel == null || templateHomeCardBizModel.normal == null || templateHomeCardBizModel.normal.data == null) {
            this.f12250a.setVisibility(8);
            return;
        }
        HashMap hashMap = new HashMap();
        final String str3 = null;
        if (templateHomeCardBizModel.mExtension == null || templateHomeCardBizModel.mExtension.mLogData == null || templateHomeCardBizModel.mExtension.mLogData.mShowEvent == null || TextUtils.isEmpty(templateHomeCardBizModel.mExtension.mLogData.mShowEvent.mSwEventId)) {
            str = null;
        } else {
            str = templateHomeCardBizModel.mExtension.mLogData.mShowEvent.mSwEventId;
            JsonObject jsonObject = templateHomeCardBizModel.mExtension.mLogData.mShowEvent.mEventParams;
            if (jsonObject != null) {
                Set<String> keySet = jsonObject.keySet();
                if (!CollectionUtil.isEmpty((Collection<?>) keySet)) {
                    for (String next : keySet) {
                        JsonElement jsonElement = jsonObject.get(next);
                        if (jsonElement != null) {
                            hashMap.put(next, jsonElement.toString());
                        }
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
        }
        this.f12250a.setVisibility(0);
        final TemplateHomeCardBizModel.BizTemplateData bizTemplateData = templateHomeCardBizModel.normal.data;
        if (bizTemplateData.bgColor != null) {
            bizTemplateData.bgColor.bindView(this.f12250a, 20);
        }
        m8298a(bizTemplateData.title, this.f12253d);
        m8298a(bizTemplateData.subtitle, this.f12254e);
        if (bizTemplateData.rightIcon == null || TextUtils.isEmpty(bizTemplateData.rightIcon.url)) {
            this.f12252c.setVisibility(8);
        } else {
            this.f12252c.setVisibility(0);
            Glide.with(this.f12251b).asBitmap().load(bizTemplateData.rightIcon.url).into(this.f12252c);
            if (bizTemplateData.rightIcon.position == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12252c.getLayoutParams();
                layoutParams.rightMargin = UIUtils.dip2pxInt(this.f12251b, 0.0f);
                layoutParams.addRule(11);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12252c.getLayoutParams();
                layoutParams2.rightMargin = UIUtils.dip2pxInt(this.f12251b, 0.0f);
                layoutParams2.addRule(15);
                layoutParams2.addRule(11);
            }
        }
        if (bizTemplateData.config != null && !TextUtils.isEmpty(bizTemplateData.config.clickLink)) {
            this.f12250a.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DRouter.build(bizTemplateData.config.clickLink).start();
                }
            });
        }
        if (bizTemplateData.buttons != null && !CollectionUtil.isEmpty((Collection<?>) bizTemplateData.buttons.buttonList)) {
            final TemplateHomeCardBizModel.ButtonModel buttonModel = bizTemplateData.buttons.buttonList.get(0);
            final TemplateHomeCardBizModel.ButtonModel buttonModel2 = bizTemplateData.buttons.buttonList.size() == 2 ? bizTemplateData.buttons.buttonList.get(1) : null;
            if (buttonModel == null) {
                this.f12255f.setVisibility(8);
            } else {
                final HashMap hashMap2 = new HashMap();
                if (buttonModel.mExtension == null || buttonModel.mExtension.mLogData == null || buttonModel.mExtension.mLogData.mClickEvent == null || TextUtils.isEmpty(buttonModel.mExtension.mLogData.mClickEvent.mCkEventId)) {
                    str2 = null;
                } else {
                    str2 = buttonModel.mExtension.mLogData.mClickEvent.mCkEventId;
                    JsonObject jsonObject2 = buttonModel.mExtension.mLogData.mClickEvent.mEventParams;
                    if (jsonObject2 != null) {
                        Set<String> keySet2 = jsonObject2.keySet();
                        if (!CollectionUtil.isEmpty((Collection<?>) keySet2)) {
                            for (String next2 : keySet2) {
                                JsonElement jsonElement2 = jsonObject2.get(next2);
                                if (jsonElement2 != null) {
                                    hashMap2.put(next2, jsonElement2.toString());
                                }
                            }
                        }
                    }
                }
                if (buttonModel.theme != 0) {
                    int i = buttonModel.theme;
                } else if (buttonModel.position == 1) {
                    this.f12256g.inflate();
                    TextView textView = (TextView) this.f12250a.findViewById(R.id.global_template_card_btn_new_style);
                    this.f12257h = textView;
                    textView.setTextSize(20.0f);
                    if (buttonModel.title == null || TextUtils.isEmpty(buttonModel.title.getContent())) {
                        this.f12257h.setVisibility(8);
                    } else {
                        this.f12257h.setVisibility(0);
                        this.f12257h.setText(buttonModel.title.getContent());
                        this.f12257h.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                            public void onAntiShakeClick(View view) {
                                DRouter.build(buttonModel.url).start();
                                if (!TextUtils.isEmpty(str2)) {
                                    GlobalOmegaUtils.trackEvent(str2, (Map<String, Object>) hashMap2);
                                }
                            }
                        });
                    }
                } else if (buttonModel.position == 0) {
                    this.f12255f.setVisibility(0);
                    if (buttonModel.title == null || TextUtils.isEmpty(buttonModel.title.getContent())) {
                        this.f12255f.setVisibility(8);
                    } else {
                        this.f12255f.setVisibility(0);
                        this.f12255f.setText(buttonModel.title.getContent());
                        this.f12255f.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                            public void onAntiShakeClick(View view) {
                                DRouter.build(buttonModel.url).start();
                                if (!TextUtils.isEmpty(str2)) {
                                    GlobalOmegaUtils.trackEvent(str2, (Map<String, Object>) hashMap2);
                                }
                            }
                        });
                    }
                }
            }
            if (buttonModel2 != null) {
                final HashMap hashMap3 = new HashMap();
                if (!(buttonModel2.mExtension == null || buttonModel2.mExtension.mLogData == null || buttonModel2.mExtension.mLogData.mClickEvent == null || TextUtils.isEmpty(buttonModel2.mExtension.mLogData.mClickEvent.mCkEventId))) {
                    str3 = buttonModel2.mExtension.mLogData.mClickEvent.mCkEventId;
                    JsonObject jsonObject3 = buttonModel2.mExtension.mLogData.mClickEvent.mEventParams;
                    if (jsonObject3 != null) {
                        Set<String> keySet3 = jsonObject3.keySet();
                        if (!CollectionUtil.isEmpty((Collection<?>) keySet3)) {
                            for (String next3 : keySet3) {
                                JsonElement jsonElement3 = jsonObject3.get(next3);
                                if (jsonElement3 != null) {
                                    hashMap3.put(next3, jsonElement3.toString());
                                }
                            }
                        }
                    }
                }
                if (buttonModel2.theme == 1 && buttonModel2.position == 1) {
                    this.f12258i.inflate();
                    this.f12259j = (TextView) this.f12250a.findViewById(R.id.global_template_card_link_btn);
                    if (buttonModel2.title == null || TextUtils.isEmpty(buttonModel2.title.getContent())) {
                        this.f12259j.setVisibility(8);
                        return;
                    }
                    this.f12259j.setVisibility(0);
                    buttonModel2.title.bindTextView(this.f12259j);
                    this.f12259j.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            DRouter.build(buttonModel2.url).start();
                            if (!TextUtils.isEmpty(str3)) {
                                GlobalOmegaUtils.trackEvent(str3, (Map<String, Object>) hashMap3);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    private void m8298a(final TemplateHomeCardBizModel.TitleCk titleCk, TextView textView) {
        if (titleCk == null || titleCk.richTitle == null) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        titleCk.richTitle.bindTextView(textView);
        if (!TextUtils.isEmpty(titleCk.url)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.common_icon_arrow, 0);
            textView.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DRouter.build(titleCk.url).start();
                }
            });
        }
    }

    public View getView() {
        return this.f12250a;
    }
}
