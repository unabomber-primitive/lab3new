package heroes;

import java.util.Arrays;
import java.util.Objects;

public class Child extends Human{

    int quant = 1;
    Human mother;
    Human father;

    public void setSex(Sex sex) throws IncorrectSexExcepion{
        if(sex.equals(Sex.MALE) || sex.equals(Sex.FEMALE)) {
            this.sex = sex;
            this.setDescr(sex.equals(Sex.MALE) ? "мальчик" : "девочка");
        }
        else throw new IncorrectSexExcepion("There are only two genders.");
    }

    public String getSex() {
        return this.sex.equals(Sex.MALE) ? "мальчик" : (this.sex.equals(Sex.FEMALE) ? "девочка" : "пол неопределен");
    }

    public Child() {
        this.isMany = false;
        this.setDescr("ребенок");
    }

    public Child(int quant, Human mother, Human father) {
        this.isMany = true;
        if(quant < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным числом.");
        }else this.quant = quant;
        this.setDescr("дети");
        this.mother = mother;
        this.father = father;
    }

    public Child(String name, Human mother, Human father) {
        this.isMany = false;
        this.setDescr("ребенок");
        this.setName(name);
        this.mother = mother;
        this.father = father;
    }

    public Child(String name) {
        this.isMany = false;
        this.setDescr("ребенок");
        this.setName(name);
    }

    public Child(int quant) {
        this.isMany = true;
        this.setDescr("дети");
    }

    public Child(String groupName, int quant) {
        this.isMany = true;
        this.setDescr(groupName);
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " name: " + getName() + " missed_heroes: " + Arrays.toString(missedHeroes) + " missed_things: " + Arrays.toString(missedThings) + " sex: " + getSex() + " quant: " + quant + " mother: " + mother.toString() + "father" + father.toString();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), quant, mother, father);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Child objChild = (Child) obj;
        return super.equals((Human) obj) && mother.equals(objChild.mother) && father.equals(objChild.father) && quant == objChild.quant;
    }
}
