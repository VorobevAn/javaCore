package org.seminar5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static java.nio.file.Files.delete;

public class Copy {
    public static void main(String[] args) {
        copyDirectory("./src", "./bascup");
    }

    /**
     * Метод копирования директории с вложенными файломи и директориями
     * @param dirSource копируемая директория
     * @param dirTarget директория назначения
     */

    public static void copyDirectory(String dirSource, String dirTarget) {
        // Проверяем если директория существует, удаляем её.
        try {
            Path target = Paths.get(dirTarget);
            if (Files.exists(target)) {
                delete(target);
            }
            // Пробегаемся по всем вложеным папкам копируемой дирекрории,
            // сездаем путь вложенных директорий и копируем в новую директорию.
            Files.walk(Paths.get(dirSource))
                    .forEach(source -> {
                        Path destination = Paths.get(dirTarget, source.toString()
                                .substring(dirSource.length()));
                        try {
                            Files.copy(source, destination);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}