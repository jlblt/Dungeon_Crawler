import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener {
    private final DynamicSprite hero;

    public GameEngine(DynamicSprite hero) {
        this.hero = hero;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Change la direction du Sprite en fonction de la touche appuié
     * @param e the event to be processed
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                hero.SetDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.SetDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.SetDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
               hero.SetDirection(Direction.EAST);
               break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void update() {

    }
}
