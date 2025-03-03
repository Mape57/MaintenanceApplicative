package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(int sellIn, int quality) {
        this.name = "foo";
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
   }

   public void update() {
       if (this.quality > 0) {
           this.quality = this.quality - 1;
       }

       this.sellIn = this.sellIn - 1;

       if (this.quality > 0) {
           this.quality = this.quality - 1;
       }
   }
}
