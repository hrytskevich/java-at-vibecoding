package org.hw_14;

public class XMLUtils {

    public static String createEmptyElement(String tagName) {
        if (tagName == null || tagName.equals(""))
            return "<invalid/>";
        return "<" + tagName + "></" + tagName + ">";
    }
}
