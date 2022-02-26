package things;

import java.util.Objects;

public class Furniture extends Thing{
    private int quant;

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        if(quant < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным числом.");
        }else this.quant = quant;
    }

    public Furniture() {
        this.isMany = false;
        this.setDescr("мебельный предмет");
    }

    public Furniture(int quant) {
        this.setQuant(quant);
        this.isMany = true;
        this.setDescr("мебельные предметы");
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
        Furniture objFurniture = (Furniture) obj;
        return super.equals((Thing) obj) && quant == objFurniture.quant;
    }
}
