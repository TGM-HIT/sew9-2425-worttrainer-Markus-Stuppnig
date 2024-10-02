package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RechtschreibtrainerTest {

    private Rechtschreibtrainer trainer;
    private Wortpaar wortpaar1;
    private Wortpaar wortpaar2;

    @BeforeEach
    void setUp() {
        trainer = new Rechtschreibtrainer();
        wortpaar1 = new Wortpaar("https://www.example1.com", "Wort1");
        wortpaar2 = new Wortpaar("https://www.example2.com", "Wort2");
        trainer.addWortpaar(wortpaar1);
        trainer.addWortpaar(wortpaar2);
    }

    @Test
    void testWaehleWortpaar() {
        trainer.waehleWortpaar(0);
        assertEquals("https://www.example1.com", trainer.getBildURL());
        assertEquals("Wort1", trainer.getWort());

        trainer.waehleWortpaar(1);
        assertEquals("https://www.example2.com", trainer.getBildURL());
        assertEquals("Wort2", trainer.getWort());
    }

    @Test
    void testWaehleRandomWortpaar() {
        trainer.waehleRandomWortpaar();
        String url = trainer.getBildURL();
        assertTrue(url.equals("https://www.example1.com") || url.equals("https://www.example2.com"));
    }

    @Test
    void testSetRichtig() {
        trainer.setRichtig(5);
        assertEquals(5, trainer.getRichtig());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trainer.setRichtig(-1);
        });
        assertEquals("richtig negative", exception.getMessage());
    }

    @Test
    void testSetInsgesamt() {
        trainer.setInsgesamt(10);
        assertEquals(10, trainer.getInsgesamt());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trainer.setInsgesamt(-1);
        });
        assertEquals("insgesamt negative", exception.getMessage());
    }

    @Test
    void testGetBildURL() {
        trainer.waehleWortpaar(0);
        assertEquals("https://www.example1.com", trainer.getBildURL());
    }

    @Test
    void testGetWort() {
        trainer.waehleWortpaar(1);
        assertEquals("Wort2", trainer.getWort());
    }
}