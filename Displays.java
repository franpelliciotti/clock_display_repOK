import java.util.ArrayList;
/**
 * Encapsula una lista de objetos de tipo ClockDisplay.
 */
public class Displays
{
    private ArrayList<ClockDisplay> displays;
    
    public Displays(){
        displays = new ArrayList<ClockDisplay>();
    }
    
    public void addHour(ClockDisplay hour){
        displays.add(hour);
    }
    
    /**
     * Computa la hora máxima en los objetos de tipo ClockDisplay
     * de la lista, siempre que ésta cuente con al menos un
     * ClockDisplay almacenado en la lista.
     */
    public int maxHour() {
        assert displays.size() > 0;
        int max = displays.get(0).getHour();
        for(ClockDisplay display: displays){
            if(display.getHour() > max){
                max = display.getHour();
            }
        }
        return max;
    }
    
    public int maxHour2() {
        assert displays.size() > 0;
        int max = displays.get(0).getHour();
        int i = 1;
        while (i < displays.size()){
            if(displays.get(i).getHour() > max){
                max = displays.get(i).getHour();
            }
            i = i + 1;
        }
        return max;
    }
}
