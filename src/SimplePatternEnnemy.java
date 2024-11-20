import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SimplePatternEnnemy extends DynamicSprite{
    public SimplePatternEnnemy(Image image, double x, double y, double width, double height, Direction direction, int timeBetweenFrame, double speed, boolean isWalking) {
        super(image, x, y, width, height, direction, timeBetweenFrame, speed, isWalking);
    }
    public void checkAndSwitchDirection(ArrayList<Sprite> environment){
        if(direction == Direction.EAST && !isMovingPossible(environment)){
            this.SetDirection(Direction.WEST);
        }
        else if(direction == Direction.WEST && !isMovingPossible(environment)){
            this.SetDirection(Direction.EAST);
        }
    }

    @Override
    public void moveIfPossible(ArrayList<Sprite> environment) {
        super.moveIfPossible(environment);
        checkAndSwitchDirection(environment);
    }
}
