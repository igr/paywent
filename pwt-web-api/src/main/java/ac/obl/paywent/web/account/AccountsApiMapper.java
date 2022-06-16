package ac.obl.paywent.web.account;

import ac.obl.paywent.map.PwtMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = PwtMapperConfig.class)
public interface AccountsApiMapper extends AccountResponseMapper {

}
