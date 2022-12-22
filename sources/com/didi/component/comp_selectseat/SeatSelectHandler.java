package com.didi.component.comp_selectseat;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.comp_selectseat.activity.SeatSelectActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.taxis99.R;

public class SeatSelectHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Activity currentActivity;
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("style");
        String queryParameter2 = uri.getQueryParameter("unique_id");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter) && !TextUtils.isEmpty(queryParameter2) && (currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity()) != null) {
            currentActivity.startActivity(SeatSelectActivity.getIntent(request.getContext(), queryParameter2));
            currentActivity.overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
            FormStore.getInstance().setIsInMiniBus(true);
        }
    }
}
