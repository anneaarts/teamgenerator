/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgenerator;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Quintess
 */
public class LandGenerator {

    private HashMap<Classpect.Aspect, String[]> aspectTerms;
    private String[] otherWords;

    public LandGenerator() {
        generateAspectWords();
    }

    public String getLand(Classpect c) {
        Random rand = new Random();
        int indexOther = rand.nextInt(otherWords.length);
        String otherWord = otherWords[indexOther].toUpperCase();

        String[] terms = aspectTerms.get(c.getA());
        int indexAspect = rand.nextInt(terms.length);
        String aspectTerm = terms[indexAspect].toUpperCase();

        if (indexAspect % 2 == 0) {
            return "land of " + otherWord + " and " + aspectTerm;
        } else {
            return "land of " + aspectTerm + " and " + otherWord;
        }
    }

    private void generateAspectWords() {
        aspectTerms = new HashMap();

        String[] Time = new String[]{"Ticking", "Sundials", "Clockworks", "Pendulums",
            "Quartz", "Rhythm", "Passing", "Dusk"};
        aspectTerms.put(Classpect.Aspect.TIME, Time);

        String[] Space = new String[]{"Frogs"};
        aspectTerms.put(Classpect.Aspect.SPACE, Space);

        String[] Blood = new String[]{"Blood", "Magnets", "Iron", "Shackles", "Connection",
            "Ties", "Pulse", "Promise"};
        aspectTerms.put(Classpect.Aspect.BLOOD, Blood);

        String[] Breath = new String[]{"Wind", "Windmills", "Flight", "Distance",
            "Balloons", "Feathers"};
        aspectTerms.put(Classpect.Aspect.BREATH, Breath);

        String[] Life = new String[]{"Vines", "Dew", "Lush", "Vitality", "Roots", "Defiance",
            "Abundance", "Plenty", "Wealth"};
        aspectTerms.put(Classpect.Aspect.LIFE, Life);

        String[] Doom = new String[]{"Alleys", "Mazes", "Decay", "Endings", "Acceptance",
            "Regulation"};
        aspectTerms.put(Classpect.Aspect.DOOM, Doom);

        String[] Void = new String[]{"Mist", "Obscurity", "Shade", "Locks", "Dark",
            "Riddles", "Mystery"};
        aspectTerms.put(Classpect.Aspect.VOID, Void);

        String[] Light = new String[]{"Candles", "Light", "Fortune", "Illuminescence",
            "Transparancy", "Clarity", "Glass", "Truth"};
        aspectTerms.put(Classpect.Aspect.LIGHT, Light);

        String[] Hope = new String[]{"Angels", "Faith", "Belief", "Bells", "Piety",
            "Blindness", "Prayer", "Hymns"};
        aspectTerms.put(Classpect.Aspect.HOPE, Hope);

        String[] Rage = new String[]{"Wrath", "Suspicion", "Specters", "Fear", "Tunnels",
            "Rejection", "Animosity", "Whispers"};
        aspectTerms.put(Classpect.Aspect.RAGE, Rage);

        String[] Heart = new String[]{"Sugar", "Essence", "Heart", "Warmth", "Windows",
            "Soul", "Home"};
        aspectTerms.put(Classpect.Aspect.HEART, Heart);

        String[] Mind = new String[]{"Thought", "Lightning", "Mind", "Sparks", "Impulse",
            "Masks"};
        aspectTerms.put(Classpect.Aspect.MIND, Mind);

        otherWords = new String[]{"Towers", "Doors", "Stairs", "Bridges", "Windows",
            "Ink", "Paint", "Waterfalls", "Glue", "Tea", "Oil", "Ponds", "Coffee",
            "Marvel", "Mirth", "Sighs", "Celebration", "Ponderance", "Silence",
            "Marble", "Gold", "Crystal", "Sand", "Cloth", "Wool", "Silk", "Rubber",
            "Silver", "Bronze", "Paper", "Cotton", "Coal",
            "Rain", "Hail", "Snow", "Drizzle", "Storms", "Dawn", "Rays", "Heat",
            "Frost", "Fog",
            "Peaks", "Shallows", "Dunes", "Rifts", "Cliffs", "Caves", "Reefs",
            "Maps", "Cups", "Lanterns", "Scrolls", "Cards", "Disks", "Statues",
            "Mirrors", "Curtains"};
    }

}
