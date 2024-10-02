package org.example.gui;

import org.example.model.Rechtschreibtrainer;

import javax.swing.*;

public class JOptionView {

    public Object nextWort(Icon icon, String text) {
        return JOptionPane.showInputDialog(null, text, "Input Dialog", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
    }

    public boolean showSaveModelDialogue() {
        return JOptionPane.showConfirmDialog(null, "Worttrainer speichern?", "Speichern?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
