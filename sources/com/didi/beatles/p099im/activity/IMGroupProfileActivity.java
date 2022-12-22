package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.adapter.IMGroupProfileAdapter;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMModifyGroupForbidCallback;
import com.didi.beatles.p099im.module.IMSessionCallback;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.module.impl.IMGroupUserInfoCallback;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.IMSlideSwitch;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.activity.IMGroupProfileActivity */
public class IMGroupProfileActivity extends IMBaseActivity {

    /* renamed from: a */
    private static final String f8905a = "extra_sid";

    /* renamed from: b */
    private static final String f8906b = "extra_forbid";

    /* renamed from: c */
    private static final int f8907c = 5;

    /* renamed from: d */
    private RecyclerView f8908d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f8909e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMSlideSwitch f8910f;

    /* renamed from: g */
    private CommonTitleBar f8911g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IMGroupProfileAdapter f8912h;

    /* renamed from: i */
    private long f8913i;

    /* renamed from: j */
    private boolean f8914j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMSession f8915k;

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_group_profile);
        m5979a();
        m5985c();
        m5983b();
    }

    public static void startActivity(Context context, long j) {
        Intent intent = new Intent(context, IMGroupProfileActivity.class);
        intent.putExtra(f8905a, j);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m5979a() {
        this.f8913i = getIntent().getLongExtra(f8905a, 0);
    }

    /* renamed from: b */
    private void m5983b() {
        IMManager.getInstance().getSessionModel().getSessionFromLocal(this.f8913i, new IMSessionCallback() {
            public void onSessionOptionResult(List<IMSession> list, int i) {
            }

            public void onSessionStatusUpdate(List<IMSession> list) {
            }

            public void onSessionLoad(List<IMSession> list) {
                if (list != null && list.size() != 0) {
                    IMSession unused = IMGroupProfileActivity.this.f8915k = list.get(0);
                    IMGroupProfileActivity.this.f8909e.setText(IMGroupProfileActivity.this.f8915k.getSessionName());
                    IMGroupProfileActivity.this.f8910f.setState(IMGroupProfileActivity.this.f8915k.getIsForbid());
                }
            }
        });
        IMManager.getInstance().getUserModel().getUserInfo(this.f8913i, (IMGroupUserInfoCallback) new IMGroupUserInfoCallback() {
            public void onUserInfoLoaded(List<IMUser> list) {
                IMGroupProfileActivity.this.f8912h.updateData(list);
            }
        }, true);
    }

    /* renamed from: c */
    private void m5985c() {
        this.f8908d = (RecyclerView) findViewById(R.id.profile_recyclerview);
        this.f8910f = (IMSlideSwitch) findViewById(R.id.forbid_slide_switch);
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.group_title_bar);
        this.f8911g = commonTitleBar;
        commonTitleBar.setTitle(IMResource.getString(R.string.im_group_title));
        this.f8909e = (TextView) findViewById(R.id.im_group_name);
        this.f8910f.setSlideListener(new IMSlideSwitch.SlideListener() {
            public void open(boolean z) {
                if (z) {
                    IMGroupProfileActivity.this.m5981a(true);
                }
            }

            public void close(boolean z) {
                if (z) {
                    IMGroupProfileActivity.this.m5981a(false);
                }
            }
        });
        this.f8911g.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMGroupProfileActivity.this.finish();
            }
        });
        m5987d();
    }

    /* renamed from: d */
    private void m5987d() {
        IMGroupProfileAdapter iMGroupProfileAdapter = new IMGroupProfileAdapter();
        this.f8912h = iMGroupProfileAdapter;
        iMGroupProfileAdapter.setData((List<IMUser>) null, this);
        this.f8908d.setAdapter(this.f8912h);
        this.f8908d.setLayoutManager(new GridLayoutManager((Context) this, 5, 1, false));
        this.f8908d.setPadding((IMViewUtil.getWindowWidth(this) - (IMViewUtil.dp2px(this, 45.0f) * 5)) / 6, 0, 0, IMViewUtil.dp2px(this, 15.0f));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5981a(boolean z) {
        IMManager.getInstance().getSessionModel().modifyGroupForbidState(this.f8913i, z, new IMModifyGroupForbidCallback() {
            public void onFailed(String str) {
            }

            public void onSucceed() {
            }
        });
    }
}
