package olivermakesco.de.copper.energy

import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

var energyAbilities = HashMap<Identifier,EnergyAbility>()

interface EnergyAbility {
    var cooldown: Int
    fun onBlockUse(context: ItemUsageContext): ActionResult
    fun onBlockBreak(stack: ItemStack, world: World, state: BlockState, pos: BlockPos, entity: LivingEntity): Boolean
    fun onEntityHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean
    fun tick() {
        cooldown--
    }
    fun canHave(other: EnergyAbility): Boolean {
        return other::class != this::class
    }
    fun canCombine(other: EnergyAbility): Boolean {
        return other.canHave(this) && this.canHave(other)
    }
}