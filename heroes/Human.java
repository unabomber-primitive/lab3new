package heroes;

import interfaces.Miss;
import interfaces.Talk;
import things.Thing;

import java.util.Arrays;
import java.util.Objects;

public class Human extends Hero implements Miss, Talk {

    protected Sex sex;
    Hero[] missedHeroes;
    Thing[] missedThings;
    boolean isTalking;
    private int karma = 123;

    static public enum Sex {
        MALE,
        FEMALE
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public void addKarma(int karma) {
        this.karma += karma;
    }

    public int getKarma() {
        return karma;
    }

    public String[] talkAboutSomebody(Hero hero) {
        this.isTalking = true;
        return new String[] {this.getName(), hero.getName()};
//        System.out.println(this.getName() + " говорит про " + hero.getName());
    }

    public Thing[] missSomething(Thing[] things) {
        this.missedThings = things;
        return this.missedThings;
    }

    public Hero[] missSomebody(Hero[] heroes) {
        this.missedHeroes = heroes;
        return this.missedHeroes;
    }

    public void setSex(Sex sex) {
        if(sex.equals(Human.Sex.MALE) | sex.equals(Human.Sex.FEMALE)) {
            this.sex = sex;
            this.setDescr(sex.equals(Human.Sex.MALE) ? "мужчина" : "женщина");
        }
        else System.out.println("введен некорректный пол");
    }

    public String getSex() {
        return this.sex.equals(Human.Sex.MALE) ? "мужчина" : (this.sex.equals(Human.Sex.FEMALE) ? "женщина" : "пол неопределен");
    }

    public Human() {
        this.isMany = false;
        this.setDescr("человек");
    }

    public Human(String name) {
        this.isMany = false;
        this.setDescr("человек");
        this.setName(name);
    }

    public Human(int quant) {
        this.isMany = true;
        this.setDescr("люди");
    }

    public Human(String groupName, int quant) {
        this.isMany = true;
        this.setDescr(groupName);
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " name: " + getName() + " missed_heroes: " + Arrays.toString(missedHeroes) + " missed_things: " + Arrays.toString(missedThings) + " sex: " + getSex();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getSex(), Arrays.hashCode(missedHeroes), Arrays.hashCode(missedThings));
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human objHuman = (Human) obj;
        return super.equals((Hero) obj) && getSex().equals(objHuman.getSex()) && Arrays.equals(missedHeroes, objHuman.missedHeroes) && Arrays.equals(missedThings, objHuman.missedThings);
    }
}
