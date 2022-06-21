package ac.obl.paywent.profile;

import java.util.function.Predicate;

public interface Specification {
    default <T> void given(final Predicate<T> predicate, final T argument) {
        if (!predicate.test(argument)) {
            throw new IllegalStateException("Given condition is not met");
        }
    }

    default <T> void then(final Predicate<T> predicate, final T argument) {
        if (!predicate.test(argument)) {
            throw new IllegalStateException("Then condition is not met");
        }
    }
}
