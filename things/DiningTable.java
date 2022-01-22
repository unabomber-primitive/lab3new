package things;

import heroes.Human;

import java.util.Arrays;
import java.util.Objects;

public class DiningTable extends Furniture {
    private Food[] dishesSlots = new Food[10];
    private Human[] seatSpots = new Human[6];

    public Food[] getDishesSlots() {
        return this.dishesSlots;
    }

    public Human[] getSeatSpots() {
        return this.seatSpots;
    }

    public void addDishes(Food[] dishes) {
        int i = 0;
        for(Food dishe : dishes) {
            this.dishesSlots[i] = dishe;
            i += 1;
        }
    };

    public void addSeaters(Human[] seaters) {
        int i = 0;
        for(Human seater : seaters) {
            this.seatSpots[i] = seater;
            i += 1;
        }
    };

    public void removeDishes() {
        for(Food dishe : this.dishesSlots) {
            dishe = null;
        }
    }

    public void removeSeaters() {
        for(Human seater : this.seatSpots) {
            seater = null;
        }
    }

    public DiningTable(Food[] dishes, Human[] seaters) {
        this.isMany = false;
        this.setDescr("стол");
        this.addDishes(dishes);
        this.addSeaters(seaters);
    }

    public DiningTable() {
        this.isMany = false;
        this.setDescr("стол");
    }

    public DiningTable(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("столы");
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " quant: " + quant + " dishes: " + Arrays.toString(dishesSlots) + " seat_spots: " + Arrays.toString(seatSpots);
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany, quant, Arrays.hashCode(dishesSlots), Arrays.hashCode(seatSpots));
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiningTable objDiningTable = (DiningTable) obj;
        return getDescr().equals(objDiningTable.getDescr()) && getTheBestThingIn().equals(objDiningTable.getTheBestThingIn()) && isMany == objDiningTable.isMany && quant == objDiningTable.quant && Arrays.equals(dishesSlots, objDiningTable.dishesSlots) && Arrays.equals(seatSpots, objDiningTable.seatSpots);
    }
}
