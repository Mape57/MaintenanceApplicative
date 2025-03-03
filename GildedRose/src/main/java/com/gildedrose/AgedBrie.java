package com.gildedrose;

public class AgedBrie extends Item {

	public AgedBrie(int sellIn, int quality) {
		super(GildedRose.AGED_BRIE, sellIn, quality);
	}

	@Override
	public void update() {
		if (this.quality < 50) {
			this.quality = this.quality + 1;
		}

		this.sellIn = this.sellIn - 1;

		if (this.quality < 50) {
			this.quality = this.quality + 1;
		}
	}
}
