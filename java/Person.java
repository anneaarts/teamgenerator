/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgenerator;

/**
 *
 * @author Quintess
 */
public class Person {
    public enum Moon {PROSPIT, DERSE};
    private final Classpect cp;
    private final Moon moon;
    private final String land;
    
    public Person(Classpect cp, Moon moon, String land) {
        this.cp = cp;
        this.moon = moon;
        this.land = land;
    }
    
    @Override
    public String toString() {
        return cp + ", dreaming on " + moon + ", with the " + land;
    }
    
    
}
