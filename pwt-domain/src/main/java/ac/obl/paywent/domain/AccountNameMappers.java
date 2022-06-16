package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface AccountNameMappers {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapStringToAccountName {
    }

    @MapStringToAccountName
    default AccountName mapStringToAccountName(final String value) {
        return AccountName.of(value);
    }

}
