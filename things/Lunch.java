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
        if(room == null) {
            throw new NullPointerException();
        }else this.room = room;
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
        for(DiningTable.Dishe i : table.getDishesSlots()) {
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

    public Lunch(DiningTable diningTable, DiningTable.Dishe[] dishes, Human[] eaters) {
        if(diningTable == null) {
            throw new NullPointerException();
        }else this.table = diningTable;
        this.table.addDishes(dishes);
        this.table.addSeaters(eaters);
        if(eaters == null) {
            throw new NullPointerException();
        }else this.eaters = eaters;
        for(Human i : this.eaters) {
            i.isEating();
        }
    }

    public void endLunch() {
        this.table.removeDishes();
        for(int i=0; i<this.eaters.length; i++) {
            eaters[i].notEating();
            eaters[i] = null;
        }
        this.table.removeSeaters();
    }

    public void transcedentalCosmicEternalPunishment() {
        class LastJudgement {
            Human[] pool;
            public LastJudgement(Human[] pool) {
                if(pool == null) {
                    throw new NullPointerException();
                }else this.pool = pool;
            }

            public boolean isGuilty(Human human) {
                if(human == null) {
                    throw new NullPointerException();
                }else return human.getKarma() < -5000;
            }

            public Human[] selection() {
                for(int k=0; k < pool.length; k++) {
                    if(pool[k] != null && !isGuilty(pool[k])) {
                        pool[k] = null;
                    }
                }
                return pool;
            }
        }

        LastJudgement lastJudgement = new LastJudgement(eaters);
        int counter = 0;
        for(Human human : lastJudgement.selection()) {
            if(human != null) {
                System.out.println(human.getName() + ", последний раз вкусив пищу, внезапно умирает и обретает вечные страдания в загробном мире.");
                ++counter;
            }
        }
        if(counter == 0) {
            System.out.println("\nИ были они таковы.");
        }

    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " table_pool: " + Arrays.toString(getTablePool());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getFunny(), table, Arrays.hashCode(eaters), room);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lunch objLunch = (Lunch) obj;
        return super.equals((Thing) obj) && getFunny() == objLunch.getFunny() && getRoom().equals(objLunch.getRoom()) && Arrays.equals(getTablePool(), objLunch.getTablePool()) && Arrays.equals(eaters, objLunch.eaters);
    }
}


