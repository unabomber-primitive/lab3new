package things;

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
}
