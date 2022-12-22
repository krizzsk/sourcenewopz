package com.didi.payment.base.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.finResource.FinResourceRequest;
import com.didi.payment.base.tracker.FinResOmegaUtils;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/base/view/activity/FinTechResourcesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "finRequest", "Lcom/didi/payment/base/finResource/FinResourceRequest;", "getFinRequest", "()Lcom/didi/payment/base/finResource/FinResourceRequest;", "finRequest$delegate", "Lkotlin/Lazy;", "imageView", "Landroid/widget/ImageView;", "rootView", "Landroid/view/ViewGroup;", "onClkClose", "", "resourceId", "", "planId", "activityId", "omegaMap", "", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinTechResourcesActivity.kt */
public final class FinTechResourcesActivity extends AppCompatActivity {

    /* renamed from: a */
    private ImageView f30038a;

    /* renamed from: b */
    private ViewGroup f30039b;

    /* renamed from: c */
    private final Lazy f30040c = LazyKt.lazy(new FinTechResourcesActivity$finRequest$2(this));

    /* renamed from: a */
    private final FinResourceRequest m21030a() {
        return (FinResourceRequest) this.f30040c.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fintech_resources);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "this.window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "win.attributes");
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        View findViewById = findViewById(R.id.source_image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.source_image_view)");
        this.f30038a = (ImageView) findViewById;
        String stringExtra = getIntent().getStringExtra(InvitationPageActivity.RESOURCE_ID);
        String stringExtra2 = getIntent().getStringExtra("planId");
        getIntent().getStringExtra("resourceType");
        String stringExtra3 = getIntent().getStringExtra("activityId");
        getIntent().getStringExtra("title");
        String stringExtra4 = getIntent().getStringExtra("link");
        String stringExtra5 = getIntent().getStringExtra("image");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("activity_id", stringExtra3);
        linkedHashMap.put("resource_id", stringExtra);
        linkedHashMap.put("plan_id", stringExtra2);
        linkedHashMap.put("pub_page", "wallethome");
        new FinResOmegaUtils("fin_general_popup_sw").addParam("action_type", "resource_sw").addParamAll(linkedHashMap).send();
        Context context = this;
        ImageView imageView = this.f30038a;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        GlideUtils.with2load2into(context, stringExtra5, imageView);
        ImageView imageView3 = this.f30038a;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener(stringExtra4, linkedHashMap, this) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ Map f$1;
            public final /* synthetic */ FinTechResourcesActivity f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                FinTechResourcesActivity.m21033a(this.f$0, this.f$1, this.f$2, view);
            }
        });
        String str = stringExtra;
        String str2 = stringExtra2;
        String str3 = stringExtra3;
        Map map = linkedHashMap;
        ((ImageView) findViewById(R.id.btn_close)).setOnClickListener(new View.OnClickListener(str, str2, str3, map) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ Map f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onClick(View view) {
                FinTechResourcesActivity.m21031a(FinTechResourcesActivity.this, this.f$1, this.f$2, this.f$3, this.f$4, view);
            }
        });
        ((ConstraintLayout) findViewById(R.id.root_view)).setOnClickListener(new View.OnClickListener(str, str2, str3, map) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ Map f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onClick(View view) {
                FinTechResourcesActivity.m21034b(FinTechResourcesActivity.this, this.f$1, this.f$2, this.f$3, this.f$4, view);
            }
        });
        FinResourceRequest.notifyRecord$default(m21030a(), stringExtra, stringExtra2, stringExtra3, (String) null, new FinTechResourcesActivity$onCreate$4(), 8, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21033a(String str, Map map, FinTechResourcesActivity finTechResourcesActivity, View view) {
        Intrinsics.checkNotNullParameter(map, "$omegaMap");
        Intrinsics.checkNotNullParameter(finTechResourcesActivity, "this$0");
        if (str != null) {
            new FinResOmegaUtils("fin_general_popupenter_ck").addParam("action_type", "resource_ck").addParamAll(map).send();
            DRouter.build(str).start(finTechResourcesActivity);
            finTechResourcesActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21031a(FinTechResourcesActivity finTechResourcesActivity, String str, String str2, String str3, Map map, View view) {
        Intrinsics.checkNotNullParameter(finTechResourcesActivity, "this$0");
        Intrinsics.checkNotNullParameter(map, "$omegaMap");
        finTechResourcesActivity.m21032a(str, str2, str3, (Map<String, Object>) map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21034b(FinTechResourcesActivity finTechResourcesActivity, String str, String str2, String str3, Map map, View view) {
        Intrinsics.checkNotNullParameter(finTechResourcesActivity, "this$0");
        Intrinsics.checkNotNullParameter(map, "$omegaMap");
        finTechResourcesActivity.m21032a(str, str2, str3, (Map<String, Object>) map);
    }

    /* renamed from: a */
    private final void m21032a(String str, String str2, String str3, Map<String, Object> map) {
        m21030a().notifyRecord(str, str2, str3, "close", new FinTechResourcesActivity$onClkClose$1());
        new FinResOmegaUtils("fin_general_popupclose_ck").addParamAll(map).send();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
