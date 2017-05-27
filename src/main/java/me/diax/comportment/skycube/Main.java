/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.comportment.skycube;

import me.diax.comportment.skycube.command.SkyCubeCommandExecutor;
import me.diax.comportment.skycube.island.IslandManager;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by Comportment at 15:58 on 27/05/17 
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public final class Main extends JavaPlugin {

    private final Logger logger = this.getLogger();
    private static IslandManager manager;

    @Override
    public void onEnable() {
        logger.info("SkyCube enabling...");
        this.getCommand("skycube").setExecutor(new SkyCubeCommandExecutor());
        if (this.getServer().getWorld("SkyCube") == null) {
            manager = new IslandManager(this);
        } else {
            this.getServer().createWorld(new WorldCreator("SkyCube"));
            manager = new IslandManager(this);
        }
        logger.info("SkyCube has been enabled.");
    }

    @Override
    public void onDisable() {
        logger.info("SkyCube disabling...");
        logger.info("SkyCube has been disabled.");
    }

    public static IslandManager getManager() {
        return manager;
    }
}