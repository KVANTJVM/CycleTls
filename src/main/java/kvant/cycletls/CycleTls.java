package kvant.cycletls;

import kvant.cycletls.connection.AsyncTlsChannel;
import kvant.cycletls.connection.TlsChannel;
import kvant.cycletls.utils.OS;

import java.io.IOException;
import java.nio.file.Path;

public final class CycleTls {
    private CycleTls() {}

    public static Process launch(Path path) throws IOException {
        StringBuilder buffer = new StringBuilder();

        switch (OS.current()) {
            case MAC:
                buffer.append("open -n").append(path.toString());
                break;
            case WINDOWS:
                buffer.append("start").append(path.toString());
                break;
            case LINUX:
                buffer.append(path.toString());
                break;
        }

        return Runtime.getRuntime().exec(buffer.toString());
    }

    public static AsyncTlsChannel createAsyncChannel() {
        return new AsyncTlsChannel();
    }

    public static TlsChannel createChannel() {
        return new TlsChannel();
    }
}
