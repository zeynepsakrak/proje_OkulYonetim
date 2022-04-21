package notHesap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {

    Teacher teacher;
    String name;
    String prefix;
    int noteYazili=0;
    int noteSozlu=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNoteYazili() {
        return noteYazili;
    }

    public void setNoteYazili(int noteYazili) {
        this.noteYazili = noteYazili;
    }

    public int getNoteSozlu() {
        return noteSozlu;
    }

    public void setNoteSozlu(int noteSozlu) {
        this.noteSozlu = noteSozlu;
    }
}


