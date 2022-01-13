package olivermakesco.de.copper

import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback
import net.minecraft.client.texture.SpriteAtlasHolder
import net.minecraft.client.util.ModelIdentifier
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import olivermakesco.de.copper.item.copperSword
import olivermakesco.de.copper.item.energizedCopperIngot
import org.apache.logging.log4j.LogManager

val logger = LogManager.getLogger("copper_reworked")

val itemIdentifiers = ArrayList<ModelIdentifier>()

@SuppressWarnings("UNUSED")
fun init() {
    logger.info("Initializing Copper Reworked!")

    addItem(energizedCopperIngot, id("energized_copper_ingot"))
    addItem(copperSword, id("copper_sword"))

    logger.info("Copper Reworked initialized!")
}

fun addItem(item: Item, id: Identifier) {
    itemIdentifiers.add(ModelIdentifier(id.namespace,id.path,"inventory"))
    Registry.register(Registry.ITEM, id, item)
}

fun id(name: String): Identifier {
    return Identifier("copper_reworked", name)
}
