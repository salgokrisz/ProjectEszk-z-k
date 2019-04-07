package cluedo.Tools.LanguageString;

import cluedo.Tools.LanguageString.parser.LanguageStringsParser;
import java.util.HashMap;

public class LanguageStrings {
    private static HashMap<String, String> strings = null;
    private static Language L = Language.ENG;
    
    public static Language getCurrentLanguage () {
        if (L == Language.ENG) return Language.ENG;
        else return Language.HUN;
    }
    
    public static String getString (String key) {
        if (key == null) 
            return null;
        if (strings == null)
            strings = LanguageStringsParser.Parse (L, false, "");  
        return strings.get (key);
    }
    
    public static void changeLanguage (Language L) {
        if (LanguageStrings.L != L) {
            LanguageStrings.L = L;
            strings = LanguageStringsParser.Parse (L, false, "");  
        }
    }
    
}
    