package jpastart.reserve.application;

import jpastart.reserve.model.UserDomain;
import jpastart.util.DBTestResource;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.fail;

public class WithdrawServiceTest {

	@Rule
	public DBTestResource resource = new DBTestResource();
	private WithdrawService withdrawService = new WithdrawService();

	@Test
	public void userExists_thenWithdraw() throws Exception {
		withdrawService.withdraw("madvirus@madvirus.net");
		UserDomain.assertUserNotExists("madvirus@madvirus.net");
	}

	@Test
	public void noUser_thenException() throws Exception {
		try {
			withdrawService.withdraw("nouser@nouser.net");
			fail("익셉션 발생");
		} catch (UserNotFoundException ex) {

		}
	}

}
