package ps.lambda.patterns.ch4;

import ps.lambda.patterns.model.Circle;

import java.awt.*;

public class CircleMain {

    public static void main(String[] args) {
        Factory<Circle> fc1 = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> fc2 = Factory.createFactory(Circle::new);

    }

}
