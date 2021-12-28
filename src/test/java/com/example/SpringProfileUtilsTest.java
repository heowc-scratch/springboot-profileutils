package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
class SpringProfileUtilsTest {

    @ActiveProfiles("local")
    @SpringBootTest
    static class Local {

        @Test
        void test() {
            assertThat(SpringProfileUtils.isLocal()).isTrue();
        }
    }

    @ActiveProfiles("dev")
    @SpringBootTest
    static class Dev {

        @Test
        void test() {
            assertThat(SpringProfileUtils.isDev()).isTrue();
        }
    }

    @ActiveProfiles("stage")
    @SpringBootTest
    static class Stage {

        @Test
        void test() {
            assertThat(SpringProfileUtils.isStage()).isTrue();
        }
    }

    @ActiveProfiles("prod")
    @SpringBootTest
    static class Prod {

        @Test
        void test() {
            assertThat(SpringProfileUtils.isProd()).isTrue();
        }
    }
}
