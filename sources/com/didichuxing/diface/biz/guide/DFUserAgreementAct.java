package com.didichuxing.diface.biz.guide;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.data.PreGuideContent;
import com.taxis99.R;

public class DFUserAgreementAct extends DFBaseAct {
    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_user_agreement_layout;
    }

    public static void start(Context context, PreGuideContent preGuideContent) {
        Intent intent = new Intent(context, DFUserAgreementAct.class);
        intent.putExtra(GuideHelper.EXTRA_KEY_PRE_GUIDE_RESULT, preGuideContent);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        if (getIntent() != null && getIntent().getSerializableExtra(GuideHelper.EXTRA_KEY_PRE_GUIDE_RESULT) != null) {
            PreGuideContent preGuideContent = (PreGuideContent) getIntent().getSerializableExtra(GuideHelper.EXTRA_KEY_PRE_GUIDE_RESULT);
            GuideHelper.setTextViewText((TextView) findViewById(R.id.user_agreement_title), preGuideContent.agreementTitle);
            GuideHelper.setTextViewText((TextView) findViewById(R.id.user_agreement_contents), preGuideContent.agreementContent);
        }
    }
}
