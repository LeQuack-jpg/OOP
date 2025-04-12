package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CheckoutPanelFull extends JPanel {

    public CheckoutPanelFull() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // Header
        JLabel titleLabel = new JLabel("Phòng 110  |  Giá phòng: 450,000", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.RED);
        add(titleLabel, BorderLayout.NORTH);

        // Center content
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(createTopInfoPanel(), BorderLayout.NORTH);
        centerPanel.add(createDetailPanel(), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Right - Payment section
        add(createPaymentPanel(), BorderLayout.EAST);
    }

    private JPanel createTopInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

        panel.add(createBookingDetailPanel());
        panel.add(createInvoiceHeaderPanel());

        return panel;
    }

    private JPanel createBookingDetailPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Chi Tiết Đặt Phòng"));

        panel.add(new JLabel("Khách hàng:"));
        panel.add(new JTextField("Nguyễn Văn A"));
        panel.add(new JLabel("Loại thuê:"));
        panel.add(new JComboBox<>(new String[]{"Theo ngày", "Theo giờ"}));

        panel.add(new JLabel("Nhân viên:"));
        panel.add(new JTextField("Lê Tuấn Anh"));
        panel.add(new JLabel("Số người ở:"));
        panel.add(new JTextField("2"));

        panel.add(new JLabel("Mã HĐ:"));
        panel.add(new JTextField("HD017"));
        panel.add(new JLabel("Tên phòng:"));
        panel.add(new JTextField("Phòng 110"));

        return panel;
    }

    private JPanel createInvoiceHeaderPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Hóa Đơn Chi Tiết"));

        panel.add(new JLabel("Mã HĐ"));
        panel.add(new JLabel("Phòng"));
        panel.add(new JLabel("Tên khách hàng"));

        panel.add(new JTextField("HD017"));
        panel.add(new JTextField("Phòng 110"));
        panel.add(new JTextField("Nguyễn Văn A"));

        return panel;
    }

    private JPanel createDetailPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.add(createServicePanel());
        panel.add(createEquipmentPanel());
        return panel;
    }

    private JPanel createServicePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Chi Tiết Dịch Vụ"));

        JTable table = new JTable(new DefaultTableModel(
            new Object[][]{
                {"DV001", "Giặt ủi", 100000, 1},
                {"DV002", "Dịch vụ bar", 250000, 2},
                {"DV003", "Fitness", 350000, 1},
            },
            new Object[]{"Mã DV", "Tên DV", "Giá", "Số lượng"}
        ));

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createEquipmentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Chi Tiết Thiết Bị"));

        JTable table = new JTable(new DefaultTableModel(
            new Object[][]{
                {"TB001", "Tivi", 500000, 1},
                {"TB002", "Bàn ủi", 1000000, 1},
            },
            new Object[]{"Mã TB", "Tên TB", "Giá", "Số lượng"}
        ));

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

   private JPanel createPaymentPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createTitledBorder("Thanh Toán"));

    // Section 1: Phụ thu check-in & check-out
    JPanel surchargePanel = new JPanel(new GridLayout(5, 2, 5, 5));
    surchargePanel.setBorder(BorderFactory.createTitledBorder("Phụ thu check-in & check-out"));

    surchargePanel.add(new JLabel("Tiền đặt cọc:"));
    JTextField depositField = new JTextField("1012500");
    surchargePanel.add(depositField);

    surchargePanel.add(new JLabel("Phụ thu check-in:"));
    JTextField earlyCheckInField = new JTextField("0");
    surchargePanel.add(earlyCheckInField);

    surchargePanel.add(new JLabel("Phụ thu check-out:"));
    JTextField lateCheckoutField = new JTextField("225000");
    surchargePanel.add(lateCheckoutField);

    surchargePanel.add(new JLabel("Tổng phụ thu:"));
    JTextField surchargeTotalField = new JTextField("225000");
    surchargeTotalField.setEditable(false);
    surchargePanel.add(surchargeTotalField);

    surchargePanel.add(new JLabel("Tạm tính:"));
    JTextField subtotalField = new JTextField("1575000");
    subtotalField.setEditable(false);
    surchargePanel.add(subtotalField);

    // Section 2: Tổng tiền dịch vụ và thiết bị
    JPanel serviceDevicePanel = new JPanel(new GridLayout(2, 2, 5, 5));
    serviceDevicePanel.setBorder(BorderFactory.createTitledBorder("Tổng tiền dịch vụ + thiết bị"));

    serviceDevicePanel.add(new JLabel("Dịch vụ:"));
    JTextField serviceTotalField = new JTextField("600000");
    serviceTotalField.setEditable(false);
    serviceDevicePanel.add(serviceTotalField);

    serviceDevicePanel.add(new JLabel("Thiết bị:"));
    JTextField deviceTotalField = new JTextField("150000");
    deviceTotalField.setEditable(false);
    serviceDevicePanel.add(deviceTotalField);

    // Section 3: Tổng tiền thanh toán
    JPanel grandTotalPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    JLabel totalLabel = new JLabel("Tổng tiền thanh toán:");
    totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
    JTextField totalField = new JTextField("1,177,500 VNĐ");
    totalField.setForeground(Color.RED);
    totalField.setFont(new Font("Arial", Font.BOLD, 16));
    totalField.setHorizontalAlignment(JTextField.CENTER);
    totalField.setEditable(false);
    grandTotalPanel.add(totalLabel);
    grandTotalPanel.add(totalField);

    // Section 4: Tiền khách đưa & tiền thối lại
    JPanel customerPayPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    customerPayPanel.add(new JLabel("Tiền khách đưa:"));
    JTextField cashGivenField = new JTextField("2000000");
    customerPayPanel.add(cashGivenField);

    customerPayPanel.add(new JLabel("Tiền thối lại khách:"));
    JTextField refundField = new JTextField("822500 VNĐ");
    refundField.setForeground(Color.BLUE);
    refundField.setFont(new Font("Arial", Font.BOLD, 14));
    refundField.setEditable(false);
    customerPayPanel.add(refundField);

    // Add all sections to main panel
    panel.add(surchargePanel);
    panel.add(serviceDevicePanel);
    panel.add(Box.createVerticalStrut(10));
    panel.add(grandTotalPanel);
    panel.add(Box.createVerticalStrut(10));
    panel.add(customerPayPanel);

    return panel;
}


    private JPanel createLabeledField(String label, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(label);
        JTextField txt = new JTextField(value);
        txt.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(lbl, BorderLayout.WEST);
        panel.add(txt, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Thanh Toán - Check Out");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CheckoutPanelFull());
        frame.setSize(1300, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
