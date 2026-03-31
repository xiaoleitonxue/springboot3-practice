package org.example;

import org.junit.jupiter.api.Test;

public class UUIDTest {

    @Test
    public void testuuid() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(java.util.UUID.randomUUID().toString().replace("-", ""));
        }
    }
}
