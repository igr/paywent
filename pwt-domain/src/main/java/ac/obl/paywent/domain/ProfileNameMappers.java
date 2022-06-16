package ac.obl.paywent.domain;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ProfileNameMappers {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface MapStringToProfileName {
    }

    @MapStringToProfileName
    default ProfileName mapStringToProfileName(final String value) {
        return ProfileName.of(value);
    }

}
