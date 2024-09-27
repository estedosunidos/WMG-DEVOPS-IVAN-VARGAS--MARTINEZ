package es.upm.miw.iwvg_devops.code;
import java.util.*;
import java.util.stream.Stream;
public class Search {

    // Método para obtener el stream de usuarios
    public Stream<User> findAll() {
        // Datos de prueba
        List<Fraction> fractions1 = List.of(new Fraction(0, 1), new Fraction(1, 1), new Fraction(2, 1));
        List<Fraction> fractions2 = List.of(new Fraction(2, 1), new Fraction(-1, 5), new Fraction(2, 4), new Fraction(4, 3));
        List<Fraction> fractions3 = List.of(new Fraction(1, 5), new Fraction(3, -6), new Fraction(1, 2), new Fraction(4, 4));
        List<Fraction> fractions4 = List.of(new Fraction(2, 2), new Fraction(4, 4));
        List<Fraction> fractions5 = List.of(new Fraction(0, 1), new Fraction(0, -2), new Fraction(0, 3));
        List<Fraction> fractions6 = List.of(new Fraction(0, 0), new Fraction(1, 0), new Fraction(1, 1));

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }


    // 0. Find the user's last name if it has any proper fraction
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getFamilyName);
    }
    // 1. Find the user ID if it has any proper fraction
    public Stream<String> findUserIdBySomeProperFraction() {
        return findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId);
    }

    // 2. Multiply user fractions by last name
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1, 1), Fraction::multiply);
    }
    // 3. Dividir las fracciones del usuario por ID
    public Fraction findFractionDivisionByUserId(String id) {
        return findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1, 1), Fraction::divide);
    }




}