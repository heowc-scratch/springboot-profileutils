package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SpringProfileUtils implements EnvironmentPostProcessor {

    private static Set<String> activeProfiles;

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        activeProfiles = Arrays.stream(environment.getActiveProfiles())
                               .collect(Collectors.toUnmodifiableSet());
    }

    public static boolean isLocal() {
        return activeProfiles.contains("local");
    }

    public static boolean isDev() {
        return activeProfiles.contains("dev");
    }

    public static boolean isStage() {
        return activeProfiles.contains("stage");
    }

    public static boolean isProd() {
        return activeProfiles.contains("prod");
    }
}
