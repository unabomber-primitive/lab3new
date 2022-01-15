import heroes.Child;
import heroes.Hero;
import heroes.Human;
import things.*;

public class Story {
    public static void main(String[] args) {
        Food dish1 = new Food("Яблочная запеканка в ванильном соусе");
        Food dish2 = new Food("обед");
        Human bok = new Human("Фрекен Бок");
        Human mother = new Human("Мама");
        Human father = new Human("Папа");
        Human frida = new Human("Фрида");
        Child mal = new Child("Малыш", mother,father);
        Child bos = new Child("Босе", mother,father);
        Child bet = new Child("Бетан", mother,father);

        Food[] dishes = {dish1, dish2};
        Human[] eaters = {bok, mal};
        Lunch lunch = new Lunch(dishes, eaters);

        Hero[] missed = {mother, father, bos, bet};
        lunch.getTablePool();
        mal.missSomebody(missed);
        bok.talkAboutSomebody(frida);
    }
}
