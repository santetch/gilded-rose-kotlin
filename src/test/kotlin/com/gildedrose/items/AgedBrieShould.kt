package com.gildedrose.items

import com.gildedrose.GildedRoseKata
import com.gildedrose.Item
import com.gildedrose.doubles.ItemBuilder
import org.junit.Assert.*
import org.junit.Test

class AgedBrieShould {
    private lateinit var agedBrie: Item
    private lateinit var gildedRose: GildedRoseKata

    @Test
    fun `increase quality over the days`() {
        agedBrie = ItemBuilder()
                .withName("Aged Brie")
                .withQuality(1)
                .withSellIn(1)
                .build()

        givenAGildedRose()

        whenUpdateQuality(agedBrie)

        thenIncreaseQualityInOne()
    }

    @Test
    fun `increase quality over the days even with sell in 0`() {
        agedBrie = ItemBuilder()
                .withName("Aged Brie")
                .withQuality(1)
                .withSellIn(0)
                .build()

        givenAGildedRose()

        whenUpdateQuality(agedBrie)

        thenIncreaseQualityInTwo()
    }

    @Test
    fun `not increase quality over 50`() {
        agedBrie = ItemBuilder()
                .withName("Aged Brie")
                .withQuality(50)
                .withSellIn(1)
                .build()

        givenAGildedRose()

        whenUpdateQuality(agedBrie)

        thenNotIncreaseOverFifty()
    }

    @Test
    fun `not increase quality over 50 even with sell in 0`() {
        agedBrie = ItemBuilder()
                .withName("Aged Brie")
                .withQuality(50)
                .withSellIn(0)
                .build()

        givenAGildedRose()

        whenUpdateQuality(agedBrie)

        thenNotIncreaseOverFifty()
    }

    private fun givenAGildedRose() {
        gildedRose = GildedRoseKata()
    }

    private fun whenUpdateQuality(agedBrie: Item) {
        gildedRose.updateQuality(arrayOf(agedBrie))
    }

    private fun thenIncreaseQualityInOne() {
        assertEquals(2, agedBrie.quality)
    }

    private fun thenNotIncreaseOverFifty() {
        assertEquals(50, agedBrie.quality)
    }

    private fun thenIncreaseQualityInTwo() {
        assertEquals(3, agedBrie.quality)
    }
}
