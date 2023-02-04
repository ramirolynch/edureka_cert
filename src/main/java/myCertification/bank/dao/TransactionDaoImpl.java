package myCertification.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import myCertification.bank.dto.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public Integer saveCredit(Transaction tx) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jt).withTableName("transactions").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", tx.getUserId());
		parameters.put("date_tx", tx.getDateTx());
		parameters.put("description", tx.getDescription());
		parameters.put("amount", tx.getAmount());
		parameters.put("account_to", tx.getAccountFrom());
		int txSaved = insert.execute(parameters);

		return txSaved;
	}

	public Integer saveDebit(Transaction tx) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jt).withTableName("transactions").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", tx.getUserId());
		parameters.put("date_tx", tx.getDateTx());
		parameters.put("description", tx.getDescription());
		parameters.put("amount", tx.getAmount());
		parameters.put("account_from", tx.getAccountFrom());

		int txSaved = insert.execute(parameters);

		return txSaved;
	}

	public List<Transaction> findAllTransactionsByUserId(Long user_id) {

		String sql = "select tx.date_tx, tx.description, tx.amount, tx.account_to, tx.account_from from transactions as tx where user_id="
				+ user_id;

		List<Transaction> txs = jt.query(sql, new ResultSetExtractor<List<Transaction>>() {
			public List<Transaction> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Transaction> tx = new ArrayList<Transaction>();
				while (rs.next()) {
					
					Date date_tx = rs.getDate(1);
					String desc = rs.getString(2);
					Long amt = rs.getLong(3);
					Long acc_to = rs.getLong(4);
					Long acc_from = rs.getLong(5);
					Transaction transaction = new Transaction(date_tx, desc, amt, acc_to, acc_from);
					tx.add(transaction);
				}
				return tx;
			}
		});
		return txs;
	}

}