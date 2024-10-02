package org.example.persistence;
import org.example.model.Rechtschreibtrainer;

/**
 * @author Markus Stuppnig
 * @version 2024-10-02
 * Klasse mit statischen Methoden zum Abspeichern des Rechtschreibtrainer Objektes
 */
public class StatisticSaver {

    public static void saveModel(Speicherstrategie strategie, Rechtschreibtrainer rechtschreibtrainer) {
        strategie.saveModel(rechtschreibtrainer);
    }

    public static Rechtschreibtrainer loadModel(Speicherstrategie strategie) {
        return strategie.loadModel();
    }
}
