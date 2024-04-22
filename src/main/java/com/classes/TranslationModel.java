package com.classes;


import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ausier
 */
public class TranslationModel {
    private String inputWord;
    
    public TranslationModel(String inputWord) {
        FileHandler.initializeTranslationsFile();
        this.inputWord = inputWord;
    }
    
    public String getWordTranslation() {
        return FileHandler.getWordTranslation(inputWord);
    }
    
}
