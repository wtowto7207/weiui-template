package cc.weiui.framework.extend.integration.glide.load.engine;

import cc.weiui.framework.extend.integration.glide.load.Key;
import cc.weiui.framework.extend.integration.glide.load.Options;
import cc.weiui.framework.extend.integration.glide.load.Transformation;
import java.util.Map;

class EngineKeyFactory {

  @SuppressWarnings("rawtypes")
  EngineKey buildKey(Object model, Key signature, int width, int height,
      Map<Class<?>, Transformation<?>> transformations, Class<?> resourceClass,
      Class<?> transcodeClass, Options options) {
    return new EngineKey(model, signature, width, height, transformations, resourceClass,
        transcodeClass, options);
  }
}
