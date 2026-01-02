package com.duyanhggg.blockminer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Custom mining tool item that provides mining speed bonuses
 */
public class BlockMinerItem extends Item {
	private static final float MINING_SPEED_MULTIPLIER = 8.0f;

	public BlockMinerItem(Settings settings) {
		super(settings.attributeModifiers(createAttributeModifiers()));
	}

	/**
	 * Create attribute modifiers for the tool
	 * Adds mining speed bonus when held
	 */
	private static AttributeModifiersComponent createAttributeModifiers() {
		return AttributeModifiersComponent.builder()
			.add(
				EntityAttributes.PLAYER_BLOCK_BREAK_SPEED,
				new EntityAttributeModifier(
					Identifier.of(BlockMinerMod.MOD_ID, "mining_speed"),
					MINING_SPEED_MULTIPLIER,
					EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
				),
				AttributeModifierSlot.MAINHAND
			)
			.build();
	}

	@Override
	public float getMiningSpeed(ItemStack stack, BlockState state) {
		// Check if the block can be mined efficiently with this tool
		if (isSuitableFor(state)) {
			return 15.0f; // Fast mining speed
		}
		return 1.0f; // Default speed
	}

	@Override
	public boolean isSuitableFor(BlockState state) {
		// This tool is effective on most mineable blocks
		return state.isIn(BlockTags.PICKAXE_MINEABLE) ||
			   state.isIn(BlockTags.SHOVEL_MINEABLE) ||
			   state.isIn(BlockTags.AXE_MINEABLE);
	}

	@Override
	public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
		return true;
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		// Damage the item when used to hit entities
		stack.damage(2, attacker, EquipmentSlot.MAINHAND);
		return true;
	}

	@Override
	public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
		// Damage the item when mining blocks
		if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
			stack.damage(1, miner, EquipmentSlot.MAINHAND);
		}
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		// Add custom tooltip information
		tooltip.add(Text.translatable("item.blockminer.block_miner.tooltip.line1")
			.formatted(Formatting.GRAY));
		tooltip.add(Text.translatable("item.blockminer.block_miner.tooltip.line2")
			.formatted(Formatting.GRAY));
		tooltip.add(Text.literal("Mining Speed: +" + (int)(MINING_SPEED_MULTIPLIER * 100) + "%")
			.formatted(Formatting.GOLD));
	}
}
