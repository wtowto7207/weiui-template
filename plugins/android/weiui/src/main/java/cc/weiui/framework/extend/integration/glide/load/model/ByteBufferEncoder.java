package cc.weiui.framework.extend.integration.glide.load.model;

import android.support.annotation.NonNull;
import android.util.Log;
import cc.weiui.framework.extend.integration.glide.load.Encoder;
import cc.weiui.framework.extend.integration.glide.load.Options;
import cc.weiui.framework.extend.integration.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Writes {@link ByteBuffer ByteBuffers} to {@link File Files}.
 */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
  private static final String TAG = "ByteBufferEncoder";

  @Override
  public boolean encode(@NonNull ByteBuffer data, @NonNull File file, @NonNull Options options) {
    boolean success = false;
    try {
      ByteBufferUtil.toFile(data, file);
      success = true;
    } catch (IOException e) {
      if (Log.isLoggable(TAG, Log.DEBUG)) {
        Log.d(TAG, "Failed to write data", e);
      }
    }
    return success;
  }
}
