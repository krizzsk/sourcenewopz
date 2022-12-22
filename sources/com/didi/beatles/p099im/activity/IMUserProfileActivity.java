package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.api.entity.IMNewstandResponse;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IMNewstandInfoCallback;
import com.didi.beatles.p099im.views.IMProfileHeaderView;
import com.didi.beatles.p099im.views.messageCard.IMOneMessageCard1;
import com.didi.beatles.p099im.views.messageCard.IMOneMessageCard2;
import com.didi.beatles.p099im.views.messageCard.IMOneMessageCard3;
import com.didi.beatles.p099im.views.titlebar.CommonTitleBar;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMUserProfileActivity */
public class IMUserProfileActivity extends IMBaseActivity {
    public static int ONE_MESSAGE_CARD_1 = 1;
    public static int ONE_MESSAGE_CARD_2 = 2;
    public static int ONE_MESSAGE_CARD_3 = 3;
    public static String USER_ID = "user_id";
    public static String USER_TITLE = "user_title";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonTitleBar f9026a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMProfileHeaderView f9027b;

    /* renamed from: c */
    private LinearLayout f9028c;

    /* renamed from: d */
    private TextView f9029d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMNewstandResponse.NewStandInfo f9030e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f9031f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f9032g;

    /* renamed from: h */
    private long f9033h;

    /* renamed from: i */
    private String f9034i;

    public static void startActivity(Context context, String str, long j) {
        Intent intent = new Intent(context, IMUserProfileActivity.class);
        intent.putExtra(USER_ID, j);
        intent.putExtra(USER_TITLE, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.im_user_profile_activity);
        m6139b();
        this.f9033h = getIntent().getLongExtra(USER_ID, 0);
        this.f9034i = getIntent().getStringExtra(USER_TITLE);
        m6136a();
    }

    /* renamed from: a */
    private void m6136a() {
        IMManager.getInstance().getNewstandInfo(this.f9033h, new IMNewstandInfoCallback() {
            public void onNewstandInfoLoaded(long j, IMNewstandResponse iMNewstandResponse) {
                if (iMNewstandResponse == null || iMNewstandResponse.Info == null) {
                    IMUserProfileActivity.this.f9031f.setVisibility(0);
                    IMUserProfileActivity.this.f9032g.setVisibility(8);
                    return;
                }
                IMNewstandResponse.NewStandInfo unused = IMUserProfileActivity.this.f9030e = iMNewstandResponse.Info;
                if (IMUserProfileActivity.this.f9030e.user != null && !TextUtils.isEmpty(IMUserProfileActivity.this.f9030e.user.user_name)) {
                    IMUserProfileActivity.this.f9026a.setTitle(IMUserProfileActivity.this.f9030e.user.user_name);
                }
                IMUserProfileActivity.this.f9027b.bindUserInfo(IMUserProfileActivity.this.f9030e);
                IMUserProfileActivity iMUserProfileActivity = IMUserProfileActivity.this;
                iMUserProfileActivity.m6137a(iMUserProfileActivity.f9030e);
            }
        });
    }

    /* renamed from: b */
    private void m6139b() {
        this.f9026a = (CommonTitleBar) findViewById(R.id.im_title_bar);
        if (!TextUtils.isEmpty(this.f9034i)) {
            this.f9026a.setTitle(this.f9034i);
        }
        this.f9026a.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMUserProfileActivity.this.finish();
            }
        });
        this.f9032g = findViewById(R.id.profile_content);
        this.f9031f = findViewById(R.id.im_empty_layout);
        this.f9027b = (IMProfileHeaderView) findViewById(R.id.profile_header);
        this.f9028c = (LinearLayout) findViewById(R.id.profile_history_contain);
        this.f9029d = (TextView) findViewById(R.id.aciton_title);
    }

    /* renamed from: c */
    private void m6142c() {
        this.f9028c.setVisibility(8);
        this.f9029d.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6137a(IMNewstandResponse.NewStandInfo newStandInfo) {
        if (newStandInfo == null) {
            m6142c();
            return;
        }
        IMNewstandResponse.NewStandHistory newStandHistory = newStandInfo.history;
        if (newStandHistory == null) {
            m6142c();
        } else if (newStandHistory.message.length > 0) {
            this.f9029d.setVisibility(0);
            for (int i = 0; i < newStandHistory.message.length; i++) {
                int i2 = newStandHistory.message[i].template;
                IMNewstandResponse.NewStandMessage newStandMessage = newStandHistory.message[i];
                if (i2 == ONE_MESSAGE_CARD_1) {
                    IMOneMessageCard1 iMOneMessageCard1 = new IMOneMessageCard1(this);
                    iMOneMessageCard1.bindViewData(newStandMessage, i);
                    this.f9028c.addView(iMOneMessageCard1);
                } else if (i2 == ONE_MESSAGE_CARD_2) {
                    IMOneMessageCard2 iMOneMessageCard2 = new IMOneMessageCard2(this);
                    iMOneMessageCard2.bindViewData(newStandMessage, i);
                    this.f9028c.addView(iMOneMessageCard2);
                } else if (i2 == ONE_MESSAGE_CARD_3) {
                    IMOneMessageCard3 iMOneMessageCard3 = new IMOneMessageCard3(this);
                    iMOneMessageCard3.bindViewData(newStandMessage, i);
                    this.f9028c.addView(iMOneMessageCard3);
                }
            }
        } else {
            m6142c();
        }
    }
}
