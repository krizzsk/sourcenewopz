package com.didi.component.comp_selectseat.ticket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class TicketActivity extends AppCompatActivity {
    public static Intent getIntent(Context context, String str) {
        Intent intent = new Intent(context, TicketActivity.class);
        intent.putExtra("detail_data", str);
        intent.setFlags(268435456);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ticket);
        m8485a();
    }

    /* renamed from: a */
    private void m8485a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ticket_fragment_container, TicketFragment.newInstance(getIntent().getStringExtra("detail_data"))).commit();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
