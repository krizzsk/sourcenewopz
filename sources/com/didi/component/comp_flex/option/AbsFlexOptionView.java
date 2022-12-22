package com.didi.component.comp_flex.option;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.comp_flex.option.OperationPanelModel;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsFlexOptionView implements View.OnClickListener, IFlexOptionView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f12190a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f12191b;

    /* renamed from: c */
    private FlexOptionPresenter f12192c;

    /* renamed from: d */
    private View f12193d;

    /* renamed from: e */
    private View f12194e;

    /* renamed from: f */
    private PopupWindow f12195f;

    /* renamed from: g */
    private OperationPanelModel f12196g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12197h = true;

    public AbsFlexOptionView(Context context, ViewGroup viewGroup) {
        this.f12191b = context;
        this.f12193d = viewGroup;
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_option_layout, viewGroup, false);
        this.f12194e = inflate;
        inflate.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        showOptionPop();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8248a() {
        PopupWindow popupWindow = this.f12195f;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f12195f.dismiss();
            this.f12195f = null;
        }
    }

    public void onDestroy() {
        m8248a();
    }

    public void showOptionPop() {
        View inflate = LayoutInflater.from(this.f12191b).inflate(R.layout.flex_option_popup, (ViewGroup) null);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AbsFlexOptionView.this.m8248a();
            }
        });
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_container);
        OperationPanelModel operationPanelModel = this.f12196g;
        if (!(operationPanelModel == null || operationPanelModel.data == null || this.f12196g.data.items == null || this.f12196g.data.items.size() <= 0)) {
            for (final OperationPanelModel.ItemModel next : this.f12196g.data.items) {
                if (next.richBtn != null && !TextUtils.isEmpty(next.richBtn.getContent())) {
                    View inflate2 = LayoutInflater.from(this.f12191b).inflate(R.layout.flex_option_pop_item_layout, (ViewGroup) null);
                    next.richBtn.bindTextView((TextView) inflate2.findViewById(R.id.flex_option_tv));
                    inflate2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            AbsFlexOptionView.this.m8248a();
                            if (next.url != null && AbsFlexOptionView.this.f12197h) {
                                boolean unused = AbsFlexOptionView.this.f12197h = false;
                                try {
                                    GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_canceltrip_ck");
                                    ((Request) DRouter.build(next.url).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(AbsFlexOptionView.this.f12191b, new RouterCallback() {
                                        public void onResult(Result result) {
                                            JSONObject optJSONObject;
                                            JSONObject optJSONObject2;
                                            boolean unused = AbsFlexOptionView.this.f12197h = true;
                                            AbsFlexOptionView.this.f12190a.info("onResult: 取消订单  数据提交", new Object[0]);
                                            String string = result.getString("KEY_CALLBACK");
                                            if (!TextUtils.isEmpty(string)) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(string);
                                                    if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("extension") && (optJSONObject2 = optJSONObject.optJSONObject("extension")) != null && optJSONObject2.optInt("errno") != 0) {
                                                        LEGOToastHelper.showToast(AbsFlexOptionView.this.f12191b, optJSONObject2.optString("errmsg"));
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(next.iconUrl)) {
                        Glide.with(this.f12191b).load(next.iconUrl).into((ImageView) inflate2.findViewById(R.id.flex_option_close_img));
                    }
                    linearLayout.addView(inflate2);
                }
            }
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        this.f12195f = popupWindow;
        popupWindow.showAtLocation(this.f12193d, GravityCompat.END, 0, 0);
    }

    public void setVisibility(int i) {
        this.f12194e.setVisibility(i);
    }

    public void setOperationPanelModel(OperationPanelModel operationPanelModel) {
        this.f12196g = operationPanelModel;
    }

    public View getView() {
        return this.f12194e;
    }

    public void setPresenter(FlexOptionPresenter flexOptionPresenter) {
        this.f12192c = flexOptionPresenter;
    }
}
