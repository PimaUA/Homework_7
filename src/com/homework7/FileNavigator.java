package com.homework7;

import java.nio.file.Path;
import java.util.*;

public class FileNavigator {
    private final Map<Path, List<FileData>> map = new HashMap<>();

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
    }

    //method find
    Collection<FileData> find(Path filePath) {
        return map.get(filePath);
    }

    //method filterBySize
    Collection<FileData> filterBySize(long checkedFileSize) {
        Collection<List<FileData>> allValuesCollection = map.values();
        Collection<FileData> filesCollection = new ArrayList<>();
        for (List<FileData> element : allValuesCollection) {
            for (FileData eachFile : element) {
                if (eachFile.getFileSize() < checkedFileSize) {
                    filesCollection.add(eachFile);
                }
            }
        }
        return filesCollection;
    }

    //remove method
    Collection<FileData> remove(Path path) {
        return map.remove(path);
    }

    //sort method
    Collection<FileData> sortBySize() {
        Collection<List<FileData>> allValuesCollection = map.values();
        TreeSet<FileData> collectionBySize = new TreeSet<>(new FileComparator());
        for (List<FileData> element : allValuesCollection) {
            collectionBySize.addAll(element);
        }
        return collectionBySize;
    }
}
