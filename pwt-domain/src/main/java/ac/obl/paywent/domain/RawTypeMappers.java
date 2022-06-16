package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface RawTypeMappers {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapRawTypeToString {
    }

    @MapRawTypeToString
    default String mapRawTypeToString(final RawType<?> rawType) {
        return rawType.get().toString();
    }

}
