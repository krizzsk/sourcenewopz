package atd.p042q0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import atd.p015d.C0976a;
import atd.p040p0.C1127a;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.p059ui.widget.ToolbarView;
import com.taxis99.R;

/* renamed from: atd.q0.a */
public abstract class C1134a<C extends C0976a, L extends C1127a> extends LinearLayout implements ToolbarView.C1427a {

    /* renamed from: a */
    private L f340a;

    C1134a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LinearLayout.inflate(context, R.layout.a3ds2_view_challenge_container, this);
        LinearLayout.inflate(context, getChallengeContainerLayoutId(), (ViewGroup) findViewById(R.id.scrollView_content));
        ((ToolbarView) findViewById(R.id.toolbarView)).setToolbarListener(this);
    }

    /* renamed from: a */
    public void mo13873a() {
        L l = this.f340a;
        if (l != null) {
            l.mo13858a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getChallengeContainerLayoutId();

    public L getChallengeListener() {
        if (this.f340a == null) {
            C1172a.m764a(-726442631842478L);
            C1127a.class.getName();
            C1172a.m764a(-726502761384622L);
        }
        return this.f340a;
    }

    public void setChallengeListener(L l) {
        this.f340a = l;
    }
}
