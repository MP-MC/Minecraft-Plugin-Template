package ml.empee.templateplugin.controllers;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandMethod;
import lombok.RequiredArgsConstructor;
import ml.empee.ioc.Bean;
import ml.empee.templateplugin.config.CommandsConfig;
import ml.empee.templateplugin.utils.helpers.Logger;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public class PluginController implements Bean {

  private final CommandsConfig commandsConfig;
  private final Logger logger;

  @Override
  public void onStart() {
    commandsConfig.register(this);
  }

  @CommandMethod("echo <text> [target]")
  public void sendEcho(
    CommandSender sender,
    @Argument String text,
    @Argument @Nullable Player target
  ) {
    if (target != null) {
      sender = target;
    }

    logger.log(sender, text);
  }

}
