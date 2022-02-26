package heroes;

import java.util.Objects;

public class Animal extends Hero{

    public Animal(){
        this.isMany = false;
        this.setDescr("животное");
    }

    public Animal(String name) {
        this.isMany = false;
        this.setDescr("животное");
        this.setName(name);
    }

    public Animal(int quant) {
        this.isMany = true;
        this.setDescr("животные");
    }

    public Animal(String groupName, int quant) {
        this.isMany = true;
        this.setDescr(groupName);
    }
}
