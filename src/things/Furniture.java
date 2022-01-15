package things;

public class Furniture extends Thing{
    int quant;

    public Furniture() {
        this.isMany = false;
        this.setDescr("мебельный предмет");
    }

    public Furniture(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("мебельные предметы");
    }
}
