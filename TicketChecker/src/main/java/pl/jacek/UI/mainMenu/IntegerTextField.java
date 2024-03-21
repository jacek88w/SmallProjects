package pl.jacek.UI.mainMenu;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class IntegerTextField extends JFormattedTextField {
    public IntegerTextField() {
        super(createFormatter());
        setColumns(10);
    }

    private static NumberFormatter createFormatter() {
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(integerFormat);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0); // Set minimum value if needed
        formatter.setMaximum(Integer.MAX_VALUE); // Set maximum value if needed
        formatter.setAllowsInvalid(false); // Disallow invalid input
        return formatter;
    }
}