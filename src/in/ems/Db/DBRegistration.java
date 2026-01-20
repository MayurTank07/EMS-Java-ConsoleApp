package in.ems.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.ems.auth.Registration;

public class DBRegistration {

    public static int insertReg(Registration r) {

        int status = 0;

        try {
            Connection conn = DbConnection.getConnection();

            String sql = "INSERT INTO registration(name, username, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, r.getName());
            ps.setString(2, r.getUsername());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getPassword());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
