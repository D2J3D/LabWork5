package Server.commands;

import Server.CollectionManager;
import Server.core.Chapter;

import java.io.Serializable;
/**
 * Класс реализующий команду remove_all_by_chapter
 * Удаляет все элементы имеющим определенное значением Chapter
 */
public class RemoveAllByChapter implements Command, Serializable {
    CollectionManager cm;
    Chapter chapter;

    public RemoveAllByChapter(CollectionManager cm){
        this.cm = cm;
    }
    public RemoveAllByChapter(CollectionManager cm, Chapter chapter){
        this.chapter = chapter;
    }
    @Override
    public void execute() {
        cm.removeAllByChapter(chapter);
    }

    @Override
    public String descr() {
        return null;
    }

    @Override
    public void setParamName(String param) {
        this.chapter = new Chapter(param);
    }
}
