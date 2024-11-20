import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite {
    private boolean isWalking;
    private double speed = 5;
    private final int spriteSheetNumberOfColumns = 10;
    private int timeBetweenFrame = 200;
    protected Direction direction;

    public DynamicSprite(Image image, double x, double y, double width, double height, Direction direction, int timeBetweenFrame, double speed, boolean isWalking) {
        super(image, x, y, width, height);
        this.direction = direction;
        this.timeBetweenFrame = timeBetweenFrame;
        this.speed = speed;
        this.isWalking = isWalking;
    }

    public void SetDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g) {
        long index = (System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumns;
        int attitude = direction.getFrameLineNumber();
        g.drawImage(image, (int) x, (int) y, (int) (x + width), (int) (y + height), (int) (index * width), (int) (attitude * height), (int) ((index + 1) * width), (int) ((attitude + 1) * height), null);
    }

    private void move() {
        switch (direction) {
            case NORTH -> y -= speed;
            case SOUTH -> y += speed;
            case EAST -> x += speed;
            case WEST -> x -= speed;
        }
    }

    protected boolean isMovingPossible(ArrayList<Sprite> environment){
        Rectangle2D hitbox;
        switch (direction) {
            case NORTH -> hitbox = new Rectangle2D.Double(x, y - speed, width, height);
            case EAST -> hitbox = new Rectangle2D.Double(x + speed, y, width, height);
            case SOUTH -> hitbox = new Rectangle2D.Double(x, y + speed, width, height);
            case WEST -> hitbox = new Rectangle2D.Double(x - speed, y, width, height);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        for (Sprite sprite : environment) {
            Rectangle2D hitboxSprite;
            hitboxSprite = new Rectangle2D.Double(sprite.x, sprite.y, sprite.width, sprite.height);
            if(hitbox.intersects(hitboxSprite) &&  !sprite.equals(this) && sprite instanceof SolidSprite){
                return false;
            }
        }
        return true;
    }

    public void moveIfPossible(ArrayList<Sprite> environment) {
    if (isMovingPossible(environment)) {
        move();
    }
    }
}