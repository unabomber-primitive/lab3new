import heroes.Child;
import heroes.Hero;
import heroes.Human;
import heroes.IncorrectSexExcepion;
import things.*;

public class Story {
    public static void main(String[] args) {
        Human bok = new Human("Фрекен Бок");
        try {
            bok.setSex(Human.Sex.FEMALE);
        } catch (IncorrectSexExcepion ignored) {}
        Human mother = new Human("Мама");
        Human father = new Human("Папа");
        Human frida = new Human("Фрида");
        Child mal = new Child("Малыш", mother,father);
        try {
            mal.setSex(Human.Sex.MALE);
        } catch (IncorrectSexExcepion ignored) {}
        Child bos = new Child("Босе", mother,father);
        Child bet = new Child("Бетан", mother,father);
        Action malEating = new Action("Я его ем", mal);
        Action thinking = new Action("Думает", mal);
        Action stodge = new Action("уплетал за двоих", mal);

        DiningTable table = new DiningTable();
        DiningTable.Dishe dish1 = table.new Dishe("Яблочная запеканка");
        //DiningTable.Dishe dish2 = table.new Dishe("обед");
        DiningTable.Dishe dish3 = table.new Dishe("Ванильный соус");
        DiningTable.Dishe dish4 = table.new Dishe("вкусные тефтели");
        table.setKitchener(bok);
        table.getKitchener().addKarma(1488);


        bok.setTheBestThingIn(dish1);
        bok.getTheBestThingIn().setTheBestThingIn(dish3);
        bok.getTheBestThingIn().getTheBestThingIn().setTheBestThingIn(malEating);

        DiningTable.Dishe[] dishes = {dish1, dish4};
        Human[] eaters = {bok, mal};
        Room kitchen = new Room("Кухня");
        Lunch lunch = new Lunch(table, dishes, eaters);
        lunch.setRoom(kitchen);

        String[] tablePool = lunch.getTablePool();
        Hero[] missedByMal = mal.missSomebody(new Hero[] {mother, father, bos, bet});
        String[] namesOfTalk = bok.talkAboutSomebody(frida);

        System.out.println("За столом сидели " + tablePool[1] + ". A на столе стояли " + tablePool[0] + "\n");

        Action lunchWith = new Action("Обедать вдвоем", bok) {
            {
                setIsBoring(getActor().getName().equals("Фрекен Бок"));
                System.out.print(getDescr() + " с " + getActor().getName() + (getIsBoring() ? " было скучно. " : " не было скучным занятием. "));
            }
            boolean isBoring;
            public boolean getIsBoring() {
                return isBoring;
            }
            public void setIsBoring(boolean isBoring) {
                this.isBoring = isBoring;
            }
        };

        System.out.println("Но зато " + dish4.getHumanWhoPreparedTheDish().getName() + " приготовила " + dish4.getDescr() + ". ");
        System.out.println(stodge.getActor().getName() + " " + stodge.getDescr() );
        System.out.print("\"Все-таки " + bok.getName() + (bok.getKarma()>666 ? ", может быть, не так уж плоха.\"" : "плоха.\""));
        System.out.println("\t -- " + thinking.getDescr() + " " + thinking.getActor().getName() + "\n");
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
        lunch.transcedentalCosmicEternalPunishment();
    }
}
