package email.client.gui.receive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.mail.Message;

import email.client.dao.DBConnection;

/**
 * 用来保存SimpleEmailReceiver.handlerReceive()返回的邮件数据
 * 
 * 能够帮助管理这些邮件数据
 * 
 * @author baikkp
 * 
 *         2014-2-26 下午11:01:52
 * 
 */
public class ReceivedEmailStore {

	private Message[] messages;

	/**
	 * 用接收到的Message[]数据进行创建
	 * 
	 * @param messages
	 *            接收到的Message
	 */
	public ReceivedEmailStore(Message[] messages) {
		this.messages = messages;
	}

	/**
	 * 将这些邮件数据存入到数据库中
	 */
	public void saveIntoDB() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("");
			
			for (Message message : messages) {
				System.out.println(message.hashCode());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 返回所有邮件主题
	 * 
	 * @return 所有邮件的主题
	 */
	public String[] getAllSubjects() {
		return new String[] { "1", "2", "33333", "444444", "33333", "444444",
				"33333", "444444" };
	}
	
}
