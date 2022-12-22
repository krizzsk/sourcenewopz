package atd.p042q0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import atd.p009a.C0948h;
import atd.p015d.C0985g;
import atd.p015d.C0992l;
import atd.p017e.C1013b;
import atd.p040p0.C1127a;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: atd.q0.d */
abstract class C1138d<C extends C0992l, L extends C1127a> extends C1134a<C, L> implements View.OnClickListener {

    /* renamed from: b */
    private final TextView f344b = ((TextView) findViewById(R.id.textView_infoHeader));

    /* renamed from: c */
    private final TextView f345c = ((TextView) findViewById(R.id.textView_infoText));

    /* renamed from: d */
    private final TextView f346d = ((TextView) findViewById(R.id.textView_infoLabel));

    /* renamed from: e */
    private final ImageView f347e = ((ImageView) findViewById(R.id.imageView_infoTextIndicator));

    /* renamed from: f */
    private final Button f348f = ((Button) findViewById(R.id.button_resend));

    /* renamed from: g */
    private final ExpandableInfoTextView f349g = ((ExpandableInfoTextView) findViewById(R.id.expandableInfoText_why));

    /* renamed from: h */
    private final ExpandableInfoTextView f350h = ((ExpandableInfoTextView) findViewById(R.id.expandableInfoText_explained));

    /* renamed from: i */
    private final View f351i = findViewById(R.id.dividerView_logos);

    /* renamed from: j */
    private final ImageView f352j = ((ImageView) findViewById(R.id.imageView_issuer));

    /* renamed from: k */
    private final ImageView f353k = ((ImageView) findViewById(R.id.imageView_scheme));

    /* renamed from: l */
    private final SwitchCompat f354l = ((SwitchCompat) findViewById(R.id.switch_whitelist));

    C1138d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LinearLayout.inflate(context, getChallengeLayoutId(), (ViewGroup) findViewById(R.id.linearLayout_challengeContainer));
    }

    private void setImagesOrHide(C c) {
        C0985g g = c.mo13686g();
        C0985g h = c.mo13687h();
        boolean z = true;
        if (g == null || h == null) {
            m675a(this.f351i, false);
            m675a((View) this.f352j, g != null);
            ImageView imageView = this.f353k;
            if (h == null) {
                z = false;
            }
            m675a((View) imageView, z);
        } else {
            m675a(this.f351i, true);
            m675a((View) this.f352j, true);
            m675a((View) this.f353k, true);
        }
        C0948h.f166d.mo13569a(this.f352j, g);
        C0948h.f166d.mo13569a(this.f353k, h);
    }

    private void setWhitelistOrHide(C c) {
        m675a((View) this.f354l, !TextUtils.isEmpty(c.mo13689j()));
        this.f354l.setText(c.mo13689j());
    }

    /* renamed from: a */
    public void mo13881a(C c) {
        m676a(this.f344b, (CharSequence) c.mo13681b());
        m676a(this.f345c, (CharSequence) c.mo13683d());
        m676a(this.f346d, (CharSequence) c.mo13682c());
        m675a((View) this.f347e, c.mo13692m());
        if (c.mo13625a() == C1013b.SINGLE_TEXT_INPUT) {
            m676a((TextView) this.f348f, (CharSequence) c.mo13688i());
        } else {
            this.f348f.setVisibility(8);
        }
        m677a(this.f349g, c.mo13690k(), c.mo13691l());
        m677a(this.f350h, c.mo13684e(), c.mo13685f());
        setImagesOrHide(c);
        setWhitelistOrHide(c);
        this.f348f.setOnClickListener(this);
        mo13882b(c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo13882b(C c);

    /* access modifiers changed from: protected */
    public int getChallengeContainerLayoutId() {
        return R.layout.a3ds2_view_challenge_native_container;
    }

    /* access modifiers changed from: protected */
    public abstract int getChallengeLayoutId();

    /* access modifiers changed from: protected */
    public String getWhitelistStatus() {
        if (this.f354l.getVisibility() != 0) {
            return null;
        }
        return C1172a.m764a(this.f354l.isChecked() ? -727456244124334L : -727464834058926L);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (getChallengeListener() != null && view.equals(this.f348f)) {
            this.f348f.setEnabled(false);
            getChallengeListener().mo13861d();
        }
    }

    /* access modifiers changed from: protected */
    public void setInfoLabelFor(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f346d.setLabelFor(i);
        }
    }

    /* access modifiers changed from: protected */
    public void setInfoTextIndicatorVisibility(boolean z) {
        m675a((View) this.f347e, z);
    }

    /* access modifiers changed from: protected */
    public void setInfoTextOrHide(CharSequence charSequence) {
        m676a(this.f345c, charSequence);
    }

    /* renamed from: a */
    private void m676a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    /* renamed from: a */
    private void m677a(ExpandableInfoTextView expandableInfoTextView, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            expandableInfoTextView.setVisibility(8);
            return;
        }
        expandableInfoTextView.setTitle(str);
        expandableInfoTextView.setInfo(str2);
    }

    /* renamed from: a */
    private void m675a(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
