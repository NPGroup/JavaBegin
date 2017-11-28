package entity;

public class Chapter {
    private int idName;
    private String chapter;
    private int idRefrence;
    private String chapterChild;
    private String refrence;


    public Chapter(int idName, String chapter, int idRefrence, String chapterChild, String refrence) {

        this.idName = idName;
        this.chapter = chapter;
        this.idRefrence = idRefrence;
        this.chapterChild = chapterChild;
        this.refrence = refrence;
    }

    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getIdRefrence() {
        return idRefrence;
    }

    public void setIdRefrence(int idRefrence) {
        this.idRefrence = idRefrence;
    }

    public String getChapterChild() {
        return chapterChild;
    }

    public void setChapterChild(String chapterChild) {
        this.chapterChild = chapterChild;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }

}
