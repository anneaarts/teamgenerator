/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

/**
 *
 * @author Quintess
 */
public class Team {

    public Team() {

    }

    public Person[] generateRandomTeam(int i) {
        Classpect[] cps = generateRandomTeamClasspects(i);
        Person.Moon [] moons = getRandomMoonList(i);
        Person [] team = new Person[i];
        String land;
        LandGenerator lg = new LandGenerator();
        for(int j = 0; j < i; j ++) {
            land = lg.getLand(cps[j]);
            team[j] = new Person(cps[j], moons[j], land);
        }
        
        return team;
    }

    private Classpect[] generateRandomTeamClasspects(int i) {
        if (i < 2 || i > 12 || i%2 != 0) {
            return null;
        }

        int actives = 0;
        int passives = 0;

        ArrayList<Classpect.Aspect> remainingAspects = new ArrayList(EnumSet.allOf(Classpect.Aspect.class));
        ArrayList<Classpect.Class> remainingClasses = new ArrayList(EnumSet.allOf(Classpect.Class.class));
        Classpect[] classpects = new Classpect[i];

        Classpect.Class tempClass;
        Classpect.Aspect tempAspect;
        for (int j = 0; j < i; j++) {
            if (j < 2) {
                tempAspect = remainingAspects.get(0);
            } else {
                tempAspect = getRandomAspect(remainingAspects);
            }
            tempClass = getRandomClass(remainingClasses);

            //Ensuring same amount of actives and passives
            if (tempClass.getActPas() == Classpect.ActPas.ACTIVE) {
                actives++;
            } else {
                passives++;
            }
            if (actives > i / 2) {
                while (tempClass.getActPas() != Classpect.ActPas.PASSIVE) {
                    tempClass = getRandomClass(remainingClasses);
                }
                actives--;
                passives++;
            }
            if (passives > i / 2) {
                while (tempClass.getActPas() != Classpect.ActPas.ACTIVE) {
                    tempClass = getRandomClass(remainingClasses);
                }
                actives++;
                passives--;
            }

            classpects[j] = new Classpect(tempClass, tempAspect);
            remainingAspects.remove(tempAspect);
            remainingClasses.remove(tempClass);
        }
        return classpects;
    }

    private Classpect.Class getRandomClass(ArrayList<Classpect.Class> classes) {
        Random random = new Random();
        return classes.get(random.nextInt(classes.size()));
    }

    private Classpect.Aspect getRandomAspect(ArrayList<Classpect.Aspect> aspects) {
        Random random = new Random();
        return aspects.get(random.nextInt(aspects.size()));
    }

    private Person.Moon [] getRandomMoonList(int i) {
        ArrayList<Person.Moon> moons = new ArrayList();
        for(int j = 0; j < i; j ++) {
            if(j%2 == 0) {
                moons.add(Person.Moon.PROSPIT);
            }
            else{
                moons.add(Person.Moon.DERSE);
            }
        }
        Collections.shuffle(moons);
        return moons.toArray(new Person.Moon[i]);
    }

}
