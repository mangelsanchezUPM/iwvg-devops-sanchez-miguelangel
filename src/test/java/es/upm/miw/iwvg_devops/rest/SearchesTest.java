package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {
    private Searches search = new Searches();

    @Test
    void testFindHighestFraction() {
        assertEquals(new Fraction(1,0), search.findHighestFraction());
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("O.", "A.", "O.", "A."), search.findUserFamilyNameInitialByAnyProperFraction().collect(Collectors.toList()));
    }
}
