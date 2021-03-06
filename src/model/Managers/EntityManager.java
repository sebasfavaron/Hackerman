package model.Managers;

import model.entity.Entity;
import model.entity.dynamicEntity.character.PlayerCharacter;
import model.entity.dynamicEntity.character.enemyCharacter.EnemyCharacter;
import model.entity.staticEntity.Obstacle;
import model.entity.staticEntity.interactiveStaticEntity.Computer;
import model.entity.staticEntity.interactiveStaticEntity.Door;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscosanguineti on 31/5/17.
 */
public class EntityManager {

    private PlayerCharacter player;
    private Door door;
    private List<EnemyCharacter> enemies;
    private List<Computer> computers;
    private List<Obstacle> obstacles;

    public EntityManager(PlayerCharacter player, Door door, List<EnemyCharacter> enemies, List<Computer> computers, List<Obstacle> obstacles) {
        this.player = player;
        this.door = door;
        this.enemies = enemies;
        this.computers = computers;
        this.obstacles = obstacles;
    }

    public void tick() {
        player.tick();                  //chequear si no esta en pausa
        for(EnemyCharacter enemy: enemies) {
            enemy.tick();
        }
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public Door getDoor() {
        return door;
    }

    public List<EnemyCharacter> getEnemies() {
        return enemies;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void addEnemy(EnemyCharacter enemy) {
        enemies.add(enemy);
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(player);
        entities.add(door);
        entities.addAll(enemies);
        entities.addAll(computers);
        entities.addAll(obstacles);
    }
}
