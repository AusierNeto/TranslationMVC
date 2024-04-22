/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.classes.FileHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author ausier
 */
public class FileHandlerTests {
    
    @BeforeAll
    public static void testSetup() {
        FileHandler.createStorageFile();
    }
    
    @Test
    public void getTranslationFromFileTest() {
        FileHandler.writeInformation("Interface Interface");
        assertEquals("Interface", FileHandler.getWordTranslation("Interface"));
    }
    
    @Test
    public void getTranslationsOfMultipleWordsTest() {
        FileHandler.writeInformation("Automation Automação");
        FileHandler.writeInformation("Information Informação");
        assertEquals("Informação", FileHandler.getWordTranslation("Information"));
        assertEquals("Automação", FileHandler.getWordTranslation("Automation"));
    }
    
}
