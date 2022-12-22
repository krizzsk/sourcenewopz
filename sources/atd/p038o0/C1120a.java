package atd.p038o0;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.adyen.threeds2.ProgressDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: atd.o0.a */
public final class C1120a implements DialogInterface.OnDismissListener, ProgressDialog {

    /* renamed from: a */
    private AlertDialog f335a;

    /* renamed from: b */
    private final DialogInterface.OnDismissListener f336b;

    public C1120a(Activity activity, DialogInterface.OnDismissListener onDismissListener) {
        this.f336b = onDismissListener;
        AlertDialog create = new AlertDialog.Builder(activity, 2132018098).setView(LayoutInflater.from(activity).inflate(R.layout.a3ds2_widget_progress_dialog, (ViewGroup) null)).setCancelable(false).create();
        this.f335a = create;
        create.setOnDismissListener(this);
    }

    public void hide() {
        AlertDialog alertDialog = this.f335a;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (IllegalStateException unused) {
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f335a = null;
        this.f336b.onDismiss(dialogInterface);
    }

    public void show() {
        AlertDialog alertDialog = this.f335a;
        if (alertDialog != null) {
            SystemUtils.showDialog(alertDialog);
        }
    }
}
