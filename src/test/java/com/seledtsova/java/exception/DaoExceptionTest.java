package com.seledtsova.java.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoExceptionTest {

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(DaoException.class, () ->
        {
            throw new DaoException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

}