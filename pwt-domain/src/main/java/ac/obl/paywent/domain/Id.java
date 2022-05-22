package ac.obl.paywent.domain;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.UUID;

public interface Id<T> {

    T getId();

    /**
     * String ID implementation of the ID.
     */
    @RequiredArgsConstructor
    abstract class UuidId implements Id<UUID> {
        protected final UUID id;

        @Override
        public UUID getId() {
            return id;
        }

        @Override
        public String toString() {
            return id.toString();
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final UuidId uuidId = (UuidId) o;
            return id.equals(uuidId.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
