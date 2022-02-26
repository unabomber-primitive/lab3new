package things;

import java.util.Objects;

public class Room extends Thing{
    int quant;

    public Room() {
        this.isMany = false;
        this.setDescr("комната");
    }

    public Room(int quant) {
        if(quant < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным числом.");
        }else this.quant = quant;
        this.isMany = true;
        this.setDescr("комнаты");
    }

    public Room(String descr) {
        this.isMany = false;
        this.setDescr(descr);
    }

    public Room(String descr, int quant) {
        if(quant < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным числом.");
        }else this.quant = quant;
        this.isMany = true;
        this.setDescr(descr);
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " quant: " + quant;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), quant);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room objRoom = (Room) obj;
        return super.equals((Thing) obj) && quant == objRoom.quant;
    }
}
