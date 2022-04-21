package notHesap;

public class Course {

    Teacher teacher;
    String name;
    String prefix;
    int noteYazili=0;
    int noteSozlu=0;



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


