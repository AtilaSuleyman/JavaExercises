package Intermediate;

public class Paint {

    private String name;
    private int amountInLitres;
    private int coveragePerLitre;
    private double price;

    public Paint(String name, int amountInLitres, int coveragePerLitre, double price){
        this.name = name;
        this.amountInLitres = amountInLitres;
        this.coveragePerLitre = coveragePerLitre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(int amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public int getCoveragePerLitre() {
        return coveragePerLitre;
    }

    public void setCoveragePerLitre(int coveragePerLitre) {
        this.coveragePerLitre = coveragePerLitre;
    }

    @Override
    public String toString() {
        return "Paint{" +
                "name='" + name + '\'' +
                ", amountInLitres=" + amountInLitres +
                ", coveragePerLitre=" + coveragePerLitre +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
