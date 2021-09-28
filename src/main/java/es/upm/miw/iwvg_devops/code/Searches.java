package es.upm.miw.iwvg_devops.code;

import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::initials);
    }

    public Fraction findFractionDivisionByUserId(String id) {
        Optional<Fraction> optionalFraction = new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce((fraction1, fraction2) -> {
                    fraction1.divide(fraction2);
                    return fraction1;
                });

        if (optionalFraction.isEmpty())
            throw new NotFoundException("Fraction division not found with User id " + id);

        return optionalFraction.get();
    }

    public Fraction findHighestFraction() {
        Optional<Fraction> optionalFraction = new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .max((fraction, fraction2) -> (int) (fraction.decimal() - fraction2.decimal()));

        if (optionalFraction.isEmpty())
            throw new NotFoundException("Fraction not found.");

        return optionalFraction.get();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }
}
