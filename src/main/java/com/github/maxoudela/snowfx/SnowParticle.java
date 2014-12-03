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

import java.util.Random;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Samir Hadzic
 */
class SnowParticle extends Circle {

    private static final double MAX_RADIUS = 7.0;
    private static final double MAX_STAGGER = 2.0;
    private final DoubleProperty x;
    private final DoubleProperty y;
    private final double radius;
    private final Color color;
    private final Random random = new Random();

    public SnowParticle(double initX) {
        x = new SimpleDoubleProperty(initX);
        y = new SimpleDoubleProperty(0.0);
        centerYProperty().bind(y);
        centerXProperty().bind(x);

        radius = random.nextDouble() * MAX_RADIUS;
        setRadius(radius);
        setMouseTransparent(true);
        color = Color.rgb(255, 255, 255, random.nextDouble());
        setFill(color);
    }

    public double update() {
        x.setValue(x.get() + (random.nextDouble() * MAX_STAGGER - MAX_STAGGER / 2.0));
        y.setValue(y.get() + (random.nextDouble() * MAX_STAGGER));
        return y.get();
    }
}
