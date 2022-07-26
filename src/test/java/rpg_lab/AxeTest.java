package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int ATTACK = 13;

    private static final int DURABILITY = 42;

    private static final int HEALTH = 100;

    private static final int EXPERIENCE = 200;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void setUp(){

        dummy = new Dummy(HEALTH, EXPERIENCE);
        axe = new Axe(ATTACK, DURABILITY);

    }


    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated() {

        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());


    }

    @Test
    public void test_AxeLosesDurability_AfterAttacking() {

        axe.attack(dummy);

        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void test_AxeAttack_WhenBroken_Fails() {
        int durability = 0;

        Axe axe = new Axe(ATTACK, durability);

        //Assert the axe is broken
        assertEquals(0, axe.getDurabilityPoints());

        axe.attack(dummy);



    }



}