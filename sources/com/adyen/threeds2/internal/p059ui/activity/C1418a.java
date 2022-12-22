package com.adyen.threeds2.internal.p059ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import atd.p015d.C0976a;
import atd.p015d.C0983f;
import atd.p015d.C0996n;
import atd.p015d.C0998o;
import atd.p015d.C1002q;
import atd.p040p0.C1127a;
import atd.p042q0.C1134a;
import atd.p042q0.C1135b;
import atd.p042q0.C1137c;
import atd.p042q0.C1139e;
import atd.p042q0.C1140f;
import atd.p042q0.C1150g;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.taxis99.R;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.adyen.threeds2.internal.ui.activity.a */
final class C1418a {

    /* renamed from: e */
    private static boolean f1055e;

    /* renamed from: a */
    private final FragmentActivity f1056a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1127a f1057b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Queue<AnimatorSet> f1058c;

    /* renamed from: d */
    private final C1422c f1059d = C1422c.m1209a();

    /* renamed from: com.adyen.threeds2.internal.ui.activity.a$a */
    class C1419a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ View f1060a;

        /* renamed from: b */
        final /* synthetic */ View f1061b;

        C1419a(View view, View view2) {
            this.f1060a = view;
            this.f1061b = view2;
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeAllListeners();
            C1418a.this.m1192b(this.f1060a);
            C1418a.this.m1198h();
            if (C1418a.this.f1058c.isEmpty() && !(this.f1061b instanceof C1137c)) {
                C1418a.this.f1057b.mo13860c();
            }
        }
    }

    /* renamed from: com.adyen.threeds2.internal.ui.activity.a$b */
    static /* synthetic */ class C1420b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1063a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atd.e.b[] r0 = atd.p017e.C1013b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1063a = r0
                atd.e.b r1 = atd.p017e.C1013b.SINGLE_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1063a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.p017e.C1013b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1063a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.e.b r1 = atd.p017e.C1013b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1063a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.e.b r1 = atd.p017e.C1013b.OUT_OF_BAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1063a     // Catch:{ NoSuchFieldError -> 0x003e }
                atd.e.b r1 = atd.p017e.C1013b.HTML_UI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.p059ui.activity.C1418a.C1420b.<clinit>():void");
        }
    }

    static {
        C1172a.m764a(-726369617398446L);
    }

    C1418a(FragmentActivity fragmentActivity, C1127a aVar) {
        this.f1056a = fragmentActivity;
        this.f1057b = aVar;
        this.f1058c = new ArrayDeque();
    }

    /* renamed from: d */
    private ViewGroup m1195d() {
        return (ViewGroup) this.f1056a.findViewById(16908290);
    }

    /* renamed from: e */
    private View m1196e() {
        ViewGroup d = m1195d();
        int childCount = d.getChildCount();
        return d.getChildAt(childCount > 0 ? childCount - 1 : 0);
    }

    /* renamed from: g */
    static boolean m1197g() {
        return f1055e;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m1198h() {
        AnimatorSet peek;
        this.f1058c.poll();
        if (!this.f1058c.isEmpty() && (peek = this.f1058c.peek()) != null) {
            peek.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo14887f() {
        if (m1197g()) {
            m1189a(false);
            if (this.f1059d.isAdded()) {
                this.f1059d.dismiss();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo14888i() {
        if (!m1197g()) {
            m1189a(true);
            if (!this.f1059d.isAdded()) {
                this.f1059d.show(this.f1056a.getSupportFragmentManager(), C1172a.m764a(-726296602954414L));
            }
        }
    }

    /* renamed from: c */
    private void m1194c(View view) {
        View e = m1196e();
        if (e == null) {
            this.f1056a.setContentView(view);
            if (!(view instanceof C1137c)) {
                this.f1057b.mo13860c();
            }
        } else if (!e.equals(view)) {
            m1186a(e, view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo14885b(C0976a aVar) {
        mo14887f();
        int i = C1420b.f1063a[aVar.mo13625a().ordinal()];
        if (i == 1) {
            C1150g gVar = new C1150g(this.f1056a);
            m1194c((View) gVar);
            gVar.mo13881a((C1002q) aVar);
        } else if (i == 2 || i == 3) {
            C1140f fVar = new C1140f(this.f1056a);
            m1194c((View) fVar);
            fVar.mo13881a((C0998o) aVar);
        } else if (i == 4) {
            C1139e eVar = new C1139e(this.f1056a);
            m1194c((View) eVar);
            eVar.mo13881a((C0996n) aVar);
        } else if (i == 5) {
            C1135b bVar = new C1135b(this.f1056a);
            m1194c((View) bVar);
            bVar.mo13877a((C0983f) aVar);
        } else {
            throw C1225c.CHALLENGE_PRESENTATION_FAILURE.mo13982a();
        }
    }

    /* renamed from: a */
    private static void m1189a(boolean z) {
        f1055e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14884a(C0976a aVar) {
        C1134a c = mo14886c();
        if (c != null && !(c instanceof C1137c)) {
            int i = C1420b.f1063a[aVar.mo13625a().ordinal()];
            if (i == 4) {
                ((C1139e) c).mo13889b((C0996n) aVar);
            } else if (i == 5) {
                ((C1135b) c).mo13878b((C0983f) aVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C1134a mo14886c() {
        View b = m1190b();
        if (b instanceof C1134a) {
            return (C1134a) b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14883a() {
        while (!this.f1058c.isEmpty()) {
            AnimatorSet poll = this.f1058c.poll();
            if (poll != null) {
                poll.cancel();
                poll.removeAllListeners();
            }
        }
    }

    /* renamed from: a */
    private void m1186a(View view, View view2) {
        View findViewById = view.findViewById(R.id.scrollView_content);
        View findViewById2 = view2.findViewById(R.id.scrollView_content);
        findViewById2.setAlpha(0.0f);
        m1185a(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new C1419a(view, view2));
        m1184a(animatorSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1192b(View view) {
        m1195d().removeView(view);
    }

    /* renamed from: b */
    private View m1190b() {
        return m1195d().getChildAt(0);
    }

    /* renamed from: a */
    private void m1185a(View view) {
        ViewGroup d = m1195d();
        if (view instanceof C1137c) {
            d.addView(view, d.getChildCount());
        } else {
            d.addView(view, 0);
        }
    }

    /* renamed from: a */
    private void m1184a(AnimatorSet animatorSet) {
        if (this.f1058c.isEmpty()) {
            this.f1058c.add(animatorSet);
            animatorSet.start();
            return;
        }
        this.f1058c.add(animatorSet);
    }
}
