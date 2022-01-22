import heroes.Child;
import heroes.Hero;
import heroes.Human;
import things.*;

import java.util.stream.Stream;

public class Story {
    public static void main(String[] args) {
        Food dish1 = new Food("Яблочная запеканка");
        Food dish2 = new Food("обед");
        Food dish3 = new Food("Ванильный соус");
        Human bok = new Human("Фрекен Бок");
        Human mother = new Human("Мама");
        Human father = new Human("Папа");
        Human frida = new Human("Фрида");
        Child mal = new Child("Малыш", mother,father);
        Child bos = new Child("Босе", mother,father);
        Child bet = new Child("Бетан", mother,father);
        Action malEating = new Action("Я его ем", mal);
        Action thinking = new Action("Думает", mal);

        bok.setTheBestThingIn(dish1);
        bok.getTheBestThingIn().setTheBestThingIn(dish3);
        bok.getTheBestThingIn().getTheBestThingIn().setTheBestThingIn(malEating);

        Food[] dishes = {dish1, dish2};
        Human[] eaters = {bok, mal};
        Room kitchen = new Room("Кухня");
        Lunch lunch = new Lunch(dishes, eaters);
        lunch.setRoom(kitchen);

        String[] tablePool = lunch.getTablePool();
        Hero[] missedByMal = mal.missSomebody(new Hero[] {mother, father, bos, bet});
        String[] namesOfTalk = bok.talkAboutSomebody(frida);

        System.out.println("За столом сидели " + tablePool[1] + ". A на столе стояли " + tablePool[0] + "\n");
        System.out.println("\"Лучшее в " + bok.getName() + " -- это " + bok.getTheBestThingIn().getDescr());
        System.out.println("А лучшее в " + bok.getTheBestThingIn().getDescr() + " -- это " + bok.getTheBestThingIn().getTheBestThingIn().getDescr());
        System.out.print("А лучшее в " + bok.getTheBestThingIn().getTheBestThingIn().getDescr() + " -- это то, что " + bok.getTheBestThingIn().getTheBestThingIn().getTheBestThingIn().getDescr() + "\"");
        System.out.println("\t -- " + thinking.getDescr() + " " + thinking.getActor().getName() + "\n");

        System.out.println(lunch.getFunny() ? "И все же это был веселый обед \n" : "И все же это был невеселый обед, потому что столько мест за столом пустовало. \n");

        StringBuilder y = new StringBuilder();
        for(Hero i : missedByMal) {
            y.append(y.toString().equals("") ? "" : ", ").append(i.getName());
        }
        System.out.println(mal.getName() + " скучал по " + y.toString());
        System.out.println("А " + namesOfTalk[0] + " безумолку болтала о " + namesOfTalk[1]);

    }
}
