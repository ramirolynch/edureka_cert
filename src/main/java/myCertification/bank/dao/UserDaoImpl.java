package myCertification.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import myCertification.bank.dto.User;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	public User findUserById(Long uno) {
		String sql = "select id, password from users_bank where id=" + uno;
		try {
			User use = jt.queryForObject(sql, new RowMapper<User>() {

				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					String userId = rs.getString(1);
					String pass = rs.getString(2);

					return new User(Long.parseLong(userId), pass);
				}
			});
			return use;
		} catch (Exception ex) {
			return null;
		}		
	}	    	
	    	
	     
}