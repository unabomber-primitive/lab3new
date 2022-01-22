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
        this.setDescr("блюда");
    }

    public Food(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("блюдо");
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
        Food objFood = (Food) obj;
        return getDescr().equals(objFood.getDescr()) && getTheBestThingIn().equals(objFood.getTheBestThingIn()) && isMany == objFood.isMany && quant == objFood.quant;
    }
}
