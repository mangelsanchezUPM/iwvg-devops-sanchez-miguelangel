package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        this.user = new User("0", "Name", "FName", new ArrayList<>());
    }

    @Test
    void testGetId() { assertEquals("0", this.user.getId()); }

    @Test
    void testGetName() {
        assertEquals("Name", this.user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("FName", this.user.getFamilyName());
    }

    @Test
    void testSetName() {
        String newName = "newName";
        this.user.setName(newName);
        assertEquals("newName", this.user.getName());
    }

    @Test
    void testSetFamilyName() {
        String newFName = "newFName";
        this.user.setFamilyName(newFName);
        assertEquals("newFName", this.user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(new ArrayList<Fraction>(), this.user.getFractions());
    }

    @Test
    void testSetFractions() {
        ArrayList<Fraction> fractionList = new ArrayList<>();
        fractionList.add(new Fraction(2,3));
        this.user.setFractions(fractionList);
        assertEquals(fractionList, this.user.getFractions());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction(2,3);
        ArrayList<Fraction> fractions = new ArrayList<>() {{
            add(fraction);
        }};
        this.user.addFraction(fraction);
        assertEquals(fractions, this.user.getFractions());
    }

    @Test
    void testFullName() {
        assertEquals("Name FName", this.user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("N.", this.user.initials());
    }
}
