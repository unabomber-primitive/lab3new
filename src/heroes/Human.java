package heroes;

import interfaces.Miss;
import interfaces.Talk;
import things.Thing;

public class Human extends Hero implements Miss, Talk {

    String sex;
    Hero[] missedHeroes;
    Thing[] missedThings;
    boolean isTalking;

    public void talkAboutSomebody(Hero hero) {
        this.isTalking = true;
        System.out.println(this.getName() + " говорит про " + hero.getName());
    }

    public void missSomething(Thing[] things) {
        this.missedThings = things;
    }

    public void missSomebody(Hero[] heroes) {
        this.missedHeroes = heroes;
        String i = "";
        for(Hero h : heroes) {
            i+=", "+h.getName();
        }
        System.out.println(this.getName() + " скучает по " + i);
    }

    public void setSex(String sex) {
        if(sex.equals("Male") | sex.equals("Female")) {
            this.sex = sex;
            this.setDescr(sex.equals("Male") ? "мужчина" : "женщина");
        }
        else System.out.println("введен некорректный пол");
    }

    public String getSex(String sex) {
        return this.sex.equals("Male") ? "мужчина" : (this.sex.equals("Female") ? "женщина" : "пол неопределен");
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
}
