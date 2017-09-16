package com.sanda.chrome;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cdc89 on 06.02.2017.
 */
public class StreamTest {
    @Test
    public void test1(){
        Arrays.stream(new int[] {1, 2, 3})
.map(n -> 2 * n + 1).forEach(System.out::println);

    }
}
