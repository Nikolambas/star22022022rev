package com.star.app.game;

public class GameController {
    private Background background;
    private BulletController bulletController;
    private Hero hero;
    private AsteroidController asteroidController;

    public BulletController getBulletController() {
        return bulletController;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public Background getBackground() {
        return background;
    }

    public Hero getHero() {
        return hero;
    }

    public GameController() {
        this.background = new Background(this);
        this.bulletController = new BulletController();
        this.hero = new Hero(this);
        this.asteroidController = new AsteroidController();

    }

    public void update(float dt) {
        background.update(dt);
        bulletController.update(dt);
        hero.update(dt);
        asteroidController.update(dt);
        checkCollisions();
    }


    public void checkCollisions() {
        for (int i = 0; i < bulletController.getActiveList().size(); i++) {
            for (int j = 0; j < asteroidController.getAsteroids().size(); j++) {
                Bullet b = bulletController.getActiveList().get(i);
                Asteroid a = asteroidController.getAsteroids().get(j);
                if (a.getPosition().dst(b.getPosition()) < 112.0f){
                    b.deactivate();
                    a.reset();
                }
            }

        }
    }

}
