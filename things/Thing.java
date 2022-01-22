package things;

import interfaces.BestIn;

import java.util.Objects;

public abstract class Thing implements BestIn {
    public boolean isMany;
    private String descr;
    protected Thing theBestThingIn;

    public void setTheBestThingIn(Thing thing) {
        this.theBestThingIn = thing;
    }

    public Thing getTheBestThingIn() {
        return theBestThingIn;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDescr() {
        return this.descr;
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr());
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Thing objThing = (Thing) obj;
        return getDescr().equals(objThing.getDescr()) && getTheBestThingIn().equals(objThing.getTheBestThingIn()) && isMany == objThing.isMany;
    }
}
