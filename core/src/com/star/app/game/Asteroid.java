package com.star.app.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;

import javax.xml.crypto.Data;

import java.util.Timer;

import static com.star.app.screen.ScreenManager.SCREEN_HEIGHT;
import static com.star.app.screen.ScreenManager.SCREEN_WIDTH;

public class Asteroid {
    private Vector2 position;
    private Vector2 velocity;
    private float angel;

    public float getAngel() {
        return angel;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Asteroid() {
        this.position=new Vector2(SCREEN_WIDTH, MathUtils.random(256, SCREEN_HEIGHT-256));
        this.velocity=new Vector2(MathUtils.random(-40, -20), MathUtils.random(-20,20));
        this.angel=0.0f;

    }



    public void update(float dt) {
        position.mulAdd(velocity,dt);
        if (position.x < -256) {
            position.x = SCREEN_WIDTH + 256;
        }
        if (position.y<-256){
            position.y=SCREEN_HEIGHT+256;
        }if (position.y> SCREEN_HEIGHT+256){
            position.y=-256;
        }

    }

    public void reset() {
        velocity.x=MathUtils.random(-40, -20);
        velocity.y=MathUtils.random(-20,20);
        position.x=SCREEN_WIDTH;
    }


}
