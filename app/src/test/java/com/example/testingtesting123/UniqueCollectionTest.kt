package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun getItem_ShouldReturnCorrectItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("Item2"))
        val item = collection.get(1)
        assertEquals("Item2", item.name)
    }

    @Test
    fun removeItem_ShouldRemoveItemAndReturnTrue_WhenItemExists() {
        val item = Item("Item1")
        collection.addItem(item)
        assertTrue("Item should be removed and return true", collection.remove(item))
        assertEquals(0, collection.size())
    }

    @Test
    fun removeItem_ShouldReturnFalse_WhenItemDoesNotExist() {
        val item = Item("Item1")
        collection.addItem(Item("Item2"))  // Add a different item
        assertFalse("Should return false as item does not exist", collection.remove(item))
        assertEquals(1, collection.size())  // Ensure the collection is unchanged
    }

    @Test
    fun removeItem_ShouldHandleMultipleItemsCorrectly() {
        val item1 = Item("Item1")
        val item2 = Item("Item2")
        collection.addItem(item1)
        collection.addItem(item2)
        assertTrue("Expected true when item is removed", collection.remove(item1))
        assertEquals(1, collection.size())
        assertEquals("Item2", collection.get(0).name)  // Ensure remaining item is Item2
    }
}