package olivermakesco.de.copper.item

import net.minecraft.item.ItemStack

interface OxidizableItem {
    fun getOxidization(stack:ItemStack):Int {
        return 0
    }
    fun addOxidization(stack:ItemStack, amount:Int)
    fun setOxidization(stack:ItemStack, amount:Int)
}
