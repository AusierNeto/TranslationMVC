package com.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FileHandler {
    
    private static Path mainDirectory = Paths.get(System.getProperty("user.dir"));

    public static void createStorageFile(String filename) {
        Path filepath = mainDirectory.resolve(filename);
        File file = new File(filepath.toString());

        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println(filename + " file successfully created.");
            } else {
                System.out.println("File already created. Recreating file");
            	FileHandler.deleteStorageFile(filename);
            	file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("When creating the file, an exception ocurred: "
            		+ e.getMessage());
        }
    }
    
    public static void createStorageFile() {
        createStorageFile("TranslationsFile.txt");
    }
    
    public static void deleteStorageFile(String filename) {
    	Path filePath = mainDirectory.resolve(filename);
    	File fileObject = new File(filePath.toString());
    	try {
            fileObject.delete();
            } catch (Exception e) {
                System.out.println("An exception ocurred while deleting the file: "
                                + e.getMessage());
            }
    }
    
    public static List<String> getFilesInDirectory() {
        Path directory = mainDirectory;
        List<String> fileNames = new ArrayList<>();
        try {
            fileNames = Files.list(directory)
                             .filter(Files::isRegularFile)
                             .map(Path::getFileName)
                             .map(Path::toString)
                             .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An exception ocurred: " + e.getMessage());
        }
        return fileNames;
    }

    public static void writeInformation(String filenameString, String informationString) {
        Path filepath = mainDirectory.resolve(filenameString);

        try {
            Files.write(filepath, (informationString + "\n").getBytes(StandardCharsets.UTF_8)
                , StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("An exception ocurred: " + e.getMessage());
        }
    }

    public static void writeInformation(String informationString) {
        writeInformation("TranslationsFile.txt", informationString);
    }

    public static List<String> readFileLines(String filenameString) {
        List<String> linhas = new ArrayList<>();
        Path filePath = mainDirectory.resolve(filenameString);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public static List<String> readFileLines() {
        return readFileLines("TranslationsFile.txt");
    }
    
    public static void addTranslationToFile(String originalWord, String translation) {
        String fileLine = originalWord + " " + translation;
        FileHandler.writeInformation(fileLine);
    }
    
    public static void initializeTranslationsFile() {
        FileHandler.createStorageFile();
        FileHandler.addTranslationToFile("Information", "Informação");
        FileHandler.addTranslationToFile("Head", "Cabeça");
        FileHandler.addTranslationToFile("Book", "Livro");
        FileHandler.addTranslationToFile("Worry", "Preocupação");
        FileHandler.addTranslationToFile("Keyboard", "Teclado");
        FileHandler.addTranslationToFile("Computer", "Computador");
        FileHandler.addTranslationToFile("Board", "Placa");
        FileHandler.addTranslationToFile("Flowchart", "Fluxograma");
        FileHandler.addTranslationToFile("Canvas", "Quadro");
        FileHandler.addTranslationToFile("Keys", "Chaves");
        FileHandler.addTranslationToFile("Snake", "Cobra");
        FileHandler.addTranslationToFile("Desk", "Escrivaninha");
        FileHandler.addTranslationToFile("Table", "Mesa");
        FileHandler.addTranslationToFile("Mobile Phone", "Celular");
        FileHandler.addTranslationToFile("Watch", "Relógio");
        FileHandler.addTranslationToFile("Cube", "Cubo");
        FileHandler.addTranslationToFile("Controller", "Controle");
        FileHandler.addTranslationToFile("Knife", "Faca");
        FileHandler.addTranslationToFile("Screen", "Tela");
        FileHandler.addTranslationToFile("Whale", "Baleia");
        FileHandler.addTranslationToFile("Window", "Janela");
    }
    
    public static String getWordTranslation(String inputWord) {
        List<String> fileLines = readFileLines();
        for (String line : fileLines) {
            if (line.split(" ")[0].equals(inputWord)) {
                return line.split(" ")[1];
            }
        }
        return inputWord;
    }
    
    public static void main(String[] args) {
        FileHandler.initializeTranslationsFile();
    }

}
