package org.example.gui;

import javax.swing.*;

/**
 * @author Markus Stuppnig
 * @version 2024-10-02
 * Die View Klasse welche Methoden für JOptionPane zur Verfügung stellt
 */
public class JOptionView {

    public Object nextWort(Icon icon, String text) {
        return JOptionPane.showInputDialog(null, text, "Input Dialog", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
    }

    public boolean showSaveModelDialogue() {
        return JOptionPane.showConfirmDialog(null, "Worttrainer speichern?", "Speichern?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
