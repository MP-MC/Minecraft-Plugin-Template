package ml.empee.templateplugin.controllers;

import lombok.SneakyThrows;
import ml.empee.commandsManager.CommandManager;
import ml.empee.commandsManager.command.CommandExecutor;
import ml.empee.commandsManager.command.annotations.CommandNode;
import ml.empee.ioc.Bean;
import ml.empee.templateplugin.Permissions;
import ml.empee.templateplugin.utils.helpers.Logger;
import org.bukkit.entity.Player;

/** Controller used for managing the plugin. **/

@CommandNode(label = "demo", permission = Permissions.ADMIN)
public class PluginController extends CommandExecutor implements Bean {

  private final Logger logger;

  /** IoC Constructor **/
  public PluginController(CommandManager commandManager, Logger logger) {
    this.logger = logger;

    commandManager.registerCommand(this);
  }

  /**
   * Demo endpoint
   */
  @SneakyThrows
  @CommandNode(label = "demo")
  public void demo(Player player) {
    logger.info(player, "Hello World!");
  }

}
