package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchesTest {
    private Searches search = new Searches();

    @Test
    void testFindHighestFraction() {
        assertEquals(new Fraction(1,0), search.findHighestFraction());
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("O.", "A.", "O.", "A."), search.findUserFamilyNameInitialByAnyProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        String userName = "Paula";
        assertEquals(List.of(1.0, 1.0, Double.NaN, Double.POSITIVE_INFINITY, 1.0), search.findDecimalFractionByUserName(userName).collect(Collectors.toList()));
        userName = "Antonio";
        assertEquals(List.of(0.0, -0.0, 0.0), search.findDecimalFractionByUserName(userName).collect(Collectors.toList()));
    }

    @Test
    void testFindFractionDivisionByUserId() {
        String userId = "3";
        assertEquals(new Fraction(-4,5), search.findFractionDivisionByUserId(userId));
        userId = "4";
        assertEquals(new Fraction(1,1), search.findFractionDivisionByUserId(userId));
    }

    @Test
    void testFindFractionDivisionByUserIdException() {
        String userId = "100";
        assertThrows(NotFoundException.class, () -> search.findFractionDivisionByUserId(userId));
    }
}
