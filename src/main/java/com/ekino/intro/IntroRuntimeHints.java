package com.ekino.intro;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class IntroRuntimeHints implements RuntimeHintsRegistrar {

  @Override
  public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
    // Register method for reflection
    Method method = ReflectionUtils.findMethod(IntroController.class, "privateMethod");
    hints.reflection().registerMethod(method, ExecutableMode.INVOKE);

    // Register resources
    hints.resources().registerPattern("my-resource.txt");

  }

}
