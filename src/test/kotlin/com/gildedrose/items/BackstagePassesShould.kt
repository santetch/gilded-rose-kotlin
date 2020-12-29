package com.gildedrose.items

import com.gildedrose.GildedRoseKata
import com.gildedrose.Item
import com.gildedrose.doubles.ItemBuilder
import org.junit.Assert.*
import org.junit.Test

class BackstagePassesShould {
    private lateinit var backstagePass: Item
    private lateinit var gildedRose: GildedRoseKata
    @Test
    fun `increase quality in 1 when sell in is greater than 10`() {
        backstagePass = ItemBuilder()
                .withName("Backstage passes to a TAFKAL80ETC concert")
                .withQuality(1)
                .withSellIn(11)
                .build()

        givenAGildedRose()

        whenUpdateQuality(backstagePass)

        thenIncreasesQualityInOne(backstagePass)
    }

    @Test
    fun `increase quality in 2 when sell in is greater than 5 and less than 11`() {
        backstagePass = ItemBuilder()
                .withName("Backstage passes to a TAFKAL80ETC concert")
                .withQuality(1)
                .withSellIn(7)
                .build()

        givenAGildedRose()

        whenUpdateQuality(backstagePass)

        thenIncreasesQualityInTwo(backstagePass)
    }

    @Test
    fun `increase quality in 3 when sell in is less than 5`() {
        backstagePass = ItemBuilder()
                .withName("Backstage passes to a TAFKAL80ETC concert")
                .withQuality(1)
                .withSellIn(3)
                .build()

        givenAGildedRose()

        whenUpdateQuality(backstagePass)

        thenIncreasesQualityInThree(backstagePass)
    }

    @Test
    fun `decrease quality to 0 when sell in is less than 0`() {
        backstagePass = ItemBuilder()
                .withName("Backstage passes to a TAFKAL80ETC concert")
                .withQuality(1)
                .withSellIn(0)
                .build()

        givenAGildedRose()

        whenUpdateQuality(backstagePass)

        thenDecreaseQualityToZero(backstagePass)
    }

    @Test
    fun `not increase quality over 50`() {
        backstagePass = ItemBuilder()
                .withName("Backstage passes to a TAFKAL80ETC concert")
                .withQuality(50)
                .withSellIn(2)
                .build()

        givenAGildedRose()

        whenUpdateQuality(backstagePass)

        thenNotIncreaseOverFifty(backstagePass)
    }

    private fun givenAGildedRose() {
        gildedRose = GildedRoseKata()
    }

    private fun whenUpdateQuality(backstagePass: Item) {
        gildedRose.updateQuality(arrayOf(backstagePass))
    }

    private fun thenIncreasesQualityInOne(backstagePass: Item) {
        assertEquals(2, backstagePass.quality)
    }

    private fun thenIncreasesQualityInTwo(backstagePass: Item) {
        assertEquals(3, backstagePass.quality)
    }

    private fun thenIncreasesQualityInThree(backstagePass: Item) {
        assertEquals(4, backstagePass.quality)
    }

    private fun thenDecreaseQualityToZero(backstagePass: Item) {
        assertEquals(0, backstagePass.quality)
    }

    private fun thenNotIncreaseOverFifty(backstagePass: Item) {
        assertEquals(50, backstagePass.quality)
    }
}
