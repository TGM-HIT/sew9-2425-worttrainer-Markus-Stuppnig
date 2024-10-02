package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WortpaarTest {

    @Test
    void testValidWortpaarCreation() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        assertEquals("https://www.example.com", wortpaar.getUrl());
        assertEquals("TestWort", wortpaar.getWort());
    }

    @Test
    void testInvalidUrlThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Wortpaar("invalid_url", "TestWort");
        });
        assertEquals("url 'invalid_url' is not a valid URL", exception.getMessage());
    }

    @Test
    void testNullUrlThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Wortpaar(null, "TestWort");
        });
        assertEquals("url is null", exception.getMessage());
    }

    @Test
    void testNullWortThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Wortpaar("https://www.example.com", null);
        });
        assertEquals("wort must not be null", exception.getMessage());
    }

    @Test
    void testSetValidUrl() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        wortpaar.setUrl("https://www.example2.com");
        assertEquals("https://www.example2.com", wortpaar.getUrl());
    }

    @Test
    void testSetInvalidUrlThrowsException() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wortpaar.setUrl("invalid_url");
        });
        assertEquals("url 'invalid_url' is not a valid URL", exception.getMessage());
    }

    @Test
    void testSetNullUrlThrowsException() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wortpaar.setUrl(null);
        });
        assertEquals("url is null", exception.getMessage());
    }

    @Test
    void testSetValidWort() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        wortpaar.setWort("NeuesWort");
        assertEquals("NeuesWort", wortpaar.getWort());
    }

    @Test
    void testSetNullWortThrowsException() {
        Wortpaar wortpaar = new Wortpaar("https://www.example.com", "TestWort");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wortpaar.setWort(null);
        });
        assertEquals("wort must not be null", exception.getMessage());
    }
}