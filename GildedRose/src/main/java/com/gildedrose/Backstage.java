package com.gildedrose;

public class Backstage extends Item {
	public Backstage(int sellIn, int quality) {
		super(GildedRose.BACKSTAGE, sellIn, quality);
	}

	@Override
	public void update() {
		if (this.quality < 50) {
			this.quality = this.quality + 1;

			if (this.sellIn < 11) {
				this.quality = this.quality + 1;
			}

			if (this.sellIn < 6) {
				this.quality = this.quality + 1;
			}
		}

		this.sellIn = this.sellIn - 1;

		if (this.sellIn < 0) {
			this.quality = 0;
		}
	}
}
