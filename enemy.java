import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    public enemy() {
        setImage("Enemy.gif");
    }

    public void act() {
        if (getWorld().getObjects(character.class).isEmpty()) {
            return;
        }

        followcharacter();
        checkCollisionWithcharacter();
    }

    private void followcharacter() {
        character character = (character) getWorld().getObjects(character.class).get(0);
        if (character != null) {
            int characterX = character.getX();
            int characterY = character.getY();
            int currentX = getX();
            int currentY = getY();

            int dx = characterX - currentX;
            int dy = characterY - currentY;

            double angle = Math.atan2(dy, dx);
            int speed = 2;

            int vx = (int) (speed * Math.cos(angle));
            int vy = (int) (speed * Math.sin(angle));

            setLocation(currentX + vx, currentY + vy);
        }
    }

    private void checkCollisionWithcharacter() {
        if (isTouching(character.class)) {
            showGameOver();
            Greenfoot.stop();
        }
    }

    private void showGameOver() {
        World world = getWorld();
        world.showText("Game Over", world.getWidth() / 2, world.getHeight() / 2);
    }
}
