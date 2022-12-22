package com.didi.unifylogin.utils.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryListActivity;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class CountrySwitchView extends RelativeLayout {

    /* renamed from: a */
    private TextView f44983a;

    /* renamed from: b */
    private TextView f44984b;

    /* renamed from: c */
    private ImageView f44985c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f44986d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f44987e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Activity f44988f;

    public CountrySwitchView(Context context) {
        super(context);
        m32244a(context);
    }

    public CountrySwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32244a(context);
    }

    public CountrySwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32244a(context);
    }

    /* renamed from: a */
    private void m32244a(final Context context) {
        if (context instanceof Activity) {
            this.f44988f = (Activity) context;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.login_unify_view_country_switch, this);
        this.f44983a = (TextView) inflate.findViewById(R.id.tv_switch_country_code);
        DIDIFontUtils.Companion.setTypeface(getContext(), this.f44983a);
        this.f44984b = (TextView) inflate.findViewById(R.id.tv_code);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_country_flag);
        this.f44985c = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.login_unify_color_country_placeholder));
        CountryManager.getIns().setContext(context.getApplicationContext());
        setCountry(CountryManager.getIns().getDefCountry());
        this.f44983a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.COUNTRY_CK).send();
                Intent intent = new Intent(context, CountryListActivity.class);
                if (CountrySwitchView.this.f44988f == null || !CountrySwitchView.this.f44986d) {
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                intent.putExtra(CountryListActivity.SEND_RESULT_2_CALLER, true);
                CountrySwitchView.this.f44988f.startActivityForResult(intent, CountrySwitchView.this.f44987e);
            }
        });
        if (LoginPreferredConfig.isCanSwitchCountry()) {
            this.f44983a.setVisibility(0);
        } else {
            this.f44984b.setVisibility(0);
        }
    }

    public void setCountry(CountryListResponse.CountryRule countryRule) {
        Glide.with(getContext()).load(countryRule.getNationalFlagUrl()).into(this.f44985c);
        this.f44984b.setText(countryRule.calling_code);
        this.f44983a.setText(countryRule.calling_code);
    }

    public void forbidSwitch() {
        this.f44984b.setVisibility(0);
        this.f44983a.setVisibility(4);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!this.f44986d) {
            this.f44983a.setText(CountryManager.getIns().getDefCountry().calling_code);
            this.f44984b.setText(CountryManager.getIns().getDefCountry().calling_code);
            Glide.with(getContext()).load(CountryManager.getIns().getDefCountry().getNationalFlagUrl()).into(this.f44985c);
        }
    }

    public void setSendResult2Caller(boolean z, int i) {
        this.f44986d = z;
        this.f44987e = i;
    }
}
