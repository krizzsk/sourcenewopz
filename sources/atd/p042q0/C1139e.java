package atd.p042q0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import atd.p015d.C0996n;
import atd.p040p0.C1129c;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: atd.q0.e */
public final class C1139e extends C1138d<C0996n, C1129c> implements View.OnClickListener {

    /* renamed from: m */
    private final Button f355m;

    /* renamed from: n */
    private final Button f356n;

    public C1139e(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13882b(C0996n nVar) {
        String p = nVar.mo13704p();
        if (p != null) {
            this.f355m.setTag(Uri.parse(p));
            this.f355m.setText(nVar.mo13703o());
            this.f355m.setOnClickListener(this);
        } else {
            this.f355m.setVisibility(8);
        }
        this.f356n.setText(nVar.mo13705q());
        this.f356n.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_out_of_band;
    }

    public String getWhitelistStatus() {
        return super.getWhitelistStatus();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        if (getChallengeListener() == null) {
            return;
        }
        if (view.equals(this.f356n)) {
            this.f356n.setEnabled(false);
            ((C1129c) getChallengeListener()).mo13864a(getWhitelistStatus());
        } else if (view.equals(this.f355m)) {
            this.f355m.setEnabled(false);
            ((C1129c) getChallengeListener()).mo13863a((Uri) this.f355m.getTag());
        }
    }

    public C1139e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    public void mo13889b(C0996n nVar) {
        String n = nVar.mo13702n();
        if (!TextUtils.isEmpty(n)) {
            setInfoTextOrHide(n);
            setInfoTextIndicatorVisibility(false);
        }
    }

    public C1139e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f355m = (Button) findViewById(R.id.button_app);
        this.f356n = (Button) findViewById(R.id.button_continue);
    }
}
