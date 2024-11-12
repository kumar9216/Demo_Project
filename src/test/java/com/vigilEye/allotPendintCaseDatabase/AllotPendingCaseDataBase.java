package com.vigilEye.allotPendintCaseDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.utility.DateFormat;

public class AllotPendingCaseDataBase {

	public static String mmyyyy="102024";
	public static String userIdAT="AT@DIV211211";
	public static String databaseName="DVVNL_VIGILANCE_TEST";
	public static String consumerMasterDbName="Dvvnl_mri_data_test";
	public static String countOFpendingCase=null;
	public static String acId="9391330000";


	@Test
	public String toverifyCountAllotPendingCaseInDatabase() throws SQLException, ClassNotFoundException {
		//public void toverifyCountAllotPendingCaseInDatabase() throws SQLException, ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//Create Connection
		String url="jdbc:sqlserver://45.114.143.206;"+";encrypt=true;trustServerCertificate=true";
		String user="mantoo";

		String password="mantoo@123#";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(DISTINCT mt.Case_No) AS Pending_Case_Count\r\n"
				+ "FROM \r\n"
				+ "    "+databaseName+"..MARKING_TRANS mt\r\n"
				+ "LEFT JOIN \r\n"
				+ "    "+databaseName+"..Priority_Trans pt ON mt.Case_No = pt.Case_No\r\n"
				+ "LEFT JOIN \r\n"
				+ "    "+databaseName+"..Marking_Validation_Master mvm ON pt.Priority_Code = mvm.Priority_Code\r\n"
				+ "LEFT JOIN \r\n"
				+ "    "+consumerMasterDbName+"..CONSUMER_MASTER_"+mmyyyy+" CM ON CM.AC_ID=MT.AC_ID\r\n"
				+ "LEFT JOIN  \r\n"
				+ "     DVVNL_SAIADM_TEST..PVVNL_LOGIN PL ON PL.DIV_CD=CM.DIV\r\n"
				+ "WHERE mvm.Is_Enable = 'Y' AND CM.CONSUMER_STATUS IN('IN SERVICE','B') AND OPR_ID='"+userIdAT+"'\r\n"
				+ " AND mt.Case_No NOT IN (SELECT DISTINCT fvt.Case_No FROM DVVNL_VIGILANCE_TEST..FIELD_VIGILANCE_TRANS FVT) and pt.PRIORITY_CODE='1'");


		ResultSet n = ps.executeQuery();

		DecimalFormat f = new DecimalFormat("#.##");
		while(n.next())
		{ 
			countOFpendingCase = n.getString("Pending_Case_Count").trim();
			this. countOFpendingCase= countOFpendingCase;

		}

	return countOFpendingCase;
	//System.out.println(countOFpendingCase);
	}
	@Test
	public List<String> toverifyAllotPendingCaseDetailsInDatabase() throws SQLException, ClassNotFoundException {
		// public void toverifyAllotPendingCaseDetailsInDatabase() throws SQLException, ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//Create Connection
		String url="jdbc:sqlserver://45.114.143.206;"+";encrypt=true;trustServerCertificate=true";
		String user="mantoo";

		String password="mantoo@123#";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = con.prepareStatement(" Select cm.DIV_NAME,pt.CASE_NO,cm.AC_ID,cm.NAME,cm.ADDRESS,cm.CONTACT_DEMAND,pt.PRIORITY_CODE from "+consumerMasterDbName+"..CONSUMER_MASTER_102024 cm\r\n"
				+ "left join \r\n"
				+ " "+databaseName+"..MARKING_TRANS mt\r\n"
				+ "on cm.AC_ID=mt.AC_ID \r\n"
				+ "left join \r\n"
				+ ""+databaseName+"..PRIORITY_TRANS pt\r\n"
				+ "on\r\n"
				+ "mt.CASE_NO=pt.CASE_NO\r\n"
				+ "where cm.AC_ID='"+acId+"'\r\n"
				+ "");


		ResultSet n = ps.executeQuery();
		ArrayList<String> AllotpendingDetails=new ArrayList<>();

		DecimalFormat f = new DecimalFormat("#.##");
		while(n.next())
		{ 
			AllotpendingDetails.add(n.getString("DIV_NAME").trim());
			AllotpendingDetails.add(n.getString("CASE_NO").trim());
			AllotpendingDetails.add(n.getString("AC_ID").trim());
			AllotpendingDetails.add(n.getString("NAME").trim());
			AllotpendingDetails.add(n.getString("ADDRESS").trim());
			AllotpendingDetails.add(n.getString("CONTACT_DEMAND").trim());
			AllotpendingDetails.add(n.getString("PRIORITY_CODE").trim());

		}

		return AllotpendingDetails;
		//System.out.println(AllotpendingDetails);
	}
	@Test
	public List<String> toverifyConsumerDetailsInDatabase() throws SQLException, ClassNotFoundException {
		// public void toverifyConsumerDetailsInDatabase() throws SQLException, ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//Create Connection
		String url="jdbc:sqlserver://45.114.143.206;"+";encrypt=true;trustServerCertificate=true";
		String user="mantoo";

		String password="mantoo@123#";
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = con.prepareStatement("Select name,address,CONTACT_DEMAND,AC_ID,MOBILE_NO \r\n"
				+ "from DVVNL_MRI_DATA_TEST..consumer_master_102024 where ac_id='"+acId+"'");


		ResultSet n = ps.executeQuery();
		ArrayList<String> ConsumerDetails=new ArrayList<>();

		DecimalFormat f = new DecimalFormat("#.##");
		while(n.next())
		{ 
			ConsumerDetails.add(n.getString("name").trim());
			ConsumerDetails.add(n.getString("address").trim());
			ConsumerDetails.add(n.getString("CONTACT_DEMAND").trim());
			ConsumerDetails.add(n.getString("AC_ID").trim());
			ConsumerDetails.add(n.getString("MOBILE_NO").trim());

		}

		return ConsumerDetails;
		//System.out.println(ConsumerDetails);
	}
	@Test
	//public void toverifyMarkingDetailsInDatabase() throws SQLException, ClassNotFoundException {
	public List<String> toverifyMarkingDetailsInDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://45.114.143.206;" + ";encrypt=true;trustServerCertificate=true";
        String user = "mantoo";
        String password = "mantoo@123#";
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement("SELECT rmk, rmk_date, RMK_SOURCE, RMK_BY, PRIORITY_CODE FROM "
                + databaseName + "..marking_trans WHERE ac_id = '" + acId + "'");
        ResultSet rs = ps.executeQuery();
        DateFormat df = new DateFormat();
        ArrayList<String> markingDetails = new ArrayList<>();
        
        while (rs.next()) {
            markingDetails.add(rs.getString("rmk").trim());
            String rmkDateStr = rs.getString("rmk_date").trim();
            String formattedRmkDate = df.date_dd_mm_yyyy_Format(rmkDateStr);
            markingDetails.add(formattedRmkDate);
            markingDetails.add(rs.getString("RMK_SOURCE").trim());
            markingDetails.add(rs.getString("RMK_BY").trim());
            markingDetails.add(rs.getString("PRIORITY_CODE").trim());
        }
         return markingDetails;
         // System.out.println(markingDetails);
    }
}