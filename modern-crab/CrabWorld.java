import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    public final int TIEMPO_NIVEL = 15;
    private Counter contGusanos;
    private Counter contVidas;
    private Crab cangrejo;
    private Lobster langosta;
    private Counter conTiempo;
    private SimpleTimer reloj;

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1);
        contGusanos = new Counter("Gusanos: ");
        addObject(contGusanos, 64, 20);
        contVidas = new Counter("Vidas: ");
        addObject(contVidas, 480, 20);
        prepare();
        conTiempo.setValue(TIEMPO_NIVEL);
        reloj = new SimpleTimer();
    }

    
    public void started()
    {
        reloj.mark();
        System.out.println("Boton Run presionado");
    }
    
    public void stopped()
    {
        System.out.println("Boton Pause presionado");
    }
    
    public void act()
    {
        contGusanos.act();
        contVidas.act();
        tiempoAcabado();
        if(reloj.millisElapsed() > 1000)
        {
           conTiempo.add(-1);
           reloj.mark();
        }
    }
    
    public void cangrejoAtrapado()
    {
        restaVidas();
        langosta.setLocation(20, 30);
        cangrejo.setLocation(250, 250);
        if(contVidas.getValue() == 0)
        {
              Label etiquetaFin = new Label("GAME OVER :v", 75);
              addObject(etiquetaFin, 250, 250);
              Greenfoot.stop();
        }
    }
    
    public void ganaste()
    {
        List lista = getObjects(Worm.class);
        if(lista.size()==0)
           {
                Label etiquetaGana = new Label("GANASTE!!! :3", 50);
                addObject(etiquetaGana, 250, 250);
                Greenfoot.stop();
           }
    }
    

    public void incrementaGusanos()
    {
        contGusanos.add(1);
        //counter.add(1);
    }
    
    public void restaVidas()
    {
        contVidas.add(-1);
    }
    
    public void tiempoAcabado()
    {
        if(conTiempo.getValue() <= 0)
        {
          Label etiquetaTiempo = new Label("SE ACABO EL TIEMPO XD", 40);
          addObject(etiquetaTiempo, 250, 250);
          Greenfoot.stop();
        }
    }
    
    public void reiniciaPosCangrejo()
    {
       cangrejo.setLocation(250, 250);   
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        contVidas.setValue(3);
        Worm worm = new Worm();
        addObject(worm,506,258);
        Worm worm2 = new Worm();
        addObject(worm2,276,115);
        Worm worm3 = new Worm();
        addObject(worm3,152,384);
        Worm worm4 = new Worm();
        addObject(worm4,397,483);
        Worm worm5 = new Worm();
        addObject(worm5,424,365);
        Worm worm6 = new Worm();
        addObject(worm6,348,325);
        Worm worm7 = new Worm();
        addObject(worm7,66,206);
        Worm worm8 = new Worm();
        addObject(worm8,67,206);
        Worm worm9 = new Worm();
        addObject(worm9,246,165);
        Worm worm10 = new Worm();
        addObject(worm10,357,163);
        Worm worm11 = new Worm();
        addObject(worm11,377,163);
        Worm worm12 = new Worm();
        addObject(worm12,392,157);
        Worm worm13 = new Worm();
        addObject(worm13,507,86);
        Worm worm14 = new Worm();
        addObject(worm14,140,477);
        Worm worm15 = new Worm();
        addObject(worm15,38,449);
        Worm worm16 = new Worm();
        addObject(worm16,169,269);
        Worm worm17 = new Worm();
        addObject(worm17,159,87);
        Worm worm18 = new Worm();
        addObject(worm18,356,43);
        cangrejo = new Crab();
        addObject(cangrejo,285,254);
        conTiempo = new Counter("Tiempo: ");
        addObject(conTiempo, 250, 24);
        langosta = new Lobster();
        addObject(langosta,248,421);   
    }
}
