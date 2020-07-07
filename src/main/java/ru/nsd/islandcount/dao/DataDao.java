package ru.nsd.islandcount.dao;

import ru.nsd.islandcount.ConnectionFactory;
import ru.nsd.islandcount.Data;
import ru.nsd.islandcount.dao.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao implements Dao<Data> {

    public List<Data> findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        List<Data> dataList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);
            while (rs.next()) {
                Data data = new Data();
                data.setId(rs.getInt("id"));
                data.setN(rs.getInt("n"));
                data.setMatrix(rs.getString("matrix"));
                data.setResult(rs.getInt("result"));
                dataList.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Data> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        List<Data> dataList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                Data data = new Data();
                data.setId(rs.getInt("id"));
                data.setN(rs.getInt("n"));
                data.setMatrix(rs.getString("matrix"));
                data.setResult(rs.getInt("result"));
                dataList.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insert(Data data) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TEST VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, data.getId());
            ps.setInt(2, data.getN());
            ps.setInt(3, data.getM());
            ps.setString(4, data.getMatrix());
            ps.setInt(5, data.getResult());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Data data) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET id=?,n=?, m=?, matrix=?, result=? WHERE id=?");
            ps.setInt(1, data.getId());
            ps.setInt(2, data.getN());
            ps.setInt(3, data.getM());
            ps.setString(4, data.getMatrix());
            ps.setInt(5, data.getResult());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
