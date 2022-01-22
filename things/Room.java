package things;

import java.util.Objects;

public class Room extends Thing{
    int quant;

    public Room() {
        this.isMany = false;
        this.setDescr("комната");
    }

    public Room(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("комнаты");
    }

    public Room(String descr) {
        this.isMany = false;
        this.setDescr(descr);
    }

    public Room(String descr, int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr(descr);
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " quant: " + quant;
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany, quant);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room objRoom = (Room) obj;
        return getDescr().equals(objRoom.getDescr()) && getTheBestThingIn().equals(objRoom.getTheBestThingIn()) && isMany == objRoom.isMany && quant == objRoom.quant;
    }
}
