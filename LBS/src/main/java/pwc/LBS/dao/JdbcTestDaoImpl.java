package pwc.LBS.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pwc.LBS.model.Account;
@Repository
public class JdbcTestDaoImpl {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("************aa****************");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Account> getAccounts(){
		return this.jdbcTemplate.query("select name,sic_category__c from account", new RowMapper<Account>(){

			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Account acc = new Account();
				acc.setName(rs.getString("name"));
				acc.setSic_category__c(rs.getString("sic_category__c"));
				return acc;
			}
			
		});
	}
	public void  insertAccounts(){
		 //this.jdbcTemplate.update("insert in to account (name,sic_category__c)", "hello","helloworld");
		 this.jdbcTemplate.update("insert in to account (?,?)", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "hello");
				ps.setString(2, "WOCAONIMA");
				
			}});
	}
}
