import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(800, 600, 1);
        prepare();
    }
    private int spesialObjectDelay = 100;
    private int spesialObjectCounter = 0;
    private int score = 0;
    public void act() {
        if (score >= 100) {
            showText("You Win!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }

    public void prepare() {
        // Add initialization of objects and main characters for the first level here
        addObject(new character(), getWidth() / 2, getHeight() - 100);
        addObject(new enemy(), getWidth() / 30, getHeight() + - 10);
        addObject(new objectspesial(),
        Greenfoot.getRandomNumber(getWidth()), 
        Greenfoot.getRandomNumber(getHeight()));

        // Add more objects or characters for the first level here
    }

    public void nextLevel() {
        if (score >= 100) {
            showText("You Win!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        } else {
            removeObjects(getObjects(objectspesial.class));
            prepare();
        }
    }
    
    public void addScore() {
        score++;
    }
}
