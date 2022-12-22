package com.didi.component.notalk.info;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.nightmode.sdk.NightModeManager;
import com.didichuxing.nightmode.sdk.NightModeState;
import com.taxis99.R;

public class NonTalkingMeetCardActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        m10481a();
    }

    /* renamed from: a */
    private void m10481a() {
        if (NightModeManager.getInstance(getApplicationContext()).getNightModeState() == NightModeState.DAY) {
            setContentView((int) R.layout.activity_non_talking_meet_card);
        } else {
            setContentView((int) R.layout.activity_non_talking_meet_card_night);
        }
        TextView textView = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        String stringExtra = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(stringExtra)) {
            textView.setText(stringExtra);
        }
        findViewById(R.id.common_title_bar_left_img).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NonTalkingMeetCardActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.tv_global_non_talking_iam)).setText(getApplicationContext().getString(R.string.Global_Rider_non_talking_meet_card_Hello_I_drRQ));
        ((TextView) findViewById(R.id.tv_global_non_talking_going)).setText(getApplicationContext().getString(R.string.Global_Rider_non_talking_meet_card_Go_and_sugz));
        TextView textView2 = (TextView) findViewById(R.id.tv_global_non_talking_name);
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(this);
        if (userInfo == null || TextUtils.isEmpty(userInfo.getFirst_name())) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(userInfo.getFirst_name());
        }
        TextView textView3 = (TextView) findViewById(R.id.tv_global_non_talking_dest);
        CarOrder order = CarOrderHelper.getOrder();
        if (!(order == null || order.endAddress == null)) {
            textView3.setText(order.endAddress.getDisplayName());
        }
        TextView textView4 = (TextView) findViewById(R.id.tv_global_non_talking_text);
        String stringExtra2 = getIntent().getStringExtra("text");
        if (!TextUtils.isEmpty(stringExtra2)) {
            textView4.setText(stringExtra2);
        }
    }
}
