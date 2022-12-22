package com.didi.drouter.router;

import android.app.Activity;
import android.content.Intent;

public class RouterHelper {
    public static Request getRequest(Activity activity) {
        Intent intent = activity.getIntent();
        return getRequest(intent != null ? intent.getStringExtra("DRouter_start_activity_request_number") : null);
    }

    public static Result getResult(Activity activity) {
        Request request = getRequest(activity);
        if (request != null) {
            return getResult(request.getNumber());
        }
        return null;
    }

    public static Request getRequest(String str) {
        return C7943c.m14367a(str);
    }

    public static Result getResult(String str) {
        return C7943c.m14375c(str);
    }

    public static void release(Activity activity) {
        C7943c.m14370a(getRequest(activity), "complete");
    }

    public static void release(Request request) {
        C7943c.m14370a(request, "complete");
    }

    public static Request getPrimaryRequest(Result result) {
        return result.f19188a.f19210k;
    }
}
