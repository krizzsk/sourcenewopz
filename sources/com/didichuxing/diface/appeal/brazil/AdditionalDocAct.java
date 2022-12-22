package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class AdditionalDocAct extends DFBaseAct {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RadioGroup f47004a;

    /* renamed from: b */
    private Button f47005b;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_additional_doc_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AdditionalDocAct.class));
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f47004a = (RadioGroup) findViewById(R.id.radio_group);
        this.f47005b = (Button) findViewById(R.id.next_btn);
        String string = getString(R.string.df_appeal_additional_doc_option1);
        AdditionalDocFragment.changeTextStyle((RadioButton) this.f47004a.findViewById(R.id.option1), string, string.indexOf(10) + 1);
        this.f47005b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BusUtils.post(new AdditionalDocSelectDoneEvent((String) ((RadioButton) AdditionalDocAct.this.f47004a.findViewById(AdditionalDocAct.this.f47004a.getCheckedRadioButtonId())).getTag()));
            }
        });
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }
}
