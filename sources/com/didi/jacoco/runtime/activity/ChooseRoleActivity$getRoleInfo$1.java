package com.didi.jacoco.runtime.activity;

import androidx.core.app.NotificationCompat;
import com.didi.jacoco.runtime.module.role.Data;
import com.didi.jacoco.runtime.module.role.QaRdInfo;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/jacoco/runtime/activity/ChooseRoleActivity$getRoleInfo$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
public final class ChooseRoleActivity$getRoleInfo$1 implements Callback {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ ChooseRoleActivity this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2225490925192500835L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$getRoleInfo$1", 21);
        $jacocoData = probes;
        return probes;
    }

    ChooseRoleActivity$getRoleInfo$1(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = chooseRoleActivity;
        $jacocoInit[20] = true;
    }

    public void onFailure(Call call, IOException iOException) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        $jacocoInit[0] = true;
        SystemUtils.log(4, ChooseRoleActivity.access$getTAG$p(this.this$0), String.valueOf(iOException.getMessage()), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity$getRoleInfo$1", 149);
        $jacocoInit[1] = true;
    }

    public void onResponse(Call call, Response response) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        $jacocoInit[2] = true;
        ResponseBody body = response.body();
        if (body != null) {
            $jacocoInit[3] = true;
        } else {
            Intrinsics.throwNpe();
            $jacocoInit[4] = true;
        }
        String string = body.string();
        $jacocoInit[5] = true;
        String str = "";
        if (response.isSuccessful()) {
            $jacocoInit[6] = true;
            String access$getTAG$p = ChooseRoleActivity.access$getTAG$p(this.this$0);
            StringBuilder sb = new StringBuilder();
            sb.append("onSuccess ");
            if (string != null) {
                $jacocoInit[7] = true;
                str = string;
            } else {
                $jacocoInit[8] = true;
            }
            sb.append(str);
            SystemUtils.log(4, access$getTAG$p, sb.toString(), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity$getRoleInfo$1", 156);
            $jacocoInit[9] = true;
            QaRdInfo qaRdInfo = (QaRdInfo) new Gson().fromJson(string, QaRdInfo.class);
            $jacocoInit[10] = true;
            if (qaRdInfo.getErrno() == 0) {
                $jacocoInit[11] = true;
                ChooseRoleActivity.access$setNames$p(this.this$0, new ArrayList(qaRdInfo.getData()));
                $jacocoInit[12] = true;
                ArrayList access$getNames$p = ChooseRoleActivity.access$getNames$p(this.this$0);
                String string2 = this.this$0.getResources().getString(R.string.name);
                Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.string.name)");
                access$getNames$p.add(0, new Data("-1", string2));
                $jacocoInit[13] = true;
                this.this$0.runOnUiThread(new ChooseRoleActivity$getRoleInfo$1$onResponse$1(this));
                $jacocoInit[14] = true;
            } else {
                String access$getTAG$p2 = ChooseRoleActivity.access$getTAG$p(this.this$0);
                SystemUtils.log(4, access$getTAG$p2, "error code = " + qaRdInfo.getErrno(), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity$getRoleInfo$1", 167);
                $jacocoInit[15] = true;
            }
        } else {
            String access$getTAG$p3 = ChooseRoleActivity.access$getTAG$p(this.this$0);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onFailure ");
            if (string != null) {
                $jacocoInit[16] = true;
            } else {
                $jacocoInit[17] = true;
                string = str;
            }
            sb2.append(string);
            SystemUtils.log(4, access$getTAG$p3, sb2.toString(), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity$getRoleInfo$1", 170);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }
}
