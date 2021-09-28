package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Optional;
import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream()
                        .filter(i -> null != i)
                )
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isProper()))
                .map(User::initials);
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return Stream.empty();
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return null;
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce((fraction1, fraction2) -> { fraction1.divide(fraction2); return fraction1; } )
                .get();
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return null;
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return Stream.empty();
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return null;
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return Stream.empty();
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .max((fraction, fraction2) -> (int) (fraction.decimal() - fraction2.decimal())).
                get();
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return Stream.empty();
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return Stream.empty();
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return null;
    }
}
