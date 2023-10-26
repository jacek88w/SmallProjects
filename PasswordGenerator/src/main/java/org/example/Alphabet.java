package org.example;

public class Alphabet {

    private String value;

    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String SPECIALSIGNS = "@#&*$()_%=[]|,.+-/?!<>";

    private final StringBuilder stringBuilder;

    public Alphabet(boolean useLowerCase, boolean useUpperCase, boolean useDigits, boolean useSpecialSigns) {
        stringBuilder = new StringBuilder();

        if(useLowerCase) stringBuilder.append(LOWERCASE);

        if(useUpperCase) stringBuilder.append(UPPERCASE);

        if(useDigits) stringBuilder.append(DIGITS);

        if(useSpecialSigns) stringBuilder.append(SPECIALSIGNS);

        this.value = stringBuilder.toString();
    }

    public String getValue() {
        return value;
    }
}
