package com.bn.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XXXUtilsTest {
    @Test
    void testReverseString() {
        String str = "hello world";
        assertEquals("dlrow olleh", XXXUtils.reverse(str));
    }
}
