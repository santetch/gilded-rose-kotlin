package com.gildedrose

import com.gildedrose.GildedRose.updateQuality
import org.junit.Assert.assertEquals
import org.junit.Test

class AgedBrieUpdateQualityTest {

    @Test
    fun increases_quality_the_older_it_gets() {
        val agedBrie = anAgredBrie().withSellIn(1)
                .withQuality(1)
                .build()

        updateQuality(arrayOf(agedBrie))
        assertEquals(agedBrie.quality, 2)
    }

    @Test
    fun never_increases_over_50() {
        val agedBrie = anAgredBrie().withSellIn(1)
                .withQuality(50)
                .build()

        updateQuality(arrayOf(agedBrie))
        assertEquals(agedBrie.quality, 50)
    }

    private fun anAgredBrie(): ItemBuilder {
        return ItemBuilder.anItem().withName("Aged Brie")
    }
}