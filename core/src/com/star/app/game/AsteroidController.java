package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.game.helpers.ObjectPool;

import java.util.ArrayList;

public class AsteroidController {
    private Texture textureAsteroid;
    private ArrayList<Asteroid>asteroids;

    public ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }

    public AsteroidController() {
        this.textureAsteroid=new Texture("asteroid.png");
        asteroids=new ArrayList<>();

    }

    public void update(float dt){
        if (asteroids.size()<5){
            asteroids.add(new Asteroid());
        }
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).update(dt);
        }

    }


    public void render(SpriteBatch batch){
        for (int i = 0; i < asteroids.size(); i++) {
            Asteroid a = asteroids.get(i);
            batch.draw(textureAsteroid, a.getPosition().x-128 , a.getPosition().y-128 , 128, 128,
                    256, 256, 1, 1, a.getAngel(), 0, 0, 256, 256,
                    false, false);
        }


    }
}
