import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    JFrame displayZoneFrame;
    RenderEngine renderEngine;//On a fait un Nullpointer, on a juste déclaré la variable
    GameEngine gameEngine; //
    PhysicEngine physicEngine;
    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DynamicSprite hero = new DynamicSprite(ImageIO.read(new File("./img/heroTileSheetLowRes.png")),200,300,48,50,Direction.NORTH,10,5,true);
        SimplePatternEnnemy ennemy = new SimplePatternEnnemy(ImageIO.read(new File("./img/heroTileSheetLowRes.png")),200,600,48,50,Direction.WEST,10,5,true);

        renderEngine = new RenderEngine(); // On est obligé de l'instancier pour s'en sevir
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer (50,(time) -> renderEngine.update()); // Je n'ai pas comprit le lambda
        Timer gameTimer= new Timer (50,(time) -> gameEngine.update());
        Timer physicTimer= new Timer (50,(time) -> physicEngine.update());

        renderTimer.start();
        gameTimer.start();
        physicTimer.start();

        displayZoneFrame.getContentPane().add(renderEngine);
        displayZoneFrame.setVisible(true);

        Playground level = new Playground("./data/level1.txt");
        //SolidSprite testSprite = new DynamicSprite(100,100,test,0,0);
        renderEngine.addToRenderList(level.getSpriteList());
        renderEngine.addToRenderList(hero);
        renderEngine.addToRenderList(ennemy);
        physicEngine.addToMovingSpriteList(hero);
        physicEngine.addToMovingSpriteList(ennemy);
        physicEngine.setEnvironment(level.getSolidSpriteList());

        displayZoneFrame.addKeyListener(gameEngine);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

    }
}