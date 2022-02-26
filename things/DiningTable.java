package things;

import heroes.Human;

import java.util.Arrays;
import java.util.Objects;

public class DiningTable extends Furniture {
    private Dishe[] dishesSlots = new Dishe[10];
    private Human[] seatSpots = new Human[6];
    private Human kitchener;

    public Human getKitchener() {
        return kitchener;
    }

    public void setKitchener(Human kitchener) {
        if(kitchener == null) {
            throw new NullPointerException();
        } else {
            this.kitchener = kitchener;
            for (Dishe dishe : dishesSlots) {
                if (dishe != null) {
                    dishe.setHumanWhoPreparedTheDish(kitchener);
                }
            }
        }
    }

    public class Dishe extends Food {
        private Human humanWhoPreparedTheDish;

        public Dishe(String name) {
            super(name);
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public Dishe() {
            this.isMany = false;
            this.setDescr("блюдо");
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public Dishe(int quant) {
            this.setQuant(quant);
            this.isMany = true;
            this.setDescr("блюда");
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public Dishe(String name, Human humanWhoPreparedTheDish) {
            super(name);
            this.setHumanWhoPreparedTheDish(humanWhoPreparedTheDish);
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public Dishe(Human humanWhoPreparedTheDish) {
            this.isMany = false;
            this.setDescr("блюдо");
            this.setHumanWhoPreparedTheDish(humanWhoPreparedTheDish);
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public Dishe(int quant, Human humanWhoPreparedTheDish) {
            this.setQuant(quant);
            this.isMany = true;
            this.setDescr("блюда");
            this.setHumanWhoPreparedTheDish(humanWhoPreparedTheDish);
            for (int i=0; i<10; i++) {
                if(dishesSlots[i] == null) {
                    dishesSlots[i] = this;
                    break;
                }
            }
        }

        public void setHumanWhoPreparedTheDish(Human humanWhoPreparedTheDish) {
            if(humanWhoPreparedTheDish == null) {
                throw new NullPointerException();
            }else this.humanWhoPreparedTheDish = humanWhoPreparedTheDish;
        }

        public Human getHumanWhoPreparedTheDish() {
            return humanWhoPreparedTheDish;
        }

    }

    public Dishe[] getDishesSlots() {
        return this.dishesSlots;
    }

    public Human[] getSeatSpots() {
        return this.seatSpots;
    }

    public void addDishes(Dishe[] dishes) {
        if(dishes == null) {
            throw new NullPointerException();
        }else {
            removeDishes();
            int i = 0;
            for (Dishe dishe : dishes) {
                this.dishesSlots[i] = dishe;
                i += 1;
            }
        }
    }

    public void addSeaters(Human[] seaters) {
        if(seaters == null) {
            throw new NullPointerException();
        }else {
            removeSeaters();
            int i = 0;
            for (Human seater : seaters) {
                this.seatSpots[i] = seater;
                i += 1;
            }
        }
    }

    public void removeDishes() {
        for(int i=0; i<this.dishesSlots.length; i++) {
            if(this.dishesSlots[i] != null) {
                this.dishesSlots[i] = null;
            }
        }
    }

    public void removeSeaters() {
        for(int i=0; i<this.seatSpots.length; i++) {
            if(this.seatSpots[i] != null) {
                this.seatSpots[i] = null;
            }
        }
    }

    public DiningTable(Human[] seaters) {
        this.isMany = false;
        this.setDescr("стол");
        this.addSeaters(seaters);
    }

    /*public DiningTable(Food[] food, Human[] seaters, Human kitchener) {
        this.isMany = false;
        this.setDescr("стол");
        this.addSeaters(seaters);
        Dishe[] dishes = Stream.of(food).map((x) -> this.new (Dishe) x)
        this.addDishes(dishes);
    }*/

    public DiningTable() {
        this.isMany = false;
        this.setDescr("стол");
    }

    public DiningTable(int quant) {
        this.setQuant(quant);
        this.isMany = true;
        this.setDescr("столы");
    }

    public String toString() {
        return getClass().getName() + " descr: " + getDescr() + " isMany: " + isMany + (getTheBestThingIn() == null ? "" : " the best thing in: " + getTheBestThingIn().getDescr()) + " quant: " + getQuant() + " dishes: " + Arrays.toString(dishesSlots) + " seat_spots: " + Arrays.toString(seatSpots);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(dishesSlots), Arrays.hashCode(seatSpots));
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiningTable objDiningTable = (DiningTable) obj;
        return super.equals((Furniture) obj) && Arrays.equals(dishesSlots, objDiningTable.dishesSlots) && Arrays.equals(seatSpots, objDiningTable.seatSpots);
    }
}
