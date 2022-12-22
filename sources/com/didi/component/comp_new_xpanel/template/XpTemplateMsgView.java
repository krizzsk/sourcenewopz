package com.didi.component.comp_new_xpanel.template;

import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.model.XpTemplateMsgModel;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpTemplateMsgView implements IXEView<XpTemplateMsgModel> {

    /* renamed from: p */
    private static final String f12321p = "android.accessibilityservice.AccessibilityService";

    /* renamed from: q */
    private static final String f12322q = "android.accessibilityservice.category.FEEDBACK_SPOKEN";

    /* renamed from: a */
    private View f12323a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f12324b;

    /* renamed from: c */
    private ImageView f12325c;

    /* renamed from: d */
    private FrameLayout f12326d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextSwitcher f12327e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewSwitcher f12328f;

    /* renamed from: g */
    private boolean f12329g = true;

    /* renamed from: h */
    private boolean f12330h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f12331i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f12332j = 4;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f12333k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f12334l = 4;

    /* renamed from: m */
    private String f12335m;

    /* renamed from: n */
    private String f12336n;

    /* renamed from: o */
    private int f12337o;

    public void initView(Context context) {
        this.f12324b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_msg_template, (ViewGroup) null);
        this.f12323a = inflate;
        this.f12328f = (ViewSwitcher) inflate.findViewById(R.id.xp_msg_title_switcher);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12324b, R.anim.in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f12324b, R.anim.out);
        this.f12328f.setInAnimation(loadAnimation);
        this.f12328f.setOutAnimation(loadAnimation2);
        m8359b(loadAnimation2);
        this.f12328f.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                return new XpMsgTitleLayout(XpTemplateMsgView.this.f12324b);
            }
        });
        this.f12327e = (TextSwitcher) this.f12323a.findViewById(R.id.xp_msg_subtitle_switcher);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this.f12324b, R.anim.in);
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this.f12324b, R.anim.out);
        this.f12327e.setInAnimation(loadAnimation3);
        this.f12327e.setOutAnimation(loadAnimation4);
        m8352a(loadAnimation4);
        this.f12327e.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                return LayoutInflater.from(XpTemplateMsgView.this.f12324b).inflate(R.layout.g_xp_msg_subtitle, XpTemplateMsgView.this.f12327e, false);
            }
        });
        this.f12325c = (ImageView) this.f12323a.findViewById(R.id.xp_msg_bg_img);
        this.f12326d = (FrameLayout) this.f12323a.findViewById(R.id.xp_msg_bg_color);
    }

    /* renamed from: a */
    private void m8352a(Animation animation) {
        final int duration = (int) (animation.getDuration() / 2);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                XpTemplateMsgView xpTemplateMsgView = XpTemplateMsgView.this;
                int unused = xpTemplateMsgView.f12331i = xpTemplateMsgView.f12327e.getHeight();
                ViewGroup.LayoutParams layoutParams = XpTemplateMsgView.this.f12327e.getLayoutParams();
                layoutParams.height = -2;
                XpTemplateMsgView.this.f12327e.setLayoutParams(layoutParams);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        final int measuredHeight = XpTemplateMsgView.this.f12327e.getCurrentView().getMeasuredHeight();
                        if (TextUtils.isEmpty(((TextView) XpTemplateMsgView.this.f12327e.getCurrentView()).getText().toString())) {
                            measuredHeight = 0;
                        }
                        if (measuredHeight < XpTemplateMsgView.this.f12331i) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{XpTemplateMsgView.this.f12331i, measuredHeight});
                            ofInt.setDuration((long) duration);
                            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    ViewGroup.LayoutParams layoutParams = XpTemplateMsgView.this.f12327e.getLayoutParams();
                                    layoutParams.height = intValue + (measuredHeight == 0 ? 0 : XpTemplateMsgView.this.f12332j);
                                    XpTemplateMsgView.this.f12327e.setLayoutParams(layoutParams);
                                }
                            });
                            ofInt.start();
                        }
                    }
                }, 50);
            }

            public void onAnimationEnd(Animation animation) {
                int measuredHeight = XpTemplateMsgView.this.f12327e.getCurrentView().getMeasuredHeight();
                int unused = XpTemplateMsgView.this.f12332j = XpTemplateMsgView.this.f12327e.getMeasuredHeight() - measuredHeight;
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT);
            }
        });
    }

    /* renamed from: b */
    private void m8359b(Animation animation) {
        final int duration = (int) (animation.getDuration() / 2);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                XpTemplateMsgView xpTemplateMsgView = XpTemplateMsgView.this;
                int unused = xpTemplateMsgView.f12333k = xpTemplateMsgView.f12328f.getHeight();
                ViewGroup.LayoutParams layoutParams = XpTemplateMsgView.this.f12328f.getLayoutParams();
                layoutParams.height = -2;
                XpTemplateMsgView.this.f12328f.setLayoutParams(layoutParams);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        final int measuredHeight = XpTemplateMsgView.this.f12328f.getCurrentView().getMeasuredHeight();
                        if (((XpMsgTitleLayout) XpTemplateMsgView.this.f12328f.getCurrentView()).isTitleEmpty()) {
                            measuredHeight = 0;
                        }
                        if (measuredHeight < XpTemplateMsgView.this.f12333k) {
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{XpTemplateMsgView.this.f12333k, measuredHeight});
                            ofInt.setDuration((long) duration);
                            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    ViewGroup.LayoutParams layoutParams = XpTemplateMsgView.this.f12328f.getLayoutParams();
                                    layoutParams.height = intValue + (measuredHeight == 0 ? 0 : XpTemplateMsgView.this.f12334l);
                                    XpTemplateMsgView.this.f12328f.setLayoutParams(layoutParams);
                                }
                            });
                            ofInt.start();
                        }
                    }
                }, 50);
            }

            public void onAnimationEnd(Animation animation) {
                int measuredHeight = XpTemplateMsgView.this.f12328f.getCurrentView().getMeasuredHeight();
                int unused = XpTemplateMsgView.this.f12334l = XpTemplateMsgView.this.f12328f.getMeasuredHeight() - measuredHeight;
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT);
            }
        });
    }

    public void setPageId(int i) {
        this.f12337o = i;
    }

    public void bindData(final XpTemplateMsgModel xpTemplateMsgModel) {
        if (xpTemplateMsgModel == null || xpTemplateMsgModel.normal == null || xpTemplateMsgModel.normal.data == null) {
            this.f12323a.setVisibility(8);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT);
            return;
        }
        this.f12323a.setVisibility(0);
        m8354a("ibt_gp_tripservice_operationcard_sw", xpTemplateMsgModel);
        final XpTemplateMsgModel.MsgTemplateData msgTemplateData = xpTemplateMsgModel.normal.data;
        if (msgTemplateData.title == null || TextUtils.isEmpty(msgTemplateData.title.getContent())) {
            this.f12330h = true;
            this.f12335m = null;
            this.f12328f.setVisibility(8);
        } else if (this.f12330h) {
            this.f12328f.setVisibility(0);
            this.f12330h = false;
            ((XpMsgTitleLayout) this.f12328f.getCurrentView()).update(msgTemplateData);
            this.f12335m = msgTemplateData.titleKey;
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_REFRESH_HEIGHT);
        } else if (!TextUtils.isEmpty(this.f12335m) && !this.f12335m.equals(msgTemplateData.titleKey)) {
            if (xpTemplateMsgModel.normal.isNeedAnim) {
                ((XpMsgTitleLayout) this.f12328f.getNextView()).update(msgTemplateData);
                this.f12328f.showNext();
            } else {
                ((XpMsgTitleLayout) this.f12328f.getCurrentView()).update(msgTemplateData);
            }
            this.f12335m = msgTemplateData.titleKey;
        } else if (msgTemplateData.title_type == 4 || msgTemplateData.title_type == 6 || msgTemplateData.title_type == 5) {
            ((XpMsgTitleLayout) this.f12328f.getCurrentView()).update(msgTemplateData);
        }
        if (msgTemplateData.subtitle == null || TextUtils.isEmpty(msgTemplateData.subtitle.getContent())) {
            this.f12329g = true;
            this.f12336n = null;
            this.f12327e.setVisibility(8);
        } else if (this.f12329g) {
            this.f12327e.setVisibility(0);
            this.f12329g = false;
            msgTemplateData.subtitle.bindTextView((TextView) this.f12327e.getCurrentView());
            this.f12336n = msgTemplateData.subtitleKey;
        } else if (!TextUtils.isEmpty(this.f12336n) && !this.f12336n.equals(msgTemplateData.subtitleKey)) {
            if (xpTemplateMsgModel.normal.isNeedAnim) {
                msgTemplateData.subtitle.bindTextView((TextView) this.f12327e.getNextView());
                this.f12327e.showNext();
            } else {
                msgTemplateData.subtitle.bindTextView((TextView) this.f12327e.getCurrentView());
            }
            this.f12336n = msgTemplateData.subtitleKey;
        } else if (msgTemplateData.subtitle_type == 4) {
            msgTemplateData.subtitle.bindTextView((TextView) this.f12327e.getCurrentView());
        }
        if (!TextUtils.isEmpty(msgTemplateData.rightIcon)) {
            this.f12325c.setVisibility(0);
            ((RequestBuilder) Glide.with(this.f12324b).load(msgTemplateData.rightIcon).centerCrop()).into(this.f12325c);
        }
        if (msgTemplateData.bgColor != null) {
            msgTemplateData.bgColor.bindView(this.f12326d, 0);
        }
        if (msgTemplateData.cardClick == null || TextUtils.isEmpty(msgTemplateData.cardClick.url)) {
            try {
                boolean isAccessibilityEnabled = isAccessibilityEnabled(this.f12324b);
                GLog.m7965d("isaccessibility", "issupport =" + isAccessibilityEnabled);
                if (isAccessibilityEnabled) {
                    this.f12323a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.f12323a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XpTemplateMsgView.this.m8354a("ibt_gp_tripservice_operationcard_ck", xpTemplateMsgModel);
                    DRouter.build(msgTemplateData.cardClick.url).start();
                }
            });
        }
    }

    public static boolean isAccessibilityEnabled(Context context) {
        if (context == null) {
            return false;
        }
        boolean isEnabled = ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
        boolean a = m8355a(context);
        if (!isEnabled || !a) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m8355a(Context context) {
        Intent intent = new Intent(f12321p);
        intent.addCategory(f12322q);
        boolean z = false;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                for (ResolveInfo next : queryIntentServices) {
                    z |= m8356a(context, next.serviceInfo.packageName + "/" + next.serviceInfo.name);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
                    arrayList.add(runningServiceInfo.service.getPackageName());
                }
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (arrayList.contains(resolveInfo.serviceInfo.packageName)) {
                        z |= true;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m8356a(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8354a(String str, XpTemplateMsgModel xpTemplateMsgModel) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.oid != null) {
            boolean isCancelOrder = BusinessDataUtil.isCancelOrder(CarOrderHelper.getOrder());
            HashMap hashMap = new HashMap();
            hashMap.put("id", xpTemplateMsgModel.f50198id);
            hashMap.put("order_status", Integer.valueOf(order.status));
            int i = 1;
            if (isCancelOrder && !BusinessDataUtil.isTripCanceledWithoutFee(CarOrderHelper.getOrder())) {
                i = 2;
            }
            hashMap.put("fault_type", Integer.valueOf(i));
            hashMap.put("type", Integer.valueOf(order.orderType));
            hashMap.put(ParamConst.PARAM_PAY_TYPE, Integer.valueOf(order.payType));
            hashMap.put("g_PageId", Integer.valueOf(this.f12337o));
            try {
                if (!(xpTemplateMsgModel.extension == null || xpTemplateMsgModel.extension.log_data == null)) {
                    String jSONObject = xpTemplateMsgModel.extension.log_data.toString();
                    HashMap hashMap2 = new HashMap();
                    hashMap.putAll((Map) new Gson().fromJson((JsonElement) new JsonParser().parse(jSONObject).getAsJsonObject(), hashMap2.getClass()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }

    public View getView() {
        return this.f12323a;
    }
}
