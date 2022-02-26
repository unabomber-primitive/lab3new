package heroes;

import interfaces.BestIn;
import interfaces.Eat;
import interfaces.Miss;
import things.Room;
import things.Thing;

import java.util.Objects;

public class Hero implements Eat, BestIn {
    public boolean isMany;
    private String descr;
    private String name;
    private boolean eating;
    protected Thing theBestThingIn;

    public void setTheBestThingIn(Thing thing) {
        if(thing == null) {
            throw new NullPointerException();
        } else {
            this.theBestThingIn = thing;
        }
    }

    public Thing getTheBestThingIn() {
        return theBestThingIn;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public boolean getEating() {
        return this.eating;
    }

    public void isEating() {
        this.eating = true;
//        System.out.println(this.getName() + " ест");
    }

    public void notEating() {
        this.eating = false;
    }

    public Hero() {
        this.isMany = false;
        this.setDescr("персонаж");
    }

    public Hero(String name) {
        this.isMany = false;
        this.setName(name);
    }

    public Hero(int quant) {
        this.isMany = true;
        this.setDescr("персонажи");
    }

    public Hero(String groupName, int quant){
        this.isMany = true;
        setDescr(groupName);
    }

    public void setName(String name) {
        if(name == null) {
            throw new NullPointerException();
        } else if(name.equals("")) {
            throw new IllegalArgumentException("Имя не может быть пустой строкой.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return (name == null ? this.descr : this.name);
    }

    public void setDescr(String descr) {
        if(descr == null) {
            throw new NullPointerException();
        } else if(descr.equals("")) {
            throw new IllegalArgumentException("Описание не может быть пустой строкой.");
        } else {
            this.descr = descr;
        }
    }

    public String getDescr() {
        return this.descr;
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " name: " + getName();
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany, getName());
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hero objHero = (Hero) obj;
        return getDescr().equals(objHero.getDescr()) && getTheBestThingIn().equals(objHero.getTheBestThingIn()) && isMany == objHero.isMany && getName().equals(objHero.getName());
    }
}
