package com.didi.soda.home.topgun.component.topicact;

import android.content.Context;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
/* synthetic */ class TopicActivityPresenter$registerScopeActions$2 extends FunctionReferenceImpl implements Function4<Context, IBlockScope, HashMap<String, Object>, Buildable, ActionResult> {
    TopicActivityPresenter$registerScopeActions$2(Object obj) {
        super(4, obj, TopicActivityPresenter.class, "updateSceneTag", "updateSceneTag(Landroid/content/Context;Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/util/HashMap;Lcom/didi/soda/blocks/widget/Buildable;)Lcom/didi/soda/blocks/action/ActionResult;", 0);
    }

    public final ActionResult invoke(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Intrinsics.checkNotNullParameter(context, "p0");
        Intrinsics.checkNotNullParameter(iBlockScope, "p1");
        Intrinsics.checkNotNullParameter(buildable, "p3");
        return ((TopicActivityPresenter) this.receiver).m30380b(context, iBlockScope, hashMap, buildable);
    }
}
