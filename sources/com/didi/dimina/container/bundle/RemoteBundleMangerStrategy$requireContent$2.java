package com.didi.dimina.container.bundle;

import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: RemoteBundleMangerStrategy.kt */
final class RemoteBundleMangerStrategy$requireContent$2 implements Runnable {
    final /* synthetic */ BundleManagerStrategy.ReadFileCallBack $callback;
    final /* synthetic */ String $url;

    RemoteBundleMangerStrategy$requireContent$2(String str, BundleManagerStrategy.ReadFileCallBack readFileCallBack) {
        this.$url = str;
        this.$callback = readFileCallBack;
    }

    public final void run() {
        HttpUtil.downloadString(this.$url, new IDMCommonAction<String>(this) {
            final /* synthetic */ RemoteBundleMangerStrategy$requireContent$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void callback(final String str) {
                UIHandlerUtil.post(new Runnable(this) {
                    final /* synthetic */ C74451 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        if (!TextUtil.isEmpty(str)) {
                            BundleManagerStrategy.ReadFileCallBack readFileCallBack = this.this$0.this$0.$callback;
                            if (readFileCallBack != null) {
                                readFileCallBack.onRead(true, new BundleManagerStrategy.FileInfo(str, this.this$0.this$0.$url));
                                return;
                            }
                            return;
                        }
                        BundleManagerStrategy.ReadFileCallBack readFileCallBack2 = this.this$0.this$0.$callback;
                        if (readFileCallBack2 != null) {
                            readFileCallBack2.onRead(false, new BundleManagerStrategy.FileInfo((String) null, (String) null, 3, (DefaultConstructorMarker) null));
                        }
                    }
                });
            }
        });
    }
}
