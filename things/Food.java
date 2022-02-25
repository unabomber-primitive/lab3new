package things;

import java.util.Objects;

public class Food extends Thing{
    int quant;

    public Food(String name) {
        this.isMany = false;
        this.setDescr(name);
    }

    public Food() {
        this.isMany = false;
        this.setDescr("продукт");
    }

    public Food(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("продукты");
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
        Food objFood = (Food) obj;
        return super.equals((Thing) obj) && quant == objFood.quant;
    }
}
