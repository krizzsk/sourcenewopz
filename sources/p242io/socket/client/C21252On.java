package p242io.socket.client;

import p242io.socket.emitter.Emitter;

/* renamed from: io.socket.client.On */
public class C21252On {

    /* renamed from: io.socket.client.On$Handle */
    public interface Handle {
        void destroy();
    }

    private C21252On() {
    }

    /* renamed from: on */
    public static Handle m41997on(final Emitter emitter, final String str, final Emitter.Listener listener) {
        emitter.mo175675on(str, listener);
        return new Handle() {
            public void destroy() {
                emitter.off(str, listener);
            }
        };
    }
}
