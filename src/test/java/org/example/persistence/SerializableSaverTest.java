package org.example.persistence;

import org.example.model.Rechtschreibtrainer;
import org.example.model.Wortpaar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializableSaverTest {

    private SerializableSaver saver;
    private Rechtschreibtrainer trainer;

    @BeforeEach
    void setUp() {
        saver = new SerializableSaver();
        trainer = new Rechtschreibtrainer();
        Wortpaar wortpaar1 = new Wortpaar("https://www.example1.com", "Wort1");
        Wortpaar wortpaar2 = new Wortpaar("https://www.example2.com", "Wort2");
        trainer.addWortpaar(wortpaar1);
        trainer.addWortpaar(wortpaar2);
    }

    @Test
    void testSaveAndLoadModel() {
        // Save the trainer object
        saver.saveModel(trainer);

        // Load the trainer object
        Rechtschreibtrainer loadedTrainer = saver.loadModel();

        // Assert that the loaded object is not null
        assertNotNull(loadedTrainer);

        // Assert that the loaded object has the same data
        trainer.waehleWortpaar(0);
        assertEquals("https://www.example1.com", trainer.getBildURL());

        trainer.waehleWortpaar(1);
        assertEquals("Wort2", trainer.getWort());
    }
}