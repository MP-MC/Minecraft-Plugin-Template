package ml.empee.templateplugin.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import lombok.RequiredArgsConstructor;
import ml.empee.ioc.Bean;
import ml.empee.ioc.RegisteredListener;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

@RequiredArgsConstructor
public class TestListener implements RegisteredListener, Bean {

  private final JavaPlugin plugin;

  @EventHandler
  public void test(AsyncChatEvent event) {
    Bukkit.getScheduler().runTaskLater(
      plugin, () -> {
        Bukkit.getServer().audiences().forEach(a -> {
          a.deleteMessage(event.signedMessage());
          System.out.println("Deleted old message");
        });
      }, 20 * 4
    );
  }

}
