package olivermakesco.de.copper

import net.minecraft.item.ItemStack

interface OxidizableItem {
    fun getOxidization(stack:ItemStack): Int {
        return 0
    }
    fun addOxidization(stack:ItemStack, amount: Int)
}
