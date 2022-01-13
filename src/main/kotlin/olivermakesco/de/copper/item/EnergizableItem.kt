package olivermakesco.de.copper.item

import net.minecraft.item.ItemStack
import olivermakesco.de.copper.energy.EnergyAbility

interface EnergizableItem {
    fun getEnergyAbilities(stack: ItemStack): ArrayList<EnergyAbility>
    fun addEnergyAbility(stack: ItemStack, ability: EnergyAbility) {
        val energyAbilities = getEnergyAbilities(stack)
        var combine = true
        for (a2 in energyAbilities)
            if (!ability.canCombine(a2)) {
                combine = false
                break
            }
        if (!combine) return
        energyAbilities.add(ability)
        setEnergyAbilities(stack,energyAbilities)
    }
    fun setEnergyAbilities(stack: ItemStack, abilities: ArrayList<EnergyAbility>)
    fun tickAll(stack: ItemStack) {
        val energyAbilities = getEnergyAbilities(stack)
        for (ability in energyAbilities)
            ability.tick()
        setEnergyAbilities(stack, energyAbilities)
    }

}