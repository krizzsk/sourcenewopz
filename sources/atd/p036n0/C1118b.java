package atd.p036n0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import atd.p046s0.C1172a;

/* renamed from: atd.n0.b */
public final class C1118b implements LayoutInflater.Factory2 {

    /* renamed from: c */
    private static final String[] f332c = {C1172a.m764a(-724990932896430L), C1172a.m764a(-725051062438574L), C1172a.m764a(-725119781915310L), C1172a.m764a(-725188501392046L)};

    /* renamed from: a */
    private final Window f333a;

    /* renamed from: b */
    private final C1116a f334b;

    public C1118b(Window window, C1116a aVar) {
        this.f333a = window;
        this.f334b = aVar;
        aVar.mo13845a(window);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        LayoutInflater layoutInflater = this.f333a.getLayoutInflater();
        View view2 = null;
        if (str.contains(C1172a.m764a(-724832019106478L))) {
            try {
                view2 = layoutInflater.createView(str, (String) null, attributeSet);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(C1172a.m764a(-724840609041070L) + str + C1172a.m764a(-724978047994542L), e);
            } catch (InflateException unused) {
            }
        } else {
            String[] strArr = f332c;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    view2 = layoutInflater.createView(str, strArr[i], attributeSet);
                    if (view2 != null) {
                        break;
                    }
                    i++;
                } catch (InflateException | ClassNotFoundException unused2) {
                }
            }
        }
        if (view2 != null) {
            this.f334b.mo13844a(view2, attributeSet);
        }
        return view2;
    }
}
