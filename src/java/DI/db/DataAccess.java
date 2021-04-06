/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DI.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import DI.models.BankTransaction;

/**
 *
 * @author samsung
 */
public class DataAccess 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String username = "drug";
    String password = "123";

    Connection conn = null;
    private Object java;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    public int createAccount(String firstName, String lastName, String email, String username, 
            String password)
    {
        try
        {
            String insertCommand = "insert into manager values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, username);
            stmt.setString(5, password);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    
   
    public boolean existUser(String username,String passkey)
    {
        try
        {
            String query = "select * from manager where username = ? and passkey = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, passkey);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
               
        
    }
    
    public String CurSeq(){
        try
        {
            String queryCommand = "select drug_seq.currval from purchasequantity";
            PreparedStatement querystmt = conn.prepareStatement(queryCommand);
            ResultSet rs = querystmt.executeQuery();
            if(rs.next())
            {
               String curseq = rs.getString("currval");
               return curseq;
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
            
    
    }
    
    public String CurSeqShip(){
        try
        {
            String queryCommand = "select drug_seq.currval from shipmentquantity";
            PreparedStatement querystmt = conn.prepareStatement(queryCommand);
            ResultSet rs = querystmt.executeQuery();
            if(rs.next())
            {
               String curseq = rs.getString("currval");
               return curseq;
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
            
    
    }
    
    public List<String> getClient()
    {
        try
        {
            String insertCommand = "select *  from client";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            List <String> client = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String clientID = rs.getString("clientID");
                String due = rs.getString("due");
                String address = rs.getString("address");
                String phoneNO = rs.getString("phoneNO");
                String total = firstName+ "   " + lastName + "   "+clientID+"   "+due+ "    "+address+"    "+phoneNO+ "<br/>";
                client.add(total);
            }
            return client;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getWorker()
    {
        try
        {
            String insertCommand = "select *  from worker";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            List <String> worker = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String workerID = rs.getString("workerID");
                String hireDate = rs.getString("hireDate");
                String salary = rs.getString("salary");
                String address = rs.getString("address");
                String phoneNO = rs.getString("phoneNO");
                String total = firstName+ "   " + lastName + "   "+workerID+"   "+hireDate+ "    "+salary+"   "+address+"    "+phoneNO+ "<br/>";
                worker.add(total);
            }
            return worker;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
     public int editMedicineInfo(String medicineName, String retailedPrice)
    {
        try
        {
            String insertCommand = "update medicine set retailedprice=? where medicinename=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, retailedPrice);
            stmt.setString(2, medicineName);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
     
    public List<String> getPurchaseCart(String invoiceNO)
    {
        try
        {
            String insertCommand = "select * from purchasequantity where invoiceNO = ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, invoiceNO);
            List <String> medicine = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String batchNO = rs.getString("batchNO");
                String medicineID = rs.getString("medicineID");
                String quantity = rs.getString("quantity");
                String total = batchNO+ "   " + medicineID + "   "+quantity + "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getShipmentCart(String orderNO)
    {
        try
        {
            String insertCommand = "select * from shipmentquantity where orderNO = ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, orderNO);
            List <String> medicine = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            System.out.println("adjkfhdfjhgjkhdhf");
            while(rs.next()){
                String batchNO = rs.getString("batchNO");
                String medicineID = rs.getString("medicineID");
                String quantity = rs.getString("quantity");
                String purchasedPrice = rs.getString("purchasedPrice");
                String expiryDate = rs.getString("expiryDate");
                String total = batchNO+ "   " + medicineID +"    "+purchasedPrice+ "   "+quantity+ "    "+expiryDate+ "<br/>";
                medicine.add(total);
                System.out.println(total+"akhdhf");
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getSearchByMedicineName(String medicineName)
    {
        try
        {
            String insertCommand = "select *  from Medicine where medicineName= ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineName);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String medicineID = rs.getString("medicineID");
                String genericName = rs.getString("genericName");
                String companyID = rs.getString("companyID");
                String retailedPrice = rs.getString("retailedPrice");
                String status = rs.getString("status");
                String total = medicineID+ "   " + medicineName + "   "+genericName+"   "+companyID+ "    "+retailedPrice+"   "+status+ "<br/>";
                medicine.add(total);
                System.out.println("Fuck twice"+total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getSearchByGenericName(String genericName)
    {
        try
        {
            String insertCommand = "select *  from Medicine where genericName= ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, genericName);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String medicineID = rs.getString("medicineID");
                String medicineName = rs.getString("medicineName");
                String companyID = rs.getString("companyID");
                String retailedPrice = rs.getString("retailedPrice");
                String status = rs.getString("status");
                String total = medicineID+ "   " + medicineName + "   "+genericName+"   "+companyID+ "    "+retailedPrice+"   "+status+ "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getSearchByCompanyName(String companyName)
    {
        try
        {
            String insertCommand = "select *  from Medicine where companyid= (select companyID from company where companyName=? ) ";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, companyName);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String medicineID = rs.getString("medicineID");
                String medicineName = rs.getString("medicineName");
                String genericName = rs.getString("genericName");
                String retailedPrice = rs.getString("retailedPrice");
                String status = rs.getString("status");
                String total = medicineID+ "   " + medicineName + "   "+genericName+"   "+companyName+ "    "+retailedPrice+"   "+status+ "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getInventory()
    {
        try
        {
            String insertCommand = "select *  from inventory ";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String batchNO = rs.getString("batchNO");
                String medicineID = rs.getString("medicineID");
                String quantity = rs.getString("quantity");
                String expiryDate = rs.getString("expiryDate");
                String total = batchNO+ "   " + medicineID  + "   "+quantity +"   "+expiryDate+ "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    
    public List<String> getInventoryByGenericName(String genericName)
    {
        try
        {
            String insertCommand = "select * from inventory where MEDICINEID in (select medicineid from medicine where genericname= ?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, genericName);
            List <String> medicine = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String batchNO = rs.getString("batchNO");
                String medicineID = rs.getString("medicineID");
                String quantity = rs.getString("quantity");
                String expiryDate = rs.getString("expiryDate");
                String total = batchNO+ "   " + medicineID + "   "+quantity+ "    "+expiryDate+ "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getInventoryByMedicineName(String medicineName)
    {
        try
        {
            String insertCommand = "select * from inventory where MEDICINEID in (select medicineid from medicine where medicinename= ?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineName);
            List <String> medicine = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String batchNO = rs.getString("batchNO");
                String medicineID = rs.getString("medicineID");
                String quantity = rs.getString("quantity");
                String expiryDate = rs.getString("expiryDate");
                String total = batchNO+ "   " + medicineID + "   "+quantity+ "    "+expiryDate+ "<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    
    public List<String> getCompanyDue(String companyName)
    {
        try
        {
            String insertCommand = "select due  from company where companyName= ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, companyName);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String due = rs.getString("due");
                String total = "Company : " + companyName + "   "+"Due : "+due+"<br/>";
                medicine.add(total);
                //System.out.println("Fuck twice"+total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getClientDue(String clientID)
    {
        try
        {
            String insertCommand = "select due  from client where clientID= ?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, clientID);
            List <String> medicine = new ArrayList<>();
            //System.out.println(insertCommand+" medicine="+medicineName +" rs =");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String due = rs.getString("due");
                String total = "Client ID : " + clientID + "   "+"Due : "+due+"<br/>";
                medicine.add(total);
            }
            return medicine;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<String> getCompany()
    {
        try
        {
            String insertCommand = "select *  from company";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            List <String> worker = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String companyName = rs.getString("companyName");
                String companyID = rs.getString("companyID");
                String address = rs.getString("address");
                String country = rs.getString("country");
                String email = rs.getString("email");
                String due = rs.getString("due");
                String phoneNO = rs.getString("phoneNO");
                String total = companyName+ "   " + companyID + "   "+address+"   "+country+ "    "+email+"   "+due+"    "+phoneNO+ "<br/>";
                worker.add(total);
            }
            return worker;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        } 
    }
    
    public int deleteClientById(String clientID)
    {
        try
        {
            String insertCommand = "DELETE FROM client WHERE CLIENTID=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, clientID);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int deleteClientByName(String clientName)
    {
        try
        {
            String insertCommand = "DELETE FROM client WHERE FIRSTNAME=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, clientName);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int deleteMedicineByCompany(String companyName)
    {
        try
        {
            String insertCommand = "DELETE FROM medicine WHERE companyID = (Select companyID from company where companyName=?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, companyName);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int deleteMedicineByGenericName(String genericName)
    {
        try
        {
            String insertCommand = "DELETE FROM medicine WHERE genericName=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, genericName);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int deleteMedicineById(String medicineID)
    {
        try
        {
            String insertCommand = "DELETE FROM medicine WHERE medicineID=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineID);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int deleteMedicineByName(String medicineName)
    {
        try
        {
            String insertCommand = "DELETE FROM medicine WHERE medicineNAME=?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineName);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    
    public int AddWorker(String firstName, String lastName, String hiredate, String salary, String address, String phoneno)
    {
        try
        {
            String insertCommand = "insert into worker values(?,?,WORKER_ID_SEQ.nextval,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, hiredate);
            stmt.setString(4, salary);
            stmt.setString(5, address);
            stmt.setString(6, phoneno);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    
    
    
    public int AddClient(String firstName, String lastName, String due, String address, String phoneno)
    {
        try
        {
            String insertCommand = "insert into client values(?,?,CLIENT_ID_SEQ.nextval,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, due);
            stmt.setString(4, address);
            stmt.setString(5, phoneno);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    
    public int AddCompany(String companyname, String address, String country, String email, String due, String phoneno)
    {
        try
        {
            String insertCommand = "insert into company values(?,COMPANY_ID_SEQ.nextval,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, companyname);
            stmt.setString(2, address);
            stmt.setString(3, country);
            stmt.setString(4, email);
            stmt.setString(5, due);
            stmt.setString(6, phoneno);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int AddMedicine(String medicineName, String genericName, String companyID, String retailedPrice, String status)
    {
        try
        {
            String insertCommand = "insert into medicine values(MEDICINE_ID_SEQ.nextval,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineName);
            stmt.setString(2, genericName);
            stmt.setString(3, companyID);
            stmt.setString(4, retailedPrice);
            stmt.setString(5, status);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
      
    
    public int AddItem(String batchNo,String medicineID,String quantity)
    {
        try
        {
            String insertCommand = "insert into purchasequantity values(?,?,drug_seq.nextval,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, batchNo);
            stmt.setString(2, medicineID);
            stmt.setString(3, quantity);
            int count = stmt.executeUpdate();
            
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int AddMoreItem(String batchNo,String medicineID,String invoiceNO,String quantity)
    {
        try
        {
            String insertCommand = "insert into purchasequantity values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, batchNo);
            stmt.setString(2, medicineID);
            stmt.setString(3, invoiceNO);
            stmt.setString(4, quantity);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    public int AddInvoice(String invoiceNO,String clientID,String paidAmount,String discount,String workerID)
    {
        try
        {
            String insertCommand = "insert into purchase values(?,SYSDATE,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, invoiceNO);
            stmt.setString(2, clientID);
            stmt.setString(3, paidAmount);
            stmt.setString(4, discount);
            stmt.setString(5, workerID);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int AddShipItem(String medicineID,String batchNo,String quantity, String purchasedPrice,String expiryDate)
    {
        try
        {
            String insertCommand = "insert into shipmentquantity values(drug_seq.nextval,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, medicineID);
            stmt.setString(2, batchNo);
            stmt.setString(3, quantity);
            stmt.setString(4, purchasedPrice);
            stmt.setString(5, expiryDate);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int AddMoreShipItem(String invoiceNO,String medicineID,String batchNo,String quantity, String purchasedPrice,String expiryDate)
    {
        try
        {
            String insertCommand = "insert into shipmentquantity values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, invoiceNO);
            stmt.setString(2, medicineID);
            stmt.setString(3, batchNo);
            stmt.setString(4, quantity);
            stmt.setString(5, purchasedPrice);
            stmt.setString(6, expiryDate);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    
    public int AddShipInvoice(String invoiceNO,String companyID,String paidAmount,String workerID)
    {
        try
        {
            String insertCommand = "insert into shipment values(?,?,SYSDATE,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, invoiceNO);
            stmt.setString(2, companyID);
            stmt.setString(3, paidAmount);
            stmt.setString(4, workerID);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        } 
    }
    /*public ArrayList<BankTransaction> getTransactions(String bankAccountNo)
    {
        ArrayList<BankTransaction> transactions = new ArrayList<BankTransaction>();
        
        String selectStatement = "select accountno, amount,"
                + "to_char(datetime,'DD/MM/YY hh:mi') dt from banktransaction"
                + " where accountno = ? order by datetime asc";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, bankAccountNo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String accountno = rs.getString("accountno");
                double amount = rs.getDouble("amount");
                String datetime = rs.getString("dt");
                BankTransaction trans = new BankTransaction(accountno, amount, datetime);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return transactions;

    }
    public boolean processTransaction(String bankAccountNo, double amount)
    {
        String sql = "{ call processTransaction(?,?) }";
        try
        {
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,bankAccountNo);
            statement.setDouble(2,amount);
            statement.execute();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }     
    }*/
/*
//Call function sample:
    
    String sql = "{ ? = call FUNCT_PERSON(?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/
    
 /*
    String sql = "{ call PROC_PERSON(?,?,?) }";
    CallableStatement statement = connection.prepareCall(sql);
    statement.setString(2,username);
    statement.setString(3,password);
    statement.registerOutParameter(1, java.sql.Types.INTEGER);  

    statement.execute();   
    //this is the main line
    long id = statement.getLong(1);
    if (id > 0) {
        //proceed to another page
    } else {
        //Go back to the login page
    }*/ 

    
}
