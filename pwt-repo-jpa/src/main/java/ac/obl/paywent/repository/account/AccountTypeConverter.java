package ac.obl.paywent.repository.account;

import ac.obl.paywent.domain.AccountType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class AccountTypeConverter implements javax.persistence.AttributeConverter<AccountType, String> {
	@Override
	public String convertToDatabaseColumn(final AccountType accountType) {
		return accountType.name().toLowerCase();
	}

	@Override
	public AccountType convertToEntityAttribute(final String value) {
		return AccountType.valueOf(value.toUpperCase());
	}
}
