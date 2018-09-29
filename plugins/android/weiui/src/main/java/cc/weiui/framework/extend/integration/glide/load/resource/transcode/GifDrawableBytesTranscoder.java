package cc.weiui.framework.extend.integration.glide.load.resource.transcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import cc.weiui.framework.extend.integration.glide.load.Options;
import cc.weiui.framework.extend.integration.glide.load.engine.Resource;
import cc.weiui.framework.extend.integration.glide.load.resource.bytes.BytesResource;
import cc.weiui.framework.extend.integration.glide.load.resource.gif.GifDrawable;
import cc.weiui.framework.extend.integration.glide.util.ByteBufferUtil;
import java.nio.ByteBuffer;

/**
 * An {@link cc.weiui.framework.extend.integration.glide.load.resource.transcode.ResourceTranscoder} that converts {@link
 * cc.weiui.framework.extend.integration.glide.load.resource.gif.GifDrawable} into bytes by obtaining the original bytes of
 * the GIF from the {@link cc.weiui.framework.extend.integration.glide.load.resource.gif.GifDrawable}.
 */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
  @Nullable
  @Override
  public Resource<byte[]> transcode(@NonNull Resource<GifDrawable> toTranscode,
      @NonNull Options options) {
    GifDrawable gifData = toTranscode.get();
    ByteBuffer byteBuffer = gifData.getBuffer();
    return new BytesResource(ByteBufferUtil.toBytes(byteBuffer));
  }
}
