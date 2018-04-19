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
public class Classpect {

    public enum Class {
        SYLPH(ActPas.PASSIVE), MAID(ActPas.ACTIVE), KNIGHT(ActPas.PASSIVE), 
        PAGE(ActPas.ACTIVE), HEIR(ActPas.PASSIVE), WITCH(ActPas.ACTIVE), 
        SEER(ActPas.PASSIVE), MAGE(ActPas.ACTIVE), ROGUE(ActPas.PASSIVE), 
        THIEF(ActPas.ACTIVE), BARD(ActPas.PASSIVE), PRINCE(ActPas.ACTIVE);
        private final ActPas ap;
        private Class(ActPas ap) {
        this.ap = ap;
        }
        public ActPas getActPas() {
            return ap;
        }
    };

    public enum Aspect {
        TIME, SPACE, MIND, DOOM, RAGE, LIGHT, VOID, HOPE, LIFE, HEART, BREATH, BLOOD
    };

    public enum ActPas {
        ACTIVE, PASSIVE
    };

    public enum Type {
        UNDERSTANDING, CREATING, DESTROYING, RELOCATING, CHANGING, SERVING
    };
    private final Class c;
    private final Aspect a;
    private final ActPas mode;
    private final Type t;

    public Classpect(Class c, Aspect a) {
        this.c = c;
        this.a = a;
        this.mode = c.getActPas();
        this.t = makeType();
    }

    public Class getC() {
        return c;
    }

    public Aspect getA() {
        return a;
    }

    public ActPas getMode() {
        return mode;
    }

    public Type getType() {
        return t;
    }

    private Type makeType() {
        switch (c) {
            case SYLPH:
            case MAID:
                return Type.CREATING;
            case KNIGHT:
            case PAGE:
                return Type.SERVING;
            case HEIR:
            case WITCH:
                return Type.CHANGING;
            case SEER:
            case MAGE:
                return Type.UNDERSTANDING;
            case ROGUE:
            case THIEF:
                return Type.RELOCATING;
            case BARD:
            case PRINCE:
                return Type.DESTROYING;
            default:
                return null;
        }
    }
    
    @Override
    public String toString() {
        return c + " of " + a;
    }
}
