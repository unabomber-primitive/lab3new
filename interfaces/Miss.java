package interfaces;
import heroes.Hero;
import heroes.Human;
import things.Thing;

public interface Miss {
    Hero[] missSomebody(Hero[] heroes);
    Thing[] missSomething(Thing[] things);
}
