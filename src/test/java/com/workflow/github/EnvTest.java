package com.workflow.github;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnvTest {

    @Test
    public void should_return_true_when_initialize_env() {
        Assertions.assertThat(true).isTrue();
    }

    @Test
    public void should_concatenate_two_strings() {
        String actual = "hello ".concat("world");
        String expected = "hello world";

        Assertions.assertThat(actual).isEqualTo(expected);
    }


}
