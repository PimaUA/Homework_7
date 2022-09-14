package com.homework7;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        FileData file1 = new FileData("file1.txt", 18, Paths.get("src/firstFolder"));
        FileData file2 = new FileData("file2.txt", 5, Paths.get("src/firstFolder"));
        FileData file3 = new FileData("file3.txt", 14, Paths.get("src/firstFolder"));
        FileData file4 = new FileData("file4.txt", 6, Paths.get("src/secondFolder"));
        FileData file5 = new FileData("file5.txt", 5, Paths.get("src/secondFolderxxx"));
        FileNavigator newFile = new FileNavigator(file1);
        FileNavigator newFile2 = new FileNavigator(file2);
        FileNavigator newFile3 = new FileNavigator(file3);
        FileNavigator newFile4 = new FileNavigator(file4);
        FileNavigator newFile5 = new FileNavigator(file5);

        newFile.add(Paths.get("src/firstFolder"), file1);
        newFile2.add(Paths.get("src/firstFolder"), file2);
        newFile3.add(Paths.get("src/firstFolder"), file3);
        newFile4.add(Paths.get("src/secondFolder"), file4);
        newFile5.add(Paths.get("src/secondFolder"), file5);

        newFile3.find(Paths.get("src/firstFolder"));
        newFile4.filterBySize(10);
        newFile5.sortBySize();
        newFile5.remove(Paths.get("src/firstFolder"));
    }
}
