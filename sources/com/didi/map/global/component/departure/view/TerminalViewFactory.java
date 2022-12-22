package com.didi.map.global.component.departure.view;

import android.content.Context;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;

public class TerminalViewFactory {
    public static ITerminalWelcomeView createTerminalWelcomeView(Context context, ITerminalWelcomeView.Callback callback) {
        TerminalWelcomeView terminalWelcomeView = new TerminalWelcomeView(context);
        terminalWelcomeView.setCallback(callback);
        return terminalWelcomeView;
    }

    public static ITerminalView createTerminalView(Context context, ITerminalView.Callback callback) {
        TerminalView terminalView = new TerminalView(context);
        terminalView.setCallback(callback);
        return terminalView;
    }
}
