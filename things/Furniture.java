package things;

import java.util.Objects;

public class Furniture extends Thing{
    int quant;

    public Furniture() {
        this.isMany = false;
        this.setDescr("мебельный предмет");
    }

    public Furniture(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("мебельные предметы");
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
        Furniture objFurniture = (Furniture) obj;
        return getDescr().equals(objFurniture.getDescr()) && getTheBestThingIn().equals(objFurniture.getTheBestThingIn()) && isMany == objFurniture.isMany && quant == objFurniture.quant;
    }
}
