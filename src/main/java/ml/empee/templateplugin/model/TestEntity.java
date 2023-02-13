package ml.empee.templateplugin.model;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_19_R2.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

/** A custom entity **/

public class TestEntity extends Skeleton {

  private final CraftWorld world;

  /** Spawn a TestEntity at the given location **/
  public static TestEntity spawn(Location location) {
    TestEntity testEntity = new TestEntity(location);
    testEntity.spawn();
    return testEntity;
  }

  private TestEntity(Location location) {
    super(
        EntityType.SKELETON, ((CraftWorld) location.getWorld()).getHandle().getLevel()
    );

    absMoveTo(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    setYHeadRot(location.getPitch());

    this.world = (CraftWorld) location.getWorld();
  }

  /** {@inheritDoc} **/
  @Override
  public void tick() {

  }

  private void spawn() {
    world.addEntity(this, SpawnReason.CUSTOM);
  }

}
