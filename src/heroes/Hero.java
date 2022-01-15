package heroes;

import interfaces.Eat;
import interfaces.Miss;

public class Hero implements Eat{
    public boolean isMany;
    private String descr;
    private String name;
    boolean isEating;

    public void isEating() {
        this.isEating = true;
        System.out.println(this.getName() + " ест");
    }

    public void notEating() {
        this.isEating = false;
    }

    public Hero() {
        this.isMany = false;
        this.setDescr("персонаж");
    }

    public Hero(String name) {
        this.isMany = false;
        this.setDescr("персонаж");
        this.setName(name);
    }

    public Hero(int quant) {
        this.isMany = true;
        this.setDescr("персонажи");
    }

    public Hero(String groupName, int quant) {
        this.isMany = true;
        this.setDescr(groupName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return (name == null ? this.descr : this.name);
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDescr() {
        return this.descr;
    }
}
