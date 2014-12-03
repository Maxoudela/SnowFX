/**
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified copies of
 * this license document, and changing it is allowed as long as the name is
 * changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE TERMS AND CONDITIONS FOR COPYING,
 * DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package com.github.maxoudela.snowfx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This class will allow you to add some snow to your application.
 *
 * Simply give your {@link Pane} you want snow in into the constructor. Then
 * SnowFX will encapsulate your pane and you just have to add SnowFX at the
 * place where you wanted to place your {@link Pane}.
 *
 * You can then call {@link #showSnow(boolean) } in order to show/unshow the
 * snow. A quick call to {@link #isSnowing() } can indicate what is the current
 * state.
 *
 * @author Samir Hadzic
 */
public class SnowFX extends BorderPane {

    private final Pane pane;
    private final List<SnowParticle> particles = new ArrayList<>();
    private final Random random = new Random();
    private final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            update();
        }
    };

    /**
     * Give your Pane here and then just add SnowFX where you would have
     * normally added the given Pane.
     *
     * @param pane
     */
    public SnowFX(Pane pane) {
        this.pane = pane;
        setCenter(pane);
    }

    /**
     * Show or unshow the snow.
     *
     * @param value
     */
    public void showSnow(boolean value) {
        if (value && particles.isEmpty()) {
            initSnowParticle();
            timer.start();
        } else if (!value) {
            timer.stop();
            Iterator<SnowParticle> it = particles.iterator();
            while (it.hasNext()) {
                SnowParticle particle = it.next();
                it.remove();
                getChildren().remove(particle);
            }
        }
    }

    /**
     * Return whether it's currently snowing in your application.
     *
     * @return
     */
    public boolean isSnowing() {
        return !particles.isEmpty();
    }

    private void initSnowParticle() {

        int size = random.nextInt(5);
        for (int i = 0; i < size; i++) {
            SnowParticle particle = new SnowParticle(random.nextDouble() * pane.getWidth());
            particles.add(particle);
            getChildren().add(particle);
        }
    }

    private void update() {
        Iterator<SnowParticle> it = particles.iterator();
        while (it.hasNext()) {
            SnowParticle particle = it.next();
            double y = particle.update();
            if (y >= pane.getHeight()) {
                it.remove();
                getChildren().remove(particle);
            }
        }
        if (random.nextInt(3) == 0) {
            SnowParticle particle = new SnowParticle(random.nextDouble() * pane.getWidth());
            particles.add(particle);
            getChildren().add(particle);
        }
    }
}
