package com.didi.dimina.container.p106ui.title;

import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.navigationbar.NavigationBarButtonParam;
import com.didi.dimina.container.bridge.navigationbar.NavigationBarButtonParams;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.TextUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.title.WebTitleBar */
public class WebTitleBar extends CommonTitleBar {

    /* renamed from: a */
    ArrayMap<String, View> f17848a = new ArrayMap<>();

    /* renamed from: b */
    private final int f17849b = 3;

    public WebTitleBar(Context context) {
        super(context);
    }

    public WebTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTitleBackgroundColor(int i) {
        this.mMiddleTv.setTextColor(i);
    }

    public void setTitleName(String str) {
        this.mMiddleTv.setText(str);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.mLeft1Bt.setOnClickListener(onClickListener);
    }

    public void setNavigationBarButton(NavigationBarButtonParams navigationBarButtonParams, CallbackFunction callbackFunction) {
        if (navigationBarButtonParams != null) {
            List<NavigationBarButtonParam> lefts = navigationBarButtonParams.getLefts();
            List<NavigationBarButtonParam> rights = navigationBarButtonParams.getRights();
            m13362a(lefts, this.leftTvs, callbackFunction);
            m13362a(rights, this.rightTvs, callbackFunction);
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        CallBackUtil.onFail("params is empty", callbackFunction);
    }

    public void setNavigationBarClickListener(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        JSONArray optJSONArray = jSONObject.optJSONArray("clickIds");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            CallBackUtil.onFail("clickIds is empty", callbackFunction);
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            final String optString = optJSONArray.optString(i);
            if (this.f17848a.containsKey(optString)) {
                this.f17848a.get(optString).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "id", (Object) optString);
                        callbackFunction.onCallBack(jSONObject);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m13362a(List<NavigationBarButtonParam> list, ImageTextButton[] imageTextButtonArr, CallbackFunction callbackFunction) {
        int i = 0;
        while (i < list.size() && i < 3) {
            if (TextUtil.isEmpty(list.get(i).getId())) {
                CallBackUtil.onFail("params is empty", callbackFunction);
                return;
            }
            this.f17848a.put(list.get(i).getId(), imageTextButtonArr[i]);
            if (!TextUtil.isEmpty(list.get(i).getIconUrl())) {
                imageTextButtonArr[i].showImage(list.get(i).getIconUrl());
            } else if (!TextUtil.isEmpty(list.get(i).getText())) {
                imageTextButtonArr[i].showText(list.get(i).getText());
            }
            imageTextButtonArr[i].setVisibility(0);
            i++;
        }
    }
}
