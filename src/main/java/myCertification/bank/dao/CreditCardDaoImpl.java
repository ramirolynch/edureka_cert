package myCertification.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import myCertification.bank.dto.CreditCard;

public class CreditCardDaoImpl implements CreditCardDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public Integer authorizeCreditCard(CreditCard cc) {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jt).withTableName("credit_card").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("card_number", cc.getCardNumber());
		parameters.put("cvv", cc.getCvv());
		parameters.put("amount", cc.getAmount());
		
		int authorizationSaved = insert.execute(parameters);
		
		return authorizationSaved;
	}
	
	public CreditCard findCardByNumber(Long cc, Long cvv) {
		String sql = "select card_number, cvv from credit_card where card_number=" + cc + " AND cvv="+cvv;
		try {
			CreditCard credit_card = jt.queryForObject(sql, new RowMapper<CreditCard>() {

				public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
					Long cardNumber = rs.getLong(1);
					Long cvv = rs.getLong(2);
					return new CreditCard(cardNumber, cvv);
				}
			});
			return credit_card;
		} catch (Exception ex) {
			return null;
		}		
	}	    	
	    

}