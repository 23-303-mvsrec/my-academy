package ex;

public class Product {
    private String pid;
    private double price;
    private int qty;
    private double disc;
    //private double finalPrice;

     public String getPid() { 
        return pid;
     }

    public void setPid(String x) {
        pid = x;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int y) {
    qty= y; }

    public double getDisc() {
        return disc;
    }

    public void setDisc(double z) {
        disc = z;
    }

    public double getFinalPrice() {
        return (price * qty) * ((100 - disc) / 100.0);
    }
}