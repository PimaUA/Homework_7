package com.homework7;

import java.nio.file.Path;
import java.util.*;

public class FileNavigator {
    static Map<Path, List<FileData>> map = new HashMap<>();
    private final FileData fileData;

    public FileNavigator(FileData fileData) {
        this.fileData = fileData;
    }

    //method add
    void add(Path filePathKey, FileData fileData) {
        try {
            if (filePathKey.equals(fileData.getFilePath())) {
                if (map.isEmpty() || (!map.containsKey(filePathKey))) {
                    map.put(filePathKey, new ArrayList<>());
                }
                map.get(filePathKey).add(fileData);
            } else {
                String exceptionMessage = "No such path available: " + fileData.getFilePath()
                        + " ,file not added.";
                throw new NoSuchPathException(exceptionMessage);
            }
        } catch (NoSuchPathException e) {
            e.printStackTrace();
        }
        System.out.println("Initial map: " + map);
    }

    //method find
    void find(Path filePath) {
        Collection<FileData> collectionOfValues = map.get(filePath);
        System.out.println("Files found: " + collectionOfValues);
    }

    //method filterBySize
    void filterBySize(long checkedFileSize) {
        Collection<List<FileData>> allValuesCollection = map.values();
        Collection<FileData> filesCollection = new ArrayList<>();
        for (List<FileData> element : allValuesCollection) {
            for (FileData eachFile : element) {
                if (eachFile.getFileSize() < checkedFileSize) {
                    filesCollection.add(eachFile);
                }
            }
        }
        System.out.println("Filtered by provided size: " + filesCollection);
    }

    //remove method
    void remove(Path path) {
        Collection<FileData> collectionRemoved = map.remove(path);
        System.out.println("Removed files by path: " + collectionRemoved);
        System.out.println("Map after remove" + map);
    }

    //sort method
    void sortBySize() {
        Collection<List<FileData>> allValuesCollection = map.values();
        TreeSet<FileData> collectionBySize = new TreeSet<>(new FileComparator());
        for (List<FileData> element : allValuesCollection) {
            collectionBySize.addAll(element);
        }
        System.out.println("Sorted by Size: " + collectionBySize);
    }
}
