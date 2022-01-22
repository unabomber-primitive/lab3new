package things;
import heroes.*;

import java.util.Arrays;
import java.util.Objects;

public class Lunch extends Thing{
    private boolean isFunny;
    DiningTable table;
    Human[] eaters;
    Room room;

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setFunny(boolean var) {
        isFunny = var;
    }

    public String[] getTablePool() {
        StringBuilder dishes = new StringBuilder();
        StringBuilder humans = new StringBuilder();
        int humancounter = 0;
        for(Food i : table.getDishesSlots()) {
            if(i!=null) {
                dishes.append(dishes.toString().equals("") ? "" : ", ").append(i.getDescr());
            }
        }
        for(Human j : table.getSeatSpots()) {
            if(j!=null) {
                humancounter += 1;
                humans.append(humans.toString().equals("") ? "" : ", ").append(j.getName());
            }
        }
//        System.out.println("За столом сидели " + humans + ". А на столе стояли " + dishes);
        setFunny(table.getSeatSpots().length-humancounter<table.getSeatSpots().length/2);
        return new String[]{dishes.toString(), humans.toString()};
//        getFunny();
    }


    public boolean getFunny() {
        return isFunny;
//        System.out.println(isFunny ? " Все-таки это был веселый обед " : " И все же это был невеселый обед ");
    }

    public Lunch(Food[] dishes, Human[] eaters) {
        this.table = new DiningTable(dishes, eaters);
        this.eaters = eaters;
        for(Human i : this.eaters) {
            i.isEating();
        }
    }

    public void endLunch() {
        this.table.removeDishes();
        for(Human i : this.eaters) {
            i.notEating();
            i = null;
        }
        this.table.removeSeaters();
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " table_pool: " + Arrays.toString(getTablePool());
    }

    public int hashCode() {
        return Objects.hash(getTheBestThingIn(), getDescr(), isMany, table, Arrays.hashCode(eaters), room);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lunch objLunch = (Lunch) obj;
        return getDescr().equals(objLunch.getDescr()) && getTheBestThingIn().equals(objLunch.getTheBestThingIn()) && isMany == objLunch.isMany && getFunny() == objLunch.getFunny() && getRoom().equals(objLunch.getRoom()) && Arrays.equals(getTablePool(), objLunch.getTablePool());
    }
}


