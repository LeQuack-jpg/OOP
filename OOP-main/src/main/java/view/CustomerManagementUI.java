package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomerManagementUI extends JFrame {
    private JTable customerTable;
    private DefaultTableModel tableModel;

    private JTextField txtCusID, txtCusName, txtAdress, txtPhone, txtIDNumber;
    private JTextField txtCusDateofbirth;
    private JRadioButton radMale, radFemale;
    private ButtonGroup genderGroup;

    private JButton btnAdd, btnDelete, btnEdit, btnSave, btnBack;

    private Color darkBlue = new Color(9, 45, 66);
    private Color redBtn = new Color(204, 0, 0);
    private Font defaultFont = new Font("Tahoma", Font.PLAIN, 14);

    public CustomerManagementUI() {
        setTitle("Customer Management");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(darkBlue);

        initComponents();
    }

    private void initComponents() {
        // ===== TABLE: Customer Info =====
        String[] columnNames = {"ID Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "CMND", "Giới Tính"};
        tableModel = new DefaultTableModel(columnNames, 0);
        customerTable = new JTable(tableModel);
        customerTable.setFont(defaultFont);
        customerTable.setRowHeight(25);

        JTableHeader header = customerTable.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
        header.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(customerTable);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.NORTH);

        // ===== FORM + BUTTONS =====
        JPanel formPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        formPanel.setBackground(darkBlue);
        formPanel.setBorder(new EmptyBorder(20, 30, 10, 30));

        txtCusID = new JTextField();
        txtCusName = new JTextField();
        txtAdress = new JTextField();
        txtPhone = new JTextField();
        txtIDNumber = new JTextField();
        txtCusDateofbirth = new JTextField();

        radMale = new JRadioButton("Nam");
        radFemale = new JRadioButton("Nữ");
        genderGroup = new ButtonGroup();
        genderGroup.add(radMale);
        genderGroup.add(radFemale);

        radMale.setBackground(darkBlue);
        radFemale.setBackground(darkBlue);
        radMale.setForeground(Color.WHITE);
        radFemale.setForeground(Color.WHITE);

        JLabel[] labels = {
                new JLabel("ID Khách Hàng"), new JLabel("Địa Chỉ"),
                new JLabel("Tên Khách Hàng"), new JLabel("Số Điện Thoại"),
                new JLabel("Ngày Sinh"), new JLabel("CMND"),
                new JLabel("Giới Tính")
        };
        for (JLabel lbl : labels) {
            lbl.setForeground(Color.WHITE);
            lbl.setFont(defaultFont);
        }

        formPanel.add(labels[0]);
        formPanel.add(txtCusID);
        formPanel.add(labels[1]);
        formPanel.add(txtAdress);

        formPanel.add(labels[2]);
        formPanel.add(txtCusName);
        formPanel.add(labels[3]);
        formPanel.add(txtPhone);

        formPanel.add(labels[4]);
        formPanel.add(txtCusDateofbirth);
        formPanel.add(labels[5]);
        formPanel.add(txtIDNumber);

        formPanel.add(labels[6]);
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(darkBlue);
        genderPanel.add(radMale);
        genderPanel.add(radFemale);
        formPanel.add(genderPanel);

        add(formPanel, BorderLayout.CENTER);

        // ===== BUTTONS =====
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(darkBlue);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 20, 10));

        btnAdd = createStyledButton("THÊM");
        btnDelete = createStyledButton("XÓA");
        btnEdit = createStyledButton("SỬA");
        btnSave = createStyledButton("LƯU");
        btnBack = createStyledButton("QUAY LẠI");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.SOUTH);

        // ===== MOCK ACTIONS =====
        btnAdd.addActionListener(e -> {
            String gender = radMale.isSelected() ? "Nam" : "Nữ";
            tableModel.addRow(new Object[]{
                    txtCusID.getText(),
                    txtCusName.getText(),
                    txtCusDateofbirth.getText(),
                    txtAdress.getText(),
                    txtPhone.getText(),
                    txtIDNumber.getText(),
                    gender
            });
            clearForm();
        });

        btnDelete.addActionListener(e -> {
            int row = customerTable.getSelectedRow();
            if (row >= 0) tableModel.removeRow(row);
        });

        btnEdit.addActionListener(e -> {
            int row = customerTable.getSelectedRow();
            if (row >= 0) {
                txtCusID.setText(tableModel.getValueAt(row, 0).toString());
                txtCusName.setText(tableModel.getValueAt(row, 1).toString());
                txtCusDateofbirth.setText(tableModel.getValueAt(row, 2).toString());
                txtAdress.setText(tableModel.getValueAt(row, 3).toString());
                txtPhone.setText(tableModel.getValueAt(row, 4).toString());
                txtIDNumber.setText(tableModel.getValueAt(row, 5).toString());

                String gender = tableModel.getValueAt(row, 6).toString();
                if (gender.equals("Nam")) radMale.setSelected(true);
                else radFemale.setSelected(true);
            }
        });

        btnBack.addActionListener(e -> clearForm());

        btnSave.addActionListener(e -> JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu."));
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn.setBackground(redBtn);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(100, 40));
        return btn;
    }

    private void clearForm() {
        txtCusID.setText("");
        txtCusName.setText("");
        txtAdress.setText("");
        txtPhone.setText("");
        txtIDNumber.setText("");
        txtCusDateofbirth.setText("");
        genderGroup.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerManagementUI().setVisible(true));
    }
}
