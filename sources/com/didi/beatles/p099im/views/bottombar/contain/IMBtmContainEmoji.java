package com.didi.beatles.p099im.views.bottombar.contain;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.adapter.IMEmojiAdapter;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.utils.IMEmotionInputDetector;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.buttonView.IMSwitchView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainEmoji */
class IMBtmContainEmoji extends C4306a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Callback f10022c;

    /* renamed from: d */
    private RecyclerView f10023d;

    /* renamed from: e */
    private IMEmojiAdapter f10024e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainEmoji$Callback */
    interface Callback {
        void sendEmoji(String str, String str2, String str3);
    }

    IMBtmContainEmoji(View view) {
        super(view);
        m6803a(view);
    }

    /* renamed from: a */
    public void mo44075a(Callback callback) {
        this.f10022c = callback;
    }

    /* renamed from: a */
    public void mo44069a() {
        this.f10022c = null;
    }

    /* renamed from: a */
    private void m6803a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.emoji_recyclerview);
        this.f10023d = recyclerView;
        recyclerView.setVisibility(0);
        ((IMSwitchView) view.findViewById(R.id.im_bottombar_switch)).setVisibility(8);
        view.findViewById(R.id.bottom_list).setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44076a(List<IMEmojiModule> list) {
        IMEmojiAdapter iMEmojiAdapter = this.f10024e;
        if (iMEmojiAdapter != null) {
            iMEmojiAdapter.changeEmojiList(list);
        } else {
            m6804b(list);
        }
    }

    /* renamed from: b */
    private void m6804b(List<IMEmojiModule> list) {
        if (this.f10023d != null) {
            this.f10023d.setLayoutManager(new GridLayoutManager(this.f10058a, 4, 1, false));
            IMEmojiAdapter iMEmojiAdapter = new IMEmojiAdapter(this.f10058a, (IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f10058a, 50.0f)) / 2, list, new IMEmojiAdapter.IMEmojiViewOnClickListener() {
                public void onClick(String str, String str2, String str3) {
                    if (IMBtmContainEmoji.this.f10022c != null) {
                        IMBtmContainEmoji.this.f10022c.sendEmoji(str, str2, str3);
                    }
                }
            });
            this.f10024e = iMEmojiAdapter;
            this.f10023d.setAdapter(iMEmojiAdapter);
        }
    }
}
