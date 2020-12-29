package com.gildedrose.items

import com.gildedrose.GildedRoseKata
import com.gildedrose.Item
import com.gildedrose.doubles.ItemBuilder
import org.junit.Assert.*
import org.junit.Test

class SulfurasShould {
    private lateinit var sulfuras: Item
    private lateinit var gildedRose: GildedRoseKata

    @Test
    fun `not be sold`() {
        sulfuras = ItemBuilder()
                .withName("Sulfuras, Hand of Ragnaros")
                .withQuality(1)
                .withSellIn(1)
                .build()

        givenAGildedRose()

        whenUpdateQuality(sulfuras)

        thenNotDecreaseSellIn()
    }

    @Test
    fun `not decrease quality`() {
        sulfuras = ItemBuilder()
                .withName("Sulfuras, Hand of Ragnaros")
                .withQuality(1)
                .withSellIn(1)
                .build()

        givenAGildedRose()

        whenUpdateQuality(sulfuras)

        thenNotDecreaseQuality()
    }

    private fun givenAGildedRose() {
        gildedRose = GildedRoseKata()
    }

    private fun whenUpdateQuality(sulfuras: Item) {
        gildedRose.updateQuality(arrayOf(sulfuras))
    }

    private fun thenNotDecreaseSellIn() {
        assertEquals(1, sulfuras.sellIn)
    }

    private fun thenNotDecreaseQuality() {
        assertEquals(1, sulfuras.quality)
    }


}