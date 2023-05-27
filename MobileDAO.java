package Mobile1;

import java.sql.*;
import java.util.ArrayList;

public class MobileDAO {
    static Connection con = null;
    ArrayList<MobileDTO> list=new ArrayList<>();

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "19991001!!Pp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addMobile(MobileDTO m) {
        PreparedStatement pstmt=null;
        int count=0;
        String query = "insert into mobile_info values(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,m.getModelNo());
            pstmt.setString(2,m.getModelName());
            pstmt.setString(3,m.getCompany());
            pstmt.setInt(4,m.getRam());
            pstmt.setInt(5,m.getCamera());
            pstmt.setDouble(6,m.getPrice());
            count=pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public ArrayList<MobileDTO> searchMobileByCompany(String name) {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select model_name from mobile_info where company=?";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,name);
            rs=pstmt.executeQuery();
            while (rs.next()){
                String modelName=rs.getString(1);

                MobileDTO d2=new MobileDTO();
                d2.setModelName(modelName);
                list.add(d2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;


    }

    public ArrayList<MobileDTO> searchMobileByPrice(double startPrice, double endPrice) {
        Statement stmt=null;
        ResultSet rs=null;


        String query="select * from mobile_info where price between "+startPrice+" and "+endPrice;

        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName=rs.getString(2);
                String compnay=rs.getString(3);
                int ram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);

                MobileDTO d3=new MobileDTO();
                d3.setModelNo(modelNo);
                d3.setModelName(modelName);
                d3.setCompany(compnay);
                d3.setRam(ram);
                d3.setCamera(camera);
                d3.setPrice(price);
                list.add(d3);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;


    }

    public ArrayList<MobileDTO> searchMobileByRam(int ram) {
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from mobile_info where ram="+ram;

        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName=rs.getString(2);
                String compnay=rs.getString(3);
                int dbram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);

                MobileDTO d3=new MobileDTO();
                d3.setModelNo(modelNo);
                d3.setModelName(modelName);
                d3.setCompany(compnay);
                d3.setRam(dbram);
                d3.setCamera(camera);
                d3.setPrice(price);
                list.add(d3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<MobileDTO> searchMobileByCamera(double startMP, double endMP) {
        Statement stmt=null;
        ResultSet rs=null;
        String query="select * from mobile_info where camera between "+startMP+" and "+endMP;
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName=rs.getString(2);
                String compnay=rs.getString(3);
                int ram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);

                MobileDTO d3=new MobileDTO();
                d3.setModelNo(modelNo);
                d3.setModelName(modelName);
                d3.setCompany(compnay);
                d3.setRam(ram);
                d3.setCamera(camera);
                d3.setPrice(price);
                list.add(d3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int deleteMobile(int modelNo) {
        PreparedStatement pstmt=null;
        int count=0;
        String query="delete from mobile_info where model_no=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,modelNo);
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}