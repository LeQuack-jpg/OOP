package test;

import view.CustomerManagementUI;

import javax.swing.*;

public class TestCustomerUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Customer UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 500);
            frame.setLocationRelativeTo(null);

            frame.setContentPane(new CustomerManagementUI()); // <-- Gọi panel quản lý khách hàng
            frame.setVisible(true);
        });
    }
}
