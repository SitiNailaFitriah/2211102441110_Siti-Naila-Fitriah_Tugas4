import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class objectspesial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class objectspesial extends Actor
{
    private int specialObjectDelay = 100;
    private int specialObjectCounter = 0;
    private GreenfootSound collectSound = new GreenfootSound("collectcoin.mp3");
    private int speed = 2;
    private boolean isCollected = false;
    
    public void objectspesial()
    {
        setImage("ObjectSpesial.png");
    }
    
    public void act() 
    {
        if (!isCollected) {
            checkForCollision();
            fall();
        } else {
            handleCollectedState();
        }
    }
    
    private void handleCollectedState() {
        int currentY = getY();
        if (currentY >= getWorld().getHeight() - 1) {
            isCollected = false;
            resetPosition();
        }
    }
    
    private void resetPosition() {
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
    }
    
    public void checkForCollision() {
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null) {
            isCollected = true;
            getWorld().removeObject(this);
            playCollectSound();
        }
    }
    
    public void fall() {
        int currentX = getX();
        int currentY = getY();
        if (atWorldEdge()) {
            getWorld().removeObject(this);
        } else {
            setLocation(currentX, currentY + speed);
        }
    }
    
    public boolean atWorldEdge() {
        return getY() >= getWorld().getHeight() - 1;
    }
    
    public void playCollectSound() {
        collectSound.play();
    }
}