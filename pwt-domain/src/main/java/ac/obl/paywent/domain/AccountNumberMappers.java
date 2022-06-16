package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface AccountNumberMappers {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapStringToAccountNumber {
    }

    @MapStringToAccountNumber
    default AccountNumber mapStringToAccountNumber(final String value) {
        return AccountNumber.of(value);
    }

}
