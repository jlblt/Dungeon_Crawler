import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine{
    private ArrayList<Displayable> Renderlist;

    public RenderEngine(){
        this.Renderlist = new ArrayList<>();
    }

    public void update(){
        repaint();
    }

    public void setRenderlist(ArrayList<Displayable> Renderlist){
        this.Renderlist = Renderlist;
    }

    public void addToRenderList(Displayable displayable){ //Permet le cloisonnement des objets (car private)
        this.Renderlist.add(displayable);
    }
    public void addToRenderList(ArrayList<Displayable> displayable){
        if (!Renderlist.contains(displayable)){
            Renderlist.addAll(displayable);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Renderlist.forEach(render -> render.draw(g));
    }
}
