package atd.p042q0;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import atd.p015d.C1002q;
import atd.p040p0.C1131e;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: atd.q0.g */
public final class C1150g extends C1138d<C1002q, C1131e> implements View.OnClickListener {

    /* renamed from: m */
    private final EditText f371m;

    /* renamed from: n */
    private final Button f372n;

    public C1150g(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13882b(C1002q qVar) {
        setInfoLabelFor(this.f371m.getId());
        this.f372n.setText(qVar.mo13697n());
        this.f372n.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_text;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        if (getChallengeListener() != null && view.equals(this.f372n)) {
            this.f372n.setEnabled(false);
            String obj = this.f371m.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                ((C1131e) getChallengeListener()).mo13859b();
            } else {
                ((C1131e) getChallengeListener()).mo13866a(obj, getWhitelistStatus());
            }
        }
    }

    public C1150g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1150g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f371m = (EditText) findViewById(R.id.editText_text);
        this.f372n = (Button) findViewById(R.id.button_continue);
    }
}
