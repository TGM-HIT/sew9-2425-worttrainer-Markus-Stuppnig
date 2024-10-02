package org.example.persistence;

import org.example.model.Rechtschreibtrainer;

/**
 * @author Markus Stuppnig
 * @version 2024-10-02
 * Interface zur Speicherstrategie - schreibt eine Laden und eine Speichern Methode for
 */
public interface Speicherstrategie {

    void saveModel(Rechtschreibtrainer rechtschreibtrainer);
    Rechtschreibtrainer loadModel();
}
