package Server.commands;

import Server.CollectionManager;

import java.io.Serializable;
/**
 * Класс реализующий команду print_unique_chapter
 * Возвращает все уникальные объекты значения Chapter, которые есть у объектов коллекции
 */
public class PrintUniqueChapter implements Command, Serializable {
    CollectionManager cm;
    public PrintUniqueChapter(CollectionManager cm){
        this.cm = cm;
    }
    @Override
    public void execute() {
        cm.printUniqueChapter();
    }

    @Override
    public String descr() {
        return null;
    }
}
