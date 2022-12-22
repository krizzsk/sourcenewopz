package com.didi.jacoco.runtime.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.didi.jacoco.runtime.JacocoRuntime;
import com.didi.jacoco.runtime.adapter.NameAdapter;
import com.didi.jacoco.runtime.module.role.Data;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006/"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/activity/ChooseRoleActivity;", "Landroid/app/Activity;", "()V", "TAG", "", "auto", "", "btnSubmit", "Landroid/widget/Button;", "getBtnSubmit", "()Landroid/widget/Button;", "setBtnSubmit", "(Landroid/widget/Button;)V", "nameAdapter", "Lcom/didi/jacoco/runtime/adapter/NameAdapter;", "names", "Ljava/util/ArrayList;", "Lcom/didi/jacoco/runtime/module/role/Data;", "Lkotlin/collections/ArrayList;", "okHttpClient", "Lokhttp3/OkHttpClient;", "roleData", "spName", "Landroid/widget/Spinner;", "getSpName", "()Landroid/widget/Spinner;", "setSpName", "(Landroid/widget/Spinner;)V", "spRole", "getSpRole", "setSpRole", "txtOldData", "Landroid/widget/TextView;", "getTxtOldData", "()Landroid/widget/TextView;", "setTxtOldData", "(Landroid/widget/TextView;)V", "userListUrl", "getRoleInfo", "", "appId", "role", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
public final class ChooseRoleActivity extends Activity {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String TAG = "ChooseRoleActivity";
    private boolean auto;
    public Button btnSubmit;
    private NameAdapter nameAdapter;
    private ArrayList<Data> names;
    private final OkHttpClient okHttpClient;
    private Data roleData;
    public Spinner spName;
    public Spinner spRole;
    public TextView txtOldData;
    private final String userListUrl = "/quality/user/list";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7522529995899853003L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity", 93);
        $jacocoData = probes;
        return probes;
    }

    public ChooseRoleActivity() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[72] = true;
        $jacocoInit[73] = true;
        this.names = new ArrayList<>();
        $jacocoInit[74] = true;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        $jacocoInit[75] = true;
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        $jacocoInit[76] = true;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        $jacocoInit[77] = true;
        OkHttpClient.Builder addInterceptor = builder.addInterceptor(httpLoggingInterceptor);
        $jacocoInit[78] = true;
        OkHttpClient build = addInterceptor.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OkHttpClient.Builder()\n …tor)\n            .build()");
        this.okHttpClient = build;
        $jacocoInit[79] = true;
    }

    public static final /* synthetic */ boolean access$getAuto$p(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = chooseRoleActivity.auto;
        $jacocoInit[90] = true;
        return z;
    }

    public static final /* synthetic */ NameAdapter access$getNameAdapter$p(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        NameAdapter nameAdapter2 = chooseRoleActivity.nameAdapter;
        $jacocoInit[86] = true;
        return nameAdapter2;
    }

    public static final /* synthetic */ ArrayList access$getNames$p(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Data> arrayList = chooseRoleActivity.names;
        $jacocoInit[84] = true;
        return arrayList;
    }

    public static final /* synthetic */ Data access$getRoleData$li(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = chooseRoleActivity.roleData;
        $jacocoInit[88] = true;
        return data;
    }

    public static final /* synthetic */ Data access$getRoleData$p(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = chooseRoleActivity.roleData;
        if (data != null) {
            $jacocoInit[80] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("roleData");
            $jacocoInit[81] = true;
        }
        $jacocoInit[82] = true;
        return data;
    }

    public static final /* synthetic */ String access$getTAG$p(ChooseRoleActivity chooseRoleActivity) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = chooseRoleActivity.TAG;
        $jacocoInit[92] = true;
        return str;
    }

    public static final /* synthetic */ void access$setAuto$p(ChooseRoleActivity chooseRoleActivity, boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        chooseRoleActivity.auto = z;
        $jacocoInit[91] = true;
    }

    public static final /* synthetic */ void access$setNameAdapter$p(ChooseRoleActivity chooseRoleActivity, NameAdapter nameAdapter2) {
        boolean[] $jacocoInit = $jacocoInit();
        chooseRoleActivity.nameAdapter = nameAdapter2;
        $jacocoInit[87] = true;
    }

    public static final /* synthetic */ void access$setNames$p(ChooseRoleActivity chooseRoleActivity, ArrayList arrayList) {
        boolean[] $jacocoInit = $jacocoInit();
        chooseRoleActivity.names = arrayList;
        $jacocoInit[85] = true;
    }

    public static final /* synthetic */ void access$setRoleData$li(ChooseRoleActivity chooseRoleActivity, Data data) {
        boolean[] $jacocoInit = $jacocoInit();
        chooseRoleActivity.roleData = data;
        $jacocoInit[89] = true;
    }

    public static final /* synthetic */ void access$setRoleData$p(ChooseRoleActivity chooseRoleActivity, Data data) {
        boolean[] $jacocoInit = $jacocoInit();
        chooseRoleActivity.roleData = data;
        $jacocoInit[83] = true;
    }

    public final Spinner getSpRole() {
        boolean[] $jacocoInit = $jacocoInit();
        Spinner spinner = this.spRole;
        if (spinner != null) {
            $jacocoInit[0] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("spRole");
            $jacocoInit[1] = true;
        }
        $jacocoInit[2] = true;
        return spinner;
    }

    public final void setSpRole(Spinner spinner) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.spRole = spinner;
        $jacocoInit[3] = true;
    }

    public final Spinner getSpName() {
        boolean[] $jacocoInit = $jacocoInit();
        Spinner spinner = this.spName;
        if (spinner != null) {
            $jacocoInit[4] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("spName");
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return spinner;
    }

    public final void setSpName(Spinner spinner) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.spName = spinner;
        $jacocoInit[7] = true;
    }

    public final Button getBtnSubmit() {
        boolean[] $jacocoInit = $jacocoInit();
        Button button = this.btnSubmit;
        if (button != null) {
            $jacocoInit[8] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("btnSubmit");
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
        return button;
    }

    public final void setBtnSubmit(Button button) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.btnSubmit = button;
        $jacocoInit[11] = true;
    }

    public final TextView getTxtOldData() {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.txtOldData;
        if (textView != null) {
            $jacocoInit[12] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("txtOldData");
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return textView;
    }

    public final void setTxtOldData(TextView textView) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.txtOldData = textView;
        $jacocoInit[15] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(bundle);
        $jacocoInit[16] = true;
        setContentView(R.layout.activity_choose_roleinfo);
        $jacocoInit[17] = true;
        initData();
        $jacocoInit[18] = true;
        initView();
        $jacocoInit[19] = true;
    }

    private final void initData() {
        boolean[] $jacocoInit = $jacocoInit();
        JacocoRuntime.jacocoRuntime.callback = new ChooseRoleActivity$initData$1(this);
        $jacocoInit[20] = true;
        this.auto = getIntent().getBooleanExtra(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, false);
        $jacocoInit[21] = true;
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this, "data", 0);
        $jacocoInit[22] = true;
        String string = sharedPreferences.getString("id", (String) null);
        $jacocoInit[23] = true;
        String string2 = sharedPreferences.getString("name", (String) null);
        if (string == null) {
            $jacocoInit[24] = true;
        } else if (string2 == null) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            this.roleData = new Data(string, string2);
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }

    private final void initView() {
        boolean[] $jacocoInit = $jacocoInit();
        View findViewById = findViewById(R.id.txt_old_data);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.txt_old_data)");
        this.txtOldData = (TextView) findViewById;
        $jacocoInit[29] = true;
        if (this.roleData == null) {
            $jacocoInit[30] = true;
        } else {
            Data data = this.roleData;
            if (data != null) {
                $jacocoInit[31] = true;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("roleData");
                $jacocoInit[32] = true;
            }
            if (data == null) {
                $jacocoInit[33] = true;
            } else {
                $jacocoInit[34] = true;
                TextView textView = this.txtOldData;
                if (textView != null) {
                    $jacocoInit[35] = true;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("txtOldData");
                    $jacocoInit[36] = true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("\n 上次提交者姓名：");
                Data data2 = this.roleData;
                if (data2 != null) {
                    $jacocoInit[37] = true;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("roleData");
                    $jacocoInit[38] = true;
                }
                sb.append(data2.getName());
                textView.setText(sb.toString());
                $jacocoInit[39] = true;
            }
        }
        View findViewById2 = findViewById(R.id.sp_role);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.sp_role)");
        this.spRole = (Spinner) findViewById2;
        $jacocoInit[40] = true;
        View findViewById3 = findViewById(R.id.sp_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.sp_name)");
        this.spName = (Spinner) findViewById3;
        $jacocoInit[41] = true;
        View findViewById4 = findViewById(R.id.btn_submit);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.btn_submit)");
        this.btnSubmit = (Button) findViewById4;
        $jacocoInit[42] = true;
        this.nameAdapter = new NameAdapter(this, this.names);
        $jacocoInit[43] = true;
        Spinner spinner = this.spName;
        if (spinner != null) {
            $jacocoInit[44] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("spName");
            $jacocoInit[45] = true;
        }
        spinner.setAdapter(this.nameAdapter);
        $jacocoInit[46] = true;
        Spinner spinner2 = this.spName;
        if (spinner2 != null) {
            $jacocoInit[47] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("spName");
            $jacocoInit[48] = true;
        }
        spinner2.setOnItemSelectedListener(new ChooseRoleActivity$initView$2(this));
        $jacocoInit[49] = true;
        Spinner spinner3 = this.spRole;
        if (spinner3 != null) {
            $jacocoInit[50] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("spRole");
            $jacocoInit[51] = true;
        }
        spinner3.setOnItemSelectedListener(new ChooseRoleActivity$initView$3(this));
        $jacocoInit[52] = true;
        Button button = this.btnSubmit;
        if (button != null) {
            $jacocoInit[53] = true;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("btnSubmit");
            $jacocoInit[54] = true;
        }
        button.setOnClickListener(new ChooseRoleActivity$initView$4(this));
        $jacocoInit[55] = true;
    }

    public final void getRoleInfo(String str, String str2) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(str, "appId");
        Intrinsics.checkParameterIsNotNull(str2, "role");
        $jacocoInit[56] = true;
        String str3 = this.TAG;
        SystemUtils.log(4, str3, "appId = " + str, (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity", 136);
        $jacocoInit[57] = true;
        String str4 = this.TAG;
        SystemUtils.log(4, str4, "jenkinsInfo = " + JacocoRuntime.jacocoRuntime.coverageConfig.jenkinsInfo(), (Throwable) null, "com.didi.jacoco.runtime.activity.ChooseRoleActivity", 137);
        $jacocoInit[58] = true;
        FormBody.Builder builder = new FormBody.Builder();
        $jacocoInit[59] = true;
        builder.add("appId", str);
        $jacocoInit[60] = true;
        builder.add("role", str2);
        try {
            $jacocoInit[61] = true;
            $jacocoInit[62] = true;
            Request.Builder builder2 = new Request.Builder();
            $jacocoInit[63] = true;
            Request.Builder post = builder2.post(builder.build());
            $jacocoInit[64] = true;
            Request.Builder url = post.url(JacocoRuntime.jacocoRuntime.coverageConfig.url() + this.userListUrl);
            $jacocoInit[65] = true;
            Request build = url.build();
            $jacocoInit[66] = true;
            Call newCall = this.okHttpClient.newCall(build);
            $jacocoInit[67] = true;
            newCall.enqueue(new ChooseRoleActivity$getRoleInfo$1(this));
            $jacocoInit[68] = true;
        } catch (Exception e) {
            $jacocoInit[69] = true;
            e.printStackTrace();
            $jacocoInit[70] = true;
        }
        $jacocoInit[71] = true;
    }
}
