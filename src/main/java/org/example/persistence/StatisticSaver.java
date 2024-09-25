package org.example.persistence;
import org.example.model.Rechtschreibtrainer;

import java.io.*;

public class StatisticSaver {

    public static void saveModel(Speicherstrategie strategie, Rechtschreibtrainer rechtschreibtrainer) {
        strategie.saveModel(rechtschreibtrainer);
    }

    public static Rechtschreibtrainer loadModel(Speicherstrategie strategie) {
        return strategie.loadModel();
    }
}
