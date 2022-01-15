package heroes;

public class Child extends Human{

    int quant;
    Human mother;
    Human father;

    public void setSex(String sex) {
        if(sex.equals("Male") | sex.equals("Female")) {
            this.sex = sex;
            this.setDescr(sex.equals("Male") ? "мальчик" : "девочка");
        }
        else System.out.println("введен некорректный пол");
    }

    public String getSex(String sex) {
        return this.sex.equals("Male") ? "мальчик" : (this.sex.equals("Female") ? "девочка" : "пол неопределен");
    }

    public Child() {
        this.isMany = false;
        this.setDescr("ребенок");
    }

    public Child(int quant, Human mother, Human father) {
        this.isMany = true;
        this.quant = quant;
        this.setDescr("дети");
        this.mother = mother;
        this.father = father;
    }

    public Child(String name, Human mother, Human father) {
        this.isMany = false;
        this.setDescr("ребенок");
        this.setName(name);
        this.mother = mother;
        this.father = father;
    }

    public Child(String name) {
        this.isMany = false;
        this.setDescr("ребенок");
        this.setName(name);
    }

    public Child(int quant) {
        this.isMany = true;
        this.setDescr("дети");
    }

    public Child(String groupName, int quant) {
        this.isMany = true;
        this.setDescr(groupName);
    }
}
