package myCertification.bank.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import myCertification.bank.dto.Account;

public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public Integer saveAccount(Account acc) {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jt).withTableName("accounts").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", acc.getUserId());
		parameters.put("account_name", acc.getName());
		parameters.put("date_of_birth", acc.getDateOfBirth());
		parameters.put("address", acc.getAddress());
		parameters.put("email", acc.getEmail());
		parameters.put("account_type", acc.getAccountType());
		
		int accSaved = insert.execute(parameters);
		
		return accSaved;
	}
/*
	public Integer updateAccount(Account acc) {
		String sql = "update accounts set aname='" + acc.getName() + "',dob=" + acc.getDateOfBirth() + "',address="
				+ acc.getAddress() + "',email=" + acc.getEmail() + "',type=" + acc.getAccountType() + " where id="
				+ acc.getId();
		Integer accUpdated = jt.update(sql);
		return accUpdated;
	}

	public Integer deleteAccountById(Long id) {
		String sql = "delete from accounts where id =" + id;
		Integer accDeleted = jt.update(sql);
		return accDeleted;
	}

	public Account findAccountById(Long id) {
		String sql = "select aname, dob, address, email, type from accounts where id=" + id;
		try {
			Account acc = jt.queryForObject(sql, new RowMapper<Account>() {

				public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
					String aname = rs.getString(2);
					Date dob = rs.getDate(3);
					String address = rs.getString(4);
					String email = rs.getString(5);
					String type = rs.getString(6);

					return new Account(aname, dob, address, email, type);
				}
			});
			return acc;
		} catch (Exception ex) {
			return null;
		}
	}

	public List<Account> findAllAccounts() {
		String sql = "select * from accounts";
		List<Account> accs = jt.query(sql, new ResultSetExtractor<List<Account>>() {

			public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Account> accounts = new ArrayList<Account>();
				while (rs.next()) {

					String aname = rs.getString(2);
					Date dob = rs.getDate(3);
					String address = rs.getString(4);
					String email = rs.getString(5);
					String type = rs.getString(6);

					Account acc = new Account(aname, dob, address, email, type);
					accounts.add(acc);
				}
				return accounts;
			}

		});
		return accs;
	}
	*/

}
