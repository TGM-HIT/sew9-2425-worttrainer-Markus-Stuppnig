package org.example.persistence;

import org.example.model.Rechtschreibtrainer;

public interface Speicherstrategie {

    void saveModel(Rechtschreibtrainer rechtschreibtrainer);
    Rechtschreibtrainer loadModel();
}
