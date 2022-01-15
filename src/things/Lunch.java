package things;
import heroes.*;

public class Lunch {
    private boolean isFunny;
    DiningTable table;
    Human[] eaters;

    public void setFunny(boolean var) {
        isFunny = var;
    }

    public void getTablePool() {
        String dishes = "";
        String humans = "";
        int humancounter = 0;
        for(Food i : table.getDishesSlots()) {
            if(i!=null) {
                dishes += ", " + i.getDescr();
            }
        }
        for(Human j : table.getSeatSpots()) {
            if(j!=null) {
                humancounter += 1;
                humans += ", " + j.getName();
            }
        }
        System.out.println("За столом сидели " + humans + ". А на столе стояли " + dishes);
        setFunny(table.getSeatSpots().length-humancounter<3);
        getFunny();
    }

    public void getFunny() {
        System.out.println(isFunny ? " Все-таки это был веселый обед " : " И все же это был невеселый обед ");
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
}


