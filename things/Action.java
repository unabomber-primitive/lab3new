package things;

import heroes.Human;

import java.util.Objects;

public class Action extends Thing{
    protected Human actor;

    public void setActor(Human actor) {
        this.actor = actor;
    }

    public Human getActor() {
        return actor;
    }

    public Action(String processName) {
        this.setDescr(processName);
    }

    public Action(String processName, Human actor) {
        this.setDescr(processName);
        this.setActor(actor);
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " actor: " + getActor();
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany, getActor());
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Action objAction = (Action) obj;
        return getDescr().equals(objAction.getDescr()) && getTheBestThingIn().equals(objAction.getTheBestThingIn()) && isMany == objAction.isMany && getActor().equals(objAction.getActor());
    }
}
