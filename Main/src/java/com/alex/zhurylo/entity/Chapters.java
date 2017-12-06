package java.com.alex.zhurylo.entity;

import java.util.List;

public class Chapters {
    private int id;
    private String name;
    private List<Chapters> subchapter;
    private String referenceOnFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chapters> getSubchapter() {
        return subchapter;
    }

    public void setSubchapter(List<Chapters> subchapter) {
        this.subchapter = subchapter;
    }

    public String getreferenceOnFile() {
        return referenceOnFile;
    }

    public void setreferenceOnFile(String referenceOnFile) {
        this.referenceOnFile = referenceOnFile;
    }

    public Chapters() {

    }
    @Override
    public String toString() {
        return "Chapters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subchapter=" + subchapter +
                ", referenceOnFile='" + referenceOnFile + '\'' +
                '}';
    }
}
