package interfaces;
import heroes.Hero;
import heroes.Human;
import things.Thing;

public interface Miss {
    void missSomebody(Hero[] heroes);
    void missSomething(Thing[] things);
}
