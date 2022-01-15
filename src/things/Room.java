package things;

public class Room extends Thing{
    int quant;

    public Room() {
        this.isMany = false;
        this.setDescr("комната");
    }

    public Room(int quant) {
        this.quant = quant;
        this.isMany = true;
        this.setDescr("комнаты");
    }
}
