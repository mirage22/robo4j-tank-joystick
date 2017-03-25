/*
 * Copyright (c) 2014, 2017, Marcus Hirt, Miroslav Wengner
 *
 * Robo4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robo4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robo4J. If not, see <http://www.gnu.org/licenses/>.
 */

package com.robo4j.joystick.tank.layout;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
public class Joystick extends Group {
	private Canvas canvas;
	private Circle pov;
	private IntegerProperty levelsProperty;
	private DoubleProperty radiusProperty;

	public Joystick(final double radius, final int levelNumber) {
		levelsProperty = new SimpleIntegerProperty(levelNumber);
		radiusProperty = new SimpleDoubleProperty(radius);
		pov = new Circle(0, Color.BLACK);
		canvas = new Canvas(radius * 2, radius * 2);
		getChildren().addAll(canvas, pov);
		new JoystickController(this);
	}

	public Circle getPov() {
		return pov;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public int getLevels() {
		return levelsProperty.get();
	}

	public double getRadius() {
		return radiusProperty.get();
	}

	public DoubleProperty radiusProperty() {
		return radiusProperty;
	}

	public IntegerProperty levelsProperty() {
		return levelsProperty;
	}
}
