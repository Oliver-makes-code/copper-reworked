package olivermakesco.de.copper.item

import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import kotlin.random.Random

class CopperItem(settings: Settings) : SwordItem(CopperToolMaterial(), 3, -2.4f, settings), OxidizableItem {
    var random = Random((Math.random() * 100).toLong())

    override fun addOxidization(stack: ItemStack, amount: Int) {
        val nbt = stack.orCreateNbt
        var oxidization = if (nbt.contains("oxidization")) nbt.getInt("oxidization") else 0
        oxidization += amount
        nbt.putInt("oxidization", oxidization);
    }

    override fun getOxidization(stack: ItemStack): Int {
        val nbt = stack.orCreateNbt
        return if (nbt.contains("oxidization")) nbt.getInt("oxidization") else 0
    }

    override fun setOxidization(stack: ItemStack, amount: Int) {
        val nbt = stack.orCreateNbt
        nbt.putInt("oxidization", amount)
    }

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        if (random.nextLong(0,10) >= 7.5)
            stack?.let { addOxidization(it, 1) }

        return true
    }

    override fun isDamageable(): Boolean {
        return false
    }
}