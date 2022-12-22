package com.didi.aoe.library.api.interpreter;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import java.util.List;

public abstract class SingleInterpreterComponent<TInput, TOutput> implements AoeProcessor.InterpreterComponent<TInput, TOutput> {
    public abstract void init(Context context, AoeModelOption aoeModelOption, OnInterpreterInitListener onInterpreterInitListener);

    public final void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        if (list.size() != 1) {
            onInterpreterInitListener.onInitResult(InterpreterInitResult.create(-2));
        } else {
            init(context, list.get(0), onInterpreterInitListener);
        }
    }
}
