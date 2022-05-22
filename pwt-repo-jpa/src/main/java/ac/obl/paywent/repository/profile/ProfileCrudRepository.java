package ac.obl.paywent.repository.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileCrudRepository extends CrudRepository<ProfileEntity, UUID> {

}
